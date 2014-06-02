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
package org.eclipse.rcptt.ui.refactoring.rename;

import java.text.MessageFormat;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.ChangeDescriptor;
import org.eclipse.ltk.core.refactoring.resource.ResourceChange;
import org.eclipse.osgi.util.TextProcessor;

import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.ctx.resources.WSUtils;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.editors.INamedElementEditor;
import org.eclipse.rcptt.ui.utils.ModelUtils;
import org.eclipse.rcptt.workspace.WSContainer;
import org.eclipse.rcptt.workspace.WSFile;
import org.eclipse.rcptt.workspace.WSResource;

public class RenameNamedElementChange extends ResourceChange {

	private static final String RENAME_MESSAGE = Messages.RenameNamedElementChange_Msg;
	private static final String RENAME_PROGRESS_MESSAGE = Messages.RenameNamedElementChange_ProgressMsg;
	private final String fNewResourceName;
	private final String fNewElementName;
	private final IPath fResourcePath;
	private IQ7NamedElement fElement;

	private ChangeDescriptor fDescriptor;

	public RenameNamedElementChange(IPath resourcePath, String newResourceName,
			String newElementName) {
		if (resourcePath == null || newResourceName == null
				|| newResourceName.length() == 0 || newElementName == null
				|| newElementName.length() == 0) {
			throw new IllegalArgumentException();
		}

		fResourcePath = resourcePath;
		fElement = (IQ7NamedElement) RcpttCore
				.create((IFile) getModifiedResource());
		if (fElement == null) {
			throw new IllegalArgumentException();
		}

		fNewResourceName = newResourceName;
		fNewElementName = newElementName;
		fDescriptor = null;
		setValidationMethod(VALIDATE_NOT_DIRTY);
	}

	@Override
	public ChangeDescriptor getDescriptor() {
		return fDescriptor;
	}

	public void setDescriptor(ChangeDescriptor descriptor) {
		fDescriptor = descriptor;
	}

	@Override
	protected IResource getModifiedResource() {
		return ResourcesPlugin.getWorkspace().getRoot()
				.findMember(fResourcePath);
	}

	@Override
	public String getName() {
		return MessageFormat.format(RENAME_MESSAGE,
				new Object[] { getPathLabel(fResourcePath),
						getResourceName(fNewResourceName) });
	}

	private static String getPathLabel(IPath path) {
		String label = path.makeRelative().toString();

		return TextProcessor.process(label, "/\\:."); //$NON-NLS-1$
	}

	private static String getResourceName(String resourceName) {
		return TextProcessor.process(resourceName, ":."); //$NON-NLS-1$
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		try {
			pm.beginTask(RENAME_PROGRESS_MESSAGE, 1);

			String oldElementName = fElement.getElementName();
			String oldResourceName = fResourcePath.lastSegment();

			IResource resource = getModifiedResource();

			final INamedElementEditor editor = ModelUtils.findEditor(fElement);
			boolean isDirtyInEditor = false;
			if (editor != null && editor.isDirty())
				isDirtyInEditor = true;

			IPath newPath = renamedResourcePath(fResourcePath, fNewResourceName);
			RcpttCore.getInstance().rename((IFile) resource, newPath);

			IQ7Element newElement = RcpttCore.create(ResourcesPlugin
					.getWorkspace().getRoot().findMember(newPath));
			if( newElement == null) {
				return null;
			}
			IQ7NamedElement copy = ((IQ7NamedElement) newElement)
					.getWorkingCopy(new NullProgressMonitor());
			copy.setElementName(fNewElementName);
			try {
				if (!isDirtyInEditor) {
					copy.commitWorkingCopy(true, new NullProgressMonitor());
				}
				if (editor != null) {
					editor.renamed(!isDirtyInEditor);
				}
			} catch (Exception e) {
				Q7UIPlugin.log(e);
			} finally {
				copy.discardWorkingCopy();
			}

			return new RenameNamedElementChange(newPath, oldResourceName,
					oldElementName);
		} finally {
			pm.done();
		}
	}

	@SuppressWarnings("unused")
	private static void updateFileReference(String folderName, WSResource res) {
		if (res instanceof WSContainer) {
			for (WSResource child : WSUtils.getContents((WSContainer) res)) {
				updateFileReference(folderName, child);
			}
		} else if (res instanceof WSFile) {
			WSFile file = (WSFile) res;
			String uri = file.getContentURI();
			if (uri != null && uri.length() > 0) {
				IPath path = new Path(uri);
				path = new Path(folderName).append(path.removeFirstSegments(1));
				file.setContentURI(path.toString());
			}
		}
	}

	@SuppressWarnings("unused")
	private static String getFolderName(String fileName) {
		String folderName = fileName.replaceAll("\\.", ""); //$NON-NLS-1$ //$NON-NLS-2$
		return "." + folderName; //$NON-NLS-1$
	}

	private static IPath renamedResourcePath(IPath path, String newName) {
		return path.removeLastSegments(1).append(newName);
	}
}
