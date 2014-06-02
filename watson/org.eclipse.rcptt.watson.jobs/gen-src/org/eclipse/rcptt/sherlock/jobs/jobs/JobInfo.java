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
package org.eclipse.rcptt.sherlock.jobs.jobs;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Job Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getJobClassName <em>Job Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getSourceClass <em>Source Class</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getSourceMethod <em>Source Method</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#isSystem <em>System</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#isUser <em>User</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getSourceFile <em>Source File</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getThisClassName <em>This Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getThreadName <em>Thread Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getJobInfo()
 * @model
 * @generated
 */
public interface JobInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Job Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Job Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Job Class Name</em>' attribute.
	 * @see #setJobClassName(String)
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getJobInfo_JobClassName()
	 * @model
	 * @generated
	 */
	String getJobClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getJobClassName <em>Job Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Job Class Name</em>' attribute.
	 * @see #getJobClassName()
	 * @generated
	 */
	void setJobClassName(String value);

	/**
	 * Returns the value of the '<em><b>Source Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Class</em>' attribute.
	 * @see #setSourceClass(String)
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getJobInfo_SourceClass()
	 * @model
	 * @generated
	 */
	String getSourceClass();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getSourceClass <em>Source Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Class</em>' attribute.
	 * @see #getSourceClass()
	 * @generated
	 */
	void setSourceClass(String value);

	/**
	 * Returns the value of the '<em><b>Source Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Method</em>' attribute.
	 * @see #setSourceMethod(String)
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getJobInfo_SourceMethod()
	 * @model
	 * @generated
	 */
	String getSourceMethod();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getSourceMethod <em>Source Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Method</em>' attribute.
	 * @see #getSourceMethod()
	 * @generated
	 */
	void setSourceMethod(String value);

	/**
	 * Returns the value of the '<em><b>System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System</em>' attribute.
	 * @see #setSystem(boolean)
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getJobInfo_System()
	 * @model
	 * @generated
	 */
	boolean isSystem();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#isSystem <em>System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' attribute.
	 * @see #isSystem()
	 * @generated
	 */
	void setSystem(boolean value);

	/**
	 * Returns the value of the '<em><b>User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' attribute.
	 * @see #setUser(boolean)
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getJobInfo_User()
	 * @model
	 * @generated
	 */
	boolean isUser();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#isUser <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' attribute.
	 * @see #isUser()
	 * @generated
	 */
	void setUser(boolean value);

	/**
	 * Returns the value of the '<em><b>Source File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source File</em>' attribute.
	 * @see #setSourceFile(String)
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getJobInfo_SourceFile()
	 * @model
	 * @generated
	 */
	String getSourceFile();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getSourceFile <em>Source File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source File</em>' attribute.
	 * @see #getSourceFile()
	 * @generated
	 */
	void setSourceFile(String value);

	/**
	 * Returns the value of the '<em><b>This Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>This Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>This Class Name</em>' attribute.
	 * @see #setThisClassName(String)
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getJobInfo_ThisClassName()
	 * @model
	 * @generated
	 */
	String getThisClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getThisClassName <em>This Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>This Class Name</em>' attribute.
	 * @see #getThisClassName()
	 * @generated
	 */
	void setThisClassName(String value);

	/**
	 * Returns the value of the '<em><b>Thread Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thread Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thread Name</em>' attribute.
	 * @see #setThreadName(String)
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getJobInfo_ThreadName()
	 * @model
	 * @generated
	 */
	String getThreadName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getThreadName <em>Thread Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thread Name</em>' attribute.
	 * @see #getThreadName()
	 * @generated
	 */
	void setThreadName(String value);

} // JobInfo
