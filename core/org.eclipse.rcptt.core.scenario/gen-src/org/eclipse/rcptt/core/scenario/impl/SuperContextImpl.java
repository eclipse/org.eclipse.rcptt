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
package org.eclipse.rcptt.core.scenario.impl;

import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.core.scenario.SuperContext;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Super Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.SuperContextImpl#getContextReferences <em>Context References</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.SuperContextImpl#getChildType <em>Child Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SuperContextImpl extends ContextImpl implements SuperContext {
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
	 * The default value of the '{@link #getChildType() <em>Child Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildType()
	 * @generated
	 * @ordered
	 */
	protected static final String CHILD_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChildType() <em>Child Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildType()
	 * @generated
	 * @ordered
	 */
	protected String childType = CHILD_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SuperContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScenarioPackage.Literals.SUPER_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getContextReferences() {
		if (contextReferences == null) {
			contextReferences = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.SUPER_CONTEXT__CONTEXT_REFERENCES);
		}
		return contextReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChildType() {
		return childType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildType(String newChildType) {
		String oldChildType = childType;
		childType = newChildType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.SUPER_CONTEXT__CHILD_TYPE, oldChildType, childType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScenarioPackage.SUPER_CONTEXT__CONTEXT_REFERENCES:
				return getContextReferences();
			case ScenarioPackage.SUPER_CONTEXT__CHILD_TYPE:
				return getChildType();
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
			case ScenarioPackage.SUPER_CONTEXT__CONTEXT_REFERENCES:
				getContextReferences().clear();
				getContextReferences().addAll((Collection<? extends String>)newValue);
				return;
			case ScenarioPackage.SUPER_CONTEXT__CHILD_TYPE:
				setChildType((String)newValue);
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
			case ScenarioPackage.SUPER_CONTEXT__CONTEXT_REFERENCES:
				getContextReferences().clear();
				return;
			case ScenarioPackage.SUPER_CONTEXT__CHILD_TYPE:
				setChildType(CHILD_TYPE_EDEFAULT);
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
			case ScenarioPackage.SUPER_CONTEXT__CONTEXT_REFERENCES:
				return contextReferences != null && !contextReferences.isEmpty();
			case ScenarioPackage.SUPER_CONTEXT__CHILD_TYPE:
				return CHILD_TYPE_EDEFAULT == null ? childType != null : !CHILD_TYPE_EDEFAULT.equals(childType);
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
		result.append(", childType: ");
		result.append(childType);
		result.append(')');
		return result.toString();
	}

} //SuperContextImpl
