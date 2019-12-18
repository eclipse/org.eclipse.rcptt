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
package org.eclipse.rcptt.tesla.ecl.model;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>From Raw Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.FromRawKey#getMask <em>Mask</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.FromRawKey#getKeyCode <em>Key Code</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.FromRawKey#getMeta <em>Meta</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getFromRawKey()
 * @model annotation="http://www.eclipse.org/ecl/internal"
 * @generated
 */
public interface FromRawKey extends Command {
	/**
	 * Returns the value of the '<em><b>Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mask</em>' attribute.
	 * @see #setMask(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getFromRawKey_Mask()
	 * @model
	 * @generated
	 */
	Integer getMask();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.FromRawKey#getMask <em>Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mask</em>' attribute.
	 * @see #getMask()
	 * @generated
	 */
	void setMask(Integer value);

	/**
	 * Returns the value of the '<em><b>Key Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Code</em>' attribute.
	 * @see #setKeyCode(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getFromRawKey_KeyCode()
	 * @model
	 * @generated
	 */
	Integer getKeyCode();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.FromRawKey#getKeyCode <em>Key Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Code</em>' attribute.
	 * @see #getKeyCode()
	 * @generated
	 */
	void setKeyCode(Integer value);

	/**
	 * Returns the value of the '<em><b>Meta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta</em>' attribute.
	 * @see #setMeta(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getFromRawKey_Meta()
	 * @model
	 * @generated
	 */
	Integer getMeta();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.FromRawKey#getMeta <em>Meta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta</em>' attribute.
	 * @see #getMeta()
	 * @generated
	 */
	void setMeta(Integer value);

} // FromRawKey
