/*******************************************************************************
 * Copyright (c) 2009, 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Items Response</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.GetItemsResponse#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getGetItemsResponse()
 * @model
 * @generated
 */
public interface GetItemsResponse extends Response {
	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getGetItemsResponse_Result()
	 * @model
	 * @generated
	 */
	EList<String> getResult();

} // GetItemsResponse
