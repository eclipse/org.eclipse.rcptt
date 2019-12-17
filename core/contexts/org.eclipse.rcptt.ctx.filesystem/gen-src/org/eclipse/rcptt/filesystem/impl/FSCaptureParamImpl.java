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
package org.eclipse.rcptt.filesystem.impl;

import org.eclipse.rcptt.filesystem.FSCaptureParam;
import org.eclipse.rcptt.filesystem.FilesystemPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FS Capture Param</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.filesystem.impl.FSCaptureParamImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.filesystem.impl.FSCaptureParamImpl#isClear <em>Clear</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FSCaptureParamImpl extends EObjectImpl implements FSCaptureParam {
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
	 * The default value of the '{@link #isClear() <em>Clear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClear()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLEAR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isClear() <em>Clear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClear()
	 * @generated
	 * @ordered
	 */
	protected boolean clear = CLEAR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FSCaptureParamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FilesystemPackage.Literals.FS_CAPTURE_PARAM;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FilesystemPackage.FS_CAPTURE_PARAM__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClear() {
		return clear;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClear(boolean newClear) {
		boolean oldClear = clear;
		clear = newClear;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FilesystemPackage.FS_CAPTURE_PARAM__CLEAR, oldClear, clear));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FilesystemPackage.FS_CAPTURE_PARAM__PATH:
				return getPath();
			case FilesystemPackage.FS_CAPTURE_PARAM__CLEAR:
				return isClear();
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
			case FilesystemPackage.FS_CAPTURE_PARAM__PATH:
				setPath((String)newValue);
				return;
			case FilesystemPackage.FS_CAPTURE_PARAM__CLEAR:
				setClear((Boolean)newValue);
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
			case FilesystemPackage.FS_CAPTURE_PARAM__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case FilesystemPackage.FS_CAPTURE_PARAM__CLEAR:
				setClear(CLEAR_EDEFAULT);
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
			case FilesystemPackage.FS_CAPTURE_PARAM__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case FilesystemPackage.FS_CAPTURE_PARAM__CLEAR:
				return clear != CLEAR_EDEFAULT;
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
		result.append(" (path: ");
		result.append(path);
		result.append(", clear: ");
		result.append(clear);
		result.append(')');
		return result.toString();
	}

} //FSCaptureParamImpl
