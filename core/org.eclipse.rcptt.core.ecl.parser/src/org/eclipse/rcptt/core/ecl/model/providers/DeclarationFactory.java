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
package org.eclipse.rcptt.core.ecl.model.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.ContextTypeManager;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.ecl.model.IDeclContainer;
import org.eclipse.rcptt.core.internal.ecl.parser.Q7EclParserPlugin;

public enum DeclarationFactory {
	INSTANCE;
	private DeclarationFactory() {
		for (IConfigurationElement element : Platform.getExtensionRegistry().getConfigurationElementsFor(EXT)) {
			try {
				providers.put(element.getAttribute(ATTR_ID),
						(IContextContainerProvider) element.createExecutableExtension(ATTR_CLASS));
			} catch (Exception e) {
				Q7EclParserPlugin.logErr(e, "Error loading context declaration provider from plugin %s", element
						.getDeclaringExtension().getUniqueIdentifier());
			}
		}
	}

	public IDeclContainer safeFromContext(IContext context) {
		try {
			return fromContext(context);
		} catch (Exception e) {
			Q7EclParserPlugin.logErr(e, "Error loading declarations from context");
			return null;
		}
	}

	public IDeclContainer fromContext(IContext context) throws ModelException {
		Context content = (Context) context.getNamedElement();
		ContextType type = ContextTypeManager.getInstance().getTypeByContext(content);
		IContextContainerProvider provider = providers.get(type.getId());
		if (provider != null) {
			return provider.create(content);
		}
		return null;
	}

	private static final String ATTR_ID = "contextId";
	private static final String ATTR_CLASS = "class";
	private static final String EXT = Q7EclParserPlugin.PLUGIN_ID + ".context_container_provider";
	private Map<String, IContextContainerProvider> providers = new HashMap<String, IContextContainerProvider>();
}
