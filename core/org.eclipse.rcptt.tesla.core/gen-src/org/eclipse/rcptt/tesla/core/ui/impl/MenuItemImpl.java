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
package org.eclipse.rcptt.tesla.core.ui.impl;

import org.eclipse.rcptt.tesla.core.ui.MenuItem;
import org.eclipse.rcptt.tesla.core.ui.UiPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Menu Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.MenuItemImpl#getAccelerator <em>Accelerator</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.MenuItemImpl#isCascade <em>Cascade</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MenuItemImpl extends ItemImpl implements MenuItem {
	/**
	 * The default value of the '{@link #getAccelerator() <em>Accelerator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccelerator()
	 * @generated
	 * @ordered
	 */
	protected static final String ACCELERATOR_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getAccelerator() <em>Accelerator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccelerator()
	 * @generated
	 * @ordered
	 */
	protected String accelerator = ACCELERATOR_EDEFAULT;
	/**
	 * The default value of the '{@link #isCascade() <em>Cascade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCascade()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CASCADE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isCascade() <em>Cascade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCascade()
	 * @generated
	 * @ordered
	 */
	protected boolean cascade = CASCADE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiPackage.Literals.MENU_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAccelerator() {
		return accelerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccelerator(String newAccelerator) {
		String oldAccelerator = accelerator;
		accelerator = newAccelerator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.MENU_ITEM__ACCELERATOR, oldAccelerator, accelerator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCascade() {
		return cascade;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCascade(boolean newCascade) {
		boolean oldCascade = cascade;
		cascade = newCascade;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.MENU_ITEM__CASCADE, oldCascade, cascade));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UiPackage.MENU_ITEM__ACCELERATOR:
				return getAccelerator();
			case UiPackage.MENU_ITEM__CASCADE:
				return isCascade();
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
			case UiPackage.MENU_ITEM__ACCELERATOR:
				setAccelerator((String)newValue);
				return;
			case UiPackage.MENU_ITEM__CASCADE:
				setCascade((Boolean)newValue);
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
			case UiPackage.MENU_ITEM__ACCELERATOR:
				setAccelerator(ACCELERATOR_EDEFAULT);
				return;
			case UiPackage.MENU_ITEM__CASCADE:
				setCascade(CASCADE_EDEFAULT);
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
			case UiPackage.MENU_ITEM__ACCELERATOR:
				return ACCELERATOR_EDEFAULT == null ? accelerator != null : !ACCELERATOR_EDEFAULT.equals(accelerator);
			case UiPackage.MENU_ITEM__CASCADE:
				return cascade != CASCADE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (accelerator: ");
		result.append(accelerator);
		result.append(", cascade: ");
		result.append(cascade);
		result.append(')');
		return result.toString();
	}

} //MenuItemImpl
