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

import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Response</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.Response#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.Response#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.Response#getAdvancedInformation <em>Advanced Information</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getResponse()
 * @model
 * @generated
 */
public interface Response extends EObject {
	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The default value is <code>"Ok"</code>.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus
	 * @see #setStatus(ResponseStatus)
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getResponse_Status()
	 * @model default="Ok"
	 * @generated
	 */
	ResponseStatus getStatus();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Response#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(ResponseStatus value);

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
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getResponse_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Response#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advanced Information</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advanced Information</em>' containment reference.
	 * @see #setAdvancedInformation(AdvancedInformation)
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getResponse_AdvancedInformation()
	 * @model containment="true"
	 * @generated
	 */
	AdvancedInformation getAdvancedInformation();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Response#getAdvancedInformation <em>Advanced Information</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Advanced Information</em>' containment reference.
	 * @see #getAdvancedInformation()
	 * @generated
	 */
	void setAdvancedInformation(AdvancedInformation value);

} // Response
