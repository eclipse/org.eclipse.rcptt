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
package org.eclipse.rcptt.tesla.protocol.nebula.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.rcptt.tesla.core.protocol.impl.MultiSelectionItemImpl;

import org.eclipse.rcptt.tesla.protocol.nebula.MultiSelectionItemEx;
import org.eclipse.rcptt.tesla.protocol.nebula.NebulaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Selection Item Ex</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.protocol.nebula.impl.MultiSelectionItemExImpl#getCellColumn <em>Cell Column</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.protocol.nebula.impl.MultiSelectionItemExImpl#isRowHeader <em>Row Header</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiSelectionItemExImpl extends MultiSelectionItemImpl implements MultiSelectionItemEx {
	/**
	 * The default value of the '{@link #getCellColumn() <em>Cell Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCellColumn()
	 * @generated
	 * @ordered
	 */
	protected static final String CELL_COLUMN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCellColumn() <em>Cell Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCellColumn()
	 * @generated
	 * @ordered
	 */
	protected String cellColumn = CELL_COLUMN_EDEFAULT;

	/**
	 * The default value of the '{@link #isRowHeader() <em>Row Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRowHeader()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ROW_HEADER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRowHeader() <em>Row Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRowHeader()
	 * @generated
	 * @ordered
	 */
	protected boolean rowHeader = ROW_HEADER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiSelectionItemExImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NebulaPackage.Literals.MULTI_SELECTION_ITEM_EX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCellColumn() {
		return cellColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCellColumn(String newCellColumn) {
		String oldCellColumn = cellColumn;
		cellColumn = newCellColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.MULTI_SELECTION_ITEM_EX__CELL_COLUMN, oldCellColumn, cellColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRowHeader() {
		return rowHeader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRowHeader(boolean newRowHeader) {
		boolean oldRowHeader = rowHeader;
		rowHeader = newRowHeader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.MULTI_SELECTION_ITEM_EX__ROW_HEADER, oldRowHeader, rowHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NebulaPackage.MULTI_SELECTION_ITEM_EX__CELL_COLUMN:
				return getCellColumn();
			case NebulaPackage.MULTI_SELECTION_ITEM_EX__ROW_HEADER:
				return isRowHeader();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NebulaPackage.MULTI_SELECTION_ITEM_EX__CELL_COLUMN:
				setCellColumn((String)newValue);
				return;
			case NebulaPackage.MULTI_SELECTION_ITEM_EX__ROW_HEADER:
				setRowHeader((Boolean)newValue);
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
			case NebulaPackage.MULTI_SELECTION_ITEM_EX__CELL_COLUMN:
				setCellColumn(CELL_COLUMN_EDEFAULT);
				return;
			case NebulaPackage.MULTI_SELECTION_ITEM_EX__ROW_HEADER:
				setRowHeader(ROW_HEADER_EDEFAULT);
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
			case NebulaPackage.MULTI_SELECTION_ITEM_EX__CELL_COLUMN:
				return CELL_COLUMN_EDEFAULT == null ? cellColumn != null : !CELL_COLUMN_EDEFAULT.equals(cellColumn);
			case NebulaPackage.MULTI_SELECTION_ITEM_EX__ROW_HEADER:
				return rowHeader != ROW_HEADER_EDEFAULT;
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
		result.append(" (cellColumn: ");
		result.append(cellColumn);
		result.append(", rowHeader: ");
		result.append(rowHeader);
		result.append(')');
		return result.toString();
	}

} //MultiSelectionItemExImpl
