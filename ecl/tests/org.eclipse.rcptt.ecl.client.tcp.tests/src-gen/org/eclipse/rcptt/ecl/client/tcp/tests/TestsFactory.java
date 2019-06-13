/**
 */
package org.eclipse.rcptt.ecl.client.tcp.tests;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.ecl.client.tcp.tests.TestsPackage
 * @generated
 */
public interface TestsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestsFactory eINSTANCE = org.eclipse.rcptt.ecl.client.tcp.tests.impl.TestsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ecl Injected Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecl Injected Command</em>'.
	 * @generated
	 */
	EclInjectedCommand createEclInjectedCommand();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TestsPackage getTestsPackage();

} //TestsFactory
