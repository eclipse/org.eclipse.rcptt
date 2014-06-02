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
package org.eclipse.rcptt.ecl.platform.commands;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Log</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.commands.Log#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.commands.Log#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.commands.Log#getPlugin <em>Plugin</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.platform.commands.CommandsPackage#getLog()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Writes an entry into Eclipse log' returns='Nothing'"
 * @generated
 */
public interface Log extends Command {
	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.eclipse.rcptt.ecl.platform.commands.CommandsPackage#getLog_Message()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Writes an entry into Eclipse log'"
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.platform.commands.Log#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * The default value is <code>"info"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see #setSeverity(String)
	 * @see org.eclipse.rcptt.ecl.platform.commands.CommandsPackage#getLog_Severity()
	 * @model default="info"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Log entry severity. Can be <code>info</code>, <code>warning</code>, <code>error</code>, <code>ok</code>, <code>cancel</code> in any letter case. Default value is <code>info</code>.'"
	 * @generated
	 */
	String getSeverity();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.platform.commands.Log#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(String value);

	/**
	 * Returns the value of the '<em><b>Plugin</b></em>' attribute.
	 * The default value is <code>"org.eclipse.rcptt.ecl.platform"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin</em>' attribute.
	 * @see #setPlugin(String)
	 * @see org.eclipse.rcptt.ecl.platform.commands.CommandsPackage#getLog_Plugin()
	 * @model default="org.eclipse.rcptt.ecl.platform"
	 *        annotation="http://www.eclipse.org/ecl/docs description='ID of plugin adding log entry. Default value is <code>org.eclipse.rcptt.ecl.platform</code>'"
	 * @generated
	 */
	String getPlugin();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.platform.commands.Log#getPlugin <em>Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin</em>' attribute.
	 * @see #getPlugin()
	 * @generated
	 */
	void setPlugin(String value);

} // Log
