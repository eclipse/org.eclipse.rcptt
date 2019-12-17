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

package org.eclipse.rcptt.ui.editors.ecl;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.text.rules.IRule;

public abstract class SingleTokenScanner extends EnhancedRuleScanner {

	public SingleTokenScanner(EditorToolkit toolkit) {
		super(toolkit);
	}

	@Override
	protected String[] getProperties() {
		return new String[] { getSingleProperty() };
	}

	abstract protected String getSingleProperty();

	@Override
	protected List<IRule> createRules() {
		setDefaultReturnToken(getToken(getSingleProperty()));
		return Collections.emptyList();
	}
}
