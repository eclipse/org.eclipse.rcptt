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
package org.eclipse.rcptt.ui.verification;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.forms.IManagedForm;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.ui.editors.IQ7Editor;

public abstract class BaseVerificationEditor implements IQ7Editor<Verification> {

	protected final DataBindingContext dbc = new DataBindingContext();

	private IVerification verification;

	private IManagedForm form;

	public IVerification getElement() {
		return verification;
	}

	public void setElement(IQ7NamedElement verification) {
		this.verification = (IVerification) verification;
	}

	public void copyContentFrom(Verification verification, IProgressMonitor monitor)
			throws CoreException {
		getElement().getType().getMaker().captureContents(
				getElement(), verification, monitor);
	}

	public void save() throws CoreException {
		// Default empty implementation
	}

	public void select(Object data) {

	}

	public void dispose() {
		dbc.dispose();
	}

	public EObject getCreateParam(AutLaunch launch) {
		return null;
	}

	public void setForm(IManagedForm form) {
		this.form = form;
	}

	public IManagedForm getForm() {
		return form;
	}
}
