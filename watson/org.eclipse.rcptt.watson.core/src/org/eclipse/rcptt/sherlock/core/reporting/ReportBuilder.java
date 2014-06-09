/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.sherlock.core.reporting;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingCategory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingData;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportBuilderStore;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;

/**
 * Build a complex report.
 */
public class ReportBuilder implements IReportBuilder {
	private final Report report;
	private NodeBuilder currentNode;
	
	//Provides synchronized access to report nodes
	private class NodeBuilder implements INodeBuilder {
		private final Node node;
		private NodeBuilder parent;
		private NodeBuilder(NodeBuilder parent, Node node){
			this.parent = parent;
			this.node = node;
		}
		/**
		 * Will add new node to current one and go one level down.
		 */
		@Override
		public INodeBuilder beginTask(String name) {
			Node child = ReportFactory.eINSTANCE.createNode();
			child.setName(name);
			child.setStartTime(getTime());
			synchronized (report) {
				node.getChildren().add(child);
			}
			return new NodeBuilder(this, child);
		}
		
		/**
		 * Will go one level up.
		 */
		@Override
		public void endTask() {
			synchronized (report) {
				node.setEndTime(getTime());
				if (parent != null) {
					currentNode = parent;
				}
			}
		}
		
		@Override
		public void createEvent(Event event) {
			synchronized (report) {
				Event copy = EcoreUtil.copy(event);
				copy.setTime(getTime());
				node.getEvents().add(copy);
			}
		}
		
		
		/*
		 * Add or append existing log entry into current node.
		 */
		@Override
		public void appendLog(LoggingCategory category, String text) {
			String log_key = getLogCategoryKey(category);
			synchronized (report) {
				EMap<String, EObject> properties = node.getProperties();
				LoggingData data = (LoggingData) properties.get(log_key);
				if (data == null)
					properties.put(log_key, data = ReportFactory.eINSTANCE.createLoggingData());
				StringBuilder sb = new StringBuilder(data.getText());
				sb.append(text);
				sb.append("\n");
				data.setText(sb.toString());
			}
		}
		
		@Override
		public void setProperty(String key, EObject value) {
			EObject copy = EcoreUtil.copy(value);
			synchronized (report) {
				if (node.getProperties().containsKey(key))
					throw new IllegalStateException("Property " + key+ " is already set for node" + node.getName());
				node.getProperties().put(key, copy);
			}
		}

		
		@Override
		public void addSnapshot(Snaphot snapshot) {
			Snaphot copy = EcoreUtil.copy(snapshot);
			copy.setTime(getTime());
			synchronized (report) {
				node.getSnapshots().add(copy);
			}
		}
		
		@Override
		public void update(Procedure1<Node> runnable) {
			synchronized (report) {
				runnable.apply(node);
			}
		}
	}

	static private Report createReport() {
		Report report = ReportFactory.eINSTANCE.createReport();
		Node root = ReportFactory.eINSTANCE.createNode();
		report.setRoot(root);
		root.setName("root");
		root.setStartTime(getTime());
		return report;
	}
	
	private ReportBuilder(Report report, Node currentNode) {
		this.report = report;
		this.currentNode = new NodeBuilder(null, currentNode);
		if (report.getRoot() == null) 
			throw new NullPointerException();
		if (currentNode == null)
			throw new NullPointerException();
		Node root = currentNode;
		
		while (root.getParent() != null)
			root = root.getParent();
		if (root != report.getRoot())
			throw new IllegalArgumentException();
	}

	public EventSource registerEventSource(String name) {
		EventSource source = ReportFactory.eINSTANCE.createEventSource();
		source.setName(name);
		synchronized (report) {
			report.getSources().add(source);
		}
		return source;
	}


//	@Override
//	public void withCurrentNode(Procedure1<Node> procedure) {
//		synchronized (report) {
//			procedure.apply(currentNode);
//		}
//	}
	
//	 Report getReport() {
//		synchronized (report) {
//			report.getRoot().setEndTime(getTime());
//		}
//		return report;
//	}

	public Report getReportCopy() {
		synchronized (report) {
			Report reportCopy = EcoreUtil.copy(report);
			reportCopy.getRoot().setEndTime(getTime());

			return reportCopy;
		}
	}

	@Override
	public INodeBuilder getCurrent() {
		return currentNode;
	}

	public static long getTime() {
		return System.currentTimeMillis();
	}

	@Override
	public void takeSnapshot(String type, String... id) {
		if (id.length == 0) {
			EventProviderManager.getInstance().takeSnapshot(this, null, type);
		} else {
			for (String lid : id) {
				EventProviderManager.getInstance()
						.takeSnapshot(this, lid, type);
			}
		}
	}

	public void registerProviders(String... id) {
		if (id.length == 0) {
			EventProviderManager.getInstance().register(this, null);
		} else {
			for (String lid : id) {
				EventProviderManager.getInstance().register(this, lid);
			}
		}
	}

	public void unregisterProviders(String... id) {
		if (id.length == 0) {
			EventProviderManager.getInstance().unregister(this, null);
		} else {
			for (String lid : id) {
				EventProviderManager.getInstance().unregister(this, lid);
			}
		}
	}

	/**
	 * Search for event source with equals eobject specified in property
	 */
	public EventSource findSource(String attr, EObject info) {
		synchronized (report) {
			EList<EventSource> sources = report.getSources();
			for (EventSource eventSource : sources) {
				EObject object = eventSource.getProperties().get(attr);
				if (object != null && EcoreUtil.equals(object, info)) {
					return eventSource;
				}
			}
		}
		return null;
	}


	private static String getLogCategoryKey(LoggingCategory category) {
		return "log_" + category.name();
	}

	public static String getLogs(Node node, LoggingCategory cat) {
		EObject object = node.getProperties().get(getLogCategoryKey(cat));
		if (object != null && object instanceof LoggingData) {
			return ((LoggingData) object).getText();
		}
		return null;
	}
	
	
	public static ReportBuilder create(String title) {
		Report report = createReport();
		report.getRoot().setName(title);
		return new ReportBuilder(report, report.getRoot());
	}
	
	public ReportBuilderStore save() {
		ReportBuilderStore store = ReportFactory.eINSTANCE.createReportBuilderStore();
		synchronized (report) {
			EcoreUtil.Copier copier = new Copier();
			store.setReport((Report) copier.copy(report));
			store.setCurrentNode((Node) copier.get(currentNode.node));
		}
		assert store.getCurrentNode() != null;
		assert store.getCurrentNode().eContainer() != null;
		store.getReport().getRoot().setEndTime(getTime());
		return store;
	}
	
	public static ReportBuilder load(ReportBuilderStore store) {
		return new ReportBuilder(store.getReport(), store.getCurrentNode());
	}

	public static Snaphot createSnapshot(EObject data, Map<String, EObject> properties) {
		Snaphot snapshot = ReportFactory.eINSTANCE.createSnaphot();
		snapshot.setTime(getTime());
		snapshot.setData(data);
		if (properties != null) {
			snapshot.getProperties().addAll(properties.entrySet());
		}
		return snapshot;
	}
}
