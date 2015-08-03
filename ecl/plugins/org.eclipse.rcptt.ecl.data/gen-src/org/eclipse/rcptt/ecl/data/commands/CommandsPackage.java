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


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.rcptt.ecl.data.commands.CommandsFactory
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
	String eNS_URI = "http://www.eclipse.org/ecl/data/commands.ecore";

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
	CommandsPackage eINSTANCE = org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ReadCsvFileImpl <em>Read Csv File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.ReadCsvFileImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getReadCsvFile()
	 * @generated
	 */
	int READ_CSV_FILE = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_CSV_FILE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_CSV_FILE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_CSV_FILE__URI = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Read Csv File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_CSV_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.PrintImpl <em>Print</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.PrintImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getPrint()
	 * @generated
	 */
	int PRINT = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT__INPUT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Print</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRINT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.WriteCsvFileImpl <em>Write Csv File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.WriteCsvFileImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getWriteCsvFile()
	 * @generated
	 */
	int WRITE_CSV_FILE = 2;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_CSV_FILE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_CSV_FILE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_CSV_FILE__TABLE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_CSV_FILE__URI = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Write Csv File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_CSV_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ExcludeColumnsImpl <em>Exclude Columns</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.ExcludeColumnsImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getExcludeColumns()
	 * @generated
	 */
	int EXCLUDE_COLUMNS = 3;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDE_COLUMNS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDE_COLUMNS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDE_COLUMNS__TABLE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDE_COLUMNS__COLUMNS = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Exclude Columns</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDE_COLUMNS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.SelectColumnsImpl <em>Select Columns</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.SelectColumnsImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getSelectColumns()
	 * @generated
	 */
	int SELECT_COLUMNS = 4;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_COLUMNS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_COLUMNS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_COLUMNS__TABLE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_COLUMNS__COLUMNS = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Select Columns</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_COLUMNS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.AssertTablesMatchImpl <em>Assert Tables Match</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.AssertTablesMatchImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getAssertTablesMatch()
	 * @generated
	 */
	int ASSERT_TABLES_MATCH = 5;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_TABLES_MATCH__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_TABLES_MATCH__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_TABLES_MATCH__LEFT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_TABLES_MATCH__RIGHT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ignore Column Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_TABLES_MATCH__IGNORE_COLUMN_ORDER = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ignore Missing Columns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_TABLES_MATCH__IGNORE_MISSING_COLUMNS = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Assert Tables Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_TABLES_MATCH_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.WriteLinesImpl <em>Write Lines</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.WriteLinesImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getWriteLines()
	 * @generated
	 */
	int WRITE_LINES = 6;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_LINES__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_LINES__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_LINES__URI = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Append</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_LINES__APPEND = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Write Lines</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_LINES_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ReadLinesImpl <em>Read Lines</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.ReadLinesImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getReadLines()
	 * @generated
	 */
	int READ_LINES = 7;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_LINES__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_LINES__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_LINES__URI = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Read Lines</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_LINES_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.SelectRowsImpl <em>Select Rows</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.SelectRowsImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getSelectRows()
	 * @generated
	 */
	int SELECT_ROWS = 8;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ROWS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ROWS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ROWS__TABLE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ROWS__COLUMN = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ROWS__VALUE = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Match</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ROWS__MATCH = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Select Rows</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_ROWS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ExcludeRowsImpl <em>Exclude Rows</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.ExcludeRowsImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getExcludeRows()
	 * @generated
	 */
	int EXCLUDE_ROWS = 9;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDE_ROWS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDE_ROWS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDE_ROWS__TABLE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDE_ROWS__COLUMN = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDE_ROWS__VALUE = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Match</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDE_ROWS__MATCH = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Exclude Rows</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUDE_ROWS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.AsTableDataImpl <em>As Table Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.AsTableDataImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getAsTableData()
	 * @generated
	 */
	int AS_TABLE_DATA = 10;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_TABLE_DATA__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_TABLE_DATA__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_TABLE_DATA__INPUT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>As Table Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AS_TABLE_DATA_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ReadPropertiesImpl <em>Read Properties</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.ReadPropertiesImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getReadProperties()
	 * @generated
	 */
	int READ_PROPERTIES = 11;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_PROPERTIES__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_PROPERTIES__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_PROPERTIES__URI = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Read Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_PROPERTIES_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ReadFileImpl <em>Read File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.ReadFileImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getReadFile()
	 * @generated
	 */
	int READ_FILE = 12;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_FILE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_FILE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_FILE__URI = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Read File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.IgnoreColumnsMode <em>Ignore Columns Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.IgnoreColumnsMode
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getIgnoreColumnsMode()
	 * @generated
	 */
	int IGNORE_COLUMNS_MODE = 13;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.RowMatchMode <em>Row Match Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.RowMatchMode
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getRowMatchMode()
	 * @generated
	 */
	int ROW_MATCH_MODE = 14;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.ReadCsvFile <em>Read Csv File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Read Csv File</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ReadCsvFile
	 * @generated
	 */
	EClass getReadCsvFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.ReadCsvFile#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ReadCsvFile#getUri()
	 * @see #getReadCsvFile()
	 * @generated
	 */
	EAttribute getReadCsvFile_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.Print <em>Print</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Print</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.Print
	 * @generated
	 */
	EClass getPrint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.rcptt.ecl.data.commands.Print#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.Print#getInput()
	 * @see #getPrint()
	 * @generated
	 */
	EReference getPrint_Input();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.WriteCsvFile <em>Write Csv File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Write Csv File</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.WriteCsvFile
	 * @generated
	 */
	EClass getWriteCsvFile();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.WriteCsvFile#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.WriteCsvFile#getTable()
	 * @see #getWriteCsvFile()
	 * @generated
	 */
	EReference getWriteCsvFile_Table();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.WriteCsvFile#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.WriteCsvFile#getUri()
	 * @see #getWriteCsvFile()
	 * @generated
	 */
	EAttribute getWriteCsvFile_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.ExcludeColumns <em>Exclude Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exclude Columns</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ExcludeColumns
	 * @generated
	 */
	EClass getExcludeColumns();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.ExcludeColumns#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ExcludeColumns#getTable()
	 * @see #getExcludeColumns()
	 * @generated
	 */
	EReference getExcludeColumns_Table();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.ecl.data.commands.ExcludeColumns#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Columns</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ExcludeColumns#getColumns()
	 * @see #getExcludeColumns()
	 * @generated
	 */
	EAttribute getExcludeColumns_Columns();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.SelectColumns <em>Select Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select Columns</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.SelectColumns
	 * @generated
	 */
	EClass getSelectColumns();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.SelectColumns#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.SelectColumns#getTable()
	 * @see #getSelectColumns()
	 * @generated
	 */
	EReference getSelectColumns_Table();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.ecl.data.commands.SelectColumns#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Columns</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.SelectColumns#getColumns()
	 * @see #getSelectColumns()
	 * @generated
	 */
	EAttribute getSelectColumns_Columns();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.AssertTablesMatch <em>Assert Tables Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assert Tables Match</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.AssertTablesMatch
	 * @generated
	 */
	EClass getAssertTablesMatch();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.AssertTablesMatch#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.AssertTablesMatch#getLeft()
	 * @see #getAssertTablesMatch()
	 * @generated
	 */
	EReference getAssertTablesMatch_Left();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.AssertTablesMatch#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.AssertTablesMatch#getRight()
	 * @see #getAssertTablesMatch()
	 * @generated
	 */
	EReference getAssertTablesMatch_Right();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.AssertTablesMatch#isIgnoreColumnOrder <em>Ignore Column Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ignore Column Order</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.AssertTablesMatch#isIgnoreColumnOrder()
	 * @see #getAssertTablesMatch()
	 * @generated
	 */
	EAttribute getAssertTablesMatch_IgnoreColumnOrder();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.AssertTablesMatch#getIgnoreMissingColumns <em>Ignore Missing Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ignore Missing Columns</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.AssertTablesMatch#getIgnoreMissingColumns()
	 * @see #getAssertTablesMatch()
	 * @generated
	 */
	EAttribute getAssertTablesMatch_IgnoreMissingColumns();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.WriteLines <em>Write Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Write Lines</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.WriteLines
	 * @generated
	 */
	EClass getWriteLines();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.WriteLines#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.WriteLines#getUri()
	 * @see #getWriteLines()
	 * @generated
	 */
	EAttribute getWriteLines_Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.WriteLines#isAppend <em>Append</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Append</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.WriteLines#isAppend()
	 * @see #getWriteLines()
	 * @generated
	 */
	EAttribute getWriteLines_Append();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.ReadLines <em>Read Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Read Lines</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ReadLines
	 * @generated
	 */
	EClass getReadLines();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.ReadLines#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ReadLines#getUri()
	 * @see #getReadLines()
	 * @generated
	 */
	EAttribute getReadLines_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.SelectRows <em>Select Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select Rows</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.SelectRows
	 * @generated
	 */
	EClass getSelectRows();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.SelectRows#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.SelectRows#getTable()
	 * @see #getSelectRows()
	 * @generated
	 */
	EReference getSelectRows_Table();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.SelectRows#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.SelectRows#getColumn()
	 * @see #getSelectRows()
	 * @generated
	 */
	EAttribute getSelectRows_Column();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.SelectRows#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.SelectRows#getValue()
	 * @see #getSelectRows()
	 * @generated
	 */
	EAttribute getSelectRows_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.SelectRows#getMatch <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Match</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.SelectRows#getMatch()
	 * @see #getSelectRows()
	 * @generated
	 */
	EAttribute getSelectRows_Match();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.ExcludeRows <em>Exclude Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exclude Rows</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ExcludeRows
	 * @generated
	 */
	EClass getExcludeRows();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getTable()
	 * @see #getExcludeRows()
	 * @generated
	 */
	EReference getExcludeRows_Table();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getColumn()
	 * @see #getExcludeRows()
	 * @generated
	 */
	EAttribute getExcludeRows_Column();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getValue()
	 * @see #getExcludeRows()
	 * @generated
	 */
	EAttribute getExcludeRows_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getMatch <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Match</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ExcludeRows#getMatch()
	 * @see #getExcludeRows()
	 * @generated
	 */
	EAttribute getExcludeRows_Match();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.AsTableData <em>As Table Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>As Table Data</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.AsTableData
	 * @generated
	 */
	EClass getAsTableData();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.rcptt.ecl.data.commands.AsTableData#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.AsTableData#getInput()
	 * @see #getAsTableData()
	 * @generated
	 */
	EReference getAsTableData_Input();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.ReadProperties <em>Read Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Read Properties</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ReadProperties
	 * @generated
	 */
	EClass getReadProperties();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.ReadProperties#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ReadProperties#getUri()
	 * @see #getReadProperties()
	 * @generated
	 */
	EAttribute getReadProperties_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.ReadFile <em>Read File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Read File</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ReadFile
	 * @generated
	 */
	EClass getReadFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.ReadFile#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ReadFile#getUri()
	 * @see #getReadFile()
	 * @generated
	 */
	EAttribute getReadFile_Uri();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.ecl.data.commands.IgnoreColumnsMode <em>Ignore Columns Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Ignore Columns Mode</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.IgnoreColumnsMode
	 * @generated
	 */
	EEnum getIgnoreColumnsMode();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.ecl.data.commands.RowMatchMode <em>Row Match Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Row Match Mode</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.RowMatchMode
	 * @generated
	 */
	EEnum getRowMatchMode();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ReadCsvFileImpl <em>Read Csv File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.ReadCsvFileImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getReadCsvFile()
		 * @generated
		 */
		EClass READ_CSV_FILE = eINSTANCE.getReadCsvFile();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute READ_CSV_FILE__URI = eINSTANCE.getReadCsvFile_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.PrintImpl <em>Print</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.PrintImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getPrint()
		 * @generated
		 */
		EClass PRINT = eINSTANCE.getPrint();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRINT__INPUT = eINSTANCE.getPrint_Input();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.WriteCsvFileImpl <em>Write Csv File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.WriteCsvFileImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getWriteCsvFile()
		 * @generated
		 */
		EClass WRITE_CSV_FILE = eINSTANCE.getWriteCsvFile();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WRITE_CSV_FILE__TABLE = eINSTANCE.getWriteCsvFile_Table();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WRITE_CSV_FILE__URI = eINSTANCE.getWriteCsvFile_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ExcludeColumnsImpl <em>Exclude Columns</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.ExcludeColumnsImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getExcludeColumns()
		 * @generated
		 */
		EClass EXCLUDE_COLUMNS = eINSTANCE.getExcludeColumns();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCLUDE_COLUMNS__TABLE = eINSTANCE.getExcludeColumns_Table();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXCLUDE_COLUMNS__COLUMNS = eINSTANCE.getExcludeColumns_Columns();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.SelectColumnsImpl <em>Select Columns</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.SelectColumnsImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getSelectColumns()
		 * @generated
		 */
		EClass SELECT_COLUMNS = eINSTANCE.getSelectColumns();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_COLUMNS__TABLE = eINSTANCE.getSelectColumns_Table();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_COLUMNS__COLUMNS = eINSTANCE.getSelectColumns_Columns();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.AssertTablesMatchImpl <em>Assert Tables Match</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.AssertTablesMatchImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getAssertTablesMatch()
		 * @generated
		 */
		EClass ASSERT_TABLES_MATCH = eINSTANCE.getAssertTablesMatch();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERT_TABLES_MATCH__LEFT = eINSTANCE.getAssertTablesMatch_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERT_TABLES_MATCH__RIGHT = eINSTANCE.getAssertTablesMatch_Right();

		/**
		 * The meta object literal for the '<em><b>Ignore Column Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_TABLES_MATCH__IGNORE_COLUMN_ORDER = eINSTANCE.getAssertTablesMatch_IgnoreColumnOrder();

		/**
		 * The meta object literal for the '<em><b>Ignore Missing Columns</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_TABLES_MATCH__IGNORE_MISSING_COLUMNS = eINSTANCE.getAssertTablesMatch_IgnoreMissingColumns();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.WriteLinesImpl <em>Write Lines</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.WriteLinesImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getWriteLines()
		 * @generated
		 */
		EClass WRITE_LINES = eINSTANCE.getWriteLines();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WRITE_LINES__URI = eINSTANCE.getWriteLines_Uri();

		/**
		 * The meta object literal for the '<em><b>Append</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WRITE_LINES__APPEND = eINSTANCE.getWriteLines_Append();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ReadLinesImpl <em>Read Lines</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.ReadLinesImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getReadLines()
		 * @generated
		 */
		EClass READ_LINES = eINSTANCE.getReadLines();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute READ_LINES__URI = eINSTANCE.getReadLines_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.SelectRowsImpl <em>Select Rows</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.SelectRowsImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getSelectRows()
		 * @generated
		 */
		EClass SELECT_ROWS = eINSTANCE.getSelectRows();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_ROWS__TABLE = eINSTANCE.getSelectRows_Table();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_ROWS__COLUMN = eINSTANCE.getSelectRows_Column();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_ROWS__VALUE = eINSTANCE.getSelectRows_Value();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_ROWS__MATCH = eINSTANCE.getSelectRows_Match();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ExcludeRowsImpl <em>Exclude Rows</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.ExcludeRowsImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getExcludeRows()
		 * @generated
		 */
		EClass EXCLUDE_ROWS = eINSTANCE.getExcludeRows();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCLUDE_ROWS__TABLE = eINSTANCE.getExcludeRows_Table();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXCLUDE_ROWS__COLUMN = eINSTANCE.getExcludeRows_Column();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXCLUDE_ROWS__VALUE = eINSTANCE.getExcludeRows_Value();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXCLUDE_ROWS__MATCH = eINSTANCE.getExcludeRows_Match();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.AsTableDataImpl <em>As Table Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.AsTableDataImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getAsTableData()
		 * @generated
		 */
		EClass AS_TABLE_DATA = eINSTANCE.getAsTableData();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AS_TABLE_DATA__INPUT = eINSTANCE.getAsTableData_Input();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ReadPropertiesImpl <em>Read Properties</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.ReadPropertiesImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getReadProperties()
		 * @generated
		 */
		EClass READ_PROPERTIES = eINSTANCE.getReadProperties();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute READ_PROPERTIES__URI = eINSTANCE.getReadProperties_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ReadFileImpl <em>Read File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.ReadFileImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getReadFile()
		 * @generated
		 */
		EClass READ_FILE = eINSTANCE.getReadFile();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute READ_FILE__URI = eINSTANCE.getReadFile_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.IgnoreColumnsMode <em>Ignore Columns Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.IgnoreColumnsMode
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getIgnoreColumnsMode()
		 * @generated
		 */
		EEnum IGNORE_COLUMNS_MODE = eINSTANCE.getIgnoreColumnsMode();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.RowMatchMode <em>Row Match Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.RowMatchMode
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getRowMatchMode()
		 * @generated
		 */
		EEnum ROW_MATCH_MODE = eINSTANCE.getRowMatchMode();

	}

} //CommandsPackage
