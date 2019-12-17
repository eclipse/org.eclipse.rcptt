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
package org.eclipse.rcptt.tesla.internal.core.network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
import org.eclipse.rcptt.ecl.core.util.ECLBinaryResourceImpl;

import org.eclipse.rcptt.tesla.core.TeslaSerializationOptions;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer;

public class DataSerializer {
	public static void writeTransfer(DataOutputStream stream,
			CommandTransfer transfer) throws IOException {
		Resource resource = new ECLBinaryResourceImpl();
		resource.getContents().add(transfer);
		final Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMIResource.OPTION_ENCODING, "UTF-8");

		XMLMapImpl map = new XMLMapImpl();

		TeslaSerializationOptions.fillOptions(map);
		options.put(XMLResource.OPTION_XML_MAP, map);

		options.put(XMLResource.OPTION_ENCODING, "utf-8");
		options.put(XMLResource.OPTION_ESCAPE_USING_CDATA, Boolean.TRUE);
		options.put(XMLResource.OPTION_SKIP_ESCAPE, Boolean.FALSE);

		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		resource.save(bytes, options);
		stream.writeInt(bytes.size());
		bytes.writeTo(stream);
		stream.flush();
	}

	public static void writeEObject(DataOutputStream stream, EObject transfer)
			throws IOException {
		Resource resource = new ECLBinaryResourceImpl();
		resource.getContents().add(transfer);
		final Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMIResource.OPTION_ENCODING, "UTF-8");
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		resource.save(bytes, options);
		stream.writeInt(bytes.size());
		bytes.writeTo(stream);
		stream.flush();
	}

	public static CommandTransfer readTransfer(DataInputStream stream)
			throws IOException {
		int read = stream.readInt();
		byte[] bytes = readBytes(stream, read);
		if (bytes.length != read) {
			throw new RuntimeException("Failed to retrive tesla command");
		}
		Resource resource = new ECLBinaryResourceImpl();
		resource.load(new ByteArrayInputStream(bytes), null);
		EList<EObject> contents = resource.getContents();
		for (EObject eObject : contents) {
			if (eObject instanceof CommandTransfer) {
				return (CommandTransfer) eObject;
			}
		}

		return null;
	}

	public static EObject readEObject(DataInputStream stream)
			throws IOException {
		int read = stream.readInt();
		byte[] bytes = readBytes(stream, read);
		if (bytes.length != read) {
			throw new RuntimeException("Failed to retrive tesla command");
		}
		Resource resource = new ECLBinaryResourceImpl();
		resource.load(new ByteArrayInputStream(bytes), null);
		EList<EObject> contents = resource.getContents();
		if (contents.size() == 1) {
			return contents.get(0);
		}

		return null;
	}

	private static byte[] readBytes(DataInputStream stream, int read)
			throws IOException {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		byte[] part = new byte[1024];
		while (read > 0) {
			int k = read;
			if (k > 1023) {
				k = 1023;
			}
			int len = stream.read(part, 0, k);
			bout.write(part, 0, len);
			read -= len;
		}
		return bout.toByteArray();
	}
}
