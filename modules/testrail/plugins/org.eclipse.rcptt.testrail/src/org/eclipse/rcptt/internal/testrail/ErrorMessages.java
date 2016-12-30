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

public class ErrorMessages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.rcptt.internal.testrail.error-messages"; //$NON-NLS-1$
	public static String TestRailPlugin_ErrorWhileSaving;
	public static String TestRailPlugin_ErrorWhileGetting;
	public static String TestRailService_ErrorWhileGettingTestCaseProperty;
	public static String TestRailService_FailedToSetUpConnection;
	public static String TestRailAPIClient_FailedToAddTestRun;
	public static String TestRailAPIClient_FailedToAddTestResult;
	public static String APIClient_HTTPError;
	public static String APIClient_ErrorWhileSendingRequest;
	public static String APIClient_ErrorWhileGenerationRequest;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, ErrorMessages.class);
	}

	private ErrorMessages() {
	}
}
