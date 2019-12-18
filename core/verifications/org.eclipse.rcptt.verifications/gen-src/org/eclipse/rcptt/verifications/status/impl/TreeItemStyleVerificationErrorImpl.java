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
package org.eclipse.rcptt.verifications.status.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.rcptt.verifications.status.StatusPackage;
import org.eclipse.rcptt.verifications.status.TreeItemStyleVerificationError;
import org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Tree Item Style Verification Error</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.status.impl.TreeItemStyleVerificationErrorImpl#getExpectedStyle <em>Expected Style</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.status.impl.TreeItemStyleVerificationErrorImpl#getActualStyle <em>Actual Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TreeItemStyleVerificationErrorImpl extends TreeItemVerificationErrorImpl implements
		TreeItemStyleVerificationError {
	/**
	 * The cached value of the '{@link #getExpectedStyle() <em>Expected Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpectedStyle()
	 * @generated
	 * @ordered
	 */
	protected StyleRangeEntry expectedStyle;

	/**
	 * The cached value of the '{@link #getActualStyle() <em>Actual Style</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActualStyle()
	 * @generated
	 * @ordered
	 */
	protected StyleRangeEntry actualStyle;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeItemStyleVerificationErrorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatusPackage.Literals.TREE_ITEM_STYLE_VERIFICATION_ERROR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public StyleRangeEntry getExpectedStyle() {
		return expectedStyle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpectedStyle(StyleRangeEntry newExpectedStyle, NotificationChain msgs) {
		StyleRangeEntry oldExpectedStyle = expectedStyle;
		expectedStyle = newExpectedStyle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR__EXPECTED_STYLE, oldExpectedStyle, newExpectedStyle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpectedStyle(StyleRangeEntry newExpectedStyle) {
		if (newExpectedStyle != expectedStyle) {
			NotificationChain msgs = null;
			if (expectedStyle != null)
				msgs = ((InternalEObject)expectedStyle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR__EXPECTED_STYLE, null, msgs);
			if (newExpectedStyle != null)
				msgs = ((InternalEObject)newExpectedStyle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR__EXPECTED_STYLE, null, msgs);
			msgs = basicSetExpectedStyle(newExpectedStyle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR__EXPECTED_STYLE, newExpectedStyle, newExpectedStyle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public StyleRangeEntry getActualStyle() {
		if (actualStyle != null && actualStyle.eIsProxy()) {
			InternalEObject oldActualStyle = (InternalEObject)actualStyle;
			actualStyle = (StyleRangeEntry)eResolveProxy(oldActualStyle);
			if (actualStyle != oldActualStyle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR__ACTUAL_STYLE, oldActualStyle, actualStyle));
			}
		}
		return actualStyle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public StyleRangeEntry basicGetActualStyle() {
		return actualStyle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualStyle(StyleRangeEntry newActualStyle) {
		StyleRangeEntry oldActualStyle = actualStyle;
		actualStyle = newActualStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR__ACTUAL_STYLE, oldActualStyle, actualStyle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR__EXPECTED_STYLE:
				return basicSetExpectedStyle(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR__EXPECTED_STYLE:
				return getExpectedStyle();
			case StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR__ACTUAL_STYLE:
				if (resolve) return getActualStyle();
				return basicGetActualStyle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR__EXPECTED_STYLE:
				setExpectedStyle((StyleRangeEntry)newValue);
				return;
			case StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR__ACTUAL_STYLE:
				setActualStyle((StyleRangeEntry)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR__EXPECTED_STYLE:
				setExpectedStyle((StyleRangeEntry)null);
				return;
			case StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR__ACTUAL_STYLE:
				setActualStyle((StyleRangeEntry)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR__EXPECTED_STYLE:
				return expectedStyle != null;
			case StatusPackage.TREE_ITEM_STYLE_VERIFICATION_ERROR__ACTUAL_STYLE:
				return actualStyle != null;
		}
		return super.eIsSet(featureID);
	}

} // TreeItemStyleVerificationErrorImpl
