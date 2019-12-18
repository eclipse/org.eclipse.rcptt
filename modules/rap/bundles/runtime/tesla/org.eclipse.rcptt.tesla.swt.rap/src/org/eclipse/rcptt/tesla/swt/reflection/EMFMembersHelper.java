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
package org.eclipse.rcptt.tesla.swt.reflection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.rcptt.tesla.core.ui.PropertyNode;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeType;
import org.eclipse.rcptt.tesla.core.ui.UiFactory;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTModelMapper;

public class EMFMembersHelper {

	public static final String LIST_SIZE_PROPERTY_CAPTION = "size"; //$NON-NLS-1$	

	public static String getPropertyValue(Object object, String nodePath) {
		Object node = findNodeValue(object, nodePath);
		if (node != null) {
			return node.toString();
		}
		return null;
	}

	public static boolean fillProperties(Object object, String nodePath,
			EList<PropertyNode> propertiesNodes) {
		Object node = findNodeValue(object, nodePath);
		if (node != null) {
			fillProperties(node, propertiesNodes);
			return true;
		}
		return false;
	}

	public static void fillProperties(Object object,
			EList<PropertyNode> propertiesNodes) {
		fillProperties(object, propertiesNodes, "");
	}

	public static void fillProperties(Object object,
			EList<PropertyNode> propertiesNodes, String... ignoresArray) {

		Set<String> ignores = new HashSet<String>(Arrays.asList(ignoresArray));

		if (object instanceof List) {
			processList(object, propertiesNodes);
		}
		if (object instanceof EObject) {
			EObject emfObject = (EObject) object;
			EClass eClass = emfObject.eClass();
			EList<EStructuralFeature> features = eClass
					.getEAllStructuralFeatures();
			for (EStructuralFeature eStructuralFeature : features) {
				if (ignores.contains(eStructuralFeature.getName())) {
					continue;
				}
				processStructuralFeature(emfObject, eStructuralFeature,
						propertiesNodes);
			}
		}
	}

	private static void processList(Object object,
			EList<PropertyNode> propertiesNodes) {

		List<?> list = (List<?>) object;

		PropertyNode lenghtNode = UiFactory.eINSTANCE.createPropertyNode();
		lenghtNode.setName(LIST_SIZE_PROPERTY_CAPTION);
		lenghtNode.setType(PropertyNodeType.PROPERTY);
		lenghtNode.setValue(Integer.toString(list.size()));
		propertiesNodes.add(lenghtNode);

		int idx = 0;
		for (Object item : list) {
			if (item instanceof EObject) {
				EObject itemEmfObject = (EObject) item;
				EClass eClass = itemEmfObject.eClass();
				PropertyNode propertyNode = UiFactory.eINSTANCE
						.createPropertyNode();
				propertyNode.setName(eClass.getName() + "[" + idx + "]");
				propertyNode.setType(PropertyNodeType.REFERENCE);
				propertiesNodes.add(propertyNode);
			} else {
				PropertyNode propertyNode = UiFactory.eINSTANCE
						.createPropertyNode();
				propertyNode.setName(item.getClass().getName());
				propertyNode.setType(PropertyNodeType.PROPERTY);
				String stringValue = SWTModelMapper.unify(item == null ? ""
						: item.toString());
				propertyNode.setValue(stringValue);
				propertiesNodes.add(propertyNode);
			}
			idx++;
		}
	}

	private static void processStructuralFeature(EObject emfObject,
			EStructuralFeature eStructuralFeature,
			EList<PropertyNode> propertiesNodes) {
		Object value = emfObject.eGet(eStructuralFeature);
		if (!(value instanceof EObject)
				&& eStructuralFeature instanceof EAttribute) {
			PropertyNode propertyNode = UiFactory.eINSTANCE
					.createPropertyNode();
			propertyNode.setName(eStructuralFeature.getName());
			propertyNode.setType(PropertyNodeType.PROPERTY);
			String stringValue = SWTModelMapper.unify(value == null ? ""
					: value.toString());
			propertyNode.setValue(stringValue);
			propertiesNodes.add(propertyNode);
		} else if (!eStructuralFeature.isMany()
				|| (eStructuralFeature.isMany() && value instanceof List)) {
			PropertyNode propertyNode = UiFactory.eINSTANCE
					.createPropertyNode();
			propertyNode.setName(eStructuralFeature.getName());
			if (value != null) {
				propertyNode.setType(PropertyNodeType.REFERENCE);
			} else {
				propertyNode.setType(PropertyNodeType.PROPERTY);
				propertyNode.setValue(JavaMembersHelper.NULL_CONST);
			}
			propertiesNodes.add(propertyNode);
		}
	}

	private static Object findNodeValue(Object object, String nodePath) {
		// if have indexed property in old format, convert it to new format
		// for example:
		// old format: assigns[Assign:0].destination
		// new format: assigns.Assign[0].destination
		if (nodePath.matches(".*\\[(\\w+):(\\d+)\\].*")) {
			nodePath = nodePath.replaceAll("\\[(\\w+):(\\d+)\\]", ".$1[$2]");
		}
		String[] nodes = nodePath.split("\\.");
		Object current = object;
		for (String node : nodes) {
			current = getNodeValue(current, node);
			if (current == null) {
				return null;
			}
		}
		return current;
	}

	static Object getNodeValue(Object object, String node) {

		if (object instanceof List) {
			List<?> list = (List<?>) object;
			if (LIST_SIZE_PROPERTY_CAPTION.equals(node)) {
				return list.size();
			}
			if (node.matches(".*\\[.*\\]")) {
				String strIdx = node.substring(node.indexOf('[') + 1,
						node.indexOf(']'));
				strIdx = strIdx.replaceAll("\\D", "");
				int idx = Integer.parseInt(strIdx);
				return list.get(idx);
			}
		}
		if (object instanceof EObject) {
			EObject emfObject = (EObject) object;
			EClass eClass = emfObject.eClass();
			EStructuralFeature feature = eClass.getEStructuralFeature(node);
			if (feature != null) {
				Object value = emfObject.eGet(feature);

				if (value == null) {
					Class<?> class_ = feature.getEType().getInstanceClass();
					if (class_ == String.class)
						value = "";
				}

				return value;
			}
		}

		return null;
	}

}
