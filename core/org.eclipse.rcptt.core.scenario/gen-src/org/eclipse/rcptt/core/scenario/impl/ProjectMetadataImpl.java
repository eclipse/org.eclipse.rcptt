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

import org.eclipse.rcptt.core.scenario.ProjectMetadata;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project Metadata</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.ProjectMetadataImpl#getContexts <em>Contexts</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.ProjectMetadataImpl#getIgnores <em>Ignores</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.ProjectMetadataImpl#getVerifications <em>Verifications</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectMetadataImpl extends NamedElementImpl implements ProjectMetadata {
	/**
	 * The cached value of the '{@link #getContexts() <em>Contexts</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContexts()
	 * @generated
	 * @ordered
	 */
	protected EList<String> contexts;

	/**
	 * The cached value of the '{@link #getIgnores() <em>Ignores</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIgnores()
	 * @generated
	 * @ordered
	 */
	protected EList<String> ignores;

	/**
	 * The cached value of the '{@link #getVerifications() <em>Verifications</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerifications()
	 * @generated
	 * @ordered
	 */
	protected EList<String> verifications;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectMetadataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScenarioPackage.Literals.PROJECT_METADATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getContexts() {
		if (contexts == null) {
			contexts = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.PROJECT_METADATA__CONTEXTS);
		}
		return contexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getIgnores() {
		if (ignores == null) {
			ignores = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.PROJECT_METADATA__IGNORES);
		}
		return ignores;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getVerifications() {
		if (verifications == null) {
			verifications = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.PROJECT_METADATA__VERIFICATIONS);
		}
		return verifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScenarioPackage.PROJECT_METADATA__CONTEXTS:
				return getContexts();
			case ScenarioPackage.PROJECT_METADATA__IGNORES:
				return getIgnores();
			case ScenarioPackage.PROJECT_METADATA__VERIFICATIONS:
				return getVerifications();
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
			case ScenarioPackage.PROJECT_METADATA__CONTEXTS:
				getContexts().clear();
				getContexts().addAll((Collection<? extends String>)newValue);
				return;
			case ScenarioPackage.PROJECT_METADATA__IGNORES:
				getIgnores().clear();
				getIgnores().addAll((Collection<? extends String>)newValue);
				return;
			case ScenarioPackage.PROJECT_METADATA__VERIFICATIONS:
				getVerifications().clear();
				getVerifications().addAll((Collection<? extends String>)newValue);
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
			case ScenarioPackage.PROJECT_METADATA__CONTEXTS:
				getContexts().clear();
				return;
			case ScenarioPackage.PROJECT_METADATA__IGNORES:
				getIgnores().clear();
				return;
			case ScenarioPackage.PROJECT_METADATA__VERIFICATIONS:
				getVerifications().clear();
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
			case ScenarioPackage.PROJECT_METADATA__CONTEXTS:
				return contexts != null && !contexts.isEmpty();
			case ScenarioPackage.PROJECT_METADATA__IGNORES:
				return ignores != null && !ignores.isEmpty();
			case ScenarioPackage.PROJECT_METADATA__VERIFICATIONS:
				return verifications != null && !verifications.isEmpty();
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
		result.append(" (contexts: ");
		result.append(contexts);
		result.append(", ignores: ");
		result.append(ignores);
		result.append(", verifications: ");
		result.append(verifications);
		result.append(')');
		return result.toString();
	}

} //ProjectMetadataImpl
