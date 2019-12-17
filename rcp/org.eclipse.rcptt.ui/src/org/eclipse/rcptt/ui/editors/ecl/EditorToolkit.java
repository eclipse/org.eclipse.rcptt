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

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;

public abstract class EditorToolkit {

	private final ColorManager colorManager = new ColorManager();

	public ColorManager getColorManager() {
		return colorManager;
	}

	public String getEditorTextFont() {
		return JFaceResources.TEXT_FONT;
	}

	public abstract IPreferenceStore getPreferenceStore();

	public abstract String[] getContentTypes();

	public abstract EnhancedRuleScanner getScanner(String ct);

	public abstract String[] getPartitions();

	public abstract IPartitionTokenScanner getPartitionScanner();

	public void dispose() {
		colorManager.dispose();
	}
}