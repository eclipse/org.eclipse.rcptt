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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hover At Text Offset</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset#getControl <em>Control</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset#getLine <em>Line</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getHoverAtTextOffset()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Perform mouse hover at specific text position.' returns='value of <code>control</code> parameter'"
 * @generated
 */
public interface HoverAtTextOffset extends Command {
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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getHoverAtTextOffset_Control()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Text control: editbox, editor or combo.'"
	 * @generated
	 */
	ControlHandler getControl();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset#getControl <em>Control</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control</em>' reference.
	 * @see #getControl()
	 * @generated
	 */
	void setControl(ControlHandler value);

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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getHoverAtTextOffset_Offset()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Value of offset to be set. Must not be less than 0 and greater than the number of characters in the text control. '"
	 * @generated
	 */
	Integer getOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(Integer value);

	/**
	 * Returns the value of the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line</em>' attribute.
	 * @see #setLine(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getHoverAtTextOffset_Line()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Value of offset to be set. Must not be less than 0 and greater than the number of characters in the text control. '"
	 * @generated
	 */
	Integer getLine();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset#getLine <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' attribute.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(Integer value);

} // HoverAtTextOffset
