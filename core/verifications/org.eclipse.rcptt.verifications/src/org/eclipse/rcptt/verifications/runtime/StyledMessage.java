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
package org.eclipse.rcptt.verifications.runtime;

import java.util.LinkedHashMap;

import org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry;

public class StyledMessage {
	private String message;
	private LinkedHashMap<StyleRangeEntry, Object> styles;

	public StyledMessage(String message, LinkedHashMap<StyleRangeEntry, Object> styles) {
		this.message = message;
		this.styles = styles;
	}

	public String getMessage() {
		return message;
	}

	public LinkedHashMap<StyleRangeEntry, Object> getStyles() {
		return styles;
	}
}
