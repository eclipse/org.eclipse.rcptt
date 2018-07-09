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
package org.eclipse.rcptt.maven.util;

import java.util.Map;
import java.util.Map.Entry;

public class TestEngine {
	private String id;
	private Map<String, String> parameters;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (parameters != null) {
			for (Entry<String, String> entry : parameters.entrySet()) {
				if (sb.length() > 0) {
					sb.append(";");
				}
				String key = entry.getKey();
				String value = entry.getValue();
				if (value == null) {
					value = "";
				}
				sb.append(String.format("%s=%s", key, value));
			}
		}
		if (sb.length() > 0) {
			sb.insert(0, ":");
		}
		sb.insert(0, id);
		return sb.toString();
	}
}
