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
package org.eclipse.rcptt.internal.launching.reporting;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.core.ecl.core.model.BeginReportNode;
import org.eclipse.rcptt.core.ecl.core.model.EndReportNode;
import org.eclipse.rcptt.core.ecl.core.model.Q7CoreFactory;
import org.eclipse.rcptt.ecl.core.ProcessStatus;
import org.eclipse.rcptt.ecl.internal.core.ProcessStatusConverter;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.launching.IExecutionSession;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.core.IQ7ReportConstants;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory;
import org.eclipse.rcptt.sherlock.core.streams.SherlockReportOutputStream;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * Creates cumulative sherlock report from IExecutionSession
 */
public class ReportMaker implements IQ7ReportConstants {

	public static void beginReportNode(String node,
			Map<String, EObject> properties, AutLaunch launch)
			throws CoreException, InterruptedException {
		BeginReportNode reportNode = Q7CoreFactory.eINSTANCE
				.createBeginReportNode();
		reportNode.setName(node);
		if (properties != null) {
			Q7Info info = (Q7Info) properties.get(IQ7ReportConstants.ROOT);
			Preconditions.checkArgument(!Strings.isNullOrEmpty(info.getId()), "Id can't be empty");
			Preconditions.checkArgument(info.getResult() == null, "Can't create report with a preset  result");
			reportNode.getProperties().putAll(properties);
		}
		launch.execute(reportNode);
	}

	public static void endReportNode(boolean takeSnaphots, AutLaunch launch, IStatus result) throws CoreException {
		try {
			endReportNode(takeSnaphots, launch, ProcessStatusConverter.toProcessStatus(result));
		} catch (CoreException e) {
			IStatus[] children = new IStatus[] { result, e.getStatus() };
			throw new CoreException(new MultiStatus(Q7LaunchingPlugin.PLUGIN_ID, 0, children, "Failed to close report node", null));
		}
	}
	/**
	 * If snaphots contains elements, then only items will be used, overwize all
	 * snaphots will be taken
	 */
	public static void endReportNode(boolean takeSnaphots, AutLaunch launch, ProcessStatus result)
			throws CoreException {
		EndReportNode reportNode = Q7CoreFactory.eINSTANCE
				.createEndReportNode();
		reportNode.setTakeSnaphots(takeSnaphots);
		reportNode.setResult(result);
		try {
			launch.execute(reportNode);
		} catch (InterruptedException e) {
			RcpttPlugin.log(e);
		}
	}

	private final SherlockReportOutputStream stream;

	public ReportMaker(SherlockReportOutputStream out) {
		this.stream = out;
	}

	public void make(IExecutionSession session, IProgressMonitor monitor) {
		IExecutable[] executables = session.getTestCases();
		monitor.beginTask("Prepare RCPTT report", executables.length + 50);
		for (IExecutable iExecutable : executables) {
			Report report = iExecutable.getResultReport();
			if (report == null) {
				// Generate minimal report
				report = ReportFactory.eINSTANCE.createReport();
				report.setRoot(minimalReport(iExecutable));
				stream.write(report);
			} else {
				stream.write(EcoreUtil.copy(report));
			}
			monitor.worked(1);
		}
		monitor.done();
	}

	private void setProperties(IExecutable iExecutable, Q7Info info) {
		switch (iExecutable.getType()) {
		case IExecutable.TYPE_CONTEXT:
			info.setType(ItemKind.CONTEXT);
			break;
		case IExecutable.TYPE_VERIFICATION:
			info.setType(ItemKind.VERIFICATION);
			break;
		case IExecutable.TYPE_SCENARIO:
			info.setType(ItemKind.SCRIPT);
			break;
		}
		info.setResult(ProcessStatusConverter.toProcessStatus(iExecutable.getResultStatus()));
	}

	private Node minimalReport(IExecutable iExecutable) {
		Report report = iExecutable.getResultReport();
		if (report != null) {
			assert ReportHelper.getInfo(report.getRoot()).getId() != null;
			return EcoreUtil.copy(report.getRoot());
		}
		Node nde = ReportFactory.eINSTANCE.createNode();
		nde.setName(iExecutable.getName());
		nde.setStartTime(0);
		nde.setEndTime(iExecutable.getTime());
		Q7Info info = ReportHelper.getInfo(nde);
		setProperties(iExecutable, info);
		assert info.getType() != null;
		for (IExecutable iExecutable2 : iExecutable.getChildren()) {
			nde.getChildren().add(minimalReport(iExecutable2));
		}
		return nde;

	}
}
