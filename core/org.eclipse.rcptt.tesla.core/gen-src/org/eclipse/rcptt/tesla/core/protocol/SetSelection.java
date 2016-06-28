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
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetSelection#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetSelection#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetSelection#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetSelection#getAdditionalItems <em>Additional Items</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetSelection#isAll <em>All</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetSelection()
 * @model
 * @generated
 */
public interface SetSelection extends ElementCommand {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetSelection_Path()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getPath();

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetSelection_Pattern()
	 * @model
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetSelection#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetSelection_Index()
	 * @model
	 * @generated
	 */
	Integer getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetSelection#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(Integer value);

	/**
	 * Returns the value of the '<em><b>Additional Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional Items</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetSelection_AdditionalItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<MultiSelectionItem> getAdditionalItems();

	/**
	 * Returns the value of the '<em><b>All</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All</em>' attribute.
	 * @see #setAll(boolean)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetSelection_All()
	 * @model default="false"
	 * @generated
	 */
	boolean isAll();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetSelection#isAll <em>All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>All</em>' attribute.
	 * @see #isAll()
	 * @generated
	 */
	void setAll(boolean value);

} // SetSelection
