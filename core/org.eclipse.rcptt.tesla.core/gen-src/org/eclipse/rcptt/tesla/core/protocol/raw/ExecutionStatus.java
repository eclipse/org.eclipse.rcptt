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
 * A representation of the model object '<em><b>Execution Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus#getProgress <em>Progress</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus#getStatusKind <em>Status Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getExecutionStatus()
 * @model
 * @generated
 */
public interface ExecutionStatus extends EObject {
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
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getExecutionStatus_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Progress</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Progress</em>' attribute.
	 * @see #setProgress(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getExecutionStatus_Progress()
	 * @model
	 * @generated
	 */
	int getProgress();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus#getProgress <em>Progress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Progress</em>' attribute.
	 * @see #getProgress()
	 * @generated
	 */
	void setProgress(int value);

	/**
	 * Returns the value of the '<em><b>Status Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatusKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status Kind</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatusKind
	 * @see #setStatusKind(ExecutionStatusKind)
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getExecutionStatus_StatusKind()
	 * @model
	 * @generated
	 */
	ExecutionStatusKind getStatusKind();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus#getStatusKind <em>Status Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status Kind</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatusKind
	 * @see #getStatusKind()
	 * @generated
	 */
	void setStatusKind(ExecutionStatusKind value);

} // ExecutionStatus
