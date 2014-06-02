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
package org.eclipse.rcptt.verifications.time.impl;

import org.eclipse.rcptt.core.scenario.ScenarioPackage;

import org.eclipse.rcptt.verifications.time.TimeFactory;
import org.eclipse.rcptt.verifications.time.TimePackage;
import org.eclipse.rcptt.verifications.time.TimeVerification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TimePackageImpl extends EPackageImpl implements TimePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeVerificationEClass = null;

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
	 * @see org.eclipse.rcptt.verifications.time.TimePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TimePackageImpl() {
		super(eNS_URI, TimeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TimePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TimePackage init() {
		if (isInited) return (TimePackage)EPackage.Registry.INSTANCE.getEPackage(TimePackage.eNS_URI);

		// Obtain or create and register package
		TimePackageImpl theTimePackage = (TimePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TimePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TimePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ScenarioPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTimePackage.createPackageContents();

		// Initialize created meta-data
		theTimePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTimePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TimePackage.eNS_URI, theTimePackage);
		return theTimePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeVerification() {
		return timeVerificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeVerification_Minutes() {
		return (EAttribute)timeVerificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeVerification_Seconds() {
		return (EAttribute)timeVerificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeVerification_IncludeContexts() {
		return (EAttribute)timeVerificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeFactory getTimeFactory() {
		return (TimeFactory)getEFactoryInstance();
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
		timeVerificationEClass = createEClass(TIME_VERIFICATION);
		createEAttribute(timeVerificationEClass, TIME_VERIFICATION__MINUTES);
		createEAttribute(timeVerificationEClass, TIME_VERIFICATION__SECONDS);
		createEAttribute(timeVerificationEClass, TIME_VERIFICATION__INCLUDE_CONTEXTS);
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
		timeVerificationEClass.getESuperTypes().add(theScenarioPackage.getVerification());

		// Initialize classes and features; add operations and parameters
		initEClass(timeVerificationEClass, TimeVerification.class, "TimeVerification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeVerification_Minutes(), ecorePackage.getEInt(), "minutes", "1", 1, 1, TimeVerification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeVerification_Seconds(), ecorePackage.getEInt(), "seconds", "0", 1, 1, TimeVerification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeVerification_IncludeContexts(), ecorePackage.getEBoolean(), "includeContexts", null, 1, 1, TimeVerification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TimePackageImpl
