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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;

public interface IEmbeddedComposite {

	String getName();

	Image getImage();

	void createControl(Composite parent);

	Control getControl();

	void createToolBar(Composite parent);

	ToolBar getToolBar();

	boolean getVisible();

	void setVisible(boolean value);

	IObservableValue observeVisible();

	void dispose();
}
