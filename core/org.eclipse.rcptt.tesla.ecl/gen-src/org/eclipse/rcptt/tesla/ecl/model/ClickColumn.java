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
package org.eclipse.rcptt.tesla.ecl.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Click Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ClickColumn#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ClickColumn#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getClickColumn()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Clicks on a header of table or tree column. The column is identified by <code>name</code> and <code>index</code>. If name is empty, then column is identified by zero-based index. If there is more than one column with a given name, then <code>index</code> can be used. In this case <code>index</code> is used to identify the column within all other columns with the same name. If there are no columns with given name, then command tries to interpret <code>name</code> as Java regular expression pattern and search for a column. ' returns='<code>Table</code> object or <code>Tree</code> control' recorded='true' example='get-table | click-column Description //clicks on a header of column Description\nget-table | click-column -index 5 //clicks on 6th column header (since index is 0-based)\nget-table | click-column -name \"D.*\" -index 1 //clicks on a second column starting with \"D\" '"
 * @generated
 */
public interface ClickColumn extends ControlCommand {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getClickColumn_Name()
	 * @model annotation="http://www.eclipse.org/ecl/docs desciption='Column name or regular expression pattern. When empty, column is identified by <code>index</code>.'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ClickColumn#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getClickColumn_Index()
	 * @model annotation="http://www.eclipse.org/ecl/docs desciption='Index of a column within all columns matching a given name. When <code>name</code> is empty, this is a column index in table or tree'"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ClickColumn#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

} // ClickColumn
