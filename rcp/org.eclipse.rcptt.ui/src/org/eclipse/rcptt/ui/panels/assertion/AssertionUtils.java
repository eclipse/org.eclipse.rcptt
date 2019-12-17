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
package org.eclipse.rcptt.ui.panels.assertion;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.tesla.core.protocol.Assert;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.ui.PropertyNode;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeType;

public class AssertionUtils {

	public static class ReferencePlaceholder {
		private final Element element;

		ReferencePlaceholder(Element element) {
			this.element = (Element) EcoreUtil.copy(element);
		}

		public Element getElement() {
			return element;
		}
	}

	public static Assert createAssert(String name, Object value,
			EClassifier valueType, Element element, String category) {
		final Assert a = ProtocolFactory.eINSTANCE.createAssert();
		a.setAttribute(name);
		a.setValue(value.toString());
		a.setValueType(valueType);
		a.setCategory(category);
		a.setElement((Element) EcoreUtil.copy(element));
		return a;
	}

	public static void fillAdvancedPropertiesGroup(List<Object> group,
			EList<PropertyNode> propertyNodes, Element element,
			String prefixPath) {
		group.clear();
		if (prefixPath == null) {
			prefixPath = "";
		}
		if (prefixPath.length() > 0) {
			prefixPath += ".";
		}
		for (PropertyNode node : propertyNodes) {
			if (node.getType().equals(PropertyNodeType.PROPERTY)) {
				group.add(AssertionUtils.createAssert(
						prefixPath + node.getName(), node.getValue(), null,
						element, "advanced"));
			} else {
				final List<Object> reference = new ArrayList<Object>();
				reference.add(new ReferencePlaceholder(element));
				group.add(new AssertGroup(node.getName(), reference));
			}

		}
	}

}
