/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
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

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.rcptt.ecl.core.impl.CommandImpl;
import org.eclipse.rcptt.ecl.interop.ExecProcess;
import org.eclipse.rcptt.ecl.interop.InteropPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exec Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.impl.ExecProcessImpl#getCommand <em>Command</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.impl.ExecProcessImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.impl.ExecProcessImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.impl.ExecProcessImpl#isIgnoreExitCode <em>Ignore Exit Code</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.impl.ExecProcessImpl#isIgnoreStderr <em>Ignore Stderr</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.impl.ExecProcessImpl#getStdin <em>Stdin</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExecProcessImpl extends CommandImpl implements ExecProcess {
	/**
	 * The default value of the '{@link #getCommand() <em>Command</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommand() <em>Command</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	protected String command = COMMAND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArgs() <em>Args</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgs()
	 * @generated
	 * @ordered
	 */
	protected EList<String> args;

	/**
	 * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final int TIMEOUT_EDEFAULT = 60;

	/**
	 * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected int timeout = TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #isIgnoreExitCode() <em>Ignore Exit Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIgnoreExitCode()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IGNORE_EXIT_CODE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIgnoreExitCode() <em>Ignore Exit Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIgnoreExitCode()
	 * @generated
	 * @ordered
	 */
	protected boolean ignoreExitCode = IGNORE_EXIT_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIgnoreStderr() <em>Ignore Stderr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIgnoreStderr()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IGNORE_STDERR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIgnoreStderr() <em>Ignore Stderr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIgnoreStderr()
	 * @generated
	 * @ordered
	 */
	protected boolean ignoreStderr = IGNORE_STDERR_EDEFAULT;

	/**
	 * The default value of the '{@link #getStdin() <em>Stdin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStdin()
	 * @generated
	 * @ordered
	 */
	protected static final String STDIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStdin() <em>Stdin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStdin()
	 * @generated
	 * @ordered
	 */
	protected String stdin = STDIN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InteropPackage.Literals.EXEC_PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommand(String newCommand) {
		String oldCommand = command;
		command = newCommand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InteropPackage.EXEC_PROCESS__COMMAND, oldCommand, command));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getArgs() {
		if (args == null) {
			args = new EDataTypeUniqueEList<String>(String.class, this, InteropPackage.EXEC_PROCESS__ARGS);
		}
		return args;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeout(int newTimeout) {
		int oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InteropPackage.EXEC_PROCESS__TIMEOUT, oldTimeout, timeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIgnoreExitCode() {
		return ignoreExitCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIgnoreExitCode(boolean newIgnoreExitCode) {
		boolean oldIgnoreExitCode = ignoreExitCode;
		ignoreExitCode = newIgnoreExitCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InteropPackage.EXEC_PROCESS__IGNORE_EXIT_CODE, oldIgnoreExitCode, ignoreExitCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIgnoreStderr() {
		return ignoreStderr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIgnoreStderr(boolean newIgnoreStderr) {
		boolean oldIgnoreStderr = ignoreStderr;
		ignoreStderr = newIgnoreStderr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InteropPackage.EXEC_PROCESS__IGNORE_STDERR, oldIgnoreStderr, ignoreStderr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStdin() {
		return stdin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStdin(String newStdin) {
		String oldStdin = stdin;
		stdin = newStdin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InteropPackage.EXEC_PROCESS__STDIN, oldStdin, stdin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InteropPackage.EXEC_PROCESS__COMMAND:
				return getCommand();
			case InteropPackage.EXEC_PROCESS__ARGS:
				return getArgs();
			case InteropPackage.EXEC_PROCESS__TIMEOUT:
				return getTimeout();
			case InteropPackage.EXEC_PROCESS__IGNORE_EXIT_CODE:
				return isIgnoreExitCode();
			case InteropPackage.EXEC_PROCESS__IGNORE_STDERR:
				return isIgnoreStderr();
			case InteropPackage.EXEC_PROCESS__STDIN:
				return getStdin();
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
			case InteropPackage.EXEC_PROCESS__COMMAND:
				setCommand((String)newValue);
				return;
			case InteropPackage.EXEC_PROCESS__ARGS:
				getArgs().clear();
				getArgs().addAll((Collection<? extends String>)newValue);
				return;
			case InteropPackage.EXEC_PROCESS__TIMEOUT:
				setTimeout((Integer)newValue);
				return;
			case InteropPackage.EXEC_PROCESS__IGNORE_EXIT_CODE:
				setIgnoreExitCode((Boolean)newValue);
				return;
			case InteropPackage.EXEC_PROCESS__IGNORE_STDERR:
				setIgnoreStderr((Boolean)newValue);
				return;
			case InteropPackage.EXEC_PROCESS__STDIN:
				setStdin((String)newValue);
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
			case InteropPackage.EXEC_PROCESS__COMMAND:
				setCommand(COMMAND_EDEFAULT);
				return;
			case InteropPackage.EXEC_PROCESS__ARGS:
				getArgs().clear();
				return;
			case InteropPackage.EXEC_PROCESS__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case InteropPackage.EXEC_PROCESS__IGNORE_EXIT_CODE:
				setIgnoreExitCode(IGNORE_EXIT_CODE_EDEFAULT);
				return;
			case InteropPackage.EXEC_PROCESS__IGNORE_STDERR:
				setIgnoreStderr(IGNORE_STDERR_EDEFAULT);
				return;
			case InteropPackage.EXEC_PROCESS__STDIN:
				setStdin(STDIN_EDEFAULT);
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
			case InteropPackage.EXEC_PROCESS__COMMAND:
				return COMMAND_EDEFAULT == null ? command != null : !COMMAND_EDEFAULT.equals(command);
			case InteropPackage.EXEC_PROCESS__ARGS:
				return args != null && !args.isEmpty();
			case InteropPackage.EXEC_PROCESS__TIMEOUT:
				return timeout != TIMEOUT_EDEFAULT;
			case InteropPackage.EXEC_PROCESS__IGNORE_EXIT_CODE:
				return ignoreExitCode != IGNORE_EXIT_CODE_EDEFAULT;
			case InteropPackage.EXEC_PROCESS__IGNORE_STDERR:
				return ignoreStderr != IGNORE_STDERR_EDEFAULT;
			case InteropPackage.EXEC_PROCESS__STDIN:
				return STDIN_EDEFAULT == null ? stdin != null : !STDIN_EDEFAULT.equals(stdin);
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
		result.append(" (command: ");
		result.append(command);
		result.append(", args: ");
		result.append(args);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(", ignoreExitCode: ");
		result.append(ignoreExitCode);
		result.append(", ignoreStderr: ");
		result.append(ignoreStderr);
		result.append(", stdin: ");
		result.append(stdin);
		result.append(')');
		return result.toString();
	}

} //ExecProcessImpl
