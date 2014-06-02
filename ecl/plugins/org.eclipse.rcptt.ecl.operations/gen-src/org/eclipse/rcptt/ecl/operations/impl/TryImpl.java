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
package org.eclipse.rcptt.ecl.operations.impl;




import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.impl.CommandImpl;
import org.eclipse.rcptt.ecl.operations.OperationsPackage;
import org.eclipse.rcptt.ecl.operations.Try;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Try</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.impl.TryImpl#getCommand <em>Command</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.impl.TryImpl#getCatch <em>Catch</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.impl.TryImpl#getFinally <em>Finally</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.impl.TryImpl#getTimes <em>Times</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.impl.TryImpl#getDelay <em>Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TryImpl extends CommandImpl implements Try {
	/**
	 * The cached value of the '{@link #getCommand() <em>Command</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	protected Command command;

	/**
	 * The cached value of the '{@link #getCatch() <em>Catch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatch()
	 * @generated
	 * @ordered
	 */
	protected Command catch_;

	/**
	 * The cached value of the '{@link #getFinally() <em>Finally</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinally()
	 * @generated
	 * @ordered
	 */
	protected Command finally_;

	/**
	 * The default value of the '{@link #getTimes() <em>Times</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimes()
	 * @generated
	 * @ordered
	 */
	protected static final Integer TIMES_EDEFAULT = new Integer(1);

	/**
	 * The cached value of the '{@link #getTimes() <em>Times</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimes()
	 * @generated
	 * @ordered
	 */
	protected Integer times = TIMES_EDEFAULT;

	/**
	 * The default value of the '{@link #getDelay() <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelay()
	 * @generated
	 * @ordered
	 */
	protected static final Integer DELAY_EDEFAULT = new Integer(0);

	/**
	 * The cached value of the '{@link #getDelay() <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelay()
	 * @generated
	 * @ordered
	 */
	protected Integer delay = DELAY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.TRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command getCommand() {
		if (command != null && command.eIsProxy()) {
			InternalEObject oldCommand = (InternalEObject)command;
			command = (Command)eResolveProxy(oldCommand);
			if (command != oldCommand) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationsPackage.TRY__COMMAND, oldCommand, command));
			}
		}
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command basicGetCommand() {
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommand(Command newCommand) {
		Command oldCommand = command;
		command = newCommand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.TRY__COMMAND, oldCommand, command));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command getCatch() {
		if (catch_ != null && catch_.eIsProxy()) {
			InternalEObject oldCatch = (InternalEObject)catch_;
			catch_ = (Command)eResolveProxy(oldCatch);
			if (catch_ != oldCatch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationsPackage.TRY__CATCH, oldCatch, catch_));
			}
		}
		return catch_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command basicGetCatch() {
		return catch_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCatch(Command newCatch) {
		Command oldCatch = catch_;
		catch_ = newCatch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.TRY__CATCH, oldCatch, catch_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command getFinally() {
		if (finally_ != null && finally_.eIsProxy()) {
			InternalEObject oldFinally = (InternalEObject)finally_;
			finally_ = (Command)eResolveProxy(oldFinally);
			if (finally_ != oldFinally) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationsPackage.TRY__FINALLY, oldFinally, finally_));
			}
		}
		return finally_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command basicGetFinally() {
		return finally_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinally(Command newFinally) {
		Command oldFinally = finally_;
		finally_ = newFinally;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.TRY__FINALLY, oldFinally, finally_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getTimes() {
		return times;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimes(Integer newTimes) {
		Integer oldTimes = times;
		times = newTimes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.TRY__TIMES, oldTimes, times));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getDelay() {
		return delay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelay(Integer newDelay) {
		Integer oldDelay = delay;
		delay = newDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.TRY__DELAY, oldDelay, delay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationsPackage.TRY__COMMAND:
				if (resolve) return getCommand();
				return basicGetCommand();
			case OperationsPackage.TRY__CATCH:
				if (resolve) return getCatch();
				return basicGetCatch();
			case OperationsPackage.TRY__FINALLY:
				if (resolve) return getFinally();
				return basicGetFinally();
			case OperationsPackage.TRY__TIMES:
				return getTimes();
			case OperationsPackage.TRY__DELAY:
				return getDelay();
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
			case OperationsPackage.TRY__COMMAND:
				setCommand((Command)newValue);
				return;
			case OperationsPackage.TRY__CATCH:
				setCatch((Command)newValue);
				return;
			case OperationsPackage.TRY__FINALLY:
				setFinally((Command)newValue);
				return;
			case OperationsPackage.TRY__TIMES:
				setTimes((Integer)newValue);
				return;
			case OperationsPackage.TRY__DELAY:
				setDelay((Integer)newValue);
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
			case OperationsPackage.TRY__COMMAND:
				setCommand((Command)null);
				return;
			case OperationsPackage.TRY__CATCH:
				setCatch((Command)null);
				return;
			case OperationsPackage.TRY__FINALLY:
				setFinally((Command)null);
				return;
			case OperationsPackage.TRY__TIMES:
				setTimes(TIMES_EDEFAULT);
				return;
			case OperationsPackage.TRY__DELAY:
				setDelay(DELAY_EDEFAULT);
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
			case OperationsPackage.TRY__COMMAND:
				return command != null;
			case OperationsPackage.TRY__CATCH:
				return catch_ != null;
			case OperationsPackage.TRY__FINALLY:
				return finally_ != null;
			case OperationsPackage.TRY__TIMES:
				return TIMES_EDEFAULT == null ? times != null : !TIMES_EDEFAULT.equals(times);
			case OperationsPackage.TRY__DELAY:
				return DELAY_EDEFAULT == null ? delay != null : !DELAY_EDEFAULT.equals(delay);
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
		result.append(" (times: ");
		result.append(times);
		result.append(", delay: ");
		result.append(delay);
		result.append(')');
		return result.toString();
	}

} //TryImpl
