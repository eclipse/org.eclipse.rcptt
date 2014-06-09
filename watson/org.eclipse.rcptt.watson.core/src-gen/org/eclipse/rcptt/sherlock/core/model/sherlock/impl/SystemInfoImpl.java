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
package org.eclipse.rcptt.sherlock.core.model.sherlock.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage;
import org.eclipse.rcptt.sherlock.core.model.sherlock.SystemInfo;
import org.eclipse.rcptt.sherlock.core.model.sherlock.SystemVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SystemInfoImpl#getOsName <em>Os Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SystemInfoImpl#getOsVersion <em>Os Version</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SystemInfoImpl#getOsArch <em>Os Arch</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SystemInfoImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SystemInfoImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemInfoImpl extends EObjectImpl implements SystemInfo {
	/**
	 * The default value of the '{@link #getOsName() <em>Os Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOsName()
	 * @generated
	 * @ordered
	 */
	protected static final String OS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOsName() <em>Os Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOsName()
	 * @generated
	 * @ordered
	 */
	protected String osName = OS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOsVersion() <em>Os Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOsVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String OS_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOsVersion() <em>Os Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOsVersion()
	 * @generated
	 * @ordered
	 */
	protected String osVersion = OS_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getOsArch() <em>Os Arch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOsArch()
	 * @generated
	 * @ordered
	 */
	protected static final String OS_ARCH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOsArch() <em>Os Arch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOsArch()
	 * @generated
	 * @ordered
	 */
	protected String osArch = OS_ARCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String USERNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsername()
	 * @generated
	 * @ordered
	 */
	protected String username = USERNAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemVariable> variables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SherlockPackage.Literals.SYSTEM_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOsName() {
		return osName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOsName(String newOsName) {
		String oldOsName = osName;
		osName = newOsName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.SYSTEM_INFO__OS_NAME, oldOsName, osName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOsVersion() {
		return osVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOsVersion(String newOsVersion) {
		String oldOsVersion = osVersion;
		osVersion = newOsVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.SYSTEM_INFO__OS_VERSION, oldOsVersion, osVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOsArch() {
		return osArch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOsArch(String newOsArch) {
		String oldOsArch = osArch;
		osArch = newOsArch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.SYSTEM_INFO__OS_ARCH, oldOsArch, osArch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsername(String newUsername) {
		String oldUsername = username;
		username = newUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.SYSTEM_INFO__USERNAME, oldUsername, username));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemVariable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<SystemVariable>(SystemVariable.class, this, SherlockPackage.SYSTEM_INFO__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SherlockPackage.SYSTEM_INFO__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
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
			case SherlockPackage.SYSTEM_INFO__OS_NAME:
				return getOsName();
			case SherlockPackage.SYSTEM_INFO__OS_VERSION:
				return getOsVersion();
			case SherlockPackage.SYSTEM_INFO__OS_ARCH:
				return getOsArch();
			case SherlockPackage.SYSTEM_INFO__USERNAME:
				return getUsername();
			case SherlockPackage.SYSTEM_INFO__VARIABLES:
				return getVariables();
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
			case SherlockPackage.SYSTEM_INFO__OS_NAME:
				setOsName((String)newValue);
				return;
			case SherlockPackage.SYSTEM_INFO__OS_VERSION:
				setOsVersion((String)newValue);
				return;
			case SherlockPackage.SYSTEM_INFO__OS_ARCH:
				setOsArch((String)newValue);
				return;
			case SherlockPackage.SYSTEM_INFO__USERNAME:
				setUsername((String)newValue);
				return;
			case SherlockPackage.SYSTEM_INFO__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends SystemVariable>)newValue);
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
			case SherlockPackage.SYSTEM_INFO__OS_NAME:
				setOsName(OS_NAME_EDEFAULT);
				return;
			case SherlockPackage.SYSTEM_INFO__OS_VERSION:
				setOsVersion(OS_VERSION_EDEFAULT);
				return;
			case SherlockPackage.SYSTEM_INFO__OS_ARCH:
				setOsArch(OS_ARCH_EDEFAULT);
				return;
			case SherlockPackage.SYSTEM_INFO__USERNAME:
				setUsername(USERNAME_EDEFAULT);
				return;
			case SherlockPackage.SYSTEM_INFO__VARIABLES:
				getVariables().clear();
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
			case SherlockPackage.SYSTEM_INFO__OS_NAME:
				return OS_NAME_EDEFAULT == null ? osName != null : !OS_NAME_EDEFAULT.equals(osName);
			case SherlockPackage.SYSTEM_INFO__OS_VERSION:
				return OS_VERSION_EDEFAULT == null ? osVersion != null : !OS_VERSION_EDEFAULT.equals(osVersion);
			case SherlockPackage.SYSTEM_INFO__OS_ARCH:
				return OS_ARCH_EDEFAULT == null ? osArch != null : !OS_ARCH_EDEFAULT.equals(osArch);
			case SherlockPackage.SYSTEM_INFO__USERNAME:
				return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
			case SherlockPackage.SYSTEM_INFO__VARIABLES:
				return variables != null && !variables.isEmpty();
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
		result.append(" (osName: ");
		result.append(osName);
		result.append(", osVersion: ");
		result.append(osVersion);
		result.append(", osArch: ");
		result.append(osArch);
		result.append(", username: ");
		result.append(username);
		result.append(')');
		return result.toString();
	}

} //SystemInfoImpl
