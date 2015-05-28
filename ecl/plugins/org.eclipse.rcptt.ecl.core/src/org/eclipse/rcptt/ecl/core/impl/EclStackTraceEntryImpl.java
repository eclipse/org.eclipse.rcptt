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
package org.eclipse.rcptt.ecl.core.impl;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.ecl.core.EclStackTraceEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ecl Stack Trace Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.EclStackTraceEntryImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.EclStackTraceEntryImpl#getDeclaringClass <em>Declaring Class</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.EclStackTraceEntryImpl#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.EclStackTraceEntryImpl#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.EclStackTraceEntryImpl#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.core.impl.EclStackTraceEntryImpl#isNativeMethod <em>Native Method</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EclStackTraceEntryImpl extends EObjectImpl implements EclStackTraceEntry {
	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getDeclaringClass() <em>Declaring Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaringClass()
	 * @generated
	 * @ordered
	 */
	protected static final String DECLARING_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDeclaringClass() <em>Declaring Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaringClass()
	 * @generated
	 * @ordered
	 */
	protected String declaringClass = DECLARING_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodName()
	 * @generated
	 * @ordered
	 */
	protected static final String METHOD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodName()
	 * @generated
	 * @ordered
	 */
	protected String methodName = METHOD_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected String fileName = FILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected int lineNumber = LINE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #isNativeMethod() <em>Native Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNativeMethod()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NATIVE_METHOD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNativeMethod() <em>Native Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNativeMethod()
	 * @generated
	 * @ordered
	 */
	protected boolean nativeMethod = NATIVE_METHOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EclStackTraceEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.ECL_STACK_TRACE_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(int newIndex) {
		int oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ECL_STACK_TRACE_ENTRY__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDeclaringClass() {
		return declaringClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaringClass(String newDeclaringClass) {
		String oldDeclaringClass = declaringClass;
		declaringClass = newDeclaringClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ECL_STACK_TRACE_ENTRY__DECLARING_CLASS, oldDeclaringClass, declaringClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodName(String newMethodName) {
		String oldMethodName = methodName;
		methodName = newMethodName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ECL_STACK_TRACE_ENTRY__METHOD_NAME, oldMethodName, methodName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileName(String newFileName) {
		String oldFileName = fileName;
		fileName = newFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ECL_STACK_TRACE_ENTRY__FILE_NAME, oldFileName, fileName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineNumber(int newLineNumber) {
		int oldLineNumber = lineNumber;
		lineNumber = newLineNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ECL_STACK_TRACE_ENTRY__LINE_NUMBER, oldLineNumber, lineNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNativeMethod() {
		return nativeMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNativeMethod(boolean newNativeMethod) {
		boolean oldNativeMethod = nativeMethod;
		nativeMethod = newNativeMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ECL_STACK_TRACE_ENTRY__NATIVE_METHOD, oldNativeMethod, nativeMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.ECL_STACK_TRACE_ENTRY__INDEX:
				return getIndex();
			case CorePackage.ECL_STACK_TRACE_ENTRY__DECLARING_CLASS:
				return getDeclaringClass();
			case CorePackage.ECL_STACK_TRACE_ENTRY__METHOD_NAME:
				return getMethodName();
			case CorePackage.ECL_STACK_TRACE_ENTRY__FILE_NAME:
				return getFileName();
			case CorePackage.ECL_STACK_TRACE_ENTRY__LINE_NUMBER:
				return getLineNumber();
			case CorePackage.ECL_STACK_TRACE_ENTRY__NATIVE_METHOD:
				return isNativeMethod();
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
			case CorePackage.ECL_STACK_TRACE_ENTRY__INDEX:
				setIndex((Integer)newValue);
				return;
			case CorePackage.ECL_STACK_TRACE_ENTRY__DECLARING_CLASS:
				setDeclaringClass((String)newValue);
				return;
			case CorePackage.ECL_STACK_TRACE_ENTRY__METHOD_NAME:
				setMethodName((String)newValue);
				return;
			case CorePackage.ECL_STACK_TRACE_ENTRY__FILE_NAME:
				setFileName((String)newValue);
				return;
			case CorePackage.ECL_STACK_TRACE_ENTRY__LINE_NUMBER:
				setLineNumber((Integer)newValue);
				return;
			case CorePackage.ECL_STACK_TRACE_ENTRY__NATIVE_METHOD:
				setNativeMethod((Boolean)newValue);
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
			case CorePackage.ECL_STACK_TRACE_ENTRY__INDEX:
				setIndex(INDEX_EDEFAULT);
				return;
			case CorePackage.ECL_STACK_TRACE_ENTRY__DECLARING_CLASS:
				setDeclaringClass(DECLARING_CLASS_EDEFAULT);
				return;
			case CorePackage.ECL_STACK_TRACE_ENTRY__METHOD_NAME:
				setMethodName(METHOD_NAME_EDEFAULT);
				return;
			case CorePackage.ECL_STACK_TRACE_ENTRY__FILE_NAME:
				setFileName(FILE_NAME_EDEFAULT);
				return;
			case CorePackage.ECL_STACK_TRACE_ENTRY__LINE_NUMBER:
				setLineNumber(LINE_NUMBER_EDEFAULT);
				return;
			case CorePackage.ECL_STACK_TRACE_ENTRY__NATIVE_METHOD:
				setNativeMethod(NATIVE_METHOD_EDEFAULT);
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
			case CorePackage.ECL_STACK_TRACE_ENTRY__INDEX:
				return index != INDEX_EDEFAULT;
			case CorePackage.ECL_STACK_TRACE_ENTRY__DECLARING_CLASS:
				return DECLARING_CLASS_EDEFAULT == null ? declaringClass != null : !DECLARING_CLASS_EDEFAULT.equals(declaringClass);
			case CorePackage.ECL_STACK_TRACE_ENTRY__METHOD_NAME:
				return METHOD_NAME_EDEFAULT == null ? methodName != null : !METHOD_NAME_EDEFAULT.equals(methodName);
			case CorePackage.ECL_STACK_TRACE_ENTRY__FILE_NAME:
				return FILE_NAME_EDEFAULT == null ? fileName != null : !FILE_NAME_EDEFAULT.equals(fileName);
			case CorePackage.ECL_STACK_TRACE_ENTRY__LINE_NUMBER:
				return lineNumber != LINE_NUMBER_EDEFAULT;
			case CorePackage.ECL_STACK_TRACE_ENTRY__NATIVE_METHOD:
				return nativeMethod != NATIVE_METHOD_EDEFAULT;
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
		result.append(" (index: ");
		result.append(index);
		result.append(", declaringClass: ");
		result.append(declaringClass);
		result.append(", methodName: ");
		result.append(methodName);
		result.append(", fileName: ");
		result.append(fileName);
		result.append(", lineNumber: ");
		result.append(lineNumber);
		result.append(", nativeMethod: ");
		result.append(nativeMethod);
		result.append(')');
		return result.toString();
	}

} //EclStackTraceEntryImpl
