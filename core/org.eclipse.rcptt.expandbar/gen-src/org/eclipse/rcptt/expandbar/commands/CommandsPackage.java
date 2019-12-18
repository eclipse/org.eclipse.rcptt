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
package org.eclipse.rcptt.expandbar.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.eclipse.rcptt.expandbar.commands.CommandsFactory
 * @model kind="package"
 * @generated
 */
public interface CommandsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "commands";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/widgets/expandbar/ecl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.widgets.expandbar.ecl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommandsPackage eINSTANCE = org.eclipse.rcptt.expandbar.commands.impl.CommandsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.expandbar.commands.impl.GetExpandBarImpl <em>Get Expand Bar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.expandbar.commands.impl.GetExpandBarImpl
	 * @see org.eclipse.rcptt.expandbar.commands.impl.CommandsPackageImpl#getGetExpandBar()
	 * @generated
	 */
	int GET_EXPAND_BAR = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_BAR__HOST = TeslaPackage.SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_BAR__BINDINGS = TeslaPackage.SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_BAR__ID = TeslaPackage.SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_BAR__AFTER = TeslaPackage.SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_BAR__TYPE = TeslaPackage.SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_BAR__INDEX = TeslaPackage.SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_BAR__PARENT = TeslaPackage.SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Expand Bar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_BAR_FEATURE_COUNT = TeslaPackage.SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.expandbar.commands.impl.GetExpandItemImpl <em>Get Expand Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.expandbar.commands.impl.GetExpandItemImpl
	 * @see org.eclipse.rcptt.expandbar.commands.impl.CommandsPackageImpl#getGetExpandItem()
	 * @generated
	 */
	int GET_EXPAND_ITEM = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_ITEM__HOST = TeslaPackage.TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_ITEM__BINDINGS = TeslaPackage.TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_ITEM__ID = TeslaPackage.TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_ITEM__AFTER = TeslaPackage.TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_ITEM__TYPE = TeslaPackage.TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_ITEM__INDEX = TeslaPackage.TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_ITEM__PARENT = TeslaPackage.TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_ITEM__TEXT = TeslaPackage.TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Expand Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EXPAND_ITEM_FEATURE_COUNT = TeslaPackage.TEXT_SELECTOR_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.expandbar.commands.GetExpandBar <em>Get Expand Bar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Expand Bar</em>'.
	 * @see org.eclipse.rcptt.expandbar.commands.GetExpandBar
	 * @generated
	 */
	EClass getGetExpandBar();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.expandbar.commands.GetExpandItem <em>Get Expand Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Expand Item</em>'.
	 * @see org.eclipse.rcptt.expandbar.commands.GetExpandItem
	 * @generated
	 */
	EClass getGetExpandItem();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommandsFactory getCommandsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.expandbar.commands.impl.GetExpandBarImpl <em>Get Expand Bar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.expandbar.commands.impl.GetExpandBarImpl
		 * @see org.eclipse.rcptt.expandbar.commands.impl.CommandsPackageImpl#getGetExpandBar()
		 * @generated
		 */
		EClass GET_EXPAND_BAR = eINSTANCE.getGetExpandBar();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.expandbar.commands.impl.GetExpandItemImpl <em>Get Expand Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.expandbar.commands.impl.GetExpandItemImpl
		 * @see org.eclipse.rcptt.expandbar.commands.impl.CommandsPackageImpl#getGetExpandItem()
		 * @generated
		 */
		EClass GET_EXPAND_ITEM = eINSTANCE.getGetExpandItem();

	}

} //CommandsPackage
