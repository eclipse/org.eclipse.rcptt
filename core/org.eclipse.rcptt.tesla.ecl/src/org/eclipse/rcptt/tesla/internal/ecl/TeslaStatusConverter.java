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
package org.eclipse.rcptt.tesla.internal.ecl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.rcptt.ecl.internal.core.ProcessStatusConverter;
import org.eclipse.rcptt.ecl.runtime.IEMFConverter;
import org.eclipse.rcptt.tesla.ecl.TeslaErrorStatus;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;
import org.eclipse.rcptt.tesla.ecl.model.TeslaPackage;
import org.eclipse.rcptt.tesla.ecl.model.TeslaProcessStatus;

public class TeslaStatusConverter implements
		IEMFConverter<TeslaErrorStatus, TeslaProcessStatus> {

	public TeslaErrorStatus fromEObject(TeslaProcessStatus ps)
			throws CoreException {
		return new TeslaErrorStatus(ps.getSeverity(), ps.getPluginId(),
				ps.getMessage(), ps.getInfo());
	}

	public TeslaProcessStatus toEObject(TeslaErrorStatus status)
			throws CoreException {
		TeslaProcessStatus ps = TeslaFactory.eINSTANCE
				.createTeslaProcessStatus();
		ProcessStatusConverter.toEObject(status, ps);
		ps.setInfo(status.getInfo());
		return ps;
	}

	public Class<TeslaErrorStatus> getJavaClass() {
		return TeslaErrorStatus.class;
	}

	public EClass getEClass() {
		return TeslaPackage.Literals.TESLA_PROCESS_STATUS;
	}

}
