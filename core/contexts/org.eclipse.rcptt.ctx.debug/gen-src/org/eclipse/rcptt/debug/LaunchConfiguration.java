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
 * A representation of the model object '<em><b>Launch Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.debug.LaunchConfiguration#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.LaunchConfiguration#getTypeId <em>Type Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.debug.DebugPackage#getLaunchConfiguration()
 * @model
 * @generated
 */
public interface LaunchConfiguration extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.core.scenario.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.eclipse.rcptt.debug.DebugPackage#getLaunchConfiguration_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<NamedElement> getAttributes();

	/**
	 * Returns the value of the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Id</em>' attribute.
	 * @see #setTypeId(String)
	 * @see org.eclipse.rcptt.debug.DebugPackage#getLaunchConfiguration_TypeId()
	 * @model
	 * @generated
	 */
	String getTypeId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.debug.LaunchConfiguration#getTypeId <em>Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Id</em>' attribute.
	 * @see #getTypeId()
	 * @generated
	 */
	void setTypeId(String value);

} // LaunchConfiguration
