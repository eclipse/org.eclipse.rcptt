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
package org.eclipse.rcptt.workspace.impl;

import org.eclipse.rcptt.workspace.WSFile;
import org.eclipse.rcptt.workspace.WorkspacePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.workspace.impl.WSFileImpl#getContentURI <em>Content URI</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.impl.WSFileImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.impl.WSFileImpl#isExecutable <em>Executable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WSFileImpl extends WSResourceImpl implements WSFile {
	/**
	 * The default value of the '{@link #getContentURI() <em>Content URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentURI()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContentURI() <em>Content URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentURI()
	 * @generated
	 * @ordered
	 */
	protected String contentURI = CONTENT_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected byte[] content = CONTENT_EDEFAULT;

	/**
	 * The default value of the '{@link #isExecutable() <em>Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExecutable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXECUTABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExecutable() <em>Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExecutable()
	 * @generated
	 * @ordered
	 */
	protected boolean executable = EXECUTABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WSFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.WS_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContentURI() {
		return contentURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContentURI(String newContentURI) {
		String oldContentURI = contentURI;
		contentURI = newContentURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.WS_FILE__CONTENT_URI, oldContentURI, contentURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(byte[] newContent) {
		byte[] oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.WS_FILE__CONTENT, oldContent, content));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExecutable() {
		return executable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutable(boolean newExecutable) {
		boolean oldExecutable = executable;
		executable = newExecutable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.WS_FILE__EXECUTABLE, oldExecutable, executable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkspacePackage.WS_FILE__CONTENT_URI:
				return getContentURI();
			case WorkspacePackage.WS_FILE__CONTENT:
				return getContent();
			case WorkspacePackage.WS_FILE__EXECUTABLE:
				return isExecutable();
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
			case WorkspacePackage.WS_FILE__CONTENT_URI:
				setContentURI((String)newValue);
				return;
			case WorkspacePackage.WS_FILE__CONTENT:
				setContent((byte[])newValue);
				return;
			case WorkspacePackage.WS_FILE__EXECUTABLE:
				setExecutable((Boolean)newValue);
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
			case WorkspacePackage.WS_FILE__CONTENT_URI:
				setContentURI(CONTENT_URI_EDEFAULT);
				return;
			case WorkspacePackage.WS_FILE__CONTENT:
				setContent(CONTENT_EDEFAULT);
				return;
			case WorkspacePackage.WS_FILE__EXECUTABLE:
				setExecutable(EXECUTABLE_EDEFAULT);
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
			case WorkspacePackage.WS_FILE__CONTENT_URI:
				return CONTENT_URI_EDEFAULT == null ? contentURI != null : !CONTENT_URI_EDEFAULT.equals(contentURI);
			case WorkspacePackage.WS_FILE__CONTENT:
				return CONTENT_EDEFAULT == null ? content != null : !CONTENT_EDEFAULT.equals(content);
			case WorkspacePackage.WS_FILE__EXECUTABLE:
				return executable != EXECUTABLE_EDEFAULT;
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
		result.append(" (contentURI: ");
		result.append(contentURI);
		result.append(", content: ");
		result.append(content);
		result.append(", executable: ");
		result.append(executable);
		result.append(')');
		return result.toString();
	}

} //WSFileImpl
