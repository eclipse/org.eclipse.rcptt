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
package org.eclipse.rcptt.tesla.core.protocol.raw.util;

import org.eclipse.rcptt.tesla.core.protocol.raw.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage
 * @generated
 */
public class RawSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RawPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawSwitch() {
		if (modelPackage == null)
		{
			modelPackage = RawPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage)
		{
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else
		{
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID)
		{
		case RawPackage.ELEMENT: {
			Element element = (Element) theEObject;
			T result = caseElement(element);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.COMMAND: {
			Command command = (Command) theEObject;
			T result = caseCommand(command);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.RESPONSE: {
			Response response = (Response) theEObject;
			T result = caseResponse(response);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.COMMAND_TRANSFER: {
			CommandTransfer commandTransfer = (CommandTransfer) theEObject;
			T result = caseCommandTransfer(commandTransfer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.CLOSE_CONNECTION: {
			CloseConnection closeConnection = (CloseConnection) theEObject;
			T result = caseCloseConnection(closeConnection);
			if (result == null)
				result = caseCommand(closeConnection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.TESLA_SCENARIO: {
			TeslaScenario teslaScenario = (TeslaScenario) theEObject;
			T result = caseTeslaScenario(teslaScenario);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY: {
			CommandToElementEntry commandToElementEntry = (CommandToElementEntry) theEObject;
			T result = caseCommandToElementEntry(commandToElementEntry);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.COMMAND_TO_RAW_ENTRY: {
			CommandToRawEntry commandToRawEntry = (CommandToRawEntry) theEObject;
			T result = caseCommandToRawEntry(commandToRawEntry);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.GET_FEATURE: {
			GetFeature getFeature = (GetFeature) theEObject;
			T result = caseGetFeature(getFeature);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.GET_FEATURE_RESPONSE: {
			GetFeatureResponse getFeatureResponse = (GetFeatureResponse) theEObject;
			T result = caseGetFeatureResponse(getFeatureResponse);
			if (result == null)
				result = caseResponse(getFeatureResponse);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.SET_MODE: {
			SetMode setMode = (SetMode) theEObject;
			T result = caseSetMode(setMode);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.EXECUTE_SCENARIO: {
			ExecuteScenario executeScenario = (ExecuteScenario) theEObject;
			T result = caseExecuteScenario(executeScenario);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.STEP_EXECUTION: {
			StepExecution stepExecution = (StepExecution) theEObject;
			T result = caseStepExecution(stepExecution);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.EXECUTION_STATUS: {
			ExecutionStatus executionStatus = (ExecutionStatus) theEObject;
			T result = caseExecutionStatus(executionStatus);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.ASSERTION_FOCUS: {
			AssertionFocus assertionFocus = (AssertionFocus) theEObject;
			T result = caseAssertionFocus(assertionFocus);
			if (result == null)
				result = caseCommand(assertionFocus);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.RAW_EVENT: {
			RawEvent rawEvent = (RawEvent) theEObject;
			T result = caseRawEvent(rawEvent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.SET_FEATURE: {
			SetFeature setFeature = (SetFeature) theEObject;
			T result = caseSetFeature(setFeature);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RawPackage.RESET_ASSERT_SELECTION: {
			ResetAssertSelection resetAssertSelection = (ResetAssertSelection) theEObject;
			T result = caseResetAssertSelection(resetAssertSelection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommand(Command object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResponse(Response object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command Transfer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command Transfer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandTransfer(CommandTransfer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Close Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Close Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloseConnection(CloseConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tesla Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tesla Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTeslaScenario(TeslaScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command To Element Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command To Element Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandToElementEntry(CommandToElementEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command To Raw Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command To Raw Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandToRawEntry(CommandToRawEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetFeature(GetFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Feature Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Feature Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetFeatureResponse(GetFeatureResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Mode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Mode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetMode(SetMode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execute Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execute Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecuteScenario(ExecuteScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Step Execution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Step Execution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStepExecution(StepExecution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Status</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Status</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionStatus(ExecutionStatus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assertion Focus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assertion Focus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssertionFocus(AssertionFocus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRawEvent(RawEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetFeature(SetFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reset Assert Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reset Assert Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResetAssertSelection(ResetAssertSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //RawSwitch
