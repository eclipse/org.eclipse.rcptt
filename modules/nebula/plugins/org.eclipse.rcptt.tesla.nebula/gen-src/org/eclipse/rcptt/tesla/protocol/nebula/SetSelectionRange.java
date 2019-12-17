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
package org.eclipse.rcptt.tesla.protocol.nebula;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.tesla.core.protocol.SetSelection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Selection Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange#getToPath <em>To Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage#getSetSelectionRange()
 * @model
 * @generated
 */
public interface SetSelectionRange extends SetSelection {
	/**
	 * Returns the value of the '<em><b>To Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Path</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Path</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage#getSetSelectionRange_ToPath()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getToPath();

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(MultiSelectionItemEx)
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage#getSetSelectionRange_From()
	 * @model
	 * @generated
	 */
	MultiSelectionItemEx getFrom();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(MultiSelectionItemEx value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(MultiSelectionItemEx)
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage#getSetSelectionRange_To()
	 * @model
	 * @generated
	 */
	MultiSelectionItemEx getTo();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.protocol.nebula.SetSelectionRange#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(MultiSelectionItemEx value);

} // SetSelectionRange
