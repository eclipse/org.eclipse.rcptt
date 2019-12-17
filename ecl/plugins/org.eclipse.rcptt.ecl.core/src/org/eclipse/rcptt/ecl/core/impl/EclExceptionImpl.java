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
package org.eclipse.rcptt.ecl.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.ecl.core.EclException;
import org.eclipse.rcptt.ecl.core.EclStackTraceEntry;
import org.eclipse.rcptt.ecl.core.ProcessStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ecl Exception</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.EclExceptionImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.EclExceptionImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.EclExceptionImpl#getStackTrace <em>Stack Trace</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.EclExceptionImpl#getThrowable <em>Throwable</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.EclExceptionImpl#getCause <em>Cause</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.EclExceptionImpl#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EclExceptionImpl extends EObjectImpl implements EclException {
	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStackTrace() <em>Stack Trace</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStackTrace()
	 * @generated
	 * @ordered
	 */
	protected EList<EclStackTraceEntry> stackTrace;

	/**
	 * The default value of the '{@link #getThrowable() <em>Throwable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrowable()
	 * @generated
	 * @ordered
	 */
	protected static final Throwable THROWABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThrowable() <em>Throwable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrowable()
	 * @generated
	 * @ordered
	 */
	protected Throwable throwable = THROWABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCause() <em>Cause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCause()
	 * @generated
	 * @ordered
	 */
	protected EclException cause;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected ProcessStatus status;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EclExceptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.ECL_EXCEPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ECL_EXCEPTION__CLASS_NAME, oldClassName, className));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ECL_EXCEPTION__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EclStackTraceEntry> getStackTrace() {
		if (stackTrace == null) {
			stackTrace = new EObjectContainmentEList<EclStackTraceEntry>(EclStackTraceEntry.class, this, CorePackage.ECL_EXCEPTION__STACK_TRACE);
		}
		return stackTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Throwable getThrowable() {
		return throwable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThrowable(Throwable newThrowable) {
		Throwable oldThrowable = throwable;
		throwable = newThrowable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ECL_EXCEPTION__THROWABLE, oldThrowable, throwable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EclException getCause() {
		return cause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCause(EclException newCause, NotificationChain msgs) {
		EclException oldCause = cause;
		cause = newCause;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.ECL_EXCEPTION__CAUSE, oldCause, newCause);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCause(EclException newCause) {
		if (newCause != cause) {
			NotificationChain msgs = null;
			if (cause != null)
				msgs = ((InternalEObject)cause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.ECL_EXCEPTION__CAUSE, null, msgs);
			if (newCause != null)
				msgs = ((InternalEObject)newCause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.ECL_EXCEPTION__CAUSE, null, msgs);
			msgs = basicSetCause(newCause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ECL_EXCEPTION__CAUSE, newCause, newCause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStatus(ProcessStatus newStatus, NotificationChain msgs) {
		ProcessStatus oldStatus = status;
		status = newStatus;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.ECL_EXCEPTION__STATUS, oldStatus, newStatus);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(ProcessStatus newStatus) {
		if (newStatus != status) {
			NotificationChain msgs = null;
			if (status != null)
				msgs = ((InternalEObject)status).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.ECL_EXCEPTION__STATUS, null, msgs);
			if (newStatus != null)
				msgs = ((InternalEObject)newStatus).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.ECL_EXCEPTION__STATUS, null, msgs);
			msgs = basicSetStatus(newStatus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ECL_EXCEPTION__STATUS, newStatus, newStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.ECL_EXCEPTION__STACK_TRACE:
				return ((InternalEList<?>)getStackTrace()).basicRemove(otherEnd, msgs);
			case CorePackage.ECL_EXCEPTION__CAUSE:
				return basicSetCause(null, msgs);
			case CorePackage.ECL_EXCEPTION__STATUS:
				return basicSetStatus(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.ECL_EXCEPTION__CLASS_NAME:
				return getClassName();
			case CorePackage.ECL_EXCEPTION__MESSAGE:
				return getMessage();
			case CorePackage.ECL_EXCEPTION__STACK_TRACE:
				return getStackTrace();
			case CorePackage.ECL_EXCEPTION__THROWABLE:
				return getThrowable();
			case CorePackage.ECL_EXCEPTION__CAUSE:
				return getCause();
			case CorePackage.ECL_EXCEPTION__STATUS:
				return getStatus();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.ECL_EXCEPTION__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case CorePackage.ECL_EXCEPTION__MESSAGE:
				setMessage((String)newValue);
				return;
			case CorePackage.ECL_EXCEPTION__STACK_TRACE:
				getStackTrace().clear();
				getStackTrace().addAll((Collection<? extends EclStackTraceEntry>)newValue);
				return;
			case CorePackage.ECL_EXCEPTION__THROWABLE:
				setThrowable((Throwable)newValue);
				return;
			case CorePackage.ECL_EXCEPTION__CAUSE:
				setCause((EclException)newValue);
				return;
			case CorePackage.ECL_EXCEPTION__STATUS:
				setStatus((ProcessStatus)newValue);
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
			case CorePackage.ECL_EXCEPTION__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case CorePackage.ECL_EXCEPTION__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case CorePackage.ECL_EXCEPTION__STACK_TRACE:
				getStackTrace().clear();
				return;
			case CorePackage.ECL_EXCEPTION__THROWABLE:
				setThrowable(THROWABLE_EDEFAULT);
				return;
			case CorePackage.ECL_EXCEPTION__CAUSE:
				setCause((EclException)null);
				return;
			case CorePackage.ECL_EXCEPTION__STATUS:
				setStatus((ProcessStatus)null);
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
			case CorePackage.ECL_EXCEPTION__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case CorePackage.ECL_EXCEPTION__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case CorePackage.ECL_EXCEPTION__STACK_TRACE:
				return stackTrace != null && !stackTrace.isEmpty();
			case CorePackage.ECL_EXCEPTION__THROWABLE:
				return THROWABLE_EDEFAULT == null ? throwable != null : !THROWABLE_EDEFAULT.equals(throwable);
			case CorePackage.ECL_EXCEPTION__CAUSE:
				return cause != null;
			case CorePackage.ECL_EXCEPTION__STATUS:
				return status != null;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (className: ");
		result.append(className);
		result.append(", message: ");
		result.append(message);
		result.append(", throwable: ");
		result.append(throwable);
		result.append(')');
		return result.toString();
	}

} //EclExceptionImpl
