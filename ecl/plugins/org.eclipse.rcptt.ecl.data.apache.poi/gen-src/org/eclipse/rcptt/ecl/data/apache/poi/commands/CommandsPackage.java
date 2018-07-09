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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.rcptt.ecl.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.CommandsFactory
 * @model kind="package"
 * @generated
 */
public interface CommandsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "commands";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ecl/data/apache/poi/commands.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dataCommands";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommandsPackage eINSTANCE = org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.CommandsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.WriteExcelFileImpl <em>Write Excel File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.WriteExcelFileImpl
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.CommandsPackageImpl#getWriteExcelFile()
	 * @generated
	 */
	int WRITE_EXCEL_FILE = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_EXCEL_FILE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_EXCEL_FILE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Tables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_EXCEL_FILE__TABLES = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_EXCEL_FILE__URI = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Append</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_EXCEL_FILE__APPEND = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Write Excel File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_EXCEL_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.ReadExcelFileImpl <em>Read Excel File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.ReadExcelFileImpl
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.CommandsPackageImpl#getReadExcelFile()
	 * @generated
	 */
	int READ_EXCEL_FILE = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_EXCEL_FILE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_EXCEL_FILE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_EXCEL_FILE__URI = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sheets</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_EXCEL_FILE__SHEETS = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Read Excel File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_EXCEL_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.GetTableCellsImpl <em>Get Table Cells</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.GetTableCellsImpl
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.CommandsPackageImpl#getGetTableCells()
	 * @generated
	 */
	int GET_TABLE_CELLS = 2;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_CELLS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_CELLS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_CELLS__TABLE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cells</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_CELLS__CELLS = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Get Table Cells</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_CELLS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.GetTableRangeImpl <em>Get Table Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.GetTableRangeImpl
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.CommandsPackageImpl#getGetTableRange()
	 * @generated
	 */
	int GET_TABLE_RANGE = 3;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_RANGE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_RANGE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_RANGE__TABLE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_RANGE__RANGE = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Get Table Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TABLE_RANGE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.SetTableCellsImpl <em>Set Table Cells</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.SetTableCellsImpl
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.CommandsPackageImpl#getSetTableCells()
	 * @generated
	 */
	int SET_TABLE_CELLS = 4;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TABLE_CELLS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TABLE_CELLS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TABLE_CELLS__TABLE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cells</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TABLE_CELLS__CELLS = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Table Cells</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TABLE_CELLS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.WriteExcelFile <em>Write Excel File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Write Excel File</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.WriteExcelFile
	 * @generated
	 */
	EClass getWriteExcelFile();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.WriteExcelFile#getTables <em>Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tables</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.WriteExcelFile#getTables()
	 * @see #getWriteExcelFile()
	 * @generated
	 */
	EReference getWriteExcelFile_Tables();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.WriteExcelFile#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.WriteExcelFile#getUri()
	 * @see #getWriteExcelFile()
	 * @generated
	 */
	EAttribute getWriteExcelFile_Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.WriteExcelFile#isAppend <em>Append</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Append</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.WriteExcelFile#isAppend()
	 * @see #getWriteExcelFile()
	 * @generated
	 */
	EAttribute getWriteExcelFile_Append();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.ReadExcelFile <em>Read Excel File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Read Excel File</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.ReadExcelFile
	 * @generated
	 */
	EClass getReadExcelFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.ReadExcelFile#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.ReadExcelFile#getUri()
	 * @see #getReadExcelFile()
	 * @generated
	 */
	EAttribute getReadExcelFile_Uri();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.ReadExcelFile#getSheets <em>Sheets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Sheets</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.ReadExcelFile#getSheets()
	 * @see #getReadExcelFile()
	 * @generated
	 */
	EAttribute getReadExcelFile_Sheets();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableCells <em>Get Table Cells</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Table Cells</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableCells
	 * @generated
	 */
	EClass getGetTableCells();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableCells#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableCells#getTable()
	 * @see #getGetTableCells()
	 * @generated
	 */
	EReference getGetTableCells_Table();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableCells#getCells <em>Cells</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Cells</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableCells#getCells()
	 * @see #getGetTableCells()
	 * @generated
	 */
	EAttribute getGetTableCells_Cells();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableRange <em>Get Table Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Table Range</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableRange
	 * @generated
	 */
	EClass getGetTableRange();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableRange#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableRange#getTable()
	 * @see #getGetTableRange()
	 * @generated
	 */
	EReference getGetTableRange_Table();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableRange#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.GetTableRange#getRange()
	 * @see #getGetTableRange()
	 * @generated
	 */
	EAttribute getGetTableRange_Range();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.SetTableCells <em>Set Table Cells</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Table Cells</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.SetTableCells
	 * @generated
	 */
	EClass getSetTableCells();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.SetTableCells#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.SetTableCells#getTable()
	 * @see #getSetTableCells()
	 * @generated
	 */
	EReference getSetTableCells_Table();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.SetTableCells#getCells <em>Cells</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Cells</em>'.
	 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.SetTableCells#getCells()
	 * @see #getSetTableCells()
	 * @generated
	 */
	EReference getSetTableCells_Cells();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommandsFactory getCommandsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.WriteExcelFileImpl <em>Write Excel File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.WriteExcelFileImpl
		 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.CommandsPackageImpl#getWriteExcelFile()
		 * @generated
		 */
		EClass WRITE_EXCEL_FILE = eINSTANCE.getWriteExcelFile();

		/**
		 * The meta object literal for the '<em><b>Tables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WRITE_EXCEL_FILE__TABLES = eINSTANCE.getWriteExcelFile_Tables();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WRITE_EXCEL_FILE__URI = eINSTANCE.getWriteExcelFile_Uri();

		/**
		 * The meta object literal for the '<em><b>Append</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WRITE_EXCEL_FILE__APPEND = eINSTANCE.getWriteExcelFile_Append();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.ReadExcelFileImpl <em>Read Excel File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.ReadExcelFileImpl
		 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.CommandsPackageImpl#getReadExcelFile()
		 * @generated
		 */
		EClass READ_EXCEL_FILE = eINSTANCE.getReadExcelFile();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute READ_EXCEL_FILE__URI = eINSTANCE.getReadExcelFile_Uri();

		/**
		 * The meta object literal for the '<em><b>Sheets</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute READ_EXCEL_FILE__SHEETS = eINSTANCE.getReadExcelFile_Sheets();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.GetTableCellsImpl <em>Get Table Cells</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.GetTableCellsImpl
		 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.CommandsPackageImpl#getGetTableCells()
		 * @generated
		 */
		EClass GET_TABLE_CELLS = eINSTANCE.getGetTableCells();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_TABLE_CELLS__TABLE = eINSTANCE.getGetTableCells_Table();

		/**
		 * The meta object literal for the '<em><b>Cells</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_TABLE_CELLS__CELLS = eINSTANCE.getGetTableCells_Cells();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.GetTableRangeImpl <em>Get Table Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.GetTableRangeImpl
		 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.CommandsPackageImpl#getGetTableRange()
		 * @generated
		 */
		EClass GET_TABLE_RANGE = eINSTANCE.getGetTableRange();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_TABLE_RANGE__TABLE = eINSTANCE.getGetTableRange_Table();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_TABLE_RANGE__RANGE = eINSTANCE.getGetTableRange_Range();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.SetTableCellsImpl <em>Set Table Cells</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.SetTableCellsImpl
		 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.CommandsPackageImpl#getSetTableCells()
		 * @generated
		 */
		EClass SET_TABLE_CELLS = eINSTANCE.getSetTableCells();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_TABLE_CELLS__TABLE = eINSTANCE.getSetTableCells_Table();

		/**
		 * The meta object literal for the '<em><b>Cells</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_TABLE_CELLS__CELLS = eINSTANCE.getSetTableCells_Cells();

	}

} //CommandsPackage
