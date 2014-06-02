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
package org.eclipse.rcptt.ui.report.internal;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.ui.controls.AbstractEmbeddedComposite;

public class DetailsComposite extends AbstractEmbeddedComposite {

	private Composite control;
	private StyledText text;

	@Override
	protected void fillActions(IToolBarManager manager) {
	}

	public DetailsComposite() {
	}

	public String getName() {
		return "Details";
	}

	public Image getImage() {
		return Images.getImage(Images.FILE);
	}

	public void createControl(Composite parent) {
		super.createControl(parent);

		control = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(control);
		GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(false)
				.applyTo(control);

		text = new StyledText(control, SWT.MULTI | SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL|SWT.READ_ONLY);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(text);
	}

	public void updateText(final String textValue) {
		text.getDisplay().asyncExec(new Runnable() {
			public void run() {
				text.setText(textValue);
			}
		});
	}

	public Control getControl() {
		return control;
	}

}
