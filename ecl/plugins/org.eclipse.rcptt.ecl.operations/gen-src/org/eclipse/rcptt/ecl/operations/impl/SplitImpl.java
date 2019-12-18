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
package org.eclipse.rcptt.ecl.operations.impl;



import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.rcptt.ecl.core.impl.CommandImpl;
import org.eclipse.rcptt.ecl.operations.OperationsPackage;
import org.eclipse.rcptt.ecl.operations.Split;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Split</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.impl.SplitImpl#getStr <em>Str</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.impl.SplitImpl#getSep <em>Sep</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.impl.SplitImpl#isTrimResults <em>Trim Results</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.impl.SplitImpl#isOmitEmptyStrings <em>Omit Empty Strings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SplitImpl extends CommandImpl implements Split {
	/**
	 * The default value of the '{@link #getStr() <em>Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStr()
	 * @generated
	 * @ordered
	 */
	protected static final String STR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStr() <em>Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStr()
	 * @generated
	 * @ordered
	 */
	protected String str = STR_EDEFAULT;

	/**
	 * The default value of the '{@link #getSep() <em>Sep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSep()
	 * @generated
	 * @ordered
	 */
	protected static final String SEP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSep() <em>Sep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSep()
	 * @generated
	 * @ordered
	 */
	protected String sep = SEP_EDEFAULT;

	/**
	 * The default value of the '{@link #isTrimResults() <em>Trim Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTrimResults()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRIM_RESULTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTrimResults() <em>Trim Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTrimResults()
	 * @generated
	 * @ordered
	 */
	protected boolean trimResults = TRIM_RESULTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isOmitEmptyStrings() <em>Omit Empty Strings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOmitEmptyStrings()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OMIT_EMPTY_STRINGS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOmitEmptyStrings() <em>Omit Empty Strings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOmitEmptyStrings()
	 * @generated
	 * @ordered
	 */
	protected boolean omitEmptyStrings = OMIT_EMPTY_STRINGS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SplitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.SPLIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStr() {
		return str;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStr(String newStr) {
		String oldStr = str;
		str = newStr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.SPLIT__STR, oldStr, str));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSep() {
		return sep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSep(String newSep) {
		String oldSep = sep;
		sep = newSep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.SPLIT__SEP, oldSep, sep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTrimResults() {
		return trimResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrimResults(boolean newTrimResults) {
		boolean oldTrimResults = trimResults;
		trimResults = newTrimResults;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.SPLIT__TRIM_RESULTS, oldTrimResults, trimResults));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOmitEmptyStrings() {
		return omitEmptyStrings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOmitEmptyStrings(boolean newOmitEmptyStrings) {
		boolean oldOmitEmptyStrings = omitEmptyStrings;
		omitEmptyStrings = newOmitEmptyStrings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.SPLIT__OMIT_EMPTY_STRINGS, oldOmitEmptyStrings, omitEmptyStrings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationsPackage.SPLIT__STR:
				return getStr();
			case OperationsPackage.SPLIT__SEP:
				return getSep();
			case OperationsPackage.SPLIT__TRIM_RESULTS:
				return isTrimResults();
			case OperationsPackage.SPLIT__OMIT_EMPTY_STRINGS:
				return isOmitEmptyStrings();
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
			case OperationsPackage.SPLIT__STR:
				setStr((String)newValue);
				return;
			case OperationsPackage.SPLIT__SEP:
				setSep((String)newValue);
				return;
			case OperationsPackage.SPLIT__TRIM_RESULTS:
				setTrimResults((Boolean)newValue);
				return;
			case OperationsPackage.SPLIT__OMIT_EMPTY_STRINGS:
				setOmitEmptyStrings((Boolean)newValue);
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
			case OperationsPackage.SPLIT__STR:
				setStr(STR_EDEFAULT);
				return;
			case OperationsPackage.SPLIT__SEP:
				setSep(SEP_EDEFAULT);
				return;
			case OperationsPackage.SPLIT__TRIM_RESULTS:
				setTrimResults(TRIM_RESULTS_EDEFAULT);
				return;
			case OperationsPackage.SPLIT__OMIT_EMPTY_STRINGS:
				setOmitEmptyStrings(OMIT_EMPTY_STRINGS_EDEFAULT);
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
			case OperationsPackage.SPLIT__STR:
				return STR_EDEFAULT == null ? str != null : !STR_EDEFAULT.equals(str);
			case OperationsPackage.SPLIT__SEP:
				return SEP_EDEFAULT == null ? sep != null : !SEP_EDEFAULT.equals(sep);
			case OperationsPackage.SPLIT__TRIM_RESULTS:
				return trimResults != TRIM_RESULTS_EDEFAULT;
			case OperationsPackage.SPLIT__OMIT_EMPTY_STRINGS:
				return omitEmptyStrings != OMIT_EMPTY_STRINGS_EDEFAULT;
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
		result.append(" (str: ");
		result.append(str);
		result.append(", sep: ");
		result.append(sep);
		result.append(", trimResults: ");
		result.append(trimResults);
		result.append(", omitEmptyStrings: ");
		result.append(omitEmptyStrings);
		result.append(')');
		return result.toString();
	}

} //SplitImpl
