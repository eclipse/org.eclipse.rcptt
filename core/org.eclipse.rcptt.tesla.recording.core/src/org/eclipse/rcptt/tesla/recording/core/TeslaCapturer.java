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
package org.eclipse.rcptt.tesla.recording.core;

import java.util.List;

import org.eclipse.rcptt.tesla.core.TeslaScenarioContainer;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransferKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent;
import org.eclipse.rcptt.tesla.core.ui.Widget;
import org.eclipse.rcptt.tesla.internal.core.SimpleCommandPrinter;

public class TeslaCapturer implements ITeslaRecordingListener {
	private TeslaScenarioContainer container = new TeslaScenarioContainer();
	private boolean printingEnabled = false;

	public void enable() {
		TeslaRecorder.getInstance().addListener(this);
	}

	public void disable() {
		TeslaRecorder.getInstance().removeListener(this);
	}

	public void recordCommand(Command command, List<Element> elements,
			CommandTransferKind kind, List<Widget> controls, int index,
			List<RawEvent> rawEvents) {
		if (command != null) {
			container.processTransfer(command, elements, kind, controls, index,
					rawEvents);
			if (printingEnabled) {
				// System.out.println("COMMAND:");
				System.out.println(SimpleCommandPrinter.toString(command));
			}
		}
	}

	public void enablePrints() {
		this.printingEnabled = true;
	}
}
