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
package org.eclipse.rcptt.verifications.tree.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.verifications.tree.CaptureTreeVerificationData;
import org.eclipse.rcptt.verifications.tree.Cell;
import org.eclipse.rcptt.verifications.tree.CollapseType;
import org.eclipse.rcptt.verifications.tree.Column;
import org.eclipse.rcptt.verifications.tree.CommonTreeVerificationData;
import org.eclipse.rcptt.verifications.tree.ItemData;
import org.eclipse.rcptt.verifications.tree.Row;
import org.eclipse.rcptt.verifications.tree.Tree;
import org.eclipse.rcptt.verifications.tree.TreeFactory;
import org.eclipse.rcptt.verifications.tree.TreePackage;
import org.eclipse.rcptt.verifications.tree.TreeVerification;
import org.eclipse.rcptt.verifications.tree.VerifyStyleType;
import org.eclipse.rcptt.verifications.tree.VerifyTreeData;
import org.eclipse.rcptt.tesla.core.ui.UiPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class TreePackageImpl extends EPackageImpl implements TreePackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass treeVerificationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass treeEClass = null;
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass columnEClass = null;
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rowEClass = null;
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cellEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imagesMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itemDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commonTreeVerificationDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass captureTreeVerificationDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass verifyTreeDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum verifyStyleTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TreePackageImpl() {
		super(eNS_URI, TreeFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link TreePackage#eINSTANCE} when that
	 * field is accessed. Clients should not invoke it directly. Instead, they
	 * should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TreePackage init() {
		if (isInited) return (TreePackage)EPackage.Registry.INSTANCE.getEPackage(TreePackage.eNS_URI);

		// Obtain or create and register package
		TreePackageImpl theTreePackage = (TreePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TreePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TreePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ScenarioPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTreePackage.createPackageContents();

		// Initialize created meta-data
		theTreePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTreePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TreePackage.eNS_URI, theTreePackage);
		return theTreePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTreeVerification() {
		return treeVerificationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTree() {
		return treeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTree_Columns() {
		return (EReference)treeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTree_Style() {
		return (EAttribute)treeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTree_Rows() {
		return (EReference)treeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTree_Enabled() {
		return (EAttribute)treeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTree_HeaderVisible() {
		return (EAttribute)treeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTree_LinesVisible() {
		return (EAttribute)treeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTree_SortColumnInd() {
		return (EAttribute)treeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTree_SortDirection() {
		return (EAttribute)treeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColumn() {
		return columnEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_Name() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_Width() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_Style() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColumn_Image() {
		return (EReference)columnEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColumn_Tooltip() {
		return (EAttribute)columnEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRow() {
		return rowEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRow_Values() {
		return (EReference)rowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRow_Children() {
		return (EReference)rowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRow_Checked() {
		return (EAttribute)rowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRow_Grayed() {
		return (EAttribute)rowEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRow_Data() {
		return (EReference)rowEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCell() {
		return cellEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCell_Style() {
		return (EReference)cellEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCell_Data() {
		return (EReference)cellEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImagesMap() {
		return imagesMapEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImagesMap_Key() {
		return (EAttribute)imagesMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImagesMap_Value() {
		return (EAttribute)imagesMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getItemData() {
		return itemDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getItemData_Text() {
		return (EAttribute)itemDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getItemData_Image() {
		return (EReference)itemDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getItemData_ForegroundColor() {
		return (EReference)itemDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getItemData_BackgroundColor() {
		return (EReference)itemDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommonTreeVerificationData() {
		return commonTreeVerificationDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommonTreeVerificationData_Tree() {
		return (EReference)commonTreeVerificationDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaptureTreeVerificationData() {
		return captureTreeVerificationDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCaptureTreeVerificationData_Images() {
		return (EReference)captureTreeVerificationDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVerifyTreeData() {
		return verifyTreeDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVerifyTreeData_AllowExtraColumns() {
		return (EAttribute)verifyTreeDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVerifyTreeData_AllowMissingColumns() {
		return (EAttribute)verifyTreeDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVerifyTreeData_VerifyStyle() {
		return (EAttribute)verifyTreeDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVerifyTreeData_VerifyIcons() {
		return (EAttribute)verifyTreeDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVerifyTreeData_AllowUncapturedChildren() {
		return (EAttribute)verifyTreeDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVerifyTreeData_EnableVerifyStyle() {
		return (EAttribute)verifyTreeDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVerifyTreeData_ExcludedColumns() {
		return (EAttribute)verifyTreeDataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVerifyStyleType() {
		return verifyStyleTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TreeFactory getTreeFactory() {
		return (TreeFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		treeVerificationEClass = createEClass(TREE_VERIFICATION);

		treeEClass = createEClass(TREE);
		createEReference(treeEClass, TREE__COLUMNS);
		createEAttribute(treeEClass, TREE__STYLE);
		createEReference(treeEClass, TREE__ROWS);
		createEAttribute(treeEClass, TREE__ENABLED);
		createEAttribute(treeEClass, TREE__HEADER_VISIBLE);
		createEAttribute(treeEClass, TREE__LINES_VISIBLE);
		createEAttribute(treeEClass, TREE__SORT_COLUMN_IND);
		createEAttribute(treeEClass, TREE__SORT_DIRECTION);

		columnEClass = createEClass(COLUMN);
		createEAttribute(columnEClass, COLUMN__NAME);
		createEAttribute(columnEClass, COLUMN__WIDTH);
		createEAttribute(columnEClass, COLUMN__STYLE);
		createEReference(columnEClass, COLUMN__IMAGE);
		createEAttribute(columnEClass, COLUMN__TOOLTIP);

		rowEClass = createEClass(ROW);
		createEReference(rowEClass, ROW__VALUES);
		createEReference(rowEClass, ROW__CHILDREN);
		createEAttribute(rowEClass, ROW__CHECKED);
		createEAttribute(rowEClass, ROW__GRAYED);
		createEReference(rowEClass, ROW__DATA);

		cellEClass = createEClass(CELL);
		createEReference(cellEClass, CELL__STYLE);
		createEReference(cellEClass, CELL__DATA);

		imagesMapEClass = createEClass(IMAGES_MAP);
		createEAttribute(imagesMapEClass, IMAGES_MAP__KEY);
		createEAttribute(imagesMapEClass, IMAGES_MAP__VALUE);

		itemDataEClass = createEClass(ITEM_DATA);
		createEAttribute(itemDataEClass, ITEM_DATA__TEXT);
		createEReference(itemDataEClass, ITEM_DATA__IMAGE);
		createEReference(itemDataEClass, ITEM_DATA__FOREGROUND_COLOR);
		createEReference(itemDataEClass, ITEM_DATA__BACKGROUND_COLOR);

		commonTreeVerificationDataEClass = createEClass(COMMON_TREE_VERIFICATION_DATA);
		createEReference(commonTreeVerificationDataEClass, COMMON_TREE_VERIFICATION_DATA__TREE);

		captureTreeVerificationDataEClass = createEClass(CAPTURE_TREE_VERIFICATION_DATA);
		createEReference(captureTreeVerificationDataEClass, CAPTURE_TREE_VERIFICATION_DATA__IMAGES);

		verifyTreeDataEClass = createEClass(VERIFY_TREE_DATA);
		createEAttribute(verifyTreeDataEClass, VERIFY_TREE_DATA__ALLOW_EXTRA_COLUMNS);
		createEAttribute(verifyTreeDataEClass, VERIFY_TREE_DATA__ALLOW_MISSING_COLUMNS);
		createEAttribute(verifyTreeDataEClass, VERIFY_TREE_DATA__VERIFY_STYLE);
		createEAttribute(verifyTreeDataEClass, VERIFY_TREE_DATA__VERIFY_ICONS);
		createEAttribute(verifyTreeDataEClass, VERIFY_TREE_DATA__ALLOW_UNCAPTURED_CHILDREN);
		createEAttribute(verifyTreeDataEClass, VERIFY_TREE_DATA__ENABLE_VERIFY_STYLE);
		createEAttribute(verifyTreeDataEClass, VERIFY_TREE_DATA__EXCLUDED_COLUMNS);

		// Create enums
		verifyStyleTypeEEnum = createEEnum(VERIFY_STYLE_TYPE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
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
		UiPackage theUiPackage = (UiPackage)EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);
		ScenarioPackage theScenarioPackage = (ScenarioPackage)EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		treeVerificationEClass.getESuperTypes().add(this.getCaptureTreeVerificationData());
		treeVerificationEClass.getESuperTypes().add(this.getVerifyTreeData());
		commonTreeVerificationDataEClass.getESuperTypes().add(theScenarioPackage.getWidgetVerification());
		captureTreeVerificationDataEClass.getESuperTypes().add(this.getCommonTreeVerificationData());
		verifyTreeDataEClass.getESuperTypes().add(this.getCommonTreeVerificationData());

		// Initialize classes and features; add operations and parameters
		initEClass(treeVerificationEClass, TreeVerification.class, "TreeVerification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(treeEClass, Tree.class, "Tree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTree_Columns(), this.getColumn(), null, "columns", null, 0, -1, Tree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTree_Style(), ecorePackage.getEInt(), "style", null, 1, 1, Tree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTree_Rows(), this.getRow(), null, "rows", null, 0, -1, Tree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTree_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 1, 1, Tree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTree_HeaderVisible(), ecorePackage.getEBoolean(), "headerVisible", null, 1, 1, Tree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTree_LinesVisible(), ecorePackage.getEBoolean(), "linesVisible", null, 1, 1, Tree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTree_SortColumnInd(), ecorePackage.getEInt(), "sortColumnInd", null, 0, 1, Tree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTree_SortDirection(), ecorePackage.getEInt(), "sortDirection", null, 0, 1, Tree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(columnEClass, Column.class, "Column", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColumn_Name(), ecorePackage.getEString(), "name", null, 1, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColumn_Width(), ecorePackage.getEInt(), "width", null, 1, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColumn_Style(), ecorePackage.getEInt(), "style", null, 1, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getColumn_Image(), theUiPackage.getImage(), null, "image", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColumn_Tooltip(), ecorePackage.getEString(), "tooltip", null, 0, 1, Column.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rowEClass, Row.class, "Row", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRow_Values(), this.getCell(), null, "values", null, 0, -1, Row.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRow_Children(), this.getRow(), null, "children", null, 0, -1, Row.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRow_Checked(), ecorePackage.getEBoolean(), "checked", null, 1, 1, Row.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRow_Grayed(), ecorePackage.getEBoolean(), "grayed", null, 1, 1, Row.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRow_Data(), this.getItemData(), null, "data", null, 0, 1, Row.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cellEClass, Cell.class, "Cell", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCell_Style(), theUiPackage.getStyleRangeEntry(), null, "style", null, 0, -1, Cell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCell_Data(), this.getItemData(), null, "data", null, 0, 1, Cell.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imagesMapEClass, Map.Entry.class, "ImagesMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImagesMap_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImagesMap_Value(), ecorePackage.getEByteArray(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(itemDataEClass, ItemData.class, "ItemData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getItemData_Text(), ecorePackage.getEString(), "text", null, 0, 1, ItemData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getItemData_Image(), theUiPackage.getImage(), null, "image", null, 0, 1, ItemData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getItemData_ForegroundColor(), theUiPackage.getColor(), null, "foregroundColor", null, 0, 1, ItemData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getItemData_BackgroundColor(), theUiPackage.getColor(), null, "backgroundColor", null, 0, 1, ItemData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commonTreeVerificationDataEClass, CommonTreeVerificationData.class, "CommonTreeVerificationData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommonTreeVerificationData_Tree(), this.getTree(), null, "tree", null, 1, 1, CommonTreeVerificationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(captureTreeVerificationDataEClass, CaptureTreeVerificationData.class, "CaptureTreeVerificationData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCaptureTreeVerificationData_Images(), this.getImagesMap(), null, "images", null, 0, -1, CaptureTreeVerificationData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(verifyTreeDataEClass, VerifyTreeData.class, "VerifyTreeData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVerifyTreeData_AllowExtraColumns(), ecorePackage.getEBoolean(), "allowExtraColumns", null, 1, 1, VerifyTreeData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVerifyTreeData_AllowMissingColumns(), ecorePackage.getEBoolean(), "allowMissingColumns", null, 0, 1, VerifyTreeData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVerifyTreeData_VerifyStyle(), this.getVerifyStyleType(), "verifyStyle", null, 0, 1, VerifyTreeData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVerifyTreeData_VerifyIcons(), ecorePackage.getEBoolean(), "verifyIcons", "true", 1, 1, VerifyTreeData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVerifyTreeData_AllowUncapturedChildren(), ecorePackage.getEBoolean(), "allowUncapturedChildren", "true", 0, 1, VerifyTreeData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVerifyTreeData_EnableVerifyStyle(), ecorePackage.getEBoolean(), "enableVerifyStyle", "true", 0, 1, VerifyTreeData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVerifyTreeData_ExcludedColumns(), ecorePackage.getEInt(), "excludedColumns", null, 0, -1, VerifyTreeData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(verifyStyleTypeEEnum, VerifyStyleType.class, "VerifyStyleType");
		addEEnumLiteral(verifyStyleTypeEEnum, VerifyStyleType.ALL);
		addEEnumLiteral(verifyStyleTypeEEnum, VerifyStyleType.IGNORE_STYLES);
		addEEnumLiteral(verifyStyleTypeEEnum, VerifyStyleType.IGNORE_STYLED_TEXT);

		// Create resource
		createResource(eNS_URI);
	}

} // TreePackageImpl
