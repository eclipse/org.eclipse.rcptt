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
/**
 */
package org.eclipse.rcptt.testing.commands;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Site Injection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.testing.commands.SiteInjection#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testing.commands.SiteInjection#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getSiteInjection()
 * @model
 * @generated
 */
public interface SiteInjection extends Command {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getSiteInjection_Uri()
	 * @model required="true"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testing.commands.SiteInjection#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute list.
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getSiteInjection_Unit()
	 * @model
	 * @generated
	 */
	EList<String> getUnit();

} // SiteInjection
