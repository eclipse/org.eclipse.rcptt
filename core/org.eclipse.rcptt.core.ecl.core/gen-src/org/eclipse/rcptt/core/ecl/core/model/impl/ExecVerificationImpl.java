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

import org.eclipse.rcptt.core.scenario.Verification;

import org.eclipse.rcptt.core.ecl.core.model.ExecVerification;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.rcptt.ecl.core.impl.CommandImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exec Verification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.impl.ExecVerificationImpl#getVerification <em>Verification</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.impl.ExecVerificationImpl#getPhase <em>Phase</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecVerificationImpl extends CommandImpl implements ExecVerification {
	/**
	 * The cached value of the '{@link #getVerification() <em>Verification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerification()
	 * @generated
	 * @ordered
	 */
	protected Verification verification;

	/**
	 * The default value of the '{@link #getPhase() <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhase()
	 * @generated
	 * @ordered
	 */
	protected static final ExecutionPhase PHASE_EDEFAULT = ExecutionPhase.AUTO;
	/**
	 * The cached value of the '{@link #getPhase() <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPhase()
	 * @generated
	 * @ordered
	 */
	protected ExecutionPhase phase = PHASE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecVerificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Q7CorePackage.Literals.EXEC_VERIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Verification getVerification() {
		return verification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVerification(Verification newVerification, NotificationChain msgs) {
		Verification oldVerification = verification;
		verification = newVerification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Q7CorePackage.EXEC_VERIFICATION__VERIFICATION, oldVerification, newVerification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerification(Verification newVerification) {
		if (newVerification != verification) {
			NotificationChain msgs = null;
			if (verification != null)
				msgs = ((InternalEObject)verification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Q7CorePackage.EXEC_VERIFICATION__VERIFICATION, null, msgs);
			if (newVerification != null)
				msgs = ((InternalEObject)newVerification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Q7CorePackage.EXEC_VERIFICATION__VERIFICATION, null, msgs);
			msgs = basicSetVerification(newVerification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Q7CorePackage.EXEC_VERIFICATION__VERIFICATION, newVerification, newVerification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionPhase getPhase() {
		return phase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPhase(ExecutionPhase newPhase) {
		ExecutionPhase oldPhase = phase;
		phase = newPhase == null ? PHASE_EDEFAULT : newPhase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Q7CorePackage.EXEC_VERIFICATION__PHASE, oldPhase, phase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Q7CorePackage.EXEC_VERIFICATION__VERIFICATION:
				return basicSetVerification(null, msgs);
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
			case Q7CorePackage.EXEC_VERIFICATION__VERIFICATION:
				return getVerification();
			case Q7CorePackage.EXEC_VERIFICATION__PHASE:
				return getPhase();
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
			case Q7CorePackage.EXEC_VERIFICATION__VERIFICATION:
				setVerification((Verification)newValue);
				return;
			case Q7CorePackage.EXEC_VERIFICATION__PHASE:
				setPhase((ExecutionPhase)newValue);
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
			case Q7CorePackage.EXEC_VERIFICATION__VERIFICATION:
				setVerification((Verification)null);
				return;
			case Q7CorePackage.EXEC_VERIFICATION__PHASE:
				setPhase(PHASE_EDEFAULT);
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
			case Q7CorePackage.EXEC_VERIFICATION__VERIFICATION:
				return verification != null;
			case Q7CorePackage.EXEC_VERIFICATION__PHASE:
				return phase != PHASE_EDEFAULT;
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
		result.append(" (phase: ");
		result.append(phase);
		result.append(')');
		return result.toString();
	}

} //ExecVerificationImpl
