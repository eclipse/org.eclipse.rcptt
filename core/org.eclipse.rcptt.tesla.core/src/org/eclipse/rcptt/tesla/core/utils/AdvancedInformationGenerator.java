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
package org.eclipse.rcptt.tesla.core.utils;

import java.io.PrintWriter;

import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.InfoNode;
import org.eclipse.rcptt.tesla.core.info.JobEntry;
import org.eclipse.rcptt.tesla.core.info.NodeProperty;
import org.eclipse.rcptt.tesla.core.info.StackTraceEntry;

public class AdvancedInformationGenerator {
	private final PrintWriter writer;

	public AdvancedInformationGenerator(PrintWriter writer) {
		this.writer = writer;
	}

	private PrintWriter w(int tabs) {
		for (int i = 0; i < tabs; ++i) {
			writer.append("  ");
		}
		return writer;
	}

	public void writeAdvanced(AdvancedInformation info, int tabs) {
		EList<InfoNode> nodes = info.getNodes();
		for (InfoNode infoNode : nodes) {
			printNode(infoNode, tabs);
		}
		// Append job information
		EList<JobEntry> jobs = info.getJobs();
		if (!jobs.isEmpty()) {
			w(tabs).println("Jobs information:");
			for (JobEntry jobEntry : jobs) {
				w(tabs + 1).println("Job:" + jobEntry.getName());
				w(tabs + 2).println("class=" + jobEntry.getJobClass());
				w(tabs + 2).println("state=" + jobEntry.getState());
				if (jobEntry.getRule() != null) {
					w(tabs + 2).println("rule=" + jobEntry.getRule());
				}
			}
		}
		// Append thread information
		EList<StackTraceEntry> threads = info.getThreads();
		if (!threads.isEmpty()) {
			w(tabs + 0).println("Thread information:");
			for (StackTraceEntry trace : threads) {
				if (trace.getThreadClass().equals(
						"org.eclipse.core.internal.jobs.Worker")
						&& trace.getStackTrace().size() == 4) {
					// Skip Worker threads sleep state
					continue;
				}
				w(tabs + 1).println("Thread:" + trace.getThreadName());
				w(tabs + 2).println("class=" + trace.getThreadClass());
				EList<String> list = trace.getStackTrace();
				for (int i = 0; i < list.size(); i++) {
					w(tabs + 3).append(Integer.toString(list.size() - i - 1))
							.append(": ").append(list.get(i))
							.println();

				}
			}
		}
	}

	private void printNode(InfoNode infoNode, int tabs) {
		w(tabs).println(infoNode.getName());
		EList<NodeProperty> list = infoNode.getProperties();
		EList<InfoNode> childs = infoNode.getChildren();
		if (!list.isEmpty() || !childs.isEmpty()) {
			w(tabs).println(" {");
			// Out properties
			if (list.size() != 0) {
				for (NodeProperty nodeProperty : list) {
					w(tabs + 1).println(nodeProperty.getName() + "=" + nodeProperty.getValue());
				}
			}
			if (childs.size() != 0) {
				for (InfoNode child : childs) {
					printNode(child, tabs + 2);
				}
			}
			w(tabs).println("}");
		}
	}
}
