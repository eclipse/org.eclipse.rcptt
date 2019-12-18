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
package org.eclipse.rcptt.ui.launching;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.rcptt.internal.launching.Q7LaunchManager;
import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

/**
 * Migrates broken launch configurations Does not depend on storage location.
 * */
public class LaunchConfigurationMigration {
	private final Set<String> registeredTypes;
	private final Map<String, String> typeMap = new HashMap<String, String>();
	{
		Function<ILaunchConfigurationType, String> toIdentifier = new Function<ILaunchConfigurationType, String>() {
			@Override
			public String apply(ILaunchConfigurationType input) {
				return input.getIdentifier();
			}
		};
		ILaunchConfigurationType[] types = DebugPlugin.getDefault()
				.getLaunchManager().getLaunchConfigurationTypes();
		Iterable<String> ids = Iterables.transform(asList(types), toIdentifier);
		registeredTypes = ImmutableSet.copyOf(ids);

		registerMigration("com.xored.q7.launching.scenarios", Q7LaunchManager.Q7_TEST_SUITE_LAUNCH_ID, registeredTypes,
				typeMap);
		registerMigration("com.xored.q7.launching.ext", "org.eclipse.rcptt.launching.ext", registeredTypes, typeMap);
		registerMigration("com.xored.q7.launching.remote", "org.eclipse.rcptt.launching.remote", registeredTypes,
				typeMap);
		registerMigration("com.xored.q7.launching.multiaut", "org.eclipse.rcptt.launching.multiaut", registeredTypes,
				typeMap);
	}

	private static void registerMigration(String from, String to, Set<String> knownTypes, Map<String, String> typeMap) {
		if (!knownTypes.contains(to)) {
			Q7UIPlugin
					.getDefault()
					.getLog()
					.log(new Status(IStatus.WARNING, Q7UIPlugin.PLUGIN_ID, String.format(
							"Attempt to register launch configuration migration to unknown type %s", to)));
			return;
		}
		typeMap.put(from, to);
	}

	private static String replacePrefix(String prefix, String newPrefix,
			String target) {
		if (target == null)
			return null;
		if (target.startsWith(prefix)) {
			return newPrefix + target.substring(prefix.length());
		}
		return target;
	}

	private static final Function<String, String> replaceKeyPrefixes = new Function<String, String>() {
		@Override
		public String apply(String input) {
			return replacePrefix("com.xored.q7.launching",
					Q7LaunchingPlugin.PLUGIN_ID, input);
		}
	};

	public static Document parse(Reader reader) {
		try {
			DocumentBuilder parser = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			parser.setErrorHandler(new DefaultHandler());
			return parser.parse(new InputSource(reader));
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String getType(Document document) {
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		try {
			XPathExpression expr = xpath.compile("launchConfiguration/@type");
			return expr.evaluate(document);
		} catch (XPathExpressionException e) {
			throw new RuntimeException(e);
		}

	}

	public boolean isMigrationRequired(Document doc) {
		return typeMap.containsKey(getType(doc));
	}

	public static void write(Document document, Writer writer) {
		if (document == null)
			throw new NullPointerException();
		try {
			// Writes DOM to output.
			// TODO: find a more straightforward way to write out DOM
			Transformer identity = TransformerFactory.newInstance()
					.newTransformer();
			identity.transform(new DOMSource(document),
					new StreamResult(writer));
		} catch (TransformerException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean migrate(Document document) throws CoreException {
		String type = LaunchConfigurationMigration.getType(document);
		if (type == null)
			return false;
		if (registeredTypes.contains(type))
			return false;
		if (type.equals("com.xored.q7.launching.scenarios")) {
			migrateType(document, Q7LaunchManager.Q7_TEST_SUITE_LAUNCH_ID);
			return true;
		}
		if (type.equals("com.xored.q7.launching.ext")) {
			migrateType(document, "org.eclipse.rcptt.launching.ext");
			return true;
		}
		if (type.equals("com.xored.q7.launching.remote")) {
			migrateType(document, "org.eclipse.rcptt.launching.remote");
			return true;
		}

		return false;
	}

	public static void migrateKeys(Node root,
			Function<String, String> calcNewKey)
			throws XPathExpressionException {
		assert root != null;
		NodeList list = root.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (!node.getNodeName().endsWith("Attribute"))
				continue;
			Node keynode = node.getAttributes().getNamedItem("key");
			if (keynode == null)
				continue;
			String oldKey = keynode.getTextContent();
			if (oldKey == null)
				continue;
			String newKey = calcNewKey.apply(oldKey);
			if (!oldKey.equals(newKey))
				keynode.setTextContent(newKey);
		}
	}

	/** Migrates common part of Q7 launch configuration */
	public void migrateType(Document document, String newTypeId) {
		if (!registeredTypes.contains(newTypeId))
			throw new IllegalArgumentException(
					"New type id must reference existing launch type");
		try {
			XPath xpath = XPathFactory.newInstance().newXPath();
			XPathExpression expr = xpath.compile("launchConfiguration/@type");
			Node node = (Node) expr.evaluate(document, XPathConstants.NODE);
			node.setTextContent(newTypeId);
			migrateKeys(document.getDocumentElement(), replaceKeyPrefixes);
		} catch (XPathExpressionException e) {
			throw new RuntimeException(e);
		}
	}

}
