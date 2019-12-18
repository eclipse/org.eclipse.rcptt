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
package org.eclipse.rcptt.ui.commons;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public abstract class OneSelectionListener implements SelectionListener {

	public abstract void selected(SelectionEvent e);

	public void widgetSelected(SelectionEvent e) {
		selected(e);
	}

	public void widgetDefaultSelected(SelectionEvent e) {
		selected(e);
	}
}
