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
package org.eclipse.rcptt.ui.dialogs;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

public class ChangesWarningDialog extends LinkMessageDialogWithToggle {
	private static final String TITLE = "Saving changes";
	private static final String MESSAGE_TEMPLATE = "This test case is under debugging, changes will not affect current execution.";
	private static final String TOGGLE_MESSAGE = "Never show this dialog again";
	private static final String PREF_KEY_DONT_SHOW_DIALOG_AGAIN = "org.eclipse.rcptt.ui.dialogs_ChangesWarningDialog_DontShowDialogAgain";

	@SuppressWarnings("deprecation")
	public ChangesWarningDialog(Shell parentShell) {
		super(parentShell, TITLE, null, MESSAGE_TEMPLATE,
				MessageDialog.WARNING,
				new String[] { IDialogConstants.OK_LABEL }, 0, TOGGLE_MESSAGE,
				false, PREF_KEY_DONT_SHOW_DIALOG_AGAIN, new InstanceScope()
						.getNode(Q7UIPlugin.PLUGIN_ID));
	}

}
