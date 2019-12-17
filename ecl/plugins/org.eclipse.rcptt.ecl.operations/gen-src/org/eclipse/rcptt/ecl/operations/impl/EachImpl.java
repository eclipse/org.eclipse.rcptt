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
package org.eclipse.rcptt.ecl.operations.impl;




import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.EclList;
import org.eclipse.rcptt.ecl.core.Val;
import org.eclipse.rcptt.ecl.core.impl.CommandImpl;
import org.eclipse.rcptt.ecl.operations.Each;
import org.eclipse.rcptt.ecl.operations.OperationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Each</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.impl.EachImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.impl.EachImpl#getVal <em>Val</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.impl.EachImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.impl.EachImpl#getDo <em>Do</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EachImpl extends CommandImpl implements Each {
	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected EObject input;

	/**
	 * The cached value of the '{@link #getVal() <em>Val</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVal()
	 * @generated
	 * @ordered
	 */
	protected Val val;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected Val key;

	/**
	 * The cached value of the '{@link #getDo() <em>Do</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDo()
	 * @generated
	 * @ordered
	 */
	protected Command do_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EachImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.EACH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getInput() {
		if (input != null && input.eIsProxy()) {
			InternalEObject oldInput = (InternalEObject)input;
			input = eResolveProxy(oldInput);
			if (input != oldInput) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationsPackage.EACH__INPUT, oldInput, input));
			}
		}
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(EObject newInput) {
		EObject oldInput = input;
		input = newInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.EACH__INPUT, oldInput, input));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Val getVal() {
		return val;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVal(Val newVal, NotificationChain msgs) {
		Val oldVal = val;
		val = newVal;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationsPackage.EACH__VAL, oldVal, newVal);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVal(Val newVal) {
		if (newVal != val) {
			NotificationChain msgs = null;
			if (val != null)
				msgs = ((InternalEObject)val).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.EACH__VAL, null, msgs);
			if (newVal != null)
				msgs = ((InternalEObject)newVal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.EACH__VAL, null, msgs);
			msgs = basicSetVal(newVal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.EACH__VAL, newVal, newVal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Val getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetKey(Val newKey, NotificationChain msgs) {
		Val oldKey = key;
		key = newKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationsPackage.EACH__KEY, oldKey, newKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(Val newKey) {
		if (newKey != key) {
			NotificationChain msgs = null;
			if (key != null)
				msgs = ((InternalEObject)key).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.EACH__KEY, null, msgs);
			if (newKey != null)
				msgs = ((InternalEObject)newKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.EACH__KEY, null, msgs);
			msgs = basicSetKey(newKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.EACH__KEY, newKey, newKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command getDo() {
		return do_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDo(Command newDo, NotificationChain msgs) {
		Command oldDo = do_;
		do_ = newDo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationsPackage.EACH__DO, oldDo, newDo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDo(Command newDo) {
		if (newDo != do_) {
			NotificationChain msgs = null;
			if (do_ != null)
				msgs = ((InternalEObject)do_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.EACH__DO, null, msgs);
			if (newDo != null)
				msgs = ((InternalEObject)newDo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OperationsPackage.EACH__DO, null, msgs);
			msgs = basicSetDo(newDo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.EACH__DO, newDo, newDo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperationsPackage.EACH__VAL:
				return basicSetVal(null, msgs);
			case OperationsPackage.EACH__KEY:
				return basicSetKey(null, msgs);
			case OperationsPackage.EACH__DO:
				return basicSetDo(null, msgs);
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
			case OperationsPackage.EACH__INPUT:
				if (resolve) return getInput();
				return basicGetInput();
			case OperationsPackage.EACH__VAL:
				return getVal();
			case OperationsPackage.EACH__KEY:
				return getKey();
			case OperationsPackage.EACH__DO:
				return getDo();
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
			case OperationsPackage.EACH__INPUT:
				setInput((EObject)newValue);
				return;
			case OperationsPackage.EACH__VAL:
				setVal((Val)newValue);
				return;
			case OperationsPackage.EACH__KEY:
				setKey((Val)newValue);
				return;
			case OperationsPackage.EACH__DO:
				setDo((Command)newValue);
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
			case OperationsPackage.EACH__INPUT:
				setInput((EObject)null);
				return;
			case OperationsPackage.EACH__VAL:
				setVal((Val)null);
				return;
			case OperationsPackage.EACH__KEY:
				setKey((Val)null);
				return;
			case OperationsPackage.EACH__DO:
				setDo((Command)null);
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
			case OperationsPackage.EACH__INPUT:
				return input != null;
			case OperationsPackage.EACH__VAL:
				return val != null;
			case OperationsPackage.EACH__KEY:
				return key != null;
			case OperationsPackage.EACH__DO:
				return do_ != null;
		}
		return super.eIsSet(featureID);
	}

} //EachImpl
