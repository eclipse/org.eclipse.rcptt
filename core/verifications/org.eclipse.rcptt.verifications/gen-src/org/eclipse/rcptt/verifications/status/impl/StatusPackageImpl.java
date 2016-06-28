/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.verifications.status.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.verifications.status.EVerificationStatus;
import org.eclipse.rcptt.verifications.status.StatusFactory;
import org.eclipse.rcptt.verifications.status.StatusPackage;
import org.eclipse.rcptt.verifications.status.TreeItemStyleVerificationError;
import org.eclipse.rcptt.verifications.status.TreeItemVerificationError;
import org.eclipse.rcptt.verifications.status.VerificationStatusData;
import org.eclipse.rcptt.tesla.core.ui.UiPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class StatusPackageImpl extends EPackageImpl implements StatusPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eVerificationStatusEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass verificationStatusDataEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass treeItemVerificationErrorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass treeItemStyleVerificationErrorEClass = null;

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
	 * @see org.eclipse.rcptt.verifications.status.StatusPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StatusPackageImpl() {
		super(eNS_URI, StatusFactory.eINSTANCE);
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
	 * This method is used to initialize {@link StatusPackage#eINSTANCE} when
	 * that field is accessed. Clients should not invoke it directly. Instead,
	 * they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StatusPackage init() {
		if (isInited) return (StatusPackage)EPackage.Registry.INSTANCE.getEPackage(StatusPackage.eNS_URI);

		// Obtain or create and register package
		StatusPackageImpl theStatusPackage = (StatusPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StatusPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StatusPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UiPackage.eINSTANCE.eClass();
		CorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theStatusPackage.createPackageContents();

		// Initialize created meta-data
		theStatusPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStatusPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StatusPackage.eNS_URI, theStatusPackage);
		return theStatusPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEVerificationStatus() {
		return eVerificationStatusEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEVerificationStatus_Resource() {
		return (EAttribute)eVerificationStatusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEVerificationStatus_Data() {
		return (EReference)eVerificationStatusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVerificationStatusData() {
		return verificationStatusDataEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVerificationStatusData_Message() {
		return (EAttribute)verificationStatusDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVerificationStatusData_ResourceId() {
		return (EAttribute)verificationStatusDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTreeItemVerificationError() {
		return treeItemVerificationErrorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeItemVerificationError_ItemIndexPath() {
		return (EAttribute)treeItemVerificationErrorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeItemVerificationError_ItemPath() {
		return (EAttribute)treeItemVerificationErrorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeItemVerificationError_Column() {
		return (EAttribute)treeItemVerificationErrorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTreeItemStyleVerificationError() {
		return treeItemStyleVerificationErrorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeItemStyleVerificationError_ExpectedStyle() {
		return (EReference)treeItemStyleVerificationErrorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeItemStyleVerificationError_ActualStyle() {
		return (EReference)treeItemStyleVerificationErrorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public StatusFactory getStatusFactory() {
		return (StatusFactory)getEFactoryInstance();
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
		eVerificationStatusEClass = createEClass(EVERIFICATION_STATUS);
		createEAttribute(eVerificationStatusEClass, EVERIFICATION_STATUS__RESOURCE);
		createEReference(eVerificationStatusEClass, EVERIFICATION_STATUS__DATA);

		verificationStatusDataEClass = createEClass(VERIFICATION_STATUS_DATA);
		createEAttribute(verificationStatusDataEClass, VERIFICATION_STATUS_DATA__MESSAGE);
		createEAttribute(verificationStatusDataEClass, VERIFICATION_STATUS_DATA__RESOURCE_ID);

		treeItemVerificationErrorEClass = createEClass(TREE_ITEM_VERIFICATION_ERROR);
		createEAttribute(treeItemVerificationErrorEClass, TREE_ITEM_VERIFICATION_ERROR__ITEM_INDEX_PATH);
		createEAttribute(treeItemVerificationErrorEClass, TREE_ITEM_VERIFICATION_ERROR__ITEM_PATH);
		createEAttribute(treeItemVerificationErrorEClass, TREE_ITEM_VERIFICATION_ERROR__COLUMN);

		treeItemStyleVerificationErrorEClass = createEClass(TREE_ITEM_STYLE_VERIFICATION_ERROR);
		createEReference(treeItemStyleVerificationErrorEClass, TREE_ITEM_STYLE_VERIFICATION_ERROR__EXPECTED_STYLE);
		createEReference(treeItemStyleVerificationErrorEClass, TREE_ITEM_STYLE_VERIFICATION_ERROR__ACTUAL_STYLE);
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
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		UiPackage theUiPackage = (UiPackage)EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		eVerificationStatusEClass.getESuperTypes().add(theCorePackage.getProcessStatus());
		treeItemVerificationErrorEClass.getESuperTypes().add(this.getVerificationStatusData());
		treeItemStyleVerificationErrorEClass.getESuperTypes().add(this.getTreeItemVerificationError());

		// Initialize classes and features; add operations and parameters
		initEClass(eVerificationStatusEClass, EVerificationStatus.class, "EVerificationStatus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEVerificationStatus_Resource(), ecorePackage.getEString(), "resource", null, 0, 1, EVerificationStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEVerificationStatus_Data(), this.getVerificationStatusData(), null, "data", null, 0, -1, EVerificationStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(verificationStatusDataEClass, VerificationStatusData.class, "VerificationStatusData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVerificationStatusData_Message(), ecorePackage.getEString(), "message", null, 0, 1, VerificationStatusData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVerificationStatusData_ResourceId(), ecorePackage.getEString(), "resourceId", null, 0, 1, VerificationStatusData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(treeItemVerificationErrorEClass, TreeItemVerificationError.class, "TreeItemVerificationError", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTreeItemVerificationError_ItemIndexPath(), ecorePackage.getEInt(), "itemIndexPath", null, 0, -1, TreeItemVerificationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTreeItemVerificationError_ItemPath(), ecorePackage.getEString(), "itemPath", null, 1, 1, TreeItemVerificationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTreeItemVerificationError_Column(), ecorePackage.getEString(), "column", null, 0, 1, TreeItemVerificationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(treeItemStyleVerificationErrorEClass, TreeItemStyleVerificationError.class, "TreeItemStyleVerificationError", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTreeItemStyleVerificationError_ExpectedStyle(), theUiPackage.getStyleRangeEntry(), null, "expectedStyle", null, 0, 1, TreeItemStyleVerificationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTreeItemStyleVerificationError_ActualStyle(), theUiPackage.getStyleRangeEntry(), null, "actualStyle", null, 0, 1, TreeItemStyleVerificationError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // StatusPackageImpl
