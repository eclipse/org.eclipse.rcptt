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
package org.eclipse.rcptt.ui.resources.actions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.dialogs.ISelectionValidator;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import org.eclipse.rcptt.core.persistence.IPersistenceModel;
import org.eclipse.rcptt.core.persistence.PersistenceManager;
import org.eclipse.rcptt.ctx.resources.ImportUtils;
import org.eclipse.rcptt.ctx.resources.WSUtils;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.internal.resources.Q7WorkspaceUI;
import org.eclipse.rcptt.ui.resources.imports.ExternalProjectImportWizard;
import org.eclipse.rcptt.ui.resources.wizards.FileSystemImportWizard;
import org.eclipse.rcptt.ui.utils.WorkbenchUtils;
import org.eclipse.rcptt.workspace.WSFile;
import org.eclipse.rcptt.workspace.WSFileLink;
import org.eclipse.rcptt.workspace.WSFolder;
import org.eclipse.rcptt.workspace.WSFolderLink;
import org.eclipse.rcptt.workspace.WSProject;
import org.eclipse.rcptt.workspace.WSProjectLink;
import org.eclipse.rcptt.workspace.WSResource;
import org.eclipse.rcptt.workspace.WorkspaceContext;
import org.eclipse.rcptt.workspace.WorkspaceFactory;

public abstract class WSAction extends Action {

	public WSAction(String text, ImageDescriptor descriptor) {
		super(text, descriptor);
	}

	protected WSResource[] selection;
	protected TreeViewer viewer;

	public void setViewer(TreeViewer viewer) {
		this.viewer = viewer;
	}

	protected WorkspaceContext getContext() {
		return (WorkspaceContext) viewer.getInput();
	}

	public void setSelection(WSResource[] selection) {
		this.selection = selection;
		init();
	}

	protected abstract void init();

	public static class Remove extends WSAction {

		public Remove() {
			super("Remove", PlatformUI.getWorkbench().getSharedImages()
					.getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
		}

		@Override
		protected void init() {
			setEnabled(selection != null && selection.length > 0);
		}

		@Override
		public void run() {
			for (WSResource selectionItem: selection) {
				removeContents(selectionItem);
				WSUtils.remove(selectionItem);
			}
		}

		private void removeContents(WSResource resource) {
			if (resource instanceof WSFolder) {
				WSFolder folder = (WSFolder) resource;
				for (WSResource child : WSUtils.getContents(folder)) {
					removeContents(child);
				}
			} else if (resource instanceof WSFile) {
				WSFile file = (WSFile) resource;
				String name = ImportUtils.getName(file);

				IPersistenceModel model = PersistenceManager.getInstance()
						.getModel(getContext().eResource());
				if (model != null) {
					String[] names = model.getNames();
					for (String f : names) {
						if (f.startsWith(name)) {
							model.delete(f);
						}
					}
				}
			}
		}

	}

	public static class ImportProjects extends WSAction {

		public ImportProjects() {
			super("Import Projects...", Images
					.getImageDescriptor(Images.IMPORT_PROJECTS));
		}

		@Override
		protected void init() {
		}

		@Override
		public void run() {
			ExternalProjectImportWizard wizard = new ExternalProjectImportWizard(
					getContext(), null);
			WizardDialog dialog = new WizardDialog(WorkbenchUtils.getShell(),
					wizard);
			dialog.open();
		}

	}

	public static class ImportFiles extends WSAction {

		public ImportFiles() {
			super("Import Files...", Images
					.getImageDescriptor(Images.IMPORT_FILES));
		}

		@Override
		protected void init() {
			setEnabled(selection != null 
					&& selection.length == 1 
					&& selection[0] instanceof WSFolder);
		}

		@Override
		public void run() {
			WSFolder folder = (WSFolder) selection[0];
			FileSystemImportWizard wizard = new FileSystemImportWizard(folder);
			WizardDialog dialog = new WizardDialog(WorkbenchUtils.getShell(),
					wizard);
			dialog.open();
		}

	}

	public static class LinkProject extends WSAction {

		public LinkProject() {
			super("Link Workspace Project...", Images
					.getImageDescriptor(Images.LINK_PROJECT));
		}

		@Override
		protected void init() {
			setEnabled(true);
		}

