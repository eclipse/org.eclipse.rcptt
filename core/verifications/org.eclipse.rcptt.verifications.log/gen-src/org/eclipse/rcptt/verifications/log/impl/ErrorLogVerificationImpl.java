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
package org.eclipse.rcptt.verifications.log.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.rcptt.core.scenario.impl.VerificationImpl;

import org.eclipse.rcptt.verifications.log.ErrorLogVerification;
import org.eclipse.rcptt.verifications.log.LogEntryPredicate;
import org.eclipse.rcptt.verifications.log.LogPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Log Verification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.log.impl.ErrorLogVerificationImpl#getAllowed <em>Allowed</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.log.impl.ErrorLogVerificationImpl#getDenied <em>Denied</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.log.impl.ErrorLogVerificationImpl#getRequired <em>Required</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorLogVerificationImpl extends VerificationImpl implements ErrorLogVerification {
	/**
	 * The cached value of the '{@link #getAllowed() <em>Allowed</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllowed()
	 * @generated
	 * @ordered
	 */
	protected EList<LogEntryPredicate> allowed;

	/**
	 * The cached value of the '{@link #getDenied() <em>Denied</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDenied()
	 * @generated
	 * @ordered
	 */
	protected EList<LogEntryPredicate> denied;

	/**
	 * The cached value of the '{@link #getRequired() <em>Required</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequired()
	 * @generated
	 * @ordered
	 */
	protected EList<LogEntryPredicate> required;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorLogVerificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.ERROR_LOG_VERIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LogEntryPredicate> getAllowed() {
		if (allowed == null) {
			allowed = new EObjectContainmentEList<LogEntryPredicate>(LogEntryPredicate.class, this, LogPackage.ERROR_LOG_VERIFICATION__ALLOWED);
		}
		return allowed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LogEntryPredicate> getDenied() {
		if (denied == null) {
			denied = new EObjectContainmentEList<LogEntryPredicate>(LogEntryPredicate.class, this, LogPackage.ERROR_LOG_VERIFICATION__DENIED);
		}
		return denied;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LogEntryPredicate> getRequired() {
		if (required == null) {
			required = new EObjectContainmentEList<LogEntryPredicate>(LogEntryPredicate.class, this, LogPackage.ERROR_LOG_VERIFICATION__REQUIRED);
		}
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LogPackage.ERROR_LOG_VERIFICATION__ALLOWED:
				return ((InternalEList<?>)getAllowed()).basicRemove(otherEnd, msgs);
			case LogPackage.ERROR_LOG_VERIFICATION__DENIED:
				return ((InternalEList<?>)getDenied()).basicRemove(otherEnd, msgs);
			case LogPackage.ERROR_LOG_VERIFICATION__REQUIRED:
				return ((InternalEList<?>)getRequired()).basicRemove(otherEnd, msgs);
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
			case LogPackage.ERROR_LOG_VERIFICATION__ALLOWED:
				return getAllowed();
			case LogPackage.ERROR_LOG_VERIFICATION__DENIED:
				return getDenied();
			case LogPackage.ERROR_LOG_VERIFICATION__REQUIRED:
				return getRequired();
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
			case LogPackage.ERROR_LOG_VERIFICATION__ALLOWED:
				getAllowed().clear();
				getAllowed().addAll((Collection<? extends LogEntryPredicate>)newValue);
				return;
			case LogPackage.ERROR_LOG_VERIFICATION__DENIED:
				getDenied().clear();
				getDenied().addAll((Collection<? extends LogEntryPredicate>)newValue);
				return;
			case LogPackage.ERROR_LOG_VERIFICATION__REQUIRED:
				getRequired().clear();
				getRequired().addAll((Collection<? extends LogEntryPredicate>)newValue);
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
			case LogPackage.ERROR_LOG_VERIFICATION__ALLOWED:
				getAllowed().clear();
				return;
			case LogPackage.ERROR_LOG_VERIFICATION__DENIED:
				getDenied().clear();
				return;
			case LogPackage.ERROR_LOG_VERIFICATION__REQUIRED:
				getRequired().clear();
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
			case LogPackage.ERROR_LOG_VERIFICATION__ALLOWED:
				return allowed != null && !allowed.isEmpty();
			case LogPackage.ERROR_LOG_VERIFICATION__DENIED:
				return denied != null && !denied.isEmpty();
			case LogPackage.ERROR_LOG_VERIFICATION__REQUIRED:
				return required != null && !required.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ErrorLogVerificationImpl
