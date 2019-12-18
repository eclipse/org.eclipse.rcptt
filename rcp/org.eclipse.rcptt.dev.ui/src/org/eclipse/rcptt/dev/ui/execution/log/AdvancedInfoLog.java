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
package org.eclipse.rcptt.dev.ui.execution.log;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.rcptt.core.persistence.PersistenceManager;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.ecl.model.GetAdvancedInfo;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;

public class AdvancedInfoLog {

	public static void addLogFile(IExecutable executable, String stepDesc)
			throws CoreException, IOException, InterruptedException {

		GetAdvancedInfo advInfoCmd = TeslaFactory.eINSTANCE
				.createGetAdvancedInfo();

		executable.getAut().execute(advInfoCmd);
		Object object = executable.getAut().execute(
				TeslaFactory.eINSTANCE.createSetupPlayer());
		if (object instanceof AdvancedInformation) {
			Resource resource = ((AdvancedInformation) object).eResource();
			resource.setURI(URI.createPlatformResourceURI("ExecutionDump/"
					+ executable.getName() + " " + getTimeStamp() + " "
					+ stepDesc + ".ecore", false));
			PersistenceManager.getInstance().saveResource(resource);
		}
	}

	private static String getTimeStamp() {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy_MM_dd_HH_mm_ss");
		return dateFormat.format(date);
	}

}
