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
package org.eclipse.rcptt.tesla.core.info;

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
 * @see org.eclipse.rcptt.tesla.core.info.InfoFactory
 * @model kind="package"
 * @generated
 */
public interface InfoPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "info";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/tesla/info";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.tesla.info";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InfoPackage eINSTANCE = org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.info.impl.AdvancedInformationImpl <em>Advanced Information</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.info.impl.AdvancedInformationImpl
	 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getAdvancedInformation()
	 * @generated
	 */
	int ADVANCED_INFORMATION = 0;

	/**
	 * The feature id for the '<em><b>Threads</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_INFORMATION__THREADS = 0;

	/**
	 * The feature id for the '<em><b>Jobs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_INFORMATION__JOBS = 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_INFORMATION__MESSAGE = 2;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_INFORMATION__NODES = 3;

	/**
	 * The number of structural features of the '<em>Advanced Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_INFORMATION_FEATURE_COUNT = 4;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.info.impl.StackTraceEntryImpl <em>Stack Trace Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.info.impl.StackTraceEntryImpl
	 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getStackTraceEntry()
	 * @generated
	 */
	int STACK_TRACE_ENTRY = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_TRACE_ENTRY__ID = 0;

	/**
	 * The feature id for the '<em><b>Stack Trace</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_TRACE_ENTRY__STACK_TRACE = 1;

	/**
	 * The feature id for the '<em><b>Thread Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_TRACE_ENTRY__THREAD_NAME = 2;

	/**
	 * The feature id for the '<em><b>Thread Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_TRACE_ENTRY__THREAD_CLASS = 3;

	/**
	 * The number of structural features of the '<em>Stack Trace Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_TRACE_ENTRY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.info.impl.JobEntryImpl <em>Job Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.info.impl.JobEntryImpl
	 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getJobEntry()
	 * @generated
	 */
	int JOB_ENTRY = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_ENTRY__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_ENTRY__NAME = 1;

	/**
	 * The feature id for the '<em><b>Job Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_ENTRY__JOB_CLASS = 2;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_ENTRY__STATE = 3;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_ENTRY__RULE = 4;

	/**
	 * The feature id for the '<em><b>Rule Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_ENTRY__RULE_CLASS = 5;

	/**
	 * The number of structural features of the '<em>Job Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_ENTRY_FEATURE_COUNT = 6;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.info.impl.InfoNodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoNodeImpl
	 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getInfoNode()
	 * @generated
	 */
	int INFO_NODE = 3;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_NODE__CHILDREN = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_NODE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_NODE__PROPERTIES = 2;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_NODE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.info.impl.NodePropertyImpl <em>Node Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.info.impl.NodePropertyImpl
	 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getNodeProperty()
	 * @generated
	 */
	int NODE_PROPERTY = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PROPERTY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Node Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_PROPERTY_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoImpl <em>Q7 Wait Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoImpl
	 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getQ7WaitInfo()
	 * @generated
	 */
	int Q7_WAIT_INFO = 5;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO__START_TIME = 0;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO__END_TIME = 1;

	/**
	 * The feature id for the '<em><b>Last Tick</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO__LAST_TICK = 2;

	/**
	 * The feature id for the '<em><b>Class Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO__CLASS_ID = 3;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO__TYPE_ID = 4;

	/**
	 * The feature id for the '<em><b>Ticks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO__TICKS = 5;

	/**
	 * The number of structural features of the '<em>Q7 Wait Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoRootImpl <em>Q7 Wait Info Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoRootImpl
	 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getQ7WaitInfoRoot()
	 * @generated
	 */
	int Q7_WAIT_INFO_ROOT = 6;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO_ROOT__INFOS = 0;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO_ROOT__START_TIME = 1;

	/**
	 * The feature id for the '<em><b>Tick</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO_ROOT__TICK = 2;

	/**
	 * The feature id for the '<em><b>Class Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO_ROOT__CLASS_NAMES = 3;

	/**
	 * The feature id for the '<em><b>Types Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO_ROOT__TYPES_NAMES = 4;

	/**
	 * The feature id for the '<em><b>Inner Class Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO_ROOT__INNER_CLASS_MAP = 5;

	/**
	 * The number of structural features of the '<em>Q7 Wait Info Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO_ROOT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoInnerClassMapImpl <em>Q7 Wait Info Inner Class Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoInnerClassMapImpl
	 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getQ7WaitInfoInnerClassMap()
	 * @generated
	 */
	int Q7_WAIT_INFO_INNER_CLASS_MAP = 7;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO_INNER_CLASS_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO_INNER_CLASS_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Q7 Wait Info Inner Class Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_WAIT_INFO_INNER_CLASS_MAP_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.info.AdvancedInformation <em>Advanced Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Advanced Information</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.AdvancedInformation
	 * @generated
	 */
	EClass getAdvancedInformation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.info.AdvancedInformation#getThreads <em>Threads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Threads</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.AdvancedInformation#getThreads()
	 * @see #getAdvancedInformation()
	 * @generated
	 */
	EReference getAdvancedInformation_Threads();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.info.AdvancedInformation#getJobs <em>Jobs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Jobs</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.AdvancedInformation#getJobs()
	 * @see #getAdvancedInformation()
	 * @generated
	 */
	EReference getAdvancedInformation_Jobs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.AdvancedInformation#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.AdvancedInformation#getMessage()
	 * @see #getAdvancedInformation()
	 * @generated
	 */
	EAttribute getAdvancedInformation_Message();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.info.AdvancedInformation#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.AdvancedInformation#getNodes()
	 * @see #getAdvancedInformation()
	 * @generated
	 */
	EReference getAdvancedInformation_Nodes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.info.StackTraceEntry <em>Stack Trace Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stack Trace Entry</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.StackTraceEntry
	 * @generated
	 */
	EClass getStackTraceEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.StackTraceEntry#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.StackTraceEntry#getId()
	 * @see #getStackTraceEntry()
	 * @generated
	 */
	EAttribute getStackTraceEntry_Id();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.info.StackTraceEntry#getStackTrace <em>Stack Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Stack Trace</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.StackTraceEntry#getStackTrace()
	 * @see #getStackTraceEntry()
	 * @generated
	 */
	EAttribute getStackTraceEntry_StackTrace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.StackTraceEntry#getThreadName <em>Thread Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thread Name</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.StackTraceEntry#getThreadName()
	 * @see #getStackTraceEntry()
	 * @generated
	 */
	EAttribute getStackTraceEntry_ThreadName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.StackTraceEntry#getThreadClass <em>Thread Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thread Class</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.StackTraceEntry#getThreadClass()
	 * @see #getStackTraceEntry()
	 * @generated
	 */
	EAttribute getStackTraceEntry_ThreadClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.info.JobEntry <em>Job Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Job Entry</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.JobEntry
	 * @generated
	 */
	EClass getJobEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.JobEntry#getId()
	 * @see #getJobEntry()
	 * @generated
	 */
	EAttribute getJobEntry_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.JobEntry#getName()
	 * @see #getJobEntry()
	 * @generated
	 */
	EAttribute getJobEntry_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getJobClass <em>Job Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Job Class</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.JobEntry#getJobClass()
	 * @see #getJobEntry()
	 * @generated
	 */
	EAttribute getJobEntry_JobClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.JobEntry#getState()
	 * @see #getJobEntry()
	 * @generated
	 */
	EAttribute getJobEntry_State();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rule</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.JobEntry#getRule()
	 * @see #getJobEntry()
	 * @generated
	 */
	EAttribute getJobEntry_Rule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getRuleClass <em>Rule Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rule Class</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.JobEntry#getRuleClass()
	 * @see #getJobEntry()
	 * @generated
	 */
	EAttribute getJobEntry_RuleClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.info.InfoNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.InfoNode
	 * @generated
	 */
	EClass getInfoNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.info.InfoNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.InfoNode#getChildren()
	 * @see #getInfoNode()
	 * @generated
	 */
	EReference getInfoNode_Children();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.InfoNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.InfoNode#getName()
	 * @see #getInfoNode()
	 * @generated
	 */
	EAttribute getInfoNode_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.info.InfoNode#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.InfoNode#getProperties()
	 * @see #getInfoNode()
	 * @generated
	 */
	EReference getInfoNode_Properties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.info.NodeProperty <em>Node Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Property</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.NodeProperty
	 * @generated
	 */
	EClass getNodeProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.NodeProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.NodeProperty#getName()
	 * @see #getNodeProperty()
	 * @generated
	 */
	EAttribute getNodeProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.NodeProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.NodeProperty#getValue()
	 * @see #getNodeProperty()
	 * @generated
	 */
	EAttribute getNodeProperty_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo <em>Q7 Wait Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Q7 Wait Info</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.Q7WaitInfo
	 * @generated
	 */
	EClass getQ7WaitInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getStartTime()
	 * @see #getQ7WaitInfo()
	 * @generated
	 */
	EAttribute getQ7WaitInfo_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getEndTime()
	 * @see #getQ7WaitInfo()
	 * @generated
	 */
	EAttribute getQ7WaitInfo_EndTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getLastTick <em>Last Tick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Tick</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getLastTick()
	 * @see #getQ7WaitInfo()
	 * @generated
	 */
	EAttribute getQ7WaitInfo_LastTick();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getClassId <em>Class Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Id</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getClassId()
	 * @see #getQ7WaitInfo()
	 * @generated
	 */
	EAttribute getQ7WaitInfo_ClassId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getTypeId <em>Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Id</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getTypeId()
	 * @see #getQ7WaitInfo()
	 * @generated
	 */
	EAttribute getQ7WaitInfo_TypeId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getTicks <em>Ticks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ticks</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.Q7WaitInfo#getTicks()
	 * @see #getQ7WaitInfo()
	 * @generated
	 */
	EAttribute getQ7WaitInfo_Ticks();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot <em>Q7 Wait Info Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Q7 Wait Info Root</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot
	 * @generated
	 */
	EClass getQ7WaitInfoRoot();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getInfos <em>Infos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Infos</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getInfos()
	 * @see #getQ7WaitInfoRoot()
	 * @generated
	 */
	EReference getQ7WaitInfoRoot_Infos();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getStartTime()
	 * @see #getQ7WaitInfoRoot()
	 * @generated
	 */
	EAttribute getQ7WaitInfoRoot_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getTick <em>Tick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tick</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getTick()
	 * @see #getQ7WaitInfoRoot()
	 * @generated
	 */
	EAttribute getQ7WaitInfoRoot_Tick();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getClassNames <em>Class Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Class Names</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getClassNames()
	 * @see #getQ7WaitInfoRoot()
	 * @generated
	 */
	EAttribute getQ7WaitInfoRoot_ClassNames();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getTypesNames <em>Types Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Types Names</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getTypesNames()
	 * @see #getQ7WaitInfoRoot()
	 * @generated
	 */
	EAttribute getQ7WaitInfoRoot_TypesNames();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getInnerClassMap <em>Inner Class Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Inner Class Map</em>'.
	 * @see org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot#getInnerClassMap()
	 * @see #getQ7WaitInfoRoot()
	 * @generated
	 */
	EReference getQ7WaitInfoRoot_InnerClassMap();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Q7 Wait Info Inner Class Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Q7 Wait Info Inner Class Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getQ7WaitInfoInnerClassMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getQ7WaitInfoInnerClassMap()
	 * @generated
	 */
	EAttribute getQ7WaitInfoInnerClassMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getQ7WaitInfoInnerClassMap()
	 * @generated
	 */
	EAttribute getQ7WaitInfoInnerClassMap_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InfoFactory getInfoFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.info.impl.AdvancedInformationImpl <em>Advanced Information</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.info.impl.AdvancedInformationImpl
		 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getAdvancedInformation()
		 * @generated
		 */
		EClass ADVANCED_INFORMATION = eINSTANCE.getAdvancedInformation();
		/**
		 * The meta object literal for the '<em><b>Threads</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVANCED_INFORMATION__THREADS = eINSTANCE.getAdvancedInformation_Threads();
		/**
		 * The meta object literal for the '<em><b>Jobs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVANCED_INFORMATION__JOBS = eINSTANCE.getAdvancedInformation_Jobs();
		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADVANCED_INFORMATION__MESSAGE = eINSTANCE.getAdvancedInformation_Message();
		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVANCED_INFORMATION__NODES = eINSTANCE.getAdvancedInformation_Nodes();
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.info.impl.StackTraceEntryImpl <em>Stack Trace Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.info.impl.StackTraceEntryImpl
		 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getStackTraceEntry()
		 * @generated
		 */
		EClass STACK_TRACE_ENTRY = eINSTANCE.getStackTraceEntry();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_TRACE_ENTRY__ID = eINSTANCE.getStackTraceEntry_Id();
		/**
		 * The meta object literal for the '<em><b>Stack Trace</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_TRACE_ENTRY__STACK_TRACE = eINSTANCE.getStackTraceEntry_StackTrace();
		/**
		 * The meta object literal for the '<em><b>Thread Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_TRACE_ENTRY__THREAD_NAME = eINSTANCE.getStackTraceEntry_ThreadName();
		/**
		 * The meta object literal for the '<em><b>Thread Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_TRACE_ENTRY__THREAD_CLASS = eINSTANCE.getStackTraceEntry_ThreadClass();
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.info.impl.JobEntryImpl <em>Job Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.info.impl.JobEntryImpl
		 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getJobEntry()
		 * @generated
		 */
		EClass JOB_ENTRY = eINSTANCE.getJobEntry();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_ENTRY__ID = eINSTANCE.getJobEntry_Id();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_ENTRY__NAME = eINSTANCE.getJobEntry_Name();
		/**
		 * The meta object literal for the '<em><b>Job Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_ENTRY__JOB_CLASS = eINSTANCE.getJobEntry_JobClass();
		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_ENTRY__STATE = eINSTANCE.getJobEntry_State();
		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_ENTRY__RULE = eINSTANCE.getJobEntry_Rule();
		/**
		 * The meta object literal for the '<em><b>Rule Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_ENTRY__RULE_CLASS = eINSTANCE.getJobEntry_RuleClass();
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.info.impl.InfoNodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoNodeImpl
		 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getInfoNode()
		 * @generated
		 */
		EClass INFO_NODE = eINSTANCE.getInfoNode();
		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFO_NODE__CHILDREN = eINSTANCE.getInfoNode_Children();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INFO_NODE__NAME = eINSTANCE.getInfoNode_Name();
		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFO_NODE__PROPERTIES = eINSTANCE.getInfoNode_Properties();
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.info.impl.NodePropertyImpl <em>Node Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.info.impl.NodePropertyImpl
		 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getNodeProperty()
		 * @generated
		 */
		EClass NODE_PROPERTY = eINSTANCE.getNodeProperty();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_PROPERTY__NAME = eINSTANCE.getNodeProperty_Name();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_PROPERTY__VALUE = eINSTANCE.getNodeProperty_Value();
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoImpl <em>Q7 Wait Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoImpl
		 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getQ7WaitInfo()
		 * @generated
		 */
		EClass Q7_WAIT_INFO = eINSTANCE.getQ7WaitInfo();
		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_WAIT_INFO__START_TIME = eINSTANCE.getQ7WaitInfo_StartTime();
		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_WAIT_INFO__END_TIME = eINSTANCE.getQ7WaitInfo_EndTime();
		/**
		 * The meta object literal for the '<em><b>Last Tick</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_WAIT_INFO__LAST_TICK = eINSTANCE.getQ7WaitInfo_LastTick();
		/**
		 * The meta object literal for the '<em><b>Class Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_WAIT_INFO__CLASS_ID = eINSTANCE.getQ7WaitInfo_ClassId();
		/**
		 * The meta object literal for the '<em><b>Type Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_WAIT_INFO__TYPE_ID = eINSTANCE.getQ7WaitInfo_TypeId();
		/**
		 * The meta object literal for the '<em><b>Ticks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_WAIT_INFO__TICKS = eINSTANCE.getQ7WaitInfo_Ticks();
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoRootImpl <em>Q7 Wait Info Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoRootImpl
		 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getQ7WaitInfoRoot()
		 * @generated
		 */
		EClass Q7_WAIT_INFO_ROOT = eINSTANCE.getQ7WaitInfoRoot();
		/**
		 * The meta object literal for the '<em><b>Infos</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference Q7_WAIT_INFO_ROOT__INFOS = eINSTANCE.getQ7WaitInfoRoot_Infos();
		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_WAIT_INFO_ROOT__START_TIME = eINSTANCE.getQ7WaitInfoRoot_StartTime();
		/**
		 * The meta object literal for the '<em><b>Tick</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_WAIT_INFO_ROOT__TICK = eINSTANCE.getQ7WaitInfoRoot_Tick();
		/**
		 * The meta object literal for the '<em><b>Class Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_WAIT_INFO_ROOT__CLASS_NAMES = eINSTANCE.getQ7WaitInfoRoot_ClassNames();
		/**
		 * The meta object literal for the '<em><b>Types Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_WAIT_INFO_ROOT__TYPES_NAMES = eINSTANCE.getQ7WaitInfoRoot_TypesNames();
		/**
		 * The meta object literal for the '<em><b>Inner Class Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference Q7_WAIT_INFO_ROOT__INNER_CLASS_MAP = eINSTANCE.getQ7WaitInfoRoot_InnerClassMap();
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoInnerClassMapImpl <em>Q7 Wait Info Inner Class Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoInnerClassMapImpl
		 * @see org.eclipse.rcptt.tesla.core.info.impl.InfoPackageImpl#getQ7WaitInfoInnerClassMap()
		 * @generated
		 */
		EClass Q7_WAIT_INFO_INNER_CLASS_MAP = eINSTANCE.getQ7WaitInfoInnerClassMap();
		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_WAIT_INFO_INNER_CLASS_MAP__KEY = eINSTANCE.getQ7WaitInfoInnerClassMap_Key();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_WAIT_INFO_INNER_CLASS_MAP__VALUE = eINSTANCE.getQ7WaitInfoInnerClassMap_Value();

	}

} //InfoPackage
