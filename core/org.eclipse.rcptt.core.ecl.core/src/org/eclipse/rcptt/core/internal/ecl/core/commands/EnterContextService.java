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
package org.eclipse.rcptt.core.internal.ecl.core.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.core.ContextTypeManager;
import org.eclipse.rcptt.core.ecl.core.model.EnterContext;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.parser.ScriptErrorStatus;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ReportingFactory;
import org.eclipse.rcptt.reporting.ResultStatus;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.InfoFactory;
import org.eclipse.rcptt.tesla.ecl.TeslaErrorStatus;
import org.eclipse.rcptt.tesla.internal.core.TeslaProcessorManager;
import org.eclipse.rcptt.tesla.internal.core.info.GeneralInformationCollector;
import org.eclipse.rcptt.tesla.internal.core.processing.ITeslaCommandProcessor;
import org.eclipse.swt.widgets.Display;

public class EnterContextService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		EnterContext ewc = (EnterContext) command;
		final Context data = ewc.getData();
		final INodeBuilder nde = ReportManager.getCurrentReportNode().beginTask(data.getName() == null ? "Unnamed ctx"
				: data.getName());
		Q7Info info = ReportingFactory.eINSTANCE.createQ7Info();
		info.setType(ItemKind.CONTEXT);
		info.setId(data.getId());
		info.setTags(data.getTags());
		info.setSubtype(data.getId());
		info.setDescription(data.getDescription());
		ReportHelper.setInfo(nde, info);
		try {
			ContextTypeManager.getInstance().apply(data, context.getSession());
		} catch (final Throwable e) {
			ReportHelper.setResult(nde, ResultStatus.FAIL, e.getMessage());
			boolean processed = false;
			if (e instanceof CoreException
					&& ((CoreException) e).getStatus() instanceof ScriptErrorStatus) {
				ScriptErrorStatus sest = (ScriptErrorStatus) ((CoreException) e)
						.getStatus();
				if (sest.getCause() instanceof TeslaErrorStatus) {
					TeslaErrorStatus tes = (TeslaErrorStatus) sest.getCause();
					
					AdvancedInformation advancedInfo = tes.getInfo();
					if (advancedInfo != null) {
						ReportHelper.addSnapshotWithData(nde, advancedInfo);
						processed = true;
					}
				}
			}
			if (!processed) {
				final AdvancedInformation information = InfoFactory.eINSTANCE
						.createAdvancedInformation();
				final ITeslaCommandProcessor[] processors = new TeslaProcessorManager()
						.getProcessors();
				try {
					final boolean infoCollected[] = { false };
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							for (ITeslaCommandProcessor processor : processors) {
								processor.collectInformation(information, null);
							}
							infoCollected[0] = true;
						}
					});
					long waitStart = System.currentTimeMillis();
					while (!infoCollected[0]
							&& (System.currentTimeMillis() - waitStart) < 15000) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException eee) {
							break;
						}
					}
				} catch (Throwable eee) {
					// ignore
				}
				GeneralInformationCollector.collectInformation(information);
				ReportHelper.addSnapshotWithData(nde, information);
			}
			if (e instanceof CoreException) {
				throw (CoreException) e;
			} else {
				throw new CoreException(new Status(IStatus.ERROR,
						org.eclipse.rcptt.core.internal.ecl.core.Activator.PLUGIN_ID,
						"Failed to apply context: " + e.getMessage(), e));
			}

		} finally {
			nde.endTask();
		}
		return Status.OK_STATUS;
	}
}
