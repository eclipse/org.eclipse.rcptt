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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Status;

import org.eclipse.rcptt.verifications.status.VerificationStatusData;

public class VerificationStatus extends Status {
	private String resourceId;
	private List<VerificationStatusData> data;

	public VerificationStatus(int severity, String pluginId, String message, String resourceId,
			Collection<? extends VerificationStatusData> data) {
		super(severity, pluginId, message);
		this.resourceId = resourceId;
		this.data = new ArrayList<VerificationStatusData>(data);
	}

	public List<VerificationStatusData> getData() {
		return data;
	}

	public String getResourceId() {
		return resourceId;
	}
}
