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

import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.part.FileEditorInput;

import org.eclipse.rcptt.core.model.IElementChangedListener;
import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.IQ7ElementDelta;
import org.eclipse.rcptt.core.model.IQ7Folder;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.Q7ElementChangedEvent;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.core.workspace.Q7Utils;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.builder.NamedElementReferencesResolver;
import org.eclipse.rcptt.ui.dialogs.AddProjectReferencesDialog;
import org.eclipse.rcptt.ui.utils.WorkbenchUtils;

public abstract class NamedElementEditor extends FormEditor implements
		IElementChangedListener, INamedElementEditor {

	private IQ7NamedElement model;
	private NamedElement element;
	private IQ7NamedElement handle;
	private boolean resourceTracking = true;
	private FilenameUpdater filenameUpdater;
	protected NamedElementEditorActions actions;

	public IQ7NamedElement getModel() {
		return model;
	}

	public NamedElement getElement() {
		return element;
	}

	protected void setEnableResourceTracking(boolean enableResourceTracking) {
		resourceTracking = enableResourceTracking;
	}

	public void setTags(String tags) {
		if (element != null) {
			element.setTags(tags);
		}
	}

	protected void updateEditorTitle() {
		setPartName(getElement().getName());
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		super.init(site, input);
		try {
			IFile inputFile = getInputFile();
			if (inputFile == null) {
				throw new PartInitException(
						Messages.NamedElementEditor_InvalidInputType);
			}
			if (resourceTracking) {
				handle = (IQ7NamedElement) RcpttCore.create(inputFile);
				filenameUpdater = new FilenameUpdater(handle);
				updateElement();
				RcpttCore.addElementChangedListener(this);
				updateEditorTitle();
				scheduleCheckMissingReferences();
			}
		} catch (PartInitException e) {
			throw e;
		} catch (Exception e) {
			throw new PartInitException(
					Messages.NamedElementEditor_LoadingFailed, e);
		}
	}

	private void scheduleCheckMissingReferences() {
		new Job(Messages.NamedElementEditor_Job) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				checkMissingReferences();
				return Status.OK_STATUS;
			}
		}.schedule(500);
	}

	private class ContentAdapter extends EContentAdapter {

		private final NamedElement element;

		public ContentAdapter(NamedElement element) {
			this.element = element;
			element.eAdapters().add(this);
		}

		@SuppressWarnings("unused")
		public void dispose() {
			element.eAdapters().remove(this);
		}

		@Override
		public void notifyChanged(Notification msg) {
			super.notifyChanged(msg);
			if (msg.getEventType() == Notification.RESOLVE
					|| msg.getEventType() == Notification.REMOVING_ADAPTER)
				return;
			updateEditorTitle();
			getSite().getShell().getDisplay().asyncExec(new Runnable() {
				public void run() {
					firePropertyChange(PROP_DIRTY);
				};
			});

			if (msg.getFeature() != null) {
				if (msg.getFeature().equals(
						ScenarioPackage.Literals.SCENARIO__CONTEXTS)
						|| msg.getFeature()
								.equals(ScenarioPackage.Literals.GROUP_CONTEXT__CONTEXT_REFERENCES)) {
					checkMissingReferences();
				}
			}
		}
	}

	protected void updateElement() throws ModelException, PartInitException {
		if (resourceTracking) {
			makeWorkingCopy();
			element = model.getNamedElement();
			if (element == null) {
				discardWorkingCopy();
				throw new PartInitException(
						Messages.NamedElementEditor_InvalidInputFormat);
			}
			// element.eAdapters().add(new AdapterImpl() {
			// public void notifyChanged(Notification notification) {
			// firePropertyChange(PROP_DIRTY);
			// }
			//
			// });
			new ContentAdapter(element);
		}
	}

	private void makeWorkingCopy() throws ModelException {
		RcpttCore.removeElementChangedListener(this);
		if (model != null) {
			discardWorkingCopy();
		}
		model = handle.getWorkingCopy(new NullProgressMonitor());
		RcpttCore.addElementChangedListener(this);
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		if (resourceTracking) {
			try {
				RcpttCore.removeElementChangedListener(this);
				model.commitWorkingCopy(true, monitor);
				updateEditorTitle();
				for (Object p : pages) {
					if (p instanceof NamedElementEditorPage) {
						((IQ7NamedElementEditorPage) p).elementChangedEvent();
					}
				}
				firePropertyChange(PROP_DIRTY);
			} catch (Exception e) {
				Q7UIPlugin.log(e);
			} finally {
				RcpttCore.addElementChangedListener(this);
			}

			try {
				filenameUpdater.update(model);
			} catch (Exception e) {
				Q7UIPlugin.log(e);
			}
		}
	}

	@Override
	public void doSaveAs() {
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public boolean isDirty() {
		if (resourceTracking) {
			try {
				if (model == null) {
					return false;
				}
				return model.hasUnsavedChanges();
			} catch (ModelException e) {
				Q7UIPlugin.log(e);
				return true;
			}
		}
		return super.isDirty();
	}

	@Override
	public void close(boolean save) {
		super.close(save);
		try {
			discardWorkingCopy();
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == IResource.class) {
			return Q7Utils.getLocation(element);
		}
		if (adapter.isInstance(element)) {
			return element;
		}
		if (adapter.isInstance(model)) {
			return model;
		}
		
		return super.getAdapter(adapter);
	}

	private void update(IQ7NamedElement newOrigin, IProgressMonitor monitor) {
		try {
			RcpttCore.removeElementChangedListener(this);
			discardWorkingCopy();
			handle = newOrigin;
			// Copy content from new to old
			updateElement();

			WorkbenchUtils.uiRun(new Runnable() {
				public void run() {
					int pageIdx = getActivePage();
					while (getPageCount() > 0) {
						removePage(0);
					}
					createPages();
					if (getPageCount() > 0) {
						if (pageIdx < getPageCount()) {
							setActivePage(pageIdx);
						} else {
							setActivePage(0);
						}
					}
					updateEditorTitle();
				}
			});

			firePropertyChange(PROP_DIRTY);
		} catch (Exception e) {
			WorkbenchUtils.uiRun(new Runnable() {
				public void run() {
					close(false);
				}
			});
			Q7UIPlugin.log(e);
		} finally {
			RcpttCore.addElementChangedListener(this);
		}
	}

	private void discardWorkingCopy() throws ModelException {
		if (resourceTracking) {
			if (model != null) {
				model.discardWorkingCopy();
				model = null;
			}
		}
	}

	public void removed(NamedElement element) {
		WorkbenchUtils.uiRun(new Runnable() {
			public void run() {
				getSite().getPage().closeEditor(NamedElementEditor.this, false);
			}
		});
	}

	protected IFile getInputFile() {
		IEditorInput input = getEditorInput();
		if (input instanceof IFileEditorInput) {
			return ((IFileEditorInput) input).getFile();
		}
		return null;
	}

	public void hideTabs() {
		if (getContainer() instanceof CTabFolder) {
			((CTabFolder) getContainer()).setTabHeight(0);
		}
	}

	public void showSearchMatch(int scenarioPart, int offset, int length) {
		// if (getActivePageInstance() instanceof ScenarioEditorPage) {
		// ((ScenarioEditorPage) getActivePageInstance()).showSearchMatch(
		// scenarioPart, offset, length);
		// }
	}

	private boolean hasContainerChanges(IQ7ElementDelta delta) {
		IQ7Element element = delta.getElement();
		if (element instanceof IQ7Project || element instanceof IQ7Folder) {
			if (delta.getKind() == IQ7ElementDelta.REMOVED) {
				IPath p1 = delta.getElement().getPath();
				IPath p2 = model.getPath();
				if (p1.isPrefixOf(p2)) {
					return true;
				}
			}
		}
		IQ7ElementDelta[] deltas = delta.getAffectedChildren();
		for (IQ7ElementDelta childDelta : deltas) {
			return hasContainerChanges(childDelta);
		}
		return false;
	}

	private IQ7Element[] hasContainerMoveChanges(IQ7ElementDelta delta) {
		IQ7Element element = delta.getElement();
		if (element instanceof IQ7Project || element instanceof IQ7Folder) {
			if (delta.getKind() == IQ7ElementDelta.REMOVED) {
				IPath p1 = delta.getElement().getPath();
				IPath p2 = model.getPath();
				if (p1.isPrefixOf(p2)) {
					if (((delta.getFlags() & IQ7ElementDelta.F_MOVED_FROM) != 0 || (delta
							.getFlags() & IQ7ElementDelta.F_MOVED_TO) != 0)) {
						return new IQ7Element[] { delta.getElement(),
								delta.getMovedToElement() };
					}
					return null;
				}
			}
		}
		IQ7ElementDelta[] deltas = delta.getAffectedChildren();
		for (IQ7ElementDelta childDelta : deltas) {
			IQ7Element el[] = hasContainerMoveChanges(childDelta);
			if (el != null) {
				return el;
			}
		}
		return null;
	}

	public void elementChanged(Q7ElementChangedEvent event) {
		if (!resourceTracking) {
			return;
		}
		if (model == null) {
			return;
		}

		IQ7ElementDelta delta = event.getDelta();
		IQ7Element[] moveTo = hasContainerMoveChanges(delta);
		if (moveTo != null) {
			IPath relativePath = model.getPath().removeFirstSegments(
					moveTo[0].getPath().segmentCount());
			IPath newPath = moveTo[1].getPath().append(relativePath);
			replaceResource(RcpttCore.create(ResourcesPlugin.getWorkspace()
					.getRoot().findMember(newPath)));
			return;
		}
		IQ7NamedElement[] namedElements = delta.getNamedElements();
		for (final IQ7NamedElement e : namedElements) {
			IQ7ElementDelta childDelta = delta.getChildBy(e);
			if (model.equals(e)) {
				switch (childDelta.getKind()) {
				case IQ7ElementDelta.REMOVED:
					if (!((childDelta.getFlags() & IQ7ElementDelta.F_MOVED_FROM) != 0 || (childDelta
							.getFlags() & IQ7ElementDelta.F_MOVED_TO) != 0)) {
						resourceRemoved(e);
						break;
					}
				case IQ7ElementDelta.CHANGED:
					if ((childDelta.getFlags() & IQ7ElementDelta.F_CONTENT) != 0
							|| (childDelta.getFlags() & IQ7ElementDelta.F_MOVED_FROM) != 0
							|| (childDelta.getFlags() & IQ7ElementDelta.F_MOVED_TO) != 0
							|| (childDelta.getFlags() & IQ7ElementDelta.F_DESCRIPTION) != 0) {
						if ((childDelta.getFlags() & IQ7ElementDelta.F_MOVED_TO) != 0) {
							final IQ7Element el = childDelta
									.getMovedToElement();
							if (el != null && el instanceof IQ7NamedElement) {
								replaceResource(el);
								return;
							}
						}
						resourceChanged(e);
						return;
					}
					break;
				}
			}
		}

		IQ7ElementDelta[] children = delta.getAffectedChildren();
		IQ7Project project = model.getQ7Project();
		for (IQ7ElementDelta c : children) {
			if (c.getElement().equals(project)
					&& (c.getFlags() & IQ7ElementDelta.F_CLOSED) != 0) {
				resourceClosed(model);
			}
		}

		if (hasContainerChanges(delta)) {
			resourceRemoved(model);
			return;
		}
	}

	private void replaceResource(final IQ7Element el) {
		if (!resourceTracking) {
			return;
		}
		try {
			RcpttCore.removeElementChangedListener(this);
			discardWorkingCopy();
			RcpttCore.addElementChangedListener(this);
			WorkbenchUtils.uiRun(new Runnable() {
				public void run() {
					try {
						init(getEditorSite(),
								new FileEditorInput((IFile) el.getResource()));
					} catch (PartInitException e) {
						Q7UIPlugin.log(e);
					}
				}
			});
		} catch (ModelException e2) {
			Q7UIPlugin.log(e2);
		}
		resourceChanged((IQ7NamedElement) el);
		return;
	}

	private void resourceRemoved(final IQ7NamedElement e) {
		WorkbenchUtils.uiRun(new Runnable() {
			public void run() {
				// String title =
				// Messages.NamedElementEditor_ResourceDeletedDialogTitle;
				// String msg = Messages.bind(
				// Messages.NamedElementEditor_ResourceDeletedDialogMsg,
				// getInputFile().getName());
				// String[] buttons = {
				// Messages.NamedElementEditor_ResourceDeletedDialogButtonSave,
				// Messages.NamedElementEditor_ResourceDeletedDialogButtonClose,
				// };
				//
				// MessageDialog dialog = new
				// MessageDialog(getSite().getShell(),
				// title, null, msg, MessageDialog.QUESTION, buttons, 0);
				// if (isDirty() && dialog.open() == 0) {
				// doSave(getProgressMonitor());
				// } else {
				close(false);
				// }
			}
		});
	}

	private void resourceClosed(final IQ7NamedElement e) {
		WorkbenchUtils.uiRun(new Runnable() {
			public void run() {
				close(true);
			}
		});
	}

	private void resourceChanged(final IQ7NamedElement e) {
		if (!resourceTracking) {
			return;
		}
		WorkbenchUtils.uiRun(new Runnable() {
			public void run() {
				String title = Messages.NamedElementEditor_ResourceChangedDialogTitle;
				String msg = Messages.bind(
						Messages.NamedElementEditor_ResourceChangedDialogMsg,
						getInputFile().getName());
				if (isDirty()) {
					if (MessageDialog.openQuestion(getSite().getShell(), title,
							msg)) {
						update(e, getProgressMonitor());
						int pageIdx = getActivePage();
						while (getPageCount() > 0) {
							removePage(0);
						}
						createPages();
						if (getPageCount() > 0) {
							if (pageIdx < getPageCount()) {
								setActivePage(pageIdx);
							} else {
								setActivePage(0);
							}
						}
						updateEditorTitle();
						firePropertyChange(PROP_DIRTY);
					} else {
						firePropertyChange(PROP_DIRTY);
					}
				} else {
					update(e, getProgressMonitor());
				}
				scheduleCheckMissingReferences();
			}
		});
	}

	protected IProgressMonitor getProgressMonitor() {
		IProgressMonitor pm = null;
		IStatusLineManager manager = getStatusLineManager();
		if (manager != null)
			pm = manager.getProgressMonitor();
		return pm != null ? pm : new NullProgressMonitor();
	}

	protected IStatusLineManager getStatusLineManager() {
		return getEditorSite().getActionBars().getStatusLineManager();
	}

	@Override
	public void dispose() {
		try {
			discardWorkingCopy();
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
		super.dispose();
		RcpttCore.removeElementChangedListener(this);
	}

	protected void checkMissingReferences() {
		try {
			final Map<IProject, Set<IQ7NamedElement>> missing = NamedElementReferencesResolver
					.resolveMissingReferences(getModel());
			if (!missing.isEmpty()) {
				IFile file = Q7Utils.getLocation(getElement());
				final IProject project = file.getProject();
				getSite().getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						if (AddProjectReferencesDialog.open(getSite()
								.getShell(), project, missing)) {
							afterMissingReferencesAdded();
						}
					}
				});
			}
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
	}

	protected void afterMissingReferencesAdded() {
	}

	public void renamed(boolean wasDirty) {

	}

	public void updateEnablement() {
		if (actions != null) {
			actions.updateEnablement();
		}
	}

	public void activateActions() {
		if (actions != null) {
			actions.activate();
		}
	}

	public void deactivateActions() {
		if (actions != null) {
			actions.deactivate();
		}
	}

	public abstract void createActions();
}
