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
package org.eclipse.rcptt.tesla.core.ui;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Menu Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.MenuItem#getAccelerator <em>Accelerator</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.MenuItem#isCascade <em>Cascade</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getMenuItem()
 * @model
 * @generated
 */
public interface MenuItem extends Item {

	/**
	 * Returns the value of the '<em><b>Accelerator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accelerator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accelerator</em>' attribute.
	 * @see #setAccelerator(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getMenuItem_Accelerator()
	 * @model
	 * @generated
	 */
	String getAccelerator();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.MenuItem#getAccelerator <em>Accelerator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accelerator</em>' attribute.
	 * @see #getAccelerator()
	 * @generated
	 */
	void setAccelerator(String value);

	/**
	 * Returns the value of the '<em><b>Cascade</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cascade</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cascade</em>' attribute.
	 * @see #setCascade(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getMenuItem_Cascade()
	 * @model
	 * @generated
	 */
	boolean isCascade();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.MenuItem#isCascade <em>Cascade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cascade</em>' attribute.
	 * @see #isCascade()
	 * @generated
	 */
	void setCascade(boolean value);
} // MenuItem
