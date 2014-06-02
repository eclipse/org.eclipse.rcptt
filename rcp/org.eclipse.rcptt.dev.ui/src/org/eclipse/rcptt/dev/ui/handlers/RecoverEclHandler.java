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
package org.eclipse.rcptt.dev.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;

import org.eclipse.rcptt.core.Scenarios;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.dev.ui.dialogs.RecoverEclWarningDialog;
import org.eclipse.rcptt.ui.actions.ScenariosActionHandler;

public class RecoverEclHandler extends ScenariosActionHandler {

	public RecoverEclHandler() {
		super("Recovering scenatios from captured data...");
	}

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		if (RecoverEclWarningDialog.INSTANCE.open()) {
			return super.execute(event);
		}
		return null;
	}

	@Override
	protected boolean doExecute(ITestCase scenario) {
		try {
			if (Scenarios.isEclMode((Scenario) scenario.getNamedElement())) {
				IQ7NamedElement copy = scenario
						.getWorkingCopy(new NullProgressMonitor());
				try {
					Scenario sc = (Scenario) copy.getNamedElement();
					Scenarios.setTypeToTesla(sc, true);
					Scenarios.setTypeToEcl(sc);
					copy.commitWorkingCopy(true, new NullProgressMonitor());
				} finally {
					copy.discardWorkingCopy();
				}
				return true;
			}
		} catch (ModelException e) {
			e.printStackTrace();
		}
		return false;
	}
}
