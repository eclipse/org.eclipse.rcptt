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
package org.eclipse.rcptt.ui.editors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.launching.AutLaunch;

public interface IQ7Editor<T> {

	public IQ7NamedElement getElement();

	public void setElement(IQ7NamedElement element);

	public Control create(Composite parent, FormToolkit toolkit, IWorkbenchSite site,
			EditorHeader header);

	public void copyContentFrom(T source, IProgressMonitor monitor) throws CoreException;

	/**
	 * Actions to be executed before primary context editor saved
	 * 
	 * @throws CoreException
	 */
	public void save() throws CoreException;

	public void dispose();

	public EObject getCreateParam(AutLaunch launch) throws CoreException;

	public void setForm(IManagedForm form);

	public void setSelectionAtLine(int line);

	public void select(Object data);
}
