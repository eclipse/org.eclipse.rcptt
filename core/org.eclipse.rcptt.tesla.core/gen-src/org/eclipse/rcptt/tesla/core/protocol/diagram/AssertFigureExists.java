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

import org.eclipse.rcptt.tesla.core.protocol.ElementCommand;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assert Figure Exists</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.AssertFigureExists#getPartPath <em>Part Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.AssertFigureExists#getFigureID <em>Figure ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getAssertFigureExists()
 * @model
 * @generated
 */
public interface AssertFigureExists extends ElementCommand {
	/**
	 * Returns the value of the '<em><b>Part Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Path</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Path</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getAssertFigureExists_PartPath()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getPartPath();

	/**
	 * Returns the value of the '<em><b>Figure ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Figure ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Figure ID</em>' attribute.
	 * @see #setFigureID(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getAssertFigureExists_FigureID()
	 * @model
	 * @generated
	 */
	String getFigureID();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.AssertFigureExists#getFigureID <em>Figure ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Figure ID</em>' attribute.
	 * @see #getFigureID()
	 * @generated
	 */
	void setFigureID(String value);

} // AssertFigureExists
