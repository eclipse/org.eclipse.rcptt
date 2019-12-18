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
package org.eclipse.rcptt.tesla.ecl.nebula;

import org.eclipse.rcptt.ecl.core.Command;

import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Select Grid Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange#getControl <em>Control</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getSelectGridRange()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Selects item or cell range.' returns='value of <code>control</code> parameter' example='get-nebula-grid | select \"From Item\" \"To Item\"\nget-nebula-grid | select [get-item \"From Item\" | get-item-cell -column \"Col1\"] [get-item \"To Item\" | get-item-cell -column \"Col2\"]'"
 * @generated
 */
public interface SelectGridRange extends Command {
	/**
	 * Returns the value of the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Control</em>' reference.
	 * @see #setControl(ControlHandler)
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getSelectGridRange_Control()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Nebula Grid.'"
	 * @generated
	 */
	ControlHandler getControl();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange#getControl <em>Control</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control</em>' reference.
	 * @see #getControl()
	 * @generated
	 */
	void setControl(ControlHandler value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' attribute.
	 * @see #setFrom(Object)
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getSelectGridRange_From()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Path of item of item cell from where the selection begins.'"
	 *        annotation="http://www.eclipse.org/ecl/meta type='string | org.eclipse.rcptt.tesla.ecl.model.ControlHandler'"
	 * @generated
	 */
	Object getFrom();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange#getFrom <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' attribute.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(Object value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' attribute.
	 * @see #setTo(Object)
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getSelectGridRange_To()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Path of item or item cell where the selection ends.'"
	 *        annotation="http://www.eclipse.org/ecl/meta type='string | org.eclipse.rcptt.tesla.ecl.model.ControlHandler'"
	 * @generated
	 */
	Object getTo();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.nebula.SelectGridRange#getTo <em>To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' attribute.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(Object value);

} // SelectGridRange
