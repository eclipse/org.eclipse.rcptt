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
package org.eclipse.rcptt.core.scenario.impl;

import org.eclipse.rcptt.core.scenario.Editor;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.core.scenario.WorkbenchContext;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workbench Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.WorkbenchContextImpl#getPerspectiveId <em>Perspective Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.WorkbenchContextImpl#isNoModalDialogs <em>No Modal Dialogs</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.WorkbenchContextImpl#isCloseEditors <em>Close Editors</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.WorkbenchContextImpl#getEditors <em>Editors</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.WorkbenchContextImpl#getViews <em>Views</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.WorkbenchContextImpl#isResetPerspective <em>Reset Perspective</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.WorkbenchContextImpl#isClearClipboard <em>Clear Clipboard</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkbenchContextImpl extends ContextImpl implements WorkbenchContext {
	/**
	 * The default value of the '{@link #getPerspectiveId() <em>Perspective Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerspectiveId()
	 * @generated
	 * @ordered
	 */
	protected static final String PERSPECTIVE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPerspectiveId() <em>Perspective Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerspectiveId()
	 * @generated
	 * @ordered
	 */
	protected String perspectiveId = PERSPECTIVE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isNoModalDialogs() <em>No Modal Dialogs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoModalDialogs()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_MODAL_DIALOGS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isNoModalDialogs() <em>No Modal Dialogs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoModalDialogs()
	 * @generated
	 * @ordered
	 */
	protected boolean noModalDialogs = NO_MODAL_DIALOGS_EDEFAULT;

	/**
	 * The default value of the '{@link #isCloseEditors() <em>Close Editors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCloseEditors()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLOSE_EDITORS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isCloseEditors() <em>Close Editors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCloseEditors()
	 * @generated
	 * @ordered
	 */
	protected boolean closeEditors = CLOSE_EDITORS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEditors() <em>Editors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditors()
	 * @generated
	 * @ordered
	 */
	protected EList<Editor> editors;

	/**
	 * The cached value of the '{@link #getViews() <em>Views</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViews()
	 * @generated
	 * @ordered
	 */
	protected EList<String> views;

	/**
	 * The default value of the '{@link #isResetPerspective() <em>Reset Perspective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResetPerspective()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESET_PERSPECTIVE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isResetPerspective() <em>Reset Perspective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResetPerspective()
	 * @generated
	 * @ordered
	 */
	protected boolean resetPerspective = RESET_PERSPECTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isClearClipboard() <em>Clear Clipboard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClearClipboard()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLEAR_CLIPBOARD_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isClearClipboard() <em>Clear Clipboard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClearClipboard()
	 * @generated
	 * @ordered
	 */
	protected boolean clearClipboard = CLEAR_CLIPBOARD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkbenchContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScenarioPackage.Literals.WORKBENCH_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPerspectiveId() {
		return perspectiveId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPerspectiveId(String newPerspectiveId) {
		String oldPerspectiveId = perspectiveId;
		perspectiveId = newPerspectiveId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.WORKBENCH_CONTEXT__PERSPECTIVE_ID, oldPerspectiveId, perspectiveId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNoModalDialogs() {
		return noModalDialogs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoModalDialogs(boolean newNoModalDialogs) {
		boolean oldNoModalDialogs = noModalDialogs;
		noModalDialogs = newNoModalDialogs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.WORKBENCH_CONTEXT__NO_MODAL_DIALOGS, oldNoModalDialogs, noModalDialogs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCloseEditors() {
		return closeEditors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCloseEditors(boolean newCloseEditors) {
		boolean oldCloseEditors = closeEditors;
		closeEditors = newCloseEditors;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.WORKBENCH_CONTEXT__CLOSE_EDITORS, oldCloseEditors, closeEditors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Editor> getEditors() {
		if (editors == null) {
			editors = new EObjectContainmentEList<Editor>(Editor.class, this, ScenarioPackage.WORKBENCH_CONTEXT__EDITORS);
		}
		return editors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getViews() {
		if (views == null) {
			views = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.WORKBENCH_CONTEXT__VIEWS);
		}
		return views;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResetPerspective() {
		return resetPerspective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResetPerspective(boolean newResetPerspective) {
		boolean oldResetPerspective = resetPerspective;
		resetPerspective = newResetPerspective;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.WORKBENCH_CONTEXT__RESET_PERSPECTIVE, oldResetPerspective, resetPerspective));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isClearClipboard() {
		return clearClipboard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClearClipboard(boolean newClearClipboard) {
		boolean oldClearClipboard = clearClipboard;
		clearClipboard = newClearClipboard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.WORKBENCH_CONTEXT__CLEAR_CLIPBOARD, oldClearClipboard, clearClipboard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScenarioPackage.WORKBENCH_CONTEXT__EDITORS:
				return ((InternalEList<?>)getEditors()).basicRemove(otherEnd, msgs);
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
			case ScenarioPackage.WORKBENCH_CONTEXT__PERSPECTIVE_ID:
				return getPerspectiveId();
			case ScenarioPackage.WORKBENCH_CONTEXT__NO_MODAL_DIALOGS:
				return isNoModalDialogs();
			case ScenarioPackage.WORKBENCH_CONTEXT__CLOSE_EDITORS:
				return isCloseEditors();
			case ScenarioPackage.WORKBENCH_CONTEXT__EDITORS:
				return getEditors();
			case ScenarioPackage.WORKBENCH_CONTEXT__VIEWS:
				return getViews();
			case ScenarioPackage.WORKBENCH_CONTEXT__RESET_PERSPECTIVE:
				return isResetPerspective();
			case ScenarioPackage.WORKBENCH_CONTEXT__CLEAR_CLIPBOARD:
				return isClearClipboard();
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
			case ScenarioPackage.WORKBENCH_CONTEXT__PERSPECTIVE_ID:
				setPerspectiveId((String)newValue);
				return;
			case ScenarioPackage.WORKBENCH_CONTEXT__NO_MODAL_DIALOGS:
				setNoModalDialogs((Boolean)newValue);
				return;
			case ScenarioPackage.WORKBENCH_CONTEXT__CLOSE_EDITORS:
				setCloseEditors((Boolean)newValue);
				return;
			case ScenarioPackage.WORKBENCH_CONTEXT__EDITORS:
				getEditors().clear();
				getEditors().addAll((Collection<? extends Editor>)newValue);
				return;
			case ScenarioPackage.WORKBENCH_CONTEXT__VIEWS:
				getViews().clear();
				getViews().addAll((Collection<? extends String>)newValue);
				return;
			case ScenarioPackage.WORKBENCH_CONTEXT__RESET_PERSPECTIVE:
				setResetPerspective((Boolean)newValue);
				return;
			case ScenarioPackage.WORKBENCH_CONTEXT__CLEAR_CLIPBOARD:
				setClearClipboard((Boolean)newValue);
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
			case ScenarioPackage.WORKBENCH_CONTEXT__PERSPECTIVE_ID:
				setPerspectiveId(PERSPECTIVE_ID_EDEFAULT);
				return;
			case ScenarioPackage.WORKBENCH_CONTEXT__NO_MODAL_DIALOGS:
				setNoModalDialogs(NO_MODAL_DIALOGS_EDEFAULT);
				return;
			case ScenarioPackage.WORKBENCH_CONTEXT__CLOSE_EDITORS:
				setCloseEditors(CLOSE_EDITORS_EDEFAULT);
				return;
			case ScenarioPackage.WORKBENCH_CONTEXT__EDITORS:
				getEditors().clear();
				return;
			case ScenarioPackage.WORKBENCH_CONTEXT__VIEWS:
				getViews().clear();
				return;
			case ScenarioPackage.WORKBENCH_CONTEXT__RESET_PERSPECTIVE:
				setResetPerspective(RESET_PERSPECTIVE_EDEFAULT);
				return;
			case ScenarioPackage.WORKBENCH_CONTEXT__CLEAR_CLIPBOARD:
				setClearClipboard(CLEAR_CLIPBOARD_EDEFAULT);
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
			case ScenarioPackage.WORKBENCH_CONTEXT__PERSPECTIVE_ID:
				return PERSPECTIVE_ID_EDEFAULT == null ? perspectiveId != null : !PERSPECTIVE_ID_EDEFAULT.equals(perspectiveId);
			case ScenarioPackage.WORKBENCH_CONTEXT__NO_MODAL_DIALOGS:
				return noModalDialogs != NO_MODAL_DIALOGS_EDEFAULT;
			case ScenarioPackage.WORKBENCH_CONTEXT__CLOSE_EDITORS:
				return closeEditors != CLOSE_EDITORS_EDEFAULT;
			case ScenarioPackage.WORKBENCH_CONTEXT__EDITORS:
				return editors != null && !editors.isEmpty();
			case ScenarioPackage.WORKBENCH_CONTEXT__VIEWS:
				return views != null && !views.isEmpty();
			case ScenarioPackage.WORKBENCH_CONTEXT__RESET_PERSPECTIVE:
				return resetPerspective != RESET_PERSPECTIVE_EDEFAULT;
			case ScenarioPackage.WORKBENCH_CONTEXT__CLEAR_CLIPBOARD:
				return clearClipboard != CLEAR_CLIPBOARD_EDEFAULT;
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
		result.append(" (perspectiveId: ");
		result.append(perspectiveId);
		result.append(", noModalDialogs: ");
		result.append(noModalDialogs);
		result.append(", closeEditors: ");
		result.append(closeEditors);
		result.append(", views: ");
		result.append(views);
		result.append(", resetPerspective: ");
		result.append(resetPerspective);
		result.append(", clearClipboard: ");
		result.append(clearClipboard);
		result.append(')');
		return result.toString();
	}

} //WorkbenchContextImpl
