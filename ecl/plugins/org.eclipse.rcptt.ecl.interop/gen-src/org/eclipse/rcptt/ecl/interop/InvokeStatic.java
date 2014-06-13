/*******************************************************************************
 * Copyright (c) 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.interop;

import org.eclipse.rcptt.ecl.core.Command;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invoke Static</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.InvokeStatic#getPluginId <em>Plugin Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.InvokeStatic#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.InvokeStatic#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.InvokeStatic#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getInvokeStatic()
 * @model
 * @generated
 */
public interface InvokeStatic extends Command {
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
	 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getInvokeStatic_PluginId()
	 * @model
	 * @generated
	 */
	String getPluginId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.interop.InvokeStatic#getPluginId <em>Plugin Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin Id</em>' attribute.
	 * @see #getPluginId()
	 * @generated
	 */
	void setPluginId(String value);

	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getInvokeStatic_ClassName()
	 * @model
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.interop.InvokeStatic#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

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
	 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getInvokeStatic_MethodName()
	 * @model
	 * @generated
	 */
	String getMethodName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.interop.InvokeStatic#getMethodName <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Name</em>' attribute.
	 * @see #getMethodName()
	 * @generated
	 */
	void setMethodName(String value);

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
	 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getInvokeStatic_Args()
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Variable number of arguments to the method.'"
	 * @generated
	 */
	EList<Object> getArgs();

} // InvokeStatic
