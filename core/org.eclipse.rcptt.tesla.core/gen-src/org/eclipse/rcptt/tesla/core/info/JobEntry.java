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
package org.eclipse.rcptt.tesla.core.info;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Job Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getJobClass <em>Job Class</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getRuleClass <em>Rule Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getJobEntry()
 * @model
 * @generated
 */
public interface JobEntry extends EObject {
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
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getJobEntry_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

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
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getJobEntry_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Job Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Job Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Job Class</em>' attribute.
	 * @see #setJobClass(String)
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getJobEntry_JobClass()
	 * @model
	 * @generated
	 */
	String getJobClass();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getJobClass <em>Job Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Job Class</em>' attribute.
	 * @see #getJobClass()
	 * @generated
	 */
	void setJobClass(String value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see #setState(String)
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getJobEntry_State()
	 * @model
	 * @generated
	 */
	String getState();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see #getState()
	 * @generated
	 */
	void setState(String value);

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' attribute.
	 * @see #setRule(String)
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getJobEntry_Rule()
	 * @model
	 * @generated
	 */
	String getRule();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getRule <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' attribute.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(String value);

	/**
	 * Returns the value of the '<em><b>Rule Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Class</em>' attribute.
	 * @see #setRuleClass(String)
	 * @see org.eclipse.rcptt.tesla.core.info.InfoPackage#getJobEntry_RuleClass()
	 * @model
	 * @generated
	 */
	String getRuleClass();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.info.JobEntry#getRuleClass <em>Rule Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Class</em>' attribute.
	 * @see #getRuleClass()
	 * @generated
	 */
	void setRuleClass(String value);

} // JobEntry
