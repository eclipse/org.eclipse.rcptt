/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.testrail;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.testrail.TestRailStep#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testrail.TestRailStep#getExpected <em>Expected</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testrail.TestRailStep#getActual <em>Actual</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testrail.TestRailStep#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.testrail.TestRailPackage#getTestRailStep()
 * @model
 * @generated
 */
public interface TestRailStep extends Command {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see org.eclipse.rcptt.testrail.TestRailPackage#getTestRailStep_Content()
	 * @model
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testrail.TestRailStep#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

	/**
	 * Returns the value of the '<em><b>Expected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expected</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expected</em>' attribute.
	 * @see #setExpected(String)
	 * @see org.eclipse.rcptt.testrail.TestRailPackage#getTestRailStep_Expected()
	 * @model
	 * @generated
	 */
	String getExpected();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testrail.TestRailStep#getExpected <em>Expected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expected</em>' attribute.
	 * @see #getExpected()
	 * @generated
	 */
	void setExpected(String value);

	/**
	 * Returns the value of the '<em><b>Actual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual</em>' attribute.
	 * @see #setActual(String)
	 * @see org.eclipse.rcptt.testrail.TestRailPackage#getTestRailStep_Actual()
	 * @model
	 * @generated
	 */
	String getActual();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testrail.TestRailStep#getActual <em>Actual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual</em>' attribute.
	 * @see #getActual()
	 * @generated
	 */
	void setActual(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The default value is <code>"untested"</code>.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.testrail.TestRailStepStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.eclipse.rcptt.testrail.TestRailStepStatus
	 * @see #setStatus(TestRailStepStatus)
	 * @see org.eclipse.rcptt.testrail.TestRailPackage#getTestRailStep_Status()
	 * @model default="untested"
	 * @generated
	 */
	TestRailStepStatus getStatus();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testrail.TestRailStep#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see org.eclipse.rcptt.testrail.TestRailStepStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(TestRailStepStatus value);

} // TestRailStep
