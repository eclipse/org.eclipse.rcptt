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
package org.eclipse.rcptt.tesla.core.ui;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.DiagramConnection#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.DiagramConnection#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramConnection()
 * @model
 * @generated
 */
public interface DiagramConnection extends DiagramItem {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(DiagramItem)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramConnection_Source()
	 * @model containment="true"
	 * @generated
	 */
	DiagramItem getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.DiagramConnection#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(DiagramItem value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(DiagramItem)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramConnection_Target()
	 * @model containment="true"
	 * @generated
	 */
	DiagramItem getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.DiagramConnection#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(DiagramItem value);

} // DiagramConnection
