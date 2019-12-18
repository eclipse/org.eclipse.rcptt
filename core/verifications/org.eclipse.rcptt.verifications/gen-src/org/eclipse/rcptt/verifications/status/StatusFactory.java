/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.verifications.status;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.verifications.status.StatusPackage
 * @generated
 */
public interface StatusFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatusFactory eINSTANCE = org.eclipse.rcptt.verifications.status.impl.StatusFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EVerification Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EVerification Status</em>'.
	 * @generated
	 */
	EVerificationStatus createEVerificationStatus();

	/**
	 * Returns a new object of class '<em>Verification Status Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Verification Status Data</em>'.
	 * @generated
	 */
	VerificationStatusData createVerificationStatusData();

	/**
	 * Returns a new object of class '<em>Tree Item Verification Error</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tree Item Verification Error</em>'.
	 * @generated
	 */
	TreeItemVerificationError createTreeItemVerificationError();

	/**
	 * Returns a new object of class '<em>Tree Item Style Verification Error</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tree Item Style Verification Error</em>'.
	 * @generated
	 */
	TreeItemStyleVerificationError createTreeItemStyleVerificationError();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StatusPackage getStatusPackage();

} //StatusFactory
