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
package org.eclipse.rcptt.ecl.operations;


import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concat</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Concat#getStrs <em>Strs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getConcat()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Concatenates strings passed as arguments' returns='Concatenated string value' example='concat \"Mess\" \"age\" | equals \"Message\" | assert-true'"
 * @generated
 */
public interface Concat extends Command {
	/**
	 * Returns the value of the '<em><b>Strs</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strs</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strs</em>' attribute list.
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getConcat_Strs()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getStrs();

} // Concat
