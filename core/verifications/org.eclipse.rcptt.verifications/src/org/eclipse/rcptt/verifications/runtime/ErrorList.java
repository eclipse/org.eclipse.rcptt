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
package org.eclipse.rcptt.verifications.runtime;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.verifications.status.StatusFactory;
import org.eclipse.rcptt.verifications.status.VerificationStatusData;

public class ErrorList {
	private EList<VerificationStatusData> errors = new BasicEList<VerificationStatusData>();

	public void add(String error, Object... args) {
		VerificationStatusData newError = StatusFactory.eINSTANCE.createVerificationStatusData();
		newError.setMessage(String.format(error, args));
		errors.add(newError);
	}

	public void add(VerificationStatusData data) {
		errors.add(data);
	}

	public void throwIfAny(String message, String pluginId, String resourceId) throws CoreException {
		if (errors.size() == 0) {
			return;
		}
		for (VerificationStatusData data : errors) {
			data.setResourceId(resourceId);
		}
		throw new CoreException(new VerificationStatus(Status.ERROR, pluginId, message, resourceId, errors));
	}

	public boolean isEmpty() {
		return errors.isEmpty();
	}
}
