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
package org.eclipse.rcptt.verifications.text;

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
 * @see org.eclipse.rcptt.verifications.text.TextFactory
 * @model kind="package"
 * @generated
 */
public interface TextPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "text";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/verifications/text";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.verifications.text";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TextPackage eINSTANCE = org.eclipse.rcptt.verifications.text.impl.TextPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.text.impl.TextVerificationImpl <em>Verification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.text.impl.TextVerificationImpl
	 * @see org.eclipse.rcptt.verifications.text.impl.TextPackageImpl#getTextVerification()
	 * @generated
	 */
	int TEXT_VERIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_VERIFICATION__NAME = ScenarioPackage.WIDGET_VERIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_VERIFICATION__VERSION = ScenarioPackage.WIDGET_VERIFICATION__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_VERIFICATION__ID = ScenarioPackage.WIDGET_VERIFICATION__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_VERIFICATION__DESCRIPTION = ScenarioPackage.WIDGET_VERIFICATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_VERIFICATION__TAGS = ScenarioPackage.WIDGET_VERIFICATION__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_VERIFICATION__ATTACHMENTS = ScenarioPackage.WIDGET_VERIFICATION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_VERIFICATION__SELECTOR = ScenarioPackage.WIDGET_VERIFICATION__SELECTOR;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_VERIFICATION__TEXT = ScenarioPackage.WIDGET_VERIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Styles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_VERIFICATION__STYLES = ScenarioPackage.WIDGET_VERIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ignore Styling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_VERIFICATION__IGNORE_STYLING = ScenarioPackage.WIDGET_VERIFICATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Verification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_VERIFICATION_FEATURE_COUNT = ScenarioPackage.WIDGET_VERIFICATION_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.text.TextVerification <em>Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verification</em>'.
	 * @see org.eclipse.rcptt.verifications.text.TextVerification
	 * @generated
	 */
	EClass getTextVerification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.text.TextVerification#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.verifications.text.TextVerification#getText()
	 * @see #getTextVerification()
	 * @generated
	 */
	EAttribute getTextVerification_Text();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.verifications.text.TextVerification#getStyles <em>Styles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Styles</em>'.
	 * @see org.eclipse.rcptt.verifications.text.TextVerification#getStyles()
	 * @see #getTextVerification()
	 * @generated
	 */
	EReference getTextVerification_Styles();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.text.TextVerification#isIgnoreStyling <em>Ignore Styling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ignore Styling</em>'.
	 * @see org.eclipse.rcptt.verifications.text.TextVerification#isIgnoreStyling()
	 * @see #getTextVerification()
	 * @generated
	 */
	EAttribute getTextVerification_IgnoreStyling();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TextFactory getTextFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.text.impl.TextVerificationImpl <em>Verification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.text.impl.TextVerificationImpl
		 * @see org.eclipse.rcptt.verifications.text.impl.TextPackageImpl#getTextVerification()
		 * @generated
		 */
		EClass TEXT_VERIFICATION = eINSTANCE.getTextVerification();
		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_VERIFICATION__TEXT = eINSTANCE.getTextVerification_Text();
		/**
		 * The meta object literal for the '<em><b>Styles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_VERIFICATION__STYLES = eINSTANCE.getTextVerification_Styles();
		/**
		 * The meta object literal for the '<em><b>Ignore Styling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_VERIFICATION__IGNORE_STYLING = eINSTANCE.getTextVerification_IgnoreStyling();

	}

} //TextPackage
