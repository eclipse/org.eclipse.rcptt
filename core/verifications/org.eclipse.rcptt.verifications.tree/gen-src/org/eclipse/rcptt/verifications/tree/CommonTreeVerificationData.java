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
package org.eclipse.rcptt.verifications.tree;

import org.eclipse.rcptt.core.scenario.WidgetVerification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Common Tree Verification Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.CommonTreeVerificationData#getTree <em>Tree</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getCommonTreeVerificationData()
 * @model
 * @generated
 */
public interface CommonTreeVerificationData extends WidgetVerification {
	/**
	 * Returns the value of the '<em><b>Tree</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tree</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tree</em>' containment reference.
	 * @see #setTree(Tree)
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getCommonTreeVerificationData_Tree()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Tree getTree();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.CommonTreeVerificationData#getTree <em>Tree</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tree</em>' containment reference.
	 * @see #getTree()
	 * @generated
	 */
	void setTree(Tree value);

} // CommonTreeVerificationData
