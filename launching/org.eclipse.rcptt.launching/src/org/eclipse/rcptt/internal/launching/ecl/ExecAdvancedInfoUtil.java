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
package org.eclipse.rcptt.internal.launching.ecl;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.launching.ExecutionStatus;
import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.ecl.model.GetAdvancedInfo;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;

public class ExecAdvancedInfoUtil {
	
	private static IStatus setAdvancedInfo(AutLaunch launch, ExecutionStatus resultStatus) {
		AdvancedInformation info = null;
		try {
			// try to obtain advanced error information from AUT
			final GetAdvancedInfo advInfoCmd = TeslaFactory.eINSTANCE
					.createGetAdvancedInfo();
			final Object obj = launch.execute(advInfoCmd);
			if (obj instanceof AdvancedInformation)
				info = (AdvancedInformation) obj;
		} catch (Exception e) {
			return RcpttPlugin.createStatus(e);
		}
		if (info != null) {
			resultStatus.setAdvancedInfo(info);
		}
		return resultStatus;
	}

	public static IStatus askForAdvancedInfo(AutLaunch launch, String err) {
		final ExecutionStatus resultStatus = new ExecutionStatus(IStatus.CANCEL,
				Q7LaunchingPlugin.PLUGIN_ID, err);

		return setAdvancedInfo(launch, resultStatus);
	}

	public static IStatus askForAdvancedInfo(AutLaunch launch, IStatus status) {
		final ExecutionStatus resultStatus = new ExecutionStatus(status);

		return setAdvancedInfo(launch, resultStatus);
	}

}
