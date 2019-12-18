/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ctx.extensions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.scenario.SuperContext;
import org.eclipse.rcptt.core.ecl.model.CompositeContainer;
import org.eclipse.rcptt.core.ecl.model.IDeclContainer;
import org.eclipse.rcptt.core.ecl.model.providers.DeclarationFactory;
import org.eclipse.rcptt.core.ecl.model.providers.IContextContainerProvider;

public class SupercontextProvider implements IContextContainerProvider {
	public IDeclContainer create(Context context) {
		if (!(context instanceof SuperContext)) {
			return null;
		}

		List<IDeclContainer> children = new ArrayList<IDeclContainer>();
		for (String contextId : ((SuperContext) context).getContextReferences()) {
			IQ7NamedElement child = Q7SearchCore.findById(contextId);
			if (child == null || !(child instanceof IContext)) {
				continue;
			}
			try {
				IDeclContainer childContainer = DeclarationFactory.INSTANCE.fromContext((IContext) child);
				if (childContainer != null) {
					children.add(childContainer);
				}
			} catch (ModelException e) {
				// Ignore
			}
		}

		return new CompositeContainer(children.toArray(new IDeclContainer[children.size()]));
	}
}
