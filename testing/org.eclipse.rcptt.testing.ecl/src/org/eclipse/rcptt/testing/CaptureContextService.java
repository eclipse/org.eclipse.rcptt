/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.testing;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.ContextTypeManager;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.launching.utils.TestSuiteUtils;
import org.eclipse.rcptt.testing.commands.CaptureContext;
import org.eclipse.rcptt.ui.actions.ContextSnapshotAction;
import org.eclipse.rcptt.ui.context.ContextUIManager;
import org.eclipse.rcptt.ui.utils.WriteAccessChecker;

public class CaptureContextService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof CaptureContext)) {
			return Status.CANCEL_STATUS;
		}

		CaptureContext cmd = (CaptureContext) command;

		IFile file = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(cmd.getPath()));
		ContextType fromResource = getContextType(file);
		ContextType fromArg = getContextType(cmd.getType());

		if (fromResource == null && fromArg == null) {
			return TestingPlugin
					.createErrStatus("Cannot determine context type to capture");
		}

		if (fromResource != null && fromArg != null
				&& !fromResource.getId().equals(fromArg.getId())) {
			return TestingPlugin
					.createErrStatus("Context type of existing file does "
							+ "not match to context type from argument");
		}
		ContextType type = fromResource == null ? fromArg : fromResource;
		if (!ContextUIManager.getInstance().getViewer(type).getViewer()
				.isCaptureSupported()) {
			return TestingPlugin.createErrStatus(String.format(
					"Capture is not supported for context type %s",
					type.getName()));
		}

		IContext ctx = file.exists() ? contextFromResource(file) : RcpttCore
				.create(file.getProject())
				.getFolder(file.getParent().getProjectRelativePath())
				.createContext(getFileNameWithoutExtension(file), type, true,
						new NullProgressMonitor());
		ctx = (IContext) ctx.getWorkingCopy(new NullProgressMonitor());
		Context contextData = ContextSnapshotAction.createSnapshot(null,
				type.getId(), null);
		type.getMaker().captureContents(ctx, contextData,
				new NullProgressMonitor());
		WriteAccessChecker writeAccessChecker = new WriteAccessChecker();
		if (writeAccessChecker.makeResourceWritable(ctx)) {
			ctx.commitWorkingCopy(true, new NullProgressMonitor());
			return Status.OK_STATUS;
		}
		return Status.CANCEL_STATUS;
	}

	private static String getFileNameWithoutExtension(IFile file) {
		String extension = file.getFullPath().getFileExtension();
		String name = file.getName();
		if (extension == null) {
			return name;
		}
		return file.getName().substring(0,
				name.length() - extension.length() - 1);
	}

	private static ContextType getContextType(String name) {
		if (name == null || name.length() == 0) {
			return null;
		}
		for (ContextType type : ContextTypeManager.getInstance().getTypes()) {
			if (type.getEClass().getName().equals(name)) {
				return type;
			}
		}
		return null;
	}

	private ContextType getContextType(IFile file) throws CoreException {
		if (!file.exists()) {
			return null;
		}
		IContext context = contextFromResource(file);
		return context == null ? null : context.getType();
	}

	private static IContext contextFromResource(IResource resource)
			throws CoreException {
		IQ7NamedElement[] elements = TestSuiteUtils.getElements(
				new IResource[] { resource }, false);
		if (elements.length != 1 || !(elements[0] instanceof IContext)) {
			throw new CoreException(TestingPlugin.createErrStatus(String
					.format("Can't find context in existing file %s",
							resource.getFullPath())));
		}

		return (IContext) elements[0];
	}
}
