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


import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Eq</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Eq#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Eq#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getEq()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Compares arguments on equality' returns='<code>true</code> when args are equal, <code>false</code> otherwise.'"
 * @generated
 */
public interface Eq extends Command {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' reference.
	 * @see #setLeft(EObject)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getEq_Left()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Left argument'"
	 * @generated
	 */
	EObject getLeft();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Eq#getLeft <em>Left</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(EObject value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' reference.
	 * @see #setRight(EObject)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getEq_Right()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Right argument'"
	 * @generated
	 */
	EObject getRight();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Eq#getRight <em>Right</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(EObject value);

} // Eq
