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
package org.eclipse.rcptt.testrail.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.rcptt.ecl.core.impl.CommandImpl;
import org.eclipse.rcptt.testrail.TestRailPackage;
import org.eclipse.rcptt.testrail.TestRailStep;
import org.eclipse.rcptt.testrail.TestRailStepStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.testrail.impl.TestRailStepImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testrail.impl.TestRailStepImpl#getExpected <em>Expected</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testrail.impl.TestRailStepImpl#getActual <em>Actual</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testrail.impl.TestRailStepImpl#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestRailStepImpl extends CommandImpl implements TestRailStep {
	/**
	 * The default value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected String content = CONTENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpected() <em>Expected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpected()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPECTED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpected() <em>Expected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpected()
	 * @generated
	 * @ordered
	 */
	protected String expected = EXPECTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getActual() <em>Actual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActual()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTUAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActual() <em>Actual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActual()
	 * @generated
	 * @ordered
	 */
	protected String actual = ACTUAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final TestRailStepStatus STATUS_EDEFAULT = TestRailStepStatus.UNTESTED;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected TestRailStepStatus status = STATUS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestRailStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestRailPackage.Literals.TEST_RAIL_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(String newContent) {
		String oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestRailPackage.TEST_RAIL_STEP__CONTENT, oldContent, content));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpected() {
		return expected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpected(String newExpected) {
		String oldExpected = expected;
		expected = newExpected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestRailPackage.TEST_RAIL_STEP__EXPECTED, oldExpected, expected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActual() {
		return actual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActual(String newActual) {
		String oldActual = actual;
		actual = newActual;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestRailPackage.TEST_RAIL_STEP__ACTUAL, oldActual, actual));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRailStepStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(TestRailStepStatus newStatus) {
		TestRailStepStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestRailPackage.TEST_RAIL_STEP__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestRailPackage.TEST_RAIL_STEP__CONTENT:
				return getContent();
			case TestRailPackage.TEST_RAIL_STEP__EXPECTED:
				return getExpected();
			case TestRailPackage.TEST_RAIL_STEP__ACTUAL:
				return getActual();
			case TestRailPackage.TEST_RAIL_STEP__STATUS:
				return getStatus();
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
			case TestRailPackage.TEST_RAIL_STEP__CONTENT:
				setContent((String)newValue);
				return;
			case TestRailPackage.TEST_RAIL_STEP__EXPECTED:
				setExpected((String)newValue);
				return;
			case TestRailPackage.TEST_RAIL_STEP__ACTUAL:
				setActual((String)newValue);
				return;
			case TestRailPackage.TEST_RAIL_STEP__STATUS:
				setStatus((TestRailStepStatus)newValue);
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
			case TestRailPackage.TEST_RAIL_STEP__CONTENT:
				setContent(CONTENT_EDEFAULT);
				return;
			case TestRailPackage.TEST_RAIL_STEP__EXPECTED:
				setExpected(EXPECTED_EDEFAULT);
				return;
			case TestRailPackage.TEST_RAIL_STEP__ACTUAL:
				setActual(ACTUAL_EDEFAULT);
				return;
			case TestRailPackage.TEST_RAIL_STEP__STATUS:
				setStatus(STATUS_EDEFAULT);
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
			case TestRailPackage.TEST_RAIL_STEP__CONTENT:
				return CONTENT_EDEFAULT == null ? content != null : !CONTENT_EDEFAULT.equals(content);
			case TestRailPackage.TEST_RAIL_STEP__EXPECTED:
				return EXPECTED_EDEFAULT == null ? expected != null : !EXPECTED_EDEFAULT.equals(expected);
			case TestRailPackage.TEST_RAIL_STEP__ACTUAL:
				return ACTUAL_EDEFAULT == null ? actual != null : !ACTUAL_EDEFAULT.equals(actual);
			case TestRailPackage.TEST_RAIL_STEP__STATUS:
				return status != STATUS_EDEFAULT;
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
		result.append(" (content: ");
		result.append(content);
		result.append(", expected: ");
		result.append(expected);
		result.append(", actual: ");
		result.append(actual);
		result.append(", status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //TestRailStepImpl
