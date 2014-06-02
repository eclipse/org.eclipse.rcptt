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
package org.eclipse.rcptt.core.persistence.plain;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface IPlainTextPersistenceExtension {

	boolean isContentEntryOptional(EList<EObject> contents);

	void updateAttributes(PlainTextPersistenceModel plainTextPersistenceModel,
			Map<String, String> masterAttributes, EObject eObject);

	void updateMetadata(PlainTextPersistenceModel plainTextPersistenceModel,
			Map<String, String> header, EObject eObject);

	void performObjectPreSaveUpdate(EObject eObject);

	String getTextContentType(String fName);
}
