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
package org.eclipse.rcptt.filesystem.impl;

import org.eclipse.rcptt.filesystem.FSFile;
import org.eclipse.rcptt.filesystem.FSFolder;
import org.eclipse.rcptt.filesystem.FilesystemPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FS Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.filesystem.impl.FSFolderImpl#getFolders <em>Folders</em>}</li>
 *   <li>{@link org.eclipse.rcptt.filesystem.impl.FSFolderImpl#getFiles <em>Files</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FSFolderImpl extends FSResourceImpl implements FSFolder {
	/**
	 * The cached value of the '{@link #getFolders() <em>Folders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFolders()
	 * @generated
	 * @ordered
	 */
	protected EList<FSFolder> folders;

	/**
	 * The cached value of the '{@link #getFiles() <em>Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<FSFile> files;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FSFolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FilesystemPackage.Literals.FS_FOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FSFolder> getFolders() {
		if (folders == null) {
			folders = new EObjectContainmentEList<FSFolder>(FSFolder.class, this, FilesystemPackage.FS_FOLDER__FOLDERS);
		}
		return folders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FSFile> getFiles() {
		if (files == null) {
			files = new EObjectContainmentEList<FSFile>(FSFile.class, this, FilesystemPackage.FS_FOLDER__FILES);
		}
		return files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FilesystemPackage.FS_FOLDER__FOLDERS:
				return ((InternalEList<?>)getFolders()).basicRemove(otherEnd, msgs);
			case FilesystemPackage.FS_FOLDER__FILES:
				return ((InternalEList<?>)getFiles()).basicRemove(otherEnd, msgs);
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
			case FilesystemPackage.FS_FOLDER__FOLDERS:
				return getFolders();
			case FilesystemPackage.FS_FOLDER__FILES:
				return getFiles();
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
			case FilesystemPackage.FS_FOLDER__FOLDERS:
				getFolders().clear();
				getFolders().addAll((Collection<? extends FSFolder>)newValue);
				return;
			case FilesystemPackage.FS_FOLDER__FILES:
				getFiles().clear();
				getFiles().addAll((Collection<? extends FSFile>)newValue);
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
			case FilesystemPackage.FS_FOLDER__FOLDERS:
				getFolders().clear();
				return;
			case FilesystemPackage.FS_FOLDER__FILES:
				getFiles().clear();
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
			case FilesystemPackage.FS_FOLDER__FOLDERS:
				return folders != null && !folders.isEmpty();
			case FilesystemPackage.FS_FOLDER__FILES:
				return files != null && !files.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FSFolderImpl
