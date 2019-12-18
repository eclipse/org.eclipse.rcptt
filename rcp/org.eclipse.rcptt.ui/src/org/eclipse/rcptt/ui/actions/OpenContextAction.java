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
package org.eclipse.rcptt.ui.actions;

import java.util.Set;

import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.internal.ui.Messages;

public class OpenContextAction extends OpenNamedElementAction implements
		IWorkbenchWindowActionDelegate {
	protected String getWindowTitle() {
		return Messages.OpenContextAction_WindowTitle;
	}

	protected void fillNamedElements(Set<IQ7NamedElement> allElements) {
		IQ7NamedElement[] elements = Q7SearchCore.findAllElements();
		for (IQ7NamedElement iq7NamedElement : elements) {
			if( iq7NamedElement instanceof IContext) {
				allElements.add(iq7NamedElement);
			}
		}
	}
}