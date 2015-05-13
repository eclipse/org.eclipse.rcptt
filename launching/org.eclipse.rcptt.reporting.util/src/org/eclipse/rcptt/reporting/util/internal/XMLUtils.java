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
package org.eclipse.rcptt.reporting.util.internal;

import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.util.StringUtils;
import org.w3c.dom.Document;

public class XMLUtils {

	public static Document createDocument() throws CoreException {
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.newDocument();
		} catch (ParserConfigurationException e1) {
			throw new CoreException(Plugin.UTILS.createError(e1));
		}
	}

	public static XMLStreamWriter createWriter(OutputStream stream)
			throws CoreException {
		try {
			return XMLOutputFactory.newInstance().createXMLStreamWriter(stream,
					"UTF-8");
		} catch (XMLStreamException e1) {
			throw new CoreException(Plugin.UTILS.createError(e1));
		}
	}

	public static void closeWriter(XMLStreamWriter writer) {
		try {
			writer.close();
		} catch (RuntimeException ex) {
			Plugin.UTILS.log("Can't close XMLStreamWriter", ex);
		} catch (XMLStreamException ex) {
			Plugin.UTILS.log("Can't close XMLStreamWriter", ex);
		}
	}
	public static String toString(Document doc) throws CoreException {
		Transformer transformer;
		StreamResult result = null;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer
					.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");

			// initialize StreamResult with File object to save to file
			result = new StreamResult(new StringWriter());
			DOMSource source = new DOMSource(doc);
			transformer.transform(source, result);

		} catch (Exception ex) {
			throw new CoreException(Plugin.UTILS.createError(ex));
		}
		return result.getWriter().toString();
	}

	public static byte[] toUtf8Bytes(String data) {
		return StringUtils.getUtf8Bytes(data);
	}

}
