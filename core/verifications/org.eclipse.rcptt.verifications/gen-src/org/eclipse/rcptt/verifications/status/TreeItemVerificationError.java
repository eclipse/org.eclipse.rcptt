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
package org.eclipse.rcptt.verifications.status;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree Item Verification Error</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.status.TreeItemVerificationError#getItemIndexPath <em>Item Index Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.status.TreeItemVerificationError#getItemPath <em>Item Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.status.TreeItemVerificationError#getColumn <em>Column</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getTreeItemVerificationError()
 * @model
 * @generated
 */
public interface TreeItemVerificationError extends VerificationStatusData {
	/**
	 * Returns the value of the '<em><b>Item Index Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item Index Path</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item Index Path</em>' attribute list.
	 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getTreeItemVerificationError_ItemIndexPath()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getItemIndexPath();

	/**
	 * Returns the value of the '<em><b>Item Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item Path</em>' attribute.
	 * @see #setItemPath(String)
	 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getTreeItemVerificationError_ItemPath()
	 * @model required="true"
	 * @generated
	 */
	String getItemPath();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.status.TreeItemVerificationError#getItemPath <em>Item Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item Path</em>' attribute.
	 * @see #getItemPath()
	 * @generated
	 */
	void setItemPath(String value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' attribute.
	 * @see #setColumn(String)
	 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getTreeItemVerificationError_Column()
	 * @model
	 * @generated
	 */
	String getColumn();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.status.TreeItemVerificationError#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(String value);

} // TreeItemVerificationError
