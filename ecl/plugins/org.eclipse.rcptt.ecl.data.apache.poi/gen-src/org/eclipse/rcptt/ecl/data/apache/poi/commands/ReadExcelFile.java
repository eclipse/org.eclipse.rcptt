/**
 */
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
 * @model annotation="http://www.eclipse.org/ecl/docs description='Parses given excel file (xls or xlsx) into tables and write them to output pipe. Fails if file is not found or format is invalid.' returns='List of <code>Table</code> EMF Objects' example='get-view \"Error Log\" | get-tree | expand-all\nget-view \"Error Log\" | get-tree | get-table-data | write-excel-file\n\"workspace:/MyProject/AssertData/table.xls\"\n\nread-excel-file \"workspace:/MyProject/AssertData/table.xls\"\n\t| get-rows-data | each [val item] {\n\t\t$item | get \"Message\" | log\n}'"
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
