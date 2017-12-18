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
package org.eclipse.rcptt.workspace.impl;

import org.eclipse.rcptt.workspace.WSFile;
import org.eclipse.rcptt.workspace.WSFileLink;
import org.eclipse.rcptt.workspace.WSFolder;
import org.eclipse.rcptt.workspace.WSFolderLink;
import org.eclipse.rcptt.workspace.WorkspacePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.workspace.impl.WSFolderImpl#getFiles <em>Files</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.impl.WSFolderImpl#getFolders <em>Folders</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.impl.WSFolderImpl#getFolderLinks <em>Folder Links</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.impl.WSFolderImpl#getFileLinks <em>File Links</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WSFolderImpl extends WSContainerImpl implements WSFolder {
	/**
	 * The cached value of the '{@link #getFiles() <em>Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<WSFile> files;

	/**
	 * The cached value of the '{@link #getFolders() <em>Folders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFolders()
	 * @generated
	 * @ordered
	 */
	protected EList<WSFolder> folders;

	/**
	 * The cached value of the '{@link #getFolderLinks() <em>Folder Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFolderLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<WSFolderLink> folderLinks;

	/**
	 * The cached value of the '{@link #getFileLinks() <em>File Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<WSFileLink> fileLinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WSFolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.WS_FOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WSFile> getFiles() {
		if (files == null) {
			files = new EObjectContainmentEList<WSFile>(WSFile.class, this, WorkspacePackage.WS_FOLDER__FILES);
		}
		return files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WSFolder> getFolders() {
		if (folders == null) {
			folders = new EObjectContainmentEList<WSFolder>(WSFolder.class, this, WorkspacePackage.WS_FOLDER__FOLDERS);
		}
		return folders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WSFolderLink> getFolderLinks() {
		if (folderLinks == null) {
			folderLinks = new EObjectContainmentEList<WSFolderLink>(WSFolderLink.class, this, WorkspacePackage.WS_FOLDER__FOLDER_LINKS);
		}
		return folderLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WSFileLink> getFileLinks() {
		if (fileLinks == null) {
			fileLinks = new EObjectContainmentEList<WSFileLink>(WSFileLink.class, this, WorkspacePackage.WS_FOLDER__FILE_LINKS);
		}
		return fileLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkspacePackage.WS_FOLDER__FILES:
				return ((InternalEList<?>)getFiles()).basicRemove(otherEnd, msgs);
			case WorkspacePackage.WS_FOLDER__FOLDERS:
				return ((InternalEList<?>)getFolders()).basicRemove(otherEnd, msgs);
			case WorkspacePackage.WS_FOLDER__FOLDER_LINKS:
				return ((InternalEList<?>)getFolderLinks()).basicRemove(otherEnd, msgs);
			case WorkspacePackage.WS_FOLDER__FILE_LINKS:
				return ((InternalEList<?>)getFileLinks()).basicRemove(otherEnd, msgs);
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
			case WorkspacePackage.WS_FOLDER__FILES:
				return getFiles();
			case WorkspacePackage.WS_FOLDER__FOLDERS:
				return getFolders();
			case WorkspacePackage.WS_FOLDER__FOLDER_LINKS:
				return getFolderLinks();
			case WorkspacePackage.WS_FOLDER__FILE_LINKS:
				return getFileLinks();
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
			case WorkspacePackage.WS_FOLDER__FILES:
				getFiles().clear();
				getFiles().addAll((Collection<? extends WSFile>)newValue);
				return;
			case WorkspacePackage.WS_FOLDER__FOLDERS:
				getFolders().clear();
				getFolders().addAll((Collection<? extends WSFolder>)newValue);
				return;
			case WorkspacePackage.WS_FOLDER__FOLDER_LINKS:
				getFolderLinks().clear();
				getFolderLinks().addAll((Collection<? extends WSFolderLink>)newValue);
				return;
			case WorkspacePackage.WS_FOLDER__FILE_LINKS:
				getFileLinks().clear();
				getFileLinks().addAll((Collection<? extends WSFileLink>)newValue);
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
			case WorkspacePackage.WS_FOLDER__FILES:
				getFiles().clear();
				return;
			case WorkspacePackage.WS_FOLDER__FOLDERS:
				getFolders().clear();
				return;
			case WorkspacePackage.WS_FOLDER__FOLDER_LINKS:
				getFolderLinks().clear();
				return;
			case WorkspacePackage.WS_FOLDER__FILE_LINKS:
				getFileLinks().clear();
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
			case WorkspacePackage.WS_FOLDER__FILES:
				return files != null && !files.isEmpty();
			case WorkspacePackage.WS_FOLDER__FOLDERS:
				return folders != null && !folders.isEmpty();
			case WorkspacePackage.WS_FOLDER__FOLDER_LINKS:
				return folderLinks != null && !folderLinks.isEmpty();
			case WorkspacePackage.WS_FOLDER__FILE_LINKS:
				return fileLinks != null && !fileLinks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //WSFolderImpl
