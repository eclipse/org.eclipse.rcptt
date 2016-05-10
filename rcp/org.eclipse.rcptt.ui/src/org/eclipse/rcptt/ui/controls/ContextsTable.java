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
package org.eclipse.rcptt.ui.controls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ResourceTransfer;

import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.ContextTypeManager;
import org.eclipse.rcptt.core.Q7Features;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IElementChangedListener;
import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.IQ7Element.HandleType;
import org.eclipse.rcptt.core.model.IQ7ElementDelta;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.IQ7ProjectMetadata;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.Q7ElementChangedEvent;
import org.eclipse.rcptt.core.model.search.AllProjectScope;
import org.eclipse.rcptt.core.model.search.ISearchScope;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.scenario.GroupContext;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.model.Q7TestCase;
import org.eclipse.rcptt.internal.core.model.ReferencedProjectScope;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.commons.EObjectTable;
import org.eclipse.rcptt.ui.commons.NamedElementTransfer;
import org.eclipse.rcptt.ui.dialogs.ContextSelectionDialog;
import org.eclipse.rcptt.ui.editors.NamedElementLabelProvider;
import org.eclipse.rcptt.ui.launching.LaunchUtils;
import org.eclipse.rcptt.ui.recording.RecordingSupport.RecordingMode;
import org.eclipse.rcptt.ui.utils.WorkbenchUtils;

public class ContextsTable extends EObjectTable {
	@Override
	protected void fillContextMenu(IMenuManager manager) {
		manager.add(new Action("&Open") {
			@Override
			public void run() {
				doOpen((IStructuredSelection) viewer.getSelection());
			}
		});
		final Action runAction = new Action("&Run") {
			{
				setToolTipText(Messages.RunSelectedAction_ToolTip);
				setText("&Run");
				setImageDescriptor(Images.getImageDescriptor(Images.PLAY));
				setDisabledImageDescriptor(Images
						.getImageDescriptor(Images.PLAY_D));
			}

			@Override
			public void run() {
				doRun((IStructuredSelection) viewer.getSelection());
			}
		};
		observeRecordingMode().addValueChangeListener(
				new IValueChangeListener() {
					public void handleValueChange(ValueChangeEvent event) {
						updateRunAction(runAction);
					}
				});
		manager.add(runAction);
		updateRunAction(runAction);
		super.fillContextMenu(manager);
	}

	protected void doRun(IStructuredSelection selection) {
		if (!selection.isEmpty()) {
			List<IResource> resources = new ArrayList<IResource>();
			Iterator<?> it = selection.iterator();
			while (it.hasNext()) {
				String elementId = (String) it.next();

				IQ7NamedElement element = getContentsElementById(elementId);
				if (element != null) {
					resources.add(element.getResource());
				}
			}
			if (resources.size() > 0) {
				LaunchUtils.launchContext(
						resources.toArray(new IResource[resources.size()]), "run", false); //$NON-NLS-1$
			}
		}
	}

