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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.rcptt.ecl.runtime.IParamConverter;

@SuppressWarnings("unchecked")
public class ParamConverterManager {
	private static ParamConverterManager instance;

	public static ParamConverterManager getInstance() {
		if (instance == null) {
			instance = new ParamConverterManager();
		}
		return instance;
	}

	private final static String CONVERTER_EXTPT = "org.eclipse.rcptt.ecl.core.param_converter";
	private final static String CONVERTER_CLASS_ATTR = "class";

	private Map<Class<?>, IParamConverter<?>> converters;

	private ParamConverterManager() {
	}

	public <T> IParamConverter<T> getConverter(Class<T> type) {
		if (converters == null) {
			loadScriptlets();
		}
		return (IParamConverter<T>) converters.get(type);
	}

	public boolean hasConverter(Class<?> type) {
		if (converters == null) {
			loadScriptlets();
		}
		return converters.containsKey(type);
	}

	private void loadScriptlets() {
		converters = new HashMap<Class<?>, IParamConverter<?>>();
		IConfigurationElement[] configs = Platform.getExtensionRegistry().getConfigurationElementsFor(CONVERTER_EXTPT);
		for (IConfigurationElement config : configs) {
			try {
				IParamConverter<?> converter = (IParamConverter<?>) config
						.createExecutableExtension(CONVERTER_CLASS_ATTR);
				addConverter(converter);
			} catch (CoreException e) {
				CorePlugin.getDefault().getLog().log(e.getStatus());
			}
		}
	}

	private <T> void addConverter(IParamConverter<T> converter) {
		Class<T> clazz = converter.forType();
		converters.put(clazz, converter);
	}
}
