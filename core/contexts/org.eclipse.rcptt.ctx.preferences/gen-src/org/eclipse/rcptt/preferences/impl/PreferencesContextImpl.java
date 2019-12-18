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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.rcptt.core.scenario.impl.ContextImpl;

import org.eclipse.rcptt.preferences.PrefNode;
import org.eclipse.rcptt.preferences.PreferencesContext;
import org.eclipse.rcptt.preferences.PreferencesPackage;
import org.eclipse.rcptt.preferences.SettingsNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.preferences.impl.PreferencesContextImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.rcptt.preferences.impl.PreferencesContextImpl#isCleanPreferences <em>Clean Preferences</em>}</li>
 *   <li>{@link org.eclipse.rcptt.preferences.impl.PreferencesContextImpl#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PreferencesContextImpl extends ContextImpl implements PreferencesContext {
	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected EList<PrefNode> content;

	/**
	 * The default value of the '{@link #isCleanPreferences() <em>Clean Preferences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCleanPreferences()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLEAN_PREFERENCES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCleanPreferences() <em>Clean Preferences</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCleanPreferences()
	 * @generated
	 * @ordered
	 */
	protected boolean cleanPreferences = CLEAN_PREFERENCES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSettings() <em>Settings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSettings()
	 * @generated
	 * @ordered
	 */
	protected SettingsNode settings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreferencesContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PreferencesPackage.Literals.PREFERENCES_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PrefNode> getContent() {
		if (content == null) {
			content = new EObjectContainmentEList<PrefNode>(PrefNode.class, this, PreferencesPackage.PREFERENCES_CONTEXT__CONTENT);
		}
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCleanPreferences() {
		return cleanPreferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCleanPreferences(boolean newCleanPreferences) {
		boolean oldCleanPreferences = cleanPreferences;
		cleanPreferences = newCleanPreferences;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreferencesPackage.PREFERENCES_CONTEXT__CLEAN_PREFERENCES, oldCleanPreferences, cleanPreferences));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SettingsNode getSettings() {
		return settings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSettings(SettingsNode newSettings, NotificationChain msgs) {
		SettingsNode oldSettings = settings;
		settings = newSettings;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PreferencesPackage.PREFERENCES_CONTEXT__SETTINGS, oldSettings, newSettings);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSettings(SettingsNode newSettings) {
		if (newSettings != settings) {
			NotificationChain msgs = null;
			if (settings != null)
				msgs = ((InternalEObject)settings).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PreferencesPackage.PREFERENCES_CONTEXT__SETTINGS, null, msgs);
			if (newSettings != null)
				msgs = ((InternalEObject)newSettings).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PreferencesPackage.PREFERENCES_CONTEXT__SETTINGS, null, msgs);
			msgs = basicSetSettings(newSettings, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PreferencesPackage.PREFERENCES_CONTEXT__SETTINGS, newSettings, newSettings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PreferencesPackage.PREFERENCES_CONTEXT__CONTENT:
				return ((InternalEList<?>)getContent()).basicRemove(otherEnd, msgs);
			case PreferencesPackage.PREFERENCES_CONTEXT__SETTINGS:
				return basicSetSettings(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PreferencesPackage.PREFERENCES_CONTEXT__CONTENT:
				return getContent();
			case PreferencesPackage.PREFERENCES_CONTEXT__CLEAN_PREFERENCES:
				return isCleanPreferences();
			case PreferencesPackage.PREFERENCES_CONTEXT__SETTINGS:
				return getSettings();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PreferencesPackage.PREFERENCES_CONTEXT__CONTENT:
				getContent().clear();
				getContent().addAll((Collection<? extends PrefNode>)newValue);
				return;
			case PreferencesPackage.PREFERENCES_CONTEXT__CLEAN_PREFERENCES:
				setCleanPreferences((Boolean)newValue);
				return;
			case PreferencesPackage.PREFERENCES_CONTEXT__SETTINGS:
				setSettings((SettingsNode)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PreferencesPackage.PREFERENCES_CONTEXT__CONTENT:
				getContent().clear();
				return;
			case PreferencesPackage.PREFERENCES_CONTEXT__CLEAN_PREFERENCES:
				setCleanPreferences(CLEAN_PREFERENCES_EDEFAULT);
				return;
			case PreferencesPackage.PREFERENCES_CONTEXT__SETTINGS:
				setSettings((SettingsNode)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PreferencesPackage.PREFERENCES_CONTEXT__CONTENT:
				return content != null && !content.isEmpty();
			case PreferencesPackage.PREFERENCES_CONTEXT__CLEAN_PREFERENCES:
				return cleanPreferences != CLEAN_PREFERENCES_EDEFAULT;
			case PreferencesPackage.PREFERENCES_CONTEXT__SETTINGS:
				return settings != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (cleanPreferences: ");
		result.append(cleanPreferences);
		result.append(')');
		return result.toString();
	}

} //PreferencesContextImpl
