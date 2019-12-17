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
 * A representation of the model object '<em><b>Remove</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.Remove#getObject <em>Object</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.Remove#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getRemove()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Removes child node from the object by index. Fails if <code>index</code> parameter is out of range.' returns='The value of <code>object</code> argument' example='tree-node \"Device\"\n\t[tree-node -name \"DeviceName\" -text \"device\"]\n\t[tree-node -name \"DeviceTarget\" -text \"target\"]\n\t\t| remove -index 1'"
 * @generated
 */
public interface Remove extends Command {
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
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getRemove_Object()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Object to remove child node from'"
	 * @generated
	 */
	EObject getObject();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.Remove#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getRemove_Index()
	 * @model default="-1" required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Index of the child node. Min value is <code>0</code> and max value is the last index in the node list. Default value is <code>-1</code> and the last index in the node list.'"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.Remove#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

} // Remove
