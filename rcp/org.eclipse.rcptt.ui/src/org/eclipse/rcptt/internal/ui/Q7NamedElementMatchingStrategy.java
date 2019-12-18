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
package org.eclipse.rcptt.internal.ui;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.ui.editors.NamedElementEditor;
import org.eclipse.rcptt.ui.editors.ecl.EclEditor;
import org.eclipse.rcptt.ui.editors.ecl.EclEditorInput;

public class Q7NamedElementMatchingStrategy implements IEditorMatchingStrategy {

	@Override
	public boolean matches(IEditorReference editorRef, IEditorInput input) {
		IQ7Element inputElement = getElement(input);
		if (inputElement != null && editorRef.getId().startsWith("org.eclipse.rcptt.ui.editors")) {
			IWorkbenchPart part = editorRef.getPart(false);
			if (part instanceof EclEditor) {
				IQ7NamedElement model = ((EclEditor) part).getModel();
				if (model != null) {
					return inputElement.equals(model);
				}
			}
			else if (part instanceof NamedElementEditor) {
				IQ7NamedElement model = ((NamedElementEditor) part).getModel();
				if (model != null) {
					return inputElement.equals(model);
				}
			}

			// try figure out using ref editor input
			IEditorInput editRefInput;
			try {
				editRefInput = editorRef.getEditorInput();
				if (editRefInput != null) {
					IQ7Element refElement = getElement(editRefInput);
					return inputElement.equals(refElement);
				}
			} catch (PartInitException e) {
				RcpttPlugin.log(e.getMessage(), e);
			}
		}
		return false;
	}

	private IQ7Element getElement(IEditorInput input) {
		IQ7Element inputElement = null;
		if (input instanceof IFileEditorInput) {
			inputElement = RcpttCore.create(((IFileEditorInput) input).getFile());
		}
		else if (input instanceof EclEditorInput) {
			inputElement = ((EclEditorInput) input).getElement();
		}
		return inputElement;
	}
}
