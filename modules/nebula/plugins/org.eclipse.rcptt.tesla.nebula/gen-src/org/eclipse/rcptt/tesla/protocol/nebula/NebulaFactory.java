/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.protocol.nebula;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage
 * @generated
 */
public interface NebulaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NebulaFactory eINSTANCE = org.eclipse.rcptt.tesla.protocol.nebula.impl.NebulaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Set Selection Ex</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Selection Ex</em>'.
	 * @generated
	 */
	SetSelectionEx createSetSelectionEx();

	/**
	 * Returns a new object of class '<em>Set Selection Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Selection Range</em>'.
	 * @generated
	 */
	SetSelectionRange createSetSelectionRange();

	/**
	 * Returns a new object of class '<em>Multi Selection Item Ex</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Selection Item Ex</em>'.
	 * @generated
	 */
	MultiSelectionItemEx createMultiSelectionItemEx();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NebulaPackage getNebulaPackage();

} //NebulaFactory
