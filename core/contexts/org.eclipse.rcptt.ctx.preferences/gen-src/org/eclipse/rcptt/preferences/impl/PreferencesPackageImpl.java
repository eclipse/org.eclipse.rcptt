/*******************************************************************************
 * Copyright (c) 2014-2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.preferences.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.rcptt.core.scenario.ScenarioPackage;

import org.eclipse.rcptt.preferences.ListPrefData;
import org.eclipse.rcptt.preferences.PrefData;
import org.eclipse.rcptt.preferences.PrefNode;
import org.eclipse.rcptt.preferences.PreferencesContext;
import org.eclipse.rcptt.preferences.PreferencesFactory;
import org.eclipse.rcptt.preferences.PreferencesPackage;
import org.eclipse.rcptt.preferences.SecurePrefNode;
import org.eclipse.rcptt.preferences.SettingsNode;
import org.eclipse.rcptt.preferences.StringPrefData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PreferencesPackageImpl extends EPackageImpl implements PreferencesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preferencesContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prefNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prefDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass settingsNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringPrefDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listPrefDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass securePrefNodeEClass = null;

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
	 * @see org.eclipse.rcptt.preferences.PreferencesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PreferencesPackageImpl() {
		super(eNS_URI, PreferencesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PreferencesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PreferencesPackage init() {
		if (isInited) return (PreferencesPackage)EPackage.Registry.INSTANCE.getEPackage(PreferencesPackage.eNS_URI);

		// Obtain or create and register package
		PreferencesPackageImpl thePreferencesPackage = (PreferencesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PreferencesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PreferencesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ScenarioPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePreferencesPackage.createPackageContents();

		// Initialize created meta-data
		thePreferencesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePreferencesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PreferencesPackage.eNS_URI, thePreferencesPackage);
		return thePreferencesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreferencesContext() {
		return preferencesContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreferencesContext_Content() {
		return (EReference)preferencesContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPreferencesContext_CleanPreferences() {
		return (EAttribute)preferencesContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPreferencesContext_Settings() {
		return (EReference)preferencesContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrefNode() {
		return prefNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrefNode_Name() {
		return (EAttribute)prefNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrefNode_Childs() {
		return (EReference)prefNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrefNode_Data() {
		return (EReference)prefNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrefData() {
		return prefDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrefData_Key() {
		return (EAttribute)prefDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSettingsNode() {
		return settingsNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringPrefData() {
		return stringPrefDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringPrefData_Value() {
		return (EAttribute)stringPrefDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListPrefData() {
		return listPrefDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getListPrefData_Values() {
		return (EAttribute)listPrefDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSecurePrefNode() {
		return securePrefNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreferencesFactory getPreferencesFactory() {
		return (PreferencesFactory)getEFactoryInstance();
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
		preferencesContextEClass = createEClass(PREFERENCES_CONTEXT);
		createEReference(preferencesContextEClass, PREFERENCES_CONTEXT__CONTENT);
		createEAttribute(preferencesContextEClass, PREFERENCES_CONTEXT__CLEAN_PREFERENCES);
		createEReference(preferencesContextEClass, PREFERENCES_CONTEXT__SETTINGS);

		prefNodeEClass = createEClass(PREF_NODE);
		createEAttribute(prefNodeEClass, PREF_NODE__NAME);
		createEReference(prefNodeEClass, PREF_NODE__CHILDS);
		createEReference(prefNodeEClass, PREF_NODE__DATA);

		prefDataEClass = createEClass(PREF_DATA);
		createEAttribute(prefDataEClass, PREF_DATA__KEY);

		settingsNodeEClass = createEClass(SETTINGS_NODE);

		stringPrefDataEClass = createEClass(STRING_PREF_DATA);
		createEAttribute(stringPrefDataEClass, STRING_PREF_DATA__VALUE);

		listPrefDataEClass = createEClass(LIST_PREF_DATA);
		createEAttribute(listPrefDataEClass, LIST_PREF_DATA__VALUES);

		securePrefNodeEClass = createEClass(SECURE_PREF_NODE);
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
		preferencesContextEClass.getESuperTypes().add(theScenarioPackage.getContext());
		settingsNodeEClass.getESuperTypes().add(this.getPrefNode());
		stringPrefDataEClass.getESuperTypes().add(this.getPrefData());
		listPrefDataEClass.getESuperTypes().add(this.getPrefData());
		securePrefNodeEClass.getESuperTypes().add(this.getPrefNode());

		// Initialize classes and features; add operations and parameters
		initEClass(preferencesContextEClass, PreferencesContext.class, "PreferencesContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPreferencesContext_Content(), this.getPrefNode(), null, "content", null, 0, -1, PreferencesContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPreferencesContext_CleanPreferences(), ecorePackage.getEBoolean(), "cleanPreferences", null, 0, 1, PreferencesContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPreferencesContext_Settings(), this.getSettingsNode(), null, "settings", null, 0, 1, PreferencesContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(prefNodeEClass, PrefNode.class, "PrefNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrefNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, PrefNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrefNode_Childs(), this.getPrefNode(), null, "childs", null, 0, -1, PrefNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrefNode_Data(), this.getPrefData(), null, "data", null, 0, -1, PrefNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(prefDataEClass, PrefData.class, "PrefData", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrefData_Key(), ecorePackage.getEString(), "key", null, 0, 1, PrefData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(settingsNodeEClass, SettingsNode.class, "SettingsNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringPrefDataEClass, StringPrefData.class, "StringPrefData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringPrefData_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringPrefData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listPrefDataEClass, ListPrefData.class, "ListPrefData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getListPrefData_Values(), ecorePackage.getEString(), "values", null, 0, -1, ListPrefData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(securePrefNodeEClass, SecurePrefNode.class, "SecurePrefNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //PreferencesPackageImpl
