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
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activate Cell Editor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getColumn <em>Column</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getButton <em>Button</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getActivateCellEditor()
 * @model
 * @generated
 */
public interface ActivateCellEditor extends ElementCommand {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getActivateCellEditor_Path()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getPath();

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getActivateCellEditor_Pattern()
	 * @model
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getActivateCellEditor_Index()
	 * @model
	 * @generated
	 */
	Integer getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(Integer value);

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
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getActivateCellEditor_Column()
	 * @model
	 * @generated
	 */
	int getColumn();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(int value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.tesla.core.protocol.ActivationEventType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ActivationEventType
	 * @see #setType(ActivationEventType)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getActivateCellEditor_Type()
	 * @model
	 * @generated
	 */
	ActivationEventType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ActivationEventType
	 * @see #getType()
	 * @generated
	 */
	void setType(ActivationEventType value);

	/**
	 * Returns the value of the '<em><b>Button</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Button</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Button</em>' attribute.
	 * @see #setButton(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getActivateCellEditor_Button()
	 * @model default="1"
	 * @generated
	 */
	int getButton();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor#getButton <em>Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Button</em>' attribute.
	 * @see #getButton()
	 * @generated
	 */
	void setButton(int value);

} // ActivateCellEditor
