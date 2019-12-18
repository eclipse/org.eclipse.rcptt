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
package org.eclipse.rcptt.ui.utils;

import static com.google.common.base.Functions.compose;
import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;

public class WriteAccessChecker {

	private Shell shell;
	private boolean currentThread = true;

	public WriteAccessChecker(Shell shell) {
		this.shell = shell;
	}

	public WriteAccessChecker(Shell shell, boolean currentThread) {
		this.shell = shell;
		this.currentThread = currentThread;
	}

	public WriteAccessChecker() {
	}

	static final Function<IQ7Element, IResource> toResource = new Function<IQ7Element, IResource>() {
		@Override
		public IResource apply(IQ7Element input) {
			return input.getResource();
		}
	};

	static final Function<IResource, String> toPath = new Function<IResource, String>() {
		@Override
		public String apply(IResource input) {
			return input.getFullPath().toOSString();
		}
	};

	private IQ7Element[] findReadOnly(IQ7Element... models) {
		List<IQ7Element> readOnly = new ArrayList<IQ7Element>();
		for (IQ7Element model : models) {
			if (isReadOnly(model) && !readOnly.contains(model)) {
				readOnly.add(model);
			}
		}
		return Iterables.toArray(readOnly, IQ7Element.class);
	}

	public static boolean isReadOnly(IQ7Element file) {
		if (file.getResource().getResourceAttributes() != null
				&& file.getResource().getResourceAttributes().isReadOnly()) {
			return true;
		}
		return false;
	}

	private IResource[] findReadOnly(IResource... files) {
		List<IResource> readOnly = new ArrayList<IResource>();
		for (IResource file : files) {
			if (isReadOnly(file) && !readOnly.contains(file)) {
				readOnly.add(file);
			}
		}
		return Iterables.toArray(readOnly, IResource.class);
	}

	public static boolean isReadOnly(IResource file) {
		if (file.getResourceAttributes() != null && file.getResourceAttributes().isReadOnly()) {
			return true;
		}
		return false;
	}

	public boolean makeResourceWritable(List<IQ7Element> references) throws CoreException {
		return makeResourceWritable(references.toArray(new IQ7Element[0]));
	}

	public boolean makeResourceWritable(IQ7Element... models) throws CoreException {
		IQ7Element[] readOnly = findReadOnly(models);
		if (readOnly.length == 0) {
			return true;
		}
		String filesStr = Joiner.on(",\n").join(Collections2.transform(asList(readOnly), compose(toPath, toResource)));
		if (!showDialog(filesStr))
			return false;

		for (IQ7Element model : readOnly) {
			setWritable((IFile) model.getResource(), true);
		}
		return true;
	}

	public boolean makeResourceWritable(IResource... models) throws CoreException {
		IResource[] readOnly = findReadOnly(models);
		if (readOnly.length == 0) {
			return true;
		}
		String filesStr = Joiner.on(",\n").join(readOnly);
		if (!showDialog(filesStr))
			return false;

		for (IResource file : readOnly) {
			setWritable(file, true);
		}
		return true;
	}

	public static void setWritable(IResource file, boolean writable) throws CoreException {
		ResourceAttributes attributes = file.getResourceAttributes();
		if (attributes != null) {
			attributes.setReadOnly(!writable);
		}
		file.setResourceAttributes(attributes);
	}

	private boolean showDialog(final String filesStr) {
		if (!currentThread || shell == null) {
			final boolean[] answer = { false };
			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
				public void run() {
					if (shell == null) {
						shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
					}
					answer[0] = MessageDialog.openQuestion(shell, Messages.ResourceAccessDialog_Title,
							NLS.bind(Messages.ResourceAccessDialog_Message,
							new String[] { filesStr }));
				}
			});
			return answer[0];
		}
		return MessageDialog.openQuestion(shell, Messages.ResourceAccessDialog_Title,
				NLS.bind(Messages.ResourceAccessDialog_Message,
				new String[] { filesStr }));
	}
}
