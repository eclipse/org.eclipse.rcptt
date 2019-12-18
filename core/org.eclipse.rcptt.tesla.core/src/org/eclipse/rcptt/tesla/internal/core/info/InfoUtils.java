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
package org.eclipse.rcptt.tesla.internal.core.info;

import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.InfoFactory;
import org.eclipse.rcptt.tesla.core.info.InfoNode;
import org.eclipse.rcptt.tesla.core.info.NodeProperty;

public class InfoUtils {
	public static InfoNode node(String name) {
		InfoNode node = InfoFactory.eINSTANCE.createInfoNode();
		if (name.contains("]]>")) {
			name = name.replace("]]>", "{q7.replace.CDATA_END}");
		}
		node.setName(name);
		return node;
	}

	public static NodeProperty property(String name, String value) {
		NodeProperty property = InfoFactory.eINSTANCE.createNodeProperty();
		if (name.contains("]]>")) {
			name = name.replace("]]>", "{q7.replace.CDATA_END}");
		}
		property.setName(name);
		if (value != null && value.contains("]]>")) {
			value = value.replace("]]>", "{q7.replace.CDATA_END}");
		}
		property.setValue(value);
		return property;
	}

	public static void property(InfoNode node, String name, String value) {
		node.getProperties().add(property(name, value));
	}

	public static Node newNode(String name) {
		return new Node(node(name));
	}

	public static class Node {
		private InfoNode node;

		Node(InfoNode node) {
			this.node = node;
		}

		public Node property(String name, String value) {
			InfoUtils.property(node, name, value);
			return this;
		}

		public Node property(String name, Object value) {
			InfoUtils.property(node, name, value.toString());
			return this;
		}

		public Node add(AdvancedInformation info) {
			info.getNodes().add(node);
			return this;
		}

		public Node child(String name) {
			InfoNode childNode = node(name);
			node.getChildren().add(childNode);
			return new Node(childNode);
		}

		@Override
		public String toString() {
			return node.toString();
		}
	}
}
