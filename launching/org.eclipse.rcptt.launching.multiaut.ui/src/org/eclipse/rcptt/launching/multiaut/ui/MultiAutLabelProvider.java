/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.launching.multiaut.ui;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

public class MultiAutLabelProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
		// Do nothing
	}

	@Override
	public void dispose() {
		// Do nothing

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return true;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// Do nothing
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		LaunchUIEntry entry = (LaunchUIEntry) element;
		switch (columnIndex) {
		case COL_NAME:
			return null;
		case COL_RESTART:
			return entry.restart ? MultiAutUIPlugin.getCheckedImage() : MultiAutUIPlugin.getUncheckedImage();
		default:
			return null;
		}

	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		LaunchUIEntry entry = (LaunchUIEntry) element;
		switch (columnIndex) {
		case COL_NAME:
			return entry.getTestName();
		case COL_AUT:
			return entry.getAutName();
		case COL_RESTART:
			return "";
		default:
			return "";
		}
	}

	private static final int COL_NAME = 0;
	private static final int COL_AUT = 1;
	private static final int COL_RESTART = 2;
}
