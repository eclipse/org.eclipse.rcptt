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

import org.eclipse.rcptt.verifications.tree.CaptureTreeVerificationData;
import org.eclipse.rcptt.verifications.tree.TreePackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Capture Tree Verification Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.CaptureTreeVerificationDataImpl#getImages <em>Images</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CaptureTreeVerificationDataImpl extends CommonTreeVerificationDataImpl implements CaptureTreeVerificationData {
	/**
	 * The cached value of the '{@link #getImages() <em>Images</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImages()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, byte[]> images;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CaptureTreeVerificationDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TreePackage.Literals.CAPTURE_TREE_VERIFICATION_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, byte[]> getImages() {
		if (images == null) {
			images = new EcoreEMap<String,byte[]>(TreePackage.Literals.IMAGES_MAP, ImagesMapImpl.class, this, TreePackage.CAPTURE_TREE_VERIFICATION_DATA__IMAGES);
		}
		return images;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TreePackage.CAPTURE_TREE_VERIFICATION_DATA__IMAGES:
				return ((InternalEList<?>)getImages()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TreePackage.CAPTURE_TREE_VERIFICATION_DATA__IMAGES:
				if (coreType) return getImages();
				else return getImages().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TreePackage.CAPTURE_TREE_VERIFICATION_DATA__IMAGES:
				((EStructuralFeature.Setting)getImages()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TreePackage.CAPTURE_TREE_VERIFICATION_DATA__IMAGES:
				getImages().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TreePackage.CAPTURE_TREE_VERIFICATION_DATA__IMAGES:
				return images != null && !images.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CaptureTreeVerificationDataImpl
