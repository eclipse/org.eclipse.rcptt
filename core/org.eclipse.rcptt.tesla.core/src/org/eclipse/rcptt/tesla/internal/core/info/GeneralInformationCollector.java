/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.internal.core.info;

import java.util.Map;

import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;

import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.InfoFactory;
import org.eclipse.rcptt.tesla.core.info.JobEntry;
import org.eclipse.rcptt.tesla.core.info.StackTraceEntry;
import org.eclipse.rcptt.tesla.internal.core.info.InfoUtils.Node;

public class GeneralInformationCollector {

	public static void collectInformation(AdvancedInformation information) {
		collectJobInformation(information);
		collectThreadInformation(information);
		// Collect memory information

		Runtime runtime = Runtime.getRuntime();
		Node nde = InfoUtils.newNode("java.runtime").add(information);
		nde.property("cpus", Integer.toString(runtime.availableProcessors()));
		nde.property("freeMemory", Long.toString(runtime.freeMemory()));
		nde.property("totalMemory", Long.toString(runtime.totalMemory()));
		nde.property("maxMemory", Long.toString(runtime.maxMemory()));
	}

	private static void collectThreadInformation(AdvancedInformation information) {
		Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
		for (Map.Entry<Thread, StackTraceElement[]> e : allStackTraces.entrySet()) {
			Thread key = e.getKey();
			String threadClassName = key.getClass().getName();
			if (threadClassName.contains("org.eclipse.osgi.framework.eventmgr.EventManager")
					|| threadClassName.contains("java.lang.ref.Finalizer")
					|| threadClassName.contains("org.eclipse.emf.common.util.CommonUtil")
					|| threadClassName.contains("java.lang.ref.Reference")
					|| threadClassName.contains("org.eclipse.rcptt.tesla.core.server.TeslaNetworkServer")
					|| threadClassName.contains("org.eclipse.rcptt.ecl.server.tcp.EclTcpServer")
					|| threadClassName.contains("org.eclipse.osgi.framework.eventmgr")) {
				continue;
			}
			StackTraceElement[] value = e.getValue();
			StackTraceEntry entry = InfoFactory.eINSTANCE.createStackTraceEntry();
			entry.setId(Integer.toHexString(key.hashCode()));
			entry.setThreadClass(threadClassName);
			entry.setThreadName(key.getName());
			boolean add = true;
			for (StackTraceElement stackTraceElement : value) {
				String stElement = stackTraceElement.toString();
				if (stElement.contains("org.eclipse.rcptt.ecl.server.tcp.SessionRequestHandler.writeOutput")
						|| stElement.contains("org.eclipse.rcptt.ecl.server.tcp.SessionRequestHandler")
						|| stElement.contains("org.eclipse.rcptt.ecl.client.tcp.EclTcpSession")) {
					add = false;
					break;
				}
				entry.getStackTrace().add(stElement);
			}
			if (add) {
				information.getThreads().add(entry);
			}
		}
	}

	private static void collectJobInformation(AdvancedInformation information) {
		IJobManager manager = Job.getJobManager();
		Job[] find = manager.find(null);
		for (Job job : find) {
			JobEntry entry = InfoFactory.eINSTANCE.createJobEntry();
			entry.setId(Integer.toHexString(job.hashCode()));
			entry.setJobClass(job.getClass().getName());
			entry.setName(job.getName());
			entry.setState(stateToString(job));
			ISchedulingRule rule = job.getRule();
			if (rule != null) {
				entry.setRule(rule.toString());
				entry.setRuleClass(rule.getClass().getName());
			}
			information.getJobs().add(entry);
		}
	}

	private static String stateToString(Job job) {
		switch (job.getState()) {
		case Job.RUNNING:
			return "running";
		case Job.SLEEPING:
			return "sleeping";
		case Job.NONE:
			return "none";
		case Job.WAITING:
			return "waiting";
		}
		return "unknown";
	}

}
