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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus;
import org.eclipse.rcptt.sherlock.core.model.sherlock.JavaException;
import org.eclipse.rcptt.sherlock.core.model.sherlock.JavaStackTraceEntry;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfo;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;

public class SimpleReportGenerator {
	private static final String LINE_SEPARATOR = "\n";

	public String generateContent(Report report) {
		StringBuilder builder = new StringBuilder();
		Node nodes = report.getRoot();
		builder.append("Report:").append(LINE_SEPARATOR);
		printNode(nodes, builder, 1, false);
		builder.append("Q7 Wait details");
		printNode(nodes, builder, 1, true);
		return builder.toString();
	}

	public void printNode(Node infoNode, StringBuilder stream, int tabs, boolean includeWaitDetails) {
		appendTabs(stream, tabs);
		stream.append(infoNode.getName())
				.append(" ")
				.append(Long.toString(infoNode.getEndTime()
						- infoNode.getStartTime()));
		stream.append(" {").append(LINE_SEPARATOR);

		EMap<String, EObject> list = infoNode.getProperties();
		for (String key : list.keySet()) {
			EObject value = list.get(key);
			if (value instanceof Q7WaitInfoRoot) {
				if (includeWaitDetails) {
					printWaitInfo(stream, tabs, key, (Q7WaitInfoRoot) value);
				}
			}
			else {
				if (!includeWaitDetails) {
					appendTabs(stream, tabs + 1).append(key).append("=")
							.append(asValue(value)).append(LINE_SEPARATOR);
				}
			}
		}
		for (Node child : infoNode.getChildren()) {
			printNode(child, stream, tabs + 2, includeWaitDetails);
		}

		if (!includeWaitDetails) {
			for (Snaphot child : infoNode.getSnapshots()) {
				printSnapshot(child, stream, tabs + 2);
			}
		}
		appendTabs(stream, tabs).append("}").append(LINE_SEPARATOR);
	}

	public void printWaitInfo(StringBuilder stream, int tabs, String key, Q7WaitInfoRoot value) {
		Q7WaitInfoRoot info = (Q7WaitInfoRoot) value;
		List<Q7WaitInfo> infos = new ArrayList<Q7WaitInfo>(info.getInfos());
		Collections.sort(infos, new Comparator<Q7WaitInfo>() {
			@Override
			public int compare(Q7WaitInfo o1, Q7WaitInfo o2) {
				return Long.valueOf(o1.getLastTick()).compareTo(Long.valueOf(o2.getLastTick()));
			}
		});
		if (infos.size() == 0) {
			return;
		}
		long endTime = info.getStartTime();
		int total = 0;
		for (Q7WaitInfo q7WaitInfo : infos) {
			if (getType(info, q7WaitInfo) == null) {
				continue;
			}
			if (endTime < q7WaitInfo.getEndTime()) {
				endTime = q7WaitInfo.getEndTime();
			}
			total++;
		}
		if (total == 0) {
			return;
		}
		appendTabs(stream, tabs + 4).append("--> q7 wait details <-- total wait time: ")
				.append(Long.toString(endTime - info.getStartTime()))
				.append(LINE_SEPARATOR);
		for (Q7WaitInfo i : infos) {
			long totalTime = i.getEndTime() - i.getStartTime();
			String className = getClassName(value, i);
			String type = getType(info, i);
			if (type == null) {
				continue;
			}
			appendTabs(stream, tabs + 8).append(type).append(": ")
					.append(className);
			// stream.append(" time: ").append(Long.toString(i.getStartTime())).append(" - ").append(i.getEndTime());
			if (totalTime != 0)
				stream.append(", total time: ").append(Long.toString(totalTime));
			if (i.getLastTick() > 0) {
				// stream.append(", total ticks: ").append(Long.toString(i.getTicks()));
				stream.append(", ticks: ").append(Long.toString(i.getLastTick() - i.getTicks() + 1));
				stream.append(" to ").append(Long.toString(i.getLastTick()));
			}
			// if( i.getLastTick() != 0) {
			// }
			stream.append(LINE_SEPARATOR);
		}
	}

	public static String getType(Q7WaitInfoRoot info, Q7WaitInfo q7WaitInfo) {
		String type = info.getTypesNames().get(q7WaitInfo.getTypeId());
		if (!TeslaFeatures.isIncludeIgnoredWaitDetails() && type.contains("(ignored)")) {
			return null;
		}
		return type;
	}

	private String asValue(EObject eObject) {
		StringBuilder b = new StringBuilder();
		toString(b, 0, eObject);
		return "(" + b.toString().replace("\n", " ") + ")";
	}

	protected void printSnapshot(Snaphot child, StringBuilder stream, int tabs) {
		appendTabs(stream, tabs);
		stream.append(" %");
		stream.append(" object:").append(LINE_SEPARATOR);
		toString(stream, tabs + 1, child.getData()).append(LINE_SEPARATOR);

		EMap<String, EObject> list = child.getProperties();
		for (String key : list.keySet()) {
			appendTabs(stream, tabs + 1).append(key).append("=")
					.append(asValue(list.get(key))).append(LINE_SEPARATOR);
		}
		appendTabs(stream, tabs).append("%").append(LINE_SEPARATOR);
	}

