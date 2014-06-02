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
package org.eclipse.rcptt.tesla.core.protocol.raw;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Mode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.SetMode#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.SetMode#getWidgetClasses <em>Widget Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getSetMode()
 * @model
 * @generated
 */
public interface SetMode extends EObject {
	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode
	 * @see #setMode(TeslaMode)
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getSetMode_Mode()
	 * @model
	 * @generated
	 */
	TeslaMode getMode();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.SetMode#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(TeslaMode value);

	/**
	 * Returns the value of the '<em><b>Widget Classes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget Classes</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget Classes</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getSetMode_WidgetClasses()
	 * @model
	 * @generated
	 */
	EList<String> getWidgetClasses();

} // SetMode
