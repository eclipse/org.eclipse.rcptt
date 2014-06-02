/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.tesla.ecl.nebula;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage
 * @generated
 */
public interface NebulaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NebulaFactory eINSTANCE = org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Get Nebula Grid</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Nebula Grid</em>'.
	 * @generated
	 */
	GetNebulaGrid createGetNebulaGrid();

	/**
	 * Returns a new object of class '<em>Grid</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grid</em>'.
	 * @generated
	 */
	NebulaGrid createNebulaGrid();

	/**
	 * Returns a new object of class '<em>Grid Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grid Item</em>'.
	 * @generated
	 */
	NebulaGridItem createNebulaGridItem();

	/**
	 * Returns a new object of class '<em>Grid Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grid Column</em>'.
	 * @generated
	 */
	NebulaGridColumn createNebulaGridColumn();

	/**
	 * Returns a new object of class '<em>Get Row Header</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Row Header</em>'.
	 * @generated
	 */
	GetRowHeader createGetRowHeader();

	/**
	 * Returns a new object of class '<em>Get Item Cell</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Item Cell</em>'.
	 * @generated
	 */
	GetItemCell createGetItemCell();

	/**
	 * Returns a new object of class '<em>Get Empty Area</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Empty Area</em>'.
	 * @generated
	 */
	GetEmptyArea createGetEmptyArea();

	/**
	 * Returns a new object of class '<em>Select Grid Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select Grid Range</em>'.
	 * @generated
	 */
	SelectGridRange createSelectGridRange();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NebulaPackage getNebulaPackage();

} //NebulaFactory
