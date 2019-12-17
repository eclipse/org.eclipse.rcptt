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
package org.eclipse.rcptt.ecl.popup.ui.internal;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

class DialogRow extends Composite implements IFocusReceiver {

	public DialogRow(Composite parent, String title) {
		super(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(false)
				.applyTo(this);
		
		getGridData().applyTo(this);
		Label titleLabel = new Label(this, SWT.NONE);
		titleLabel.setText(title);

		GridDataFactory.swtDefaults().grab(false, false)
				.align(SWT.BEGINNING, SWT.BEGINNING).applyTo(titleLabel);
		titleLabel.setFont(JFaceResources.getFontRegistry().getBold(
				JFaceResources.TEXT_FONT));
		GridDataFactory.swtDefaults().grab(true, true)
				.align(SWT.FILL, SWT.FILL).applyTo(createContent());
	}

	protected IFocusReceiver focusReceiver;

	public void setFocusReceiver(IFocusReceiver focusReceiver) {
		this.focusReceiver = focusReceiver;
	}
	
	protected ICommandReceiver commandReceiver = new ICommandReceiver() {
		
		public void commandSelected(String command) {
			
		}
	};
	public void setCommandReceiver(ICommandReceiver commandReceiver) {
		this.commandReceiver = commandReceiver;
	}

	private boolean hidden = false;

	public boolean isHidden() {
		return hidden;
	}

	public void hide() {
		GridDataFactory.swtDefaults().hint(0, 0).applyTo(this);
		hidden = true;
	}

	public void show() {
		getGridData().applyTo(this);
		hidden = false;
	}

	private int heightHint = SWT.DEFAULT;

	public void setHeightHint(int heightHint) {
		this.heightHint = heightHint;
		if(!isHidden()) {
			getGridData().applyTo(this);
		}
	}
	
	private GridDataFactory getGridData() {
		return GridDataFactory.swtDefaults().grab(true, false)
			.align(SWT.FILL, SWT.FILL).hint(SWT.DEFAULT, heightHint);
	}
	protected Control createContent() {
		Label result = new Label(this, SWT.NONE);
		result.setText("content goes here");
		return result;
	}

	public void receiveTopFocus() {
	}

	public void receiveBottomFocus() {
	}
}