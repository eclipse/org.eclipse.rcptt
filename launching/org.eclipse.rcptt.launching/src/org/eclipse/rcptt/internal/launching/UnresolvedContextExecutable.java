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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.internal.launching.reporting.ReportMaker;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ResultStatus;
import org.eclipse.rcptt.reporting.core.IQ7ReportConstants;
import org.eclipse.rcptt.reporting.core.ReportHelper;

public class UnresolvedContextExecutable extends ContextExecutable {

	public UnresolvedContextExecutable(AutLaunch launch, IContext context, boolean debug) {
		super(launch, context, debug);
	}

	@Override
	protected IStatus doExecute() throws CoreException, InterruptedException {
		Map<String, EObject> props = new HashMap<String, EObject>();

		Q7Info info = ReportHelper.createInfo();
		info.setResult(ResultStatus.FAIL);
		info.setType(ItemKind.CONTEXT);
		info.setMessage("Context is unresolved");
		props.put(IQ7ReportConstants.ROOT, info);

		ReportMaker.beginReportNode(getName(), props, launch);
		ReportMaker.endReportNode(false, null, launch);
		updateStatus(FAILED);
		return new Status(Status.ERROR, Q7LaunchingPlugin.PLUGIN_ID,
				"Context could not be resolved:" + getName());
	}

}
