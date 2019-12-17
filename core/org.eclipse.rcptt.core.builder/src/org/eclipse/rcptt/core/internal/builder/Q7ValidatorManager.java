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
package org.eclipse.rcptt.core.internal.builder;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import org.eclipse.rcptt.core.builder.IQ7Validator;

public class Q7ValidatorManager {
	private List<IQ7Validator> managers = null;

	public Q7ValidatorManager() {
	}

	private synchronized void initialize() {
		if (managers != null) {
			return;
		}
		managers = new ArrayList<IQ7Validator>();

		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						Q7BuilderActivator.PLUGIN_ID + ".q7Validator");
		for (IConfigurationElement cfg : elements) {
			IQ7Validator provider;
			try {
				provider = (IQ7Validator) cfg
						.createExecutableExtension("class");
				managers.add(provider);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	public IQ7Validator[] getExtensions() {
		initialize();
		return managers.toArray(new IQ7Validator[managers.size()]);
	}
}
