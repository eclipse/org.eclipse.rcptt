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
package org.eclipse.rcptt.tesla.core.protocol.impl;

import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;
import org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Text Selection2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelection2Impl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelection2Impl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelection2Impl#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelection2Impl#getStartOffset <em>Start Offset</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelection2Impl#getEndLine <em>End Line</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelection2Impl#getEndOffset <em>End Offset</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.SetTextSelection2Impl#isBlockMode <em>Block Mode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SetTextSelection2Impl extends EObjectImpl implements SetTextSelection2 {
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
	 * The default value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected static final int START_LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected int startLine = START_LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartOffset() <em>Start Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int START_OFFSET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartOffset() <em>Start Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartOffset()
	 * @generated
	 * @ordered
	 */
	protected int startOffset = START_OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndLine() <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLine()
	 * @generated
	 * @ordered
	 */
	protected static final int END_LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndLine() <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLine()
	 * @generated
	 * @ordered
	 */
	protected int endLine = END_LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndOffset() <em>End Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int END_OFFSET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndOffset() <em>End Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndOffset()
	 * @generated
	 * @ordered
	 */
	protected int endOffset = END_OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #isBlockMode() <em>Block Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBlockMode()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BLOCK_MODE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBlockMode() <em>Block Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBlockMode()
	 * @generated
	 * @ordered
	 */
	protected boolean blockMode = BLOCK_MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetTextSelection2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProtocolPackage.Literals.SET_TEXT_SELECTION2;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION2__ID, oldId, id));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION2__ELEMENT, oldElement, newElement);
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
				msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProtocolPackage.SET_TEXT_SELECTION2__ELEMENT, null, msgs);
			if (newElement != null)
				msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProtocolPackage.SET_TEXT_SELECTION2__ELEMENT, null, msgs);
			msgs = basicSetElement(newElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION2__ELEMENT, newElement, newElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartLine() {
		return startLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartLine(int newStartLine) {
		int oldStartLine = startLine;
		startLine = newStartLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION2__START_LINE, oldStartLine, startLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartOffset() {
		return startOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartOffset(int newStartOffset) {
		int oldStartOffset = startOffset;
		startOffset = newStartOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION2__START_OFFSET, oldStartOffset, startOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndLine() {
		return endLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndLine(int newEndLine) {
		int oldEndLine = endLine;
		endLine = newEndLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION2__END_LINE, oldEndLine, endLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndOffset() {
		return endOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndOffset(int newEndOffset) {
		int oldEndOffset = endOffset;
		endOffset = newEndOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION2__END_OFFSET, oldEndOffset, endOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBlockMode() {
		return blockMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlockMode(boolean newBlockMode) {
		boolean oldBlockMode = blockMode;
		blockMode = newBlockMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.SET_TEXT_SELECTION2__BLOCK_MODE, oldBlockMode, blockMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProtocolPackage.SET_TEXT_SELECTION2__ELEMENT:
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
			case ProtocolPackage.SET_TEXT_SELECTION2__ID:
				return getId();
			case ProtocolPackage.SET_TEXT_SELECTION2__ELEMENT:
				return getElement();
			case ProtocolPackage.SET_TEXT_SELECTION2__START_LINE:
				return getStartLine();
			case ProtocolPackage.SET_TEXT_SELECTION2__START_OFFSET:
				return getStartOffset();
			case ProtocolPackage.SET_TEXT_SELECTION2__END_LINE:
				return getEndLine();
			case ProtocolPackage.SET_TEXT_SELECTION2__END_OFFSET:
				return getEndOffset();
			case ProtocolPackage.SET_TEXT_SELECTION2__BLOCK_MODE:
				return isBlockMode();
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
			case ProtocolPackage.SET_TEXT_SELECTION2__ID:
				setId((Integer)newValue);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION2__ELEMENT:
				setElement((Element)newValue);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION2__START_LINE:
				setStartLine((Integer)newValue);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION2__START_OFFSET:
				setStartOffset((Integer)newValue);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION2__END_LINE:
				setEndLine((Integer)newValue);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION2__END_OFFSET:
				setEndOffset((Integer)newValue);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION2__BLOCK_MODE:
				setBlockMode((Boolean)newValue);
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
			case ProtocolPackage.SET_TEXT_SELECTION2__ID:
				setId(ID_EDEFAULT);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION2__ELEMENT:
				setElement((Element)null);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION2__START_LINE:
				setStartLine(START_LINE_EDEFAULT);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION2__START_OFFSET:
				setStartOffset(START_OFFSET_EDEFAULT);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION2__END_LINE:
				setEndLine(END_LINE_EDEFAULT);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION2__END_OFFSET:
				setEndOffset(END_OFFSET_EDEFAULT);
				return;
			case ProtocolPackage.SET_TEXT_SELECTION2__BLOCK_MODE:
				setBlockMode(BLOCK_MODE_EDEFAULT);
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
			case ProtocolPackage.SET_TEXT_SELECTION2__ID:
				return id != ID_EDEFAULT;
			case ProtocolPackage.SET_TEXT_SELECTION2__ELEMENT:
				return element != null;
			case ProtocolPackage.SET_TEXT_SELECTION2__START_LINE:
				return startLine != START_LINE_EDEFAULT;
			case ProtocolPackage.SET_TEXT_SELECTION2__START_OFFSET:
				return startOffset != START_OFFSET_EDEFAULT;
			case ProtocolPackage.SET_TEXT_SELECTION2__END_LINE:
				return endLine != END_LINE_EDEFAULT;
			case ProtocolPackage.SET_TEXT_SELECTION2__END_OFFSET:
				return endOffset != END_OFFSET_EDEFAULT;
			case ProtocolPackage.SET_TEXT_SELECTION2__BLOCK_MODE:
				return blockMode != BLOCK_MODE_EDEFAULT;
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
		result.append(", startLine: ");
		result.append(startLine);
		result.append(", startOffset: ");
		result.append(startOffset);
		result.append(", endLine: ");
		result.append(endLine);
		result.append(", endOffset: ");
		result.append(endOffset);
		result.append(", blockMode: ");
		result.append(blockMode);
		result.append(')');
		return result.toString();
	}

} //SetTextSelection2Impl
