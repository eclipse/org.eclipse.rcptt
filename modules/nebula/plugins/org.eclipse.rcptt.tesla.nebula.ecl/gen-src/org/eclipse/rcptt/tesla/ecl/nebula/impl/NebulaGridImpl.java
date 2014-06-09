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
package org.eclipse.rcptt.tesla.ecl.nebula.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.rcptt.tesla.core.ui.Selection;

import org.eclipse.rcptt.tesla.core.ui.impl.ControlImpl;

import org.eclipse.rcptt.tesla.ecl.nebula.NebulaGrid;
import org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridColumn;
import org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridImpl#isLinesVisible <em>Lines Visible</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridImpl#isMultiSelection <em>Multi Selection</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridImpl#isHeaderVisible <em>Header Visible</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridImpl#getItemCount <em>Item Count</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridImpl#getSelection <em>Selection</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridImpl#getColumns <em>Columns</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NebulaGridImpl extends ControlImpl implements NebulaGrid {
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
	 * The default value of the '{@link #isMultiSelection() <em>Multi Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiSelection()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTI_SELECTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMultiSelection() <em>Multi Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiSelection()
	 * @generated
	 * @ordered
	 */
	protected boolean multiSelection = MULTI_SELECTION_EDEFAULT;

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
	 * The default value of the '{@link #getItemCount() <em>Item Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemCount()
	 * @generated
	 * @ordered
	 */
	protected static final int ITEM_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getItemCount() <em>Item Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemCount()
	 * @generated
	 * @ordered
	 */
	protected int itemCount = ITEM_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSelection() <em>Selection</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelection()
	 * @generated
	 * @ordered
	 */
	protected EList<Selection> selection;

	/**
	 * The cached value of the '{@link #getColumns() <em>Columns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumns()
	 * @generated
	 * @ordered
	 */
	protected EList<NebulaGridColumn> columns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NebulaGridImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NebulaPackage.Literals.NEBULA_GRID;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID__LINES_VISIBLE, oldLinesVisible, linesVisible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMultiSelection() {
		return multiSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiSelection(boolean newMultiSelection) {
		boolean oldMultiSelection = multiSelection;
		multiSelection = newMultiSelection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID__MULTI_SELECTION, oldMultiSelection, multiSelection));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID__HEADER_VISIBLE, oldHeaderVisible, headerVisible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getItemCount() {
		return itemCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemCount(int newItemCount) {
		int oldItemCount = itemCount;
		itemCount = newItemCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID__ITEM_COUNT, oldItemCount, itemCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Selection> getSelection() {
		if (selection == null) {
			selection = new EObjectContainmentEList<Selection>(Selection.class, this, NebulaPackage.NEBULA_GRID__SELECTION);
		}
		return selection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NebulaGridColumn> getColumns() {
		if (columns == null) {
			columns = new EObjectContainmentEList<NebulaGridColumn>(NebulaGridColumn.class, this, NebulaPackage.NEBULA_GRID__COLUMNS);
		}
		return columns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NebulaPackage.NEBULA_GRID__SELECTION:
				return ((InternalEList<?>)getSelection()).basicRemove(otherEnd, msgs);
			case NebulaPackage.NEBULA_GRID__COLUMNS:
				return ((InternalEList<?>)getColumns()).basicRemove(otherEnd, msgs);
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
			case NebulaPackage.NEBULA_GRID__LINES_VISIBLE:
				return isLinesVisible();
			case NebulaPackage.NEBULA_GRID__MULTI_SELECTION:
				return isMultiSelection();
			case NebulaPackage.NEBULA_GRID__HEADER_VISIBLE:
				return isHeaderVisible();
			case NebulaPackage.NEBULA_GRID__ITEM_COUNT:
				return getItemCount();
			case NebulaPackage.NEBULA_GRID__SELECTION:
				return getSelection();
			case NebulaPackage.NEBULA_GRID__COLUMNS:
				return getColumns();
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
			case NebulaPackage.NEBULA_GRID__LINES_VISIBLE:
				setLinesVisible((Boolean)newValue);
				return;
			case NebulaPackage.NEBULA_GRID__MULTI_SELECTION:
				setMultiSelection((Boolean)newValue);
				return;
			case NebulaPackage.NEBULA_GRID__HEADER_VISIBLE:
				setHeaderVisible((Boolean)newValue);
				return;
			case NebulaPackage.NEBULA_GRID__ITEM_COUNT:
				setItemCount((Integer)newValue);
				return;
			case NebulaPackage.NEBULA_GRID__SELECTION:
				getSelection().clear();
				getSelection().addAll((Collection<? extends Selection>)newValue);
				return;
			case NebulaPackage.NEBULA_GRID__COLUMNS:
				getColumns().clear();
				getColumns().addAll((Collection<? extends NebulaGridColumn>)newValue);
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
			case NebulaPackage.NEBULA_GRID__LINES_VISIBLE:
				setLinesVisible(LINES_VISIBLE_EDEFAULT);
				return;
			case NebulaPackage.NEBULA_GRID__MULTI_SELECTION:
				setMultiSelection(MULTI_SELECTION_EDEFAULT);
				return;
			case NebulaPackage.NEBULA_GRID__HEADER_VISIBLE:
				setHeaderVisible(HEADER_VISIBLE_EDEFAULT);
				return;
			case NebulaPackage.NEBULA_GRID__ITEM_COUNT:
				setItemCount(ITEM_COUNT_EDEFAULT);
				return;
			case NebulaPackage.NEBULA_GRID__SELECTION:
				getSelection().clear();
				return;
			case NebulaPackage.NEBULA_GRID__COLUMNS:
				getColumns().clear();
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
			case NebulaPackage.NEBULA_GRID__LINES_VISIBLE:
				return linesVisible != LINES_VISIBLE_EDEFAULT;
			case NebulaPackage.NEBULA_GRID__MULTI_SELECTION:
				return multiSelection != MULTI_SELECTION_EDEFAULT;
			case NebulaPackage.NEBULA_GRID__HEADER_VISIBLE:
				return headerVisible != HEADER_VISIBLE_EDEFAULT;
			case NebulaPackage.NEBULA_GRID__ITEM_COUNT:
				return itemCount != ITEM_COUNT_EDEFAULT;
			case NebulaPackage.NEBULA_GRID__SELECTION:
				return selection != null && !selection.isEmpty();
			case NebulaPackage.NEBULA_GRID__COLUMNS:
				return columns != null && !columns.isEmpty();
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
		result.append(" (linesVisible: ");
		result.append(linesVisible);
		result.append(", multiSelection: ");
		result.append(multiSelection);
		result.append(", headerVisible: ");
		result.append(headerVisible);
		result.append(", itemCount: ");
		result.append(itemCount);
		result.append(')');
		return result.toString();
	}

} //NebulaGridImpl
