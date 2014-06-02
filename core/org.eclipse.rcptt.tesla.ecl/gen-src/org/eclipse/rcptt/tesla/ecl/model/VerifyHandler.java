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
package org.eclipse.rcptt.tesla.ecl.model;

import org.eclipse.rcptt.tesla.core.protocol.AssertKind;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verify Handler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getVerifyHandler()
 * @model
 * @generated
 */
public interface VerifyHandler extends EObject {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(Element)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getVerifyHandler_Element()
	 * @model
	 * @generated
	 */
	Element getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(Element value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' attribute.
	 * @see #setAttribute(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getVerifyHandler_Attribute()
	 * @model
	 * @generated
	 */
	String getAttribute();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getAttribute <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' attribute.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getVerifyHandler_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.tesla.core.protocol.AssertKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertKind
	 * @see #setKind(AssertKind)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getVerifyHandler_Kind()
	 * @model
	 * @generated
	 */
	AssertKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(AssertKind value);

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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getVerifyHandler_Index()
	 * @model
	 * @generated
	 */
	Integer getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyHandler#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(Integer value);

} // VerifyHandler
