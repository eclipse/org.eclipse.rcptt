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
package org.eclipse.rcptt.ctx.extensions;

import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.ecl.context.EclContext;
import org.eclipse.rcptt.core.ecl.model.IDeclContainer;
import org.eclipse.rcptt.core.ecl.model.providers.IContextContainerProvider;
import org.eclipse.rcptt.core.ecl.parser.ast.Parser;
import org.eclipse.rcptt.core.ecl.parser.model.ScriptContainer;

public class EclContextProvider implements IContextContainerProvider {

	@Override
	public IDeclContainer create(Context context) {
		if (!(context instanceof EclContext)) {
			return null;
		}
		return ScriptContainer.fromScript(Parser.parse(((EclContext) context).getScript().getContent()),
				context.getId());
	}

}
