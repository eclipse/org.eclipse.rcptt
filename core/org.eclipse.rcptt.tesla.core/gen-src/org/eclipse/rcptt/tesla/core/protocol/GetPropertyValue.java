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
package org.eclipse.rcptt.tesla.core.protocol;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Property Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue#getAllowRawValues <em>Allow Raw Values</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getGetPropertyValue()
 * @model
 * @generated
 */
public interface GetPropertyValue extends ElementCommand {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getGetPropertyValue_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getGetPropertyValue_Index()
	 * @model
	 * @generated
	 */
	Integer getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(Integer value);

	/**
	 * Returns the value of the '<em><b>Allow Raw Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Raw Values</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Raw Values</em>' attribute.
	 * @see #setAllowRawValues(Boolean)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getGetPropertyValue_AllowRawValues()
	 * @model
	 * @generated
	 */
	Boolean getAllowRawValues();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue#getAllowRawValues <em>Allow Raw Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Raw Values</em>' attribute.
	 * @see #getAllowRawValues()
	 * @generated
	 */
	void setAllowRawValues(Boolean value);

} // GetPropertyValue
