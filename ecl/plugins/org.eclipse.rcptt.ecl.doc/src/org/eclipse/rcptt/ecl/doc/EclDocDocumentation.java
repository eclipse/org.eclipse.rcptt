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
package org.eclipse.rcptt.ecl.doc;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;

final class EclDocDocumentation {

	private EMap<String, String> details = null;

	public EclDocDocumentation(EModelElement element) {
		EAnnotation ann = element.getEAnnotation(EclDocConstants.DOCS_ANN);
		if (ann == null)
			return;
		this.details = ann.getDetails();
	}

	public String get(String key) {
		if (details == null || !details.containsKey(key))
			return null;
		return details.get(key);
	}
}
