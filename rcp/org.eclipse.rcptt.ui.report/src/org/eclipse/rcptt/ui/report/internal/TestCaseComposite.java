/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
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
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.core.IQ7ReportConstants;
import org.eclipse.rcptt.reporting.core.SimpleSeverity;
import org.eclipse.rcptt.reporting.core.TimeFormatHelper;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.ui.controls.AbstractEmbeddedComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

public class TestCaseComposite extends AbstractEmbeddedComposite {

	private Composite control;
	private Report report;

	private class ReportEntryLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			Node entry = (Node) element;
			Q7Info object = (Q7Info) entry.getProperties().get(
					IQ7ReportConstants.ROOT);
			if (object != null) {
				SimpleSeverity severity = SimpleSeverity.create(object);
				switch (object.getType()) {
				case SCRIPT:
				case TESTCASE:
					if (severity == SimpleSeverity.OK)
						return Images.getImage(Images.SCENARIO_PASS);
					if (severity == SimpleSeverity.CANCEL)
						return Images.getImage(Images.SCENARIO);
					return Images.getImage(Images.SCENARIO_FAIL);
				case CONTEXT:
					if (severity == SimpleSeverity.OK)
						return Images.getImage(Images.CONTEXT_PASS);
					if (severity == SimpleSeverity.CANCEL)
						return Images.getImage(Images.CONTEXT);
					return Images.getImage(Images.CONTEXT_FAIL);
				case VERIFICATION:
					if (severity == SimpleSeverity.OK)
						return Images.getImage(Images.VERIFICATION_PASS);
					if (severity == SimpleSeverity.CANCEL)
						return Images.getImage(Images.VERIFICATION);
					return Images.getImage(Images.VERIFICATION_FAIL);
				case ECL_COMMAND:
					if (severity == SimpleSeverity.OK)
						return Images.getImage(Images.ECL_COMMAND);
					if (severity == SimpleSeverity.CANCEL)
						return Images.getOverlayImageBottomLeft(
								Images.ECL_COMMAND, Images.OVERLAY_WARNING);
					return Images.getOverlayImageBottomLeft(Images.ECL_COMMAND, Images.OVERLAY_ERROR);
				case TEST_SUITE:
					if (severity == SimpleSeverity.OK)
						return Images.getImage(Images.EXECUTION_SESSION_OK);
					if (severity == SimpleSeverity.CANCEL)
						return Images.getImage(Images.EXECUTION_SESSION_STOP);
					return Images.getImage(Images.EXECUTION_SESSION_FAIL);
				}
			}
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			Node entry = (Node) element;
			Q7Info object = (Q7Info) entry.getProperties().get(
					IQ7ReportConstants.ROOT);
			switch (columnIndex) {
			case 0:// name
				return entry.getName();
			case 1:// status
				if (object != null) {
					return SimpleSeverity.create(object.getResult()).name();
				}
				return "";
			case 2:// time
				return TimeFormatHelper.format(entry.getEndTime()
						- entry.getStartTime());
				// case 3:// location
				// return entry.location;
			}
			return null;
		}
	}

	private class ReportEntryContentProvider implements ITreeContentProvider {
		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getElements(Object inputElement) {
			return new Object[] { report.getRoot() };
		}

		public Object[] getChildren(Object parentElement) {
			Node nde = (Node) parentElement;
			return nde.getChildren().toArray();
		}

		public Object getParent(Object element) {
			Node nde = (Node) element;
			return nde.getParent();
		}

		public boolean hasChildren(Object element) {
			Node nde = (Node) element;
			return !nde.getChildren().isEmpty();
		}
	};

	@Override
	protected void fillActions(IToolBarManager manager) {
	}

	public TestCaseComposite(Report report) {
		this.report = report;
	}

	public String getName() {
		return report.getRoot().getName();
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

		TreeViewer viewer = new TreeViewer(control, SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
		Tree tree = viewer.getTree();
		tree.setHeaderVisible(true);
		GridDataFactory.fillDefaults().grab(true, true).hint(SWT.DEFAULT, 100)
				.applyTo(viewer.getControl());
		TreeColumn testcaseColumn = new TreeColumn(tree, SWT.NONE);
		testcaseColumn.setText("Test case");
		testcaseColumn.setWidth(200);

		TreeColumn statusColumn = new TreeColumn(tree, SWT.NONE);
		statusColumn.setText("Status");
		statusColumn.setWidth(80);

		TreeColumn timeColumn = new TreeColumn(tree, SWT.NONE);
		timeColumn.setText("Time");
		timeColumn.setWidth(80);

		viewer.setLabelProvider(new ReportEntryLabelProvider());
		viewer.setContentProvider(new ReportEntryContentProvider());
		viewer.setInput(report);

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
				List<Node> nodes = new ArrayList<Node>();
				Iterator<?> i = selection.iterator();
				while (i.hasNext()) {
					addNodes(nodes, (Node) i.next());
				}
				doNodesSelection(nodes);
			}

			private void addNodes(List<Node> nodes, Node next) {
				if (!nodes.contains(next)) {
					nodes.add(next);
				}
			}
		});

		viewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection thisSelection = (IStructuredSelection) event.getSelection();
				Object selectedNode = thisSelection.getFirstElement();
				if (selectedNode == null || !(selectedNode instanceof Node)) {
					return;
				}

				Node node = (Node) selectedNode;
				Q7Info info = (Q7Info) node.getProperties().get(IQ7ReportConstants.ROOT);
				if (info == null) {
					return;
				}
				String id = info.getId();
				IQ7NamedElement element = Q7SearchCore.findById(id);
				if (element == null) {
					return;
				}

				try {
					IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
							(IFile) element.getResource());
				} catch (PartInitException e) {
					// Do nothing
				}
			}
		});

	}

	protected void doNodesSelection(List<Node> nodes) {

	}

	public Control getControl() {
		return control;
	}

}
