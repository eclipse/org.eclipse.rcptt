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
package org.eclipse.rcptt.ui.editors.ecl.actions;

import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyledText;

import org.eclipse.rcptt.ui.editors.ecl.EclEditor;

public class SmartLineEndAction extends LineEndAction {

	public SmartLineEndAction(EclEditor editor, StyledText textWidget,
			boolean doSelect) {
		super(editor, textWidget, doSelect);
	}

	protected int getAction() {
		if (fDoSelect) {
			return ST.SELECT_LINE_END;
		}
		return ST.LINE_END;
	}
}