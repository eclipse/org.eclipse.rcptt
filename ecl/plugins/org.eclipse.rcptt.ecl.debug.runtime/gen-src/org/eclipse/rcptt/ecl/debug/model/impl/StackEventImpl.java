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
package org.eclipse.rcptt.ecl.debug.model.impl;

import java.util.Collection;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.rcptt.ecl.debug.model.ModelPackage;
import org.eclipse.rcptt.ecl.debug.model.StackEvent;
import org.eclipse.rcptt.ecl.debug.model.StackFrame;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stack Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.impl.StackEventImpl#getLine <em>Line</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.impl.StackEventImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.impl.StackEventImpl#getStackFrame <em>Stack Frame</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StackEventImpl extends EventImpl implements StackEvent {
	/**
	 * The default value of the '{@link #getLine() <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine()
	 * @generated
	 * @ordered
	 */
	protected static final String LINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLine() <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine()
	 * @generated
	 * @ordered
	 */
	protected String line = LINE_EDEFAULT;

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
	 * The cached value of the '{@link #getStackFrame() <em>Stack Frame</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStackFrame()
	 * @generated
	 * @ordered
	 */
	protected EList<StackFrame> stackFrame;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StackEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.STACK_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLine() {
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLine(String newLine) {
		String oldLine = line;
		line = newLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STACK_EVENT__LINE, oldLine, line));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STACK_EVENT__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StackFrame> getStackFrame() {
		if (stackFrame == null) {
			stackFrame = new EObjectResolvingEList<StackFrame>(StackFrame.class, this, ModelPackage.STACK_EVENT__STACK_FRAME);
		}
		return stackFrame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.STACK_EVENT__LINE:
				return getLine();
			case ModelPackage.STACK_EVENT__PATH:
				return getPath();
			case ModelPackage.STACK_EVENT__STACK_FRAME:
				return getStackFrame();
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
			case ModelPackage.STACK_EVENT__LINE:
				setLine((String)newValue);
				return;
			case ModelPackage.STACK_EVENT__PATH:
				setPath((String)newValue);
				return;
			case ModelPackage.STACK_EVENT__STACK_FRAME:
				getStackFrame().clear();
				getStackFrame().addAll((Collection<? extends StackFrame>)newValue);
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
			case ModelPackage.STACK_EVENT__LINE:
				setLine(LINE_EDEFAULT);
				return;
			case ModelPackage.STACK_EVENT__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case ModelPackage.STACK_EVENT__STACK_FRAME:
				getStackFrame().clear();
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
			case ModelPackage.STACK_EVENT__LINE:
				return LINE_EDEFAULT == null ? line != null : !LINE_EDEFAULT.equals(line);
			case ModelPackage.STACK_EVENT__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case ModelPackage.STACK_EVENT__STACK_FRAME:
				return stackFrame != null && !stackFrame.isEmpty();
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
		result.append(" (line: ");
		result.append(line);
		result.append(", path: ");
		result.append(path);
		result.append(')');
		return result.toString();
	}

} //StackEventImpl
