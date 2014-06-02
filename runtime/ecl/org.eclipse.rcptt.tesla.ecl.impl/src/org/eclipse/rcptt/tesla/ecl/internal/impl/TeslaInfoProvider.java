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
package org.eclipse.rcptt.tesla.ecl.internal.impl;

import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;
import org.eclipse.rcptt.sherlock.core.reporting.AbstractEventProvider;
import org.eclipse.rcptt.sherlock.core.reporting.IReportBuilder;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;

public class TeslaInfoProvider extends AbstractEventProvider {
	public TeslaInfoProvider() {
	}

	public void storeSnapshot(IReportBuilder builder, String type) {
		AdvancedInformation info = TeslaBridge.getLastInfo();
		if (info != null && builder != null) {
			Snaphot snapshot = builder.createSnapshot();
			snapshot.setData(info);
		}
//		if (builder != null) {
//			ReportScreenshotProvider.takeScreenshot(PlatformUI.getWorkbench()
//					.getDisplay());
//		}
	}

	@Override
	protected void initializeBuilder(IReportBuilder builder) {
	}
}
