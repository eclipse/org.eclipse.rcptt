/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.context;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.forms.IManagedForm;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.ui.editors.IQ7Editor;

public abstract class BaseContextEditor implements IQ7Editor<Context> {

	protected final DataBindingContext dbc = new DataBindingContext();

	private IContext context;

	private IManagedForm form;

	public void setSelectionAtLine(int line) {
	}

	public IContext getElement() {
		return context;
	}

	public void setElement(IQ7NamedElement context) {
		this.context = (IContext) context;
	}

	public void copyContentFrom(Context context, IProgressMonitor monitor)
			throws CoreException {
		getElement().getType().getMaker().captureContents(getElement(), context, monitor);
	}

	public void save() throws CoreException {
		// Default empty implementation
	}

	public void dispose() {
		dbc.dispose();
	}

	public EObject getCreateParam(AutLaunch launch) throws CoreException {
		return null;
	}

	public void setForm(IManagedForm form) {
		this.form = form;
	}

	public IManagedForm getForm() {
		return form;
	}

	public void select(Object data) {

	}
}
