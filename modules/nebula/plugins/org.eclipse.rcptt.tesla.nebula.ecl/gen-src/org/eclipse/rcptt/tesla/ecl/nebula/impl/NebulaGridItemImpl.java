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

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.rcptt.tesla.core.ui.Color;
import org.eclipse.rcptt.tesla.core.ui.Rectangle;

import org.eclipse.rcptt.tesla.core.ui.impl.ItemImpl;

import org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem;
import org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grid Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridItemImpl#isChecked <em>Checked</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridItemImpl#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridItemImpl#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridItemImpl#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridItemImpl#getChildCount <em>Child Count</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridItemImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridItemImpl#getColumnsBackgroundColor <em>Columns Background Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridItemImpl#getColumnsForegroundColor <em>Columns Foreground Color</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NebulaGridItemImpl extends ItemImpl implements NebulaGridItem {
	/**
	 * The default value of the '{@link #isChecked() <em>Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChecked()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECKED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isChecked() <em>Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChecked()
	 * @generated
	 * @ordered
	 */
	protected boolean checked = CHECKED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundColor()
	 * @generated
	 * @ordered
	 */
	protected Color backgroundColor;

	/**
	 * The cached value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForegroundColor()
	 * @generated
	 * @ordered
	 */
	protected Color foregroundColor;

	/**
	 * The cached value of the '{@link #getBounds() <em>Bounds</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBounds()
	 * @generated
	 * @ordered
	 */
	protected Rectangle bounds;

	/**
	 * The default value of the '{@link #getChildCount() <em>Child Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildCount()
	 * @generated
	 * @ordered
	 */
	protected static final Integer CHILD_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChildCount() <em>Child Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildCount()
	 * @generated
	 * @ordered
	 */
	protected Integer childCount = CHILD_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getColumns() <em>Columns</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumns()
	 * @generated
	 * @ordered
	 */
	protected EList<String> columns;

	/**
	 * The cached value of the '{@link #getColumnsBackgroundColor() <em>Columns Background Color</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnsBackgroundColor()
	 * @generated
	 * @ordered
	 */
	protected EList<Color> columnsBackgroundColor;

	/**
	 * The cached value of the '{@link #getColumnsForegroundColor() <em>Columns Foreground Color</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnsForegroundColor()
	 * @generated
	 * @ordered
	 */
	protected EList<Color> columnsForegroundColor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NebulaGridItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NebulaPackage.Literals.NEBULA_GRID_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChecked(boolean newChecked) {
		boolean oldChecked = checked;
		checked = newChecked;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID_ITEM__CHECKED, oldChecked, checked));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBackgroundColor(Color newBackgroundColor, NotificationChain msgs) {
		Color oldBackgroundColor = backgroundColor;
		backgroundColor = newBackgroundColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID_ITEM__BACKGROUND_COLOR, oldBackgroundColor, newBackgroundColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackgroundColor(Color newBackgroundColor) {
		if (newBackgroundColor != backgroundColor) {
			NotificationChain msgs = null;
			if (backgroundColor != null)
				msgs = ((InternalEObject)backgroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NebulaPackage.NEBULA_GRID_ITEM__BACKGROUND_COLOR, null, msgs);
			if (newBackgroundColor != null)
				msgs = ((InternalEObject)newBackgroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NebulaPackage.NEBULA_GRID_ITEM__BACKGROUND_COLOR, null, msgs);
			msgs = basicSetBackgroundColor(newBackgroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID_ITEM__BACKGROUND_COLOR, newBackgroundColor, newBackgroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getForegroundColor() {
		return foregroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForegroundColor(Color newForegroundColor, NotificationChain msgs) {
		Color oldForegroundColor = foregroundColor;
		foregroundColor = newForegroundColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID_ITEM__FOREGROUND_COLOR, oldForegroundColor, newForegroundColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForegroundColor(Color newForegroundColor) {
		if (newForegroundColor != foregroundColor) {
			NotificationChain msgs = null;
			if (foregroundColor != null)
				msgs = ((InternalEObject)foregroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NebulaPackage.NEBULA_GRID_ITEM__FOREGROUND_COLOR, null, msgs);
			if (newForegroundColor != null)
				msgs = ((InternalEObject)newForegroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NebulaPackage.NEBULA_GRID_ITEM__FOREGROUND_COLOR, null, msgs);
			msgs = basicSetForegroundColor(newForegroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID_ITEM__FOREGROUND_COLOR, newForegroundColor, newForegroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rectangle getBounds() {
		return bounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBounds(Rectangle newBounds, NotificationChain msgs) {
		Rectangle oldBounds = bounds;
		bounds = newBounds;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID_ITEM__BOUNDS, oldBounds, newBounds);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBounds(Rectangle newBounds) {
		if (newBounds != bounds) {
			NotificationChain msgs = null;
			if (bounds != null)
				msgs = ((InternalEObject)bounds).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NebulaPackage.NEBULA_GRID_ITEM__BOUNDS, null, msgs);
			if (newBounds != null)
				msgs = ((InternalEObject)newBounds).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NebulaPackage.NEBULA_GRID_ITEM__BOUNDS, null, msgs);
			msgs = basicSetBounds(newBounds, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID_ITEM__BOUNDS, newBounds, newBounds));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getChildCount() {
		return childCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildCount(Integer newChildCount) {
		Integer oldChildCount = childCount;
		childCount = newChildCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID_ITEM__CHILD_COUNT, oldChildCount, childCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getColumns() {
		if (columns == null) {
			columns = new EDataTypeEList<String>(String.class, this, NebulaPackage.NEBULA_GRID_ITEM__COLUMNS);
		}
		return columns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Color> getColumnsBackgroundColor() {
		if (columnsBackgroundColor == null) {
			columnsBackgroundColor = new EObjectContainmentEList<Color>(Color.class, this, NebulaPackage.NEBULA_GRID_ITEM__COLUMNS_BACKGROUND_COLOR);
		}
		return columnsBackgroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Color> getColumnsForegroundColor() {
		if (columnsForegroundColor == null) {
			columnsForegroundColor = new EObjectContainmentEList<Color>(Color.class, this, NebulaPackage.NEBULA_GRID_ITEM__COLUMNS_FOREGROUND_COLOR);
		}
		return columnsForegroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NebulaPackage.NEBULA_GRID_ITEM__BACKGROUND_COLOR:
				return basicSetBackgroundColor(null, msgs);
			case NebulaPackage.NEBULA_GRID_ITEM__FOREGROUND_COLOR:
				return basicSetForegroundColor(null, msgs);
			case NebulaPackage.NEBULA_GRID_ITEM__BOUNDS:
				return basicSetBounds(null, msgs);
			case NebulaPackage.NEBULA_GRID_ITEM__COLUMNS_BACKGROUND_COLOR:
				return ((InternalEList<?>)getColumnsBackgroundColor()).basicRemove(otherEnd, msgs);
			case NebulaPackage.NEBULA_GRID_ITEM__COLUMNS_FOREGROUND_COLOR:
				return ((InternalEList<?>)getColumnsForegroundColor()).basicRemove(otherEnd, msgs);
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
			case NebulaPackage.NEBULA_GRID_ITEM__CHECKED:
				return isChecked();
			case NebulaPackage.NEBULA_GRID_ITEM__BACKGROUND_COLOR:
				return getBackgroundColor();
			case NebulaPackage.NEBULA_GRID_ITEM__FOREGROUND_COLOR:
				return getForegroundColor();
			case NebulaPackage.NEBULA_GRID_ITEM__BOUNDS:
				return getBounds();
			case NebulaPackage.NEBULA_GRID_ITEM__CHILD_COUNT:
				return getChildCount();
			case NebulaPackage.NEBULA_GRID_ITEM__COLUMNS:
				return getColumns();
			case NebulaPackage.NEBULA_GRID_ITEM__COLUMNS_BACKGROUND_COLOR:
				return getColumnsBackgroundColor();
			case NebulaPackage.NEBULA_GRID_ITEM__COLUMNS_FOREGROUND_COLOR:
				return getColumnsForegroundColor();
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
			case NebulaPackage.NEBULA_GRID_ITEM__CHECKED:
				setChecked((Boolean)newValue);
				return;
			case NebulaPackage.NEBULA_GRID_ITEM__BACKGROUND_COLOR:
				setBackgroundColor((Color)newValue);
				return;
			case NebulaPackage.NEBULA_GRID_ITEM__FOREGROUND_COLOR:
				setForegroundColor((Color)newValue);
				return;
			case NebulaPackage.NEBULA_GRID_ITEM__BOUNDS:
				setBounds((Rectangle)newValue);
				return;
			case NebulaPackage.NEBULA_GRID_ITEM__CHILD_COUNT:
				setChildCount((Integer)newValue);
				return;
			case NebulaPackage.NEBULA_GRID_ITEM__COLUMNS:
				getColumns().clear();
				getColumns().addAll((Collection<? extends String>)newValue);
				return;
			case NebulaPackage.NEBULA_GRID_ITEM__COLUMNS_BACKGROUND_COLOR:
				getColumnsBackgroundColor().clear();
				getColumnsBackgroundColor().addAll((Collection<? extends Color>)newValue);
				return;
			case NebulaPackage.NEBULA_GRID_ITEM__COLUMNS_FOREGROUND_COLOR:
				getColumnsForegroundColor().clear();
				getColumnsForegroundColor().addAll((Collection<? extends Color>)newValue);
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
			case NebulaPackage.NEBULA_GRID_ITEM__CHECKED:
				setChecked(CHECKED_EDEFAULT);
				return;
			case NebulaPackage.NEBULA_GRID_ITEM__BACKGROUND_COLOR:
				setBackgroundColor((Color)null);
				return;
			case NebulaPackage.NEBULA_GRID_ITEM__FOREGROUND_COLOR:
				setForegroundColor((Color)null);
				return;
			case NebulaPackage.NEBULA_GRID_ITEM__BOUNDS:
				setBounds((Rectangle)null);
				return;
			case NebulaPackage.NEBULA_GRID_ITEM__CHILD_COUNT:
				setChildCount(CHILD_COUNT_EDEFAULT);
				return;
			case NebulaPackage.NEBULA_GRID_ITEM__COLUMNS:
				getColumns().clear();
				return;
			case NebulaPackage.NEBULA_GRID_ITEM__COLUMNS_BACKGROUND_COLOR:
				getColumnsBackgroundColor().clear();
				return;
			case NebulaPackage.NEBULA_GRID_ITEM__COLUMNS_FOREGROUND_COLOR:
				getColumnsForegroundColor().clear();
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
			case NebulaPackage.NEBULA_GRID_ITEM__CHECKED:
				return checked != CHECKED_EDEFAULT;
			case NebulaPackage.NEBULA_GRID_ITEM__BACKGROUND_COLOR:
				return backgroundColor != null;
			case NebulaPackage.NEBULA_GRID_ITEM__FOREGROUND_COLOR:
				return foregroundColor != null;
			case NebulaPackage.NEBULA_GRID_ITEM__BOUNDS:
				return bounds != null;
			case NebulaPackage.NEBULA_GRID_ITEM__CHILD_COUNT:
				return CHILD_COUNT_EDEFAULT == null ? childCount != null : !CHILD_COUNT_EDEFAULT.equals(childCount);
			case NebulaPackage.NEBULA_GRID_ITEM__COLUMNS:
				return columns != null && !columns.isEmpty();
			case NebulaPackage.NEBULA_GRID_ITEM__COLUMNS_BACKGROUND_COLOR:
				return columnsBackgroundColor != null && !columnsBackgroundColor.isEmpty();
			case NebulaPackage.NEBULA_GRID_ITEM__COLUMNS_FOREGROUND_COLOR:
				return columnsForegroundColor != null && !columnsForegroundColor.isEmpty();
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
		result.append(" (checked: ");
		result.append(checked);
		result.append(", childCount: ");
		result.append(childCount);
		result.append(", columns: ");
		result.append(columns);
		result.append(')');
		return result.toString();
	}

} //NebulaGridItemImpl
