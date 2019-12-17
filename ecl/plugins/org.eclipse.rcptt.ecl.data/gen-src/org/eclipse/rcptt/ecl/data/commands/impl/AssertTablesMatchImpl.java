/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.data.commands.impl;




import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.rcptt.ecl.core.impl.CommandImpl;
import org.eclipse.rcptt.ecl.data.commands.AssertTablesMatch;
import org.eclipse.rcptt.ecl.data.commands.CommandsPackage;
import org.eclipse.rcptt.ecl.data.commands.IgnoreColumnsMode;
import org.eclipse.rcptt.ecl.data.objects.Table;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assert Tables Match</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.impl.AssertTablesMatchImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.impl.AssertTablesMatchImpl#getRight <em>Right</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.impl.AssertTablesMatchImpl#isIgnoreColumnOrder <em>Ignore Column Order</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.impl.AssertTablesMatchImpl#getIgnoreMissingColumns <em>Ignore Missing Columns</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssertTablesMatchImpl extends CommandImpl implements AssertTablesMatch {
	/**
	 * The cached value of the '{@link #getLeft() <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
	protected Table left;

	/**
	 * The cached value of the '{@link #getRight() <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
	protected Table right;

	/**
	 * The default value of the '{@link #isIgnoreColumnOrder() <em>Ignore Column Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIgnoreColumnOrder()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IGNORE_COLUMN_ORDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIgnoreColumnOrder() <em>Ignore Column Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIgnoreColumnOrder()
	 * @generated
	 * @ordered
	 */
	protected boolean ignoreColumnOrder = IGNORE_COLUMN_ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getIgnoreMissingColumns() <em>Ignore Missing Columns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIgnoreMissingColumns()
	 * @generated
	 * @ordered
	 */
	protected static final IgnoreColumnsMode IGNORE_MISSING_COLUMNS_EDEFAULT = IgnoreColumnsMode.NONE;

	/**
	 * The cached value of the '{@link #getIgnoreMissingColumns() <em>Ignore Missing Columns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIgnoreMissingColumns()
	 * @generated
	 * @ordered
	 */
	protected IgnoreColumnsMode ignoreMissingColumns = IGNORE_MISSING_COLUMNS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssertTablesMatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommandsPackage.Literals.ASSERT_TABLES_MATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table getLeft() {
		if (left != null && left.eIsProxy()) {
			InternalEObject oldLeft = (InternalEObject)left;
			left = (Table)eResolveProxy(oldLeft);
			if (left != oldLeft) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CommandsPackage.ASSERT_TABLES_MATCH__LEFT, oldLeft, left));
			}
		}
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetLeft() {
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeft(Table newLeft) {
		Table oldLeft = left;
		left = newLeft;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandsPackage.ASSERT_TABLES_MATCH__LEFT, oldLeft, left));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table getRight() {
		if (right != null && right.eIsProxy()) {
			InternalEObject oldRight = (InternalEObject)right;
			right = (Table)eResolveProxy(oldRight);
			if (right != oldRight) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CommandsPackage.ASSERT_TABLES_MATCH__RIGHT, oldRight, right));
			}
		}
		return right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetRight() {
		return right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRight(Table newRight) {
		Table oldRight = right;
		right = newRight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandsPackage.ASSERT_TABLES_MATCH__RIGHT, oldRight, right));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIgnoreColumnOrder() {
		return ignoreColumnOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIgnoreColumnOrder(boolean newIgnoreColumnOrder) {
		boolean oldIgnoreColumnOrder = ignoreColumnOrder;
		ignoreColumnOrder = newIgnoreColumnOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandsPackage.ASSERT_TABLES_MATCH__IGNORE_COLUMN_ORDER, oldIgnoreColumnOrder, ignoreColumnOrder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IgnoreColumnsMode getIgnoreMissingColumns() {
		return ignoreMissingColumns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIgnoreMissingColumns(IgnoreColumnsMode newIgnoreMissingColumns) {
		IgnoreColumnsMode oldIgnoreMissingColumns = ignoreMissingColumns;
		ignoreMissingColumns = newIgnoreMissingColumns == null ? IGNORE_MISSING_COLUMNS_EDEFAULT : newIgnoreMissingColumns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandsPackage.ASSERT_TABLES_MATCH__IGNORE_MISSING_COLUMNS, oldIgnoreMissingColumns, ignoreMissingColumns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommandsPackage.ASSERT_TABLES_MATCH__LEFT:
				if (resolve) return getLeft();
				return basicGetLeft();
			case CommandsPackage.ASSERT_TABLES_MATCH__RIGHT:
				if (resolve) return getRight();
				return basicGetRight();
			case CommandsPackage.ASSERT_TABLES_MATCH__IGNORE_COLUMN_ORDER:
				return isIgnoreColumnOrder();
			case CommandsPackage.ASSERT_TABLES_MATCH__IGNORE_MISSING_COLUMNS:
				return getIgnoreMissingColumns();
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
			case CommandsPackage.ASSERT_TABLES_MATCH__LEFT:
				setLeft((Table)newValue);
				return;
			case CommandsPackage.ASSERT_TABLES_MATCH__RIGHT:
				setRight((Table)newValue);
				return;
			case CommandsPackage.ASSERT_TABLES_MATCH__IGNORE_COLUMN_ORDER:
				setIgnoreColumnOrder((Boolean)newValue);
				return;
			case CommandsPackage.ASSERT_TABLES_MATCH__IGNORE_MISSING_COLUMNS:
				setIgnoreMissingColumns((IgnoreColumnsMode)newValue);
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
			case CommandsPackage.ASSERT_TABLES_MATCH__LEFT:
				setLeft((Table)null);
				return;
			case CommandsPackage.ASSERT_TABLES_MATCH__RIGHT:
				setRight((Table)null);
				return;
			case CommandsPackage.ASSERT_TABLES_MATCH__IGNORE_COLUMN_ORDER:
				setIgnoreColumnOrder(IGNORE_COLUMN_ORDER_EDEFAULT);
				return;
			case CommandsPackage.ASSERT_TABLES_MATCH__IGNORE_MISSING_COLUMNS:
				setIgnoreMissingColumns(IGNORE_MISSING_COLUMNS_EDEFAULT);
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
			case CommandsPackage.ASSERT_TABLES_MATCH__LEFT:
				return left != null;
			case CommandsPackage.ASSERT_TABLES_MATCH__RIGHT:
				return right != null;
			case CommandsPackage.ASSERT_TABLES_MATCH__IGNORE_COLUMN_ORDER:
				return ignoreColumnOrder != IGNORE_COLUMN_ORDER_EDEFAULT;
			case CommandsPackage.ASSERT_TABLES_MATCH__IGNORE_MISSING_COLUMNS:
				return ignoreMissingColumns != IGNORE_MISSING_COLUMNS_EDEFAULT;
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
		result.append(" (ignoreColumnOrder: ");
		result.append(ignoreColumnOrder);
		result.append(", ignoreMissingColumns: ");
		result.append(ignoreMissingColumns);
		result.append(')');
		return result.toString();
	}

} //AssertTablesMatchImpl
