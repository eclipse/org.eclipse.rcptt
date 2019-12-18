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

/**
 * This enum represents state of the {@link AutLaunch}. AUT launch has following
 * life cycle:
 * 
 * <pre>
 * <code>
 * LAUNCH --> ACTIVE <-> RESTART
 *            /               /
 *           +-> TERMINATE <-+
 * </code>
 * </pre>
 * 
 * @author Yuri Strot
 * @see AutLaunch
 */
public enum AutLaunchState {

	/**
	 * AUT was launched but is not ready for work. There is initial state.
	 */
	LAUNCH,

	/**
	 * AUT launched and ready for work.
	 */
	ACTIVE,

	/**
	 * Launched AUT is restarting. After restart launch state will be changed to
	 * {@link #ACTIVE}
	 */
	RESTART,

	/**
	 * AUT launch was terminated.
	 */
	TERMINATE

}
