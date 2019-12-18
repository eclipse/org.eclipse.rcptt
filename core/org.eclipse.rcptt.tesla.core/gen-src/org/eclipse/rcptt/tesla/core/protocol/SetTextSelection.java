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
 * A representation of the model object '<em><b>Set Text Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getLength <em>Length</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getEndline <em>Endline</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getEndoffset <em>Endoffset</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetTextSelection()
 * @model
 * @generated
 */
public interface SetTextSelection extends ElementCommand {
	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetTextSelection_Offset()
	 * @model
	 * @generated
	 */
	Integer getOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(Integer value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetTextSelection_Length()
	 * @model
	 * @generated
	 */
	Integer getLength();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(Integer value);

	/**
	 * Returns the value of the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Line</em>' attribute.
	 * @see #setStartLine(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetTextSelection_StartLine()
	 * @model
	 * @generated
	 */
	Integer getStartLine();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getStartLine <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Line</em>' attribute.
	 * @see #getStartLine()
	 * @generated
	 */
	void setStartLine(Integer value);

	/**
	 * Returns the value of the '<em><b>Endline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endline</em>' attribute.
	 * @see #setEndline(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetTextSelection_Endline()
	 * @model
	 * @generated
	 */
	Integer getEndline();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getEndline <em>Endline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endline</em>' attribute.
	 * @see #getEndline()
	 * @generated
	 */
	void setEndline(Integer value);

	/**
	 * Returns the value of the '<em><b>Endoffset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endoffset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endoffset</em>' attribute.
	 * @see #setEndoffset(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSetTextSelection_Endoffset()
	 * @model
	 * @generated
	 */
	Integer getEndoffset();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection#getEndoffset <em>Endoffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endoffset</em>' attribute.
	 * @see #getEndoffset()
	 * @generated
	 */
	void setEndoffset(Integer value);

} // SetTextSelection
