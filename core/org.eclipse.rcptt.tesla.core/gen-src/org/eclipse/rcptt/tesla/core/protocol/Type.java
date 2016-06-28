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
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.Type#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.Type#getCode <em>Code</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.Type#isFromDisplay <em>From Display</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.Type#getCharacter <em>Character</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.Type#getMeta <em>Meta</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.Type#isTraverse <em>Traverse</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.Type#getTimes <em>Times</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getType()
 * @model
 * @generated
 */
public interface Type extends ElementCommand {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see #setState(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getType_State()
	 * @model
	 * @generated
	 */
	Integer getState();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.Type#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see #getState()
	 * @generated
	 */
	void setState(Integer value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getType_Code()
	 * @model
	 * @generated
	 */
	Integer getCode();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.Type#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(Integer value);

	/**
	 * Returns the value of the '<em><b>From Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Display</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Display</em>' attribute.
	 * @see #setFromDisplay(boolean)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getType_FromDisplay()
	 * @model
	 * @generated
	 */
	boolean isFromDisplay();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.Type#isFromDisplay <em>From Display</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Display</em>' attribute.
	 * @see #isFromDisplay()
	 * @generated
	 */
	void setFromDisplay(boolean value);

	/**
	 * Returns the value of the '<em><b>Character</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Character</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Character</em>' attribute.
	 * @see #setCharacter(char)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getType_Character()
	 * @model
	 * @generated
	 */
	char getCharacter();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.Type#getCharacter <em>Character</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Character</em>' attribute.
	 * @see #getCharacter()
	 * @generated
	 */
	void setCharacter(char value);

	/**
	 * Returns the value of the '<em><b>Meta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta</em>' attribute.
	 * @see #setMeta(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getType_Meta()
	 * @model
	 * @generated
	 */
	Integer getMeta();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.Type#getMeta <em>Meta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta</em>' attribute.
	 * @see #getMeta()
	 * @generated
	 */
	void setMeta(Integer value);

	/**
	 * Returns the value of the '<em><b>Traverse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traverse</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traverse</em>' attribute.
	 * @see #setTraverse(boolean)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getType_Traverse()
	 * @model
	 * @generated
	 */
	boolean isTraverse();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.Type#isTraverse <em>Traverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Traverse</em>' attribute.
	 * @see #isTraverse()
	 * @generated
	 */
	void setTraverse(boolean value);

	/**
	 * Returns the value of the '<em><b>Times</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Times</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Times</em>' attribute.
	 * @see #setTimes(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getType_Times()
	 * @model default="1"
	 * @generated
	 */
	Integer getTimes();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.Type#getTimes <em>Times</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Times</em>' attribute.
	 * @see #getTimes()
	 * @generated
	 */
	void setTimes(Integer value);

} // Type
