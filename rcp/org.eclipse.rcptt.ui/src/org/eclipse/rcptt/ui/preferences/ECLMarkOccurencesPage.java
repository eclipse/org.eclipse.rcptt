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
package org.eclipse.rcptt.ui.preferences;

import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.rcptt.core.ecl.parser.model.OccurrencesSettings;
import org.eclipse.rcptt.ui.editors.ecl.ECLEditorPlugin;
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

public class ECLMarkOccurencesPage extends PreferencePage implements IWorkbenchPreferencePage {

	private Button occurencesEnabled;
	private Button markCommands;
	private Button markProcs;
	private Button markGlobals;
	private Button markLocals;

	@Override
	public boolean performOk() {
		save();
		return super.performOk();
	}

	@Override
	protected void performDefaults() {
		toUI(OccurrencesSettings.DEFAULT);
		super.performDefaults();
	}

	private OccurrencesSettings fromUI() {
		return new OccurrencesSettings(occurencesEnabled.getSelection(),
				markCommands.getSelection(),
				markProcs.getSelection(),
				markGlobals.getSelection(),
				markLocals.getSelection());
	}

	private void toUI(OccurrencesSettings settings) {
		occurencesEnabled.setSelection(settings.enabled);
		markCommands.setSelection(settings.commands);
		markProcs.setSelection(settings.procs);
		markGlobals.setSelection(settings.globals);
		markLocals.setSelection(settings.locals);
		updateEnablement();
	}

	private void updateEnablement() {
		boolean enabled = occurencesEnabled.getSelection();
		markCommands.setEnabled(enabled);
		markProcs.setEnabled(enabled);
		markGlobals.setEnabled(enabled);
		markLocals.setEnabled(enabled);
	}

	private void save() {
		ECLEditorPlugin.setMarkSettings(fromUI());
	}

	public void init(IWorkbench workbench) {
	}

	private Button createButton(Composite parent, String labelText, boolean master) {
		Button button = new Button(parent, SWT.CHECK);
		if (master) {
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					updateEnablement();
				}
			});
		}
		button.setText(labelText);
		if (!master) {
			GridData gridData = new GridData();
			gridData.horizontalIndent = 10;
			button.setLayoutData(gridData);
		}
		return button;
	}

	private void addFiller(Composite composite) {
		PixelConverter pixelConverter = new PixelConverter(composite);

		Label filler = new Label(composite, SWT.LEFT);
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.horizontalSpan = 1;
		gd.heightHint = pixelConverter.convertHeightInCharsToPixels(1) / 2;
		filler.setLayoutData(gd);
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		occurencesEnabled = createButton(composite,
				"Mark occurrences of the selected element in the current file.",
				true);
		addFiller(composite);
		markCommands = createButton(composite, "Commands", false);
		markProcs = createButton(composite, "References", false);
		markGlobals = createButton(composite, "Parameters", false);
		markLocals = createButton(composite, "Constants", false);

		toUI(ECLEditorPlugin.getMarkSettings());
		return composite;
	}
}
