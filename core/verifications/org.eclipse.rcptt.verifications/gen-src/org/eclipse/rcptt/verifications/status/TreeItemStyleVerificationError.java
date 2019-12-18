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
package org.eclipse.rcptt.verifications.status;

import org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Tree Item Style Verification Error</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.status.TreeItemStyleVerificationError#getExpectedStyle <em>Expected Style</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.status.TreeItemStyleVerificationError#getActualStyle <em>Actual Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getTreeItemStyleVerificationError()
 * @model
 * @generated
 */
public interface TreeItemStyleVerificationError extends TreeItemVerificationError {
	/**
	 * Returns the value of the '<em><b>Expected Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expected Style</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expected Style</em>' containment reference.
	 * @see #setExpectedStyle(StyleRangeEntry)
	 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getTreeItemStyleVerificationError_ExpectedStyle()
	 * @model containment="true"
	 * @generated
	 */
	StyleRangeEntry getExpectedStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.status.TreeItemStyleVerificationError#getExpectedStyle <em>Expected Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expected Style</em>' containment reference.
	 * @see #getExpectedStyle()
	 * @generated
	 */
	void setExpectedStyle(StyleRangeEntry value);

	/**
	 * Returns the value of the '<em><b>Actual Style</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Style</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Actual Style</em>' reference.
	 * @see #setActualStyle(StyleRangeEntry)
	 * @see org.eclipse.rcptt.verifications.status.StatusPackage#getTreeItemStyleVerificationError_ActualStyle()
	 * @model
	 * @generated
	 */
	StyleRangeEntry getActualStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.status.TreeItemStyleVerificationError#getActualStyle <em>Actual Style</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Actual Style</em>' reference.
	 * @see #getActualStyle()
	 * @generated
	 */
	void setActualStyle(StyleRangeEntry value);

} // TreeItemStyleVerificationError
