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
package org.eclipse.rcptt.debug;

import org.eclipse.rcptt.core.scenario.NamedElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Breakpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.debug.Breakpoint#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.Breakpoint#isRegistered <em>Registered</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.Breakpoint#isPersisted <em>Persisted</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.Breakpoint#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.Breakpoint#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.Breakpoint#getWorkingSets <em>Working Sets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.debug.DebugPackage#getBreakpoint()
 * @model
 * @generated
 */
public interface Breakpoint extends EObject {
	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.eclipse.rcptt.debug.DebugPackage#getBreakpoint_Enabled()
	 * @model default="true"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.debug.Breakpoint#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Registered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registered</em>' attribute.
	 * @see #setRegistered(boolean)
	 * @see org.eclipse.rcptt.debug.DebugPackage#getBreakpoint_Registered()
	 * @model
	 * @generated
	 */
	boolean isRegistered();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.debug.Breakpoint#isRegistered <em>Registered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registered</em>' attribute.
	 * @see #isRegistered()
	 * @generated
	 */
	void setRegistered(boolean value);

	/**
	 * Returns the value of the '<em><b>Persisted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persisted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persisted</em>' attribute.
	 * @see #setPersisted(boolean)
	 * @see org.eclipse.rcptt.debug.DebugPackage#getBreakpoint_Persisted()
	 * @model
	 * @generated
	 */
	boolean isPersisted();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.debug.Breakpoint#isPersisted <em>Persisted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persisted</em>' attribute.
	 * @see #isPersisted()
	 * @generated
	 */
	void setPersisted(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.rcptt.debug.DebugPackage#getBreakpoint_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.debug.Breakpoint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.core.scenario.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.eclipse.rcptt.debug.DebugPackage#getBreakpoint_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<NamedElement> getAttributes();

	/**
	 * Returns the value of the '<em><b>Working Sets</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Working Sets</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Working Sets</em>' attribute list.
	 * @see org.eclipse.rcptt.debug.DebugPackage#getBreakpoint_WorkingSets()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getWorkingSets();

} // Breakpoint
