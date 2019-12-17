/*******************************************************************************
 * Copyright (c) 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.zephyr.internal.ui;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.rcptt.zephyr.internal.ui.messages"; //$NON-NLS-1$
	public static String ZephyrPreferencePage_EnableIntegration;
	public static String ZephyrPreferencePage_Address;
	public static String ZephyrPreferencePage_Username;
	public static String ZephyrPreferencePage_Password;
	public static String ZephyrPreferencePage_Project;
	public static String ZephyrPreferencePage_Version;
	public static String ZephyrPreferencePage_Cycle;
	public static String ZephyrPreferencePage_Issue;
	public static String ZephyrPreferencePage_TestConnection;
	public static String ZephyrPreferencePage_IncorrectAddressMsg;
	public static String ZephyrPreferencePage_AddressEndsWithSlashMsg;
	public static String ZephyrPreferencePage_FieldNotSpecifiedMsg;
	public static String ZephyrPreferencePage_IncorrectProjectIdMsg;
	public static String ZephyrPreferencePage_FailedToConnectMsg;
	public static String ZephyrPreferencePage_SuccessfullyConnectedMsg;
	public static String ZephyrPreferencePage_AdvancedSectionLabel;
	public static String ZephyrPropertiesPage_AllPropertiesValid;
	public static String ZephyrPropertiesPage_CycleInvalid;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
