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
package org.eclipse.rcptt.ui.recording;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.rcptt.core.VerificationType;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

public class WidgetPickerWindow extends Dialog {

	private static final String SETTINGS_KEY = "WidgetPickerWindow";
	private final Shell shellToListenForClose;
	private final VerificationType type;

	public WidgetPickerWindow(Shell shellToListenForClose, Shell parentShell,
			VerificationType type) {
		super(parentShell);
		this.shellToListenForClose = shellToListenForClose;
		this.type = type;
		setShellStyle(SWT.TOOL | SWT.CLOSE | SWT.ON_TOP | SWT.RESIZE |
				(parentShell != null ? SWT.PRIMARY_MODAL : 0));
	}

	@Override
	protected Control createContents(Composite parent) {
		final String prompt = type.getPrompt();

		Label welcomeLabel = new Label(parent, SWT.WRAP);
		GridDataFactory.fillDefaults().hint(334, SWT.DEFAULT).
				grab(true, true).applyTo(welcomeLabel);
		welcomeLabel.setText(prompt == null ?
				"Please pick a widget for verification." :
				type.getPrompt());

		// FontData existingFont = welcomeLabel.getFont().getFontData()[0];
		// welcomeLabel.setFont(new Font(welcomeLabel.getDisplay(),
		// new FontData(existingFont.name, (int) existingFont.height + 4,
		// existingFont.style)));

		Label cancelLabel = new Label(parent, SWT.NONE);
		GridDataFactory.fillDefaults().indent(0, 16).applyTo(cancelLabel);
		cancelLabel.setText("Waiting for selection. Press Esc to cancel.");

		Button cancelButton = new Button(parent, SWT.PUSH);
		cancelButton.setText("Cancel");
		GridDataFactory.fillDefaults().align(SWT.RIGHT, SWT.CENTER).
				applyTo(cancelButton);
		cancelButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});

		parent.getShell().pack();
		parent.getShell().setLocation(getInitialLocation(getInitialSize()));

		return parent;
	}

	@Override
	protected Point getInitialLocation(Point location) {
		if (hasDialogBoundsSettings()) {
			return super.getInitialLocation(location);
		} else {
			return new Point(0, 0);
		}
	}

	@Override
	protected IDialogSettings getDialogBoundsSettings() {
		final IDialogSettings root = Q7UIPlugin.getDefault()
				.getDialogSettings();
		IDialogSettings section = root.getSection(SETTINGS_KEY);
		if (section == null) {
			section = root.addNewSection(SETTINGS_KEY);
		}
		return section;
	}

	private boolean hasDialogBoundsSettings() {
		final IDialogSettings root = Q7UIPlugin.getDefault()
				.getDialogSettings();
		return root.getSection(SETTINGS_KEY) != null;
	}

	@Override
	protected void configureShell(final Shell newShell) {
		super.configureShell(newShell);
		GridLayoutFactory.fillDefaults().equalWidth(true).numColumns(1).spacing(8, 8)
				.margins(8, 8).applyTo(newShell);
		shellToListenForClose.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				close();
			}
		});

		final Listener filter = new Listener() {
			@Override
			public void handleEvent(Event event) {
				if (event.widget instanceof Control &&
						((Control) event.widget).getShell() == newShell &&
						event.keyCode == SWT.ESC) {
					close();
				}
			}
		};
		newShell.getDisplay().addFilter(SWT.KeyDown, filter);

		newShell.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				newShell.getDisplay().removeFilter(SWT.KeyDown, filter);
			}
		});
	}
}
