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
package org.eclipse.rcptt.launching.injection.impl;

import org.eclipse.rcptt.launching.injection.InjectionPackage;
import org.eclipse.rcptt.launching.injection.UpdateSite;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Update Site</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.launching.injection.impl.UpdateSiteImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.rcptt.launching.injection.impl.UpdateSiteImpl#getUnits <em>Units</em>}</li>
 *   <li>{@link org.eclipse.rcptt.launching.injection.impl.UpdateSiteImpl#isAllUnits <em>All Units</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UpdateSiteImpl extends EntryImpl implements UpdateSite {
	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUnits() <em>Units</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<String> units;

	/**
	 * The default value of the '{@link #isAllUnits() <em>All Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllUnits()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALL_UNITS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllUnits() <em>All Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllUnits()
	 * @generated
	 * @ordered
	 */
	protected boolean allUnits = ALL_UNITS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UpdateSiteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InjectionPackage.Literals.UPDATE_SITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InjectionPackage.UPDATE_SITE__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getUnits() {
		if (units == null) {
			units = new EDataTypeUniqueEList<String>(String.class, this, InjectionPackage.UPDATE_SITE__UNITS);
		}
		return units;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllUnits() {
		return allUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllUnits(boolean newAllUnits) {
		boolean oldAllUnits = allUnits;
		allUnits = newAllUnits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InjectionPackage.UPDATE_SITE__ALL_UNITS, oldAllUnits, allUnits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InjectionPackage.UPDATE_SITE__URI:
				return getUri();
			case InjectionPackage.UPDATE_SITE__UNITS:
				return getUnits();
			case InjectionPackage.UPDATE_SITE__ALL_UNITS:
				return isAllUnits();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InjectionPackage.UPDATE_SITE__URI:
				setUri((String)newValue);
				return;
			case InjectionPackage.UPDATE_SITE__UNITS:
				getUnits().clear();
				getUnits().addAll((Collection<? extends String>)newValue);
				return;
			case InjectionPackage.UPDATE_SITE__ALL_UNITS:
				setAllUnits((Boolean)newValue);
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
			case InjectionPackage.UPDATE_SITE__URI:
				setUri(URI_EDEFAULT);
				return;
			case InjectionPackage.UPDATE_SITE__UNITS:
				getUnits().clear();
				return;
			case InjectionPackage.UPDATE_SITE__ALL_UNITS:
				setAllUnits(ALL_UNITS_EDEFAULT);
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
			case InjectionPackage.UPDATE_SITE__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case InjectionPackage.UPDATE_SITE__UNITS:
				return units != null && !units.isEmpty();
			case InjectionPackage.UPDATE_SITE__ALL_UNITS:
				return allUnits != ALL_UNITS_EDEFAULT;
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(", units: ");
		result.append(units);
		result.append(", allUnits: ");
		result.append(allUnits);
		result.append(')');
		return result.toString();
	}

} //UpdateSiteImpl
