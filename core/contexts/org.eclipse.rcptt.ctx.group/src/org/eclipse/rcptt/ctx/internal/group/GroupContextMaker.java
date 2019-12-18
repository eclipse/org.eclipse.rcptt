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
package org.eclipse.rcptt.ctx.internal.group;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.DefaultContextMaker;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.scenario.GroupContext;

public class GroupContextMaker extends DefaultContextMaker {

	@Override
	public void makeExecutable(Context context, IQ7NamedElement source)
			throws ModelException {
		GroupContext group = (GroupContext) context;
		GroupContext sourceGroup = (GroupContext) source.getNamedElement();
		group.getContexts().clear();
		EList<String> references = sourceGroup.getContextReferences();
		for (String id : references) {
			Context ctx = getContext(source.getQ7Project(), id);
			if (ctx != null) {
				group.getContexts().add(ctx);
			} else {
				throw new ModelException(null,
						"Failed to load referenced group context with id:" + id);
			}
		}
	}

	private Context getContext(IQ7Project project, String id)
			throws ModelException {
		List<IContext> ctx = project.find(IContext.class, id);
		if (ctx.size() > 0) {
			IContext ctx0 = ctx.get(0);
			Context childContext = EcoreUtil.copy((Context) ctx0
					.getNamedElement());
			ContextType type = ctx0.getType();
			if (type != null) {
				type.getMaker().makeExecutable(childContext, ctx0);
			}
			return childContext;
		}
		return null;
	}
}
