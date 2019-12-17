/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.debug.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Skip All Cmd</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.SkipAllCmd#isSkip <em>Skip</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getSkipAllCmd()
 * @model
 * @generated
 */
public interface SkipAllCmd extends DebugCmd {
	/**
	 * Returns the value of the '<em><b>Skip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Skip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Skip</em>' attribute.
	 * @see #setSkip(boolean)
	 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getSkipAllCmd_Skip()
	 * @model
	 * @generated
	 */
	boolean isSkip();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.debug.model.SkipAllCmd#isSkip <em>Skip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skip</em>' attribute.
	 * @see #isSkip()
	 * @generated
	 */
	void setSkip(boolean value);

} // SkipAllCmd
