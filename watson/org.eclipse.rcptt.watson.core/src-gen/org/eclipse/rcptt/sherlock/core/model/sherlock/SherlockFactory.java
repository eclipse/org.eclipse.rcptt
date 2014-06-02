/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.sherlock.core.model.sherlock;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage
 * @generated
 */
public interface SherlockFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SherlockFactory eINSTANCE = org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>System Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Info</em>'.
	 * @generated
	 */
	SystemInfo createSystemInfo();

	/**
	 * Returns a new object of class '<em>System Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Variable</em>'.
	 * @generated
	 */
	SystemVariable createSystemVariable();

	/**
	 * Returns a new object of class '<em>Java Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Info</em>'.
	 * @generated
	 */
	JavaInfo createJavaInfo();

	/**
	 * Returns a new object of class '<em>Java Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Property</em>'.
	 * @generated
	 */
	JavaProperty createJavaProperty();

	/**
	 * Returns a new object of class '<em>Eclipse Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eclipse Info</em>'.
	 * @generated
	 */
	EclipseInfo createEclipseInfo();

	/**
	 * Returns a new object of class '<em>Eclipse Plugin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eclipse Plugin</em>'.
	 * @generated
	 */
	EclipsePlugin createEclipsePlugin();

	/**
	 * Returns a new object of class '<em>Eclipse Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eclipse Feature</em>'.
	 * @generated
	 */
	EclipseFeature createEclipseFeature();

	/**
	 * Returns a new object of class '<em>Java Exception</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Exception</em>'.
	 * @generated
	 */
	JavaException createJavaException();

	/**
	 * Returns a new object of class '<em>Java Stack Trace Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Stack Trace Entry</em>'.
	 * @generated
	 */
	JavaStackTraceEntry createJavaStackTraceEntry();

	/**
	 * Returns a new object of class '<em>Eclipse Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eclipse Status</em>'.
	 * @generated
	 */
	EclipseStatus createEclipseStatus();

	/**
	 * Returns a new object of class '<em>Eclipse Preference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eclipse Preference</em>'.
	 * @generated
	 */
	EclipsePreference createEclipsePreference();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SherlockPackage getSherlockPackage();

} //SherlockFactory
