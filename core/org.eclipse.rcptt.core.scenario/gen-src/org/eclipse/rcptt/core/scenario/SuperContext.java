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
 * A representation of the model object '<em><b>Super Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.SuperContext#getContextReferences <em>Context References</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.SuperContext#getChildType <em>Child Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getSuperContext()
 * @model
 * @generated
 */
public interface SuperContext extends Context {
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
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getSuperContext_ContextReferences()
	 * @model
	 * @generated
	 */
	EList<String> getContextReferences();

	/**
	 * Returns the value of the '<em><b>Child Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Type</em>' attribute.
	 * @see #setChildType(String)
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getSuperContext_ChildType()
	 * @model
	 * @generated
	 */
	String getChildType();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.SuperContext#getChildType <em>Child Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child Type</em>' attribute.
	 * @see #getChildType()
	 * @generated
	 */
	void setChildType(String value);

} // SuperContext
