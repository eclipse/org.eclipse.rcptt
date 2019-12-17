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
package org.eclipse.rcptt.internal.launching.aut;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunchConfiguration;

import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.launching.ILaunchValidator;

public class Q7LaunchValidatorManager {
	private static List<ILaunchValidator> validators = null;

	public static boolean isValid(ILaunchConfiguration config) {
		initialize();
		for (ILaunchValidator validator : validators) {
			if (!validator.isLaunchValid(config)) {
				return false;
			}
		}
		return true;
	}

	private synchronized static void initialize() {
		if (validators == null) {
			validators = new ArrayList<ILaunchValidator>();
			IExtensionPoint extension = Platform.getExtensionRegistry()
					.getExtensionPoint(
							Q7LaunchingPlugin.PLUGIN_ID + ".launchValidator");
			if (extension != null) {
				IConfigurationElement[] elements = extension
						.getConfigurationElements();
				for (IConfigurationElement iConfigurationElement : elements) {
					try {
						ILaunchValidator validator = (ILaunchValidator) iConfigurationElement
								.createExecutableExtension("class");
						validators.add(validator);
					} catch (Throwable e) {
						Q7LaunchingPlugin.log(e);
					}
				}
			}
		}
	}
}
