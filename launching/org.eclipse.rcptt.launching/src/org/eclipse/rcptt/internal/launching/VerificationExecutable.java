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
package org.eclipse.rcptt.internal.launching;

import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.launching.AutLaunch;

public abstract class VerificationExecutable extends DataExecutable {

	public VerificationExecutable(AutLaunch launch, IVerification verification,
			boolean debug, ExecutionPhase phase) {
		super(launch, verification, debug, phase);
	}

	@Override
	public IVerification getActualElement() {
		return (IVerification) super.getActualElement();
	}

	public int getType() {
		return TYPE_VERIFICATION;
	}

	@Override
	public String toString() {
		return "Verification: " + getActualElement().getName();
	}

}
