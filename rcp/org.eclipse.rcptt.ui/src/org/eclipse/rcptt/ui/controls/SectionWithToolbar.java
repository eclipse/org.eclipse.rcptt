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
package org.eclipse.rcptt.ui.controls;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class SectionWithToolbar {
	private final IEmbeddedComposite composite;
	private final int style;

	public SectionWithToolbar(IEmbeddedComposite composite, int style) {
		this.composite = composite;
		this.style = style;
	}

	public Section create(Composite parent, FormToolkit toolkit) {
		boolean twistie = (style & Section.TWISTIE) != 0;
		boolean expanded = !twistie || (style & Section.EXPANDED) != 0;
		final Section section = toolkit.createSection(parent, style
				| Section.NO_TITLE_FOCUS_BOX);
		section.setText(composite.getName());
		GridDataFactory.fillDefaults().grab(true, expanded).applyTo(section);

		Composite c = toolkit.createComposite(section);
		GridLayoutFactory.fillDefaults().extendedMargins(0, 0, 0, 5).applyTo(c);
		composite.createControl(c);

		Composite forToolbar = new Composite(section, SWT.NONE);
		FillLayout fl = new FillLayout();
		forToolbar.setLayout(fl);
		if (Platform.getOS().equals(Platform.OS_LINUX)) {
			fl.marginHeight = -2;
		}
		if (Platform.getOS().equals(Platform.OS_MACOSX)) {
			fl.marginHeight = -2;
		}
		composite.createToolBar(forToolbar);

		section.setClient(c);
		section.setTextClient(forToolbar);

		if (twistie) {
			composite.setVisible(expanded);
			composite.observeVisible().addChangeListener(new IChangeListener() {
				public void handleChange(ChangeEvent event) {
					GridDataFactory.fillDefaults()
							.grab(true, composite.getVisible())
							.applyTo(section);
					section.setExpanded(composite.getVisible());
				}
			});
			section.addExpansionListener(new ExpansionAdapter() {
				public void expansionStateChanged(ExpansionEvent e) {
					composite.setVisible(section.isExpanded());
				}
			});
		}
		return section;
	}
}
