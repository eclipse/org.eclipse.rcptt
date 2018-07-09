/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
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

import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;
import org.eclipse.rcptt.tesla.core.protocol.Type;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.TypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.TypeImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.TypeImpl#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.TypeImpl#getCode <em>Code</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.TypeImpl#isFromDisplay <em>From Display</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.TypeImpl#getCharacter <em>Character</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.TypeImpl#getMeta <em>Meta</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.TypeImpl#isTraverse <em>Traverse</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.TypeImpl#getTimes <em>Times</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeImpl extends EObjectImpl implements Type {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected Element element;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final Integer STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected Integer state = STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected static final Integer CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected Integer code = CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #isFromDisplay() <em>From Display</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isFromDisplay()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FROM_DISPLAY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFromDisplay() <em>From Display</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isFromDisplay()
	 * @generated
	 * @ordered
	 */
	protected boolean fromDisplay = FROM_DISPLAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCharacter() <em>Character</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCharacter()
	 * @generated
	 * @ordered
	 */
	protected static final char CHARACTER_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getCharacter() <em>Character</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCharacter()
	 * @generated
	 * @ordered
	 */
	protected char character = CHARACTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMeta() <em>Meta</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMeta()
	 * @generated
	 * @ordered
	 */
	protected static final Integer META_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMeta() <em>Meta</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMeta()
	 * @generated
	 * @ordered
	 */
	protected Integer meta = META_EDEFAULT;

	/**
	 * The default value of the '{@link #isTraverse() <em>Traverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTraverse()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRAVERSE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTraverse() <em>Traverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTraverse()
	 * @generated
	 * @ordered
	 */
	protected boolean traverse = TRAVERSE_EDEFAULT;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProtocolPackage.Literals.TYPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Element getElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElement(Element newElement,
			NotificationChain msgs) {
		Element oldElement = element;
		element = newElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProtocolPackage.TYPE__ELEMENT, oldElement, newElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(Element newElement) {
		if (newElement != element) {
			NotificationChain msgs = null;
			if (element != null)
				msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProtocolPackage.TYPE__ELEMENT, null, msgs);
			if (newElement != null)
				msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProtocolPackage.TYPE__ELEMENT, null, msgs);
			msgs = basicSetElement(newElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.TYPE__ELEMENT, newElement, newElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(Integer newState) {
		Integer oldState = state;
		state = newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.TYPE__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCode(Integer newCode) {
		Integer oldCode = code;
		code = newCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.TYPE__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFromDisplay() {
		return fromDisplay;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromDisplay(boolean newFromDisplay) {
		boolean oldFromDisplay = fromDisplay;
		fromDisplay = newFromDisplay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.TYPE__FROM_DISPLAY, oldFromDisplay, fromDisplay));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public char getCharacter() {
		return character;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharacter(char newCharacter) {
		char oldCharacter = character;
		character = newCharacter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.TYPE__CHARACTER, oldCharacter, character));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getMeta() {
		return meta;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeta(Integer newMeta) {
		Integer oldMeta = meta;
		meta = newMeta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.TYPE__META, oldMeta, meta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTraverse() {
		return traverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraverse(boolean newTraverse) {
		boolean oldTraverse = traverse;
		traverse = newTraverse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.TYPE__TRAVERSE, oldTraverse, traverse));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.TYPE__TIMES, oldTimes, times));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProtocolPackage.TYPE__ELEMENT:
				return basicSetElement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProtocolPackage.TYPE__ID:
				return getId();
			case ProtocolPackage.TYPE__ELEMENT:
				return getElement();
			case ProtocolPackage.TYPE__STATE:
				return getState();
			case ProtocolPackage.TYPE__CODE:
				return getCode();
			case ProtocolPackage.TYPE__FROM_DISPLAY:
				return isFromDisplay();
			case ProtocolPackage.TYPE__CHARACTER:
				return getCharacter();
			case ProtocolPackage.TYPE__META:
				return getMeta();
			case ProtocolPackage.TYPE__TRAVERSE:
				return isTraverse();
			case ProtocolPackage.TYPE__TIMES:
				return getTimes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProtocolPackage.TYPE__ID:
				setId((Integer)newValue);
				return;
			case ProtocolPackage.TYPE__ELEMENT:
				setElement((Element)newValue);
				return;
			case ProtocolPackage.TYPE__STATE:
				setState((Integer)newValue);
				return;
			case ProtocolPackage.TYPE__CODE:
				setCode((Integer)newValue);
				return;
			case ProtocolPackage.TYPE__FROM_DISPLAY:
				setFromDisplay((Boolean)newValue);
				return;
			case ProtocolPackage.TYPE__CHARACTER:
				setCharacter((Character)newValue);
				return;
			case ProtocolPackage.TYPE__META:
				setMeta((Integer)newValue);
				return;
			case ProtocolPackage.TYPE__TRAVERSE:
				setTraverse((Boolean)newValue);
				return;
			case ProtocolPackage.TYPE__TIMES:
				setTimes((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ProtocolPackage.TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case ProtocolPackage.TYPE__ELEMENT:
				setElement((Element)null);
				return;
			case ProtocolPackage.TYPE__STATE:
				setState(STATE_EDEFAULT);
				return;
			case ProtocolPackage.TYPE__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case ProtocolPackage.TYPE__FROM_DISPLAY:
				setFromDisplay(FROM_DISPLAY_EDEFAULT);
				return;
			case ProtocolPackage.TYPE__CHARACTER:
				setCharacter(CHARACTER_EDEFAULT);
				return;
			case ProtocolPackage.TYPE__META:
				setMeta(META_EDEFAULT);
				return;
			case ProtocolPackage.TYPE__TRAVERSE:
				setTraverse(TRAVERSE_EDEFAULT);
				return;
			case ProtocolPackage.TYPE__TIMES:
				setTimes(TIMES_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ProtocolPackage.TYPE__ID:
				return id != ID_EDEFAULT;
			case ProtocolPackage.TYPE__ELEMENT:
				return element != null;
			case ProtocolPackage.TYPE__STATE:
				return STATE_EDEFAULT == null ? state != null : !STATE_EDEFAULT.equals(state);
			case ProtocolPackage.TYPE__CODE:
				return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
			case ProtocolPackage.TYPE__FROM_DISPLAY:
				return fromDisplay != FROM_DISPLAY_EDEFAULT;
			case ProtocolPackage.TYPE__CHARACTER:
				return character != CHARACTER_EDEFAULT;
			case ProtocolPackage.TYPE__META:
				return META_EDEFAULT == null ? meta != null : !META_EDEFAULT.equals(meta);
			case ProtocolPackage.TYPE__TRAVERSE:
				return traverse != TRAVERSE_EDEFAULT;
			case ProtocolPackage.TYPE__TIMES:
				return TIMES_EDEFAULT == null ? times != null : !TIMES_EDEFAULT.equals(times);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", state: ");
		result.append(state);
		result.append(", code: ");
		result.append(code);
		result.append(", fromDisplay: ");
		result.append(fromDisplay);
		result.append(", character: ");
		result.append(character);
		result.append(", meta: ");
		result.append(meta);
		result.append(", traverse: ");
		result.append(traverse);
		result.append(", times: ");
		result.append(times);
		result.append(')');
		return result.toString();
	}

} // TypeImpl
