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
package org.eclipse.rcptt.tesla.core.protocol.impl;

import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;
import org.eclipse.rcptt.tesla.core.protocol.SetTextSelection;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Text Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelectionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelectionImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelectionImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelectionImpl#getLength <em>Length</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelectionImpl#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelectionImpl#getEndline <em>Endline</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelectionImpl#getEndoffset <em>Endoffset</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SetTextSelectionImpl extends EObjectImpl implements SetTextSelection {
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
	 * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected static final Integer OFFSET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected Integer offset = OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final Integer LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected Integer length = LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected static final Integer START_LINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected Integer startLine = START_LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndline() <em>Endline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndline()
	 * @generated
	 * @ordered
	 */
	protected static final Integer ENDLINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndline() <em>Endline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndline()
	 * @generated
	 * @ordered
	 */
	protected Integer endline = ENDLINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndoffset() <em>Endoffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndoffset()
	 * @generated
	 * @ordered
	 */
	protected static final Integer ENDOFFSET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndoffset() <em>Endoffset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndoffset()
	 * @generated
	 * @ordered
	 */
	protected Integer endoffset = ENDOFFSET_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetTextSelectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProtocolPackage.Literals.SET_TEXT_SELECTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION__ID, oldId, id));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION__ELEMENT, oldElement, newElement);
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
				msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProtocolPackage.SET_TEXT_SELECTION__ELEMENT, null, msgs);
			if (newElement != null)
				msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProtocolPackage.SET_TEXT_SELECTION__ELEMENT, null, msgs);
			msgs = basicSetElement(newElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION__ELEMENT, newElement, newElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getOffset() {
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffset(Integer newOffset) {
		Integer oldOffset = offset;
		offset = newOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION__OFFSET, oldOffset, offset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLength(Integer newLength) {
		Integer oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getStartLine() {
		return startLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartLine(Integer newStartLine) {
		Integer oldStartLine = startLine;
		startLine = newStartLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION__START_LINE, oldStartLine, startLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getEndline() {
		return endline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndline(Integer newEndline) {
		Integer oldEndline = endline;
		endline = newEndline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION__ENDLINE, oldEndline, endline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getEndoffset() {
		return endoffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndoffset(Integer newEndoffset) {
		Integer oldEndoffset = endoffset;
		endoffset = newEndoffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION__ENDOFFSET, oldEndoffset, endoffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProtocolPackage.SET_TEXT_SELECTION__ELEMENT:
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
			case ProtocolPackage.SET_TEXT_SELECTION__ID:
				return getId();
			case ProtocolPackage.SET_TEXT_SELECTION__ELEMENT:
				return getElement();
			case ProtocolPackage.SET_TEXT_SELECTION__OFFSET:
				return getOffset();
			case ProtocolPackage.SET_TEXT_SELECTION__LENGTH:
				return getLength();
			case ProtocolPackage.SET_TEXT_SELECTION__START_LINE:
				return getStartLine();
			case ProtocolPackage.SET_TEXT_SELECTION__ENDLINE:
				return getEndline();
			case ProtocolPackage.SET_TEXT_SELECTION__ENDOFFSET:
				return getEndoffset();
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
			case ProtocolPackage.SET_TEXT_SELECTION__ID:
				setId((Integer)newValue);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION__ELEMENT:
				setElement((Element)newValue);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION__OFFSET:
				setOffset((Integer)newValue);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION__LENGTH:
				setLength((Integer)newValue);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION__START_LINE:
				setStartLine((Integer)newValue);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION__ENDLINE:
				setEndline((Integer)newValue);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION__ENDOFFSET:
				setEndoffset((Integer)newValue);
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
			case ProtocolPackage.SET_TEXT_SELECTION__ID:
				setId(ID_EDEFAULT);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION__ELEMENT:
				setElement((Element)null);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION__OFFSET:
				setOffset(OFFSET_EDEFAULT);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION__START_LINE:
				setStartLine(START_LINE_EDEFAULT);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION__ENDLINE:
				setEndline(ENDLINE_EDEFAULT);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION__ENDOFFSET:
				setEndoffset(ENDOFFSET_EDEFAULT);
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
			case ProtocolPackage.SET_TEXT_SELECTION__ID:
				return id != ID_EDEFAULT;
			case ProtocolPackage.SET_TEXT_SELECTION__ELEMENT:
				return element != null;
			case ProtocolPackage.SET_TEXT_SELECTION__OFFSET:
				return OFFSET_EDEFAULT == null ? offset != null : !OFFSET_EDEFAULT.equals(offset);
			case ProtocolPackage.SET_TEXT_SELECTION__LENGTH:
				return LENGTH_EDEFAULT == null ? length != null : !LENGTH_EDEFAULT.equals(length);
			case ProtocolPackage.SET_TEXT_SELECTION__START_LINE:
				return START_LINE_EDEFAULT == null ? startLine != null : !START_LINE_EDEFAULT.equals(startLine);
			case ProtocolPackage.SET_TEXT_SELECTION__ENDLINE:
				return ENDLINE_EDEFAULT == null ? endline != null : !ENDLINE_EDEFAULT.equals(endline);
			case ProtocolPackage.SET_TEXT_SELECTION__ENDOFFSET:
				return ENDOFFSET_EDEFAULT == null ? endoffset != null : !ENDOFFSET_EDEFAULT.equals(endoffset);
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", offset: ");
		result.append(offset);
		result.append(", length: ");
		result.append(length);
		result.append(", startLine: ");
		result.append(startLine);
		result.append(", endline: ");
		result.append(endline);
		result.append(", endoffset: ");
		result.append(endoffset);
		result.append(')');
		return result.toString();
	}

} //SetTextSelectionImpl
