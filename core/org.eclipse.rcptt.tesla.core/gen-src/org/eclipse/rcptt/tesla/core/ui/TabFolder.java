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
package org.eclipse.rcptt.tesla.core.ui;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tab Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TabFolder#getSelection <em>Selection</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TabFolder#getPages <em>Pages</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TabFolder#getActivePage <em>Active Page</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TabFolder#getTabCount <em>Tab Count</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTabFolder()
 * @model
 * @generated
 */
public interface TabFolder extends Control {
	/**
	 * Returns the value of the '<em><b>Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection</em>' attribute.
	 * @see #setSelection(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTabFolder_Selection()
	 * @model
	 * @generated
	 */
	String getSelection();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.TabFolder#getSelection <em>Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection</em>' attribute.
	 * @see #getSelection()
	 * @generated
	 */
	void setSelection(String value);

	/**
	 * Returns the value of the '<em><b>Pages</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pages</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pages</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTabFolder_Pages()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getPages();

	/**
	 * Returns the value of the '<em><b>Active Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Page</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Page</em>' attribute.
	 * @see #setActivePage(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTabFolder_ActivePage()
	 * @model
	 * @generated
	 */
	String getActivePage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.TabFolder#getActivePage <em>Active Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active Page</em>' attribute.
	 * @see #getActivePage()
	 * @generated
	 */
	void setActivePage(String value);

	/**
	 * Returns the value of the '<em><b>Tab Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tab Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tab Count</em>' attribute.
	 * @see #setTabCount(int)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTabFolder_TabCount()
	 * @model
	 * @generated
	 */
	int getTabCount();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.TabFolder#getTabCount <em>Tab Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tab Count</em>' attribute.
	 * @see #getTabCount()
	 * @generated
	 */
	void setTabCount(int value);

} // TabFolder
