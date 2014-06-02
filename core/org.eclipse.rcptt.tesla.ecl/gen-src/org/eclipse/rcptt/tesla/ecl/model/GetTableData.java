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
 * A representation of the model object '<em><b>Get Table Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetTableData#isIncludeChecked <em>Include Checked</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetTableData#isExcludeHidden <em>Exclude Hidden</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetTableData()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Takes a data from table or tree and returns <code>Table</code> EMF object. When table or tree does not have columns, then it is assumed that there\'s one column named \'text\'.' returns='<code>Table</code> object' recorded='false' example='get-table | get-table-data | write-csv-file \"workspace:/project/file.csv\"'"
 * @generated
 */
public interface GetTableData extends ControlCommand {

	/**
	 * Returns the value of the '<em><b>Include Checked</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include Checked</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include Checked</em>' attribute.
	 * @see #setIncludeChecked(boolean)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetTableData_IncludeChecked()
	 * @model default="false"
	 *        annotation="http://www.eclipse.org/ecl/docs description='When true, adds a column named \'checked\' which contains <code>true</code> or <code>false</code> depending on checked state of row'"
	 * @generated
	 */
	boolean isIncludeChecked();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetTableData#isIncludeChecked <em>Include Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include Checked</em>' attribute.
	 * @see #isIncludeChecked()
	 * @generated
	 */
	void setIncludeChecked(boolean value);

	/**
	 * Returns the value of the '<em><b>Exclude Hidden</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exclude Hidden</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exclude Hidden</em>' attribute.
	 * @see #setExcludeHidden(boolean)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetTableData_ExcludeHidden()
	 * @model default="false"
	 *        annotation="http://www.eclipse.org/ecl/docs description='When true, output table does not include columns with width=0'"
	 * @generated
	 */
	boolean isExcludeHidden();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetTableData#isExcludeHidden <em>Exclude Hidden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exclude Hidden</em>' attribute.
	 * @see #isExcludeHidden()
	 * @generated
	 */
	void setExcludeHidden(boolean value);
} // GetTableData
