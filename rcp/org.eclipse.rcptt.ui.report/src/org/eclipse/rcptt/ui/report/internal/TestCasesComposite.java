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
package org.eclipse.rcptt.ui.report.internal;

import static com.google.common.base.Predicates.notNull;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.transform;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ResultStatus;
import org.eclipse.rcptt.reporting.core.IQ7ReportConstants;
import org.eclipse.rcptt.reporting.core.Q7ReportIterator;
import org.eclipse.rcptt.reporting.internal.ReportUtils;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.reporting.SimpleReportGenerator;
import org.eclipse.rcptt.ui.actions.AbstractRunAction;
import org.eclipse.rcptt.ui.actions.AbstractRunFailedAction;
import org.eclipse.rcptt.ui.controls.AbstractEmbeddedComposite;
import org.eclipse.rcptt.ui.launching.LaunchUtils;
import org.eclipse.rcptt.ui.launching.TimeFormatHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

public class TestCasesComposite extends AbstractEmbeddedComposite {
	private class ReportEntry {
		public String name;
		public String id;
		public int time;
		public ResultStatus status;
		public String message;
		public boolean warning = false;
	}

	private Composite control;
	private Q7ReportIterator iterator;
	private List<ReportEntry> entries = new ArrayList<ReportEntry>();