	private final IElementChangedListener workspaceMonitorListener = new IElementChangedListener() {
		private void refreshTable(IQ7NamedElement[] elements) {
			if (viewer == null || getControl() == null
					|| getControl().isDisposed()) {
				return;
			}
			boolean needRefresh = false;
			if (elements == null) {
				// It might mean that .project file was changed and some
				// dependencies was added/removed
				needRefresh = true;
			} else {
				IQ7NamedElement testCase = getContent();
				String[] contexts = null;
				if (contexts == null && testCase instanceof ITestCase) {
					try {
						contexts = ((ITestCase) testCase).getContexts();
					} catch (ModelException e) {
						needRefresh = true;
					}
				}
				if (contexts == null && testCase instanceof IQ7ProjectMetadata) {
					try {
						contexts = ((IQ7ProjectMetadata) testCase)
								.getContexts();
					} catch (ModelException e) {
						needRefresh = true;
					}
				}
				try {
					if (contexts == null
							&& testCase instanceof IContext
							&& testCase.getNamedElement() instanceof GroupContext) {
						EList<String> list = ((GroupContext) getContent()
								.getNamedElement()).getContextReferences();
						if (list != null) {
							contexts = list.toArray(new String[list
									.size()]);
						}
					}
				} catch (Exception e) {
					// Ignore
					needRefresh = true;
				}
				List<String> lc = new ArrayList<String>();
				if (contexts != null) {
					lc.addAll(Arrays.asList(contexts));
				}
				for (IQ7NamedElement element : elements) {
					try {
						String elementID = Q7SearchCore
								.findIDByDocument(element);
						if (elementID == null) {
							elementID = element.getID();
						}
						needRefresh = lc.contains(elementID);
						if (needRefresh) {
							break;
						}
					} catch (ModelException e) {
						// Q7UIPlugin.log(e);
						needRefresh = true;
					}
				}
			}
			if (needRefresh) {
				refresh();
			}
		}

		private IQ7NamedElement findRenamed(IQ7ElementDelta delta,
				IQ7NamedElement element) {
			if (delta.getElement() instanceof ITestCase) {
				ITestCase test = (Q7TestCase) delta.getElement();
				if ((delta.getFlags() & IQ7ElementDelta.F_MOVED_FROM) != 0) {
					if (delta.getMovedFromElement().getPath()
							.equals(element.getPath())) {
						return test;
					}
				}
			}

			IQ7ElementDelta[] deltas = delta.getAffectedChildren();
			for (IQ7ElementDelta d : deltas) {
				IQ7NamedElement result = findRenamed(d, element);
				if (result != null)
					return result;
			}

			return null;
		}

		public void elementChanged(Q7ElementChangedEvent event) {
			IQ7ElementDelta delta = event.getDelta();
			IQ7NamedElement newContent = findRenamed(delta, getContent());
			if (newContent != null)
				setContent(newContent);

			IQ7ElementDelta[] elementDeltas = event.getDelta()
					.getAffectedChildren();
			for (IQ7ElementDelta iq7ElementDelta : elementDeltas) {
				if (iq7ElementDelta.getElement() instanceof IQ7Project) {
					if ((iq7ElementDelta.getFlags() & IQ7ElementDelta.F_DESCRIPTION) != 0) {
						updateProjectContextsList();
						refreshTable(null);
						return;
					}
				}
			}
			IQ7NamedElement[] elements = event.getDelta().getNamedElements();
			refreshTable(elements);
		}
	};

	private IProject project;

	private boolean showProjectContexts = true;

	private static NamedElementTransfer TRANSFER = null;
	private IQ7NamedElement namedElement;
	private EList<String> projectContexts = new BasicEList<String>();

	private String contextFilter = null;

	public ContextsTable(IQ7NamedElement content, EStructuralFeature feature,
			boolean showProjectContexts) throws ModelException {
		super(content.getNamedElement(), feature);
		this.showProjectContexts = showProjectContexts;
		this.namedElement = content;
		updateProjectContextsList();
	}

	@Override
	protected List<Object> getViewerContents() {
		List<Object> result = new ArrayList<Object>();
		if (showProjectContexts) {
			result.addAll(projectContexts);
		}
		result.addAll(getContexts());
		return result;
	}

