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
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;
import org.eclipse.rcptt.sherlock.core.reporting.Procedure1;
import org.eclipse.rcptt.sherlock.core.reporting.ReportBuilder;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.InfoFactory;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.internal.core.info.GeneralInformationCollector;

public class AdvancedInfoService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {

		final IProcess finalContext = context;

		if (PlatformUI.isWorkbenchRunning()) {
			final boolean complete[] = { false };
			Thread askForInfoThread = new Thread(new Runnable() {
				public void run() {
					PlatformUI.getWorkbench().getDisplay()
							.syncExec(new Runnable() {

								public void run() {
									boolean mustClientShutdown = false;
									if (TeslaBridge.getClient() == null) {
										mustClientShutdown = true;
										TeslaBridge.setup();
									}
									try {
										TeslaBridge.makeScreenshot(true,
												"Timeout during execution");
										final AdvancedInformation info = TeslaBridge
												.getClient()
												.getAdvancedInformation(null);
										returnGeneralInfo(info, finalContext);
										if (ReportManager.getBuilder() != null) {
											ReportManager.getBuilder().withCurrentNode(new Procedure1<Node>() {
												
												@Override
												public void apply(Node node) {
													if (node != null) {
														Snaphot snaphot = ReportFactory.eINSTANCE.createSnaphot();
														snaphot.setTime(System.currentTimeMillis());
														snaphot.setData(EcoreUtil.copy(info));
														node.getSnapshots().add(snaphot);
													}
												}
											});
										}
									} finally {
										if (mustClientShutdown) {
											TeslaBridge.shutdown();
										}
										complete[0] = true;
									}
								}
							});

				}
			}, "get-advanced-info thread");
			askForInfoThread.start();
			askForInfoThread.join(10 * 1000); // Wait only 10 seconds.
			if (!complete[0]) {
				askForInfoThread.interrupt();
				returnGeneralInfo(null, finalContext);
			}
		}

		return Status.OK_STATUS;
	}

	private void returnGeneralInfo(AdvancedInformation info,
			final IProcess finalContext) {
		// Return general information in any case.
		if (info == null) {
			info = InfoFactory.eINSTANCE.createAdvancedInformation();
		}
		GeneralInformationCollector.collectInformation(info);

		if (info != null) {
			try {
				finalContext.getOutput().write(info);
			} catch (CoreException e) {
				TeslaImplPlugin.err(e.getMessage(), e);
			}
		}
	}
}
