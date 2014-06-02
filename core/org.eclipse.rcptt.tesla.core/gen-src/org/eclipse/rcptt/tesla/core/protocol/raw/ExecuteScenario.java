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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execute Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteScenario#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteScenario#getExecuteMode <em>Execute Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getExecuteScenario()
 * @model
 * @generated
 */
public interface ExecuteScenario extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getExecuteScenario_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteScenario#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Execute Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execute Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execute Mode</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteMode
	 * @see #setExecuteMode(ExecuteMode)
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getExecuteScenario_ExecuteMode()
	 * @model
	 * @generated
	 */
	ExecuteMode getExecuteMode();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteScenario#getExecuteMode <em>Execute Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execute Mode</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteMode
	 * @see #getExecuteMode()
	 * @generated
	 */
	void setExecuteMode(ExecuteMode value);

} // ExecuteScenario