		@Override
		public void run() {
			ContainerSelectionDialog dialog = new ContainerSelectionDialog(
					WorkbenchUtils.getShell(), null, false,
					"Please select a project:");

			dialog.setTitle("Project Selection");

			IDialogSettings settings = Q7WorkspaceUI.getDefault()
					.getDialogSettings();
			IDialogSettings section = settings
					.getSection("LinkProjectDialog.bounds");
			if (section == null)
				section = settings.addNewSection("LinkProjectDialog.bounds");
			dialog.setDialogBoundsSettings(section, Dialog.DIALOG_PERSISTSIZE);

			dialog.setValidator(new ISelectionValidator() {
				public String isValid(Object selection) {
					if (!(selection instanceof IPath))
						return "Unsupported selection type.";

					IPath path = (IPath) selection;
					if (path.segmentCount() == 1)
						return null; // that is a project
					else if (path.segmentCount() > 1) {
						// that is a folder
						IFolder folder = ResourcesPlugin.getWorkspace()
								.getRoot().getFolder(path);
						IResource dotProject = folder.findMember(".project");
						return dotProject != null && dotProject.exists()
								&& dotProject instanceof IFile ? null
								: "Selected folder is not a project.";
					} else
						return "Unsupported selection type.";
				}
			});

			if (dialog.open() != Window.OK)
				return;

			// --

			Object[] selection = dialog.getResult();
			for (Object o : selection) {
				if (!(o instanceof IPath))
					continue;

				IPath path = (IPath) o;
				IContainer c;
				if (path.segmentCount() > 1)
					c = ResourcesPlugin.getWorkspace().getRoot()
							.getFolder(path);
				else if (path.segmentCount() == 1)
					c = ResourcesPlugin.getWorkspace().getRoot()
							.getProject(path.segment(0));
				else
					continue;

				WSProjectLink link = WorkspaceFactory.eINSTANCE
						.createWSProjectLink();

				link.setName(c.getName());
				link.setProject(c.getProject().getName());
				link.setPath(c.getProjectRelativePath().toPortableString());

				addResource(getContext().getContent().getProjectLinks(),
						link.getName(), link, true);
			}
		}
	}

	public static class LinkFolder extends WSAction {

		public LinkFolder() {
			super("Link Workspace Folder...", Images
					.getImageDescriptor(Images.LINK_FOLDER));
		}

		@Override
		protected void init() {
			setEnabled(selection != null &&
					selection.length == 1 &&
						(selection[0] instanceof WSFolder
						|| selection[0] instanceof WSProject));
		}

		@Override
		public void run() {
			WSFolder folder = (WSFolder) selection[0];

			ContainerSelectionDialog dialog = new ContainerSelectionDialog(
					WorkbenchUtils.getShell(), null, false,
					"Please select a folder:");

			IDialogSettings settings = Q7WorkspaceUI.getDefault()
					.getDialogSettings();
			IDialogSettings section = settings
					.getSection("LinkFolderDialog.bounds");
			if (section == null)
				section = settings.addNewSection("LinkFolderDialog.bounds");
			dialog.setDialogBoundsSettings(section, Dialog.DIALOG_PERSISTSIZE);

			if (dialog.open() != Window.OK)
				return;

			// --

			Object[] selection = dialog.getResult();
			for (Object o : selection) {
				if (!(o instanceof IPath))
					continue;

				IPath path = (IPath) o;
				IContainer c;
				if (path.segmentCount() > 1)
					c = ResourcesPlugin.getWorkspace().getRoot()
							.getFolder(path);
				else if (path.segmentCount() == 1)
					c = ResourcesPlugin.getWorkspace().getRoot()
							.getProject(path.segment(0));
				else
					continue;

				WSFolderLink link = WorkspaceFactory.eINSTANCE
						.createWSFolderLink();

				link.setName(c.getName());
				link.setProject(c.getProject().getName());
				link.setPath(c.getProjectRelativePath().toPortableString());

				addResource(folder.getFolderLinks(), link.getName(), link, true);
			}
		}
	}

	public static class LinkFiles extends WSAction {

		public LinkFiles() {
			super("Link Workspace Files...", Images
					.getImageDescriptor(Images.LINK_FILE));
		}

		@Override
		protected void init() {
			setEnabled(selection != null 
					&& selection.length == 1 
					&& selection[0] instanceof WSFolder);
		}

		@Override
		public void run() {
			WSFolder folder = (WSFolder) selection[0];

			// --

			CheckedTreeSelectionDialog dialog = new CheckedTreeSelectionDialog(
					WorkbenchUtils.getShell(), new WorkbenchLabelProvider(),
					new BaseWorkbenchContentProvider());
			dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());

			dialog.setTitle("File Selection");
			dialog.setMessage("Please select files:");

			dialog.setContainerMode(true);
			dialog.setValidator(new ISelectionStatusValidator() {

				public IStatus validate(Object[] selection) {
					for (Object o : selection)
						if (o instanceof IFile)
							return new Status(IStatus.OK,
									Q7WorkspaceUI.PLUGIN_ID, "");
					return new Status(IStatus.ERROR, Q7WorkspaceUI.PLUGIN_ID,
							"Select one or more files.");
				}
			});

			IDialogSettings settings = Q7WorkspaceUI.getDefault()
					.getDialogSettings();
			IDialogSettings section = settings
					.getSection("LinkFilesDialog.bounds");
			if (section == null)
				section = settings.addNewSection("LinkFilesDialog.bounds");
			dialog.setDialogBoundsSettings(section, Dialog.DIALOG_PERSISTSIZE);

			if (dialog.open() != Window.OK)
				return;

			// --

			Object[] selection = dialog.getResult();
			for (Object o : selection) {
				if (!(o instanceof IFile))
					continue;

				IFile file = (IFile) o;

				WSFileLink link = WorkspaceFactory.eINSTANCE.createWSFileLink();
				link.setName(file.getName());
				link.setProject(file.getProject().getName());
				link.setPath(file.getProjectRelativePath().toPortableString());

				addResource(folder.getFileLinks(), link.getName(), link, true);
			}
		}

	}

