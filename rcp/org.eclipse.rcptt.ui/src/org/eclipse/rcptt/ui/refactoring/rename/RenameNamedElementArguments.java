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
package org.eclipse.rcptt.ui.refactoring.rename;

import org.eclipse.ltk.core.refactoring.participants.RenameArguments;

public class RenameNamedElementArguments extends RenameArguments {

	private final String newElenemtName;

	public RenameNamedElementArguments(String newElementName,
			String newFileName, boolean updateReferences) {
		super(newFileName, updateReferences);
		this.newElenemtName = newElementName;
	}

	public String getNewElenemtName() {
		return newElenemtName;
	}

}
