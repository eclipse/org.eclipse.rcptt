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
package org.eclipse.rcptt.debug.impl;

import org.eclipse.rcptt.core.scenario.ScenarioPackage;

import org.eclipse.rcptt.debug.Breakpoint;
import org.eclipse.rcptt.debug.BreakpointResource;
import org.eclipse.rcptt.debug.Collection;
import org.eclipse.rcptt.debug.DebugContext;
import org.eclipse.rcptt.debug.DebugFactory;
import org.eclipse.rcptt.debug.DebugPackage;
import org.eclipse.rcptt.debug.Launch;
import org.eclipse.rcptt.debug.LaunchConfiguration;
import org.eclipse.rcptt.debug.LaunchType;
import org.eclipse.rcptt.debug.ListValue;
import org.eclipse.rcptt.debug.MapValue;
import org.eclipse.rcptt.debug.PrimitiveValue;
import org.eclipse.rcptt.debug.SetValue;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DebugPackageImpl extends EPackageImpl implements DebugPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass debugContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass launchConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass launchTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass breakpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass launchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass breakpointResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveValueEClass = null;

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
	 * @see org.eclipse.rcptt.debug.DebugPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DebugPackageImpl() {
		super(eNS_URI, DebugFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DebugPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DebugPackage init() {
		if (isInited) return (DebugPackage)EPackage.Registry.INSTANCE.getEPackage(DebugPackage.eNS_URI);

		// Obtain or create and register package
		DebugPackageImpl theDebugPackage = (DebugPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DebugPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DebugPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ScenarioPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDebugPackage.createPackageContents();

		// Initialize created meta-data
		theDebugPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDebugPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DebugPackage.eNS_URI, theDebugPackage);
		return theDebugPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDebugContext() {
		return debugContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDebugContext_NoLaunches() {
		return (EAttribute)debugContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDebugContext_NoBreakpoints() {
		return (EAttribute)debugContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDebugContext_NoLaunchShortcuts() {
		return (EAttribute)debugContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDebugContext_LaunchShortcutExceptions() {
		return (EAttribute)debugContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDebugContext_LaunchExceptions() {
		return (EAttribute)debugContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDebugContext_BreakpointResources() {
		return (EReference)debugContextEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDebugContext_Launches() {
		return (EReference)debugContextEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDebugContext_LaunchTypes() {
		return (EReference)debugContextEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLaunchConfiguration() {
		return launchConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLaunchConfiguration_Attributes() {
		return (EReference)launchConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaunchConfiguration_TypeId() {
		return (EAttribute)launchConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapValue() {
		return mapValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListValue() {
		return listValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetValue() {
		return setValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLaunchType() {
		return launchTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaunchType_Image() {
		return (EAttribute)launchTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLaunchType_Configurations() {
		return (EReference)launchTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBreakpoint() {
		return breakpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBreakpoint_Enabled() {
		return (EAttribute)breakpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBreakpoint_Registered() {
		return (EAttribute)breakpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBreakpoint_Persisted() {
		return (EAttribute)breakpointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBreakpoint_Type() {
		return (EAttribute)breakpointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBreakpoint_Attributes() {
		return (EReference)breakpointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBreakpoint_WorkingSets() {
		return (EAttribute)breakpointEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLaunch() {
		return launchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLaunch_ConfigurationDelta() {
		return (EReference)launchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaunch_Mode() {
		return (EAttribute)launchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLaunch_Configuration() {
		return (EReference)launchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaunch_ConfigurationName() {
		return (EAttribute)launchEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBreakpointResource() {
		return breakpointResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBreakpointResource_Path() {
		return (EAttribute)breakpointResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBreakpointResource_Breakpoints() {
		return (EReference)breakpointResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollection() {
		return collectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollection_Entries() {
		return (EReference)collectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveValue() {
		return primitiveValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveValue_Value() {
		return (EReference)primitiveValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DebugFactory getDebugFactory() {
		return (DebugFactory)getEFactoryInstance();
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
		debugContextEClass = createEClass(DEBUG_CONTEXT);
		createEAttribute(debugContextEClass, DEBUG_CONTEXT__NO_LAUNCHES);
		createEAttribute(debugContextEClass, DEBUG_CONTEXT__NO_BREAKPOINTS);
		createEAttribute(debugContextEClass, DEBUG_CONTEXT__NO_LAUNCH_SHORTCUTS);
		createEAttribute(debugContextEClass, DEBUG_CONTEXT__LAUNCH_SHORTCUT_EXCEPTIONS);
		createEAttribute(debugContextEClass, DEBUG_CONTEXT__LAUNCH_EXCEPTIONS);
		createEReference(debugContextEClass, DEBUG_CONTEXT__BREAKPOINT_RESOURCES);
		createEReference(debugContextEClass, DEBUG_CONTEXT__LAUNCHES);
		createEReference(debugContextEClass, DEBUG_CONTEXT__LAUNCH_TYPES);

		launchConfigurationEClass = createEClass(LAUNCH_CONFIGURATION);
		createEReference(launchConfigurationEClass, LAUNCH_CONFIGURATION__ATTRIBUTES);
		createEAttribute(launchConfigurationEClass, LAUNCH_CONFIGURATION__TYPE_ID);

		mapValueEClass = createEClass(MAP_VALUE);

		listValueEClass = createEClass(LIST_VALUE);

		setValueEClass = createEClass(SET_VALUE);

		launchTypeEClass = createEClass(LAUNCH_TYPE);
		createEAttribute(launchTypeEClass, LAUNCH_TYPE__IMAGE);
		createEReference(launchTypeEClass, LAUNCH_TYPE__CONFIGURATIONS);

		breakpointEClass = createEClass(BREAKPOINT);
		createEAttribute(breakpointEClass, BREAKPOINT__ENABLED);
		createEAttribute(breakpointEClass, BREAKPOINT__REGISTERED);
		createEAttribute(breakpointEClass, BREAKPOINT__PERSISTED);
		createEAttribute(breakpointEClass, BREAKPOINT__TYPE);
		createEReference(breakpointEClass, BREAKPOINT__ATTRIBUTES);
		createEAttribute(breakpointEClass, BREAKPOINT__WORKING_SETS);

		launchEClass = createEClass(LAUNCH);
		createEReference(launchEClass, LAUNCH__CONFIGURATION_DELTA);
		createEAttribute(launchEClass, LAUNCH__MODE);
		createEReference(launchEClass, LAUNCH__CONFIGURATION);
		createEAttribute(launchEClass, LAUNCH__CONFIGURATION_NAME);

		breakpointResourceEClass = createEClass(BREAKPOINT_RESOURCE);
		createEAttribute(breakpointResourceEClass, BREAKPOINT_RESOURCE__PATH);
		createEReference(breakpointResourceEClass, BREAKPOINT_RESOURCE__BREAKPOINTS);

		collectionEClass = createEClass(COLLECTION);
		createEReference(collectionEClass, COLLECTION__ENTRIES);

		primitiveValueEClass = createEClass(PRIMITIVE_VALUE);
		createEReference(primitiveValueEClass, PRIMITIVE_VALUE__VALUE);
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

		// Obtain other dependent packages
		ScenarioPackage theScenarioPackage = (ScenarioPackage)EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		debugContextEClass.getESuperTypes().add(theScenarioPackage.getContext());
		launchConfigurationEClass.getESuperTypes().add(theScenarioPackage.getNamedElement());
		mapValueEClass.getESuperTypes().add(this.getCollection());
		listValueEClass.getESuperTypes().add(this.getCollection());
		setValueEClass.getESuperTypes().add(this.getCollection());
		launchTypeEClass.getESuperTypes().add(theScenarioPackage.getNamedElement());
		collectionEClass.getESuperTypes().add(theScenarioPackage.getNamedElement());
		primitiveValueEClass.getESuperTypes().add(theScenarioPackage.getNamedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(debugContextEClass, DebugContext.class, "DebugContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDebugContext_NoLaunches(), ecorePackage.getEBoolean(), "noLaunches", "true", 0, 1, DebugContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugContext_NoBreakpoints(), ecorePackage.getEBoolean(), "noBreakpoints", "true", 0, 1, DebugContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugContext_NoLaunchShortcuts(), ecorePackage.getEBoolean(), "noLaunchShortcuts", "false", 0, 1, DebugContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugContext_LaunchShortcutExceptions(), ecorePackage.getEString(), "launchShortcutExceptions", null, 0, 1, DebugContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDebugContext_LaunchExceptions(), ecorePackage.getEString(), "launchExceptions", null, 0, 1, DebugContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDebugContext_BreakpointResources(), this.getBreakpointResource(), null, "breakpointResources", null, 0, -1, DebugContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDebugContext_Launches(), this.getLaunch(), null, "launches", null, 0, -1, DebugContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDebugContext_LaunchTypes(), this.getLaunchType(), null, "launchTypes", null, 0, -1, DebugContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(launchConfigurationEClass, LaunchConfiguration.class, "LaunchConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLaunchConfiguration_Attributes(), theScenarioPackage.getNamedElement(), null, "attributes", null, 0, -1, LaunchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLaunchConfiguration_TypeId(), ecorePackage.getEString(), "typeId", null, 0, 1, LaunchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapValueEClass, MapValue.class, "MapValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(listValueEClass, ListValue.class, "ListValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setValueEClass, SetValue.class, "SetValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(launchTypeEClass, LaunchType.class, "LaunchType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLaunchType_Image(), ecorePackage.getEByteArray(), "image", null, 0, 1, LaunchType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLaunchType_Configurations(), this.getLaunchConfiguration(), null, "configurations", null, 0, -1, LaunchType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(breakpointEClass, Breakpoint.class, "Breakpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBreakpoint_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 0, 1, Breakpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBreakpoint_Registered(), ecorePackage.getEBoolean(), "registered", null, 0, 1, Breakpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBreakpoint_Persisted(), ecorePackage.getEBoolean(), "persisted", null, 0, 1, Breakpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBreakpoint_Type(), ecorePackage.getEString(), "type", null, 0, 1, Breakpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBreakpoint_Attributes(), theScenarioPackage.getNamedElement(), null, "attributes", null, 0, -1, Breakpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBreakpoint_WorkingSets(), ecorePackage.getEString(), "workingSets", null, 1, -1, Breakpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(launchEClass, Launch.class, "Launch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLaunch_ConfigurationDelta(), theScenarioPackage.getNamedElement(), null, "configurationDelta", null, 0, -1, Launch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLaunch_Mode(), ecorePackage.getEString(), "mode", null, 0, 1, Launch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLaunch_Configuration(), this.getLaunchConfiguration(), null, "configuration", null, 0, 1, Launch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLaunch_ConfigurationName(), ecorePackage.getEString(), "configurationName", null, 0, 1, Launch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(breakpointResourceEClass, BreakpointResource.class, "BreakpointResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBreakpointResource_Path(), ecorePackage.getEString(), "path", null, 0, 1, BreakpointResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBreakpointResource_Breakpoints(), this.getBreakpoint(), null, "breakpoints", null, 0, -1, BreakpointResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionEClass, Collection.class, "Collection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollection_Entries(), theScenarioPackage.getNamedElement(), null, "entries", null, 0, -1, Collection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveValueEClass, PrimitiveValue.class, "PrimitiveValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrimitiveValue_Value(), ecorePackage.getEObject(), null, "value", null, 1, 1, PrimitiveValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DebugPackageImpl
