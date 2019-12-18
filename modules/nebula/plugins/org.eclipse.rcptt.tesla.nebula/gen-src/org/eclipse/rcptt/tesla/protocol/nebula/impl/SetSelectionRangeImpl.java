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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.rcptt.tesla.core.protocol.impl.SetSelectionImpl;

import org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx;
import org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage;
import org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Selection Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.protocol.nebula.impl.SetSelectionRangeImpl#getToPath <em>To Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.protocol.nebula.impl.SetSelectionRangeImpl#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.protocol.nebula.impl.SetSelectionRangeImpl#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetSelectionRangeImpl extends SetSelectionImpl implements SetSelectionRange {
	/**
	 * The cached value of the '{@link #getToPath() <em>To Path</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToPath()
	 * @generated
	 * @ordered
	 */
	protected EList<String> toPath;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected MultiSelectionItemEx from;

	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected MultiSelectionItemEx to;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetSelectionRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NebulaPackage.Literals.SET_SELECTION_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getToPath() {
		if (toPath == null) {
			toPath = new EDataTypeEList<String>(String.class, this, NebulaPackage.SET_SELECTION_RANGE__TO_PATH);
		}
		return toPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiSelectionItemEx getFrom() {
		if (from != null && from.eIsProxy()) {
			InternalEObject oldFrom = (InternalEObject)from;
			from = (MultiSelectionItemEx)eResolveProxy(oldFrom);
			if (from != oldFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NebulaPackage.SET_SELECTION_RANGE__FROM, oldFrom, from));
			}
		}
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiSelectionItemEx basicGetFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(MultiSelectionItemEx newFrom) {
		MultiSelectionItemEx oldFrom = from;
		from = newFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.SET_SELECTION_RANGE__FROM, oldFrom, from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiSelectionItemEx getTo() {
		if (to != null && to.eIsProxy()) {
			InternalEObject oldTo = (InternalEObject)to;
			to = (MultiSelectionItemEx)eResolveProxy(oldTo);
			if (to != oldTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NebulaPackage.SET_SELECTION_RANGE__TO, oldTo, to));
			}
		}
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiSelectionItemEx basicGetTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo(MultiSelectionItemEx newTo) {
		MultiSelectionItemEx oldTo = to;
		to = newTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.SET_SELECTION_RANGE__TO, oldTo, to));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NebulaPackage.SET_SELECTION_RANGE__TO_PATH:
				return getToPath();
			case NebulaPackage.SET_SELECTION_RANGE__FROM:
				if (resolve) return getFrom();
				return basicGetFrom();
			case NebulaPackage.SET_SELECTION_RANGE__TO:
				if (resolve) return getTo();
				return basicGetTo();
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
			case NebulaPackage.SET_SELECTION_RANGE__TO_PATH:
				getToPath().clear();
				getToPath().addAll((Collection<? extends String>)newValue);
				return;
			case NebulaPackage.SET_SELECTION_RANGE__FROM:
				setFrom((MultiSelectionItemEx)newValue);
				return;
			case NebulaPackage.SET_SELECTION_RANGE__TO:
				setTo((MultiSelectionItemEx)newValue);
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
			case NebulaPackage.SET_SELECTION_RANGE__TO_PATH:
				getToPath().clear();
				return;
			case NebulaPackage.SET_SELECTION_RANGE__FROM:
				setFrom((MultiSelectionItemEx)null);
				return;
			case NebulaPackage.SET_SELECTION_RANGE__TO:
				setTo((MultiSelectionItemEx)null);
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
			case NebulaPackage.SET_SELECTION_RANGE__TO_PATH:
				return toPath != null && !toPath.isEmpty();
			case NebulaPackage.SET_SELECTION_RANGE__FROM:
				return from != null;
			case NebulaPackage.SET_SELECTION_RANGE__TO:
				return to != null;
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
		result.append(" (toPath: ");
		result.append(toPath);
		result.append(')');
		return result.toString();
	}

} //SetSelectionRangeImpl
