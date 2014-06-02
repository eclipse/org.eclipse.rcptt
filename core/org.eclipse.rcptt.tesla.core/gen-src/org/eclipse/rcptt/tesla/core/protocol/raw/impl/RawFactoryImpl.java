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
package org.eclipse.rcptt.tesla.core.protocol.raw.impl;

import org.eclipse.rcptt.tesla.core.protocol.raw.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RawFactoryImpl extends EFactoryImpl implements RawFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RawFactory init() {
		try
		{
			RawFactory theRawFactory = (RawFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://eclipse.org/rcptt/tesla/rawprotocol");
			if (theRawFactory != null)
			{
				return theRawFactory;
			}
		} catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RawFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID())
		{
		case RawPackage.ELEMENT:
			return createElement();
		case RawPackage.RESPONSE:
			return createResponse();
		case RawPackage.COMMAND_TRANSFER:
			return createCommandTransfer();
		case RawPackage.CLOSE_CONNECTION:
			return createCloseConnection();
		case RawPackage.TESLA_SCENARIO:
			return createTeslaScenario();
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY:
			return createCommandToElementEntry();
		case RawPackage.COMMAND_TO_RAW_ENTRY:
			return createCommandToRawEntry();
		case RawPackage.GET_FEATURE:
			return createGetFeature();
		case RawPackage.GET_FEATURE_RESPONSE:
			return createGetFeatureResponse();
		case RawPackage.SET_MODE:
			return createSetMode();
		case RawPackage.EXECUTE_SCENARIO:
			return createExecuteScenario();
		case RawPackage.STEP_EXECUTION:
			return createStepExecution();
		case RawPackage.EXECUTION_STATUS:
			return createExecutionStatus();
		case RawPackage.ASSERTION_FOCUS:
			return createAssertionFocus();
		case RawPackage.RAW_EVENT:
			return createRawEvent();
		case RawPackage.SET_FEATURE:
			return createSetFeature();
		case RawPackage.RESET_ASSERT_SELECTION:
			return createResetAssertSelection();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID())
		{
		case RawPackage.RESPONSE_STATUS:
			return createResponseStatusFromString(eDataType, initialValue);
		case RawPackage.COMMAND_TRANSFER_KIND:
			return createCommandTransferKindFromString(eDataType, initialValue);
		case RawPackage.TESLA_MODE:
			return createTeslaModeFromString(eDataType, initialValue);
		case RawPackage.EXECUTE_MODE:
			return createExecuteModeFromString(eDataType, initialValue);
		case RawPackage.EXECUTION_STATUS_KIND:
			return createExecutionStatusKindFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID())
		{
		case RawPackage.RESPONSE_STATUS:
			return convertResponseStatusToString(eDataType, instanceValue);
		case RawPackage.COMMAND_TRANSFER_KIND:
			return convertCommandTransferKindToString(eDataType, instanceValue);
		case RawPackage.TESLA_MODE:
			return convertTeslaModeToString(eDataType, instanceValue);
		case RawPackage.EXECUTE_MODE:
			return convertExecuteModeToString(eDataType, instanceValue);
		case RawPackage.EXECUTION_STATUS_KIND:
			return convertExecutionStatusKindToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element createElement() {
		ElementImpl element = new ElementImpl();
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Response createResponse() {
		ResponseImpl response = new ResponseImpl();
		return response;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandTransfer createCommandTransfer() {
		CommandTransferImpl commandTransfer = new CommandTransferImpl();
		return commandTransfer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloseConnection createCloseConnection() {
		CloseConnectionImpl closeConnection = new CloseConnectionImpl();
		return closeConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TeslaScenario createTeslaScenario() {
		TeslaScenarioImpl teslaScenario = new TeslaScenarioImpl();
		return teslaScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandToElementEntry createCommandToElementEntry() {
		CommandToElementEntryImpl commandToElementEntry = new CommandToElementEntryImpl();
		return commandToElementEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandToRawEntry createCommandToRawEntry() {
		CommandToRawEntryImpl commandToRawEntry = new CommandToRawEntryImpl();
		return commandToRawEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetFeature createGetFeature() {
		GetFeatureImpl getFeature = new GetFeatureImpl();
		return getFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetFeatureResponse createGetFeatureResponse() {
		GetFeatureResponseImpl getFeatureResponse = new GetFeatureResponseImpl();
		return getFeatureResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetMode createSetMode() {
		SetModeImpl setMode = new SetModeImpl();
		return setMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecuteScenario createExecuteScenario() {
		ExecuteScenarioImpl executeScenario = new ExecuteScenarioImpl();
		return executeScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepExecution createStepExecution() {
		StepExecutionImpl stepExecution = new StepExecutionImpl();
		return stepExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionStatus createExecutionStatus() {
		ExecutionStatusImpl executionStatus = new ExecutionStatusImpl();
		return executionStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssertionFocus createAssertionFocus() {
		AssertionFocusImpl assertionFocus = new AssertionFocusImpl();
		return assertionFocus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawEvent createRawEvent() {
		RawEventImpl rawEvent = new RawEventImpl();
		return rawEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetFeature createSetFeature() {
		SetFeatureImpl setFeature = new SetFeatureImpl();
		return setFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResetAssertSelection createResetAssertSelection() {
		ResetAssertSelectionImpl resetAssertSelection = new ResetAssertSelectionImpl();
		return resetAssertSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponseStatus createResponseStatusFromString(EDataType eDataType,
			String initialValue) {
		ResponseStatus result = ResponseStatus.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
					+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResponseStatusToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandTransferKind createCommandTransferKindFromString(
			EDataType eDataType, String initialValue) {
		CommandTransferKind result = CommandTransferKind.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
					+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCommandTransferKindToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TeslaMode createTeslaModeFromString(EDataType eDataType,
			String initialValue) {
		TeslaMode result = TeslaMode.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
					+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTeslaModeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecuteMode createExecuteModeFromString(EDataType eDataType,
			String initialValue) {
		ExecuteMode result = ExecuteMode.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
					+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExecuteModeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionStatusKind createExecutionStatusKindFromString(
			EDataType eDataType, String initialValue) {
		ExecutionStatusKind result = ExecutionStatusKind.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
					+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExecutionStatusKindToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawPackage getRawPackage() {
		return (RawPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RawPackage getPackage() {
		return RawPackage.eINSTANCE;
	}

} //RawFactoryImpl
