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
package org.eclipse.rcptt.debug;

import org.eclipse.rcptt.core.scenario.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Launch Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.debug.LaunchType#getImage <em>Image</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.LaunchType#getConfigurations <em>Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.debug.DebugPackage#getLaunchType()
 * @model
 * @generated
 */
public interface LaunchType extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' attribute.
	 * @see #setImage(byte[])
	 * @see org.eclipse.rcptt.debug.DebugPackage#getLaunchType_Image()
	 * @model
	 * @generated
	 */
	byte[] getImage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.debug.LaunchType#getImage <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' attribute.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(byte[] value);

	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.debug.LaunchConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' containment reference list.
	 * @see org.eclipse.rcptt.debug.DebugPackage#getLaunchType_Configurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<LaunchConfiguration> getConfigurations();

} // LaunchType
