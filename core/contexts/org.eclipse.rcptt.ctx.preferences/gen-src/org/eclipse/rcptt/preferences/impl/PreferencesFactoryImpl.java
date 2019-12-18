/*******************************************************************************
 * Copyright (c) 2014-2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.preferences.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.rcptt.preferences.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PreferencesFactoryImpl extends EFactoryImpl implements PreferencesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PreferencesFactory init() {
		try {
			PreferencesFactory thePreferencesFactory = (PreferencesFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/rcptt/ctx/preferences"); 
			if (thePreferencesFactory != null) {
				return thePreferencesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PreferencesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreferencesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PreferencesPackage.PREFERENCES_CONTEXT: return createPreferencesContext();
			case PreferencesPackage.PREF_NODE: return createPrefNode();
			case PreferencesPackage.SETTINGS_NODE: return createSettingsNode();
			case PreferencesPackage.STRING_PREF_DATA: return createStringPrefData();
			case PreferencesPackage.LIST_PREF_DATA: return createListPrefData();
			case PreferencesPackage.SECURE_PREF_NODE: return createSecurePrefNode();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreferencesContext createPreferencesContext() {
		PreferencesContextImpl preferencesContext = new PreferencesContextImpl();
		return preferencesContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrefNode createPrefNode() {
		PrefNodeImpl prefNode = new PrefNodeImpl();
		return prefNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SettingsNode createSettingsNode() {
		SettingsNodeImpl settingsNode = new SettingsNodeImpl();
		return settingsNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringPrefData createStringPrefData() {
		StringPrefDataImpl stringPrefData = new StringPrefDataImpl();
		return stringPrefData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListPrefData createListPrefData() {
		ListPrefDataImpl listPrefData = new ListPrefDataImpl();
		return listPrefData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecurePrefNode createSecurePrefNode() {
		SecurePrefNodeImpl securePrefNode = new SecurePrefNodeImpl();
		return securePrefNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreferencesPackage getPreferencesPackage() {
		return (PreferencesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PreferencesPackage getPackage() {
		return PreferencesPackage.eINSTANCE;
	}

} //PreferencesFactoryImpl
