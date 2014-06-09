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
package org.eclipse.rcptt.testing.commands;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.testing.commands.CommandsPackage
 * @generated
 */
public interface CommandsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommandsFactory eINSTANCE = org.eclipse.rcptt.testing.commands.impl.CommandsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Get Aut</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Aut</em>'.
	 * @generated
	 */
	GetAut createGetAut();

	/**
	 * Returns a new object of class '<em>Eval</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eval</em>'.
	 * @generated
	 */
	Eval createEval();

	/**
	 * Returns a new object of class '<em>Get Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Recorder</em>'.
	 * @generated
	 */
	GetRecorder createGetRecorder();

	/**
	 * Returns a new object of class '<em>Set Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Feature</em>'.
	 * @generated
	 */
	SetFeature createSetFeature();

	/**
	 * Returns a new object of class '<em>Invoke AUT</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invoke AUT</em>'.
	 * @generated
	 */
	InvokeAUT createInvokeAUT();

	/**
	 * Returns a new object of class '<em>Find Contexts</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Find Contexts</em>'.
	 * @generated
	 */
	FindContexts createFindContexts();

	/**
	 * Returns a new object of class '<em>Capture Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Capture Context</em>'.
	 * @generated
	 */
	CaptureContext createCaptureContext();

	/**
	 * Returns a new object of class '<em>Apply Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Apply Context</em>'.
	 * @generated
	 */
	ApplyContext createApplyContext();

	/**
	 * Returns a new object of class '<em>Get Global</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Global</em>'.
	 * @generated
	 */
	GetGlobal createGetGlobal();

	/**
	 * Returns a new object of class '<em>Set Global</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Global</em>'.
	 * @generated
	 */
	SetGlobal createSetGlobal();

	/**
	 * Returns a new object of class '<em>Clean Self AUT</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clean Self AUT</em>'.
	 * @generated
	 */
	CleanSelfAUT createCleanSelfAUT();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CommandsPackage getCommandsPackage();

} //CommandsFactory
