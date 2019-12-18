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
package org.eclipse.rcptt.verifications.tree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.Tree#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.Tree#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.Tree#getRows <em>Rows</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.Tree#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.Tree#isHeaderVisible <em>Header Visible</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.Tree#isLinesVisible <em>Lines Visible</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.Tree#getSortColumnInd <em>Sort Column Ind</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.Tree#getSortDirection <em>Sort Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getTree()
 * @model
 * @generated
 */
public interface Tree extends EObject {
	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.verifications.tree.Column}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getTree_Columns()
	 * @model containment="true"
	 * @generated
	 */
	EList<Column> getColumns();

	/**
	 * Returns the value of the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' attribute.
	 * @see #setStyle(int)
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getTree_Style()
	 * @model required="true"
	 * @generated
	 */
	int getStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.Tree#getStyle <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' attribute.
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(int value);

	/**
	 * Returns the value of the '<em><b>Rows</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.verifications.tree.Row}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rows</em>' containment reference list.
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getTree_Rows()
	 * @model containment="true"
	 * @generated
	 */
	EList<Row> getRows();

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getTree_Enabled()
	 * @model required="true"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.Tree#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

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
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getTree_HeaderVisible()
	 * @model required="true"
	 * @generated
	 */
	boolean isHeaderVisible();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.Tree#isHeaderVisible <em>Header Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header Visible</em>' attribute.
	 * @see #isHeaderVisible()
	 * @generated
	 */
	void setHeaderVisible(boolean value);

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
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getTree_LinesVisible()
	 * @model required="true"
	 * @generated
	 */
	boolean isLinesVisible();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.Tree#isLinesVisible <em>Lines Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lines Visible</em>' attribute.
	 * @see #isLinesVisible()
	 * @generated
	 */
	void setLinesVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>Sort Column Ind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sort Column Ind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sort Column Ind</em>' attribute.
	 * @see #setSortColumnInd(int)
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getTree_SortColumnInd()
	 * @model
	 * @generated
	 */
	int getSortColumnInd();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.Tree#getSortColumnInd <em>Sort Column Ind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sort Column Ind</em>' attribute.
	 * @see #getSortColumnInd()
	 * @generated
	 */
	void setSortColumnInd(int value);

	/**
	 * Returns the value of the '<em><b>Sort Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sort Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sort Direction</em>' attribute.
	 * @see #setSortDirection(int)
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getTree_SortDirection()
	 * @model
	 * @generated
	 */
	int getSortDirection();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.Tree#getSortDirection <em>Sort Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sort Direction</em>' attribute.
	 * @see #getSortDirection()
	 * @generated
	 */
	void setSortDirection(int value);

} // Tree