	protected StringBuilder appendTabs(StringBuilder stream, int tabs) {
		for (int i = 0; i < tabs; ++i) {
			stream.append("  ");
		}
		return stream;
	}

	protected StringBuilder printStatus(EclipseStatus s, int tabs,
			StringBuilder builder) {
		int severity = s.getSeverity();
		if (severity == IStatus.ERROR) {
			appendTabs(builder, tabs).append("Error");
		}
		if (severity == IStatus.INFO) {
			appendTabs(builder, tabs).append("Info");
		}
		if (severity == IStatus.WARNING) {
			appendTabs(builder, tabs).append("Warning");
		}
		builder.append(" in plugin: ").append(s.getPlugin())
				.append(LINE_SEPARATOR);
		appendTabs(builder, tabs).append("message: ").append(s.getMessage())
				.append(LINE_SEPARATOR);
		if (s.getException() != null) {
			appendTabs(builder, tabs).append("exception: ").append(
					LINE_SEPARATOR);
			printJavaException(s.getException(), tabs + 2, builder);
		}
		return builder;
	}

	private StringBuilder printJavaException(JavaException e, int tabs,
			StringBuilder builder) {
		appendTabs(builder, tabs).append(e.getClassName());
		if (e.getMessage() != null && e.getMessage().length() > 0) {
			builder.append(":").append(e.getMessage());
		}
		builder.append(LINE_SEPARATOR);
		for (JavaStackTraceEntry st : e.getStackTrace()) {
			appendTabs(builder, tabs + 2).append("at ")
					.append(st.getClassName()).append(".")
					.append(st.getMethodName()).append("(")
					.append(st.getFileName()).append(":")
					.append(st.getLineNumber()).append(")")
					.append(LINE_SEPARATOR);
		}
		JavaException cause = e.getCause();
		if (cause != null) {
			appendTabs(builder, tabs + 2).append("Caused by:").append(
					LINE_SEPARATOR);
			printJavaException(cause, tabs + 4, builder);
		}
		return builder;
	}

	public StringBuilder toString(StringBuilder builder, int tabs, EObject obj,
			String... ignores) {
		return toString(builder, tabs, obj, true, ignores);
	}

	@SuppressWarnings("rawtypes")
	public StringBuilder toString(StringBuilder builder, int tabs, EObject obj,
			boolean skipDefaults, String... ignores) {
		if (obj instanceof EclipseStatus) {
			return printStatus((EclipseStatus) obj, tabs, builder);
		}
		if (obj == null) {
			return builder;
		}
		EClass eClass = obj.eClass();
		EList<EStructuralFeature> features = eClass.getEAllStructuralFeatures();
		for (EStructuralFeature f : features) {
			Object eGet = obj.eGet(f);
			boolean needArg = true;
			Object defaultValue = f.getDefaultValue();
			needArg = (defaultValue == null || !defaultValue.equals(eGet));

			if (eGet instanceof List && ((List<?>) eGet).size() == 0) {
				needArg = false;
			}
			if (!skipDefaults) {
				needArg = true;
			}
			for (String ignore : ignores) {
				if (ignore.equals(f.getName())) {
					needArg = false;
					break;
				}
			}
			if (eGet != null && needArg) {
				appendTabs(builder, tabs).append(f.getName()).append('=');
				if (eGet instanceof EObject) {
					builder.append('{').append(LINE_SEPARATOR);
					toString(builder, tabs + 1, (EObject) eGet,
							"eFactoryInstance").append('}');
				} else if (eGet instanceof EList) {
					EList l = (EList) eGet;
					builder.append('[');
					for (int i = 0; i < l.size(); i++) {
						Object va = l.get(i);
						if (va instanceof EObject) {
							if (i != 0) {
								appendTabs(builder, tabs + 2);
							}
							builder.append('{').append(LINE_SEPARATOR);
							toString(builder, tabs + 4, (EObject) va,
									"eFactoryInstance");
							appendTabs(builder, tabs + 2).append('}').append(
									LINE_SEPARATOR);
						}
					}
					builder.append(']');
				} else {
					builder.append(eGet).append(LINE_SEPARATOR);
				}
			}
		}
		return builder;
	}

	public static String getClassName(Q7WaitInfoRoot waitRoot, Q7WaitInfo i) {
		String className = waitRoot.getClassNames().get(i.getClassId());
		if (className != null && waitRoot.getInnerClassMap().containsKey(className)) {
			String originalClassName = className;
			int pos = className.indexOf("$");
			if (pos != -1) {
				className = className.substring(0, pos);
			}
			className += '.' + waitRoot.getInnerClassMap().get(originalClassName);
		}
		return className;
	}
}
