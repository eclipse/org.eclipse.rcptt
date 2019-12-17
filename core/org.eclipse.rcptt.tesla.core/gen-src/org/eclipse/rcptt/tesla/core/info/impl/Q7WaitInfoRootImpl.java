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
package org.eclipse.rcptt.tesla.core.info.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.rcptt.tesla.core.info.InfoPackage;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfo;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Q7 Wait Info Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoRootImpl#getInfos <em>Infos</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoRootImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoRootImpl#getTick <em>Tick</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoRootImpl#getClassNames <em>Class Names</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoRootImpl#getTypesNames <em>Types Names</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.Q7WaitInfoRootImpl#getInnerClassMap <em>Inner Class Map</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Q7WaitInfoRootImpl extends EObjectImpl implements Q7WaitInfoRoot {
	/**
	 * The cached value of the '{@link #getInfos() <em>Infos</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfos()
	 * @generated
	 * @ordered
	 */
	protected EList<Q7WaitInfo> infos;

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
	 * The default value of the '{@link #getTick() <em>Tick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTick()
	 * @generated
	 * @ordered
	 */
	protected static final long TICK_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTick() <em>Tick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTick()
	 * @generated
	 * @ordered
	 */
	protected long tick = TICK_EDEFAULT;

	/**
	 * The cached value of the '{@link #getClassNames() <em>Class Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> classNames;

	/**
	 * The cached value of the '{@link #getTypesNames() <em>Types Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypesNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> typesNames;

	/**
	 * The cached value of the '{@link #getInnerClassMap() <em>Inner Class Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerClassMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> innerClassMap;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Q7WaitInfoRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfoPackage.Literals.Q7_WAIT_INFO_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Q7WaitInfo> getInfos() {
		if (infos == null) {
			infos = new EObjectContainmentEList<Q7WaitInfo>(Q7WaitInfo.class, this, InfoPackage.Q7_WAIT_INFO_ROOT__INFOS);
		}
		return infos;
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
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.Q7_WAIT_INFO_ROOT__START_TIME, oldStartTime, startTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTick() {
		return tick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTick(long newTick) {
		long oldTick = tick;
		tick = newTick;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.Q7_WAIT_INFO_ROOT__TICK, oldTick, tick));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getClassNames() {
		if (classNames == null) {
			classNames = new EDataTypeEList<String>(String.class, this, InfoPackage.Q7_WAIT_INFO_ROOT__CLASS_NAMES);
		}
		return classNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTypesNames() {
		if (typesNames == null) {
			typesNames = new EDataTypeEList<String>(String.class, this, InfoPackage.Q7_WAIT_INFO_ROOT__TYPES_NAMES);
		}
		return typesNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getInnerClassMap() {
		if (innerClassMap == null) {
			innerClassMap = new EcoreEMap<String,String>(InfoPackage.Literals.Q7_WAIT_INFO_INNER_CLASS_MAP, Q7WaitInfoInnerClassMapImpl.class, this, InfoPackage.Q7_WAIT_INFO_ROOT__INNER_CLASS_MAP);
		}
		return innerClassMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InfoPackage.Q7_WAIT_INFO_ROOT__INFOS:
				return ((InternalEList<?>)getInfos()).basicRemove(otherEnd, msgs);
			case InfoPackage.Q7_WAIT_INFO_ROOT__INNER_CLASS_MAP:
				return ((InternalEList<?>)getInnerClassMap()).basicRemove(otherEnd, msgs);
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
			case InfoPackage.Q7_WAIT_INFO_ROOT__INFOS:
				return getInfos();
			case InfoPackage.Q7_WAIT_INFO_ROOT__START_TIME:
				return getStartTime();
			case InfoPackage.Q7_WAIT_INFO_ROOT__TICK:
				return getTick();
			case InfoPackage.Q7_WAIT_INFO_ROOT__CLASS_NAMES:
				return getClassNames();
			case InfoPackage.Q7_WAIT_INFO_ROOT__TYPES_NAMES:
				return getTypesNames();
			case InfoPackage.Q7_WAIT_INFO_ROOT__INNER_CLASS_MAP:
				if (coreType) return getInnerClassMap();
				else return getInnerClassMap().map();
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
			case InfoPackage.Q7_WAIT_INFO_ROOT__INFOS:
				getInfos().clear();
				getInfos().addAll((Collection<? extends Q7WaitInfo>)newValue);
				return;
			case InfoPackage.Q7_WAIT_INFO_ROOT__START_TIME:
				setStartTime((Long)newValue);
				return;
			case InfoPackage.Q7_WAIT_INFO_ROOT__TICK:
				setTick((Long)newValue);
				return;
			case InfoPackage.Q7_WAIT_INFO_ROOT__CLASS_NAMES:
				getClassNames().clear();
				getClassNames().addAll((Collection<? extends String>)newValue);
				return;
			case InfoPackage.Q7_WAIT_INFO_ROOT__TYPES_NAMES:
				getTypesNames().clear();
				getTypesNames().addAll((Collection<? extends String>)newValue);
				return;
			case InfoPackage.Q7_WAIT_INFO_ROOT__INNER_CLASS_MAP:
				((EStructuralFeature.Setting)getInnerClassMap()).set(newValue);
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
			case InfoPackage.Q7_WAIT_INFO_ROOT__INFOS:
				getInfos().clear();
				return;
			case InfoPackage.Q7_WAIT_INFO_ROOT__START_TIME:
				setStartTime(START_TIME_EDEFAULT);
				return;
			case InfoPackage.Q7_WAIT_INFO_ROOT__TICK:
				setTick(TICK_EDEFAULT);
				return;
			case InfoPackage.Q7_WAIT_INFO_ROOT__CLASS_NAMES:
				getClassNames().clear();
				return;
			case InfoPackage.Q7_WAIT_INFO_ROOT__TYPES_NAMES:
				getTypesNames().clear();
				return;
			case InfoPackage.Q7_WAIT_INFO_ROOT__INNER_CLASS_MAP:
				getInnerClassMap().clear();
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
			case InfoPackage.Q7_WAIT_INFO_ROOT__INFOS:
				return infos != null && !infos.isEmpty();
			case InfoPackage.Q7_WAIT_INFO_ROOT__START_TIME:
				return startTime != START_TIME_EDEFAULT;
			case InfoPackage.Q7_WAIT_INFO_ROOT__TICK:
				return tick != TICK_EDEFAULT;
			case InfoPackage.Q7_WAIT_INFO_ROOT__CLASS_NAMES:
				return classNames != null && !classNames.isEmpty();
			case InfoPackage.Q7_WAIT_INFO_ROOT__TYPES_NAMES:
				return typesNames != null && !typesNames.isEmpty();
			case InfoPackage.Q7_WAIT_INFO_ROOT__INNER_CLASS_MAP:
				return innerClassMap != null && !innerClassMap.isEmpty();
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
		result.append(", tick: ");
		result.append(tick);
		result.append(", classNames: ");
		result.append(classNames);
		result.append(", typesNames: ");
		result.append(typesNames);
		result.append(')');
		return result.toString();
	}

} //Q7WaitInfoRootImpl
