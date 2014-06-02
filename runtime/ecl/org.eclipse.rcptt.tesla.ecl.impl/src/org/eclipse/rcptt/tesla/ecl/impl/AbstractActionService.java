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
package org.eclipse.rcptt.tesla.ecl.impl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.dispatch.ServiceDispatchingUtils;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.reporting.Procedure1;
import org.eclipse.rcptt.sherlock.core.reporting.ReportBuilder;
import org.eclipse.rcptt.tesla.ecl.TeslaErrorStatus;
import org.eclipse.rcptt.tesla.ecl.internal.impl.ServiceUtil;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;

public abstract class AbstractActionService implements ICommandService {

	private IProcess context;

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {

		this.context = context;

		TeslaBridge.waitDelay();

		final String[] msg = new String[1];
		ReportBuilder builder = ReportManager.getBuilder();
		if (builder != null) {
			builder.withCurrentNode(new Procedure1<Node>() {

				@Override
				public void apply(Node node) {
					if (node != null)
						msg[0] = node.getName();
				}
			});
		}
		makeScreenshot(false, msg[0]);
		try {
			IStatus extensionResult = ServiceDispatchingUtils.handleWithExtensions(command, context);
			if (extensionResult != null) {
				if (!extensionResult.isOK()) {
					makeScreenshot(true, extensionResult.getMessage());
					return extensionResult;
				}
			} else {
				Object result = exec(command);

				if (result != null) {
					if (!(result instanceof EObject))
						result = wrap(result);
					context.getOutput().write(result);
				}
			}
			TeslaErrorStatus failure = TeslaBridge.getTeslaFailure();
			if (failure != null) {
				makeScreenshot(true, failure.getMessage());
				return failure;
			}
			return Status.OK_STATUS;
		} catch (Exception e) {
			TeslaErrorStatus failure = TeslaBridge.getTeslaFailure();
			if (failure != null) {
				return failure;
			}
			if (e instanceof CoreException) {
				return ((CoreException) e).getStatus();
			}
			return TeslaImplPlugin.err(e.getMessage(), e);
		} finally {
			TeslaBridge.waitExecution();
		}
	}

	protected IProcess getContext() {
		return context;
	}

	protected void makeScreenshot(boolean onError, String message) {
		TeslaBridge.makeScreenshot(onError, message);
	}

	protected Object wrap(Object object) {
		return ServiceUtil.wrap(object);
	}

	protected abstract Object exec(Command command) throws CoreException;
}
