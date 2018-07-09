/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.scenario.impl;

import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.core.scenario.TestSuiteItem;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Suite Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.TestSuiteItemImpl#getNamedElementId <em>Named Element Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.TestSuiteItemImpl#getNamedElemetName <em>Named Elemet Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.TestSuiteItemImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.TestSuiteItemImpl#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestSuiteItemImpl extends EObjectImpl implements TestSuiteItem {
	/**
	 * The default value of the '{@link #getNamedElementId() <em>Named Element Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedElementId()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMED_ELEMENT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamedElementId() <em>Named Element Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedElementId()
	 * @generated
	 * @ordered
	 */
	protected String namedElementId = NAMED_ELEMENT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getNamedElemetName() <em>Named Elemet Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedElemetName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMED_ELEMET_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamedElemetName() <em>Named Elemet Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedElemetName()
	 * @generated
	 * @ordered
	 */
	protected String namedElemetName = NAMED_ELEMET_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected String kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestSuiteItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScenarioPackage.Literals.TEST_SUITE_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNamedElementId() {
		return namedElementId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamedElementId(String newNamedElementId) {
		String oldNamedElementId = namedElementId;
		namedElementId = newNamedElementId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.TEST_SUITE_ITEM__NAMED_ELEMENT_ID, oldNamedElementId, namedElementId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNamedElemetName() {
		return namedElemetName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamedElemetName(String newNamedElemetName) {
		String oldNamedElemetName = namedElemetName;
		namedElemetName = newNamedElemetName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.TEST_SUITE_ITEM__NAMED_ELEMET_NAME, oldNamedElemetName, namedElemetName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(String newKind) {
		String oldKind = kind;
		kind = newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.TEST_SUITE_ITEM__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.TEST_SUITE_ITEM__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScenarioPackage.TEST_SUITE_ITEM__NAMED_ELEMENT_ID:
				return getNamedElementId();
			case ScenarioPackage.TEST_SUITE_ITEM__NAMED_ELEMET_NAME:
				return getNamedElemetName();
			case ScenarioPackage.TEST_SUITE_ITEM__KIND:
				return getKind();
			case ScenarioPackage.TEST_SUITE_ITEM__PATH:
				return getPath();
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
			case ScenarioPackage.TEST_SUITE_ITEM__NAMED_ELEMENT_ID:
				setNamedElementId((String)newValue);
				return;
			case ScenarioPackage.TEST_SUITE_ITEM__NAMED_ELEMET_NAME:
				setNamedElemetName((String)newValue);
				return;
			case ScenarioPackage.TEST_SUITE_ITEM__KIND:
				setKind((String)newValue);
				return;
			case ScenarioPackage.TEST_SUITE_ITEM__PATH:
				setPath((String)newValue);
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
			case ScenarioPackage.TEST_SUITE_ITEM__NAMED_ELEMENT_ID:
				setNamedElementId(NAMED_ELEMENT_ID_EDEFAULT);
				return;
			case ScenarioPackage.TEST_SUITE_ITEM__NAMED_ELEMET_NAME:
				setNamedElemetName(NAMED_ELEMET_NAME_EDEFAULT);
				return;
			case ScenarioPackage.TEST_SUITE_ITEM__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ScenarioPackage.TEST_SUITE_ITEM__PATH:
				setPath(PATH_EDEFAULT);
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
			case ScenarioPackage.TEST_SUITE_ITEM__NAMED_ELEMENT_ID:
				return NAMED_ELEMENT_ID_EDEFAULT == null ? namedElementId != null : !NAMED_ELEMENT_ID_EDEFAULT.equals(namedElementId);
			case ScenarioPackage.TEST_SUITE_ITEM__NAMED_ELEMET_NAME:
				return NAMED_ELEMET_NAME_EDEFAULT == null ? namedElemetName != null : !NAMED_ELEMET_NAME_EDEFAULT.equals(namedElemetName);
			case ScenarioPackage.TEST_SUITE_ITEM__KIND:
				return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
			case ScenarioPackage.TEST_SUITE_ITEM__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
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
		result.append(" (NamedElementId: ");
		result.append(namedElementId);
		result.append(", namedElemetName: ");
		result.append(namedElemetName);
		result.append(", kind: ");
		result.append(kind);
		result.append(", path: ");
		result.append(path);
		result.append(')');
		return result.toString();
	}

} //TestSuiteItemImpl
