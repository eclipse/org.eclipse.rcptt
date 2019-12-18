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
package org.eclipse.rcptt.tesla.protocol.nebula;

import org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Selection Item Ex</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx#getCellColumn <em>Cell Column</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx#isRowHeader <em>Row Header</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage#getMultiSelectionItemEx()
 * @model
 * @generated
 */
public interface MultiSelectionItemEx extends MultiSelectionItem {
	/**
	 * Returns the value of the '<em><b>Cell Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cell Column</em>' attribute.
	 * @see #setCellColumn(String)
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage#getMultiSelectionItemEx_CellColumn()
	 * @model
	 * @generated
	 */
	String getCellColumn();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx#getCellColumn <em>Cell Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cell Column</em>' attribute.
	 * @see #getCellColumn()
	 * @generated
	 */
	void setCellColumn(String value);

	/**
	 * Returns the value of the '<em><b>Row Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row Header</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row Header</em>' attribute.
	 * @see #setRowHeader(boolean)
	 * @see org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage#getMultiSelectionItemEx_RowHeader()
	 * @model
	 * @generated
	 */
	boolean isRowHeader();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx#isRowHeader <em>Row Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Row Header</em>' attribute.
	 * @see #isRowHeader()
	 * @generated
	 */
	void setRowHeader(boolean value);

} // MultiSelectionItemEx
