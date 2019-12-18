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
package org.eclipse.rcptt.ecl.internal.core;

import static org.eclipse.rcptt.ecl.internal.core.ScriptletManager.SCRIPTLET_CLASS_ATTR;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.rcptt.ecl.core.util.EclCommandNameConvention;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;
import org.eclipse.rcptt.ecl.runtime.ICommandService;

public final class ScriptletDefinition {
	private final String name;
	private final String namespace;
	private final IConfigurationElement config;
	private Set<String> friendlyNames;
	private ICommandService service;

	ScriptletDefinition(String ns, String name, IConfigurationElement config) {
		this.namespace = ns;
		this.name = name;
		this.config = config;
	}

	Set<String> getFriendlyNames() {
		if (friendlyNames == null) {
			friendlyNames = new HashSet<String>();
			IConfigurationElement[] elements = config
					.getChildren("friendly_name");
			for (IConfigurationElement e : elements) {
				String name = e.getAttribute("value");
				friendlyNames.add(name);
			}
		}
		return friendlyNames;
	}

	ICommandService getService() throws CoreException {
		if (service == null)
			service = (ICommandService) config.createExecutableExtension(SCRIPTLET_CLASS_ATTR);
		return service;
	}

	public EClass getEClass() {
		EPackage epackage = EPackage.Registry.INSTANCE.getEPackage(namespace);
		return (EClass) epackage.getEClassifier(name);
	}

	public String getCommandName() {
		return EclCommandNameConvention.toCommandName(getEClass().getName());
	}

	public boolean isInternal() {
		return getEClass().getEAnnotation(CoreUtils.INTERNAL_ANN) != null;
	}

}