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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.rcptt.ecl.runtime.IEMFConverter;

import org.eclipse.rcptt.verifications.status.EVerificationStatus;
import org.eclipse.rcptt.verifications.status.StatusFactory;
import org.eclipse.rcptt.verifications.status.StatusPackage;

public class VerificationStatusConverter implements
		IEMFConverter<VerificationStatus, EVerificationStatus> {

	public VerificationStatusConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public VerificationStatus fromEObject(EVerificationStatus eStatus) throws CoreException {
		return new VerificationStatus(eStatus.getSeverity(), eStatus.getPluginId(), eStatus.getMessage(),
				eStatus.getResource(), eStatus.getData());
	}

	@Override
	public EVerificationStatus toEObject(VerificationStatus status) throws CoreException {
		EVerificationStatus eStatus = StatusFactory.eINSTANCE.createEVerificationStatus();
		eStatus.setMessage(status.getMessage());
		eStatus.setPluginId(status.getPlugin());
		eStatus.setResource(status.getResourceId());
		eStatus.setSeverity(status.getSeverity());
		eStatus.getData().addAll(status.getData());
		return eStatus;
	}

	@Override
	public Class<VerificationStatus> getJavaClass() {
		return VerificationStatus.class;
	}

	@Override
	public EClass getEClass() {
		return StatusPackage.eINSTANCE.getEVerificationStatus();
	}

}
