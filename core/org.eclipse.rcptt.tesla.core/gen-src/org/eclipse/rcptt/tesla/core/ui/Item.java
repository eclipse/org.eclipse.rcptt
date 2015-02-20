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

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Item#getCaption <em>Caption</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Item#isSelection <em>Selection</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Item#isEnablement <em>Enablement</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Item#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Item#getCells <em>Cells</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getItem()
 * @model
 * @generated
 */
public interface Item extends Widget {
	/**
	 * Returns the value of the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Caption</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caption</em>' attribute.
	 * @see #setCaption(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getItem_Caption()
	 * @model
	 * @generated
	 */
	String getCaption();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Item#getCaption <em>Caption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caption</em>' attribute.
	 * @see #getCaption()
	 * @generated
	 */
	void setCaption(String value);

	/**
	 * Returns the value of the '<em><b>Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection</em>' attribute.
	 * @see #setSelection(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getItem_Selection()
	 * @model
	 * @generated
	 */
	boolean isSelection();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Item#isSelection <em>Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection</em>' attribute.
	 * @see #isSelection()
	 * @generated
	 */
	void setSelection(boolean value);

	/**
	 * Returns the value of the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enablement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enablement</em>' attribute.
	 * @see #setEnablement(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getItem_Enablement()
	 * @model
	 * @generated
	 */
	boolean isEnablement();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Item#isEnablement <em>Enablement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enablement</em>' attribute.
	 * @see #isEnablement()
	 * @generated
	 */
	void setEnablement(boolean value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getItem_Index()
	 * @model
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Item#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Cells</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.ui.Cell}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cells</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cells</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getItem_Cells()
	 * @model containment="true"
	 * @generated
	 */
	EList<Cell> getCells();

} // Item
