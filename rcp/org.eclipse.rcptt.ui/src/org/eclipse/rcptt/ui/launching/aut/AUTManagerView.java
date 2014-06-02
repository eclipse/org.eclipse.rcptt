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
package org.eclipse.rcptt.ui.launching.aut;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.part.ViewPart;

public class AUTManagerView extends ViewPart {

	private BasicAUTComposite autManager;

	public AUTManagerView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayout gl = new GridLayout();
		gl.marginWidth = 0;
		gl.marginHeight = 0;
		gl.verticalSpacing = 0;
		gl.horizontalSpacing = 0;
		parent.setLayout(gl);
		autManager = new AUTViewComposite((IViewSite) getSite());
		autManager.create(parent, false);
	}

	public void init(IViewSite site) throws org.eclipse.ui.PartInitException {
		super.init(site);

		site.setSelectionProvider(new ISelectionProvider() {
			public void setSelection(ISelection selection) {
			}

			public void removeSelectionChangedListener(
					ISelectionChangedListener listener) {
				autManager.viewer.removeSelectionChangedListener(listener);
			}

			public ISelection getSelection() {
				AutElement element = autManager.getElement();
				if (element != null)
					return new StructuredSelection(element);
				else
					return new StructuredSelection();
			}

			public void addSelectionChangedListener(
					ISelectionChangedListener listener) {
				autManager.viewer.addSelectionChangedListener(listener);
			}
		});
	};

	@Override
	public void setFocus() {
	}
}
