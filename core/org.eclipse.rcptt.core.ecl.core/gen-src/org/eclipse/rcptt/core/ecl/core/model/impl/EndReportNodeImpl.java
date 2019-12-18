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
package org.eclipse.rcptt.core.ecl.core.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.rcptt.ecl.core.impl.CommandImpl;

import org.eclipse.rcptt.core.ecl.core.model.EndReportNode;
import org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage;
import org.eclipse.rcptt.ecl.core.ProcessStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End Report Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.impl.EndReportNodeImpl#getSnaphots <em>Snaphots</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.impl.EndReportNodeImpl#isTakeSnaphots <em>Take Snaphots</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.impl.EndReportNodeImpl#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EndReportNodeImpl extends CommandImpl implements EndReportNode {
	/**
	 * The cached value of the '{@link #getSnaphots() <em>Snaphots</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnaphots()
	 * @generated
	 * @ordered
	 */
	protected EList<String> snaphots;

	/**
	 * The default value of the '{@link #isTakeSnaphots() <em>Take Snaphots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTakeSnaphots()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TAKE_SNAPHOTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTakeSnaphots() <em>Take Snaphots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTakeSnaphots()
	 * @generated
	 * @ordered
	 */
	protected boolean takeSnaphots = TAKE_SNAPHOTS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected ProcessStatus result;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndReportNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Q7CorePackage.Literals.END_REPORT_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSnaphots() {
		if (snaphots == null) {
			snaphots = new EDataTypeUniqueEList<String>(String.class, this, Q7CorePackage.END_REPORT_NODE__SNAPHOTS);
		}
		return snaphots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTakeSnaphots() {
		return takeSnaphots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTakeSnaphots(boolean newTakeSnaphots) {
		boolean oldTakeSnaphots = takeSnaphots;
		takeSnaphots = newTakeSnaphots;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Q7CorePackage.END_REPORT_NODE__TAKE_SNAPHOTS, oldTakeSnaphots, takeSnaphots));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessStatus getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResult(ProcessStatus newResult, NotificationChain msgs) {
		ProcessStatus oldResult = result;
		result = newResult;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Q7CorePackage.END_REPORT_NODE__RESULT, oldResult, newResult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(ProcessStatus newResult) {
		if (newResult != result) {
			NotificationChain msgs = null;
			if (result != null)
				msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Q7CorePackage.END_REPORT_NODE__RESULT, null, msgs);
			if (newResult != null)
				msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Q7CorePackage.END_REPORT_NODE__RESULT, null, msgs);
			msgs = basicSetResult(newResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Q7CorePackage.END_REPORT_NODE__RESULT, newResult, newResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Q7CorePackage.END_REPORT_NODE__RESULT:
				return basicSetResult(null, msgs);
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
			case Q7CorePackage.END_REPORT_NODE__SNAPHOTS:
				return getSnaphots();
			case Q7CorePackage.END_REPORT_NODE__TAKE_SNAPHOTS:
				return isTakeSnaphots();
			case Q7CorePackage.END_REPORT_NODE__RESULT:
				return getResult();
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
			case Q7CorePackage.END_REPORT_NODE__SNAPHOTS:
				getSnaphots().clear();
				getSnaphots().addAll((Collection<? extends String>)newValue);
				return;
			case Q7CorePackage.END_REPORT_NODE__TAKE_SNAPHOTS:
				setTakeSnaphots((Boolean)newValue);
				return;
			case Q7CorePackage.END_REPORT_NODE__RESULT:
				setResult((ProcessStatus)newValue);
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
			case Q7CorePackage.END_REPORT_NODE__SNAPHOTS:
				getSnaphots().clear();
				return;
			case Q7CorePackage.END_REPORT_NODE__TAKE_SNAPHOTS:
				setTakeSnaphots(TAKE_SNAPHOTS_EDEFAULT);
				return;
			case Q7CorePackage.END_REPORT_NODE__RESULT:
				setResult((ProcessStatus)null);
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
			case Q7CorePackage.END_REPORT_NODE__SNAPHOTS:
				return snaphots != null && !snaphots.isEmpty();
			case Q7CorePackage.END_REPORT_NODE__TAKE_SNAPHOTS:
				return takeSnaphots != TAKE_SNAPHOTS_EDEFAULT;
			case Q7CorePackage.END_REPORT_NODE__RESULT:
				return result != null;
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
		result.append(" (snaphots: ");
		result.append(snaphots);
		result.append(", takeSnaphots: ");
		result.append(takeSnaphots);
		result.append(')');
		return result.toString();
	}

} //EndReportNodeImpl
