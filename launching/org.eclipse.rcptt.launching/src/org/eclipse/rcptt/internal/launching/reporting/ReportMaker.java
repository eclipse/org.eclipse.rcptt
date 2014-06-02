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

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.core.ecl.core.model.BeginReportNode;
import org.eclipse.rcptt.core.ecl.core.model.EndReportNode;
import org.eclipse.rcptt.core.ecl.core.model.Q7CoreFactory;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.launching.IExecutionSession;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ResultStatus;
import org.eclipse.rcptt.reporting.core.IQ7ReportConstants;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory;
import org.eclipse.rcptt.sherlock.core.streams.SherlockReportOutputStream;

/**
 * Creates cumulative sherlock report from IExecutionSession
 */
public class ReportMaker implements IQ7ReportConstants {

	public static void beginReportNode(String node,
			Map<String, EObject> properties, AutLaunch launch)
			throws CoreException {
		BeginReportNode reportNode = Q7CoreFactory.eINSTANCE
				.createBeginReportNode();
		reportNode.setName(node);
		if (properties != null) {
			reportNode.getProperties().putAll(properties);
		}
		try {
			launch.execute(reportNode);
		} catch (InterruptedException e) {
			RcpttPlugin.log(e);
		}
	}

	/**
	 * If snaphots contains elements, then only items will be used, overwize all
	 * snaphots will be taken
	 */
	public static void endReportNode(Map<String, EObject> properties,
			boolean takeSnaphots, List<String> snaphosts, AutLaunch launch)
			throws CoreException {
		EndReportNode reportNode = Q7CoreFactory.eINSTANCE
				.createEndReportNode();
		if (properties != null) {
			reportNode.getProperties().putAll(properties);
		}
		reportNode.setTakeSnaphots(takeSnaphots);
		if (takeSnaphots && snaphosts != null) {
			reportNode.getSnaphots().addAll(snaphosts);
		}
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
				Node nde = ReportFactory.eINSTANCE.createNode();
				report.setRoot(nde);
				nde.setName(iExecutable.getName());
				nde.setStartTime(0);
				nde.setEndTime(iExecutable.getTime());
				Q7Info info = ReportHelper.getInfo(nde);
				setProperties(iExecutable, nde);
				info.setMessage("Skipped or not started");
				info.setResult(ResultStatus.SKIPPED);
				info.setType(ItemKind.TESTCASE);
				processChildren(report, nde, iExecutable);
				stream.write(report);
			} else {
				stream.write(EcoreUtil.copy(report));
			}
			monitor.worked(1);
		}
		monitor.done();
	}

	private void setProperties(IExecutable iExecutable, Node nde) {
		Q7Info info = ReportHelper.getInfo(nde);
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
		switch (iExecutable.getStatus()) {
		case IExecutable.WAITING:
		case IExecutable.LAUNCHING:
			info.setResult(ResultStatus.SKIPPED);
			break;
		case IExecutable.FAILED:
			info.setResult(ResultStatus.FAIL);
			break;
		case IExecutable.PASSED:
			info.setResult(ResultStatus.PASS);
			break;
		}
	}

	private void processChildren(Report report, Node rnde,
			IExecutable iExecutable) {
		IExecutable[] children = iExecutable.getChildren();
		for (IExecutable iExecutable2 : children) {
			Node nde = ReportFactory.eINSTANCE.createNode();
			rnde.getChildren().add(nde);
			nde.setName(iExecutable2.getName());
			Q7Info info = ReportHelper.getInfo(nde);
			info.setResult(ResultStatus.FAIL);
			nde.setStartTime(0);
			nde.setEndTime(iExecutable2.getTime());
			setProperties(iExecutable2, nde);
			processChildren(report, nde, iExecutable2);
		}
	}
}
