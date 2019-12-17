/*******************************************************************************
 * Copyright (c) 2014-2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.preferences;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.core.scenario.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.preferences.PreferencesContext#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.rcptt.preferences.PreferencesContext#isCleanPreferences <em>Clean Preferences</em>}</li>
 *   <li>{@link org.eclipse.rcptt.preferences.PreferencesContext#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.preferences.PreferencesPackage#getPreferencesContext()
 * @model
 * @generated
 */
public interface PreferencesContext extends Context {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.preferences.PrefNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' containment reference list.
	 * @see org.eclipse.rcptt.preferences.PreferencesPackage#getPreferencesContext_Content()
	 * @model containment="true"
	 * @generated
	 */
	EList<PrefNode> getContent();

	/**
	 * Returns the value of the '<em><b>Clean Preferences</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clean Preferences</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clean Preferences</em>' attribute.
	 * @see #setCleanPreferences(boolean)
	 * @see org.eclipse.rcptt.preferences.PreferencesPackage#getPreferencesContext_CleanPreferences()
	 * @model
	 * @generated
	 */
	boolean isCleanPreferences();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.preferences.PreferencesContext#isCleanPreferences <em>Clean Preferences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clean Preferences</em>' attribute.
	 * @see #isCleanPreferences()
	 * @generated
	 */
	void setCleanPreferences(boolean value);

	/**
	 * Returns the value of the '<em><b>Settings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settings</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settings</em>' containment reference.
	 * @see #setSettings(SettingsNode)
	 * @see org.eclipse.rcptt.preferences.PreferencesPackage#getPreferencesContext_Settings()
	 * @model containment="true"
	 * @generated
	 */
	SettingsNode getSettings();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.preferences.PreferencesContext#getSettings <em>Settings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Settings</em>' containment reference.
	 * @see #getSettings()
	 * @generated
	 */
	void setSettings(SettingsNode value);

} // PreferencesContext
