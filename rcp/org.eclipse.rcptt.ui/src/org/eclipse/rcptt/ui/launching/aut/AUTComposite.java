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
package org.eclipse.rcptt.ui.launching.aut;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.commons.SWTFactory;

public class AUTComposite extends BasicAUTComposite {
	private Button addButton;
	private Button removeButton;

	@Override
	protected void createButtonsBar(Composite composite) {
		Composite bar = new Composite(composite, SWT.NONE);
		GridLayoutFactory.fillDefaults().applyTo(bar);
		GridDataFactory.fillDefaults().applyTo(bar);
		createAdd(bar);
		createRemove(bar);
	}

	private void createAdd(Composite buttonsBar) {
		if (getInitWizard("new") != null) {
			addButton = new Button(buttonsBar, SWT.PUSH);
			addButton.setText(Messages.AUTComposite_AddButton);
			// addApp.setImage(getNewImage().createImage());
			addButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					addAut();
				}
			});
			addButton.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true,
					false));
			SWTFactory.setButtonDimensionHint(addButton);
		}
	}

	private void createRemove(Composite buttonsBar) {
		removeButton = new Button(buttonsBar, SWT.PUSH);
		removeButton.setText(Messages.AUTComposite_RemoveButton);
		// removeApp.setImage(getDeleteImage().createImage());
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeAUT();
			}
		});
		removeButton.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true,
				false));
		SWTFactory.setButtonDimensionHint(removeButton);
	}

	@Override
	protected void updateButtonsEnablement() {
		removeButton.setEnabled(getElement() != null);
	}
}
