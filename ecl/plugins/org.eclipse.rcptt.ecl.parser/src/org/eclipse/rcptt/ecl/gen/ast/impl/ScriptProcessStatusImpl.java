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
package org.eclipse.rcptt.ecl.gen.ast.impl;




import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.rcptt.ecl.core.ProcessStatus;
import org.eclipse.rcptt.ecl.core.impl.ProcessStatusImpl;
import org.eclipse.rcptt.ecl.gen.ast.AstNode;
import org.eclipse.rcptt.ecl.gen.ast.AstPackage;
import org.eclipse.rcptt.ecl.gen.ast.ScriptProcessStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Process Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.gen.ast.impl.ScriptProcessStatusImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.gen.ast.impl.ScriptProcessStatusImpl#getLine <em>Line</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.gen.ast.impl.ScriptProcessStatusImpl#getLength <em>Length</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.gen.ast.impl.ScriptProcessStatusImpl#getResourceID <em>Resource ID</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.gen.ast.impl.ScriptProcessStatusImpl#getCause <em>Cause</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScriptProcessStatusImpl extends ProcessStatusImpl implements ScriptProcessStatus {
	/**
	 * The default value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected static final int COLUMN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected int column = COLUMN_EDEFAULT;

	/**
	 * The default value of the '{@link #getLine() <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLine() <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine()
	 * @generated
	 * @ordered
	 */
	protected int line = LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final int LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected int length = LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceID() <em>Resource ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceID()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceID() <em>Resource ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceID()
	 * @generated
	 * @ordered
	 */
	protected String resourceID = RESOURCE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCause() <em>Cause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCause()
	 * @generated
	 * @ordered
	 */
	protected ProcessStatus cause;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScriptProcessStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.SCRIPT_PROCESS_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumn(int newColumn) {
		int oldColumn = column;
		column = newColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.SCRIPT_PROCESS_STATUS__COLUMN, oldColumn, column));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLine() {
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLine(int newLine) {
		int oldLine = line;
		line = newLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.SCRIPT_PROCESS_STATUS__LINE, oldLine, line));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLength(int newLength) {
		int oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.SCRIPT_PROCESS_STATUS__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceID() {
		return resourceID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceID(String newResourceID) {
		String oldResourceID = resourceID;
		resourceID = newResourceID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.SCRIPT_PROCESS_STATUS__RESOURCE_ID, oldResourceID, resourceID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessStatus getCause() {
		return cause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCause(ProcessStatus newCause, NotificationChain msgs) {
		ProcessStatus oldCause = cause;
		cause = newCause;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.SCRIPT_PROCESS_STATUS__CAUSE, oldCause, newCause);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCause(ProcessStatus newCause) {
		if (newCause != cause) {
			NotificationChain msgs = null;
			if (cause != null)
				msgs = ((InternalEObject)cause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.SCRIPT_PROCESS_STATUS__CAUSE, null, msgs);
			if (newCause != null)
				msgs = ((InternalEObject)newCause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.SCRIPT_PROCESS_STATUS__CAUSE, null, msgs);
			msgs = basicSetCause(newCause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.SCRIPT_PROCESS_STATUS__CAUSE, newCause, newCause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.SCRIPT_PROCESS_STATUS__CAUSE:
				return basicSetCause(null, msgs);
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
			case AstPackage.SCRIPT_PROCESS_STATUS__COLUMN:
				return getColumn();
			case AstPackage.SCRIPT_PROCESS_STATUS__LINE:
				return getLine();
			case AstPackage.SCRIPT_PROCESS_STATUS__LENGTH:
				return getLength();
			case AstPackage.SCRIPT_PROCESS_STATUS__RESOURCE_ID:
				return getResourceID();
			case AstPackage.SCRIPT_PROCESS_STATUS__CAUSE:
				return getCause();
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
			case AstPackage.SCRIPT_PROCESS_STATUS__COLUMN:
				setColumn((Integer)newValue);
				return;
			case AstPackage.SCRIPT_PROCESS_STATUS__LINE:
				setLine((Integer)newValue);
				return;
			case AstPackage.SCRIPT_PROCESS_STATUS__LENGTH:
				setLength((Integer)newValue);
				return;
			case AstPackage.SCRIPT_PROCESS_STATUS__RESOURCE_ID:
				setResourceID((String)newValue);
				return;
			case AstPackage.SCRIPT_PROCESS_STATUS__CAUSE:
				setCause((ProcessStatus)newValue);
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
			case AstPackage.SCRIPT_PROCESS_STATUS__COLUMN:
				setColumn(COLUMN_EDEFAULT);
				return;
			case AstPackage.SCRIPT_PROCESS_STATUS__LINE:
				setLine(LINE_EDEFAULT);
				return;
			case AstPackage.SCRIPT_PROCESS_STATUS__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case AstPackage.SCRIPT_PROCESS_STATUS__RESOURCE_ID:
				setResourceID(RESOURCE_ID_EDEFAULT);
				return;
			case AstPackage.SCRIPT_PROCESS_STATUS__CAUSE:
				setCause((ProcessStatus)null);
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
			case AstPackage.SCRIPT_PROCESS_STATUS__COLUMN:
				return column != COLUMN_EDEFAULT;
			case AstPackage.SCRIPT_PROCESS_STATUS__LINE:
				return line != LINE_EDEFAULT;
			case AstPackage.SCRIPT_PROCESS_STATUS__LENGTH:
				return length != LENGTH_EDEFAULT;
			case AstPackage.SCRIPT_PROCESS_STATUS__RESOURCE_ID:
				return RESOURCE_ID_EDEFAULT == null ? resourceID != null : !RESOURCE_ID_EDEFAULT.equals(resourceID);
			case AstPackage.SCRIPT_PROCESS_STATUS__CAUSE:
				return cause != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == AstNode.class) {
			switch (derivedFeatureID) {
				case AstPackage.SCRIPT_PROCESS_STATUS__COLUMN: return AstPackage.AST_NODE__COLUMN;
				case AstPackage.SCRIPT_PROCESS_STATUS__LINE: return AstPackage.AST_NODE__LINE;
				case AstPackage.SCRIPT_PROCESS_STATUS__LENGTH: return AstPackage.AST_NODE__LENGTH;
				case AstPackage.SCRIPT_PROCESS_STATUS__RESOURCE_ID: return AstPackage.AST_NODE__RESOURCE_ID;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == AstNode.class) {
			switch (baseFeatureID) {
				case AstPackage.AST_NODE__COLUMN: return AstPackage.SCRIPT_PROCESS_STATUS__COLUMN;
				case AstPackage.AST_NODE__LINE: return AstPackage.SCRIPT_PROCESS_STATUS__LINE;
				case AstPackage.AST_NODE__LENGTH: return AstPackage.SCRIPT_PROCESS_STATUS__LENGTH;
				case AstPackage.AST_NODE__RESOURCE_ID: return AstPackage.SCRIPT_PROCESS_STATUS__RESOURCE_ID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (column: ");
		result.append(column);
		result.append(", line: ");
		result.append(line);
		result.append(", length: ");
		result.append(length);
		result.append(", resourceID: ");
		result.append(resourceID);
		result.append(')');
		return result.toString();
	}

} //ScriptProcessStatusImpl
