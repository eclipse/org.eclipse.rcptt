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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.rcptt.tesla.protocol.nebula.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NebulaFactoryImpl extends EFactoryImpl implements NebulaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NebulaFactory init() {
		try {
			NebulaFactory theNebulaFactory = (NebulaFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/rcptt/tesla/nebula"); 
			if (theNebulaFactory != null) {
				return theNebulaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NebulaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NebulaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case NebulaPackage.SET_SELECTION_EX: return createSetSelectionEx();
			case NebulaPackage.SET_SELECTION_RANGE: return createSetSelectionRange();
			case NebulaPackage.MULTI_SELECTION_ITEM_EX: return createMultiSelectionItemEx();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetSelectionEx createSetSelectionEx() {
		SetSelectionExImpl setSelectionEx = new SetSelectionExImpl();
		return setSelectionEx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetSelectionRange createSetSelectionRange() {
		SetSelectionRangeImpl setSelectionRange = new SetSelectionRangeImpl();
		return setSelectionRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiSelectionItemEx createMultiSelectionItemEx() {
		MultiSelectionItemExImpl multiSelectionItemEx = new MultiSelectionItemExImpl();
		return multiSelectionItemEx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NebulaPackage getNebulaPackage() {
		return (NebulaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NebulaPackage getPackage() {
		return NebulaPackage.eINSTANCE;
	}

} //NebulaFactoryImpl
