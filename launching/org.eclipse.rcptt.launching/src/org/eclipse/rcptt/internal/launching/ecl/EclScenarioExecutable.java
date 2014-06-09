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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.launching.EclStackTrace;
import org.eclipse.rcptt.internal.launching.ExecutionStatus;
import org.eclipse.rcptt.internal.launching.ScenarioExecutable;
import org.eclipse.rcptt.internal.launching.reporting.ReportMaker;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.Q7Launcher;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ResultStatus;
import org.eclipse.rcptt.reporting.core.IQ7ReportConstants;
import org.eclipse.rcptt.reporting.core.ReportHelper;

public class EclScenarioExecutable extends ScenarioExecutable {

	private Map<String, EObject> props;
	private List<String> variantName;

	public EclScenarioExecutable(AutLaunch launch, ITestCase scenario) {
		this(launch, scenario, false);
	}

	protected EclScenarioExecutable(AutLaunch launch, ITestCase scenario,
			boolean debug) {
		super(launch, scenario, debug);
		variantName = new ArrayList<String>();
	}

	@Override
	public IStatus doExecute() throws CoreException {
		Scenario scenario = (Scenario) getActualElement()
				.getModifiedNamedElement();

		props = new HashMap<String, EObject>();
		Q7Info info = ReportHelper.createInfo();
		info.setType(ItemKind.SCRIPT);
		info.setResult(ResultStatus.PASS);
		info.setTags(scenario.getTags());
		info.setId(scenario.getId());
		if (getVariantName() != null) {
			info.getVariant().clear();
			info.getVariant().addAll(getVariantName());
		}
		props.put(IQ7ReportConstants.ROOT, info);

		ReportMaker.beginReportNode(getName(), props, launch);
		IStatus resultStatus;
		try {
			doExecuteTest(executionMonitor);
			resultStatus = Status.OK_STATUS;
		} catch (CoreException e) {
			resultStatus = e.getStatus();
		}
		if (resultStatus.getSeverity() == IStatus.CANCEL) {
			// Cancel is called, lets collect correct message
			String message = "Testcase execution is terminated";
			if (isTerminated() && isTerminateUser()) {
				message = "Testcase execution is terminated by user request";
			} else if (isTerminated()) {
				message = "Timeout during testcase execution";
			}
			resultStatus = ExecAdvancedInfoUtil.askForAdvancedInfo(launch,
					message);
		}

		info.setResult(resultStatus.isOK() ? ResultStatus.PASS
				: ResultStatus.FAIL);
		if (!resultStatus.isOK()) {
			info.setMessage(resultStatus instanceof ExecutionStatus ? EclStackTrace.fromExecStatus(
					(ExecutionStatus) resultStatus).print() : resultStatus.getMessage());
			info.setDescription(scenario.getDescription());
			
		}

		return resultStatus;
	}

	@Override
	public void postExecute() {
		// Take all snapshots
		try {
			// if (!isTerminated()) {
			ReportMaker.endReportNode(true, null, launch);
			// }
		} catch (CoreException e) {
			updateStatus(FAILED);
			RcpttPlugin.log(e);
		}
	}

	protected void doExecuteTest(IProgressMonitor monitor) throws CoreException {
		launch.run(getActualElement(), Q7Launcher.getLaunchTimeout() * 1000,
				monitor, getPhase());
	}

	@Override
	public void terminate(boolean user) {
		super.terminate(user);
	}

	public void setVariantName(List<String> variantName) {
		this.variantName = (variantName == null)
				? new ArrayList<String>()
				: new ArrayList<String>(variantName);
	}

	public List<String> getVariantName() {
		return variantName;
	}
}
