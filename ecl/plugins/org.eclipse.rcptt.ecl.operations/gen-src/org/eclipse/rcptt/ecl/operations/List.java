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
package org.eclipse.rcptt.ecl.operations;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.List#getItems <em>Items</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getList()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Creates a new list. Also see &lt;a href=\"#get\"&gt;get&lt;/a&gt; command to find an element by index.' example='list January Febuary March | get 1 | equals \"Febuary\" | verify-true'"
 * @generated
 */
public interface List extends Command {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getList_Items()
	 * @model containment="true"
	 * @generated
	 */
	EList<EObject> getItems();

} // List
