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
 * A representation of the model object '<em><b>Get Attributes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.GetAttrs#getObject <em>Object</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getGetAttrs()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Gets attributes from the object' returns='Map with object attributes' example='tree-node \"Device\" [map [entry \"id\" \"1\"] [entry \"name\" \"first\"]]\n\t| get-attrs | get \"name\" | log'"
 * @generated
 */
public interface GetAttrs extends Command {
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
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getGetAttrs_Object()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Object to get attributes from'"
	 * @generated
	 */
	EObject getObject();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.GetAttrs#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EObject value);

} // GetAttributes
