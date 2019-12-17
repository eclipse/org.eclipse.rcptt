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
package org.eclipse.rcptt.core.tags;

import org.eclipse.rcptt.core.model.IQ7NamedElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.tags.Tag#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.tags.Tag#getRefs <em>Refs</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.tags.Tag#getTags <em>Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.core.tags.TagsPackage#getTag()
 * @model
 * @generated
 */
public interface Tag extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.rcptt.core.tags.TagsPackage#getTag_Value()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.tags.Tag#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Refs</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.rcptt.core.model.IQ7NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refs</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refs</em>' attribute list.
	 * @see org.eclipse.rcptt.core.tags.TagsPackage#getTag_Refs()
	 * @model dataType="org.eclipse.rcptt.core.tags.EQ7NamedElement" transient="true"
	 * @generated
	 */
	EList<IQ7NamedElement> getRefs();

	/**
	 * Returns the value of the '<em><b>Tags</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.core.tags.Tag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tags</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tags</em>' containment reference list.
	 * @see org.eclipse.rcptt.core.tags.TagsPackage#getTag_Tags()
	 * @model containment="true"
	 * @generated
	 */
	EList<Tag> getTags();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getPath();

} // Tag
