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
package org.eclipse.rcptt.sherlock.jobs.jobs;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Job Event Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobEventInfo#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobEventInfo#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getJobEventInfo()
 * @model
 * @generated
 */
public interface JobEventInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.sherlock.jobs.jobs.JobEventKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobEventKind
	 * @see #setKind(JobEventKind)
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getJobEventInfo_Kind()
	 * @model
	 * @generated
	 */
	JobEventKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobEventInfo#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobEventKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(JobEventKind value);

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
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getJobEventInfo_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobEventInfo#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // JobEventInfo
