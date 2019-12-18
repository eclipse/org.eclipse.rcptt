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
package org.eclipse.rcptt.tesla.core.am;

public final class RecordingModeFeature {
	private static boolean isRecordingModeActive = false;

	private RecordingModeFeature() {
	}

	public static boolean isRecordingModeActive() {
		return isRecordingModeActive;
	}

	public static void setRecordingModeActive(boolean isRecordingModeActive) {
		RecordingModeFeature.isRecordingModeActive = isRecordingModeActive;
	}
}
