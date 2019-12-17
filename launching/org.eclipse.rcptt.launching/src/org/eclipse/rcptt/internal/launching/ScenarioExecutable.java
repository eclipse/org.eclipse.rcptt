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
package org.eclipse.rcptt.internal.launching;

import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.launching.AutLaunch;

public abstract class ScenarioExecutable extends DataExecutable {

	public ScenarioExecutable(AutLaunch launch, ITestCase scenario, boolean debug) {
		super(launch, scenario, debug);
	}

	@Override
	public ITestCase getActualElement() {
		return (ITestCase) super.getActualElement();
	}

	public int getType() {
		return TYPE_SCENARIO;
	}
}
