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
package org.eclipse.rcptt.ctx.capability;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.index.IIndexDocument;
import org.eclipse.rcptt.core.model.index.IIndexer;
import org.eclipse.rcptt.core.model.index.IQ7IndexConstants;
import org.eclipse.rcptt.core.scenario.CapabilityContext;
import org.eclipse.rcptt.core.scenario.CapabilityContextItem;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class CapabilityContextIndexer implements IIndexer {

	public CapabilityContextIndexer() {
	}

	public void index(IIndexDocument document) {
		IQ7NamedElement element = null;
		try {
			element = document.getElement();
			if (!(element instanceof IContext)) {
				return;
			}
			NamedElement namedElement = element.getNamedElement();
			if (namedElement instanceof CapabilityContext) {
				CapabilityContext ctx = (CapabilityContext) namedElement;
				for (CapabilityContextItem item : ctx.getItems()) {
					for (String ctxRef : item.getContextReferences()) {
						document.addKey(IQ7IndexConstants.CONTEXT_REF, ctxRef);
					}
				}

			}
		} catch (ModelException e) {
			RcpttPlugin.log(e);
		}
	}

}
