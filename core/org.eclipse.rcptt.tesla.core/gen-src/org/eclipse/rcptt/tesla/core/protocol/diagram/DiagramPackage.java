/*******************************************************************************
 * Copyright (c) 2014-2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.tesla.core.protocol.diagram;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;

import org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage;

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
 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramFactory
 * @model kind="package"
 * @generated
 */
public interface DiagramPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "diagram";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/tesla/diagram";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.tesla.diagram";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagramPackage eINSTANCE = org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateFigureImpl <em>Create Figure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateFigureImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getCreateFigure()
	 * @generated
	 */
	int CREATE_FIGURE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FIGURE__ID = ProtocolPackage.ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FIGURE__ELEMENT = ProtocolPackage.ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FIGURE__X = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FIGURE__Y = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FIGURE__PATTERN = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Gues Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FIGURE__GUES_POSITION = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Create Figure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FIGURE_FEATURE_COUNT = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateFigureResponseImpl <em>Create Figure Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateFigureResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getCreateFigureResponse()
	 * @generated
	 */
	int CREATE_FIGURE_RESPONSE = 1;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FIGURE_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FIGURE_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FIGURE_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>Figure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FIGURE_RESPONSE__FIGURE = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Create Figure Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FIGURE_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MoveFigureImpl <em>Move Figure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MoveFigureImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getMoveFigure()
	 * @generated
	 */
	int MOVE_FIGURE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_FIGURE__ID = ProtocolPackage.ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_FIGURE__ELEMENT = ProtocolPackage.ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_FIGURE__X = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_FIGURE__Y = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Move Figure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_FIGURE_FEATURE_COUNT = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.SetFigureSelectionImpl <em>Set Figure Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.SetFigureSelectionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getSetFigureSelection()
	 * @generated
	 */
	int SET_FIGURE_SELECTION = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FIGURE_SELECTION__ID = ProtocolPackage.ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FIGURE_SELECTION__ELEMENT = ProtocolPackage.ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Figures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FIGURE_SELECTION__FIGURES = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Set Figure Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_FIGURE_SELECTION_FEATURE_COUNT = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.GetFiguresImpl <em>Get Figures</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.GetFiguresImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getGetFigures()
	 * @generated
	 */
	int GET_FIGURES = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FIGURES__ID = ProtocolPackage.ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FIGURES__ELEMENT = ProtocolPackage.ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Get Figures</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FIGURES_FEATURE_COUNT = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.GetFiguresResponseImpl <em>Get Figures Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.GetFiguresResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getGetFiguresResponse()
	 * @generated
	 */
	int GET_FIGURES_RESPONSE = 5;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FIGURES_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FIGURES_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FIGURES_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>Figures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FIGURES_RESPONSE__FIGURES = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Figures Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FIGURES_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.ActivateDirectEditImpl <em>Activate Direct Edit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.ActivateDirectEditImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getActivateDirectEdit()
	 * @generated
	 */
	int ACTIVATE_DIRECT_EDIT = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_DIRECT_EDIT__ID = ProtocolPackage.ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_DIRECT_EDIT__ELEMENT = ProtocolPackage.ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Part Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_DIRECT_EDIT__PART_PATH = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Activate Direct Edit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_DIRECT_EDIT_FEATURE_COUNT = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CancelDirectEditImpl <em>Cancel Direct Edit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CancelDirectEditImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getCancelDirectEdit()
	 * @generated
	 */
	int CANCEL_DIRECT_EDIT = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_DIRECT_EDIT__ID = ProtocolPackage.ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_DIRECT_EDIT__ELEMENT = ProtocolPackage.ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Cancel Direct Edit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_DIRECT_EDIT_FEATURE_COUNT = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CommitDirectEditImpl <em>Commit Direct Edit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CommitDirectEditImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getCommitDirectEdit()
	 * @generated
	 */
	int COMMIT_DIRECT_EDIT = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMIT_DIRECT_EDIT__ID = ProtocolPackage.ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMIT_DIRECT_EDIT__ELEMENT = ProtocolPackage.ELEMENT_COMMAND__ELEMENT;

	/**
	 * The number of structural features of the '<em>Commit Direct Edit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMIT_DIRECT_EDIT_FEATURE_COUNT = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateConnectionImpl <em>Create Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateConnectionImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getCreateConnection()
	 * @generated
	 */
	int CREATE_CONNECTION = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONNECTION__ID = ProtocolPackage.ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONNECTION__ELEMENT = ProtocolPackage.ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONNECTION__PATTERN = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONNECTION__FROM = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONNECTION__TO = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Create Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONNECTION_FEATURE_COUNT = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateConnectionResponseImpl <em>Create Connection Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateConnectionResponseImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getCreateConnectionResponse()
	 * @generated
	 */
	int CREATE_CONNECTION_RESPONSE = 10;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONNECTION_RESPONSE__STATUS = RawPackage.RESPONSE__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONNECTION_RESPONSE__MESSAGE = RawPackage.RESPONSE__MESSAGE;

	/**
	 * The feature id for the '<em><b>Advanced Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONNECTION_RESPONSE__ADVANCED_INFORMATION = RawPackage.RESPONSE__ADVANCED_INFORMATION;

	/**
	 * The feature id for the '<em><b>Figure</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONNECTION_RESPONSE__FIGURE = RawPackage.RESPONSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Create Connection Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_CONNECTION_RESPONSE_FEATURE_COUNT = RawPackage.RESPONSE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.ResizeFigureImpl <em>Resize Figure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.ResizeFigureImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getResizeFigure()
	 * @generated
	 */
	int RESIZE_FIGURE = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESIZE_FIGURE__ID = ProtocolPackage.ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESIZE_FIGURE__ELEMENT = ProtocolPackage.ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESIZE_FIGURE__X = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESIZE_FIGURE__Y = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resize Figure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESIZE_FIGURE_FEATURE_COUNT = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MouseCommandImpl <em>Mouse Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MouseCommandImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getMouseCommand()
	 * @generated
	 */
	int MOUSE_COMMAND = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_COMMAND__ID = ProtocolPackage.ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_COMMAND__ELEMENT = ProtocolPackage.ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_COMMAND__X = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_COMMAND__Y = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_COMMAND__BUTTON = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_COMMAND__KIND = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Bounds Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_COMMAND__BOUNDS_WIDTH = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Bounds Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_COMMAND__BOUNDS_HEIGHT = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>State Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_COMMAND__STATE_MASK = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Mouse Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_COMMAND_FEATURE_COUNT = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.FigureMouseCommandImpl <em>Figure Mouse Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.FigureMouseCommandImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getFigureMouseCommand()
	 * @generated
	 */
	int FIGURE_MOUSE_COMMAND = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIGURE_MOUSE_COMMAND__ID = ProtocolPackage.ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIGURE_MOUSE_COMMAND__ELEMENT = ProtocolPackage.ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIGURE_MOUSE_COMMAND__X = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIGURE_MOUSE_COMMAND__Y = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIGURE_MOUSE_COMMAND__BUTTON = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIGURE_MOUSE_COMMAND__KIND = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Figure Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIGURE_MOUSE_COMMAND__FIGURE_PATH = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Part Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIGURE_MOUSE_COMMAND__PART_PATH = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Bounds Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIGURE_MOUSE_COMMAND__BOUNDS_WIDTH = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Bounds Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIGURE_MOUSE_COMMAND__BOUNDS_HEIGHT = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>State Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIGURE_MOUSE_COMMAND__STATE_MASK = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Figure Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIGURE_MOUSE_COMMAND__FIGURE_WIDTH = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Figure Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIGURE_MOUSE_COMMAND__FIGURE_HEIGHT = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Figure Mouse Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIGURE_MOUSE_COMMAND_FEATURE_COUNT = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.AssertFigureExistsImpl <em>Assert Figure Exists</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.AssertFigureExistsImpl
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getAssertFigureExists()
	 * @generated
	 */
	int ASSERT_FIGURE_EXISTS = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_FIGURE_EXISTS__ID = ProtocolPackage.ELEMENT_COMMAND__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_FIGURE_EXISTS__ELEMENT = ProtocolPackage.ELEMENT_COMMAND__ELEMENT;

	/**
	 * The feature id for the '<em><b>Part Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_FIGURE_EXISTS__PART_PATH = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Figure ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_FIGURE_EXISTS__FIGURE_ID = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assert Figure Exists</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_FIGURE_EXISTS_FEATURE_COUNT = ProtocolPackage.ELEMENT_COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind <em>Mouse Command Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getMouseCommandKind()
	 * @generated
	 */
	int MOUSE_COMMAND_KIND = 15;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigure <em>Create Figure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Figure</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigure
	 * @generated
	 */
	EClass getCreateFigure();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigure#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigure#getX()
	 * @see #getCreateFigure()
	 * @generated
	 */
	EAttribute getCreateFigure_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigure#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigure#getY()
	 * @see #getCreateFigure()
	 * @generated
	 */
	EAttribute getCreateFigure_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigure#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigure#getPattern()
	 * @see #getCreateFigure()
	 * @generated
	 */
	EAttribute getCreateFigure_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigure#isGuesPosition <em>Gues Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gues Position</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigure#isGuesPosition()
	 * @see #getCreateFigure()
	 * @generated
	 */
	EAttribute getCreateFigure_GuesPosition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigureResponse <em>Create Figure Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Figure Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigureResponse
	 * @generated
	 */
	EClass getCreateFigureResponse();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigureResponse#getFigure <em>Figure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Figure</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigureResponse#getFigure()
	 * @see #getCreateFigureResponse()
	 * @generated
	 */
	EReference getCreateFigureResponse_Figure();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.MoveFigure <em>Move Figure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Move Figure</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MoveFigure
	 * @generated
	 */
	EClass getMoveFigure();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.MoveFigure#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MoveFigure#getX()
	 * @see #getMoveFigure()
	 * @generated
	 */
	EAttribute getMoveFigure_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.MoveFigure#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MoveFigure#getY()
	 * @see #getMoveFigure()
	 * @generated
	 */
	EAttribute getMoveFigure_Y();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.SetFigureSelection <em>Set Figure Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Figure Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.SetFigureSelection
	 * @generated
	 */
	EClass getSetFigureSelection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.SetFigureSelection#getFigures <em>Figures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Figures</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.SetFigureSelection#getFigures()
	 * @see #getSetFigureSelection()
	 * @generated
	 */
	EReference getSetFigureSelection_Figures();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.GetFigures <em>Get Figures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Figures</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.GetFigures
	 * @generated
	 */
	EClass getGetFigures();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.GetFiguresResponse <em>Get Figures Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Figures Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.GetFiguresResponse
	 * @generated
	 */
	EClass getGetFiguresResponse();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.GetFiguresResponse#getFigures <em>Figures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Figures</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.GetFiguresResponse#getFigures()
	 * @see #getGetFiguresResponse()
	 * @generated
	 */
	EReference getGetFiguresResponse_Figures();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.ActivateDirectEdit <em>Activate Direct Edit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activate Direct Edit</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.ActivateDirectEdit
	 * @generated
	 */
	EClass getActivateDirectEdit();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.ActivateDirectEdit#getPartPath <em>Part Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Part Path</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.ActivateDirectEdit#getPartPath()
	 * @see #getActivateDirectEdit()
	 * @generated
	 */
	EAttribute getActivateDirectEdit_PartPath();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CancelDirectEdit <em>Cancel Direct Edit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cancel Direct Edit</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.CancelDirectEdit
	 * @generated
	 */
	EClass getCancelDirectEdit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CommitDirectEdit <em>Commit Direct Edit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Commit Direct Edit</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.CommitDirectEdit
	 * @generated
	 */
	EClass getCommitDirectEdit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnection <em>Create Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Connection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnection
	 * @generated
	 */
	EClass getCreateConnection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnection#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnection#getPattern()
	 * @see #getCreateConnection()
	 * @generated
	 */
	EAttribute getCreateConnection_Pattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnection#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnection#getFrom()
	 * @see #getCreateConnection()
	 * @generated
	 */
	EReference getCreateConnection_From();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnection#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnection#getTo()
	 * @see #getCreateConnection()
	 * @generated
	 */
	EReference getCreateConnection_To();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnectionResponse <em>Create Connection Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Connection Response</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnectionResponse
	 * @generated
	 */
	EClass getCreateConnectionResponse();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnectionResponse#getFigure <em>Figure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Figure</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnectionResponse#getFigure()
	 * @see #getCreateConnectionResponse()
	 * @generated
	 */
	EReference getCreateConnectionResponse_Figure();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.ResizeFigure <em>Resize Figure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resize Figure</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.ResizeFigure
	 * @generated
	 */
	EClass getResizeFigure();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.ResizeFigure#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.ResizeFigure#getX()
	 * @see #getResizeFigure()
	 * @generated
	 */
	EAttribute getResizeFigure_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.ResizeFigure#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.ResizeFigure#getY()
	 * @see #getResizeFigure()
	 * @generated
	 */
	EAttribute getResizeFigure_Y();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand <em>Mouse Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mouse Command</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand
	 * @generated
	 */
	EClass getMouseCommand();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand#getX()
	 * @see #getMouseCommand()
	 * @generated
	 */
	EAttribute getMouseCommand_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand#getY()
	 * @see #getMouseCommand()
	 * @generated
	 */
	EAttribute getMouseCommand_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand#getButton()
	 * @see #getMouseCommand()
	 * @generated
	 */
	EAttribute getMouseCommand_Button();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand#getKind()
	 * @see #getMouseCommand()
	 * @generated
	 */
	EAttribute getMouseCommand_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand#getBoundsWidth <em>Bounds Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bounds Width</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand#getBoundsWidth()
	 * @see #getMouseCommand()
	 * @generated
	 */
	EAttribute getMouseCommand_BoundsWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand#getBoundsHeight <em>Bounds Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bounds Height</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand#getBoundsHeight()
	 * @see #getMouseCommand()
	 * @generated
	 */
	EAttribute getMouseCommand_BoundsHeight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand#getStateMask <em>State Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Mask</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand#getStateMask()
	 * @see #getMouseCommand()
	 * @generated
	 */
	EAttribute getMouseCommand_StateMask();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand <em>Figure Mouse Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Figure Mouse Command</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand
	 * @generated
	 */
	EClass getFigureMouseCommand();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getX()
	 * @see #getFigureMouseCommand()
	 * @generated
	 */
	EAttribute getFigureMouseCommand_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getY()
	 * @see #getFigureMouseCommand()
	 * @generated
	 */
	EAttribute getFigureMouseCommand_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getButton()
	 * @see #getFigureMouseCommand()
	 * @generated
	 */
	EAttribute getFigureMouseCommand_Button();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getKind()
	 * @see #getFigureMouseCommand()
	 * @generated
	 */
	EAttribute getFigureMouseCommand_Kind();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getFigurePath <em>Figure Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Figure Path</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getFigurePath()
	 * @see #getFigureMouseCommand()
	 * @generated
	 */
	EAttribute getFigureMouseCommand_FigurePath();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getPartPath <em>Part Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Part Path</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getPartPath()
	 * @see #getFigureMouseCommand()
	 * @generated
	 */
	EAttribute getFigureMouseCommand_PartPath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getBoundsWidth <em>Bounds Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bounds Width</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getBoundsWidth()
	 * @see #getFigureMouseCommand()
	 * @generated
	 */
	EAttribute getFigureMouseCommand_BoundsWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getBoundsHeight <em>Bounds Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bounds Height</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getBoundsHeight()
	 * @see #getFigureMouseCommand()
	 * @generated
	 */
	EAttribute getFigureMouseCommand_BoundsHeight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getStateMask <em>State Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Mask</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getStateMask()
	 * @see #getFigureMouseCommand()
	 * @generated
	 */
	EAttribute getFigureMouseCommand_StateMask();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getFigureWidth <em>Figure Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Figure Width</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getFigureWidth()
	 * @see #getFigureMouseCommand()
	 * @generated
	 */
	EAttribute getFigureMouseCommand_FigureWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getFigureHeight <em>Figure Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Figure Height</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getFigureHeight()
	 * @see #getFigureMouseCommand()
	 * @generated
	 */
	EAttribute getFigureMouseCommand_FigureHeight();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.AssertFigureExists <em>Assert Figure Exists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assert Figure Exists</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.AssertFigureExists
	 * @generated
	 */
	EClass getAssertFigureExists();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.AssertFigureExists#getPartPath <em>Part Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Part Path</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.AssertFigureExists#getPartPath()
	 * @see #getAssertFigureExists()
	 * @generated
	 */
	EAttribute getAssertFigureExists_PartPath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.AssertFigureExists#getFigureID <em>Figure ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Figure ID</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.AssertFigureExists#getFigureID()
	 * @see #getAssertFigureExists()
	 * @generated
	 */
	EAttribute getAssertFigureExists_FigureID();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind <em>Mouse Command Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Mouse Command Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind
	 * @generated
	 */
	EEnum getMouseCommandKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiagramFactory getDiagramFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateFigureImpl <em>Create Figure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateFigureImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getCreateFigure()
		 * @generated
		 */
		EClass CREATE_FIGURE = eINSTANCE.getCreateFigure();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_FIGURE__X = eINSTANCE.getCreateFigure_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_FIGURE__Y = eINSTANCE.getCreateFigure_Y();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_FIGURE__PATTERN = eINSTANCE.getCreateFigure_Pattern();

		/**
		 * The meta object literal for the '<em><b>Gues Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_FIGURE__GUES_POSITION = eINSTANCE.getCreateFigure_GuesPosition();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateFigureResponseImpl <em>Create Figure Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateFigureResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getCreateFigureResponse()
		 * @generated
		 */
		EClass CREATE_FIGURE_RESPONSE = eINSTANCE.getCreateFigureResponse();

		/**
		 * The meta object literal for the '<em><b>Figure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_FIGURE_RESPONSE__FIGURE = eINSTANCE.getCreateFigureResponse_Figure();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MoveFigureImpl <em>Move Figure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MoveFigureImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getMoveFigure()
		 * @generated
		 */
		EClass MOVE_FIGURE = eINSTANCE.getMoveFigure();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVE_FIGURE__X = eINSTANCE.getMoveFigure_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVE_FIGURE__Y = eINSTANCE.getMoveFigure_Y();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.SetFigureSelectionImpl <em>Set Figure Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.SetFigureSelectionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getSetFigureSelection()
		 * @generated
		 */
		EClass SET_FIGURE_SELECTION = eINSTANCE.getSetFigureSelection();

		/**
		 * The meta object literal for the '<em><b>Figures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_FIGURE_SELECTION__FIGURES = eINSTANCE.getSetFigureSelection_Figures();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.GetFiguresImpl <em>Get Figures</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.GetFiguresImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getGetFigures()
		 * @generated
		 */
		EClass GET_FIGURES = eINSTANCE.getGetFigures();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.GetFiguresResponseImpl <em>Get Figures Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.GetFiguresResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getGetFiguresResponse()
		 * @generated
		 */
		EClass GET_FIGURES_RESPONSE = eINSTANCE.getGetFiguresResponse();

		/**
		 * The meta object literal for the '<em><b>Figures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_FIGURES_RESPONSE__FIGURES = eINSTANCE.getGetFiguresResponse_Figures();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.ActivateDirectEditImpl <em>Activate Direct Edit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.ActivateDirectEditImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getActivateDirectEdit()
		 * @generated
		 */
		EClass ACTIVATE_DIRECT_EDIT = eINSTANCE.getActivateDirectEdit();

		/**
		 * The meta object literal for the '<em><b>Part Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATE_DIRECT_EDIT__PART_PATH = eINSTANCE.getActivateDirectEdit_PartPath();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CancelDirectEditImpl <em>Cancel Direct Edit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CancelDirectEditImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getCancelDirectEdit()
		 * @generated
		 */
		EClass CANCEL_DIRECT_EDIT = eINSTANCE.getCancelDirectEdit();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CommitDirectEditImpl <em>Commit Direct Edit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CommitDirectEditImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getCommitDirectEdit()
		 * @generated
		 */
		EClass COMMIT_DIRECT_EDIT = eINSTANCE.getCommitDirectEdit();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateConnectionImpl <em>Create Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateConnectionImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getCreateConnection()
		 * @generated
		 */
		EClass CREATE_CONNECTION = eINSTANCE.getCreateConnection();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_CONNECTION__PATTERN = eINSTANCE.getCreateConnection_Pattern();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_CONNECTION__FROM = eINSTANCE.getCreateConnection_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_CONNECTION__TO = eINSTANCE.getCreateConnection_To();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateConnectionResponseImpl <em>Create Connection Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateConnectionResponseImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getCreateConnectionResponse()
		 * @generated
		 */
		EClass CREATE_CONNECTION_RESPONSE = eINSTANCE.getCreateConnectionResponse();

		/**
		 * The meta object literal for the '<em><b>Figure</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_CONNECTION_RESPONSE__FIGURE = eINSTANCE.getCreateConnectionResponse_Figure();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.ResizeFigureImpl <em>Resize Figure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.ResizeFigureImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getResizeFigure()
		 * @generated
		 */
		EClass RESIZE_FIGURE = eINSTANCE.getResizeFigure();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESIZE_FIGURE__X = eINSTANCE.getResizeFigure_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESIZE_FIGURE__Y = eINSTANCE.getResizeFigure_Y();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MouseCommandImpl <em>Mouse Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MouseCommandImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getMouseCommand()
		 * @generated
		 */
		EClass MOUSE_COMMAND = eINSTANCE.getMouseCommand();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_COMMAND__X = eINSTANCE.getMouseCommand_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_COMMAND__Y = eINSTANCE.getMouseCommand_Y();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_COMMAND__BUTTON = eINSTANCE.getMouseCommand_Button();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_COMMAND__KIND = eINSTANCE.getMouseCommand_Kind();

		/**
		 * The meta object literal for the '<em><b>Bounds Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_COMMAND__BOUNDS_WIDTH = eINSTANCE.getMouseCommand_BoundsWidth();

		/**
		 * The meta object literal for the '<em><b>Bounds Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_COMMAND__BOUNDS_HEIGHT = eINSTANCE.getMouseCommand_BoundsHeight();

		/**
		 * The meta object literal for the '<em><b>State Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_COMMAND__STATE_MASK = eINSTANCE.getMouseCommand_StateMask();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.FigureMouseCommandImpl <em>Figure Mouse Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.FigureMouseCommandImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getFigureMouseCommand()
		 * @generated
		 */
		EClass FIGURE_MOUSE_COMMAND = eINSTANCE.getFigureMouseCommand();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_MOUSE_COMMAND__X = eINSTANCE.getFigureMouseCommand_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_MOUSE_COMMAND__Y = eINSTANCE.getFigureMouseCommand_Y();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_MOUSE_COMMAND__BUTTON = eINSTANCE.getFigureMouseCommand_Button();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_MOUSE_COMMAND__KIND = eINSTANCE.getFigureMouseCommand_Kind();

		/**
		 * The meta object literal for the '<em><b>Figure Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_MOUSE_COMMAND__FIGURE_PATH = eINSTANCE.getFigureMouseCommand_FigurePath();

		/**
		 * The meta object literal for the '<em><b>Part Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_MOUSE_COMMAND__PART_PATH = eINSTANCE.getFigureMouseCommand_PartPath();

		/**
		 * The meta object literal for the '<em><b>Bounds Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_MOUSE_COMMAND__BOUNDS_WIDTH = eINSTANCE.getFigureMouseCommand_BoundsWidth();

		/**
		 * The meta object literal for the '<em><b>Bounds Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_MOUSE_COMMAND__BOUNDS_HEIGHT = eINSTANCE.getFigureMouseCommand_BoundsHeight();

		/**
		 * The meta object literal for the '<em><b>State Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_MOUSE_COMMAND__STATE_MASK = eINSTANCE.getFigureMouseCommand_StateMask();

		/**
		 * The meta object literal for the '<em><b>Figure Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_MOUSE_COMMAND__FIGURE_WIDTH = eINSTANCE.getFigureMouseCommand_FigureWidth();

		/**
		 * The meta object literal for the '<em><b>Figure Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIGURE_MOUSE_COMMAND__FIGURE_HEIGHT = eINSTANCE.getFigureMouseCommand_FigureHeight();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.AssertFigureExistsImpl <em>Assert Figure Exists</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.AssertFigureExistsImpl
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getAssertFigureExists()
		 * @generated
		 */
		EClass ASSERT_FIGURE_EXISTS = eINSTANCE.getAssertFigureExists();

		/**
		 * The meta object literal for the '<em><b>Part Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_FIGURE_EXISTS__PART_PATH = eINSTANCE.getAssertFigureExists_PartPath();

		/**
		 * The meta object literal for the '<em><b>Figure ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_FIGURE_EXISTS__FIGURE_ID = eINSTANCE.getAssertFigureExists_FigureID();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind <em>Mouse Command Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind
		 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramPackageImpl#getMouseCommandKind()
		 * @generated
		 */
		EEnum MOUSE_COMMAND_KIND = eINSTANCE.getMouseCommandKind();

	}

} //DiagramPackage
