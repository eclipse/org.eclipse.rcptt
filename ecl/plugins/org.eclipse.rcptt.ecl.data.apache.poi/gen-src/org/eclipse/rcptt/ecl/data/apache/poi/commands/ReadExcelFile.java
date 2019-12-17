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
package org.eclipse.rcptt.ecl.data.apache.poi.commands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Read Excel File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.ReadExcelFile#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.ReadExcelFile#getSheets <em>Sheets</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.CommandsPackage#getReadExcelFile()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Parses given excel file (xls or xlsx) into tables and write them to output pipe. Fails if file is not found or format is invalid.' returns='List of <code>Table</code> EMF Objects' example='global [val devicesInfo [\n\tread-excel-file \"workspace:/excel/devices.xlsx\" \"Supported devices\" \"All devices\"\n\t\t| to-list\n]]\n\n\nclear-log-view\n\n$devicesInfo | each [val table] {\n\tlog [format \"Page name: %s\" [$table | get pageName]]\n\t$table | list [get rows] | each [val row] {\n\t\t$row | list [get values] | each [val value] {\n\t\t\tlog $value\n\t\t}\n\t}\n}\n\nread-excel-file \"workspace:/excel/devices.xlsx\" \"Additional info\"\n\t| get rows | get values | log'"
 * @generated
 */
public interface ReadExcelFile extends Command {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.CommandsPackage#getReadExcelFile_Uri()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='URI to read Excel data from. Currently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system'"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.ReadExcelFile#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Sheets</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sheets</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sheets</em>' attribute list.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.CommandsPackage#getReadExcelFile_Sheets()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='List of Excel sheet names to read data from'"
	 * @generated
	 */
	EList<String> getSheets();

} // ReadExcelFile
