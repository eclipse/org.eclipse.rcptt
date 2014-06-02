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
package org.eclipse.rcptt.tesla.recording.core;

public class StringStatementList implements IStatementList {

	protected StringBuilder builder = new StringBuilder();

	protected static final String LINE_SEPARATOR = System
			.getProperty("line.separator");

	public void add(String statement) {
		builder.append(statement);
		builder.append(LINE_SEPARATOR);
	}

	@Override
	public String toString() {
		return builder.toString();
	}

}
