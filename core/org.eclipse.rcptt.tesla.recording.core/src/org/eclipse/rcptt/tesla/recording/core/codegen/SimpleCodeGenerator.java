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
package org.eclipse.rcptt.tesla.recording.core.codegen;

import java.util.List;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario;
import org.eclipse.rcptt.tesla.core.ui.Widget;
import org.eclipse.rcptt.tesla.internal.core.SimpleCommandPrinter;
import org.eclipse.rcptt.tesla.recording.core.RecordingCodeGenerator;
import org.eclipse.rcptt.tesla.recording.core.IStatementList;

public class SimpleCodeGenerator extends RecordingCodeGenerator {

	@Override
	public void generateCode(TeslaScenario scenario, IStatementList statements) {
		StringBuilder builder = new StringBuilder();
		List<Command> commands = getCommands(scenario);
		for (int i = 0; i < commands.size(); i++) {
			Command cmd = commands.get(i);
			List<Element> elements = getElements(scenario, cmd);
			if (elements != null) {
				builder.append("======>");
				for (Element element : elements) {
					builder.append(SimpleCommandPrinter.toString(element))
							.append(',');
				}
				builder.append("<====== ");
			}
			builder.append(SimpleCommandPrinter.toString(cmd));
			List<Widget> controls = getControls(scenario, cmd);
			if (controls != null) {
				builder.append("-------->");
				for (Widget control : controls) {
					builder.append(SimpleCommandPrinter.toString(control, false))
							.append(',');
				}
			}
			statements.add(builder.toString());
			builder = new StringBuilder();
		}
	}
}
