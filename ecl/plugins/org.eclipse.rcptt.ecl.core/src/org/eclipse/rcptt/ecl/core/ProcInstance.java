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
package org.eclipse.rcptt.ecl.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proc Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.ProcInstance#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.core.CorePackage#getProcInstance()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Marker superclass for user-defined procs'"
 *        annotation="http://www.eclipse.org/ecl/internal"
 * @generated
 */
public interface ProcInstance extends Command {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(Proc)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getProcInstance_Definition()
	 * @model annotation="http://www.eclipse.org/ecl/internal"
	 * @generated
	 */
	Proc getDefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.ProcInstance#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(Proc value);

} // ProcInstance
