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
package org.eclipse.rcptt.sherlock.ui.reportdetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ScrollBar;

import org.eclipse.rcptt.profiling.core.SherlockJobsCore;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventKind;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.reporting.SimpleReportGenerator;
import org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventInfo;
import org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo;
import org.eclipse.rcptt.sherlock.jobs.jobs.JobEventInfo;
import org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo;
import org.eclipse.rcptt.sherlock.ui.reportdetails.figures.EventFigure;
import org.eclipse.rcptt.sherlock.ui.reportdetails.figures.NodeFigure;
import org.eclipse.rcptt.sherlock.ui.reportdetails.figures.SourceFigure;

public class ReportTimelineComposite {
	private List<Node> nodes = new ArrayList<Node>();
	private Canvas imageCanvas;
	private ScrolledComposite sc;

	private Figure figureParent;
	private LightweightSystem lws;
	private StyledText infoText;
	private int timeWidth = 600;
	private boolean includeTasks = true;
	private ColorManager colors = new ColorManager(true);
	private long minTime;
	private long maxTime;
	private boolean showBegined = true;

	public ReportTimelineComposite(Report report2, Composite control) {
		SashForm sform = new SashForm(control, SWT.VERTICAL | SWT.SMOOTH);
		sform.setLayout(new org.eclipse.swt.layout.GridLayout(1, false));
		GridDataFactory.fillDefaults().hint(200, 100).grab(true, true)
				.applyTo(sform);
		sc = new ScrolledComposite(sform, SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.BORDER);

		imageCanvas = new Canvas(sc, SWT.DOUBLE_BUFFERED);
		sc.setContent(imageCanvas);
		final Color color = imageCanvas.getDisplay().getSystemColor(
				SWT.COLOR_WHITE);
		sc.setBackground(new Color(color.getDevice(), color.getRGB()));
		imageCanvas.setBackground(new Color(color.getDevice(), color.getRGB()));

		updateBounds(50, 50);
		GridDataFactory.fillDefaults().hint(200, 100).grab(true, true)
				.applyTo(sc);
		lws = new LightweightSystem(imageCanvas);
		figureParent = new Layer();
		GridLayout gl = new GridLayout(1, true);
		gl.horizontalSpacing = 0;
		gl.verticalSpacing = -1;
		figureParent.setLayoutManager(gl);
		lws.setContents(figureParent);

		Composite g = new Composite(sform, SWT.BORDER);
		// g.setText("Details");
		infoText = new StyledText(g, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 150).grab(true, false)
				.applyTo(g);
		GridLayoutFactory.swtDefaults().applyTo(g);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(infoText);

		sform.setWeights(new int[] { 80, 20 });
	}

	public void doZoomOut() {
		timeWidth = timeWidth - timeWidth / 4;
		if (timeWidth < 200) {
			timeWidth = 200;
		}
		ScrollBar bar = sc.getHorizontalBar();
		int selection = bar.getSelection();
		int maximum = bar.getMaximum();
		internalUpdate(nodes);
		bar.setSelection((int) ((1.0f * selection / maximum) * bar.getMaximum()));
		bar.notifyListeners(SWT.Selection, new org.eclipse.swt.widgets.Event());
	}

	public void doZoomIn() {
		timeWidth = timeWidth + timeWidth / 4;
		if (timeWidth > 30000) {
			timeWidth = 30000;
		}
		ScrollBar bar = sc.getHorizontalBar();
		int selection = bar.getSelection();
		int maximum = bar.getMaximum();
		internalUpdate(nodes);
		bar.setSelection((int) ((1.0f * selection / maximum) * bar.getMaximum()));
		bar.notifyListeners(SWT.Selection, new org.eclipse.swt.widgets.Event());
	}

	private void updateBounds(int width, int height) {
		imageCanvas.setBounds(0, 0, width, height);
		// imageCanvas.getViewport().setSize(width, height);
		// imageCanvas.setMinSize(width - 1, height - 1);
	}

