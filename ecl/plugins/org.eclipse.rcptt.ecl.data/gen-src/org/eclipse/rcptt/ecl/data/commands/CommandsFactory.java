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
package org.eclipse.rcptt.ecl.data.commands;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage
 * @generated
 */
public interface CommandsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommandsFactory eINSTANCE = org.eclipse.rcptt.ecl.data.commands.impl.CommandsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Read Csv File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Read Csv File</em>'.
	 * @generated
	 */
	ReadCsvFile createReadCsvFile();

	/**
	 * Returns a new object of class '<em>Print</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Print</em>'.
	 * @generated
	 */
	Print createPrint();

	/**
	 * Returns a new object of class '<em>Write Csv File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Write Csv File</em>'.
	 * @generated
	 */
	WriteCsvFile createWriteCsvFile();

	/**
	 * Returns a new object of class '<em>Exclude Columns</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exclude Columns</em>'.
	 * @generated
	 */
	ExcludeColumns createExcludeColumns();

	/**
	 * Returns a new object of class '<em>Select Columns</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select Columns</em>'.
	 * @generated
	 */
	SelectColumns createSelectColumns();

	/**
	 * Returns a new object of class '<em>Assert Tables Match</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assert Tables Match</em>'.
	 * @generated
	 */
	AssertTablesMatch createAssertTablesMatch();

	/**
	 * Returns a new object of class '<em>Write Lines</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Write Lines</em>'.
	 * @generated
	 */
	WriteLines createWriteLines();

	/**
	 * Returns a new object of class '<em>Read Lines</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Read Lines</em>'.
	 * @generated
	 */
	ReadLines createReadLines();

	/**
	 * Returns a new object of class '<em>Select Rows</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select Rows</em>'.
	 * @generated
	 */
	SelectRows createSelectRows();

	/**
	 * Returns a new object of class '<em>Exclude Rows</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exclude Rows</em>'.
	 * @generated
	 */
	ExcludeRows createExcludeRows();

	/**
	 * Returns a new object of class '<em>As Table Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>As Table Data</em>'.
	 * @generated
	 */
	AsTableData createAsTableData();

	/**
	 * Returns a new object of class '<em>Read Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Read Properties</em>'.
	 * @generated
	 */
	ReadProperties createReadProperties();

	/**
	 * Returns a new object of class '<em>Read File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Read File</em>'.
	 * @generated
	 */
	ReadFile createReadFile();

	/**
	 * Returns a new object of class '<em>Set Page Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Page Name</em>'.
	 * @generated
	 */
	SetPageName createSetPageName();

	/**
	 * Returns a new object of class '<em>List As Table Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List As Table Data</em>'.
	 * @generated
	 */
	ListAsTableData createListAsTableData();

	/**
	 * Returns a new object of class '<em>Read Xml File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Read Xml File</em>'.
	 * @generated
	 */
	ReadXmlFile createReadXmlFile();

	/**
	 * Returns a new object of class '<em>Write Xml File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Write Xml File</em>'.
	 * @generated
	 */
	WriteXmlFile createWriteXmlFile();

	/**
	 * Returns a new object of class '<em>Tree Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tree Node</em>'.
	 * @generated
	 */
	TreeNode createTreeNode();

	/**
	 * Returns a new object of class '<em>Get Attrs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Attrs</em>'.
	 * @generated
	 */
	GetAttrs createGetAttrs();

	/**
	 * Returns a new object of class '<em>Get Attr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Attr</em>'.
	 * @generated
	 */
	GetAttr createGetAttr();

	/**
	 * Returns a new object of class '<em>Set Attr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Attr</em>'.
	 * @generated
	 */
	SetAttr createSetAttr();

	/**
	 * Returns a new object of class '<em>Has Attr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Has Attr</em>'.
	 * @generated
	 */
	HasAttr createHasAttr();

	/**
	 * Returns a new object of class '<em>Get Nodes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Nodes</em>'.
	 * @generated
	 */
	GetNodes createGetNodes();

	/**
	 * Returns a new object of class '<em>Append</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Append</em>'.
	 * @generated
	 */
	Append createAppend();

	/**
	 * Returns a new object of class '<em>Remove</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove</em>'.
	 * @generated
	 */
	Remove createRemove();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CommandsPackage getCommandsPackage();

} //CommandsFactory
