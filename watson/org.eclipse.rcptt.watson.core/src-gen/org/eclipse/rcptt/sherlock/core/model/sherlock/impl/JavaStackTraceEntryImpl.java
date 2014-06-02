/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.sherlock.core.model.sherlock.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.rcptt.sherlock.core.model.sherlock.JavaStackTraceEntry;
import org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Stack Trace Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaStackTraceEntryImpl#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaStackTraceEntryImpl#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaStackTraceEntryImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaStackTraceEntryImpl#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaStackTraceEntryImpl#isNativeMethod <em>Native Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaStackTraceEntryImpl extends EObjectImpl implements JavaStackTraceEntry {
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
	protected JavaStackTraceEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SherlockPackage.Literals.JAVA_STACK_TRACE_ENTRY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.JAVA_STACK_TRACE_ENTRY__FILE_NAME, oldFileName, fileName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.JAVA_STACK_TRACE_ENTRY__LINE_NUMBER, oldLineNumber, lineNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.JAVA_STACK_TRACE_ENTRY__CLASS_NAME, oldClassName, className));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.JAVA_STACK_TRACE_ENTRY__METHOD_NAME, oldMethodName, methodName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SherlockPackage.JAVA_STACK_TRACE_ENTRY__NATIVE_METHOD, oldNativeMethod, nativeMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__FILE_NAME:
				return getFileName();
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__LINE_NUMBER:
				return getLineNumber();
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__CLASS_NAME:
				return getClassName();
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__METHOD_NAME:
				return getMethodName();
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__NATIVE_METHOD:
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
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__FILE_NAME:
				setFileName((String)newValue);
				return;
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__LINE_NUMBER:
				setLineNumber((Integer)newValue);
				return;
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__METHOD_NAME:
				setMethodName((String)newValue);
				return;
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__NATIVE_METHOD:
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
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__FILE_NAME:
				setFileName(FILE_NAME_EDEFAULT);
				return;
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__LINE_NUMBER:
				setLineNumber(LINE_NUMBER_EDEFAULT);
				return;
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__METHOD_NAME:
				setMethodName(METHOD_NAME_EDEFAULT);
				return;
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__NATIVE_METHOD:
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
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__FILE_NAME:
				return FILE_NAME_EDEFAULT == null ? fileName != null : !FILE_NAME_EDEFAULT.equals(fileName);
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__LINE_NUMBER:
				return lineNumber != LINE_NUMBER_EDEFAULT;
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__METHOD_NAME:
				return METHOD_NAME_EDEFAULT == null ? methodName != null : !METHOD_NAME_EDEFAULT.equals(methodName);
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY__NATIVE_METHOD:
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
		result.append(" (fileName: ");
		result.append(fileName);
		result.append(", lineNumber: ");
		result.append(lineNumber);
		result.append(", className: ");
		result.append(className);
		result.append(", methodName: ");
		result.append(methodName);
		result.append(", nativeMethod: ");
		result.append(nativeMethod);
		result.append(')');
		return result.toString();
	}

} //JavaStackTraceEntryImpl
