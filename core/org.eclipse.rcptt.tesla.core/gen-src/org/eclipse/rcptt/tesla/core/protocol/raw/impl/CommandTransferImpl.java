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
package org.eclipse.rcptt.tesla.core.protocol.raw.impl;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransferKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage;

import org.eclipse.rcptt.tesla.core.ui.Widget;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command Transfer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandTransferImpl#getCommand <em>Command</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandTransferImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandTransferImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandTransferImpl#getControls <em>Controls</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandTransferImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandTransferImpl#getRawEvents <em>Raw Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommandTransferImpl extends EObjectImpl implements CommandTransfer {
	/**
	 * The cached value of the '{@link #getCommand() <em>Command</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	protected Command command;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> elements;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final CommandTransferKind KIND_EDEFAULT = CommandTransferKind.DEFAULT;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected CommandTransferKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getControls() <em>Controls</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControls()
	 * @generated
	 * @ordered
	 */
	protected EList<Widget> controls;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRawEvents() <em>Raw Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<RawEvent> rawEvents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommandTransferImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RawPackage.Literals.COMMAND_TRANSFER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command getCommand() {
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCommand(Command newCommand,
			NotificationChain msgs) {
		Command oldCommand = command;
		command = newCommand;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					RawPackage.COMMAND_TRANSFER__COMMAND, oldCommand, newCommand);
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
	public void setCommand(Command newCommand) {
		if (newCommand != command)
		{
			NotificationChain msgs = null;
			if (command != null)
				msgs = ((InternalEObject) command).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- RawPackage.COMMAND_TRANSFER__COMMAND, null, msgs);
			if (newCommand != null)
				msgs = ((InternalEObject) newCommand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- RawPackage.COMMAND_TRANSFER__COMMAND, null, msgs);
			msgs = basicSetCommand(newCommand, msgs);
			if (msgs != null)
				msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.COMMAND_TRANSFER__COMMAND, newCommand,
					newCommand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getElements() {
		if (elements == null)
		{
			elements = new EObjectContainmentEList<Element>(Element.class, this, RawPackage.COMMAND_TRANSFER__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandTransferKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(CommandTransferKind newKind) {
		CommandTransferKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.COMMAND_TRANSFER__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Widget> getControls() {
		if (controls == null)
		{
			controls = new EObjectContainmentEList<Widget>(Widget.class, this, RawPackage.COMMAND_TRANSFER__CONTROLS);
		}
		return controls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(int newIndex) {
		int oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.COMMAND_TRANSFER__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RawEvent> getRawEvents() {
		if (rawEvents == null)
		{
			rawEvents = new EObjectContainmentEList<RawEvent>(RawEvent.class, this,
					RawPackage.COMMAND_TRANSFER__RAW_EVENTS);
		}
		return rawEvents;
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
		case RawPackage.COMMAND_TRANSFER__COMMAND:
			return basicSetCommand(null, msgs);
		case RawPackage.COMMAND_TRANSFER__ELEMENTS:
			return ((InternalEList<?>) getElements()).basicRemove(otherEnd, msgs);
		case RawPackage.COMMAND_TRANSFER__CONTROLS:
			return ((InternalEList<?>) getControls()).basicRemove(otherEnd, msgs);
		case RawPackage.COMMAND_TRANSFER__RAW_EVENTS:
			return ((InternalEList<?>) getRawEvents()).basicRemove(otherEnd, msgs);
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
		case RawPackage.COMMAND_TRANSFER__COMMAND:
			return getCommand();
		case RawPackage.COMMAND_TRANSFER__ELEMENTS:
			return getElements();
		case RawPackage.COMMAND_TRANSFER__KIND:
			return getKind();
		case RawPackage.COMMAND_TRANSFER__CONTROLS:
			return getControls();
		case RawPackage.COMMAND_TRANSFER__INDEX:
			return getIndex();
		case RawPackage.COMMAND_TRANSFER__RAW_EVENTS:
			return getRawEvents();
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
		switch (featureID)
		{
		case RawPackage.COMMAND_TRANSFER__COMMAND:
			setCommand((Command) newValue);
			return;
		case RawPackage.COMMAND_TRANSFER__ELEMENTS:
			getElements().clear();
			getElements().addAll((Collection<? extends Element>) newValue);
			return;
		case RawPackage.COMMAND_TRANSFER__KIND:
			setKind((CommandTransferKind) newValue);
			return;
		case RawPackage.COMMAND_TRANSFER__CONTROLS:
			getControls().clear();
			getControls().addAll((Collection<? extends Widget>) newValue);
			return;
		case RawPackage.COMMAND_TRANSFER__INDEX:
			setIndex((Integer) newValue);
			return;
		case RawPackage.COMMAND_TRANSFER__RAW_EVENTS:
			getRawEvents().clear();
			getRawEvents().addAll((Collection<? extends RawEvent>) newValue);
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
		case RawPackage.COMMAND_TRANSFER__COMMAND:
			setCommand((Command) null);
			return;
		case RawPackage.COMMAND_TRANSFER__ELEMENTS:
			getElements().clear();
			return;
		case RawPackage.COMMAND_TRANSFER__KIND:
			setKind(KIND_EDEFAULT);
			return;
		case RawPackage.COMMAND_TRANSFER__CONTROLS:
			getControls().clear();
			return;
		case RawPackage.COMMAND_TRANSFER__INDEX:
			setIndex(INDEX_EDEFAULT);
			return;
		case RawPackage.COMMAND_TRANSFER__RAW_EVENTS:
			getRawEvents().clear();
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
		case RawPackage.COMMAND_TRANSFER__COMMAND:
			return command != null;
		case RawPackage.COMMAND_TRANSFER__ELEMENTS:
			return elements != null && !elements.isEmpty();
		case RawPackage.COMMAND_TRANSFER__KIND:
			return kind != KIND_EDEFAULT;
		case RawPackage.COMMAND_TRANSFER__CONTROLS:
			return controls != null && !controls.isEmpty();
		case RawPackage.COMMAND_TRANSFER__INDEX:
			return index != INDEX_EDEFAULT;
		case RawPackage.COMMAND_TRANSFER__RAW_EVENTS:
			return rawEvents != null && !rawEvents.isEmpty();
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(", index: ");
		result.append(index);
		result.append(')');
		return result.toString();
	}

} //CommandTransferImpl
