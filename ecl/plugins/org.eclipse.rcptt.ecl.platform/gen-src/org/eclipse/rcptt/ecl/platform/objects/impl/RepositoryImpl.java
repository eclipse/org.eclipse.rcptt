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
package org.eclipse.rcptt.ecl.platform.objects.impl;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.rcptt.ecl.platform.objects.ObjectsPackage;
import org.eclipse.rcptt.ecl.platform.objects.Repository;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.impl.RepositoryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.impl.RepositoryImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.impl.RepositoryImpl#isIsMetadata <em>Is Metadata</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.impl.RepositoryImpl#isIsArtifact <em>Is Artifact</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RepositoryImpl extends EObjectImpl implements Repository {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The default value of the '{@link #isIsMetadata() <em>Is Metadata</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMetadata()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_METADATA_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsMetadata() <em>Is Metadata</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsMetadata()
	 * @generated
	 * @ordered
	 */
	protected boolean isMetadata = IS_METADATA_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsArtifact() <em>Is Artifact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsArtifact()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ARTIFACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsArtifact() <em>Is Artifact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsArtifact()
	 * @generated
	 * @ordered
	 */
	protected boolean isArtifact = IS_ARTIFACT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ObjectsPackage.Literals.REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ObjectsPackage.REPOSITORY__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ObjectsPackage.REPOSITORY__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsMetadata() {
		return isMetadata;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsMetadata(boolean newIsMetadata) {
		boolean oldIsMetadata = isMetadata;
		isMetadata = newIsMetadata;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ObjectsPackage.REPOSITORY__IS_METADATA, oldIsMetadata, isMetadata));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsArtifact() {
		return isArtifact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsArtifact(boolean newIsArtifact) {
		boolean oldIsArtifact = isArtifact;
		isArtifact = newIsArtifact;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ObjectsPackage.REPOSITORY__IS_ARTIFACT, oldIsArtifact, isArtifact));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ObjectsPackage.REPOSITORY__NAME:
				return getName();
			case ObjectsPackage.REPOSITORY__LOCATION:
				return getLocation();
			case ObjectsPackage.REPOSITORY__IS_METADATA:
				return isIsMetadata();
			case ObjectsPackage.REPOSITORY__IS_ARTIFACT:
				return isIsArtifact();
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
			case ObjectsPackage.REPOSITORY__NAME:
				setName((String)newValue);
				return;
			case ObjectsPackage.REPOSITORY__LOCATION:
				setLocation((String)newValue);
				return;
			case ObjectsPackage.REPOSITORY__IS_METADATA:
				setIsMetadata((Boolean)newValue);
				return;
			case ObjectsPackage.REPOSITORY__IS_ARTIFACT:
				setIsArtifact((Boolean)newValue);
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
			case ObjectsPackage.REPOSITORY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ObjectsPackage.REPOSITORY__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case ObjectsPackage.REPOSITORY__IS_METADATA:
				setIsMetadata(IS_METADATA_EDEFAULT);
				return;
			case ObjectsPackage.REPOSITORY__IS_ARTIFACT:
				setIsArtifact(IS_ARTIFACT_EDEFAULT);
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
			case ObjectsPackage.REPOSITORY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ObjectsPackage.REPOSITORY__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case ObjectsPackage.REPOSITORY__IS_METADATA:
				return isMetadata != IS_METADATA_EDEFAULT;
			case ObjectsPackage.REPOSITORY__IS_ARTIFACT:
				return isArtifact != IS_ARTIFACT_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", location: ");
		result.append(location);
		result.append(", isMetadata: ");
		result.append(isMetadata);
		result.append(", isArtifact: ");
		result.append(isArtifact);
		result.append(')');
		return result.toString();
	}

} //RepositoryImpl