	public void update(List<Node> newNodes) {
		this.nodes.clear();
		this.nodes.addAll(newNodes);
		timeWidth = 600;
		internalUpdate(nodes);
	}

	private void internalUpdate(List<Node> newNodes) {
		figureParent.removeAll();

		minTime = Long.MAX_VALUE;
		maxTime = Long.MIN_VALUE;
		for (Node node : newNodes) {
			long startTime = node.getStartTime();
			if (startTime < minTime) {
				minTime = startTime;
			}
			long endTime = node.getEndTime();
			if (endTime > maxTime) {
				maxTime = endTime;
			}
		}
		long allTime = maxTime - minTime;

		Set<Event> processed = new HashSet<Event>();

		// Create draw nodes from jobs and asyncs
		final Map<EventSource, List<Event>> sourceEvents = new HashMap<EventSource, List<Event>>();
		for (Node node : newNodes) {
			int st = calcPos(minTime, allTime, node.getStartTime());
			int ed = calcPos(minTime, allTime, node.getEndTime()) - st;
			NodeFigure nodeFig = null;
			if (includeTasks) {
				SourceFigure sources = new SourceFigure(node.getName(),
						getTimeWidth(), 1);
				figureParent.add(sources);

				nodeFig = createNodeFigure();
				nodeFig.setFill(true);
				nodeFig.setNode(node);
				nodeFig.setBackgroundColor(colors.getColor(new RGB(220, 220,
						220)));
				sources.addToContainer(nodeFig, st, 0, ed, 20, 0);
			}
			List<Event> events = new ArrayList<Event>(node.getEvents());

			// We need to collect also events started in all previous and parent
			// nodes and not finished here.
			Map<EventSource, List<Event>> nonFinishedGroups = new HashMap<EventSource, List<Event>>();
			if (showBegined && newNodes.size() < 10) {
				List<Event> priorEvents = collectPriorEvents(node);
				final Map<EventSource, List<Event>> priorEventsSources = new HashMap<EventSource, List<Event>>();
				groupBySources(priorEvents, priorEventsSources);
				mergeSources(priorEventsSources);
				List<EventSource> sourcesKeys = new ArrayList<EventSource>(
						priorEventsSources.keySet());
				Collections.sort(sourcesKeys, new Comparator<EventSource>() {
					public int compare(EventSource o1, EventSource o2) {
						long m1 = getMinTime(priorEventsSources, o1);
						long m2 = getMinTime(priorEventsSources, o2);

						return (int) (m1 - m2);
					}

				});
				for (EventSource source : sourcesKeys) {
					List<Event> events2 = priorEventsSources.get(source);
					Map<String, List<Event>> groups = groupByIDs(events2,
							new ArrayList<Event>());
					// Make small groups
					Collection<List<Event>> gvalues = groups.values();

					List<List<Event>> smallGroups = new ArrayList<List<Event>>();
					for (List<Event> list : gvalues) {
						makeSmallGroups(smallGroups, list);
					}
					Collections.sort(smallGroups,
							new Comparator<List<Event>>() {
								public int compare(List<Event> o1,
										List<Event> o2) {
									long minTime1 = calcMinTime(o1);
									long minTime2 = calcMinTime(o2);

									return (int) (minTime1 - minTime2);
								}
							});

					// Match non finished groups
					for (List<Event> list : smallGroups) {
						if (list.size() > 2) {
							Event last = list.get(list.size() - 1);
							if (!last.getKind().equals(EventKind.END)) {
								List<Event> llist = nonFinishedGroups
										.get(source);
								if (llist == null) {
									llist = new ArrayList<Event>();
									nonFinishedGroups.put(source, llist);
								}
								llist.add(last);
							}
						}
					}

				}
			}

			final Map<EventSource, List<Event>> localSourceEvents = new HashMap<EventSource, List<Event>>();
			// localSourceEvents.putAll(nonFinishedGroups);
			groupBySources(events, sourceEvents);
			groupBySources(events, localSourceEvents);
			// Build draw blocks
			if (includeTasks) {
				mergeSources(localSourceEvents);

				nodeFig.setSources(localSourceEvents);
				List<EventSource> sourcesKeys = new ArrayList<EventSource>(
						localSourceEvents.keySet());
				Collections.sort(sourcesKeys, new Comparator<EventSource>() {
					public int compare(EventSource o1, EventSource o2) {
						long m1 = getMinTime(localSourceEvents, o1);
						long m2 = getMinTime(localSourceEvents, o2);

						return (int) (m1 - m2);
					}

				});
				for (EventSource source : sourcesKeys) {
					processSource(allTime, processed, node, st, ed,
							localSourceEvents, source);
				}
				for (EventSource source : nonFinishedGroups.keySet()) {
					processNonFinishedSource(allTime, node, st, ed,
							nonFinishedGroups, source);
				}
			}

		}
		mergeSources(sourceEvents);
		// Build draw blocks
		List<EventSource> sourcesKeys = new ArrayList<EventSource>(
				sourceEvents.keySet());
		Collections.sort(sourcesKeys, new Comparator<EventSource>() {
			public int compare(EventSource o1, EventSource o2) {
				long m1 = getMinTime(sourceEvents, o1);
				long m2 = getMinTime(sourceEvents, o2);

				return (int) (m1 - m2);
			}

		});
		for (EventSource source : sourcesKeys) {
			// ArrayList<DrawNode> list = new ArrayList<DrawNode>();
			List<Event> events = sourceEvents.get(source);
			events.removeAll(processed);
			if (events.size() > 0) {
				List<List<Event>> instances = groupEvents(events);
				SourceFigure sourceRoot = new SourceFigure(
						getSourceTitle(source), getTimeWidth(),
						instances.size());
				sourceRoot.setSource(source);
				for (List<Event> list : instances) {
					addEventsTo(minTime, allTime, list, sourceRoot, minTime,
							allTime, instances.indexOf(list));
				}
				if (sourceRoot.hasChildInContainer()) {
					figureParent.add(sourceRoot);
				}
				processed.addAll(events);
			}
		}
		Dimension psize = figureParent.getPreferredSize();
		updateBounds(psize.width, psize.height);
	}

