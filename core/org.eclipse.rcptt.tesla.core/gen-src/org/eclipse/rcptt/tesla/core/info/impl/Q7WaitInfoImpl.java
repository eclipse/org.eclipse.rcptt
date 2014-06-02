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
package org.eclipse.rcptt.tesla.core.info.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.rcptt.tesla.core.info.InfoPackage;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Q7 Wait Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoImpl#getEndTime <em>End Time</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoImpl#getLastTick <em>Last Tick</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoImpl#getClassId <em>Class Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoImpl#getTypeId <em>Type Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoImpl#getTicks <em>Ticks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Q7WaitInfoImpl extends EObjectImpl implements Q7WaitInfo {
	/**
	 * The default value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected static final long START_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected long startTime = START_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected static final long END_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected long endTime = END_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastTick() <em>Last Tick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastTick()
	 * @generated
	 * @ordered
	 */
	protected static final long LAST_TICK_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getLastTick() <em>Last Tick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastTick()
	 * @generated
	 * @ordered
	 */
	protected long lastTick = LAST_TICK_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassId() <em>Class Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassId()
	 * @generated
	 * @ordered
	 */
	protected static final int CLASS_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getClassId() <em>Class Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassId()
	 * @generated
	 * @ordered
	 */
	protected int classId = CLASS_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeId() <em>Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeId()
	 * @generated
	 * @ordered
	 */
	protected static final int TYPE_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTypeId() <em>Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeId()
	 * @generated
	 * @ordered
	 */
	protected int typeId = TYPE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTicks() <em>Ticks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTicks()
	 * @generated
	 * @ordered
	 */
	protected static final long TICKS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTicks() <em>Ticks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTicks()
	 * @generated
	 * @ordered
	 */
	protected long ticks = TICKS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Q7WaitInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfoPackage.Literals.Q7_WAIT_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTime(long newStartTime) {
		long oldStartTime = startTime;
		startTime = newStartTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.Q7_WAIT_INFO__START_TIME, oldStartTime, startTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndTime(long newEndTime) {
		long oldEndTime = endTime;
		endTime = newEndTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.Q7_WAIT_INFO__END_TIME, oldEndTime, endTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getLastTick() {
		return lastTick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastTick(long newLastTick) {
		long oldLastTick = lastTick;
		lastTick = newLastTick;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.Q7_WAIT_INFO__LAST_TICK, oldLastTick, lastTick));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getClassId() {
		return classId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassId(int newClassId) {
		int oldClassId = classId;
		classId = newClassId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.Q7_WAIT_INFO__CLASS_ID, oldClassId, classId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeId(int newTypeId) {
		int oldTypeId = typeId;
		typeId = newTypeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.Q7_WAIT_INFO__TYPE_ID, oldTypeId, typeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTicks() {
		return ticks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTicks(long newTicks) {
		long oldTicks = ticks;
		ticks = newTicks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.Q7_WAIT_INFO__TICKS, oldTicks, ticks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InfoPackage.Q7_WAIT_INFO__START_TIME:
				return getStartTime();
			case InfoPackage.Q7_WAIT_INFO__END_TIME:
				return getEndTime();
			case InfoPackage.Q7_WAIT_INFO__LAST_TICK:
				return getLastTick();
			case InfoPackage.Q7_WAIT_INFO__CLASS_ID:
				return getClassId();
			case InfoPackage.Q7_WAIT_INFO__TYPE_ID:
				return getTypeId();
			case InfoPackage.Q7_WAIT_INFO__TICKS:
				return getTicks();
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
			case InfoPackage.Q7_WAIT_INFO__START_TIME:
				setStartTime((Long)newValue);
				return;
			case InfoPackage.Q7_WAIT_INFO__END_TIME:
				setEndTime((Long)newValue);
				return;
			case InfoPackage.Q7_WAIT_INFO__LAST_TICK:
				setLastTick((Long)newValue);
				return;
			case InfoPackage.Q7_WAIT_INFO__CLASS_ID:
				setClassId((Integer)newValue);
				return;
			case InfoPackage.Q7_WAIT_INFO__TYPE_ID:
				setTypeId((Integer)newValue);
				return;
			case InfoPackage.Q7_WAIT_INFO__TICKS:
				setTicks((Long)newValue);
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
			case InfoPackage.Q7_WAIT_INFO__START_TIME:
				setStartTime(START_TIME_EDEFAULT);
				return;
			case InfoPackage.Q7_WAIT_INFO__END_TIME:
				setEndTime(END_TIME_EDEFAULT);
				return;
			case InfoPackage.Q7_WAIT_INFO__LAST_TICK:
				setLastTick(LAST_TICK_EDEFAULT);
				return;
			case InfoPackage.Q7_WAIT_INFO__CLASS_ID:
				setClassId(CLASS_ID_EDEFAULT);
				return;
			case InfoPackage.Q7_WAIT_INFO__TYPE_ID:
				setTypeId(TYPE_ID_EDEFAULT);
				return;
			case InfoPackage.Q7_WAIT_INFO__TICKS:
				setTicks(TICKS_EDEFAULT);
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
			case InfoPackage.Q7_WAIT_INFO__START_TIME:
				return startTime != START_TIME_EDEFAULT;
			case InfoPackage.Q7_WAIT_INFO__END_TIME:
				return endTime != END_TIME_EDEFAULT;
			case InfoPackage.Q7_WAIT_INFO__LAST_TICK:
				return lastTick != LAST_TICK_EDEFAULT;
			case InfoPackage.Q7_WAIT_INFO__CLASS_ID:
				return classId != CLASS_ID_EDEFAULT;
			case InfoPackage.Q7_WAIT_INFO__TYPE_ID:
				return typeId != TYPE_ID_EDEFAULT;
			case InfoPackage.Q7_WAIT_INFO__TICKS:
				return ticks != TICKS_EDEFAULT;
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
		result.append(" (startTime: ");
		result.append(startTime);
		result.append(", endTime: ");
		result.append(endTime);
		result.append(", lastTick: ");
		result.append(lastTick);
		result.append(", classId: ");
		result.append(classId);
		result.append(", typeId: ");
		result.append(typeId);
		result.append(", ticks: ");
		result.append(ticks);
		result.append(')');
		return result.toString();
	}

} //Q7WaitInfoImpl
