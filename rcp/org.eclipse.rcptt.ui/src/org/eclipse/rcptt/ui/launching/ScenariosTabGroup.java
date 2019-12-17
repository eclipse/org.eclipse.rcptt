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
package org.eclipse.rcptt.ui.launching;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.rcptt.internal.launching.TestEngineManager;

public class ScenariosTabGroup extends AbstractLaunchConfigurationTabGroup {

	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		List<ILaunchConfigurationTab> tabs = new ArrayList<ILaunchConfigurationTab>();
		tabs.add(new ScenariosLaunchTab());
		tabs.add(new CommonTab());
		if (isTestEnginesNotEmpty()) {
			tabs.add(1, new TestEnginesLaunchTab());
		}
		setTabs(tabs.toArray(new ILaunchConfigurationTab[0]));
	}

	private boolean isTestEnginesNotEmpty() {
		List<TestEngineManager.TestEngineExtension> engines = TestEngineManager.getInstance().getEngines();
		return engines != null && !engines.isEmpty();
	}

}
