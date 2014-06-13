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
package org.eclipse.rcptt.reporting.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.Q7Statistics;
import org.eclipse.rcptt.reporting.ReportingFactory;
import org.eclipse.rcptt.reporting.ResultStatus;
import org.eclipse.rcptt.reporting.core.IQ7ReportConstants;
import org.eclipse.rcptt.reporting.core.Q7ReportIterator;
import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;
import org.eclipse.rcptt.sherlock.core.reporting.SimpleReportGenerator;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.utils.AdvancedInformationGenerator;

public class ReportUtils {

	public static Q7Statistics calculateStatistics(Q7ReportIterator iterator) {
		return calculateStatistics(iterator.iterator());
	}

	public static Q7Statistics calculateStatistics(Iterator<Report> iterator) {
		Q7Statistics statistics = ReportingFactory.eINSTANCE
				.createQ7Statistics();

		long startTime = Long.MAX_VALUE;
		long endTime = Long.MIN_VALUE;
		long totalTime = 0;
		int total = 0;
		int failed = 0;
		int passed = 0;
		int skipped = 0;

		while (iterator.hasNext()) {
			Report report = iterator.next();
			if (report == null) {
				return null;
			}
			total += 1;
			Node localRoot = report.getRoot();
			if (!localRoot.getProperties().containsKey(IQ7ReportConstants.ROOT)) {
				continue;
			}

			Q7Info q7info = (Q7Info) localRoot.getProperties().get(
					IQ7ReportConstants.ROOT);
			switch (q7info.getResult()) {
			case FAIL:
			case WARN:
				failed++;
				break;
			case PASS:
				passed++;
				break;
			case SKIPPED:
				skipped++;
				break;
			}

			startTime = Math.min(startTime, localRoot.getStartTime());
			endTime = Math.max(endTime, localRoot.getEndTime());
			totalTime += (localRoot.getEndTime() - localRoot.getStartTime());
		}

		statistics.setTime((int) totalTime);
		statistics.setTotal(total);
		statistics.setFailed(failed);
		statistics.setPassed(passed);
		statistics.setSkipped(skipped);
		return statistics;
	}

	/**
	 * Create complex report from individual parts
	 * 
	 * 
	 * @param session
	 * @return
	 */
	public static Report combineReports(Q7ReportIterator iterator, int len,
			IProgressMonitor monitor) {

		monitor.beginTask("Combine Q7 testcase reports", len * 10);
		Report report = ReportFactory.eINSTANCE.createReport();
		Node rootNode = ReportFactory.eINSTANCE.createNode();
		report.setRoot(rootNode);
		iterator.reset();
		while (iterator.hasNext()) {
			Report copy = iterator.next();

			// report.getSources().addAll(copy.getSources());
			Map<EventSource, EventSource> toUpdate = new HashMap<EventSource, EventSource>();
			EList<EventSource> copySources = copy.getSources();
			EList<EventSource> sources = report.getSources();
			List<EventSource> repSources = new ArrayList<EventSource>();
			for (EventSource source : copySources) {
				boolean exist = false;
				for (EventSource rootSource : sources) {
					if (compareSources(source, rootSource)) {
						toUpdate.put(source, rootSource);
						exist = true;
						break;
					}
				}
				if (!exist) {
					repSources.add(source);
				}
			}
			sources.addAll(repSources);

			for (EventSource source : toUpdate.keySet()) {
				updateSource(copy, source, toUpdate.get(source));
			}

			rootNode.getChildren().add(copy.getRoot());
			monitor.worked(10);
		}
		monitor.done();
		return report;
	}

	private static boolean compareSources(EventSource source,
			EventSource rootSource) {
		if (source == null || rootSource == null) {
			return false;
		}
		EMap<String, EObject> properties = source.getProperties();
		EMap<String, EObject> properties2 = rootSource.getProperties();
		if (properties.size() != properties2.size()) {
			return false;
		}
		Set<String> keySet = properties.keySet();
		for (String s : keySet) {
			EObject v1 = properties.get(s);
			EObject v2 = properties2.get(s);
			if (!EcoreUtil.equals(v1, v2)) {
				return false;
			}
		}

		return true;
	}

	private static void updateSource(Report copy, EventSource source,
			EventSource rootSource) {
		TreeIterator<EObject> contents = copy.eAllContents();
		List<Event> eventsToUpdate = new ArrayList<Event>();
		while (contents.hasNext()) {
			EObject next = contents.next();
			if (next instanceof Event) {
				EventSource eSource = ((Event) next).getSource();
				if (eSource != null) {
					if (source.equals(eSource)) {
						eventsToUpdate.add((Event) next);
					}
				}
			}
		}
		for (Event event : eventsToUpdate) {
			event.setSource(rootSource);
		}
	}

