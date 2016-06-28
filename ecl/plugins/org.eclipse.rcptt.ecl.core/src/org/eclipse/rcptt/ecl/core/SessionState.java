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
package org.eclipse.rcptt.ecl.core;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Session State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.SessionState#getProcs <em>Procs</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.SessionState#getDecls <em>Decls</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.core.CorePackage#getSessionState()
 * @model
 * @generated
 */
public interface SessionState extends EObject {
	/**
	 * Returns the value of the '<em><b>Procs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.ecl.core.Proc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procs</em>' containment reference list.
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getSessionState_Procs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Proc> getProcs();

	/**
	 * Returns the value of the '<em><b>Decls</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.ecl.core.Declaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decls</em>' containment reference list.
	 * @see org.eclipse.rcptt.ecl.core.CorePackage#getSessionState_Decls()
	 * @model containment="true"
	 * @generated
	 */
	EList<Declaration> getDecls();

} // SessionState
