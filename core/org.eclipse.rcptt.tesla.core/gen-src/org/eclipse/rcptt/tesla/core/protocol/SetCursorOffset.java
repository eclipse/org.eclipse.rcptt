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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Cursor Offset</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetCursorOffset#getLine <em>Line</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetCursorOffset#getOffset <em>Offset</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetCursorOffset()
 * @model
 * @generated
 */
public interface SetCursorOffset extends ElementCommand {
	/**
	 * Returns the value of the '<em><b>Line</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line</em>' attribute.
	 * @see #setLine(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetCursorOffset_Line()
	 * @model default="-1"
	 * @generated
	 */
	int getLine();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetCursorOffset#getLine <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' attribute.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(int value);

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetCursorOffset_Offset()
	 * @model
	 * @generated
	 */
	int getOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetCursorOffset#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(int value);

} // SetCursorOffset
