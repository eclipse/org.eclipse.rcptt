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
package org.eclipse.rcptt.verifications.tree.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.rcptt.core.scenario.impl.WidgetVerificationImpl;
import org.eclipse.rcptt.verifications.tree.CollapseType;
import org.eclipse.rcptt.verifications.tree.Tree;
import org.eclipse.rcptt.verifications.tree.TreePackage;
import org.eclipse.rcptt.verifications.tree.TreeVerification;
import org.eclipse.rcptt.verifications.tree.VerifyStyleType;
import org.eclipse.rcptt.verifications.tree.VerifyTreeData;
import org.eclipse.rcptt.tesla.core.ui.Image;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Verification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.TreeVerificationImpl#isAllowExtraColumns <em>Allow Extra Columns</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.TreeVerificationImpl#isAllowMissingColumns <em>Allow Missing Columns</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.TreeVerificationImpl#getVerifyStyle <em>Verify Style</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.TreeVerificationImpl#isVerifyIcons <em>Verify Icons</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.TreeVerificationImpl#isAllowUncapturedChildren <em>Allow Uncaptured Children</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.TreeVerificationImpl#isEnableVerifyStyle <em>Enable Verify Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TreeVerificationImpl extends CaptureTreeVerificationDataImpl implements TreeVerification {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeVerificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TreePackage.Literals.TREE_VERIFICATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_VERIFICATION__ALLOW_EXTRA_COLUMNS, oldAllowExtraColumns, allowExtraColumns));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_VERIFICATION__ALLOW_MISSING_COLUMNS, oldAllowMissingColumns, allowMissingColumns));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_VERIFICATION__VERIFY_STYLE, oldVerifyStyle, verifyStyle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_VERIFICATION__VERIFY_ICONS, oldVerifyIcons, verifyIcons));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_VERIFICATION__ALLOW_UNCAPTURED_CHILDREN, oldAllowUncapturedChildren, allowUncapturedChildren));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_VERIFICATION__ENABLE_VERIFY_STYLE, oldEnableVerifyStyle, enableVerifyStyle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TreePackage.TREE_VERIFICATION__ALLOW_EXTRA_COLUMNS:
				return isAllowExtraColumns();
			case TreePackage.TREE_VERIFICATION__ALLOW_MISSING_COLUMNS:
				return isAllowMissingColumns();
			case TreePackage.TREE_VERIFICATION__VERIFY_STYLE:
				return getVerifyStyle();
			case TreePackage.TREE_VERIFICATION__VERIFY_ICONS:
				return isVerifyIcons();
			case TreePackage.TREE_VERIFICATION__ALLOW_UNCAPTURED_CHILDREN:
				return isAllowUncapturedChildren();
			case TreePackage.TREE_VERIFICATION__ENABLE_VERIFY_STYLE:
				return isEnableVerifyStyle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TreePackage.TREE_VERIFICATION__ALLOW_EXTRA_COLUMNS:
				setAllowExtraColumns((Boolean)newValue);
				return;
			case TreePackage.TREE_VERIFICATION__ALLOW_MISSING_COLUMNS:
				setAllowMissingColumns((Boolean)newValue);
				return;
			case TreePackage.TREE_VERIFICATION__VERIFY_STYLE:
				setVerifyStyle((VerifyStyleType)newValue);
				return;
			case TreePackage.TREE_VERIFICATION__VERIFY_ICONS:
				setVerifyIcons((Boolean)newValue);
				return;
			case TreePackage.TREE_VERIFICATION__ALLOW_UNCAPTURED_CHILDREN:
				setAllowUncapturedChildren((Boolean)newValue);
				return;
			case TreePackage.TREE_VERIFICATION__ENABLE_VERIFY_STYLE:
				setEnableVerifyStyle((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TreePackage.TREE_VERIFICATION__ALLOW_EXTRA_COLUMNS:
				setAllowExtraColumns(ALLOW_EXTRA_COLUMNS_EDEFAULT);
				return;
			case TreePackage.TREE_VERIFICATION__ALLOW_MISSING_COLUMNS:
				setAllowMissingColumns(ALLOW_MISSING_COLUMNS_EDEFAULT);
				return;
			case TreePackage.TREE_VERIFICATION__VERIFY_STYLE:
				setVerifyStyle(VERIFY_STYLE_EDEFAULT);
				return;
			case TreePackage.TREE_VERIFICATION__VERIFY_ICONS:
				setVerifyIcons(VERIFY_ICONS_EDEFAULT);
				return;
			case TreePackage.TREE_VERIFICATION__ALLOW_UNCAPTURED_CHILDREN:
				setAllowUncapturedChildren(ALLOW_UNCAPTURED_CHILDREN_EDEFAULT);
				return;
			case TreePackage.TREE_VERIFICATION__ENABLE_VERIFY_STYLE:
				setEnableVerifyStyle(ENABLE_VERIFY_STYLE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TreePackage.TREE_VERIFICATION__ALLOW_EXTRA_COLUMNS:
				return allowExtraColumns != ALLOW_EXTRA_COLUMNS_EDEFAULT;
			case TreePackage.TREE_VERIFICATION__ALLOW_MISSING_COLUMNS:
				return allowMissingColumns != ALLOW_MISSING_COLUMNS_EDEFAULT;
			case TreePackage.TREE_VERIFICATION__VERIFY_STYLE:
				return verifyStyle != VERIFY_STYLE_EDEFAULT;
			case TreePackage.TREE_VERIFICATION__VERIFY_ICONS:
				return verifyIcons != VERIFY_ICONS_EDEFAULT;
			case TreePackage.TREE_VERIFICATION__ALLOW_UNCAPTURED_CHILDREN:
				return allowUncapturedChildren != ALLOW_UNCAPTURED_CHILDREN_EDEFAULT;
			case TreePackage.TREE_VERIFICATION__ENABLE_VERIFY_STYLE:
				return enableVerifyStyle != ENABLE_VERIFY_STYLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == VerifyTreeData.class) {
			switch (derivedFeatureID) {
				case TreePackage.TREE_VERIFICATION__ALLOW_EXTRA_COLUMNS: return TreePackage.VERIFY_TREE_DATA__ALLOW_EXTRA_COLUMNS;
				case TreePackage.TREE_VERIFICATION__ALLOW_MISSING_COLUMNS: return TreePackage.VERIFY_TREE_DATA__ALLOW_MISSING_COLUMNS;
				case TreePackage.TREE_VERIFICATION__VERIFY_STYLE: return TreePackage.VERIFY_TREE_DATA__VERIFY_STYLE;
				case TreePackage.TREE_VERIFICATION__VERIFY_ICONS: return TreePackage.VERIFY_TREE_DATA__VERIFY_ICONS;
				case TreePackage.TREE_VERIFICATION__ALLOW_UNCAPTURED_CHILDREN: return TreePackage.VERIFY_TREE_DATA__ALLOW_UNCAPTURED_CHILDREN;
				case TreePackage.TREE_VERIFICATION__ENABLE_VERIFY_STYLE: return TreePackage.VERIFY_TREE_DATA__ENABLE_VERIFY_STYLE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == VerifyTreeData.class) {
			switch (baseFeatureID) {
				case TreePackage.VERIFY_TREE_DATA__ALLOW_EXTRA_COLUMNS: return TreePackage.TREE_VERIFICATION__ALLOW_EXTRA_COLUMNS;
				case TreePackage.VERIFY_TREE_DATA__ALLOW_MISSING_COLUMNS: return TreePackage.TREE_VERIFICATION__ALLOW_MISSING_COLUMNS;
				case TreePackage.VERIFY_TREE_DATA__VERIFY_STYLE: return TreePackage.TREE_VERIFICATION__VERIFY_STYLE;
				case TreePackage.VERIFY_TREE_DATA__VERIFY_ICONS: return TreePackage.TREE_VERIFICATION__VERIFY_ICONS;
				case TreePackage.VERIFY_TREE_DATA__ALLOW_UNCAPTURED_CHILDREN: return TreePackage.TREE_VERIFICATION__ALLOW_UNCAPTURED_CHILDREN;
				case TreePackage.VERIFY_TREE_DATA__ENABLE_VERIFY_STYLE: return TreePackage.TREE_VERIFICATION__ENABLE_VERIFY_STYLE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(')');
		return result.toString();
	}

} // TreeVerificationImpl
