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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Write Lines</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.WriteLines#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.WriteLines#isAppend <em>Append</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.WriteLines#getEncode <em>Encode</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getWriteLines()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Reads objects from input pipe and writes them into file line-by-line as strings' example='//writes a list of launch configuration into a file line-by-line\nlist-launch-configurations | write-lines -uri \"workspace:/Project/Folder/file.txt\"\n// appends \"New line\" into a file. \nstr \"New line\" | write-lines -uri \"workspace:/Project/Folder/file.txt\" -append\n'"
 * @generated
 */
public interface WriteLines extends Command {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * The default value is <code>"UTF-8"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getWriteLines_Uri()
	 * @model default="UTF-8"
	 *        annotation="http://www.eclipse.org/ecl/docs description='URI to write lines to. Currently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system'"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.WriteLines#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Append</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Append</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Append</em>' attribute.
	 * @see #setAppend(boolean)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getWriteLines_Append()
	 * @model default="false"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Whether to append given lines into file. Default value is false'"
	 * @generated
	 */
	boolean isAppend();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.WriteLines#isAppend <em>Append</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Append</em>' attribute.
	 * @see #isAppend()
	 * @generated
	 */
	void setAppend(boolean value);

	/**
	 * Returns the value of the '<em><b>Encode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encode</em>' attribute.
	 * @see #setEncode(String)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getWriteLines_Encode()
	 * @model
	 * @generated
	 */
	String getEncode();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.WriteLines#getEncode <em>Encode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encode</em>' attribute.
	 * @see #getEncode()
	 * @generated
	 */
	void setEncode(String value);

} // WriteLines
