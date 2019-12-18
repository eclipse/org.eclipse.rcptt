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
package org.eclipse.rcptt.tesla.core.protocol;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Apply Cell Editor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor#isDeactivate <em>Deactivate</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor#getColumn <em>Column</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getApplyCellEditor()
 * @model
 * @generated
 */
public interface ApplyCellEditor extends ElementCommand {

	/**
	 * Returns the value of the '<em><b>Deactivate</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deactivate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deactivate</em>' attribute.
	 * @see #setDeactivate(boolean)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getApplyCellEditor_Deactivate()
	 * @model default="false"
	 * @generated
	 */
	boolean isDeactivate();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor#isDeactivate <em>Deactivate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deactivate</em>' attribute.
	 * @see #isDeactivate()
	 * @generated
	 */
	void setDeactivate(boolean value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' attribute.
	 * @see #setColumn(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getApplyCellEditor_Column()
	 * @model
	 * @generated
	 */
	int getColumn();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(int value);

} // ApplyCellEditor
