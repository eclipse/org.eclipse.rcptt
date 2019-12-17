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
 * A representation of the model object '<em><b>Read Xml File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.ReadXmlFile#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.ReadXmlFile#getXPath <em>XPath</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getReadXmlFile()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Parses given xml file into tree and write it to output pipe. Fails if file is not found or if it is invalid xml.' returns='<code>Tree</code> EMF Object' example='proc logDevice [val device] {\n\tif [$device | has-attr \"id\"] {\n\t\tlog [format \"Device ID: %s\" [$device | get-attr \"id\"]]\n\t}\n\tlog [format \"Device Name: %s\" [$device | get-nodes \"DeviceName\" | get text]]\n\tlog [format \"Device Target: %s\" [$device | get-nodes \"DeviceTarget\"  | get text]]\n}\n \n \nglobal [val supportedDevices [\n\tread-xml-file \"workspace:/xml/devices.xml\"\n\t\t| get-nodes \"SupportedDevices\" | get-nodes \"Device\" | to-list\n]]\n \n$supportedDevices | each [val device] {\n\tlogDevice $device\n}'"
 * @generated
 */
public interface ReadXmlFile extends Command {
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
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getReadXmlFile_Uri()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='URI to read xml data from. Currently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system'"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.ReadXmlFile#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>XPath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XPath</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XPath</em>' attribute.
	 * @see #setXPath(String)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getReadXmlFile_XPath()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='XPath expression to find xml nodes'"
	 * @generated
	 */
	String getXPath();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.ReadXmlFile#getXPath <em>XPath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XPath</em>' attribute.
	 * @see #getXPath()
	 * @generated
	 */
	void setXPath(String value);

} // ReadXmlFile
