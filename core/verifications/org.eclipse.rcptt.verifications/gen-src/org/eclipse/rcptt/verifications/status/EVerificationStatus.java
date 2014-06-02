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
package org.eclipse.rcptt.verifications.status;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EVerification Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.status.EVerificationStatus#getResource <em>Resource</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.status.EVerificationStatus#getData <em>Data</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.status.EVerificationStatus#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.status.EVerificationStatus#getPluginId <em>Plugin Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.status.EVerificationStatus#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getEVerificationStatus()
 * @model
 * @generated
 */
public interface EVerificationStatus extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' attribute.
	 * @see #setResource(String)
	 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getEVerificationStatus_Resource()
	 * @model
	 * @generated
	 */
	String getResource();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.status.EVerificationStatus#getResource <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' attribute.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(String value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.verifications.status.VerificationStatusData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' containment reference list.
	 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getEVerificationStatus_Data()
	 * @model containment="true"
	 * @generated
	 */
	EList<VerificationStatusData> getData();

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
	 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getEVerificationStatus_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.status.EVerificationStatus#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Plugin Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin Id</em>' attribute.
	 * @see #setPluginId(String)
	 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getEVerificationStatus_PluginId()
	 * @model
	 * @generated
	 */
	String getPluginId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.status.EVerificationStatus#getPluginId <em>Plugin Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin Id</em>' attribute.
	 * @see #getPluginId()
	 * @generated
	 */
	void setPluginId(String value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see #setSeverity(int)
	 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getEVerificationStatus_Severity()
	 * @model
	 * @generated
	 */
	int getSeverity();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.status.EVerificationStatus#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(int value);

} // EVerificationStatus
