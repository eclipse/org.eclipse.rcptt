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
package org.eclipse.rcptt.verifications.log;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.rcptt.core.scenario.ScenarioPackage;

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
 * @see org.eclipse.rcptt.verifications.log.LogFactory
 * @model kind="package"
 * @generated
 */
public interface LogPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "log";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/verifications/log";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.verifications.log";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LogPackage eINSTANCE = org.eclipse.rcptt.verifications.log.impl.LogPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.log.impl.LogEntryPredicateImpl <em>Entry Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.log.impl.LogEntryPredicateImpl
	 * @see org.eclipse.rcptt.verifications.log.impl.LogPackageImpl#getLogEntryPredicate()
	 * @generated
	 */
	int LOG_ENTRY_PREDICATE = 0;

	/**
	 * The feature id for the '<em><b>Severity Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_ENTRY_PREDICATE__SEVERITY_MASK = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_ENTRY_PREDICATE__CODE = 1;

	/**
	 * The feature id for the '<em><b>Plugin Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_ENTRY_PREDICATE__PLUGIN_PATTERN = 2;

	/**
	 * The feature id for the '<em><b>Message Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_ENTRY_PREDICATE__MESSAGE_PATTERN = 3;

	/**
	 * The number of structural features of the '<em>Entry Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_ENTRY_PREDICATE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.log.impl.ErrorLogVerificationImpl <em>Error Log Verification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.log.impl.ErrorLogVerificationImpl
	 * @see org.eclipse.rcptt.verifications.log.impl.LogPackageImpl#getErrorLogVerification()
	 * @generated
	 */
	int ERROR_LOG_VERIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_LOG_VERIFICATION__NAME = ScenarioPackage.VERIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_LOG_VERIFICATION__VERSION = ScenarioPackage.VERIFICATION__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_LOG_VERIFICATION__ID = ScenarioPackage.VERIFICATION__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_LOG_VERIFICATION__DESCRIPTION = ScenarioPackage.VERIFICATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_LOG_VERIFICATION__TAGS = ScenarioPackage.VERIFICATION__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_LOG_VERIFICATION__ATTACHMENTS = ScenarioPackage.VERIFICATION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Allowed</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_LOG_VERIFICATION__ALLOWED = ScenarioPackage.VERIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Denied</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_LOG_VERIFICATION__DENIED = ScenarioPackage.VERIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Required</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_LOG_VERIFICATION__REQUIRED = ScenarioPackage.VERIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Include Contexts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_LOG_VERIFICATION__INCLUDE_CONTEXTS = ScenarioPackage.VERIFICATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Error Log Verification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_LOG_VERIFICATION_FEATURE_COUNT = ScenarioPackage.VERIFICATION_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.log.LogEntryPredicate <em>Entry Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry Predicate</em>'.
	 * @see org.eclipse.rcptt.verifications.log.LogEntryPredicate
	 * @generated
	 */
	EClass getLogEntryPredicate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.log.LogEntryPredicate#getSeverityMask <em>Severity Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity Mask</em>'.
	 * @see org.eclipse.rcptt.verifications.log.LogEntryPredicate#getSeverityMask()
	 * @see #getLogEntryPredicate()
	 * @generated
	 */
	EAttribute getLogEntryPredicate_SeverityMask();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.log.LogEntryPredicate#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.eclipse.rcptt.verifications.log.LogEntryPredicate#getCode()
	 * @see #getLogEntryPredicate()
	 * @generated
	 */
	EAttribute getLogEntryPredicate_Code();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.log.LogEntryPredicate#getPluginPattern <em>Plugin Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin Pattern</em>'.
	 * @see org.eclipse.rcptt.verifications.log.LogEntryPredicate#getPluginPattern()
	 * @see #getLogEntryPredicate()
	 * @generated
	 */
	EAttribute getLogEntryPredicate_PluginPattern();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.log.LogEntryPredicate#getMessagePattern <em>Message Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Pattern</em>'.
	 * @see org.eclipse.rcptt.verifications.log.LogEntryPredicate#getMessagePattern()
	 * @see #getLogEntryPredicate()
	 * @generated
	 */
	EAttribute getLogEntryPredicate_MessagePattern();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.log.ErrorLogVerification <em>Error Log Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Log Verification</em>'.
	 * @see org.eclipse.rcptt.verifications.log.ErrorLogVerification
	 * @generated
	 */
	EClass getErrorLogVerification();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.verifications.log.ErrorLogVerification#getAllowed <em>Allowed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Allowed</em>'.
	 * @see org.eclipse.rcptt.verifications.log.ErrorLogVerification#getAllowed()
	 * @see #getErrorLogVerification()
	 * @generated
	 */
	EReference getErrorLogVerification_Allowed();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.verifications.log.ErrorLogVerification#getDenied <em>Denied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Denied</em>'.
	 * @see org.eclipse.rcptt.verifications.log.ErrorLogVerification#getDenied()
	 * @see #getErrorLogVerification()
	 * @generated
	 */
	EReference getErrorLogVerification_Denied();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.verifications.log.ErrorLogVerification#getRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Required</em>'.
	 * @see org.eclipse.rcptt.verifications.log.ErrorLogVerification#getRequired()
	 * @see #getErrorLogVerification()
	 * @generated
	 */
	EReference getErrorLogVerification_Required();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.log.ErrorLogVerification#isIncludeContexts <em>Include Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include Contexts</em>'.
	 * @see org.eclipse.rcptt.verifications.log.ErrorLogVerification#isIncludeContexts()
	 * @see #getErrorLogVerification()
	 * @generated
	 */
	EAttribute getErrorLogVerification_IncludeContexts();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LogFactory getLogFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.log.impl.LogEntryPredicateImpl <em>Entry Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.log.impl.LogEntryPredicateImpl
		 * @see org.eclipse.rcptt.verifications.log.impl.LogPackageImpl#getLogEntryPredicate()
		 * @generated
		 */
		EClass LOG_ENTRY_PREDICATE = eINSTANCE.getLogEntryPredicate();

		/**
		 * The meta object literal for the '<em><b>Severity Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_ENTRY_PREDICATE__SEVERITY_MASK = eINSTANCE.getLogEntryPredicate_SeverityMask();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_ENTRY_PREDICATE__CODE = eINSTANCE.getLogEntryPredicate_Code();

		/**
		 * The meta object literal for the '<em><b>Plugin Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_ENTRY_PREDICATE__PLUGIN_PATTERN = eINSTANCE.getLogEntryPredicate_PluginPattern();

		/**
		 * The meta object literal for the '<em><b>Message Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_ENTRY_PREDICATE__MESSAGE_PATTERN = eINSTANCE.getLogEntryPredicate_MessagePattern();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.log.impl.ErrorLogVerificationImpl <em>Error Log Verification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.log.impl.ErrorLogVerificationImpl
		 * @see org.eclipse.rcptt.verifications.log.impl.LogPackageImpl#getErrorLogVerification()
		 * @generated
		 */
		EClass ERROR_LOG_VERIFICATION = eINSTANCE.getErrorLogVerification();

		/**
		 * The meta object literal for the '<em><b>Allowed</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_LOG_VERIFICATION__ALLOWED = eINSTANCE.getErrorLogVerification_Allowed();

		/**
		 * The meta object literal for the '<em><b>Denied</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_LOG_VERIFICATION__DENIED = eINSTANCE.getErrorLogVerification_Denied();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_LOG_VERIFICATION__REQUIRED = eINSTANCE.getErrorLogVerification_Required();

		/**
		 * The meta object literal for the '<em><b>Include Contexts</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_LOG_VERIFICATION__INCLUDE_CONTEXTS = eINSTANCE.getErrorLogVerification_IncludeContexts();

	}

} //LogPackage
