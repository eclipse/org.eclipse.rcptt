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
package org.eclipse.rcptt.ecl.data.commands;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Read Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.ReadProperties#getUri <em>Uri</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getReadProperties()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Parses given .properties file. Fails if file is not found or format is invalid' returns='ECL map with values from properties file' example='...get-item \"General Registers/pc\" | get-property \"values[\\\'Value\\\']\"\n| matches [format \"%s.*\" [read-properties -uri \"file:/C:/Users/Administrator/Desktop/p.properties\" | get myKey]] | verify-true\n'"
 * @generated
 */
public interface ReadProperties extends Command {
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
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getReadProperties_Uri()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='URI to a file to read. Currently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system'"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.ReadProperties#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

} // ReadProperties
