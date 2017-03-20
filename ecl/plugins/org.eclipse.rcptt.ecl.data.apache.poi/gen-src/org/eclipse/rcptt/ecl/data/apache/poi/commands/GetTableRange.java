/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.data.apache.poi.commands;

import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.objects.Table;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Table Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableRange#getTable <em>Table</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableRange#getRange <em>Range</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.CommandsPackage#getGetTableRange()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Gets range by excel name and writes it into the output pipe' returns='<code>Table</code> EMF Object' example='read-excel-file \"workspace:/excel/devices.xlsx\" \"Supported devices\"\n\t| get-table-range \"A2:B4\" | list [get rows] | each [val row] {\n\t\t$row | list [get values] | each [val value] {\n\t\t\tlog $value\n\t\t}\n}'"
 * @generated
 */
public interface GetTableRange extends Command {
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
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.CommandsPackage#getGetTableRange_Table()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Table to get range from'"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableRange#getTable <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

	/**
	 * Returns the value of the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' attribute.
	 * @see #setRange(String)
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.CommandsPackage#getGetTableRange_Range()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Range name in the excel format (for example \"A1:B2\")'"
	 * @generated
	 */
	String getRange();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableRange#getRange <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' attribute.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(String value);

} // GetTableRange
