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
package org.eclipse.rcptt.ecl.internal.debug.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.containers.AbstractSourceContainerTypeDelegate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class EclSourceContainerType extends AbstractSourceContainerTypeDelegate {

	public static final String ID = Plugin.ID + ".containerType";

	public ISourceContainer createSourceContainer(String memento)
			throws CoreException {
		Node node = parseDocument(memento);
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			if ("ecl".equals(element.getNodeName())) { //$NON-NLS-1$
				return new EclSourceContainer();
			}
			abort("Unable to restore ECL source lookup entry - expecting ecl element.",
					null);
		}
		abort("Unable to restore ECL source lookup entry - invalid memento.",
				null);
		return null;
	}

	public String getMemento(ISourceContainer container) throws CoreException {
		Document document = newDocument();
		Element element = document.createElement("ecl"); //$NON-NLS-1$
		document.appendChild(element);
		return serializeDocument(document);
	}
}