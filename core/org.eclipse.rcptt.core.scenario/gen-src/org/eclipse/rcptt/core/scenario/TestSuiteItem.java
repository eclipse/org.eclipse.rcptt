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
package org.eclipse.rcptt.core.scenario;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Suite Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.TestSuiteItem#getNamedElementId <em>Named Element Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.TestSuiteItem#getNamedElemetName <em>Named Elemet Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.TestSuiteItem#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.TestSuiteItem#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getTestSuiteItem()
 * @model
 * @generated
 */
public interface TestSuiteItem extends EObject {
	/**
	 * Returns the value of the '<em><b>Named Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Element Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Named Element Id</em>' attribute.
	 * @see #setNamedElementId(String)
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getTestSuiteItem_NamedElementId()
	 * @model
	 * @generated
	 */
	String getNamedElementId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.TestSuiteItem#getNamedElementId <em>Named Element Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Named Element Id</em>' attribute.
	 * @see #getNamedElementId()
	 * @generated
	 */
	void setNamedElementId(String value);

	/**
	 * Returns the value of the '<em><b>Named Elemet Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Elemet Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Named Elemet Name</em>' attribute.
	 * @see #setNamedElemetName(String)
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getTestSuiteItem_NamedElemetName()
	 * @model
	 * @generated
	 */
	String getNamedElemetName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.TestSuiteItem#getNamedElemetName <em>Named Elemet Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Named Elemet Name</em>' attribute.
	 * @see #getNamedElemetName()
	 * @generated
	 */
	void setNamedElemetName(String value);

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
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getTestSuiteItem_Kind()
	 * @model
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.TestSuiteItem#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

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
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getTestSuiteItem_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.TestSuiteItem#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // TestSuiteItem
