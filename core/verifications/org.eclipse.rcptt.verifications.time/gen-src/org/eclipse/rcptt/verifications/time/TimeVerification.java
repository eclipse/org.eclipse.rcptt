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
package org.eclipse.rcptt.verifications.time;

import org.eclipse.rcptt.core.scenario.Verification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.time.TimeVerification#getMinutes <em>Minutes</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.time.TimeVerification#getSeconds <em>Seconds</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.time.TimeVerification#isIncludeContexts <em>Include Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.verifications.time.TimePackage#getTimeVerification()
 * @model
 * @generated
 */
public interface TimeVerification extends Verification {

	/**
	 * Returns the value of the '<em><b>Minutes</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minutes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minutes</em>' attribute.
	 * @see #setMinutes(int)
	 * @see org.eclipse.rcptt.verifications.time.TimePackage#getTimeVerification_Minutes()
	 * @model default="1" required="true"
	 * @generated
	 */
	int getMinutes();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.time.TimeVerification#getMinutes <em>Minutes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minutes</em>' attribute.
	 * @see #getMinutes()
	 * @generated
	 */
	void setMinutes(int value);

	/**
	 * Returns the value of the '<em><b>Seconds</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seconds</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seconds</em>' attribute.
	 * @see #setSeconds(int)
	 * @see org.eclipse.rcptt.verifications.time.TimePackage#getTimeVerification_Seconds()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getSeconds();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.time.TimeVerification#getSeconds <em>Seconds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seconds</em>' attribute.
	 * @see #getSeconds()
	 * @generated
	 */
	void setSeconds(int value);

	/**
	 * Returns the value of the '<em><b>Include Contexts</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include Contexts</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include Contexts</em>' attribute.
	 * @see #setIncludeContexts(boolean)
	 * @see org.eclipse.rcptt.verifications.time.TimePackage#getTimeVerification_IncludeContexts()
	 * @model required="true"
	 * @generated
	 */
	boolean isIncludeContexts();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.time.TimeVerification#isIncludeContexts <em>Include Contexts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include Contexts</em>' attribute.
	 * @see #isIncludeContexts()
	 * @generated
	 */
	void setIncludeContexts(boolean value);
} // TimeVerification
