/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.protocol.nebula.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;

import org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx;
import org.eclipse.rcptt.tesla.protocol.nebula.NebulaFactory;
import org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage;
import org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionEx;
import org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange;

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
	private EClass setSelectionExEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setSelectionRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiSelectionItemExEClass = null;

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
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage#eNS_URI
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
		ProtocolPackage.eINSTANCE.eClass();

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
	public EClass getSetSelectionEx() {
		return setSelectionExEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetSelectionRange() {
		return setSelectionRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetSelectionRange_ToPath() {
		return (EAttribute)setSelectionRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetSelectionRange_From() {
		return (EReference)setSelectionRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetSelectionRange_To() {
		return (EReference)setSelectionRangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiSelectionItemEx() {
		return multiSelectionItemExEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiSelectionItemEx_CellColumn() {
		return (EAttribute)multiSelectionItemExEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiSelectionItemEx_RowHeader() {
		return (EAttribute)multiSelectionItemExEClass.getEStructuralFeatures().get(1);
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
		setSelectionExEClass = createEClass(SET_SELECTION_EX);

		setSelectionRangeEClass = createEClass(SET_SELECTION_RANGE);
		createEAttribute(setSelectionRangeEClass, SET_SELECTION_RANGE__TO_PATH);
		createEReference(setSelectionRangeEClass, SET_SELECTION_RANGE__FROM);
		createEReference(setSelectionRangeEClass, SET_SELECTION_RANGE__TO);

		multiSelectionItemExEClass = createEClass(MULTI_SELECTION_ITEM_EX);
		createEAttribute(multiSelectionItemExEClass, MULTI_SELECTION_ITEM_EX__CELL_COLUMN);
		createEAttribute(multiSelectionItemExEClass, MULTI_SELECTION_ITEM_EX__ROW_HEADER);
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
		ProtocolPackage theProtocolPackage = (ProtocolPackage)EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		setSelectionExEClass.getESuperTypes().add(theProtocolPackage.getSetSelection());
		setSelectionRangeEClass.getESuperTypes().add(theProtocolPackage.getSetSelection());
		multiSelectionItemExEClass.getESuperTypes().add(theProtocolPackage.getMultiSelectionItem());

		// Initialize classes and features; add operations and parameters
		initEClass(setSelectionExEClass, SetSelectionEx.class, "SetSelectionEx", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setSelectionRangeEClass, SetSelectionRange.class, "SetSelectionRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetSelectionRange_ToPath(), theEcorePackage.getEString(), "toPath", null, 0, -1, SetSelectionRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetSelectionRange_From(), this.getMultiSelectionItemEx(), null, "from", null, 0, 1, SetSelectionRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetSelectionRange_To(), this.getMultiSelectionItemEx(), null, "to", null, 0, 1, SetSelectionRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiSelectionItemExEClass, MultiSelectionItemEx.class, "MultiSelectionItemEx", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiSelectionItemEx_CellColumn(), theEcorePackage.getEString(), "cellColumn", null, 0, 1, MultiSelectionItemEx.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiSelectionItemEx_RowHeader(), theEcorePackage.getEBoolean(), "rowHeader", null, 0, 1, MultiSelectionItemEx.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //NebulaPackageImpl
