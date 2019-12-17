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
package org.eclipse.rcptt.ctx.filesystem.ui;

import org.eclipse.jface.resource.ImageDescriptor;

import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.ui.editors.IQ7Editor;
import org.eclipse.rcptt.ui.editors.IQ7Viewer;

public class FilesystemViewer implements IQ7Viewer<Context> {

	public String getLabel(Context context) {
		return "Folder";
	}

	public ImageDescriptor getImage(Context context) {
		return Images.getImageDescriptor(Images.FILESYSTEM);
	}

	public IQ7Editor<Context> createEditor() {
		return new FilesystemContextEditor();
	}

	public boolean isCaptureSupported() {
		return true;
	}

	public boolean isApplySupported() {
		return true;
	}
}
