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
package org.eclipse.rcptt.verifications.tree;

import org.eclipse.rcptt.core.scenario.ScenarioPackage;

import org.eclipse.rcptt.tesla.core.ui.UiPackage;
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
 * @see org.eclipse.rcptt.verifications.tree.TreeFactory
 * @model kind="package"
 * @generated
 */
public interface TreePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tree";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/verifications/tree";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.verifications.tree";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TreePackage eINSTANCE = org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.tree.impl.CommonTreeVerificationDataImpl <em>Common Tree Verification Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.tree.impl.CommonTreeVerificationDataImpl
	 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getCommonTreeVerificationData()
	 * @generated
	 */
	int COMMON_TREE_VERIFICATION_DATA = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TREE_VERIFICATION_DATA__NAME = ScenarioPackage.WIDGET_VERIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TREE_VERIFICATION_DATA__VERSION = ScenarioPackage.WIDGET_VERIFICATION__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TREE_VERIFICATION_DATA__ID = ScenarioPackage.WIDGET_VERIFICATION__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TREE_VERIFICATION_DATA__DESCRIPTION = ScenarioPackage.WIDGET_VERIFICATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TREE_VERIFICATION_DATA__TAGS = ScenarioPackage.WIDGET_VERIFICATION__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TREE_VERIFICATION_DATA__ATTACHMENTS = ScenarioPackage.WIDGET_VERIFICATION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TREE_VERIFICATION_DATA__SELECTOR = ScenarioPackage.WIDGET_VERIFICATION__SELECTOR;

	/**
	 * The feature id for the '<em><b>Tree</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TREE_VERIFICATION_DATA__TREE = ScenarioPackage.WIDGET_VERIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Common Tree Verification Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_TREE_VERIFICATION_DATA_FEATURE_COUNT = ScenarioPackage.WIDGET_VERIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.tree.impl.CaptureTreeVerificationDataImpl <em>Capture Tree Verification Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.tree.impl.CaptureTreeVerificationDataImpl
	 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getCaptureTreeVerificationData()
	 * @generated
	 */
	int CAPTURE_TREE_VERIFICATION_DATA = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTURE_TREE_VERIFICATION_DATA__NAME = COMMON_TREE_VERIFICATION_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTURE_TREE_VERIFICATION_DATA__VERSION = COMMON_TREE_VERIFICATION_DATA__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTURE_TREE_VERIFICATION_DATA__ID = COMMON_TREE_VERIFICATION_DATA__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTURE_TREE_VERIFICATION_DATA__DESCRIPTION = COMMON_TREE_VERIFICATION_DATA__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTURE_TREE_VERIFICATION_DATA__TAGS = COMMON_TREE_VERIFICATION_DATA__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTURE_TREE_VERIFICATION_DATA__ATTACHMENTS = COMMON_TREE_VERIFICATION_DATA__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTURE_TREE_VERIFICATION_DATA__SELECTOR = COMMON_TREE_VERIFICATION_DATA__SELECTOR;

	/**
	 * The feature id for the '<em><b>Tree</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTURE_TREE_VERIFICATION_DATA__TREE = COMMON_TREE_VERIFICATION_DATA__TREE;

	/**
	 * The feature id for the '<em><b>Images</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTURE_TREE_VERIFICATION_DATA__IMAGES = COMMON_TREE_VERIFICATION_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Capture Tree Verification Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPTURE_TREE_VERIFICATION_DATA_FEATURE_COUNT = COMMON_TREE_VERIFICATION_DATA_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.tree.impl.TreeVerificationImpl <em>Verification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.tree.impl.TreeVerificationImpl
	 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getTreeVerification()
	 * @generated
	 */
	int TREE_VERIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VERIFICATION__NAME = CAPTURE_TREE_VERIFICATION_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VERIFICATION__VERSION = CAPTURE_TREE_VERIFICATION_DATA__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VERIFICATION__ID = CAPTURE_TREE_VERIFICATION_DATA__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VERIFICATION__DESCRIPTION = CAPTURE_TREE_VERIFICATION_DATA__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VERIFICATION__TAGS = CAPTURE_TREE_VERIFICATION_DATA__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VERIFICATION__ATTACHMENTS = CAPTURE_TREE_VERIFICATION_DATA__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VERIFICATION__SELECTOR = CAPTURE_TREE_VERIFICATION_DATA__SELECTOR;

	/**
	 * The feature id for the '<em><b>Tree</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VERIFICATION__TREE = CAPTURE_TREE_VERIFICATION_DATA__TREE;

	/**
	 * The feature id for the '<em><b>Images</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VERIFICATION__IMAGES = CAPTURE_TREE_VERIFICATION_DATA__IMAGES;

	/**
	 * The feature id for the '<em><b>Allow Extra Columns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VERIFICATION__ALLOW_EXTRA_COLUMNS = CAPTURE_TREE_VERIFICATION_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Allow Missing Columns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VERIFICATION__ALLOW_MISSING_COLUMNS = CAPTURE_TREE_VERIFICATION_DATA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Verify Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VERIFICATION__VERIFY_STYLE = CAPTURE_TREE_VERIFICATION_DATA_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Verify Icons</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VERIFICATION__VERIFY_ICONS = CAPTURE_TREE_VERIFICATION_DATA_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Allow Uncaptured Children</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VERIFICATION__ALLOW_UNCAPTURED_CHILDREN = CAPTURE_TREE_VERIFICATION_DATA_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Verification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_VERIFICATION_FEATURE_COUNT = CAPTURE_TREE_VERIFICATION_DATA_FEATURE_COUNT + 5;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.tree.impl.TreeImpl <em>Tree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.tree.impl.TreeImpl
	 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getTree()
	 * @generated
	 */
	int TREE = 1;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__COLUMNS = 0;

	/**
	 * The feature id for the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__STYLE = 1;

	/**
	 * The feature id for the '<em><b>Rows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__ROWS = 2;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__ENABLED = 3;

	/**
	 * The feature id for the '<em><b>Header Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__HEADER_VISIBLE = 4;

	/**
	 * The feature id for the '<em><b>Lines Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__LINES_VISIBLE = 5;

	/**
	 * The feature id for the '<em><b>Sort Column Ind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__SORT_COLUMN_IND = 6;

	/**
	 * The feature id for the '<em><b>Sort Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__SORT_DIRECTION = 7;

	/**
	 * The number of structural features of the '<em>Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.tree.impl.ColumnImpl <em>Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.tree.impl.ColumnImpl
	 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getColumn()
	 * @generated
	 */
	int COLUMN = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__WIDTH = 1;

	/**
	 * The feature id for the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__STYLE = 2;

	/**
	 * The feature id for the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__IMAGE = 3;

	/**
	 * The feature id for the '<em><b>Tooltip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__TOOLTIP = 4;

	/**
	 * The number of structural features of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.tree.impl.RowImpl <em>Row</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.tree.impl.RowImpl
	 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getRow()
	 * @generated
	 */
	int ROW = 3;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__VALUES = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__CHILDREN = 1;

	/**
	 * The feature id for the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__CHECKED = 2;

	/**
	 * The feature id for the '<em><b>Grayed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__GRAYED = 3;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW__DATA = 4;

	/**
	 * The number of structural features of the '<em>Row</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROW_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.tree.impl.CellImpl <em>Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.tree.impl.CellImpl
	 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getCell()
	 * @generated
	 */
	int CELL = 4;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL__STYLE = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL__DATA = 1;

	/**
	 * The number of structural features of the '<em>Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CELL_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.tree.impl.ImagesMapImpl <em>Images Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.tree.impl.ImagesMapImpl
	 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getImagesMap()
	 * @generated
	 */
	int IMAGES_MAP = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGES_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGES_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Images Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGES_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.tree.impl.ItemDataImpl <em>Item Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.tree.impl.ItemDataImpl
	 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getItemData()
	 * @generated
	 */
	int ITEM_DATA = 6;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DATA__TEXT = 0;

	/**
	 * The feature id for the '<em><b>Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DATA__IMAGE = 1;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DATA__FOREGROUND_COLOR = 2;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DATA__BACKGROUND_COLOR = 3;

	/**
	 * The number of structural features of the '<em>Item Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_DATA_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.tree.impl.VerifyTreeDataImpl <em>Verify Tree Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.tree.impl.VerifyTreeDataImpl
	 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getVerifyTreeData()
	 * @generated
	 */
	int VERIFY_TREE_DATA = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TREE_DATA__NAME = COMMON_TREE_VERIFICATION_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TREE_DATA__VERSION = COMMON_TREE_VERIFICATION_DATA__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TREE_DATA__ID = COMMON_TREE_VERIFICATION_DATA__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TREE_DATA__DESCRIPTION = COMMON_TREE_VERIFICATION_DATA__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TREE_DATA__TAGS = COMMON_TREE_VERIFICATION_DATA__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TREE_DATA__ATTACHMENTS = COMMON_TREE_VERIFICATION_DATA__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TREE_DATA__SELECTOR = COMMON_TREE_VERIFICATION_DATA__SELECTOR;

	/**
	 * The feature id for the '<em><b>Tree</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TREE_DATA__TREE = COMMON_TREE_VERIFICATION_DATA__TREE;

	/**
	 * The feature id for the '<em><b>Allow Extra Columns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TREE_DATA__ALLOW_EXTRA_COLUMNS = COMMON_TREE_VERIFICATION_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Allow Missing Columns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TREE_DATA__ALLOW_MISSING_COLUMNS = COMMON_TREE_VERIFICATION_DATA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Verify Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TREE_DATA__VERIFY_STYLE = COMMON_TREE_VERIFICATION_DATA_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Verify Icons</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TREE_DATA__VERIFY_ICONS = COMMON_TREE_VERIFICATION_DATA_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Allow Uncaptured Children</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TREE_DATA__ALLOW_UNCAPTURED_CHILDREN = COMMON_TREE_VERIFICATION_DATA_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Verify Tree Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFY_TREE_DATA_FEATURE_COUNT = COMMON_TREE_VERIFICATION_DATA_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.tree.VerifyStyleType <em>Verify Style Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.tree.VerifyStyleType
	 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getVerifyStyleType()
	 * @generated
	 */
	int VERIFY_STYLE_TYPE = 10;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.tree.TreeVerification <em>Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verification</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.TreeVerification
	 * @generated
	 */
	EClass getTreeVerification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.tree.Tree <em>Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Tree
	 * @generated
	 */
	EClass getTree();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.verifications.tree.Tree#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Tree#getColumns()
	 * @see #getTree()
	 * @generated
	 */
	EReference getTree_Columns();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.Tree#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Tree#getStyle()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_Style();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.verifications.tree.Tree#getRows <em>Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rows</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Tree#getRows()
	 * @see #getTree()
	 * @generated
	 */
	EReference getTree_Rows();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.Tree#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Tree#isEnabled()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.Tree#isHeaderVisible <em>Header Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Header Visible</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Tree#isHeaderVisible()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_HeaderVisible();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.Tree#isLinesVisible <em>Lines Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lines Visible</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Tree#isLinesVisible()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_LinesVisible();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.Tree#getSortColumnInd <em>Sort Column Ind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sort Column Ind</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Tree#getSortColumnInd()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_SortColumnInd();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.Tree#getSortDirection <em>Sort Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sort Direction</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Tree#getSortDirection()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_SortDirection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.tree.Column <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Column</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Column
	 * @generated
	 */
	EClass getColumn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.Column#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Column#getName()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.Column#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Column#getWidth()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.Column#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Column#getStyle()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Style();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.verifications.tree.Column#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Image</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Column#getImage()
	 * @see #getColumn()
	 * @generated
	 */
	EReference getColumn_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.Column#getTooltip <em>Tooltip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tooltip</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Column#getTooltip()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Tooltip();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.tree.Row <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Row</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Row
	 * @generated
	 */
	EClass getRow();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.verifications.tree.Row#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Row#getValues()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_Values();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.verifications.tree.Row#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Row#getChildren()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_Children();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.Row#isChecked <em>Checked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checked</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Row#isChecked()
	 * @see #getRow()
	 * @generated
	 */
	EAttribute getRow_Checked();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.Row#isGrayed <em>Grayed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grayed</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Row#isGrayed()
	 * @see #getRow()
	 * @generated
	 */
	EAttribute getRow_Grayed();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.verifications.tree.Row#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Row#getData()
	 * @see #getRow()
	 * @generated
	 */
	EReference getRow_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.tree.Cell <em>Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cell</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Cell
	 * @generated
	 */
	EClass getCell();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.verifications.tree.Cell#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Style</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Cell#getStyle()
	 * @see #getCell()
	 * @generated
	 */
	EReference getCell_Style();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.verifications.tree.Cell#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.Cell#getData()
	 * @see #getCell()
	 * @generated
	 */
	EReference getCell_Data();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Images Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Images Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EByteArray"
	 * @generated
	 */
	EClass getImagesMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getImagesMap()
	 * @generated
	 */
	EAttribute getImagesMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getImagesMap()
	 * @generated
	 */
	EAttribute getImagesMap_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.tree.ItemData <em>Item Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item Data</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.ItemData
	 * @generated
	 */
	EClass getItemData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.ItemData#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.ItemData#getText()
	 * @see #getItemData()
	 * @generated
	 */
	EAttribute getItemData_Text();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.verifications.tree.ItemData#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Image</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.ItemData#getImage()
	 * @see #getItemData()
	 * @generated
	 */
	EReference getItemData_Image();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.verifications.tree.ItemData#getForegroundColor <em>Foreground Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Foreground Color</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.ItemData#getForegroundColor()
	 * @see #getItemData()
	 * @generated
	 */
	EReference getItemData_ForegroundColor();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.verifications.tree.ItemData#getBackgroundColor <em>Background Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Background Color</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.ItemData#getBackgroundColor()
	 * @see #getItemData()
	 * @generated
	 */
	EReference getItemData_BackgroundColor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.tree.CommonTreeVerificationData <em>Common Tree Verification Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Common Tree Verification Data</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.CommonTreeVerificationData
	 * @generated
	 */
	EClass getCommonTreeVerificationData();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.verifications.tree.CommonTreeVerificationData#getTree <em>Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tree</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.CommonTreeVerificationData#getTree()
	 * @see #getCommonTreeVerificationData()
	 * @generated
	 */
	EReference getCommonTreeVerificationData_Tree();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.tree.CaptureTreeVerificationData <em>Capture Tree Verification Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capture Tree Verification Data</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.CaptureTreeVerificationData
	 * @generated
	 */
	EClass getCaptureTreeVerificationData();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.rcptt.verifications.tree.CaptureTreeVerificationData#getImages <em>Images</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Images</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.CaptureTreeVerificationData#getImages()
	 * @see #getCaptureTreeVerificationData()
	 * @generated
	 */
	EReference getCaptureTreeVerificationData_Images();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData <em>Verify Tree Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verify Tree Data</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.VerifyTreeData
	 * @generated
	 */
	EClass getVerifyTreeData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#isAllowExtraColumns <em>Allow Extra Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Extra Columns</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.VerifyTreeData#isAllowExtraColumns()
	 * @see #getVerifyTreeData()
	 * @generated
	 */
	EAttribute getVerifyTreeData_AllowExtraColumns();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#isAllowMissingColumns <em>Allow Missing Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Missing Columns</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.VerifyTreeData#isAllowMissingColumns()
	 * @see #getVerifyTreeData()
	 * @generated
	 */
	EAttribute getVerifyTreeData_AllowMissingColumns();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#getVerifyStyle <em>Verify Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Verify Style</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.VerifyTreeData#getVerifyStyle()
	 * @see #getVerifyTreeData()
	 * @generated
	 */
	EAttribute getVerifyTreeData_VerifyStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#isVerifyIcons <em>Verify Icons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Verify Icons</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.VerifyTreeData#isVerifyIcons()
	 * @see #getVerifyTreeData()
	 * @generated
	 */
	EAttribute getVerifyTreeData_VerifyIcons();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#isAllowUncapturedChildren <em>Allow Uncaptured Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Uncaptured Children</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.VerifyTreeData#isAllowUncapturedChildren()
	 * @see #getVerifyTreeData()
	 * @generated
	 */
	EAttribute getVerifyTreeData_AllowUncapturedChildren();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.verifications.tree.VerifyStyleType <em>Verify Style Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Verify Style Type</em>'.
	 * @see org.eclipse.rcptt.verifications.tree.VerifyStyleType
	 * @generated
	 */
	EEnum getVerifyStyleType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TreeFactory getTreeFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.tree.impl.TreeVerificationImpl <em>Verification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.tree.impl.TreeVerificationImpl
		 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getTreeVerification()
		 * @generated
		 */
		EClass TREE_VERIFICATION = eINSTANCE.getTreeVerification();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.tree.impl.TreeImpl <em>Tree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.tree.impl.TreeImpl
		 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getTree()
		 * @generated
		 */
		EClass TREE = eINSTANCE.getTree();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE__COLUMNS = eINSTANCE.getTree_Columns();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__STYLE = eINSTANCE.getTree_Style();

		/**
		 * The meta object literal for the '<em><b>Rows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE__ROWS = eINSTANCE.getTree_Rows();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__ENABLED = eINSTANCE.getTree_Enabled();

		/**
		 * The meta object literal for the '<em><b>Header Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__HEADER_VISIBLE = eINSTANCE.getTree_HeaderVisible();

		/**
		 * The meta object literal for the '<em><b>Lines Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__LINES_VISIBLE = eINSTANCE.getTree_LinesVisible();

		/**
		 * The meta object literal for the '<em><b>Sort Column Ind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__SORT_COLUMN_IND = eINSTANCE.getTree_SortColumnInd();

		/**
		 * The meta object literal for the '<em><b>Sort Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__SORT_DIRECTION = eINSTANCE.getTree_SortDirection();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.tree.impl.ColumnImpl <em>Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.tree.impl.ColumnImpl
		 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getColumn()
		 * @generated
		 */
		EClass COLUMN = eINSTANCE.getColumn();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__NAME = eINSTANCE.getColumn_Name();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__WIDTH = eINSTANCE.getColumn_Width();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__STYLE = eINSTANCE.getColumn_Style();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN__IMAGE = eINSTANCE.getColumn_Image();

		/**
		 * The meta object literal for the '<em><b>Tooltip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__TOOLTIP = eINSTANCE.getColumn_Tooltip();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.tree.impl.RowImpl <em>Row</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.tree.impl.RowImpl
		 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getRow()
		 * @generated
		 */
		EClass ROW = eINSTANCE.getRow();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROW__VALUES = eINSTANCE.getRow_Values();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROW__CHILDREN = eINSTANCE.getRow_Children();

		/**
		 * The meta object literal for the '<em><b>Checked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW__CHECKED = eINSTANCE.getRow_Checked();

		/**
		 * The meta object literal for the '<em><b>Grayed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROW__GRAYED = eINSTANCE.getRow_Grayed();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROW__DATA = eINSTANCE.getRow_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.tree.impl.CellImpl <em>Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.tree.impl.CellImpl
		 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getCell()
		 * @generated
		 */
		EClass CELL = eINSTANCE.getCell();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CELL__STYLE = eINSTANCE.getCell_Style();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CELL__DATA = eINSTANCE.getCell_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.tree.impl.ImagesMapImpl <em>Images Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.tree.impl.ImagesMapImpl
		 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getImagesMap()
		 * @generated
		 */
		EClass IMAGES_MAP = eINSTANCE.getImagesMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGES_MAP__KEY = eINSTANCE.getImagesMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGES_MAP__VALUE = eINSTANCE.getImagesMap_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.tree.impl.ItemDataImpl <em>Item Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.tree.impl.ItemDataImpl
		 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getItemData()
		 * @generated
		 */
		EClass ITEM_DATA = eINSTANCE.getItemData();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM_DATA__TEXT = eINSTANCE.getItemData_Text();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITEM_DATA__IMAGE = eINSTANCE.getItemData_Image();

		/**
		 * The meta object literal for the '<em><b>Foreground Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITEM_DATA__FOREGROUND_COLOR = eINSTANCE.getItemData_ForegroundColor();

		/**
		 * The meta object literal for the '<em><b>Background Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITEM_DATA__BACKGROUND_COLOR = eINSTANCE.getItemData_BackgroundColor();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.tree.impl.CommonTreeVerificationDataImpl <em>Common Tree Verification Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.tree.impl.CommonTreeVerificationDataImpl
		 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getCommonTreeVerificationData()
		 * @generated
		 */
		EClass COMMON_TREE_VERIFICATION_DATA = eINSTANCE.getCommonTreeVerificationData();

		/**
		 * The meta object literal for the '<em><b>Tree</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMON_TREE_VERIFICATION_DATA__TREE = eINSTANCE.getCommonTreeVerificationData_Tree();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.tree.impl.CaptureTreeVerificationDataImpl <em>Capture Tree Verification Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.tree.impl.CaptureTreeVerificationDataImpl
		 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getCaptureTreeVerificationData()
		 * @generated
		 */
		EClass CAPTURE_TREE_VERIFICATION_DATA = eINSTANCE.getCaptureTreeVerificationData();

		/**
		 * The meta object literal for the '<em><b>Images</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPTURE_TREE_VERIFICATION_DATA__IMAGES = eINSTANCE.getCaptureTreeVerificationData_Images();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.tree.impl.VerifyTreeDataImpl <em>Verify Tree Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.tree.impl.VerifyTreeDataImpl
		 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getVerifyTreeData()
		 * @generated
		 */
		EClass VERIFY_TREE_DATA = eINSTANCE.getVerifyTreeData();

		/**
		 * The meta object literal for the '<em><b>Allow Extra Columns</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERIFY_TREE_DATA__ALLOW_EXTRA_COLUMNS = eINSTANCE.getVerifyTreeData_AllowExtraColumns();

		/**
		 * The meta object literal for the '<em><b>Allow Missing Columns</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERIFY_TREE_DATA__ALLOW_MISSING_COLUMNS = eINSTANCE.getVerifyTreeData_AllowMissingColumns();

		/**
		 * The meta object literal for the '<em><b>Verify Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERIFY_TREE_DATA__VERIFY_STYLE = eINSTANCE.getVerifyTreeData_VerifyStyle();

		/**
		 * The meta object literal for the '<em><b>Verify Icons</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERIFY_TREE_DATA__VERIFY_ICONS = eINSTANCE.getVerifyTreeData_VerifyIcons();

		/**
		 * The meta object literal for the '<em><b>Allow Uncaptured Children</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERIFY_TREE_DATA__ALLOW_UNCAPTURED_CHILDREN = eINSTANCE.getVerifyTreeData_AllowUncapturedChildren();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.tree.VerifyStyleType <em>Verify Style Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.tree.VerifyStyleType
		 * @see org.eclipse.rcptt.verifications.tree.impl.TreePackageImpl#getVerifyStyleType()
		 * @generated
		 */
		EEnum VERIFY_STYLE_TYPE = eINSTANCE.getVerifyStyleType();

	}

} //TreePackage
