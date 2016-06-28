/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.scenario;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project Metadata</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.ProjectMetadata#getContexts <em>Contexts</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.ProjectMetadata#getIgnores <em>Ignores</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.ProjectMetadata#getVerifications <em>Verifications</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getProjectMetadata()
 * @model
 * @generated
 */
public interface ProjectMetadata extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contexts</em>' attribute list.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getProjectMetadata_Contexts()
	 * @model
	 * @generated
	 */
	EList<String> getContexts();

	/**
	 * Returns the value of the '<em><b>Ignores</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ignores</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignores</em>' attribute list.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getProjectMetadata_Ignores()
	 * @model
	 * @generated
	 */
	EList<String> getIgnores();

	/**
	 * Returns the value of the '<em><b>Verifications</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verifications</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verifications</em>' attribute list.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getProjectMetadata_Verifications()
	 * @model
	 * @generated
	 */
	EList<String> getVerifications();

} // ProjectMetadata
