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
package org.eclipse.rcptt.testing;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.IQ7ElementVisitor;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.internal.core.model.ModelManager;
import org.eclipse.rcptt.testing.commands.FindContexts;

public class FindContextsService implements ICommandService {
	
	public IStatus service(Command command, final IProcess context)
			throws InterruptedException, CoreException {
		if (!(command instanceof FindContexts)) {
			return Status.CANCEL_STATUS;
		}

		FindContexts cmd = (FindContexts) command;
		final String type = cmd.getType();
		ModelManager.getModelManager().getModel()
				.accept(new ElementVisitor(context, type));
		return Status.OK_STATUS;
	}

	private static final class ElementVisitor implements IQ7ElementVisitor {
		private final IProcess context;
		private final String type;

		private ElementVisitor(IProcess context, String type) {
			this.context = context;
			this.type = type == null ? "" : type;
		}

		
		public boolean visit(IQ7Element element) {
			try {
				if (!(element instanceof IContext)) {
					return true;
				}

				NamedElement ne = ((IQ7NamedElement) element).getNamedElement();
				if (type.length() != 0 && !ne.eClass().getName().equals(type)) {
					return false;
				}
				try {
					context.getOutput().write(
							element.getResource().getFullPath().toString());
				} catch (CoreException e) {
					TestingPlugin.logErr(
							String.format("Error writing to output pipe"), e);
				}
			} catch (ModelException e) {
				TestingPlugin.logErr(
						String.format("Problem loading q7 element: %s",
								element.getName()), e);
			}
			return true;
		}

		
		public boolean endVisit(IQ7Element element) {
			return false;
		}
	}
}
