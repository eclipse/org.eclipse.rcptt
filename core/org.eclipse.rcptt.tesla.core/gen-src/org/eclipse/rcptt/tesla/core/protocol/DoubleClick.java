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
 * A representation of the model object '<em><b>Double Click</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.DoubleClick#isWithWait <em>With Wait</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getDoubleClick()
 * @model
 * @generated
 */
public interface DoubleClick extends ElementCommand {
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
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getDoubleClick_WithWait()
	 * @model default="true"
	 * @generated
	 */
	boolean isWithWait();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.DoubleClick#isWithWait <em>With Wait</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>With Wait</em>' attribute.
	 * @see #isWithWait()
	 * @generated
	 */
	void setWithWait(boolean value);

} // DoubleClick
