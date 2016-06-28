/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.report.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.rcptt.ecl.core.ProcessStatus;

class ReportEntry {
	public final String name;
	public final String id;
	public final int time;
	public final ProcessStatus status;
	public final String message;

	public ReportEntry(String name, String id, int time, ProcessStatus status, String message) {
		super();
		checkNotNull(name);
		checkNotNull(id);
		checkNotNull(time);
		checkNotNull(status);
		checkNotNull(message);
		this.message = message;
		this.name = name;
		this.id = id;
		this.time = time;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}
}