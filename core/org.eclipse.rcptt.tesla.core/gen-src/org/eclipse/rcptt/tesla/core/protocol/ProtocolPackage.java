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
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage;

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
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory
 * @model kind="package"
 * @generated
 */
public interface ProtocolPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "protocol";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/tesla/protocol";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.tesla.core.protocol";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProtocolPackage eINSTANCE = org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SelectDataImpl <em>Select Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SelectDataImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSelectData()
	 * @generated
	 */
	int SELECT_DATA = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_DATA__KIND = 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_DATA__PATTERN = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_DATA__PATH = 2;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_DATA__INDEX = 3;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_DATA__MULTIPLICITY = 4;

	/**
	 * The feature id for the '<em><b>After</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_DATA__AFTER = 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_DATA__PARENT = 6;

	/**
	 * The feature id for the '<em><b>Class Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_DATA__CLASS_PATTERN = 7;

	/**
	 * The feature id for the '<em><b>Indexes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_DATA__INDEXES = 8;

	/**
	 * The number of structural features of the '<em>Select Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_DATA_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.IMLSelectDataImpl <em>IML Select Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.IMLSelectDataImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getIMLSelectData()
	 * @generated
	 */
	int IML_SELECT_DATA = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IML_SELECT_DATA__KIND = SELECT_DATA__KIND;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IML_SELECT_DATA__PATTERN = SELECT_DATA__PATTERN;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IML_SELECT_DATA__PATH = SELECT_DATA__PATH;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IML_SELECT_DATA__INDEX = SELECT_DATA__INDEX;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IML_SELECT_DATA__MULTIPLICITY = SELECT_DATA__MULTIPLICITY;

	/**
	 * The feature id for the '<em><b>After</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IML_SELECT_DATA__AFTER = SELECT_DATA__AFTER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IML_SELECT_DATA__PARENT = SELECT_DATA__PARENT;

	/**
	 * The feature id for the '<em><b>Class Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IML_SELECT_DATA__CLASS_PATTERN = SELECT_DATA__CLASS_PATTERN;

	/**
	 * The feature id for the '<em><b>Indexes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IML_SELECT_DATA__INDEXES = SELECT_DATA__INDEXES;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IML_SELECT_DATA__IMAGE = SELECT_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IML Select Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IML_SELECT_DATA_FEATURE_COUNT = SELECT_DATA_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SelectCommandImpl <em>Select Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SelectCommandImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSelectCommand()
	 * @generated
	 */
	int SELECT_COMMAND = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_COMMAND__ID = RawPackage.COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_COMMAND__DATA = RawPackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contain Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_COMMAND__CONTAIN_CHILDREN = RawPackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Select Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_COMMAND_FEATURE_COUNT = RawPackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SelectResponseImpl <em>Select Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SelectResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSelectResponse()
	 * @generated
	 */
	int SELECT_RESPONSE = 3;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_RESPONSE__ELEMENTS = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Select Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.ElementCommand <em>Element Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.ElementCommand
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getElementCommand()
	 * @generated
	 */
	int ELEMENT_COMMAND = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_COMMAND__ID = RawPackage.COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_COMMAND__ELEMENT = RawPackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Element Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_COMMAND_FEATURE_COUNT = RawPackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickImpl <em>Click</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ClickImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getClick()
	 * @generated
	 */
	int CLICK = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK__DEFAULT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>With Wait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK__WITH_WAIT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Arrow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK__ARROW = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Click</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.DoubleClickImpl <em>Double Click</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.DoubleClickImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getDoubleClick()
	 * @generated
	 */
	int DOUBLE_CLICK = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>With Wait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK__WITH_WAIT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Click</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ShowImpl <em>Show</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ShowImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getShow()
	 * @generated
	 */
	int SHOW = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Show</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.HideImpl <em>Hide</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.HideImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getHide()
	 * @generated
	 */
	int HIDE = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDE__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDE__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Hide</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDE_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CloseImpl <em>Close</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CloseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getClose()
	 * @generated
	 */
	int CLOSE = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Close</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetTextImpl <em>Get Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetTextImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetText()
	 * @generated
	 */
	int GET_TEXT = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Get Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetTextResponseImpl <em>Get Text Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetTextResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetTextResponse()
	 * @generated
	 */
	int GET_TEXT_RESPONSE = 11;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_RESPONSE__TEXT = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Text Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.BooleanResponseImpl <em>Boolean Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.BooleanResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getBooleanResponse()
	 * @generated
	 */
	int BOOLEAN_RESPONSE = 12;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_RESPONSE__RESULT = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.IsEnabledImpl <em>Is Enabled</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.IsEnabledImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getIsEnabled()
	 * @generated
	 */
	int IS_ENABLED = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_ENABLED__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_ENABLED__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Is Enabled</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_ENABLED_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.IsDisposedImpl <em>Is Disposed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.IsDisposedImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getIsDisposed()
	 * @generated
	 */
	int IS_DISPOSED = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_DISPOSED__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_DISPOSED__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Is Disposed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_DISPOSED_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextImpl <em>Set Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetTextImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetText()
	 * @generated
	 */
	int SET_TEXT = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT__VALUE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Select</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT__SELECT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetStateImpl <em>Get State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetStateImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetState()
	 * @generated
	 */
	int GET_STATE = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATE__ID = RawPackage.COMMAND__ID;

	/**
	 * The number of structural features of the '<em>Get State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATE_FEATURE_COUNT = RawPackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetStateResponseImpl <em>Get State Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetStateResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetStateResponse()
	 * @generated
	 */
	int GET_STATE_RESPONSE = 17;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATE_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATE_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATE_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATE_RESPONSE__STATE = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get State Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_STATE_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.WaitForStateImpl <em>Wait For State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.WaitForStateImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getWaitForState()
	 * @generated
	 */
	int WAIT_FOR_STATE = 18;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_STATE__ID = RawPackage.COMMAND__ID;

	/**
	 * The feature id for the '<em><b>State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_STATE__STATE = RawPackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Wait For State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_STATE_FEATURE_COUNT = RawPackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.RollbackToStateImpl <em>Rollback To State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.RollbackToStateImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getRollbackToState()
	 * @generated
	 */
	int ROLLBACK_TO_STATE = 19;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLLBACK_TO_STATE__ID = RawPackage.COMMAND__ID;

	/**
	 * The feature id for the '<em><b>State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLLBACK_TO_STATE__STATE = RawPackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rollback To State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLLBACK_TO_STATE_FEATURE_COUNT = RawPackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetSelectionImpl <em>Set Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetSelectionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetSelection()
	 * @generated
	 */
	int SET_SELECTION = 20;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION__PATH = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION__PATTERN = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION__INDEX = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Additional Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION__ADDITIONAL_ITEMS = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION__ALL = ELEMENT_COMMAND_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Set Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.MultiSelectionItemImpl <em>Multi Selection Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.MultiSelectionItemImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getMultiSelectionItem()
	 * @generated
	 */
	int MULTI_SELECTION_ITEM = 21;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SELECTION_ITEM__PATH = 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SELECTION_ITEM__PATTERN = 1;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SELECTION_ITEM__INDEX = 2;

	/**
	 * The number of structural features of the '<em>Multi Selection Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SELECTION_ITEM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ShutdownImpl <em>Shutdown</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ShutdownImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getShutdown()
	 * @generated
	 */
	int SHUTDOWN = 22;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN__ID = RawPackage.COMMAND__ID;

	/**
	 * The number of structural features of the '<em>Shutdown</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHUTDOWN_FEATURE_COUNT = RawPackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.NopImpl <em>Nop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.NopImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getNop()
	 * @generated
	 */
	int NOP = 23;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOP__ID = RawPackage.COMMAND__ID;

	/**
	 * The number of structural features of the '<em>Nop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOP_FEATURE_COUNT = RawPackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CountItemsImpl <em>Count Items</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CountItemsImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCountItems()
	 * @generated
	 */
	int COUNT_ITEMS = 24;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_ITEMS__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_ITEMS__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_ITEMS__PATH = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Count Items</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_ITEMS_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.IntResponseImpl <em>Int Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.IntResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getIntResponse()
	 * @generated
	 */
	int INT_RESPONSE = 25;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_RESPONSE__RESULT = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SaveImpl <em>Save</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SaveImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSave()
	 * @generated
	 */
	int SAVE = 26;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Save</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.IsDirtyImpl <em>Is Dirty</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.IsDirtyImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getIsDirty()
	 * @generated
	 */
	int IS_DIRTY = 27;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_DIRTY__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_DIRTY__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Is Dirty</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_DIRTY_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelectionImpl <em>Set Text Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelectionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetTextSelection()
	 * @generated
	 */
	int SET_TEXT_SELECTION = 28;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION__OFFSET = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION__LENGTH = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION__START_LINE = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Endline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION__ENDLINE = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Endoffset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION__ENDOFFSET = ELEMENT_COMMAND_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Set Text Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextOffsetImpl <em>Set Text Offset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetTextOffsetImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetTextOffset()
	 * @generated
	 */
	int SET_TEXT_OFFSET = 29;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_OFFSET__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_OFFSET__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_OFFSET__OFFSET = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_OFFSET__LINE = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Text Offset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_OFFSET_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ShowSelectionImpl <em>Show Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ShowSelectionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getShowSelection()
	 * @generated
	 */
	int SHOW_SELECTION = 30;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_SELECTION__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_SELECTION__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Show Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_SELECTION_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetTextSelectionImpl <em>Get Text Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetTextSelectionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetTextSelection()
	 * @generated
	 */
	int GET_TEXT_SELECTION = 31;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_SELECTION__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_SELECTION__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Get Text Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_SELECTION_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GoToTextLineImpl <em>Go To Text Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GoToTextLineImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGoToTextLine()
	 * @generated
	 */
	int GO_TO_TEXT_LINE = 32;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GO_TO_TEXT_LINE__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GO_TO_TEXT_LINE__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GO_TO_TEXT_LINE__LINE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Go To Text Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GO_TO_TEXT_LINE_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetTextLineOffsetImpl <em>Get Text Line Offset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetTextLineOffsetImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetTextLineOffset()
	 * @generated
	 */
	int GET_TEXT_LINE_OFFSET = 33;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_LINE_OFFSET__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_LINE_OFFSET__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_LINE_OFFSET__LINE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Text Line Offset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_LINE_OFFSET_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetTextLineLengthImpl <em>Get Text Line Length</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetTextLineLengthImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetTextLineLength()
	 * @generated
	 */
	int GET_TEXT_LINE_LENGTH = 34;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_LINE_LENGTH__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_LINE_LENGTH__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_LINE_LENGTH__LINE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Text Line Length</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_LINE_LENGTH_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SelectTextLineImpl <em>Select Text Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SelectTextLineImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSelectTextLine()
	 * @generated
	 */
	int SELECT_TEXT_LINE = 35;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_TEXT_LINE__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_TEXT_LINE__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_TEXT_LINE__LINE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Select Text Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_TEXT_LINE_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetCaretPositionImpl <em>Set Caret Position</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetCaretPositionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetCaretPosition()
	 * @generated
	 */
	int SET_CARET_POSITION = 36;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CARET_POSITION__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CARET_POSITION__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CARET_POSITION__OFFSET = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Caret Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CARET_POSITION_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetTextLineImpl <em>Get Text Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetTextLineImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetTextLine()
	 * @generated
	 */
	int GET_TEXT_LINE = 37;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_LINE__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_LINE__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_LINE__LINE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Text Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_LINE_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetTextRangeImpl <em>Get Text Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetTextRangeImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetTextRange()
	 * @generated
	 */
	int GET_TEXT_RANGE = 38;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_RANGE__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_RANGE__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_RANGE__START_OFFSET = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_RANGE__END_OFFSET = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Get Text Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TEXT_RANGE_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.TextSelectionResponseImpl <em>Text Selection Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.TextSelectionResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getTextSelectionResponse()
	 * @generated
	 */
	int TEXT_SELECTION_RESPONSE = 39;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTION_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTION_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTION_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTION_RESPONSE__X = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTION_RESPONSE__Y = RawPackage.RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTION_RESPONSE__TEXT = RawPackage.RESPONSE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Text Selection Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SELECTION_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetColorImpl <em>Get Color</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetColorImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetColor()
	 * @generated
	 */
	int GET_COLOR = 40;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Get Color</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetColorImpl <em>Set Color</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetColorImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetColor()
	 * @generated
	 */
	int SET_COLOR = 41;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COLOR__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COLOR__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COLOR__COLOR = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Color</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COLOR_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetColorResponseImpl <em>Get Color Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetColorResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetColorResponse()
	 * @generated
	 */
	int GET_COLOR_RESPONSE = 42;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR_RESPONSE__COLOR = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Color Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_COLOR_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.TypeTextImpl <em>Type Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.TypeTextImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getTypeText()
	 * @generated
	 */
	int TYPE_TEXT = 43;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEXT__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEXT__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEXT__STATE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEXT__TEXT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>From Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEXT__FROM_DISPLAY = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Type Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEXT_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ChildrenImpl <em>Children</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ChildrenImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getChildren()
	 * @generated
	 */
	int CHILDREN = 44;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILDREN__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILDREN__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Children</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILDREN_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ChildrenResponseImpl <em>Children Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ChildrenResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getChildrenResponse()
	 * @generated
	 */
	int CHILDREN_RESPONSE = 45;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILDREN_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILDREN_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILDREN_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILDREN_RESPONSE__CHILDREN = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Children Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILDREN_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ParentImpl <em>Parent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ParentImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getParent()
	 * @generated
	 */
	int PARENT = 46;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Parent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ParentResponseImpl <em>Parent Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ParentResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getParentResponse()
	 * @generated
	 */
	int PARENT_RESPONSE = 47;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_RESPONSE__PARENT = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parent Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.TypeImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 48;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__STATE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__CODE = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>From Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__FROM_DISPLAY = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Character</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__CHARACTER = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Meta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__META = ELEMENT_COMMAND_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Traverse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__TRAVERSE = ELEMENT_COMMAND_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Times</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__TIMES = ELEMENT_COMMAND_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.TypeActionImpl <em>Type Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.TypeActionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getTypeAction()
	 * @generated
	 */
	int TYPE_ACTION = 49;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ACTION__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ACTION__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Action Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ACTION__ACTION_ID = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ACTION_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CopyTextSelectionImpl <em>Copy Text Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CopyTextSelectionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCopyTextSelection()
	 * @generated
	 */
	int COPY_TEXT_SELECTION = 50;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_TEXT_SELECTION__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_TEXT_SELECTION__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Copy Text Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_TEXT_SELECTION_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CutTextSelectionImpl <em>Cut Text Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CutTextSelectionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCutTextSelection()
	 * @generated
	 */
	int CUT_TEXT_SELECTION = 51;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUT_TEXT_SELECTION__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUT_TEXT_SELECTION__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Cut Text Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUT_TEXT_SELECTION_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.PasteTextSelectionImpl <em>Paste Text Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.PasteTextSelectionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getPasteTextSelection()
	 * @generated
	 */
	int PASTE_TEXT_SELECTION = 52;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASTE_TEXT_SELECTION__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASTE_TEXT_SELECTION__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Paste Text Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASTE_TEXT_SELECTION_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ReplaceTextSelectionImpl <em>Replace Text Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ReplaceTextSelectionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getReplaceTextSelection()
	 * @generated
	 */
	int REPLACE_TEXT_SELECTION = 53;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_TEXT_SELECTION__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_TEXT_SELECTION__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_TEXT_SELECTION__TEXT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Replace Text Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_TEXT_SELECTION_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CheckItemImpl <em>Check Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CheckItemImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCheckItem()
	 * @generated
	 */
	int CHECK_ITEM = 54;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ITEM__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ITEM__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ITEM__PATH = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ITEM__PATTERN = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ITEM__INDEX = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ITEM__STATE = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Check Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ITEM_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ExpandImpl <em>Expand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ExpandImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getExpand()
	 * @generated
	 */
	int EXPAND = 55;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Expand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CloseWorkbenchImpl <em>Close Workbench</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CloseWorkbenchImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCloseWorkbench()
	 * @generated
	 */
	int CLOSE_WORKBENCH = 56;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_WORKBENCH__ID = RawPackage.COMMAND__ID;

	/**
	 * The number of structural features of the '<em>Close Workbench</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSE_WORKBENCH_FEATURE_COUNT = RawPackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ActivateCellEditorImpl <em>Activate Cell Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ActivateCellEditorImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getActivateCellEditor()
	 * @generated
	 */
	int ACTIVATE_CELL_EDITOR = 57;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_CELL_EDITOR__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_CELL_EDITOR__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_CELL_EDITOR__PATH = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_CELL_EDITOR__PATTERN = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_CELL_EDITOR__INDEX = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_CELL_EDITOR__COLUMN = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Activate Cell Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_CELL_EDITOR_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ApplyCellEditorImpl <em>Apply Cell Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ApplyCellEditorImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getApplyCellEditor()
	 * @generated
	 */
	int APPLY_CELL_EDITOR = 58;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_CELL_EDITOR__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_CELL_EDITOR__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Deactivate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_CELL_EDITOR__DEACTIVATE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_CELL_EDITOR__COLUMN = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Apply Cell Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLY_CELL_EDITOR_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CancelCellEditorImpl <em>Cancel Cell Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CancelCellEditorImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCancelCellEditor()
	 * @generated
	 */
	int CANCEL_CELL_EDITOR = 59;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_CELL_EDITOR__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_CELL_EDITOR__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Cancel Cell Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_CELL_EDITOR_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.DeactivateCellEditorImpl <em>Deactivate Cell Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.DeactivateCellEditorImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getDeactivateCellEditor()
	 * @generated
	 */
	int DEACTIVATE_CELL_EDITOR = 60;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEACTIVATE_CELL_EDITOR__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEACTIVATE_CELL_EDITOR__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Deactivate Cell Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEACTIVATE_CELL_EDITOR_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetSWTDialogInfoImpl <em>Set SWT Dialog Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetSWTDialogInfoImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetSWTDialogInfo()
	 * @generated
	 */
	int SET_SWT_DIALOG_INFO = 61;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SWT_DIALOG_INFO__ID = RawPackage.COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SWT_DIALOG_INFO__KIND = RawPackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SWT_DIALOG_INFO__PATH = RawPackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set SWT Dialog Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SWT_DIALOG_INFO_FEATURE_COUNT = RawPackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.AssertImpl <em>Assert</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.AssertImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getAssert()
	 * @generated
	 */
	int ASSERT = 62;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT__ID = RawPackage.COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT__ELEMENT = RawPackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT__ATTRIBUTE = RawPackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT__VALUE = RawPackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT__KIND = RawPackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT__INDEX = RawPackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT__CATEGORY = RawPackage.COMMAND_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT__VALUE_TYPE = RawPackage.COMMAND_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Image Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT__IMAGE_DATA = RawPackage.COMMAND_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Show Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT__SHOW_INDEX = RawPackage.COMMAND_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Assert</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_FEATURE_COUNT = RawPackage.COMMAND_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetRegionTextImpl <em>Get Region Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetRegionTextImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetRegionText()
	 * @generated
	 */
	int GET_REGION_TEXT = 63;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__X = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__Y = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__SX = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__SY = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__WIDTH = ELEMENT_COMMAND_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT__HEIGHT = ELEMENT_COMMAND_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Get Region Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_REGION_TEXT_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.AssertImageDataImpl <em>Assert Image Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.AssertImageDataImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getAssertImageData()
	 * @generated
	 */
	int ASSERT_IMAGE_DATA = 64;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_IMAGE_DATA__IMAGE = 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_IMAGE_DATA__X = 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_IMAGE_DATA__Y = 2;

	/**
	 * The feature id for the '<em><b>Sx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_IMAGE_DATA__SX = 3;

	/**
	 * The feature id for the '<em><b>Sy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_IMAGE_DATA__SY = 4;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_IMAGE_DATA__WIDTH = 5;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_IMAGE_DATA__HEIGHT = 6;

	/**
	 * The number of structural features of the '<em>Assert Image Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_IMAGE_DATA_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.AssertResponseImpl <em>Assert Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.AssertResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getAssertResponse()
	 * @generated
	 */
	int ASSERT_RESPONSE = 65;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The number of structural features of the '<em>Assert Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetSelectionImpl <em>Get Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetSelectionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetSelection()
	 * @generated
	 */
	int GET_SELECTION = 66;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SELECTION__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SELECTION__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Get Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SELECTION_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SelectionResponseImpl <em>Selection Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SelectionResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSelectionResponse()
	 * @generated
	 */
	int SELECTION_RESPONSE = 67;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_RESPONSE__VALUES = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Selection Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SelectionItemImpl <em>Selection Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SelectionItemImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSelectionItem()
	 * @generated
	 */
	int SELECTION_ITEM = 68;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_ITEM__TEXT = 0;

	/**
	 * The number of structural features of the '<em>Selection Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_ITEM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.DragCommandImpl <em>Drag Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.DragCommandImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getDragCommand()
	 * @generated
	 */
	int DRAG_COMMAND = 69;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_COMMAND__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_COMMAND__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_COMMAND__KIND = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_COMMAND__X = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_COMMAND__Y = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_COMMAND__STYLE = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Drag Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAG_COMMAND_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.WaitForRestartImpl <em>Wait For Restart</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.WaitForRestartImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getWaitForRestart()
	 * @generated
	 */
	int WAIT_FOR_RESTART = 70;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_RESTART__ID = RawPackage.COMMAND__ID;

	/**
	 * The number of structural features of the '<em>Wait For Restart</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_FOR_RESTART_FEATURE_COUNT = RawPackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CellClickImpl <em>Cell Click</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CellClickImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCellClick()
	 * @generated
	 */
	int CELL_CLICK = 71;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_CLICK__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_CLICK__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_CLICK__COLUMN = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cell Click</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_CLICK_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ShowContentAssistImpl <em>Show Content Assist</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ShowContentAssistImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getShowContentAssist()
	 * @generated
	 */
	int SHOW_CONTENT_ASSIST = 72;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_CONTENT_ASSIST__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_CONTENT_ASSIST__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Show Content Assist</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_CONTENT_ASSIST_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickAboutMenuImpl <em>Click About Menu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ClickAboutMenuImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getClickAboutMenu()
	 * @generated
	 */
	int CLICK_ABOUT_MENU = 73;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_ABOUT_MENU__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_ABOUT_MENU__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Click About Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_ABOUT_MENU_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickPreferencesMenuImpl <em>Click Preferences Menu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ClickPreferencesMenuImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getClickPreferencesMenu()
	 * @generated
	 */
	int CLICK_PREFERENCES_MENU = 74;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_PREFERENCES_MENU__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_PREFERENCES_MENU__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Click Preferences Menu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_PREFERENCES_MENU_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.RecordingModeRequestImpl <em>Recording Mode Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.RecordingModeRequestImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getRecordingModeRequest()
	 * @generated
	 */
	int RECORDING_MODE_REQUEST = 75;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORDING_MODE_REQUEST__ID = RawPackage.COMMAND__ID;

	/**
	 * The number of structural features of the '<em>Recording Mode Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORDING_MODE_REQUEST_FEATURE_COUNT = RawPackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.AssertionModeRequestImpl <em>Assertion Mode Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.AssertionModeRequestImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getAssertionModeRequest()
	 * @generated
	 */
	int ASSERTION_MODE_REQUEST = 76;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION_MODE_REQUEST__ID = RawPackage.COMMAND__ID;

	/**
	 * The number of structural features of the '<em>Assertion Mode Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION_MODE_REQUEST_FEATURE_COUNT = RawPackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.MinimizeImpl <em>Minimize</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.MinimizeImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getMinimize()
	 * @generated
	 */
	int MINIMIZE = 77;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINIMIZE__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINIMIZE__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Minimize</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINIMIZE_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.MaximizeImpl <em>Maximize</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.MaximizeImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getMaximize()
	 * @generated
	 */
	int MAXIMIZE = 78;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAXIMIZE__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAXIMIZE__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Maximize</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAXIMIZE_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.RestoreImpl <em>Restore</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.RestoreImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getRestore()
	 * @generated
	 */
	int RESTORE = 79;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTORE__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTORE__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Restore</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTORE_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ShowTabListImpl <em>Show Tab List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ShowTabListImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getShowTabList()
	 * @generated
	 */
	int SHOW_TAB_LIST = 80;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_TAB_LIST__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_TAB_LIST__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Show Tab List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_TAB_LIST_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetStatusDialogModeImpl <em>Set Status Dialog Mode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetStatusDialogModeImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetStatusDialogMode()
	 * @generated
	 */
	int SET_STATUS_DIALOG_MODE = 81;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATUS_DIALOG_MODE__ID = RawPackage.COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATUS_DIALOG_MODE__ENABLED = RawPackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Status Dialog Mode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATUS_DIALOG_MODE_FEATURE_COUNT = RawPackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CheckImpl <em>Check</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CheckImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCheck()
	 * @generated
	 */
	int CHECK = 82;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__STATE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Check</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.HoverAtTextOffsetImpl <em>Hover At Text Offset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.HoverAtTextOffsetImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getHoverAtTextOffset()
	 * @generated
	 */
	int HOVER_AT_TEXT_OFFSET = 83;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT_OFFSET__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT_OFFSET__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT_OFFSET__OFFSET = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT_OFFSET__LINE = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Hover At Text Offset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT_OFFSET_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetCursorOffsetImpl <em>Set Cursor Offset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetCursorOffsetImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetCursorOffset()
	 * @generated
	 */
	int SET_CURSOR_OFFSET = 84;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CURSOR_OFFSET__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CURSOR_OFFSET__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CURSOR_OFFSET__LINE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CURSOR_OFFSET__OFFSET = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Cursor Offset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_CURSOR_OFFSET_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelection2Impl <em>Set Text Selection2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelection2Impl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetTextSelection2()
	 * @generated
	 */
	int SET_TEXT_SELECTION2 = 85;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION2__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION2__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION2__START_LINE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION2__START_OFFSET = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION2__END_LINE = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION2__END_OFFSET = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Block Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION2__BLOCK_MODE = ELEMENT_COMMAND_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Set Text Selection2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TEXT_SELECTION2_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.HoverAtTextImpl <em>Hover At Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.HoverAtTextImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getHoverAtText()
	 * @generated
	 */
	int HOVER_AT_TEXT = 86;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT__LINE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT__OFFSET = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT__STATE_MASK = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Hover At Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HOVER_AT_TEXT_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.OpenDeclarationImpl <em>Open Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.OpenDeclarationImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getOpenDeclaration()
	 * @generated
	 */
	int OPEN_DECLARATION = 87;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_DECLARATION__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_DECLARATION__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Open Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_DECLARATION_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.RulerClickImpl <em>Ruler Click</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.RulerClickImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getRulerClick()
	 * @generated
	 */
	int RULER_CLICK = 88;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_CLICK__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_CLICK__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_CLICK__LINE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_CLICK__BUTTON = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_CLICK__STATE_MASK = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Ruler Click</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_CLICK_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.RulerDoubleClickImpl <em>Ruler Double Click</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.RulerDoubleClickImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getRulerDoubleClick()
	 * @generated
	 */
	int RULER_DOUBLE_CLICK = 89;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_DOUBLE_CLICK__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_DOUBLE_CLICK__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_DOUBLE_CLICK__LINE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_DOUBLE_CLICK__BUTTON = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_DOUBLE_CLICK__STATE_MASK = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Ruler Double Click</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_DOUBLE_CLICK_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.RulerHoverImpl <em>Ruler Hover</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.RulerHoverImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getRulerHover()
	 * @generated
	 */
	int RULER_HOVER = 90;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_HOVER__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_HOVER__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_HOVER__LINE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>State Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_HOVER__STATE_MASK = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ruler Hover</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULER_HOVER_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickLinkImpl <em>Click Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ClickLinkImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getClickLink()
	 * @generated
	 */
	int CLICK_LINK = 91;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_LINK__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_LINK__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_LINK__REF = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Click Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_LINK_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetFocusImpl <em>Set Focus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetFocusImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetFocus()
	 * @generated
	 */
	int SET_FOCUS = 92;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FOCUS__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FOCUS__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FOCUS__VALUE = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Focus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FOCUS_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetPropertyValueImpl <em>Get Property Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetPropertyValueImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetPropertyValue()
	 * @generated
	 */
	int GET_PROPERTY_VALUE = 93;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_VALUE__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_VALUE__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_VALUE__NAME = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_VALUE__INDEX = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Allow Raw Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_VALUE__ALLOW_RAW_VALUES = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Get Property Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PROPERTY_VALUE_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ObjectResponseImpl <em>Object Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ObjectResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getObjectResponse()
	 * @generated
	 */
	int OBJECT_RESPONSE = 94;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESPONSE__RESULT = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetBoundsImpl <em>Get Bounds</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetBoundsImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetBounds()
	 * @generated
	 */
	int GET_BOUNDS = 95;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BOUNDS__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BOUNDS__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Get Bounds</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_BOUNDS_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.BoundsResponseImpl <em>Bounds Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.BoundsResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getBoundsResponse()
	 * @generated
	 */
	int BOUNDS_RESPONSE = 96;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDS_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDS_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDS_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDS_RESPONSE__X = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDS_RESPONSE__Y = RawPackage.RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDS_RESPONSE__WIDTH = RawPackage.RESPONSE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDS_RESPONSE__HEIGHT = RawPackage.RESPONSE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Bounds Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDS_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CollapseImpl <em>Collapse</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CollapseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCollapse()
	 * @generated
	 */
	int COLLAPSE = 97;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLAPSE__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLAPSE__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Collapse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLAPSE_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickColumnImpl <em>Click Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ClickColumnImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getClickColumn()
	 * @generated
	 */
	int CLICK_COLUMN = 98;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_COLUMN__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_COLUMN__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_COLUMN__NAME = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_COLUMN__INDEX = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Click Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_COLUMN_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetSortColumnImpl <em>Set Sort Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetSortColumnImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetSortColumn()
	 * @generated
	 */
	int SET_SORT_COLUMN = 99;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SORT_COLUMN__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SORT_COLUMN__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SORT_COLUMN__NAME = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SORT_COLUMN__INDEX = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Descending</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SORT_COLUMN__DESCENDING = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Set Sort Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SORT_COLUMN_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.MouseEventImpl <em>Mouse Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.MouseEventImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getMouseEvent()
	 * @generated
	 */
	int MOUSE_EVENT = 100;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_EVENT__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_EVENT__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_EVENT__KIND = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_EVENT__BUTTON = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_EVENT__STATE_MASK = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_EVENT__COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_EVENT__X = ELEMENT_COMMAND_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_EVENT__Y = ELEMENT_COMMAND_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Mouse Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_EVENT_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickTextImpl <em>Click Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ClickTextImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getClickText()
	 * @generated
	 */
	int CLICK_TEXT = 101;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_TEXT__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_TEXT__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_TEXT__START = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_TEXT__END = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_TEXT__BUTTON = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Click Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLICK_TEXT_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.DoubleClickTextImpl <em>Double Click Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.DoubleClickTextImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getDoubleClickText()
	 * @generated
	 */
	int DOUBLE_CLICK_TEXT = 102;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_TEXT__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_TEXT__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_TEXT__POSITION = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_TEXT__BUTTON = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Double Click Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CLICK_TEXT_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetWidthImpl <em>Set Width</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetWidthImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetWidth()
	 * @generated
	 */
	int SET_WIDTH = 103;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_WIDTH__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_WIDTH__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_WIDTH__WIDTH = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Width</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_WIDTH_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetPositionImpl <em>Set Position</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetPositionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetPosition()
	 * @generated
	 */
	int SET_POSITION = 104;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_POSITION__ID = ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_POSITION__ELEMENT = ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_POSITION__INDEX = ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_POSITION_FEATURE_COUNT = ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.SWTDialogKind <em>SWT Dialog Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.SWTDialogKind
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSWTDialogKind()
	 * @generated
	 */
	int SWT_DIALOG_KIND = 105;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.AssertKind <em>Assert Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertKind
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getAssertKind()
	 * @generated
	 */
	int ASSERT_KIND = 106;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.DragKind <em>Drag Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.DragKind
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getDragKind()
	 * @generated
	 */
	int DRAG_KIND = 107;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.MouseEventKind <em>Mouse Event Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.MouseEventKind
	 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getMouseEventKind()
	 * @generated
	 */
	int MOUSE_EVENT_KIND = 108;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData <em>Select Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select Data</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectData
	 * @generated
	 */
	EClass getSelectData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectData#getKind()
	 * @see #getSelectData()
	 * @generated
	 */
	EAttribute getSelectData_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectData#getPattern()
	 * @see #getSelectData()
	 * @generated
	 */
	EAttribute getSelectData_Pattern();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectData#getPath()
	 * @see #getSelectData()
	 * @generated
	 */
	EAttribute getSelectData_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectData#getIndex()
	 * @see #getSelectData()
	 * @generated
	 */
	EAttribute getSelectData_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectData#getMultiplicity()
	 * @see #getSelectData()
	 * @generated
	 */
	EAttribute getSelectData_Multiplicity();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getAfter <em>After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>After</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectData#getAfter()
	 * @see #getSelectData()
	 * @generated
	 */
	EReference getSelectData_After();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parent</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectData#getParent()
	 * @see #getSelectData()
	 * @generated
	 */
	EReference getSelectData_Parent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getClassPattern <em>Class Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Pattern</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectData#getClassPattern()
	 * @see #getSelectData()
	 * @generated
	 */
	EAttribute getSelectData_ClassPattern();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getIndexes <em>Indexes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Indexes</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectData#getIndexes()
	 * @see #getSelectData()
	 * @generated
	 */
	EAttribute getSelectData_Indexes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.IMLSelectData <em>IML Select Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IML Select Data</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.IMLSelectData
	 * @generated
	 */
	EClass getIMLSelectData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.IMLSelectData#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.IMLSelectData#getImage()
	 * @see #getIMLSelectData()
	 * @generated
	 */
	EAttribute getIMLSelectData_Image();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SelectCommand <em>Select Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select Command</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectCommand
	 * @generated
	 */
	EClass getSelectCommand();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.protocol.SelectCommand#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectCommand#getData()
	 * @see #getSelectCommand()
	 * @generated
	 */
	EReference getSelectCommand_Data();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.SelectCommand#getContainChildren <em>Contain Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contain Children</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectCommand#getContainChildren()
	 * @see #getSelectCommand()
	 * @generated
	 */
	EReference getSelectCommand_ContainChildren();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SelectResponse <em>Select Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectResponse
	 * @generated
	 */
	EClass getSelectResponse();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.SelectResponse#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectResponse#getElements()
	 * @see #getSelectResponse()
	 * @generated
	 */
	EReference getSelectResponse_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.ElementCommand <em>Element Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Command</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ElementCommand
	 * @generated
	 */
	EClass getElementCommand();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.protocol.ElementCommand#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ElementCommand#getElement()
	 * @see #getElementCommand()
	 * @generated
	 */
	EReference getElementCommand_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Click <em>Click</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Click</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Click
	 * @generated
	 */
	EClass getClick();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Click#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Click#isDefault()
	 * @see #getClick()
	 * @generated
	 */
	EAttribute getClick_Default();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Click#isWithWait <em>With Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With Wait</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Click#isWithWait()
	 * @see #getClick()
	 * @generated
	 */
	EAttribute getClick_WithWait();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Click#isArrow <em>Arrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arrow</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Click#isArrow()
	 * @see #getClick()
	 * @generated
	 */
	EAttribute getClick_Arrow();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.DoubleClick <em>Double Click</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Click</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DoubleClick
	 * @generated
	 */
	EClass getDoubleClick();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.DoubleClick#isWithWait <em>With Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With Wait</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DoubleClick#isWithWait()
	 * @see #getDoubleClick()
	 * @generated
	 */
	EAttribute getDoubleClick_WithWait();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Show <em>Show</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Show</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Show
	 * @generated
	 */
	EClass getShow();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Hide <em>Hide</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hide</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Hide
	 * @generated
	 */
	EClass getHide();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Close <em>Close</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Close</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Close
	 * @generated
	 */
	EClass getClose();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GetText <em>Get Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetText
	 * @generated
	 */
	EClass getGetText();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextResponse <em>Get Text Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Text Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextResponse
	 * @generated
	 */
	EClass getGetTextResponse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextResponse#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextResponse#getText()
	 * @see #getGetTextResponse()
	 * @generated
	 */
	EAttribute getGetTextResponse_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.BooleanResponse <em>Boolean Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.BooleanResponse
	 * @generated
	 */
	EClass getBooleanResponse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.BooleanResponse#isResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.BooleanResponse#isResult()
	 * @see #getBooleanResponse()
	 * @generated
	 */
	EAttribute getBooleanResponse_Result();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.IsEnabled <em>Is Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Enabled</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.IsEnabled
	 * @generated
	 */
	EClass getIsEnabled();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.IsDisposed <em>Is Disposed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Disposed</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.IsDisposed
	 * @generated
	 */
	EClass getIsDisposed();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SetText <em>Set Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetText
	 * @generated
	 */
	EClass getSetText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetText#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetText#getValue()
	 * @see #getSetText()
	 * @generated
	 */
	EAttribute getSetText_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetText#isSelect <em>Select</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Select</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetText#isSelect()
	 * @see #getSetText()
	 * @generated
	 */
	EAttribute getSetText_Select();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GetState <em>Get State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get State</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetState
	 * @generated
	 */
	EClass getGetState();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GetStateResponse <em>Get State Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get State Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetStateResponse
	 * @generated
	 */
	EClass getGetStateResponse();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.protocol.GetStateResponse#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetStateResponse#getState()
	 * @see #getGetStateResponse()
	 * @generated
	 */
	EReference getGetStateResponse_State();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.WaitForState <em>Wait For State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait For State</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.WaitForState
	 * @generated
	 */
	EClass getWaitForState();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.protocol.WaitForState#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.WaitForState#getState()
	 * @see #getWaitForState()
	 * @generated
	 */
	EReference getWaitForState_State();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.RollbackToState <em>Rollback To State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rollback To State</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RollbackToState
	 * @generated
	 */
	EClass getRollbackToState();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.protocol.RollbackToState#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RollbackToState#getState()
	 * @see #getRollbackToState()
	 * @generated
	 */
	EReference getRollbackToState_State();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SetSelection <em>Set Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSelection
	 * @generated
	 */
	EClass getSetSelection();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.SetSelection#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSelection#getPath()
	 * @see #getSetSelection()
	 * @generated
	 */
	EAttribute getSetSelection_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetSelection#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSelection#getPattern()
	 * @see #getSetSelection()
	 * @generated
	 */
	EAttribute getSetSelection_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetSelection#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSelection#getIndex()
	 * @see #getSetSelection()
	 * @generated
	 */
	EAttribute getSetSelection_Index();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.SetSelection#getAdditionalItems <em>Additional Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Additional Items</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSelection#getAdditionalItems()
	 * @see #getSetSelection()
	 * @generated
	 */
	EReference getSetSelection_AdditionalItems();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetSelection#isAll <em>All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>All</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSelection#isAll()
	 * @see #getSetSelection()
	 * @generated
	 */
	EAttribute getSetSelection_All();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem <em>Multi Selection Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Selection Item</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem
	 * @generated
	 */
	EClass getMultiSelectionItem();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem#getPath()
	 * @see #getMultiSelectionItem()
	 * @generated
	 */
	EAttribute getMultiSelectionItem_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem#getPattern()
	 * @see #getMultiSelectionItem()
	 * @generated
	 */
	EAttribute getMultiSelectionItem_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem#getIndex()
	 * @see #getMultiSelectionItem()
	 * @generated
	 */
	EAttribute getMultiSelectionItem_Index();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Shutdown <em>Shutdown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shutdown</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Shutdown
	 * @generated
	 */
	EClass getShutdown();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Nop <em>Nop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nop</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Nop
	 * @generated
	 */
	EClass getNop();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.CountItems <em>Count Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Count Items</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CountItems
	 * @generated
	 */
	EClass getCountItems();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.CountItems#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CountItems#getPath()
	 * @see #getCountItems()
	 * @generated
	 */
	EAttribute getCountItems_Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.IntResponse <em>Int Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.IntResponse
	 * @generated
	 */
	EClass getIntResponse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.IntResponse#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.IntResponse#getResult()
	 * @see #getIntResponse()
	 * @generated
	 */
	EAttribute getIntResponse_Result();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Save <em>Save</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Save</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Save
	 * @generated
	 */
	EClass getSave();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.IsDirty <em>Is Dirty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Dirty</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.IsDirty
	 * @generated
	 */
	EClass getIsDirty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection <em>Set Text Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Text Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextSelection
	 * @generated
	 */
	EClass getSetTextSelection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getOffset()
	 * @see #getSetTextSelection()
	 * @generated
	 */
	EAttribute getSetTextSelection_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getLength()
	 * @see #getSetTextSelection()
	 * @generated
	 */
	EAttribute getSetTextSelection_Length();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getStartLine <em>Start Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getStartLine()
	 * @see #getSetTextSelection()
	 * @generated
	 */
	EAttribute getSetTextSelection_StartLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getEndline <em>Endline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Endline</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getEndline()
	 * @see #getSetTextSelection()
	 * @generated
	 */
	EAttribute getSetTextSelection_Endline();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getEndoffset <em>Endoffset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Endoffset</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getEndoffset()
	 * @see #getSetTextSelection()
	 * @generated
	 */
	EAttribute getSetTextSelection_Endoffset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextOffset <em>Set Text Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Text Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextOffset
	 * @generated
	 */
	EClass getSetTextOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextOffset#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextOffset#getOffset()
	 * @see #getSetTextOffset()
	 * @generated
	 */
	EAttribute getSetTextOffset_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextOffset#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextOffset#getLine()
	 * @see #getSetTextOffset()
	 * @generated
	 */
	EAttribute getSetTextOffset_Line();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.ShowSelection <em>Show Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Show Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ShowSelection
	 * @generated
	 */
	EClass getShowSelection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextSelection <em>Get Text Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Text Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextSelection
	 * @generated
	 */
	EClass getGetTextSelection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GoToTextLine <em>Go To Text Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Go To Text Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GoToTextLine
	 * @generated
	 */
	EClass getGoToTextLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GoToTextLine#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GoToTextLine#getLine()
	 * @see #getGoToTextLine()
	 * @generated
	 */
	EAttribute getGoToTextLine_Line();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextLineOffset <em>Get Text Line Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Text Line Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextLineOffset
	 * @generated
	 */
	EClass getGetTextLineOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextLineOffset#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextLineOffset#getLine()
	 * @see #getGetTextLineOffset()
	 * @generated
	 */
	EAttribute getGetTextLineOffset_Line();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextLineLength <em>Get Text Line Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Text Line Length</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextLineLength
	 * @generated
	 */
	EClass getGetTextLineLength();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextLineLength#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextLineLength#getLine()
	 * @see #getGetTextLineLength()
	 * @generated
	 */
	EAttribute getGetTextLineLength_Line();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SelectTextLine <em>Select Text Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select Text Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectTextLine
	 * @generated
	 */
	EClass getSelectTextLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SelectTextLine#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectTextLine#getLine()
	 * @see #getSelectTextLine()
	 * @generated
	 */
	EAttribute getSelectTextLine_Line();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SetCaretPosition <em>Set Caret Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Caret Position</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetCaretPosition
	 * @generated
	 */
	EClass getSetCaretPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetCaretPosition#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetCaretPosition#getOffset()
	 * @see #getSetCaretPosition()
	 * @generated
	 */
	EAttribute getSetCaretPosition_Offset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextLine <em>Get Text Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Text Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextLine
	 * @generated
	 */
	EClass getGetTextLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextLine#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextLine#getLine()
	 * @see #getGetTextLine()
	 * @generated
	 */
	EAttribute getGetTextLine_Line();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextRange <em>Get Text Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Text Range</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextRange
	 * @generated
	 */
	EClass getGetTextRange();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextRange#getStartOffset <em>Start Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextRange#getStartOffset()
	 * @see #getGetTextRange()
	 * @generated
	 */
	EAttribute getGetTextRange_StartOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextRange#getEndOffset <em>End Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextRange#getEndOffset()
	 * @see #getGetTextRange()
	 * @generated
	 */
	EAttribute getGetTextRange_EndOffset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.TextSelectionResponse <em>Text Selection Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Selection Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.TextSelectionResponse
	 * @generated
	 */
	EClass getTextSelectionResponse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.TextSelectionResponse#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.TextSelectionResponse#getX()
	 * @see #getTextSelectionResponse()
	 * @generated
	 */
	EAttribute getTextSelectionResponse_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.TextSelectionResponse#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.TextSelectionResponse#getY()
	 * @see #getTextSelectionResponse()
	 * @generated
	 */
	EAttribute getTextSelectionResponse_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.TextSelectionResponse#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.TextSelectionResponse#getText()
	 * @see #getTextSelectionResponse()
	 * @generated
	 */
	EAttribute getTextSelectionResponse_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GetColor <em>Get Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetColor
	 * @generated
	 */
	EClass getGetColor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SetColor <em>Set Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetColor
	 * @generated
	 */
	EClass getSetColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetColor#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetColor#getColor()
	 * @see #getSetColor()
	 * @generated
	 */
	EAttribute getSetColor_Color();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GetColorResponse <em>Get Color Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Color Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetColorResponse
	 * @generated
	 */
	EClass getGetColorResponse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetColorResponse#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetColorResponse#getColor()
	 * @see #getGetColorResponse()
	 * @generated
	 */
	EAttribute getGetColorResponse_Color();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.TypeText <em>Type Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.TypeText
	 * @generated
	 */
	EClass getTypeText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.TypeText#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.TypeText#getState()
	 * @see #getTypeText()
	 * @generated
	 */
	EAttribute getTypeText_State();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.TypeText#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.TypeText#getText()
	 * @see #getTypeText()
	 * @generated
	 */
	EAttribute getTypeText_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.TypeText#isFromDisplay <em>From Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Display</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.TypeText#isFromDisplay()
	 * @see #getTypeText()
	 * @generated
	 */
	EAttribute getTypeText_FromDisplay();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Children <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Children</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Children
	 * @generated
	 */
	EClass getChildren();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.ChildrenResponse <em>Children Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Children Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ChildrenResponse
	 * @generated
	 */
	EClass getChildrenResponse();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.ChildrenResponse#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ChildrenResponse#getChildren()
	 * @see #getChildrenResponse()
	 * @generated
	 */
	EReference getChildrenResponse_Children();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Parent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parent</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Parent
	 * @generated
	 */
	EClass getParent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.ParentResponse <em>Parent Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parent Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ParentResponse
	 * @generated
	 */
	EClass getParentResponse();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.protocol.ParentResponse#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parent</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ParentResponse#getParent()
	 * @see #getParentResponse()
	 * @generated
	 */
	EReference getParentResponse_Parent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Type#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Type#getState()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_State();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Type#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Type#getCode()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Code();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Type#isFromDisplay <em>From Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Display</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Type#isFromDisplay()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_FromDisplay();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Type#getCharacter <em>Character</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Character</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Type#getCharacter()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Character();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Type#getMeta <em>Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Type#getMeta()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Meta();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Type#isTraverse <em>Traverse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Traverse</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Type#isTraverse()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Traverse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Type#getTimes <em>Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Times</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Type#getTimes()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Times();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.TypeAction <em>Type Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Action</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.TypeAction
	 * @generated
	 */
	EClass getTypeAction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.TypeAction#getActionId <em>Action Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Id</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.TypeAction#getActionId()
	 * @see #getTypeAction()
	 * @generated
	 */
	EAttribute getTypeAction_ActionId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.CopyTextSelection <em>Copy Text Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Copy Text Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CopyTextSelection
	 * @generated
	 */
	EClass getCopyTextSelection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.CutTextSelection <em>Cut Text Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cut Text Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CutTextSelection
	 * @generated
	 */
	EClass getCutTextSelection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.PasteTextSelection <em>Paste Text Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Paste Text Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.PasteTextSelection
	 * @generated
	 */
	EClass getPasteTextSelection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.ReplaceTextSelection <em>Replace Text Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replace Text Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ReplaceTextSelection
	 * @generated
	 */
	EClass getReplaceTextSelection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.ReplaceTextSelection#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ReplaceTextSelection#getText()
	 * @see #getReplaceTextSelection()
	 * @generated
	 */
	EAttribute getReplaceTextSelection_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.CheckItem <em>Check Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check Item</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CheckItem
	 * @generated
	 */
	EClass getCheckItem();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.CheckItem#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CheckItem#getPath()
	 * @see #getCheckItem()
	 * @generated
	 */
	EAttribute getCheckItem_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.CheckItem#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CheckItem#getPattern()
	 * @see #getCheckItem()
	 * @generated
	 */
	EAttribute getCheckItem_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.CheckItem#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CheckItem#getIndex()
	 * @see #getCheckItem()
	 * @generated
	 */
	EAttribute getCheckItem_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.CheckItem#isState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CheckItem#isState()
	 * @see #getCheckItem()
	 * @generated
	 */
	EAttribute getCheckItem_State();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Expand <em>Expand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expand</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Expand
	 * @generated
	 */
	EClass getExpand();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.CloseWorkbench <em>Close Workbench</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Close Workbench</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CloseWorkbench
	 * @generated
	 */
	EClass getCloseWorkbench();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor <em>Activate Cell Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activate Cell Editor</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor
	 * @generated
	 */
	EClass getActivateCellEditor();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getPath()
	 * @see #getActivateCellEditor()
	 * @generated
	 */
	EAttribute getActivateCellEditor_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getPattern()
	 * @see #getActivateCellEditor()
	 * @generated
	 */
	EAttribute getActivateCellEditor_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getIndex()
	 * @see #getActivateCellEditor()
	 * @generated
	 */
	EAttribute getActivateCellEditor_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getColumn()
	 * @see #getActivateCellEditor()
	 * @generated
	 */
	EAttribute getActivateCellEditor_Column();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor <em>Apply Cell Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Apply Cell Editor</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor
	 * @generated
	 */
	EClass getApplyCellEditor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor#isDeactivate <em>Deactivate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deactivate</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor#isDeactivate()
	 * @see #getApplyCellEditor()
	 * @generated
	 */
	EAttribute getApplyCellEditor_Deactivate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor#getColumn()
	 * @see #getApplyCellEditor()
	 * @generated
	 */
	EAttribute getApplyCellEditor_Column();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.CancelCellEditor <em>Cancel Cell Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cancel Cell Editor</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CancelCellEditor
	 * @generated
	 */
	EClass getCancelCellEditor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.DeactivateCellEditor <em>Deactivate Cell Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deactivate Cell Editor</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DeactivateCellEditor
	 * @generated
	 */
	EClass getDeactivateCellEditor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SetSWTDialogInfo <em>Set SWT Dialog Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set SWT Dialog Info</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSWTDialogInfo
	 * @generated
	 */
	EClass getSetSWTDialogInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetSWTDialogInfo#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSWTDialogInfo#getKind()
	 * @see #getSetSWTDialogInfo()
	 * @generated
	 */
	EAttribute getSetSWTDialogInfo_Kind();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.SetSWTDialogInfo#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSWTDialogInfo#getPath()
	 * @see #getSetSWTDialogInfo()
	 * @generated
	 */
	EAttribute getSetSWTDialogInfo_Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Assert <em>Assert</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assert</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Assert
	 * @generated
	 */
	EClass getAssert();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.protocol.Assert#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Assert#getElement()
	 * @see #getAssert()
	 * @generated
	 */
	EReference getAssert_Element();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Assert#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Assert#getAttribute()
	 * @see #getAssert()
	 * @generated
	 */
	EAttribute getAssert_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Assert#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Assert#getValue()
	 * @see #getAssert()
	 * @generated
	 */
	EAttribute getAssert_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Assert#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Assert#getKind()
	 * @see #getAssert()
	 * @generated
	 */
	EAttribute getAssert_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Assert#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Assert#getIndex()
	 * @see #getAssert()
	 * @generated
	 */
	EAttribute getAssert_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Assert#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Category</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Assert#getCategory()
	 * @see #getAssert()
	 * @generated
	 */
	EAttribute getAssert_Category();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.core.protocol.Assert#getValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value Type</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Assert#getValueType()
	 * @see #getAssert()
	 * @generated
	 */
	EReference getAssert_ValueType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.protocol.Assert#getImageData <em>Image Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Image Data</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Assert#getImageData()
	 * @see #getAssert()
	 * @generated
	 */
	EReference getAssert_ImageData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Assert#isShowIndex <em>Show Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Index</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Assert#isShowIndex()
	 * @see #getAssert()
	 * @generated
	 */
	EAttribute getAssert_ShowIndex();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GetRegionText <em>Get Region Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Region Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetRegionText
	 * @generated
	 */
	EClass getGetRegionText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetRegionText#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetRegionText#getX()
	 * @see #getGetRegionText()
	 * @generated
	 */
	EAttribute getGetRegionText_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetRegionText#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetRegionText#getY()
	 * @see #getGetRegionText()
	 * @generated
	 */
	EAttribute getGetRegionText_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetRegionText#getSx <em>Sx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sx</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetRegionText#getSx()
	 * @see #getGetRegionText()
	 * @generated
	 */
	EAttribute getGetRegionText_Sx();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetRegionText#getSy <em>Sy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sy</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetRegionText#getSy()
	 * @see #getGetRegionText()
	 * @generated
	 */
	EAttribute getGetRegionText_Sy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetRegionText#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetRegionText#getWidth()
	 * @see #getGetRegionText()
	 * @generated
	 */
	EAttribute getGetRegionText_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetRegionText#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetRegionText#getHeight()
	 * @see #getGetRegionText()
	 * @generated
	 */
	EAttribute getGetRegionText_Height();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.AssertImageData <em>Assert Image Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assert Image Data</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertImageData
	 * @generated
	 */
	EClass getAssertImageData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.AssertImageData#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertImageData#getImage()
	 * @see #getAssertImageData()
	 * @generated
	 */
	EAttribute getAssertImageData_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.AssertImageData#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertImageData#getX()
	 * @see #getAssertImageData()
	 * @generated
	 */
	EAttribute getAssertImageData_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.AssertImageData#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertImageData#getY()
	 * @see #getAssertImageData()
	 * @generated
	 */
	EAttribute getAssertImageData_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.AssertImageData#getSx <em>Sx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sx</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertImageData#getSx()
	 * @see #getAssertImageData()
	 * @generated
	 */
	EAttribute getAssertImageData_Sx();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.AssertImageData#getSy <em>Sy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sy</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertImageData#getSy()
	 * @see #getAssertImageData()
	 * @generated
	 */
	EAttribute getAssertImageData_Sy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.AssertImageData#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertImageData#getWidth()
	 * @see #getAssertImageData()
	 * @generated
	 */
	EAttribute getAssertImageData_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.AssertImageData#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertImageData#getHeight()
	 * @see #getAssertImageData()
	 * @generated
	 */
	EAttribute getAssertImageData_Height();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.AssertResponse <em>Assert Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assert Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertResponse
	 * @generated
	 */
	EClass getAssertResponse();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GetSelection <em>Get Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetSelection
	 * @generated
	 */
	EClass getGetSelection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SelectionResponse <em>Selection Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectionResponse
	 * @generated
	 */
	EClass getSelectionResponse();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.rcptt.tesla.core.protocol.SelectionResponse#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectionResponse#getValues()
	 * @see #getSelectionResponse()
	 * @generated
	 */
	EReference getSelectionResponse_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SelectionItem <em>Selection Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Item</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectionItem
	 * @generated
	 */
	EClass getSelectionItem();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.SelectionItem#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectionItem#getText()
	 * @see #getSelectionItem()
	 * @generated
	 */
	EAttribute getSelectionItem_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.DragCommand <em>Drag Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drag Command</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DragCommand
	 * @generated
	 */
	EClass getDragCommand();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.DragCommand#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DragCommand#getKind()
	 * @see #getDragCommand()
	 * @generated
	 */
	EAttribute getDragCommand_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.DragCommand#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DragCommand#getX()
	 * @see #getDragCommand()
	 * @generated
	 */
	EAttribute getDragCommand_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.DragCommand#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DragCommand#getY()
	 * @see #getDragCommand()
	 * @generated
	 */
	EAttribute getDragCommand_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.DragCommand#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DragCommand#getStyle()
	 * @see #getDragCommand()
	 * @generated
	 */
	EAttribute getDragCommand_Style();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.WaitForRestart <em>Wait For Restart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait For Restart</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.WaitForRestart
	 * @generated
	 */
	EClass getWaitForRestart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.CellClick <em>Cell Click</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cell Click</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CellClick
	 * @generated
	 */
	EClass getCellClick();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.CellClick#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CellClick#getColumn()
	 * @see #getCellClick()
	 * @generated
	 */
	EAttribute getCellClick_Column();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.ShowContentAssist <em>Show Content Assist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Show Content Assist</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ShowContentAssist
	 * @generated
	 */
	EClass getShowContentAssist();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.ClickAboutMenu <em>Click About Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Click About Menu</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickAboutMenu
	 * @generated
	 */
	EClass getClickAboutMenu();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.ClickPreferencesMenu <em>Click Preferences Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Click Preferences Menu</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickPreferencesMenu
	 * @generated
	 */
	EClass getClickPreferencesMenu();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.RecordingModeRequest <em>Recording Mode Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recording Mode Request</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RecordingModeRequest
	 * @generated
	 */
	EClass getRecordingModeRequest();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.AssertionModeRequest <em>Assertion Mode Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assertion Mode Request</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertionModeRequest
	 * @generated
	 */
	EClass getAssertionModeRequest();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Minimize <em>Minimize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Minimize</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Minimize
	 * @generated
	 */
	EClass getMinimize();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Maximize <em>Maximize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Maximize</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Maximize
	 * @generated
	 */
	EClass getMaximize();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Restore <em>Restore</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Restore</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Restore
	 * @generated
	 */
	EClass getRestore();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.ShowTabList <em>Show Tab List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Show Tab List</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ShowTabList
	 * @generated
	 */
	EClass getShowTabList();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SetStatusDialogMode <em>Set Status Dialog Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Status Dialog Mode</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetStatusDialogMode
	 * @generated
	 */
	EClass getSetStatusDialogMode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetStatusDialogMode#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetStatusDialogMode#isEnabled()
	 * @see #getSetStatusDialogMode()
	 * @generated
	 */
	EAttribute getSetStatusDialogMode_Enabled();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Check <em>Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Check
	 * @generated
	 */
	EClass getCheck();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.Check#isState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Check#isState()
	 * @see #getCheck()
	 * @generated
	 */
	EAttribute getCheck_State();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.HoverAtTextOffset <em>Hover At Text Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hover At Text Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.HoverAtTextOffset
	 * @generated
	 */
	EClass getHoverAtTextOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.HoverAtTextOffset#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.HoverAtTextOffset#getOffset()
	 * @see #getHoverAtTextOffset()
	 * @generated
	 */
	EAttribute getHoverAtTextOffset_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.HoverAtTextOffset#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.HoverAtTextOffset#getLine()
	 * @see #getHoverAtTextOffset()
	 * @generated
	 */
	EAttribute getHoverAtTextOffset_Line();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SetCursorOffset <em>Set Cursor Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Cursor Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetCursorOffset
	 * @generated
	 */
	EClass getSetCursorOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetCursorOffset#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetCursorOffset#getLine()
	 * @see #getSetCursorOffset()
	 * @generated
	 */
	EAttribute getSetCursorOffset_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetCursorOffset#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetCursorOffset#getOffset()
	 * @see #getSetCursorOffset()
	 * @generated
	 */
	EAttribute getSetCursorOffset_Offset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2 <em>Set Text Selection2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Text Selection2</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2
	 * @generated
	 */
	EClass getSetTextSelection2();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getStartLine <em>Start Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getStartLine()
	 * @see #getSetTextSelection2()
	 * @generated
	 */
	EAttribute getSetTextSelection2_StartLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getStartOffset <em>Start Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getStartOffset()
	 * @see #getSetTextSelection2()
	 * @generated
	 */
	EAttribute getSetTextSelection2_StartOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getEndLine <em>End Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getEndLine()
	 * @see #getSetTextSelection2()
	 * @generated
	 */
	EAttribute getSetTextSelection2_EndLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getEndOffset <em>End Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getEndOffset()
	 * @see #getSetTextSelection2()
	 * @generated
	 */
	EAttribute getSetTextSelection2_EndOffset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#isBlockMode <em>Block Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Block Mode</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#isBlockMode()
	 * @see #getSetTextSelection2()
	 * @generated
	 */
	EAttribute getSetTextSelection2_BlockMode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.HoverAtText <em>Hover At Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hover At Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.HoverAtText
	 * @generated
	 */
	EClass getHoverAtText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.HoverAtText#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.HoverAtText#getLine()
	 * @see #getHoverAtText()
	 * @generated
	 */
	EAttribute getHoverAtText_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.HoverAtText#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.HoverAtText#getOffset()
	 * @see #getHoverAtText()
	 * @generated
	 */
	EAttribute getHoverAtText_Offset();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.HoverAtText#getStateMask <em>State Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Mask</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.HoverAtText#getStateMask()
	 * @see #getHoverAtText()
	 * @generated
	 */
	EAttribute getHoverAtText_StateMask();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.OpenDeclaration <em>Open Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Declaration</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.OpenDeclaration
	 * @generated
	 */
	EClass getOpenDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.RulerClick <em>Ruler Click</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ruler Click</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RulerClick
	 * @generated
	 */
	EClass getRulerClick();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.RulerClick#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RulerClick#getLine()
	 * @see #getRulerClick()
	 * @generated
	 */
	EAttribute getRulerClick_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.RulerClick#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RulerClick#getButton()
	 * @see #getRulerClick()
	 * @generated
	 */
	EAttribute getRulerClick_Button();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.RulerClick#getStateMask <em>State Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Mask</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RulerClick#getStateMask()
	 * @see #getRulerClick()
	 * @generated
	 */
	EAttribute getRulerClick_StateMask();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.RulerDoubleClick <em>Ruler Double Click</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ruler Double Click</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RulerDoubleClick
	 * @generated
	 */
	EClass getRulerDoubleClick();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.RulerDoubleClick#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RulerDoubleClick#getLine()
	 * @see #getRulerDoubleClick()
	 * @generated
	 */
	EAttribute getRulerDoubleClick_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.RulerDoubleClick#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RulerDoubleClick#getButton()
	 * @see #getRulerDoubleClick()
	 * @generated
	 */
	EAttribute getRulerDoubleClick_Button();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.RulerDoubleClick#getStateMask <em>State Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Mask</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RulerDoubleClick#getStateMask()
	 * @see #getRulerDoubleClick()
	 * @generated
	 */
	EAttribute getRulerDoubleClick_StateMask();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.RulerHover <em>Ruler Hover</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ruler Hover</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RulerHover
	 * @generated
	 */
	EClass getRulerHover();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.RulerHover#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RulerHover#getLine()
	 * @see #getRulerHover()
	 * @generated
	 */
	EAttribute getRulerHover_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.RulerHover#getStateMask <em>State Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Mask</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RulerHover#getStateMask()
	 * @see #getRulerHover()
	 * @generated
	 */
	EAttribute getRulerHover_StateMask();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.ClickLink <em>Click Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Click Link</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickLink
	 * @generated
	 */
	EClass getClickLink();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.ClickLink#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickLink#getRef()
	 * @see #getClickLink()
	 * @generated
	 */
	EAttribute getClickLink_Ref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SetFocus <em>Set Focus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Focus</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetFocus
	 * @generated
	 */
	EClass getSetFocus();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetFocus#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetFocus#isValue()
	 * @see #getSetFocus()
	 * @generated
	 */
	EAttribute getSetFocus_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue <em>Get Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Property Value</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue
	 * @generated
	 */
	EClass getGetPropertyValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue#getName()
	 * @see #getGetPropertyValue()
	 * @generated
	 */
	EAttribute getGetPropertyValue_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue#getIndex()
	 * @see #getGetPropertyValue()
	 * @generated
	 */
	EAttribute getGetPropertyValue_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue#getAllowRawValues <em>Allow Raw Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Raw Values</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue#getAllowRawValues()
	 * @see #getGetPropertyValue()
	 * @generated
	 */
	EAttribute getGetPropertyValue_AllowRawValues();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.ObjectResponse <em>Object Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ObjectResponse
	 * @generated
	 */
	EClass getObjectResponse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.ObjectResponse#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ObjectResponse#getResult()
	 * @see #getObjectResponse()
	 * @generated
	 */
	EAttribute getObjectResponse_Result();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.GetBounds <em>Get Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Bounds</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetBounds
	 * @generated
	 */
	EClass getGetBounds();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.BoundsResponse <em>Bounds Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bounds Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.BoundsResponse
	 * @generated
	 */
	EClass getBoundsResponse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.BoundsResponse#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.BoundsResponse#getX()
	 * @see #getBoundsResponse()
	 * @generated
	 */
	EAttribute getBoundsResponse_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.BoundsResponse#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.BoundsResponse#getY()
	 * @see #getBoundsResponse()
	 * @generated
	 */
	EAttribute getBoundsResponse_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.BoundsResponse#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.BoundsResponse#getWidth()
	 * @see #getBoundsResponse()
	 * @generated
	 */
	EAttribute getBoundsResponse_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.BoundsResponse#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.BoundsResponse#getHeight()
	 * @see #getBoundsResponse()
	 * @generated
	 */
	EAttribute getBoundsResponse_Height();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.Collapse <em>Collapse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collapse</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Collapse
	 * @generated
	 */
	EClass getCollapse();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.ClickColumn <em>Click Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Click Column</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickColumn
	 * @generated
	 */
	EClass getClickColumn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.ClickColumn#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickColumn#getName()
	 * @see #getClickColumn()
	 * @generated
	 */
	EAttribute getClickColumn_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.ClickColumn#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickColumn#getIndex()
	 * @see #getClickColumn()
	 * @generated
	 */
	EAttribute getClickColumn_Index();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SetSortColumn <em>Set Sort Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Sort Column</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSortColumn
	 * @generated
	 */
	EClass getSetSortColumn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetSortColumn#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSortColumn#getName()
	 * @see #getSetSortColumn()
	 * @generated
	 */
	EAttribute getSetSortColumn_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetSortColumn#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSortColumn#getIndex()
	 * @see #getSetSortColumn()
	 * @generated
	 */
	EAttribute getSetSortColumn_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetSortColumn#isDescending <em>Descending</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Descending</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSortColumn#isDescending()
	 * @see #getSetSortColumn()
	 * @generated
	 */
	EAttribute getSetSortColumn_Descending();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.MouseEvent <em>Mouse Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mouse Event</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.MouseEvent
	 * @generated
	 */
	EClass getMouseEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.MouseEvent#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.MouseEvent#getKind()
	 * @see #getMouseEvent()
	 * @generated
	 */
	EAttribute getMouseEvent_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.MouseEvent#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.MouseEvent#getButton()
	 * @see #getMouseEvent()
	 * @generated
	 */
	EAttribute getMouseEvent_Button();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.MouseEvent#getStateMask <em>State Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Mask</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.MouseEvent#getStateMask()
	 * @see #getMouseEvent()
	 * @generated
	 */
	EAttribute getMouseEvent_StateMask();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.MouseEvent#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.MouseEvent#getCount()
	 * @see #getMouseEvent()
	 * @generated
	 */
	EAttribute getMouseEvent_Count();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.MouseEvent#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.MouseEvent#getX()
	 * @see #getMouseEvent()
	 * @generated
	 */
	EAttribute getMouseEvent_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.MouseEvent#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.MouseEvent#getY()
	 * @see #getMouseEvent()
	 * @generated
	 */
	EAttribute getMouseEvent_Y();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.ClickText <em>Click Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Click Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickText
	 * @generated
	 */
	EClass getClickText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.ClickText#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickText#getStart()
	 * @see #getClickText()
	 * @generated
	 */
	EAttribute getClickText_Start();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.ClickText#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickText#getEnd()
	 * @see #getClickText()
	 * @generated
	 */
	EAttribute getClickText_End();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.ClickText#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickText#getButton()
	 * @see #getClickText()
	 * @generated
	 */
	EAttribute getClickText_Button();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.DoubleClickText <em>Double Click Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Click Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DoubleClickText
	 * @generated
	 */
	EClass getDoubleClickText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.DoubleClickText#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DoubleClickText#getPosition()
	 * @see #getDoubleClickText()
	 * @generated
	 */
	EAttribute getDoubleClickText_Position();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.DoubleClickText#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DoubleClickText#getButton()
	 * @see #getDoubleClickText()
	 * @generated
	 */
	EAttribute getDoubleClickText_Button();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SetWidth <em>Set Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Width</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetWidth
	 * @generated
	 */
	EClass getSetWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetWidth#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetWidth#getWidth()
	 * @see #getSetWidth()
	 * @generated
	 */
	EAttribute getSetWidth_Width();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.SetPosition <em>Set Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Position</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetPosition
	 * @generated
	 */
	EClass getSetPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.SetPosition#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetPosition#getIndex()
	 * @see #getSetPosition()
	 * @generated
	 */
	EAttribute getSetPosition_Index();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.tesla.core.protocol.SWTDialogKind <em>SWT Dialog Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SWT Dialog Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SWTDialogKind
	 * @generated
	 */
	EEnum getSWTDialogKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.tesla.core.protocol.AssertKind <em>Assert Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Assert Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertKind
	 * @generated
	 */
	EEnum getAssertKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.tesla.core.protocol.DragKind <em>Drag Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Drag Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DragKind
	 * @generated
	 */
	EEnum getDragKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.tesla.core.protocol.MouseEventKind <em>Mouse Event Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Mouse Event Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.MouseEventKind
	 * @generated
	 */
	EEnum getMouseEventKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProtocolFactory getProtocolFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SelectDataImpl <em>Select Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SelectDataImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSelectData()
		 * @generated
		 */
		EClass SELECT_DATA = eINSTANCE.getSelectData();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_DATA__KIND = eINSTANCE.getSelectData_Kind();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_DATA__PATTERN = eINSTANCE.getSelectData_Pattern();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_DATA__PATH = eINSTANCE.getSelectData_Path();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_DATA__INDEX = eINSTANCE.getSelectData_Index();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_DATA__MULTIPLICITY = eINSTANCE.getSelectData_Multiplicity();

		/**
		 * The meta object literal for the '<em><b>After</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_DATA__AFTER = eINSTANCE.getSelectData_After();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_DATA__PARENT = eINSTANCE.getSelectData_Parent();

		/**
		 * The meta object literal for the '<em><b>Class Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_DATA__CLASS_PATTERN = eINSTANCE.getSelectData_ClassPattern();

		/**
		 * The meta object literal for the '<em><b>Indexes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_DATA__INDEXES = eINSTANCE.getSelectData_Indexes();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.IMLSelectDataImpl <em>IML Select Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.IMLSelectDataImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getIMLSelectData()
		 * @generated
		 */
		EClass IML_SELECT_DATA = eINSTANCE.getIMLSelectData();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IML_SELECT_DATA__IMAGE = eINSTANCE.getIMLSelectData_Image();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SelectCommandImpl <em>Select Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SelectCommandImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSelectCommand()
		 * @generated
		 */
		EClass SELECT_COMMAND = eINSTANCE.getSelectCommand();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_COMMAND__DATA = eINSTANCE.getSelectCommand_Data();

		/**
		 * The meta object literal for the '<em><b>Contain Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_COMMAND__CONTAIN_CHILDREN = eINSTANCE.getSelectCommand_ContainChildren();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SelectResponseImpl <em>Select Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SelectResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSelectResponse()
		 * @generated
		 */
		EClass SELECT_RESPONSE = eINSTANCE.getSelectResponse();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_RESPONSE__ELEMENTS = eINSTANCE.getSelectResponse_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.ElementCommand <em>Element Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.ElementCommand
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getElementCommand()
		 * @generated
		 */
		EClass ELEMENT_COMMAND = eINSTANCE.getElementCommand();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_COMMAND__ELEMENT = eINSTANCE.getElementCommand_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickImpl <em>Click</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ClickImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getClick()
		 * @generated
		 */
		EClass CLICK = eINSTANCE.getClick();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK__DEFAULT = eINSTANCE.getClick_Default();

		/**
		 * The meta object literal for the '<em><b>With Wait</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK__WITH_WAIT = eINSTANCE.getClick_WithWait();

		/**
		 * The meta object literal for the '<em><b>Arrow</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK__ARROW = eINSTANCE.getClick_Arrow();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.DoubleClickImpl <em>Double Click</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.DoubleClickImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getDoubleClick()
		 * @generated
		 */
		EClass DOUBLE_CLICK = eINSTANCE.getDoubleClick();

		/**
		 * The meta object literal for the '<em><b>With Wait</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_CLICK__WITH_WAIT = eINSTANCE.getDoubleClick_WithWait();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ShowImpl <em>Show</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ShowImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getShow()
		 * @generated
		 */
		EClass SHOW = eINSTANCE.getShow();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.HideImpl <em>Hide</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.HideImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getHide()
		 * @generated
		 */
		EClass HIDE = eINSTANCE.getHide();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CloseImpl <em>Close</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CloseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getClose()
		 * @generated
		 */
		EClass CLOSE = eINSTANCE.getClose();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetTextImpl <em>Get Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetTextImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetText()
		 * @generated
		 */
		EClass GET_TEXT = eINSTANCE.getGetText();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetTextResponseImpl <em>Get Text Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetTextResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetTextResponse()
		 * @generated
		 */
		EClass GET_TEXT_RESPONSE = eINSTANCE.getGetTextResponse();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_TEXT_RESPONSE__TEXT = eINSTANCE.getGetTextResponse_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.BooleanResponseImpl <em>Boolean Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.BooleanResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getBooleanResponse()
		 * @generated
		 */
		EClass BOOLEAN_RESPONSE = eINSTANCE.getBooleanResponse();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_RESPONSE__RESULT = eINSTANCE.getBooleanResponse_Result();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.IsEnabledImpl <em>Is Enabled</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.IsEnabledImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getIsEnabled()
		 * @generated
		 */
		EClass IS_ENABLED = eINSTANCE.getIsEnabled();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.IsDisposedImpl <em>Is Disposed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.IsDisposedImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getIsDisposed()
		 * @generated
		 */
		EClass IS_DISPOSED = eINSTANCE.getIsDisposed();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextImpl <em>Set Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetTextImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetText()
		 * @generated
		 */
		EClass SET_TEXT = eINSTANCE.getSetText();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT__VALUE = eINSTANCE.getSetText_Value();

		/**
		 * The meta object literal for the '<em><b>Select</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT__SELECT = eINSTANCE.getSetText_Select();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetStateImpl <em>Get State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetStateImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetState()
		 * @generated
		 */
		EClass GET_STATE = eINSTANCE.getGetState();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetStateResponseImpl <em>Get State Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetStateResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetStateResponse()
		 * @generated
		 */
		EClass GET_STATE_RESPONSE = eINSTANCE.getGetStateResponse();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_STATE_RESPONSE__STATE = eINSTANCE.getGetStateResponse_State();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.WaitForStateImpl <em>Wait For State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.WaitForStateImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getWaitForState()
		 * @generated
		 */
		EClass WAIT_FOR_STATE = eINSTANCE.getWaitForState();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WAIT_FOR_STATE__STATE = eINSTANCE.getWaitForState_State();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.RollbackToStateImpl <em>Rollback To State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.RollbackToStateImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getRollbackToState()
		 * @generated
		 */
		EClass ROLLBACK_TO_STATE = eINSTANCE.getRollbackToState();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLLBACK_TO_STATE__STATE = eINSTANCE.getRollbackToState_State();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetSelectionImpl <em>Set Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetSelectionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetSelection()
		 * @generated
		 */
		EClass SET_SELECTION = eINSTANCE.getSetSelection();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_SELECTION__PATH = eINSTANCE.getSetSelection_Path();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_SELECTION__PATTERN = eINSTANCE.getSetSelection_Pattern();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_SELECTION__INDEX = eINSTANCE.getSetSelection_Index();

		/**
		 * The meta object literal for the '<em><b>Additional Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_SELECTION__ADDITIONAL_ITEMS = eINSTANCE.getSetSelection_AdditionalItems();

		/**
		 * The meta object literal for the '<em><b>All</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_SELECTION__ALL = eINSTANCE.getSetSelection_All();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.MultiSelectionItemImpl <em>Multi Selection Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.MultiSelectionItemImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getMultiSelectionItem()
		 * @generated
		 */
		EClass MULTI_SELECTION_ITEM = eINSTANCE.getMultiSelectionItem();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_SELECTION_ITEM__PATH = eINSTANCE.getMultiSelectionItem_Path();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_SELECTION_ITEM__PATTERN = eINSTANCE.getMultiSelectionItem_Pattern();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_SELECTION_ITEM__INDEX = eINSTANCE.getMultiSelectionItem_Index();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ShutdownImpl <em>Shutdown</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ShutdownImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getShutdown()
		 * @generated
		 */
		EClass SHUTDOWN = eINSTANCE.getShutdown();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.NopImpl <em>Nop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.NopImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getNop()
		 * @generated
		 */
		EClass NOP = eINSTANCE.getNop();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CountItemsImpl <em>Count Items</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CountItemsImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCountItems()
		 * @generated
		 */
		EClass COUNT_ITEMS = eINSTANCE.getCountItems();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COUNT_ITEMS__PATH = eINSTANCE.getCountItems_Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.IntResponseImpl <em>Int Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.IntResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getIntResponse()
		 * @generated
		 */
		EClass INT_RESPONSE = eINSTANCE.getIntResponse();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_RESPONSE__RESULT = eINSTANCE.getIntResponse_Result();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SaveImpl <em>Save</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SaveImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSave()
		 * @generated
		 */
		EClass SAVE = eINSTANCE.getSave();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.IsDirtyImpl <em>Is Dirty</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.IsDirtyImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getIsDirty()
		 * @generated
		 */
		EClass IS_DIRTY = eINSTANCE.getIsDirty();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelectionImpl <em>Set Text Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelectionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetTextSelection()
		 * @generated
		 */
		EClass SET_TEXT_SELECTION = eINSTANCE.getSetTextSelection();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_SELECTION__OFFSET = eINSTANCE.getSetTextSelection_Offset();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_SELECTION__LENGTH = eINSTANCE.getSetTextSelection_Length();

		/**
		 * The meta object literal for the '<em><b>Start Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_SELECTION__START_LINE = eINSTANCE.getSetTextSelection_StartLine();

		/**
		 * The meta object literal for the '<em><b>Endline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_SELECTION__ENDLINE = eINSTANCE.getSetTextSelection_Endline();

		/**
		 * The meta object literal for the '<em><b>Endoffset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_SELECTION__ENDOFFSET = eINSTANCE.getSetTextSelection_Endoffset();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextOffsetImpl <em>Set Text Offset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetTextOffsetImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetTextOffset()
		 * @generated
		 */
		EClass SET_TEXT_OFFSET = eINSTANCE.getSetTextOffset();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_OFFSET__OFFSET = eINSTANCE.getSetTextOffset_Offset();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_OFFSET__LINE = eINSTANCE.getSetTextOffset_Line();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ShowSelectionImpl <em>Show Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ShowSelectionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getShowSelection()
		 * @generated
		 */
		EClass SHOW_SELECTION = eINSTANCE.getShowSelection();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetTextSelectionImpl <em>Get Text Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetTextSelectionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetTextSelection()
		 * @generated
		 */
		EClass GET_TEXT_SELECTION = eINSTANCE.getGetTextSelection();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GoToTextLineImpl <em>Go To Text Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GoToTextLineImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGoToTextLine()
		 * @generated
		 */
		EClass GO_TO_TEXT_LINE = eINSTANCE.getGoToTextLine();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GO_TO_TEXT_LINE__LINE = eINSTANCE.getGoToTextLine_Line();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetTextLineOffsetImpl <em>Get Text Line Offset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetTextLineOffsetImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetTextLineOffset()
		 * @generated
		 */
		EClass GET_TEXT_LINE_OFFSET = eINSTANCE.getGetTextLineOffset();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_TEXT_LINE_OFFSET__LINE = eINSTANCE.getGetTextLineOffset_Line();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetTextLineLengthImpl <em>Get Text Line Length</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetTextLineLengthImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetTextLineLength()
		 * @generated
		 */
		EClass GET_TEXT_LINE_LENGTH = eINSTANCE.getGetTextLineLength();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_TEXT_LINE_LENGTH__LINE = eINSTANCE.getGetTextLineLength_Line();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SelectTextLineImpl <em>Select Text Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SelectTextLineImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSelectTextLine()
		 * @generated
		 */
		EClass SELECT_TEXT_LINE = eINSTANCE.getSelectTextLine();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_TEXT_LINE__LINE = eINSTANCE.getSelectTextLine_Line();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetCaretPositionImpl <em>Set Caret Position</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetCaretPositionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetCaretPosition()
		 * @generated
		 */
		EClass SET_CARET_POSITION = eINSTANCE.getSetCaretPosition();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_CARET_POSITION__OFFSET = eINSTANCE.getSetCaretPosition_Offset();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetTextLineImpl <em>Get Text Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetTextLineImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetTextLine()
		 * @generated
		 */
		EClass GET_TEXT_LINE = eINSTANCE.getGetTextLine();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_TEXT_LINE__LINE = eINSTANCE.getGetTextLine_Line();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetTextRangeImpl <em>Get Text Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetTextRangeImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetTextRange()
		 * @generated
		 */
		EClass GET_TEXT_RANGE = eINSTANCE.getGetTextRange();

		/**
		 * The meta object literal for the '<em><b>Start Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_TEXT_RANGE__START_OFFSET = eINSTANCE.getGetTextRange_StartOffset();

		/**
		 * The meta object literal for the '<em><b>End Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_TEXT_RANGE__END_OFFSET = eINSTANCE.getGetTextRange_EndOffset();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.TextSelectionResponseImpl <em>Text Selection Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.TextSelectionResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getTextSelectionResponse()
		 * @generated
		 */
		EClass TEXT_SELECTION_RESPONSE = eINSTANCE.getTextSelectionResponse();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_SELECTION_RESPONSE__X = eINSTANCE.getTextSelectionResponse_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_SELECTION_RESPONSE__Y = eINSTANCE.getTextSelectionResponse_Y();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_SELECTION_RESPONSE__TEXT = eINSTANCE.getTextSelectionResponse_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetColorImpl <em>Get Color</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetColorImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetColor()
		 * @generated
		 */
		EClass GET_COLOR = eINSTANCE.getGetColor();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetColorImpl <em>Set Color</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetColorImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetColor()
		 * @generated
		 */
		EClass SET_COLOR = eINSTANCE.getSetColor();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_COLOR__COLOR = eINSTANCE.getSetColor_Color();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetColorResponseImpl <em>Get Color Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetColorResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetColorResponse()
		 * @generated
		 */
		EClass GET_COLOR_RESPONSE = eINSTANCE.getGetColorResponse();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_COLOR_RESPONSE__COLOR = eINSTANCE.getGetColorResponse_Color();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.TypeTextImpl <em>Type Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.TypeTextImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getTypeText()
		 * @generated
		 */
		EClass TYPE_TEXT = eINSTANCE.getTypeText();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TEXT__STATE = eINSTANCE.getTypeText_State();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TEXT__TEXT = eINSTANCE.getTypeText_Text();

		/**
		 * The meta object literal for the '<em><b>From Display</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_TEXT__FROM_DISPLAY = eINSTANCE.getTypeText_FromDisplay();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ChildrenImpl <em>Children</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ChildrenImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getChildren()
		 * @generated
		 */
		EClass CHILDREN = eINSTANCE.getChildren();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ChildrenResponseImpl <em>Children Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ChildrenResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getChildrenResponse()
		 * @generated
		 */
		EClass CHILDREN_RESPONSE = eINSTANCE.getChildrenResponse();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHILDREN_RESPONSE__CHILDREN = eINSTANCE.getChildrenResponse_Children();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ParentImpl <em>Parent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ParentImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getParent()
		 * @generated
		 */
		EClass PARENT = eINSTANCE.getParent();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ParentResponseImpl <em>Parent Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ParentResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getParentResponse()
		 * @generated
		 */
		EClass PARENT_RESPONSE = eINSTANCE.getParentResponse();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARENT_RESPONSE__PARENT = eINSTANCE.getParentResponse_Parent();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.TypeImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__STATE = eINSTANCE.getType_State();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__CODE = eINSTANCE.getType_Code();

		/**
		 * The meta object literal for the '<em><b>From Display</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__FROM_DISPLAY = eINSTANCE.getType_FromDisplay();

		/**
		 * The meta object literal for the '<em><b>Character</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__CHARACTER = eINSTANCE.getType_Character();

		/**
		 * The meta object literal for the '<em><b>Meta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__META = eINSTANCE.getType_Meta();

		/**
		 * The meta object literal for the '<em><b>Traverse</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__TRAVERSE = eINSTANCE.getType_Traverse();

		/**
		 * The meta object literal for the '<em><b>Times</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__TIMES = eINSTANCE.getType_Times();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.TypeActionImpl <em>Type Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.TypeActionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getTypeAction()
		 * @generated
		 */
		EClass TYPE_ACTION = eINSTANCE.getTypeAction();

		/**
		 * The meta object literal for the '<em><b>Action Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_ACTION__ACTION_ID = eINSTANCE.getTypeAction_ActionId();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CopyTextSelectionImpl <em>Copy Text Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CopyTextSelectionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCopyTextSelection()
		 * @generated
		 */
		EClass COPY_TEXT_SELECTION = eINSTANCE.getCopyTextSelection();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CutTextSelectionImpl <em>Cut Text Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CutTextSelectionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCutTextSelection()
		 * @generated
		 */
		EClass CUT_TEXT_SELECTION = eINSTANCE.getCutTextSelection();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.PasteTextSelectionImpl <em>Paste Text Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.PasteTextSelectionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getPasteTextSelection()
		 * @generated
		 */
		EClass PASTE_TEXT_SELECTION = eINSTANCE.getPasteTextSelection();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ReplaceTextSelectionImpl <em>Replace Text Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ReplaceTextSelectionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getReplaceTextSelection()
		 * @generated
		 */
		EClass REPLACE_TEXT_SELECTION = eINSTANCE.getReplaceTextSelection();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPLACE_TEXT_SELECTION__TEXT = eINSTANCE.getReplaceTextSelection_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CheckItemImpl <em>Check Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CheckItemImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCheckItem()
		 * @generated
		 */
		EClass CHECK_ITEM = eINSTANCE.getCheckItem();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECK_ITEM__PATH = eINSTANCE.getCheckItem_Path();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECK_ITEM__PATTERN = eINSTANCE.getCheckItem_Pattern();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECK_ITEM__INDEX = eINSTANCE.getCheckItem_Index();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECK_ITEM__STATE = eINSTANCE.getCheckItem_State();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ExpandImpl <em>Expand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ExpandImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getExpand()
		 * @generated
		 */
		EClass EXPAND = eINSTANCE.getExpand();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CloseWorkbenchImpl <em>Close Workbench</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CloseWorkbenchImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCloseWorkbench()
		 * @generated
		 */
		EClass CLOSE_WORKBENCH = eINSTANCE.getCloseWorkbench();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ActivateCellEditorImpl <em>Activate Cell Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ActivateCellEditorImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getActivateCellEditor()
		 * @generated
		 */
		EClass ACTIVATE_CELL_EDITOR = eINSTANCE.getActivateCellEditor();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATE_CELL_EDITOR__PATH = eINSTANCE.getActivateCellEditor_Path();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATE_CELL_EDITOR__PATTERN = eINSTANCE.getActivateCellEditor_Pattern();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATE_CELL_EDITOR__INDEX = eINSTANCE.getActivateCellEditor_Index();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATE_CELL_EDITOR__COLUMN = eINSTANCE.getActivateCellEditor_Column();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ApplyCellEditorImpl <em>Apply Cell Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ApplyCellEditorImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getApplyCellEditor()
		 * @generated
		 */
		EClass APPLY_CELL_EDITOR = eINSTANCE.getApplyCellEditor();

		/**
		 * The meta object literal for the '<em><b>Deactivate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLY_CELL_EDITOR__DEACTIVATE = eINSTANCE.getApplyCellEditor_Deactivate();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLY_CELL_EDITOR__COLUMN = eINSTANCE.getApplyCellEditor_Column();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CancelCellEditorImpl <em>Cancel Cell Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CancelCellEditorImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCancelCellEditor()
		 * @generated
		 */
		EClass CANCEL_CELL_EDITOR = eINSTANCE.getCancelCellEditor();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.DeactivateCellEditorImpl <em>Deactivate Cell Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.DeactivateCellEditorImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getDeactivateCellEditor()
		 * @generated
		 */
		EClass DEACTIVATE_CELL_EDITOR = eINSTANCE.getDeactivateCellEditor();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetSWTDialogInfoImpl <em>Set SWT Dialog Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetSWTDialogInfoImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetSWTDialogInfo()
		 * @generated
		 */
		EClass SET_SWT_DIALOG_INFO = eINSTANCE.getSetSWTDialogInfo();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_SWT_DIALOG_INFO__KIND = eINSTANCE.getSetSWTDialogInfo_Kind();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_SWT_DIALOG_INFO__PATH = eINSTANCE.getSetSWTDialogInfo_Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.AssertImpl <em>Assert</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.AssertImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getAssert()
		 * @generated
		 */
		EClass ASSERT = eINSTANCE.getAssert();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERT__ELEMENT = eINSTANCE.getAssert_Element();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT__ATTRIBUTE = eINSTANCE.getAssert_Attribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT__VALUE = eINSTANCE.getAssert_Value();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT__KIND = eINSTANCE.getAssert_Kind();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT__INDEX = eINSTANCE.getAssert_Index();

		/**
		 * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT__CATEGORY = eINSTANCE.getAssert_Category();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERT__VALUE_TYPE = eINSTANCE.getAssert_ValueType();

		/**
		 * The meta object literal for the '<em><b>Image Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERT__IMAGE_DATA = eINSTANCE.getAssert_ImageData();

		/**
		 * The meta object literal for the '<em><b>Show Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT__SHOW_INDEX = eINSTANCE.getAssert_ShowIndex();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetRegionTextImpl <em>Get Region Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetRegionTextImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetRegionText()
		 * @generated
		 */
		EClass GET_REGION_TEXT = eINSTANCE.getGetRegionText();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION_TEXT__X = eINSTANCE.getGetRegionText_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION_TEXT__Y = eINSTANCE.getGetRegionText_Y();

		/**
		 * The meta object literal for the '<em><b>Sx</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION_TEXT__SX = eINSTANCE.getGetRegionText_Sx();

		/**
		 * The meta object literal for the '<em><b>Sy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION_TEXT__SY = eINSTANCE.getGetRegionText_Sy();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION_TEXT__WIDTH = eINSTANCE.getGetRegionText_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_REGION_TEXT__HEIGHT = eINSTANCE.getGetRegionText_Height();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.AssertImageDataImpl <em>Assert Image Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.AssertImageDataImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getAssertImageData()
		 * @generated
		 */
		EClass ASSERT_IMAGE_DATA = eINSTANCE.getAssertImageData();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_IMAGE_DATA__IMAGE = eINSTANCE.getAssertImageData_Image();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_IMAGE_DATA__X = eINSTANCE.getAssertImageData_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_IMAGE_DATA__Y = eINSTANCE.getAssertImageData_Y();

		/**
		 * The meta object literal for the '<em><b>Sx</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_IMAGE_DATA__SX = eINSTANCE.getAssertImageData_Sx();

		/**
		 * The meta object literal for the '<em><b>Sy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_IMAGE_DATA__SY = eINSTANCE.getAssertImageData_Sy();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_IMAGE_DATA__WIDTH = eINSTANCE.getAssertImageData_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_IMAGE_DATA__HEIGHT = eINSTANCE.getAssertImageData_Height();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.AssertResponseImpl <em>Assert Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.AssertResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getAssertResponse()
		 * @generated
		 */
		EClass ASSERT_RESPONSE = eINSTANCE.getAssertResponse();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetSelectionImpl <em>Get Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetSelectionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetSelection()
		 * @generated
		 */
		EClass GET_SELECTION = eINSTANCE.getGetSelection();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SelectionResponseImpl <em>Selection Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SelectionResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSelectionResponse()
		 * @generated
		 */
		EClass SELECTION_RESPONSE = eINSTANCE.getSelectionResponse();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION_RESPONSE__VALUES = eINSTANCE.getSelectionResponse_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SelectionItemImpl <em>Selection Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SelectionItemImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSelectionItem()
		 * @generated
		 */
		EClass SELECTION_ITEM = eINSTANCE.getSelectionItem();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTION_ITEM__TEXT = eINSTANCE.getSelectionItem_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.DragCommandImpl <em>Drag Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.DragCommandImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getDragCommand()
		 * @generated
		 */
		EClass DRAG_COMMAND = eINSTANCE.getDragCommand();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAG_COMMAND__KIND = eINSTANCE.getDragCommand_Kind();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAG_COMMAND__X = eINSTANCE.getDragCommand_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAG_COMMAND__Y = eINSTANCE.getDragCommand_Y();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRAG_COMMAND__STYLE = eINSTANCE.getDragCommand_Style();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.WaitForRestartImpl <em>Wait For Restart</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.WaitForRestartImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getWaitForRestart()
		 * @generated
		 */
		EClass WAIT_FOR_RESTART = eINSTANCE.getWaitForRestart();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CellClickImpl <em>Cell Click</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CellClickImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCellClick()
		 * @generated
		 */
		EClass CELL_CLICK = eINSTANCE.getCellClick();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CELL_CLICK__COLUMN = eINSTANCE.getCellClick_Column();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ShowContentAssistImpl <em>Show Content Assist</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ShowContentAssistImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getShowContentAssist()
		 * @generated
		 */
		EClass SHOW_CONTENT_ASSIST = eINSTANCE.getShowContentAssist();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickAboutMenuImpl <em>Click About Menu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ClickAboutMenuImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getClickAboutMenu()
		 * @generated
		 */
		EClass CLICK_ABOUT_MENU = eINSTANCE.getClickAboutMenu();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickPreferencesMenuImpl <em>Click Preferences Menu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ClickPreferencesMenuImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getClickPreferencesMenu()
		 * @generated
		 */
		EClass CLICK_PREFERENCES_MENU = eINSTANCE.getClickPreferencesMenu();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.RecordingModeRequestImpl <em>Recording Mode Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.RecordingModeRequestImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getRecordingModeRequest()
		 * @generated
		 */
		EClass RECORDING_MODE_REQUEST = eINSTANCE.getRecordingModeRequest();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.AssertionModeRequestImpl <em>Assertion Mode Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.AssertionModeRequestImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getAssertionModeRequest()
		 * @generated
		 */
		EClass ASSERTION_MODE_REQUEST = eINSTANCE.getAssertionModeRequest();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.MinimizeImpl <em>Minimize</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.MinimizeImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getMinimize()
		 * @generated
		 */
		EClass MINIMIZE = eINSTANCE.getMinimize();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.MaximizeImpl <em>Maximize</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.MaximizeImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getMaximize()
		 * @generated
		 */
		EClass MAXIMIZE = eINSTANCE.getMaximize();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.RestoreImpl <em>Restore</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.RestoreImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getRestore()
		 * @generated
		 */
		EClass RESTORE = eINSTANCE.getRestore();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ShowTabListImpl <em>Show Tab List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ShowTabListImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getShowTabList()
		 * @generated
		 */
		EClass SHOW_TAB_LIST = eINSTANCE.getShowTabList();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetStatusDialogModeImpl <em>Set Status Dialog Mode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetStatusDialogModeImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetStatusDialogMode()
		 * @generated
		 */
		EClass SET_STATUS_DIALOG_MODE = eINSTANCE.getSetStatusDialogMode();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_STATUS_DIALOG_MODE__ENABLED = eINSTANCE.getSetStatusDialogMode_Enabled();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CheckImpl <em>Check</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CheckImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCheck()
		 * @generated
		 */
		EClass CHECK = eINSTANCE.getCheck();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECK__STATE = eINSTANCE.getCheck_State();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.HoverAtTextOffsetImpl <em>Hover At Text Offset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.HoverAtTextOffsetImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getHoverAtTextOffset()
		 * @generated
		 */
		EClass HOVER_AT_TEXT_OFFSET = eINSTANCE.getHoverAtTextOffset();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOVER_AT_TEXT_OFFSET__OFFSET = eINSTANCE.getHoverAtTextOffset_Offset();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOVER_AT_TEXT_OFFSET__LINE = eINSTANCE.getHoverAtTextOffset_Line();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetCursorOffsetImpl <em>Set Cursor Offset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetCursorOffsetImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetCursorOffset()
		 * @generated
		 */
		EClass SET_CURSOR_OFFSET = eINSTANCE.getSetCursorOffset();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_CURSOR_OFFSET__LINE = eINSTANCE.getSetCursorOffset_Line();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_CURSOR_OFFSET__OFFSET = eINSTANCE.getSetCursorOffset_Offset();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelection2Impl <em>Set Text Selection2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelection2Impl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetTextSelection2()
		 * @generated
		 */
		EClass SET_TEXT_SELECTION2 = eINSTANCE.getSetTextSelection2();

		/**
		 * The meta object literal for the '<em><b>Start Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_SELECTION2__START_LINE = eINSTANCE.getSetTextSelection2_StartLine();

		/**
		 * The meta object literal for the '<em><b>Start Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_SELECTION2__START_OFFSET = eINSTANCE.getSetTextSelection2_StartOffset();

		/**
		 * The meta object literal for the '<em><b>End Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_SELECTION2__END_LINE = eINSTANCE.getSetTextSelection2_EndLine();

		/**
		 * The meta object literal for the '<em><b>End Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_SELECTION2__END_OFFSET = eINSTANCE.getSetTextSelection2_EndOffset();

		/**
		 * The meta object literal for the '<em><b>Block Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TEXT_SELECTION2__BLOCK_MODE = eINSTANCE.getSetTextSelection2_BlockMode();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.HoverAtTextImpl <em>Hover At Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.HoverAtTextImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getHoverAtText()
		 * @generated
		 */
		EClass HOVER_AT_TEXT = eINSTANCE.getHoverAtText();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOVER_AT_TEXT__LINE = eINSTANCE.getHoverAtText_Line();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOVER_AT_TEXT__OFFSET = eINSTANCE.getHoverAtText_Offset();

		/**
		 * The meta object literal for the '<em><b>State Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HOVER_AT_TEXT__STATE_MASK = eINSTANCE.getHoverAtText_StateMask();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.OpenDeclarationImpl <em>Open Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.OpenDeclarationImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getOpenDeclaration()
		 * @generated
		 */
		EClass OPEN_DECLARATION = eINSTANCE.getOpenDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.RulerClickImpl <em>Ruler Click</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.RulerClickImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getRulerClick()
		 * @generated
		 */
		EClass RULER_CLICK = eINSTANCE.getRulerClick();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULER_CLICK__LINE = eINSTANCE.getRulerClick_Line();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULER_CLICK__BUTTON = eINSTANCE.getRulerClick_Button();

		/**
		 * The meta object literal for the '<em><b>State Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULER_CLICK__STATE_MASK = eINSTANCE.getRulerClick_StateMask();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.RulerDoubleClickImpl <em>Ruler Double Click</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.RulerDoubleClickImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getRulerDoubleClick()
		 * @generated
		 */
		EClass RULER_DOUBLE_CLICK = eINSTANCE.getRulerDoubleClick();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULER_DOUBLE_CLICK__LINE = eINSTANCE.getRulerDoubleClick_Line();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULER_DOUBLE_CLICK__BUTTON = eINSTANCE.getRulerDoubleClick_Button();

		/**
		 * The meta object literal for the '<em><b>State Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULER_DOUBLE_CLICK__STATE_MASK = eINSTANCE.getRulerDoubleClick_StateMask();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.RulerHoverImpl <em>Ruler Hover</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.RulerHoverImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getRulerHover()
		 * @generated
		 */
		EClass RULER_HOVER = eINSTANCE.getRulerHover();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULER_HOVER__LINE = eINSTANCE.getRulerHover_Line();

		/**
		 * The meta object literal for the '<em><b>State Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULER_HOVER__STATE_MASK = eINSTANCE.getRulerHover_StateMask();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickLinkImpl <em>Click Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ClickLinkImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getClickLink()
		 * @generated
		 */
		EClass CLICK_LINK = eINSTANCE.getClickLink();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK_LINK__REF = eINSTANCE.getClickLink_Ref();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetFocusImpl <em>Set Focus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetFocusImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetFocus()
		 * @generated
		 */
		EClass SET_FOCUS = eINSTANCE.getSetFocus();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_FOCUS__VALUE = eINSTANCE.getSetFocus_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetPropertyValueImpl <em>Get Property Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetPropertyValueImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetPropertyValue()
		 * @generated
		 */
		EClass GET_PROPERTY_VALUE = eINSTANCE.getGetPropertyValue();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_PROPERTY_VALUE__NAME = eINSTANCE.getGetPropertyValue_Name();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_PROPERTY_VALUE__INDEX = eINSTANCE.getGetPropertyValue_Index();

		/**
		 * The meta object literal for the '<em><b>Allow Raw Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_PROPERTY_VALUE__ALLOW_RAW_VALUES = eINSTANCE.getGetPropertyValue_AllowRawValues();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ObjectResponseImpl <em>Object Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ObjectResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getObjectResponse()
		 * @generated
		 */
		EClass OBJECT_RESPONSE = eINSTANCE.getObjectResponse();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_RESPONSE__RESULT = eINSTANCE.getObjectResponse_Result();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.GetBoundsImpl <em>Get Bounds</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.GetBoundsImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getGetBounds()
		 * @generated
		 */
		EClass GET_BOUNDS = eINSTANCE.getGetBounds();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.BoundsResponseImpl <em>Bounds Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.BoundsResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getBoundsResponse()
		 * @generated
		 */
		EClass BOUNDS_RESPONSE = eINSTANCE.getBoundsResponse();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDS_RESPONSE__X = eINSTANCE.getBoundsResponse_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDS_RESPONSE__Y = eINSTANCE.getBoundsResponse_Y();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDS_RESPONSE__WIDTH = eINSTANCE.getBoundsResponse_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDS_RESPONSE__HEIGHT = eINSTANCE.getBoundsResponse_Height();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.CollapseImpl <em>Collapse</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.CollapseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getCollapse()
		 * @generated
		 */
		EClass COLLAPSE = eINSTANCE.getCollapse();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickColumnImpl <em>Click Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ClickColumnImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getClickColumn()
		 * @generated
		 */
		EClass CLICK_COLUMN = eINSTANCE.getClickColumn();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK_COLUMN__NAME = eINSTANCE.getClickColumn_Name();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK_COLUMN__INDEX = eINSTANCE.getClickColumn_Index();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetSortColumnImpl <em>Set Sort Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetSortColumnImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetSortColumn()
		 * @generated
		 */
		EClass SET_SORT_COLUMN = eINSTANCE.getSetSortColumn();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_SORT_COLUMN__NAME = eINSTANCE.getSetSortColumn_Name();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_SORT_COLUMN__INDEX = eINSTANCE.getSetSortColumn_Index();

		/**
		 * The meta object literal for the '<em><b>Descending</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_SORT_COLUMN__DESCENDING = eINSTANCE.getSetSortColumn_Descending();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.MouseEventImpl <em>Mouse Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.MouseEventImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getMouseEvent()
		 * @generated
		 */
		EClass MOUSE_EVENT = eINSTANCE.getMouseEvent();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_EVENT__KIND = eINSTANCE.getMouseEvent_Kind();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_EVENT__BUTTON = eINSTANCE.getMouseEvent_Button();

		/**
		 * The meta object literal for the '<em><b>State Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_EVENT__STATE_MASK = eINSTANCE.getMouseEvent_StateMask();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_EVENT__COUNT = eINSTANCE.getMouseEvent_Count();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_EVENT__X = eINSTANCE.getMouseEvent_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_EVENT__Y = eINSTANCE.getMouseEvent_Y();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickTextImpl <em>Click Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ClickTextImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getClickText()
		 * @generated
		 */
		EClass CLICK_TEXT = eINSTANCE.getClickText();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK_TEXT__START = eINSTANCE.getClickText_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK_TEXT__END = eINSTANCE.getClickText_End();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLICK_TEXT__BUTTON = eINSTANCE.getClickText_Button();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.DoubleClickTextImpl <em>Double Click Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.DoubleClickTextImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getDoubleClickText()
		 * @generated
		 */
		EClass DOUBLE_CLICK_TEXT = eINSTANCE.getDoubleClickText();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_CLICK_TEXT__POSITION = eINSTANCE.getDoubleClickText_Position();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_CLICK_TEXT__BUTTON = eINSTANCE.getDoubleClickText_Button();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetWidthImpl <em>Set Width</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetWidthImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetWidth()
		 * @generated
		 */
		EClass SET_WIDTH = eINSTANCE.getSetWidth();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_WIDTH__WIDTH = eINSTANCE.getSetWidth_Width();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetPositionImpl <em>Set Position</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.SetPositionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSetPosition()
		 * @generated
		 */
		EClass SET_POSITION = eINSTANCE.getSetPosition();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_POSITION__INDEX = eINSTANCE.getSetPosition_Index();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.SWTDialogKind <em>SWT Dialog Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.SWTDialogKind
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getSWTDialogKind()
		 * @generated
		 */
		EEnum SWT_DIALOG_KIND = eINSTANCE.getSWTDialogKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.AssertKind <em>Assert Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.AssertKind
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getAssertKind()
		 * @generated
		 */
		EEnum ASSERT_KIND = eINSTANCE.getAssertKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.DragKind <em>Drag Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.DragKind
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getDragKind()
		 * @generated
		 */
		EEnum DRAG_KIND = eINSTANCE.getDragKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.MouseEventKind <em>Mouse Event Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.MouseEventKind
		 * @see org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolPackageImpl#getMouseEventKind()
		 * @generated
		 */
		EEnum MOUSE_EVENT_KIND = eINSTANCE.getMouseEventKind();

	}

} //ProtocolPackage
