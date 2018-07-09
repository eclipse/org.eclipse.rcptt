package org.eclipse.rcptt.internal.launching.ext.ui;

import java.util.Map;

import org.eclipse.debug.internal.ui.launchConfigurations.EnvironmentVariable;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.rcptt.launching.target.ITargetPlatformHelper;
import org.eclipse.swt.widgets.TableItem;

@SuppressWarnings("restriction")
public class AUTEnvironmentTab extends EnvironmentTab implements IAUTListener {

	@Override
	public void update(ITargetPlatformHelper info) {
		Map<String, String> envs = info.getIniEnvironment();
		for (Map.Entry<String, String> env : envs.entrySet()) {
			addVariableFromIniFile(env.getKey(), env.getValue());
		}
	}

	private void addVariableFromIniFile(String name, String value) {
		TableItem[] items = environmentTable.getTable().getItems();
		for (int i = 0; i < items.length; i++) {
			EnvironmentVariable existingVariable = (EnvironmentVariable) items[i].getData();
			if (existingVariable.getName().equals(name) && existingVariable.getValue().equals(value)) {
				return;
			}
		}
		addVariable(new EnvironmentVariable(name, value));
	}

}
