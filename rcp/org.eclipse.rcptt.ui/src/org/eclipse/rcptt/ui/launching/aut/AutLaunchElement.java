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
package org.eclipse.rcptt.ui.launching.aut;

import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.AutLaunchState;

public class AutLaunchElement extends AutElement {

	private AutLaunch launch;

	public AutLaunchElement(AutLaunch launch) {
		super(launch.getAut());
		this.launch = launch;
	}

	public AutLaunch getLaunch() {
		return launch;
	}

	@Override
	public boolean isLaunched() {
		return launch.getState() != AutLaunchState.TERMINATE;
	}

	@Override
	boolean couldBeStopped() {
		return isLaunched();
	}

	@Override
	public void stop() {
		launch.terminate();
	}

}
