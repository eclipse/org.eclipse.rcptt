/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core.ui;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Image#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Image#getDecorations <em>Decorations</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getImage()
 * @model
 * @generated
 */
public interface Image extends EObject {
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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getImage_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Image#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Decorations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.ui.Image}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decorations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decorations</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getImage_Decorations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Image> getDecorations();

} // Image
