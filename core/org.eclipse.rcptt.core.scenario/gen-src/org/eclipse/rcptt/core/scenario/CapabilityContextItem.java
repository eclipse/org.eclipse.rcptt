/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
/**
 */
package org.eclipse.rcptt.core.scenario;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Capability Context Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.CapabilityContextItem#getCapability <em>Capability</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.CapabilityContextItem#getContextReferences <em>Context References</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getCapabilityContextItem()
 * @model
 * @generated
 */
public interface CapabilityContextItem extends EObject {
	/**
	 * Returns the value of the '<em><b>Capability</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability</em>' attribute list.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getCapabilityContextItem_Capability()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getCapability();

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
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getCapabilityContextItem_ContextReferences()
	 * @model
	 * @generated
	 */
	EList<String> getContextReferences();

} // CapabilityContextItem
