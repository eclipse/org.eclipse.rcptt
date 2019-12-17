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
package org.eclipse.rcptt.testrail.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.testrail.TestRailFactory;
import org.eclipse.rcptt.testrail.TestRailPackage;
import org.eclipse.rcptt.testrail.TestRailStep;
import org.eclipse.rcptt.testrail.TestRailStepStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestRailPackageImpl extends EPackageImpl implements TestRailPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testRailStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum testRailStepStatusEEnum = null;

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
	 * @see org.eclipse.rcptt.testrail.TestRailPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TestRailPackageImpl() {
		super(eNS_URI, TestRailFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TestRailPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TestRailPackage init() {
		if (isInited) return (TestRailPackage)EPackage.Registry.INSTANCE.getEPackage(TestRailPackage.eNS_URI);

		// Obtain or create and register package
		TestRailPackageImpl theTestRailPackage = (TestRailPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TestRailPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TestRailPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTestRailPackage.createPackageContents();

		// Initialize created meta-data
		theTestRailPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTestRailPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TestRailPackage.eNS_URI, theTestRailPackage);
		return theTestRailPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestRailStep() {
		return testRailStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestRailStep_Content() {
		return (EAttribute)testRailStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestRailStep_Expected() {
		return (EAttribute)testRailStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestRailStep_Actual() {
		return (EAttribute)testRailStepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestRailStep_Status() {
		return (EAttribute)testRailStepEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTestRailStepStatus() {
		return testRailStepStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRailFactory getTestRailFactory() {
		return (TestRailFactory)getEFactoryInstance();
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
		testRailStepEClass = createEClass(TEST_RAIL_STEP);
		createEAttribute(testRailStepEClass, TEST_RAIL_STEP__CONTENT);
		createEAttribute(testRailStepEClass, TEST_RAIL_STEP__EXPECTED);
		createEAttribute(testRailStepEClass, TEST_RAIL_STEP__ACTUAL);
		createEAttribute(testRailStepEClass, TEST_RAIL_STEP__STATUS);

		// Create enums
		testRailStepStatusEEnum = createEEnum(TEST_RAIL_STEP_STATUS);
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
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		testRailStepEClass.getESuperTypes().add(theCorePackage.getCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(testRailStepEClass, TestRailStep.class, "TestRailStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestRailStep_Content(), theEcorePackage.getEString(), "content", null, 0, 1, TestRailStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestRailStep_Expected(), theEcorePackage.getEString(), "expected", null, 0, 1, TestRailStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestRailStep_Actual(), theEcorePackage.getEString(), "actual", null, 0, 1, TestRailStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestRailStep_Status(), this.getTestRailStepStatus(), "status", "untested", 0, 1, TestRailStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(testRailStepStatusEEnum, TestRailStepStatus.class, "TestRailStepStatus");
		addEEnumLiteral(testRailStepStatusEEnum, TestRailStepStatus.PASSED);
		addEEnumLiteral(testRailStepStatusEEnum, TestRailStepStatus.BLOCKED);
		addEEnumLiteral(testRailStepStatusEEnum, TestRailStepStatus.UNTESTED);
		addEEnumLiteral(testRailStepStatusEEnum, TestRailStepStatus.RETEST);
		addEEnumLiteral(testRailStepStatusEEnum, TestRailStepStatus.FAILED);

		// Create resource
		createResource(eNS_URI);
	}

} //TestRailPackageImpl
