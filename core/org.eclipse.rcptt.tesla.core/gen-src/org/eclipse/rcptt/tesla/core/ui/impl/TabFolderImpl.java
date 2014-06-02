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
package org.eclipse.rcptt.tesla.core.ui.impl;

import org.eclipse.rcptt.tesla.core.ui.TabFolder;
import org.eclipse.rcptt.tesla.core.ui.UiPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tab Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TabFolderImpl#getSelection <em>Selection</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TabFolderImpl#getPages <em>Pages</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TabFolderImpl#getActivePage <em>Active Page</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TabFolderImpl#getTabCount <em>Tab Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TabFolderImpl extends ControlImpl implements TabFolder {
	/**
	 * The default value of the '{@link #getSelection() <em>Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelection()
	 * @generated
	 * @ordered
	 */
	protected static final String SELECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSelection() <em>Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelection()
	 * @generated
	 * @ordered
	 */
	protected String selection = SELECTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPages() <em>Pages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPages()
	 * @generated
	 * @ordered
	 */
	protected EList<String> pages;

	/**
	 * The default value of the '{@link #getActivePage() <em>Active Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivePage()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTIVE_PAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActivePage() <em>Active Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivePage()
	 * @generated
	 * @ordered
	 */
	protected String activePage = ACTIVE_PAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTabCount() <em>Tab Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTabCount()
	 * @generated
	 * @ordered
	 */
	protected static final int TAB_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTabCount() <em>Tab Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTabCount()
	 * @generated
	 * @ordered
	 */
	protected int tabCount = TAB_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TabFolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiPackage.Literals.TAB_FOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSelection() {
		return selection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelection(String newSelection) {
		String oldSelection = selection;
		selection = newSelection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TAB_FOLDER__SELECTION, oldSelection, selection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPages() {
		if (pages == null) {
			pages = new EDataTypeEList<String>(String.class, this, UiPackage.TAB_FOLDER__PAGES);
		}
		return pages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActivePage() {
		return activePage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivePage(String newActivePage) {
		String oldActivePage = activePage;
		activePage = newActivePage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TAB_FOLDER__ACTIVE_PAGE, oldActivePage, activePage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTabCount() {
		return tabCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTabCount(int newTabCount) {
		int oldTabCount = tabCount;
		tabCount = newTabCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TAB_FOLDER__TAB_COUNT, oldTabCount, tabCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UiPackage.TAB_FOLDER__SELECTION:
				return getSelection();
			case UiPackage.TAB_FOLDER__PAGES:
				return getPages();
			case UiPackage.TAB_FOLDER__ACTIVE_PAGE:
				return getActivePage();
			case UiPackage.TAB_FOLDER__TAB_COUNT:
				return getTabCount();
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
			case UiPackage.TAB_FOLDER__SELECTION:
				setSelection((String)newValue);
				return;
			case UiPackage.TAB_FOLDER__PAGES:
				getPages().clear();
				getPages().addAll((Collection<? extends String>)newValue);
				return;
			case UiPackage.TAB_FOLDER__ACTIVE_PAGE:
				setActivePage((String)newValue);
				return;
			case UiPackage.TAB_FOLDER__TAB_COUNT:
				setTabCount((Integer)newValue);
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
			case UiPackage.TAB_FOLDER__SELECTION:
				setSelection(SELECTION_EDEFAULT);
				return;
			case UiPackage.TAB_FOLDER__PAGES:
				getPages().clear();
				return;
			case UiPackage.TAB_FOLDER__ACTIVE_PAGE:
				setActivePage(ACTIVE_PAGE_EDEFAULT);
				return;
			case UiPackage.TAB_FOLDER__TAB_COUNT:
				setTabCount(TAB_COUNT_EDEFAULT);
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
			case UiPackage.TAB_FOLDER__SELECTION:
				return SELECTION_EDEFAULT == null ? selection != null : !SELECTION_EDEFAULT.equals(selection);
			case UiPackage.TAB_FOLDER__PAGES:
				return pages != null && !pages.isEmpty();
			case UiPackage.TAB_FOLDER__ACTIVE_PAGE:
				return ACTIVE_PAGE_EDEFAULT == null ? activePage != null : !ACTIVE_PAGE_EDEFAULT.equals(activePage);
			case UiPackage.TAB_FOLDER__TAB_COUNT:
				return tabCount != TAB_COUNT_EDEFAULT;
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
		result.append(" (selection: ");
		result.append(selection);
		result.append(", pages: ");
		result.append(pages);
		result.append(", activePage: ");
		result.append(activePage);
		result.append(", tabCount: ");
		result.append(tabCount);
		result.append(')');
		return result.toString();
	}

} //TabFolderImpl
