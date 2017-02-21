/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.data.commands;

import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.objects.Table;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Page Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.GetPageName#getTable <em>Table</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getGetPageName()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Get page name from table' returns='Table page name' example='get-view \"Error Log\" | get-tree | expand-all\nget-view \"Error Log\" | get-tree | get-table-data\n\t| set-page-name \"Table\" | write-excel-file \"workspace:/MyProject/AssertData/table.xls\"\n\nread-excel-file \"workspace:/MyProject/AssertData/table.xls\"\n\t| get-page-name | equals \"Table\" | assert-true'"
 * @generated
 */
public interface GetPageName extends Command {
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
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getGetPageName_Table()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Table to get page name from'"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.GetPageName#getTable <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

} // GetPageName
