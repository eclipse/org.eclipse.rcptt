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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetRegion#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetRegion#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetRegion#getImageURI <em>Image URI</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetRegion#getRawImage <em>Raw Image</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetRegion()
 * @model
 * @generated
 */
public interface GetRegion extends Selector {
	/**
	 * Returns the value of the '<em><b>Raw Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Image</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Image</em>' attribute.
	 * @see #setRawImage(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetRegion_RawImage()
	 * @model
	 * @generated
	 */
	String getRawImage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegion#getRawImage <em>Raw Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Image</em>' attribute.
	 * @see #getRawImage()
	 * @generated
	 */
	void setRawImage(String value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetRegion_X()
	 * @model required="true"
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegion#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetRegion_Y()
	 * @model required="true"
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegion#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

	/**
	 * Returns the value of the '<em><b>Image URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image URI</em>' attribute.
	 * @see #setImageURI(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetRegion_ImageURI()
	 * @model required="true"
	 * @generated
	 */
	String getImageURI();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegion#getImageURI <em>Image URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image URI</em>' attribute.
	 * @see #getImageURI()
	 * @generated
	 */
	void setImageURI(String value);

} // GetRegion
