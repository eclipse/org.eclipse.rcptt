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

package org.eclipse.rcptt.ecl.platform.ui.objects;

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
 * @see org.eclipse.rcptt.ecl.platform.ui.objects.ObjectsFactory
 * @model kind="package"
 * @generated
 */
public interface ObjectsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "objects";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ecl/platform.ui/objects.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.ecl.platform.ui";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ObjectsPackage eINSTANCE = org.eclipse.rcptt.ecl.platform.ui.objects.impl.ObjectsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.ui.objects.impl.WorkingSetImpl <em>Working Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.ui.objects.impl.WorkingSetImpl
	 * @see org.eclipse.rcptt.ecl.platform.ui.objects.impl.ObjectsPackageImpl#getWorkingSet()
	 * @generated
	 */
	int WORKING_SET = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKING_SET__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKING_SET__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Working Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKING_SET_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.ui.objects.WorkingSet <em>Working Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Working Set</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.ui.objects.WorkingSet
	 * @generated
	 */
	EClass getWorkingSet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.ui.objects.WorkingSet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.ui.objects.WorkingSet#getName()
	 * @see #getWorkingSet()
	 * @generated
	 */
	EAttribute getWorkingSet_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.ui.objects.WorkingSet#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.ui.objects.WorkingSet#getType()
	 * @see #getWorkingSet()
	 * @generated
	 */
	EAttribute getWorkingSet_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ObjectsFactory getObjectsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.ui.objects.impl.WorkingSetImpl <em>Working Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.ui.objects.impl.WorkingSetImpl
		 * @see org.eclipse.rcptt.ecl.platform.ui.objects.impl.ObjectsPackageImpl#getWorkingSet()
		 * @generated
		 */
		EClass WORKING_SET = eINSTANCE.getWorkingSet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKING_SET__NAME = eINSTANCE.getWorkingSet_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKING_SET__TYPE = eINSTANCE.getWorkingSet_Type();

	}

} //ObjectsPackage
