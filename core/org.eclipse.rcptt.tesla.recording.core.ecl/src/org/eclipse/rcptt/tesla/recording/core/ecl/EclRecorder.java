/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.recording.core.ecl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.util.DefaultFormatter;

import org.eclipse.rcptt.tesla.core.protocol.GetState;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.WaitForState;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario;
import org.eclipse.rcptt.tesla.recording.core.IStatementList;
import org.eclipse.rcptt.tesla.recording.core.RecordingCodeGenerator;
import org.eclipse.rcptt.tesla.recording.core.ecl.parser.TeslaParser;
import org.eclipse.rcptt.tesla.recording.core.internal.ecl.ECLStringConverter;
import org.eclipse.rcptt.tesla.recording.core.internal.ecl.TeslaSelectorParser;

public class EclRecorder extends RecordingCodeGenerator {

	@Override
	public void generateCode(TeslaScenario scenario, IStatementList statements) {
		throw new UnsupportedOperationException("Doesn't implemented yet");
	}

	@Override
	public String generateCode(TeslaScenario scenario) {
		TeslaParser parser = new TeslaParser();
		org.eclipse.rcptt.ecl.core.Command eclCommand = parser.teslaScenario(scenario, null);
		return ECLStringConverter.INSTANCE.convert(eclCommand);
	}

	public EclCodePart getCodeLineForCommand(TeslaScenario scenario,
			int commandIndex) {
		if (commandIndex == 0) {
			return new EclCodePart(1, null);
		} else {
			TeslaParser parser = new TeslaParser();
			// if select skip for non select
			EList<org.eclipse.rcptt.tesla.core.protocol.raw.Command> commands = scenario
					.getCommands();
			org.eclipse.rcptt.tesla.core.protocol.raw.Command cm = commands
					.get(commandIndex);
			int realCommandIndex = commandIndex;
			if (isSkipCommand(cm)) {
				int i = 0;
				for (i = commandIndex + 1; i < commands.size(); i++) {
					if (!isSkipCommand(commands.get(i))) {
						break;
					}
				}
				realCommandIndex = i + 1;

			}
			org.eclipse.rcptt.ecl.core.Command eclCommand = parser.teslaScenario(scenario,
					realCommandIndex);

			String result = ECLStringConverter.INSTANCE.convert(eclCommand);
			String[] parts = result.split("\n");
			String lastLine = "";
			int lineNumber = 0;
			for (int i = parts.length - 1; i >= 0; i--) {
				String curLine = parts[i].trim();
				if (!curLine.equals("}")) {
					lastLine = curLine;
					lineNumber = i;
					break;
				}
			}
			return new EclCodePart(lineNumber + 1, lastLine);
		}
	}

	private boolean isSkipCommand(org.eclipse.rcptt.tesla.core.protocol.raw.Command cm) {
		return cm instanceof SelectCommand || cm instanceof WaitForState
				|| cm instanceof GetState;
	}

	public String selectorOf(TeslaScenario scenario, Element element) {
		TeslaSelectorParser parser = new TeslaSelectorParser(scenario);
		parser.parse();
		return ECLStringConverter.INSTANCE.convert(parser.selectorOf(element, true),
				new DefaultFormatter(false));
	}
}
