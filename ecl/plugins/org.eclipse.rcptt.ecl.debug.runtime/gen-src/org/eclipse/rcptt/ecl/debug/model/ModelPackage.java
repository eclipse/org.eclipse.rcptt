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
package org.eclipse.rcptt.ecl.debug.model;

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
 * @see org.eclipse.rcptt.ecl.debug.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/debug/runtime/model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.ecl.debug.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.EventImpl
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.BreakpointEventImpl <em>Breakpoint Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.BreakpointEventImpl
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getBreakpointEvent()
	 * @generated
	 */
	int BREAKPOINT_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT_EVENT__TYPE = EVENT__TYPE;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT_EVENT__LINE = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT_EVENT__PATH = EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Breakpoint Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.StackEventImpl <em>Stack Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.StackEventImpl
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getStackEvent()
	 * @generated
	 */
	int STACK_EVENT = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_EVENT__TYPE = EVENT__TYPE;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_EVENT__LINE = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_EVENT__PATH = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Stack Frame</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_EVENT__STACK_FRAME = EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Stack Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.StackFrameImpl <em>Stack Frame</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.StackFrameImpl
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getStackFrame()
	 * @generated
	 */
	int STACK_FRAME = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__ID = 0;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__FILE = 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__LINE = 2;

	/**
	 * The feature id for the '<em><b>Command</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__COMMAND = 3;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__VARIABLES = 4;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__COLUMN = 5;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__LENGTH = 6;

	/**
	 * The number of structural features of the '<em>Stack Frame</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.VariableImpl
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__VALUE = 2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__CHILDREN = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ID = 4;

	/**
	 * The feature id for the '<em><b>Object Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__OBJECT_REF = 5;

	/**
	 * The feature id for the '<em><b>Complex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__COMPLEX = 6;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__KIND = 7;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.ResolveVariableEventImpl <em>Resolve Variable Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.ResolveVariableEventImpl
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getResolveVariableEvent()
	 * @generated
	 */
	int RESOLVE_VARIABLE_EVENT = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_VARIABLE_EVENT__TYPE = EVENT__TYPE;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_VARIABLE_EVENT__VARIABLE = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resolve Variable Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_VARIABLE_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.DebugCmdImpl <em>Debug Cmd</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.DebugCmdImpl
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getDebugCmd()
	 * @generated
	 */
	int DEBUG_CMD = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CMD__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Debug Cmd</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CMD_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.SkipAllCmdImpl <em>Skip All Cmd</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.SkipAllCmdImpl
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getSkipAllCmd()
	 * @generated
	 */
	int SKIP_ALL_CMD = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_ALL_CMD__TYPE = DEBUG_CMD__TYPE;

	/**
	 * The feature id for the '<em><b>Skip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_ALL_CMD__SKIP = DEBUG_CMD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Skip All Cmd</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SKIP_ALL_CMD_FEATURE_COUNT = DEBUG_CMD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.BreakpointCmdImpl <em>Breakpoint Cmd</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.BreakpointCmdImpl
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getBreakpointCmd()
	 * @generated
	 */
	int BREAKPOINT_CMD = 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT_CMD__TYPE = DEBUG_CMD__TYPE;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT_CMD__LINE = DEBUG_CMD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT_CMD__PATH = DEBUG_CMD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Breakpoint Cmd</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT_CMD_FEATURE_COUNT = DEBUG_CMD_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.ResolveVariableCmdImpl <em>Resolve Variable Cmd</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.ResolveVariableCmdImpl
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getResolveVariableCmd()
	 * @generated
	 */
	int RESOLVE_VARIABLE_CMD = 9;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_VARIABLE_CMD__TYPE = DEBUG_CMD__TYPE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_VARIABLE_CMD__ID = DEBUG_CMD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resolve Variable Cmd</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLVE_VARIABLE_CMD_FEATURE_COUNT = DEBUG_CMD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.model.VariableKind <em>Variable Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.model.VariableKind
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getVariableKind()
	 * @generated
	 */
	int VARIABLE_KIND = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.model.EventType <em>Event Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.model.EventType
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getEventType()
	 * @generated
	 */
	int EVENT_TYPE = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.debug.model.DebugType <em>Debug Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.debug.model.DebugType
	 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getDebugType()
	 * @generated
	 */
	int DEBUG_TYPE = 12;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.debug.model.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.Event#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.Event#getType()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.debug.model.BreakpointEvent <em>Breakpoint Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Breakpoint Event</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.BreakpointEvent
	 * @generated
	 */
	EClass getBreakpointEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.BreakpointEvent#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.BreakpointEvent#getLine()
	 * @see #getBreakpointEvent()
	 * @generated
	 */
	EAttribute getBreakpointEvent_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.BreakpointEvent#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.BreakpointEvent#getPath()
	 * @see #getBreakpointEvent()
	 * @generated
	 */
	EAttribute getBreakpointEvent_Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.debug.model.StackEvent <em>Stack Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stack Event</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.StackEvent
	 * @generated
	 */
	EClass getStackEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.StackEvent#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.StackEvent#getLine()
	 * @see #getStackEvent()
	 * @generated
	 */
	EAttribute getStackEvent_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.StackEvent#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.StackEvent#getPath()
	 * @see #getStackEvent()
	 * @generated
	 */
	EAttribute getStackEvent_Path();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.rcptt.ecl.debug.model.StackEvent#getStackFrame <em>Stack Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stack Frame</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.StackEvent#getStackFrame()
	 * @see #getStackEvent()
	 * @generated
	 */
	EReference getStackEvent_StackFrame();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.debug.model.StackFrame <em>Stack Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stack Frame</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.StackFrame
	 * @generated
	 */
	EClass getStackFrame();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.StackFrame#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.StackFrame#getId()
	 * @see #getStackFrame()
	 * @generated
	 */
	EAttribute getStackFrame_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.StackFrame#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.StackFrame#getFile()
	 * @see #getStackFrame()
	 * @generated
	 */
	EAttribute getStackFrame_File();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.StackFrame#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.StackFrame#getLine()
	 * @see #getStackFrame()
	 * @generated
	 */
	EAttribute getStackFrame_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.StackFrame#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.StackFrame#getCommand()
	 * @see #getStackFrame()
	 * @generated
	 */
	EAttribute getStackFrame_Command();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.rcptt.ecl.debug.model.StackFrame#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variables</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.StackFrame#getVariables()
	 * @see #getStackFrame()
	 * @generated
	 */
	EReference getStackFrame_Variables();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.StackFrame#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.StackFrame#getColumn()
	 * @see #getStackFrame()
	 * @generated
	 */
	EAttribute getStackFrame_Column();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.StackFrame#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.StackFrame#getLength()
	 * @see #getStackFrame()
	 * @generated
	 */
	EAttribute getStackFrame_Length();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.debug.model.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.Variable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.Variable#getType()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.Variable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.Variable#getName()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.debug.model.Variable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.Variable#getValue()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Value();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.ecl.debug.model.Variable#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.Variable#getChildren()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Children();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.Variable#getObjectRef <em>Object Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object Ref</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.Variable#getObjectRef()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_ObjectRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.Variable#isComplex <em>Complex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Complex</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.Variable#isComplex()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Complex();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.Variable#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.Variable#getKind()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.Variable#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.Variable#getId()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.debug.model.ResolveVariableEvent <em>Resolve Variable Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolve Variable Event</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.ResolveVariableEvent
	 * @generated
	 */
	EClass getResolveVariableEvent();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.debug.model.ResolveVariableEvent#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.ResolveVariableEvent#getVariable()
	 * @see #getResolveVariableEvent()
	 * @generated
	 */
	EReference getResolveVariableEvent_Variable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.debug.model.DebugCmd <em>Debug Cmd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Debug Cmd</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.DebugCmd
	 * @generated
	 */
	EClass getDebugCmd();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.DebugCmd#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.DebugCmd#getType()
	 * @see #getDebugCmd()
	 * @generated
	 */
	EAttribute getDebugCmd_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.debug.model.SkipAllCmd <em>Skip All Cmd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Skip All Cmd</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.SkipAllCmd
	 * @generated
	 */
	EClass getSkipAllCmd();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.SkipAllCmd#isSkip <em>Skip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Skip</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.SkipAllCmd#isSkip()
	 * @see #getSkipAllCmd()
	 * @generated
	 */
	EAttribute getSkipAllCmd_Skip();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.debug.model.BreakpointCmd <em>Breakpoint Cmd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Breakpoint Cmd</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.BreakpointCmd
	 * @generated
	 */
	EClass getBreakpointCmd();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.BreakpointCmd#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.BreakpointCmd#getLine()
	 * @see #getBreakpointCmd()
	 * @generated
	 */
	EAttribute getBreakpointCmd_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.BreakpointCmd#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.BreakpointCmd#getPath()
	 * @see #getBreakpointCmd()
	 * @generated
	 */
	EAttribute getBreakpointCmd_Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.debug.model.ResolveVariableCmd <em>Resolve Variable Cmd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolve Variable Cmd</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.ResolveVariableCmd
	 * @generated
	 */
	EClass getResolveVariableCmd();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.debug.model.ResolveVariableCmd#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.ResolveVariableCmd#getId()
	 * @see #getResolveVariableCmd()
	 * @generated
	 */
	EAttribute getResolveVariableCmd_Id();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.ecl.debug.model.VariableKind <em>Variable Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Kind</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.VariableKind
	 * @generated
	 */
	EEnum getVariableKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.ecl.debug.model.EventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Event Type</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.EventType
	 * @generated
	 */
	EEnum getEventType();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.ecl.debug.model.DebugType <em>Debug Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Debug Type</em>'.
	 * @see org.eclipse.rcptt.ecl.debug.model.DebugType
	 * @generated
	 */
	EEnum getDebugType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.EventImpl
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TYPE = eINSTANCE.getEvent_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.BreakpointEventImpl <em>Breakpoint Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.BreakpointEventImpl
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getBreakpointEvent()
		 * @generated
		 */
		EClass BREAKPOINT_EVENT = eINSTANCE.getBreakpointEvent();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BREAKPOINT_EVENT__LINE = eINSTANCE.getBreakpointEvent_Line();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BREAKPOINT_EVENT__PATH = eINSTANCE.getBreakpointEvent_Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.StackEventImpl <em>Stack Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.StackEventImpl
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getStackEvent()
		 * @generated
		 */
		EClass STACK_EVENT = eINSTANCE.getStackEvent();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_EVENT__LINE = eINSTANCE.getStackEvent_Line();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_EVENT__PATH = eINSTANCE.getStackEvent_Path();

		/**
		 * The meta object literal for the '<em><b>Stack Frame</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STACK_EVENT__STACK_FRAME = eINSTANCE.getStackEvent_StackFrame();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.StackFrameImpl <em>Stack Frame</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.StackFrameImpl
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getStackFrame()
		 * @generated
		 */
		EClass STACK_FRAME = eINSTANCE.getStackFrame();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_FRAME__ID = eINSTANCE.getStackFrame_Id();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_FRAME__FILE = eINSTANCE.getStackFrame_File();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_FRAME__LINE = eINSTANCE.getStackFrame_Line();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_FRAME__COMMAND = eINSTANCE.getStackFrame_Command();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STACK_FRAME__VARIABLES = eINSTANCE.getStackFrame_Variables();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_FRAME__COLUMN = eINSTANCE.getStackFrame_Column();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_FRAME__LENGTH = eINSTANCE.getStackFrame_Length();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.VariableImpl
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__TYPE = eINSTANCE.getVariable_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__VALUE = eINSTANCE.getVariable_Value();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__CHILDREN = eINSTANCE.getVariable_Children();

		/**
		 * The meta object literal for the '<em><b>Object Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__OBJECT_REF = eINSTANCE.getVariable_ObjectRef();

		/**
		 * The meta object literal for the '<em><b>Complex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__COMPLEX = eINSTANCE.getVariable_Complex();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__KIND = eINSTANCE.getVariable_Kind();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__ID = eINSTANCE.getVariable_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.ResolveVariableEventImpl <em>Resolve Variable Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.ResolveVariableEventImpl
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getResolveVariableEvent()
		 * @generated
		 */
		EClass RESOLVE_VARIABLE_EVENT = eINSTANCE.getResolveVariableEvent();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOLVE_VARIABLE_EVENT__VARIABLE = eINSTANCE.getResolveVariableEvent_Variable();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.DebugCmdImpl <em>Debug Cmd</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.DebugCmdImpl
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getDebugCmd()
		 * @generated
		 */
		EClass DEBUG_CMD = eINSTANCE.getDebugCmd();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_CMD__TYPE = eINSTANCE.getDebugCmd_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.SkipAllCmdImpl <em>Skip All Cmd</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.SkipAllCmdImpl
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getSkipAllCmd()
		 * @generated
		 */
		EClass SKIP_ALL_CMD = eINSTANCE.getSkipAllCmd();

		/**
		 * The meta object literal for the '<em><b>Skip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SKIP_ALL_CMD__SKIP = eINSTANCE.getSkipAllCmd_Skip();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.BreakpointCmdImpl <em>Breakpoint Cmd</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.BreakpointCmdImpl
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getBreakpointCmd()
		 * @generated
		 */
		EClass BREAKPOINT_CMD = eINSTANCE.getBreakpointCmd();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BREAKPOINT_CMD__LINE = eINSTANCE.getBreakpointCmd_Line();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BREAKPOINT_CMD__PATH = eINSTANCE.getBreakpointCmd_Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.model.impl.ResolveVariableCmdImpl <em>Resolve Variable Cmd</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.ResolveVariableCmdImpl
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getResolveVariableCmd()
		 * @generated
		 */
		EClass RESOLVE_VARIABLE_CMD = eINSTANCE.getResolveVariableCmd();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOLVE_VARIABLE_CMD__ID = eINSTANCE.getResolveVariableCmd_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.model.VariableKind <em>Variable Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.model.VariableKind
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getVariableKind()
		 * @generated
		 */
		EEnum VARIABLE_KIND = eINSTANCE.getVariableKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.model.EventType <em>Event Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.model.EventType
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getEventType()
		 * @generated
		 */
		EEnum EVENT_TYPE = eINSTANCE.getEventType();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.debug.model.DebugType <em>Debug Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.debug.model.DebugType
		 * @see org.eclipse.rcptt.ecl.debug.model.impl.ModelPackageImpl#getDebugType()
		 * @generated
		 */
		EEnum DEBUG_TYPE = eINSTANCE.getDebugType();

	}

} //ModelPackage
