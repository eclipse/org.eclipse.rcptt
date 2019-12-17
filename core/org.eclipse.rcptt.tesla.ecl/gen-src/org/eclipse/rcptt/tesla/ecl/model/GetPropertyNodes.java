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
package org.eclipse.rcptt.tesla.ecl.model;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Property Nodes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetPropertyNodes#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetPropertyNodes#getNodePath <em>Node Path</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetPropertyNodes()
 * @model annotation="http://www.eclipse.org/ecl/internal"
 * @generated
 */
public interface GetPropertyNodes extends Command {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(Element)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetPropertyNodes_Element()
	 * @model
	 * @generated
	 */
	Element getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetPropertyNodes#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(Element value);

	/**
	 * Returns the value of the '<em><b>Node Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Path</em>' attribute.
	 * @see #setNodePath(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetPropertyNodes_NodePath()
	 * @model
	 * @generated
	 */
	String getNodePath();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetPropertyNodes#getNodePath <em>Node Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Path</em>' attribute.
	 * @see #getNodePath()
	 * @generated
	 */
	void setNodePath(String value);

} // GetPropertyNodes
