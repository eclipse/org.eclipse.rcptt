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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingCategory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingData;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;

/**
 * Build a complex report.
 */
public class ReportBuilder implements IReportBuilder {
	private Report report;
	private Node currentNode;

	public ReportBuilder() {
		report = ReportFactory.eINSTANCE.createReport();
		currentNode = ReportFactory.eINSTANCE.createNode();
		report.setRoot(currentNode);
		currentNode.setName("root");
		currentNode.setStartTime(getTime());
	}

	public EventSource registerEventSource(String name) {
		EventSource source = ReportFactory.eINSTANCE.createEventSource();
		source.setName(name);
		synchronized (report) {
			report.getSources().add(source);
		}
		return source;
	}

	/**
	 * Will add new node to current one and go one level down.
	 */

	public Node beginTask(String name) {
		Node nde = ReportFactory.eINSTANCE.createNode();
		nde.setName(name);
		nde.setStartTime(getTime());
		synchronized (report) {
			currentNode.getChildren().add(nde);
			currentNode = nde;
		}
		return nde;
	}

	@Override
	public void withCurrentNode(Procedure1<Node> procedure) {
		synchronized (report) {
			procedure.apply(currentNode);
		}
	}
	
	public Report getReport() {
		synchronized (report) {
			report.getRoot().setEndTime(getTime());
		}
		return report;
	}

	public Report getReportCopy() {
		synchronized (report) {
			Report reportCopy = EcoreUtil.copy(report);
			reportCopy.getRoot().setEndTime(getTime());

			return reportCopy;
		}
	}

	/**
	 * Will go one level up.
	 */

	public void endTask() {
		synchronized (report) {
			currentNode.setEndTime(getTime());
			if (!report.getRoot().equals(currentNode)) {
				currentNode = currentNode.getParent();
			}
		}
	}

	public long getTime() {
		return System.currentTimeMillis();
	}

	public Event createEvent() {
		synchronized (report) {
			return createEvent(currentNode);
		}
	}

	public Event createEvent(Node node) {
		Event event = ReportFactory.eINSTANCE.createEvent();
		event.setTime(getTime());
		synchronized (report) {
			node.getEvents().add(event);
		}
		return event;
	}

	public Snaphot createSnapshot() {
		Snaphot snapshot = ReportFactory.eINSTANCE.createSnaphot();
		snapshot.setTime(getTime());
		synchronized (report) {
			currentNode.getSnapshots().add(snapshot);
		}
		return snapshot;
	}

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

	public void setReport(Report eObject, Node node) {
		report = eObject;
		currentNode = node;
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

	/*
	 * Add or append existing log entry into current node.
	 */
	public static void appendLog(Node node, LoggingCategory category, String text) {
		if (node == null) {
			return;
		}
		LoggingData data = null;
		String log_key = getLogCategoryKey(category);
		EObject eObject = node.getProperties().get(log_key);
		if (eObject instanceof LoggingData) {
			data = (LoggingData) eObject;
		}
		if (data == null) {
			data = ReportFactory.eINSTANCE.createLoggingData();
			node.getProperties().put(log_key, data);
		}
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
}
