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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.data.objects.Tree;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Nodes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.GetNodes#getObject <em>Object</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.GetNodes#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.GetNodes#getPos <em>Pos</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.GetNodes#getLen <em>Len</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getGetNodes()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Gets child nodes from the object and writes them into output pipe. Fails if <code>pos</code> of <code>len</code> parameter is out of range.' returns='Child nodes of the object' example='proc newDevice [val id] [val name] [val target] {\n\ttree-node \"Device\"\n\t\t[map [entry \"id\" $id]]\n\t\t[tree-node -name \"DeviceName\" -text $name]\n\t\t[tree-node -name \"DeviceTarget\" -text $target]\n}\n \nglobal [val supportedDevices [tree-node \"SupportedDevices\"\n\t[newDevice \"1\" \"device 1\" \"target 1\"]\n\t[newDevice \"2\" \"device 2\" \"target 2\"]\n\t[newDevice \"3\" \"device 3\" \"target 3\"]\n]]\n \n$supportedDevices | get-nodes \"Device\" -pos 1 -len 1\n\t| get-nodes \"DeviceName\" | get text\n\t| equals \"device 2\" | verify-true'"
 * @generated
 */
public interface GetNodes extends Command {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(EObject)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getGetNodes_Object()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Object to get child nodes from'"
	 * @generated
	 */
	EObject getObject();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.GetNodes#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getGetNodes_Name()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Name of the nodes'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.GetNodes#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Pos</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pos</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pos</em>' attribute.
	 * @see #setPos(int)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getGetNodes_Pos()
	 * @model default="0"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Start position. If <code>name</code> attribute is provided, <code>pos</code> is relative to the node list filtered by name.'"
	 * @generated
	 */
	int getPos();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.GetNodes#getPos <em>Pos</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pos</em>' attribute.
	 * @see #getPos()
	 * @generated
	 */
	void setPos(int value);

	/**
	 * Returns the value of the '<em><b>Len</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Len</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Len</em>' attribute.
	 * @see #setLen(int)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getGetNodes_Len()
	 * @model default="-1"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Count of nodes. Default value is <code>-1</code> and it means the end of the node list. If <code>name</code> attribute is provided, <code>len</code> is relative to the node list filtered by name.'"
	 * @generated
	 */
	int getLen();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.GetNodes#getLen <em>Len</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Len</em>' attribute.
	 * @see #getLen()
	 * @generated
	 */
	void setLen(int value);

} // GetNodes
