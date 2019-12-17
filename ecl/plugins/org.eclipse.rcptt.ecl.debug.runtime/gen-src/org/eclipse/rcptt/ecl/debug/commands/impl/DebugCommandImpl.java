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
package org.eclipse.rcptt.ecl.debug.commands.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;



import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.impl.CommandImpl;
import org.eclipse.rcptt.ecl.debug.commands.CommandsPackage;
import org.eclipse.rcptt.ecl.debug.commands.DebugCommand;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Debug Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.commands.impl.DebugCommandImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.commands.impl.DebugCommandImpl#getSession <em>Session</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.commands.impl.DebugCommandImpl#getCommand <em>Command</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.commands.impl.DebugCommandImpl#getPaths <em>Paths</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DebugCommandImpl extends CommandImpl implements DebugCommand {
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
	 * The default value of the '{@link #getSession() <em>Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSession()
	 * @generated
	 * @ordered
	 */
	protected static final String SESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSession() <em>Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSession()
	 * @generated
	 * @ordered
	 */
	protected String session = SESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCommand() <em>Command</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	protected Command command;

	/**
	 * The cached value of the '{@link #getPaths() <em>Paths</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaths()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> paths;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DebugCommandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommandsPackage.Literals.DEBUG_COMMAND;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommandsPackage.DEBUG_COMMAND__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSession() {
		return session;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSession(String newSession) {
		String oldSession = session;
		session = newSession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandsPackage.DEBUG_COMMAND__SESSION, oldSession, session));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command getCommand() {
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCommand(Command newCommand, NotificationChain msgs) {
		Command oldCommand = command;
		command = newCommand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CommandsPackage.DEBUG_COMMAND__COMMAND, oldCommand, newCommand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommand(Command newCommand) {
		if (newCommand != command) {
			NotificationChain msgs = null;
			if (command != null)
				msgs = ((InternalEObject)command).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CommandsPackage.DEBUG_COMMAND__COMMAND, null, msgs);
			if (newCommand != null)
				msgs = ((InternalEObject)newCommand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CommandsPackage.DEBUG_COMMAND__COMMAND, null, msgs);
			msgs = basicSetCommand(newCommand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommandsPackage.DEBUG_COMMAND__COMMAND, newCommand, newCommand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<String, String> getPaths() {
		if (paths == null) {
			paths = new EcoreEMap<String,String>(CommandsPackage.Literals.PATHS_MAP, PathsMapImpl.class, this, CommandsPackage.DEBUG_COMMAND__PATHS);
		}
		return paths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CommandsPackage.DEBUG_COMMAND__COMMAND:
				return basicSetCommand(null, msgs);
			case CommandsPackage.DEBUG_COMMAND__PATHS:
				return ((InternalEList<?>)getPaths()).basicRemove(otherEnd, msgs);
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
			case CommandsPackage.DEBUG_COMMAND__PATH:
				return getPath();
			case CommandsPackage.DEBUG_COMMAND__SESSION:
				return getSession();
			case CommandsPackage.DEBUG_COMMAND__COMMAND:
				return getCommand();
			case CommandsPackage.DEBUG_COMMAND__PATHS:
				if (coreType) return getPaths();
				else return getPaths().map();
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
			case CommandsPackage.DEBUG_COMMAND__PATH:
				setPath((String)newValue);
				return;
			case CommandsPackage.DEBUG_COMMAND__SESSION:
				setSession((String)newValue);
				return;
			case CommandsPackage.DEBUG_COMMAND__COMMAND:
				setCommand((Command)newValue);
				return;
			case CommandsPackage.DEBUG_COMMAND__PATHS:
				((EStructuralFeature.Setting)getPaths()).set(newValue);
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
			case CommandsPackage.DEBUG_COMMAND__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case CommandsPackage.DEBUG_COMMAND__SESSION:
				setSession(SESSION_EDEFAULT);
				return;
			case CommandsPackage.DEBUG_COMMAND__COMMAND:
				setCommand((Command)null);
				return;
			case CommandsPackage.DEBUG_COMMAND__PATHS:
				getPaths().clear();
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
			case CommandsPackage.DEBUG_COMMAND__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case CommandsPackage.DEBUG_COMMAND__SESSION:
				return SESSION_EDEFAULT == null ? session != null : !SESSION_EDEFAULT.equals(session);
			case CommandsPackage.DEBUG_COMMAND__COMMAND:
				return command != null;
			case CommandsPackage.DEBUG_COMMAND__PATHS:
				return paths != null && !paths.isEmpty();
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
		result.append(" (path: ");
		result.append(path);
		result.append(", session: ");
		result.append(session);
		result.append(')');
		return result.toString();
	}

} //DebugCommandImpl
