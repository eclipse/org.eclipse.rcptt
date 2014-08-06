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
package org.eclipse.rcptt.core.ecl.context.internal.viewer;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.rcptt.core.ecl.context.viewer.Activator;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.editors.IQ7Editor;
import org.eclipse.rcptt.ui.editors.IQ7Viewer2;
import org.eclipse.ui.IEditorPart;

public class EclContextViewer implements IQ7Viewer2<Context> {

	public IQ7Editor<Context> createEditor() {
		return new EclContextEditor();
	}

	public ImageDescriptor getImage(Context context) {
		return getEclContextImage();
	}

	public static ImageDescriptor getEclContextImage() {
		return Q7UIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
				"/icons/script.gif");
	}

	public String getLabel(Context context) {
		return "Ecl Script Context";
	}

	public IEditorPart createEditorPart() {
		return new org.eclipse.rcptt.core.ecl.context.editor.EclContextEditor();
	}

	public boolean isEnableResourceTracking() {
		return false;
	}

	public boolean isCaptureSupported() {
		return false;
	}

	public boolean isApplySupported() {
		return true;
	}
}
