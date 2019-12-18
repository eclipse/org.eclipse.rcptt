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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bound Control Handle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.BoundControlHandle#getWidgetId <em>Widget Id</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getBoundControlHandle()
 * @model
 * @generated
 */
public interface BoundControlHandle extends ControlHandler {
	/**
	 * Returns the value of the '<em><b>Widget Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget Id</em>' attribute.
	 * @see #setWidgetId(long)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getBoundControlHandle_WidgetId()
	 * @model required="true"
	 * @generated
	 */
	long getWidgetId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.BoundControlHandle#getWidgetId <em>Widget Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Widget Id</em>' attribute.
	 * @see #getWidgetId()
	 * @generated
	 */
	void setWidgetId(long value);

} // BoundControlHandle
