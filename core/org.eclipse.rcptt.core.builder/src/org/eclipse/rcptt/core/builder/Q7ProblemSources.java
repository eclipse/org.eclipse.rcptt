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
package org.eclipse.rcptt.core.builder;

public enum Q7ProblemSources {
	ERR_SYNTAX(1, false),
	WARN_OBSOLETE_GETPARAM_CMD(101, true),
	WARN_OBSOLETE_SETPARAM_CMD(102, false);

	private final int sourceId;
	private final boolean isQuickFixable;

	private Q7ProblemSources(int sourceId, boolean isQuickFixable) {
		this.sourceId = sourceId;
		this.isQuickFixable = isQuickFixable;
	}

	public int getSourceId() {
		return sourceId;
	}

	public boolean isQuickFixable() {
		return isQuickFixable;
	}

	public static boolean isQuickFixable(int sourceId) {
		for (Q7ProblemSources val : Q7ProblemSources.values()) {
			if (val.getSourceId() == sourceId) {
				return val.isQuickFixable();
			}
		}
		return false;
	}
}
