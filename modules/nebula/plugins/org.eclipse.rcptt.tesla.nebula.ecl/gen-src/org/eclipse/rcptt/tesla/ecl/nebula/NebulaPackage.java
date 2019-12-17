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
package org.eclipse.rcptt.tesla.ecl.nebula;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.rcptt.ecl.core.CorePackage;

import org.eclipse.rcptt.tesla.core.ui.UiPackage;

import org.eclipse.rcptt.tesla.ecl.model.TeslaPackage;

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
 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaFactory
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
	String eNS_URI = "http://eclipse.org/rcptt/tesla/nebula/ecl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.tesla.nebula.ecl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NebulaPackage eINSTANCE = org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.GetNebulaGridImpl <em>Get Nebula Grid</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.GetNebulaGridImpl
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getGetNebulaGrid()
	 * @generated
	 */
	int GET_NEBULA_GRID = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_GRID__HOST = TeslaPackage.SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_GRID__BINDINGS = TeslaPackage.SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_GRID__ID = TeslaPackage.SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_GRID__AFTER = TeslaPackage.SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_GRID__TYPE = TeslaPackage.SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_GRID__INDEX = TeslaPackage.SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_GRID__PARENT = TeslaPackage.SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Nebula Grid</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_GRID_FEATURE_COUNT = TeslaPackage.SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridImpl <em>Grid</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridImpl
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getNebulaGrid()
	 * @generated
	 */
	int NEBULA_GRID = 1;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID__PROPERTY_NODES = UiPackage.CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID__CLASS_NAME = UiPackage.CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID__ENABLEMENT = UiPackage.CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID__BACKGROUND_COLOR = UiPackage.CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID__FOREGROUND_COLOR = UiPackage.CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID__CONTAIN_MENU = UiPackage.CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID__BOUNDS = UiPackage.CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID__BORDER_WITH = UiPackage.CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID__DECORATORS = UiPackage.CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Lines Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID__LINES_VISIBLE = UiPackage.CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Multi Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID__MULTI_SELECTION = UiPackage.CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Header Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID__HEADER_VISIBLE = UiPackage.CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Item Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID__ITEM_COUNT = UiPackage.CONTROL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID__SELECTION = UiPackage.CONTROL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID__COLUMNS = UiPackage.CONTROL_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Grid</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_FEATURE_COUNT = UiPackage.CONTROL_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridItemImpl <em>Grid Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridItemImpl
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getNebulaGridItem()
	 * @generated
	 */
	int NEBULA_GRID_ITEM = 2;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_ITEM__PROPERTY_NODES = UiPackage.ITEM__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_ITEM__CAPTION = UiPackage.ITEM__CAPTION;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_ITEM__SELECTION = UiPackage.ITEM__SELECTION;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_ITEM__ENABLEMENT = UiPackage.ITEM__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_ITEM__INDEX = UiPackage.ITEM__INDEX;

	/**
	 * The feature id for the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_ITEM__CHECKED = UiPackage.ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_ITEM__BACKGROUND_COLOR = UiPackage.ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_ITEM__FOREGROUND_COLOR = UiPackage.ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_ITEM__BOUNDS = UiPackage.ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Child Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_ITEM__CHILD_COUNT = UiPackage.ITEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_ITEM__COLUMNS = UiPackage.ITEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Columns Background Color</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_ITEM__COLUMNS_BACKGROUND_COLOR = UiPackage.ITEM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Columns Foreground Color</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_ITEM__COLUMNS_FOREGROUND_COLOR = UiPackage.ITEM_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Grid Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_ITEM_FEATURE_COUNT = UiPackage.ITEM_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridColumnImpl <em>Grid Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridColumnImpl
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getNebulaGridColumn()
	 * @generated
	 */
	int NEBULA_GRID_COLUMN = 3;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_COLUMN__PROPERTY_NODES = UiPackage.ITEM__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_COLUMN__CAPTION = UiPackage.ITEM__CAPTION;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_COLUMN__SELECTION = UiPackage.ITEM__SELECTION;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_COLUMN__ENABLEMENT = UiPackage.ITEM__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_COLUMN__INDEX = UiPackage.ITEM__INDEX;

	/**
	 * The feature id for the '<em><b>Resizable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_COLUMN__RESIZABLE = UiPackage.ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_COLUMN__MOVABLE = UiPackage.ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_COLUMN__WIDTH = UiPackage.ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tooltip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_COLUMN__TOOLTIP = UiPackage.ITEM_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Grid Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_GRID_COLUMN_FEATURE_COUNT = UiPackage.ITEM_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.GetRowHeaderImpl <em>Get Row Header</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.GetRowHeaderImpl
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getGetRowHeader()
	 * @generated
	 */
	int GET_ROW_HEADER = 4;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ROW_HEADER__HOST = TeslaPackage.SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ROW_HEADER__BINDINGS = TeslaPackage.SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ROW_HEADER__ID = TeslaPackage.SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ROW_HEADER__AFTER = TeslaPackage.SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ROW_HEADER__TYPE = TeslaPackage.SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ROW_HEADER__INDEX = TeslaPackage.SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ROW_HEADER__PARENT = TeslaPackage.SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Row Header</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ROW_HEADER_FEATURE_COUNT = TeslaPackage.SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.GetItemCellImpl <em>Get Item Cell</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.GetItemCellImpl
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getGetItemCell()
	 * @generated
	 */
	int GET_ITEM_CELL = 5;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM_CELL__HOST = TeslaPackage.SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM_CELL__BINDINGS = TeslaPackage.SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM_CELL__ID = TeslaPackage.SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM_CELL__AFTER = TeslaPackage.SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM_CELL__TYPE = TeslaPackage.SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM_CELL__INDEX = TeslaPackage.SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM_CELL__PARENT = TeslaPackage.SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM_CELL__COLUMN = TeslaPackage.SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Item Cell</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ITEM_CELL_FEATURE_COUNT = TeslaPackage.SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.GetEmptyAreaImpl <em>Get Empty Area</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.GetEmptyAreaImpl
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getGetEmptyArea()
	 * @generated
	 */
	int GET_EMPTY_AREA = 6;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EMPTY_AREA__HOST = TeslaPackage.SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EMPTY_AREA__BINDINGS = TeslaPackage.SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EMPTY_AREA__ID = TeslaPackage.SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EMPTY_AREA__AFTER = TeslaPackage.SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EMPTY_AREA__TYPE = TeslaPackage.SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EMPTY_AREA__INDEX = TeslaPackage.SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EMPTY_AREA__PARENT = TeslaPackage.SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EMPTY_AREA__TOP = TeslaPackage.SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EMPTY_AREA__LEFT = TeslaPackage.SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EMPTY_AREA__COLUMN = TeslaPackage.SELECTOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Get Empty Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EMPTY_AREA_FEATURE_COUNT = TeslaPackage.SELECTOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.SelectGridRangeImpl <em>Select Grid Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.SelectGridRangeImpl
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getSelectGridRange()
	 * @generated
	 */
	int SELECT_GRID_RANGE = 7;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_GRID_RANGE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_GRID_RANGE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_GRID_RANGE__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_GRID_RANGE__FROM = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_GRID_RANGE__TO = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Select Grid Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_GRID_RANGE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.nebula.GetNebulaGrid <em>Get Nebula Grid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Nebula Grid</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.GetNebulaGrid
	 * @generated
	 */
	EClass getGetNebulaGrid();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid <em>Grid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grid</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid
	 * @generated
	 */
	EClass getNebulaGrid();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid#isLinesVisible <em>Lines Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lines Visible</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid#isLinesVisible()
	 * @see #getNebulaGrid()
	 * @generated
	 */
	EAttribute getNebulaGrid_LinesVisible();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid#isMultiSelection <em>Multi Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multi Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid#isMultiSelection()
	 * @see #getNebulaGrid()
	 * @generated
	 */
	EAttribute getNebulaGrid_MultiSelection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid#isHeaderVisible <em>Header Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Header Visible</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid#isHeaderVisible()
	 * @see #getNebulaGrid()
	 * @generated
	 */
	EAttribute getNebulaGrid_HeaderVisible();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid#getItemCount <em>Item Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Item Count</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid#getItemCount()
	 * @see #getNebulaGrid()
	 * @generated
	 */
	EAttribute getNebulaGrid_ItemCount();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid#getSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid#getSelection()
	 * @see #getNebulaGrid()
	 * @generated
	 */
	EReference getNebulaGrid_Selection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid#getColumns()
	 * @see #getNebulaGrid()
	 * @generated
	 */
	EReference getNebulaGrid_Columns();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem <em>Grid Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grid Item</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem
	 * @generated
	 */
	EClass getNebulaGridItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#isChecked <em>Checked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checked</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#isChecked()
	 * @see #getNebulaGridItem()
	 * @generated
	 */
	EAttribute getNebulaGridItem_Checked();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getBackgroundColor <em>Background Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Background Color</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getBackgroundColor()
	 * @see #getNebulaGridItem()
	 * @generated
	 */
	EReference getNebulaGridItem_BackgroundColor();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getForegroundColor <em>Foreground Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Foreground Color</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getForegroundColor()
	 * @see #getNebulaGridItem()
	 * @generated
	 */
	EReference getNebulaGridItem_ForegroundColor();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getBounds <em>Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bounds</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getBounds()
	 * @see #getNebulaGridItem()
	 * @generated
	 */
	EReference getNebulaGridItem_Bounds();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getChildCount <em>Child Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Child Count</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getChildCount()
	 * @see #getNebulaGridItem()
	 * @generated
	 */
	EAttribute getNebulaGridItem_ChildCount();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Columns</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getColumns()
	 * @see #getNebulaGridItem()
	 * @generated
	 */
	EAttribute getNebulaGridItem_Columns();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getColumnsBackgroundColor <em>Columns Background Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns Background Color</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getColumnsBackgroundColor()
	 * @see #getNebulaGridItem()
	 * @generated
	 */
	EReference getNebulaGridItem_ColumnsBackgroundColor();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getColumnsForegroundColor <em>Columns Foreground Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns Foreground Color</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getColumnsForegroundColor()
	 * @see #getNebulaGridItem()
	 * @generated
	 */
	EReference getNebulaGridItem_ColumnsForegroundColor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridColumn <em>Grid Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grid Column</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridColumn
	 * @generated
	 */
	EClass getNebulaGridColumn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridColumn#isResizable <em>Resizable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resizable</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridColumn#isResizable()
	 * @see #getNebulaGridColumn()
	 * @generated
	 */
	EAttribute getNebulaGridColumn_Resizable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridColumn#isMovable <em>Movable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Movable</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridColumn#isMovable()
	 * @see #getNebulaGridColumn()
	 * @generated
	 */
	EAttribute getNebulaGridColumn_Movable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridColumn#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridColumn#getWidth()
	 * @see #getNebulaGridColumn()
	 * @generated
	 */
	EAttribute getNebulaGridColumn_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridColumn#getTooltip <em>Tooltip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tooltip</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridColumn#getTooltip()
	 * @see #getNebulaGridColumn()
	 * @generated
	 */
	EAttribute getNebulaGridColumn_Tooltip();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.nebula.GetRowHeader <em>Get Row Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Row Header</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.GetRowHeader
	 * @generated
	 */
	EClass getGetRowHeader();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.nebula.GetItemCell <em>Get Item Cell</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Item Cell</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.GetItemCell
	 * @generated
	 */
	EClass getGetItemCell();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.GetItemCell#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.GetItemCell#getColumn()
	 * @see #getGetItemCell()
	 * @generated
	 */
	EAttribute getGetItemCell_Column();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea <em>Get Empty Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Empty Area</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea
	 * @generated
	 */
	EClass getGetEmptyArea();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea#isTop <em>Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Top</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea#isTop()
	 * @see #getGetEmptyArea()
	 * @generated
	 */
	EAttribute getGetEmptyArea_Top();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea#isLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Left</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea#isLeft()
	 * @see #getGetEmptyArea()
	 * @generated
	 */
	EAttribute getGetEmptyArea_Left();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea#getColumn()
	 * @see #getGetEmptyArea()
	 * @generated
	 */
	EAttribute getGetEmptyArea_Column();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange <em>Select Grid Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select Grid Range</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange
	 * @generated
	 */
	EClass getSelectGridRange();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange#getControl()
	 * @see #getSelectGridRange()
	 * @generated
	 */
	EReference getSelectGridRange_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange#getFrom()
	 * @see #getSelectGridRange()
	 * @generated
	 */
	EAttribute getSelectGridRange_From();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange#getTo()
	 * @see #getSelectGridRange()
	 * @generated
	 */
	EAttribute getSelectGridRange_To();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.GetNebulaGridImpl <em>Get Nebula Grid</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.GetNebulaGridImpl
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getGetNebulaGrid()
		 * @generated
		 */
		EClass GET_NEBULA_GRID = eINSTANCE.getGetNebulaGrid();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridImpl <em>Grid</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridImpl
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getNebulaGrid()
		 * @generated
		 */
		EClass NEBULA_GRID = eINSTANCE.getNebulaGrid();

		/**
		 * The meta object literal for the '<em><b>Lines Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEBULA_GRID__LINES_VISIBLE = eINSTANCE.getNebulaGrid_LinesVisible();

		/**
		 * The meta object literal for the '<em><b>Multi Selection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEBULA_GRID__MULTI_SELECTION = eINSTANCE.getNebulaGrid_MultiSelection();

		/**
		 * The meta object literal for the '<em><b>Header Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEBULA_GRID__HEADER_VISIBLE = eINSTANCE.getNebulaGrid_HeaderVisible();

		/**
		 * The meta object literal for the '<em><b>Item Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEBULA_GRID__ITEM_COUNT = eINSTANCE.getNebulaGrid_ItemCount();

		/**
		 * The meta object literal for the '<em><b>Selection</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEBULA_GRID__SELECTION = eINSTANCE.getNebulaGrid_Selection();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEBULA_GRID__COLUMNS = eINSTANCE.getNebulaGrid_Columns();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridItemImpl <em>Grid Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridItemImpl
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getNebulaGridItem()
		 * @generated
		 */
		EClass NEBULA_GRID_ITEM = eINSTANCE.getNebulaGridItem();

		/**
		 * The meta object literal for the '<em><b>Checked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEBULA_GRID_ITEM__CHECKED = eINSTANCE.getNebulaGridItem_Checked();

		/**
		 * The meta object literal for the '<em><b>Background Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEBULA_GRID_ITEM__BACKGROUND_COLOR = eINSTANCE.getNebulaGridItem_BackgroundColor();

		/**
		 * The meta object literal for the '<em><b>Foreground Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEBULA_GRID_ITEM__FOREGROUND_COLOR = eINSTANCE.getNebulaGridItem_ForegroundColor();

		/**
		 * The meta object literal for the '<em><b>Bounds</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEBULA_GRID_ITEM__BOUNDS = eINSTANCE.getNebulaGridItem_Bounds();

		/**
		 * The meta object literal for the '<em><b>Child Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEBULA_GRID_ITEM__CHILD_COUNT = eINSTANCE.getNebulaGridItem_ChildCount();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEBULA_GRID_ITEM__COLUMNS = eINSTANCE.getNebulaGridItem_Columns();

		/**
		 * The meta object literal for the '<em><b>Columns Background Color</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEBULA_GRID_ITEM__COLUMNS_BACKGROUND_COLOR = eINSTANCE.getNebulaGridItem_ColumnsBackgroundColor();

		/**
		 * The meta object literal for the '<em><b>Columns Foreground Color</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEBULA_GRID_ITEM__COLUMNS_FOREGROUND_COLOR = eINSTANCE.getNebulaGridItem_ColumnsForegroundColor();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridColumnImpl <em>Grid Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridColumnImpl
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getNebulaGridColumn()
		 * @generated
		 */
		EClass NEBULA_GRID_COLUMN = eINSTANCE.getNebulaGridColumn();

		/**
		 * The meta object literal for the '<em><b>Resizable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEBULA_GRID_COLUMN__RESIZABLE = eINSTANCE.getNebulaGridColumn_Resizable();

		/**
		 * The meta object literal for the '<em><b>Movable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEBULA_GRID_COLUMN__MOVABLE = eINSTANCE.getNebulaGridColumn_Movable();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEBULA_GRID_COLUMN__WIDTH = eINSTANCE.getNebulaGridColumn_Width();

		/**
		 * The meta object literal for the '<em><b>Tooltip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEBULA_GRID_COLUMN__TOOLTIP = eINSTANCE.getNebulaGridColumn_Tooltip();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.GetRowHeaderImpl <em>Get Row Header</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.GetRowHeaderImpl
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getGetRowHeader()
		 * @generated
		 */
		EClass GET_ROW_HEADER = eINSTANCE.getGetRowHeader();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.GetItemCellImpl <em>Get Item Cell</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.GetItemCellImpl
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getGetItemCell()
		 * @generated
		 */
		EClass GET_ITEM_CELL = eINSTANCE.getGetItemCell();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_ITEM_CELL__COLUMN = eINSTANCE.getGetItemCell_Column();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.GetEmptyAreaImpl <em>Get Empty Area</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.GetEmptyAreaImpl
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getGetEmptyArea()
		 * @generated
		 */
		EClass GET_EMPTY_AREA = eINSTANCE.getGetEmptyArea();

		/**
		 * The meta object literal for the '<em><b>Top</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_EMPTY_AREA__TOP = eINSTANCE.getGetEmptyArea_Top();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_EMPTY_AREA__LEFT = eINSTANCE.getGetEmptyArea_Left();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_EMPTY_AREA__COLUMN = eINSTANCE.getGetEmptyArea_Column();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.SelectGridRangeImpl <em>Select Grid Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.SelectGridRangeImpl
		 * @see org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaPackageImpl#getSelectGridRange()
		 * @generated
		 */
		EClass SELECT_GRID_RANGE = eINSTANCE.getSelectGridRange();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_GRID_RANGE__CONTROL = eINSTANCE.getSelectGridRange_Control();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_GRID_RANGE__FROM = eINSTANCE.getSelectGridRange_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_GRID_RANGE__TO = eINSTANCE.getSelectGridRange_To();

	}

} //NebulaPackage
