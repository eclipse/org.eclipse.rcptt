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
package org.eclipse.rcptt.testrail.internal.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.rcptt.testrail.internal.ui.messages"; //$NON-NLS-1$
	public static String TestRailLaunchConfig_TestRunIdField;
	public static String TestRailLaunchConfig_IncorrectTestRunIdMsg;
	public static String TestRailPreferencePage_EnableIntegration;
	public static String TestRailPreferencePage_Address;
	public static String TestRailPreferencePage_Username;
	public static String TestRailPreferencePage_Password;
	public static String TestRailPreferencePage_ProjectId;
	public static String TestRailPreferencePage_TestConnection;
	public static String TestRailPreferencePage_IncorrectAddressMsg;
	public static String TestRailPreferencePage_AddressEndsWithSlashMsg;
	public static String TestRailPreferencePage_FieldNotSpecifiedMsg;
	public static String TestRailPreferencePage_IncorrectProjectIdMsg;
	public static String TestRailPreferencePage_FailedToConnectMsg;
	public static String TestRailPreferencePage_SuccessfullyConnectedMsg;
	public static String TestRailPreferencePage_AdvancedSectionLabel;
	public static String TestRailPreferencePage_UseUnicode;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
