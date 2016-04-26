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
package org.eclipse.rcptt.core.workspace;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.NamedElement;

public class Q7Utils {
	/**
	 * @return string id or <code>null</code>
	 */
	public static String safeGetId(IQ7NamedElement element) {
		try {
			return element == null ? null : element.getID();
		} catch (ModelException e) {
			return null;
		}
	}

	public static IFile getLocation(String uri) {
		return getLocation(new ResourceImpl(URI.createPlatformResourceURI(uri,
				true)));
	}

	public static IFile getLocation(NamedElement executable) {
		if (executable == null) {
			return null;
		}
		return getLocation(executable.eResource());
	}

	public static IFile getLocation(Resource resource) {
		if (resource == null /* || resource.getResourceSet() == null */) {
			return null;
		}
		if (resource.getURI() == null) {
			return null;
		}
		return WorkspaceSynchronizer.getFile(resource);
	}

	public static String serializeToString(EObject eObject) throws IOException {
		Resource resource = new XMLResourceImpl();
		resource.getContents().add(EcoreUtil.copy(eObject));
		final Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMIResource.OPTION_ENCODING, "UTF-8");
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		resource.save(bytes, options);
		return bytes.toString();
	}

	public static EObject deserializeFromstring(String xml) throws IOException {
		Resource resource = new XMLResourceImpl();
		resource.load(new ByteArrayInputStream(xml.getBytes()), null);
		EList<EObject> contents = resource.getContents();
		if (contents.size() == 1) {
			return contents.get(0);
		}
		return null;
	}
}
