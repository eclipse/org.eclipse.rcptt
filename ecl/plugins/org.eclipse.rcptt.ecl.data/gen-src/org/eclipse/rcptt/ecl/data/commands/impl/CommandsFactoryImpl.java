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
package org.eclipse.rcptt.ecl.data.commands.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.rcptt.ecl.data.commands.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommandsFactoryImpl extends EFactoryImpl implements CommandsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommandsFactory init() {
		try {
			CommandsFactory theCommandsFactory = (CommandsFactory)EPackage.Registry.INSTANCE.getEFactory(CommandsPackage.eNS_URI);
			if (theCommandsFactory != null) {
				return theCommandsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CommandsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CommandsPackage.READ_CSV_FILE: return createReadCsvFile();
			case CommandsPackage.PRINT: return createPrint();
			case CommandsPackage.WRITE_CSV_FILE: return createWriteCsvFile();
			case CommandsPackage.EXCLUDE_COLUMNS: return createExcludeColumns();
			case CommandsPackage.SELECT_COLUMNS: return createSelectColumns();
			case CommandsPackage.ASSERT_TABLES_MATCH: return createAssertTablesMatch();
			case CommandsPackage.WRITE_LINES: return createWriteLines();
			case CommandsPackage.READ_LINES: return createReadLines();
			case CommandsPackage.SELECT_ROWS: return createSelectRows();
			case CommandsPackage.EXCLUDE_ROWS: return createExcludeRows();
			case CommandsPackage.AS_TABLE_DATA: return createAsTableData();
			case CommandsPackage.READ_PROPERTIES: return createReadProperties();
			case CommandsPackage.READ_FILE: return createReadFile();
			case CommandsPackage.GET_PAGE_NAME: return createGetPageName();
			case CommandsPackage.SET_PAGE_NAME: return createSetPageName();
			case CommandsPackage.GET_COLUMN_NAMES: return createGetColumnNames();
			case CommandsPackage.GET_ROWS_DATA: return createGetRowsData();
			case CommandsPackage.LIST_AS_TABLE_DATA: return createListAsTableData();
			case CommandsPackage.READ_XML_FILE: return createReadXmlFile();
			case CommandsPackage.WRITE_XML_FILE: return createWriteXmlFile();
			case CommandsPackage.TREE_NODE: return createTreeNode();
			case CommandsPackage.GET_ATTRS: return createGetAttrs();
			case CommandsPackage.GET_ATTR: return createGetAttr();
			case CommandsPackage.SET_ATTR: return createSetAttr();
			case CommandsPackage.HAS_ATTR: return createHasAttr();
			case CommandsPackage.GET_NODES: return createGetNodes();
			case CommandsPackage.APPEND: return createAppend();
			case CommandsPackage.REMOVE: return createRemove();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CommandsPackage.IGNORE_COLUMNS_MODE:
				return createIgnoreColumnsModeFromString(eDataType, initialValue);
			case CommandsPackage.ROW_MATCH_MODE:
				return createRowMatchModeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CommandsPackage.IGNORE_COLUMNS_MODE:
				return convertIgnoreColumnsModeToString(eDataType, instanceValue);
			case CommandsPackage.ROW_MATCH_MODE:
				return convertRowMatchModeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReadCsvFile createReadCsvFile() {
		ReadCsvFileImpl readCsvFile = new ReadCsvFileImpl();
		return readCsvFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Print createPrint() {
		PrintImpl print = new PrintImpl();
		return print;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WriteCsvFile createWriteCsvFile() {
		WriteCsvFileImpl writeCsvFile = new WriteCsvFileImpl();
		return writeCsvFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExcludeColumns createExcludeColumns() {
		ExcludeColumnsImpl excludeColumns = new ExcludeColumnsImpl();
		return excludeColumns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectColumns createSelectColumns() {
		SelectColumnsImpl selectColumns = new SelectColumnsImpl();
		return selectColumns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssertTablesMatch createAssertTablesMatch() {
		AssertTablesMatchImpl assertTablesMatch = new AssertTablesMatchImpl();
		return assertTablesMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WriteLines createWriteLines() {
		WriteLinesImpl writeLines = new WriteLinesImpl();
		return writeLines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReadLines createReadLines() {
		ReadLinesImpl readLines = new ReadLinesImpl();
		return readLines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectRows createSelectRows() {
		SelectRowsImpl selectRows = new SelectRowsImpl();
		return selectRows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExcludeRows createExcludeRows() {
		ExcludeRowsImpl excludeRows = new ExcludeRowsImpl();
		return excludeRows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsTableData createAsTableData() {
		AsTableDataImpl asTableData = new AsTableDataImpl();
		return asTableData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReadProperties createReadProperties() {
		ReadPropertiesImpl readProperties = new ReadPropertiesImpl();
		return readProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReadFile createReadFile() {
		ReadFileImpl readFile = new ReadFileImpl();
		return readFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetPageName createGetPageName() {
		GetPageNameImpl getPageName = new GetPageNameImpl();
		return getPageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetPageName createSetPageName() {
		SetPageNameImpl setPageName = new SetPageNameImpl();
		return setPageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetColumnNames createGetColumnNames() {
		GetColumnNamesImpl getColumnNames = new GetColumnNamesImpl();
		return getColumnNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetRowsData createGetRowsData() {
		GetRowsDataImpl getRowsData = new GetRowsDataImpl();
		return getRowsData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListAsTableData createListAsTableData() {
		ListAsTableDataImpl listAsTableData = new ListAsTableDataImpl();
		return listAsTableData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReadXmlFile createReadXmlFile() {
		ReadXmlFileImpl readXmlFile = new ReadXmlFileImpl();
		return readXmlFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WriteXmlFile createWriteXmlFile() {
		WriteXmlFileImpl writeXmlFile = new WriteXmlFileImpl();
		return writeXmlFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeNode createTreeNode() {
		TreeNodeImpl treeNode = new TreeNodeImpl();
		return treeNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetAttrs createGetAttrs() {
		GetAttrsImpl getAttrs = new GetAttrsImpl();
		return getAttrs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetAttr createGetAttr() {
		GetAttrImpl getAttr = new GetAttrImpl();
		return getAttr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetAttr createSetAttr() {
		SetAttrImpl setAttr = new SetAttrImpl();
		return setAttr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HasAttr createHasAttr() {
		HasAttrImpl hasAttr = new HasAttrImpl();
		return hasAttr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetNodes createGetNodes() {
		GetNodesImpl getNodes = new GetNodesImpl();
		return getNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Append createAppend() {
		AppendImpl append = new AppendImpl();
		return append;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Remove createRemove() {
		RemoveImpl remove = new RemoveImpl();
		return remove;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IgnoreColumnsMode createIgnoreColumnsModeFromString(EDataType eDataType, String initialValue) {
		IgnoreColumnsMode result = IgnoreColumnsMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIgnoreColumnsModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RowMatchMode createRowMatchModeFromString(EDataType eDataType, String initialValue) {
		RowMatchMode result = RowMatchMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRowMatchModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandsPackage getCommandsPackage() {
		return (CommandsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CommandsPackage getPackage() {
		return CommandsPackage.eINSTANCE;
	}

} //CommandsFactoryImpl
