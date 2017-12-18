/*******************************************************************************
 * Copyright (c) 2009, 2017 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.workspace.impl;

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

import org.eclipse.rcptt.core.scenario.Attachment;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.core.scenario.Verification;

import org.eclipse.rcptt.core.scenario.impl.VerificationImpl;
import org.eclipse.rcptt.workspace.WSRoot;
import org.eclipse.rcptt.workspace.WorkspaceData;
import org.eclipse.rcptt.workspace.WorkspacePackage;
import org.eclipse.rcptt.workspace.WorkspaceVerification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.workspace.impl.WorkspaceVerificationImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.impl.WorkspaceVerificationImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.impl.WorkspaceVerificationImpl#isAllowUncapturedFiles <em>Allow Uncaptured Files</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.impl.WorkspaceVerificationImpl#getIgnoredLines <em>Ignored Lines</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkspaceVerificationImpl extends VerificationImpl implements WorkspaceVerification {
	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected WSRoot content;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowUncapturedFiles() <em>Allow Uncaptured Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowUncapturedFiles()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_UNCAPTURED_FILES_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAllowUncapturedFiles() <em>Allow Uncaptured Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowUncapturedFiles()
	 * @generated
	 * @ordered
	 */
	protected boolean allowUncapturedFiles = ALLOW_UNCAPTURED_FILES_EDEFAULT;

	/**
	 * The default value of the '{@link #getIgnoredLines() <em>Ignored Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIgnoredLines()
	 * @generated
	 * @ordered
	 */
	protected static final String IGNORED_LINES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIgnoredLines() <em>Ignored Lines</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIgnoredLines()
	 * @generated
	 * @ordered
	 */
	protected String ignoredLines = IGNORED_LINES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkspaceVerificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.WORKSPACE_VERIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WSRoot getContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContent(WSRoot newContent, NotificationChain msgs) {
		WSRoot oldContent = content;
		content = newContent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkspacePackage.WORKSPACE_VERIFICATION__CONTENT, oldContent, newContent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(WSRoot newContent) {
		if (newContent != content) {
			NotificationChain msgs = null;
			if (content != null)
				msgs = ((InternalEObject)content).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkspacePackage.WORKSPACE_VERIFICATION__CONTENT, null, msgs);
			if (newContent != null)
				msgs = ((InternalEObject)newContent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkspacePackage.WORKSPACE_VERIFICATION__CONTENT, null, msgs);
			msgs = basicSetContent(newContent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.WORKSPACE_VERIFICATION__CONTENT, newContent, newContent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.WORKSPACE_VERIFICATION__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowUncapturedFiles() {
		return allowUncapturedFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowUncapturedFiles(boolean newAllowUncapturedFiles) {
		boolean oldAllowUncapturedFiles = allowUncapturedFiles;
		allowUncapturedFiles = newAllowUncapturedFiles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.WORKSPACE_VERIFICATION__ALLOW_UNCAPTURED_FILES, oldAllowUncapturedFiles, allowUncapturedFiles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIgnoredLines() {
		return ignoredLines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIgnoredLines(String newIgnoredLines) {
		String oldIgnoredLines = ignoredLines;
		ignoredLines = newIgnoredLines;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.WORKSPACE_VERIFICATION__IGNORED_LINES, oldIgnoredLines, ignoredLines));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkspacePackage.WORKSPACE_VERIFICATION__CONTENT:
				return basicSetContent(null, msgs);
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
			case WorkspacePackage.WORKSPACE_VERIFICATION__CONTENT:
				return getContent();
			case WorkspacePackage.WORKSPACE_VERIFICATION__LOCATION:
				return getLocation();
			case WorkspacePackage.WORKSPACE_VERIFICATION__ALLOW_UNCAPTURED_FILES:
				return isAllowUncapturedFiles();
			case WorkspacePackage.WORKSPACE_VERIFICATION__IGNORED_LINES:
				return getIgnoredLines();
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
			case WorkspacePackage.WORKSPACE_VERIFICATION__CONTENT:
				setContent((WSRoot)newValue);
				return;
			case WorkspacePackage.WORKSPACE_VERIFICATION__LOCATION:
				setLocation((String)newValue);
				return;
			case WorkspacePackage.WORKSPACE_VERIFICATION__ALLOW_UNCAPTURED_FILES:
				setAllowUncapturedFiles((Boolean)newValue);
				return;
			case WorkspacePackage.WORKSPACE_VERIFICATION__IGNORED_LINES:
				setIgnoredLines((String)newValue);
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
			case WorkspacePackage.WORKSPACE_VERIFICATION__CONTENT:
				setContent((WSRoot)null);
				return;
			case WorkspacePackage.WORKSPACE_VERIFICATION__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case WorkspacePackage.WORKSPACE_VERIFICATION__ALLOW_UNCAPTURED_FILES:
				setAllowUncapturedFiles(ALLOW_UNCAPTURED_FILES_EDEFAULT);
				return;
			case WorkspacePackage.WORKSPACE_VERIFICATION__IGNORED_LINES:
				setIgnoredLines(IGNORED_LINES_EDEFAULT);
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
			case WorkspacePackage.WORKSPACE_VERIFICATION__CONTENT:
				return content != null;
			case WorkspacePackage.WORKSPACE_VERIFICATION__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case WorkspacePackage.WORKSPACE_VERIFICATION__ALLOW_UNCAPTURED_FILES:
				return allowUncapturedFiles != ALLOW_UNCAPTURED_FILES_EDEFAULT;
			case WorkspacePackage.WORKSPACE_VERIFICATION__IGNORED_LINES:
				return IGNORED_LINES_EDEFAULT == null ? ignoredLines != null : !IGNORED_LINES_EDEFAULT.equals(ignoredLines);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == WorkspaceData.class) {
			switch (derivedFeatureID) {
				case WorkspacePackage.WORKSPACE_VERIFICATION__CONTENT: return WorkspacePackage.WORKSPACE_DATA__CONTENT;
				case WorkspacePackage.WORKSPACE_VERIFICATION__LOCATION: return WorkspacePackage.WORKSPACE_DATA__LOCATION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == WorkspaceData.class) {
			switch (baseFeatureID) {
				case WorkspacePackage.WORKSPACE_DATA__CONTENT: return WorkspacePackage.WORKSPACE_VERIFICATION__CONTENT;
				case WorkspacePackage.WORKSPACE_DATA__LOCATION: return WorkspacePackage.WORKSPACE_VERIFICATION__LOCATION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (location: ");
		result.append(location);
		result.append(", allowUncapturedFiles: ");
		result.append(allowUncapturedFiles);
		result.append(", ignoredLines: ");
		result.append(ignoredLines);
		result.append(')');
		return result.toString();
	}

} //WorkspaceVerificationImpl
