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

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.rcptt.ecl.core.impl.CommandImpl;

import org.eclipse.rcptt.tesla.ecl.rap.model.MarkDownloadHandler;
import org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mark Download Handler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.MarkDownloadHandlerImpl#getHandler <em>Handler</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MarkDownloadHandlerImpl extends CommandImpl implements MarkDownloadHandler {
	/**
	 * The cached value of the '{@link #getHandler() <em>Handler</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandler()
	 * @generated
	 * @ordered
	 */
	protected EList<String> handler;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkDownloadHandlerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RapTeslaPackage.Literals.MARK_DOWNLOAD_HANDLER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getHandler() {
		if (handler == null) {
			handler = new EDataTypeUniqueEList<String>(String.class, this, RapTeslaPackage.MARK_DOWNLOAD_HANDLER__HANDLER);
		}
		return handler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RapTeslaPackage.MARK_DOWNLOAD_HANDLER__HANDLER:
				return getHandler();
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
			case RapTeslaPackage.MARK_DOWNLOAD_HANDLER__HANDLER:
				getHandler().clear();
				getHandler().addAll((Collection<? extends String>)newValue);
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
			case RapTeslaPackage.MARK_DOWNLOAD_HANDLER__HANDLER:
				getHandler().clear();
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
			case RapTeslaPackage.MARK_DOWNLOAD_HANDLER__HANDLER:
				return handler != null && !handler.isEmpty();
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
		result.append(" (handler: ");
		result.append(handler);
		result.append(')');
		return result.toString();
	}

} //MarkDownloadHandlerImpl
