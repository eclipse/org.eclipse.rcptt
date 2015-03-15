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
package org.eclipse.rcptt.tesla.core.info.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.InfoFactory;
import org.eclipse.rcptt.tesla.core.info.InfoNode;
import org.eclipse.rcptt.tesla.core.info.InfoPackage;
import org.eclipse.rcptt.tesla.core.info.JobEntry;
import org.eclipse.rcptt.tesla.core.info.NodeProperty;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfo;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.core.info.StackTraceEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InfoPackageImpl extends EPackageImpl implements InfoPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass advancedInformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stackTraceEntryEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jobEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass infoNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass q7WaitInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass q7WaitInfoRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass q7WaitInfoInnerClassMapEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private InfoPackageImpl() {
		super(eNS_URI, InfoFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link InfoPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static InfoPackage init() {
		if (isInited) return (InfoPackage)EPackage.Registry.INSTANCE.getEPackage(InfoPackage.eNS_URI);

		// Obtain or create and register package
		InfoPackageImpl theInfoPackage = (InfoPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InfoPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InfoPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theInfoPackage.createPackageContents();

		// Initialize created meta-data
		theInfoPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInfoPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InfoPackage.eNS_URI, theInfoPackage);
		return theInfoPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdvancedInformation() {
		return advancedInformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdvancedInformation_Threads() {
		return (EReference)advancedInformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdvancedInformation_Jobs() {
		return (EReference)advancedInformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdvancedInformation_Message() {
		return (EAttribute)advancedInformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdvancedInformation_Nodes() {
		return (EReference)advancedInformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStackTraceEntry() {
		return stackTraceEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackTraceEntry_Id() {
		return (EAttribute)stackTraceEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackTraceEntry_StackTrace() {
		return (EAttribute)stackTraceEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackTraceEntry_ThreadName() {
		return (EAttribute)stackTraceEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackTraceEntry_ThreadClass() {
		return (EAttribute)stackTraceEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJobEntry() {
		return jobEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobEntry_Id() {
		return (EAttribute)jobEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobEntry_Name() {
		return (EAttribute)jobEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobEntry_JobClass() {
		return (EAttribute)jobEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobEntry_State() {
		return (EAttribute)jobEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobEntry_Rule() {
		return (EAttribute)jobEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobEntry_RuleClass() {
		return (EAttribute)jobEntryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInfoNode() {
		return infoNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInfoNode_Children() {
		return (EReference)infoNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInfoNode_Name() {
		return (EAttribute)infoNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInfoNode_Properties() {
		return (EReference)infoNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeProperty() {
		return nodePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeProperty_Name() {
		return (EAttribute)nodePropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeProperty_Value() {
		return (EAttribute)nodePropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQ7WaitInfo() {
		return q7WaitInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7WaitInfo_StartTime() {
		return (EAttribute)q7WaitInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7WaitInfo_EndTime() {
		return (EAttribute)q7WaitInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7WaitInfo_LastTick() {
		return (EAttribute)q7WaitInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7WaitInfo_ClassId() {
		return (EAttribute)q7WaitInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7WaitInfo_TypeId() {
		return (EAttribute)q7WaitInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7WaitInfo_Ticks() {
		return (EAttribute)q7WaitInfoEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQ7WaitInfoRoot() {
		return q7WaitInfoRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQ7WaitInfoRoot_Infos() {
		return (EReference)q7WaitInfoRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7WaitInfoRoot_StartTime() {
		return (EAttribute)q7WaitInfoRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7WaitInfoRoot_Tick() {
		return (EAttribute)q7WaitInfoRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7WaitInfoRoot_ClassNames() {
		return (EAttribute)q7WaitInfoRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7WaitInfoRoot_TypesNames() {
		return (EAttribute)q7WaitInfoRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQ7WaitInfoRoot_InnerClassMap() {
		return (EReference)q7WaitInfoRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQ7WaitInfoInnerClassMap() {
		return q7WaitInfoInnerClassMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7WaitInfoInnerClassMap_Key() {
		return (EAttribute)q7WaitInfoInnerClassMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7WaitInfoInnerClassMap_Value() {
		return (EAttribute)q7WaitInfoInnerClassMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfoFactory getInfoFactory() {
		return (InfoFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		advancedInformationEClass = createEClass(ADVANCED_INFORMATION);
		createEReference(advancedInformationEClass, ADVANCED_INFORMATION__THREADS);
		createEReference(advancedInformationEClass, ADVANCED_INFORMATION__JOBS);
		createEAttribute(advancedInformationEClass, ADVANCED_INFORMATION__MESSAGE);
		createEReference(advancedInformationEClass, ADVANCED_INFORMATION__NODES);

		stackTraceEntryEClass = createEClass(STACK_TRACE_ENTRY);
		createEAttribute(stackTraceEntryEClass, STACK_TRACE_ENTRY__ID);
		createEAttribute(stackTraceEntryEClass, STACK_TRACE_ENTRY__STACK_TRACE);
		createEAttribute(stackTraceEntryEClass, STACK_TRACE_ENTRY__THREAD_NAME);
		createEAttribute(stackTraceEntryEClass, STACK_TRACE_ENTRY__THREAD_CLASS);

		jobEntryEClass = createEClass(JOB_ENTRY);
		createEAttribute(jobEntryEClass, JOB_ENTRY__ID);
		createEAttribute(jobEntryEClass, JOB_ENTRY__NAME);
		createEAttribute(jobEntryEClass, JOB_ENTRY__JOB_CLASS);
		createEAttribute(jobEntryEClass, JOB_ENTRY__STATE);
		createEAttribute(jobEntryEClass, JOB_ENTRY__RULE);
		createEAttribute(jobEntryEClass, JOB_ENTRY__RULE_CLASS);

		infoNodeEClass = createEClass(INFO_NODE);
		createEReference(infoNodeEClass, INFO_NODE__CHILDREN);
		createEAttribute(infoNodeEClass, INFO_NODE__NAME);
		createEReference(infoNodeEClass, INFO_NODE__PROPERTIES);

		nodePropertyEClass = createEClass(NODE_PROPERTY);
		createEAttribute(nodePropertyEClass, NODE_PROPERTY__NAME);
		createEAttribute(nodePropertyEClass, NODE_PROPERTY__VALUE);

		q7WaitInfoEClass = createEClass(Q7_WAIT_INFO);
		createEAttribute(q7WaitInfoEClass, Q7_WAIT_INFO__START_TIME);
		createEAttribute(q7WaitInfoEClass, Q7_WAIT_INFO__END_TIME);
		createEAttribute(q7WaitInfoEClass, Q7_WAIT_INFO__LAST_TICK);
		createEAttribute(q7WaitInfoEClass, Q7_WAIT_INFO__CLASS_ID);
		createEAttribute(q7WaitInfoEClass, Q7_WAIT_INFO__TYPE_ID);
		createEAttribute(q7WaitInfoEClass, Q7_WAIT_INFO__TICKS);

		q7WaitInfoRootEClass = createEClass(Q7_WAIT_INFO_ROOT);
		createEReference(q7WaitInfoRootEClass, Q7_WAIT_INFO_ROOT__INFOS);
		createEAttribute(q7WaitInfoRootEClass, Q7_WAIT_INFO_ROOT__START_TIME);
		createEAttribute(q7WaitInfoRootEClass, Q7_WAIT_INFO_ROOT__TICK);
		createEAttribute(q7WaitInfoRootEClass, Q7_WAIT_INFO_ROOT__CLASS_NAMES);
		createEAttribute(q7WaitInfoRootEClass, Q7_WAIT_INFO_ROOT__TYPES_NAMES);
		createEReference(q7WaitInfoRootEClass, Q7_WAIT_INFO_ROOT__INNER_CLASS_MAP);

		q7WaitInfoInnerClassMapEClass = createEClass(Q7_WAIT_INFO_INNER_CLASS_MAP);
		createEAttribute(q7WaitInfoInnerClassMapEClass, Q7_WAIT_INFO_INNER_CLASS_MAP__KEY);
		createEAttribute(q7WaitInfoInnerClassMapEClass, Q7_WAIT_INFO_INNER_CLASS_MAP__VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(advancedInformationEClass, AdvancedInformation.class, "AdvancedInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdvancedInformation_Threads(), this.getStackTraceEntry(), null, "threads", null, 0, -1, AdvancedInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdvancedInformation_Jobs(), this.getJobEntry(), null, "jobs", null, 0, -1, AdvancedInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdvancedInformation_Message(), ecorePackage.getEString(), "message", null, 0, 1, AdvancedInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdvancedInformation_Nodes(), this.getInfoNode(), null, "nodes", null, 0, -1, AdvancedInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stackTraceEntryEClass, StackTraceEntry.class, "StackTraceEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStackTraceEntry_Id(), ecorePackage.getEString(), "id", null, 0, 1, StackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStackTraceEntry_StackTrace(), ecorePackage.getEString(), "stackTrace", null, 0, -1, StackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStackTraceEntry_ThreadName(), ecorePackage.getEString(), "threadName", null, 0, 1, StackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStackTraceEntry_ThreadClass(), ecorePackage.getEString(), "threadClass", null, 0, 1, StackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jobEntryEClass, JobEntry.class, "JobEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJobEntry_Id(), ecorePackage.getEString(), "id", null, 0, 1, JobEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJobEntry_Name(), ecorePackage.getEString(), "name", null, 0, 1, JobEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJobEntry_JobClass(), ecorePackage.getEString(), "jobClass", null, 0, 1, JobEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJobEntry_State(), ecorePackage.getEString(), "state", null, 0, 1, JobEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJobEntry_Rule(), ecorePackage.getEString(), "rule", null, 0, 1, JobEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJobEntry_RuleClass(), ecorePackage.getEString(), "ruleClass", null, 0, 1, JobEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(infoNodeEClass, InfoNode.class, "InfoNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInfoNode_Children(), this.getInfoNode(), null, "children", null, 0, -1, InfoNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInfoNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, InfoNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInfoNode_Properties(), this.getNodeProperty(), null, "properties", null, 0, -1, InfoNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodePropertyEClass, NodeProperty.class, "NodeProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNodeProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, NodeProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNodeProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, NodeProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(q7WaitInfoEClass, Q7WaitInfo.class, "Q7WaitInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQ7WaitInfo_StartTime(), ecorePackage.getELong(), "startTime", null, 0, 1, Q7WaitInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQ7WaitInfo_EndTime(), ecorePackage.getELong(), "endTime", null, 0, 1, Q7WaitInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQ7WaitInfo_LastTick(), ecorePackage.getELong(), "lastTick", null, 0, 1, Q7WaitInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQ7WaitInfo_ClassId(), ecorePackage.getEInt(), "classId", null, 0, 1, Q7WaitInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQ7WaitInfo_TypeId(), ecorePackage.getEInt(), "typeId", null, 0, 1, Q7WaitInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQ7WaitInfo_Ticks(), ecorePackage.getELong(), "ticks", null, 0, 1, Q7WaitInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(q7WaitInfoRootEClass, Q7WaitInfoRoot.class, "Q7WaitInfoRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQ7WaitInfoRoot_Infos(), this.getQ7WaitInfo(), null, "infos", null, 0, -1, Q7WaitInfoRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQ7WaitInfoRoot_StartTime(), ecorePackage.getELong(), "startTime", null, 0, 1, Q7WaitInfoRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQ7WaitInfoRoot_Tick(), ecorePackage.getELong(), "tick", null, 0, 1, Q7WaitInfoRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQ7WaitInfoRoot_ClassNames(), ecorePackage.getEString(), "classNames", null, 0, -1, Q7WaitInfoRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQ7WaitInfoRoot_TypesNames(), ecorePackage.getEString(), "typesNames", null, 0, -1, Q7WaitInfoRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQ7WaitInfoRoot_InnerClassMap(), this.getQ7WaitInfoInnerClassMap(), null, "innerClassMap", null, 0, -1, Q7WaitInfoRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(q7WaitInfoInnerClassMapEClass, Map.Entry.class, "Q7WaitInfoInnerClassMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQ7WaitInfoInnerClassMap_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQ7WaitInfoInnerClassMap_Value(), ecorePackage.getEString(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //InfoPackageImpl
