/**
 */
package org.eclipse.rcptt.tesla.ecl.rap.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage
 * @generated
 */
public interface RapTeslaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RapTeslaFactory eINSTANCE = org.eclipse.rcptt.tesla.ecl.rap.model.impl.RapTeslaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Run Js</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Run Js</em>'.
	 * @generated
	 */
	RunJs createRunJs();

	/**
	 * Returns a new object of class '<em>Exec Without Js</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exec Without Js</em>'.
	 * @generated
	 */
	ExecWithoutJs createExecWithoutJs();

	/**
	 * Returns a new object of class '<em>Mark Download Handler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mark Download Handler</em>'.
	 * @generated
	 */
	MarkDownloadHandler createMarkDownloadHandler();

	/**
	 * Returns a new object of class '<em>Upload File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Upload File</em>'.
	 * @generated
	 */
	UploadFile createUploadFile();

	/**
	 * Returns a new object of class '<em>Download File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Download File</em>'.
	 * @generated
	 */
	DownloadFile createDownloadFile();

	/**
	 * Returns a new object of class '<em>To String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>To String</em>'.
	 * @generated
	 */
	ToString createToString();

	/**
	 * Returns a new object of class '<em>Match Binary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Match Binary</em>'.
	 * @generated
	 */
	MatchBinary createMatchBinary();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RapTeslaPackage getRapTeslaPackage();

} //RapTeslaFactory
