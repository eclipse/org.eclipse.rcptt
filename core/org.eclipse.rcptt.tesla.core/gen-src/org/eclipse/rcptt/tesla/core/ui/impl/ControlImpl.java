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
package org.eclipse.rcptt.tesla.core.ui.impl;

import org.eclipse.rcptt.tesla.core.ui.Color;
import org.eclipse.rcptt.tesla.core.ui.Control;
import org.eclipse.rcptt.tesla.core.ui.ControlDecorator;
import org.eclipse.rcptt.tesla.core.ui.Rectangle;
import org.eclipse.rcptt.tesla.core.ui.UiPackage;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Control</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.ControlImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.ControlImpl#isEnablement <em>Enablement</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.ControlImpl#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.ControlImpl#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.ControlImpl#isContainMenu <em>Contain Menu</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.ControlImpl#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.ControlImpl#getBorderWith <em>Border With</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.ControlImpl#getDecorators <em>Decorators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ControlImpl extends WidgetImpl implements Control {
	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnablement() <em>Enablement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnablement()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLEMENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnablement() <em>Enablement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnablement()
	 * @generated
	 * @ordered
	 */
	protected boolean enablement = ENABLEMENT_EDEFAULT;

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
	 * The default value of the '{@link #isContainMenu() <em>Contain Menu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainMenu()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTAIN_MENU_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContainMenu() <em>Contain Menu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainMenu()
	 * @generated
	 * @ordered
	 */
	protected boolean containMenu = CONTAIN_MENU_EDEFAULT;

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
	 * The default value of the '{@link #getBorderWith() <em>Border With</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderWith()
	 * @generated
	 * @ordered
	 */
	protected static final int BORDER_WITH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBorderWith() <em>Border With</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderWith()
	 * @generated
	 * @ordered
	 */
	protected int borderWith = BORDER_WITH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDecorators() <em>Decorators</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecorators()
	 * @generated
	 * @ordered
	 */
	protected EList<ControlDecorator> decorators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControlImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiPackage.Literals.CONTROL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.CONTROL__CLASS_NAME, oldClassName, className));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnablement() {
		return enablement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnablement(boolean newEnablement) {
		boolean oldEnablement = enablement;
		enablement = newEnablement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.CONTROL__ENABLEMENT, oldEnablement, enablement));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.CONTROL__BACKGROUND_COLOR, oldBackgroundColor, newBackgroundColor);
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
				msgs = ((InternalEObject)backgroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.CONTROL__BACKGROUND_COLOR, null, msgs);
			if (newBackgroundColor != null)
				msgs = ((InternalEObject)newBackgroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.CONTROL__BACKGROUND_COLOR, null, msgs);
			msgs = basicSetBackgroundColor(newBackgroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.CONTROL__BACKGROUND_COLOR, newBackgroundColor, newBackgroundColor));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.CONTROL__FOREGROUND_COLOR, oldForegroundColor, newForegroundColor);
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
				msgs = ((InternalEObject)foregroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.CONTROL__FOREGROUND_COLOR, null, msgs);
			if (newForegroundColor != null)
				msgs = ((InternalEObject)newForegroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.CONTROL__FOREGROUND_COLOR, null, msgs);
			msgs = basicSetForegroundColor(newForegroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.CONTROL__FOREGROUND_COLOR, newForegroundColor, newForegroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContainMenu() {
		return containMenu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainMenu(boolean newContainMenu) {
		boolean oldContainMenu = containMenu;
		containMenu = newContainMenu;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.CONTROL__CONTAIN_MENU, oldContainMenu, containMenu));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.CONTROL__BOUNDS, oldBounds, newBounds);
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
				msgs = ((InternalEObject)bounds).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.CONTROL__BOUNDS, null, msgs);
			if (newBounds != null)
				msgs = ((InternalEObject)newBounds).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.CONTROL__BOUNDS, null, msgs);
			msgs = basicSetBounds(newBounds, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.CONTROL__BOUNDS, newBounds, newBounds));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBorderWith() {
		return borderWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorderWith(int newBorderWith) {
		int oldBorderWith = borderWith;
		borderWith = newBorderWith;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.CONTROL__BORDER_WITH, oldBorderWith, borderWith));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ControlDecorator> getDecorators() {
		if (decorators == null) {
			decorators = new EObjectResolvingEList<ControlDecorator>(ControlDecorator.class, this, UiPackage.CONTROL__DECORATORS);
		}
		return decorators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UiPackage.CONTROL__BACKGROUND_COLOR:
				return basicSetBackgroundColor(null, msgs);
			case UiPackage.CONTROL__FOREGROUND_COLOR:
				return basicSetForegroundColor(null, msgs);
			case UiPackage.CONTROL__BOUNDS:
				return basicSetBounds(null, msgs);
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
			case UiPackage.CONTROL__CLASS_NAME:
				return getClassName();
			case UiPackage.CONTROL__ENABLEMENT:
				return isEnablement();
			case UiPackage.CONTROL__BACKGROUND_COLOR:
				return getBackgroundColor();
			case UiPackage.CONTROL__FOREGROUND_COLOR:
				return getForegroundColor();
			case UiPackage.CONTROL__CONTAIN_MENU:
				return isContainMenu();
			case UiPackage.CONTROL__BOUNDS:
				return getBounds();
			case UiPackage.CONTROL__BORDER_WITH:
				return getBorderWith();
			case UiPackage.CONTROL__DECORATORS:
				return getDecorators();
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
			case UiPackage.CONTROL__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case UiPackage.CONTROL__ENABLEMENT:
				setEnablement((Boolean)newValue);
				return;
			case UiPackage.CONTROL__BACKGROUND_COLOR:
				setBackgroundColor((Color)newValue);
				return;
			case UiPackage.CONTROL__FOREGROUND_COLOR:
				setForegroundColor((Color)newValue);
				return;
			case UiPackage.CONTROL__CONTAIN_MENU:
				setContainMenu((Boolean)newValue);
				return;
			case UiPackage.CONTROL__BOUNDS:
				setBounds((Rectangle)newValue);
				return;
			case UiPackage.CONTROL__BORDER_WITH:
				setBorderWith((Integer)newValue);
				return;
			case UiPackage.CONTROL__DECORATORS:
				getDecorators().clear();
				getDecorators().addAll((Collection<? extends ControlDecorator>)newValue);
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
			case UiPackage.CONTROL__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case UiPackage.CONTROL__ENABLEMENT:
				setEnablement(ENABLEMENT_EDEFAULT);
				return;
			case UiPackage.CONTROL__BACKGROUND_COLOR:
				setBackgroundColor((Color)null);
				return;
			case UiPackage.CONTROL__FOREGROUND_COLOR:
				setForegroundColor((Color)null);
				return;
			case UiPackage.CONTROL__CONTAIN_MENU:
				setContainMenu(CONTAIN_MENU_EDEFAULT);
				return;
			case UiPackage.CONTROL__BOUNDS:
				setBounds((Rectangle)null);
				return;
			case UiPackage.CONTROL__BORDER_WITH:
				setBorderWith(BORDER_WITH_EDEFAULT);
				return;
			case UiPackage.CONTROL__DECORATORS:
				getDecorators().clear();
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
			case UiPackage.CONTROL__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case UiPackage.CONTROL__ENABLEMENT:
				return enablement != ENABLEMENT_EDEFAULT;
			case UiPackage.CONTROL__BACKGROUND_COLOR:
				return backgroundColor != null;
			case UiPackage.CONTROL__FOREGROUND_COLOR:
				return foregroundColor != null;
			case UiPackage.CONTROL__CONTAIN_MENU:
				return containMenu != CONTAIN_MENU_EDEFAULT;
			case UiPackage.CONTROL__BOUNDS:
				return bounds != null;
			case UiPackage.CONTROL__BORDER_WITH:
				return borderWith != BORDER_WITH_EDEFAULT;
			case UiPackage.CONTROL__DECORATORS:
				return decorators != null && !decorators.isEmpty();
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
		result.append(" (className: ");
		result.append(className);
		result.append(", enablement: ");
		result.append(enablement);
		result.append(", containMenu: ");
		result.append(containMenu);
		result.append(", borderWith: ");
		result.append(borderWith);
		result.append(')');
		return result.toString();
	}

} //ControlImpl
