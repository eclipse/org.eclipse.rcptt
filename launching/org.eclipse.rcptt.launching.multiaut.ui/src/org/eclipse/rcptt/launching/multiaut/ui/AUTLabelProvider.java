/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.launching.multiaut.ui;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.rcptt.ui.launching.aut.AUTProvider;
import org.eclipse.rcptt.ui.launching.aut.AutElement;
import org.eclipse.swt.graphics.Image;

public class AUTLabelProvider extends LabelProvider {
	@Override
	public String getText(Object element) {
		if (element instanceof AutElement) {
			return AUTProvider.getText((AutElement) element);
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof AutElement) {
			AutElement e = (AutElement) element;
			return AUTProvider.getImage(e);
		}
		return super.getImage(element);
	}
}