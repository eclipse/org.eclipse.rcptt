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
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportPackage;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.PropertyMapImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End Report Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.impl.EndReportNodeImpl#getSnaphots <em>Snaphots</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.impl.EndReportNodeImpl#isTakeSnaphots <em>Take Snaphots</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.impl.EndReportNodeImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
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
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EObject> properties;

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
	public EMap<String, EObject> getProperties() {
		if (properties == null) {
			properties = new EcoreEMap<String,EObject>(ReportPackage.Literals.PROPERTY_MAP, PropertyMapImpl.class, this, Q7CorePackage.END_REPORT_NODE__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Q7CorePackage.END_REPORT_NODE__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
			case Q7CorePackage.END_REPORT_NODE__PROPERTIES:
				if (coreType) return getProperties();
				else return getProperties().map();
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
			case Q7CorePackage.END_REPORT_NODE__PROPERTIES:
				((EStructuralFeature.Setting)getProperties()).set(newValue);
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
			case Q7CorePackage.END_REPORT_NODE__PROPERTIES:
				getProperties().clear();
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
			case Q7CorePackage.END_REPORT_NODE__PROPERTIES:
				return properties != null && !properties.isEmpty();
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
