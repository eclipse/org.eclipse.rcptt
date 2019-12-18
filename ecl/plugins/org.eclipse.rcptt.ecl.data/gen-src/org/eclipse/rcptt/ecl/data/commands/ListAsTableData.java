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
import org.eclipse.rcptt.ecl.core.EclList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List As Table Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.ListAsTableData#getList <em>List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getListAsTableData()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Converts input list to table data format' returns='<code>Table</code> EMF Object' example='proc newTable [val table] [val name] {\n\t$table | list-as-table-data | set-page-name $name\n}\n\nglobal [val devices [list\n\t[list \"Device Name\" \"Device Target\"]\n\t[list \"Device 1\" \"Info 1\"]\n\t[list \"Device 2\" \"Info 2\"]\n\t[list \"Device 3\" \"Info 3\"]\n]]\n\nnewTable $devices \"Devices\"\n\t| write-excel-file \"workspace:/excel/devices.xls\"'"
 * @generated
 */
public interface ListAsTableData extends Command {
	/**
	 * Returns the value of the '<em><b>List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List</em>' reference.
	 * @see #setList(EclList)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getListAsTableData_List()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='List of List of String to convert to Table'"
	 * @generated
	 */
	EclList getList();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.ListAsTableData#getList <em>List</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List</em>' reference.
	 * @see #getList()
	 * @generated
	 */
	void setList(EclList value);

} // ListAsTableData
