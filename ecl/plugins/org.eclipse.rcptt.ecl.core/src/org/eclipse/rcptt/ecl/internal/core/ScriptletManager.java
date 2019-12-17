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

package org.eclipse.rcptt.ecl.internal.core;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.FQName;
import org.eclipse.rcptt.ecl.runtime.ICommandService;

public class ScriptletManager {

	final static String SCRIPTLET_EXTPT = "org.eclipse.rcptt.ecl.core.scriptlet";
	public final static String SCRIPTLET_NAME_ATTR = "name";
	public final static String SCRIPTLET_NAMESPACE_ATTR = "namespace";
	public final static String SCRIPTLET_CLASS_ATTR = "class";

	public static final boolean TRACE_REGISTERED_COMMANDS = Boolean.valueOf(
			Platform.getDebugOption(CorePlugin.PLUGIN_ID
					+ "/traceRegisteredCommands")).booleanValue();

	private Map<FQName, ScriptletDefinition> scriptlets;

	synchronized ICommandService getScriptletService(Command scriptlet)
			throws CoreException {
		String ns = scriptlet.eClass().getEPackage().getNsURI();
		String name = scriptlet.eClass().getName();
		return getScriptletDefinition(ns, name).getService();
	}

	synchronized public EClass findCommand(String ns, String name)
			throws CoreException {
		return getScriptletDefinition(ns, name).getEClass();
	}

	synchronized public Command createCommand(String ns, String name)
			throws CoreException {
		EClass clazz = getScriptletDefinition(ns, name).getEClass();
		return (Command) clazz.getEPackage().getEFactoryInstance()
				.create(clazz);
	}

	private synchronized ScriptletDefinition getScriptletDefinition(String ns,
			String name) throws CoreException {
		if (scriptlets == null)
			loadScriptlets();
		FQName fqn = new FQName(ns, name);
		ScriptletDefinition def = scriptlets.get(fqn);
		// Search unique scriptlet
		if (def == null) {
			FQName fqname = null;
			for (FQName d : scriptlets.keySet()) {
				if (d.name.equals(name)) {
					if (fqname == null) {
						fqname = d;
					} else {
						fqname = null;
						break;
					}
				} else {
					ScriptletDefinition sd = scriptlets.get(d);
					Set<String> friendlyNames = sd.getFriendlyNames();
					if (friendlyNames.contains(name)) {
						if (fqname == null) {
							fqname = d;
						} else {
							fqname = null;
							break;
						}
					}
				}
			}
			if (fqname != null) {
				def = scriptlets.get(fqname);
			}
		}
		if (def == null) {
			IStatus status = new Status(IStatus.ERROR, CorePlugin.PLUGIN_ID,
					MessageFormat.format("Scriptlet {0} not found",
							new Object[] { fqn }));
			if (TRACE_REGISTERED_COMMANDS)
				System.out.println(status.getMessage());

			throw new CoreException(status);
		}
		return def;
	}

	synchronized public Set<FQName> getAllCommandNames() {
		if (scriptlets == null)
			loadScriptlets();
		return scriptlets.keySet();
	}

	synchronized public Set<String> getAllFriendlyNames() {
		if (scriptlets == null)
			loadScriptlets();
		Set<String> all = new HashSet<String>();
		for (ScriptletDefinition def : scriptlets.values()) {
			all.addAll(def.getFriendlyNames());
		}
		return all;
	}

	synchronized public Set<String> getFriendlyNames(String ns, String name)
			throws CoreException {
		ScriptletDefinition def = getScriptletDefinition(ns, name);
		return def == null ? null : def.getFriendlyNames();
	}

	private void loadScriptlets() {
		scriptlets = new HashMap<FQName, ScriptletDefinition>();
		IConfigurationElement[] configs = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(SCRIPTLET_EXTPT);
		for (IConfigurationElement config : configs) {
			String ns = config.getAttribute(SCRIPTLET_NAMESPACE_ATTR);
			String name = config.getAttribute(SCRIPTLET_NAME_ATTR);
			try {
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(ns);
				Assert.isLegal(ePackage != null, "Unknown package nsURI=" + ns);
				Assert.isLegal(
						ePackage.getEClassifier(name) != null,
						"Unknown class=" + name + " in package="
								+ ePackage.getName());
				FQName fqn = new FQName(ns, name);
				if (TRACE_REGISTERED_COMMANDS)
					System.out.println("Loaded definition of command " + fqn);
				scriptlets.put(fqn, new ScriptletDefinition(ns, name, config));
			} catch (Exception e) {
				CorePlugin.log(CorePlugin.err("Failed to load scriptlet "
						+ name + ": " + e.getMessage(), e));
			}
		}
	}
}
