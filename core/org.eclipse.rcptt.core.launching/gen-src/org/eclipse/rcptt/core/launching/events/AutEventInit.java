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
package org.eclipse.rcptt.core.launching.events;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aut Event Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.launching.events.AutEventInit#getBundleState <em>Bundle State</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.core.launching.events.EventsPackage#getAutEventInit()
 * @model
 * @generated
 */
public interface AutEventInit extends AutEvent {
	/**
	 * Returns the value of the '<em><b>Bundle State</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.core.launching.events.AutBundleState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle State</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle State</em>' containment reference list.
	 * @see org.eclipse.rcptt.core.launching.events.EventsPackage#getAutEventInit_BundleState()
	 * @model containment="true"
	 * @generated
	 */
	EList<AutBundleState> getBundleState();

} // AutEventInit
