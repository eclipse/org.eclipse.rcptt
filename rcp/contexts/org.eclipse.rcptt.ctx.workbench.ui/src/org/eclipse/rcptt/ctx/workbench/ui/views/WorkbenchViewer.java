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
package org.eclipse.rcptt.ctx.workbench.ui.views;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.scenario.WorkbenchContext;
import org.eclipse.rcptt.ui.editors.IQ7Editor;
import org.eclipse.rcptt.ui.editors.IQ7Viewer;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class WorkbenchViewer implements IQ7Viewer<Context> {

	public IQ7Editor<Context> createEditor() {
		return new WorkbenchContextEditor();
	}

	public ImageDescriptor getImage(Context context) {
		IPerspectiveDescriptor descriptor = getDescriptor(context);
		if (descriptor != null) {
			return descriptor.getImageDescriptor();
		}
		return PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ETOOL_DEF_PERSPECTIVE);
	}

	public String getLabel(Context context) {
		WorkbenchContext perspective = (WorkbenchContext) context;
		String id = perspective.getPerspectiveId();
		IPerspectiveDescriptor descriptor = getDescriptor(id);
		String label = null;
		if (descriptor == null) {
			if (id == null || id.length() == 0) {
				label = "Undefined";
			} else {
				label = id;
			}
		} else {
			label = descriptor.getLabel();
		}
		return label + " Perspective";
	}

	private IPerspectiveDescriptor getDescriptor(Context context) {
		WorkbenchContext perspective = (WorkbenchContext) context;
		return getDescriptor(perspective.getPerspectiveId());
	}

	private IPerspectiveDescriptor getDescriptor(String id) {
		return PlatformUI.getWorkbench().getPerspectiveRegistry()
				.findPerspectiveWithId(id);
	}

	public boolean isCaptureSupported() {
		return true;
	}

	public boolean isApplySupported() {
		return true;
	}
}
