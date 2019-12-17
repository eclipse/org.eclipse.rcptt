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
package org.eclipse.rcptt.ui.controls;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class SectionWithComposite {

	private final String name;
	private final int style;
	private int numColumns = 1;
	private boolean grabVertical = true;
	private Section section;
	private Composite composite;

	public SectionWithComposite(String name, int style) {
		this.name = name;
		this.style = style;
	}

	public Section getSection() {
		return section;
	}

	public Composite getComposite() {
		return composite;
	}

	public SectionWithComposite numColumns(int numColumns) {
		this.numColumns = numColumns;
		return this;
	}

	public SectionWithComposite grabVertical(boolean grabVertical) {
		this.grabVertical = grabVertical;
		return this;
	}

	public Section create(Composite parent, FormToolkit toolkit) {
		boolean twistie = (style & Section.TWISTIE) != 0;
		boolean expanded = !twistie || (style & Section.EXPANDED) != 0;
		section = toolkit.createSection(parent, style
				| Section.NO_TITLE_FOCUS_BOX);
		section.setText(name);
		GridDataFactory.fillDefaults().grab(true, grabVertical && expanded)
				.applyTo(section);

		composite = toolkit.createComposite(section);
		GridLayoutFactory.fillDefaults().extendedMargins(0, 0, 0, 5)
				.numColumns(numColumns).applyTo(composite);
		section.setClient(composite);

		if (twistie) {
			section.addExpansionListener(new ExpansionAdapter() {
				public void expansionStateChanged(ExpansionEvent e) {
					GridDataFactory.fillDefaults()
							.grab(true, grabVertical && section.isExpanded())
							.applyTo(section);
					section.getParent().layout();
				}
			});
		}
		return section;
	}

}
