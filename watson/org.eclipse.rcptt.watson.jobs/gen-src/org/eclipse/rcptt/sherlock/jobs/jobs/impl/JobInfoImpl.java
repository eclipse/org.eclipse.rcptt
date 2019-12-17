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
package org.eclipse.rcptt.sherlock.jobs.jobs.impl;

import org.eclipse.rcptt.sherlock.jobs.jobs.JobInfo;
import org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Job Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobInfoImpl#getJobClassName <em>Job Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobInfoImpl#getSourceClass <em>Source Class</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobInfoImpl#getSourceMethod <em>Source Method</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobInfoImpl#isSystem <em>System</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobInfoImpl#isUser <em>User</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobInfoImpl#getSourceFile <em>Source File</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobInfoImpl#getThisClassName <em>This Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.JobInfoImpl#getThreadName <em>Thread Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JobInfoImpl extends EObjectImpl implements JobInfo {
	/**
	 * The default value of the '{@link #getJobClassName() <em>Job Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String JOB_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJobClassName() <em>Job Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobClassName()
	 * @generated
	 * @ordered
	 */
	protected String jobClassName = JOB_CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceClass() <em>Source Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceClass()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceClass() <em>Source Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceClass()
	 * @generated
	 * @ordered
	 */
	protected String sourceClass = SOURCE_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceMethod() <em>Source Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceMethod()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_METHOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceMethod() <em>Source Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceMethod()
	 * @generated
	 * @ordered
	 */
	protected String sourceMethod = SOURCE_METHOD_EDEFAULT;

	/**
	 * The default value of the '{@link #isSystem() <em>System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSystem()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SYSTEM_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSystem() <em>System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSystem()
	 * @generated
	 * @ordered
	 */
	protected boolean system = SYSTEM_EDEFAULT;

	/**
	 * The default value of the '{@link #isUser() <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUser()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUser() <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUser()
	 * @generated
	 * @ordered
	 */
	protected boolean user = USER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceFile() <em>Source File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFile()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceFile() <em>Source File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFile()
	 * @generated
	 * @ordered
	 */
	protected String sourceFile = SOURCE_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getThisClassName() <em>This Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThisClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String THIS_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThisClassName() <em>This Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThisClassName()
	 * @generated
	 * @ordered
	 */
	protected String thisClassName = THIS_CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getThreadName() <em>Thread Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreadName()
	 * @generated
	 * @ordered
	 */
	protected static final String THREAD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThreadName() <em>Thread Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreadName()
	 * @generated
	 * @ordered
	 */
	protected String threadName = THREAD_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JobInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JobsPackage.Literals.JOB_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJobClassName() {
		return jobClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJobClassName(String newJobClassName) {
		String oldJobClassName = jobClassName;
		jobClassName = newJobClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.JOB_INFO__JOB_CLASS_NAME, oldJobClassName, jobClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceClass() {
		return sourceClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceClass(String newSourceClass) {
		String oldSourceClass = sourceClass;
		sourceClass = newSourceClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.JOB_INFO__SOURCE_CLASS, oldSourceClass, sourceClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceMethod() {
		return sourceMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceMethod(String newSourceMethod) {
		String oldSourceMethod = sourceMethod;
		sourceMethod = newSourceMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.JOB_INFO__SOURCE_METHOD, oldSourceMethod, sourceMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSystem() {
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem(boolean newSystem) {
		boolean oldSystem = system;
		system = newSystem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.JOB_INFO__SYSTEM, oldSystem, system));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUser() {
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(boolean newUser) {
		boolean oldUser = user;
		user = newUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.JOB_INFO__USER, oldUser, user));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceFile() {
		return sourceFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceFile(String newSourceFile) {
		String oldSourceFile = sourceFile;
		sourceFile = newSourceFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.JOB_INFO__SOURCE_FILE, oldSourceFile, sourceFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThisClassName() {
		return thisClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThisClassName(String newThisClassName) {
		String oldThisClassName = thisClassName;
		thisClassName = newThisClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.JOB_INFO__THIS_CLASS_NAME, oldThisClassName, thisClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThreadName() {
		return threadName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThreadName(String newThreadName) {
		String oldThreadName = threadName;
		threadName = newThreadName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.JOB_INFO__THREAD_NAME, oldThreadName, threadName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JobsPackage.JOB_INFO__JOB_CLASS_NAME:
				return getJobClassName();
			case JobsPackage.JOB_INFO__SOURCE_CLASS:
				return getSourceClass();
			case JobsPackage.JOB_INFO__SOURCE_METHOD:
				return getSourceMethod();
			case JobsPackage.JOB_INFO__SYSTEM:
				return isSystem();
			case JobsPackage.JOB_INFO__USER:
				return isUser();
			case JobsPackage.JOB_INFO__SOURCE_FILE:
				return getSourceFile();
			case JobsPackage.JOB_INFO__THIS_CLASS_NAME:
				return getThisClassName();
			case JobsPackage.JOB_INFO__THREAD_NAME:
				return getThreadName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JobsPackage.JOB_INFO__JOB_CLASS_NAME:
				setJobClassName((String)newValue);
				return;
			case JobsPackage.JOB_INFO__SOURCE_CLASS:
				setSourceClass((String)newValue);
				return;
			case JobsPackage.JOB_INFO__SOURCE_METHOD:
				setSourceMethod((String)newValue);
				return;
			case JobsPackage.JOB_INFO__SYSTEM:
				setSystem((Boolean)newValue);
				return;
			case JobsPackage.JOB_INFO__USER:
				setUser((Boolean)newValue);
				return;
			case JobsPackage.JOB_INFO__SOURCE_FILE:
				setSourceFile((String)newValue);
				return;
			case JobsPackage.JOB_INFO__THIS_CLASS_NAME:
				setThisClassName((String)newValue);
				return;
			case JobsPackage.JOB_INFO__THREAD_NAME:
				setThreadName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case JobsPackage.JOB_INFO__JOB_CLASS_NAME:
				setJobClassName(JOB_CLASS_NAME_EDEFAULT);
				return;
			case JobsPackage.JOB_INFO__SOURCE_CLASS:
				setSourceClass(SOURCE_CLASS_EDEFAULT);
				return;
			case JobsPackage.JOB_INFO__SOURCE_METHOD:
				setSourceMethod(SOURCE_METHOD_EDEFAULT);
				return;
			case JobsPackage.JOB_INFO__SYSTEM:
				setSystem(SYSTEM_EDEFAULT);
				return;
			case JobsPackage.JOB_INFO__USER:
				setUser(USER_EDEFAULT);
				return;
			case JobsPackage.JOB_INFO__SOURCE_FILE:
				setSourceFile(SOURCE_FILE_EDEFAULT);
				return;
			case JobsPackage.JOB_INFO__THIS_CLASS_NAME:
				setThisClassName(THIS_CLASS_NAME_EDEFAULT);
				return;
			case JobsPackage.JOB_INFO__THREAD_NAME:
				setThreadName(THREAD_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case JobsPackage.JOB_INFO__JOB_CLASS_NAME:
				return JOB_CLASS_NAME_EDEFAULT == null ? jobClassName != null : !JOB_CLASS_NAME_EDEFAULT.equals(jobClassName);
			case JobsPackage.JOB_INFO__SOURCE_CLASS:
				return SOURCE_CLASS_EDEFAULT == null ? sourceClass != null : !SOURCE_CLASS_EDEFAULT.equals(sourceClass);
			case JobsPackage.JOB_INFO__SOURCE_METHOD:
				return SOURCE_METHOD_EDEFAULT == null ? sourceMethod != null : !SOURCE_METHOD_EDEFAULT.equals(sourceMethod);
			case JobsPackage.JOB_INFO__SYSTEM:
				return system != SYSTEM_EDEFAULT;
			case JobsPackage.JOB_INFO__USER:
				return user != USER_EDEFAULT;
			case JobsPackage.JOB_INFO__SOURCE_FILE:
				return SOURCE_FILE_EDEFAULT == null ? sourceFile != null : !SOURCE_FILE_EDEFAULT.equals(sourceFile);
			case JobsPackage.JOB_INFO__THIS_CLASS_NAME:
				return THIS_CLASS_NAME_EDEFAULT == null ? thisClassName != null : !THIS_CLASS_NAME_EDEFAULT.equals(thisClassName);
			case JobsPackage.JOB_INFO__THREAD_NAME:
				return THREAD_NAME_EDEFAULT == null ? threadName != null : !THREAD_NAME_EDEFAULT.equals(threadName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (jobClassName: ");
		result.append(jobClassName);
		result.append(", sourceClass: ");
		result.append(sourceClass);
		result.append(", sourceMethod: ");
		result.append(sourceMethod);
		result.append(", system: ");
		result.append(system);
		result.append(", user: ");
		result.append(user);
		result.append(", sourceFile: ");
		result.append(sourceFile);
		result.append(", thisClassName: ");
		result.append(thisClassName);
		result.append(", threadName: ");
		result.append(threadName);
		result.append(')');
		return result.toString();
	}

} //JobInfoImpl
