/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2016 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.rap.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.rcptt.ecl.core.impl.CommandImpl;

import org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage;
import org.eclipse.rcptt.tesla.ecl.rap.model.TeslaPackage;
import org.eclipse.rcptt.tesla.ecl.rap.model.VerifyDownloadFile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verify Download File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.VerifyDownloadFileImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.VerifyDownloadFileImpl#getHandler <em>Handler</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VerifyDownloadFileImpl extends CommandImpl implements VerifyDownloadFile {
	/**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getHandler() <em>Handler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandler()
	 * @generated
	 * @ordered
	 */
	protected static final String HANDLER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHandler() <em>Handler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandler()
	 * @generated
	 * @ordered
	 */
	protected String handler = HANDLER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VerifyDownloadFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RapTeslaPackage.Literals.VERIFY_DOWNLOAD_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapTeslaPackage.VERIFY_DOWNLOAD_FILE__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHandler() {
		return handler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHandler(String newHandler) {
		String oldHandler = handler;
		handler = newHandler;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapTeslaPackage.VERIFY_DOWNLOAD_FILE__HANDLER, oldHandler, handler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RapTeslaPackage.VERIFY_DOWNLOAD_FILE__URL:
				return getUrl();
			case RapTeslaPackage.VERIFY_DOWNLOAD_FILE__HANDLER:
				return getHandler();
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
			case RapTeslaPackage.VERIFY_DOWNLOAD_FILE__URL:
				setUrl((String)newValue);
				return;
			case RapTeslaPackage.VERIFY_DOWNLOAD_FILE__HANDLER:
				setHandler((String)newValue);
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
			case RapTeslaPackage.VERIFY_DOWNLOAD_FILE__URL:
				setUrl(URL_EDEFAULT);
				return;
			case RapTeslaPackage.VERIFY_DOWNLOAD_FILE__HANDLER:
				setHandler(HANDLER_EDEFAULT);
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
			case RapTeslaPackage.VERIFY_DOWNLOAD_FILE__URL:
				return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
			case RapTeslaPackage.VERIFY_DOWNLOAD_FILE__HANDLER:
				return HANDLER_EDEFAULT == null ? handler != null : !HANDLER_EDEFAULT.equals(handler);
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
		result.append(" (url: ");
		result.append(url);
		result.append(", handler: ");
		result.append(handler);
		result.append(')');
		return result.toString();
	}

} //VerifyDownloadFileImpl
