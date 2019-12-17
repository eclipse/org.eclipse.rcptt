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
package org.eclipse.rcptt.testrail;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.rcptt.ecl.core.CorePackage;

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
 * @see org.eclipse.rcptt.testrail.TestRailFactory
 * @model kind="package"
 * @generated
 */
public interface TestRailPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testrail";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/testrail/ecl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.testrail.ecl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestRailPackage eINSTANCE = org.eclipse.rcptt.testrail.impl.TestRailPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.testrail.impl.TestRailStepImpl <em>Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.testrail.impl.TestRailStepImpl
	 * @see org.eclipse.rcptt.testrail.impl.TestRailPackageImpl#getTestRailStep()
	 * @generated
	 */
	int TEST_RAIL_STEP = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RAIL_STEP__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RAIL_STEP__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RAIL_STEP__CONTENT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RAIL_STEP__EXPECTED = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Actual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RAIL_STEP__ACTUAL = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RAIL_STEP__STATUS = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RAIL_STEP_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 4;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.testrail.TestRailStepStatus <em>Step Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.testrail.TestRailStepStatus
	 * @see org.eclipse.rcptt.testrail.impl.TestRailPackageImpl#getTestRailStepStatus()
	 * @generated
	 */
	int TEST_RAIL_STEP_STATUS = 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.testrail.TestRailStep <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step</em>'.
	 * @see org.eclipse.rcptt.testrail.TestRailStep
	 * @generated
	 */
	EClass getTestRailStep();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testrail.TestRailStep#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.eclipse.rcptt.testrail.TestRailStep#getContent()
	 * @see #getTestRailStep()
	 * @generated
	 */
	EAttribute getTestRailStep_Content();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testrail.TestRailStep#getExpected <em>Expected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expected</em>'.
	 * @see org.eclipse.rcptt.testrail.TestRailStep#getExpected()
	 * @see #getTestRailStep()
	 * @generated
	 */
	EAttribute getTestRailStep_Expected();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testrail.TestRailStep#getActual <em>Actual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actual</em>'.
	 * @see org.eclipse.rcptt.testrail.TestRailStep#getActual()
	 * @see #getTestRailStep()
	 * @generated
	 */
	EAttribute getTestRailStep_Actual();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.testrail.TestRailStep#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.eclipse.rcptt.testrail.TestRailStep#getStatus()
	 * @see #getTestRailStep()
	 * @generated
	 */
	EAttribute getTestRailStep_Status();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.testrail.TestRailStepStatus <em>Step Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Step Status</em>'.
	 * @see org.eclipse.rcptt.testrail.TestRailStepStatus
	 * @generated
	 */
	EEnum getTestRailStepStatus();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestRailFactory getTestRailFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.testrail.impl.TestRailStepImpl <em>Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.testrail.impl.TestRailStepImpl
		 * @see org.eclipse.rcptt.testrail.impl.TestRailPackageImpl#getTestRailStep()
		 * @generated
		 */
		EClass TEST_RAIL_STEP = eINSTANCE.getTestRailStep();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_RAIL_STEP__CONTENT = eINSTANCE.getTestRailStep_Content();

		/**
		 * The meta object literal for the '<em><b>Expected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_RAIL_STEP__EXPECTED = eINSTANCE.getTestRailStep_Expected();

		/**
		 * The meta object literal for the '<em><b>Actual</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_RAIL_STEP__ACTUAL = eINSTANCE.getTestRailStep_Actual();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_RAIL_STEP__STATUS = eINSTANCE.getTestRailStep_Status();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.testrail.TestRailStepStatus <em>Step Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.testrail.TestRailStepStatus
		 * @see org.eclipse.rcptt.testrail.impl.TestRailPackageImpl#getTestRailStepStatus()
		 * @generated
		 */
		EEnum TEST_RAIL_STEP_STATUS = eINSTANCE.getTestRailStepStatus();

	}

} //TestRailPackage
