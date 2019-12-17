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
package org.eclipse.rcptt.ui.search;

import org.eclipse.core.runtime.SubMonitor;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

public class ScenarioMatcher implements Matcher {

	public boolean matches(IQ7NamedElement object, String query,
			SubMonitor monitor) {
		if (!(object instanceof ITestCase)) {
			return false;
		}

		final ITestCase scenario = (ITestCase) object;
		try {
			if (scenario.getExternalReference() != null
					&& scenario.getExternalReference().toLowerCase()
							.contains(query)) {
				return true;
			}
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}

		return false;
	}
}
