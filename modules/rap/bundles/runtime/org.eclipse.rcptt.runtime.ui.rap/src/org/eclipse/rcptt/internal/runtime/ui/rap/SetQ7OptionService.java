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
package org.eclipse.rcptt.internal.runtime.ui.rap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.core.OptionsHandler;
import org.eclipse.rcptt.core.ecl.core.model.SetQ7Option;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;

public class SetQ7OptionService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		SetQ7Option s = (SetQ7Option) command;
		new OptionsHandler().applyOption(s.getKey(), s.getValue());
		
		if (s.getKey().equals(TeslaFeatures.STATUS_DIALOG_ALLOWED)) {
			TeslaEventManager.getManager().setStatusDialogModeAllowed(Boolean.valueOf(s.getValue()));
		}
		
		return Status.OK_STATUS;
	}
}
