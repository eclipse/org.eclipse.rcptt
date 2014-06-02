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
package org.eclipse.rcptt.core.internal.ecl.core.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.core.IVerificationProcessor;
import org.eclipse.rcptt.core.VerificationTypeManager;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.core.ecl.core.model.CreateVerification;

public class CreateVerificationService implements ICommandService {

	@Override
	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		final CreateVerification createVerification = (CreateVerification) command;

		IVerificationProcessor processor = VerificationTypeManager.getInstance().
				getProcessor(createVerification.getType());
		Verification verification = processor.create(createVerification.getParam(),
				context);
		context.getOutput().write(verification);

		return Status.OK_STATUS;
	}

}
