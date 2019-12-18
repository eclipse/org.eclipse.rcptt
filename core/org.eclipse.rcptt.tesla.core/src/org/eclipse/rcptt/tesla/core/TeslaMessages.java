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
package org.eclipse.rcptt.tesla.core;

import org.eclipse.osgi.util.NLS;

public class TeslaMessages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.rcptt.tesla.core.TeslaMessages";//$NON-NLS-1$

	protected TeslaMessages() {
		// Do not instantiate
	}

	public static String CommandProcessor_CannotExecuteCommandOverDisposedElement;
	public static String CommandProcessor_CannotFindWidget;
	public static String CommandProcessor_CannotExecuteCommandBecauseOfModalDialog;
	public static String CommandProcessor_CannotFindProperty;

	public static String TeslaFeatures_IdentifyMethodsNotProvided;

	static {
		NLS.initializeMessages(BUNDLE_NAME, TeslaMessages.class);
	}
}
