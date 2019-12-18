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
package org.eclipse.rcptt.tesla.core.ui;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Viewer Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.ViewerColumn#isResizable <em>Resizable</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.ViewerColumn#isMovable <em>Movable</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.ViewerColumn#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.ViewerColumn#getTooltip <em>Tooltip</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getViewerColumn()
 * @model
 * @generated
 */
public interface ViewerColumn extends Item {
	/**
	 * Returns the value of the '<em><b>Resizable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resizable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resizable</em>' attribute.
	 * @see #setResizable(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getViewerColumn_Resizable()
	 * @model
	 * @generated
	 */
	boolean isResizable();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.ViewerColumn#isResizable <em>Resizable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resizable</em>' attribute.
	 * @see #isResizable()
	 * @generated
	 */
	void setResizable(boolean value);

	/**
	 * Returns the value of the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Movable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Movable</em>' attribute.
	 * @see #setMovable(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getViewerColumn_Movable()
	 * @model
	 * @generated
	 */
	boolean isMovable();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.ViewerColumn#isMovable <em>Movable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Movable</em>' attribute.
	 * @see #isMovable()
	 * @generated
	 */
	void setMovable(boolean value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getViewerColumn_Width()
	 * @model
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.ViewerColumn#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>Tooltip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tooltip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tooltip</em>' attribute.
	 * @see #setTooltip(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getViewerColumn_Tooltip()
	 * @model
	 * @generated
	 */
	String getTooltip();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.ViewerColumn#getTooltip <em>Tooltip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tooltip</em>' attribute.
	 * @see #getTooltip()
	 * @generated
	 */
	void setTooltip(String value);

} // ViewerColumn
