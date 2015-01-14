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
package org.eclipse.rcptt.reporting.core;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ReportingFactory;
import org.eclipse.rcptt.reporting.ResultStatus;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;
import org.eclipse.rcptt.sherlock.core.reporting.EventProviderManager;
import org.eclipse.rcptt.sherlock.core.reporting.Procedure1;
import org.eclipse.rcptt.tesla.core.Q7WaitUtils;
import org.eclipse.rcptt.tesla.core.info.InfoFactory;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;

public class ReportHelper {

	public static Q7Info getInfo(Node node) {
		synchronized (node) {
			Q7Info value = getInfoOnly(node);
			if (value == null) {
				value = ReportingFactory.eINSTANCE.createQ7Info();
				node.getProperties().put(IQ7ReportConstants.ROOT, value);
			}
			return (Q7Info) value;
		}
	}
	

	public static void setInfo(INodeBuilder node, Q7Info info) {
		assert info.getType() != null;
		assert info.getResult() != null;
		node.setProperty(IQ7ReportConstants.ROOT, info);
	}
	
	{
		//Prevents class loader lock in synchronized context. See http://jira4.xored.com/browse/QS-3201#comment-22683
		InfoFactory.eINSTANCE.createQ7WaitInfoRoot();
	}

	public static Q7WaitInfoRoot getWaitInfo(Node node, boolean create) {
		synchronized (node) {
			Q7WaitInfoRoot value = (Q7WaitInfoRoot) node.getProperties().get(
					IQ7ReportConstants.ROOT_WAIT);
			if (value != null) {
				return (Q7WaitInfoRoot) value;
			}
			if (value == null && create) {
				value = InfoFactory.eINSTANCE.createQ7WaitInfoRoot();
				value.setStartTime(System.currentTimeMillis());
				value.setTick(0); // Indicated current object index
				node.getProperties().put(IQ7ReportConstants.ROOT_WAIT, value);
			}
			return (Q7WaitInfoRoot) value;
		}
	}
	
	public static void putProperties(INodeBuilder node, Map<String, ? extends EObject> properties) {
		for (Map.Entry<String, ? extends EObject> entry : properties.entrySet()) {
			node.setProperty(entry.getKey(), entry.getValue());
		}
	}
	

	public static Q7Info getInfoOnly(Node node) {
		synchronized (node) {
			EObject value = node.getProperties().get(IQ7ReportConstants.ROOT);
			if (value instanceof Q7Info) {
				return (Q7Info) value;
			}
			return null;
		}
	}

	public static Q7Info createInfo() {
		return ReportingFactory.eINSTANCE.createQ7Info();
	}
	
	public static void updateWaitInfo(INodeBuilder node, final String kind, final String className) {
		Q7WaitUtils.updateInfo(kind, className, getWaitInfo(node));
	}
	
	/** Leaks Q7WaitInfoRoot reference in unsynchronized context */
	public static Q7WaitInfoRoot getWaitInfo(INodeBuilder node) {
		
		final Q7WaitInfoRoot waitInfo[] = new Q7WaitInfoRoot[1];
		node.update(new Procedure1<Node>() {
			@Override
			public void apply(Node node) {
				//Leaking reference to unsynchronized context
				waitInfo[0] = getWaitInfo(node, true);
			}
		});
		return waitInfo[0]; //Might be null at this point if no report is active
	}
	
	public static void setResult(INodeBuilder node, final ResultStatus status, final String message) {
		node.update(new Procedure1<Node>() {
			@Override
			public void apply(Node arg) {
				Q7Info info = getInfo(arg);

				info.setResult(status);
				info.setMessage(message);
			}
		});
	}
	
	public static void addSnapshotWithData(INodeBuilder node, EObject data) {
		Snaphot snapshot = ReportFactory.eINSTANCE.createSnaphot();
		snapshot.setData(data);
		node.addSnapshot(snapshot);
	}

	public static void takeSnapshot(INodeBuilder node) {
		EventProviderManager.getInstance().takeSnapshot(node);
	}
}
