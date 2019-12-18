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
package org.eclipse.rcptt.ui.panels.assertion;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public final class WidgetDetailsDialog extends Dialog {
	@SuppressWarnings("unused")
	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator"); //$NON-NLS-1$
	private StyledText text;
	private String details;
	private static final int COPY_ID = IDialogConstants.CLIENT_ID + 1;

	public WidgetDetailsDialog(Shell parentShell, String details) {
		super(parentShell);
		this.details = details;
		setShellStyle(getShellStyle() | SWT.SHEET);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite content = (Composite) super.createDialogArea(parent);

		text = new StyledText(content, SWT.BORDER | SWT.READ_ONLY
				| SWT.H_SCROLL | SWT.V_SCROLL);
		text.setText(details);

		GridDataFactory.fillDefaults().grab(true, true).applyTo(text);
		GridLayoutFactory.swtDefaults().numColumns(1).applyTo(text);

		return content;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Widget details");
		Rectangle bounds = newShell.getBounds();
		newShell.setBounds(bounds.x, bounds.y, 600, 500);
	}

	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
		createButton(parent, COPY_ID, "Copy to clipboard", true);
		createButton(parent, IDialogConstants.OK_ID,
				IDialogConstants.CLOSE_LABEL, true);
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (COPY_ID == buttonId) {
			Clipboard cb = new Clipboard(getShell().getDisplay());
			cb.setContents(new Object[] { text.getText() },
					new Transfer[] { TextTransfer.getInstance() });
			cb.dispose();
		}
		super.buttonPressed(buttonId);
	}
}