package org.eclipse.rcptt.ui.launching;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;

public interface ITestEngineLaunchConfig {

	public void createControl(Composite parent, Listener listener);

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration);

	public void initializeFrom(ILaunchConfiguration configuration);

	public void performApply(ILaunchConfigurationWorkingCopy configuration);

	public String validatePage();

}
