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
package org.eclipse.rcptt.debug;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.debug.DebugPackage
 * @generated
 */
public interface DebugFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DebugFactory eINSTANCE = org.eclipse.rcptt.debug.impl.DebugFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Context</em>'.
	 * @generated
	 */
	DebugContext createDebugContext();

	/**
	 * Returns a new object of class '<em>Launch Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Launch Configuration</em>'.
	 * @generated
	 */
	LaunchConfiguration createLaunchConfiguration();

	/**
	 * Returns a new object of class '<em>Map Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Value</em>'.
	 * @generated
	 */
	MapValue createMapValue();

	/**
	 * Returns a new object of class '<em>List Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Value</em>'.
	 * @generated
	 */
	ListValue createListValue();

	/**
	 * Returns a new object of class '<em>Set Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Value</em>'.
	 * @generated
	 */
	SetValue createSetValue();

	/**
	 * Returns a new object of class '<em>Launch Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Launch Type</em>'.
	 * @generated
	 */
	LaunchType createLaunchType();

	/**
	 * Returns a new object of class '<em>Breakpoint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Breakpoint</em>'.
	 * @generated
	 */
	Breakpoint createBreakpoint();

	/**
	 * Returns a new object of class '<em>Launch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Launch</em>'.
	 * @generated
	 */
	Launch createLaunch();

	/**
	 * Returns a new object of class '<em>Breakpoint Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Breakpoint Resource</em>'.
	 * @generated
	 */
	BreakpointResource createBreakpointResource();

	/**
	 * Returns a new object of class '<em>Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection</em>'.
	 * @generated
	 */
	Collection createCollection();

	/**
	 * Returns a new object of class '<em>Primitive Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Value</em>'.
	 * @generated
	 */
	PrimitiveValue createPrimitiveValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DebugPackage getDebugPackage();

} //DebugFactory
