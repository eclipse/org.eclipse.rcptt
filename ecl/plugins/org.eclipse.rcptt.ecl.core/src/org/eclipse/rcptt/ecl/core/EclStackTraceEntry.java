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
 * A representation of the model object '<em><b>Ecl Stack Trace Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getDeclaringClass <em>Declaring Class</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#isNativeMethod <em>Native Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.core.CorePackage#getEclStackTraceEntry()
 * @model
 * @generated
 */
public interface EclStackTraceEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getEclStackTraceEntry_Index()
	 * @model
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Declaring Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaring Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaring Class</em>' attribute.
	 * @see #setDeclaringClass(String)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getEclStackTraceEntry_DeclaringClass()
	 * @model
	 * @generated
	 */
	String getDeclaringClass();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getDeclaringClass <em>Declaring Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaring Class</em>' attribute.
	 * @see #getDeclaringClass()
	 * @generated
	 */
	void setDeclaringClass(String value);

	/**
	 * Returns the value of the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Name</em>' attribute.
	 * @see #setMethodName(String)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getEclStackTraceEntry_MethodName()
	 * @model
	 * @generated
	 */
	String getMethodName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getMethodName <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Name</em>' attribute.
	 * @see #getMethodName()
	 * @generated
	 */
	void setMethodName(String value);

	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see #setFileName(String)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getEclStackTraceEntry_FileName()
	 * @model
	 * @generated
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getFileName <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);

	/**
	 * Returns the value of the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Number</em>' attribute.
	 * @see #setLineNumber(int)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getEclStackTraceEntry_LineNumber()
	 * @model
	 * @generated
	 */
	int getLineNumber();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getLineNumber <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Number</em>' attribute.
	 * @see #getLineNumber()
	 * @generated
	 */
	void setLineNumber(int value);

	/**
	 * Returns the value of the '<em><b>Native Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native Method</em>' attribute.
	 * @see #setNativeMethod(boolean)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getEclStackTraceEntry_NativeMethod()
	 * @model
	 * @generated
	 */
	boolean isNativeMethod();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#isNativeMethod <em>Native Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Native Method</em>' attribute.
	 * @see #isNativeMethod()
	 * @generated
	 */
	void setNativeMethod(boolean value);

} // EclStackTraceEntry
