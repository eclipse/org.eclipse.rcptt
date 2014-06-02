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
package org.eclipse.rcptt.core.ecl.core.model;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Verification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.CreateVerification#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.CreateVerification#getParam <em>Param</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getCreateVerification()
 * @model
 * @generated
 */
public interface CreateVerification extends Command {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getCreateVerification_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.ecl.core.model.CreateVerification#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Param</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param</em>' reference.
	 * @see #setParam(EObject)
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getCreateVerification_Param()
	 * @model
	 * @generated
	 */
	EObject getParam();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.ecl.core.model.CreateVerification#getParam <em>Param</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param</em>' reference.
	 * @see #getParam()
	 * @generated
	 */
	void setParam(EObject value);

} // CreateVerification
