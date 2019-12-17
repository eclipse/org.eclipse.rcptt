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
package org.eclipse.rcptt.debug.impl;

import org.eclipse.rcptt.core.scenario.NamedElement;

import org.eclipse.rcptt.core.scenario.impl.NamedElementImpl;

import org.eclipse.rcptt.debug.DebugPackage;
import org.eclipse.rcptt.debug.LaunchConfiguration;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Launch Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.debug.impl.LaunchConfigurationImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.LaunchConfigurationImpl#getTypeId <em>Type Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LaunchConfigurationImpl extends NamedElementImpl implements LaunchConfiguration {
	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedElement> attributes;

	/**
	 * The default value of the '{@link #getTypeId() <em>Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeId()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeId() <em>Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeId()
	 * @generated
	 * @ordered
	 */
	protected String typeId = TYPE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LaunchConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DebugPackage.Literals.LAUNCH_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<NamedElement>(NamedElement.class, this, DebugPackage.LAUNCH_CONFIGURATION__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeId(String newTypeId) {
		String oldTypeId = typeId;
		typeId = newTypeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.LAUNCH_CONFIGURATION__TYPE_ID, oldTypeId, typeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DebugPackage.LAUNCH_CONFIGURATION__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
			case DebugPackage.LAUNCH_CONFIGURATION__ATTRIBUTES:
				return getAttributes();
			case DebugPackage.LAUNCH_CONFIGURATION__TYPE_ID:
				return getTypeId();
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
			case DebugPackage.LAUNCH_CONFIGURATION__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends NamedElement>)newValue);
				return;
			case DebugPackage.LAUNCH_CONFIGURATION__TYPE_ID:
				setTypeId((String)newValue);
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
			case DebugPackage.LAUNCH_CONFIGURATION__ATTRIBUTES:
				getAttributes().clear();
				return;
			case DebugPackage.LAUNCH_CONFIGURATION__TYPE_ID:
				setTypeId(TYPE_ID_EDEFAULT);
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
			case DebugPackage.LAUNCH_CONFIGURATION__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case DebugPackage.LAUNCH_CONFIGURATION__TYPE_ID:
				return TYPE_ID_EDEFAULT == null ? typeId != null : !TYPE_ID_EDEFAULT.equals(typeId);
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
		result.append(" (typeId: ");
		result.append(typeId);
		result.append(')');
		return result.toString();
	}

} //LaunchConfigurationImpl
