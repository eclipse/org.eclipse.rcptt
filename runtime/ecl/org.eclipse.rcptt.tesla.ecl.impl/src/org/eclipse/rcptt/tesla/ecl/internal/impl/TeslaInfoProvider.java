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
package org.eclipse.rcptt.tesla.ecl.internal.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.sherlock.core.reporting.AbstractEventProvider;
import org.eclipse.rcptt.sherlock.core.reporting.IReportBuilder;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.InfoFactory;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.internal.core.TeslaProcessorManager;
import org.eclipse.rcptt.tesla.internal.core.info.GeneralInformationCollector;
import org.eclipse.swt.widgets.Display;

public class TeslaInfoProvider extends AbstractEventProvider {
	public TeslaInfoProvider() {
	}

	public static AdvancedInformation getAdvancedInformation() throws InterruptedException, CoreException {
		FutureTask<AdvancedInformation> displayExec = new FutureTask<AdvancedInformation>(
				new Callable<AdvancedInformation>() {
					@Override
					public AdvancedInformation call() throws Exception {
						AdvancedInformation information = InfoFactory.eINSTANCE.createAdvancedInformation();
						new TeslaProcessorManager().collectInformation(information, null);
						GeneralInformationCollector.collectInformation(information);
						return information;
					}
				});
		Display.getDefault().asyncExec(displayExec);
		try {
			return displayExec.get(15, TimeUnit.SECONDS);
		} catch (ExecutionException e1) {
			throw new CoreException(RcpttPlugin.createStatus(e1));
		} catch (TimeoutException e1) {
			RcpttPlugin.log("GUI thread is blocked", e1); // Can't be helped,
															// GUI thread is
															// blocked.
			AdvancedInformation information = InfoFactory.eINSTANCE.createAdvancedInformation();
			GeneralInformationCollector.collectInformation(information);
			return information;
		}
	}

	@Override
	public void storeSnapshot(INodeBuilder node) {
		AdvancedInformation info = TeslaBridge.getLastInfo();
		if (info != null) {
			ReportHelper.addSnapshotWithData(node, info);
		}
	}

	@Override
	protected void initializeBuilder(IReportBuilder builder) {
	}
}
