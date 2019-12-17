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
package org.eclipse.rcptt.tesla.core.protocol.raw;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tesla Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getCommands <em>Commands</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getElementMapping <em>Element Mapping</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getRequiredContexts <em>Required Contexts</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getRawMapping <em>Raw Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getTeslaScenario()
 * @model
 * @generated
 */
public interface TeslaScenario extends EObject {
	/**
	 * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.protocol.raw.Command}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Commands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commands</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getTeslaScenario_Commands()
	 * @model containment="true"
	 * @generated
	 */
	EList<Command> getCommands();

	/**
	 * Returns the value of the '<em><b>Element Mapping</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Mapping</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Mapping</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getTeslaScenario_ElementMapping()
	 * @model containment="true"
	 * @generated
	 */
	EList<CommandToElementEntry> getElementMapping();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getTeslaScenario_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Required Contexts</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Contexts</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Contexts</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getTeslaScenario_RequiredContexts()
	 * @model
	 * @generated
	 */
	EList<String> getRequiredContexts();

	/**
	 * Returns the value of the '<em><b>Raw Mapping</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Mapping</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Mapping</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getTeslaScenario_RawMapping()
	 * @model containment="true"
	 * @generated
	 */
	EList<CommandToRawEntry> getRawMapping();

} // TeslaScenario
