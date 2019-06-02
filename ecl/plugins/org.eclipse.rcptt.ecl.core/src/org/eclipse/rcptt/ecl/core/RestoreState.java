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
package org.eclipse.rcptt.ecl.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Restore State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.RestoreState#getState <em>State</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.core.CorePackage#getRestoreState()
 * @model annotation="http://www.eclipse.org/ecl/internal"
 * @generated
 */
public interface RestoreState extends Command {
	/**
	 * Returns the value of the '<em><b>State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' containment reference.
	 * @see #setState(SessionState)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getRestoreState_State()
	 * @model containment="true"
	 * @generated
	 */
	SessionState getState();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.RestoreState#getState <em>State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' containment reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(SessionState value);

} // RestoreState
