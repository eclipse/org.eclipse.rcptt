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
package org.eclipse.rcptt.ecl.interop;


import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invoke</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.Invoke#getObject <em>Object</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.Invoke#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.Invoke#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.Invoke#isNoResult <em>No Result</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getInvoke()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Invokes method on Java object.' returns='Value returned by method.' example='get-eclipse-window | get-object | invoke setSize 700 700'"
 * @generated
 */
public interface Invoke extends Command {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' attribute.
	 * @see #setObject(Object)
	 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getInvoke_Object()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Object to call the method on.'"
	 * @generated
	 */
	Object getObject();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.interop.Invoke#getObject <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' attribute.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(Object value);

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
	 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getInvoke_Name()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Name of the method to call. As a useful addtion, there are three pseudo-methods for arrays: <code>get <i>index</i></code>, <code>set <i>index value</i></code> and <code>length</code>.'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.interop.Invoke#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Args</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Args</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Args</em>' attribute list.
	 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getInvoke_Args()
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Variable number of arguments to the method.'"
	 * @generated
	 */
	EList<Object> getArgs();

	/**
	 * Returns the value of the '<em><b>No Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Result</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Result</em>' attribute.
	 * @see #setNoResult(boolean)
	 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getInvoke_NoResult()
	 * @model
	 * @generated
	 */
	boolean isNoResult();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.interop.Invoke#isNoResult <em>No Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Result</em>' attribute.
	 * @see #isNoResult()
	 * @generated
	 */
	void setNoResult(boolean value);

} // Invoke
