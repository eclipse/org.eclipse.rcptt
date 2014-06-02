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
package org.eclipse.rcptt.debug.impl;

import org.eclipse.rcptt.core.scenario.NamedElement;

import org.eclipse.rcptt.debug.DebugPackage;
import org.eclipse.rcptt.debug.Launch;
import org.eclipse.rcptt.debug.LaunchConfiguration;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Launch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.debug.impl.LaunchImpl#getConfigurationDelta <em>Configuration Delta</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.LaunchImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.LaunchImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.LaunchImpl#getConfigurationName <em>Configuration Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LaunchImpl extends EObjectImpl implements Launch {
	/**
	 * The cached value of the '{@link #getConfigurationDelta() <em>Configuration Delta</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationDelta()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedElement> configurationDelta;

	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final String MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected String mode = MODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected LaunchConfiguration configuration;

	/**
	 * The default value of the '{@link #getConfigurationName() <em>Configuration Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationName()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIGURATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfigurationName() <em>Configuration Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationName()
	 * @generated
	 * @ordered
	 */
	protected String configurationName = CONFIGURATION_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LaunchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DebugPackage.Literals.LAUNCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getConfigurationDelta() {
		if (configurationDelta == null) {
			configurationDelta = new EObjectContainmentEList<NamedElement>(NamedElement.class, this, DebugPackage.LAUNCH__CONFIGURATION_DELTA);
		}
		return configurationDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(String newMode) {
		String oldMode = mode;
		mode = newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.LAUNCH__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaunchConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(LaunchConfiguration newConfiguration) {
		LaunchConfiguration oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.LAUNCH__CONFIGURATION, oldConfiguration, configuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfigurationName() {
		return configurationName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurationName(String newConfigurationName) {
		String oldConfigurationName = configurationName;
		configurationName = newConfigurationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.LAUNCH__CONFIGURATION_NAME, oldConfigurationName, configurationName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DebugPackage.LAUNCH__CONFIGURATION_DELTA:
				return ((InternalEList<?>)getConfigurationDelta()).basicRemove(otherEnd, msgs);
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
			case DebugPackage.LAUNCH__CONFIGURATION_DELTA:
				return getConfigurationDelta();
			case DebugPackage.LAUNCH__MODE:
				return getMode();
			case DebugPackage.LAUNCH__CONFIGURATION:
				return getConfiguration();
			case DebugPackage.LAUNCH__CONFIGURATION_NAME:
				return getConfigurationName();
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
			case DebugPackage.LAUNCH__CONFIGURATION_DELTA:
				getConfigurationDelta().clear();
				getConfigurationDelta().addAll((Collection<? extends NamedElement>)newValue);
				return;
			case DebugPackage.LAUNCH__MODE:
				setMode((String)newValue);
				return;
			case DebugPackage.LAUNCH__CONFIGURATION:
				setConfiguration((LaunchConfiguration)newValue);
				return;
			case DebugPackage.LAUNCH__CONFIGURATION_NAME:
				setConfigurationName((String)newValue);
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
			case DebugPackage.LAUNCH__CONFIGURATION_DELTA:
				getConfigurationDelta().clear();
				return;
			case DebugPackage.LAUNCH__MODE:
				setMode(MODE_EDEFAULT);
				return;
			case DebugPackage.LAUNCH__CONFIGURATION:
				setConfiguration((LaunchConfiguration)null);
				return;
			case DebugPackage.LAUNCH__CONFIGURATION_NAME:
				setConfigurationName(CONFIGURATION_NAME_EDEFAULT);
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
			case DebugPackage.LAUNCH__CONFIGURATION_DELTA:
				return configurationDelta != null && !configurationDelta.isEmpty();
			case DebugPackage.LAUNCH__MODE:
				return MODE_EDEFAULT == null ? mode != null : !MODE_EDEFAULT.equals(mode);
			case DebugPackage.LAUNCH__CONFIGURATION:
				return configuration != null;
			case DebugPackage.LAUNCH__CONFIGURATION_NAME:
				return CONFIGURATION_NAME_EDEFAULT == null ? configurationName != null : !CONFIGURATION_NAME_EDEFAULT.equals(configurationName);
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
		result.append(" (mode: ");
		result.append(mode);
		result.append(", configurationName: ");
		result.append(configurationName);
		result.append(')');
		return result.toString();
	}

} //LaunchImpl
