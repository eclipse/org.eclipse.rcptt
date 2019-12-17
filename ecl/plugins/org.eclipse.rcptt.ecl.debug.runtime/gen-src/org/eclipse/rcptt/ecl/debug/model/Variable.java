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
package org.eclipse.rcptt.ecl.debug.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.Variable#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.Variable#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.Variable#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.Variable#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.Variable#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.Variable#getObjectRef <em>Object Ref</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.Variable#isComplex <em>Complex</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.Variable#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends EObject {
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
	 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getVariable_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.debug.model.Variable#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getVariable_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.debug.model.Variable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(EObject)
	 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getVariable_Value()
	 * @model containment="true"
	 * @generated
	 */
	EObject getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.debug.model.Variable#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EObject value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.ecl.debug.model.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getVariable_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getChildren();

	/**
	 * Returns the value of the '<em><b>Object Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Ref</em>' attribute.
	 * @see #setObjectRef(Object)
	 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getVariable_ObjectRef()
	 * @model transient="true"
	 * @generated
	 */
	Object getObjectRef();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.debug.model.Variable#getObjectRef <em>Object Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Ref</em>' attribute.
	 * @see #getObjectRef()
	 * @generated
	 */
	void setObjectRef(Object value);

	/**
	 * Returns the value of the '<em><b>Complex</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complex</em>' attribute.
	 * @see #setComplex(boolean)
	 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getVariable_Complex()
	 * @model default="false"
	 * @generated
	 */
	boolean isComplex();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.debug.model.Variable#isComplex <em>Complex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Complex</em>' attribute.
	 * @see #isComplex()
	 * @generated
	 */
	void setComplex(boolean value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.ecl.debug.model.VariableKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.rcptt.ecl.debug.model.VariableKind
	 * @see #setKind(VariableKind)
	 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getVariable_Kind()
	 * @model
	 * @generated
	 */
	VariableKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.debug.model.Variable#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.rcptt.ecl.debug.model.VariableKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(VariableKind value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getVariable_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.debug.model.Variable#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // Variable
