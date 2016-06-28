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
package org.eclipse.rcptt.tesla.core.protocol.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.rcptt.tesla.core.protocol.Click;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Click</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickImpl#isDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickImpl#isWithWait <em>With Wait</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.ClickImpl#isArrow <em>Arrow</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClickImpl extends EObjectImpl implements Click {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected Element element;

	/**
	 * The default value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean default_ = DEFAULT_EDEFAULT;

	/**
	 * The default value of the '{@link #isWithWait() <em>With Wait</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWithWait()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WITH_WAIT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isWithWait() <em>With Wait</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWithWait()
	 * @generated
	 * @ordered
	 */
	protected boolean withWait = WITH_WAIT_EDEFAULT;

	/**
	 * The default value of the '{@link #isArrow() <em>Arrow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isArrow()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ARROW_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isArrow() <em>Arrow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isArrow()
	 * @generated
	 * @ordered
	 */
	protected boolean arrow = ARROW_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProtocolPackage.Literals.CLICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.CLICK__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElement(Element newElement, NotificationChain msgs) {
		Element oldElement = element;
		element = newElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProtocolPackage.CLICK__ELEMENT, oldElement, newElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(Element newElement) {
		if (newElement != element) {
			NotificationChain msgs = null;
			if (element != null)
				msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProtocolPackage.CLICK__ELEMENT, null, msgs);
			if (newElement != null)
				msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProtocolPackage.CLICK__ELEMENT, null, msgs);
			msgs = basicSetElement(newElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.CLICK__ELEMENT, newElement, newElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(boolean newDefault) {
		boolean oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.CLICK__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWithWait() {
		return withWait;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWithWait(boolean newWithWait) {
		boolean oldWithWait = withWait;
		withWait = newWithWait;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.CLICK__WITH_WAIT, oldWithWait, withWait));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isArrow() {
		return arrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrow(boolean newArrow) {
		boolean oldArrow = arrow;
		arrow = newArrow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.CLICK__ARROW, oldArrow, arrow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProtocolPackage.CLICK__ELEMENT:
				return basicSetElement(null, msgs);
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
			case ProtocolPackage.CLICK__ID:
				return getId();
			case ProtocolPackage.CLICK__ELEMENT:
				return getElement();
			case ProtocolPackage.CLICK__DEFAULT:
				return isDefault();
			case ProtocolPackage.CLICK__WITH_WAIT:
				return isWithWait();
			case ProtocolPackage.CLICK__ARROW:
				return isArrow();
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
			case ProtocolPackage.CLICK__ID:
				setId((Integer)newValue);
				return;
			case ProtocolPackage.CLICK__ELEMENT:
				setElement((Element)newValue);
				return;
			case ProtocolPackage.CLICK__DEFAULT:
				setDefault((Boolean)newValue);
				return;
			case ProtocolPackage.CLICK__WITH_WAIT:
				setWithWait((Boolean)newValue);
				return;
			case ProtocolPackage.CLICK__ARROW:
				setArrow((Boolean)newValue);
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
			case ProtocolPackage.CLICK__ID:
				setId(ID_EDEFAULT);
				return;
			case ProtocolPackage.CLICK__ELEMENT:
				setElement((Element)null);
				return;
			case ProtocolPackage.CLICK__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case ProtocolPackage.CLICK__WITH_WAIT:
				setWithWait(WITH_WAIT_EDEFAULT);
				return;
			case ProtocolPackage.CLICK__ARROW:
				setArrow(ARROW_EDEFAULT);
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
			case ProtocolPackage.CLICK__ID:
				return id != ID_EDEFAULT;
			case ProtocolPackage.CLICK__ELEMENT:
				return element != null;
			case ProtocolPackage.CLICK__DEFAULT:
				return default_ != DEFAULT_EDEFAULT;
			case ProtocolPackage.CLICK__WITH_WAIT:
				return withWait != WITH_WAIT_EDEFAULT;
			case ProtocolPackage.CLICK__ARROW:
				return arrow != ARROW_EDEFAULT;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", default: ");
		result.append(default_);
		result.append(", withWait: ");
		result.append(withWait);
		result.append(", arrow: ");
		result.append(arrow);
		result.append(')');
		return result.toString();
	}

} //ClickImpl
