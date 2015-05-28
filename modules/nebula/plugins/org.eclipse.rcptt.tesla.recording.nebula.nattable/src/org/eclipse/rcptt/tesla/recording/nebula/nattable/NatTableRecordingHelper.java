/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.recording.nebula.nattable;

import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.recording.core.swt.BasicRecordingHelper;

public class NatTableRecordingHelper extends BasicRecordingHelper<SWTUIElement> {

	private static NatTableRecordingHelper mapper;

	public static NatTableRecordingHelper getHelper() {
		if (mapper == null) {
			mapper = new NatTableRecordingHelper();
		}
		return mapper;
	}

}
