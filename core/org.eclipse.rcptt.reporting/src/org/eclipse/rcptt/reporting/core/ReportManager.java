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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.ProcessStatus;
import org.eclipse.rcptt.ecl.core.util.ECLBinaryResourceImpl;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.internal.Q7ReportingPlugin;
import org.eclipse.rcptt.sherlock.core.IEventProviders;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingCategory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportBuilderStore;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;
import org.eclipse.rcptt.sherlock.core.reporting.IReportBuilder;
import org.eclipse.rcptt.sherlock.core.reporting.Procedure1;
import org.eclipse.rcptt.sherlock.core.reporting.ReportBuilder;

public class ReportManager implements IQ7ReportConstants {
	private static ReportBuilder builder = null;

	public static String[] eventProviders = {
		IEventProviders.LOG_EVENT_PROVIDER,
		IEventProviders.JFACE_LOG_EVENT_PROVIDER,
		IEventProviders.JOBS_INFO_PROVIDER,
		IEventProviders.TESLA_INFO_PROVIDER,
		IEventProviders.ECL_COMMAND_EVENT_PROVIDER
	};

	private synchronized static void initializeBuilder(String title, ReportBuilderStore store) {
		if (builder != null) {
			builder.unregisterProviders();
		}
		if (store != null)
			builder = ReportBuilder.load(store);
		else {
			assert title != null;
			builder = ReportBuilder.create(title);
		}
		builder.registerProviders(eventProviders);
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
	
	
	private static class DummyReportNode implements INodeBuilder {
		private static final DummyReportNode INSTANCE = new DummyReportNode();
		@Override
		public INodeBuilder beginTask(String name) {
			return INSTANCE;
		}

		@Override
		public void endTask() {
		}

		@Override
		public void createEvent(Event event) {
		}

		@Override
		public void appendLog(LoggingCategory category, String text) {
		}

		@Override
		public void setProperty(String key, EObject value) {
		}

		@Override
		public void addSnapshot(Snaphot snapshot) {
		}

		@Override
		public void update(Procedure1<Node> runnable) {
		}

	};
	
	
	public synchronized static INodeBuilder getCurrentReportNode() {
		IReportBuilder builder = getBuilder();
		if (builder != null) {
			INodeBuilder rv = builder.getCurrent();
			if (rv == null)
				throw new NullPointerException();
			return rv;
		} else {
			return DummyReportNode.INSTANCE;
		}
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
						ReportBuilderStore store = (ReportBuilderStore) eObject;
						initializeBuilder(null, store);
					}
					INodeBuilder node = builder.getCurrent();
					ReportHelper.setResult(node,
							RcpttPlugin.createProcessStatus(IStatus.OK, "Restart successful"));
					node.endTask();
					ProcessStatus eclStatus = RcpttPlugin
							.createProcessStatus(
									IStatus.OK,
									"AUT restarted. Closing ECL report nodes.");
					while (getType(node = builder.getCurrent()) == ItemKind.ECL_COMMAND) {
						ReportHelper.setResult(node, eclStatus);
						node.endTask();
					}
				} catch (Throwable e) {
					Q7ReportingPlugin.log(e);
				}
			}
			current.delete();
		}
	}

	private static ItemKind getType(INodeBuilder node) {
		final ItemKind[] rv = { null };
		node.update(new Procedure1<Node>() {
			@Override
			public void apply(Node arg) {
				rv[0] = ReportHelper.getInfo(arg).getType();
			}
		});
		return rv[0];
	}
	public synchronized static void storeState() {
		ReportBuilder localBuilder = builder;
		if (localBuilder != null) {
			localBuilder.getCurrent().beginTask("Restarting Workbench");
			ECLBinaryResourceImpl res = new ECLBinaryResourceImpl();
			final ReportBuilderStore store = localBuilder.save();
			assert store.getCurrentNode().eContainer() != null;
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
		getCurrentReportNode().appendLog(cat, msg + "\n");
	}

	public synchronized static INodeBuilder createReport(String title, Q7Info q7info) {
		clear();
		initializeBuilder(title, null);
		INodeBuilder root = builder.getCurrent();
		assert q7info.getType() != null;
		assert q7info.getResult() == null;
		root.setProperty(IQ7ReportConstants.ROOT, q7info);
		return root;
	}
}
