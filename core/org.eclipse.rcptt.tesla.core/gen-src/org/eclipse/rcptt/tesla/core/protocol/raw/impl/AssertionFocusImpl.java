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
package org.eclipse.rcptt.tesla.core.protocol.raw.impl;

import org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assertion Focus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.AssertionFocusImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.AssertionFocusImpl#isPointFixed <em>Point Fixed</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.AssertionFocusImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.AssertionFocusImpl#getImageCapture <em>Image Capture</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssertionFocusImpl extends EObjectImpl implements AssertionFocus {
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
	 * The default value of the '{@link #isPointFixed() <em>Point Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPointFixed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean POINT_FIXED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPointFixed() <em>Point Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPointFixed()
	 * @generated
	 * @ordered
	 */
	protected boolean pointFixed = POINT_FIXED_EDEFAULT;

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
	 * The default value of the '{@link #getImageCapture() <em>Image Capture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageCapture()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] IMAGE_CAPTURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImageCapture() <em>Image Capture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageCapture()
	 * @generated
	 * @ordered
	 */
	protected byte[] imageCapture = IMAGE_CAPTURE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssertionFocusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RawPackage.Literals.ASSERTION_FOCUS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.ASSERTION_FOCUS__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPointFixed() {
		return pointFixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointFixed(boolean newPointFixed) {
		boolean oldPointFixed = pointFixed;
		pointFixed = newPointFixed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.ASSERTION_FOCUS__POINT_FIXED,
					oldPointFixed, pointFixed));
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
	public NotificationChain basicSetElement(Element newElement,
			NotificationChain msgs) {
		Element oldElement = element;
		element = newElement;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					RawPackage.ASSERTION_FOCUS__ELEMENT, oldElement, newElement);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(Element newElement) {
		if (newElement != element)
		{
			NotificationChain msgs = null;
			if (element != null)
				msgs = ((InternalEObject) element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- RawPackage.ASSERTION_FOCUS__ELEMENT, null, msgs);
			if (newElement != null)
				msgs = ((InternalEObject) newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- RawPackage.ASSERTION_FOCUS__ELEMENT, null, msgs);
			msgs = basicSetElement(newElement, msgs);
			if (msgs != null)
				msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.ASSERTION_FOCUS__ELEMENT, newElement,
					newElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getImageCapture() {
		return imageCapture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImageCapture(byte[] newImageCapture) {
		byte[] oldImageCapture = imageCapture;
		imageCapture = newImageCapture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.ASSERTION_FOCUS__IMAGE_CAPTURE,
					oldImageCapture, imageCapture));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
		case RawPackage.ASSERTION_FOCUS__ELEMENT:
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
		switch (featureID)
		{
		case RawPackage.ASSERTION_FOCUS__ID:
			return getId();
		case RawPackage.ASSERTION_FOCUS__POINT_FIXED:
			return isPointFixed();
		case RawPackage.ASSERTION_FOCUS__ELEMENT:
			return getElement();
		case RawPackage.ASSERTION_FOCUS__IMAGE_CAPTURE:
			return getImageCapture();
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
		switch (featureID)
		{
		case RawPackage.ASSERTION_FOCUS__ID:
			setId((Integer) newValue);
			return;
		case RawPackage.ASSERTION_FOCUS__POINT_FIXED:
			setPointFixed((Boolean) newValue);
			return;
		case RawPackage.ASSERTION_FOCUS__ELEMENT:
			setElement((Element) newValue);
			return;
		case RawPackage.ASSERTION_FOCUS__IMAGE_CAPTURE:
			setImageCapture((byte[]) newValue);
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
		switch (featureID)
		{
		case RawPackage.ASSERTION_FOCUS__ID:
			setId(ID_EDEFAULT);
			return;
		case RawPackage.ASSERTION_FOCUS__POINT_FIXED:
			setPointFixed(POINT_FIXED_EDEFAULT);
			return;
		case RawPackage.ASSERTION_FOCUS__ELEMENT:
			setElement((Element) null);
			return;
		case RawPackage.ASSERTION_FOCUS__IMAGE_CAPTURE:
			setImageCapture(IMAGE_CAPTURE_EDEFAULT);
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
		switch (featureID)
		{
		case RawPackage.ASSERTION_FOCUS__ID:
			return id != ID_EDEFAULT;
		case RawPackage.ASSERTION_FOCUS__POINT_FIXED:
			return pointFixed != POINT_FIXED_EDEFAULT;
		case RawPackage.ASSERTION_FOCUS__ELEMENT:
			return element != null;
		case RawPackage.ASSERTION_FOCUS__IMAGE_CAPTURE:
			return IMAGE_CAPTURE_EDEFAULT == null ? imageCapture != null : !IMAGE_CAPTURE_EDEFAULT.equals(imageCapture);
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", pointFixed: ");
		result.append(pointFixed);
		result.append(", imageCapture: ");
		result.append(imageCapture);
		result.append(')');
		return result.toString();
	}

} //AssertionFocusImpl
