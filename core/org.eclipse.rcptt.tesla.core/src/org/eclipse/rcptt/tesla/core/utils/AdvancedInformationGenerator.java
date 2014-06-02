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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.InfoNode;
import org.eclipse.rcptt.tesla.core.info.JobEntry;
import org.eclipse.rcptt.tesla.core.info.NodeProperty;
import org.eclipse.rcptt.tesla.core.info.StackTraceEntry;

public class AdvancedInformationGenerator {
	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");
	public static final String STACK_TRACE = "include.stack.trace";

	private Map<String, Boolean> options = new HashMap<String, Boolean>();

	{
		options.put(STACK_TRACE, Boolean.TRUE);
	}

	public AdvancedInformationGenerator set(String property, boolean value) {
		options.put(property, Boolean.valueOf(value));
		return this;
	}

	public String generateContent(AdvancedInformation info) {
		StringBuilder builder = new StringBuilder();
		EList<InfoNode> nodes = info.getNodes();
		builder.append("Information:").append(LINE_SEPARATOR);
		for (InfoNode infoNode : nodes) {
			printNode(infoNode, builder, 1);
		}
		// Append job information
		EList<JobEntry> jobs = info.getJobs();
		if (!jobs.isEmpty()) {
			builder.append(LINE_SEPARATOR).append("Jobs information:")
					.append(LINE_SEPARATOR);
			for (JobEntry jobEntry : jobs) {
				appendTabs(builder, 1).append("Job:")
						.append(jobEntry.getName()).append(LINE_SEPARATOR);
				appendTabs(builder, 2).append("class=")
						.append(jobEntry.getJobClass()).append(LINE_SEPARATOR);
				appendTabs(builder, 2).append("state=")
						.append(jobEntry.getState()).append(LINE_SEPARATOR);
				if (jobEntry.getRule() != null) {
					appendTabs(builder, 2).append("rule=")
							.append(jobEntry.getRule()).append(LINE_SEPARATOR);
				}
			}
		}
		// Append job information
		if (options.get(STACK_TRACE).equals(Boolean.TRUE)) {
			EList<StackTraceEntry> threads = info.getThreads();
			if (!threads.isEmpty()) {
				builder.append(LINE_SEPARATOR).append("Thread information:")
						.append(LINE_SEPARATOR);
				for (StackTraceEntry trace : threads) {
					if (trace.getThreadClass().equals(
							"org.eclipse.core.internal.jobs.Worker")
							&& trace.getStackTrace().size() == 4) {
						// Skip Worker threads sleep state
						continue;
					}
					appendTabs(builder, 1).append("Thread:")
							.append(trace.getThreadName())
							.append(LINE_SEPARATOR);
					appendTabs(builder, 2).append("class=")
							.append(trace.getThreadClass())
							.append(LINE_SEPARATOR);
					EList<String> list = trace.getStackTrace();
					for (int i = 0; i < list.size(); i++) {
						appendTabs(builder, 3)
								.append(Integer.toString(list.size() - i - 1))
								.append(": ").append(list.get(i))
								.append(LINE_SEPARATOR);

					}
				}
			}
		}
		return builder.toString();
	}

	private void printNode(InfoNode infoNode, StringBuilder stream, int tabs) {
		appendTabs(stream, tabs);
		stream.append(infoNode.getName());
		EList<NodeProperty> list = infoNode.getProperties();
		EList<InfoNode> childs = infoNode.getChildren();
		if (!list.isEmpty() || !childs.isEmpty()) {
			stream.append(" {").append(LINE_SEPARATOR);
			// Out properties
			if (list.size() != 0) {
				// appendTabs(stream, tabs + 1).append("properties = [\n");
				for (NodeProperty nodeProperty : list) {
					appendTabs(stream, tabs + 1).append(nodeProperty.getName())
							.append("=").append(nodeProperty.getValue())
							.append(LINE_SEPARATOR);
				}
				// appendTabs(stream, tabs + 1).append("]\n");
			}

			if (childs.size() != 0) {
				// appendTabs(stream, tabs + 1).append(LINE_SEPARATOR);
				for (InfoNode child : childs) {
					printNode(child, stream, tabs + 2);
				}
			}
			appendTabs(stream, tabs).append("}").append(LINE_SEPARATOR);
		} else {
			stream.append(LINE_SEPARATOR);
		}
	}

	private StringBuilder appendTabs(StringBuilder stream, int tabs) {
		for (int i = 0; i < tabs; ++i) {
			stream.append("  ");
		}
		return stream;
	}
}
