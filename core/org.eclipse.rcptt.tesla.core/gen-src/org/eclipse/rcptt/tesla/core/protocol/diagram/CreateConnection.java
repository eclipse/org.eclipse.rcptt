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
package org.eclipse.rcptt.tesla.core.protocol.diagram;

import org.eclipse.rcptt.tesla.core.protocol.ElementCommand;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnection#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnection#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnection#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getCreateConnection()
 * @model
 * @generated
 */
public interface CreateConnection extends ElementCommand {
	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getCreateConnection_Pattern()
	 * @model
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnection#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(Element)
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getCreateConnection_From()
	 * @model
	 * @generated
	 */
	Element getFrom();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnection#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(Element value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(Element)
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getCreateConnection_To()
	 * @model
	 * @generated
	 */
	Element getTo();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnection#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(Element value);

} // CreateConnection
