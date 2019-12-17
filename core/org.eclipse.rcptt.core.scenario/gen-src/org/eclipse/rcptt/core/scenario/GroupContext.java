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
package org.eclipse.rcptt.core.scenario;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.GroupContext#getContextReferences <em>Context References</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.GroupContext#getContexts <em>Contexts</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getGroupContext()
 * @model
 * @generated
 */
public interface GroupContext extends Context {
	/**
	 * Returns the value of the '<em><b>Context References</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context References</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context References</em>' attribute list.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getGroupContext_ContextReferences()
	 * @model
	 * @generated
	 */
	EList<String> getContextReferences();

	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.core.scenario.Context}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contexts</em>' containment reference list.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getGroupContext_Contexts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Context> getContexts();

} // GroupContext
