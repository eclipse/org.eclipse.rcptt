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
package org.eclipse.rcptt.verifications.log;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.log.LogEntryPredicate#getSeverityMask <em>Severity Mask</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.log.LogEntryPredicate#getCode <em>Code</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.log.LogEntryPredicate#getPluginPattern <em>Plugin Pattern</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.log.LogEntryPredicate#getMessagePattern <em>Message Pattern</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.verifications.log.LogPackage#getLogEntryPredicate()
 * @model
 * @generated
 */
public interface LogEntryPredicate extends EObject {
	/**
	 * Returns the value of the '<em><b>Severity Mask</b></em>' attribute.
	 * The default value is <code>"7"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity Mask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity Mask</em>' attribute.
	 * @see #setSeverityMask(int)
	 * @see org.eclipse.rcptt.verifications.log.LogPackage#getLogEntryPredicate_SeverityMask()
	 * @model default="7"
	 * @generated
	 */
	int getSeverityMask();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.log.LogEntryPredicate#getSeverityMask <em>Severity Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity Mask</em>' attribute.
	 * @see #getSeverityMask()
	 * @generated
	 */
	void setSeverityMask(int value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(int)
	 * @see org.eclipse.rcptt.verifications.log.LogPackage#getLogEntryPredicate_Code()
	 * @model default="0"
	 * @generated
	 */
	int getCode();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.log.LogEntryPredicate#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(int value);

	/**
	 * Returns the value of the '<em><b>Plugin Pattern</b></em>' attribute.
	 * The default value is <code>".*"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin Pattern</em>' attribute.
	 * @see #setPluginPattern(String)
	 * @see org.eclipse.rcptt.verifications.log.LogPackage#getLogEntryPredicate_PluginPattern()
	 * @model default=".*"
	 * @generated
	 */
	String getPluginPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.log.LogEntryPredicate#getPluginPattern <em>Plugin Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin Pattern</em>' attribute.
	 * @see #getPluginPattern()
	 * @generated
	 */
	void setPluginPattern(String value);

	/**
	 * Returns the value of the '<em><b>Message Pattern</b></em>' attribute.
	 * The default value is <code>".*"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Pattern</em>' attribute.
	 * @see #setMessagePattern(String)
	 * @see org.eclipse.rcptt.verifications.log.LogPackage#getLogEntryPredicate_MessagePattern()
	 * @model default=".*"
	 * @generated
	 */
	String getMessagePattern();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.log.LogEntryPredicate#getMessagePattern <em>Message Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Pattern</em>' attribute.
	 * @see #getMessagePattern()
	 * @generated
	 */
	void setMessagePattern(String value);

} // LogEntryPredicate
