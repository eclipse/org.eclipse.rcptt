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
package org.eclipse.rcptt.testing.commands.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.rcptt.ecl.core.impl.CommandImpl;
import org.eclipse.rcptt.launching.injection.Entry;
import org.eclipse.rcptt.testing.commands.CommandsPackage;
import org.eclipse.rcptt.testing.commands.InvokeAUT;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invoke AUT</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.testing.commands.impl.InvokeAUTImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testing.commands.impl.InvokeAUTImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testing.commands.impl.InvokeAUTImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testing.commands.impl.InvokeAUTImpl#getVmargs <em>Vmargs</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testing.commands.impl.InvokeAUTImpl#getInject <em>Inject</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvokeAUTImpl extends CommandImpl implements InvokeAUT {
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
	 * The default value of the '{@link #getArgs() <em>Args</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
	protected static final String ARGS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArgs() <em>Args</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
	protected String args = ARGS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getVmargs() <em>Vmargs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVmargs()
	 * @generated
	 * @ordered
	 */
	protected static final String VMARGS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVmargs() <em>Vmargs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVmargs()
	 * @generated
	 * @ordered
	 */
	protected String vmargs = VMARGS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInject() <em>Inject</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInject()
	 * @generated
	 * @ordered
	 */
	protected EList<Entry> inject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvokeAUTImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommandsPackage.Literals.INVOKE_AUT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommandsPackage.INVOKE_AUT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArgs() {
		return args;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgs(String newArgs) {
		String oldArgs = args;
		args = newArgs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandsPackage.INVOKE_AUT__ARGS, oldArgs, args));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandsPackage.INVOKE_AUT__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVmargs() {
		return vmargs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVmargs(String newVmargs) {
		String oldVmargs = vmargs;
		vmargs = newVmargs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandsPackage.INVOKE_AUT__VMARGS, oldVmargs, vmargs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Entry> getInject() {
		if (inject == null) {
			inject = new EObjectContainmentEList<Entry>(Entry.class, this, CommandsPackage.INVOKE_AUT__INJECT);
		}
		return inject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommandsPackage.INVOKE_AUT__INJECT:
				return ((InternalEList<?>)getInject()).basicRemove(otherEnd, msgs);
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
			case CommandsPackage.INVOKE_AUT__NAME:
				return getName();
			case CommandsPackage.INVOKE_AUT__ARGS:
				return getArgs();
			case CommandsPackage.INVOKE_AUT__PATH:
				return getPath();
			case CommandsPackage.INVOKE_AUT__VMARGS:
				return getVmargs();
			case CommandsPackage.INVOKE_AUT__INJECT:
				return getInject();
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
			case CommandsPackage.INVOKE_AUT__NAME:
				setName((String)newValue);
				return;
			case CommandsPackage.INVOKE_AUT__ARGS:
				setArgs((String)newValue);
				return;
			case CommandsPackage.INVOKE_AUT__PATH:
				setPath((String)newValue);
				return;
			case CommandsPackage.INVOKE_AUT__VMARGS:
				setVmargs((String)newValue);
				return;
			case CommandsPackage.INVOKE_AUT__INJECT:
				getInject().clear();
				getInject().addAll((Collection<? extends Entry>)newValue);
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
			case CommandsPackage.INVOKE_AUT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CommandsPackage.INVOKE_AUT__ARGS:
				setArgs(ARGS_EDEFAULT);
				return;
			case CommandsPackage.INVOKE_AUT__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case CommandsPackage.INVOKE_AUT__VMARGS:
				setVmargs(VMARGS_EDEFAULT);
				return;
			case CommandsPackage.INVOKE_AUT__INJECT:
				getInject().clear();
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
			case CommandsPackage.INVOKE_AUT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CommandsPackage.INVOKE_AUT__ARGS:
				return ARGS_EDEFAULT == null ? args != null : !ARGS_EDEFAULT.equals(args);
			case CommandsPackage.INVOKE_AUT__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case CommandsPackage.INVOKE_AUT__VMARGS:
				return VMARGS_EDEFAULT == null ? vmargs != null : !VMARGS_EDEFAULT.equals(vmargs);
			case CommandsPackage.INVOKE_AUT__INJECT:
				return inject != null && !inject.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", args: ");
		result.append(args);
		result.append(", path: ");
		result.append(path);
		result.append(", vmargs: ");
		result.append(vmargs);
		result.append(')');
		return result.toString();
	}

} //InvokeAUTImpl
