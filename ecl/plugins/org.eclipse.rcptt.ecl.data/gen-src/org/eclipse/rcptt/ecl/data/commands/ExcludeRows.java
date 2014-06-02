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
package org.eclipse.rcptt.ecl.data.commands;


import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.objects.Table;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exclude Rows</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getTable <em>Table</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getColumn <em>Column</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getMatch <em>Match</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getExcludeRows()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Takes a table from input and returns the table with rows filtered by column and criteria.' returns='Copy of input table object with filtered rows.' example='exclude-rows -column \"columnName\" -value \"value\" -match exact|glob|regex'"
 * @generated
 */
public interface ExcludeRows extends Command {
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
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getExcludeRows_Table()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Table to take columns from'"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getTable <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' attribute.
	 * @see #setColumn(String)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getExcludeRows_Column()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Column named to filter rows by.'"
	 * @generated
	 */
	String getColumn();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getExcludeRows_Value()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Pattern to match rows to.'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Match</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.ecl.data.commands.RowMatchMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Match</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match</em>' attribute.
	 * @see org.eclipse.rcptt.ecl.data.commands.RowMatchMode
	 * @see #setMatch(RowMatchMode)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getExcludeRows_Match()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Describes the matching behaviour for rows.\n<ul>\n<li><b>glob</b> &ndash; wildcard matching</li>\n<li><b>exact</b> &ndash; value should be equals to pattern</li>\n<li><b>regext</b> &ndash; value must match java regular expression</li>\n</ul>'"
	 * @generated
	 */
	RowMatchMode getMatch();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getMatch <em>Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Match</em>' attribute.
	 * @see org.eclipse.rcptt.ecl.data.commands.RowMatchMode
	 * @see #getMatch()
	 * @generated
	 */
	void setMatch(RowMatchMode value);

} // ExcludeRows
