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
package org.eclipse.rcptt.ui.refactoring.delete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7ProjectMetadata;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.GroupContext;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.SuperContext;

public abstract class AbstractDeleteContextReferenceChange extends Change {
	private IQ7Element element;
	private final IContext context;
	private String contextID;

	protected AbstractDeleteContextReferenceChange(IQ7Element element,
			IContext context, String contextID) {
		this.element = element;
		this.context = context;
		this.contextID = contextID;
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
	}

	@Override
	public Object getModifiedElement() {
		return element.getResource();
	}

	protected final IQ7Element getElement() {
		return element;
	}

	protected final IContext getContext() {
		return context;
	}

	protected final String getContextId() {
		return contextID;
	}

	protected boolean isValid() throws ModelException {
		if (element == null || context == null)
			return false;
		if (getContextId() == null || getContextId().length() == 0)
			return false;
		if (!(element instanceof ITestCase || element instanceof IContext || element instanceof IQ7ProjectMetadata))
			return false;
		// if (Q7Utils.getLocation(element) == null)
		// return false;
		return true;
	}

	protected final List<String> getContextsReferences(IQ7NamedElement copy)
			throws ModelException {
		if (copy instanceof ITestCase) {
			return new ArrayList<String>(Arrays.asList(((ITestCase) copy)
					.getContexts()));
		}

		if (copy instanceof IQ7ProjectMetadata) {
			return new ArrayList<String>(Arrays.asList(((IQ7ProjectMetadata) copy)
					.getContexts()));
		}

		if (copy instanceof IContext) {
			NamedElement namedElement = ((IContext) copy).getNamedElement();
			if (namedElement instanceof GroupContext) {
				return new ArrayList<String>(
						((GroupContext) namedElement).getContextReferences());
			}
			if (namedElement instanceof SuperContext) {
				return ((SuperContext) namedElement).getContextReferences();
			}
		}
		throw new IllegalArgumentException();
	}
}