	private void groupBySources(List<Event> events,
			final Map<EventSource, List<Event>> localSourceEvents) {
		for (Event event : events) {
			EventSource source = event.getSource();
			if (source != null) {

				// Put also in loca
				List<Event> list = localSourceEvents.get(source);

				if (list == null) {
					list = new ArrayList<Event>();
					localSourceEvents.put(source, list);
				}
				list.add(event);
			}
		}
	}

	/**
	 * Collect events started before node and not finished yet.
	 */
	private List<Event> collectPriorEvents(Node node) {
		Node parent = node.getParent();
		if (parent == null) {
			return new ArrayList<Event>();
		}

		List<Event> result = new ArrayList<Event>();
		result.addAll(collectPriorEvents(parent));
		EList<Event> events = parent.getEvents();
		for (Event event : events) {
			if (!event.getKind().equals(EventKind.INFO)
					&& event.getTime() < node.getStartTime()) {
				result.add(event);
			}
		}

		EList<Node> children = parent.getChildren();
		int pos = children.indexOf(node);

		for (int i = 0; i < pos; i++) {
			EList<Event> evs = children.get(i).getEvents();
			for (Event event : evs) {
				if (!event.getKind().equals(EventKind.INFO)) {
					result.addAll(evs);
				}
			}
		}

		return result;
	}

	private void processSource(long allTime, Set<Event> processed, Node node,
			int st, int ed,
			final Map<EventSource, List<Event>> localSourceEvents,
			EventSource source) {
		List<Event> events2 = localSourceEvents.get(source);
		processed.addAll(events2);
		List<List<Event>> instances = groupEvents(events2);

		SourceFigure sourceRoot = new SourceFigure(getSourceTitle(source),
				getTimeWidth(), instances.size());

		figureParent.add(sourceRoot);
		for (List<Event> list : instances) {
			addEventsTo(minTime, allTime, list, sourceRoot, st, ed,
					instances.indexOf(list));
		}
	}

