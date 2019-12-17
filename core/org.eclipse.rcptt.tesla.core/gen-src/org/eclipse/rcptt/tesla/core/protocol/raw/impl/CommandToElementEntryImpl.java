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
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
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
 * An implementation of the model object '<em><b>Command To Element Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandToElementEntryImpl#getCommand <em>Command</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandToElementEntryImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.CommandToElementEntryImpl#getControls <em>Controls</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommandToElementEntryImpl extends EObjectImpl implements
		CommandToElementEntry {
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
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> elements;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommandToElementEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RawPackage.Literals.COMMAND_TO_ELEMENT_ENTRY;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RawPackage.COMMAND_TO_ELEMENT_ENTRY__COMMAND, oldCommand, command));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.COMMAND_TO_ELEMENT_ENTRY__COMMAND,
					oldCommand, command));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getElements() {
		if (elements == null)
		{
			elements = new EObjectContainmentEList<Element>(Element.class, this,
					RawPackage.COMMAND_TO_ELEMENT_ENTRY__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Widget> getControls() {
		if (controls == null)
		{
			controls = new EObjectContainmentEList<Widget>(Widget.class, this,
					RawPackage.COMMAND_TO_ELEMENT_ENTRY__CONTROLS);
		}
		return controls;
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
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY__ELEMENTS:
			return ((InternalEList<?>) getElements()).basicRemove(otherEnd, msgs);
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY__CONTROLS:
			return ((InternalEList<?>) getControls()).basicRemove(otherEnd, msgs);
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
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY__COMMAND:
			if (resolve)
				return getCommand();
			return basicGetCommand();
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY__ELEMENTS:
			return getElements();
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY__CONTROLS:
			return getControls();
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
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY__COMMAND:
			setCommand((Command) newValue);
			return;
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY__ELEMENTS:
			getElements().clear();
			getElements().addAll((Collection<? extends Element>) newValue);
			return;
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY__CONTROLS:
			getControls().clear();
			getControls().addAll((Collection<? extends Widget>) newValue);
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
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY__COMMAND:
			setCommand((Command) null);
			return;
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY__ELEMENTS:
			getElements().clear();
			return;
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY__CONTROLS:
			getControls().clear();
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
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY__COMMAND:
			return command != null;
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY__ELEMENTS:
			return elements != null && !elements.isEmpty();
		case RawPackage.COMMAND_TO_ELEMENT_ENTRY__CONTROLS:
			return controls != null && !controls.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CommandToElementEntryImpl
