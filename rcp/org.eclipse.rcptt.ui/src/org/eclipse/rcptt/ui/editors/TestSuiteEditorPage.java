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
package org.eclipse.rcptt.ui.editors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ITestSuite;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.AllProjectScope;
import org.eclipse.rcptt.core.model.search.ISearchScope;
import org.eclipse.rcptt.core.scenario.TestSuite;
import org.eclipse.rcptt.core.scenario.TestSuiteItem;
import org.eclipse.rcptt.internal.core.model.ReferencedProjectScope;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.commons.TestSuiteTableViewer;
import org.eclipse.rcptt.ui.controls.SectionWithComposite;
import org.eclipse.rcptt.ui.controls.TestSuiteButtonsPanel;
import org.eclipse.rcptt.ui.tags.SelectTagsFilterDialog;
import org.eclipse.rcptt.ui.utils.WorkbenchUtils;

public class TestSuiteEditorPage extends NamedElementEditorPage {

	private TestSuiteTableViewer testCasesviewer;
	private TestSuiteButtonsPanel suiteButtonsPanel;
	private boolean needCheckReferences = true;

	public TestSuiteEditorPage(NamedElementEditor editor) {
		super(editor, "test.suite", Messages.TestSuiteEditorPage_Name); //$NON-NLS-1$
	}

	@Override
	public ITestSuite getModel() {
		return (ITestSuite) super.getModel();
	}

	@Override
	public TestSuite getElement() {
		return (TestSuite) super.getElement();
	}

	public TestSuiteTableViewer getTestCasesviewer() {
		return testCasesviewer;
	}

	@Override
	protected void createSpecificContent(Composite parent, FormToolkit toolkit,
			IManagedForm form) {
		Section testCasesSection = new SectionWithComposite("Test Cases",
				Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED)
				.numColumns(2).create(parent, toolkit);
		Composite testCasesComposite = (Composite) testCasesSection.getClient();

		createSuiteTable(testCasesComposite);

		suiteButtonsPanel = new TestSuiteButtonsPanel(testCasesComposite, true);
		addButtonsListeners();

		testCasesviewer.setInput(getElement().getItems());
		suiteButtonsPanel.updateButtons(testCasesviewer);

		suiteButtonsPanel.getResetOrderLink().setVisible(
				getElement().isManuallyOrdered());
	}