	private void processNonFinishedSource(long allTime, Node node, int st,
			int ed, final Map<EventSource, List<Event>> localSourceEvents,
			EventSource source) {
		List<Event> events2 = localSourceEvents.get(source);
		List<List<Event>> instances = groupEvents(events2);

		SourceFigure sourceRoot = new SourceFigure(getSourceTitle(source),
				getTimeWidth(), instances.size());

		figureParent.add(sourceRoot);
		for (List<Event> list : instances) {
			int level = instances.indexOf(list);
			Set<Event> processed = new HashSet<Event>();
			int len = list.size();
			for (int i = 0; i < len; i++) {
				Event event = list.get(i);
				if (processed.contains(event)) {
					continue;
				}
				if (event.getKind().equals(EventKind.BEGIN)) {
					// Check for end node
					EventFigure childFig = createEventFigure();
					childFig.setEvent(event);
					childFig.setFill(true);
					if (event.getColor() == null) {
						childFig.setBackgroundColor(colors.getColor(new RGB(0,
								0, 0)));
					} else {
						Color color = colors.getColor(parseColor(event
								.getColor()));
						childFig.setBackgroundColor(color);
					}
					sourceRoot.addToContainer(childFig, st, 0, (int) ed, 20,
							level);
				}

			}
		}
	}

	private List<List<Event>> groupEvents(List<Event> events) {
		List<List<Event>> results = new ArrayList<List<Event>>();

		List<Event> topGroup = new ArrayList<Event>();
		List<Event> infoEvents = new ArrayList<Event>();

		Map<String, List<Event>> groups = groupByIDs(events, infoEvents);

		// Make small groups
		Collection<List<Event>> gvalues = groups.values();

		List<List<Event>> smallGroups = new ArrayList<List<Event>>();
		for (List<Event> list : gvalues) {
			makeSmallGroups(smallGroups, list);
		}
		Collections.sort(smallGroups, new Comparator<List<Event>>() {
			public int compare(List<Event> o1, List<Event> o2) {
				long minTime1 = calcMinTime(o1);
				long minTime2 = calcMinTime(o2);

				return (int) (minTime1 - minTime2);
			}
		});
		// Lets merge groups
		for (List<Event> list : smallGroups) {
			if (isFitGroup(topGroup, list)) {
				topGroup.addAll(list);
			} else {
				// try to merge events by BEGIN,END pairs
				results.add(list);
			}
		}
		if (!topGroup.isEmpty()) {
			results.add(topGroup);
		}
		if (!infoEvents.isEmpty()) {
			topGroup.addAll(infoEvents);
		}

		Collections.sort(results, new Comparator<List<Event>>() {
			public int compare(List<Event> o1, List<Event> o2) {
				long minTime1 = calcMinTime(o1);
				long minTime2 = calcMinTime(o2);

				return (int) (minTime1 - minTime2);
			}
		});

		return results;
	}

	private Map<String, List<Event>> groupByIDs(List<Event> events,
			List<Event> infoEvents) {
		Map<String, List<Event>> groups = new HashMap<String, List<Event>>();

		int len = events.size();
		for (int i = 0; i < len; i++) {
			Event event = events.get(i);
			if (event.getKind().equals(EventKind.INFO)) {
				infoEvents.add(event);
				continue;
			}
			String instance = getEventInstance(event);
			List<Event> list = groups.get(instance);
			if (list == null) {
				list = new ArrayList<Event>();
				groups.put(instance, list);
			}
			list.add(event);
		}
		return groups;
	}

