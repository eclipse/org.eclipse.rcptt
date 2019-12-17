/*******************************************************************************
 * Copyright (c) 2014-2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.tesla.core.protocol.diagram;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Figure Response</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigureResponse#getFigure <em>Figure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getCreateFigureResponse()
 * @model
 * @generated
 */
public interface CreateFigureResponse extends Response {
	/**
	 * Returns the value of the '<em><b>Figure</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.protocol.raw.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Figure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Figure</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getCreateFigureResponse_Figure()
	 * @model containment="true"
	 * @generated
	 */
	EList<Element> getFigure();

} // CreateFigureResponse
