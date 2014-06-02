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
package org.eclipse.rcptt.verifications.tree;

import org.eclipse.rcptt.tesla.core.ui.Color;
import org.eclipse.rcptt.tesla.core.ui.Image;
import org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cell</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.Cell#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.Cell#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getCell()
 * @model
 * @generated
 */
public interface Cell extends EObject {
	/**
	 * Returns the value of the '<em><b>Style</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' containment reference list.
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getCell_Style()
	 * @model containment="true"
	 * @generated
	 */
	EList<StyleRangeEntry> getStyle();

	/**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' containment reference.
	 * @see #setData(ItemData)
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getCell_Data()
	 * @model containment="true"
	 * @generated
	 */
	ItemData getData();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.Cell#getData <em>Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' containment reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(ItemData value);

} // Cell
