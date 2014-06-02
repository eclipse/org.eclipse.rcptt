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
package org.eclipse.rcptt.ecl.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Global#getVals <em>Vals</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.Global#isOverride <em>Override</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.core.CorePackage#getGlobal()
 * @model
 * @generated
 */
public interface Global extends Command {
	/**
	 * Returns the value of the '<em><b>Vals</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.ecl.core.Declaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vals</em>' containment reference list.
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getGlobal_Vals()
	 * @model containment="true"
	 * @generated
	 */
	EList<Declaration> getVals();

	/**
	 * Returns the value of the '<em><b>Override</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Override</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Override</em>' attribute.
	 * @see #setOverride(boolean)
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getGlobal_Override()
	 * @model default="false"
	 * @generated
	 */
	boolean isOverride();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.core.Global#isOverride <em>Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Override</em>' attribute.
	 * @see #isOverride()
	 * @generated
	 */
	void setOverride(boolean value);

} // Global
