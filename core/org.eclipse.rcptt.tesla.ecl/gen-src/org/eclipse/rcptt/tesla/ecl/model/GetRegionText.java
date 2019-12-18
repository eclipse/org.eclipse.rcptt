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
package org.eclipse.rcptt.tesla.ecl.model;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Region Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getControl <em>Control</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getSx <em>Sx</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getSy <em>Sy</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getHeight <em>Height</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetRegionText()
 * @model
 * @generated
 */
public interface GetRegionText extends Command {
	/**
	 * Returns the value of the '<em><b>Control</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Control</em>' reference.
	 * @see #setControl(ControlHandler)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetRegionText_Control()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/input"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Any control is appropriate.'"
	 * @generated
	 */
	ControlHandler getControl();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getControl <em>Control</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control</em>' reference.
	 * @see #getControl()
	 * @generated
	 */
	void setControl(ControlHandler value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetRegionText_X()
	 * @model default="0" required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='X coordinate relative to left top corner of the control.' default='0'"
	 * @generated
	 */
	Integer getX();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(Integer value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetRegionText_Y()
	 * @model default="0" required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Y coordinate relative to left top corner of the control.' default='0'"
	 * @generated
	 */
	Integer getY();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(Integer value);

	/**
	 * Returns the value of the '<em><b>Sx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sx</em>' attribute.
	 * @see #setSx(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetRegionText_Sx()
	 * @model required="true"
	 * @generated
	 */
	Integer getSx();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getSx <em>Sx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sx</em>' attribute.
	 * @see #getSx()
	 * @generated
	 */
	void setSx(Integer value);

	/**
	 * Returns the value of the '<em><b>Sy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sy</em>' attribute.
	 * @see #setSy(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetRegionText_Sy()
	 * @model required="true"
	 * @generated
	 */
	Integer getSy();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getSy <em>Sy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sy</em>' attribute.
	 * @see #getSy()
	 * @generated
	 */
	void setSy(Integer value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetRegionText_Width()
	 * @model required="true"
	 * @generated
	 */
	Integer getWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(Integer value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetRegionText_Height()
	 * @model required="true"
	 * @generated
	 */
	Integer getHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetRegionText#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(Integer value);

} // GetRegionText
