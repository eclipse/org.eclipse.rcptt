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
package org.eclipse.rcptt.internal.runtime.ui.rap;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.rcptt.runtime.ui.rap.AutEventManager;
import org.eclipse.rcptt.runtime.ui.rap.Q7ServerStarter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class Q7RuntimePreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	private Label eclInfoLabel;
	private Label teslaInfoLabel;
	private Button startButton;

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		eclInfoLabel = new Label(composite, SWT.NONE);
		eclInfoLabel.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true,
				false));
		teslaInfoLabel = new Label(composite, SWT.NONE);
		teslaInfoLabel.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true,
				false));

		startButton = new Button(composite, SWT.PUSH);
		startButton.setText("Start servers");
		startButton.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, true,
				false, 3, 1));
		startButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					try {
						Q7ServerStarter.INSTANCE.start();
						AutEventManager.getInstance().sendStartup();
					} catch (Exception ee) {
						AutEventManager.getInstance().sendInitialStartupFail(
								"Couldn't start Q7 servers. Cause:" + ee.getMessage());
					}
				} finally {
					updateInfo();
				}
			}
		});

		updateInfo();
		return composite;
	}

	private void updateInfo() {
		init(eclInfoLabel, "ECL server", Q7ServerStarter.INSTANCE.getEclPort());
		init(teslaInfoLabel, "Tesla server",
				Q7ServerStarter.INSTANCE.getTeslaPort());
		startButton.setEnabled(!Q7ServerStarter.INSTANCE.isActive());
	}

	private void init(Label label, String prefix, int port) {
		if (port > 0) {
			label.setText(prefix + ": active on port " + Integer.toString(port));
		} else {
			label.setText(prefix + ": not active");
		}
	}

	public void init(IWorkbench workbench) {
	}
}
