/*******************************************************************************
 * Copyright (c) 2014, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.interop.impl;

import java.util.Collection;

import org.eclipse.rcptt.ecl.core.impl.CommandImpl;

import org.eclipse.rcptt.ecl.interop.InteropPackage;
import org.eclipse.rcptt.ecl.interop.InvokeStatic;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invoke Static</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.impl.InvokeStaticImpl#getPluginId <em>Plugin Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.impl.InvokeStaticImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.impl.InvokeStaticImpl#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.impl.InvokeStaticImpl#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InvokeStaticImpl extends CommandImpl implements InvokeStatic {
	/**
	 * The default value of the '{@link #getPluginId() <em>Plugin Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginId()
	 * @generated
	 * @ordered
	 */
	protected static final String PLUGIN_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPluginId() <em>Plugin Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginId()
	 * @generated
	 * @ordered
	 */
	protected String pluginId = PLUGIN_ID_EDEFAULT;

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
	 * The cached value of the '{@link #getArgs() <em>Args</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> args;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvokeStaticImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteropPackage.Literals.INVOKE_STATIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPluginId() {
		return pluginId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPluginId(String newPluginId) {
		String oldPluginId = pluginId;
		pluginId = newPluginId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InteropPackage.INVOKE_STATIC__PLUGIN_ID, oldPluginId, pluginId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, InteropPackage.INVOKE_STATIC__CLASS_NAME, oldClassName, className));
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
			eNotify(new ENotificationImpl(this, Notification.SET, InteropPackage.INVOKE_STATIC__METHOD_NAME, oldMethodName, methodName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getArgs() {
		if (args == null) {
			args = new EDataTypeEList<Object>(Object.class, this, InteropPackage.INVOKE_STATIC__ARGS);
		}
		return args;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InteropPackage.INVOKE_STATIC__PLUGIN_ID:
				return getPluginId();
			case InteropPackage.INVOKE_STATIC__CLASS_NAME:
				return getClassName();
			case InteropPackage.INVOKE_STATIC__METHOD_NAME:
				return getMethodName();
			case InteropPackage.INVOKE_STATIC__ARGS:
				return getArgs();
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
			case InteropPackage.INVOKE_STATIC__PLUGIN_ID:
				setPluginId((String)newValue);
				return;
			case InteropPackage.INVOKE_STATIC__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case InteropPackage.INVOKE_STATIC__METHOD_NAME:
				setMethodName((String)newValue);
				return;
			case InteropPackage.INVOKE_STATIC__ARGS:
				getArgs().clear();
				getArgs().addAll((Collection<? extends Object>)newValue);
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
			case InteropPackage.INVOKE_STATIC__PLUGIN_ID:
				setPluginId(PLUGIN_ID_EDEFAULT);
				return;
			case InteropPackage.INVOKE_STATIC__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case InteropPackage.INVOKE_STATIC__METHOD_NAME:
				setMethodName(METHOD_NAME_EDEFAULT);
				return;
			case InteropPackage.INVOKE_STATIC__ARGS:
				getArgs().clear();
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
			case InteropPackage.INVOKE_STATIC__PLUGIN_ID:
				return PLUGIN_ID_EDEFAULT == null ? pluginId != null : !PLUGIN_ID_EDEFAULT.equals(pluginId);
			case InteropPackage.INVOKE_STATIC__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case InteropPackage.INVOKE_STATIC__METHOD_NAME:
				return METHOD_NAME_EDEFAULT == null ? methodName != null : !METHOD_NAME_EDEFAULT.equals(methodName);
			case InteropPackage.INVOKE_STATIC__ARGS:
				return args != null && !args.isEmpty();
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
		result.append(" (pluginId: ");
		result.append(pluginId);
		result.append(", className: ");
		result.append(className);
		result.append(", methodName: ");
		result.append(methodName);
		result.append(", args: ");
		result.append(args);
		result.append(')');
		return result.toString();
	}

} //InvokeStaticImpl
