/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.testing.commands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.launching.injection.Entry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invoke AUT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getVmargs <em>Vmargs</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getInject <em>Inject</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getInvokeAUT()
 * @model
 * @generated
 */
public interface InvokeAUT extends Command {
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
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getInvokeAUT_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Args</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Args</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Args</em>' attribute.
	 * @see #setArgs(String)
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getInvokeAUT_Args()
	 * @model required="true"
	 * @generated
	 */
	String getArgs();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getArgs <em>Args</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Args</em>' attribute.
	 * @see #getArgs()
	 * @generated
	 */
	void setArgs(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getInvokeAUT_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Vmargs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vmargs</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vmargs</em>' attribute.
	 * @see #setVmargs(String)
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getInvokeAUT_Vmargs()
	 * @model
	 * @generated
	 */
	String getVmargs();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testing.commands.InvokeAUT#getVmargs <em>Vmargs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vmargs</em>' attribute.
	 * @see #getVmargs()
	 * @generated
	 */
	void setVmargs(String value);

	/**
	 * Returns the value of the '<em><b>Inject</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.launching.injection.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inject</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inject</em>' containment reference list.
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getInvokeAUT_Inject()
	 * @model containment="true"
	 * @generated
	 */
	EList<Entry> getInject();

} // InvokeAUT
