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
package org.eclipse.rcptt.tesla.core.info;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stack Trace Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.StackTraceEntry#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.StackTraceEntry#getStackTrace <em>Stack Trace</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.StackTraceEntry#getThreadName <em>Thread Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.StackTraceEntry#getThreadClass <em>Thread Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getStackTraceEntry()
 * @model
 * @generated
 */
public interface StackTraceEntry extends EObject {
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
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getStackTraceEntry_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.StackTraceEntry#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Stack Trace</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stack Trace</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stack Trace</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getStackTraceEntry_StackTrace()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getStackTrace();

	/**
	 * Returns the value of the '<em><b>Thread Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thread Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thread Name</em>' attribute.
	 * @see #setThreadName(String)
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getStackTraceEntry_ThreadName()
	 * @model
	 * @generated
	 */
	String getThreadName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.StackTraceEntry#getThreadName <em>Thread Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thread Name</em>' attribute.
	 * @see #getThreadName()
	 * @generated
	 */
	void setThreadName(String value);

	/**
	 * Returns the value of the '<em><b>Thread Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thread Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thread Class</em>' attribute.
	 * @see #setThreadClass(String)
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getStackTraceEntry_ThreadClass()
	 * @model
	 * @generated
	 */
	String getThreadClass();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.StackTraceEntry#getThreadClass <em>Thread Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thread Class</em>' attribute.
	 * @see #getThreadClass()
	 * @generated
	 */
	void setThreadClass(String value);

} // StackTraceEntry
