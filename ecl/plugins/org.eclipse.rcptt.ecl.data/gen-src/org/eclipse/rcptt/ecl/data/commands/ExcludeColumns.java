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
package org.eclipse.rcptt.ecl.data.commands;



import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.objects.Table;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exclude Columns</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.ExcludeColumns#getTable <em>Table</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.ExcludeColumns#getColumns <em>Columns</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getExcludeColumns()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Takes a table from input and returns the same table which has some columns excluded. ' returns='Copy of input table object without columns with names listed in <code>columns</code>' example='get-view \"Error Log\" | get-tree | get-table-data | exclude-columns \"Message\" \"Plug-in\" | write-csv-file \"workspace:/MyProject/AssertData/table.csv\"'"
 * @generated
 */
public interface ExcludeColumns extends Command {
	/**
	 * Returns the value of the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' reference.
	 * @see #setTable(Table)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getExcludeColumns_Table()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Table to exclude columns from'"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.ExcludeColumns#getTable <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

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
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getExcludeColumns_Columns()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Column names to exclude from table. It is OK to pass column names which are not present in table'"
	 * @generated
	 */
	EList<String> getColumns();

} // ExcludeColumns
