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
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.LiteralParameter;
import org.eclipse.rcptt.ecl.runtime.IParamConverter;

public class ObjectParamConverter implements IParamConverter<Object> {

	private static interface IConverter {
		public Object convert(String value);
	}

	private static final Map<String, IConverter> CONVERTERS = new HashMap<String, IConverter>();
	static {
		multiPut(CONVERTERS, new IConverter() {
			public Object convert(String value) {
				try {
					return Integer.decode(value);
				} catch (NumberFormatException e) {
					return null;
				}
			}
		}, "int", "Integer", Integer.class.getName());

		multiPut(CONVERTERS, new IConverter() {
			public Object convert(String value) {
				try {
					return Double.valueOf(value);
				} catch (NumberFormatException e) {
					return null;
				}
			}
		}, "double", "Double", Double.class.getName());

		multiPut(CONVERTERS, new IConverter() {
			public Object convert(String value) {
				return value.equalsIgnoreCase("true")
						|| value.equalsIgnoreCase("false") ? Boolean
						.valueOf(value) : null;
			}
		}, "boolean", "Boolean", Boolean.class.getName());

		multiPut(CONVERTERS, new IConverter() {
			public Object convert(String value) {
				return value;
			}
		}, "string" /* why not? ;) */, "String", String.class.getName());
	}

	private static String[] DEFAULT_CONVERTERS = { "int", "double", "boolean",
			"string" };

	public Object convert(LiteralParameter parameter, List<String> allowedTypes)
			throws CoreException {
		String literal = parameter.getLiteral();
		if (literal == null) // just in case
			return null;

		if (allowedTypes == null) { // default behavior
			for (String s : DEFAULT_CONVERTERS) {
				IConverter c = CONVERTERS.get(s);
				assert c != null;
				Object converted = c.convert(literal);
				if (converted != null)
					return converted;
			}
			return literal; // must never be here
		}

		// restricting types
		for (String t : allowedTypes) {
			IConverter converter = CONVERTERS.get(t);
			if (converter == null) {
				if (t.contains(".")) // FQN detected
					// since we are converting literals, we can not do anything
					// useful here -- skipping
					continue;
				return error("No converter for type " + t);
			}

			Object converted = converter.convert(literal);
			if (converted != null)
				return converted;
		}

		return error("Unable to convert \"" + literal + "\"");
	}

	public Class<Object> forType() {
		return Object.class;
	}

	private static Object error(String message) throws CoreException {
		throw new CoreException(new Status(IStatus.ERROR, CorePlugin.PLUGIN_ID,
				message));
	}

	private static <K, V> void multiPut(Map<K, V> map, V value, K... keys) {
		for (K k : keys)
			map.put(k, value);
	}

	public String convertToCode(Object value) {
		return String.valueOf(value);
	}

}
