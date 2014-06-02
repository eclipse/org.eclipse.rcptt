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
package org.eclipse.rcptt.tesla.core.protocol.raw;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawFactory
 * @model kind="package"
 * @generated
 */
public interface RawPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "raw";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/tesla/rawprotocol";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rpctt.tesla.rawprotocol";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RawPackage eINSTANCE = org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.ElementImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__KIND = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Command <em>Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Command
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getCommand()
	 * @generated
	 */
	int COMMAND = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__ID = 0;

	/**
	 * The number of structural features of the '<em>Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ResponseImpl <em>Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.ResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getResponse()
	 * @generated
	 */
	int RESPONSE = 2;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE__STATUS = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE__ADVANCED_INFORMATION = 2;

	/**
	 * The number of structural features of the '<em>Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandTransferImpl <em>Command Transfer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandTransferImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getCommandTransfer()
	 * @generated
	 */
	int COMMAND_TRANSFER = 3;

	/**
	 * The feature id for the '<em><b>Command</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TRANSFER__COMMAND = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TRANSFER__ELEMENTS = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TRANSFER__KIND = 2;

	/**
	 * The feature id for the '<em><b>Controls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TRANSFER__CONTROLS = 3;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TRANSFER__INDEX = 4;

	/**
	 * The feature id for the '<em><b>Raw Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TRANSFER__RAW_EVENTS = 5;

	/**
	 * The number of structural features of the '<em>Command Transfer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TRANSFER_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CloseConnectionImpl <em>Close Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.CloseConnectionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getCloseConnection()
	 * @generated
	 */
	int CLOSE_CONNECTION = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_CONNECTION__ID = COMMAND__ID;

	/**
	 * The number of structural features of the '<em>Close Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_CONNECTION_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.TeslaScenarioImpl <em>Tesla Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.TeslaScenarioImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getTeslaScenario()
	 * @generated
	 */
	int TESLA_SCENARIO = 5;

	/**
	 * The feature id for the '<em><b>Commands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESLA_SCENARIO__COMMANDS = 0;

	/**
	 * The feature id for the '<em><b>Element Mapping</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESLA_SCENARIO__ELEMENT_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESLA_SCENARIO__ID = 2;

	/**
	 * The feature id for the '<em><b>Required Contexts</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESLA_SCENARIO__REQUIRED_CONTEXTS = 3;

	/**
	 * The feature id for the '<em><b>Raw Mapping</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESLA_SCENARIO__RAW_MAPPING = 4;

	/**
	 * The number of structural features of the '<em>Tesla Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TESLA_SCENARIO_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandToElementEntryImpl <em>Command To Element Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandToElementEntryImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getCommandToElementEntry()
	 * @generated
	 */
	int COMMAND_TO_ELEMENT_ENTRY = 6;

	/**
	 * The feature id for the '<em><b>Command</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TO_ELEMENT_ENTRY__COMMAND = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TO_ELEMENT_ENTRY__ELEMENTS = 1;

	/**
	 * The feature id for the '<em><b>Controls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TO_ELEMENT_ENTRY__CONTROLS = 2;

	/**
	 * The number of structural features of the '<em>Command To Element Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TO_ELEMENT_ENTRY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandToRawEntryImpl <em>Command To Raw Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandToRawEntryImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getCommandToRawEntry()
	 * @generated
	 */
	int COMMAND_TO_RAW_ENTRY = 7;

	/**
	 * The feature id for the '<em><b>Raw Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TO_RAW_ENTRY__RAW_EVENTS = 0;

	/**
	 * The feature id for the '<em><b>Command</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TO_RAW_ENTRY__COMMAND = 1;

	/**
	 * The number of structural features of the '<em>Command To Raw Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_TO_RAW_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.GetFeatureImpl <em>Get Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.GetFeatureImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getGetFeature()
	 * @generated
	 */
	int GET_FEATURE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FEATURE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Get Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FEATURE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.GetFeatureResponseImpl <em>Get Feature Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.GetFeatureResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getGetFeatureResponse()
	 * @generated
	 */
	int GET_FEATURE_RESPONSE = 9;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FEATURE_RESPONSE__STATUS = RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FEATURE_RESPONSE__MESSAGE = RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FEATURE_RESPONSE__ADVANCED_INFORMATION = RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FEATURE_RESPONSE__VALUE = RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Feature Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FEATURE_RESPONSE_FEATURE_COUNT = RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.SetModeImpl <em>Set Mode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.SetModeImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getSetMode()
	 * @generated
	 */
	int SET_MODE = 10;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MODE__MODE = 0;

	/**
	 * The feature id for the '<em><b>Widget Classes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MODE__WIDGET_CLASSES = 1;

	/**
	 * The number of structural features of the '<em>Set Mode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_MODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ExecuteScenarioImpl <em>Execute Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.ExecuteScenarioImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getExecuteScenario()
	 * @generated
	 */
	int EXECUTE_SCENARIO = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_SCENARIO__ID = 0;

	/**
	 * The feature id for the '<em><b>Execute Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_SCENARIO__EXECUTE_MODE = 1;

	/**
	 * The number of structural features of the '<em>Execute Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTE_SCENARIO_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.StepExecutionImpl <em>Step Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.StepExecutionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getStepExecution()
	 * @generated
	 */
	int STEP_EXECUTION = 12;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_EXECUTION__COUNT = 0;

	/**
	 * The number of structural features of the '<em>Step Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_EXECUTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ExecutionStatusImpl <em>Execution Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.ExecutionStatusImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getExecutionStatus()
	 * @generated
	 */
	int EXECUTION_STATUS = 13;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATUS__MESSAGE = 0;

	/**
	 * The feature id for the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATUS__PROGRESS = 1;

	/**
	 * The feature id for the '<em><b>Status Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATUS__STATUS_KIND = 2;

	/**
	 * The number of structural features of the '<em>Execution Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STATUS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.AssertionFocusImpl <em>Assertion Focus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.AssertionFocusImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getAssertionFocus()
	 * @generated
	 */
	int ASSERTION_FOCUS = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION_FOCUS__ID = COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Point Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION_FOCUS__POINT_FIXED = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION_FOCUS__ELEMENT = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Image Capture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION_FOCUS__IMAGE_CAPTURE = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assertion Focus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION_FOCUS_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getRawEvent()
	 * @generated
	 */
	int RAW_EVENT = 15;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__WIDGET = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__DETAIL = 2;

	/**
	 * The feature id for the '<em><b>Item</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__ITEM = 3;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__INDEX = 4;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__X = 5;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__Y = 6;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__WIDTH = 7;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__HEIGHT = 8;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__COUNT = 9;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__TIME = 10;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__BUTTON = 11;

	/**
	 * The feature id for the '<em><b>Character</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__CHARACTER = 12;

	/**
	 * The feature id for the '<em><b>Key Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__KEY_CODE = 13;

	/**
	 * The feature id for the '<em><b>State Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__STATE_MASK = 14;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__START = 15;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__END = 16;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__TEXT = 17;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__DATA = 18;

	/**
	 * The feature id for the '<em><b>Native Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT__NATIVE_EVENT = 19;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_EVENT_FEATURE_COUNT = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.SetFeatureImpl <em>Set Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.SetFeatureImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getSetFeature()
	 * @generated
	 */
	int SET_FEATURE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FEATURE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FEATURE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Set Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FEATURE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ResetAssertSelectionImpl <em>Reset Assert Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.ResetAssertSelectionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getResetAssertSelection()
	 * @generated
	 */
	int RESET_ASSERT_SELECTION = 17;

	/**
	 * The number of structural features of the '<em>Reset Assert Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_ASSERT_SELECTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus <em>Response Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getResponseStatus()
	 * @generated
	 */
	int RESPONSE_STATUS = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransferKind <em>Command Transfer Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransferKind
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getCommandTransferKind()
	 * @generated
	 */
	int COMMAND_TRANSFER_KIND = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode <em>Tesla Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getTeslaMode()
	 * @generated
	 */
	int TESLA_MODE = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteMode <em>Execute Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteMode
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getExecuteMode()
	 * @generated
	 */
	int EXECUTE_MODE = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatusKind <em>Execution Status Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatusKind
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getExecutionStatusKind()
	 * @generated
	 */
	int EXECUTION_STATUS_KIND = 22;

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Element#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Element#getId()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Element#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Element#getKind()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Element#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Element#getDescription()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Description();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Command
	 * @generated
	 */
	EClass getCommand();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Command#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Command#getId()
	 * @see #getCommand()
	 * @generated
	 */
	EAttribute getCommand_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Response <em>Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Response
	 * @generated
	 */
	EClass getResponse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Response#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Response#getStatus()
	 * @see #getResponse()
	 * @generated
	 */
	EAttribute getResponse_Status();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Response#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Response#getMessage()
	 * @see #getResponse()
	 * @generated
	 */
	EAttribute getResponse_Message();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Response#getAdvancedInformation <em>Advanced Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Advanced Information</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Response#getAdvancedInformation()
	 * @see #getResponse()
	 * @generated
	 */
	EReference getResponse_AdvancedInformation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer <em>Command Transfer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command Transfer</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer
	 * @generated
	 */
	EClass getCommandTransfer();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Command</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer#getCommand()
	 * @see #getCommandTransfer()
	 * @generated
	 */
	EReference getCommandTransfer_Command();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer#getElements()
	 * @see #getCommandTransfer()
	 * @generated
	 */
	EReference getCommandTransfer_Elements();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer#getKind()
	 * @see #getCommandTransfer()
	 * @generated
	 */
	EAttribute getCommandTransfer_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer#getControls <em>Controls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Controls</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer#getControls()
	 * @see #getCommandTransfer()
	 * @generated
	 */
	EReference getCommandTransfer_Controls();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer#getIndex()
	 * @see #getCommandTransfer()
	 * @generated
	 */
	EAttribute getCommandTransfer_Index();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer#getRawEvents <em>Raw Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Raw Events</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer#getRawEvents()
	 * @see #getCommandTransfer()
	 * @generated
	 */
	EReference getCommandTransfer_RawEvents();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CloseConnection <em>Close Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Close Connection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CloseConnection
	 * @generated
	 */
	EClass getCloseConnection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario <em>Tesla Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tesla Scenario</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario
	 * @generated
	 */
	EClass getTeslaScenario();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getCommands <em>Commands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Commands</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getCommands()
	 * @see #getTeslaScenario()
	 * @generated
	 */
	EReference getTeslaScenario_Commands();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getElementMapping <em>Element Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element Mapping</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getElementMapping()
	 * @see #getTeslaScenario()
	 * @generated
	 */
	EReference getTeslaScenario_ElementMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getId()
	 * @see #getTeslaScenario()
	 * @generated
	 */
	EAttribute getTeslaScenario_Id();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getRequiredContexts <em>Required Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Required Contexts</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getRequiredContexts()
	 * @see #getTeslaScenario()
	 * @generated
	 */
	EAttribute getTeslaScenario_RequiredContexts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getRawMapping <em>Raw Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Raw Mapping</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getRawMapping()
	 * @see #getTeslaScenario()
	 * @generated
	 */
	EReference getTeslaScenario_RawMapping();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry <em>Command To Element Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command To Element Entry</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry
	 * @generated
	 */
	EClass getCommandToElementEntry();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Command</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry#getCommand()
	 * @see #getCommandToElementEntry()
	 * @generated
	 */
	EReference getCommandToElementEntry_Command();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry#getElements()
	 * @see #getCommandToElementEntry()
	 * @generated
	 */
	EReference getCommandToElementEntry_Elements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry#getControls <em>Controls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Controls</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry#getControls()
	 * @see #getCommandToElementEntry()
	 * @generated
	 */
	EReference getCommandToElementEntry_Controls();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry <em>Command To Raw Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command To Raw Entry</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry
	 * @generated
	 */
	EClass getCommandToRawEntry();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry#getRawEvents <em>Raw Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Raw Events</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry#getRawEvents()
	 * @see #getCommandToRawEntry()
	 * @generated
	 */
	EReference getCommandToRawEntry_RawEvents();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Command</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry#getCommand()
	 * @see #getCommandToRawEntry()
	 * @generated
	 */
	EReference getCommandToRawEntry_Command();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.GetFeature <em>Get Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Feature</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.GetFeature
	 * @generated
	 */
	EClass getGetFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.GetFeature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.GetFeature#getName()
	 * @see #getGetFeature()
	 * @generated
	 */
	EAttribute getGetFeature_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.GetFeatureResponse <em>Get Feature Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Feature Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.GetFeatureResponse
	 * @generated
	 */
	EClass getGetFeatureResponse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.GetFeatureResponse#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.GetFeatureResponse#getValue()
	 * @see #getGetFeatureResponse()
	 * @generated
	 */
	EAttribute getGetFeatureResponse_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.SetMode <em>Set Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Mode</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.SetMode
	 * @generated
	 */
	EClass getSetMode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.SetMode#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.SetMode#getMode()
	 * @see #getSetMode()
	 * @generated
	 */
	EAttribute getSetMode_Mode();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.raw.SetMode#getWidgetClasses <em>Widget Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Widget Classes</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.SetMode#getWidgetClasses()
	 * @see #getSetMode()
	 * @generated
	 */
	EAttribute getSetMode_WidgetClasses();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteScenario <em>Execute Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execute Scenario</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteScenario
	 * @generated
	 */
	EClass getExecuteScenario();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteScenario#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteScenario#getId()
	 * @see #getExecuteScenario()
	 * @generated
	 */
	EAttribute getExecuteScenario_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteScenario#getExecuteMode <em>Execute Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execute Mode</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteScenario#getExecuteMode()
	 * @see #getExecuteScenario()
	 * @generated
	 */
	EAttribute getExecuteScenario_ExecuteMode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.StepExecution <em>Step Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step Execution</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.StepExecution
	 * @generated
	 */
	EClass getStepExecution();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.StepExecution#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.StepExecution#getCount()
	 * @see #getStepExecution()
	 * @generated
	 */
	EAttribute getStepExecution_Count();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus <em>Execution Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Status</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus
	 * @generated
	 */
	EClass getExecutionStatus();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus#getMessage()
	 * @see #getExecutionStatus()
	 * @generated
	 */
	EAttribute getExecutionStatus_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus#getProgress <em>Progress</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Progress</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus#getProgress()
	 * @see #getExecutionStatus()
	 * @generated
	 */
	EAttribute getExecutionStatus_Progress();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus#getStatusKind <em>Status Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus#getStatusKind()
	 * @see #getExecutionStatus()
	 * @generated
	 */
	EAttribute getExecutionStatus_StatusKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus <em>Assertion Focus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assertion Focus</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus
	 * @generated
	 */
	EClass getAssertionFocus();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus#isPointFixed <em>Point Fixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Point Fixed</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus#isPointFixed()
	 * @see #getAssertionFocus()
	 * @generated
	 */
	EAttribute getAssertionFocus_PointFixed();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus#getElement()
	 * @see #getAssertionFocus()
	 * @generated
	 */
	EReference getAssertionFocus_Element();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus#getImageCapture <em>Image Capture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Capture</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus#getImageCapture()
	 * @see #getAssertionFocus()
	 * @generated
	 */
	EAttribute getAssertionFocus_ImageCapture();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent
	 * @generated
	 */
	EClass getRawEvent();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getWidget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Widget</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getWidget()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_Widget();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getType()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getDetail <em>Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Detail</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getDetail()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_Detail();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Item</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getItem()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_Item();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getIndex()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getX()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getY()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getWidth()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getHeight()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getCount()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_Count();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getTime()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_Time();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getButton()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_Button();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getCharacter <em>Character</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Character</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getCharacter()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_Character();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getKeyCode <em>Key Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key Code</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getKeyCode()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_KeyCode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getStateMask <em>State Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Mask</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getStateMask()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_StateMask();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getStart()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_Start();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getEnd()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_End();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getText()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#getData()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_Data();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#isNativeEvent <em>Native Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Native Event</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent#isNativeEvent()
	 * @see #getRawEvent()
	 * @generated
	 */
	EAttribute getRawEvent_NativeEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.SetFeature <em>Set Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Feature</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.SetFeature
	 * @generated
	 */
	EClass getSetFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.SetFeature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.SetFeature#getName()
	 * @see #getSetFeature()
	 * @generated
	 */
	EAttribute getSetFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.raw.SetFeature#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.SetFeature#getValue()
	 * @see #getSetFeature()
	 * @generated
	 */
	EAttribute getSetFeature_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ResetAssertSelection <em>Reset Assert Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reset Assert Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ResetAssertSelection
	 * @generated
	 */
	EClass getResetAssertSelection();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus <em>Response Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Response Status</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus
	 * @generated
	 */
	EEnum getResponseStatus();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransferKind <em>Command Transfer Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Command Transfer Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransferKind
	 * @generated
	 */
	EEnum getCommandTransferKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode <em>Tesla Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Tesla Mode</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode
	 * @generated
	 */
	EEnum getTeslaMode();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteMode <em>Execute Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Execute Mode</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteMode
	 * @generated
	 */
	EEnum getExecuteMode();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatusKind <em>Execution Status Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Execution Status Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatusKind
	 * @generated
	 */
	EEnum getExecutionStatusKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RawFactory getRawFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.ElementImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__ID = eINSTANCE.getElement_Id();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__KIND = eINSTANCE.getElement_Kind();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__DESCRIPTION = eINSTANCE.getElement_Description();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Command <em>Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Command
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getCommand()
		 * @generated
		 */
		EClass COMMAND = eINSTANCE.getCommand();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND__ID = eINSTANCE.getCommand_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ResponseImpl <em>Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.ResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getResponse()
		 * @generated
		 */
		EClass RESPONSE = eINSTANCE.getResponse();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESPONSE__STATUS = eINSTANCE.getResponse_Status();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESPONSE__MESSAGE = eINSTANCE.getResponse_Message();

		/**
		 * The meta object literal for the '<em><b>Advanced Information</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSE__ADVANCED_INFORMATION = eINSTANCE.getResponse_AdvancedInformation();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandTransferImpl <em>Command Transfer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandTransferImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getCommandTransfer()
		 * @generated
		 */
		EClass COMMAND_TRANSFER = eINSTANCE.getCommandTransfer();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_TRANSFER__COMMAND = eINSTANCE.getCommandTransfer_Command();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_TRANSFER__ELEMENTS = eINSTANCE.getCommandTransfer_Elements();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_TRANSFER__KIND = eINSTANCE.getCommandTransfer_Kind();

		/**
		 * The meta object literal for the '<em><b>Controls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_TRANSFER__CONTROLS = eINSTANCE.getCommandTransfer_Controls();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_TRANSFER__INDEX = eINSTANCE.getCommandTransfer_Index();

		/**
		 * The meta object literal for the '<em><b>Raw Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_TRANSFER__RAW_EVENTS = eINSTANCE.getCommandTransfer_RawEvents();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CloseConnectionImpl <em>Close Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.CloseConnectionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getCloseConnection()
		 * @generated
		 */
		EClass CLOSE_CONNECTION = eINSTANCE.getCloseConnection();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.TeslaScenarioImpl <em>Tesla Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.TeslaScenarioImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getTeslaScenario()
		 * @generated
		 */
		EClass TESLA_SCENARIO = eINSTANCE.getTeslaScenario();

		/**
		 * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESLA_SCENARIO__COMMANDS = eINSTANCE.getTeslaScenario_Commands();

		/**
		 * The meta object literal for the '<em><b>Element Mapping</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESLA_SCENARIO__ELEMENT_MAPPING = eINSTANCE.getTeslaScenario_ElementMapping();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESLA_SCENARIO__ID = eINSTANCE.getTeslaScenario_Id();

		/**
		 * The meta object literal for the '<em><b>Required Contexts</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TESLA_SCENARIO__REQUIRED_CONTEXTS = eINSTANCE.getTeslaScenario_RequiredContexts();

		/**
		 * The meta object literal for the '<em><b>Raw Mapping</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TESLA_SCENARIO__RAW_MAPPING = eINSTANCE.getTeslaScenario_RawMapping();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandToElementEntryImpl <em>Command To Element Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandToElementEntryImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getCommandToElementEntry()
		 * @generated
		 */
		EClass COMMAND_TO_ELEMENT_ENTRY = eINSTANCE.getCommandToElementEntry();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_TO_ELEMENT_ENTRY__COMMAND = eINSTANCE.getCommandToElementEntry_Command();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_TO_ELEMENT_ENTRY__ELEMENTS = eINSTANCE.getCommandToElementEntry_Elements();

		/**
		 * The meta object literal for the '<em><b>Controls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_TO_ELEMENT_ENTRY__CONTROLS = eINSTANCE.getCommandToElementEntry_Controls();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandToRawEntryImpl <em>Command To Raw Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandToRawEntryImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getCommandToRawEntry()
		 * @generated
		 */
		EClass COMMAND_TO_RAW_ENTRY = eINSTANCE.getCommandToRawEntry();

		/**
		 * The meta object literal for the '<em><b>Raw Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_TO_RAW_ENTRY__RAW_EVENTS = eINSTANCE.getCommandToRawEntry_RawEvents();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_TO_RAW_ENTRY__COMMAND = eINSTANCE.getCommandToRawEntry_Command();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.GetFeatureImpl <em>Get Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.GetFeatureImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getGetFeature()
		 * @generated
		 */
		EClass GET_FEATURE = eINSTANCE.getGetFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_FEATURE__NAME = eINSTANCE.getGetFeature_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.GetFeatureResponseImpl <em>Get Feature Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.GetFeatureResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getGetFeatureResponse()
		 * @generated
		 */
		EClass GET_FEATURE_RESPONSE = eINSTANCE.getGetFeatureResponse();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_FEATURE_RESPONSE__VALUE = eINSTANCE.getGetFeatureResponse_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.SetModeImpl <em>Set Mode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.SetModeImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getSetMode()
		 * @generated
		 */
		EClass SET_MODE = eINSTANCE.getSetMode();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_MODE__MODE = eINSTANCE.getSetMode_Mode();

		/**
		 * The meta object literal for the '<em><b>Widget Classes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_MODE__WIDGET_CLASSES = eINSTANCE.getSetMode_WidgetClasses();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ExecuteScenarioImpl <em>Execute Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.ExecuteScenarioImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getExecuteScenario()
		 * @generated
		 */
		EClass EXECUTE_SCENARIO = eINSTANCE.getExecuteScenario();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTE_SCENARIO__ID = eINSTANCE.getExecuteScenario_Id();

		/**
		 * The meta object literal for the '<em><b>Execute Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTE_SCENARIO__EXECUTE_MODE = eINSTANCE.getExecuteScenario_ExecuteMode();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.StepExecutionImpl <em>Step Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.StepExecutionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getStepExecution()
		 * @generated
		 */
		EClass STEP_EXECUTION = eINSTANCE.getStepExecution();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEP_EXECUTION__COUNT = eINSTANCE.getStepExecution_Count();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ExecutionStatusImpl <em>Execution Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.ExecutionStatusImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getExecutionStatus()
		 * @generated
		 */
		EClass EXECUTION_STATUS = eINSTANCE.getExecutionStatus();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_STATUS__MESSAGE = eINSTANCE.getExecutionStatus_Message();

		/**
		 * The meta object literal for the '<em><b>Progress</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_STATUS__PROGRESS = eINSTANCE.getExecutionStatus_Progress();

		/**
		 * The meta object literal for the '<em><b>Status Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_STATUS__STATUS_KIND = eINSTANCE.getExecutionStatus_StatusKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.AssertionFocusImpl <em>Assertion Focus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.AssertionFocusImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getAssertionFocus()
		 * @generated
		 */
		EClass ASSERTION_FOCUS = eINSTANCE.getAssertionFocus();

		/**
		 * The meta object literal for the '<em><b>Point Fixed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERTION_FOCUS__POINT_FIXED = eINSTANCE.getAssertionFocus_PointFixed();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERTION_FOCUS__ELEMENT = eINSTANCE.getAssertionFocus_Element();

		/**
		 * The meta object literal for the '<em><b>Image Capture</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERTION_FOCUS__IMAGE_CAPTURE = eINSTANCE.getAssertionFocus_ImageCapture();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getRawEvent()
		 * @generated
		 */
		EClass RAW_EVENT = eINSTANCE.getRawEvent();

		/**
		 * The meta object literal for the '<em><b>Widget</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__WIDGET = eINSTANCE.getRawEvent_Widget();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__TYPE = eINSTANCE.getRawEvent_Type();

		/**
		 * The meta object literal for the '<em><b>Detail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__DETAIL = eINSTANCE.getRawEvent_Detail();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__ITEM = eINSTANCE.getRawEvent_Item();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__INDEX = eINSTANCE.getRawEvent_Index();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__X = eINSTANCE.getRawEvent_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__Y = eINSTANCE.getRawEvent_Y();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__WIDTH = eINSTANCE.getRawEvent_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__HEIGHT = eINSTANCE.getRawEvent_Height();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__COUNT = eINSTANCE.getRawEvent_Count();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__TIME = eINSTANCE.getRawEvent_Time();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__BUTTON = eINSTANCE.getRawEvent_Button();

		/**
		 * The meta object literal for the '<em><b>Character</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__CHARACTER = eINSTANCE.getRawEvent_Character();

		/**
		 * The meta object literal for the '<em><b>Key Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__KEY_CODE = eINSTANCE.getRawEvent_KeyCode();

		/**
		 * The meta object literal for the '<em><b>State Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__STATE_MASK = eINSTANCE.getRawEvent_StateMask();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__START = eINSTANCE.getRawEvent_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__END = eINSTANCE.getRawEvent_End();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__TEXT = eINSTANCE.getRawEvent_Text();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__DATA = eINSTANCE.getRawEvent_Data();

		/**
		 * The meta object literal for the '<em><b>Native Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RAW_EVENT__NATIVE_EVENT = eINSTANCE.getRawEvent_NativeEvent();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.SetFeatureImpl <em>Set Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.SetFeatureImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getSetFeature()
		 * @generated
		 */
		EClass SET_FEATURE = eINSTANCE.getSetFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_FEATURE__NAME = eINSTANCE.getSetFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_FEATURE__VALUE = eINSTANCE.getSetFeature_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.ResetAssertSelectionImpl <em>Reset Assert Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.ResetAssertSelectionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getResetAssertSelection()
		 * @generated
		 */
		EClass RESET_ASSERT_SELECTION = eINSTANCE.getResetAssertSelection();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus <em>Response Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getResponseStatus()
		 * @generated
		 */
		EEnum RESPONSE_STATUS = eINSTANCE.getResponseStatus();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransferKind <em>Command Transfer Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransferKind
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getCommandTransferKind()
		 * @generated
		 */
		EEnum COMMAND_TRANSFER_KIND = eINSTANCE.getCommandTransferKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode <em>Tesla Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getTeslaMode()
		 * @generated
		 */
		EEnum TESLA_MODE = eINSTANCE.getTeslaMode();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteMode <em>Execute Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteMode
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getExecuteMode()
		 * @generated
		 */
		EEnum EXECUTE_MODE = eINSTANCE.getExecuteMode();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatusKind <em>Execution Status Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatusKind
		 * @see org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawPackageImpl#getExecutionStatusKind()
		 * @generated
		 */
		EEnum EXECUTION_STATUS_KIND = eINSTANCE.getExecutionStatusKind();

	}

} //RawPackage
