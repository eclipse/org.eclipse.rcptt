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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.core.IContextProcessor;
import org.eclipse.rcptt.core.IEclAwareProcessor;
import org.eclipse.rcptt.core.ecl.core.model.EnterContext;
import org.eclipse.rcptt.core.ecl.core.model.Q7CoreFactory;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.scenario.GroupContext;
import org.eclipse.rcptt.ecl.runtime.ISession;

public class GroupContextProcessor implements IContextProcessor, IEclAwareProcessor {
	@Override
	public void apply(Context context, ISession session) throws CoreException {
		GroupContext groupContext = (GroupContext) context;
		for (Context refContext : groupContext.getContexts()) {
			EnterContext childCommand = Q7CoreFactory.eINSTANCE.createEnterContext();
			childCommand.setData(EcoreUtil.copy(refContext));
			session.execute(childCommand);
		}
	}

	@Override
	public void apply(Context context) throws CoreException {
		apply(context, null);
	}

	@Override
	public Context create(EObject param) throws CoreException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isApplied(Context context) {
		throw new UnsupportedOperationException();
	}

	public boolean isCreateAllowed() {
		return false;
	}
}
