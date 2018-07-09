/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.verifications.log;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.core.scenario.Verification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Log Verification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.log.ErrorLogVerification#getAllowed <em>Allowed</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.log.ErrorLogVerification#getDenied <em>Denied</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.log.ErrorLogVerification#getRequired <em>Required</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.log.ErrorLogVerification#isIncludeContexts <em>Include Contexts</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.verifications.log.LogPackage#getErrorLogVerification()
 * @model
 * @generated
 */
public interface ErrorLogVerification extends Verification {
	/**
	 * Returns the value of the '<em><b>Allowed</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.verifications.log.LogEntryPredicate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allowed</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allowed</em>' containment reference list.
	 * @see org.eclipse.rcptt.verifications.log.LogPackage#getErrorLogVerification_Allowed()
	 * @model containment="true"
	 * @generated
	 */
	EList<LogEntryPredicate> getAllowed();

	/**
	 * Returns the value of the '<em><b>Denied</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.verifications.log.LogEntryPredicate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Denied</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Denied</em>' containment reference list.
	 * @see org.eclipse.rcptt.verifications.log.LogPackage#getErrorLogVerification_Denied()
	 * @model containment="true"
	 * @generated
	 */
	EList<LogEntryPredicate> getDenied();

	/**
	 * Returns the value of the '<em><b>Required</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.verifications.log.LogEntryPredicate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' containment reference list.
	 * @see org.eclipse.rcptt.verifications.log.LogPackage#getErrorLogVerification_Required()
	 * @model containment="true"
	 * @generated
	 */
	EList<LogEntryPredicate> getRequired();

	/**
	 * Returns the value of the '<em><b>Include Contexts</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include Contexts</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include Contexts</em>' attribute.
	 * @see #setIncludeContexts(boolean)
	 * @see org.eclipse.rcptt.verifications.log.LogPackage#getErrorLogVerification_IncludeContexts()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isIncludeContexts();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.log.ErrorLogVerification#isIncludeContexts <em>Include Contexts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include Contexts</em>' attribute.
	 * @see #isIncludeContexts()
	 * @generated
	 */
	void setIncludeContexts(boolean value);

} // ErrorLogVerification
