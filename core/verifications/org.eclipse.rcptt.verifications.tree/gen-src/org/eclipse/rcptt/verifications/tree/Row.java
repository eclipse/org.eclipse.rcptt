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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.Row#getValues <em>Values</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.Row#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.Row#isChecked <em>Checked</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.Row#isGrayed <em>Grayed</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.Row#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getRow()
 * @model
 * @generated
 */
public interface Row extends EObject {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.verifications.tree.Cell}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getRow_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<Cell> getValues();

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.verifications.tree.Row}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getRow_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<Row> getChildren();

	/**
	 * Returns the value of the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checked</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checked</em>' attribute.
	 * @see #setChecked(boolean)
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getRow_Checked()
	 * @model required="true"
	 * @generated
	 */
	boolean isChecked();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.Row#isChecked <em>Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checked</em>' attribute.
	 * @see #isChecked()
	 * @generated
	 */
	void setChecked(boolean value);

	/**
	 * Returns the value of the '<em><b>Grayed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grayed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grayed</em>' attribute.
	 * @see #setGrayed(boolean)
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getRow_Grayed()
	 * @model required="true"
	 * @generated
	 */
	boolean isGrayed();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.Row#isGrayed <em>Grayed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grayed</em>' attribute.
	 * @see #isGrayed()
	 * @generated
	 */
	void setGrayed(boolean value);

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
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getRow_Data()
	 * @model containment="true"
	 * @generated
	 */
	ItemData getData();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.Row#getData <em>Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' containment reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(ItemData value);

} // Row
