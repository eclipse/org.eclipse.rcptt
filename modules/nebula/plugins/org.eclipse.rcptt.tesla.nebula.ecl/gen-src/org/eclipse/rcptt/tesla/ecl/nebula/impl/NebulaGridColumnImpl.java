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
package org.eclipse.rcptt.tesla.ecl.nebula.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.rcptt.tesla.core.ui.impl.ItemImpl;

import org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridColumn;
import org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grid Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridColumnImpl#isResizable <em>Resizable</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridColumnImpl#isMovable <em>Movable</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridColumnImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.impl.NebulaGridColumnImpl#getTooltip <em>Tooltip</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NebulaGridColumnImpl extends ItemImpl implements NebulaGridColumn {
	/**
	 * The default value of the '{@link #isResizable() <em>Resizable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResizable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESIZABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isResizable() <em>Resizable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResizable()
	 * @generated
	 * @ordered
	 */
	protected boolean resizable = RESIZABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isMovable() <em>Movable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMovable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MOVABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMovable() <em>Movable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMovable()
	 * @generated
	 * @ordered
	 */
	protected boolean movable = MOVABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected int width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getTooltip() <em>Tooltip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTooltip()
	 * @generated
	 * @ordered
	 */
	protected static final String TOOLTIP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTooltip() <em>Tooltip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTooltip()
	 * @generated
	 * @ordered
	 */
	protected String tooltip = TOOLTIP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NebulaGridColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NebulaPackage.Literals.NEBULA_GRID_COLUMN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResizable() {
		return resizable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResizable(boolean newResizable) {
		boolean oldResizable = resizable;
		resizable = newResizable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID_COLUMN__RESIZABLE, oldResizable, resizable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMovable() {
		return movable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMovable(boolean newMovable) {
		boolean oldMovable = movable;
		movable = newMovable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID_COLUMN__MOVABLE, oldMovable, movable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(int newWidth) {
		int oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID_COLUMN__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTooltip() {
		return tooltip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTooltip(String newTooltip) {
		String oldTooltip = tooltip;
		tooltip = newTooltip;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NebulaPackage.NEBULA_GRID_COLUMN__TOOLTIP, oldTooltip, tooltip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NebulaPackage.NEBULA_GRID_COLUMN__RESIZABLE:
				return isResizable();
			case NebulaPackage.NEBULA_GRID_COLUMN__MOVABLE:
				return isMovable();
			case NebulaPackage.NEBULA_GRID_COLUMN__WIDTH:
				return getWidth();
			case NebulaPackage.NEBULA_GRID_COLUMN__TOOLTIP:
				return getTooltip();
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
			case NebulaPackage.NEBULA_GRID_COLUMN__RESIZABLE:
				setResizable((Boolean)newValue);
				return;
			case NebulaPackage.NEBULA_GRID_COLUMN__MOVABLE:
				setMovable((Boolean)newValue);
				return;
			case NebulaPackage.NEBULA_GRID_COLUMN__WIDTH:
				setWidth((Integer)newValue);
				return;
			case NebulaPackage.NEBULA_GRID_COLUMN__TOOLTIP:
				setTooltip((String)newValue);
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
			case NebulaPackage.NEBULA_GRID_COLUMN__RESIZABLE:
				setResizable(RESIZABLE_EDEFAULT);
				return;
			case NebulaPackage.NEBULA_GRID_COLUMN__MOVABLE:
				setMovable(MOVABLE_EDEFAULT);
				return;
			case NebulaPackage.NEBULA_GRID_COLUMN__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case NebulaPackage.NEBULA_GRID_COLUMN__TOOLTIP:
				setTooltip(TOOLTIP_EDEFAULT);
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
			case NebulaPackage.NEBULA_GRID_COLUMN__RESIZABLE:
				return resizable != RESIZABLE_EDEFAULT;
			case NebulaPackage.NEBULA_GRID_COLUMN__MOVABLE:
				return movable != MOVABLE_EDEFAULT;
			case NebulaPackage.NEBULA_GRID_COLUMN__WIDTH:
				return width != WIDTH_EDEFAULT;
			case NebulaPackage.NEBULA_GRID_COLUMN__TOOLTIP:
				return TOOLTIP_EDEFAULT == null ? tooltip != null : !TOOLTIP_EDEFAULT.equals(tooltip);
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
		result.append(" (resizable: ");
		result.append(resizable);
		result.append(", movable: ");
		result.append(movable);
		result.append(", width: ");
		result.append(width);
		result.append(", tooltip: ");
		result.append(tooltip);
		result.append(')');
		return result.toString();
	}

} //NebulaGridColumnImpl
