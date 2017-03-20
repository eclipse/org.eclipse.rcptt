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
	 * The feature id for the '<em><b>Append</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_CSV_FILE__APPEND = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Write Csv File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_CSV_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

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
	 * The feature id for the '<em><b>Encode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_LINES__ENCODE = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Write Lines</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_LINES_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

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
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.SetPageNameImpl <em>Set Page Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.SetPageNameImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getSetPageName()
	 * @generated
	 */
	int SET_PAGE_NAME = 13;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PAGE_NAME__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PAGE_NAME__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PAGE_NAME__TABLE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PAGE_NAME__NAME = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Page Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_PAGE_NAME_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ListAsTableDataImpl <em>List As Table Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.ListAsTableDataImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getListAsTableData()
	 * @generated
	 */
	int LIST_AS_TABLE_DATA = 14;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_AS_TABLE_DATA__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_AS_TABLE_DATA__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_AS_TABLE_DATA__LIST = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List As Table Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_AS_TABLE_DATA_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ReadXmlFileImpl <em>Read Xml File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.ReadXmlFileImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getReadXmlFile()
	 * @generated
	 */
	int READ_XML_FILE = 15;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_XML_FILE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_XML_FILE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_XML_FILE__URI = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>XPath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_XML_FILE__XPATH = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Read Xml File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_XML_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.WriteXmlFileImpl <em>Write Xml File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.WriteXmlFileImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getWriteXmlFile()
	 * @generated
	 */
	int WRITE_XML_FILE = 16;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_XML_FILE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_XML_FILE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Tree</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_XML_FILE__TREE = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_XML_FILE__URI = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Write Xml File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_XML_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.TreeNodeImpl <em>Tree Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.TreeNodeImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getTreeNode()
	 * @generated
	 */
	int TREE_NODE = 17;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__NAME = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attrs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__ATTRS = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__CHILDREN = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE__TEXT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Tree Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_NODE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.GetAttrsImpl <em>Get Attrs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.GetAttrsImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getGetAttrs()
	 * @generated
	 */
	int GET_ATTRS = 18;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ATTRS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ATTRS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ATTRS__OBJECT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Attrs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ATTRS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.GetAttrImpl <em>Get Attr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.GetAttrImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getGetAttr()
	 * @generated
	 */
	int GET_ATTR = 19;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ATTR__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ATTR__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ATTR__OBJECT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ATTR__NAME = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Get Attr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ATTR_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.SetAttrImpl <em>Set Attr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.SetAttrImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getSetAttr()
	 * @generated
	 */
	int SET_ATTR = 20;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ATTR__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ATTR__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ATTR__OBJECT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ATTR__NAME = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ATTR__VALUE = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Set Attr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ATTR_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.HasAttrImpl <em>Has Attr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.HasAttrImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getHasAttr()
	 * @generated
	 */
	int HAS_ATTR = 21;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_ATTR__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_ATTR__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_ATTR__OBJECT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_ATTR__NAME = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Has Attr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_ATTR_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.GetNodesImpl <em>Get Nodes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.GetNodesImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getGetNodes()
	 * @generated
	 */
	int GET_NODES = 22;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NODES__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NODES__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NODES__OBJECT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NODES__NAME = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NODES__POS = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Len</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NODES__LEN = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Get Nodes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NODES_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.AppendImpl <em>Append</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.AppendImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getAppend()
	 * @generated
	 */
	int APPEND = 23;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND__OBJECT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND__CHILDREN = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND__INDEX = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Append</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.RemoveImpl <em>Remove</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.RemoveImpl
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getRemove()
	 * @generated
	 */
	int REMOVE = 24;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE__OBJECT = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE__INDEX = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Remove</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.IgnoreColumnsMode <em>Ignore Columns Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.IgnoreColumnsMode
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getIgnoreColumnsMode()
	 * @generated
	 */
	int IGNORE_COLUMNS_MODE = 25;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.data.commands.RowMatchMode <em>Row Match Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.data.commands.RowMatchMode
	 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getRowMatchMode()
	 * @generated
	 */
	int ROW_MATCH_MODE = 26;


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
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.WriteCsvFile#isAppend <em>Append</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Append</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.WriteCsvFile#isAppend()
	 * @see #getWriteCsvFile()
	 * @generated
	 */
	EAttribute getWriteCsvFile_Append();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.WriteLines#getEncode <em>Encode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encode</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.WriteLines#getEncode()
	 * @see #getWriteLines()
	 * @generated
	 */
	EAttribute getWriteLines_Encode();

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
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.SetPageName <em>Set Page Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Page Name</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.SetPageName
	 * @generated
	 */
	EClass getSetPageName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.SetPageName#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.SetPageName#getTable()
	 * @see #getSetPageName()
	 * @generated
	 */
	EReference getSetPageName_Table();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.SetPageName#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.SetPageName#getName()
	 * @see #getSetPageName()
	 * @generated
	 */
	EAttribute getSetPageName_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.ListAsTableData <em>List As Table Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List As Table Data</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ListAsTableData
	 * @generated
	 */
	EClass getListAsTableData();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.ListAsTableData#getList <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>List</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ListAsTableData#getList()
	 * @see #getListAsTableData()
	 * @generated
	 */
	EReference getListAsTableData_List();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.ReadXmlFile <em>Read Xml File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Read Xml File</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ReadXmlFile
	 * @generated
	 */
	EClass getReadXmlFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.ReadXmlFile#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ReadXmlFile#getUri()
	 * @see #getReadXmlFile()
	 * @generated
	 */
	EAttribute getReadXmlFile_Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.ReadXmlFile#getXPath <em>XPath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XPath</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.ReadXmlFile#getXPath()
	 * @see #getReadXmlFile()
	 * @generated
	 */
	EAttribute getReadXmlFile_XPath();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.WriteXmlFile <em>Write Xml File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Write Xml File</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.WriteXmlFile
	 * @generated
	 */
	EClass getWriteXmlFile();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.WriteXmlFile#getTree <em>Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tree</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.WriteXmlFile#getTree()
	 * @see #getWriteXmlFile()
	 * @generated
	 */
	EReference getWriteXmlFile_Tree();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.WriteXmlFile#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.WriteXmlFile#getUri()
	 * @see #getWriteXmlFile()
	 * @generated
	 */
	EAttribute getWriteXmlFile_Uri();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.TreeNode <em>Tree Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree Node</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.TreeNode
	 * @generated
	 */
	EClass getTreeNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.TreeNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.TreeNode#getName()
	 * @see #getTreeNode()
	 * @generated
	 */
	EAttribute getTreeNode_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.TreeNode#getAttrs <em>Attrs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attrs</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.TreeNode#getAttrs()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_Attrs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.rcptt.ecl.data.commands.TreeNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.TreeNode#getChildren()
	 * @see #getTreeNode()
	 * @generated
	 */
	EReference getTreeNode_Children();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.TreeNode#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.TreeNode#getText()
	 * @see #getTreeNode()
	 * @generated
	 */
	EAttribute getTreeNode_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.GetAttrs <em>Get Attrs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Attrs</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.GetAttrs
	 * @generated
	 */
	EClass getGetAttrs();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.GetAttrs#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.GetAttrs#getObject()
	 * @see #getGetAttrs()
	 * @generated
	 */
	EReference getGetAttrs_Object();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.GetAttr <em>Get Attr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Attr</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.GetAttr
	 * @generated
	 */
	EClass getGetAttr();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.GetAttr#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.GetAttr#getObject()
	 * @see #getGetAttr()
	 * @generated
	 */
	EReference getGetAttr_Object();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.GetAttr#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.GetAttr#getName()
	 * @see #getGetAttr()
	 * @generated
	 */
	EAttribute getGetAttr_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.SetAttr <em>Set Attr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Attr</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.SetAttr
	 * @generated
	 */
	EClass getSetAttr();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.SetAttr#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.SetAttr#getObject()
	 * @see #getSetAttr()
	 * @generated
	 */
	EReference getSetAttr_Object();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.SetAttr#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.SetAttr#getName()
	 * @see #getSetAttr()
	 * @generated
	 */
	EAttribute getSetAttr_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.SetAttr#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.SetAttr#getValue()
	 * @see #getSetAttr()
	 * @generated
	 */
	EAttribute getSetAttr_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.HasAttr <em>Has Attr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Attr</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.HasAttr
	 * @generated
	 */
	EClass getHasAttr();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.HasAttr#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.HasAttr#getObject()
	 * @see #getHasAttr()
	 * @generated
	 */
	EReference getHasAttr_Object();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.HasAttr#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.HasAttr#getName()
	 * @see #getHasAttr()
	 * @generated
	 */
	EAttribute getHasAttr_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.GetNodes <em>Get Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Nodes</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.GetNodes
	 * @generated
	 */
	EClass getGetNodes();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.GetNodes#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.GetNodes#getObject()
	 * @see #getGetNodes()
	 * @generated
	 */
	EReference getGetNodes_Object();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.GetNodes#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.GetNodes#getName()
	 * @see #getGetNodes()
	 * @generated
	 */
	EAttribute getGetNodes_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.GetNodes#getPos <em>Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pos</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.GetNodes#getPos()
	 * @see #getGetNodes()
	 * @generated
	 */
	EAttribute getGetNodes_Pos();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.GetNodes#getLen <em>Len</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Len</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.GetNodes#getLen()
	 * @see #getGetNodes()
	 * @generated
	 */
	EAttribute getGetNodes_Len();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.Append <em>Append</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Append</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.Append
	 * @generated
	 */
	EClass getAppend();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.Append#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.Append#getObject()
	 * @see #getAppend()
	 * @generated
	 */
	EReference getAppend_Object();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.rcptt.ecl.data.commands.Append#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.Append#getChildren()
	 * @see #getAppend()
	 * @generated
	 */
	EReference getAppend_Children();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.Append#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.Append#getIndex()
	 * @see #getAppend()
	 * @generated
	 */
	EAttribute getAppend_Index();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.data.commands.Remove <em>Remove</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.Remove
	 * @generated
	 */
	EClass getRemove();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.data.commands.Remove#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.Remove#getObject()
	 * @see #getRemove()
	 * @generated
	 */
	EReference getRemove_Object();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.data.commands.Remove#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.ecl.data.commands.Remove#getIndex()
	 * @see #getRemove()
	 * @generated
	 */
	EAttribute getRemove_Index();

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
		 * The meta object literal for the '<em><b>Append</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WRITE_CSV_FILE__APPEND = eINSTANCE.getWriteCsvFile_Append();

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
		 * The meta object literal for the '<em><b>Encode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WRITE_LINES__ENCODE = eINSTANCE.getWriteLines_Encode();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.SetPageNameImpl <em>Set Page Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.SetPageNameImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getSetPageName()
		 * @generated
		 */
		EClass SET_PAGE_NAME = eINSTANCE.getSetPageName();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_PAGE_NAME__TABLE = eINSTANCE.getSetPageName_Table();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_PAGE_NAME__NAME = eINSTANCE.getSetPageName_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ListAsTableDataImpl <em>List As Table Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.ListAsTableDataImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getListAsTableData()
		 * @generated
		 */
		EClass LIST_AS_TABLE_DATA = eINSTANCE.getListAsTableData();

		/**
		 * The meta object literal for the '<em><b>List</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_AS_TABLE_DATA__LIST = eINSTANCE.getListAsTableData_List();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.ReadXmlFileImpl <em>Read Xml File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.ReadXmlFileImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getReadXmlFile()
		 * @generated
		 */
		EClass READ_XML_FILE = eINSTANCE.getReadXmlFile();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute READ_XML_FILE__URI = eINSTANCE.getReadXmlFile_Uri();

		/**
		 * The meta object literal for the '<em><b>XPath</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute READ_XML_FILE__XPATH = eINSTANCE.getReadXmlFile_XPath();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.WriteXmlFileImpl <em>Write Xml File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.WriteXmlFileImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getWriteXmlFile()
		 * @generated
		 */
		EClass WRITE_XML_FILE = eINSTANCE.getWriteXmlFile();

		/**
		 * The meta object literal for the '<em><b>Tree</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WRITE_XML_FILE__TREE = eINSTANCE.getWriteXmlFile_Tree();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WRITE_XML_FILE__URI = eINSTANCE.getWriteXmlFile_Uri();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.TreeNodeImpl <em>Tree Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.TreeNodeImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getTreeNode()
		 * @generated
		 */
		EClass TREE_NODE = eINSTANCE.getTreeNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_NODE__NAME = eINSTANCE.getTreeNode_Name();

		/**
		 * The meta object literal for the '<em><b>Attrs</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_NODE__ATTRS = eINSTANCE.getTreeNode_Attrs();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_NODE__CHILDREN = eINSTANCE.getTreeNode_Children();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_NODE__TEXT = eINSTANCE.getTreeNode_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.GetAttrsImpl <em>Get Attrs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.GetAttrsImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getGetAttrs()
		 * @generated
		 */
		EClass GET_ATTRS = eINSTANCE.getGetAttrs();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_ATTRS__OBJECT = eINSTANCE.getGetAttrs_Object();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.GetAttrImpl <em>Get Attr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.GetAttrImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getGetAttr()
		 * @generated
		 */
		EClass GET_ATTR = eINSTANCE.getGetAttr();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_ATTR__OBJECT = eINSTANCE.getGetAttr_Object();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_ATTR__NAME = eINSTANCE.getGetAttr_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.SetAttrImpl <em>Set Attr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.SetAttrImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getSetAttr()
		 * @generated
		 */
		EClass SET_ATTR = eINSTANCE.getSetAttr();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_ATTR__OBJECT = eINSTANCE.getSetAttr_Object();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_ATTR__NAME = eINSTANCE.getSetAttr_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_ATTR__VALUE = eINSTANCE.getSetAttr_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.HasAttrImpl <em>Has Attr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.HasAttrImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getHasAttr()
		 * @generated
		 */
		EClass HAS_ATTR = eINSTANCE.getHasAttr();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAS_ATTR__OBJECT = eINSTANCE.getHasAttr_Object();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HAS_ATTR__NAME = eINSTANCE.getHasAttr_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.GetNodesImpl <em>Get Nodes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.GetNodesImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getGetNodes()
		 * @generated
		 */
		EClass GET_NODES = eINSTANCE.getGetNodes();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET_NODES__OBJECT = eINSTANCE.getGetNodes_Object();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_NODES__NAME = eINSTANCE.getGetNodes_Name();

		/**
		 * The meta object literal for the '<em><b>Pos</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_NODES__POS = eINSTANCE.getGetNodes_Pos();

		/**
		 * The meta object literal for the '<em><b>Len</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_NODES__LEN = eINSTANCE.getGetNodes_Len();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.AppendImpl <em>Append</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.AppendImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getAppend()
		 * @generated
		 */
		EClass APPEND = eINSTANCE.getAppend();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPEND__OBJECT = eINSTANCE.getAppend_Object();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPEND__CHILDREN = eINSTANCE.getAppend_Children();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPEND__INDEX = eINSTANCE.getAppend_Index();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.data.commands.impl.RemoveImpl <em>Remove</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.RemoveImpl
		 * @see org.eclipse.rcptt.ecl.data.commands.impl.CommandsPackageImpl#getRemove()
		 * @generated
		 */
		EClass REMOVE = eINSTANCE.getRemove();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE__OBJECT = eINSTANCE.getRemove_Object();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOVE__INDEX = eINSTANCE.getRemove_Index();

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
