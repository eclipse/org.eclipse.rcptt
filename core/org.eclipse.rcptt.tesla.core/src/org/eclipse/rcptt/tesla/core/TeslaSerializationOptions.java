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
package org.eclipse.rcptt.tesla.core;

import org.eclipse.emf.ecore.xmi.impl.XMLInfoImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;

import org.eclipse.rcptt.tesla.core.ui.UiPackage;

public class TeslaSerializationOptions {
	public static void fillOptions(XMLMapImpl map) {
		map.add(UiPackage.eINSTANCE.getBrowser_Text(), asElement());
		map.add(UiPackage.eINSTANCE.getButton_Caption(), asElement());
		map.add(UiPackage.eINSTANCE.getText_RawValue(), asElement());
		map.add(UiPackage.eINSTANCE.getPropertyNode_Value(), asElement());
	}

	private static XMLInfoImpl asElement() {
		XMLInfoImpl x = new XMLInfoImpl();
		x.setXMLRepresentation(XMLInfoImpl.ELEMENT);
		return x;
	}
}
