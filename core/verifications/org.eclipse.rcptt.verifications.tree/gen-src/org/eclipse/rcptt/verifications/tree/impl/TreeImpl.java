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
package org.eclipse.rcptt.verifications.tree.impl;

import org.eclipse.rcptt.verifications.tree.Column;
import org.eclipse.rcptt.verifications.tree.Row;
import org.eclipse.rcptt.verifications.tree.Tree;
import org.eclipse.rcptt.verifications.tree.TreePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.TreeImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.TreeImpl#getStyle <em>Style</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.TreeImpl#getRows <em>Rows</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.TreeImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.TreeImpl#isHeaderVisible <em>Header Visible</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.TreeImpl#isLinesVisible <em>Lines Visible</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.TreeImpl#getSortColumnInd <em>Sort Column Ind</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.TreeImpl#getSortDirection <em>Sort Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TreeImpl extends EObjectImpl implements Tree {
	/**
	 * The cached value of the '{@link #getColumns() <em>Columns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumns()
	 * @generated
	 * @ordered
	 */
	protected EList<Column> columns;

	/**
	 * The default value of the '{@link #getStyle() <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyle()
	 * @generated
	 * @ordered
	 */
	protected static final int STYLE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStyle() <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyle()
	 * @generated
	 * @ordered
	 */
	protected int style = STYLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRows() <em>Rows</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRows()
	 * @generated
	 * @ordered
	 */
	protected EList<Row> rows;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isHeaderVisible() <em>Header Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHeaderVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HEADER_VISIBLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHeaderVisible() <em>Header Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHeaderVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean headerVisible = HEADER_VISIBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isLinesVisible() <em>Lines Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLinesVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LINES_VISIBLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLinesVisible() <em>Lines Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLinesVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean linesVisible = LINES_VISIBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSortColumnInd() <em>Sort Column Ind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortColumnInd()
	 * @generated
	 * @ordered
	 */
	protected static final int SORT_COLUMN_IND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSortColumnInd() <em>Sort Column Ind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortColumnInd()
	 * @generated
	 * @ordered
	 */
	protected int sortColumnInd = SORT_COLUMN_IND_EDEFAULT;

	/**
	 * The default value of the '{@link #getSortDirection() <em>Sort Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortDirection()
	 * @generated
	 * @ordered
	 */
	protected static final int SORT_DIRECTION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSortDirection() <em>Sort Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortDirection()
	 * @generated
	 * @ordered
	 */
	protected int sortDirection = SORT_DIRECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TreePackage.Literals.TREE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Column> getColumns() {
		if (columns == null) {
			columns = new EObjectContainmentEList<Column>(Column.class, this, TreePackage.TREE__COLUMNS);
		}
		return columns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStyle() {
		return style;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStyle(int newStyle) {
		int oldStyle = style;
		style = newStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE__STYLE, oldStyle, style));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Row> getRows() {
		if (rows == null) {
			rows = new EObjectContainmentEList<Row>(Row.class, this, TreePackage.TREE__ROWS);
		}
		return rows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled) {
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHeaderVisible() {
		return headerVisible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderVisible(boolean newHeaderVisible) {
		boolean oldHeaderVisible = headerVisible;
		headerVisible = newHeaderVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE__HEADER_VISIBLE, oldHeaderVisible, headerVisible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLinesVisible() {
		return linesVisible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinesVisible(boolean newLinesVisible) {
		boolean oldLinesVisible = linesVisible;
		linesVisible = newLinesVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE__LINES_VISIBLE, oldLinesVisible, linesVisible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSortColumnInd() {
		return sortColumnInd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSortColumnInd(int newSortColumnInd) {
		int oldSortColumnInd = sortColumnInd;
		sortColumnInd = newSortColumnInd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE__SORT_COLUMN_IND, oldSortColumnInd, sortColumnInd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSortDirection() {
		return sortDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSortDirection(int newSortDirection) {
		int oldSortDirection = sortDirection;
		sortDirection = newSortDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE__SORT_DIRECTION, oldSortDirection, sortDirection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TreePackage.TREE__COLUMNS:
				return ((InternalEList<?>)getColumns()).basicRemove(otherEnd, msgs);
			case TreePackage.TREE__ROWS:
				return ((InternalEList<?>)getRows()).basicRemove(otherEnd, msgs);
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
			case TreePackage.TREE__COLUMNS:
				return getColumns();
			case TreePackage.TREE__STYLE:
				return getStyle();
			case TreePackage.TREE__ROWS:
				return getRows();
			case TreePackage.TREE__ENABLED:
				return isEnabled();
			case TreePackage.TREE__HEADER_VISIBLE:
				return isHeaderVisible();
			case TreePackage.TREE__LINES_VISIBLE:
				return isLinesVisible();
			case TreePackage.TREE__SORT_COLUMN_IND:
				return getSortColumnInd();
			case TreePackage.TREE__SORT_DIRECTION:
				return getSortDirection();
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
			case TreePackage.TREE__COLUMNS:
				getColumns().clear();
				getColumns().addAll((Collection<? extends Column>)newValue);
				return;
			case TreePackage.TREE__STYLE:
				setStyle((Integer)newValue);
				return;
			case TreePackage.TREE__ROWS:
				getRows().clear();
				getRows().addAll((Collection<? extends Row>)newValue);
				return;
			case TreePackage.TREE__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case TreePackage.TREE__HEADER_VISIBLE:
				setHeaderVisible((Boolean)newValue);
				return;
			case TreePackage.TREE__LINES_VISIBLE:
				setLinesVisible((Boolean)newValue);
				return;
			case TreePackage.TREE__SORT_COLUMN_IND:
				setSortColumnInd((Integer)newValue);
				return;
			case TreePackage.TREE__SORT_DIRECTION:
				setSortDirection((Integer)newValue);
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
			case TreePackage.TREE__COLUMNS:
				getColumns().clear();
				return;
			case TreePackage.TREE__STYLE:
				setStyle(STYLE_EDEFAULT);
				return;
			case TreePackage.TREE__ROWS:
				getRows().clear();
				return;
			case TreePackage.TREE__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case TreePackage.TREE__HEADER_VISIBLE:
				setHeaderVisible(HEADER_VISIBLE_EDEFAULT);
				return;
			case TreePackage.TREE__LINES_VISIBLE:
				setLinesVisible(LINES_VISIBLE_EDEFAULT);
				return;
			case TreePackage.TREE__SORT_COLUMN_IND:
				setSortColumnInd(SORT_COLUMN_IND_EDEFAULT);
				return;
			case TreePackage.TREE__SORT_DIRECTION:
				setSortDirection(SORT_DIRECTION_EDEFAULT);
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
			case TreePackage.TREE__COLUMNS:
				return columns != null && !columns.isEmpty();
			case TreePackage.TREE__STYLE:
				return style != STYLE_EDEFAULT;
			case TreePackage.TREE__ROWS:
				return rows != null && !rows.isEmpty();
			case TreePackage.TREE__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case TreePackage.TREE__HEADER_VISIBLE:
				return headerVisible != HEADER_VISIBLE_EDEFAULT;
			case TreePackage.TREE__LINES_VISIBLE:
				return linesVisible != LINES_VISIBLE_EDEFAULT;
			case TreePackage.TREE__SORT_COLUMN_IND:
				return sortColumnInd != SORT_COLUMN_IND_EDEFAULT;
			case TreePackage.TREE__SORT_DIRECTION:
				return sortDirection != SORT_DIRECTION_EDEFAULT;
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
		result.append(" (style: ");
		result.append(style);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", headerVisible: ");
		result.append(headerVisible);
		result.append(", linesVisible: ");
		result.append(linesVisible);
		result.append(", sortColumnInd: ");
		result.append(sortColumnInd);
		result.append(", sortDirection: ");
		result.append(sortDirection);
		result.append(')');
		return result.toString();
	}

} //TreeImpl
