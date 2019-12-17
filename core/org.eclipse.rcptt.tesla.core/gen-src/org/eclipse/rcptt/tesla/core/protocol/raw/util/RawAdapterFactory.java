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
package org.eclipse.rcptt.tesla.core.protocol.raw.util;

import org.eclipse.rcptt.tesla.core.protocol.raw.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage
 * @generated
 */
public class RawAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RawPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawAdapterFactory() {
		if (modelPackage == null)
		{
			modelPackage = RawPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RawSwitch<Adapter> modelSwitch = new RawSwitch<Adapter>()
	{
		@Override
		public Adapter caseElement(Element object)
		{
			return createElementAdapter();
		}

		@Override
		public Adapter caseCommand(Command object)
		{
			return createCommandAdapter();
		}

		@Override
		public Adapter caseResponse(Response object)
		{
			return createResponseAdapter();
		}

		@Override
		public Adapter caseCommandTransfer(CommandTransfer object)
		{
			return createCommandTransferAdapter();
		}

		@Override
		public Adapter caseCloseConnection(CloseConnection object)
		{
			return createCloseConnectionAdapter();
		}

		@Override
		public Adapter caseTeslaScenario(TeslaScenario object)
		{
			return createTeslaScenarioAdapter();
		}

		@Override
		public Adapter caseCommandToElementEntry(CommandToElementEntry object)
		{
			return createCommandToElementEntryAdapter();
		}

		@Override
		public Adapter caseCommandToRawEntry(CommandToRawEntry object)
		{
			return createCommandToRawEntryAdapter();
		}

		@Override
		public Adapter caseGetFeature(GetFeature object)
		{
			return createGetFeatureAdapter();
		}

		@Override
		public Adapter caseGetFeatureResponse(GetFeatureResponse object)
		{
			return createGetFeatureResponseAdapter();
		}

		@Override
		public Adapter caseSetMode(SetMode object)
		{
			return createSetModeAdapter();
		}

		@Override
		public Adapter caseExecuteScenario(ExecuteScenario object)
		{
			return createExecuteScenarioAdapter();
		}

		@Override
		public Adapter caseStepExecution(StepExecution object)
		{
			return createStepExecutionAdapter();
		}

		@Override
		public Adapter caseExecutionStatus(ExecutionStatus object)
		{
			return createExecutionStatusAdapter();
		}

		@Override
		public Adapter caseAssertionFocus(AssertionFocus object)
		{
			return createAssertionFocusAdapter();
		}

		@Override
		public Adapter caseRawEvent(RawEvent object)
		{
			return createRawEventAdapter();
		}

		@Override
		public Adapter caseSetFeature(SetFeature object)
		{
			return createSetFeatureAdapter();
		}

		@Override
		public Adapter caseResetAssertSelection(ResetAssertSelection object)
		{
			return createResetAssertSelectionAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object)
		{
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Command
	 * @generated
	 */
	public Adapter createCommandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Response <em>Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Response
	 * @generated
	 */
	public Adapter createResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer <em>Command Transfer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer
	 * @generated
	 */
	public Adapter createCommandTransferAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CloseConnection <em>Close Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CloseConnection
	 * @generated
	 */
	public Adapter createCloseConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario <em>Tesla Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario
	 * @generated
	 */
	public Adapter createTeslaScenarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry <em>Command To Element Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry
	 * @generated
	 */
	public Adapter createCommandToElementEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry <em>Command To Raw Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry
	 * @generated
	 */
	public Adapter createCommandToRawEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.GetFeature <em>Get Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.GetFeature
	 * @generated
	 */
	public Adapter createGetFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.GetFeatureResponse <em>Get Feature Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.GetFeatureResponse
	 * @generated
	 */
	public Adapter createGetFeatureResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.SetMode <em>Set Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.SetMode
	 * @generated
	 */
	public Adapter createSetModeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteScenario <em>Execute Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteScenario
	 * @generated
	 */
	public Adapter createExecuteScenarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.StepExecution <em>Step Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.StepExecution
	 * @generated
	 */
	public Adapter createStepExecutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus <em>Execution Status</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus
	 * @generated
	 */
	public Adapter createExecutionStatusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus <em>Assertion Focus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus
	 * @generated
	 */
	public Adapter createAssertionFocusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent
	 * @generated
	 */
	public Adapter createRawEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.SetFeature <em>Set Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.SetFeature
	 * @generated
	 */
	public Adapter createSetFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ResetAssertSelection <em>Reset Assert Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ResetAssertSelection
	 * @generated
	 */
	public Adapter createResetAssertSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //RawAdapterFactory
