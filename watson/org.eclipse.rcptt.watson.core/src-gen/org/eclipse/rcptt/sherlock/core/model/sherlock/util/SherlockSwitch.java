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
package org.eclipse.rcptt.sherlock.core.model.sherlock.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.sherlock.core.model.sherlock.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockPackage
 * @generated
 */
public class SherlockSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SherlockPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SherlockSwitch() {
		if (modelPackage == null) {
			modelPackage = SherlockPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SherlockPackage.SYSTEM_INFO: {
				SystemInfo systemInfo = (SystemInfo)theEObject;
				T result = caseSystemInfo(systemInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SherlockPackage.SYSTEM_VARIABLE: {
				SystemVariable systemVariable = (SystemVariable)theEObject;
				T result = caseSystemVariable(systemVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SherlockPackage.JAVA_INFO: {
				JavaInfo javaInfo = (JavaInfo)theEObject;
				T result = caseJavaInfo(javaInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SherlockPackage.JAVA_PROPERTY: {
				JavaProperty javaProperty = (JavaProperty)theEObject;
				T result = caseJavaProperty(javaProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SherlockPackage.ECLIPSE_INFO: {
				EclipseInfo eclipseInfo = (EclipseInfo)theEObject;
				T result = caseEclipseInfo(eclipseInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SherlockPackage.ECLIPSE_PLUGIN: {
				EclipsePlugin eclipsePlugin = (EclipsePlugin)theEObject;
				T result = caseEclipsePlugin(eclipsePlugin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SherlockPackage.ECLIPSE_FEATURE: {
				EclipseFeature eclipseFeature = (EclipseFeature)theEObject;
				T result = caseEclipseFeature(eclipseFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SherlockPackage.JAVA_EXCEPTION: {
				JavaException javaException = (JavaException)theEObject;
				T result = caseJavaException(javaException);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SherlockPackage.JAVA_STACK_TRACE_ENTRY: {
				JavaStackTraceEntry javaStackTraceEntry = (JavaStackTraceEntry)theEObject;
				T result = caseJavaStackTraceEntry(javaStackTraceEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SherlockPackage.ECLIPSE_STATUS: {
				EclipseStatus eclipseStatus = (EclipseStatus)theEObject;
				T result = caseEclipseStatus(eclipseStatus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SherlockPackage.ECLIPSE_PREFERENCE: {
				EclipsePreference eclipsePreference = (EclipsePreference)theEObject;
				T result = caseEclipsePreference(eclipsePreference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemInfo(SystemInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemVariable(SystemVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaInfo(JavaInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaProperty(JavaProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eclipse Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eclipse Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclipseInfo(EclipseInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eclipse Plugin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eclipse Plugin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclipsePlugin(EclipsePlugin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eclipse Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eclipse Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclipseFeature(EclipseFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Exception</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Exception</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaException(JavaException object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Stack Trace Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Stack Trace Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaStackTraceEntry(JavaStackTraceEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eclipse Status</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eclipse Status</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclipseStatus(EclipseStatus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eclipse Preference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eclipse Preference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclipsePreference(EclipsePreference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //SherlockSwitch
