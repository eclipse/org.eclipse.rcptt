/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.internal.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

public class ModelUtils {
	@SuppressWarnings("rawtypes")
	public static int countElements(Object eGet, EObject element) {
		int count = 0;
		if (eGet instanceof EObject
				&& EcoreUtil.equals((EObject) eGet, element)) {
			count++;
		} else if (eGet instanceof EObject) {
			count += countElements((EObject) eGet, element);
		} else if (eGet instanceof List) {
			List l = (List) eGet;
			for (Object object : l) {
				count += countElements(object, element);
			}
		} else if (eGet instanceof Map) {
			Map l = (Map) eGet;
			for (Object object : l.values()) {
				count += countElements(object, element);
			}
		} else if (eGet instanceof Set) {
			Set l = (Set) eGet;
			for (Object object : l) {
				count += countElements(object, element);
			}
		}
		return count;
	}

	@SuppressWarnings("rawtypes")
	public static void extractElements(Object eGet, Set<Element> elements) {
		if (eGet instanceof Element) {
			elements.add((Element) eGet);
		} else if (eGet instanceof EObject) {
			extractElements((EObject) eGet, elements);
		} else if (eGet instanceof List) {
			List l = (List) eGet;
			for (Object object : l) {
				extractElements(object, elements);
			}
		} else if (eGet instanceof Map) {
			Map l = (Map) eGet;
			for (Object object : l.values()) {
				extractElements(object, elements);
			}
		} else if (eGet instanceof Set) {
			Set l = (Set) eGet;
			for (Object object : l) {
				extractElements(object, elements);
			}
		}
	}

	public static int countElements(EObject obj, EObject element) {
		int count = 0;
		EClass eClass = obj.eClass();
		EList<EStructuralFeature> features = eClass.getEAllStructuralFeatures();
		for (EStructuralFeature eStructuralFeature : features) {
			Object eGet = obj.eGet(eStructuralFeature);
			if (eGet != null) {
				count += ModelUtils.countElements(eGet, element);
			}
		}
		return count;
	}

	public static Set<Element> extractElements(EObject response) {
		Set<Element> elements = new HashSet<Element>();
		extractElements(response, elements);
		return elements;
	}

	public static void extractElements(EObject response, Set<Element> elements) {
		EClass eClass = response.eClass();
		EList<EStructuralFeature> features = eClass.getEAllStructuralFeatures();
		for (EStructuralFeature eStructuralFeature : features) {
			Object eGet = response.eGet(eStructuralFeature);
			if (eGet != null) {
				extractElements(eGet, elements);
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void updateElementsAccordingTo(Object eGet,
			Map<String, Element> map, Set<EObject> updated) {
		try {
			if (eGet instanceof EObject) {
				updateElementsAccordingTo((EObject) eGet, map, updated);
			} else if (eGet instanceof List) {
				List<Object> l = (List<Object>) eGet;
				List<Object> newL = new ArrayList<Object>();
				List<Object> lcopy = new ArrayList<Object>(l);
				for (Object object : lcopy) {
					if (object instanceof Element) {
						newL.add(getRealElement(map, object));
					} else {
						newL.add(object);
						updateElementsAccordingTo(object, map, updated);
					}
				}
				try {
					l.clear();
					l.addAll(newL);
				} catch (UnsupportedOperationException e) {
					// List is unmodifiable. Skipping
				}
			} else if (eGet instanceof Map) {
				Map<Object, Object> l = (Map<Object, Object>) eGet;
				Map<Object, Object> newL = new HashMap<Object, Object>();
				for (Map.Entry<Object, Object> entry : l.entrySet()) {
					// Does not check for keys
					Object key = entry.getKey();
					Object value = entry.getValue();
					if (value instanceof Element) {
						value = getRealElement(map, value);
					} else {
						updateElementsAccordingTo(value, map, updated);
					}
					newL.put(key, value);
				}
				l.clear();
				l.putAll(newL);
			} else if (eGet instanceof Set) {
				Set l = (Set) eGet;
				Set result = new HashSet();
				for (Object object : l) {
					Object o = object;
					if (o instanceof Element) {
						o = getRealElement(map, o);
					} else {
						updateElementsAccordingTo(o, map, updated);
					}
					result.add(o);
				}
				l.clear();
				l.addAll(result);
			}
		} catch (Exception e) {
			TeslaCore.log(e);
		}
	}

	public static void updateElementsAccordingTo(EObject workCmd,
			Map<String, Element> map, Set<EObject> updated) {
		if (updated.contains(workCmd)) {
			return;
		}
		updated.add(workCmd);
		EClass eClass = workCmd.eClass();
		EList<EStructuralFeature> features = eClass.getEAllStructuralFeatures();
		for (EStructuralFeature eStructuralFeature : features) {
			Object eGet = workCmd.eGet(eStructuralFeature);
			if (eGet instanceof Element) {
				// Update standalone element here.
				workCmd.eSet(eStructuralFeature, getRealElement(map, eGet));
			} else if (eGet != null) {
				updateElementsAccordingTo(eGet, map, updated);
			}
		}
	}

	private static Element getRealElement(Map<String, Element> map, Object eGet) {
		String key = makeKey((Element) eGet);
		Element e = map.get(key);
		if (e != null) {
			return (Element) EcoreUtil.copy(e);
		}
		throw new RuntimeException("Failed to map elements.");
	}

	public static String makeKey(Element element) {
		return element.getKind() + ":" + element.getId();
	}
}
