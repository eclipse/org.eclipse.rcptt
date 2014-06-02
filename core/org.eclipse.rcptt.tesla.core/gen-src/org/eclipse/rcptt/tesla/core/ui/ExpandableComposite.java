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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expandable Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.ExpandableComposite#getCaption <em>Caption</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.ExpandableComposite#isExpanded <em>Expanded</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getExpandableComposite()
 * @model
 * @generated
 */
public interface ExpandableComposite extends Composite {
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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getExpandableComposite_Caption()
	 * @model
	 * @generated
	 */
	String getCaption();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.ExpandableComposite#getCaption <em>Caption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caption</em>' attribute.
	 * @see #getCaption()
	 * @generated
	 */
	void setCaption(String value);

	/**
	 * Returns the value of the '<em><b>Expanded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expanded</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expanded</em>' attribute.
	 * @see #setExpanded(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getExpandableComposite_Expanded()
	 * @model
	 * @generated
	 */
	boolean isExpanded();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.ExpandableComposite#isExpanded <em>Expanded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expanded</em>' attribute.
	 * @see #isExpanded()
	 * @generated
	 */
	void setExpanded(boolean value);

} // ExpandableComposite
