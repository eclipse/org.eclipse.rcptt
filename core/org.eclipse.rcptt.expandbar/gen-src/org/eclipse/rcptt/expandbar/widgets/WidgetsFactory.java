/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.expandbar.widgets;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.expandbar.widgets.WidgetsPackage
 * @generated
 */
public interface WidgetsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WidgetsFactory eINSTANCE = org.eclipse.rcptt.expandbar.widgets.impl.WidgetsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Expand Bar</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expand Bar</em>'.
	 * @generated
	 */
	ExpandBar createExpandBar();

	/**
	 * Returns a new object of class '<em>Expand Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expand Item</em>'.
	 * @generated
	 */
	ExpandItem createExpandItem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WidgetsPackage getWidgetsPackage();

} //WidgetsFactory
