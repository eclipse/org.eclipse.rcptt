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
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set SWT Dialog Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetSWTDialogInfo#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetSWTDialogInfo#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetSWTDialogInfo()
 * @model
 * @generated
 */
public interface SetSWTDialogInfo extends Command {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.tesla.core.protocol.SWTDialogKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SWTDialogKind
	 * @see #setKind(SWTDialogKind)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetSWTDialogInfo_Kind()
	 * @model
	 * @generated
	 */
	SWTDialogKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetSWTDialogInfo#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SWTDialogKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(SWTDialogKind value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetSWTDialogInfo_Path()
	 * @model
	 * @generated
	 */
	EList<String> getPath();

} // SetSWTDialogInfo
