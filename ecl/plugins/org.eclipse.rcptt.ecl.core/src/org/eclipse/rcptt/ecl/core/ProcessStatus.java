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
package org.eclipse.rcptt.ecl.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.ProcessStatus#getPluginId <em>Plugin Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.ProcessStatus#getCode <em>Code</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.ProcessStatus#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.ProcessStatus#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.ProcessStatus#getException <em>Exception</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.core.CorePackage#getProcessStatus()
 * @model
 * @generated
 */
public interface ProcessStatus extends EObject {
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
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getProcessStatus_PluginId()
	 * @model
	 * @generated
	 */
	String getPluginId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.ProcessStatus#getPluginId <em>Plugin Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin Id</em>' attribute.
	 * @see #getPluginId()
	 * @generated
	 */
	void setPluginId(String value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(int)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getProcessStatus_Code()
	 * @model
	 * @generated
	 */
	int getCode();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.ProcessStatus#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(int value);

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
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getProcessStatus_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.ProcessStatus#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

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
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getProcessStatus_Severity()
	 * @model
	 * @generated
	 */
	int getSeverity();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.ProcessStatus#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(int value);

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' containment reference.
	 * @see #setException(EclException)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getProcessStatus_Exception()
	 * @model containment="true"
	 * @generated
	 */
	EclException getException();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.ProcessStatus#getException <em>Exception</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' containment reference.
	 * @see #getException()
	 * @generated
	 */
	void setException(EclException value);

} // ProcessStatus
