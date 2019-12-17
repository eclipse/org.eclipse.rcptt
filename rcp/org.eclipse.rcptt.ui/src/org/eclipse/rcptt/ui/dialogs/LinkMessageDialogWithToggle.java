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
package org.eclipse.rcptt.ui.dialogs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public abstract class LinkMessageDialogWithToggle extends
		MessageDialogWithToggle {

	protected static final String TOGGLE_MESSAGE = "Never show this dialog again";
	private static final Pattern LINK_PATTERN = Pattern.compile("<a>(.*)</a>");

	private final String linkMessage;
	private final String link;
	private final IEclipsePreferences prefs;

	public LinkMessageDialogWithToggle(Shell parentShell, String dialogTitle,
			Image image, String linkMessage, int dialogImageType,
			String[] dialogButtonLabels, int defaultIndex,
			String toggleMessage, boolean toggleState, String prefKey,
			IEclipsePreferences prefs) {
		super(parentShell, dialogTitle, image, null, dialogImageType,
				dialogButtonLabels, defaultIndex, toggleMessage, toggleState);
		Matcher matcher = LINK_PATTERN.matcher(linkMessage);
		this.linkMessage = linkMessage;
		String link = null;
		while (matcher.find()) {
			if (link != null)
				throw new IllegalArgumentException("More than one link found");
			link = matcher.group(1);
		}
		if (link != null)
			this.link = link.contains("@") ? "mailto:" + link : link;
		else
			this.link = null;
		setPrefKey(prefKey);
		this.prefs = prefs;
		setShellStyle(getShellStyle() | SWT.SHEET);
	}

	@Override
	protected Control createMessageArea(Composite composite) {
		super.createMessageArea(composite);
		Link link = new Link(composite, SWT.NONE);
		link.setText(linkMessage);
		GridDataFactory
				.fillDefaults()
				.align(SWT.FILL, SWT.BEGINNING)
				.grab(true, false)
				.hint(convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH),
						SWT.DEFAULT).applyTo(link);
		link.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				Program.launch(LinkMessageDialogWithToggle.this.link);
			}
		});
		return composite;
	}

	@Override
	public int open() {
		String show = prefs.get(getPrefKey(), MessageDialogWithToggle.PROMPT);
		if (!MessageDialogWithToggle.NEVER.equals(show)) {
			int result = super.open();
			if (getToggleState()) {
				prefs.put(getPrefKey(), MessageDialogWithToggle.NEVER);
			}
			return result;
		}
		return 0;
	}

}
