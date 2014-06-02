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
package org.eclipse.rcptt.ui.utils;

import static org.eclipse.emf.ecore.util.EcoreUtil.copy;
import static org.eclipse.emf.ecore.util.EcoreUtil.copyAll;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.core.recording.CommandInfo;
import org.eclipse.rcptt.core.recording.CommandSet;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario;
import org.eclipse.rcptt.tesla.recording.core.ecl.EclRecorder;

public class TeslaUtils {

	private TeslaUtils() {
	}

	public static String selectorOf(CommandSet commandSet) {
		// since TeslaSelectorParser is destructive (!) on its inputs,
		// we need to copy everything we pass to the insides of it

		TeslaScenario scenario = RawFactory.eINSTANCE.createTeslaScenario();

		List<Command> commands = new ArrayList<Command>();
		List<CommandToElementEntry> commandToElements =
				new ArrayList<CommandToElementEntry>();
		for (CommandInfo ci : commandSet.getCommands()) {
			commands.add(copy(ci.getCommand()));

			CommandToElementEntry entry = RawFactory.eINSTANCE.createCommandToElementEntry();
			entry.setCommand(copy(ci.getCommand()));
			entry.getElements().addAll(copyAll(ci.getElements()));
			commandToElements.add(entry);
		}
		scenario.getCommands().addAll(commands);
		scenario.getElementMapping().addAll(commandToElements);

		EclRecorder recorder = new EclRecorder();
		return recorder.selectorOf(scenario, copy(commandSet.getElement()));
	}
}
