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
package org.eclipse.rcptt.tesla.swt;

import org.eclipse.osgi.util.NLS;
import org.eclipse.rcptt.tesla.core.TeslaMessages;

public class TeslaSWTMessages extends TeslaMessages {

	private static final String BUNDLE_NAME = "org.eclipse.rcptt.tesla.swt.TeslaSWTMessages";//$NON-NLS-1$

	private TeslaSWTMessages() {
		// Do not instantiate
	}

	public static String SWTUIElement_ControlDisposed;
	public static String SWTUIElement_ControlNull;

	public static String SWTUIPlayer_CannotClickOnDisabledControl;
	public static String SWTUIPlayer_WorkbenchPartNotActivated;
	public static String SWTUIPlayer_DisposedControl_RawText;

	public static String SWTUIProcessor_OcrNotSupported;
	public static String SWTUIProcessor_CannotRecognizeText;
	public static String SWTUIProcessor_RecognizedTextNotContainsValue;
	public static String SWTUIProcessor_ControlNotContainsImage;
	public static String SWTUIProcessor_ImlNotSupported;
	public static String SWTUIProcessor_AssertIndexOutOfBounds;
	public static String SWTUIProcessor_AssertIndexOutOfBoundsListEmpty;
	public static String SWTUIProcessor_AssertFalseFailed;
	public static String SWTUIProcessor_AssertTrueFailed;
	public static String SWTUIProcessor_AssertEqualsFailed;
	public static String SWTUIProcessor_AssertNotEqualsFailed;
	public static String SWTUIProcessor_AssertEmptyFailed;
	public static String SWTUIProcessor_AssertNotEmptyFailed;
	public static String SWTUIProcessor_AssertContainsFailed;
	public static String SWTUIProcessor_AssertNotContainsFailed;
	public static String SWTUIProcessor_AssertMatchRegexFailed;
	public static String SWTUIProcessor_AssertNotMatchRegexFailed;
	public static String SWTUIProcessor_AssertFailed;
	public static String SWTUIProcessor_AssertSucceed;
	public static String SWTUIProcessor_CannotFindControl;
	public static String SWTUIProcessor_CannotSetText_DisabledControl;
	public static String SWTUIProcessor_CannotSetSpinnerValue_IncorrectFormat;
	public static String SWTUIProcessor_CannotSetSliderValue_IncorrectFormat;
	public static String SWTUIProcessor_CannotSetDataTimeValue_IncorrectFormat;
	public static String SWTUIProcessor_CannotClick_ControlDisabledDisposedOrInvisible;
	public static String SWTUIProcessor_CannotClick_PerspectiveNotContainsView;
	public static String SWTUIProcessor_CannotDoubleClick_ControlDisabledDisposedOrInvisible;
	public static String SWTUIProcessor_CannotSetSelection;

	public static String SWTUIProcessor_WidgetIsNotLink;
	public static String SWTUIProcessor_NoLinkFragments;
	public static String SWTUIProcessor_InvalidLinkRef;
	public static String SWTUIProcessor_LinkDisabled;

	public static String SWTUIProcessor_SetFocusWidgetIsNotControl;

	public static String IdentifyObjectUtil_FailedToInvokeMethod;

	static {
		NLS.initializeMessages(BUNDLE_NAME, TeslaSWTMessages.class);
	}
}
