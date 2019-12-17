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
package org.eclipse.rcptt.ecl.data.internal.commands;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.ReadXmlFile;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.data.objects.Attribute;
import org.eclipse.rcptt.ecl.data.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.data.objects.Tree;
import org.eclipse.rcptt.ecl.filesystem.EclFile;
import org.eclipse.rcptt.ecl.filesystem.FileResolver;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class ReadXmlFileService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		ReadXmlFile rxf = (ReadXmlFile) command;
		String xPath = rxf.getXPath();
		String uri = rxf.getUri();
		EclFile file = FileResolver.resolve(uri);

		Document document = XmlFileService.readXml(file);

		if (xPath != null && !xPath.equals("")) {
			// find nodes by xPath
			NodeList nodes = null;
			try {
				XPathFactory xPathFactory = XPathFactory.newInstance();
				XPathExpression nodeXPath = xPathFactory.newXPath().compile(xPath);
				nodes = (NodeList) nodeXPath.evaluate(document, XPathConstants.NODESET);
			} catch (XPathExpressionException e) {
				return EclDataPlugin.createErr(
						e, "Invalid xPath expression %s", file.toURI());
			}
			for (int i = 0; i < nodes.getLength(); i++) {
				Node child = nodes.item(i);
				if (child instanceof Element) {
					Element childElement = (Element) child;
					Tree tree = readTree(childElement);
					context.getOutput().write(tree);
				}
				if (child instanceof Attr) {
					Attr childAttr = (Attr) child;
					Attribute attr = ObjectsFactory.eINSTANCE.createAttribute();
					attr.setName(childAttr.getNodeName());
					attr.setValue(childAttr.getNodeValue());
					context.getOutput().write(attr);
				}
				if (child instanceof Text) {
					String text = getText(child);
					context.getOutput().write(text);
				}
			}
		} else {
			// read all the tree
			Element root = document.getDocumentElement();
			Tree tree = readTree(root);
			context.getOutput().write(tree);
		}
		return Status.OK_STATUS;
	}

	private Tree readTree(Element element) {
		Tree treeItem = ObjectsFactory.eINSTANCE.createTree();
		treeItem.setName(element.getNodeName());
		NodeList childs = element.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			Node child = childs.item(i);
			if (!(child instanceof Element)) {
				continue;
			}
			Element childElement = (Element) child;
			Tree childItem = readTree(childElement);
			treeItem.getChildren().add(childItem);
		}
		NamedNodeMap attributes = element.getAttributes();
		for (int i = 0; i < attributes.getLength(); i++) {
			Attribute attr = ObjectsFactory.eINSTANCE.createAttribute();
			Node attribute = attributes.item(i);
			attr.setName(attribute.getNodeName());
			attr.setValue(attribute.getNodeValue());
			treeItem.getAttributes().add(attr);
		}
		// text can be specified only if an element has no child
		if (treeItem.getChildren().size() == 0) {
			treeItem.setText(getText(element));
		}
		return treeItem;
	}

	private String getText(Node node) {
		String text = node.getTextContent();
		text = text.replaceAll("\\n", "");
		text = text.replaceAll("\\t", "");
		text = text.replaceAll("^ +", "");
		text = text.replaceAll(" +$", "");
		text = text.replaceAll("  +", " ");
		return text;
	}

}