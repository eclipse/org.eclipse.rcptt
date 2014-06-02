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

import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ResultStatus;
import org.eclipse.rcptt.reporting.core.IQ7ReportConstants;
import org.eclipse.rcptt.reporting.core.Q7ReportIterator;
import org.eclipse.rcptt.reporting.internal.ReportUtils;
import org.eclipse.rcptt.ui.controls.AbstractEmbeddedComposite;
import org.eclipse.rcptt.ui.launching.TimeFormatHelper;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.reporting.SimpleReportGenerator;

public class TestCasesComposite extends AbstractEmbeddedComposite {
	private class ReportEntry {
		public String name;
		public String id;
		public int time;
		public String status;
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
				return entry.status;
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

	@Override
	protected void fillActions(IToolBarManager manager) {
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
				re.status = info.getResult().getLiteral();
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

		TableViewer viewer = new TableViewer(control, SWT.H_SCROLL
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
	}

	protected void doSelection(String id, String name, String msg) {
	}

	protected void doOpen(String id, String title) {

	}

	public Control getControl() {
		return control;
	}

}
