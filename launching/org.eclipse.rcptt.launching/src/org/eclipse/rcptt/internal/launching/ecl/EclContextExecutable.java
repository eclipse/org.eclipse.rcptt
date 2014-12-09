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
package org.eclipse.rcptt.internal.launching.ecl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.launching.ContextExecutable;
import org.eclipse.rcptt.internal.launching.reporting.ReportMaker;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ResultStatus;
import org.eclipse.rcptt.reporting.core.IQ7ReportConstants;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.tesla.core.TeslaLimits;

public class EclContextExecutable extends ContextExecutable {
	private Map<String, EObject> props;
	private boolean isEcl;

	public EclContextExecutable(AutLaunch launch, IContext context,
			boolean debug) {
		super(launch, context, debug);
		this.isEcl = isEclScriptContext(context);
	}

	protected void doExecuteContext(IProgressMonitor monitor) throws CoreException {
		launch.run(getActualElement(), TeslaLimits.getContextRunnableTimeout(), monitor, getPhase());
	}

	private static final String ECL_SCRIPT_TYPE_ID = "org.eclipse.rcptt.ctx.ecl";

	public static boolean isEclScriptContext(IQ7NamedElement context) {
		try {
			return context instanceof IContext &&
					ECL_SCRIPT_TYPE_ID.equals(((IContext) context).getType().getId());
		} catch (ModelException e) {
			return false;
		}
	}

	@Override
	protected IStatus doExecute() throws CoreException, InterruptedException {
		String description = "";
		if (isEcl) {
			Q7Info info = ReportHelper.createInfo();
			Context context = (Context) getActualElement().getModifiedNamedElement();
			description = context.getDescription();
			props = new HashMap<String, EObject>();
			info.setType(ItemKind.CONTEXT);
			info.setResult(ResultStatus.PASS);
			info.setTags(context.getTags());
			info.setId(context.getId());
			info.setDescription(description);
			props.put(IQ7ReportConstants.ROOT, info);

			ReportMaker.beginReportNode(getName(), props, launch);
		}
		IStatus resultStatus;

		try {
			doExecuteContext(executionMonitor);
			resultStatus = Status.OK_STATUS;
		} catch (CoreException e) {
			resultStatus = e.getStatus();
		}
		if (resultStatus.getSeverity() == IStatus.CANCEL) {
			// Cancel is called, lets collect correct message
			String message = "Context execution is terminated";
			if (isTerminated() && isTerminateUser()) {
				message = "Context is terminated by user request";
			} else if (isTerminated()) {
				message = "Timeout during context execution";
			}
			resultStatus = ExecAdvancedInfoUtil.askForAdvancedInfo(launch,
					message);
		}
		return resultStatus;
	}

	@Override
	public void postExecute() {
		try {
			if (isEcl) {
				ReportMaker.endReportNode(true, null, launch);
			}
		} catch (CoreException e) {
			updateStatus(State.FAILED);
			RcpttPlugin.log(e);
		}
	}
}
