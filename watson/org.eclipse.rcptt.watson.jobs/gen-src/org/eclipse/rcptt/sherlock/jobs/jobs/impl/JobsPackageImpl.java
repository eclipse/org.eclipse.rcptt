/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.sherlock.jobs.jobs.impl;

import org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventInfo;
import org.eclipse.rcptt.sherlock.jobs.jobs.AsyncEventKind;
import org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo;
import org.eclipse.rcptt.sherlock.jobs.jobs.JobEventInfo;
import org.eclipse.rcptt.sherlock.jobs.jobs.JobEventKind;
import org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo;
import org.eclipse.rcptt.sherlock.jobs.jobs.JobsFactory;
import org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JobsPackageImpl extends EPackageImpl implements JobsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass asyncInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass asyncEventInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jobInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jobEventInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum asyncEventKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jobEventKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JobsPackageImpl() {
		super(eNS_URI, JobsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link JobsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JobsPackage init() {
		if (isInited) return (JobsPackage)EPackage.Registry.INSTANCE.getEPackage(JobsPackage.eNS_URI);

		// Obtain or create and register package
		JobsPackageImpl theJobsPackage = (JobsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JobsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JobsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theJobsPackage.createPackageContents();

		// Initialize created meta-data
		theJobsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJobsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JobsPackage.eNS_URI, theJobsPackage);
		return theJobsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAsyncInfo() {
		return asyncInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsyncInfo_Sync() {
		return (EAttribute)asyncInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsyncInfo_RunnableClass() {
		return (EAttribute)asyncInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsyncInfo_SourceClass() {
		return (EAttribute)asyncInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsyncInfo_SourceMethod() {
		return (EAttribute)asyncInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsyncInfo_SourceFile() {
		return (EAttribute)asyncInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsyncInfo_ThisClassName() {
		return (EAttribute)asyncInfoEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsyncInfo_ThreadName() {
		return (EAttribute)asyncInfoEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsyncInfo_Timer() {
		return (EAttribute)asyncInfoEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAsyncEventInfo() {
		return asyncEventInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsyncEventInfo_Kind() {
		return (EAttribute)asyncEventInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsyncEventInfo_Delay() {
		return (EAttribute)asyncEventInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAsyncEventInfo_Id() {
		return (EAttribute)asyncEventInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJobInfo() {
		return jobInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobInfo_JobClassName() {
		return (EAttribute)jobInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobInfo_SourceClass() {
		return (EAttribute)jobInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobInfo_SourceMethod() {
		return (EAttribute)jobInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobInfo_System() {
		return (EAttribute)jobInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobInfo_User() {
		return (EAttribute)jobInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobInfo_SourceFile() {
		return (EAttribute)jobInfoEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobInfo_ThisClassName() {
		return (EAttribute)jobInfoEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobInfo_ThreadName() {
		return (EAttribute)jobInfoEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJobEventInfo() {
		return jobEventInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobEventInfo_Kind() {
		return (EAttribute)jobEventInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJobEventInfo_Id() {
		return (EAttribute)jobEventInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAsyncEventKind() {
		return asyncEventKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getJobEventKind() {
		return jobEventKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobsFactory getJobsFactory() {
		return (JobsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		asyncInfoEClass = createEClass(ASYNC_INFO);
		createEAttribute(asyncInfoEClass, ASYNC_INFO__SYNC);
		createEAttribute(asyncInfoEClass, ASYNC_INFO__RUNNABLE_CLASS);
		createEAttribute(asyncInfoEClass, ASYNC_INFO__SOURCE_CLASS);
		createEAttribute(asyncInfoEClass, ASYNC_INFO__SOURCE_METHOD);
		createEAttribute(asyncInfoEClass, ASYNC_INFO__SOURCE_FILE);
		createEAttribute(asyncInfoEClass, ASYNC_INFO__THIS_CLASS_NAME);
		createEAttribute(asyncInfoEClass, ASYNC_INFO__THREAD_NAME);
		createEAttribute(asyncInfoEClass, ASYNC_INFO__TIMER);

		asyncEventInfoEClass = createEClass(ASYNC_EVENT_INFO);
		createEAttribute(asyncEventInfoEClass, ASYNC_EVENT_INFO__KIND);
		createEAttribute(asyncEventInfoEClass, ASYNC_EVENT_INFO__DELAY);
		createEAttribute(asyncEventInfoEClass, ASYNC_EVENT_INFO__ID);

		jobInfoEClass = createEClass(JOB_INFO);
		createEAttribute(jobInfoEClass, JOB_INFO__JOB_CLASS_NAME);
		createEAttribute(jobInfoEClass, JOB_INFO__SOURCE_CLASS);
		createEAttribute(jobInfoEClass, JOB_INFO__SOURCE_METHOD);
		createEAttribute(jobInfoEClass, JOB_INFO__SYSTEM);
		createEAttribute(jobInfoEClass, JOB_INFO__USER);
		createEAttribute(jobInfoEClass, JOB_INFO__SOURCE_FILE);
		createEAttribute(jobInfoEClass, JOB_INFO__THIS_CLASS_NAME);
		createEAttribute(jobInfoEClass, JOB_INFO__THREAD_NAME);

		jobEventInfoEClass = createEClass(JOB_EVENT_INFO);
		createEAttribute(jobEventInfoEClass, JOB_EVENT_INFO__KIND);
		createEAttribute(jobEventInfoEClass, JOB_EVENT_INFO__ID);

		// Create enums
		asyncEventKindEEnum = createEEnum(ASYNC_EVENT_KIND);
		jobEventKindEEnum = createEEnum(JOB_EVENT_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(asyncInfoEClass, AsyncInfo.class, "AsyncInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAsyncInfo_Sync(), ecorePackage.getEBoolean(), "sync", "false", 0, 1, AsyncInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsyncInfo_RunnableClass(), ecorePackage.getEString(), "runnableClass", null, 0, 1, AsyncInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsyncInfo_SourceClass(), ecorePackage.getEString(), "sourceClass", null, 0, 1, AsyncInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsyncInfo_SourceMethod(), ecorePackage.getEString(), "sourceMethod", null, 0, 1, AsyncInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsyncInfo_SourceFile(), ecorePackage.getEString(), "sourceFile", null, 0, 1, AsyncInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsyncInfo_ThisClassName(), ecorePackage.getEString(), "thisClassName", null, 0, 1, AsyncInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsyncInfo_ThreadName(), ecorePackage.getEString(), "threadName", null, 0, 1, AsyncInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsyncInfo_Timer(), ecorePackage.getEBoolean(), "timer", "false", 0, 1, AsyncInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(asyncEventInfoEClass, AsyncEventInfo.class, "AsyncEventInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAsyncEventInfo_Kind(), this.getAsyncEventKind(), "kind", null, 0, 1, AsyncEventInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsyncEventInfo_Delay(), ecorePackage.getEInt(), "delay", null, 0, 1, AsyncEventInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAsyncEventInfo_Id(), ecorePackage.getEString(), "id", null, 0, 1, AsyncEventInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jobInfoEClass, JobInfo.class, "JobInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJobInfo_JobClassName(), ecorePackage.getEString(), "jobClassName", null, 0, 1, JobInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJobInfo_SourceClass(), ecorePackage.getEString(), "sourceClass", null, 0, 1, JobInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJobInfo_SourceMethod(), ecorePackage.getEString(), "sourceMethod", null, 0, 1, JobInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJobInfo_System(), ecorePackage.getEBoolean(), "system", null, 0, 1, JobInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJobInfo_User(), ecorePackage.getEBoolean(), "user", null, 0, 1, JobInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJobInfo_SourceFile(), ecorePackage.getEString(), "sourceFile", null, 0, 1, JobInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJobInfo_ThisClassName(), ecorePackage.getEString(), "thisClassName", null, 0, 1, JobInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJobInfo_ThreadName(), ecorePackage.getEString(), "threadName", null, 0, 1, JobInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jobEventInfoEClass, JobEventInfo.class, "JobEventInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJobEventInfo_Kind(), this.getJobEventKind(), "kind", null, 0, 1, JobEventInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJobEventInfo_Id(), ecorePackage.getEString(), "id", null, 0, 1, JobEventInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(asyncEventKindEEnum, AsyncEventKind.class, "AsyncEventKind");
		addEEnumLiteral(asyncEventKindEEnum, AsyncEventKind.STARTING);
		addEEnumLiteral(asyncEventKindEEnum, AsyncEventKind.DONE);
		addEEnumLiteral(asyncEventKindEEnum, AsyncEventKind.RUNNING);
		addEEnumLiteral(asyncEventKindEEnum, AsyncEventKind.TIMER_EXEC);

		initEEnum(jobEventKindEEnum, JobEventKind.class, "JobEventKind");
		addEEnumLiteral(jobEventKindEEnum, JobEventKind.SHEDULED);
		addEEnumLiteral(jobEventKindEEnum, JobEventKind.RUNNING);
		addEEnumLiteral(jobEventKindEEnum, JobEventKind.ASYNC_FINISH);
		addEEnumLiteral(jobEventKindEEnum, JobEventKind.ASYNC_DONE);
		addEEnumLiteral(jobEventKindEEnum, JobEventKind.FINISHED);
		addEEnumLiteral(jobEventKindEEnum, JobEventKind.SLEPPING);
		addEEnumLiteral(jobEventKindEEnum, JobEventKind.WAITING);
		addEEnumLiteral(jobEventKindEEnum, JobEventKind.CANCELED);

		// Create resource
		createResource(eNS_URI);
	}

} //JobsPackageImpl
