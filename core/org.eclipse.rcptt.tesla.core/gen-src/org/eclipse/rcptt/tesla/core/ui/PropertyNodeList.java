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
package org.eclipse.rcptt.tesla.core.ui;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Node List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.PropertyNodeList#getPropertyNodes <em>Property Nodes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getPropertyNodeList()
 * @model
 * @generated
 */
public interface PropertyNodeList extends EObject {
	/**
	 * Returns the value of the '<em><b>Property Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.ui.PropertyNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Nodes</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getPropertyNodeList_PropertyNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropertyNode> getPropertyNodes();

} // PropertyNodeList
