/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.verifications.time;

import org.eclipse.rcptt.core.scenario.ScenarioPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.eclipse.rcptt.verifications.time.TimeFactory
 * @model kind="package"
 * @generated
 */
public interface TimePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "time";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/verifications/time";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.verifications.time";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TimePackage eINSTANCE = org.eclipse.rcptt.verifications.time.impl.TimePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.time.impl.TimeVerificationImpl <em>Verification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.time.impl.TimeVerificationImpl
	 * @see org.eclipse.rcptt.verifications.time.impl.TimePackageImpl#getTimeVerification()
	 * @generated
	 */
	int TIME_VERIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_VERIFICATION__NAME = ScenarioPackage.VERIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_VERIFICATION__VERSION = ScenarioPackage.VERIFICATION__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_VERIFICATION__ID = ScenarioPackage.VERIFICATION__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_VERIFICATION__DESCRIPTION = ScenarioPackage.VERIFICATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_VERIFICATION__TAGS = ScenarioPackage.VERIFICATION__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_VERIFICATION__ATTACHMENTS = ScenarioPackage.VERIFICATION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Minutes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_VERIFICATION__MINUTES = ScenarioPackage.VERIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Seconds</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_VERIFICATION__SECONDS = ScenarioPackage.VERIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Include Contexts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_VERIFICATION__INCLUDE_CONTEXTS = ScenarioPackage.VERIFICATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Verification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_VERIFICATION_FEATURE_COUNT = ScenarioPackage.VERIFICATION_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.time.TimeVerification <em>Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verification</em>'.
	 * @see org.eclipse.rcptt.verifications.time.TimeVerification
	 * @generated
	 */
	EClass getTimeVerification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.time.TimeVerification#getMinutes <em>Minutes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minutes</em>'.
	 * @see org.eclipse.rcptt.verifications.time.TimeVerification#getMinutes()
	 * @see #getTimeVerification()
	 * @generated
	 */
	EAttribute getTimeVerification_Minutes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.time.TimeVerification#getSeconds <em>Seconds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seconds</em>'.
	 * @see org.eclipse.rcptt.verifications.time.TimeVerification#getSeconds()
	 * @see #getTimeVerification()
	 * @generated
	 */
	EAttribute getTimeVerification_Seconds();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.time.TimeVerification#isIncludeContexts <em>Include Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include Contexts</em>'.
	 * @see org.eclipse.rcptt.verifications.time.TimeVerification#isIncludeContexts()
	 * @see #getTimeVerification()
	 * @generated
	 */
	EAttribute getTimeVerification_IncludeContexts();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TimeFactory getTimeFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.time.impl.TimeVerificationImpl <em>Verification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.time.impl.TimeVerificationImpl
		 * @see org.eclipse.rcptt.verifications.time.impl.TimePackageImpl#getTimeVerification()
		 * @generated
		 */
		EClass TIME_VERIFICATION = eINSTANCE.getTimeVerification();
		/**
		 * The meta object literal for the '<em><b>Minutes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_VERIFICATION__MINUTES = eINSTANCE.getTimeVerification_Minutes();
		/**
		 * The meta object literal for the '<em><b>Seconds</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_VERIFICATION__SECONDS = eINSTANCE.getTimeVerification_Seconds();
		/**
		 * The meta object literal for the '<em><b>Include Contexts</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_VERIFICATION__INCLUDE_CONTEXTS = eINSTANCE.getTimeVerification_IncludeContexts();

	}

} //TimePackage
