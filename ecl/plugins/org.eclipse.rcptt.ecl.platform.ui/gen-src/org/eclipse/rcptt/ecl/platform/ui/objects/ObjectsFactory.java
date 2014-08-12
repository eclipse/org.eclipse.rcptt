/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.ecl.platform.ui.objects;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.ecl.platform.ui.objects.ObjectsPackage
 * @generated
 */
public interface ObjectsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ObjectsFactory eINSTANCE = org.eclipse.rcptt.ecl.platform.ui.objects.impl.ObjectsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Working Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Working Set</em>'.
	 * @generated
	 */
	WorkingSet createWorkingSet();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ObjectsPackage getObjectsPackage();

} //ObjectsFactory
