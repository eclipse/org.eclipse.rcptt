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
package org.eclipse.rcptt.tesla.ecl.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Apply Cell Edit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ApplyCellEdit#isDeactivate <em>Deactivate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getApplyCellEdit()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Applies cell editing.' returns='value of <code>control</code> parameter' example=''"
 * @generated
 */
public interface ApplyCellEdit extends CellEdit {

	/**
	 * Returns the value of the '<em><b>Deactivate</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deactivate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deactivate</em>' attribute.
	 * @see #setDeactivate(boolean)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getApplyCellEdit_Deactivate()
	 * @model default="false"
	 * @generated
	 */
	boolean isDeactivate();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ApplyCellEdit#isDeactivate <em>Deactivate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deactivate</em>' attribute.
	 * @see #isDeactivate()
	 * @generated
	 */
	void setDeactivate(boolean value);
} // ApplyCellEdit
