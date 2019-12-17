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
package org.eclipse.rcptt.tesla.recording.core.gef;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.recording.core.swt.BasicRecordingHelper;

public class Draw2DRecordingHelper extends BasicRecordingHelper<Object> {
	private static Draw2DRecordingHelper mapper;

	public synchronized static Draw2DRecordingHelper getHelper() {
		if (mapper == null) {
			mapper = new Draw2DRecordingHelper();
		}
		return mapper;
	}

	public String getWidgetDetails(Element element) {
		return null;
	}
}
