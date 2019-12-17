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
package org.eclipse.rcptt.ecl.platform.objects;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.Repository#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.Repository#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.Repository#isIsMetadata <em>Is Metadata</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.Repository#isIsArtifact <em>Is Artifact</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.platform.objects.ObjectsPackage#getRepository()
 * @model
 * @generated
 */
public interface Repository extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.rcptt.ecl.platform.objects.ObjectsPackage#getRepository_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.platform.objects.Repository#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.eclipse.rcptt.ecl.platform.objects.ObjectsPackage#getRepository_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.platform.objects.Repository#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Is Metadata</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Metadata</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Metadata</em>' attribute.
	 * @see #setIsMetadata(boolean)
	 * @see org.eclipse.rcptt.ecl.platform.objects.ObjectsPackage#getRepository_IsMetadata()
	 * @model
	 * @generated
	 */
	boolean isIsMetadata();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.platform.objects.Repository#isIsMetadata <em>Is Metadata</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Metadata</em>' attribute.
	 * @see #isIsMetadata()
	 * @generated
	 */
	void setIsMetadata(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Artifact</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Artifact</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Artifact</em>' attribute.
	 * @see #setIsArtifact(boolean)
	 * @see org.eclipse.rcptt.ecl.platform.objects.ObjectsPackage#getRepository_IsArtifact()
	 * @model
	 * @generated
	 */
	boolean isIsArtifact();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.platform.objects.Repository#isIsArtifact <em>Is Artifact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Artifact</em>' attribute.
	 * @see #isIsArtifact()
	 * @generated
	 */
	void setIsArtifact(boolean value);

} // Repository
