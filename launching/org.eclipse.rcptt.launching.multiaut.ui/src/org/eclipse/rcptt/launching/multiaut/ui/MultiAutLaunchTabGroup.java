package org.eclipse.rcptt.launching.multiaut.ui;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class MultiAutLaunchTabGroup extends AbstractLaunchConfigurationTabGroup {
	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		setTabs(new ILaunchConfigurationTab[] {
				new MultiAutLaunchTab(),
				new CommonTab() });
	}

}
