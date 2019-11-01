/*******************************************************************************
 * Copyright (c) 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.zephyr;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.rcptt.internal.zephyr.messages"; //$NON-NLS-1$
	public static String ZephyrPlugin_ErrorWhileSaving;
	public static String ZephyrPlugin_ErrorWhileGetting;
	public static String ZephyrService_ZephyrIsNotEnabled;
	public static String ZephyrService_SuccessfullyCreatedClient;
	public static String ZephyrService_ErrorWhileGettingLaunchProperty;
	public static String ZephyrService_TestCasePropertyIsNotSpecified;
	public static String ZephyrService_TestCaseCanceled;
	public static String ZephyrService_ErrorWhileGettingTestCaseProperty;
	public static String ZephyrService_FailedToSetUpConnection;
	public static String ZephyrService_InvalidParameterValue;
	public static String ZephyrService_InvalidZephyrId;
	public static String ZephyrService_InvalidURL;
	public static String ZephyrService_URLShouldEndsWithSlash;
	public static String ZephyrService_InvalidBoolean;
	public static String ZephyrService_UrlInvalid;
	public static String ZephyrService_UrlSslError;
	public static String ZephyrService_UrlConnectionError;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
