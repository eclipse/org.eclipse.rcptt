/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.data.commands;

import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.objects.Tree;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Write Xml File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.WriteXmlFile#getTree <em>Tree</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.WriteXmlFile#getUri <em>Uri</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getWriteXmlFile()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Writes tree from input pipe to into xml file' returns='The value of <code>tree</code> argument' example='proc newDevice [val id] [val name] [val target] {\n\ttree-node \"Device\"\n\t\t[map [entry \"id\" $id]]\n\t\t[tree-node -name \"DeviceName\" -text $name]\n\t\t[tree-node -name \"DeviceTarget\" -text $target]\n}\n \n \nglobal [val supportedDevices [tree-node \"SupportedDevices\"\n\t[newDevice \"1\" \"device 1\" \"target 1\"]\n\t[newDevice \"2\" \"device 2\" \"target 2\"]\n\t[newDevice \"3\" \"device 3\" \"target 3\"]\n]]\n \nglobal [val allDevices [tree-node \"AllDevices\"\n\t[newDevice \"1\" \"device 1\" \"target 1\"]\n\t[newDevice \"2\" \"device 2\" \"target 2\"]\n\t[newDevice \"3\" \"device 3\" \"target 3\"]\n\t[newDevice \"4\" \"device 4\" \"target 4\"]\n\t[newDevice \"5\" \"device 5\" \"target 5\"]\n]]\n \nglobal [val tree [\n\ttree-node \"DevicesInfo\" $supportedDevices $allDevices\n]]\n \n$tree | write-xml-file \"workspace:/xml/devices.xml\"'"
 * @generated
 */
public interface WriteXmlFile extends Command {
	/**
	 * Returns the value of the '<em><b>Tree</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tree</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tree</em>' reference.
	 * @see #setTree(Tree)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getWriteXmlFile_Tree()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Tree to write'"
	 * @generated
	 */
	Tree getTree();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.WriteXmlFile#getTree <em>Tree</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tree</em>' reference.
	 * @see #getTree()
	 * @generated
	 */
	void setTree(Tree value);

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
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getWriteXmlFile_Uri()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='URI to write xml data to. Currently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system'"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.WriteXmlFile#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

} // WriteXmlFile
