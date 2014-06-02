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
package org.eclipse.rcptt.tesla.recording.core;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario;
import org.eclipse.rcptt.tesla.core.ui.Widget;

public abstract class RecordingCodeGenerator {

	public String generateCode(TeslaScenario scenario) {
		StringStatementList statements = new StringStatementList();
		generateCode(scenario, statements);
		return statements.toString();
	}

	public abstract void generateCode(TeslaScenario scenario,
			IStatementList statements);

	protected synchronized List<Command> getCommands(TeslaScenario scenario) {
		return scenario.getCommands();
	}

	protected synchronized List<Element> getElements(TeslaScenario scenario,
			Command cmd) {
		EList<CommandToElementEntry> elementMapping = scenario
				.getElementMapping();
		for (CommandToElementEntry commandToElementEntry : elementMapping) {
			if (commandToElementEntry.getCommand().equals(cmd)) {
				return commandToElementEntry.getElements();
			}
		}
		return null;
	}

	protected synchronized List<Widget> getControls(TeslaScenario scenario,
			Command cmd) {
		EList<CommandToElementEntry> elementMapping = scenario
				.getElementMapping();
		for (CommandToElementEntry commandToElementEntry : elementMapping) {
			if (commandToElementEntry.getCommand().equals(cmd)) {
				return commandToElementEntry.getControls();
			}
		}
		return null;
	}

}
