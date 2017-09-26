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
package org.eclipse.rcptt.core.ecl.core.model;

import org.eclipse.rcptt.core.scenario.Verification;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exec Verification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.ExecVerification#getVerification <em>Verification</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.ExecVerification#getPhase <em>Phase</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getExecVerification()
 * @model
 * @generated
 */
public interface ExecVerification extends Command {
	/**
	 * Returns the value of the '<em><b>Verification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verification</em>' containment reference.
	 * @see #setVerification(Verification)
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getExecVerification_Verification()
	 * @model containment="true"
	 * @generated
	 */
	Verification getVerification();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.ecl.core.model.ExecVerification#getVerification <em>Verification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verification</em>' containment reference.
	 * @see #getVerification()
	 * @generated
	 */
	void setVerification(Verification value);

	/**
	 * Returns the value of the '<em><b>Phase</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phase</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phase</em>' attribute.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase
	 * @see #setPhase(ExecutionPhase)
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getExecVerification_Phase()
	 * @model
	 * @generated
	 */
	ExecutionPhase getPhase();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.ecl.core.model.ExecVerification#getPhase <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phase</em>' attribute.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase
	 * @see #getPhase()
	 * @generated
	 */
	void setPhase(ExecutionPhase value);

} // ExecVerification
