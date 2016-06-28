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
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Select Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getAfter <em>After</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getClassPattern <em>Class Pattern</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getIndexes <em>Indexes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSelectData()
 * @model
 * @generated
 */
public interface SelectData extends EObject {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSelectData_Kind()
	 * @model
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSelectData_Pattern()
	 * @model
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSelectData_Path()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getPath();

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSelectData_Index()
	 * @model
	 * @generated
	 */
	Integer getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(Integer value);

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' attribute.
	 * @see #setMultiplicity(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSelectData_Multiplicity()
	 * @model
	 * @generated
	 */
	int getMultiplicity();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getMultiplicity <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' attribute.
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(int value);

	/**
	 * Returns the value of the '<em><b>After</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>After</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>After</em>' containment reference.
	 * @see #setAfter(Element)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSelectData_After()
	 * @model containment="true"
	 * @generated
	 */
	Element getAfter();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getAfter <em>After</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>After</em>' containment reference.
	 * @see #getAfter()
	 * @generated
	 */
	void setAfter(Element value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' containment reference.
	 * @see #setParent(Element)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSelectData_Parent()
	 * @model containment="true"
	 * @generated
	 */
	Element getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getParent <em>Parent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' containment reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Element value);

	/**
	 * Returns the value of the '<em><b>Class Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Pattern</em>' attribute.
	 * @see #setClassPattern(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSelectData_ClassPattern()
	 * @model
	 * @generated
	 */
	String getClassPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData#getClassPattern <em>Class Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Pattern</em>' attribute.
	 * @see #getClassPattern()
	 * @generated
	 */
	void setClassPattern(String value);

	/**
	 * Returns the value of the '<em><b>Indexes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indexes</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indexes</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSelectData_Indexes()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getIndexes();

} // SelectData
