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
package org.eclipse.rcptt.tesla.core.protocol.raw;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assertion Focus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus#isPointFixed <em>Point Fixed</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus#getImageCapture <em>Image Capture</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getAssertionFocus()
 * @model
 * @generated
 */
public interface AssertionFocus extends Command {
	/**
	 * Returns the value of the '<em><b>Point Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point Fixed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point Fixed</em>' attribute.
	 * @see #setPointFixed(boolean)
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getAssertionFocus_PointFixed()
	 * @model
	 * @generated
	 */
	boolean isPointFixed();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus#isPointFixed <em>Point Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point Fixed</em>' attribute.
	 * @see #isPointFixed()
	 * @generated
	 */
	void setPointFixed(boolean value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference.
	 * @see #setElement(Element)
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getAssertionFocus_Element()
	 * @model containment="true"
	 * @generated
	 */
	Element getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus#getElement <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' containment reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(Element value);

	/**
	 * Returns the value of the '<em><b>Image Capture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Capture</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Capture</em>' attribute.
	 * @see #setImageCapture(byte[])
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getAssertionFocus_ImageCapture()
	 * @model
	 * @generated
	 */
	byte[] getImageCapture();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus#getImageCapture <em>Image Capture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Capture</em>' attribute.
	 * @see #getImageCapture()
	 * @generated
	 */
	void setImageCapture(byte[] value);

} // AssertionFocus
