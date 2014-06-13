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
package org.eclipse.rcptt.ecl.interop;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.ecl.interop.InteropPackage
 * @generated
 */
public interface InteropFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InteropFactory eINSTANCE = org.eclipse.rcptt.ecl.interop.impl.InteropFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invoke</em>'.
	 * @generated
	 */
	Invoke createInvoke();

	/**
	 * Returns a new object of class '<em>Exec Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exec Process</em>'.
	 * @generated
	 */
	ExecProcess createExecProcess();

	/**
	 * Returns a new object of class '<em>Exec Process Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exec Process Result</em>'.
	 * @generated
	 */
	ExecProcessResult createExecProcessResult();

	/**
	 * Returns a new object of class '<em>Get Memory Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Memory Usage</em>'.
	 * @generated
	 */
	GetMemoryUsage createGetMemoryUsage();

	/**
	 * Returns a new object of class '<em>Get Java Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Java Property</em>'.
	 * @generated
	 */
	GetJavaProperty createGetJavaProperty();

	/**
	 * Returns a new object of class '<em>Invoke Static</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invoke Static</em>'.
	 * @generated
	 */
	InvokeStatic createInvokeStatic();

	/**
	 * Returns a new object of class '<em>Invoke Ui</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invoke Ui</em>'.
	 * @generated
	 */
	InvokeUi createInvokeUi();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InteropPackage getInteropPackage();

} //InteropFactory
