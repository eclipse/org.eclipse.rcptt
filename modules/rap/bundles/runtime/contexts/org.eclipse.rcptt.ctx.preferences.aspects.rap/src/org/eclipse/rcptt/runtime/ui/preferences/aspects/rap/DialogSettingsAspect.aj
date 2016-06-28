package org.eclipse.rcptt.runtime.ui.preferences.aspects.rap;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import org.eclipse.rcptt.internal.runtime.ui.preferences.Activator;
import org.eclipse.rcptt.runtime.ui.preferences.DialogSettingsManager;

public privileged aspect DialogSettingsAspect {

	public DialogSettingsAspect() {
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(AbstractUIPlugin uiPlugin): 
		execution(void org.eclipse.rap.ui.plugin.AbstractUIPlugin.loadDialogSettings()) && target(uiPlugin) {
		try {
			IDialogSettings dialogSettings = uiPlugin.getDialogSettings();
			if (dialogSettings != null) {
				DialogSettingsManager.getInstance().addSettings(
						uiPlugin.getBundle(), dialogSettings);
			}
		} catch (Throwable e) {
			Activator.log(e);
		}
	}
}
