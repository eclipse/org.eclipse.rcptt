/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.debug.impl;

import org.eclipse.rcptt.core.scenario.NamedElement;

import org.eclipse.rcptt.debug.Breakpoint;
import org.eclipse.rcptt.debug.DebugPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Breakpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.debug.impl.BreakpointImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.BreakpointImpl#isRegistered <em>Registered</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.BreakpointImpl#isPersisted <em>Persisted</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.BreakpointImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.BreakpointImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.rcptt.debug.impl.BreakpointImpl#getWorkingSets <em>Working Sets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BreakpointImpl extends EObjectImpl implements Breakpoint {
	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isRegistered() <em>Registered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRegistered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REGISTERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRegistered() <em>Registered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRegistered()
	 * @generated
	 * @ordered
	 */
	protected boolean registered = REGISTERED_EDEFAULT;

	/**
	 * The default value of the '{@link #isPersisted() <em>Persisted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPersisted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PERSISTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPersisted() <em>Persisted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPersisted()
	 * @generated
	 * @ordered
	 */
	protected boolean persisted = PERSISTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedElement> attributes;

	/**
	 * The cached value of the '{@link #getWorkingSets() <em>Working Sets</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkingSets()
	 * @generated
	 * @ordered
	 */
	protected EList<String> workingSets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BreakpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DebugPackage.Literals.BREAKPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled) {
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.BREAKPOINT__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRegistered() {
		return registered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegistered(boolean newRegistered) {
		boolean oldRegistered = registered;
		registered = newRegistered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.BREAKPOINT__REGISTERED, oldRegistered, registered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPersisted() {
		return persisted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersisted(boolean newPersisted) {
		boolean oldPersisted = persisted;
		persisted = newPersisted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.BREAKPOINT__PERSISTED, oldPersisted, persisted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.BREAKPOINT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<NamedElement>(NamedElement.class, this, DebugPackage.BREAKPOINT__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getWorkingSets() {
		if (workingSets == null) {
			workingSets = new EDataTypeUniqueEList<String>(String.class, this, DebugPackage.BREAKPOINT__WORKING_SETS);
		}
		return workingSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DebugPackage.BREAKPOINT__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
			case DebugPackage.BREAKPOINT__ENABLED:
				return isEnabled();
			case DebugPackage.BREAKPOINT__REGISTERED:
				return isRegistered();
			case DebugPackage.BREAKPOINT__PERSISTED:
				return isPersisted();
			case DebugPackage.BREAKPOINT__TYPE:
				return getType();
			case DebugPackage.BREAKPOINT__ATTRIBUTES:
				return getAttributes();
			case DebugPackage.BREAKPOINT__WORKING_SETS:
				return getWorkingSets();
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
			case DebugPackage.BREAKPOINT__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case DebugPackage.BREAKPOINT__REGISTERED:
				setRegistered((Boolean)newValue);
				return;
			case DebugPackage.BREAKPOINT__PERSISTED:
				setPersisted((Boolean)newValue);
				return;
			case DebugPackage.BREAKPOINT__TYPE:
				setType((String)newValue);
				return;
			case DebugPackage.BREAKPOINT__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends NamedElement>)newValue);
				return;
			case DebugPackage.BREAKPOINT__WORKING_SETS:
				getWorkingSets().clear();
				getWorkingSets().addAll((Collection<? extends String>)newValue);
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
			case DebugPackage.BREAKPOINT__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case DebugPackage.BREAKPOINT__REGISTERED:
				setRegistered(REGISTERED_EDEFAULT);
				return;
			case DebugPackage.BREAKPOINT__PERSISTED:
				setPersisted(PERSISTED_EDEFAULT);
				return;
			case DebugPackage.BREAKPOINT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case DebugPackage.BREAKPOINT__ATTRIBUTES:
				getAttributes().clear();
				return;
			case DebugPackage.BREAKPOINT__WORKING_SETS:
				getWorkingSets().clear();
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
			case DebugPackage.BREAKPOINT__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case DebugPackage.BREAKPOINT__REGISTERED:
				return registered != REGISTERED_EDEFAULT;
			case DebugPackage.BREAKPOINT__PERSISTED:
				return persisted != PERSISTED_EDEFAULT;
			case DebugPackage.BREAKPOINT__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case DebugPackage.BREAKPOINT__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case DebugPackage.BREAKPOINT__WORKING_SETS:
				return workingSets != null && !workingSets.isEmpty();
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
		result.append(" (enabled: ");
		result.append(enabled);
		result.append(", registered: ");
		result.append(registered);
		result.append(", persisted: ");
		result.append(persisted);
		result.append(", type: ");
		result.append(type);
		result.append(", workingSets: ");
		result.append(workingSets);
		result.append(')');
		return result.toString();
	}

} //BreakpointImpl