	private void makeSmallGroups(List<List<Event>> smallGroups, List<Event> list) {
		for (int i = 0; i < list.size(); i++) {
			Event event = list.get(i);
			List<Event> tempGroup = new ArrayList<Event>();
			tempGroup.add(event);
			if (event.getKind().equals(EventKind.BEGIN)) {
				for (int j = i + 1; j < list.size(); j++) {
					Event jEvent = list.get(j);
					if (jEvent.getKind().equals(EventKind.BEGIN)) {
						tempGroup.add(jEvent);
					} else if (jEvent.getKind().equals(EventKind.END)) {
						tempGroup.add(jEvent);
						break;
					}
				}
			}
			i += tempGroup.size() - 1;
			smallGroups.add(tempGroup);
		}
	}

	private boolean isFitGroup(List<Event> topGroup, List<Event> list) {
		if (topGroup.isEmpty()) {
			return true;
		}

		List<List<Event>> smallGroups = new ArrayList<List<Event>>();
		makeSmallGroups(smallGroups, topGroup);

		long minTime = calcMinTime(list);
		long maxTime = calcMaxTime(list);

		for (List<Event> glist : smallGroups) {
			long gminTime = calcMinTime(glist);
			long gmaxTime = calcMaxTime(glist);

			if (!(maxTime < gminTime || minTime > gmaxTime)) {
				return false;
			}
		}

		return true;
	}

	private long calcMaxTime(List<Event> list) {
		long maxTime = -1;
		for (Event event : list) {
			if (event.getTime() > maxTime) {
				maxTime = event.getTime();
			}
		}
		return maxTime;
	}

	private long calcMinTime(List<Event> list) {
		long minTime = Long.MAX_VALUE;
		for (Event event : list) {
			if (event.getTime() < minTime) {
				minTime = event.getTime();
			}
		}
		return minTime;
	}

	private String getEventInstance(Event event) {
		EObject data = event.getData();
		if (data != null) {
			if (data instanceof AsyncEventInfo) {
				String id = ((AsyncEventInfo) data).getId();
				if (id != null) {
					return id;
				}
			} else if (data instanceof JobEventInfo) {
				String id = ((JobEventInfo) data).getId();
				if (id != null) {
					return id;
				}
			}
		}
		return "";
	}

	private void addEventsTo(long minTime, long allTime, List<Event> events,
			SourceFigure sourceRoot, long stTime, long edTime, int level) {
		Set<Event> processed = new HashSet<Event>();
		int len = events.size();
		for (int i = 0; i < len; i++) {
			Event event = events.get(i);
			if (processed.contains(event)) {
				continue;
			}
			if (event.getKind().equals(EventKind.END)) {
				EventFigure childFig = createEventFigure();
				childFig.setEvent(event);
				// childFig.setEndEvent(event);
				int cst = (int) stTime;
				int cstEnd = calcPos(minTime, allTime, event.getTime());
				childFig.setFill(true);
				if (event.getColor() == null) {
					childFig.setBackgroundColor(colors
							.getColor(new RGB(0, 0, 0)));
				} else {
					Color color = colors.getColor(parseColor(event.getColor()));
					childFig.setBorder(new LineBorder(color));
					childFig.setBackgroundColor(color);
				}
				sourceRoot.addToContainer(childFig, cst, 0, cstEnd - cst, 20,
						level);
			}
			if (event.getKind().equals(EventKind.BEGIN)) {
				// Check for end node
				boolean found = false;
				for (int j = i + 1; j < len; j++) {
					Event jEvent = events.get(j);
					if (jEvent.getKind().equals(EventKind.END)
							|| jEvent.getKind().equals(EventKind.BEGIN)) {
						if (jEvent.getKind().equals(EventKind.END)) {
							processed.add(jEvent);
						}
						if (!getEventInstance(jEvent).equals(
								getEventInstance(jEvent))) {
							continue;
						}

						EventFigure childFig = createEventFigure();
						childFig.setEvent(event);
						childFig.setEndEvent(jEvent);
						int cst = calcPos(minTime, allTime, event.getTime());
						int cstEnd = calcPos(minTime, allTime, jEvent.getTime());
						childFig.setFill(true);
						if (event.getColor() == null) {
							childFig.setBackgroundColor(colors
									.getColor(new RGB(0, 0, 0)));
						} else {
							Color color = colors.getColor(parseColor(event
									.getColor()));
							childFig.setBorder(new LineBorder(color));
							childFig.setBackgroundColor(color);
						}
						sourceRoot.addToContainer(childFig, cst, 0, cstEnd
								- cst, 20, level);
						found = true;
						break;
					}
				}
				if (!found) {
					EventFigure childFig = createEventFigure();
					childFig.setEvent(event);
					int cst = calcPos(minTime, allTime, event.getTime());
					childFig.setFill(true);
					if (event.getColor() == null) {
						childFig.setBackgroundColor(colors.getColor(new RGB(0,
								0, 0)));
					} else {
						Color color = colors.getColor(parseColor(event
								.getColor()));
						childFig.setBackgroundColor(color);
					}
					sourceRoot.addToContainer(childFig, cst, 0, (int) edTime
							- cst, 20, level);
				}
			}

		}
		for (int i = 0; i < len; i++) {
			Event event = events.get(i);
			if (event.getKind().equals(EventKind.INFO)) {
				EventFigure childFig = createEventFigure();
				int cst = calcPos(minTime, allTime, event.getTime());
				childFig.setFill(true);
				childFig.setEvent(event);
				if (event.getColor() == null) {
					childFig.setBackgroundColor(colors
							.getColor(new RGB(0, 0, 0)));
				} else {
					Color color = colors.getColor(parseColor(event.getColor()));
					childFig.setBorder(new LineBorder(color));
					childFig.setBackgroundColor(color);
				}
				sourceRoot.addToContainer(childFig, cst, 0, 1, 20, level);
			}
		}
		// Locate pairs
	}

