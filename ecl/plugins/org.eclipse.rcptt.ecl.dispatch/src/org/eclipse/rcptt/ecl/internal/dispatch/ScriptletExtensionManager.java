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
package org.eclipse.rcptt.ecl.internal.dispatch;

import static org.eclipse.core.runtime.Platform.getExtensionRegistry;
import static org.eclipse.rcptt.ecl.internal.core.ScriptletManager.SCRIPTLET_CLASS_ATTR;
import static org.eclipse.rcptt.ecl.internal.core.ScriptletManager.SCRIPTLET_NAMESPACE_ATTR;
import static org.eclipse.rcptt.ecl.internal.core.ScriptletManager.SCRIPTLET_NAME_ATTR;
import static org.eclipse.rcptt.ecl.runtime.FQName.fromCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.dispatch.IScriptletExtension;
import org.eclipse.rcptt.ecl.internal.core.CorePlugin;
import org.eclipse.rcptt.ecl.runtime.FQName;
import org.eclipse.rcptt.ecl.runtime.ICommandService;

public enum ScriptletExtensionManager {
	INSTANCE;

	private ScriptletExtensionManager() {
		loadScriptlets();
	}

	private Map<FQName, ScriptletExtensionPack> byQname = new HashMap<FQName, ScriptletExtensionPack>();
	private Map<String, ScriptletExtensionPack> byName = new HashMap<String, ScriptletExtensionPack>();

	private void loadScriptlets() {
		Map<FQName, List<IConfigurationElement>> exts = new HashMap<FQName, List<IConfigurationElement>>();
		for (IConfigurationElement config : getExtensionRegistry().getConfigurationElementsFor(EXT)) {
			String name = config.getAttribute(SCRIPTLET_NAME_ATTR);
			String ns = config.getAttribute(SCRIPTLET_NAMESPACE_ATTR);
			try {
				FQName fqn = FQName.fromAttributes(ns, name);
				if (!exts.containsKey(fqn)) {
					exts.put(fqn, new ArrayList<IConfigurationElement>());
				}
				exts.get(fqn).add(config);
			} catch (CoreException e) {
				CorePlugin.log(e);
			}
		}

		for (Entry<FQName, List<IConfigurationElement>> entry : exts.entrySet()) {
			List<IScriptletExtension> scriptlets = new ArrayList<IScriptletExtension>();
			for (IConfigurationElement element : entry.getValue()) {
				try {
					scriptlets.add((IScriptletExtension) element.createExecutableExtension(SCRIPTLET_CLASS_ATTR));
				} catch (CoreException e) {
					CorePlugin.log(e);
				}
			}

			FQName key = entry.getKey();
			ScriptletExtensionPack pack = new ScriptletExtensionPack(
					scriptlets.toArray(new IScriptletExtension[scriptlets.size()]));
			byQname.put(key, pack);
			byName.put(key.name, pack);
		}
	}

	private static final String EXT = "org.eclipse.rcptt.ecl.dispatch.scriptletExtension";

	/**
	 * @return suitable extension or null, if the extensions are not suitable or no extension is available
	 */
	public ICommandService getScriptletExtension(Command scriptlet) throws CoreException {
		FQName fqn = fromCommand(scriptlet);
		ScriptletExtensionPack extPack = byQname.get(fqn);
		if (extPack == null) {
			return null;
		}

		IScriptletExtension suitableExt = null;
		for (IScriptletExtension ext : extPack.exts) {
			if (ext.canHandle(scriptlet)) {
				if (suitableExt != null)
					errorNotUnique(fromCommand(scriptlet));

				suitableExt = ext;
				// and check that others can't handle that,
				// so we don't break out from here
			}
		}

		return suitableExt;
	}

	public static final String PLUGIN_ID = "org.eclipse.rcptt.ecl.dispatch";

	private void errorNotUnique(FQName fqn) throws CoreException {
		IStatus status = new Status(IStatus.ERROR, PLUGIN_ID,
				Messages.bind(Messages.NotUniqueExtension, fqn.name));
		throw new CoreException(status);
	}

	private class ScriptletExtensionPack {
		public final IScriptletExtension[] exts;

		protected ScriptletExtensionPack(IScriptletExtension[] exts) {
			this.exts = exts;
		}
	}
}
