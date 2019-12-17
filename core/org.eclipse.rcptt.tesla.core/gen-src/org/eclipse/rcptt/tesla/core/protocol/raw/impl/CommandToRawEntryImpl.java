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

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage;

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
 * An implementation of the model object '<em><b>Command To Raw Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandToRawEntryImpl#getRawEvents <em>Raw Events</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandToRawEntryImpl#getCommand <em>Command</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommandToRawEntryImpl extends EObjectImpl implements
		CommandToRawEntry {
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
	 * The cached value of the '{@link #getCommand() <em>Command</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	protected Command command;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommandToRawEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RawPackage.Literals.COMMAND_TO_RAW_ENTRY;
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
					RawPackage.COMMAND_TO_RAW_ENTRY__RAW_EVENTS);
		}
		return rawEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Command getCommand() {
		if (command != null && command.eIsProxy())
		{
			InternalEObject oldCommand = (InternalEObject) command;
			command = (Command) eResolveProxy(oldCommand);
			if (command != oldCommand)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RawPackage.COMMAND_TO_RAW_ENTRY__COMMAND,
							oldCommand, command));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.COMMAND_TO_RAW_ENTRY__COMMAND, oldCommand,
					command));
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
		case RawPackage.COMMAND_TO_RAW_ENTRY__RAW_EVENTS:
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
		case RawPackage.COMMAND_TO_RAW_ENTRY__RAW_EVENTS:
			return getRawEvents();
		case RawPackage.COMMAND_TO_RAW_ENTRY__COMMAND:
			if (resolve)
				return getCommand();
			return basicGetCommand();
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
		case RawPackage.COMMAND_TO_RAW_ENTRY__RAW_EVENTS:
			getRawEvents().clear();
			getRawEvents().addAll((Collection<? extends RawEvent>) newValue);
			return;
		case RawPackage.COMMAND_TO_RAW_ENTRY__COMMAND:
			setCommand((Command) newValue);
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
		case RawPackage.COMMAND_TO_RAW_ENTRY__RAW_EVENTS:
			getRawEvents().clear();
			return;
		case RawPackage.COMMAND_TO_RAW_ENTRY__COMMAND:
			setCommand((Command) null);
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
		case RawPackage.COMMAND_TO_RAW_ENTRY__RAW_EVENTS:
			return rawEvents != null && !rawEvents.isEmpty();
		case RawPackage.COMMAND_TO_RAW_ENTRY__COMMAND:
			return command != null;
		}
		return super.eIsSet(featureID);
	}

} //CommandToRawEntryImpl
