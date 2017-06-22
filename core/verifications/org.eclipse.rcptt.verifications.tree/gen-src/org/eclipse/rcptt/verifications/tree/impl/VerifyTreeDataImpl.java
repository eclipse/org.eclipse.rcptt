/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.verifications.tree.impl;

import java.util.Collection;
import org.eclipse.rcptt.verifications.tree.TreePackage;
import org.eclipse.rcptt.verifications.tree.VerifyStyleType;
import org.eclipse.rcptt.verifications.tree.VerifyTreeData;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verify Tree Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.VerifyTreeDataImpl#isAllowExtraColumns <em>Allow Extra Columns</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.VerifyTreeDataImpl#isAllowMissingColumns <em>Allow Missing Columns</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.VerifyTreeDataImpl#getVerifyStyle <em>Verify Style</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.VerifyTreeDataImpl#isVerifyIcons <em>Verify Icons</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.VerifyTreeDataImpl#isAllowUncapturedChildren <em>Allow Uncaptured Children</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.VerifyTreeDataImpl#isEnableVerifyStyle <em>Enable Verify Style</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.VerifyTreeDataImpl#getExcludedColumns <em>Excluded Columns</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VerifyTreeDataImpl extends CommonTreeVerificationDataImpl implements VerifyTreeData {
	/**
	 * The default value of the '{@link #isAllowExtraColumns() <em>Allow Extra Columns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowExtraColumns()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_EXTRA_COLUMNS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowExtraColumns() <em>Allow Extra Columns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowExtraColumns()
	 * @generated
	 * @ordered
	 */
	protected boolean allowExtraColumns = ALLOW_EXTRA_COLUMNS_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowMissingColumns() <em>Allow Missing Columns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowMissingColumns()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_MISSING_COLUMNS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowMissingColumns() <em>Allow Missing Columns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowMissingColumns()
	 * @generated
	 * @ordered
	 */
	protected boolean allowMissingColumns = ALLOW_MISSING_COLUMNS_EDEFAULT;

	/**
	 * The default value of the '{@link #getVerifyStyle() <em>Verify Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerifyStyle()
	 * @generated
	 * @ordered
	 */
	protected static final VerifyStyleType VERIFY_STYLE_EDEFAULT = VerifyStyleType.ALL;

	/**
	 * The cached value of the '{@link #getVerifyStyle() <em>Verify Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerifyStyle()
	 * @generated
	 * @ordered
	 */
	protected VerifyStyleType verifyStyle = VERIFY_STYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isVerifyIcons() <em>Verify Icons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVerifyIcons()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VERIFY_ICONS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isVerifyIcons() <em>Verify Icons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVerifyIcons()
	 * @generated
	 * @ordered
	 */
	protected boolean verifyIcons = VERIFY_ICONS_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowUncapturedChildren() <em>Allow Uncaptured Children</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowUncapturedChildren()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_UNCAPTURED_CHILDREN_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAllowUncapturedChildren() <em>Allow Uncaptured Children</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowUncapturedChildren()
	 * @generated
	 * @ordered
	 */
	protected boolean allowUncapturedChildren = ALLOW_UNCAPTURED_CHILDREN_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnableVerifyStyle() <em>Enable Verify Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnableVerifyStyle()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLE_VERIFY_STYLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnableVerifyStyle() <em>Enable Verify Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnableVerifyStyle()
	 * @generated
	 * @ordered
	 */
	protected boolean enableVerifyStyle = ENABLE_VERIFY_STYLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExcludedColumns() <em>Excluded Columns</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExcludedColumns()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> excludedColumns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VerifyTreeDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TreePackage.Literals.VERIFY_TREE_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowExtraColumns() {
		return allowExtraColumns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowExtraColumns(boolean newAllowExtraColumns) {
		boolean oldAllowExtraColumns = allowExtraColumns;
		allowExtraColumns = newAllowExtraColumns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.VERIFY_TREE_DATA__ALLOW_EXTRA_COLUMNS, oldAllowExtraColumns, allowExtraColumns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowMissingColumns() {
		return allowMissingColumns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowMissingColumns(boolean newAllowMissingColumns) {
		boolean oldAllowMissingColumns = allowMissingColumns;
		allowMissingColumns = newAllowMissingColumns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.VERIFY_TREE_DATA__ALLOW_MISSING_COLUMNS, oldAllowMissingColumns, allowMissingColumns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerifyStyleType getVerifyStyle() {
		return verifyStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerifyStyle(VerifyStyleType newVerifyStyle) {
		VerifyStyleType oldVerifyStyle = verifyStyle;
		verifyStyle = newVerifyStyle == null ? VERIFY_STYLE_EDEFAULT : newVerifyStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.VERIFY_TREE_DATA__VERIFY_STYLE, oldVerifyStyle, verifyStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVerifyIcons() {
		return verifyIcons;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerifyIcons(boolean newVerifyIcons) {
		boolean oldVerifyIcons = verifyIcons;
		verifyIcons = newVerifyIcons;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.VERIFY_TREE_DATA__VERIFY_ICONS, oldVerifyIcons, verifyIcons));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowUncapturedChildren() {
		return allowUncapturedChildren;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowUncapturedChildren(boolean newAllowUncapturedChildren) {
		boolean oldAllowUncapturedChildren = allowUncapturedChildren;
		allowUncapturedChildren = newAllowUncapturedChildren;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.VERIFY_TREE_DATA__ALLOW_UNCAPTURED_CHILDREN, oldAllowUncapturedChildren, allowUncapturedChildren));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnableVerifyStyle() {
		return enableVerifyStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableVerifyStyle(boolean newEnableVerifyStyle) {
		boolean oldEnableVerifyStyle = enableVerifyStyle;
		enableVerifyStyle = newEnableVerifyStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.VERIFY_TREE_DATA__ENABLE_VERIFY_STYLE, oldEnableVerifyStyle, enableVerifyStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getExcludedColumns() {
		if (excludedColumns == null) {
			excludedColumns = new EDataTypeUniqueEList<Integer>(Integer.class, this, TreePackage.VERIFY_TREE_DATA__EXCLUDED_COLUMNS);
		}
		return excludedColumns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TreePackage.VERIFY_TREE_DATA__ALLOW_EXTRA_COLUMNS:
				return isAllowExtraColumns();
			case TreePackage.VERIFY_TREE_DATA__ALLOW_MISSING_COLUMNS:
				return isAllowMissingColumns();
			case TreePackage.VERIFY_TREE_DATA__VERIFY_STYLE:
				return getVerifyStyle();
			case TreePackage.VERIFY_TREE_DATA__VERIFY_ICONS:
				return isVerifyIcons();
			case TreePackage.VERIFY_TREE_DATA__ALLOW_UNCAPTURED_CHILDREN:
				return isAllowUncapturedChildren();
			case TreePackage.VERIFY_TREE_DATA__ENABLE_VERIFY_STYLE:
				return isEnableVerifyStyle();
			case TreePackage.VERIFY_TREE_DATA__EXCLUDED_COLUMNS:
				return getExcludedColumns();
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
			case TreePackage.VERIFY_TREE_DATA__ALLOW_EXTRA_COLUMNS:
				setAllowExtraColumns((Boolean)newValue);
				return;
			case TreePackage.VERIFY_TREE_DATA__ALLOW_MISSING_COLUMNS:
				setAllowMissingColumns((Boolean)newValue);
				return;
			case TreePackage.VERIFY_TREE_DATA__VERIFY_STYLE:
				setVerifyStyle((VerifyStyleType)newValue);
				return;
			case TreePackage.VERIFY_TREE_DATA__VERIFY_ICONS:
				setVerifyIcons((Boolean)newValue);
				return;
			case TreePackage.VERIFY_TREE_DATA__ALLOW_UNCAPTURED_CHILDREN:
				setAllowUncapturedChildren((Boolean)newValue);
				return;
			case TreePackage.VERIFY_TREE_DATA__ENABLE_VERIFY_STYLE:
				setEnableVerifyStyle((Boolean)newValue);
				return;
			case TreePackage.VERIFY_TREE_DATA__EXCLUDED_COLUMNS:
				getExcludedColumns().clear();
				getExcludedColumns().addAll((Collection<? extends Integer>)newValue);
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
			case TreePackage.VERIFY_TREE_DATA__ALLOW_EXTRA_COLUMNS:
				setAllowExtraColumns(ALLOW_EXTRA_COLUMNS_EDEFAULT);
				return;
			case TreePackage.VERIFY_TREE_DATA__ALLOW_MISSING_COLUMNS:
				setAllowMissingColumns(ALLOW_MISSING_COLUMNS_EDEFAULT);
				return;
			case TreePackage.VERIFY_TREE_DATA__VERIFY_STYLE:
				setVerifyStyle(VERIFY_STYLE_EDEFAULT);
				return;
			case TreePackage.VERIFY_TREE_DATA__VERIFY_ICONS:
				setVerifyIcons(VERIFY_ICONS_EDEFAULT);
				return;
			case TreePackage.VERIFY_TREE_DATA__ALLOW_UNCAPTURED_CHILDREN:
				setAllowUncapturedChildren(ALLOW_UNCAPTURED_CHILDREN_EDEFAULT);
				return;
			case TreePackage.VERIFY_TREE_DATA__ENABLE_VERIFY_STYLE:
				setEnableVerifyStyle(ENABLE_VERIFY_STYLE_EDEFAULT);
				return;
			case TreePackage.VERIFY_TREE_DATA__EXCLUDED_COLUMNS:
				getExcludedColumns().clear();
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
			case TreePackage.VERIFY_TREE_DATA__ALLOW_EXTRA_COLUMNS:
				return allowExtraColumns != ALLOW_EXTRA_COLUMNS_EDEFAULT;
			case TreePackage.VERIFY_TREE_DATA__ALLOW_MISSING_COLUMNS:
				return allowMissingColumns != ALLOW_MISSING_COLUMNS_EDEFAULT;
			case TreePackage.VERIFY_TREE_DATA__VERIFY_STYLE:
				return verifyStyle != VERIFY_STYLE_EDEFAULT;
			case TreePackage.VERIFY_TREE_DATA__VERIFY_ICONS:
				return verifyIcons != VERIFY_ICONS_EDEFAULT;
			case TreePackage.VERIFY_TREE_DATA__ALLOW_UNCAPTURED_CHILDREN:
				return allowUncapturedChildren != ALLOW_UNCAPTURED_CHILDREN_EDEFAULT;
			case TreePackage.VERIFY_TREE_DATA__ENABLE_VERIFY_STYLE:
				return enableVerifyStyle != ENABLE_VERIFY_STYLE_EDEFAULT;
			case TreePackage.VERIFY_TREE_DATA__EXCLUDED_COLUMNS:
				return excludedColumns != null && !excludedColumns.isEmpty();
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
		result.append(" (allowExtraColumns: ");
		result.append(allowExtraColumns);
		result.append(", allowMissingColumns: ");
		result.append(allowMissingColumns);
		result.append(", verifyStyle: ");
		result.append(verifyStyle);
		result.append(", verifyIcons: ");
		result.append(verifyIcons);
		result.append(", allowUncapturedChildren: ");
		result.append(allowUncapturedChildren);
		result.append(", enableVerifyStyle: ");
		result.append(enableVerifyStyle);
		result.append(", excludedColumns: ");
		result.append(excludedColumns);
		result.append(')');
		return result.toString();
	}

} //VerifyTreeDataImpl
