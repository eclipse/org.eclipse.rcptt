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
package org.eclipse.rcptt.core.scenario.impl;

import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.scenario.GroupContext;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.GroupContextImpl#getContextReferences <em>Context References</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.GroupContextImpl#getContexts <em>Contexts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupContextImpl extends ContextImpl implements GroupContext {
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
	 * The cached value of the '{@link #getContexts() <em>Contexts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContexts()
	 * @generated
	 * @ordered
	 */
	protected EList<Context> contexts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScenarioPackage.Literals.GROUP_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getContextReferences() {
		if (contextReferences == null) {
			contextReferences = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.GROUP_CONTEXT__CONTEXT_REFERENCES);
		}
		return contextReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Context> getContexts() {
		if (contexts == null) {
			contexts = new EObjectContainmentEList<Context>(Context.class, this, ScenarioPackage.GROUP_CONTEXT__CONTEXTS);
		}
		return contexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScenarioPackage.GROUP_CONTEXT__CONTEXTS:
				return ((InternalEList<?>)getContexts()).basicRemove(otherEnd, msgs);
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
			case ScenarioPackage.GROUP_CONTEXT__CONTEXT_REFERENCES:
				return getContextReferences();
			case ScenarioPackage.GROUP_CONTEXT__CONTEXTS:
				return getContexts();
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
			case ScenarioPackage.GROUP_CONTEXT__CONTEXT_REFERENCES:
				getContextReferences().clear();
				getContextReferences().addAll((Collection<? extends String>)newValue);
				return;
			case ScenarioPackage.GROUP_CONTEXT__CONTEXTS:
				getContexts().clear();
				getContexts().addAll((Collection<? extends Context>)newValue);
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
			case ScenarioPackage.GROUP_CONTEXT__CONTEXT_REFERENCES:
				getContextReferences().clear();
				return;
			case ScenarioPackage.GROUP_CONTEXT__CONTEXTS:
				getContexts().clear();
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
			case ScenarioPackage.GROUP_CONTEXT__CONTEXT_REFERENCES:
				return contextReferences != null && !contextReferences.isEmpty();
			case ScenarioPackage.GROUP_CONTEXT__CONTEXTS:
				return contexts != null && !contexts.isEmpty();
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
		result.append(" (contextReferences: ");
		result.append(contextReferences);
		result.append(')');
		return result.toString();
	}

} //GroupContextImpl
