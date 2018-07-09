/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
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
 * A representation of the model object '<em><b>Set Text Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getControl <em>Control</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getLength <em>Length</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getEndLine <em>End Line</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getEndOffset <em>End Offset</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getSetTextSelection()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Sets the selection to the range specified by the given offset and length. If specified four parameters sets the selection by start line, offset in start line, end line and offset in end line.' returns='value of <code>control</code> parameter' example='get-editor Q7Project | get-section Script | get-editbox |  set-text-selection -offset 0 -startLine 1 -endLine 4 -endOffset 1'"
 * @generated
 */
public interface SetTextSelection extends Command {
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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getSetTextSelection_Control()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Text control: editbox, editor or combo.'"
	 * @generated
	 */
	ControlHandler getControl();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getControl <em>Control</em>}' reference.
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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getSetTextSelection_Offset()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='Zero-based selection starting position. Must be in <code>0..length-1</code> range'"
	 * @generated
	 */
	Integer getOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getOffset <em>Offset</em>}' attribute.
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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getSetTextSelection_Length()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Length of selection. Must not be less that zero.'"
	 * @generated
	 */
	Integer getLength();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getLength <em>Length</em>}' attribute.
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
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getSetTextSelection_StartLine()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='For multiline text boxes the starting line of a selection. If set, then the <code>offset</code> value will be relative to given line.'"
	 * @generated
	 */
	Integer getStartLine();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getStartLine <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Line</em>' attribute.
	 * @see #getStartLine()
	 * @generated
	 */
	void setStartLine(Integer value);

	/**
	 * Returns the value of the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Line</em>' attribute.
	 * @see #setEndLine(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getSetTextSelection_EndLine()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='For multiline textboxes the ending line of a selection.'"
	 * @generated
	 */
	Integer getEndLine();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getEndLine <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Line</em>' attribute.
	 * @see #getEndLine()
	 * @generated
	 */
	void setEndLine(Integer value);

	/**
	 * Returns the value of the '<em><b>End Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Offset</em>' attribute.
	 * @see #setEndOffset(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getSetTextSelection_EndOffset()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Selection end offset relative to <code>endLine</code>. Don\'t use this argument along with <code>length</code> argument.'"
	 * @generated
	 */
	Integer getEndOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.SetTextSelection#getEndOffset <em>End Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Offset</em>' attribute.
	 * @see #getEndOffset()
	 * @generated
	 */
	void setEndOffset(Integer value);

} // SetTextSelection
