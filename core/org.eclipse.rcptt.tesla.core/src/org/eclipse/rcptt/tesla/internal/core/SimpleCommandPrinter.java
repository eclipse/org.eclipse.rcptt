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
package org.eclipse.rcptt.tesla.internal.core;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.ui.Color;

public class SimpleCommandPrinter {
	@SuppressWarnings("rawtypes")
	public static String toString(Command command) {
		if (command == null) {
			return "NULL COMMAND";
		}
		StringBuilder builder = new StringBuilder();
		builder.append(command.eClass().getName());
		// Print other attributes
		EClass eClass = command.eClass();
		EList<EStructuralFeature> features = eClass.getEAllStructuralFeatures();
		for (EStructuralFeature f : features) {
			Object eGet = command.eGet(f);
			if (eGet != null) {
				StringBuilder temp = new StringBuilder();
				if (eGet instanceof Element) {
					temp.append(toString((Element) eGet));
				} else if (eGet instanceof EObject) {
					String content = toString((EObject) eGet, false);
					if (content.length() > 0) {
						temp.append('{').append(content).append('}');
					}
				} else if (eGet instanceof Character) {
					temp.append('{')
							.append(Integer.toHexString((Character) eGet))
							.append('}');
				} else if (eGet instanceof List) {
					List l = (List) eGet;
					if (l.size() > 0) {
						temp.append(eGet);
					}
				} else {
					temp.append('{').append(eGet).append('}');
				}
				if (temp.length() > 0) {
					builder.append(" -").append(f.getName()).append(' ')
							.append(temp.toString());
				}
			}
		}
		return builder.toString();
	}

	@SuppressWarnings("rawtypes")
	public static String toString(EObject obj, boolean alwaysNeedArgs,
			String... ignores) {
		if (obj instanceof Color) {
			Color color = (Color) obj;
			return String.format("#%02X%02X%02X", color.getRed(),
					color.getGreen(), color.getBlue());
		}
		StringBuilder builder = new StringBuilder();
		EClass eClass = obj.eClass();
		EList<EStructuralFeature> features = eClass.getEAllStructuralFeatures();
		for (EStructuralFeature f : features) {
			Object eGet = obj.eGet(f);
			boolean needArg = true;
			Object defaultValue = f.getDefaultValue();
			needArg = (defaultValue == null || !defaultValue.equals(eGet));

			if (alwaysNeedArgs) {
				needArg = true;
			}

			if (eGet instanceof List && ((List) eGet).size() == 0) {
				needArg = false;
			}
			for (String ignore : ignores) {
				if (ignore.equals(f.getName())) {
					needArg = false;
					break;
				}
			}
			if (eGet != null && needArg) {
				builder.append(' ').append(f.getName()).append('=');
				if (eGet instanceof Element) {
					builder.append(toString((Element) eGet));
				} else if (eGet instanceof EObject) {
					builder.append('{')
							.append(toString((EObject) eGet, alwaysNeedArgs,
									"eFactoryInstance")).append('}');
				} else {
					builder.append('{').append(eGet).append('}');
				}
			}
		}
		return builder.toString();
	}

	public static String toString(Element e) {
		return e.getId();
	}

	public static String toString(List<Element> e) {
		if (e.size() == 1) {
			return toString(e.get(0));
		}
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		int index = 0;
		for (Element element : e) {
			builder.append(++index > 0 ? " " : "").append(toString(element));
		}
		builder.append(']');
		return builder.toString();
	}

}
