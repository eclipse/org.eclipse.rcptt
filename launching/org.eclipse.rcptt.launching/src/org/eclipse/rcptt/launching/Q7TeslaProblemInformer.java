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
/**
 * 
 */
package org.eclipse.rcptt.launching;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.eclipse.core.runtime.IStatus;

import org.eclipse.rcptt.internal.launching.ExecutionStatus;
import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.tesla.core.TeslaScenarioContainer;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.internal.core.SimpleCommandPrinter;
import org.eclipse.rcptt.tesla.internal.core.network.IProgressInformer;
import org.eclipse.rcptt.tesla.recording.core.ecl.EclCodePart;
import org.eclipse.rcptt.tesla.recording.core.ecl.EclRecorder;

public final class Q7TeslaProblemInformer implements IProgressInformer {
	private final IStatus[] s;

	public Q7TeslaProblemInformer(IStatus[] s) {
		this.s = s;
	}

	public void generateCodeFor(TeslaScenarioContainer container, int index) {
	}

	public void appendText(String string) {
	}

	public void handleError(TeslaScenarioContainer container, Command command,
			int index, String message, AdvancedInformation info) {
		StringBuilder errorMessage = new StringBuilder("Failed to replay");
		try {
			EclCodePart codePart = new EclRecorder().getCodeLineForCommand(
					container.getScenario(), index);
			if (codePart.getCodePart() != null) {
				errorMessage.append(" [" + codePart.getCodePart() + "]");
			}
			if (codePart.getLineNumber() > 0) {
				errorMessage.append(" at line " + codePart.getLineNumber());
			}
		} catch (Throwable e) {
			errorMessage.append(e.getMessage());
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			e.printStackTrace(new PrintStream(out));
			errorMessage.append(new String(out.toByteArray()));
		}
		if (message != null) {
			errorMessage.append("\nReason:" + message);
		}
		errorMessage.append("\n" + "Tesla command:"
				+ SimpleCommandPrinter.toString(command));

		ExecutionStatus executionStatus = new ExecutionStatus(IStatus.ERROR,
				Q7LaunchingPlugin.PLUGIN_ID, errorMessage.toString());
		// Add advanced information if present
		if (info != null) {
			executionStatus.setAdvancedInfo(info);
		}
		s[0] = executionStatus;
	}
}