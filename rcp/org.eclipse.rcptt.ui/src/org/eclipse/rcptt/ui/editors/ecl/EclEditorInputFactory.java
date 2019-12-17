/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.editors.ecl;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.workspace.RcpttCore;

public class EclEditorInputFactory implements IElementFactory {

	private static final String ID_FACTORY = "org.eclipse.rcptt.ui.editors.ecl.EclEditorInputFactory"; //$NON-NLS-1$

	private static final String TAG_PATH = "path"; //$NON-NLS-1$

	public EclEditorInputFactory() {
	}

	public IAdaptable createElement(IMemento memento) {
		String fileName = memento.getString(TAG_PATH);
		if (fileName == null) {
			return null;
		}

		IFile file = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(fileName));
		if (file != null) {
			return new EclEditorInput((IQ7NamedElement) RcpttCore.create(file));
		}
		return null;
	}

	public static String getFactoryId() {
		return ID_FACTORY;
	}

	public static void saveState(IMemento memento, EclEditorInput input) {
		IFile file = input.getFile();
		memento.putString(TAG_PATH, file.getFullPath().toString());
	}
}
