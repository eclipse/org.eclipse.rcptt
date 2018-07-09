/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.data.internal.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.data.internal.EclDataPlugin;
import org.eclipse.rcptt.ecl.filesystem.EclFile;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlFileService {

	public static Document readXml(EclFile file) throws CoreException {
		try (FileInputStream stream = new FileInputStream(file.toFile())) {
			InputSource source = new InputSource(stream);
			Document document = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder()
					.parse(source);
			return document;
		} catch (FileNotFoundException e) {
			throw new CoreException(EclDataPlugin.createErr(
					e, "File not found %s", file.toURI()));
		} catch (SAXException | ParserConfigurationException | IOException e) {
			throw new CoreException(EclDataPlugin.createErr(
					e, "Error reading file %s", file.toURI()));
		}
	}
	
	public static void writeXml(EclFile file, Document document) throws CoreException {
		try (FileOutputStream stream = new FileOutputStream(file.toFile())) {
			StreamResult result = new StreamResult(stream);
			document.setXmlStandalone(true);
			DOMSource source = new DOMSource(document);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source, result);
		} catch (TransformerException | IOException e) {
			throw new CoreException(EclDataPlugin.createErr(
					e, "Error writing file %s", file.toURI()));
		}
	}

}
