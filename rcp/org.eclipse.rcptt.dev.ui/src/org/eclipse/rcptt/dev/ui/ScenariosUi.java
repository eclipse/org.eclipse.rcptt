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
package org.eclipse.rcptt.dev.ui;

import org.eclipse.rcptt.core.Scenarios;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.dev.ui.dialogs.ObsoleteEclFormatDialog;
import org.eclipse.rcptt.dev.ui.dialogs.UserModificationDialog;

public class ScenariosUi {

	public static boolean setTypeToEcl(Scenario scenario) {
		return Scenarios.setTypeToEcl(scenario);
	}

	public static boolean setTypeToTesla(Scenario scenario) {
		if (Scenarios.isEclMode(scenario)) {
			if (Scenarios.hasObsoleteEclFormat(scenario)) {
				ObsoleteEclFormatDialog.INSTANCE.open(scenario);
				return false;
			}
			if (Scenarios.hasUserModifications(scenario)) {
				boolean discard = UserModificationDialog.INSTANCE
						.open(scenario);
				if (!discard)
					return false;
			}
			return Scenarios.setTypeToTesla(scenario, true);
		}
		return false;
	}

	// Suppresses default constructor, ensuring non-instantiability.
	private ScenariosUi() {
	}
}
