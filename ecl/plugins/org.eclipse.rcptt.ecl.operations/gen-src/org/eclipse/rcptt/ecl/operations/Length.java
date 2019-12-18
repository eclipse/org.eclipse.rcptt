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
package org.eclipse.rcptt.ecl.operations;


import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Length</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Length#getInput <em>Input</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getLength()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Returns count of objects got from input pipe' returns='Object count' example='emit 1 2 3 | length | equals 3 | verify-true\n\n// verifies that Project item has 10 children\nget-view \"Q7 Explorer\" | get-tree | get-item Project | get-items | length | equals 10 | verify-true'"
 * @generated
 */
public interface Length extends Command {
	/**
	 * Returns the value of the '<em><b>Input</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' reference list.
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getLength_Input()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='List of objects to get the length for'"
	 * @generated
	 */
	EList<EObject> getInput();

} // Length
