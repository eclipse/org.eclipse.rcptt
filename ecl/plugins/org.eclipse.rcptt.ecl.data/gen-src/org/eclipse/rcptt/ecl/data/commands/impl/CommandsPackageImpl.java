/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.data.commands.impl;




import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.ecl.data.commands.Append;
import org.eclipse.rcptt.ecl.data.commands.AsTableData;
import org.eclipse.rcptt.ecl.data.commands.AssertTablesMatch;
import org.eclipse.rcptt.ecl.data.commands.CommandsFactory;
import org.eclipse.rcptt.ecl.data.commands.CommandsPackage;
import org.eclipse.rcptt.ecl.data.commands.ExcludeColumns;
import org.eclipse.rcptt.ecl.data.commands.ExcludeRows;
import org.eclipse.rcptt.ecl.data.commands.GetAttr;
import org.eclipse.rcptt.ecl.data.commands.GetAttrs;
import org.eclipse.rcptt.ecl.data.commands.GetNodes;
import org.eclipse.rcptt.ecl.data.commands.HasAttr;
import org.eclipse.rcptt.ecl.data.commands.IgnoreColumnsMode;
import org.eclipse.rcptt.ecl.data.commands.ListAsTableData;
import org.eclipse.rcptt.ecl.data.commands.Print;
import org.eclipse.rcptt.ecl.data.commands.ReadCsvFile;
import org.eclipse.rcptt.ecl.data.commands.ReadFile;
import org.eclipse.rcptt.ecl.data.commands.ReadLines;
import org.eclipse.rcptt.ecl.data.commands.ReadProperties;
import org.eclipse.rcptt.ecl.data.commands.ReadXmlFile;
import org.eclipse.rcptt.ecl.data.commands.Remove;
import org.eclipse.rcptt.ecl.data.commands.RowMatchMode;
import org.eclipse.rcptt.ecl.data.commands.SelectColumns;
import org.eclipse.rcptt.ecl.data.commands.SelectRows;
import org.eclipse.rcptt.ecl.data.commands.SetAttr;
import org.eclipse.rcptt.ecl.data.commands.SetPageName;
import org.eclipse.rcptt.ecl.data.commands.TreeNode;
import org.eclipse.rcptt.ecl.data.commands.WriteCsvFile;
import org.eclipse.rcptt.ecl.data.commands.WriteLines;
import org.eclipse.rcptt.ecl.data.commands.WriteXmlFile;
import org.eclipse.rcptt.ecl.data.objects.ObjectsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommandsPackageImpl extends EPackageImpl implements CommandsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readCsvFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass printEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass writeCsvFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass excludeColumnsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectColumnsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertTablesMatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass writeLinesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readLinesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectRowsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass excludeRowsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass asTableDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setPageNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listAsTableDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readXmlFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass writeXmlFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass treeNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getAttrsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getAttrEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setAttrEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hasAttrEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getNodesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass appendEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ignoreColumnsModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rowMatchModeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CommandsPackageImpl() {
		super(eNS_URI, CommandsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CommandsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CommandsPackage init() {
		if (isInited) return (CommandsPackage)EPackage.Registry.INSTANCE.getEPackage(CommandsPackage.eNS_URI);

		// Obtain or create and register package
		CommandsPackageImpl theCommandsPackage = (CommandsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CommandsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CommandsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		ObjectsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCommandsPackage.createPackageContents();

		// Initialize created meta-data
		theCommandsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCommandsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CommandsPackage.eNS_URI, theCommandsPackage);
		return theCommandsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReadCsvFile() {
		return readCsvFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReadCsvFile_Uri() {
		return (EAttribute)readCsvFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrint() {
		return printEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrint_Input() {
		return (EReference)printEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWriteCsvFile() {
		return writeCsvFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWriteCsvFile_Table() {
		return (EReference)writeCsvFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWriteCsvFile_Uri() {
		return (EAttribute)writeCsvFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWriteCsvFile_Append() {
		return (EAttribute)writeCsvFileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExcludeColumns() {
		return excludeColumnsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExcludeColumns_Table() {
		return (EReference)excludeColumnsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExcludeColumns_Columns() {
		return (EAttribute)excludeColumnsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectColumns() {
		return selectColumnsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectColumns_Table() {
		return (EReference)selectColumnsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectColumns_Columns() {
		return (EAttribute)selectColumnsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssertTablesMatch() {
		return assertTablesMatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssertTablesMatch_Left() {
		return (EReference)assertTablesMatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssertTablesMatch_Right() {
		return (EReference)assertTablesMatchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertTablesMatch_IgnoreColumnOrder() {
		return (EAttribute)assertTablesMatchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertTablesMatch_IgnoreMissingColumns() {
		return (EAttribute)assertTablesMatchEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWriteLines() {
		return writeLinesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWriteLines_Uri() {
		return (EAttribute)writeLinesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWriteLines_Append() {
		return (EAttribute)writeLinesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWriteLines_Encode() {
		return (EAttribute)writeLinesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReadLines() {
		return readLinesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReadLines_Uri() {
		return (EAttribute)readLinesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectRows() {
		return selectRowsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectRows_Table() {
		return (EReference)selectRowsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectRows_Column() {
		return (EAttribute)selectRowsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectRows_Value() {
		return (EAttribute)selectRowsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectRows_Match() {
		return (EAttribute)selectRowsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExcludeRows() {
		return excludeRowsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExcludeRows_Table() {
		return (EReference)excludeRowsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExcludeRows_Column() {
		return (EAttribute)excludeRowsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExcludeRows_Value() {
		return (EAttribute)excludeRowsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExcludeRows_Match() {
		return (EAttribute)excludeRowsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAsTableData() {
		return asTableDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAsTableData_Input() {
		return (EReference)asTableDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReadProperties() {
		return readPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReadProperties_Uri() {
		return (EAttribute)readPropertiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReadFile() {
		return readFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReadFile_Uri() {
		return (EAttribute)readFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetPageName() {
		return setPageNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetPageName_Table() {
		return (EReference)setPageNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetPageName_Name() {
		return (EAttribute)setPageNameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListAsTableData() {
		return listAsTableDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListAsTableData_List() {
		return (EReference)listAsTableDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReadXmlFile() {
		return readXmlFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReadXmlFile_Uri() {
		return (EAttribute)readXmlFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReadXmlFile_XPath() {
		return (EAttribute)readXmlFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWriteXmlFile() {
		return writeXmlFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWriteXmlFile_Tree() {
		return (EReference)writeXmlFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWriteXmlFile_Uri() {
		return (EAttribute)writeXmlFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTreeNode() {
		return treeNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeNode_Name() {
		return (EAttribute)treeNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeNode_Attrs() {
		return (EReference)treeNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTreeNode_Children() {
		return (EReference)treeNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTreeNode_Text() {
		return (EAttribute)treeNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetAttrs() {
		return getAttrsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGetAttrs_Object() {
		return (EReference)getAttrsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetAttr() {
		return getAttrEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGetAttr_Object() {
		return (EReference)getAttrEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetAttr_Name() {
		return (EAttribute)getAttrEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetAttr() {
		return setAttrEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetAttr_Object() {
		return (EReference)setAttrEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetAttr_Name() {
		return (EAttribute)setAttrEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetAttr_Value() {
		return (EAttribute)setAttrEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHasAttr() {
		return hasAttrEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHasAttr_Object() {
		return (EReference)hasAttrEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHasAttr_Name() {
		return (EAttribute)hasAttrEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetNodes() {
		return getNodesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGetNodes_Object() {
		return (EReference)getNodesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetNodes_Name() {
		return (EAttribute)getNodesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetNodes_Pos() {
		return (EAttribute)getNodesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetNodes_Len() {
		return (EAttribute)getNodesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAppend() {
		return appendEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAppend_Object() {
		return (EReference)appendEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAppend_Children() {
		return (EReference)appendEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAppend_Index() {
		return (EAttribute)appendEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemove() {
		return removeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemove_Object() {
		return (EReference)removeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRemove_Index() {
		return (EAttribute)removeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIgnoreColumnsMode() {
		return ignoreColumnsModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRowMatchMode() {
		return rowMatchModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandsFactory getCommandsFactory() {
		return (CommandsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		readCsvFileEClass = createEClass(READ_CSV_FILE);
		createEAttribute(readCsvFileEClass, READ_CSV_FILE__URI);

		printEClass = createEClass(PRINT);
		createEReference(printEClass, PRINT__INPUT);

		writeCsvFileEClass = createEClass(WRITE_CSV_FILE);
		createEReference(writeCsvFileEClass, WRITE_CSV_FILE__TABLE);
		createEAttribute(writeCsvFileEClass, WRITE_CSV_FILE__URI);
		createEAttribute(writeCsvFileEClass, WRITE_CSV_FILE__APPEND);

		excludeColumnsEClass = createEClass(EXCLUDE_COLUMNS);
		createEReference(excludeColumnsEClass, EXCLUDE_COLUMNS__TABLE);
		createEAttribute(excludeColumnsEClass, EXCLUDE_COLUMNS__COLUMNS);

		selectColumnsEClass = createEClass(SELECT_COLUMNS);
		createEReference(selectColumnsEClass, SELECT_COLUMNS__TABLE);
		createEAttribute(selectColumnsEClass, SELECT_COLUMNS__COLUMNS);

		assertTablesMatchEClass = createEClass(ASSERT_TABLES_MATCH);
		createEReference(assertTablesMatchEClass, ASSERT_TABLES_MATCH__LEFT);
		createEReference(assertTablesMatchEClass, ASSERT_TABLES_MATCH__RIGHT);
		createEAttribute(assertTablesMatchEClass, ASSERT_TABLES_MATCH__IGNORE_COLUMN_ORDER);
		createEAttribute(assertTablesMatchEClass, ASSERT_TABLES_MATCH__IGNORE_MISSING_COLUMNS);

		writeLinesEClass = createEClass(WRITE_LINES);
		createEAttribute(writeLinesEClass, WRITE_LINES__URI);
		createEAttribute(writeLinesEClass, WRITE_LINES__APPEND);
		createEAttribute(writeLinesEClass, WRITE_LINES__ENCODE);

		readLinesEClass = createEClass(READ_LINES);
		createEAttribute(readLinesEClass, READ_LINES__URI);

		selectRowsEClass = createEClass(SELECT_ROWS);
		createEReference(selectRowsEClass, SELECT_ROWS__TABLE);
		createEAttribute(selectRowsEClass, SELECT_ROWS__COLUMN);
		createEAttribute(selectRowsEClass, SELECT_ROWS__VALUE);
		createEAttribute(selectRowsEClass, SELECT_ROWS__MATCH);

		excludeRowsEClass = createEClass(EXCLUDE_ROWS);
		createEReference(excludeRowsEClass, EXCLUDE_ROWS__TABLE);
		createEAttribute(excludeRowsEClass, EXCLUDE_ROWS__COLUMN);
		createEAttribute(excludeRowsEClass, EXCLUDE_ROWS__VALUE);
		createEAttribute(excludeRowsEClass, EXCLUDE_ROWS__MATCH);

		asTableDataEClass = createEClass(AS_TABLE_DATA);
		createEReference(asTableDataEClass, AS_TABLE_DATA__INPUT);

		readPropertiesEClass = createEClass(READ_PROPERTIES);
		createEAttribute(readPropertiesEClass, READ_PROPERTIES__URI);

		readFileEClass = createEClass(READ_FILE);
		createEAttribute(readFileEClass, READ_FILE__URI);

		setPageNameEClass = createEClass(SET_PAGE_NAME);
		createEReference(setPageNameEClass, SET_PAGE_NAME__TABLE);
		createEAttribute(setPageNameEClass, SET_PAGE_NAME__NAME);

		listAsTableDataEClass = createEClass(LIST_AS_TABLE_DATA);
		createEReference(listAsTableDataEClass, LIST_AS_TABLE_DATA__LIST);

		readXmlFileEClass = createEClass(READ_XML_FILE);
		createEAttribute(readXmlFileEClass, READ_XML_FILE__URI);
		createEAttribute(readXmlFileEClass, READ_XML_FILE__XPATH);

		writeXmlFileEClass = createEClass(WRITE_XML_FILE);
		createEReference(writeXmlFileEClass, WRITE_XML_FILE__TREE);
		createEAttribute(writeXmlFileEClass, WRITE_XML_FILE__URI);

		treeNodeEClass = createEClass(TREE_NODE);
		createEAttribute(treeNodeEClass, TREE_NODE__NAME);
		createEReference(treeNodeEClass, TREE_NODE__ATTRS);
		createEReference(treeNodeEClass, TREE_NODE__CHILDREN);
		createEAttribute(treeNodeEClass, TREE_NODE__TEXT);

		getAttrsEClass = createEClass(GET_ATTRS);
		createEReference(getAttrsEClass, GET_ATTRS__OBJECT);

		getAttrEClass = createEClass(GET_ATTR);
		createEReference(getAttrEClass, GET_ATTR__OBJECT);
		createEAttribute(getAttrEClass, GET_ATTR__NAME);

		setAttrEClass = createEClass(SET_ATTR);
		createEReference(setAttrEClass, SET_ATTR__OBJECT);
		createEAttribute(setAttrEClass, SET_ATTR__NAME);
		createEAttribute(setAttrEClass, SET_ATTR__VALUE);

		hasAttrEClass = createEClass(HAS_ATTR);
		createEReference(hasAttrEClass, HAS_ATTR__OBJECT);
		createEAttribute(hasAttrEClass, HAS_ATTR__NAME);

		getNodesEClass = createEClass(GET_NODES);
		createEReference(getNodesEClass, GET_NODES__OBJECT);
		createEAttribute(getNodesEClass, GET_NODES__NAME);
		createEAttribute(getNodesEClass, GET_NODES__POS);
		createEAttribute(getNodesEClass, GET_NODES__LEN);

		appendEClass = createEClass(APPEND);
		createEReference(appendEClass, APPEND__OBJECT);
		createEReference(appendEClass, APPEND__CHILDREN);
		createEAttribute(appendEClass, APPEND__INDEX);

		removeEClass = createEClass(REMOVE);
		createEReference(removeEClass, REMOVE__OBJECT);
		createEAttribute(removeEClass, REMOVE__INDEX);

		// Create enums
		ignoreColumnsModeEEnum = createEEnum(IGNORE_COLUMNS_MODE);
		rowMatchModeEEnum = createEEnum(ROW_MATCH_MODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		ObjectsPackage theObjectsPackage = (ObjectsPackage)EPackage.Registry.INSTANCE.getEPackage(ObjectsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		readCsvFileEClass.getESuperTypes().add(theCorePackage.getCommand());
		printEClass.getESuperTypes().add(theCorePackage.getCommand());
		writeCsvFileEClass.getESuperTypes().add(theCorePackage.getCommand());
		excludeColumnsEClass.getESuperTypes().add(theCorePackage.getCommand());
		selectColumnsEClass.getESuperTypes().add(theCorePackage.getCommand());
		assertTablesMatchEClass.getESuperTypes().add(theCorePackage.getCommand());
		writeLinesEClass.getESuperTypes().add(theCorePackage.getCommand());
		readLinesEClass.getESuperTypes().add(theCorePackage.getCommand());
		selectRowsEClass.getESuperTypes().add(theCorePackage.getCommand());
		excludeRowsEClass.getESuperTypes().add(theCorePackage.getCommand());
		asTableDataEClass.getESuperTypes().add(theCorePackage.getCommand());
		readPropertiesEClass.getESuperTypes().add(theCorePackage.getCommand());
		readFileEClass.getESuperTypes().add(theCorePackage.getCommand());
		setPageNameEClass.getESuperTypes().add(theCorePackage.getCommand());
		listAsTableDataEClass.getESuperTypes().add(theCorePackage.getCommand());
		readXmlFileEClass.getESuperTypes().add(theCorePackage.getCommand());
		writeXmlFileEClass.getESuperTypes().add(theCorePackage.getCommand());
		treeNodeEClass.getESuperTypes().add(theCorePackage.getCommand());
		getAttrsEClass.getESuperTypes().add(theCorePackage.getCommand());
		getAttrEClass.getESuperTypes().add(theCorePackage.getCommand());
		setAttrEClass.getESuperTypes().add(theCorePackage.getCommand());
		hasAttrEClass.getESuperTypes().add(theCorePackage.getCommand());
		getNodesEClass.getESuperTypes().add(theCorePackage.getCommand());
		appendEClass.getESuperTypes().add(theCorePackage.getCommand());
		removeEClass.getESuperTypes().add(theCorePackage.getCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(readCsvFileEClass, ReadCsvFile.class, "ReadCsvFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReadCsvFile_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, ReadCsvFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(printEClass, Print.class, "Print", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrint_Input(), theEcorePackage.getEObject(), null, "input", null, 0, -1, Print.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(writeCsvFileEClass, WriteCsvFile.class, "WriteCsvFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWriteCsvFile_Table(), theObjectsPackage.getTable(), null, "table", null, 0, 1, WriteCsvFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWriteCsvFile_Uri(), theEcorePackage.getEString(), "uri", null, 0, 1, WriteCsvFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWriteCsvFile_Append(), theEcorePackage.getEBoolean(), "append", "false", 0, 1, WriteCsvFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(excludeColumnsEClass, ExcludeColumns.class, "ExcludeColumns", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExcludeColumns_Table(), theObjectsPackage.getTable(), null, "table", null, 0, 1, ExcludeColumns.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExcludeColumns_Columns(), theEcorePackage.getEString(), "columns", null, 0, -1, ExcludeColumns.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectColumnsEClass, SelectColumns.class, "SelectColumns", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectColumns_Table(), theObjectsPackage.getTable(), null, "table", null, 0, 1, SelectColumns.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectColumns_Columns(), theEcorePackage.getEString(), "columns", null, 0, -1, SelectColumns.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assertTablesMatchEClass, AssertTablesMatch.class, "AssertTablesMatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssertTablesMatch_Left(), theObjectsPackage.getTable(), null, "left", null, 0, 1, AssertTablesMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssertTablesMatch_Right(), theObjectsPackage.getTable(), null, "right", null, 0, 1, AssertTablesMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertTablesMatch_IgnoreColumnOrder(), theEcorePackage.getEBoolean(), "ignoreColumnOrder", "false", 0, 1, AssertTablesMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertTablesMatch_IgnoreMissingColumns(), this.getIgnoreColumnsMode(), "ignoreMissingColumns", "NONE", 0, 1, AssertTablesMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(writeLinesEClass, WriteLines.class, "WriteLines", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWriteLines_Uri(), theEcorePackage.getEString(), "uri", "UTF-8", 0, 1, WriteLines.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWriteLines_Append(), theEcorePackage.getEBoolean(), "append", "false", 0, 1, WriteLines.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWriteLines_Encode(), theEcorePackage.getEString(), "encode", null, 0, 1, WriteLines.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(readLinesEClass, ReadLines.class, "ReadLines", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReadLines_Uri(), theEcorePackage.getEString(), "uri", null, 1, 1, ReadLines.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectRowsEClass, SelectRows.class, "SelectRows", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectRows_Table(), theObjectsPackage.getTable(), null, "table", null, 0, 1, SelectRows.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectRows_Column(), theEcorePackage.getEString(), "column", null, 0, 1, SelectRows.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectRows_Value(), theEcorePackage.getEString(), "value", null, 0, 1, SelectRows.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectRows_Match(), this.getRowMatchMode(), "match", null, 0, 1, SelectRows.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(excludeRowsEClass, ExcludeRows.class, "ExcludeRows", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExcludeRows_Table(), theObjectsPackage.getTable(), null, "table", null, 0, 1, ExcludeRows.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExcludeRows_Column(), theEcorePackage.getEString(), "column", null, 0, 1, ExcludeRows.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExcludeRows_Value(), theEcorePackage.getEString(), "value", null, 0, 1, ExcludeRows.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExcludeRows_Match(), this.getRowMatchMode(), "match", null, 0, 1, ExcludeRows.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(asTableDataEClass, AsTableData.class, "AsTableData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAsTableData_Input(), theEcorePackage.getEObject(), null, "input", null, 0, -1, AsTableData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(readPropertiesEClass, ReadProperties.class, "ReadProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReadProperties_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, ReadProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(readFileEClass, ReadFile.class, "ReadFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReadFile_Uri(), theEcorePackage.getEString(), "uri", null, 1, 1, ReadFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setPageNameEClass, SetPageName.class, "SetPageName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetPageName_Table(), theObjectsPackage.getTable(), null, "table", null, 1, 1, SetPageName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetPageName_Name(), theEcorePackage.getEString(), "name", null, 1, 1, SetPageName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listAsTableDataEClass, ListAsTableData.class, "ListAsTableData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListAsTableData_List(), theCorePackage.getEclList(), null, "list", null, 1, 1, ListAsTableData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(readXmlFileEClass, ReadXmlFile.class, "ReadXmlFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReadXmlFile_Uri(), ecorePackage.getEString(), "uri", null, 1, 1, ReadXmlFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReadXmlFile_XPath(), ecorePackage.getEString(), "xPath", null, 0, 1, ReadXmlFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(writeXmlFileEClass, WriteXmlFile.class, "WriteXmlFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWriteXmlFile_Tree(), theObjectsPackage.getTree(), null, "tree", null, 1, 1, WriteXmlFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWriteXmlFile_Uri(), ecorePackage.getEString(), "uri", null, 1, 1, WriteXmlFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(treeNodeEClass, TreeNode.class, "TreeNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTreeNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, TreeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTreeNode_Attrs(), theCorePackage.getEclMap(), null, "attrs", null, 0, 1, TreeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTreeNode_Children(), theObjectsPackage.getTree(), null, "children", null, 0, -1, TreeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTreeNode_Text(), ecorePackage.getEString(), "text", null, 0, 1, TreeNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getAttrsEClass, GetAttrs.class, "GetAttrs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGetAttrs_Object(), theEcorePackage.getEObject(), null, "object", null, 1, 1, GetAttrs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getAttrEClass, GetAttr.class, "GetAttr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGetAttr_Object(), theEcorePackage.getEObject(), null, "object", null, 1, 1, GetAttr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetAttr_Name(), ecorePackage.getEString(), "name", null, 1, 1, GetAttr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setAttrEClass, SetAttr.class, "SetAttr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetAttr_Object(), theEcorePackage.getEObject(), null, "object", null, 1, 1, SetAttr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetAttr_Name(), ecorePackage.getEString(), "name", null, 1, 1, SetAttr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetAttr_Value(), ecorePackage.getEString(), "value", null, 0, 1, SetAttr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hasAttrEClass, HasAttr.class, "HasAttr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHasAttr_Object(), theEcorePackage.getEObject(), null, "object", null, 1, 1, HasAttr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHasAttr_Name(), ecorePackage.getEString(), "name", null, 1, 1, HasAttr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getNodesEClass, GetNodes.class, "GetNodes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGetNodes_Object(), theEcorePackage.getEObject(), null, "object", null, 1, 1, GetNodes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetNodes_Name(), ecorePackage.getEString(), "name", null, 0, 1, GetNodes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetNodes_Pos(), theEcorePackage.getEInt(), "pos", "0", 0, 1, GetNodes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetNodes_Len(), theEcorePackage.getEInt(), "len", "-1", 0, 1, GetNodes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(appendEClass, Append.class, "Append", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAppend_Object(), theEcorePackage.getEObject(), null, "object", null, 1, 1, Append.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAppend_Children(), theEcorePackage.getEObject(), null, "children", null, 1, -1, Append.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAppend_Index(), theEcorePackage.getEInt(), "index", "-1", 0, 1, Append.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(removeEClass, Remove.class, "Remove", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRemove_Object(), theEcorePackage.getEObject(), null, "object", null, 1, 1, Remove.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRemove_Index(), theEcorePackage.getEInt(), "index", "-1", 1, 1, Remove.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(ignoreColumnsModeEEnum, IgnoreColumnsMode.class, "IgnoreColumnsMode");
		addEEnumLiteral(ignoreColumnsModeEEnum, IgnoreColumnsMode.NONE);
		addEEnumLiteral(ignoreColumnsModeEEnum, IgnoreColumnsMode.LEFT);
		addEEnumLiteral(ignoreColumnsModeEEnum, IgnoreColumnsMode.RIGHT);
		addEEnumLiteral(ignoreColumnsModeEEnum, IgnoreColumnsMode.BOTH);

		initEEnum(rowMatchModeEEnum, RowMatchMode.class, "RowMatchMode");
		addEEnumLiteral(rowMatchModeEEnum, RowMatchMode.EXACT);
		addEEnumLiteral(rowMatchModeEEnum, RowMatchMode.GLOB);
		addEEnumLiteral(rowMatchModeEEnum, RowMatchMode.REGEXP);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/ecl/docs
		createDocsAnnotations();
		// http://www.eclipse.org/ecl/internal
		createInternalAnnotations();
		// http://www.eclipse.org/ecl/input
		createInputAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/docs</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDocsAnnotations() {
		String source = "http://www.eclipse.org/ecl/docs";	
		addAnnotation
		  (readCsvFileEClass, 
		   source, 
		   new String[] {
			 "description", "Parses given csv file. Fails if file is not found or format is invalid.\nLearn more about <a href = \"http://xored.freshdesk.com/solution/articles/78219-assert-the-whole-table\">Asserting the whole table contents.</a>",
			 "returns", "<code>Table</code> EMF Object. ",
			 "example", "with [get-window Preferences] {\n\tget-tree | select \"Java/Installed JREs\"\n\tget-table | get-table-data | eq [read-csv-file \"workspace:/assertData/table.csv\"] | \n\t\tassert-true \"Data in table does not match input file\" \n\tget-button OK | click\n}\n\n//Let\'s say we need to write ErrorLog info to csv file \'table.csv\'.\n//ECL script should look like this:\n \nget-view \"Error Log\" | get-tree | expand-all\nget-view \"Error Log\" | get-tree | get-table-data | write-csv-file \"workspace:/MyProject/AssertData/table.csv\n \n//Note: \n//<a href=\"#expand-all\">Expand-all</a>command may be useful in case of hierarchical tree - otherwise non-expanded levels won\'t be written.  \n//You should have MyProject/AssertData on your workspace (you may do it easily with a workspace context) to let you csv file to be created there. \n \n//In case you want to specify which columns/rows should be written you may use \n//<a href=\"#select-columns\">select-columns</a>/<a href=\"#exclude-columns\">exclude-columns</a> and <a href=\"#select-rows\">select-rows</a>/<a href=\"#exclude-rows\">exclude-rows</a> commands:\n \nget-view \"Error Log\" | get-tree | get-table-data | select-columns \"Message\" | write-csv-file \"workspace:/MyProject/AssertData/table.csv\" \nget-view \"Error Log\" | get-tree | get-table-data | exclude-columns \"Message\" \"Plug-in\" | write-csv-file \"workspace:/MyProject/AssertData/table.csv\"\nget-view \"Error Log\" | get-tree | get-table-data | select-rows -column \"Message\"  -value \"Execution of early startup handlers completed.\" | write-csv-file \"workspace:/MyProject/AssertData/table.csv\"\n \n//To compare table data to already written csv file you may use <a href=\"#read-csv-file\">read-csv-file</a> command:\n \nget-view \"Error Log\" | get-tree | get-table-data | select-columns \"Plug-in\" | eq [read-csv-file \"workspace:/MyProject/AssertData/table.csv\"] | assert-true \"Data in table does not match input file\" "
		   });	
		addAnnotation
		  (getReadCsvFile_Uri(), 
		   source, 
		   new String[] {
			 "description", "URI to a file to read. Currently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system"
		   });	
		addAnnotation
		  (printEClass, 
		   source, 
		   new String[] {
			 "description", "Takes a list of objects from input pipe and prints them as a plain-text table into output pipe.",
			 "returns", "Series of string objects"
		   });	
		addAnnotation
		  (writeCsvFileEClass, 
		   source, 
		   new String[] {
			 "description", "Writes given table into csv file. Fails if file is not accessible.\nLearn more about <a href = \"http://xored.freshdesk.com/solution/articles/78219-assert-the-whole-table\">Asserting the whole table contents.</a>",
			 "returns", "The value of <code>table</code> argument.",
			 "example", "with [get-window Preferences] {\n\tget-tree | select \"Java/Installed JREs\"\n\tget-table | get-table-data | write-csv-file \"workspace:/assertData/table.csv\"\n\tget-button OK | click\n}\n\n//Let\'s say we need to write ErrorLog info to csv file \'table.csv\'.\n//ECL script should look like this:\n \nget-view \"Error Log\" | get-tree | expand-all\nget-view \"Error Log\" | get-tree | get-table-data | write-csv-file \"workspace:/MyProject/AssertData/table.csv\n \n//Note: \n//<a href=\"#expand-all\">Expand-all</a>command may be useful in case of hierarchical tree - otherwise non-expanded levels won\'t be written.  \n//You should have MyProject/AssertData on your workspace (you may do it easily with a workspace context) to let you csv file to be created there. \n \n//In case you want to specify which columns/rows should be written you may use \n//<a href=\"#select-columns\">select-columns</a>/<a href=\"#exclude-columns\">exclude-columns</a> and <a href=\"#select-rows\">select-rows</a>/<a href=\"#exclude-rows\">exclude-rows</a> commands:\n \nget-view \"Error Log\" | get-tree | get-table-data | select-columns \"Message\" | write-csv-file \"workspace:/MyProject/AssertData/table.csv\" \nget-view \"Error Log\" | get-tree | get-table-data | exclude-columns \"Message\" \"Plug-in\" | write-csv-file \"workspace:/MyProject/AssertData/table.csv\"\nget-view \"Error Log\" | get-tree | get-table-data | select-rows -column \"Message\"  -value \"Execution of early startup handlers completed.\" | write-csv-file \"workspace:/MyProject/AssertData/table.csv\"\n \n//To compare table data to already written csv file you may use <a href=\"#read-csv-file\">read-csv-file</a> command:\n \nget-view \"Error Log\" | get-tree | get-table-data | select-columns \"Plug-in\" | eq [read-csv-file \"workspace:/MyProject/AssertData/table.csv\"] | assert-true \"Data in table does not match input file\" "
		   });	
		addAnnotation
		  (getWriteCsvFile_Table(), 
		   source, 
		   new String[] {
			 "description", "Table to write"
		   });	
		addAnnotation
		  (getWriteCsvFile_Uri(), 
		   source, 
		   new String[] {
			 "description", "URI to write CSV data to. Currently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system"
		   });	
		addAnnotation
		  (excludeColumnsEClass, 
		   source, 
		   new String[] {
			 "description", "Takes a table from input and returns the same table which has some columns excluded. ",
			 "returns", "Copy of input table object without columns with names listed in <code>columns</code>",
			 "example", "get-view \"Error Log\" | get-tree | get-table-data | exclude-columns \"Message\" \"Plug-in\" | write-csv-file \"workspace:/MyProject/AssertData/table.csv\""
		   });	
		addAnnotation
		  (getExcludeColumns_Table(), 
		   source, 
		   new String[] {
			 "description", "Table to exclude columns from"
		   });	
		addAnnotation
		  (getExcludeColumns_Columns(), 
		   source, 
		   new String[] {
			 "description", "Column names to exclude from table. It is OK to pass column names which are not present in table"
		   });	
		addAnnotation
		  (selectColumnsEClass, 
		   source, 
		   new String[] {
			 "description", "Takes a table from input and returns the table containing only columns passed into <code>columns</code> argument.",
			 "returns", "Copy of input table object with only columns with names listed in <code>columns</code>",
			 "example", "get-view \"Error Log\" | get-tree | get-table-data | select-columns \"Message\" | write-csv-file \"workspace:/MyProject/AssertData/table.csv\" "
		   });	
		addAnnotation
		  (getSelectColumns_Table(), 
		   source, 
		   new String[] {
			 "description", "Table to take columns from"
		   });	
		addAnnotation
		  (getSelectColumns_Columns(), 
		   source, 
		   new String[] {
			 "description", "Column names to take from table. If given column name is not present in input table, command fails"
		   });	
		addAnnotation
		  (assertTablesMatchEClass, 
		   source, 
		   new String[] {
			 "description", "Compares contents of two tables. If contents are not the same, fails with a descriptive message",
			 "example", "assert-tables-match [get-editor \"context\" | get-section Parameters | get-table | get-table-data ]\n                    [get-editor \"context2\" | get-section Parameters | get-table | get-table-data]"
		   });	
		addAnnotation
		  (getAssertTablesMatch_IgnoreColumnOrder(), 
		   source, 
		   new String[] {
			 "description", "When true, column order is not taken into account"
		   });	
		addAnnotation
		  (getAssertTablesMatch_IgnoreMissingColumns(), 
		   source, 
		   new String[] {
			 "description", "Describes the comparison behaviour in case when one of tables contains a column which is not present in other table:\n<ul>\n<li><b>NONE</b> &ndash; all columns must be present in both tables</li>\n<li><b>LEFT</b> &ndash; columns from right table which are not present in left, are ignored</li>\n<li><b>RIGHT</b> &ndash; columns from left table which are not present in right, are ignored</li>\n<li><b>BOTH</b> &ndash; comparison performed only on columns present in both tables</li>\n<p>Another way to interpret this argument is that it is an answer on question &quot;Which column can have less columns?&quot;</p>\n<p>The primary reasoning for this argument is to provide smooth migration when presentation is changed \u2013 consider this scenario: we have a CSV file with table data, and we have UI table. If we add or remove extra columns in the UI, we can keep existing sample data file and just correct the <code>ignoreMissingColumns</code> argument</p>\n"
		   });	
		addAnnotation
		  (writeLinesEClass, 
		   source, 
		   new String[] {
			 "description", "Reads objects from input pipe and writes them into file line-by-line as strings",
			 "example", "//writes a list of launch configuration into a file line-by-line\nlist-launch-configurations | write-lines -uri \"workspace:/Project/Folder/file.txt\"\n// appends \"New line\" into a file. \nstr \"New line\" | write-lines -uri \"workspace:/Project/Folder/file.txt\" -append\n"
		   });	
		addAnnotation
		  (getWriteLines_Uri(), 
		   source, 
		   new String[] {
			 "description", "URI to write lines to. Currently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system"
		   });	
		addAnnotation
		  (getWriteLines_Append(), 
		   source, 
		   new String[] {
			 "description", "Whether to append given lines into file. Default value is false"
		   });	
		addAnnotation
		  (readLinesEClass, 
		   source, 
		   new String[] {
			 "description", "Reads lines from file identified by uri and writes them one-by-one into output pipe",
			 "example", "//Displays alert with lines count\nshow-alert [concat \"The number of lines is \"[read-lines -uri \"workspace:/Project/Folder/file.txt\" | length | str]]\n\n"
		   });	
		addAnnotation
		  (getReadLines_Uri(), 
		   source, 
		   new String[] {
			 "description", "URI to read lines from. Currently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system"
		   });	
		addAnnotation
		  (selectRowsEClass, 
		   source, 
		   new String[] {
			 "description", "Takes a table from input and returns the table with rows filtered by column and criteria.",
			 "returns", "Copy of input table object with filtered rows.",
			 "example", "select-rows -column \"columnName\" -value \"value\" -match exact|glob|regexp"
		   });	
		addAnnotation
		  (getSelectRows_Table(), 
		   source, 
		   new String[] {
			 "description", "Table to take columns from"
		   });	
		addAnnotation
		  (getSelectRows_Column(), 
		   source, 
		   new String[] {
			 "description", "Column named to filter rows by."
		   });	
		addAnnotation
		  (getSelectRows_Value(), 
		   source, 
		   new String[] {
			 "description", "Pattern to match rows to."
		   });	
		addAnnotation
		  (getSelectRows_Match(), 
		   source, 
		   new String[] {
			 "description", "Describes the matching behaviour for rows.\r\n<ul>\r\n<li><b>glob</b> &ndash; wildcard matching</li>\r\n<li><b>exact</b> &ndash; value should be equals to pattern</li>\r\n<li><b>regexp</b> &ndash; value must match java regular expression</li>\r\n</ul>"
		   });	
		addAnnotation
		  (excludeRowsEClass, 
		   source, 
		   new String[] {
			 "description", "Takes a table from input and returns the table with rows filtered by column and criteria.",
			 "returns", "Copy of input table object with filtered rows.",
			 "example", "exclude-rows -column \"columnName\" -value \"value\" -match exact|glob|regex"
		   });	
		addAnnotation
		  (getExcludeRows_Table(), 
		   source, 
		   new String[] {
			 "description", "Table to take columns from"
		   });	
		addAnnotation
		  (getExcludeRows_Column(), 
		   source, 
		   new String[] {
			 "description", "Column named to filter rows by."
		   });	
		addAnnotation
		  (getExcludeRows_Value(), 
		   source, 
		   new String[] {
			 "description", "Pattern to match rows to."
		   });	
		addAnnotation
		  (getExcludeRows_Match(), 
		   source, 
		   new String[] {
			 "description", "Describes the matching behaviour for rows.\n<ul>\n<li><b>glob</b> &ndash; wildcard matching</li>\n<li><b>exact</b> &ndash; value should be equals to pattern</li>\n<li><b>regext</b> &ndash; value must match java regular expression</li>\n</ul>"
		   });	
		addAnnotation
		  (asTableDataEClass, 
		   source, 
		   new String[] {
			 "description", "Converts its input to table data format, exactly the same as <code>get-table-data</code> returns.",
			 "returns", "Table data.",
			 "example", "get-log -levels error | as-table-data | write-csv-file \"workspace:/Project/file2.csv\""
		   });	
		addAnnotation
		  (getAsTableData_Input(), 
		   source, 
		   new String[] {
			 "description", "Object(s) to convert from."
		   });	
		addAnnotation
		  (readPropertiesEClass, 
		   source, 
		   new String[] {
			 "description", "Parses given .properties file. Fails if file is not found or format is invalid",
			 "returns", "ECL map with values from properties file",
			 "example", "...get-item \"General Registers/pc\" | get-property \"values[\\\'Value\\\']\"\n| matches [format \"%s.*\" [read-properties -uri \"file:/C:/Users/Administrator/Desktop/p.properties\" | get myKey]] | verify-true\n"
		   });	
		addAnnotation
		  (getReadProperties_Uri(), 
		   source, 
		   new String[] {
			 "description", "URI to a file to read. Currently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system"
		   });	
		addAnnotation
		  (readFileEClass, 
		   source, 
		   new String[] {
			 "description", "Reads file identified by uri and writes it contents into output pipe",
			 "example", "//Displays alert with file content\r\nshow-alert [read-file \"file:/path/to/your/file\"]\r\n\r\n\r\n\r\n"
		   });	
		addAnnotation
		  (getReadFile_Uri(), 
		   source, 
		   new String[] {
			 "description", "URI to read file from. Currently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system"
		   });	
		addAnnotation
		  (setPageNameEClass, 
		   source, 
		   new String[] {
			 "description", "Set page name to table",
			 "returns", "The value of <code>table</code> argument.",
			 "example", "get-view \"Error Log\" | get-tree | expand-all\nget-view \"Error Log\" | get-tree | get-table-data\n\t| set-page-name \"Table\" | write-excel-file \"workspace:/MyProject/AssertData/table.xls\"\n\nread-excel-file \"workspace:/MyProject/AssertData/table.xls\"\n\t| get pageName | equals \"Table\" | assert-true"
		   });	
		addAnnotation
		  (getSetPageName_Table(), 
		   source, 
		   new String[] {
			 "description", "Table to set page name to"
		   });	
		addAnnotation
		  (getSetPageName_Name(), 
		   source, 
		   new String[] {
			 "description", "Page name to set"
		   });	
		addAnnotation
		  (listAsTableDataEClass, 
		   source, 
		   new String[] {
			 "description", "Converts input list to table data format",
			 "returns", "<code>Table</code> EMF Object",
			 "example", "proc newTable [val table] [val name] {\n\t$table | list-as-table-data | set-page-name $name\n}\n\nglobal [val devices [list\n\t[list \"Device Name\" \"Device Target\"]\n\t[list \"Device 1\" \"Info 1\"]\n\t[list \"Device 2\" \"Info 2\"]\n\t[list \"Device 3\" \"Info 3\"]\n]]\n\nnewTable $devices \"Devices\"\n\t| write-excel-file \"workspace:/excel/devices.xls\""
		   });	
		addAnnotation
		  (getListAsTableData_List(), 
		   source, 
		   new String[] {
			 "description", "List of List of String to convert to Table"
		   });	
		addAnnotation
		  (readXmlFileEClass, 
		   source, 
		   new String[] {
			 "description", "Parses given xml file into tree and write it to output pipe. Fails if file is not found or if it is invalid xml.",
			 "returns", "<code>Tree</code> EMF Object",
			 "example", "proc logDevice [val device] {\n\tif [$device | has-attr \"id\"] {\n\t\tlog [format \"Device ID: %s\" [$device | get-attr \"id\"]]\n\t}\n\tlog [format \"Device Name: %s\" [$device | get-nodes \"DeviceName\" | get text]]\n\tlog [format \"Device Target: %s\" [$device | get-nodes \"DeviceTarget\"  | get text]]\n}\n \n \nglobal [val supportedDevices [\n\tread-xml-file \"workspace:/xml/devices.xml\"\n\t\t| get-nodes \"SupportedDevices\" | get-nodes \"Device\" | to-list\n]]\n \n$supportedDevices | each [val device] {\n\tlogDevice $device\n}"
		   });	
		addAnnotation
		  (getReadXmlFile_Uri(), 
		   source, 
		   new String[] {
			 "description", "URI to read xml data from. Currently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system"
		   });	
		addAnnotation
		  (getReadXmlFile_XPath(), 
		   source, 
		   new String[] {
			 "description", "XPath expression to find xml nodes"
		   });	
		addAnnotation
		  (writeXmlFileEClass, 
		   source, 
		   new String[] {
			 "description", "Writes tree from input pipe to into xml file",
			 "returns", "The value of <code>tree</code> argument",
			 "example", "proc newDevice [val id] [val name] [val target] {\n\ttree-node \"Device\"\n\t\t[map [entry \"id\" $id]]\n\t\t[tree-node -name \"DeviceName\" -text $name]\n\t\t[tree-node -name \"DeviceTarget\" -text $target]\n}\n \n \nglobal [val supportedDevices [tree-node \"SupportedDevices\"\n\t[newDevice \"1\" \"device 1\" \"target 1\"]\n\t[newDevice \"2\" \"device 2\" \"target 2\"]\n\t[newDevice \"3\" \"device 3\" \"target 3\"]\n]]\n \nglobal [val allDevices [tree-node \"AllDevices\"\n\t[newDevice \"1\" \"device 1\" \"target 1\"]\n\t[newDevice \"2\" \"device 2\" \"target 2\"]\n\t[newDevice \"3\" \"device 3\" \"target 3\"]\n\t[newDevice \"4\" \"device 4\" \"target 4\"]\n\t[newDevice \"5\" \"device 5\" \"target 5\"]\n]]\n \nglobal [val tree [\n\ttree-node \"DevicesInfo\" $supportedDevices $allDevices\n]]\n \n$tree | write-xml-file \"workspace:/xml/devices.xml\""
		   });	
		addAnnotation
		  (getWriteXmlFile_Tree(), 
		   source, 
		   new String[] {
			 "description", "Tree to write"
		   });	
		addAnnotation
		  (getWriteXmlFile_Uri(), 
		   source, 
		   new String[] {
			 "description", "URI to write xml data to. Currently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system"
		   });	
		addAnnotation
		  (treeNodeEClass, 
		   source, 
		   new String[] {
			 "description", "Creates a new tree node",
			 "returns", "<code>Tree</code> EMF Object",
			 "example", "tree-node \"Device\"\n\t[map [entry \"id\" \"1\"]]\n\t[tree-node -name \"DeviceName\" -text \"device\"]\n\t[tree-node -name \"DeviceTarget\" -text \"target\"]"
		   });	
		addAnnotation
		  (getTreeNode_Name(), 
		   source, 
		   new String[] {
			 "description", "Name of the new node"
		   });	
		addAnnotation
		  (getTreeNode_Attrs(), 
		   source, 
		   new String[] {
			 "description", "Map with node attributes"
		   });	
		addAnnotation
		  (getTreeNode_Children(), 
		   source, 
		   new String[] {
			 "description", "Children of the new node"
		   });	
		addAnnotation
		  (getTreeNode_Text(), 
		   source, 
		   new String[] {
			 "description", "Text of the new node"
		   });	
		addAnnotation
		  (getAttrsEClass, 
		   source, 
		   new String[] {
			 "description", "Gets attributes from the object",
			 "returns", "Map with object attributes",
			 "example", "tree-node \"Device\" [map [entry \"id\" \"1\"] [entry \"name\" \"first\"]]\n\t| get-attrs | get \"name\" | log"
		   });	
		addAnnotation
		  (getGetAttrs_Object(), 
		   source, 
		   new String[] {
			 "description", "Object to get attributes from"
		   });	
		addAnnotation
		  (getAttrEClass, 
		   source, 
		   new String[] {
			 "description", "Gets attribute from the object by name. Fails if attribute is not found.",
			 "returns", "Value of the attribute",
			 "example", "tree-node \"Device\" [map [entry \"id\" \"1\"] [entry \"name\" \"first\"]]\n\t| get-attr \"name\" | log"
		   });	
		addAnnotation
		  (getGetAttr_Object(), 
		   source, 
		   new String[] {
			 "description", "Tree node to get attribute from"
		   });	
		addAnnotation
		  (getGetAttr_Name(), 
		   source, 
		   new String[] {
			 "description", "Name of the attribute"
		   });	
		addAnnotation
		  (setAttrEClass, 
		   source, 
		   new String[] {
			 "description", "Sets value of the object attribute. If <code>value</code> parameter is not specified, the attribute will be removed.",
			 "returns", "The value of <code>object</code> argument",
			 "example", "tree-node \"Device\" [map [entry \"id\" \"1\"] [entry \"name\" \"first\"]]\n\t| get-attr \"name\" | log\n\n\n--set-attr-\n\n\n\ntree-node \"Device\" [map [entry \"id\" \"1\"] [entry \"name\" \"first\"]]\n\t| set-attr \"name\" \"second\" | get-attr \"name\" | log"
		   });	
		addAnnotation
		  (getSetAttr_Object(), 
		   source, 
		   new String[] {
			 "description", "Object to set attribute to"
		   });	
		addAnnotation
		  (getSetAttr_Name(), 
		   source, 
		   new String[] {
			 "description", "Name of the attribute"
		   });	
		addAnnotation
		  (getSetAttr_Value(), 
		   source, 
		   new String[] {
			 "description", "New value of the attribute"
		   });	
		addAnnotation
		  (hasAttrEClass, 
		   source, 
		   new String[] {
			 "description", "Checks if the object has attribute",
			 "returns", "<code>true</code> when attribute is exist, <code>false</code> otherwise",
			 "example", "tree-node \"Device\" [map [entry \"id\" \"1\"] [entry \"name\" \"first\"]]\n\t| has-attr \"name\" | log"
		   });	
		addAnnotation
		  (getHasAttr_Object(), 
		   source, 
		   new String[] {
			 "description", "Object to check attribute from"
		   });	
		addAnnotation
		  (getHasAttr_Name(), 
		   source, 
		   new String[] {
			 "description", "Name of the attribute"
		   });	
		addAnnotation
		  (getNodesEClass, 
		   source, 
		   new String[] {
			 "description", "Gets child nodes from the object and writes them into output pipe. Fails if <code>pos</code> of <code>len</code> parameter is out of range.",
			 "returns", "Child nodes of the object",
			 "example", "proc newDevice [val id] [val name] [val target] {\n\ttree-node \"Device\"\n\t\t[map [entry \"id\" $id]]\n\t\t[tree-node -name \"DeviceName\" -text $name]\n\t\t[tree-node -name \"DeviceTarget\" -text $target]\n}\n \nglobal [val supportedDevices [tree-node \"SupportedDevices\"\n\t[newDevice \"1\" \"device 1\" \"target 1\"]\n\t[newDevice \"2\" \"device 2\" \"target 2\"]\n\t[newDevice \"3\" \"device 3\" \"target 3\"]\n]]\n \n$supportedDevices | get-nodes \"Device\" -pos 1 -len 1\n\t| get-nodes \"DeviceName\" | get text\n\t| equals \"device 2\" | verify-true"
		   });	
		addAnnotation
		  (getGetNodes_Object(), 
		   source, 
		   new String[] {
			 "description", "Object to get child nodes from"
		   });	
		addAnnotation
		  (getGetNodes_Name(), 
		   source, 
		   new String[] {
			 "description", "Name of the nodes"
		   });	
		addAnnotation
		  (getGetNodes_Pos(), 
		   source, 
		   new String[] {
			 "description", "Start position. If <code>name</code> attribute is provided, <code>pos</code> is relative to the node list filtered by name."
		   });	
		addAnnotation
		  (getGetNodes_Len(), 
		   source, 
		   new String[] {
			 "description", "Count of nodes. Default value is <code>-1</code> and it means the end of the node list. If <code>name</code> attribute is provided, <code>len</code> is relative to the node list filtered by name."
		   });	
		addAnnotation
		  (appendEClass, 
		   source, 
		   new String[] {
			 "description", "Adds child nodes to the object. Fails if <code>index</code> parameter is out of range.",
			 "returns", "The value of <code>object</code> argument",
			 "example", "tree-node \"Device\" [tree-node -name \"DeviceName\" -text \"device\"]\n\t| append [tree-node -name \"DeviceTarget\" -text \"target\"] -index 0"
		   });	
		addAnnotation
		  (getAppend_Object(), 
		   source, 
		   new String[] {
			 "description", "Object to add child nodes to"
		   });	
		addAnnotation
		  (getAppend_Children(), 
		   source, 
		   new String[] {
			 "description", "New child nodes to add to the object"
		   });	
		addAnnotation
		  (getAppend_Index(), 
		   source, 
		   new String[] {
			 "description", "Index of the first child node added in the node list. Min value is <code>0</code> and max value is size of node list. Default value is <code>-1</code> and it means size of node list."
		   });	
		addAnnotation
		  (removeEClass, 
		   source, 
		   new String[] {
			 "description", "Removes child node from the object by index. Fails if <code>index</code> parameter is out of range.",
			 "returns", "The value of <code>object</code> argument",
			 "example", "tree-node \"Device\"\n\t[tree-node -name \"DeviceName\" -text \"device\"]\n\t[tree-node -name \"DeviceTarget\" -text \"target\"]\n\t\t| remove -index 1"
		   });	
		addAnnotation
		  (getRemove_Object(), 
		   source, 
		   new String[] {
			 "description", "Object to remove child node from"
		   });	
		addAnnotation
		  (getRemove_Index(), 
		   source, 
		   new String[] {
			 "description", "Index of the child node. Min value is <code>0</code> and max value is the last index in the node list. Default value is <code>-1</code> and the last index in the node list."
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/internal</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createInternalAnnotations() {
		String source = "http://www.eclipse.org/ecl/internal";	
		addAnnotation
		  (printEClass, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/input</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createInputAnnotations() {
		String source = "http://www.eclipse.org/ecl/input";	
		addAnnotation
		  (getPrint_Input(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getWriteCsvFile_Table(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getExcludeColumns_Table(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSelectColumns_Table(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReadLines_Uri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSelectRows_Table(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getExcludeRows_Table(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAsTableData_Input(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getReadFile_Uri(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSetPageName_Table(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getListAsTableData_List(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getWriteXmlFile_Tree(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getGetAttrs_Object(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getGetAttr_Object(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSetAttr_Object(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getHasAttr_Object(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getGetNodes_Object(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAppend_Object(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRemove_Object(), 
		   source, 
		   new String[] {
		   });
	}

} //CommandsPackageImpl
