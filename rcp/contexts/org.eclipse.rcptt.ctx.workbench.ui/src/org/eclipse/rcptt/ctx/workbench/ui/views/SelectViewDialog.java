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
package org.eclipse.rcptt.ctx.workbench.ui.views;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.internal.dialogs.DialogUtil;

import org.eclipse.rcptt.core.ecl.core.model.GetViews;
import org.eclipse.rcptt.core.ecl.core.model.Q7CoreFactory;
import org.eclipse.rcptt.core.ecl.core.model.ViewInfo;
import org.eclipse.rcptt.core.ecl.core.model.ViewList;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.ui.commons.SearchControl;
import org.eclipse.rcptt.ui.launching.LaunchUtils;
import org.eclipse.rcptt.ui.utils.TreeViewerWildcardFilter;

@SuppressWarnings("restriction")
public class SelectViewDialog extends Dialog {

	private final DataBindingContext dbc = new DataBindingContext();

	private WritableValue selectedView = new WritableValue(null, ViewInfo.class);
	private ViewList viewList;

	private TreeViewer viewer;

	private SearchControl searchControl;

	public SelectViewDialog(Shell parentShell) throws CoreException {
		super(parentShell);
		this.viewList = getViews(parentShell);
		if (viewList == null) {
			throw new CoreException(Status.CANCEL_STATUS);
		}
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Select View");
	}

	@Override
	protected Point getInitialSize() {
		return new Point(500, 500);
	}

	public String getView() {
		return ((ViewInfo) selectedView.getValue()).getId();
	}

	@Override
	protected Control createContents(Composite parent) {
		Control control = super.createContents(parent);
		return control;
	}

	private ViewList getViews(Shell shell) throws CoreException {
		AutLaunch aut = LaunchUtils.selectAutLaunch(shell);
		if (aut == null) {
			return null;
		}

		GetViews getPerspectives = Q7CoreFactory.eINSTANCE.createGetViews();
		try {
			Object object = aut.execute(getPerspectives);
			if (!(object instanceof ViewList)) {
				throw new CoreException(
						Q7UIPlugin.createStatus("Unexpected object: " + object
								+ ". Context is expected"));
			}
			return (ViewList) object;
		} catch (InterruptedException e) {
			throw new CoreException(Q7UIPlugin.createStatus(
					"Command execution was interrupted", e));
		}
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		((GridLayout) composite.getLayout()).numColumns = 2;
		Label descriptionLabel = new Label(composite, SWT.LEFT);
		descriptionLabel.setText("Please select view from the list below");
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 2;
		descriptionLabel.setLayoutData(data);
		searchControl = new SearchControl(composite);
		searchControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		searchControl.getFilterControl().addModifyListener(
				new ModifyListener() {
					public void modifyText(ModifyEvent e) {
						viewer.expandAll();
						viewer.refresh();
					}
				});
		createWorkspaces(composite);
		applyDialogFont(composite);
		return composite;
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Control retVal = super.createButtonBar(parent);
		dbc.bindValue(SWTObservables.observeEnabled(getButton(OK)),
				selectedView, new UpdateValueStrategy(
						UpdateValueStrategy.POLICY_NEVER),
				new UpdateValueStrategy().setConverter(new Converter(
						ViewInfo.class, Boolean.class) {
					public Boolean convert(Object fromObject) {
						ViewInfo s = (ViewInfo) fromObject;
						return s != null;
					}
				}));
		return retVal;
	}

	private void createWorkspaces(Composite parent) {
		Tree tree = new Tree(parent, SWT.BORDER);
		viewer = new TreeViewer(tree);
		viewer.setLabelProvider(new ViewsLabelProvider());
		viewer.setContentProvider(new ContentProvider());
		viewer.setFilters(new ViewerFilter[] { new TreeViewerWildcardFilter(
				viewer) {
			protected boolean isIgnoredElement(Object parentElement,
					Object element) {
				return ((ViewInfo) element).getItems().size() > 0;
			}

			@Override
			protected String getFilterText() {
				String value = searchControl.getFilterString();
				if (!searchControl.getInitialText().equals(value)) {
					return value;
				}
				return "";
			}

			@Override
			protected String getElementText(Object parentElement, Object element) {
				return ((ViewInfo) element).getLabel();
			}

		} });
		viewer.setComparator(new ViewComparator());
		viewer.setInput(viewList);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				Object element = sel.getFirstElement();
				if (element instanceof ViewInfo
						&& ((ViewInfo) element).getItems().isEmpty()) {
					selectedView.setValue(element);
				}
			}
		});
		viewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				buttonPressed(IDialogConstants.OK_ID);
			}
		});
		GridData data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 2;
		tree.setLayoutData(data);
	}

	private class ContentProvider implements ITreeContentProvider {
		public Object[] getChildren(Object element) {
			if (element instanceof ViewList) {
				return ((ViewList) element).getItems().toArray();
			} else if (element instanceof ViewInfo) {
				return ((ViewInfo) element).getItems().toArray();
			}
			return new Object[0];
		}

		public Object[] getElements(Object element) {
			return getChildren(element);
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(java.lang.Object element) {
			if (element instanceof ViewList) {
				return !((ViewList) element).getItems().isEmpty();
			} else if (element instanceof ViewInfo) {
				return !((ViewInfo) element).getItems().isEmpty();
			}
			return false;
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}
	}

	public class ViewComparator extends ViewerComparator {

		/**
		 * ViewSorter constructor comment.
		 * 
		 * @param reg
		 *            an IViewRegistry
		 */
		public ViewComparator() {
			super();
		}

		/**
		 * Returns a negative, zero, or positive number depending on whether the
		 * first element is less than, equal to, or greater than the second
		 * element.
		 */
		@SuppressWarnings("unchecked")
		public int compare(Viewer viewer, Object e1, Object e2) {
			if (e1 instanceof ViewInfo && ((ViewInfo) e1).getItems().isEmpty()) {
				String str1 = DialogUtil
						.removeAccel(((ViewInfo) e1).getLabel());
				String str2 = DialogUtil
						.removeAccel(((ViewInfo) e2).getLabel());
				return getComparator().compare(str1, str2);
			} else if (e1 instanceof ViewInfo) {
				String str1 = DialogUtil
						.removeAccel(((ViewInfo) e1).getLabel());
				String str2 = DialogUtil
						.removeAccel(((ViewInfo) e2).getLabel());
				if ("General".equals(str1)) {
					return -1;
				}
				if ("General".equals(str2)) {
					return 1;
				}
				if ("Other".equals(str1)) {
					return 1;
				}
				if ("Other".equals(str2)) {
					return -1;
				}
				return getComparator().compare(str1, str2);
			}
			return 0;
		}
	}

}
