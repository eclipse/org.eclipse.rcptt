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
package org.eclipse.rcptt.internal.launching;

import static org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin.createStatus;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.rcptt.core.Q7;
import org.eclipse.rcptt.core.Q7Features;
import org.eclipse.rcptt.core.ecl.core.model.CreateReport;
import org.eclipse.rcptt.core.ecl.core.model.GetReport;
import org.eclipse.rcptt.core.ecl.core.model.PrepareEnvironment;
import org.eclipse.rcptt.core.ecl.core.model.Q7CoreFactory;
import org.eclipse.rcptt.core.ecl.core.model.ResetVerifications;
import org.eclipse.rcptt.core.ecl.core.model.SetCommandsDelay;
import org.eclipse.rcptt.core.ecl.core.model.SetQ7Features;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.ecl.core.ProcessStatus;
import org.eclipse.rcptt.ecl.core.Sequence;
import org.eclipse.rcptt.ecl.core.util.ECLBinaryResourceImpl;
import org.eclipse.rcptt.ecl.core.util.ScriptletFactory;
import org.eclipse.rcptt.ecl.internal.core.ProcessStatusConverter;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.launching.ecl.EclScenarioExecutable;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.launching.Q7LaunchUtils;
import org.eclipse.rcptt.launching.utils.TestSuiteUtils;
import org.eclipse.rcptt.parameters.ParametersFactory;
import org.eclipse.rcptt.parameters.ResetParams;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.reporting.core.SimpleSeverity;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportContainer;
import org.eclipse.rcptt.sherlock.core.streams.SherlockReportSession;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class PrepareExecutionWrapper extends Executable {

	private final AutLaunch launch;
	private final Executable executable;
	private SherlockReportSession reportSession;

	private String resultReportID;

	public PrepareExecutionWrapper(AutLaunch launch, Executable executable) {
		super(executable.isDebug());
		this.launch = launch;
		this.executable = executable;
	}

	public Executable getExecutable() {
		return executable;
	}

	public AutLaunch getAut() {
		return launch;
	}

	@Override
	public void startLaunching() {
		executable.startLaunching();
	}

	@Override
	public Report getResultReport() {
		if (resultReportID != null && reportSession != null) {
			return reportSession.getReport(resultReportID);
		}
		return TestSuiteUtils.generateReport(getActualElement(), getResultStatus());
	}

	@Override
	public IStatus execute() throws InterruptedException {
		launch.resetState();
		PrepareEnvironment prepareEnvironment = Q7CoreFactory.eINSTANCE
				.createPrepareEnvironment();
		SetCommandsDelay commandsDelay = Q7CoreFactory.eINSTANCE.createSetCommandsDelay();
		commandsDelay.setDelay(Q7.INSTANCE.getCommandsExecutionDelay());
		TeslaFeatures.getInstance().getOption(TeslaFeatures.COMMAND_EXECUTION_DELAY)
				.setValue(Integer.toString(commandsDelay.getDelay()));
		SetQ7Features setQ7Features = Q7CoreFactory.eINSTANCE.createSetQ7Features();
		Q7LaunchUtils.setQ7Variable(setQ7Features, Q7LaunchUtils.Q7_CURRENT_TEST_VAR,
				getName());
		TeslaFeatures.getInstance().storeValues(setQ7Features.getFeatures());
		Q7Features.getInstance().storeValues(setQ7Features.getFeatures());
		Sequence command = ScriptletFactory.seq(prepareEnvironment, commandsDelay,
				setQ7Features);
		try {
			launch.execute(command);
			resetParams();
			resetVerifications();
		} catch (CoreException e) {
			return e.getStatus();
		} catch (Exception e) {
			return Q7LaunchingPlugin.createStatus(e);
		}
		try {
			createReport();
		} catch (CoreException e) {
			return e.getStatus();
		}		
		return executable.execute(); 
	}

	private Report getReport() throws InterruptedException, ModelException {
		Report resultReport = null;
		final String id = getActualElement().getID();
		Preconditions.checkNotNull(id);
		try {
			GetReport getReport = Q7CoreFactory.eINSTANCE.createGetReport();
			Object object = launch.execute(getReport);
			if (object instanceof Report) {
				resultReport = (Report) object;
			} else if (object instanceof ReportContainer) {
				ZipInputStream zin = new ZipInputStream(new ByteArrayInputStream(
						((ReportContainer) object).getContent()));
				try {
					// position the stream at the beginning of the entry data
					zin.getNextEntry();
					Resource res = new ECLBinaryResourceImpl();
					res.load(zin, null);
					EObject object2 = res.getContents().get(0);
					if (object2 instanceof Report) {
						resultReport = (Report) object2;
					} else {
						throw invalidObjectStatus(object2);
					}
				} catch (Exception e) {
					throw new CoreException(Q7LaunchingPlugin.createStatus(e.getMessage(), e));
				}
			} else if (object == null) {
				throw invalidObjectStatus(object);
			} else {
				throw invalidObjectStatus(object);
			}
			String reportId = ReportHelper.getInfo(resultReport.getRoot()).getId();
			if (!id.equals(reportId)) {
				throw new CoreException(createStatus("Expected item id: " + id + ", actual report id: " + reportId));
			}
		} catch (CoreException e) {
			IQ7NamedElement element = executable.getActualElement();
			resultReport = TestSuiteUtils.generateReport(element, e.getStatus());
		}
		Q7Info info = ReportHelper.getInfoOnly(resultReport.getRoot());
		if (info != null) {
			info.getVariant().clear();
			info.getVariant().addAll(getVariantName());
		}
		return resultReport;
	}

	private CoreException invalidObjectStatus(Object o) {
		String clazz = o == null ? "null" : o.getClass().getName();
		return new CoreException(createStatus("Expected: Report object, found: " + clazz));
	}

	private void resetParams() throws CoreException, InterruptedException {
		ResetParams cmd = ParametersFactory.eINSTANCE.createResetParams();
		launch.execute(cmd);
	}

	private void resetVerifications() throws CoreException, InterruptedException {
		ResetVerifications cmd = Q7CoreFactory.eINSTANCE.createResetVerifications();
		launch.execute(cmd);
	}

	private void createReport() throws CoreException, InterruptedException {
		CreateReport createReport = Q7CoreFactory.eINSTANCE.createCreateReport();
		String name = getName();
		Executable parent = getParent();
		while (parent != null) {
			name = parent.getName() + "/" + name;
			parent = parent.getParent();
		}
		createReport.setName(name);
		createReport.setQ7info(getQ7Info(executable));
		launch.execute(createReport);
	}

	private static Q7Info getQ7Info(Executable executable) throws ModelException {
		IQ7NamedElement element = executable.getActualElement();
		return TestSuiteUtils.getQ7Info(element);
	}


	@Override
	public Executable[] getChildren() {
		return executable.getChildren();
	}

	public IQ7NamedElement getActualElement() {
		return executable.getActualElement();
	}

	public String getName() {
		return executable.getName();
	}

	public long getTime() {
		return super.getTime() + executable.getTime();
	}

	public int getType() {
		return executable.getType();
	}

	private static void closeAllNodes(long endTime, Node node) {
		if (node.getEndTime() == 0) {
			node.setEndTime(endTime);
		}
		Q7Info info = ReportHelper.getInfo(node);
		for (Node child : node.getChildren()) {
			closeAllNodes(endTime, child);
			Q7Info childInfo = ReportHelper.getInfo(child);
			if (childInfo.getResult() == null) {
				ProcessStatus childStatus = RcpttPlugin.createProcessStatus(IStatus.ERROR, "" + child.getName()
						+ " result is not set");
				childInfo.setResult(childStatus);
				if (SimpleSeverity.create(info) == SimpleSeverity.OK)
					info.setResult(childStatus);
			}
		}
	}

	@Override
	public IStatus postExecute(IStatus status) {
		IQ7NamedElement element = executable.getActualElement();
		// Take report
		// TODO: remove dummy report, introduce AUT's log acquisition
		Report resultReport = TestSuiteUtils.generateFailedReport(element,
				"Failed to get report. Check IDE's error log.");
		try {
			if (status.matches(IStatus.CANCEL)) {
				resultReport = TestSuiteUtils.generateReport(element, status);
			} else {
				resultReport = getReport();
				Node root = resultReport.getRoot();
				Q7Info rootInfo = ReportHelper.getInfo(root);
				assert rootInfo.getResult() == null;
				rootInfo.setResult(ProcessStatusConverter.toProcessStatus(status));
				closeAllNodes(root.getStartTime() + getTime(), root);
				if (status.isOK() && SimpleSeverity.create(rootInfo) != SimpleSeverity.OK) {
					status = ProcessStatusConverter.toIStatus(rootInfo.getResult());
				}


				for (IExecutable ch : getChildren()) {
					if (ch instanceof ScenarioExecutable) {
						rootInfo.setId(ch.getId());
						break;
					}
				}
				assert Objects.equal(rootInfo.getId(), getActualElement().getID());

			}
			status = super.postExecute(status);
			return status;
		} catch (InterruptedException e) {
			resultReport = TestSuiteUtils.generateReport(element,
					RcpttPlugin.createStatus("Interrupted during report acquisition", e));
			return Status.CANCEL_STATUS;
		} catch (Throwable e) {
			IStatus rv = RcpttPlugin.createStatus(e);
			resultReport = TestSuiteUtils.generateReport(element, rv);
			return rv;
		} finally {
			Preconditions.checkNotNull(resultReport);
			if (this.reportSession != null) {
				resultReportID = this.reportSession.write(resultReport);
			}
			listeners.updateSessionCounters(this, status);
		}
	}

	public void setReportSession(SherlockReportSession reportSession) {
		this.reportSession = reportSession;
	}

	public List<String> getVariantName() {
		Executable exx = getExecutable();
		if (exx instanceof GroupExecutable) {
			IExecutable ex = ((GroupExecutable) exx).getRoot();
			if (ex instanceof EclScenarioExecutable)
				return ((EclScenarioExecutable) ex).getVariantName();
		}
		return Collections.emptyList();
	}

	@Override
	public String toString() {
		return "Prepare: " + executable.toString();
	}

}
