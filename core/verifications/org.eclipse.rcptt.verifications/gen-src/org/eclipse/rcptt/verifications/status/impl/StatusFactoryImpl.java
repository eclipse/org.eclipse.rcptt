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
package org.eclipse.rcptt.verifications.status.impl;

import org.eclipse.rcptt.verifications.status.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StatusFactoryImpl extends EFactoryImpl implements StatusFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StatusFactory init() {
		try {
			StatusFactory theStatusFactory = (StatusFactory)EPackage.Registry.INSTANCE.getEFactory(StatusPackage.eNS_URI);
			if (theStatusFactory != null) {
				return theStatusFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StatusFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatusFactoryImpl() {
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
			case StatusPackage.EVERIFICATION_STATUS: return createEVerificationStatus();
			case StatusPackage.VERIFICATION_STATUS_DATA: return createVerificationStatusData();
			case StatusPackage.TREE_ITEM_VERIFICATION_ERROR: return createTreeItemVerificationError();
			case StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR: return createTreeItemStyleVerificationError();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EVerificationStatus createEVerificationStatus() {
		EVerificationStatusImpl eVerificationStatus = new EVerificationStatusImpl();
		return eVerificationStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerificationStatusData createVerificationStatusData() {
		VerificationStatusDataImpl verificationStatusData = new VerificationStatusDataImpl();
		return verificationStatusData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeItemVerificationError createTreeItemVerificationError() {
		TreeItemVerificationErrorImpl treeItemVerificationError = new TreeItemVerificationErrorImpl();
		return treeItemVerificationError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeItemStyleVerificationError createTreeItemStyleVerificationError() {
		TreeItemStyleVerificationErrorImpl treeItemStyleVerificationError = new TreeItemStyleVerificationErrorImpl();
		return treeItemStyleVerificationError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatusPackage getStatusPackage() {
		return (StatusPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StatusPackage getPackage() {
		return StatusPackage.eINSTANCE;
	}

} //StatusFactoryImpl
