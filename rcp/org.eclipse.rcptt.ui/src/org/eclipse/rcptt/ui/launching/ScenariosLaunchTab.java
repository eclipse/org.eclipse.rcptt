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
package org.eclipse.rcptt.ui.launching;

import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Iterables.toArray;
import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.search.AllProjectScope;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.model.OneProjectScope;
import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.launching.Aut;
import org.eclipse.rcptt.launching.AutManager;
import org.eclipse.rcptt.launching.IQ7Launch;
import org.eclipse.rcptt.launching.Q7Launcher;
import org.eclipse.rcptt.launching.utils.TestSuiteUtils;
import org.eclipse.rcptt.ui.commons.ColumnViewerSorter;
import org.eclipse.rcptt.ui.controls.TestSuiteButtonsPanel;
import org.eclipse.rcptt.ui.utils.ModelUtils;

public class ScenariosLaunchTab extends AbstractLaunchConfigurationTab {
	private static final String NOTHING_SELECTED = ""; 
	
	private TableViewer viewer;
	private ComboViewer autCombo;

	private final List<ITableElement> elements = new ArrayList<ITableElement>();

	TestSuiteButtonsPanel testSuiteButtonsPanel;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse
	 * .swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		setControl(composite);

		GridLayout topLayout = new GridLayout();
		topLayout.numColumns = 2;
		composite.setLayout(topLayout);

