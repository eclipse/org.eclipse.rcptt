/*******************************************************************************
 * Copyright (c) 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.zephyr.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.ui.controls.SuggestionItem;
import org.eclipse.rcptt.ui.editors.IScenarioPropertyProvider;
import org.eclipse.rcptt.zephyr.ZephyrService;

public final class ZephyrPropertySuggestionProvider implements IScenarioPropertyProvider {

	@Override
	public List<SuggestionItem> getProperties(Scenario scenario) {
		final List<SuggestionItem> props = new ArrayList<SuggestionItem>();
		props.add(new SuggestionItem(ZephyrService.ZEPHYR_ISSUE));
		return props;
	}

	@Override
	public List<SuggestionItem> getPropertyValues(String name) {
		return Collections.emptyList();
	}

}
