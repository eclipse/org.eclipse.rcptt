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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ReportingFactory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.reporting.IReportBuilder;
import org.eclipse.rcptt.sherlock.core.reporting.Procedure1;
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
	
	public static Q7WaitInfoRoot getCurrentWaitInfo(IReportBuilder builder) {
		final Q7WaitInfoRoot[] rv = new Q7WaitInfoRoot[1];
		if (builder != null) {
			builder.withCurrentNode(new Procedure1<Node>() {
				
				@Override
				public void apply(Node node) {
					Q7WaitInfoRoot info = ReportHelper.getWaitInfo(node, true);
					rv[0] = info;
				}
			});
		}
		return rv[0];
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
}