	public static String getScenarioTags(Node item) {
		EList<Node> children = item.getChildren();
		for (Node node : children) {
			Q7Info info = (Q7Info) node.getProperties().get(
					IQ7ReportConstants.ROOT);
			if (info != null && info.getType() == ItemKind.SCRIPT) {
				return info.getTags();
			}
		}
		return null;
	}

	public static String getScenarioDescription(Node item) {
		EList<Node> children = item.getChildren();
		for (Node node : children) {
			Q7Info info = (Q7Info) node.getProperties().get(
					IQ7ReportConstants.ROOT);
			if (info != null && info.getType() == ItemKind.SCRIPT) {
				return info.getDescription();
			}
		}
		return null;
	}

	public static boolean isLoggedCommand(String name) {
		return isTraceCommand(name) || isScreenshotCommand(name);
	}

	public static boolean isTraceCommand(String name) {
		return name.equals("trace");
	}

	public static boolean isScreenshotCommand(String name) {
		return name.equals("take-screenshot");
	}

	public static final String formatTime(long duration) {
		return String.format("%d.%03d", duration / 1000, duration % 1000);
	}

	public static String replaceEscapeSymbols(String text) {
		if (text == null) {
			return null;
		}
		return text.replace("\"", "&quot;").replace("<", "&lt;")
				.replace(">", "&gt;");
	}

	public static List<Screenshot> findScreenshots(Node node) {
		List<Screenshot> result = new ArrayList<Screenshot>();
		collectScreenshots(node, result);
		return result;
	}

	private static void collectScreenshots(Node node, List<Screenshot> acc) {
		for (Snaphot snapshot : node.getSnapshots()) {
			if (snapshot.getData() instanceof Screenshot) {
				acc.add((Screenshot) snapshot.getData());
			}
		}

		for (Node child : node.getChildren()) {
			collectScreenshots(child, acc);
		}
	}

	public static String getFailMessage(Node item) {
		StringBuilder result = new StringBuilder();
		EList<Node> children = item.getChildren();
		Q7Info current = (Q7Info) item.getProperties().get(IQ7ReportConstants.ROOT);
		if (current != null && current.getResult().equals(ResultStatus.FAIL)) {
			if (current.getMessage() != null) {
				return current.getMessage();
			}
		}
		for (Node node : children) {
			String message = getFailMessage(node);
			if (message != null && !message.isEmpty()) {
				return message;
			}
		}
		return result.toString();
	}

	public static String replaceHtmlEntities(String string) {
		string = string.replace("&", "&amp;");
		string = string.replace("<", "&lt;");
		string = string.replace(">", "&gt;");
		return string;
	}

	public static String replaceLineBreaks(String string) {
		string = string.replace("\r\n", "<br />");
		string = string.replace("\n", "<br />");
		string = string.replace("\r", "<br />");
		return string;
	}

	private static void collectFailures(Node item, StringBuilder result) {
		Q7Info info = (Q7Info) item.getProperties()
				.get(IQ7ReportConstants.ROOT);
		if (info != null && info.getResult().equals(ResultStatus.FAIL)) {
			String msg = info.getMessage();
			if (msg != null) {
				result.append(msg).append("\n");
			}
		}
		EList<Node> children = item.getChildren();
		for (Node node : children) {
			collectFailures(node, result);
		}
	}

	public static String getDetails(Node item) {
		// Collect and print all snapshots
		StringBuilder builder = new StringBuilder();
		collectDetails(item, builder);
		return maskIllegalChars(builder.toString());
	}

	/**
	 * see http://jira4.xored.com/browse/QS-1334
	 * 
	 * @param str
	 * @return
	 */
	private static String maskIllegalChars(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		return str.replace("\0", "\\0").replace("]]>", "]] >");
	}

	public static String combineNames(EList<String> list, String separator) {
		if (list == null || separator == null)
			return null;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if (i < list.size() - 1) {
				sb.append(separator);
			}
		}
		return sb.toString();
	}

	public static void collectDetails(Node item, StringBuilder result) {
		EList<Snaphot> snapshots = item.getSnapshots();
		for (Snaphot snaphot : snapshots) {
			EObject data = snaphot.getData();
			if (data != null) {
				if (data instanceof AdvancedInformation) {
					result.append(new AdvancedInformationGenerator()
							.generateContent((AdvancedInformation) data));
					result.append("\n");
				} else {
					new SimpleReportGenerator().toString(result, 2, data);
					result.append("\n");
				}
			}
		}
		EList<Event> events = item.getEvents();
		for (Event event : events) {
			if (event.getData() instanceof EclipseStatus) {
				EclipseStatus data = (EclipseStatus) event.getData();
				new SimpleReportGenerator().toString(result, 1, data);
				result.append("\n");
			}
		}
		EList<Node> children = item.getChildren();
		for (Node node : children) {
			collectDetails(node, result);
		}
	}
}
