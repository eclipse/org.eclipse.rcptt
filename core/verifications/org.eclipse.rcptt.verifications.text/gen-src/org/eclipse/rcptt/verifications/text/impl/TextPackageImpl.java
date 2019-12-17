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
package org.eclipse.rcptt.verifications.text.impl;

import org.eclipse.rcptt.core.scenario.ScenarioPackage;

import org.eclipse.rcptt.verifications.text.TextFactory;
import org.eclipse.rcptt.verifications.text.TextPackage;
import org.eclipse.rcptt.verifications.text.TextVerification;

import org.eclipse.rcptt.tesla.core.ui.UiPackage;
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
public class TextPackageImpl extends EPackageImpl implements TextPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textVerificationEClass = null;

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
	 * @see org.eclipse.rcptt.verifications.text.TextPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TextPackageImpl() {
		super(eNS_URI, TextFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TextPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TextPackage init() {
		if (isInited) return (TextPackage)EPackage.Registry.INSTANCE.getEPackage(TextPackage.eNS_URI);

		// Obtain or create and register package
		TextPackageImpl theTextPackage = (TextPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TextPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TextPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ScenarioPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTextPackage.createPackageContents();

		// Initialize created meta-data
		theTextPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTextPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TextPackage.eNS_URI, theTextPackage);
		return theTextPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextVerification() {
		return textVerificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextVerification_Text() {
		return (EAttribute)textVerificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextVerification_Styles() {
		return (EReference)textVerificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextVerification_IgnoreStyling() {
		return (EAttribute)textVerificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextFactory getTextFactory() {
		return (TextFactory)getEFactoryInstance();
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
		textVerificationEClass = createEClass(TEXT_VERIFICATION);
		createEAttribute(textVerificationEClass, TEXT_VERIFICATION__TEXT);
		createEReference(textVerificationEClass, TEXT_VERIFICATION__STYLES);
		createEAttribute(textVerificationEClass, TEXT_VERIFICATION__IGNORE_STYLING);
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
		UiPackage theUiPackage = (UiPackage)EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		textVerificationEClass.getESuperTypes().add(theScenarioPackage.getWidgetVerification());

		// Initialize classes and features; add operations and parameters
		initEClass(textVerificationEClass, TextVerification.class, "TextVerification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTextVerification_Text(), ecorePackage.getEString(), "text", null, 1, 1, TextVerification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTextVerification_Styles(), theUiPackage.getStyleRangeEntry(), null, "styles", null, 0, -1, TextVerification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextVerification_IgnoreStyling(), ecorePackage.getEBoolean(), "ignoreStyling", "false", 1, 1, TextVerification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TextPackageImpl
