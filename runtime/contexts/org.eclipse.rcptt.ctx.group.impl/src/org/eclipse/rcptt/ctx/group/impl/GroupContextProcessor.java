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
package org.eclipse.rcptt.ctx.group.impl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.runtime.ISession;

import org.eclipse.rcptt.core.ContextTypeManager;
import org.eclipse.rcptt.core.IContextProcessor;
import org.eclipse.rcptt.core.IEclAwareProcessor;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.scenario.GroupContext;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ResultStatus;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.reporting.ReportBuilder;

public class GroupContextProcessor implements IContextProcessor, IEclAwareProcessor {
	public void apply(Context context, ISession session) throws CoreException {
		GroupContext groupContext = (GroupContext) context;

		ContextTypeManager typeManager = ContextTypeManager.getInstance();
		for (Context refContext : groupContext.getContexts()) {
			ReportBuilder builder = ReportManager.getBuilder();
			Node nde = null;
			Q7Info info = null;
			if (builder != null) {
				nde = builder.beginTask(refContext.getName());
				info = ReportHelper.getInfo(nde);
				info.setType(ItemKind.CONTEXT);
			}
			try {
				typeManager.apply(refContext, session);
				if (nde != null) {
					info.setResult(ResultStatus.PASS);
				}
			} catch (CoreException e) {
				if (nde != null) {
					info.setResult(ResultStatus.FAIL);
					info.setMessage(e.getMessage());
				}
				throw e;
			} finally {
				if (builder != null) {
					builder.endTask();
				}
			}
		}

	}

	public void apply(Context context) throws CoreException {
		apply(context, null);
	}

	public Context create(EObject param) throws CoreException {
		throw new UnsupportedOperationException();
	}

	public boolean isApplied(Context context) {
		throw new UnsupportedOperationException();
	}

	public boolean isCreateAllowed() {
		return false;
	}
}
