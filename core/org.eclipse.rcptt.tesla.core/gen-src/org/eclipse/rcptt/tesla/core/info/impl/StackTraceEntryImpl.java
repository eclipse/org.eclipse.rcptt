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
package org.eclipse.rcptt.tesla.core.info.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.rcptt.tesla.core.info.InfoPackage;
import org.eclipse.rcptt.tesla.core.info.StackTraceEntry;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Stack Trace Entry</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.StackTraceEntryImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.StackTraceEntryImpl#getStackTrace <em>Stack Trace</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.StackTraceEntryImpl#getThreadName <em>Thread Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.StackTraceEntryImpl#getThreadClass <em>Thread Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StackTraceEntryImpl extends EObjectImpl implements StackTraceEntry {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStackTrace() <em>Stack Trace</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStackTrace()
	 * @generated
	 * @ordered
	 */
	protected EList<String> stackTrace;

	/**
	 * The default value of the '{@link #getThreadName() <em>Thread Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getThreadName()
	 * @generated
	 * @ordered
	 */
	protected static final String THREAD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThreadName() <em>Thread Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getThreadName()
	 * @generated
	 * @ordered
	 */
	protected String threadName = THREAD_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getThreadClass() <em>Thread Class</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getThreadClass()
	 * @generated
	 * @ordered
	 */
	protected static final String THREAD_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThreadClass() <em>Thread Class</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getThreadClass()
	 * @generated
	 * @ordered
	 */
	protected String threadClass = THREAD_CLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected StackTraceEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfoPackage.Literals.STACK_TRACE_ENTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.STACK_TRACE_ENTRY__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getStackTrace() {
		if (stackTrace == null) {
			stackTrace = new EDataTypeEList<String>(String.class, this, InfoPackage.STACK_TRACE_ENTRY__STACK_TRACE);
		}
		return stackTrace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getThreadName() {
		return threadName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setThreadName(String newThreadName) {
		String oldThreadName = threadName;
		threadName = newThreadName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.STACK_TRACE_ENTRY__THREAD_NAME, oldThreadName, threadName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getThreadClass() {
		return threadClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setThreadClass(String newThreadClass) {
		String oldThreadClass = threadClass;
		threadClass = newThreadClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.STACK_TRACE_ENTRY__THREAD_CLASS, oldThreadClass, threadClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InfoPackage.STACK_TRACE_ENTRY__ID:
				return getId();
			case InfoPackage.STACK_TRACE_ENTRY__STACK_TRACE:
				return getStackTrace();
			case InfoPackage.STACK_TRACE_ENTRY__THREAD_NAME:
				return getThreadName();
			case InfoPackage.STACK_TRACE_ENTRY__THREAD_CLASS:
				return getThreadClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InfoPackage.STACK_TRACE_ENTRY__ID:
				setId((String)newValue);
				return;
			case InfoPackage.STACK_TRACE_ENTRY__STACK_TRACE:
				getStackTrace().clear();
				getStackTrace().addAll((Collection<? extends String>)newValue);
				return;
			case InfoPackage.STACK_TRACE_ENTRY__THREAD_NAME:
				setThreadName((String)newValue);
				return;
			case InfoPackage.STACK_TRACE_ENTRY__THREAD_CLASS:
				setThreadClass((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case InfoPackage.STACK_TRACE_ENTRY__ID:
				setId(ID_EDEFAULT);
				return;
			case InfoPackage.STACK_TRACE_ENTRY__STACK_TRACE:
				getStackTrace().clear();
				return;
			case InfoPackage.STACK_TRACE_ENTRY__THREAD_NAME:
				setThreadName(THREAD_NAME_EDEFAULT);
				return;
			case InfoPackage.STACK_TRACE_ENTRY__THREAD_CLASS:
				setThreadClass(THREAD_CLASS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case InfoPackage.STACK_TRACE_ENTRY__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case InfoPackage.STACK_TRACE_ENTRY__STACK_TRACE:
				return stackTrace != null && !stackTrace.isEmpty();
			case InfoPackage.STACK_TRACE_ENTRY__THREAD_NAME:
				return THREAD_NAME_EDEFAULT == null ? threadName != null : !THREAD_NAME_EDEFAULT.equals(threadName);
			case InfoPackage.STACK_TRACE_ENTRY__THREAD_CLASS:
				return THREAD_CLASS_EDEFAULT == null ? threadClass != null : !THREAD_CLASS_EDEFAULT.equals(threadClass);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", stackTrace: ");
		result.append(stackTrace);
		result.append(", threadName: ");
		result.append(threadName);
		result.append(", threadClass: ");
		result.append(threadClass);
		result.append(')');
		return result.toString();
	}

} // StackTraceEntryImpl
