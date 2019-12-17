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

import org.eclipse.rcptt.core.scenario.ScenarioPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.rcptt.debug.DebugFactory
 * @model kind="package"
 * @generated
 */
public interface DebugPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "debug";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/ctx/debug";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.ctx.debug";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DebugPackage eINSTANCE = org.eclipse.rcptt.debug.impl.DebugPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.debug.impl.DebugContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.debug.impl.DebugContextImpl
	 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getDebugContext()
	 * @generated
	 */
	int DEBUG_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CONTEXT__NAME = ScenarioPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CONTEXT__VERSION = ScenarioPackage.CONTEXT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CONTEXT__ID = ScenarioPackage.CONTEXT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CONTEXT__DESCRIPTION = ScenarioPackage.CONTEXT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CONTEXT__TAGS = ScenarioPackage.CONTEXT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CONTEXT__ATTACHMENTS = ScenarioPackage.CONTEXT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>No Launches</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CONTEXT__NO_LAUNCHES = ScenarioPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>No Breakpoints</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CONTEXT__NO_BREAKPOINTS = ScenarioPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>No Launch Shortcuts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CONTEXT__NO_LAUNCH_SHORTCUTS = ScenarioPackage.CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Launch Shortcut Exceptions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CONTEXT__LAUNCH_SHORTCUT_EXCEPTIONS = ScenarioPackage.CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Launch Exceptions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CONTEXT__LAUNCH_EXCEPTIONS = ScenarioPackage.CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Breakpoint Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CONTEXT__BREAKPOINT_RESOURCES = ScenarioPackage.CONTEXT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Launches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CONTEXT__LAUNCHES = ScenarioPackage.CONTEXT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Launch Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CONTEXT__LAUNCH_TYPES = ScenarioPackage.CONTEXT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_CONTEXT_FEATURE_COUNT = ScenarioPackage.CONTEXT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.debug.impl.LaunchConfigurationImpl <em>Launch Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.debug.impl.LaunchConfigurationImpl
	 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getLaunchConfiguration()
	 * @generated
	 */
	int LAUNCH_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_CONFIGURATION__NAME = ScenarioPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_CONFIGURATION__VERSION = ScenarioPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_CONFIGURATION__ID = ScenarioPackage.NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_CONFIGURATION__DESCRIPTION = ScenarioPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_CONFIGURATION__TAGS = ScenarioPackage.NAMED_ELEMENT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_CONFIGURATION__ATTACHMENTS = ScenarioPackage.NAMED_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_CONFIGURATION__ATTRIBUTES = ScenarioPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_CONFIGURATION__TYPE_ID = ScenarioPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Launch Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_CONFIGURATION_FEATURE_COUNT = ScenarioPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.debug.impl.CollectionImpl <em>Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.debug.impl.CollectionImpl
	 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getCollection()
	 * @generated
	 */
	int COLLECTION = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__NAME = ScenarioPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__VERSION = ScenarioPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__ID = ScenarioPackage.NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__DESCRIPTION = ScenarioPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__TAGS = ScenarioPackage.NAMED_ELEMENT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__ATTACHMENTS = ScenarioPackage.NAMED_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__ENTRIES = ScenarioPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_FEATURE_COUNT = ScenarioPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.debug.impl.MapValueImpl <em>Map Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.debug.impl.MapValueImpl
	 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getMapValue()
	 * @generated
	 */
	int MAP_VALUE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_VALUE__NAME = COLLECTION__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_VALUE__VERSION = COLLECTION__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_VALUE__ID = COLLECTION__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_VALUE__DESCRIPTION = COLLECTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_VALUE__TAGS = COLLECTION__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_VALUE__ATTACHMENTS = COLLECTION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_VALUE__ENTRIES = COLLECTION__ENTRIES;

	/**
	 * The number of structural features of the '<em>Map Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_VALUE_FEATURE_COUNT = COLLECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.debug.impl.ListValueImpl <em>List Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.debug.impl.ListValueImpl
	 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getListValue()
	 * @generated
	 */
	int LIST_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VALUE__NAME = COLLECTION__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VALUE__VERSION = COLLECTION__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VALUE__ID = COLLECTION__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VALUE__DESCRIPTION = COLLECTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VALUE__TAGS = COLLECTION__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VALUE__ATTACHMENTS = COLLECTION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VALUE__ENTRIES = COLLECTION__ENTRIES;

	/**
	 * The number of structural features of the '<em>List Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VALUE_FEATURE_COUNT = COLLECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.debug.impl.SetValueImpl <em>Set Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.debug.impl.SetValueImpl
	 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getSetValue()
	 * @generated
	 */
	int SET_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE__NAME = COLLECTION__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE__VERSION = COLLECTION__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE__ID = COLLECTION__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE__DESCRIPTION = COLLECTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE__TAGS = COLLECTION__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE__ATTACHMENTS = COLLECTION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE__ENTRIES = COLLECTION__ENTRIES;

	/**
	 * The number of structural features of the '<em>Set Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VALUE_FEATURE_COUNT = COLLECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.debug.impl.LaunchTypeImpl <em>Launch Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.debug.impl.LaunchTypeImpl
	 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getLaunchType()
	 * @generated
	 */
	int LAUNCH_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_TYPE__NAME = ScenarioPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_TYPE__VERSION = ScenarioPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_TYPE__ID = ScenarioPackage.NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_TYPE__DESCRIPTION = ScenarioPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_TYPE__TAGS = ScenarioPackage.NAMED_ELEMENT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_TYPE__ATTACHMENTS = ScenarioPackage.NAMED_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_TYPE__IMAGE = ScenarioPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_TYPE__CONFIGURATIONS = ScenarioPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Launch Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_TYPE_FEATURE_COUNT = ScenarioPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.debug.impl.BreakpointImpl <em>Breakpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.debug.impl.BreakpointImpl
	 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getBreakpoint()
	 * @generated
	 */
	int BREAKPOINT = 6;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT__ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Registered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT__REGISTERED = 1;

	/**
	 * The feature id for the '<em><b>Persisted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT__PERSISTED = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT__ATTRIBUTES = 4;

	/**
	 * The feature id for the '<em><b>Working Sets</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT__WORKING_SETS = 5;

	/**
	 * The number of structural features of the '<em>Breakpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.debug.impl.LaunchImpl <em>Launch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.debug.impl.LaunchImpl
	 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getLaunch()
	 * @generated
	 */
	int LAUNCH = 7;

	/**
	 * The feature id for the '<em><b>Configuration Delta</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH__CONFIGURATION_DELTA = 0;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH__MODE = 1;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH__CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Configuration Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH__CONFIGURATION_NAME = 3;

	/**
	 * The number of structural features of the '<em>Launch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.debug.impl.BreakpointResourceImpl <em>Breakpoint Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.debug.impl.BreakpointResourceImpl
	 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getBreakpointResource()
	 * @generated
	 */
	int BREAKPOINT_RESOURCE = 8;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT_RESOURCE__PATH = 0;

	/**
	 * The feature id for the '<em><b>Breakpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT_RESOURCE__BREAKPOINTS = 1;

	/**
	 * The number of structural features of the '<em>Breakpoint Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAKPOINT_RESOURCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.debug.impl.PrimitiveValueImpl <em>Primitive Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.debug.impl.PrimitiveValueImpl
	 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getPrimitiveValue()
	 * @generated
	 */
	int PRIMITIVE_VALUE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE__NAME = ScenarioPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE__VERSION = ScenarioPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE__ID = ScenarioPackage.NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE__DESCRIPTION = ScenarioPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE__TAGS = ScenarioPackage.NAMED_ELEMENT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE__ATTACHMENTS = ScenarioPackage.NAMED_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE__VALUE = ScenarioPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_VALUE_FEATURE_COUNT = ScenarioPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.debug.DebugContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.eclipse.rcptt.debug.DebugContext
	 * @generated
	 */
	EClass getDebugContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.debug.DebugContext#isNoLaunches <em>No Launches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>No Launches</em>'.
	 * @see org.eclipse.rcptt.debug.DebugContext#isNoLaunches()
	 * @see #getDebugContext()
	 * @generated
	 */
	EAttribute getDebugContext_NoLaunches();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.debug.DebugContext#isNoBreakpoints <em>No Breakpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>No Breakpoints</em>'.
	 * @see org.eclipse.rcptt.debug.DebugContext#isNoBreakpoints()
	 * @see #getDebugContext()
	 * @generated
	 */
	EAttribute getDebugContext_NoBreakpoints();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.debug.DebugContext#isNoLaunchShortcuts <em>No Launch Shortcuts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>No Launch Shortcuts</em>'.
	 * @see org.eclipse.rcptt.debug.DebugContext#isNoLaunchShortcuts()
	 * @see #getDebugContext()
	 * @generated
	 */
	EAttribute getDebugContext_NoLaunchShortcuts();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.debug.DebugContext#getLaunchShortcutExceptions <em>Launch Shortcut Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Launch Shortcut Exceptions</em>'.
	 * @see org.eclipse.rcptt.debug.DebugContext#getLaunchShortcutExceptions()
	 * @see #getDebugContext()
	 * @generated
	 */
	EAttribute getDebugContext_LaunchShortcutExceptions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.debug.DebugContext#getLaunchExceptions <em>Launch Exceptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Launch Exceptions</em>'.
	 * @see org.eclipse.rcptt.debug.DebugContext#getLaunchExceptions()
	 * @see #getDebugContext()
	 * @generated
	 */
	EAttribute getDebugContext_LaunchExceptions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.debug.DebugContext#getBreakpointResources <em>Breakpoint Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Breakpoint Resources</em>'.
	 * @see org.eclipse.rcptt.debug.DebugContext#getBreakpointResources()
	 * @see #getDebugContext()
	 * @generated
	 */
	EReference getDebugContext_BreakpointResources();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.debug.DebugContext#getLaunches <em>Launches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Launches</em>'.
	 * @see org.eclipse.rcptt.debug.DebugContext#getLaunches()
	 * @see #getDebugContext()
	 * @generated
	 */
	EReference getDebugContext_Launches();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.debug.DebugContext#getLaunchTypes <em>Launch Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Launch Types</em>'.
	 * @see org.eclipse.rcptt.debug.DebugContext#getLaunchTypes()
	 * @see #getDebugContext()
	 * @generated
	 */
	EReference getDebugContext_LaunchTypes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.debug.LaunchConfiguration <em>Launch Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Launch Configuration</em>'.
	 * @see org.eclipse.rcptt.debug.LaunchConfiguration
	 * @generated
	 */
	EClass getLaunchConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.debug.LaunchConfiguration#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.eclipse.rcptt.debug.LaunchConfiguration#getAttributes()
	 * @see #getLaunchConfiguration()
	 * @generated
	 */
	EReference getLaunchConfiguration_Attributes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.debug.LaunchConfiguration#getTypeId <em>Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Id</em>'.
	 * @see org.eclipse.rcptt.debug.LaunchConfiguration#getTypeId()
	 * @see #getLaunchConfiguration()
	 * @generated
	 */
	EAttribute getLaunchConfiguration_TypeId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.debug.MapValue <em>Map Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Value</em>'.
	 * @see org.eclipse.rcptt.debug.MapValue
	 * @generated
	 */
	EClass getMapValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.debug.ListValue <em>List Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Value</em>'.
	 * @see org.eclipse.rcptt.debug.ListValue
	 * @generated
	 */
	EClass getListValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.debug.SetValue <em>Set Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Value</em>'.
	 * @see org.eclipse.rcptt.debug.SetValue
	 * @generated
	 */
	EClass getSetValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.debug.LaunchType <em>Launch Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Launch Type</em>'.
	 * @see org.eclipse.rcptt.debug.LaunchType
	 * @generated
	 */
	EClass getLaunchType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.debug.LaunchType#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.eclipse.rcptt.debug.LaunchType#getImage()
	 * @see #getLaunchType()
	 * @generated
	 */
	EAttribute getLaunchType_Image();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.debug.LaunchType#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configurations</em>'.
	 * @see org.eclipse.rcptt.debug.LaunchType#getConfigurations()
	 * @see #getLaunchType()
	 * @generated
	 */
	EReference getLaunchType_Configurations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.debug.Breakpoint <em>Breakpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Breakpoint</em>'.
	 * @see org.eclipse.rcptt.debug.Breakpoint
	 * @generated
	 */
	EClass getBreakpoint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.debug.Breakpoint#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.eclipse.rcptt.debug.Breakpoint#isEnabled()
	 * @see #getBreakpoint()
	 * @generated
	 */
	EAttribute getBreakpoint_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.debug.Breakpoint#isRegistered <em>Registered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Registered</em>'.
	 * @see org.eclipse.rcptt.debug.Breakpoint#isRegistered()
	 * @see #getBreakpoint()
	 * @generated
	 */
	EAttribute getBreakpoint_Registered();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.debug.Breakpoint#isPersisted <em>Persisted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Persisted</em>'.
	 * @see org.eclipse.rcptt.debug.Breakpoint#isPersisted()
	 * @see #getBreakpoint()
	 * @generated
	 */
	EAttribute getBreakpoint_Persisted();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.debug.Breakpoint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.debug.Breakpoint#getType()
	 * @see #getBreakpoint()
	 * @generated
	 */
	EAttribute getBreakpoint_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.debug.Breakpoint#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.eclipse.rcptt.debug.Breakpoint#getAttributes()
	 * @see #getBreakpoint()
	 * @generated
	 */
	EReference getBreakpoint_Attributes();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.debug.Breakpoint#getWorkingSets <em>Working Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Working Sets</em>'.
	 * @see org.eclipse.rcptt.debug.Breakpoint#getWorkingSets()
	 * @see #getBreakpoint()
	 * @generated
	 */
	EAttribute getBreakpoint_WorkingSets();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.debug.Launch <em>Launch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Launch</em>'.
	 * @see org.eclipse.rcptt.debug.Launch
	 * @generated
	 */
	EClass getLaunch();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.debug.Launch#getConfigurationDelta <em>Configuration Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configuration Delta</em>'.
	 * @see org.eclipse.rcptt.debug.Launch#getConfigurationDelta()
	 * @see #getLaunch()
	 * @generated
	 */
	EReference getLaunch_ConfigurationDelta();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.debug.Launch#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see org.eclipse.rcptt.debug.Launch#getMode()
	 * @see #getLaunch()
	 * @generated
	 */
	EAttribute getLaunch_Mode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.debug.Launch#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Configuration</em>'.
	 * @see org.eclipse.rcptt.debug.Launch#getConfiguration()
	 * @see #getLaunch()
	 * @generated
	 */
	EReference getLaunch_Configuration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.debug.Launch#getConfigurationName <em>Configuration Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Configuration Name</em>'.
	 * @see org.eclipse.rcptt.debug.Launch#getConfigurationName()
	 * @see #getLaunch()
	 * @generated
	 */
	EAttribute getLaunch_ConfigurationName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.debug.BreakpointResource <em>Breakpoint Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Breakpoint Resource</em>'.
	 * @see org.eclipse.rcptt.debug.BreakpointResource
	 * @generated
	 */
	EClass getBreakpointResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.debug.BreakpointResource#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.debug.BreakpointResource#getPath()
	 * @see #getBreakpointResource()
	 * @generated
	 */
	EAttribute getBreakpointResource_Path();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.debug.BreakpointResource#getBreakpoints <em>Breakpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Breakpoints</em>'.
	 * @see org.eclipse.rcptt.debug.BreakpointResource#getBreakpoints()
	 * @see #getBreakpointResource()
	 * @generated
	 */
	EReference getBreakpointResource_Breakpoints();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.debug.Collection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection</em>'.
	 * @see org.eclipse.rcptt.debug.Collection
	 * @generated
	 */
	EClass getCollection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.debug.Collection#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see org.eclipse.rcptt.debug.Collection#getEntries()
	 * @see #getCollection()
	 * @generated
	 */
	EReference getCollection_Entries();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.debug.PrimitiveValue <em>Primitive Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Value</em>'.
	 * @see org.eclipse.rcptt.debug.PrimitiveValue
	 * @generated
	 */
	EClass getPrimitiveValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.debug.PrimitiveValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.rcptt.debug.PrimitiveValue#getValue()
	 * @see #getPrimitiveValue()
	 * @generated
	 */
	EReference getPrimitiveValue_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DebugFactory getDebugFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.debug.impl.DebugContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.debug.impl.DebugContextImpl
		 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getDebugContext()
		 * @generated
		 */
		EClass DEBUG_CONTEXT = eINSTANCE.getDebugContext();

		/**
		 * The meta object literal for the '<em><b>No Launches</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_CONTEXT__NO_LAUNCHES = eINSTANCE.getDebugContext_NoLaunches();

		/**
		 * The meta object literal for the '<em><b>No Breakpoints</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_CONTEXT__NO_BREAKPOINTS = eINSTANCE.getDebugContext_NoBreakpoints();

		/**
		 * The meta object literal for the '<em><b>No Launch Shortcuts</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_CONTEXT__NO_LAUNCH_SHORTCUTS = eINSTANCE.getDebugContext_NoLaunchShortcuts();

		/**
		 * The meta object literal for the '<em><b>Launch Shortcut Exceptions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_CONTEXT__LAUNCH_SHORTCUT_EXCEPTIONS = eINSTANCE.getDebugContext_LaunchShortcutExceptions();

		/**
		 * The meta object literal for the '<em><b>Launch Exceptions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_CONTEXT__LAUNCH_EXCEPTIONS = eINSTANCE.getDebugContext_LaunchExceptions();

		/**
		 * The meta object literal for the '<em><b>Breakpoint Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEBUG_CONTEXT__BREAKPOINT_RESOURCES = eINSTANCE.getDebugContext_BreakpointResources();

		/**
		 * The meta object literal for the '<em><b>Launches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEBUG_CONTEXT__LAUNCHES = eINSTANCE.getDebugContext_Launches();

		/**
		 * The meta object literal for the '<em><b>Launch Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEBUG_CONTEXT__LAUNCH_TYPES = eINSTANCE.getDebugContext_LaunchTypes();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.debug.impl.LaunchConfigurationImpl <em>Launch Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.debug.impl.LaunchConfigurationImpl
		 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getLaunchConfiguration()
		 * @generated
		 */
		EClass LAUNCH_CONFIGURATION = eINSTANCE.getLaunchConfiguration();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAUNCH_CONFIGURATION__ATTRIBUTES = eINSTANCE.getLaunchConfiguration_Attributes();

		/**
		 * The meta object literal for the '<em><b>Type Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAUNCH_CONFIGURATION__TYPE_ID = eINSTANCE.getLaunchConfiguration_TypeId();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.debug.impl.MapValueImpl <em>Map Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.debug.impl.MapValueImpl
		 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getMapValue()
		 * @generated
		 */
		EClass MAP_VALUE = eINSTANCE.getMapValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.debug.impl.ListValueImpl <em>List Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.debug.impl.ListValueImpl
		 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getListValue()
		 * @generated
		 */
		EClass LIST_VALUE = eINSTANCE.getListValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.debug.impl.SetValueImpl <em>Set Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.debug.impl.SetValueImpl
		 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getSetValue()
		 * @generated
		 */
		EClass SET_VALUE = eINSTANCE.getSetValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.debug.impl.LaunchTypeImpl <em>Launch Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.debug.impl.LaunchTypeImpl
		 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getLaunchType()
		 * @generated
		 */
		EClass LAUNCH_TYPE = eINSTANCE.getLaunchType();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAUNCH_TYPE__IMAGE = eINSTANCE.getLaunchType_Image();

		/**
		 * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAUNCH_TYPE__CONFIGURATIONS = eINSTANCE.getLaunchType_Configurations();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.debug.impl.BreakpointImpl <em>Breakpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.debug.impl.BreakpointImpl
		 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getBreakpoint()
		 * @generated
		 */
		EClass BREAKPOINT = eINSTANCE.getBreakpoint();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BREAKPOINT__ENABLED = eINSTANCE.getBreakpoint_Enabled();

		/**
		 * The meta object literal for the '<em><b>Registered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BREAKPOINT__REGISTERED = eINSTANCE.getBreakpoint_Registered();

		/**
		 * The meta object literal for the '<em><b>Persisted</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BREAKPOINT__PERSISTED = eINSTANCE.getBreakpoint_Persisted();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BREAKPOINT__TYPE = eINSTANCE.getBreakpoint_Type();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BREAKPOINT__ATTRIBUTES = eINSTANCE.getBreakpoint_Attributes();

		/**
		 * The meta object literal for the '<em><b>Working Sets</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BREAKPOINT__WORKING_SETS = eINSTANCE.getBreakpoint_WorkingSets();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.debug.impl.LaunchImpl <em>Launch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.debug.impl.LaunchImpl
		 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getLaunch()
		 * @generated
		 */
		EClass LAUNCH = eINSTANCE.getLaunch();

		/**
		 * The meta object literal for the '<em><b>Configuration Delta</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAUNCH__CONFIGURATION_DELTA = eINSTANCE.getLaunch_ConfigurationDelta();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAUNCH__MODE = eINSTANCE.getLaunch_Mode();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAUNCH__CONFIGURATION = eINSTANCE.getLaunch_Configuration();

		/**
		 * The meta object literal for the '<em><b>Configuration Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAUNCH__CONFIGURATION_NAME = eINSTANCE.getLaunch_ConfigurationName();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.debug.impl.BreakpointResourceImpl <em>Breakpoint Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.debug.impl.BreakpointResourceImpl
		 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getBreakpointResource()
		 * @generated
		 */
		EClass BREAKPOINT_RESOURCE = eINSTANCE.getBreakpointResource();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BREAKPOINT_RESOURCE__PATH = eINSTANCE.getBreakpointResource_Path();

		/**
		 * The meta object literal for the '<em><b>Breakpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BREAKPOINT_RESOURCE__BREAKPOINTS = eINSTANCE.getBreakpointResource_Breakpoints();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.debug.impl.CollectionImpl <em>Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.debug.impl.CollectionImpl
		 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getCollection()
		 * @generated
		 */
		EClass COLLECTION = eINSTANCE.getCollection();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION__ENTRIES = eINSTANCE.getCollection_Entries();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.debug.impl.PrimitiveValueImpl <em>Primitive Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.debug.impl.PrimitiveValueImpl
		 * @see org.eclipse.rcptt.debug.impl.DebugPackageImpl#getPrimitiveValue()
		 * @generated
		 */
		EClass PRIMITIVE_VALUE = eINSTANCE.getPrimitiveValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_VALUE__VALUE = eINSTANCE.getPrimitiveValue_Value();

	}

} //DebugPackage