		createSuitTable(composite);
		createPanel(composite);
		validatePage();
	}

	private void createSuitTable(Composite parent) {
		viewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.MULTI);
		GridData tableGridData = new GridData(GridData.FILL_BOTH);
		tableGridData.widthHint = 1;
		viewer.getTable().setLayoutData(tableGridData);
		viewer.getTable().setLinesVisible(true);
		viewer.getTable().setHeaderVisible(true);
		viewer.setContentProvider(new TableContentProvider());
		createTableColumns();
	}

	private void createTableColumns() {
		final TableViewerColumn columnTestCase = new TableViewerColumn(viewer,
				SWT.NONE);
		columnTestCase.getColumn().setText(
				Messages.ScenariosLaunchTab_ColumnTestCaseText);
		columnTestCase.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(Object element) {
				return ((NamedTableElement) element).getImage();
			}

			@Override
			public String getText(Object element) {
				return ((NamedTableElement) element).getText();
			}
		});

		final TableViewerColumn columnLocation = new TableViewerColumn(viewer,
				SWT.NONE);
		columnLocation.getColumn().setText(
				Messages.ScenariosLaunchTab_ColumnLocationText);
		columnLocation.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((NamedTableElement) element).getPath();
			}
		});

		viewer.getTable().addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				int width = viewer.getTable().getClientArea().width;
				int testCaseColWidth = columnTestCase.getColumn().getWidth();
				int locationColWidth = columnLocation.getColumn().getWidth();
				double ratio = 0.5;
				if (testCaseColWidth != 0 && locationColWidth != 0) {
					ratio = (double) testCaseColWidth
							/ (testCaseColWidth + locationColWidth);
				}
				columnTestCase.getColumn().setWidth((int) (width * ratio));
				columnLocation.getColumn()
						.setWidth((int) (width * (1 - ratio)));
			}
		});

		new ColumnViewerSorter(viewer, columnTestCase) {

			@Override
			protected int doCompare(Viewer viewer, Object element1,
					Object element2) {
				NamedTableElement named1 = (NamedTableElement) element1;
				NamedTableElement named2 = (NamedTableElement) element2;
				return named1.getText().compareToIgnoreCase(named2.getText());
			}

			@Override
			protected void afterSort() {
				reorderSourceList();
			}

		};

		new ColumnViewerSorter(viewer, columnLocation) {

			@Override
			protected int doCompare(Viewer viewer, Object element1,
					Object element2) {
				NamedTableElement named1 = (NamedTableElement) element1;
				NamedTableElement named2 = (NamedTableElement) element2;
				return named1.getPath().compareToIgnoreCase(named2.getPath());
			}

			@Override
			protected void afterSort() {
				reorderSourceList();
			}

		};

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				testSuiteButtonsPanel.updateButtons(viewer);
			}
		});
	}

	private void createPanel(Composite parent) {
		testSuiteButtonsPanel = new TestSuiteButtonsPanel(parent, false);

		testSuiteButtonsPanel.getAddTestCaseBtn().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						addTestCase();
					}
				});

		testSuiteButtonsPanel.getAddFolderBtn().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						addFolder();
					}
				});

		testSuiteButtonsPanel.getRemoveBtn().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						removeSelected();
					}
				});

		testSuiteButtonsPanel.getRemoveAllBtn().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						removeAll();
					}
				});

		testSuiteButtonsPanel.getMoveUpBtn().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						moveUp();
					}
				});

		testSuiteButtonsPanel.getMoveDownBtn().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						moveDown();
					}
				});

		testSuiteButtonsPanel.getAddTaggedBtn().addSelectionListener(
				new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						addTagged();
					}
				});

		new Label(testSuiteButtonsPanel, SWT.HORIZONTAL | SWT.SEPARATOR);
		//TODO: make the label closer to combo
		Label label = new Label(testSuiteButtonsPanel, SWT.BOTTOM);
		label.setText("AUT:");
		autCombo = createAutCombo(testSuiteButtonsPanel);
		
	}

	private ComboViewer createAutCombo(Composite parent) {
		ComboViewer autCombo = new ComboViewer(parent);
		autCombo.setContentProvider(new ArrayContentProvider());
		autCombo.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Aut) {
					return ((Aut) element).getName();
				}
				return super.getText(element);
			}
		});
		autCombo.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateLaunchConfigurationDialog();
			}
		});
		autCombo.setInput(toArray(concat(asList(NOTHING_SELECTED), AutManager.INSTANCE.getAuts()), Object.class));
		return autCombo;
	}

	private void addTestCase() {
		List<IQ7NamedElement> excluded = new ArrayList<IQ7NamedElement>();
		for (ITableElement element : elements) {
			excluded.add(element.getElement());
		}
		IQ7NamedElement[] selected = TestSuiteButtonsPanel.selectTestCase(
				new AllProjectScope(), excluded, true);
		for (int i = 0; i < selected.length; i++) {
			elements.add(new NamedTableElement(selected[i]));
		}
		sourceListChanged();
	}

	private void addFolder() {
		IContainer container = TestSuiteButtonsPanel.selectFolder();

		if (container != null) {
			IPath fullPath = container.getFullPath();
			IQ7NamedElement[] allElements = Q7SearchCore
					.findAllElements(new OneProjectScope(RcpttCore
							.create(container.getProject())));

			for (int i = 0; i < allElements.length; i++) {
				IQ7NamedElement el = allElements[i];
				if (el instanceof ITestCase
						&& fullPath.isPrefixOf(el.getPath())) {
					if (!isElementInList(el)) {
						elements.add(new NamedTableElement(el));
					}
				}
			}
		}
		sourceListChanged();
	}

	private void addTagged() {
		List<IQ7NamedElement> excluded = new ArrayList<IQ7NamedElement>();
		for (ITableElement element : elements) {
			excluded.add(element.getElement());
		}

		IQ7NamedElement[] filteredByTags = TestSuiteButtonsPanel.selectTags(new AllProjectScope(), excluded, true);
		for (int i = 0; i < filteredByTags.length; i++) {
			elements.add(new NamedTableElement(filteredByTags[i]));
		}

		sourceListChanged();
	}

	private void removeSelected() {
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		List<?> selectedElements = selection.toList();
		elements.removeAll(selectedElements);
		sourceListChanged();
	}

	private void removeAll() {
		elements.clear();
		sourceListChanged();
	}

	private void moveUp() {
		resetTableSort();
		Table table = viewer.getTable();
		int indices[] = table.getSelectionIndices();
		int newSelection[] = new int[indices.length];
		for (int i = 0; i < indices.length; i++) {
			int index = indices[i];
			if (index > 0) {
				swapElements(index, index - 1);
				newSelection[i] = index - 1;
			} else if (index == 0) {
				newSelection[i] = 0;
			}
		}
		sourceListChanged();
		table.setSelection(newSelection);
		testSuiteButtonsPanel.updateButtons(viewer);
	}

	private void moveDown() {
		resetTableSort();
		Table table = viewer.getTable();
		int[] indices = table.getSelectionIndices();
		if (indices.length < 1) {
			return;
		}
		int newSelection[] = new int[indices.length];
		int max = table.getItemCount() - 1;
		for (int i = indices.length - 1; i >= 0; i--) {
			int index = indices[i];
			if (index < max) {
				swapElements(index, index + 1);
				newSelection[i] = index + 1;
			} else if (index == max) {
				newSelection[i] = max;
			}
		}
		sourceListChanged();
		table.setSelection(newSelection);
		testSuiteButtonsPanel.updateButtons(viewer);
	}

	private void swapElements(int a, int b) {
		ITableElement aElement = elements.get(a);
		ITableElement bElement = elements.get(b);
		elements.set(a, bElement);
		elements.set(b, aElement);
	}

	private void resetTableSort() {
		viewer.getTable().setSortColumn(null);
		viewer.getTable().setSortDirection(ColumnViewerSorter.NONE);
		viewer.setSorter(null);
	}

	private void sourceListChanged() {
		viewer.refresh();
		validatePage();
		updateLaunchConfigurationDialog();
		testSuiteButtonsPanel.updateButtons(viewer);
	}

	private void reorderSourceList() {
		elements.clear();
		for (int i = 0; i < viewer.getTable().getItemCount(); i++) {
			elements.add((ITableElement) viewer.getElementAt(i));
		}
		validatePage();
		updateLaunchConfigurationDialog();
	}

	private boolean isElementInList(IQ7NamedElement namedElement) {
		if (namedElement == null) {
			return true;
		}
		for (ITableElement element : elements) {
			if (element.getElement().equals(namedElement)) {
				return true;
			}
		}
		return false;
	}

	private void buildElements(IResource[] resources) {
		elements.clear();
		if (resources != null) {
			for (IResource resource : resources) {
				if (resource != null && resource.exists()) {
					try {
						ITableElement element = buildElement(resource);
						if (element != null) {
							elements.add(element);
						}
					} catch (Exception e) {
						// ignore exceptions
					}
				}
			}
		}
		viewer.setInput(elements);
		testSuiteButtonsPanel.updateButtons(viewer);
	}

	private ITableElement buildElement(IResource res) {
		try {
			if (res instanceof IFile) {
				IFile file = (IFile) res;
				IQ7Element element = RcpttCore.create(file);
				if (element != null && element instanceof IQ7NamedElement) {
					return new NamedTableElement((IQ7NamedElement) element);
				}
			}
		} catch (Exception e) {
			// any exceptions mean there is no tree elements
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse
	 * .debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration config) {
		IResource[] resources = null;
		Aut aut = null;
		try {
			int resourceCount = config.getAttribute(IQ7Launch.EXEC_RESOURCES,
					-1);
			resources = config.getMappedResources();
			if (resourceCount > 0) {
				IResource[] subarray = new IResource[resourceCount];
				System.arraycopy(resources, 0, subarray, 0, Math.min(resourceCount, resources.length));
				resources = subarray;
			}
			String autName = config.getAttribute(IQ7Launch.ATTR_BOUND_AUT_NAME, "");
			aut = AutManager.INSTANCE.getByName(autName);
		} catch (CoreException e) {
			Q7LaunchingPlugin.log(e);
		}
		buildElements(resources);
		setSelectedAut(aut);
		validatePage();
	}

	private void setSelectedAut(Aut aut) {
		Object toSelect = aut;
		if (toSelect == null)
			toSelect = NOTHING_SELECTED;
		autCombo.setSelection(new StructuredSelection(toSelect));
	}
	
	private Aut getSelectedAut() {
		if (autCombo == null)
			return null;
		IStructuredSelection selection = (IStructuredSelection) autCombo.getSelection() ;
		Object selected = selection.getFirstElement();
		if (selected instanceof Aut)
			return (Aut) selected;
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse
	 * .debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy config) {
		List<IResource> resources = new ArrayList<IResource>();
		for (ITableElement element : elements) {
			resources.add(element.getResource());
		}
		config.setMappedResources(resources.toArray(new IResource[resources
				.size()]));
		config.setAttribute(IQ7Launch.EXEC_RESOURCES, resources.size());
		// Set ATTR_NO_SORT to true to prevent sorting list in execution view
		config.setAttribute(IQ7Launch.ATTR_NO_SORT, true);
		Aut aut = getSelectedAut();
		config.setAttribute(IQ7Launch.ATTR_BOUND_AUT_NAME, aut == null ? null : aut.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	@Override
	public Image getImage() {
		return Images.getImage(Images.CONTEXT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse
	 * .debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration config) {
		validatePage();
		return getErrorMessage() == null;
	}

	private void validatePage() {
		setErrorMessage(null);
		setMessage(null);

		if (viewer.getTable().getItemCount() == 0) {
			setErrorMessage(Messages.ScenariosLaunchTab_NothingSelectedMsg);
			return;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.
	 * debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy config) {
		IResource[] resources = LaunchUtils.getContext();
		IQ7NamedElement[] elements = TestSuiteUtils
				.getElements(resources, false);
		String name = Q7Launcher.getLaunchName(elements);
		config.setMappedResources(resources);
		initializeName(config, name);
		config.setAttribute(IQ7Launch.ATTR_NO_SORT, true);
		config.setAttribute(IQ7Launch.ATTR_AUT_NAME, "");
	}

	private void initializeName(ILaunchConfigurationWorkingCopy config,
			String name) {
		int index = name.lastIndexOf('.');
		if (index > 0) {
			name = name.substring(index + 1);
		}
		name = getLaunchConfigurationDialog().generateName(name);
		config.rename(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return Messages.ScenariosLaunchTab_Name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getId()
	 */
	@Override
	public String getId() {
		return "org.eclipse.rcptt.ui.launching.ScenariosLaunchTab"; //$NON-NLS-1$
	}

	private final WorkbenchLabelProvider wbLabelProvider = new WorkbenchLabelProvider();

	@Override
	public void dispose() {
		super.dispose();
		wbLabelProvider.dispose();
	}

	private class TableContentProvider implements IStructuredContentProvider {

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List<?>) {
				return ((List<?>) inputElement).toArray();
			}

			return ITableElement.EMPTY;
		}
	}

	private interface ITableElement {

		public static ITableElement[] EMPTY = new ITableElement[0];

		public IResource getResource();

		public IQ7NamedElement getElement();

		public Image getImage();

		public String getText();

		public String getPath();
	}

	private class NamedTableElement implements ITableElement {

		private final IQ7NamedElement element;

		public NamedTableElement(IQ7NamedElement element) {
			this.element = element;
		}

		public IResource getResource() {
			return element.getResource();
		}

		public IQ7NamedElement getElement() {
			return element;
		}

		public Image getImage() {
			return ModelUtils.getImage(element);
		}

		public String getText() {
			return ModelUtils.getText(element);
		}

		public String getPath() {
			return getResource().getProject().getName()
					+ "/" //$NON-NLS-1$
					+ getResource().getProjectRelativePath()
							.removeLastSegments(1).toString();
		}
	}
}
