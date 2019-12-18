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
package org.eclipse.rcptt.ecl.platform.objects.impl;

import java.util.Collection;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.rcptt.ecl.platform.objects.ObjectsPackage;
import org.eclipse.rcptt.ecl.platform.objects.Plugin;
import org.eclipse.rcptt.ecl.platform.objects.PluginState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plugin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.impl.PluginImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.impl.PluginImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.impl.PluginImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.impl.PluginImpl#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.impl.PluginImpl#getRequiredBundles <em>Required Bundles</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.impl.PluginImpl#getImportedPackages <em>Imported Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PluginImpl extends EObjectImpl implements Plugin {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final PluginState STATE_EDEFAULT = PluginState.UNINSTALLED;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected PluginState state = STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRequiredBundles() <em>Required Bundles</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredBundles()
	 * @generated
	 * @ordered
	 */
	protected EList<String> requiredBundles;

	/**
	 * The cached value of the '{@link #getImportedPackages() <em>Imported Packages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<String> importedPackages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PluginImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ObjectsPackage.Literals.PLUGIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ObjectsPackage.PLUGIN__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ObjectsPackage.PLUGIN__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ObjectsPackage.PLUGIN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PluginState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(PluginState newState) {
		PluginState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ObjectsPackage.PLUGIN__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getRequiredBundles() {
		if (requiredBundles == null) {
			requiredBundles = new EDataTypeUniqueEList<String>(String.class, this, ObjectsPackage.PLUGIN__REQUIRED_BUNDLES);
		}
		return requiredBundles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getImportedPackages() {
		if (importedPackages == null) {
			importedPackages = new EDataTypeUniqueEList<String>(String.class, this, ObjectsPackage.PLUGIN__IMPORTED_PACKAGES);
		}
		return importedPackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ObjectsPackage.PLUGIN__ID:
				return getId();
			case ObjectsPackage.PLUGIN__VERSION:
				return getVersion();
			case ObjectsPackage.PLUGIN__NAME:
				return getName();
			case ObjectsPackage.PLUGIN__STATE:
				return getState();
			case ObjectsPackage.PLUGIN__REQUIRED_BUNDLES:
				return getRequiredBundles();
			case ObjectsPackage.PLUGIN__IMPORTED_PACKAGES:
				return getImportedPackages();
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
			case ObjectsPackage.PLUGIN__ID:
				setId((String)newValue);
				return;
			case ObjectsPackage.PLUGIN__VERSION:
				setVersion((String)newValue);
				return;
			case ObjectsPackage.PLUGIN__NAME:
				setName((String)newValue);
				return;
			case ObjectsPackage.PLUGIN__STATE:
				setState((PluginState)newValue);
				return;
			case ObjectsPackage.PLUGIN__REQUIRED_BUNDLES:
				getRequiredBundles().clear();
				getRequiredBundles().addAll((Collection<? extends String>)newValue);
				return;
			case ObjectsPackage.PLUGIN__IMPORTED_PACKAGES:
				getImportedPackages().clear();
				getImportedPackages().addAll((Collection<? extends String>)newValue);
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
			case ObjectsPackage.PLUGIN__ID:
				setId(ID_EDEFAULT);
				return;
			case ObjectsPackage.PLUGIN__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case ObjectsPackage.PLUGIN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ObjectsPackage.PLUGIN__STATE:
				setState(STATE_EDEFAULT);
				return;
			case ObjectsPackage.PLUGIN__REQUIRED_BUNDLES:
				getRequiredBundles().clear();
				return;
			case ObjectsPackage.PLUGIN__IMPORTED_PACKAGES:
				getImportedPackages().clear();
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
			case ObjectsPackage.PLUGIN__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ObjectsPackage.PLUGIN__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case ObjectsPackage.PLUGIN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ObjectsPackage.PLUGIN__STATE:
				return state != STATE_EDEFAULT;
			case ObjectsPackage.PLUGIN__REQUIRED_BUNDLES:
				return requiredBundles != null && !requiredBundles.isEmpty();
			case ObjectsPackage.PLUGIN__IMPORTED_PACKAGES:
				return importedPackages != null && !importedPackages.isEmpty();
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
		result.append(" (id: ");
		result.append(id);
		result.append(", version: ");
		result.append(version);
		result.append(", name: ");
		result.append(name);
		result.append(", state: ");
		result.append(state);
		result.append(", requiredBundles: ");
		result.append(requiredBundles);
		result.append(", importedPackages: ");
		result.append(importedPackages);
		result.append(')');
		return result.toString();
	}

} //PluginImpl
