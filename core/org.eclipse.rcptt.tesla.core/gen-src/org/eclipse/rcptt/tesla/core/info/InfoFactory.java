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
package org.eclipse.rcptt.tesla.core.info;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage
 * @generated
 */
public interface InfoFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InfoFactory eINSTANCE = org.eclipse.rcptt.tesla.core.info.impl.InfoFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Advanced Information</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Advanced Information</em>'.
	 * @generated
	 */
	AdvancedInformation createAdvancedInformation();

	/**
	 * Returns a new object of class '<em>Stack Trace Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stack Trace Entry</em>'.
	 * @generated
	 */
	StackTraceEntry createStackTraceEntry();

	/**
	 * Returns a new object of class '<em>Job Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Job Entry</em>'.
	 * @generated
	 */
	JobEntry createJobEntry();

	/**
	 * Returns a new object of class '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node</em>'.
	 * @generated
	 */
	InfoNode createInfoNode();

	/**
	 * Returns a new object of class '<em>Node Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Property</em>'.
	 * @generated
	 */
	NodeProperty createNodeProperty();

	/**
	 * Returns a new object of class '<em>Q7 Wait Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Q7 Wait Info</em>'.
	 * @generated
	 */
	Q7WaitInfo createQ7WaitInfo();

	/**
	 * Returns a new object of class '<em>Q7 Wait Info Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Q7 Wait Info Root</em>'.
	 * @generated
	 */
	Q7WaitInfoRoot createQ7WaitInfoRoot();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InfoPackage getInfoPackage();

} //InfoFactory
