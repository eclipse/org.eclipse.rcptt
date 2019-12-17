/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.gef;

import org.eclipse.osgi.util.NLS;
import org.eclipse.rcptt.tesla.core.TeslaMessages;

public class TeslaGefMessages extends TeslaMessages {

	private static final String BUNDLE_NAME = "org.eclipse.rcptt.tesla.gef.TeslaGefMessages";//$NON-NLS-1$

	private TeslaGefMessages() {
		// Do not instantiate
	}

	public static String GefProcessor_CannotFindEditPart;
	public static String GefProcessor_CannotFindEditPart_DetailedMsg;
	public static String GefProcessor_CannotFindFigure;
	public static String GefProcessor_CannotFindFigure_DetailedMsg;
	public static String GefProcessor_CannotFindPalette;
	public static String GefProcessor_CannotFindPaletteTool;
	public static String GefProcessor_CannotFindDiagram;
	public static String GefProcessor_CannotFindDiagramOrCanvas;
	public static String GefProcessor_CannotFindHandle;
	public static String GefProcessor_CannotFindEditPartByClass;
	public static String GefProcessor_CannotFindFigureByAddress;
	public static String GefProcessor_CannotSelect;
	public static String GefProcessor_AssertFailed;

	static {
		NLS.initializeMessages(BUNDLE_NAME, TeslaGefMessages.class);
	}
}
