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
package org.eclipse.rcptt.verifications.status.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.rcptt.verifications.status.StatusPackage;
import org.eclipse.rcptt.verifications.status.TreeItemVerificationError;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tree Item Verification Error</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.status.impl.TreeItemVerificationErrorImpl#getItemIndexPath <em>Item Index Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.status.impl.TreeItemVerificationErrorImpl#getItemPath <em>Item Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.status.impl.TreeItemVerificationErrorImpl#getColumn <em>Column</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TreeItemVerificationErrorImpl extends VerificationStatusDataImpl implements TreeItemVerificationError {
	/**
	 * The cached value of the '{@link #getItemIndexPath() <em>Item Index Path</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemIndexPath()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> itemIndexPath;

	/**
	 * The default value of the '{@link #getItemPath() <em>Item Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemPath()
	 * @generated
	 * @ordered
	 */
	protected static final String ITEM_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getItemPath() <em>Item Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemPath()
	 * @generated
	 * @ordered
	 */
	protected String itemPath = ITEM_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected static final String COLUMN_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected String column = COLUMN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeItemVerificationErrorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatusPackage.Literals.TREE_ITEM_VERIFICATION_ERROR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getItemIndexPath() {
		if (itemIndexPath == null) {
			itemIndexPath = new EDataTypeEList<Integer>(Integer.class, this, StatusPackage.TREE_ITEM_VERIFICATION_ERROR__ITEM_INDEX_PATH);
		}
		return itemIndexPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getItemPath() {
		return itemPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemPath(String newItemPath) {
		String oldItemPath = itemPath;
		itemPath = newItemPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatusPackage.TREE_ITEM_VERIFICATION_ERROR__ITEM_PATH, oldItemPath, itemPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColumn() {
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumn(String newColumn) {
		String oldColumn = column;
		column = newColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatusPackage.TREE_ITEM_VERIFICATION_ERROR__COLUMN, oldColumn, column));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatusPackage.TREE_ITEM_VERIFICATION_ERROR__ITEM_INDEX_PATH:
				return getItemIndexPath();
			case StatusPackage.TREE_ITEM_VERIFICATION_ERROR__ITEM_PATH:
				return getItemPath();
			case StatusPackage.TREE_ITEM_VERIFICATION_ERROR__COLUMN:
				return getColumn();
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
			case StatusPackage.TREE_ITEM_VERIFICATION_ERROR__ITEM_INDEX_PATH:
				getItemIndexPath().clear();
				getItemIndexPath().addAll((Collection<? extends Integer>)newValue);
				return;
			case StatusPackage.TREE_ITEM_VERIFICATION_ERROR__ITEM_PATH:
				setItemPath((String)newValue);
				return;
			case StatusPackage.TREE_ITEM_VERIFICATION_ERROR__COLUMN:
				setColumn((String)newValue);
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
			case StatusPackage.TREE_ITEM_VERIFICATION_ERROR__ITEM_INDEX_PATH:
				getItemIndexPath().clear();
				return;
			case StatusPackage.TREE_ITEM_VERIFICATION_ERROR__ITEM_PATH:
				setItemPath(ITEM_PATH_EDEFAULT);
				return;
			case StatusPackage.TREE_ITEM_VERIFICATION_ERROR__COLUMN:
				setColumn(COLUMN_EDEFAULT);
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
			case StatusPackage.TREE_ITEM_VERIFICATION_ERROR__ITEM_INDEX_PATH:
				return itemIndexPath != null && !itemIndexPath.isEmpty();
			case StatusPackage.TREE_ITEM_VERIFICATION_ERROR__ITEM_PATH:
				return ITEM_PATH_EDEFAULT == null ? itemPath != null : !ITEM_PATH_EDEFAULT.equals(itemPath);
			case StatusPackage.TREE_ITEM_VERIFICATION_ERROR__COLUMN:
				return COLUMN_EDEFAULT == null ? column != null : !COLUMN_EDEFAULT.equals(column);
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
		result.append(" (itemIndexPath: ");
		result.append(itemIndexPath);
		result.append(", itemPath: ");
		result.append(itemPath);
		result.append(", column: ");
		result.append(column);
		result.append(')');
		return result.toString();
	}

} //TreeItemVerificationErrorImpl
