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
package org.eclipse.rcptt.tesla.core.protocol.raw;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage
 * @generated
 */
public interface RawFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RawFactory eINSTANCE = org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element</em>'.
	 * @generated
	 */
	Element createElement();

	/**
	 * Returns a new object of class '<em>Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Response</em>'.
	 * @generated
	 */
	Response createResponse();

	/**
	 * Returns a new object of class '<em>Command Transfer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command Transfer</em>'.
	 * @generated
	 */
	CommandTransfer createCommandTransfer();

	/**
	 * Returns a new object of class '<em>Close Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Close Connection</em>'.
	 * @generated
	 */
	CloseConnection createCloseConnection();

	/**
	 * Returns a new object of class '<em>Tesla Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tesla Scenario</em>'.
	 * @generated
	 */
	TeslaScenario createTeslaScenario();

	/**
	 * Returns a new object of class '<em>Command To Element Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command To Element Entry</em>'.
	 * @generated
	 */
	CommandToElementEntry createCommandToElementEntry();

	/**
	 * Returns a new object of class '<em>Command To Raw Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command To Raw Entry</em>'.
	 * @generated
	 */
	CommandToRawEntry createCommandToRawEntry();

	/**
	 * Returns a new object of class '<em>Get Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Feature</em>'.
	 * @generated
	 */
	GetFeature createGetFeature();

	/**
	 * Returns a new object of class '<em>Get Feature Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Feature Response</em>'.
	 * @generated
	 */
	GetFeatureResponse createGetFeatureResponse();

	/**
	 * Returns a new object of class '<em>Set Mode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Mode</em>'.
	 * @generated
	 */
	SetMode createSetMode();

	/**
	 * Returns a new object of class '<em>Execute Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execute Scenario</em>'.
	 * @generated
	 */
	ExecuteScenario createExecuteScenario();

	/**
	 * Returns a new object of class '<em>Step Execution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Step Execution</em>'.
	 * @generated
	 */
	StepExecution createStepExecution();

	/**
	 * Returns a new object of class '<em>Execution Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Status</em>'.
	 * @generated
	 */
	ExecutionStatus createExecutionStatus();

	/**
	 * Returns a new object of class '<em>Assertion Focus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assertion Focus</em>'.
	 * @generated
	 */
	AssertionFocus createAssertionFocus();

	/**
	 * Returns a new object of class '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event</em>'.
	 * @generated
	 */
	RawEvent createRawEvent();

	/**
	 * Returns a new object of class '<em>Set Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Feature</em>'.
	 * @generated
	 */
	SetFeature createSetFeature();

	/**
	 * Returns a new object of class '<em>Reset Assert Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reset Assert Selection</em>'.
	 * @generated
	 */
	ResetAssertSelection createResetAssertSelection();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RawPackage getRawPackage();

} //RawFactory
