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
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario;

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
 * An implementation of the model object '<em><b>Tesla Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.TeslaScenarioImpl#getCommands <em>Commands</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.TeslaScenarioImpl#getElementMapping <em>Element Mapping</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.TeslaScenarioImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.TeslaScenarioImpl#getRequiredContexts <em>Required Contexts</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.TeslaScenarioImpl#getRawMapping <em>Raw Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TeslaScenarioImpl extends EObjectImpl implements TeslaScenario {
	/**
	 * The cached value of the '{@link #getCommands() <em>Commands</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommands()
	 * @generated
	 * @ordered
	 */
	protected EList<Command> commands;

	/**
	 * The cached value of the '{@link #getElementMapping() <em>Element Mapping</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<CommandToElementEntry> elementMapping;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRequiredContexts() <em>Required Contexts</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredContexts()
	 * @generated
	 * @ordered
	 */
	protected EList<String> requiredContexts;

	/**
	 * The cached value of the '{@link #getRawMapping() <em>Raw Mapping</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<CommandToRawEntry> rawMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TeslaScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RawPackage.Literals.TESLA_SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Command> getCommands() {
		if (commands == null)
		{
			commands = new EObjectContainmentEList<Command>(Command.class, this, RawPackage.TESLA_SCENARIO__COMMANDS);
		}
		return commands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CommandToElementEntry> getElementMapping() {
		if (elementMapping == null)
		{
			elementMapping = new EObjectContainmentEList<CommandToElementEntry>(CommandToElementEntry.class, this,
					RawPackage.TESLA_SCENARIO__ELEMENT_MAPPING);
		}
		return elementMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.TESLA_SCENARIO__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getRequiredContexts() {
		if (requiredContexts == null)
		{
			requiredContexts = new EDataTypeUniqueEList<String>(String.class, this,
					RawPackage.TESLA_SCENARIO__REQUIRED_CONTEXTS);
		}
		return requiredContexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CommandToRawEntry> getRawMapping() {
		if (rawMapping == null)
		{
			rawMapping = new EObjectContainmentEList<CommandToRawEntry>(CommandToRawEntry.class, this,
					RawPackage.TESLA_SCENARIO__RAW_MAPPING);
		}
		return rawMapping;
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
		case RawPackage.TESLA_SCENARIO__COMMANDS:
			return ((InternalEList<?>) getCommands()).basicRemove(otherEnd, msgs);
		case RawPackage.TESLA_SCENARIO__ELEMENT_MAPPING:
			return ((InternalEList<?>) getElementMapping()).basicRemove(otherEnd, msgs);
		case RawPackage.TESLA_SCENARIO__RAW_MAPPING:
			return ((InternalEList<?>) getRawMapping()).basicRemove(otherEnd, msgs);
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
		case RawPackage.TESLA_SCENARIO__COMMANDS:
			return getCommands();
		case RawPackage.TESLA_SCENARIO__ELEMENT_MAPPING:
			return getElementMapping();
		case RawPackage.TESLA_SCENARIO__ID:
			return getId();
		case RawPackage.TESLA_SCENARIO__REQUIRED_CONTEXTS:
			return getRequiredContexts();
		case RawPackage.TESLA_SCENARIO__RAW_MAPPING:
			return getRawMapping();
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
		case RawPackage.TESLA_SCENARIO__COMMANDS:
			getCommands().clear();
			getCommands().addAll((Collection<? extends Command>) newValue);
			return;
		case RawPackage.TESLA_SCENARIO__ELEMENT_MAPPING:
			getElementMapping().clear();
			getElementMapping().addAll((Collection<? extends CommandToElementEntry>) newValue);
			return;
		case RawPackage.TESLA_SCENARIO__ID:
			setId((String) newValue);
			return;
		case RawPackage.TESLA_SCENARIO__REQUIRED_CONTEXTS:
			getRequiredContexts().clear();
			getRequiredContexts().addAll((Collection<? extends String>) newValue);
			return;
		case RawPackage.TESLA_SCENARIO__RAW_MAPPING:
			getRawMapping().clear();
			getRawMapping().addAll((Collection<? extends CommandToRawEntry>) newValue);
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
		case RawPackage.TESLA_SCENARIO__COMMANDS:
			getCommands().clear();
			return;
		case RawPackage.TESLA_SCENARIO__ELEMENT_MAPPING:
			getElementMapping().clear();
			return;
		case RawPackage.TESLA_SCENARIO__ID:
			setId(ID_EDEFAULT);
			return;
		case RawPackage.TESLA_SCENARIO__REQUIRED_CONTEXTS:
			getRequiredContexts().clear();
			return;
		case RawPackage.TESLA_SCENARIO__RAW_MAPPING:
			getRawMapping().clear();
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
		case RawPackage.TESLA_SCENARIO__COMMANDS:
			return commands != null && !commands.isEmpty();
		case RawPackage.TESLA_SCENARIO__ELEMENT_MAPPING:
			return elementMapping != null && !elementMapping.isEmpty();
		case RawPackage.TESLA_SCENARIO__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case RawPackage.TESLA_SCENARIO__REQUIRED_CONTEXTS:
			return requiredContexts != null && !requiredContexts.isEmpty();
		case RawPackage.TESLA_SCENARIO__RAW_MAPPING:
			return rawMapping != null && !rawMapping.isEmpty();
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
		result.append(", requiredContexts: ");
		result.append(requiredContexts);
		result.append(')');
		return result.toString();
	}

} //TeslaScenarioImpl
