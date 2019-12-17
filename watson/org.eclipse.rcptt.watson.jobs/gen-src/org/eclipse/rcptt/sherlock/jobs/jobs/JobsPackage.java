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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsFactory
 * @model kind="package"
 * @generated
 */
public interface JobsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "jobs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/sherlock/jobs";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.sherlock.jobs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JobsPackage eINSTANCE = org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncInfoImpl <em>Async Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncInfoImpl
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobsPackageImpl#getAsyncInfo()
	 * @generated
	 */
	int ASYNC_INFO = 0;

	/**
	 * The feature id for the '<em><b>Sync</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_INFO__SYNC = 0;

	/**
	 * The feature id for the '<em><b>Runnable Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_INFO__RUNNABLE_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Source Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_INFO__SOURCE_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Source Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_INFO__SOURCE_METHOD = 3;

	/**
	 * The feature id for the '<em><b>Source File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_INFO__SOURCE_FILE = 4;

	/**
	 * The feature id for the '<em><b>This Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_INFO__THIS_CLASS_NAME = 5;

	/**
	 * The feature id for the '<em><b>Thread Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_INFO__THREAD_NAME = 6;

	/**
	 * The feature id for the '<em><b>Timer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_INFO__TIMER = 7;

	/**
	 * The number of structural features of the '<em>Async Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_INFO_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncEventInfoImpl <em>Async Event Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncEventInfoImpl
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobsPackageImpl#getAsyncEventInfo()
	 * @generated
	 */
	int ASYNC_EVENT_INFO = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_INFO__KIND = 0;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_INFO__DELAY = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_INFO__ID = 2;

	/**
	 * The number of structural features of the '<em>Async Event Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASYNC_EVENT_INFO_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobInfoImpl <em>Job Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobInfoImpl
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobsPackageImpl#getJobInfo()
	 * @generated
	 */
	int JOB_INFO = 2;

	/**
	 * The feature id for the '<em><b>Job Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_INFO__JOB_CLASS_NAME = 0;

	/**
	 * The feature id for the '<em><b>Source Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_INFO__SOURCE_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Source Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_INFO__SOURCE_METHOD = 2;

	/**
	 * The feature id for the '<em><b>System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_INFO__SYSTEM = 3;

	/**
	 * The feature id for the '<em><b>User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_INFO__USER = 4;

	/**
	 * The feature id for the '<em><b>Source File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_INFO__SOURCE_FILE = 5;

	/**
	 * The feature id for the '<em><b>This Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_INFO__THIS_CLASS_NAME = 6;

	/**
	 * The feature id for the '<em><b>Thread Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_INFO__THREAD_NAME = 7;

	/**
	 * The number of structural features of the '<em>Job Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_INFO_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobEventInfoImpl <em>Job Event Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobEventInfoImpl
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobsPackageImpl#getJobEventInfo()
	 * @generated
	 */
	int JOB_EVENT_INFO = 3;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_EVENT_INFO__KIND = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_EVENT_INFO__ID = 1;

	/**
	 * The number of structural features of the '<em>Job Event Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_EVENT_INFO_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventKind <em>Async Event Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventKind
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobsPackageImpl#getAsyncEventKind()
	 * @generated
	 */
	int ASYNC_EVENT_KIND = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobEventKind <em>Job Event Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobEventKind
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobsPackageImpl#getJobEventKind()
	 * @generated
	 */
	int JOB_EVENT_KIND = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo <em>Async Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Async Info</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo
	 * @generated
	 */
	EClass getAsyncInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#isSync <em>Sync</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sync</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#isSync()
	 * @see #getAsyncInfo()
	 * @generated
	 */
	EAttribute getAsyncInfo_Sync();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getRunnableClass <em>Runnable Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runnable Class</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getRunnableClass()
	 * @see #getAsyncInfo()
	 * @generated
	 */
	EAttribute getAsyncInfo_RunnableClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getSourceClass <em>Source Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Class</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getSourceClass()
	 * @see #getAsyncInfo()
	 * @generated
	 */
	EAttribute getAsyncInfo_SourceClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getSourceMethod <em>Source Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Method</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getSourceMethod()
	 * @see #getAsyncInfo()
	 * @generated
	 */
	EAttribute getAsyncInfo_SourceMethod();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getSourceFile <em>Source File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source File</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getSourceFile()
	 * @see #getAsyncInfo()
	 * @generated
	 */
	EAttribute getAsyncInfo_SourceFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getThisClassName <em>This Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>This Class Name</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getThisClassName()
	 * @see #getAsyncInfo()
	 * @generated
	 */
	EAttribute getAsyncInfo_ThisClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getThreadName <em>Thread Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thread Name</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#getThreadName()
	 * @see #getAsyncInfo()
	 * @generated
	 */
	EAttribute getAsyncInfo_ThreadName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#isTimer <em>Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timer</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo#isTimer()
	 * @see #getAsyncInfo()
	 * @generated
	 */
	EAttribute getAsyncInfo_Timer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventInfo <em>Async Event Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Async Event Info</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventInfo
	 * @generated
	 */
	EClass getAsyncEventInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventInfo#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventInfo#getKind()
	 * @see #getAsyncEventInfo()
	 * @generated
	 */
	EAttribute getAsyncEventInfo_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventInfo#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventInfo#getDelay()
	 * @see #getAsyncEventInfo()
	 * @generated
	 */
	EAttribute getAsyncEventInfo_Delay();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventInfo#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventInfo#getId()
	 * @see #getAsyncEventInfo()
	 * @generated
	 */
	EAttribute getAsyncEventInfo_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo <em>Job Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Job Info</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo
	 * @generated
	 */
	EClass getJobInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getJobClassName <em>Job Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Job Class Name</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getJobClassName()
	 * @see #getJobInfo()
	 * @generated
	 */
	EAttribute getJobInfo_JobClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getSourceClass <em>Source Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Class</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getSourceClass()
	 * @see #getJobInfo()
	 * @generated
	 */
	EAttribute getJobInfo_SourceClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getSourceMethod <em>Source Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Method</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getSourceMethod()
	 * @see #getJobInfo()
	 * @generated
	 */
	EAttribute getJobInfo_SourceMethod();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#isSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#isSystem()
	 * @see #getJobInfo()
	 * @generated
	 */
	EAttribute getJobInfo_System();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#isUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#isUser()
	 * @see #getJobInfo()
	 * @generated
	 */
	EAttribute getJobInfo_User();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getSourceFile <em>Source File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source File</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getSourceFile()
	 * @see #getJobInfo()
	 * @generated
	 */
	EAttribute getJobInfo_SourceFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getThisClassName <em>This Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>This Class Name</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getThisClassName()
	 * @see #getJobInfo()
	 * @generated
	 */
	EAttribute getJobInfo_ThisClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getThreadName <em>Thread Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thread Name</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo#getThreadName()
	 * @see #getJobInfo()
	 * @generated
	 */
	EAttribute getJobInfo_ThreadName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobEventInfo <em>Job Event Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Job Event Info</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobEventInfo
	 * @generated
	 */
	EClass getJobEventInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobEventInfo#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobEventInfo#getKind()
	 * @see #getJobEventInfo()
	 * @generated
	 */
	EAttribute getJobEventInfo_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobEventInfo#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobEventInfo#getId()
	 * @see #getJobEventInfo()
	 * @generated
	 */
	EAttribute getJobEventInfo_Id();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventKind <em>Async Event Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Async Event Kind</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventKind
	 * @generated
	 */
	EEnum getAsyncEventKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobEventKind <em>Job Event Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Job Event Kind</em>'.
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobEventKind
	 * @generated
	 */
	EEnum getJobEventKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JobsFactory getJobsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncInfoImpl <em>Async Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncInfoImpl
		 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobsPackageImpl#getAsyncInfo()
		 * @generated
		 */
		EClass ASYNC_INFO = eINSTANCE.getAsyncInfo();

		/**
		 * The meta object literal for the '<em><b>Sync</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASYNC_INFO__SYNC = eINSTANCE.getAsyncInfo_Sync();

		/**
		 * The meta object literal for the '<em><b>Runnable Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASYNC_INFO__RUNNABLE_CLASS = eINSTANCE.getAsyncInfo_RunnableClass();

		/**
		 * The meta object literal for the '<em><b>Source Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASYNC_INFO__SOURCE_CLASS = eINSTANCE.getAsyncInfo_SourceClass();

		/**
		 * The meta object literal for the '<em><b>Source Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASYNC_INFO__SOURCE_METHOD = eINSTANCE.getAsyncInfo_SourceMethod();

		/**
		 * The meta object literal for the '<em><b>Source File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASYNC_INFO__SOURCE_FILE = eINSTANCE.getAsyncInfo_SourceFile();

		/**
		 * The meta object literal for the '<em><b>This Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASYNC_INFO__THIS_CLASS_NAME = eINSTANCE.getAsyncInfo_ThisClassName();

		/**
		 * The meta object literal for the '<em><b>Thread Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASYNC_INFO__THREAD_NAME = eINSTANCE.getAsyncInfo_ThreadName();

		/**
		 * The meta object literal for the '<em><b>Timer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASYNC_INFO__TIMER = eINSTANCE.getAsyncInfo_Timer();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncEventInfoImpl <em>Async Event Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncEventInfoImpl
		 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobsPackageImpl#getAsyncEventInfo()
		 * @generated
		 */
		EClass ASYNC_EVENT_INFO = eINSTANCE.getAsyncEventInfo();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASYNC_EVENT_INFO__KIND = eINSTANCE.getAsyncEventInfo_Kind();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASYNC_EVENT_INFO__DELAY = eINSTANCE.getAsyncEventInfo_Delay();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASYNC_EVENT_INFO__ID = eINSTANCE.getAsyncEventInfo_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobInfoImpl <em>Job Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobInfoImpl
		 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobsPackageImpl#getJobInfo()
		 * @generated
		 */
		EClass JOB_INFO = eINSTANCE.getJobInfo();

		/**
		 * The meta object literal for the '<em><b>Job Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_INFO__JOB_CLASS_NAME = eINSTANCE.getJobInfo_JobClassName();

		/**
		 * The meta object literal for the '<em><b>Source Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_INFO__SOURCE_CLASS = eINSTANCE.getJobInfo_SourceClass();

		/**
		 * The meta object literal for the '<em><b>Source Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_INFO__SOURCE_METHOD = eINSTANCE.getJobInfo_SourceMethod();

		/**
		 * The meta object literal for the '<em><b>System</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_INFO__SYSTEM = eINSTANCE.getJobInfo_System();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_INFO__USER = eINSTANCE.getJobInfo_User();

		/**
		 * The meta object literal for the '<em><b>Source File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_INFO__SOURCE_FILE = eINSTANCE.getJobInfo_SourceFile();

		/**
		 * The meta object literal for the '<em><b>This Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_INFO__THIS_CLASS_NAME = eINSTANCE.getJobInfo_ThisClassName();

		/**
		 * The meta object literal for the '<em><b>Thread Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_INFO__THREAD_NAME = eINSTANCE.getJobInfo_ThreadName();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobEventInfoImpl <em>Job Event Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobEventInfoImpl
		 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobsPackageImpl#getJobEventInfo()
		 * @generated
		 */
		EClass JOB_EVENT_INFO = eINSTANCE.getJobEventInfo();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_EVENT_INFO__KIND = eINSTANCE.getJobEventInfo_Kind();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB_EVENT_INFO__ID = eINSTANCE.getJobEventInfo_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventKind <em>Async Event Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventKind
		 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobsPackageImpl#getAsyncEventKind()
		 * @generated
		 */
		EEnum ASYNC_EVENT_KIND = eINSTANCE.getAsyncEventKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.jobs.jobs.JobEventKind <em>Job Event Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobEventKind
		 * @see org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobsPackageImpl#getJobEventKind()
		 * @generated
		 */
		EEnum JOB_EVENT_KIND = eINSTANCE.getJobEventKind();

	}

} //JobsPackage
