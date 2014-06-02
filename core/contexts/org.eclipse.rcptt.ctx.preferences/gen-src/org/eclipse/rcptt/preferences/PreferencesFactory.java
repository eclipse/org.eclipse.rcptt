/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.preferences;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.preferences.PreferencesPackage
 * @generated
 */
public interface PreferencesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PreferencesFactory eINSTANCE = org.eclipse.rcptt.preferences.impl.PreferencesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Context</em>'.
	 * @generated
	 */
	PreferencesContext createPreferencesContext();

	/**
	 * Returns a new object of class '<em>Pref Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pref Node</em>'.
	 * @generated
	 */
	PrefNode createPrefNode();

	/**
	 * Returns a new object of class '<em>Settings Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Settings Node</em>'.
	 * @generated
	 */
	SettingsNode createSettingsNode();

	/**
	 * Returns a new object of class '<em>String Pref Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Pref Data</em>'.
	 * @generated
	 */
	StringPrefData createStringPrefData();

	/**
	 * Returns a new object of class '<em>List Pref Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Pref Data</em>'.
	 * @generated
	 */
	ListPrefData createListPrefData();

	/**
	 * Returns a new object of class '<em>Secure Pref Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Secure Pref Node</em>'.
	 * @generated
	 */
	SecurePrefNode createSecurePrefNode();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PreferencesPackage getPreferencesPackage();

} //PreferencesFactory
