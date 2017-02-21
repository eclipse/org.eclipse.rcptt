/**
 */
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
	 * The number of structural features of the '<em>Write Excel File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WRITE_EXCEL_FILE_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 2;

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

	}

} //CommandsPackage