	private class ReportEntryLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			ReportEntry entry = (ReportEntry) element;
			if (columnIndex == 0) {
				if (entry.status.equals(ResultStatus.FAIL.getLiteral())) {
					return Images.getImage(Images.SCENARIO_FAIL);
				}
				if (entry.status.equals(ResultStatus.PASS.getLiteral())) {
					return Images.getImage(Images.SCENARIO_PASS);
				}
				if (entry.status.equals(ResultStatus.SKIPPED.getLiteral())) {
					return Images.getImage(Images.SCENARIO);
				}
			}
			if (columnIndex == 3) {
				if (entry.warning) {
					return PlatformUI.getWorkbench().getSharedImages()
							.getImage(ISharedImages.IMG_OBJS_WARN_TSK);
				}
			}

			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			ReportEntry entry = (ReportEntry) element;
			switch (columnIndex) {
			case 0:// name
				return entry.name;
			case 1:// status
				return entry.status.getLiteral();
			case 2:// time
				return TimeFormatHelper.format(entry.time);
				// case 3:// location
				// return entry.message.isEmpty() ? "" : "Has details";
			}
			return "";
		}
	}

	private class ReportEntryContentProvider implements
			IStructuredContentProvider {
		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getElements(Object inputElement) {
			return entries.toArray();
		}
	};

	private final static Function<ReportEntry, String> toId = new Function<ReportEntry, String>() {
		@Override
		public String apply(ReportEntry input) {
			return input.id;
		}
	};

	private final static Function<ReportEntry, ResultStatus> reportToStatus = new Function<ReportEntry, ResultStatus>() {
		@Override
		public ResultStatus apply(ReportEntry input) {
			return input.status;
		}
	};

	private final static Function<String, IQ7NamedElement> elementById = new Function<String, IQ7NamedElement>() {
		@Override
		public IQ7NamedElement apply(String input) {
			return Q7SearchCore.findById(input);
		}
	};

	private final static Function<IQ7NamedElement, IResource> resourceFromElement = new Function<IQ7NamedElement, IResource>() {
		@Override
		public IResource apply(IQ7NamedElement input) {
			return input.getResource();
		}
	};

	private final BaseSelectionListenerAction runAction = new AbstractRunAction() {

		@Override
		public void run() {
			final Iterable<ReportEntry> reports = filter(filter(getStructuredSelection().toList(), ReportEntry.class),
					notNull());
			final Iterable<String> ids = filter(transform(reports, toId), notNull());
			final Iterable<IQ7NamedElement> elements = filter(transform(ids, elementById), notNull());
			final Iterable<IResource> resources = transform(elements, resourceFromElement);
			LaunchUtils.launchContext(Iterables.toArray(resources, IResource.class), "run");
		}

	};
	private final BaseSelectionListenerAction runFailedAction = new AbstractRunFailedAction() {

		@Override
		public void run() {
			final Iterable<ReportEntry> reports = filter(
					filter((List<?>) viewer.getInput(), ReportEntry.class),
					Predicates.and(notNull(), Predicates.compose(Predicates.equalTo(ResultStatus.FAIL), reportToStatus)));
			final Iterable<String> ids = filter(transform(reports, toId), notNull());
			final Iterable<IQ7NamedElement> elements = filter(transform(ids, elementById), notNull());
			final Iterable<IResource> resources = transform(elements, resourceFromElement);
			LaunchUtils.launchContext(Iterables.toArray(resources, IResource.class), "run");
		}

	};
	private TableViewer viewer;
	@Override
	protected void fillActions(IToolBarManager manager) {
		manager.add(runAction);
		manager.add(runFailedAction);
	}

	public TestCasesComposite(Q7ReportIterator iterator) {
		this.iterator = iterator;
		this.iterator.reset();
		while (this.iterator.hasNext()) {
			Report next = this.iterator.next();
			if (next == null) {
				break;
			}
			ReportEntry re = new ReportEntry();
			Node root = next.getRoot();
			re.name = root.getName();
			re.time = (int) (root.getEndTime() - root.getStartTime());
			EMap<String, EObject> properties = root.getProperties();
			Q7Info info = (Q7Info) properties.get(IQ7ReportConstants.ROOT);

			if (info != null) {
				StringBuilder details = new StringBuilder();
				String fail = ReportUtils.getFailMessage(root);
				if (fail.length() > 0) {
					details.append(fail).append("\n");
				}
				ReportUtils.collectDetails(root, details);
				if( details.length() > 0) {
					re.warning = true;
				}
				re.message = new SimpleReportGenerator().generateContent(next);//details.toString();
				re.status = info.getResult();
				re.id = info.getId();
				entries.add(re);
			}
		}
	}

	public String getName() {
		return "Test cases";
	}

	public Image getImage() {
		return Images.getImage(Images.FILE);
	}

	public void createControl(Composite parent) {
		super.createControl(parent);

		control = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(control);
		GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(false)
				.applyTo(control);

		viewer = new TableViewer(control, SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION
				| SWT.DOUBLE_BUFFERED);
		Table table = viewer.getTable();
		table.setHeaderVisible(true);
		GridDataFactory.fillDefaults().grab(true, true).hint(SWT.DEFAULT, 100)
				.applyTo(viewer.getControl());
		TableColumn testcaseColumn = new TableColumn(table, SWT.NONE);
		testcaseColumn.setText("Test case");
		testcaseColumn.setWidth(400);

		TableColumn statusColumn = new TableColumn(table, SWT.NONE);
		statusColumn.setText("Status");
		statusColumn.setWidth(60);

		TableColumn timeColumn = new TableColumn(table, SWT.NONE);
		timeColumn.setText("Time");
		timeColumn.setWidth(80);

		TableColumn detColumn = new TableColumn(table, SWT.NONE);
		detColumn.setText("Details");
		detColumn.setWidth(20);

		viewer.setLabelProvider(new ReportEntryLabelProvider());
		viewer.setContentProvider(new ReportEntryContentProvider());
		viewer.setInput(entries);

		viewer.addOpenListener(new IOpenListener() {
			public void open(OpenEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
				ReportEntry element = (ReportEntry) selection.getFirstElement();
				if (element != null) {
					doOpen(element.id, element.name);
				}
			}
		});
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
				ReportEntry element = (ReportEntry) selection.getFirstElement();
				if (element != null) {
					doSelection(element.id, element.name, element.message);
				}
			}
		});
		viewer.addSelectionChangedListener(runAction);
		viewer.addSelectionChangedListener(runFailedAction);
	}

	protected void doSelection(String id, String name, String msg) {
	}

	protected void doOpen(String id, String title) {

	}

	public Control getControl() {
		return control;
	}

}
