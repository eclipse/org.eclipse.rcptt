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

import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;

import org.eclipse.rcptt.ecl.core.ProcessStatus;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.TeslaProcessStatus#getInfo <em>Info</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getTeslaProcessStatus()
 * @model
 * @generated
 */
public interface TeslaProcessStatus extends ProcessStatus {
	/**
	 * Returns the value of the '<em><b>Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Info</em>' containment reference.
	 * @see #setInfo(AdvancedInformation)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getTeslaProcessStatus_Info()
	 * @model containment="true"
	 * @generated
	 */
	AdvancedInformation getInfo();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.TeslaProcessStatus#getInfo <em>Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Info</em>' containment reference.
	 * @see #getInfo()
	 * @generated
	 */
	void setInfo(AdvancedInformation value);

} // TeslaProcessStatus