	private NodeFigure createNodeFigure() {
		final NodeFigure nodeFig = new NodeFigure();
		nodeFig.addMouseMotionListener(new MouseMotionListener() {
			Border oldBorder;

			public void mouseDragged(MouseEvent me) {
			}

			public void mouseEntered(MouseEvent me) {
				oldBorder = nodeFig.getBorder();
				LineBorder border = new LineBorder(2);
				border.setStyle(Graphics.LINE_SOLID);
				border.setColor(colors.getColor(new RGB(255, 0, 0)));
				nodeFig.setBorder(border);
				imageCanvas.redraw();
			}

			public void mouseExited(MouseEvent me) {
				nodeFig.setBorder(oldBorder);
			}

			public void mouseHover(MouseEvent me) {
			}

			public void mouseMoved(MouseEvent me) {
			}
		});
		nodeFig.addMouseListener(new MouseListener() {

			public void mousePressed(MouseEvent me) {

			}

			public void mouseReleased(MouseEvent me) {
				if (nodeFig.getNode() != null) {
					updateInfo(nodeFig.getNode(), nodeFig.getSources());
				}
			}

			public void mouseDoubleClicked(MouseEvent me) {
			}
		});
		return nodeFig;
	}

	private EventFigure createEventFigure() {
		final EventFigure efig = new EventFigure();
		efig.addMouseMotionListener(new MouseMotionListener() {
			Border oldBorder = null;

			public void mouseDragged(MouseEvent me) {
			}

			public void mouseEntered(MouseEvent me) {
				oldBorder = efig.getBorder();
				LineBorder border = new LineBorder(2);
				border.setStyle(Graphics.LINE_SOLID);
				border.setColor(colors.getColor(new RGB(255, 0, 0)));
				efig.setBorder(border);
				imageCanvas.redraw();
			}

			public void mouseExited(MouseEvent me) {
				efig.setBorder(oldBorder);
			}

			public void mouseHover(MouseEvent me) {
			}

			public void mouseMoved(MouseEvent me) {
			}
		});
		efig.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent me) {
				updateInfo(efig.getEvent(), efig.getEndEvent());
			}

