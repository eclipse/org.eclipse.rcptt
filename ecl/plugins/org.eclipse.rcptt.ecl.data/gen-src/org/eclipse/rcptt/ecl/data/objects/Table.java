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
package org.eclipse.rcptt.ecl.data.objects;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.objects.Table#getRows <em>Rows</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.objects.Table#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.objects.Table#getPageName <em>Page Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.objects.ObjectsPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends EObject {
	/**
	 * Returns the value of the '<em><b>Rows</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.ecl.data.objects.Row}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rows</em>' reference list.
	 * @see org.eclipse.rcptt.ecl.data.objects.ObjectsPackage#getTable_Rows()
	 * @model
	 * @generated
	 */
	EList<Row> getRows();

	/**
	 * Returns the value of the '<em><b>Columns</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' attribute list.
	 * @see org.eclipse.rcptt.ecl.data.objects.ObjectsPackage#getTable_Columns()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getColumns();

	/**
	 * Returns the value of the '<em><b>Page Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Name</em>' attribute.
	 * @see #setPageName(String)
	 * @see org.eclipse.rcptt.ecl.data.objects.ObjectsPackage#getTable_PageName()
	 * @model
	 * @generated
	 */
	String getPageName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.objects.Table#getPageName <em>Page Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Name</em>' attribute.
	 * @see #getPageName()
	 * @generated
	 */
	void setPageName(String value);

} // Table
