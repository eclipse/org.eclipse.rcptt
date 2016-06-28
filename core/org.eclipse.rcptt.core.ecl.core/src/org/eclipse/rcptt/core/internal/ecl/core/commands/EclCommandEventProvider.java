/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.internal.ecl.core.commands;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.core.ecl.core.model.BeginReportNode;
import org.eclipse.rcptt.core.ecl.core.model.CreateContext;
import org.eclipse.rcptt.core.ecl.core.model.CreateReport;
import org.eclipse.rcptt.core.ecl.core.model.EndReportNode;
import org.eclipse.rcptt.core.ecl.core.model.EnterContext;
import org.eclipse.rcptt.core.ecl.core.model.ExecVerification;
import org.eclipse.rcptt.core.ecl.core.model.GetQ7Information;
import org.eclipse.rcptt.core.ecl.core.model.GetReport;
import org.eclipse.rcptt.core.ecl.core.model.PrepareEnvironment;
import org.eclipse.rcptt.core.ecl.core.model.SetCommandsDelay;
import org.eclipse.rcptt.core.ecl.core.model.SetQ7Features;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.ISessionListener;
import org.eclipse.rcptt.ecl.core.Pipeline;
import org.eclipse.rcptt.ecl.core.RestoreState;
import org.eclipse.rcptt.ecl.core.SaveState;
import org.eclipse.rcptt.ecl.core.Script;
import org.eclipse.rcptt.ecl.core.Sequence;
import org.eclipse.rcptt.ecl.core.SessionListenerManager;
import org.eclipse.rcptt.ecl.core.With;
import org.eclipse.rcptt.ecl.core.util.CommandToStringConverter;
import org.eclipse.rcptt.ecl.gen.ast.AstExec;
import org.eclipse.rcptt.ecl.internal.core.CorePlugin;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ReportingFactory;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.sherlock.core.reporting.AbstractEventProvider;
import org.eclipse.rcptt.sherlock.core.reporting.IEventProvider;
import org.eclipse.rcptt.sherlock.core.reporting.IReportBuilder;

public class EclCommandEventProvider extends AbstractEventProvider implements
		ISessionListener, IEventProvider {

	// We need to persist report nodes not to mismatch them with ones created in other threads
	private ConcurrentMap<Command, INodeBuilder> openNodes = new ConcurrentHashMap<Command, INodeBuilder>();

	public EclCommandEventProvider() {
	}

	@Override
	protected void initializeBuilder(IReportBuilder builder) {
		SessionListenerManager.addListener(this);
	}

	@Override
	protected void doneBuilders() {
		SessionListenerManager.removeListener(this);
	}

	public void beginCommand(Command command) {
		if (isIgnoredCommand(command)) {
			return;
		}
		String cmdName = buildName(command);
		final INodeBuilder node = ReportManager.getCurrentReportNode().beginTask(cmdName);
		Q7Info info = ReportingFactory.eINSTANCE.createQ7Info();
		info.setType(ItemKind.ECL_COMMAND);
		ReportHelper.setInfo(node, info);
		INodeBuilder previousValue = openNodes.putIfAbsent(command, node);
		if (previousValue != null) {
			throw new IllegalStateException("A node for command " + cmdName + " is already opened");
		}
	}

	private static String buildName(Command command) {
		String cmdName = null;
		try {
			Command cmd = EcoreUtil.copy(command);
			if (cmd instanceof With) {
				((With) cmd).setDo(null);
			}
			cmdName = new CommandToStringConverter().convert(cmd).replace(
					"\n", "\\n");
		} catch (Throwable e) {
			CorePlugin.log(e);
			cmdName = command.getClass().getSimpleName();
		}
		return cmdName;
	}

	private boolean isIgnoredCommand(Command command) {
		String cname = command.getClass().getSimpleName();
		return command instanceof GetQ7Information
				|| command instanceof EnterContext
				|| command instanceof CreateContext
				|| command instanceof BeginReportNode
				|| command instanceof EndReportNode
				|| command instanceof SetQ7Features
				|| command instanceof SetCommandsDelay
				|| command instanceof PrepareEnvironment
				|| command instanceof Sequence || command instanceof Pipeline
				|| command instanceof AstExec || command instanceof Script
				|| cname.equals("SetupPlayerImpl")
				|| cname.equals("ShoutdownPlayerImpl")
				|| cname.equals("AutSendEventImpl")
				|| command instanceof SaveState
				|| command instanceof RestoreState
				|| command instanceof CreateReport
				|| command instanceof GetReport
				|| command instanceof ExecVerification;
	}

	public void endCommand(Command command, final IStatus status) {
		if (isIgnoredCommand(command)) {
			return;
		}
		final String name = buildName(command);
		assert name != null;
		final INodeBuilder node = openNodes.remove(command);
		if (node == null)
			throw new IllegalStateException("There is no open report node for command " + name);
		ReportHelper.setResult(node, status);
		node.endTask();
	}
}
