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
package org.eclipse.rcptt.tesla.core.protocol;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Text Selection2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getStartOffset <em>Start Offset</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getEndLine <em>End Line</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getEndOffset <em>End Offset</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#isBlockMode <em>Block Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetTextSelection2()
 * @model
 * @generated
 */
public interface SetTextSelection2 extends ElementCommand {
	/**
	 * Returns the value of the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Line</em>' attribute.
	 * @see #setStartLine(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetTextSelection2_StartLine()
	 * @model
	 * @generated
	 */
	int getStartLine();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getStartLine <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Line</em>' attribute.
	 * @see #getStartLine()
	 * @generated
	 */
	void setStartLine(int value);

	/**
	 * Returns the value of the '<em><b>Start Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Offset</em>' attribute.
	 * @see #setStartOffset(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetTextSelection2_StartOffset()
	 * @model
	 * @generated
	 */
	int getStartOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getStartOffset <em>Start Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Offset</em>' attribute.
	 * @see #getStartOffset()
	 * @generated
	 */
	void setStartOffset(int value);

	/**
	 * Returns the value of the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Line</em>' attribute.
	 * @see #setEndLine(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetTextSelection2_EndLine()
	 * @model
	 * @generated
	 */
	int getEndLine();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getEndLine <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Line</em>' attribute.
	 * @see #getEndLine()
	 * @generated
	 */
	void setEndLine(int value);

	/**
	 * Returns the value of the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Offset</em>' attribute.
	 * @see #setEndOffset(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetTextSelection2_EndOffset()
	 * @model
	 * @generated
	 */
	int getEndOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#getEndOffset <em>End Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Offset</em>' attribute.
	 * @see #getEndOffset()
	 * @generated
	 */
	void setEndOffset(int value);

	/**
	 * Returns the value of the '<em><b>Block Mode</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Mode</em>' attribute.
	 * @see #setBlockMode(boolean)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetTextSelection2_BlockMode()
	 * @model default="false"
	 * @generated
	 */
	boolean isBlockMode();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2#isBlockMode <em>Block Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block Mode</em>' attribute.
	 * @see #isBlockMode()
	 * @generated
	 */
	void setBlockMode(boolean value);

} // SetTextSelection2
