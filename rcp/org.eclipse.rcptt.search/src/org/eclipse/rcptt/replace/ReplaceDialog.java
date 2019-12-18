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
package org.eclipse.rcptt.replace;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ReplaceDialog extends Dialog {

	protected int result;
	protected Shell shlReplaceTextMatches;
	private Label lblMathesDesc;
	private Text txtOriginalString;
	private Text txtReplaceString;
	private String fReplaceString;
	private Button btnOK;

	private static final String DIALOG_TITLE = "Replace Text Matches"; //$NON-NLS-1$	
	private static final String REPLACE_HINT = "Replace:"; //$NON-NLS-1$
	private static final String REPLACE_WITH_HINT = "With:"; //$NON-NLS-1$	
	private static final String OK_BTN = "OK"; //$NON-NLS-1$	
	private static final String CANCEL_BTN = "Cancel"; //$NON-NLS-1$	

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public ReplaceDialog(Shell parent) {
		super(parent);
		setText(DIALOG_TITLE);
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public int open(String replaceHint, String originalString) {
		createContents();

		result = org.eclipse.jface.dialogs.Dialog.CANCEL;

		txtOriginalString.setText(originalString);
		lblMathesDesc.setText(replaceHint);

		shlReplaceTextMatches.open();
		shlReplaceTextMatches.layout();
		Display display = getParent().getDisplay();
		while (!shlReplaceTextMatches.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	public String getReplaceString() {
		return fReplaceString;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {

		shlReplaceTextMatches = new Shell(getParent(), SWT.DIALOG_TRIM
				| SWT.PRIMARY_MODAL | SWT.SHEET);
		shlReplaceTextMatches.setSize(450, 167);
		shlReplaceTextMatches.setText(DIALOG_TITLE);

		lblMathesDesc = new Label(shlReplaceTextMatches, SWT.NONE);
		lblMathesDesc.setBounds(10, 10, 254, 15);

		Label lblReplaceHint = new Label(shlReplaceTextMatches, SWT.NONE);
		lblReplaceHint.setBounds(10, 44, 55, 15);
		lblReplaceHint.setText(REPLACE_HINT);

		txtOriginalString = new Text(shlReplaceTextMatches, SWT.BORDER);
		txtOriginalString.setEnabled(false);
		txtOriginalString.setBounds(80, 38, 354, 21);

		Label lblNewHint = new Label(shlReplaceTextMatches, SWT.NONE);
		lblNewHint.setBounds(10, 65, 55, 15);
		lblNewHint.setText(REPLACE_WITH_HINT);

		txtReplaceString = new Text(shlReplaceTextMatches, SWT.BORDER);
		txtReplaceString.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				fReplaceString = txtReplaceString.getText();
				btnOK.setEnabled(fReplaceString.length() > 0);
			}
		});
		txtReplaceString.setBounds(80, 65, 354, 21);

		btnOK = new Button(shlReplaceTextMatches, SWT.NONE);
		btnOK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				result = org.eclipse.jface.dialogs.Dialog.OK;
				shlReplaceTextMatches.close();
			}
		});
		btnOK.setBounds(278, 104, 75, 25);
		btnOK.setText(OK_BTN);
		shlReplaceTextMatches.setDefaultButton(btnOK);
		btnOK.setEnabled(false);

		Button btnCancel = new Button(shlReplaceTextMatches, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlReplaceTextMatches.close();
			}
		});
		btnCancel.setBounds(359, 104, 75, 25);
		btnCancel.setText(CANCEL_BTN);
	}
}
