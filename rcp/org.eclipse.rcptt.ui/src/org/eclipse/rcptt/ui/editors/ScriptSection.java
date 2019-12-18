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
package org.eclipse.rcptt.ui.editors;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import org.eclipse.rcptt.internal.ui.Messages;

public class ScriptSection {

	private Composite content;
	private Composite toolbar;

	private Section section;

	public Section getSection() {
		return section;
	}

	public Composite getToolbar() {
		return toolbar;
	}

	public Composite getContent() {
		return content;
	}

	public void create(Composite parent, final FormToolkit toolkit) {
		section = toolkit.createSection(parent, Section.TITLE_BAR
				| Section.TWISTIE | Section.EXPANDED
				| Section.NO_TITLE_FOCUS_BOX);

		section.setText(getName());
		GridDataFactory.fillDefaults().
				grab(true, true).
				applyTo(section);

		content = toolkit.createComposite(section);
		content.setLayout(new FillLayout());

		toolbar = new Composite(section, SWT.NONE);
		FillLayout fl = new FillLayout();
		toolbar.setLayout(fl);
		if (Platform.getOS().equals(Platform.OS_LINUX)) {
			fl.marginHeight = -2;
		}
		if (Platform.getOS().equals(Platform.OS_MACOSX)) {
			fl.marginHeight = -2;
		}

		section.setClient(content);
		section.setTextClient(toolbar);
	}

	public String getName() {
		return Messages.ScriptComposite_Name;
	}

	public boolean isExpanded() {
		return section.isExpanded();
	}

	public void setExpanded(boolean value) {
		section.setExpanded(value);
	}

}
