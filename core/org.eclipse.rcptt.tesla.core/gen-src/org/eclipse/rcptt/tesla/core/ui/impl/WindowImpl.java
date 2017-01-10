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
package org.eclipse.rcptt.tesla.core.ui.impl;

import org.eclipse.rcptt.tesla.core.ui.UiPackage;
import org.eclipse.rcptt.tesla.core.ui.Window;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Window</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.WindowImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.WindowImpl#isSizeable <em>Sizeable</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.WindowImpl#isHasBorder <em>Has Border</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.WindowImpl#isHasMinimizeButton <em>Has Minimize Button</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.WindowImpl#isHasMaximizeButton <em>Has Maximize Button</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.WindowImpl#isHasCloseButton <em>Has Close Button</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.WindowImpl#isIsPrimaryModal <em>Is Primary Modal</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.WindowImpl#isIsApplicationModal <em>Is Application Modal</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.WindowImpl#isIsSystemModal <em>Is System Modal</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.WindowImpl#isIsTool <em>Is Tool</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.WindowImpl#isIsSheet <em>Is Sheet</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WindowImpl extends ControlImpl implements Window {
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isSizeable() <em>Sizeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSizeable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SIZEABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSizeable() <em>Sizeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSizeable()
	 * @generated
	 * @ordered
	 */
	protected boolean sizeable = SIZEABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasBorder() <em>Has Border</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasBorder()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_BORDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasBorder() <em>Has Border</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasBorder()
	 * @generated
	 * @ordered
	 */
	protected boolean hasBorder = HAS_BORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasMinimizeButton() <em>Has Minimize Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasMinimizeButton()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_MINIMIZE_BUTTON_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasMinimizeButton() <em>Has Minimize Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasMinimizeButton()
	 * @generated
	 * @ordered
	 */
	protected boolean hasMinimizeButton = HAS_MINIMIZE_BUTTON_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasMaximizeButton() <em>Has Maximize Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasMaximizeButton()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_MAXIMIZE_BUTTON_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasMaximizeButton() <em>Has Maximize Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasMaximizeButton()
	 * @generated
	 * @ordered
	 */
	protected boolean hasMaximizeButton = HAS_MAXIMIZE_BUTTON_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasCloseButton() <em>Has Close Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasCloseButton()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_CLOSE_BUTTON_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasCloseButton() <em>Has Close Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasCloseButton()
	 * @generated
	 * @ordered
	 */
	protected boolean hasCloseButton = HAS_CLOSE_BUTTON_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsPrimaryModal() <em>Is Primary Modal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPrimaryModal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PRIMARY_MODAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPrimaryModal() <em>Is Primary Modal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPrimaryModal()
	 * @generated
	 * @ordered
	 */
	protected boolean isPrimaryModal = IS_PRIMARY_MODAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsApplicationModal() <em>Is Application Modal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsApplicationModal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_APPLICATION_MODAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsApplicationModal() <em>Is Application Modal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsApplicationModal()
	 * @generated
	 * @ordered
	 */
	protected boolean isApplicationModal = IS_APPLICATION_MODAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsSystemModal() <em>Is System Modal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSystemModal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SYSTEM_MODAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsSystemModal() <em>Is System Modal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSystemModal()
	 * @generated
	 * @ordered
	 */
	protected boolean isSystemModal = IS_SYSTEM_MODAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsTool() <em>Is Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTool()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TOOL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsTool() <em>Is Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTool()
	 * @generated
	 * @ordered
	 */
	protected boolean isTool = IS_TOOL_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsSheet() <em>Is Sheet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSheet()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SHEET_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsSheet() <em>Is Sheet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSheet()
	 * @generated
	 * @ordered
	 */
	protected boolean isSheet = IS_SHEET_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiPackage.Literals.WINDOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.WINDOW__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSizeable() {
		return sizeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeable(boolean newSizeable) {
		boolean oldSizeable = sizeable;
		sizeable = newSizeable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.WINDOW__SIZEABLE, oldSizeable, sizeable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPrimaryModal() {
		return isPrimaryModal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPrimaryModal(boolean newIsPrimaryModal) {
		boolean oldIsPrimaryModal = isPrimaryModal;
		isPrimaryModal = newIsPrimaryModal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.WINDOW__IS_PRIMARY_MODAL, oldIsPrimaryModal, isPrimaryModal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsApplicationModal() {
		return isApplicationModal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsApplicationModal(boolean newIsApplicationModal) {
		boolean oldIsApplicationModal = isApplicationModal;
		isApplicationModal = newIsApplicationModal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.WINDOW__IS_APPLICATION_MODAL, oldIsApplicationModal, isApplicationModal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSystemModal() {
		return isSystemModal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSystemModal(boolean newIsSystemModal) {
		boolean oldIsSystemModal = isSystemModal;
		isSystemModal = newIsSystemModal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.WINDOW__IS_SYSTEM_MODAL, oldIsSystemModal, isSystemModal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsTool() {
		return isTool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTool(boolean newIsTool) {
		boolean oldIsTool = isTool;
		isTool = newIsTool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.WINDOW__IS_TOOL, oldIsTool, isTool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSheet() {
		return isSheet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSheet(boolean newIsSheet) {
		boolean oldIsSheet = isSheet;
		isSheet = newIsSheet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.WINDOW__IS_SHEET, oldIsSheet, isSheet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasCloseButton() {
		return hasCloseButton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasCloseButton(boolean newHasCloseButton) {
		boolean oldHasCloseButton = hasCloseButton;
		hasCloseButton = newHasCloseButton;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.WINDOW__HAS_CLOSE_BUTTON, oldHasCloseButton, hasCloseButton));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasMinimizeButton() {
		return hasMinimizeButton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasMinimizeButton(boolean newHasMinimizeButton) {
		boolean oldHasMinimizeButton = hasMinimizeButton;
		hasMinimizeButton = newHasMinimizeButton;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.WINDOW__HAS_MINIMIZE_BUTTON, oldHasMinimizeButton, hasMinimizeButton));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasMaximizeButton() {
		return hasMaximizeButton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasMaximizeButton(boolean newHasMaximizeButton) {
		boolean oldHasMaximizeButton = hasMaximizeButton;
		hasMaximizeButton = newHasMaximizeButton;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.WINDOW__HAS_MAXIMIZE_BUTTON, oldHasMaximizeButton, hasMaximizeButton));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasBorder() {
		return hasBorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasBorder(boolean newHasBorder) {
		boolean oldHasBorder = hasBorder;
		hasBorder = newHasBorder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.WINDOW__HAS_BORDER, oldHasBorder, hasBorder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UiPackage.WINDOW__TITLE:
				return getTitle();
			case UiPackage.WINDOW__SIZEABLE:
				return isSizeable();
			case UiPackage.WINDOW__HAS_BORDER:
				return isHasBorder();
			case UiPackage.WINDOW__HAS_MINIMIZE_BUTTON:
				return isHasMinimizeButton();
			case UiPackage.WINDOW__HAS_MAXIMIZE_BUTTON:
				return isHasMaximizeButton();
			case UiPackage.WINDOW__HAS_CLOSE_BUTTON:
				return isHasCloseButton();
			case UiPackage.WINDOW__IS_PRIMARY_MODAL:
				return isIsPrimaryModal();
			case UiPackage.WINDOW__IS_APPLICATION_MODAL:
				return isIsApplicationModal();
			case UiPackage.WINDOW__IS_SYSTEM_MODAL:
				return isIsSystemModal();
			case UiPackage.WINDOW__IS_TOOL:
				return isIsTool();
			case UiPackage.WINDOW__IS_SHEET:
				return isIsSheet();
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
			case UiPackage.WINDOW__TITLE:
				setTitle((String)newValue);
				return;
			case UiPackage.WINDOW__SIZEABLE:
				setSizeable((Boolean)newValue);
				return;
			case UiPackage.WINDOW__HAS_BORDER:
				setHasBorder((Boolean)newValue);
				return;
			case UiPackage.WINDOW__HAS_MINIMIZE_BUTTON:
				setHasMinimizeButton((Boolean)newValue);
				return;
			case UiPackage.WINDOW__HAS_MAXIMIZE_BUTTON:
				setHasMaximizeButton((Boolean)newValue);
				return;
			case UiPackage.WINDOW__HAS_CLOSE_BUTTON:
				setHasCloseButton((Boolean)newValue);
				return;
			case UiPackage.WINDOW__IS_PRIMARY_MODAL:
				setIsPrimaryModal((Boolean)newValue);
				return;
			case UiPackage.WINDOW__IS_APPLICATION_MODAL:
				setIsApplicationModal((Boolean)newValue);
				return;
			case UiPackage.WINDOW__IS_SYSTEM_MODAL:
				setIsSystemModal((Boolean)newValue);
				return;
			case UiPackage.WINDOW__IS_TOOL:
				setIsTool((Boolean)newValue);
				return;
			case UiPackage.WINDOW__IS_SHEET:
				setIsSheet((Boolean)newValue);
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
			case UiPackage.WINDOW__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case UiPackage.WINDOW__SIZEABLE:
				setSizeable(SIZEABLE_EDEFAULT);
				return;
			case UiPackage.WINDOW__HAS_BORDER:
				setHasBorder(HAS_BORDER_EDEFAULT);
				return;
			case UiPackage.WINDOW__HAS_MINIMIZE_BUTTON:
				setHasMinimizeButton(HAS_MINIMIZE_BUTTON_EDEFAULT);
				return;
			case UiPackage.WINDOW__HAS_MAXIMIZE_BUTTON:
				setHasMaximizeButton(HAS_MAXIMIZE_BUTTON_EDEFAULT);
				return;
			case UiPackage.WINDOW__HAS_CLOSE_BUTTON:
				setHasCloseButton(HAS_CLOSE_BUTTON_EDEFAULT);
				return;
			case UiPackage.WINDOW__IS_PRIMARY_MODAL:
				setIsPrimaryModal(IS_PRIMARY_MODAL_EDEFAULT);
				return;
			case UiPackage.WINDOW__IS_APPLICATION_MODAL:
				setIsApplicationModal(IS_APPLICATION_MODAL_EDEFAULT);
				return;
			case UiPackage.WINDOW__IS_SYSTEM_MODAL:
				setIsSystemModal(IS_SYSTEM_MODAL_EDEFAULT);
				return;
			case UiPackage.WINDOW__IS_TOOL:
				setIsTool(IS_TOOL_EDEFAULT);
				return;
			case UiPackage.WINDOW__IS_SHEET:
				setIsSheet(IS_SHEET_EDEFAULT);
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
			case UiPackage.WINDOW__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case UiPackage.WINDOW__SIZEABLE:
				return sizeable != SIZEABLE_EDEFAULT;
			case UiPackage.WINDOW__HAS_BORDER:
				return hasBorder != HAS_BORDER_EDEFAULT;
			case UiPackage.WINDOW__HAS_MINIMIZE_BUTTON:
				return hasMinimizeButton != HAS_MINIMIZE_BUTTON_EDEFAULT;
			case UiPackage.WINDOW__HAS_MAXIMIZE_BUTTON:
				return hasMaximizeButton != HAS_MAXIMIZE_BUTTON_EDEFAULT;
			case UiPackage.WINDOW__HAS_CLOSE_BUTTON:
				return hasCloseButton != HAS_CLOSE_BUTTON_EDEFAULT;
			case UiPackage.WINDOW__IS_PRIMARY_MODAL:
				return isPrimaryModal != IS_PRIMARY_MODAL_EDEFAULT;
			case UiPackage.WINDOW__IS_APPLICATION_MODAL:
				return isApplicationModal != IS_APPLICATION_MODAL_EDEFAULT;
			case UiPackage.WINDOW__IS_SYSTEM_MODAL:
				return isSystemModal != IS_SYSTEM_MODAL_EDEFAULT;
			case UiPackage.WINDOW__IS_TOOL:
				return isTool != IS_TOOL_EDEFAULT;
			case UiPackage.WINDOW__IS_SHEET:
				return isSheet != IS_SHEET_EDEFAULT;
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
		result.append(" (title: ");
		result.append(title);
		result.append(", sizeable: ");
		result.append(sizeable);
		result.append(", hasBorder: ");
		result.append(hasBorder);
		result.append(", hasMinimizeButton: ");
		result.append(hasMinimizeButton);
		result.append(", hasMaximizeButton: ");
		result.append(hasMaximizeButton);
		result.append(", hasCloseButton: ");
		result.append(hasCloseButton);
		result.append(", isPrimaryModal: ");
		result.append(isPrimaryModal);
		result.append(", isApplicationModal: ");
		result.append(isApplicationModal);
		result.append(", isSystemModal: ");
		result.append(isSystemModal);
		result.append(", isTool: ");
		result.append(isTool);
		result.append(", isSheet: ");
		result.append(isSheet);
		result.append(')');
		return result.toString();
	}

} //WindowImpl
