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
package org.eclipse.rcptt.expandbar.ide.internal;

import static org.eclipse.rcptt.expandbar.ExpandBarConstants.EXPAND_BAR_KIND;

import java.util.List;

import org.eclipse.rcptt.expandbar.commands.CommandsFactory;
import org.eclipse.rcptt.tesla.ecl.model.Selector;
import org.eclipse.rcptt.tesla.recording.core.ecl.ISelectorParserExtension;

public class ExpandBarSelectorParserExtension implements ISelectorParserExtension {

	@Override
	public Selector selector(String customKindId, String text, List<String> path, List<Integer> indexes) {
		if (!customKindId.equals(EXPAND_BAR_KIND)) {
			return null;
		}

		return CommandsFactory.eINSTANCE.createGetExpandBar();
	}

	@Override
	public boolean isParamNameForced(String commandName, String paramName) {
		return false;
	}

}
