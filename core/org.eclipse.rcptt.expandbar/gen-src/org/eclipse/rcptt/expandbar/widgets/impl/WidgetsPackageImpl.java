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
package org.eclipse.rcptt.expandbar.widgets.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.rcptt.expandbar.widgets.ExpandBar;
import org.eclipse.rcptt.expandbar.widgets.ExpandItem;
import org.eclipse.rcptt.expandbar.widgets.WidgetsFactory;
import org.eclipse.rcptt.expandbar.widgets.WidgetsPackage;

import org.eclipse.rcptt.tesla.core.ui.UiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WidgetsPackageImpl extends EPackageImpl implements WidgetsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expandBarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expandItemEClass = null;

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
	 * @see org.eclipse.rcptt.expandbar.widgets.WidgetsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WidgetsPackageImpl() {
		super(eNS_URI, WidgetsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link WidgetsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WidgetsPackage init() {
		if (isInited) return (WidgetsPackage)EPackage.Registry.INSTANCE.getEPackage(WidgetsPackage.eNS_URI);

		// Obtain or create and register package
		WidgetsPackageImpl theWidgetsPackage = (WidgetsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WidgetsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new WidgetsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UiPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theWidgetsPackage.createPackageContents();

		// Initialize created meta-data
		theWidgetsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWidgetsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WidgetsPackage.eNS_URI, theWidgetsPackage);
		return theWidgetsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpandBar() {
		return expandBarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpandBar_Items() {
		return (EReference)expandBarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpandItem() {
		return expandItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpandItem_Caption() {
		return (EAttribute)expandItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpandItem_Expanded() {
		return (EAttribute)expandItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpandItem_Index() {
		return (EAttribute)expandItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WidgetsFactory getWidgetsFactory() {
		return (WidgetsFactory)getEFactoryInstance();
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
		expandBarEClass = createEClass(EXPAND_BAR);
		createEReference(expandBarEClass, EXPAND_BAR__ITEMS);

		expandItemEClass = createEClass(EXPAND_ITEM);
		createEAttribute(expandItemEClass, EXPAND_ITEM__CAPTION);
		createEAttribute(expandItemEClass, EXPAND_ITEM__EXPANDED);
		createEAttribute(expandItemEClass, EXPAND_ITEM__INDEX);
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
		UiPackage theUiPackage = (UiPackage)EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		expandBarEClass.getESuperTypes().add(theUiPackage.getControl());
		expandItemEClass.getESuperTypes().add(theUiPackage.getWidget());
		expandItemEClass.getESuperTypes().add(theUiPackage.getWithImage());

		// Initialize classes and features; add operations and parameters
		initEClass(expandBarEClass, ExpandBar.class, "ExpandBar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpandBar_Items(), this.getExpandItem(), null, "items", null, 0, -1, ExpandBar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expandItemEClass, ExpandItem.class, "ExpandItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpandItem_Caption(), ecorePackage.getEString(), "caption", null, 0, 1, ExpandItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpandItem_Expanded(), ecorePackage.getEBoolean(), "expanded", null, 0, 1, ExpandItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpandItem_Index(), ecorePackage.getEInt(), "index", null, 0, 1, ExpandItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //WidgetsPackageImpl
