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
package org.eclipse.rcptt.ecl.doc;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.rcptt.ecl.runtime.FQName;

public class EclDocManager {
	public static EclDocManager instance = new EclDocManager();

	private final static String DOC_XTPT = "org.eclipse.rcptt.ecl.doc";
	private final static String DOC_NAME_ATTR = "name";
	private final static String DOC_NAMESPACE_ATTR = "namespace";
	private final static String DOC_ATTR = "doc";

	public Map<FQName, String> map;

	private EclDocManager() {
	}

	public String getDoc(FQName c) {
		if (map == null) {
			load();
		}
		String doc = map.get(c);
		return doc == null ? "" : doc;
	}

	private Map<FQName, String> load() {
		if (map == null) {
			map = new HashMap<FQName, String>();
			IConfigurationElement[] configs = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(DOC_XTPT);
			for (IConfigurationElement config : configs) {
				String ns = config.getAttribute(DOC_NAMESPACE_ATTR);
				String name = config.getAttribute(DOC_NAME_ATTR);
				String doc = config.getAttribute(DOC_ATTR);
				FQName fqn = new FQName(ns, name);
				map.put(fqn, doc);
			}
		}
		return map;
	}
}
