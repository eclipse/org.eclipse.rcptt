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
package org.eclipse.rcptt.reporting;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.rcptt.reporting.ReportingFactory
 * @model kind="package"
 * @generated
 */
public interface ReportingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "reporting";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/reporting/core";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.reporting.core";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ReportingPackage eINSTANCE = org.eclipse.rcptt.reporting.impl.ReportingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.reporting.impl.Q7InfoImpl <em>Q7 Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.reporting.impl.Q7InfoImpl
	 * @see org.eclipse.rcptt.reporting.impl.ReportingPackageImpl#getQ7Info()
	 * @generated
	 */
	int Q7_INFO = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFO__ID = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFO__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFO__LINE = 2;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFO__TAGS = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFO__DESCRIPTION = 4;

	/**
	 * The feature id for the '<em><b>Subtype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFO__SUBTYPE = 5;

	/**
	 * The feature id for the '<em><b>Variant</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFO__VARIANT = 6;

	/**
	 * The feature id for the '<em><b>Phase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFO__PHASE = 7;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFO__RESULT = 8;

	/**
	 * The number of structural features of the '<em>Q7 Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_INFO_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.reporting.impl.Q7StatisticsImpl <em>Q7 Statistics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.reporting.impl.Q7StatisticsImpl
	 * @see org.eclipse.rcptt.reporting.impl.ReportingPackageImpl#getQ7Statistics()
	 * @generated
	 */
	int Q7_STATISTICS = 1;

	/**
	 * The feature id for the '<em><b>Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_STATISTICS__TOTAL = 0;

	/**
	 * The feature id for the '<em><b>Failed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_STATISTICS__FAILED = 1;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_STATISTICS__TIME = 2;

	/**
	 * The feature id for the '<em><b>Skipped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_STATISTICS__SKIPPED = 3;

	/**
	 * The feature id for the '<em><b>Passed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_STATISTICS__PASSED = 4;

	/**
	 * The number of structural features of the '<em>Q7 Statistics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int Q7_STATISTICS_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.reporting.ItemKind <em>Item Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.reporting.ItemKind
	 * @see org.eclipse.rcptt.reporting.impl.ReportingPackageImpl#getItemKind()
	 * @generated
	 */
	int ITEM_KIND = 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.reporting.Q7Info <em>Q7 Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Q7 Info</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Info
	 * @generated
	 */
	EClass getQ7Info();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.reporting.Q7Info#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Info#getId()
	 * @see #getQ7Info()
	 * @generated
	 */
	EAttribute getQ7Info_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.reporting.Q7Info#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Info#getType()
	 * @see #getQ7Info()
	 * @generated
	 */
	EAttribute getQ7Info_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.reporting.Q7Info#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Info#getResult()
	 * @see #getQ7Info()
	 * @generated
	 */
	EReference getQ7Info_Result();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.reporting.Q7Info#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Info#getLine()
	 * @see #getQ7Info()
	 * @generated
	 */
	EAttribute getQ7Info_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.reporting.Q7Info#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tags</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Info#getTags()
	 * @see #getQ7Info()
	 * @generated
	 */
	EAttribute getQ7Info_Tags();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.reporting.Q7Info#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Info#getDescription()
	 * @see #getQ7Info()
	 * @generated
	 */
	EAttribute getQ7Info_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.reporting.Q7Info#getSubtype <em>Subtype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subtype</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Info#getSubtype()
	 * @see #getQ7Info()
	 * @generated
	 */
	EAttribute getQ7Info_Subtype();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.reporting.Q7Info#getVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Variant</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Info#getVariant()
	 * @see #getQ7Info()
	 * @generated
	 */
	EAttribute getQ7Info_Variant();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.reporting.Q7Info#getPhase <em>Phase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phase</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Info#getPhase()
	 * @see #getQ7Info()
	 * @generated
	 */
	EAttribute getQ7Info_Phase();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.reporting.Q7Statistics <em>Q7 Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Q7 Statistics</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Statistics
	 * @generated
	 */
	EClass getQ7Statistics();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.reporting.Q7Statistics#getTotal <em>Total</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Statistics#getTotal()
	 * @see #getQ7Statistics()
	 * @generated
	 */
	EAttribute getQ7Statistics_Total();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.reporting.Q7Statistics#getFailed <em>Failed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failed</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Statistics#getFailed()
	 * @see #getQ7Statistics()
	 * @generated
	 */
	EAttribute getQ7Statistics_Failed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.reporting.Q7Statistics#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Statistics#getTime()
	 * @see #getQ7Statistics()
	 * @generated
	 */
	EAttribute getQ7Statistics_Time();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.reporting.Q7Statistics#getSkipped <em>Skipped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Skipped</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Statistics#getSkipped()
	 * @see #getQ7Statistics()
	 * @generated
	 */
	EAttribute getQ7Statistics_Skipped();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.reporting.Q7Statistics#getPassed <em>Passed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Passed</em>'.
	 * @see org.eclipse.rcptt.reporting.Q7Statistics#getPassed()
	 * @see #getQ7Statistics()
	 * @generated
	 */
	EAttribute getQ7Statistics_Passed();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.reporting.ItemKind <em>Item Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Item Kind</em>'.
	 * @see org.eclipse.rcptt.reporting.ItemKind
	 * @generated
	 */
	EEnum getItemKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ReportingFactory getReportingFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.reporting.impl.Q7InfoImpl <em>Q7 Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.reporting.impl.Q7InfoImpl
		 * @see org.eclipse.rcptt.reporting.impl.ReportingPackageImpl#getQ7Info()
		 * @generated
		 */
		EClass Q7_INFO = eINSTANCE.getQ7Info();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_INFO__ID = eINSTANCE.getQ7Info_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_INFO__TYPE = eINSTANCE.getQ7Info_Type();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference Q7_INFO__RESULT = eINSTANCE.getQ7Info_Result();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_INFO__LINE = eINSTANCE.getQ7Info_Line();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_INFO__TAGS = eINSTANCE.getQ7Info_Tags();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_INFO__DESCRIPTION = eINSTANCE.getQ7Info_Description();

		/**
		 * The meta object literal for the '<em><b>Subtype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_INFO__SUBTYPE = eINSTANCE.getQ7Info_Subtype();

		/**
		 * The meta object literal for the '<em><b>Variant</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_INFO__VARIANT = eINSTANCE.getQ7Info_Variant();

		/**
		 * The meta object literal for the '<em><b>Phase</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_INFO__PHASE = eINSTANCE.getQ7Info_Phase();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.reporting.impl.Q7StatisticsImpl <em>Q7 Statistics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.reporting.impl.Q7StatisticsImpl
		 * @see org.eclipse.rcptt.reporting.impl.ReportingPackageImpl#getQ7Statistics()
		 * @generated
		 */
		EClass Q7_STATISTICS = eINSTANCE.getQ7Statistics();

		/**
		 * The meta object literal for the '<em><b>Total</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_STATISTICS__TOTAL = eINSTANCE.getQ7Statistics_Total();

		/**
		 * The meta object literal for the '<em><b>Failed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_STATISTICS__FAILED = eINSTANCE.getQ7Statistics_Failed();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_STATISTICS__TIME = eINSTANCE.getQ7Statistics_Time();

		/**
		 * The meta object literal for the '<em><b>Skipped</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_STATISTICS__SKIPPED = eINSTANCE.getQ7Statistics_Skipped();

		/**
		 * The meta object literal for the '<em><b>Passed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Q7_STATISTICS__PASSED = eINSTANCE.getQ7Statistics_Passed();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.reporting.ItemKind <em>Item Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.reporting.ItemKind
		 * @see org.eclipse.rcptt.reporting.impl.ReportingPackageImpl#getItemKind()
		 * @generated
		 */
		EEnum ITEM_KIND = eINSTANCE.getItemKind();

	}

} //ReportingPackage
