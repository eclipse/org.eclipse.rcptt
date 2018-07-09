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
package org.eclipse.rcptt.core.ecl.core.model.impl;

import org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage;
import org.eclipse.rcptt.core.ecl.core.model.Q7Information;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Q7 Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.impl.Q7InformationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.impl.Q7InformationImpl#isTeslaActive <em>Tesla Active</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.impl.Q7InformationImpl#getTeslaPort <em>Tesla Port</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.impl.Q7InformationImpl#isClientActive <em>Client Active</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.impl.Q7InformationImpl#getWindowCount <em>Window Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Q7InformationImpl extends EObjectImpl implements Q7Information {
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
	 * The default value of the '{@link #isTeslaActive() <em>Tesla Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTeslaActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TESLA_ACTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTeslaActive() <em>Tesla Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTeslaActive()
	 * @generated
	 * @ordered
	 */
	protected boolean teslaActive = TESLA_ACTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTeslaPort() <em>Tesla Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeslaPort()
	 * @generated
	 * @ordered
	 */
	protected static final int TESLA_PORT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTeslaPort() <em>Tesla Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeslaPort()
	 * @generated
	 * @ordered
	 */
	protected int teslaPort = TESLA_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #isClientActive() <em>Client Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClientActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLIENT_ACTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isClientActive() <em>Client Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClientActive()
	 * @generated
	 * @ordered
	 */
	protected boolean clientActive = CLIENT_ACTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWindowCount() <em>Window Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWindowCount()
	 * @generated
	 * @ordered
	 */
	protected static final int WINDOW_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWindowCount() <em>Window Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWindowCount()
	 * @generated
	 * @ordered
	 */
	protected int windowCount = WINDOW_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Q7InformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Q7CorePackage.Literals.Q7_INFORMATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Q7CorePackage.Q7_INFORMATION__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTeslaActive() {
		return teslaActive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTeslaActive(boolean newTeslaActive) {
		boolean oldTeslaActive = teslaActive;
		teslaActive = newTeslaActive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Q7CorePackage.Q7_INFORMATION__TESLA_ACTIVE, oldTeslaActive, teslaActive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTeslaPort() {
		return teslaPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTeslaPort(int newTeslaPort) {
		int oldTeslaPort = teslaPort;
		teslaPort = newTeslaPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Q7CorePackage.Q7_INFORMATION__TESLA_PORT, oldTeslaPort, teslaPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClientActive() {
		return clientActive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClientActive(boolean newClientActive) {
		boolean oldClientActive = clientActive;
		clientActive = newClientActive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Q7CorePackage.Q7_INFORMATION__CLIENT_ACTIVE, oldClientActive, clientActive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWindowCount() {
		return windowCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWindowCount(int newWindowCount) {
		int oldWindowCount = windowCount;
		windowCount = newWindowCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Q7CorePackage.Q7_INFORMATION__WINDOW_COUNT, oldWindowCount, windowCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Q7CorePackage.Q7_INFORMATION__VERSION:
				return getVersion();
			case Q7CorePackage.Q7_INFORMATION__TESLA_ACTIVE:
				return isTeslaActive();
			case Q7CorePackage.Q7_INFORMATION__TESLA_PORT:
				return getTeslaPort();
			case Q7CorePackage.Q7_INFORMATION__CLIENT_ACTIVE:
				return isClientActive();
			case Q7CorePackage.Q7_INFORMATION__WINDOW_COUNT:
				return getWindowCount();
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
			case Q7CorePackage.Q7_INFORMATION__VERSION:
				setVersion((String)newValue);
				return;
			case Q7CorePackage.Q7_INFORMATION__TESLA_ACTIVE:
				setTeslaActive((Boolean)newValue);
				return;
			case Q7CorePackage.Q7_INFORMATION__TESLA_PORT:
				setTeslaPort((Integer)newValue);
				return;
			case Q7CorePackage.Q7_INFORMATION__CLIENT_ACTIVE:
				setClientActive((Boolean)newValue);
				return;
			case Q7CorePackage.Q7_INFORMATION__WINDOW_COUNT:
				setWindowCount((Integer)newValue);
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
			case Q7CorePackage.Q7_INFORMATION__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case Q7CorePackage.Q7_INFORMATION__TESLA_ACTIVE:
				setTeslaActive(TESLA_ACTIVE_EDEFAULT);
				return;
			case Q7CorePackage.Q7_INFORMATION__TESLA_PORT:
				setTeslaPort(TESLA_PORT_EDEFAULT);
				return;
			case Q7CorePackage.Q7_INFORMATION__CLIENT_ACTIVE:
				setClientActive(CLIENT_ACTIVE_EDEFAULT);
				return;
			case Q7CorePackage.Q7_INFORMATION__WINDOW_COUNT:
				setWindowCount(WINDOW_COUNT_EDEFAULT);
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
			case Q7CorePackage.Q7_INFORMATION__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case Q7CorePackage.Q7_INFORMATION__TESLA_ACTIVE:
				return teslaActive != TESLA_ACTIVE_EDEFAULT;
			case Q7CorePackage.Q7_INFORMATION__TESLA_PORT:
				return teslaPort != TESLA_PORT_EDEFAULT;
			case Q7CorePackage.Q7_INFORMATION__CLIENT_ACTIVE:
				return clientActive != CLIENT_ACTIVE_EDEFAULT;
			case Q7CorePackage.Q7_INFORMATION__WINDOW_COUNT:
				return windowCount != WINDOW_COUNT_EDEFAULT;
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
		result.append(" (version: ");
		result.append(version);
		result.append(", teslaActive: ");
		result.append(teslaActive);
		result.append(", teslaPort: ");
		result.append(teslaPort);
		result.append(", clientActive: ");
		result.append(clientActive);
		result.append(", windowCount: ");
		result.append(windowCount);
		result.append(')');
		return result.toString();
	}

} //Q7InformationImpl
