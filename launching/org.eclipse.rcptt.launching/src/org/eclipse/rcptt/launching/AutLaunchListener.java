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
package org.eclipse.rcptt.launching;

import java.util.List;

import org.eclipse.rcptt.core.launching.events.AutBundleState;
import org.eclipse.rcptt.internal.launching.aut.BaseAutLaunch;

/**
 * {@link AutLaunch} state listener
 * 
 * @author Yuri Strot
 * @see AutLaunchState
 */
public interface AutLaunchListener {

	/**
	 * Notify AUT launch state changed
	 * 
	 * @param launch
	 *            AUT launch
	 * @param state
	 *            new AUT state
	 */
	void stateChanged(AutLaunch launch, AutLaunchState state);

	void autStarted(AutLaunch baseAutLaunch, int eclPort, int teslaPort);

	void autInit(AutLaunch baseAutLaunch, List<AutBundleState> bundleState);

	void autLocationChange(BaseAutLaunch baseAutLaunch, String location);

}
