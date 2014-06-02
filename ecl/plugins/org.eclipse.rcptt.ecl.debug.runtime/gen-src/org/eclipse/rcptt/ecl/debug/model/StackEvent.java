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
package org.eclipse.rcptt.ecl.debug.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stack Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.StackEvent#getLine <em>Line</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.StackEvent#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.StackEvent#getStackFrame <em>Stack Frame</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getStackEvent()
 * @model
 * @generated
 */
public interface StackEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line</em>' attribute.
	 * @see #setLine(String)
	 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getStackEvent_Line()
	 * @model
	 * @generated
	 */
	String getLine();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.debug.model.StackEvent#getLine <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' attribute.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getStackEvent_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.debug.model.StackEvent#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Stack Frame</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.ecl.debug.model.StackFrame}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stack Frame</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stack Frame</em>' reference list.
	 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getStackEvent_StackFrame()
	 * @model
	 * @generated
	 */
	EList<StackFrame> getStackFrame();

} // StackEvent