			public void mouseReleased(MouseEvent me) {
			}

			public void mouseDoubleClicked(MouseEvent me) {
			}
		});
		return efig;
	}

	private RGB parseColor(String color) {
		if (color.startsWith("#") && color.length() == 7) {
			int r = Integer.parseInt(color.substring(1, 3), 16);
			int g = Integer.parseInt(color.substring(3, 5), 16);
			int b = Integer.parseInt(color.substring(5, 7), 16);
			return new RGB(r, g, b);
		}
		return new RGB(0, 0, 0);
	}

	// Merge sources with same class name into one
	private void mergeSources(Map<EventSource, List<Event>> localSourceEvents) {
		Map<EventSource, List<Event>> result = new HashMap<EventSource, List<Event>>();
		for (EventSource es : localSourceEvents.keySet()) {
			String title = getSourceTitle(es);
			EventSource mergeTo = null;
			for (EventSource res : result.keySet()) {
				if (title.equals(getSourceTitle(res))) {
					mergeTo = res;
					break;
				}
			}
			if (mergeTo == null) {
				result.put(es, localSourceEvents.get(es));
			} else {
				List<Event> rList = new ArrayList<Event>();
				rList.addAll(result.get(mergeTo));
				rList.addAll(localSourceEvents.get(es));
				result.put(mergeTo, rList);
			}
		}
		localSourceEvents.clear();
		localSourceEvents.putAll(result);
	}

	private long getMinTime(
			final Map<EventSource, List<Event>> localSourceEvents,
			EventSource o1) {
		List<Event> list = localSourceEvents.get(o1);
		long minTime1 = calcMinTime(list);
		return minTime1;
	}

	protected void updateInfo(Event event, Event endEvent) {
		StringBuilder builder = new StringBuilder();

		if (event != null && endEvent != null) {
			builder.append(
					"Start time:"
							+ TimeFormatHelper.format(event.getTime() - minTime))
					.append("\n");
			builder.append(
					"Time spend:"
							+ TimeFormatHelper.format(endEvent.getTime()
									- event.getTime())).append("\n");

		} else {
			builder.append(
					"Time:"
							+ TimeFormatHelper.format(event.getTime() - minTime))
					.append("\n");

		}
		EventSource source = event.getSource();
		EObject data = source.getProperties().get(SherlockJobsCore.JOBS);
		if (data != null && data instanceof AsyncInfo) {
			EObject dta = event.getData();

			AsyncInfo info = (AsyncInfo) data;
			if (info.isSync()) {
				builder.append("sync exec:");
			} else {
				builder.append("async exec:");
				if (dta != null && dta instanceof AsyncEventInfo) {
					switch (((AsyncEventInfo) dta).getKind()) {
					case STARTING:
						builder.append("Starting");
						break;
					case RUNNING:
						builder.append("Running");
						break;
					case DONE:
						builder.append("Done");
						break;
					case TIMER_EXEC:
						builder.append("Timer exec");
						break;
					}
				}
			}
			builder.append("\n");
			String cName = info.getRunnableClass();
			if (cName == null || cName.startsWith("$")) {
				cName = info.getSourceClass() + cName;
			}
			builder.append(" class name:" + cName).append("\n");
			if (info.getSourceClass() != null) {
				builder.append(
						" source class name:" + info.getSourceClass() + "."
								+ info.getSourceMethod()).append("\n");
			}
			if (info.getSourceFile() != null) {
				builder.append(" source file:" + info.getSourceFile()).append(
						"\n");
			}
			if (info.getThisClassName() != null) {
				builder.append(" created from:" + info.getThisClassName())
						.append("\n");
			}
		}
		if (data != null && data instanceof JobInfo) {
			JobInfo info = (JobInfo) data;
			builder.append("job:");
			EObject dta = event.getData();
			if (dta != null && dta instanceof JobEventInfo) {
				switch (((JobEventInfo) dta).getKind()) {
				case SHEDULED:
					builder.append("Sheduled");
					break;
				case RUNNING:
					builder.append("Running");
					break;
				case CANCELED:
					builder.append("Canceled");
					break;
				case WAITING:
					builder.append("Waiting");
					break;
				case FINISHED:
					builder.append("Finished");
					break;
				case ASYNC_DONE:
					builder.append("Async Done");
					break;
				case SLEPPING:
					builder.append("Sleeping");
					break;
				case ASYNC_FINISH:
					builder.append("Waiting async");
					break;
				}
			}
			builder.append("\n");

			String cName = info.getJobClassName();
			if (cName == null || cName.startsWith("$")) {
				cName = info.getSourceClass() + cName;
			}
			builder.append(" class name:" + cName).append("\n");
			if (info.getSourceClass() != null) {
				builder.append(
						" source class name:" + info.getSourceClass() + "."
								+ info.getSourceMethod()).append("\n");
			}
			if (info.getSourceFile() != null) {
				builder.append(" source file:" + info.getSourceFile()).append(
						"\n");
			}
			if (info.getThisClassName() != null) {
				builder.append(" created from:" + info.getThisClassName())
						.append("\n");
			}
		}
		infoText.setText(builder.toString());
	}

	protected void updateInfo(Node node, Map<EventSource, List<Event>> sources) {
		StringBuilder builder = new StringBuilder();

		builder.append(
				"Start time:"
						+ TimeFormatHelper.format(node.getStartTime() - minTime))
				.append("\n");
		builder.append(
				"Time spend:"
						+ TimeFormatHelper.format(node.getEndTime()
								- node.getStartTime())).append("\n");

		SimpleReportGenerator gen = new SimpleReportGenerator();
		for (EventSource source : sources.keySet()) {
			builder.append("source:" + getSourceTitle(source)).append("\n");
			List<Event> events = sources.get(source);
			for (Event event : events) {
				builder.append("\t" + "event:"
						+ TimeFormatHelper.format(event.getTime() - minTime));
				StringBuilder b2 = new StringBuilder();
				gen.toString(b2, 0, event.getData(), true);
				builder.append(" " + b2.toString().replace('\n', ' ').trim())
						.append("\n");
			}
		}

		infoText.setText(builder.toString());
	}

	private int getTimeWidth() {
		return timeWidth;
	}

	private String getSourceTitle(EventSource source) {

		EMap<String, EObject> properties = source.getProperties();

		EObject eobject = properties.get(SherlockJobsCore.JOBS);
		if (eobject != null && eobject instanceof AsyncInfo) {
			AsyncInfo info = (AsyncInfo) eobject;
			String cName = info.getRunnableClass();
			if (cName == null || cName.startsWith("$")) {
				cName = info.getSourceClass() + cName;
			}
			int pos = cName.lastIndexOf('.');
			if (info.isTimer()) {
				return "\t" + "timer:" + cName.substring(pos + 1);
			}
			return "\t" + (info.isSync() ? "sync: " : "async: ")
					+ cName.substring(pos + 1);
		} else if (eobject != null && eobject instanceof JobInfo) {
			JobInfo jobInfo = (JobInfo) eobject;
			String cName = jobInfo.getJobClassName();
			if (cName == null || cName.startsWith("$")) {
				cName = jobInfo.getSourceClass() + cName;
			}
			int pos = cName.lastIndexOf('.');
			return "\t" + "job: " + cName.substring(pos + 1);
		} /*
		 * else if (teslaInfo != null) { String name = teslaInfo.getName(); int
		 * pos = name.lastIndexOf('.'); return "\t" +"cmd: " +
		 * name.substring(pos + 1); }
		 */

		return "    " + source.getName();
	}

	private int calcPos(long minTime, long allTime, long time) {
		return (int) (getTimeWidth() * (1.0f * (time - minTime) / allTime));
	}

	public void setShowTasks(boolean includeTasks2) {
		includeTasks = includeTasks2;
		internalUpdate(nodes);
	}
}
