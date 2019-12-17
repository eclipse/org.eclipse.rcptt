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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.commands.WriteXmlFile;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.data.objects.Attribute;
import org.eclipse.rcptt.ecl.data.objects.Tree;
import org.eclipse.rcptt.ecl.filesystem.EclFile;
import org.eclipse.rcptt.ecl.filesystem.FileResolver;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXmlFileService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		WriteXmlFile wxf = (WriteXmlFile) command;
		Tree tree = wxf.getTree();
		String uri = wxf.getUri();
		EclFile file = FileResolver.resolve(uri);

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			return EclDataPlugin.createErr(
					e, "Error writing file %s", file.toURI());
		}

		Document document = docBuilder.newDocument();
		Element root = readElement(document, tree);
		document.appendChild(root);

		XmlFileService.writeXml(file, document);
		context.getOutput().write(tree);
		return Status.OK_STATUS;
	}

	private Element readElement(Document document, Tree item) {
		Element element = document.createElement(item.getName());
		for (Attribute attribute : item.getAttributes()) {
			Attr attr = document.createAttribute(attribute.getName());
			attr.setValue(attribute.getValue());
			element.setAttributeNode(attr);
		}
		for (Tree child : item.getChildren()) {
			element.appendChild(readElement(document, child));
		}
		// text can be specified only if an element has no child
		if (item.getChildren().size() == 0) {
			element.setTextContent(item.getText());
		}
		return element;
	}

}
