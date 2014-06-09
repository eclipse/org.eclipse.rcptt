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
package org.eclipse.rcptt.tesla.protocol.nebula;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;

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
 * @see org.eclipse.rcptt.tesla.protocol.nebula.NebulaFactory
 * @model kind="package"
 * @generated
 */
public interface NebulaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nebula";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/tesla/nebula";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.tesla.nebula";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NebulaPackage eINSTANCE = org.eclipse.rcptt.tesla.protocol.nebula.impl.NebulaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.protocol.nebula.impl.SetSelectionExImpl <em>Set Selection Ex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.impl.SetSelectionExImpl
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.impl.NebulaPackageImpl#getSetSelectionEx()
	 * @generated
	 */
	int SET_SELECTION_EX = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_EX__ID = ProtocolPackage.SET_SELECTION__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_EX__ELEMENT = ProtocolPackage.SET_SELECTION__ELEMENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_EX__PATH = ProtocolPackage.SET_SELECTION__PATH;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_EX__PATTERN = ProtocolPackage.SET_SELECTION__PATTERN;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_EX__INDEX = ProtocolPackage.SET_SELECTION__INDEX;

	/**
	 * The feature id for the '<em><b>Additional Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_EX__ADDITIONAL_ITEMS = ProtocolPackage.SET_SELECTION__ADDITIONAL_ITEMS;

	/**
	 * The feature id for the '<em><b>All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_EX__ALL = ProtocolPackage.SET_SELECTION__ALL;

	/**
	 * The number of structural features of the '<em>Set Selection Ex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_EX_FEATURE_COUNT = ProtocolPackage.SET_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.protocol.nebula.impl.SetSelectionRangeImpl <em>Set Selection Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.impl.SetSelectionRangeImpl
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.impl.NebulaPackageImpl#getSetSelectionRange()
	 * @generated
	 */
	int SET_SELECTION_RANGE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_RANGE__ID = ProtocolPackage.SET_SELECTION__ID;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_RANGE__ELEMENT = ProtocolPackage.SET_SELECTION__ELEMENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_RANGE__PATH = ProtocolPackage.SET_SELECTION__PATH;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_RANGE__PATTERN = ProtocolPackage.SET_SELECTION__PATTERN;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_RANGE__INDEX = ProtocolPackage.SET_SELECTION__INDEX;

	/**
	 * The feature id for the '<em><b>Additional Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_RANGE__ADDITIONAL_ITEMS = ProtocolPackage.SET_SELECTION__ADDITIONAL_ITEMS;

	/**
	 * The feature id for the '<em><b>All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_RANGE__ALL = ProtocolPackage.SET_SELECTION__ALL;

	/**
	 * The feature id for the '<em><b>To Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_RANGE__TO_PATH = ProtocolPackage.SET_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_RANGE__FROM = ProtocolPackage.SET_SELECTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_RANGE__TO = ProtocolPackage.SET_SELECTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Set Selection Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_SELECTION_RANGE_FEATURE_COUNT = ProtocolPackage.SET_SELECTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.protocol.nebula.impl.MultiSelectionItemExImpl <em>Multi Selection Item Ex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.impl.MultiSelectionItemExImpl
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.impl.NebulaPackageImpl#getMultiSelectionItemEx()
	 * @generated
	 */
	int MULTI_SELECTION_ITEM_EX = 2;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SELECTION_ITEM_EX__PATH = ProtocolPackage.MULTI_SELECTION_ITEM__PATH;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SELECTION_ITEM_EX__PATTERN = ProtocolPackage.MULTI_SELECTION_ITEM__PATTERN;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SELECTION_ITEM_EX__INDEX = ProtocolPackage.MULTI_SELECTION_ITEM__INDEX;

	/**
	 * The feature id for the '<em><b>Cell Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SELECTION_ITEM_EX__CELL_COLUMN = ProtocolPackage.MULTI_SELECTION_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Row Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SELECTION_ITEM_EX__ROW_HEADER = ProtocolPackage.MULTI_SELECTION_ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multi Selection Item Ex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_SELECTION_ITEM_EX_FEATURE_COUNT = ProtocolPackage.MULTI_SELECTION_ITEM_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionEx <em>Set Selection Ex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Selection Ex</em>'.
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionEx
	 * @generated
	 */
	EClass getSetSelectionEx();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange <em>Set Selection Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Selection Range</em>'.
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange
	 * @generated
	 */
	EClass getSetSelectionRange();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange#getToPath <em>To Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>To Path</em>'.
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange#getToPath()
	 * @see #getSetSelectionRange()
	 * @generated
	 */
	EAttribute getSetSelectionRange_ToPath();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange#getFrom()
	 * @see #getSetSelectionRange()
	 * @generated
	 */
	EReference getSetSelectionRange_From();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange#getTo()
	 * @see #getSetSelectionRange()
	 * @generated
	 */
	EReference getSetSelectionRange_To();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx <em>Multi Selection Item Ex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Selection Item Ex</em>'.
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx
	 * @generated
	 */
	EClass getMultiSelectionItemEx();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx#getCellColumn <em>Cell Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cell Column</em>'.
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx#getCellColumn()
	 * @see #getMultiSelectionItemEx()
	 * @generated
	 */
	EAttribute getMultiSelectionItemEx_CellColumn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx#isRowHeader <em>Row Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Row Header</em>'.
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx#isRowHeader()
	 * @see #getMultiSelectionItemEx()
	 * @generated
	 */
	EAttribute getMultiSelectionItemEx_RowHeader();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NebulaFactory getNebulaFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.protocol.nebula.impl.SetSelectionExImpl <em>Set Selection Ex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.protocol.nebula.impl.SetSelectionExImpl
		 * @see org.eclipse.rcptt.tesla.protocol.nebula.impl.NebulaPackageImpl#getSetSelectionEx()
		 * @generated
		 */
		EClass SET_SELECTION_EX = eINSTANCE.getSetSelectionEx();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.protocol.nebula.impl.SetSelectionRangeImpl <em>Set Selection Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.protocol.nebula.impl.SetSelectionRangeImpl
		 * @see org.eclipse.rcptt.tesla.protocol.nebula.impl.NebulaPackageImpl#getSetSelectionRange()
		 * @generated
		 */
		EClass SET_SELECTION_RANGE = eINSTANCE.getSetSelectionRange();

		/**
		 * The meta object literal for the '<em><b>To Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_SELECTION_RANGE__TO_PATH = eINSTANCE.getSetSelectionRange_ToPath();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_SELECTION_RANGE__FROM = eINSTANCE.getSetSelectionRange_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_SELECTION_RANGE__TO = eINSTANCE.getSetSelectionRange_To();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.protocol.nebula.impl.MultiSelectionItemExImpl <em>Multi Selection Item Ex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.protocol.nebula.impl.MultiSelectionItemExImpl
		 * @see org.eclipse.rcptt.tesla.protocol.nebula.impl.NebulaPackageImpl#getMultiSelectionItemEx()
		 * @generated
		 */
		EClass MULTI_SELECTION_ITEM_EX = eINSTANCE.getMultiSelectionItemEx();

		/**
		 * The meta object literal for the '<em><b>Cell Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_SELECTION_ITEM_EX__CELL_COLUMN = eINSTANCE.getMultiSelectionItemEx_CellColumn();

		/**
		 * The meta object literal for the '<em><b>Row Header</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_SELECTION_ITEM_EX__ROW_HEADER = eINSTANCE.getMultiSelectionItemEx_RowHeader();

	}

} //NebulaPackage
