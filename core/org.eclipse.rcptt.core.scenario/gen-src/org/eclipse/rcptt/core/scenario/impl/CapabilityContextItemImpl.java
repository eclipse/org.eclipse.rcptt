/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
/**
 */
package org.eclipse.rcptt.core.scenario.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.rcptt.core.scenario.CapabilityContextItem;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Capability Context Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.CapabilityContextItemImpl#getCapability <em>Capability</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.CapabilityContextItemImpl#getContextReferences <em>Context References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CapabilityContextItemImpl extends EObjectImpl implements CapabilityContextItem {
	/**
	 * The cached value of the '{@link #getCapability() <em>Capability</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapability()
	 * @generated
	 * @ordered
	 */
	protected EList<String> capability;

	/**
	 * The cached value of the '{@link #getContextReferences() <em>Context References</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<String> contextReferences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CapabilityContextItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScenarioPackage.Literals.CAPABILITY_CONTEXT_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCapability() {
		if (capability == null) {
			capability = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.CAPABILITY_CONTEXT_ITEM__CAPABILITY);
		}
		return capability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getContextReferences() {
		if (contextReferences == null) {
			contextReferences = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.CAPABILITY_CONTEXT_ITEM__CONTEXT_REFERENCES);
		}
		return contextReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScenarioPackage.CAPABILITY_CONTEXT_ITEM__CAPABILITY:
				return getCapability();
			case ScenarioPackage.CAPABILITY_CONTEXT_ITEM__CONTEXT_REFERENCES:
				return getContextReferences();
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
			case ScenarioPackage.CAPABILITY_CONTEXT_ITEM__CAPABILITY:
				getCapability().clear();
				getCapability().addAll((Collection<? extends String>)newValue);
				return;
			case ScenarioPackage.CAPABILITY_CONTEXT_ITEM__CONTEXT_REFERENCES:
				getContextReferences().clear();
				getContextReferences().addAll((Collection<? extends String>)newValue);
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
			case ScenarioPackage.CAPABILITY_CONTEXT_ITEM__CAPABILITY:
				getCapability().clear();
				return;
			case ScenarioPackage.CAPABILITY_CONTEXT_ITEM__CONTEXT_REFERENCES:
				getContextReferences().clear();
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
			case ScenarioPackage.CAPABILITY_CONTEXT_ITEM__CAPABILITY:
				return capability != null && !capability.isEmpty();
			case ScenarioPackage.CAPABILITY_CONTEXT_ITEM__CONTEXT_REFERENCES:
				return contextReferences != null && !contextReferences.isEmpty();
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
		result.append(" (Capability: ");
		result.append(capability);
		result.append(", contextReferences: ");
		result.append(contextReferences);
		result.append(')');
		return result.toString();
	}

} //CapabilityContextItemImpl
