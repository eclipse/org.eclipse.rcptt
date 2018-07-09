/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.testrail;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.rcptt.internal.testrail.messages"; //$NON-NLS-1$
	public static String TestRailPlugin_ErrorWhileSaving;
	public static String TestRailPlugin_ErrorWhileGetting;
	public static String TestRailService_TestRailIsNotEnabled;
	public static String TestRailService_SuccessfullyCreatedClient;
	public static String TestRailService_ErrorWhileGettingLaunchProperty;
	public static String TestRailService_TestCasePropertyIsNotSpecified;
	public static String TestRailService_TestCaseCanceled;
	public static String TestRailService_ErrorWhileGettingTestCaseProperty;
	public static String TestRailService_FailedToSetUpConnection;
	public static String TestRailService_InvalidParameterValue;
	public static String TestRailService_InvalidTestRailId;
	public static String TestRailService_InvalidURL;
	public static String TestRailService_URLShouldEndsWithSlash;
	public static String TestRailService_InvalidBoolean;
	public static String TestRailAPIClient_FailedToGetTestCases;
	public static String TestRailAPIClient_FailedToAddTestRun;
	public static String TestRailAPIClient_FailedToAddTestResult;
	public static String APIClient_GeneratedRequest;
	public static String APIClient_RecievedResponse;
	public static String APIClient_HTTPError;
	public static String APIClient_ErrorWhileSendingRequest;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
