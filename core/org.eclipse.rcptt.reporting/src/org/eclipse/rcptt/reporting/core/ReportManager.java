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
package org.eclipse.rcptt.reporting.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.util.ECLBinaryResourceImpl;

import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ReportingFactory;
import org.eclipse.rcptt.reporting.internal.Q7ReportingPlugin;
import org.eclipse.rcptt.sherlock.core.IEventProviders;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingCategory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportBuilderStore;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory;
import org.eclipse.rcptt.sherlock.core.reporting.Procedure1;
import org.eclipse.rcptt.sherlock.core.reporting.ReportBuilder;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;

public class ReportManager implements IQ7ReportConstants {
	private static ReportBuilder builder = null;

	public static String[] eventProviders = {
			IEventProviders.LOG_EVENT_PROVIDER,
			IEventProviders.JFACE_LOG_EVENT_PROVIDER,
			"org.eclipse.rcptt.tesla.ecl.iml.info.provider", "org.eclipse.rcptt" };

	public synchronized static ReportBuilder createReport() {
		if (builder != null) {
			builder.unregisterProviders();
		}
		initializeBuilder();
		Q7Info info = ReportingFactory.eINSTANCE.createQ7Info();
		info.setType(ItemKind.TESTCASE);
		builder.getReport().getRoot().getProperties()
				.put(IQ7ReportConstants.ROOT, info);
		return builder;
	}

	private synchronized static void initializeBuilder() {
		builder = new ReportBuilder();
		builder.registerProviders(eventProviders);
		if (TeslaFeatures.getInstance().isProfilingEnabled()) {
			builder.registerProviders(IEventProviders.JOBS_EVENT_PROVIDER);
		}
		builder.registerProviders(IEventProviders.JOBS_INFO_PROVIDER);
	}

	public synchronized static Report getReportCopy() {
		if (builder == null) {
			return null;
		}
		return builder.getReportCopy();
	}

	public synchronized static ReportBuilder getBuilder() {
		return builder;
	}

	public synchronized static void reload() {
		if (builder == null) {
			File current = getReportFile();
			if (current.exists()) {
				ECLBinaryResourceImpl res = new ECLBinaryResourceImpl();
				try {
					BufferedInputStream in = new BufferedInputStream(
							new FileInputStream(current));
					res.load(in, null);
					in.close();
					EObject eObject = res.getContents().get(0);
					if (eObject instanceof ReportBuilderStore) {
						initializeBuilder();
						ReportBuilderStore store = (ReportBuilderStore) eObject;
						builder.setReport(store.getReport(),
								store.getCurrentNode());
						builder.endTask();
					}
				} catch (Throwable e) {
					Q7ReportingPlugin.log(e);
				}
			}
			current.delete();
		}
	}

	public synchronized static void storeState() {
		if (builder != null) {
			builder.beginTask("Restarting Workbench");
			ECLBinaryResourceImpl res = new ECLBinaryResourceImpl();
			final ReportBuilderStore store = ReportFactory.eINSTANCE
					.createReportBuilderStore();
			store.setReport(builder.getReport());
			builder.withCurrentNode(new Procedure1<Node>() {
				@Override
				public void apply(Node node) {
					store.setCurrentNode(node);
				}
			});
			res.getContents().add(store);
			File current = getReportFile();
			try {
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(current));
				res.save(out, null);
				out.close();
			} catch (Throwable e) {
				Q7ReportingPlugin.log(e);
			}
		}
	}

	private static File getReportFile() {
		return new File(Q7ReportingPlugin.getConfigStateLocation(),
				"current.report");
	}

	public static void clear() {
		if (builder != null) {
			builder.unregisterProviders();
		}
		builder = null;
	}
	public static void appendLog(String msg) {
		appendLog(msg, LoggingCategory.DEFAULT);
	}
	public static void appendLogError(String msg) {
		appendLog(msg, LoggingCategory.NORMAL);
	}
	public static void appendLogExtra(String msg) {
		appendLog(msg, LoggingCategory.ADVANCED);
	}
	public static void appendLog(final String msg, final LoggingCategory cat) {
		ReportBuilder builder = getBuilder();
		if(builder != null) {
			builder.withCurrentNode(new Procedure1<Node>() {
				@Override
				public void apply(Node node) {
					ReportBuilder.appendLog(node, cat, msg + "\n");
				}
			});
		}
	}
}
