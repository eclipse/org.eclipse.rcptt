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
package org.eclipse.rcptt.debug;

import org.eclipse.rcptt.core.scenario.NamedElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Launch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.debug.Launch#getConfigurationDelta <em>Configuration Delta</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.Launch#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.Launch#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.Launch#getConfigurationName <em>Configuration Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.debug.DebugPackage#getLaunch()
 * @model
 * @generated
 */
public interface Launch extends EObject {
	/**
	 * Returns the value of the '<em><b>Configuration Delta</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.core.scenario.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Delta</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Delta</em>' containment reference list.
	 * @see org.eclipse.rcptt.debug.DebugPackage#getLaunch_ConfigurationDelta()
	 * @model containment="true"
	 * @generated
	 */
	EList<NamedElement> getConfigurationDelta();

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see #setMode(String)
	 * @see org.eclipse.rcptt.debug.DebugPackage#getLaunch_Mode()
	 * @model
	 * @generated
	 */
	String getMode();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.debug.Launch#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' reference.
	 * @see #setConfiguration(LaunchConfiguration)
	 * @see org.eclipse.rcptt.debug.DebugPackage#getLaunch_Configuration()
	 * @model resolveProxies="false"
	 * @generated
	 */
	LaunchConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.debug.Launch#getConfiguration <em>Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(LaunchConfiguration value);

	/**
	 * Returns the value of the '<em><b>Configuration Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Name</em>' attribute.
	 * @see #setConfigurationName(String)
	 * @see org.eclipse.rcptt.debug.DebugPackage#getLaunch_ConfigurationName()
	 * @model
	 * @generated
	 */
	String getConfigurationName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.debug.Launch#getConfigurationName <em>Configuration Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration Name</em>' attribute.
	 * @see #getConfigurationName()
	 * @generated
	 */
	void setConfigurationName(String value);

} // Launch
