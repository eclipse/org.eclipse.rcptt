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
 * A representation of the model object '<em><b>Async Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#isSync <em>Sync</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getRunnableClass <em>Runnable Class</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getSourceClass <em>Source Class</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getSourceMethod <em>Source Method</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getSourceFile <em>Source File</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getThisClassName <em>This Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getThreadName <em>Thread Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#isTimer <em>Timer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getAsyncInfo()
 * @model
 * @generated
 */
public interface AsyncInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Sync</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sync</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sync</em>' attribute.
	 * @see #setSync(boolean)
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getAsyncInfo_Sync()
	 * @model default="false"
	 * @generated
	 */
	boolean isSync();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#isSync <em>Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sync</em>' attribute.
	 * @see #isSync()
	 * @generated
	 */
	void setSync(boolean value);

	/**
	 * Returns the value of the '<em><b>Runnable Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runnable Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runnable Class</em>' attribute.
	 * @see #setRunnableClass(String)
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getAsyncInfo_RunnableClass()
	 * @model
	 * @generated
	 */
	String getRunnableClass();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getRunnableClass <em>Runnable Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runnable Class</em>' attribute.
	 * @see #getRunnableClass()
	 * @generated
	 */
	void setRunnableClass(String value);

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
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getAsyncInfo_SourceClass()
	 * @model
	 * @generated
	 */
	String getSourceClass();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getSourceClass <em>Source Class</em>}' attribute.
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
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getAsyncInfo_SourceMethod()
	 * @model
	 * @generated
	 */
	String getSourceMethod();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getSourceMethod <em>Source Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Method</em>' attribute.
	 * @see #getSourceMethod()
	 * @generated
	 */
	void setSourceMethod(String value);

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
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getAsyncInfo_SourceFile()
	 * @model
	 * @generated
	 */
	String getSourceFile();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getSourceFile <em>Source File</em>}' attribute.
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
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getAsyncInfo_ThisClassName()
	 * @model
	 * @generated
	 */
	String getThisClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getThisClassName <em>This Class Name</em>}' attribute.
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
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getAsyncInfo_ThreadName()
	 * @model
	 * @generated
	 */
	String getThreadName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getThreadName <em>Thread Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thread Name</em>' attribute.
	 * @see #getThreadName()
	 * @generated
	 */
	void setThreadName(String value);

	/**
	 * Returns the value of the '<em><b>Timer</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timer</em>' attribute.
	 * @see #setTimer(boolean)
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getAsyncInfo_Timer()
	 * @model default="false"
	 * @generated
	 */
	boolean isTimer();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#isTimer <em>Timer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timer</em>' attribute.
	 * @see #isTimer()
	 * @generated
	 */
	void setTimer(boolean value);

} // AsyncInfo
