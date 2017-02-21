/**
 */
package org.eclipse.rcptt.ecl.data.apache.poi.commands;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.ecl.data.apache.poi.commands.CommandsPackage
 * @generated
 */
public interface CommandsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommandsFactory eINSTANCE = org.eclipse.rcptt.ecl.data.apache.poi.commands.impl.CommandsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Write Excel File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Write Excel File</em>'.
	 * @generated
	 */
	WriteExcelFile createWriteExcelFile();

	/**
	 * Returns a new object of class '<em>Read Excel File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Read Excel File</em>'.
	 * @generated
	 */
	ReadExcelFile createReadExcelFile();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CommandsPackage getCommandsPackage();

} //CommandsFactory
