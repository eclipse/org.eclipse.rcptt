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
 * A representation of the model object '<em><b>Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Composite#getChildCount <em>Child Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getComposite()
 * @model
 * @generated
 */
public interface Composite extends Control {
	/**
	 * Returns the value of the '<em><b>Child Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Count</em>' attribute.
	 * @see #setChildCount(int)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getComposite_ChildCount()
	 * @model
	 * @generated
	 */
	int getChildCount();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Composite#getChildCount <em>Child Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child Count</em>' attribute.
	 * @see #getChildCount()
	 * @generated
	 */
	void setChildCount(int value);

} // Composite
