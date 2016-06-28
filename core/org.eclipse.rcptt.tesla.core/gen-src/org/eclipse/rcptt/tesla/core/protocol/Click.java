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
 * A representation of the model object '<em><b>Click</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.Click#isDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.Click#isWithWait <em>With Wait</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.Click#isArrow <em>Arrow</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getClick()
 * @model
 * @generated
 */
public interface Click extends ElementCommand {
	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(boolean)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getClick_Default()
	 * @model default="false"
	 * @generated
	 */
	boolean isDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.Click#isDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #isDefault()
	 * @generated
	 */
	void setDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>With Wait</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>With Wait</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>With Wait</em>' attribute.
	 * @see #setWithWait(boolean)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getClick_WithWait()
	 * @model default="true"
	 * @generated
	 */
	boolean isWithWait();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.Click#isWithWait <em>With Wait</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>With Wait</em>' attribute.
	 * @see #isWithWait()
	 * @generated
	 */
	void setWithWait(boolean value);

	/**
	 * Returns the value of the '<em><b>Arrow</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arrow</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrow</em>' attribute.
	 * @see #setArrow(boolean)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getClick_Arrow()
	 * @model default="false"
	 * @generated
	 */
	boolean isArrow();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.Click#isArrow <em>Arrow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arrow</em>' attribute.
	 * @see #isArrow()
	 * @generated
	 */
	void setArrow(boolean value);

} // Click