	private void updateProjectContextsList() {
		if (!showProjectContexts) {
			return;
		}
		try {
			IQ7Project prj = this.namedElement.getQ7Project();
			if (prj != null) {
				IQ7ProjectMetadata metadata = prj.getMetadata();
				if (metadata != null && metadata.exists()) {
					String[] ctxs = metadata.getContexts();
					if (ctxs != null) {
						projectContexts.clear();
						projectContexts.addAll(Arrays.asList(ctxs));
					}
				}
			}
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
	}

	public ContextsTable(ITestCase scenario) throws ModelException {
		this(scenario, ScenarioPackage.Literals.SCENARIO__CONTEXTS, true);
		RcpttCore.addElementChangedListener(workspaceMonitorListener);
	}

	public ContextsTable(IQ7ProjectMetadata metadata) throws ModelException {
		this(metadata, ScenarioPackage.Literals.PROJECT_METADATA__CONTEXTS,
				false);
		RcpttCore.addElementChangedListener(workspaceMonitorListener);
	}

	public ContextsTable(IContext context) throws ModelException {
		this(context,
				ScenarioPackage.Literals.GROUP_CONTEXT__CONTEXT_REFERENCES,
				false);
		RcpttCore.addElementChangedListener(workspaceMonitorListener);
	}

	public IQ7NamedElement getContent() {
		return namedElement;
	}

	protected void setContent(IQ7NamedElement content) {
		namedElement = content;
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		viewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
				doOpen(selection);
			}
		});
		getControl().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				RcpttCore.removeElementChangedListener(workspaceMonitorListener);
			}
		});
		createProjectContexts(parent);
	}

	@Override
	protected Transfer getContentTransfer() {
		if (null == TRANSFER) {
			TRANSFER = new NamedElementTransfer();
		}
		return TRANSFER;
	}

	@Override
	protected boolean allowDrag(IStructuredSelection selection) {
		if (!super.allowDrag(selection)) {
			return false;
		}
		Object element = selection.getFirstElement();
		if (element == null || !(element instanceof String)) {
			return false;
		}
		return !projectContexts.contains(element);
	}

	@Override
	protected boolean doPerformDrop(Object data, Object currentTarget,
			int currentLocation) {
		if (data instanceof IResource[]) {
			IResource[] resources = (IResource[]) data;
			EList<Object> content = getContents();
			int targetPosition = content.size() - 1;
			if (currentTarget != null) {
				targetPosition = content.indexOf(currentTarget);
			}
			if (currentLocation == ViewerDropAdapter.LOCATION_AFTER
					|| currentLocation == ViewerDropAdapter.LOCATION_NONE) {
				targetPosition++;
			}
			EList<Object> contents = getContents();
			List<String> newContents = new ArrayList<String>();
			for (IResource resource : resources) {
				IQ7NamedElement element = getNamedElementByResource(resource);
				if (isValidToAdd(element)) {
					try {
						newContents.add(element.getID());
					} catch (ModelException e) {
						Q7UIPlugin.log(e);
					}
				}
			}
			if (targetPosition != -1) {
				contents.addAll(targetPosition, newContents);
			} else {
				contents.addAll(newContents);
			}
			refresh();

			return true;
		} else {
			return super.doPerformDrop(data, currentTarget, currentLocation);
		}
	}

	@Override
	protected boolean doValidateDrop(Object target, int operation,
			TransferData transferType, int currentLocation) {
		if (ResourceTransfer.getInstance().isSupportedType(transferType)) {
			IResource[] resources = getSelectedResources();
			for (IResource resource : resources) {
				IQ7NamedElement element = getNamedElementByResource(resource);
				if (isValidToAdd(element)) {
					return true;
				}
			}
			return false;
		}
		return super.doValidateDrop(target, operation, transferType,
				currentLocation);
	}

	@Override
	protected Transfer[] getDropTransferTypes() {
		Transfer[] base = super.getDropTransferTypes();
		Transfer[] result = new Transfer[base.length + 1];
		for (int i = 0; i < base.length; i++) {
			result[i] = base[i];
		}
		result[base.length] = ResourceTransfer.getInstance();
		return result;
	}

	private IResource[] getSelectedResources() {

		ISelection selection = LocalSelectionTransfer.getTransfer()
				.getSelection();
		if (selection instanceof IStructuredSelection) {
			return getSelectedResources((IStructuredSelection) selection);
		}
		return new IResource[0];
	}

	private IResource[] getSelectedResources(IStructuredSelection selection) {
		ArrayList<IResource> selectedResources = new ArrayList<IResource>();

		for (Iterator<?> i = selection.iterator(); i.hasNext();) {
			Object o = i.next();
			if (o instanceof IResource) {
				selectedResources.add((IResource) o);
			} else if (o instanceof IAdaptable) {
				IAdaptable a = (IAdaptable) o;
				IResource r = (IResource) a.getAdapter(IResource.class);
				if (r != null) {
					selectedResources.add(r);
				}
			}
		}
		return selectedResources
				.toArray(new IResource[selectedResources.size()]);
	}

	private IQ7NamedElement getNamedElementByResource(IResource resource) {
		if (resource.getType() == IResource.FILE) {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IFile file = workspace.getRoot().getFile(resource.getFullPath());
			if (file != null && file.exists()) {
				return (IQ7NamedElement) RcpttCore.create(file);
			}
		}
		return null;
	}

	protected void doOpen(IStructuredSelection selection) {
		if (selection.isEmpty()) {
			return;
		}
		for (Object element : selection.toArray()) {
			String elementId = (String) element;
			openSingleContext(elementId);
		}
	}

	protected void openSingleContext(String elementId) {
		IQ7NamedElement element = getContentsElementById(elementId);
		if (element != null) {
			try {
				IDE.openEditor(WorkbenchUtils.getPage(),
						(IFile) element.getResource());
			} catch (PartInitException e) {
				Q7UIPlugin.log(e);
			}
		}
	}

	public IProject getProject() {
		return project;
	}

	public void setProject(IProject project) {
		this.project = project;
	}

	public String getName() {
		return Messages.ContextsTable_Name;
	}

	public Image getImage() {
		return Images.getImage(Images.CONTEXT);
	}

	@SuppressWarnings("unchecked")
	public EList<String> getContexts() {
		return (EList<String>) (Object) getContents();
	}

	@Override
	protected ILabelProvider createLabelProvider() {
		IQ7Project prj = getContent().getQ7Project();
		if (prj == null && project != null) {
			prj = RcpttCore.create(project);
		}
		NamedElementLabelProvider provider = new NamedElementLabelProvider(prj) {
			protected void addExtraAnnotation(IQ7NamedElement namedElement,
					StyledString styled, int rowIndex) {
				if (showProjectContexts) {
					if (rowIndex < projectContexts.size()) {
						styled.append(" - ");
						styled.append("default context",
								StyledString.COUNTER_STYLER);
					} else {
						try {
							if (projectContexts.contains(namedElement.getID())) {
								styled.append(" - ");
								styled.append(
										"project default context conflict. Current context will be ignored",
										StyledString.DECORATIONS_STYLER);
							}
						} catch (ModelException e) {
							Q7UIPlugin.log(e);
						}
					}
				}
			}
		};
		return provider;
	}

	protected boolean isValidToAdd(IQ7NamedElement element) {
		try {
			IQ7Project q7Project = getContent().getQ7Project();
			if (q7Project != null) {
				IQ7ProjectMetadata metadata = q7Project.getMetadata();
				if (metadata != null && metadata.exists()) {
					String[] ctx = metadata.getContexts();
					if (ctx != null) {
						if (Arrays.asList(ctx).contains(element.getID())) {
							return false;
						}
					}
				}
			}

			if (getContent().getNamedElement() instanceof GroupContext) {
				String id = Q7SearchCore.findIDByDocument(element);
				if (id == null) {
					id = element.getID();
				}
				if (getContent().getID().equals(id)) {
					return false;
				}
			}
			if (element != null && element instanceof IContext) {
				IContext context = (IContext) element;
				if (contextFilter != null) {
					ContextType type = ContextTypeManager.getInstance()
							.getTypeByContext(
									(Context) context.getNamedElement());
					if (type == null || !type.getId().equals(contextFilter)) {
						return false;
					}
				}

				return !getContexts().contains(context.getID());
			}
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
		return false;
	}

	@Override
	protected String[] handleAdd() {
		ContextSelectionDialog dialog = new ContextSelectionDialog(getControl()
				.getShell(), getContent(), project) {
			@Override
			protected boolean isValidToAdd(IContext context) {
				return ContextsTable.this.isValidToAdd(context);
			}
		};
		int result = dialog.open();
		if (result == Window.OK) {
			Object[] selected = dialog.getResult();
			List<String> list = new ArrayList<String>();
			if (selected != null) {
				for (int i = 0; i < selected.length; i++) {
					IContext context = (IContext) selected[i];
					try {
						String id = Q7SearchCore.findIDByDocument(context);
						if (id == null) {
							id = context.getID();
						}
						list.add(id);
					} catch (ModelException e) {
						Q7UIPlugin.log(e);
					}
				}
			}
			setVisible(true);
			return list.toArray(new String[list.size()]);
		}
		return null;
	}

	@Override
	protected Class<?> getContentsType() {
		return String.class;
	}
	
	@Override
	protected HandleType getAppropriateHandleType() {
		return HandleType.Context;
	}

	@Override
	protected boolean canAdd(Object[] objects) {
		if (!super.canAdd(objects)) {
			return false;
		}
		IQ7NamedElement content = getContent();
		IFile iFile = (IFile) content.getResource();

		IQ7Project project = null;
		if (iFile != null) {
			project = RcpttCore.create(iFile.getProject());
		}
		for (Object obj : objects) {
			String val = null;
			if (obj instanceof String) {
				val = (String) obj;
			}
			if (obj instanceof IResource) {
				IQ7Element file = RcpttCore.create((IResource) obj);
				if (file.getElementType().equals(HandleType.Context)) {
					try {
						val = ((IContext) file).getID();
					} catch (ModelException e) {
						Q7UIPlugin.log(e);
					}
				}
			}
			if (val != null) {
				try {
					List<IContext> context = project != null ? project
							.find(IContext.class, val) : null;
					if (context != null && context.size() > 0) {
						// Check for context type

						if (contextFilter != null) {
							for (IContext ctx : context) {
								if (!ctx.getType().getId()
										.equals(contextFilter)) {
									return false;
								}
							}
						}
						return true;
					}
					// Try to locate in all projects
					IQ7NamedElement[] id = Q7SearchCore.findById(val,
							new AllProjectScope(), new NullProgressMonitor());
					for (IQ7NamedElement iq7NamedElement : id) {
						if (iq7NamedElement instanceof IContext) {
							return true;
						}
					}
					return false;
				} catch (ModelException e) {
					Q7UIPlugin.log(e);
				}
			}
		}
		return true;
	}

	protected IQ7NamedElement getContentsElementById(String elementId) {
		IQ7Project contentProject = getContent().getQ7Project();
		ISearchScope scope = new ReferencedProjectScope(contentProject);
		if (contentProject == null) {
			scope = new AllProjectScope();
		}
		IQ7NamedElement[] elts = Q7SearchCore.findById(elementId, scope,
				new NullProgressMonitor());
		if (elts != null && elts.length > 0) {
			return elts[0];
		}
		return null;
	}

	@Override
	public String getContentName(Object content) {
		try {
			IQ7Project group = getContent().getQ7Project();
			List<IContext> context = null;
			if (group == null) {
				IQ7NamedElement[] elements = Q7SearchCore.findById(
						(String) content, new AllProjectScope(),
						new NullProgressMonitor());
				context = new ArrayList<IContext>();
				for (IQ7NamedElement iq7NamedElement : elements) {
					if (iq7NamedElement instanceof IContext) {
						context.add((IContext) iq7NamedElement);
					}
				}
			} else {
				context = group.find(IContext.class, (String) content);
			}
			if (context.size() > 0) {
				String name = Q7SearchCore.findNameByDocument(context.get(0));
				if (name == null) {
					return context.get(0).getElementName();
				}
				return name;
			}
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
		return null;
	}

	private void createProjectContexts(Composite parent) {
		if (showProjectContexts && Q7Features.supportQ7OptionsFile) {
			Composite c = new Composite(parent, SWT.NONE);
			GridLayoutFactory.fillDefaults().numColumns(2).margins(0, 0)
					.applyTo(c);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(c);

			Link configure = new Link(c, SWT.NONE);
			GridDataFactory.fillDefaults().grab(true, false).span(2, 1)
					.align(SWT.RIGHT, SWT.CENTER).applyTo(configure);
			configure.setText("<a>Configure Project Default Contexts</a>");
			configure.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					try {
						IQ7ProjectMetadata md;
						md = getContent().getQ7Project().getMetadata();
						if (md.exists() && md.getResource() != null) {
							IDE.openEditor(WorkbenchUtils.getPage(),
									(IFile) md.getResource());
						}
					} catch (Exception ee) {
						Q7UIPlugin.log(ee);
					}
				}
			});
		}
	}

	@Override
	public void setVisible(boolean value) {
		super.setVisible(value);
		if (!value) {
			setSelection(new Object[0], false);
		}
	}

	@Override
	protected boolean disableToolBarOnHide() {
		return false;
	}

	private void updateRunAction(final Action runAction) {
		RecordingMode mode = (RecordingMode) observeRecordingMode().getValue();
		runAction.setEnabled(mode.equals(RecordingMode.Stopped));
	}

	public void setContextFilter(String contextFilter) {
		this.contextFilter = contextFilter;
	}
}