	protected abstract static class CreateElement extends WSAction {

		public CreateElement(String text, ImageDescriptor descriptor) {
			super(text, descriptor);
		}

		@Override
		protected void init() {
			setEnabled(selection != null 
					&& selection.length == 1 
					&& selection[0] instanceof WSFolder);
		}

		@Override
		public void run() {
			WSFolder container = getContainer();
			WSResource res = create();
			addResource(getContents(container), getNamePrefix(), res, false);
			viewer.setExpandedState(container, true);
			viewer.setSelection(new StructuredSelection(res), true);
			viewer.editElement(res, 0);
		}

		protected abstract WSResource create();

		protected abstract String getNamePrefix();

		protected WSFolder getContainer() {
			return (WSFolder) selection[0];
		}

		protected List<WSResource> getContents(WSFolder container) {
			return WSUtils.getContents(container);
		}

	}

	public static class AddFolder extends WSAction {

		public AddFolder() {
			super("Create Empty Folder", Images
					.getImageDescriptor(Images.NEW_FOLDER));
		}

		@Override
		protected void init() {
			setEnabled(selection != null 
					&& selection.length == 1 
					&& selection[0] instanceof WSFolder);
		}

		@Override
		public void run() {
			WSFolder container = (WSFolder) selection[0];
			WSFolder folder = WorkspaceFactory.eINSTANCE.createWSFolder();
			addResource(container.getFolders(), "folder", folder, false);
			viewer.setExpandedState(container, true);
			viewer.setSelection(new StructuredSelection(folder), true);
			viewer.editElement(folder, 0);
		}

	}

	public static class AddFile extends WSAction {

		public AddFile() {
			super("New File", Images.getImageDescriptor(Images.NEW_FILE));
		}

		@Override
		protected void init() {
			setEnabled(selection != null 
					&& selection.length == 1 
					&& selection[0] instanceof WSFolder);
		}

		@Override
		public void run() {
			WSFolder container = (WSFolder) selection[0];
			WSFile file = WorkspaceFactory.eINSTANCE.createWSFile();
			addResource(container.getFiles(), "file", file, false);
			viewer.setExpandedState(container, true);
			viewer.setSelection(new StructuredSelection(file), true);
			viewer.editElement(file, 0);
		}

	}

	public static class OpenFile extends WSAction {

		public OpenFile() {
			super("Open File", Images.getImageDescriptor(Images.NEW_FILE));
		}

		@Override
		protected void init() {
			setEnabled(selection != null 
					&& selection.length == 1 
					&& (selection[0] instanceof WSFile
						|| selection[0] instanceof WSFileLink));
		}

		@Override
		public void run() {
			if (selection[0] instanceof WSFile) {
				WSFile file = (WSFile) selection[0];
				String name = ImportUtils.getName(file);

				// IFile iFile = storage.getFileToOpen(file);
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				try {
					IEditorDescriptor descriptor = IDE.getEditorDescriptor(
							name, true);
					String id = null;
					if (descriptor != null) {
						id = descriptor.getId();
					} else {
						id = "org.eclipse.ui.TextEditor";
					}
					IDE.openEditor(page, new PersistenceEditorInput(
							getContext().eResource(), name), id);
				} catch (PartInitException e) {
					Q7UIPlugin.log(e);
				}
			} else {
				WSFileLink link = (WSFileLink) selection[0];
				String name = link.getName();

				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				try {
					IEditorDescriptor descriptor = IDE.getEditorDescriptor(
							name, true);
					String id = null;
					if (descriptor != null) {
						id = descriptor.getId();
					} else {
						id = "org.eclipse.ui.TextEditor";
					}
					IFile linkResource = WSUtils.getLinkResource(link);
					if (linkResource != null) {
						IDE.openEditor(page, linkResource, id, true);
					}
				} catch (PartInitException e) {
					Q7UIPlugin.log(e);
				}
			}
		}

	}

	public static class AddProject extends WSAction {

		public AddProject() {
			super("Create Empty Project", Images
					.getImageDescriptor(Images.NEW_PROJECT));
		}

		@Override
		protected void init() {
		}

		@Override
		public void run() {
			WSProject project = WorkspaceFactory.eINSTANCE.createWSProject();
			addResource(getContext().getContent().getProjects(), "project",
					project, false);
			viewer.setSelection(new StructuredSelection(project), true);
			viewer.editElement(project, 0);
		}

	}

	private static <T extends WSResource> void addResource(List<T> resources,
			String prefix, T newResource, boolean noPostfixIfPossible) {
		Set<String> names = new HashSet<String>();
		for (WSResource resource : resources) {
			names.add(resource.getName());
		}
		for (int i = 1;; i++) {
			String name = prefix + i;

			if (noPostfixIfPossible && !names.contains(prefix)) {
				newResource.setName(prefix);
				resources.add(newResource);
				return;
			}

			if (!names.contains(name)) {
				newResource.setName(name);
				resources.add(newResource);
				return;
			}
		}
	}

}
