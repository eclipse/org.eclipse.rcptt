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
package org.eclipse.rcptt.ctx.capability.ui.views;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.ContextTypeManager;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.IQ7ProjectMetadata;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.scenario.GroupContext;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

class ContextFilter {

	private static Set<String> CONTEXTS_ID = new HashSet<String>();
	static {
		CONTEXTS_ID.add("org.eclipse.rcptt.ctx.super"); //$NON-NLS-1$
		CONTEXTS_ID.add("org.eclipse.rcptt.ctx.capability"); //$NON-NLS-1$
		CONTEXTS_ID.add("org.eclipse.rcptt.ctx.group"); //$NON-NLS-1$
	}

	public boolean isValidToAdd(IQ7NamedElement element, IQ7NamedElement basicElement) {
		try {
			IQ7Project q7Project = basicElement.getQ7Project();
			if (q7Project != null) {
				IQ7ProjectMetadata metadata = q7Project.getMetadata();
				if (metadata != null && metadata.exists()) {
					String[] ctx = metadata.getContexts();
					if (ctx != null) {
						if (Arrays.asList(ctx).contains(element.getID())) {
							return false;
						}
					}
				}
			}

			if (basicElement.getNamedElement() instanceof GroupContext) {
				String id = Q7SearchCore.findIDByDocument(element);
				if (id == null) {
					id = element.getID();
				}
				if (basicElement.getID().equals(id)) {
					return false;
				}
			}
			if (element != null && element instanceof IContext) {
				final Context context = (Context) element.getNamedElement();
				final ContextType type = ContextTypeManager.getInstance().getTypeByContext(context);
				return type != null && !CONTEXTS_ID.contains(type.getId());
			}
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
		return false;
	}
}
