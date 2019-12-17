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
package org.eclipse.rcptt.ctx.debug.ui;

import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.resource.ImageDescriptor;

import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.ui.editors.IQ7Editor;
import org.eclipse.rcptt.ui.editors.IQ7Viewer;

public class DebugContextViewer implements IQ7Viewer<Context> {

	public IQ7Editor<Context> createEditor() {
		return new DebugContextEditor();
	}

	public ImageDescriptor getImage(final Context context) {
		return DebugUITools.getImageDescriptor(IDebugUIConstants.IMG_ACT_DEBUG);
	}

	public String getLabel(final Context context) {
		return "Launch Context";
	}

	public boolean isCaptureSupported() {
		return true;
	}

	public boolean isApplySupported() {
		return true;
	}
}
