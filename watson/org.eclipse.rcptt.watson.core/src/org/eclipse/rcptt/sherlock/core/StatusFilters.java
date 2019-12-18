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
package org.eclipse.rcptt.sherlock.core;

import org.eclipse.core.runtime.IStatus;

public class StatusFilters {
	private static enum AllStatusFilter implements IStatusFilter {
		INSTANCE;

		public boolean matches(IStatus status) {
			return true;
		}
	}

	public static IStatusFilter all() {
		return AllStatusFilter.INSTANCE;
	}

	private static class SevirityStatusFilter implements IStatusFilter {
		private final int severityMask;

		public SevirityStatusFilter(int severityMask) {
			this.severityMask = severityMask;
		}

		public boolean matches(IStatus status) {
			return status.matches(severityMask);
		}
	}

	public static IStatusFilter sevirity(int severityMask) {
		return new SevirityStatusFilter(severityMask);
	}
}
