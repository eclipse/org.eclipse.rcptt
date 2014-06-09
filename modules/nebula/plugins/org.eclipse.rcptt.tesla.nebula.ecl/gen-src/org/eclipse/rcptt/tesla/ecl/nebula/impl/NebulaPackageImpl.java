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
package org.eclipse.rcptt.tesla.ecl.nebula.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.rcptt.ecl.core.CorePackage;

import org.eclipse.rcptt.tesla.core.ui.UiPackage;

import org.eclipse.rcptt.tesla.ecl.model.TeslaPackage;

import org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea;
import org.eclipse.rcptt.tesla.ecl.nebula.GetItemCell;
import org.eclipse.rcptt.tesla.ecl.nebula.GetNebulaGrid;
import org.eclipse.rcptt.tesla.ecl.nebula.GetRowHeader;
import org.eclipse.rcptt.tesla.ecl.nebula.NebulaFactory;
import org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid;
import org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridColumn;
import org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem;
import org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage;
import org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NebulaPackageImpl extends EPackageImpl implements NebulaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getNebulaGridEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nebulaGridEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nebulaGridItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nebulaGridColumnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getRowHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getItemCellEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getEmptyAreaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectGridRangeEClass = null;

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
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NebulaPackageImpl() {
		super(eNS_URI, NebulaFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NebulaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NebulaPackage init() {
		if (isInited) return (NebulaPackage)EPackage.Registry.INSTANCE.getEPackage(NebulaPackage.eNS_URI);

		// Obtain or create and register package
		NebulaPackageImpl theNebulaPackage = (NebulaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NebulaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NebulaPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TeslaPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theNebulaPackage.createPackageContents();

		// Initialize created meta-data
		theNebulaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNebulaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NebulaPackage.eNS_URI, theNebulaPackage);
		return theNebulaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetNebulaGrid() {
		return getNebulaGridEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNebulaGrid() {
		return nebulaGridEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNebulaGrid_LinesVisible() {
		return (EAttribute)nebulaGridEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNebulaGrid_MultiSelection() {
		return (EAttribute)nebulaGridEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNebulaGrid_HeaderVisible() {
		return (EAttribute)nebulaGridEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNebulaGrid_ItemCount() {
		return (EAttribute)nebulaGridEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNebulaGrid_Selection() {
		return (EReference)nebulaGridEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNebulaGrid_Columns() {
		return (EReference)nebulaGridEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNebulaGridItem() {
		return nebulaGridItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNebulaGridItem_Checked() {
		return (EAttribute)nebulaGridItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNebulaGridItem_BackgroundColor() {
		return (EReference)nebulaGridItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNebulaGridItem_ForegroundColor() {
		return (EReference)nebulaGridItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNebulaGridItem_Bounds() {
		return (EReference)nebulaGridItemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNebulaGridItem_ChildCount() {
		return (EAttribute)nebulaGridItemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNebulaGridItem_Columns() {
		return (EAttribute)nebulaGridItemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNebulaGridItem_ColumnsBackgroundColor() {
		return (EReference)nebulaGridItemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNebulaGridItem_ColumnsForegroundColor() {
		return (EReference)nebulaGridItemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNebulaGridColumn() {
		return nebulaGridColumnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNebulaGridColumn_Resizable() {
		return (EAttribute)nebulaGridColumnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNebulaGridColumn_Movable() {
		return (EAttribute)nebulaGridColumnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNebulaGridColumn_Width() {
		return (EAttribute)nebulaGridColumnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNebulaGridColumn_Tooltip() {
		return (EAttribute)nebulaGridColumnEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetRowHeader() {
		return getRowHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetItemCell() {
		return getItemCellEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetItemCell_Column() {
		return (EAttribute)getItemCellEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetEmptyArea() {
		return getEmptyAreaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetEmptyArea_Top() {
		return (EAttribute)getEmptyAreaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetEmptyArea_Left() {
		return (EAttribute)getEmptyAreaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetEmptyArea_Column() {
		return (EAttribute)getEmptyAreaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectGridRange() {
		return selectGridRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectGridRange_Control() {
		return (EReference)selectGridRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectGridRange_From() {
		return (EAttribute)selectGridRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectGridRange_To() {
		return (EAttribute)selectGridRangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NebulaFactory getNebulaFactory() {
		return (NebulaFactory)getEFactoryInstance();
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
		getNebulaGridEClass = createEClass(GET_NEBULA_GRID);

		nebulaGridEClass = createEClass(NEBULA_GRID);
		createEAttribute(nebulaGridEClass, NEBULA_GRID__LINES_VISIBLE);
		createEAttribute(nebulaGridEClass, NEBULA_GRID__MULTI_SELECTION);
		createEAttribute(nebulaGridEClass, NEBULA_GRID__HEADER_VISIBLE);
		createEAttribute(nebulaGridEClass, NEBULA_GRID__ITEM_COUNT);
		createEReference(nebulaGridEClass, NEBULA_GRID__SELECTION);
		createEReference(nebulaGridEClass, NEBULA_GRID__COLUMNS);

		nebulaGridItemEClass = createEClass(NEBULA_GRID_ITEM);
		createEAttribute(nebulaGridItemEClass, NEBULA_GRID_ITEM__CHECKED);
		createEReference(nebulaGridItemEClass, NEBULA_GRID_ITEM__BACKGROUND_COLOR);
		createEReference(nebulaGridItemEClass, NEBULA_GRID_ITEM__FOREGROUND_COLOR);
		createEReference(nebulaGridItemEClass, NEBULA_GRID_ITEM__BOUNDS);
		createEAttribute(nebulaGridItemEClass, NEBULA_GRID_ITEM__CHILD_COUNT);
		createEAttribute(nebulaGridItemEClass, NEBULA_GRID_ITEM__COLUMNS);
		createEReference(nebulaGridItemEClass, NEBULA_GRID_ITEM__COLUMNS_BACKGROUND_COLOR);
		createEReference(nebulaGridItemEClass, NEBULA_GRID_ITEM__COLUMNS_FOREGROUND_COLOR);

		nebulaGridColumnEClass = createEClass(NEBULA_GRID_COLUMN);
		createEAttribute(nebulaGridColumnEClass, NEBULA_GRID_COLUMN__RESIZABLE);
		createEAttribute(nebulaGridColumnEClass, NEBULA_GRID_COLUMN__MOVABLE);
		createEAttribute(nebulaGridColumnEClass, NEBULA_GRID_COLUMN__WIDTH);
		createEAttribute(nebulaGridColumnEClass, NEBULA_GRID_COLUMN__TOOLTIP);

		getRowHeaderEClass = createEClass(GET_ROW_HEADER);

		getItemCellEClass = createEClass(GET_ITEM_CELL);
		createEAttribute(getItemCellEClass, GET_ITEM_CELL__COLUMN);

		getEmptyAreaEClass = createEClass(GET_EMPTY_AREA);
		createEAttribute(getEmptyAreaEClass, GET_EMPTY_AREA__TOP);
		createEAttribute(getEmptyAreaEClass, GET_EMPTY_AREA__LEFT);
		createEAttribute(getEmptyAreaEClass, GET_EMPTY_AREA__COLUMN);

		selectGridRangeEClass = createEClass(SELECT_GRID_RANGE);
		createEReference(selectGridRangeEClass, SELECT_GRID_RANGE__CONTROL);
		createEAttribute(selectGridRangeEClass, SELECT_GRID_RANGE__FROM);
		createEAttribute(selectGridRangeEClass, SELECT_GRID_RANGE__TO);
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
		TeslaPackage theTeslaPackage = (TeslaPackage)EPackage.Registry.INSTANCE.getEPackage(TeslaPackage.eNS_URI);
		UiPackage theUiPackage = (UiPackage)EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		getNebulaGridEClass.getESuperTypes().add(theTeslaPackage.getSelector());
		nebulaGridEClass.getESuperTypes().add(theUiPackage.getControl());
		nebulaGridItemEClass.getESuperTypes().add(theUiPackage.getItem());
		nebulaGridColumnEClass.getESuperTypes().add(theUiPackage.getItem());
		getRowHeaderEClass.getESuperTypes().add(theTeslaPackage.getSelector());
		getItemCellEClass.getESuperTypes().add(theTeslaPackage.getSelector());
		getEmptyAreaEClass.getESuperTypes().add(theTeslaPackage.getSelector());
		selectGridRangeEClass.getESuperTypes().add(theCorePackage.getCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(getNebulaGridEClass, GetNebulaGrid.class, "GetNebulaGrid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nebulaGridEClass, NebulaGrid.class, "NebulaGrid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNebulaGrid_LinesVisible(), ecorePackage.getEBoolean(), "linesVisible", null, 0, 1, NebulaGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNebulaGrid_MultiSelection(), ecorePackage.getEBoolean(), "multiSelection", null, 0, 1, NebulaGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNebulaGrid_HeaderVisible(), ecorePackage.getEBoolean(), "headerVisible", null, 0, 1, NebulaGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNebulaGrid_ItemCount(), ecorePackage.getEInt(), "itemCount", null, 0, 1, NebulaGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNebulaGrid_Selection(), theUiPackage.getSelection(), null, "selection", null, 0, -1, NebulaGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNebulaGrid_Columns(), this.getNebulaGridColumn(), null, "columns", null, 0, -1, NebulaGrid.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nebulaGridItemEClass, NebulaGridItem.class, "NebulaGridItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNebulaGridItem_Checked(), ecorePackage.getEBoolean(), "checked", null, 0, 1, NebulaGridItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNebulaGridItem_BackgroundColor(), theUiPackage.getColor(), null, "backgroundColor", null, 0, 1, NebulaGridItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNebulaGridItem_ForegroundColor(), theUiPackage.getColor(), null, "foregroundColor", null, 0, 1, NebulaGridItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNebulaGridItem_Bounds(), theUiPackage.getRectangle(), null, "bounds", null, 0, 1, NebulaGridItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNebulaGridItem_ChildCount(), theEcorePackage.getEIntegerObject(), "childCount", null, 0, 1, NebulaGridItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNebulaGridItem_Columns(), ecorePackage.getEString(), "columns", null, 0, -1, NebulaGridItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNebulaGridItem_ColumnsBackgroundColor(), theUiPackage.getColor(), null, "columnsBackgroundColor", null, 0, -1, NebulaGridItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNebulaGridItem_ColumnsForegroundColor(), theUiPackage.getColor(), null, "columnsForegroundColor", null, 0, -1, NebulaGridItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nebulaGridColumnEClass, NebulaGridColumn.class, "NebulaGridColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNebulaGridColumn_Resizable(), ecorePackage.getEBoolean(), "resizable", null, 0, 1, NebulaGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNebulaGridColumn_Movable(), ecorePackage.getEBoolean(), "movable", null, 0, 1, NebulaGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNebulaGridColumn_Width(), ecorePackage.getEInt(), "width", null, 0, 1, NebulaGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNebulaGridColumn_Tooltip(), ecorePackage.getEString(), "tooltip", null, 0, 1, NebulaGridColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getRowHeaderEClass, GetRowHeader.class, "GetRowHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getItemCellEClass, GetItemCell.class, "GetItemCell", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetItemCell_Column(), theEcorePackage.getEString(), "column", null, 1, 1, GetItemCell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getEmptyAreaEClass, GetEmptyArea.class, "GetEmptyArea", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetEmptyArea_Top(), theEcorePackage.getEBoolean(), "top", null, 0, 1, GetEmptyArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetEmptyArea_Left(), theEcorePackage.getEBoolean(), "left", null, 0, 1, GetEmptyArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetEmptyArea_Column(), theEcorePackage.getEString(), "column", null, 0, 1, GetEmptyArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectGridRangeEClass, SelectGridRange.class, "SelectGridRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectGridRange_Control(), theTeslaPackage.getControlHandler(), null, "control", null, 1, 1, SelectGridRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectGridRange_From(), theEcorePackage.getEJavaObject(), "from", null, 1, 1, SelectGridRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectGridRange_To(), theEcorePackage.getEJavaObject(), "to", null, 1, 1, SelectGridRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/ecl/docs
		createDocsAnnotations();
		// http://www.eclipse.org/ecl/input
		createInputAnnotations();
		// http://www.eclipse.org/ecl/meta
		createMetaAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/docs</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDocsAnnotations() {
		String source = "http://www.eclipse.org/ecl/docs";		
		addAnnotation
		  (getRowHeaderEClass, 
		   source, 
		   new String[] {
			 "description", "Gets the Nebula Grid item row header (on the left of the item).",
			 "returns", "item row header",
			 "recorded", "true",
			 "example", "get-nebula-grid | get-item \"Item Label\" | get-row-header"
		   });		
		addAnnotation
		  (getItemCellEClass, 
		   source, 
		   new String[] {
			 "description", "Gets the Nebula Grid item cell by its column name.",
			 "returns", "item cell",
			 "recorded", "true",
			 "example", "get-nebula-grid | get-item \"Item Label\" | get-item-cell -column \"Column Title\""
		   });		
		addAnnotation
		  (getEmptyAreaEClass, 
		   source, 
		   new String[] {
			 "description", "Gets the Nebula Grid empty area specified by its place.\n",
			 "returns", "grid empty area",
			 "recorded", "true",
			 "example", "get-nebula-grid | get-empty-area -top -left\nget-nebula-grid | get-empty-area -column \"Column Title\"\nget-nebula-grid | get-item \"Item Label\" | get-empty-area"
		   });		
		addAnnotation
		  (getGetEmptyArea_Top(), 
		   source, 
		   new String[] {
			 "description", "Area is located on the top header line. Can be combined with <code>-left</code> parameter to get the intersection corner."
		   });		
		addAnnotation
		  (getGetEmptyArea_Left(), 
		   source, 
		   new String[] {
			 "description", "Area is located on the left header column. Can be combined with <code>-top</code> parameter to get the intersection corner."
		   });		
		addAnnotation
		  (getGetEmptyArea_Column(), 
		   source, 
		   new String[] {
			 "description", "Area is located at the bottom of specified column. Must not be combined with <code>-top</code> or <code>-left</code> parameters."
		   });		
		addAnnotation
		  (selectGridRangeEClass, 
		   source, 
		   new String[] {
			 "description", "Selects item or cell range.",
			 "returns", "value of <code>control</code> parameter",
			 "example", "get-nebula-grid | select \"From Item\" \"To Item\"\nget-nebula-grid | select [get-item \"From Item\" | get-item-cell -column \"Col1\"] [get-item \"To Item\" | get-item-cell -column \"Col2\"]"
		   });			
		addAnnotation
		  (getSelectGridRange_Control(), 
		   source, 
		   new String[] {
			 "description", "Nebula Grid."
		   });		
		addAnnotation
		  (getSelectGridRange_From(), 
		   source, 
		   new String[] {
			 "description", "Path of item of item cell from where the selection begins."
		   });			
		addAnnotation
		  (getSelectGridRange_To(), 
		   source, 
		   new String[] {
			 "description", "Path of item or item cell where the selection ends."
		   });	
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/input</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createInputAnnotations() {
		String source = "http://www.eclipse.org/ecl/input";									
		addAnnotation
		  (getSelectGridRange_Control(), 
		   source, 
		   new String[] {
		   });					
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/meta</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMetaAnnotations() {
		String source = "http://www.eclipse.org/ecl/meta";												
		addAnnotation
		  (getSelectGridRange_From(), 
		   source, 
		   new String[] {
			 "type", "string | org.eclipse.rcptt.tesla.ecl.model.ControlHandler"
		   });			
		addAnnotation
		  (getSelectGridRange_To(), 
		   source, 
		   new String[] {
			 "type", "string | org.eclipse.rcptt.tesla.ecl.model.ControlHandler"
		   });
	}

} //NebulaPackageImpl
