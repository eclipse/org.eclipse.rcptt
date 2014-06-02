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
package org.eclipse.rcptt.tesla.recording.core.swt;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeList;
import org.eclipse.rcptt.tesla.core.ui.UiFactory;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.swt.reflection.JavaMembersHelper;

public abstract class BasicRecordingHelper<T> implements IRecordingHelper<T> {
	public static class ElementEntry {
		private final Element element;
		private Map<String, Object> attributes = null;

		public ElementEntry(Element element) {
			this.element = element;
		}

		public void set(String attr, Object value) {
			init();
			attributes.put(attr, value);
		}

		public String get(String attr) {
			if (attributes == null) {
				return null;
			}
			return (String) attributes.get(attr);
		}

		public Object getObj(String attr) {
			if (attributes == null) {
				return null;
			}
			return attributes.get(attr);
		}

		private void init() {
			if (attributes == null) {
				attributes = new HashMap<String, Object>();
			}
		}

		public Element getElement() {
			return element;
		}

		public boolean isSet(String attr) {
			return get(attr) != null;
		}

		public boolean matchAttributes(ElementEntry el) {
			if (attributes != null && el.attributes != null
					&& attributes.size() == el.attributes.size()) {
				Set<String> keySet = attributes.keySet();
				for (String key : keySet) {
					Object v1 = attributes.get(key);
					Object v2 = el.attributes.get(key);
					if (v1 != null && !v1.equals(v2)) {
						return false;
					}

				}
			} else {
				return false;
			}
			return true;
		}
	}

	protected Map<T, ElementEntry> elements = new HashMap<T, ElementEntry>();

	public BasicRecordingHelper() {
		super();
	}

	public ElementEntry get(T result) {
		return elements.get(result);
	}

	public void put(T element, ElementEntry value) {
		elements.put(element, value);
	}

	public void clear() {
		elements.clear();
	}

	public void remove(T obj) {
		this.elements.remove(obj);
	}

	public T findByElement(Element element) {
		for (Entry<T, ElementEntry> entry : elements.entrySet()) {
			Element entryElement = entry.getValue().getElement();
			if (entryElement.getId().equals(element.getId())
					&& entryElement.getKind().equals(element.getKind())) {
				return entry.getKey();
			}
		}
		return null;
	}

	public PropertyNodeList getNodeProperties(Element element, String nodePath)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		T original = findByElement(element);
		if (original != null) {
			PropertyNodeList propertyNodeList = UiFactory.eINSTANCE
					.createPropertyNodeList();
			if (JavaMembersHelper.fillProperties(original, nodePath,
					propertyNodeList.getPropertyNodes())) {
				return propertyNodeList;
			}
		}
		return null;
	}

	public String getWidgetDetails(Element element) {
		return null;
	}
}