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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verify Tree Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#isAllowExtraColumns <em>Allow Extra Columns</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#isAllowMissingColumns <em>Allow Missing Columns</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#getVerifyStyle <em>Verify Style</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#isVerifyIcons <em>Verify Icons</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#isAllowUncapturedChildren <em>Allow Uncaptured Children</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#isEnableVerifyStyle <em>Enable Verify Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getVerifyTreeData()
 * @model
 * @generated
 */
public interface VerifyTreeData extends CommonTreeVerificationData {
	/**
	 * Returns the value of the '<em><b>Allow Extra Columns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Extra Columns</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Extra Columns</em>' attribute.
	 * @see #setAllowExtraColumns(boolean)
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getVerifyTreeData_AllowExtraColumns()
	 * @model required="true"
	 * @generated
	 */
	boolean isAllowExtraColumns();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#isAllowExtraColumns <em>Allow Extra Columns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Extra Columns</em>' attribute.
	 * @see #isAllowExtraColumns()
	 * @generated
	 */
	void setAllowExtraColumns(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Missing Columns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Missing Columns</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Missing Columns</em>' attribute.
	 * @see #setAllowMissingColumns(boolean)
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getVerifyTreeData_AllowMissingColumns()
	 * @model
	 * @generated
	 */
	boolean isAllowMissingColumns();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#isAllowMissingColumns <em>Allow Missing Columns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Missing Columns</em>' attribute.
	 * @see #isAllowMissingColumns()
	 * @generated
	 */
	void setAllowMissingColumns(boolean value);

	/**
	 * Returns the value of the '<em><b>Verify Style</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.verifications.tree.VerifyStyleType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verify Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verify Style</em>' attribute.
	 * @see org.eclipse.rcptt.verifications.tree.VerifyStyleType
	 * @see #setVerifyStyle(VerifyStyleType)
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getVerifyTreeData_VerifyStyle()
	 * @model
	 * @generated
	 */
	VerifyStyleType getVerifyStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#getVerifyStyle <em>Verify Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verify Style</em>' attribute.
	 * @see org.eclipse.rcptt.verifications.tree.VerifyStyleType
	 * @see #getVerifyStyle()
	 * @generated
	 */
	void setVerifyStyle(VerifyStyleType value);

	/**
	 * Returns the value of the '<em><b>Verify Icons</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verify Icons</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verify Icons</em>' attribute.
	 * @see #setVerifyIcons(boolean)
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getVerifyTreeData_VerifyIcons()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isVerifyIcons();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#isVerifyIcons <em>Verify Icons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verify Icons</em>' attribute.
	 * @see #isVerifyIcons()
	 * @generated
	 */
	void setVerifyIcons(boolean value);

	/**
	 * Returns the value of the '<em><b>Allow Uncaptured Children</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Uncaptured Children</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Uncaptured Children</em>' attribute.
	 * @see #setAllowUncapturedChildren(boolean)
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getVerifyTreeData_AllowUncapturedChildren()
	 * @model default="true"
	 * @generated
	 */
	boolean isAllowUncapturedChildren();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#isAllowUncapturedChildren <em>Allow Uncaptured Children</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Uncaptured Children</em>' attribute.
	 * @see #isAllowUncapturedChildren()
	 * @generated
	 */
	void setAllowUncapturedChildren(boolean value);

	/**
	 * Returns the value of the '<em><b>Enable Verify Style</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable Verify Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable Verify Style</em>' attribute.
	 * @see #setEnableVerifyStyle(boolean)
	 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getVerifyTreeData_EnableVerifyStyle()
	 * @model default="true"
	 * @generated
	 */
	boolean isEnableVerifyStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.tree.VerifyTreeData#isEnableVerifyStyle <em>Enable Verify Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Verify Style</em>' attribute.
	 * @see #isEnableVerifyStyle()
	 * @generated
	 */
	void setEnableVerifyStyle(boolean value);

} // VerifyTreeData