	private void createSuiteTable(Composite parent) {
		testCasesviewer = new TestSuiteTableViewer(parent, getModel(),
				getElement());

		testCasesviewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						suiteButtonsPanel.updateButtons(testCasesviewer);
					}
				});

		testCasesviewer.getTestSuiteObservable().addChangeListener(
				new IChangeListener() {
					public void handleChange(ChangeEvent event) {
						if (needCheckReferences) {
							getEditor().checkMissingReferences();
						}
						suiteButtonsPanel.updateButtons(testCasesviewer);
					}
				});

		if (!getElement().isManuallyOrdered())
			testCasesviewer.setComparator(new TestSuiteComparator());
	}

	private void addButtonsListeners() {
		suiteButtonsPanel.getAddTestCaseBtn().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						addTestCase();
						refreshPage();
					}
				});
		suiteButtonsPanel.getAddFolderBtn().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						addFolder();
						refreshPage();
					}
				});
		suiteButtonsPanel.getAddTaggedBtn().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						addTagged();
						refreshPage();
					}
				});
		suiteButtonsPanel.getRemoveBtn().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						testCasesviewer.handleRemove();
						refreshPage();
					}
				});
		suiteButtonsPanel.getRemoveAllBtn().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						testCasesviewer.removeAll();
						refreshPage();
					}
				});

		suiteButtonsPanel.getMoveUpBtn().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						if (!getElement().isManuallyOrdered()) {
							getElement().setManuallyOrdered(true);
							suiteButtonsPanel.getResetOrderLink()
									.setVisible(true);
						}

						testCasesviewer.moveUp();
						suiteButtonsPanel.updateButtons(testCasesviewer);
					}
				});
		suiteButtonsPanel.getMoveDownBtn().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						if (!getElement().isManuallyOrdered()) {
							getElement().setManuallyOrdered(true);
							suiteButtonsPanel.getResetOrderLink()
									.setVisible(true);
						}

						testCasesviewer.moveDown();
						suiteButtonsPanel.updateButtons(testCasesviewer);
					}
				});
		suiteButtonsPanel.getResetOrderLink().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						if (getElement().isManuallyOrdered()) {
							getElement().setManuallyOrdered(false);
							suiteButtonsPanel.getResetOrderLink()
									.setVisible(false);
						}
						testCasesviewer
								.setComparator(new TestSuiteComparator());
						suiteButtonsPanel.updateButtons(testCasesviewer);
					}
				});
	}

	private void addTestCase() {
		try {
			needCheckReferences = false;
			List<IQ7NamedElement> excluded = new ArrayList<IQ7NamedElement>();
			excluded.add(getModel());
			List<TestSuiteItem> testcases = testCasesviewer.getTestcases();
			for (TestSuiteItem testSuiteItem : testcases) {
				try {
					IQ7NamedElement[] case1 = getModel()
							.getQ7Project()
							.findNamedElement(testSuiteItem.getNamedElementId());
					if (case1 != null && case1.length > 0) {
						excluded.addAll(Arrays.asList(case1));
					}
				} catch (ModelException e) {
					Q7UIPlugin.log(e);
				}
			}
			IQ7NamedElement[] selected = TestSuiteButtonsPanel.selectTestCase(
					getSearchScope(), excluded, true);

			for (int i = 0; i < selected.length; i++) {
				testCasesviewer.addItem(selected[i]);
			}
		} finally {
			needCheckReferences = true;
		}
	}

	private void addFolder() {
		try {
			needCheckReferences = false;
			IContainer container = TestSuiteButtonsPanel.selectFolder();
			if (container != null) {
				testCasesviewer.addFolder(container);
				getEditor().checkMissingReferences();
			}
		} finally {
			needCheckReferences = true;
		}
	}

	private void addTagged() {
		try {
			needCheckReferences = false;
			SelectTagsFilterDialog dialog = new SelectTagsFilterDialog(WorkbenchUtils.getShell());
			int result = dialog.open();
			if (result == SelectTagsFilterDialog.OK) {
				testCasesviewer.addTags(dialog.getSelectedTags());
				testCasesviewer.addItems(dialog.getSelectedItems());
			}
			
		} finally {
			needCheckReferences = true;
		}
	}

	private ISearchScope getSearchScope() {
		IQ7Project testSuiteProject = getModel().getQ7Project();
		ISearchScope scope = testSuiteProject != null ? new ReferencedProjectScope(
				testSuiteProject) : new AllProjectScope();
		return scope;
	}

	public void refreshPage() {
		testCasesviewer.refresh();
		suiteButtonsPanel.updateButtons(testCasesviewer);
		suiteButtonsPanel.getResetOrderLink().setVisible(
				getElement().isManuallyOrdered());
	}

	@Override
	protected void record() {
		// No need for test suit
	}

	public void updateContent() {
		testCasesviewer.updateItems();
	}

	@Override
	protected EditorHeader createHeader() {
		return new EditorHeader(getModel(), getElement()) {

			protected Button createRecordButton(Composite composite,
					FormToolkit toolkit) {
				Button button = toolkit.createButton(composite,
						Messages.TestSuiteEditorPage_ExecuteButton, SWT.PUSH);
				button.setImage(DebugUITools.getImageDescriptor(
						IDebugUIConstants.IMG_ACT_RUN).createImage());
				button.setBackground(null);
				GridDataFactory.fillDefaults().applyTo(button);
				button.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(final SelectionEvent e) {
						if ((e.stateMask & SWT.SHIFT) != 0)
							multiReplay();
						else
							replay();
					}
				});
				return button;
			}

			protected Button createReplayButton(Composite composite,
					FormToolkit toolkit) {
				// new Label(composite, SWT.NONE);
				return null;
			}

			@Override
			protected void record() {
				// TODO Auto-generated method stub

			}

			@Override
			protected int getTagsSpacing() {
				return 3;
			}
		};
	}

	private class TestSuiteComparator extends ViewerComparator {
		@Override
		public int category(Object element) {
			if (element instanceof TestSuiteItem) {
				String id = ((TestSuiteItem) element).getNamedElementId();
				try {
					IQ7NamedElement[] case1 = getModel().getQ7Project()
							.findNamedElement(id);
					for (IQ7NamedElement iq7NamedElement : case1) {
						if (iq7NamedElement instanceof ITestSuite) {
							return 1;
						}
						if (iq7NamedElement instanceof ITestCase) {
							return 0;
						}
					}
				} catch (CoreException e) {
					Q7UIPlugin.log(e);
				}
			}
			return super.category(element);
		}

		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			int cat1 = category(e1);
			int cat2 = category(e2);

			if (cat1 != cat2) {
				return cat1 - cat2;
			}
			if (e1 instanceof TestSuiteItem && e2 instanceof TestSuiteItem) {
				String id1 = ((TestSuiteItem) e1).getNamedElementId();
				String id2 = ((TestSuiteItem) e2).getNamedElementId();
				try {
					IQ7NamedElement[] case1 = getModel().getQ7Project()
							.findNamedElement(id1);
					IQ7NamedElement[] case2 = getModel().getQ7Project()
							.findNamedElement(id2);
					if (case1 != null && case2 != null && case1.length > 0
							&& case2.length > 0) {
						return case1[0].getElementName().compareTo(
								case2[0].getElementName());
					}

				} catch (CoreException e) {
					Q7UIPlugin.log(e);
				}
			}
			return super.compare(viewer, e1, e2);
		}
	}
}
