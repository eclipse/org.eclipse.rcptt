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
package org.eclipse.rcptt.core.scenario;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Suite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.TestSuite#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.TestSuite#isManuallyOrdered <em>Manually Ordered</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getTestSuite()
 * @model
 * @generated
 */
public interface TestSuite extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.core.scenario.TestSuiteItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getTestSuite_Items()
	 * @model containment="true"
	 * @generated
	 */
	EList<TestSuiteItem> getItems();

	/**
	 * Returns the value of the '<em><b>Manually Ordered</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manually Ordered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manually Ordered</em>' attribute.
	 * @see #setManuallyOrdered(boolean)
	 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage#getTestSuite_ManuallyOrdered()
	 * @model default="false"
	 * @generated
	 */
	boolean isManuallyOrdered();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.scenario.TestSuite#isManuallyOrdered <em>Manually Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manually Ordered</em>' attribute.
	 * @see #isManuallyOrdered()
	 * @generated
	 */
	void setManuallyOrdered(boolean value);

} // TestSuite
