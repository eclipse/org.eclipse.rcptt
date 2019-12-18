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
package org.eclipse.rcptt.verifications.status;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Status Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.status.VerificationStatusData#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.status.VerificationStatusData#getResourceId <em>Resource Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getVerificationStatusData()
 * @model
 * @generated
 */
public interface VerificationStatusData extends EObject {
	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getVerificationStatusData_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.status.VerificationStatusData#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Resource Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Id</em>' attribute.
	 * @see #setResourceId(String)
	 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getVerificationStatusData_ResourceId()
	 * @model
	 * @generated
	 */
	String getResourceId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.status.VerificationStatusData#getResourceId <em>Resource Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Id</em>' attribute.
	 * @see #getResourceId()
	 * @generated
	 */
	void setResourceId(String value);

} // VerificationStatusData
