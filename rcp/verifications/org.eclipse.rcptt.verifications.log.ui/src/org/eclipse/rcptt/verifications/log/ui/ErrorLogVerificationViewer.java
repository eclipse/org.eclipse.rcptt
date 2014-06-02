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
package org.eclipse.rcptt.verifications.log.ui;

import org.eclipse.jface.resource.ImageDescriptor;

import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.ui.editors.IQ7Editor;
import org.eclipse.rcptt.ui.editors.IQ7Viewer;

public class ErrorLogVerificationViewer implements IQ7Viewer<Verification> {
	
	@Override
	public String getLabel(Verification source) {
		return "Error Log";
	}

	
	private static final ImageDescriptor ERROR_LOG_ICON = ImageDescriptor.createFromFile(ErrorLogVerificationViewer.class, "icons/error_log.gif"); 
	
	@Override
	public ImageDescriptor getImage(Verification source) {
		return ERROR_LOG_ICON;
	}

	@Override
	public IQ7Editor<Verification> createEditor() {
		return new ErrorLogVerificationEditor();
	}

	@Override
	public boolean isCaptureSupported() {
		return true;
	}

	@Override
	public boolean isApplySupported() {
		return false;
	}


}
