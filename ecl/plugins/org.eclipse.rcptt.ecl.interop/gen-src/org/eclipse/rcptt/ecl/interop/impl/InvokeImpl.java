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
package org.eclipse.rcptt.ecl.interop.impl;

import java.util.Collection;



import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.rcptt.ecl.core.impl.CommandImpl;
import org.eclipse.rcptt.ecl.interop.InteropPackage;
import org.eclipse.rcptt.ecl.interop.Invoke;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invoke</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.impl.InvokeImpl#getObject <em>Object</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.impl.InvokeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.impl.InvokeImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.impl.InvokeImpl#isNoResult <em>No Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InvokeImpl extends CommandImpl implements Invoke {
	/**
	 * The default value of the '{@link #getObject() <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected static final Object OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected Object object = OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArgs() <em>Args</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> args;

	/**
	 * The default value of the '{@link #isNoResult() <em>No Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoResult()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_RESULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoResult() <em>No Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoResult()
	 * @generated
	 * @ordered
	 */
	protected boolean noResult = NO_RESULT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvokeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteropPackage.Literals.INVOKE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObject(Object newObject) {
		Object oldObject = object;
		object = newObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InteropPackage.INVOKE__OBJECT, oldObject, object));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InteropPackage.INVOKE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getArgs() {
		if (args == null) {
			args = new EDataTypeEList<Object>(Object.class, this, InteropPackage.INVOKE__ARGS);
		}
		return args;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNoResult() {
		return noResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoResult(boolean newNoResult) {
		boolean oldNoResult = noResult;
		noResult = newNoResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InteropPackage.INVOKE__NO_RESULT, oldNoResult, noResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InteropPackage.INVOKE__OBJECT:
				return getObject();
			case InteropPackage.INVOKE__NAME:
				return getName();
			case InteropPackage.INVOKE__ARGS:
				return getArgs();
			case InteropPackage.INVOKE__NO_RESULT:
				return isNoResult();
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
			case InteropPackage.INVOKE__OBJECT:
				setObject(newValue);
				return;
			case InteropPackage.INVOKE__NAME:
				setName((String)newValue);
				return;
			case InteropPackage.INVOKE__ARGS:
				getArgs().clear();
				getArgs().addAll((Collection<? extends Object>)newValue);
				return;
			case InteropPackage.INVOKE__NO_RESULT:
				setNoResult((Boolean)newValue);
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
			case InteropPackage.INVOKE__OBJECT:
				setObject(OBJECT_EDEFAULT);
				return;
			case InteropPackage.INVOKE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case InteropPackage.INVOKE__ARGS:
				getArgs().clear();
				return;
			case InteropPackage.INVOKE__NO_RESULT:
				setNoResult(NO_RESULT_EDEFAULT);
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
			case InteropPackage.INVOKE__OBJECT:
				return OBJECT_EDEFAULT == null ? object != null : !OBJECT_EDEFAULT.equals(object);
			case InteropPackage.INVOKE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case InteropPackage.INVOKE__ARGS:
				return args != null && !args.isEmpty();
			case InteropPackage.INVOKE__NO_RESULT:
				return noResult != NO_RESULT_EDEFAULT;
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
		result.append(" (object: ");
		result.append(object);
		result.append(", name: ");
		result.append(name);
		result.append(", args: ");
		result.append(args);
		result.append(", noResult: ");
		result.append(noResult);
		result.append(')');
		return result.toString();
	}

} //InvokeImpl
