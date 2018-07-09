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
 * A representation of the model object '<em><b>Tree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Tree#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Tree#isLinesVisible <em>Lines Visible</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Tree#getSelection <em>Selection</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Tree#isMultiSelection <em>Multi Selection</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Tree#isHeaderVisible <em>Header Visible</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Tree#getItemCount <em>Item Count</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTree()
 * @model
 * @generated
 */
public interface Tree extends Control {
	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.ui.ViewerColumn}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTree_Columns()
	 * @model containment="true"
	 * @generated
	 */
	EList<ViewerColumn> getColumns();

	/**
	 * Returns the value of the '<em><b>Lines Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lines Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lines Visible</em>' attribute.
	 * @see #setLinesVisible(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTree_LinesVisible()
	 * @model
	 * @generated
	 */
	boolean isLinesVisible();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Tree#isLinesVisible <em>Lines Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lines Visible</em>' attribute.
	 * @see #isLinesVisible()
	 * @generated
	 */
	void setLinesVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>Selection</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.ui.Selection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTree_Selection()
	 * @model containment="true"
	 * @generated
	 */
	EList<Selection> getSelection();

	/**
	 * Returns the value of the '<em><b>Multi Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi Selection</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Selection</em>' attribute.
	 * @see #setMultiSelection(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTree_MultiSelection()
	 * @model
	 * @generated
	 */
	boolean isMultiSelection();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Tree#isMultiSelection <em>Multi Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multi Selection</em>' attribute.
	 * @see #isMultiSelection()
	 * @generated
	 */
	void setMultiSelection(boolean value);

	/**
	 * Returns the value of the '<em><b>Header Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header Visible</em>' attribute.
	 * @see #setHeaderVisible(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTree_HeaderVisible()
	 * @model
	 * @generated
	 */
	boolean isHeaderVisible();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Tree#isHeaderVisible <em>Header Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header Visible</em>' attribute.
	 * @see #isHeaderVisible()
	 * @generated
	 */
	void setHeaderVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>Item Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item Count</em>' attribute.
	 * @see #setItemCount(int)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTree_ItemCount()
	 * @model
	 * @generated
	 */
	int getItemCount();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Tree#getItemCount <em>Item Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item Count</em>' attribute.
	 * @see #getItemCount()
	 * @generated
	 */
	void setItemCount(int value);

} // Tree
