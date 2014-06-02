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

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.preferences.FeaturesComposite;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;

public class OptionsComposite extends AbstractEmbeddedComposite {

	protected Composite scrolled;

	public String getName() {
		return Messages.OptionsComposite_Name;
	}

	public Image getImage() {
		return Images.getImage(Images.GEARS);
	}

	private FeaturesComposite features;

	public void setOptionChangeCallback(Runnable callback) {
		if (features != null) {
			features.setOptionChangeCallback(callback);
		}
	}

	public void createControl(Composite parent) {
		super.createControl(parent);
		features = new FeaturesComposite();
		scrolled = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(scrolled);
		GridLayoutFactory.fillDefaults().applyTo(scrolled);
		features.createOptions(scrolled, TeslaFeatures.CP_OPTIONS, true,
		/* new FormToolkit(parent.getDisplay()) */null);
	}

	public Control getControl() {
		return scrolled;
	}

}
