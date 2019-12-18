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
package org.eclipse.rcptt.ecl.data.apache.poi.commands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.objects.Table;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Write Excel File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.WriteExcelFile#getTables <em>Tables</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.WriteExcelFile#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.WriteExcelFile#isAppend <em>Append</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.CommandsPackage#getWriteExcelFile()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Writes tables from input pipe to into excel (xls or xlsx) file. Fails if file is not found or format is invalid.' returns='The value of <code>tables</code> argument' example='global [val supportedDevices [list\n\t[list \"Device Name\" \"Device Info\"]\n\t[list \"Device 1\" \"Info 1\"]\n\t[list \"Device 2\" \"Info 2\"]\n\t[list \"Device 3\" \"Info 3\"]\n]]\n\nglobal [val allDevices [list\n\t[list \"Device Name\" \"Device Info\"]\n\t[list \"Device 1\" \"Info 1\"]\n\t[list \"Device 2\" \"Info 2\"]\n\t[list \"Device 3\" \"Info 3\"]\n\t[list \"Device 4\" \"Info 4\"]\n\t[list \"Device 5\" \"Info 5\"]\n]]\n\n\nproc newTable [val table] [val name] {\n\t$table | list-as-table-data | set-page-name $name\n}\n\n\nemit [newTable $supportedDevices \"Supported devices\"] [newTable $allDevices \"All devices\"]\n\t| write-excel-file \"workspace:/excel/devices.xlsx\"'"
 * @generated
 */
public interface WriteExcelFile extends Command {
	/**
	 * Returns the value of the '<em><b>Tables</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.ecl.data.objects.Table}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tables</em>' reference list.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.CommandsPackage#getWriteExcelFile_Tables()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Tables to write'"
	 * @generated
	 */
	EList<Table> getTables();

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
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.CommandsPackage#getWriteExcelFile_Uri()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='URI to write Excel data to. Currently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system'"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.WriteExcelFile#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Append</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Append</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Append</em>' attribute.
	 * @see #setAppend(boolean)
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.CommandsPackage#getWriteExcelFile_Append()
	 * @model default="false"
	 * @generated
	 */
	boolean isAppend();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.WriteExcelFile#isAppend <em>Append</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Append</em>' attribute.
	 * @see #isAppend()
	 * @generated
	 */
	void setAppend(boolean value);

} // WriteExcelFile
