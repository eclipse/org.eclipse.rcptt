/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.launching.IExecutable.State;
import org.eclipse.rcptt.reporting.core.SimpleSeverity;
import org.eclipse.swt.graphics.Image;

import com.google.common.base.Preconditions;

public enum StateImageProvider {
	TEST(Images.SCENARIO_WAIT, Images.SCENARIO_RUN, Images.SCENARIO_STOP, Images.SCENARIO_FAIL, Images.SCENARIO_PASS),
	CONTEXT(Images.CONTEXT_WAIT, Images.CONTEXT_RUN, Images.CONTEXT_STOP, Images.CONTEXT_FAIL, Images.CONTEXT_PASS),
	VERIFICATION(Images.VERIFICATION_WAIT, Images.VERIFICATION_RUN, Images.VERIFICATION_STOP, Images.VERIFICATION_FAIL,
			Images.VERIFICATION_PASS),
	SUITE(Images.EXECUTION_SESSION, Images.EXECUTION_SESSION_RUN, Images.EXECUTION_SESSION_STOP,
			Images.EXECUTION_SESSION_FAIL, Images.EXECUTION_SESSION_OK);

	private final String wait;
	private final String run;
	private final String cancel;
	private final String error;
	private final String pass;
	public Image getStateImage(IExecutable.State state, IStatus result) throws CoreException {
		Preconditions.checkState(state != State.COMPLETED || result != null);
		switch (state) {
		case WAITING:
			return Images.getImage(wait);
		case RUNNING:
			return Images.getImage(run);
		case COMPLETED:
			switch (SimpleSeverity.create(result)) {
			case CANCEL:
				return Images.getImage(cancel);
			case ERROR:
				return Images.getImage(error);
			case OK:
				return Images.getImage(pass);
			}
		}
		MultiStatus rv = new MultiStatus(RcpttPlugin.PLUGIN_ID, 0, new IStatus[] { result },
				"Failed to create status for state " + state, null) {
			{
				setSeverity(IStatus.ERROR);
			}
		};
		throw new CoreException(rv);
	}

	StateImageProvider(String wait, String run, String cancel, String error, String pass) {
		this.wait = wait;
		this.run = run;
		this.cancel = cancel;
		this.error = error;
		this.pass = pass;
	}

}
