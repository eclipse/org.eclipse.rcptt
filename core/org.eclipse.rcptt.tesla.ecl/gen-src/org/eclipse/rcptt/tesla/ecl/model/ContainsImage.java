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
package org.eclipse.rcptt.tesla.ecl.model;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Contains Image</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ContainsImage#getControl <em>Control</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ContainsImage#getImageURI <em>Image URI</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ContainsImage#getRawImage <em>Raw Image</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getContainsImage()
 * @model
 * @generated
 */
public interface ContainsImage extends Command {
	/**
	 * Returns the value of the '<em><b>Image URI</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image URI</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Image URI</em>' attribute.
	 * @see #setImageURI(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getContainsImage_ImageURI()
	 * @model required="true"
	 * @generated
	 */
	String getImageURI();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.ContainsImage#getImageURI
	 * <em>Image URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Image URI</em>' attribute.
	 * @see #getImageURI()
	 * @generated
	 */
	void setImageURI(String value);

	/**
	 * Returns the value of the '<em><b>Raw Image</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Image</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Raw Image</em>' attribute.
	 * @see #setRawImage(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getContainsImage_RawImage()
	 * @model
	 * @generated
	 */
	String getRawImage();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.ContainsImage#getRawImage
	 * <em>Raw Image</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Raw Image</em>' attribute.
	 * @see #getRawImage()
	 * @generated
	 */
	void setRawImage(String value);

	/**
	 * Returns the value of the '<em><b>Control</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Control</em>' reference.
	 * @see #setControl(ControlHandler)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getContainsImage_Control()
	 * @model required="true" annotation=
	 *        "http://www.eclipse.org/ecl/docs description='Any control is appropriate.'"
	 * @generated
	 */
	ControlHandler getControl();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.ContainsImage#getControl
	 * <em>Control</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Control</em>' reference.
	 * @see #getControl()
	 * @generated
	 */
	void setControl(ControlHandler value);

} // ContainsImage
