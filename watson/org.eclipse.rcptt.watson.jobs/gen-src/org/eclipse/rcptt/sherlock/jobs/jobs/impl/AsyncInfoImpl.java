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

import org.eclipse.rcptt.sherlock.jobs.jobs.AsyncInfo;
import org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Async Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncInfoImpl#isSync <em>Sync</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncInfoImpl#getRunnableClass <em>Runnable Class</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncInfoImpl#getSourceClass <em>Source Class</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncInfoImpl#getSourceMethod <em>Source Method</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncInfoImpl#getSourceFile <em>Source File</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncInfoImpl#getThisClassName <em>This Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncInfoImpl#getThreadName <em>Thread Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.jobs.jobs.impl.AsyncInfoImpl#isTimer <em>Timer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AsyncInfoImpl extends EObjectImpl implements AsyncInfo {
	/**
	 * The default value of the '{@link #isSync() <em>Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSync()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SYNC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSync() <em>Sync</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSync()
	 * @generated
	 * @ordered
	 */
	protected boolean sync = SYNC_EDEFAULT;

	/**
	 * The default value of the '{@link #getRunnableClass() <em>Runnable Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunnableClass()
	 * @generated
	 * @ordered
	 */
	protected static final String RUNNABLE_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRunnableClass() <em>Runnable Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunnableClass()
	 * @generated
	 * @ordered
	 */
	protected String runnableClass = RUNNABLE_CLASS_EDEFAULT;

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
	 * The default value of the '{@link #isTimer() <em>Timer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTimer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TIMER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTimer() <em>Timer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTimer()
	 * @generated
	 * @ordered
	 */
	protected boolean timer = TIMER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AsyncInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JobsPackage.Literals.ASYNC_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSync() {
		return sync;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSync(boolean newSync) {
		boolean oldSync = sync;
		sync = newSync;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.ASYNC_INFO__SYNC, oldSync, sync));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRunnableClass() {
		return runnableClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunnableClass(String newRunnableClass) {
		String oldRunnableClass = runnableClass;
		runnableClass = newRunnableClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.ASYNC_INFO__RUNNABLE_CLASS, oldRunnableClass, runnableClass));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.ASYNC_INFO__SOURCE_CLASS, oldSourceClass, sourceClass));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.ASYNC_INFO__SOURCE_METHOD, oldSourceMethod, sourceMethod));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.ASYNC_INFO__SOURCE_FILE, oldSourceFile, sourceFile));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.ASYNC_INFO__THIS_CLASS_NAME, oldThisClassName, thisClassName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.ASYNC_INFO__THREAD_NAME, oldThreadName, threadName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTimer() {
		return timer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimer(boolean newTimer) {
		boolean oldTimer = timer;
		timer = newTimer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JobsPackage.ASYNC_INFO__TIMER, oldTimer, timer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JobsPackage.ASYNC_INFO__SYNC:
				return isSync();
			case JobsPackage.ASYNC_INFO__RUNNABLE_CLASS:
				return getRunnableClass();
			case JobsPackage.ASYNC_INFO__SOURCE_CLASS:
				return getSourceClass();
			case JobsPackage.ASYNC_INFO__SOURCE_METHOD:
				return getSourceMethod();
			case JobsPackage.ASYNC_INFO__SOURCE_FILE:
				return getSourceFile();
			case JobsPackage.ASYNC_INFO__THIS_CLASS_NAME:
				return getThisClassName();
			case JobsPackage.ASYNC_INFO__THREAD_NAME:
				return getThreadName();
			case JobsPackage.ASYNC_INFO__TIMER:
				return isTimer();
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
			case JobsPackage.ASYNC_INFO__SYNC:
				setSync((Boolean)newValue);
				return;
			case JobsPackage.ASYNC_INFO__RUNNABLE_CLASS:
				setRunnableClass((String)newValue);
				return;
			case JobsPackage.ASYNC_INFO__SOURCE_CLASS:
				setSourceClass((String)newValue);
				return;
			case JobsPackage.ASYNC_INFO__SOURCE_METHOD:
				setSourceMethod((String)newValue);
				return;
			case JobsPackage.ASYNC_INFO__SOURCE_FILE:
				setSourceFile((String)newValue);
				return;
			case JobsPackage.ASYNC_INFO__THIS_CLASS_NAME:
				setThisClassName((String)newValue);
				return;
			case JobsPackage.ASYNC_INFO__THREAD_NAME:
				setThreadName((String)newValue);
				return;
			case JobsPackage.ASYNC_INFO__TIMER:
				setTimer((Boolean)newValue);
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
			case JobsPackage.ASYNC_INFO__SYNC:
				setSync(SYNC_EDEFAULT);
				return;
			case JobsPackage.ASYNC_INFO__RUNNABLE_CLASS:
				setRunnableClass(RUNNABLE_CLASS_EDEFAULT);
				return;
			case JobsPackage.ASYNC_INFO__SOURCE_CLASS:
				setSourceClass(SOURCE_CLASS_EDEFAULT);
				return;
			case JobsPackage.ASYNC_INFO__SOURCE_METHOD:
				setSourceMethod(SOURCE_METHOD_EDEFAULT);
				return;
			case JobsPackage.ASYNC_INFO__SOURCE_FILE:
				setSourceFile(SOURCE_FILE_EDEFAULT);
				return;
			case JobsPackage.ASYNC_INFO__THIS_CLASS_NAME:
				setThisClassName(THIS_CLASS_NAME_EDEFAULT);
				return;
			case JobsPackage.ASYNC_INFO__THREAD_NAME:
				setThreadName(THREAD_NAME_EDEFAULT);
				return;
			case JobsPackage.ASYNC_INFO__TIMER:
				setTimer(TIMER_EDEFAULT);
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
			case JobsPackage.ASYNC_INFO__SYNC:
				return sync != SYNC_EDEFAULT;
			case JobsPackage.ASYNC_INFO__RUNNABLE_CLASS:
				return RUNNABLE_CLASS_EDEFAULT == null ? runnableClass != null : !RUNNABLE_CLASS_EDEFAULT.equals(runnableClass);
			case JobsPackage.ASYNC_INFO__SOURCE_CLASS:
				return SOURCE_CLASS_EDEFAULT == null ? sourceClass != null : !SOURCE_CLASS_EDEFAULT.equals(sourceClass);
			case JobsPackage.ASYNC_INFO__SOURCE_METHOD:
				return SOURCE_METHOD_EDEFAULT == null ? sourceMethod != null : !SOURCE_METHOD_EDEFAULT.equals(sourceMethod);
			case JobsPackage.ASYNC_INFO__SOURCE_FILE:
				return SOURCE_FILE_EDEFAULT == null ? sourceFile != null : !SOURCE_FILE_EDEFAULT.equals(sourceFile);
			case JobsPackage.ASYNC_INFO__THIS_CLASS_NAME:
				return THIS_CLASS_NAME_EDEFAULT == null ? thisClassName != null : !THIS_CLASS_NAME_EDEFAULT.equals(thisClassName);
			case JobsPackage.ASYNC_INFO__THREAD_NAME:
				return THREAD_NAME_EDEFAULT == null ? threadName != null : !THREAD_NAME_EDEFAULT.equals(threadName);
			case JobsPackage.ASYNC_INFO__TIMER:
				return timer != TIMER_EDEFAULT;
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
		result.append(" (sync: ");
		result.append(sync);
		result.append(", runnableClass: ");
		result.append(runnableClass);
		result.append(", sourceClass: ");
		result.append(sourceClass);
		result.append(", sourceMethod: ");
		result.append(sourceMethod);
		result.append(", sourceFile: ");
		result.append(sourceFile);
		result.append(", thisClassName: ");
		result.append(thisClassName);
		result.append(", threadName: ");
		result.append(threadName);
		result.append(", timer: ");
		result.append(timer);
		result.append(')');
		return result.toString();
	}

} //AsyncInfoImpl
