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
package org.eclipse.rcptt.core.model;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

public interface ITestCase extends IQ7NamedElement {
	String[] getContexts() throws ModelException;

	String[] getVerifications() throws ModelException;

	EObject getContent() throws ModelException;

	EObject getTesla() throws ModelException;

	String getExternalReference() throws ModelException;

	Map<String,String> getProperties() throws ModelException;

	String getType() throws ModelException;

	// Modifications, valid only for working copies
	void setContexts(String[] contexts) throws ModelException;

	// Modifications, valid only for working copies
	void setVerifications(String[] verifications) throws ModelException;

	void setContent(EObject content) throws ModelException;

	void setTesla(EObject tesla) throws ModelException;

	void setExternalReference(String ref) throws ModelException;

	void setType(String type) throws ModelException;
}
