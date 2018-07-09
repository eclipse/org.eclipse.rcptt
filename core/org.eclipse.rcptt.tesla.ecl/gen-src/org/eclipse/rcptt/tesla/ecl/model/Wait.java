/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.model;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wait</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.Wait#getMs <em>Ms</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getWait()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Suspend execution for a given number of milliseconds.' returns='nothing' recorded='false' example='wait 100'"
 * @generated
 */
public interface Wait extends Command {
	/**
	 * Returns the value of the '<em><b>Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ms</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ms</em>' attribute.
	 * @see #setMs(int)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getWait_Ms()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Number of milliseconds. Must be integer value greater than zero.'"
	 * @generated
	 */
	int getMs();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.Wait#getMs <em>Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ms</em>' attribute.
	 * @see #getMs()
	 * @generated
	 */
	void setMs(int value);

} // Wait
