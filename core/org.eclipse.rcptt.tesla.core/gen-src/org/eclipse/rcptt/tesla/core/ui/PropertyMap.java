/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core.ui;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.PropertyMap#get__properties <em>properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getPropertyMap()
 * @model
 * @generated
 */
public interface PropertyMap extends EObject {
	/**
	 * Returns the value of the '<em><b>properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.ui.PropertyEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>properties</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getPropertyMap___properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropertyEntry> get__properties();

} // PropertyMap
