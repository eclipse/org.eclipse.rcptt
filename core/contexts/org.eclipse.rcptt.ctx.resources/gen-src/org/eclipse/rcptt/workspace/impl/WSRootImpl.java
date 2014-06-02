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
package org.eclipse.rcptt.workspace.impl;

import org.eclipse.rcptt.workspace.WSProject;
import org.eclipse.rcptt.workspace.WSProjectLink;
import org.eclipse.rcptt.workspace.WSRoot;
import org.eclipse.rcptt.workspace.WorkspacePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WS Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.workspace.impl.WSRootImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.eclipse.rcptt.workspace.impl.WSRootImpl#getProjectLinks <em>Project Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WSRootImpl extends WSContainerImpl implements WSRoot {
	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<WSProject> projects;

	/**
	 * The cached value of the '{@link #getProjectLinks() <em>Project Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<WSProjectLink> projectLinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WSRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.WS_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WSProject> getProjects() {
		if (projects == null) {
			projects = new EObjectContainmentEList<WSProject>(WSProject.class, this, WorkspacePackage.WS_ROOT__PROJECTS);
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WSProjectLink> getProjectLinks() {
		if (projectLinks == null) {
			projectLinks = new EObjectContainmentEList<WSProjectLink>(WSProjectLink.class, this, WorkspacePackage.WS_ROOT__PROJECT_LINKS);
		}
		return projectLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkspacePackage.WS_ROOT__PROJECTS:
				return ((InternalEList<?>)getProjects()).basicRemove(otherEnd, msgs);
			case WorkspacePackage.WS_ROOT__PROJECT_LINKS:
				return ((InternalEList<?>)getProjectLinks()).basicRemove(otherEnd, msgs);
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
			case WorkspacePackage.WS_ROOT__PROJECTS:
				return getProjects();
			case WorkspacePackage.WS_ROOT__PROJECT_LINKS:
				return getProjectLinks();
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
			case WorkspacePackage.WS_ROOT__PROJECTS:
				getProjects().clear();
				getProjects().addAll((Collection<? extends WSProject>)newValue);
				return;
			case WorkspacePackage.WS_ROOT__PROJECT_LINKS:
				getProjectLinks().clear();
				getProjectLinks().addAll((Collection<? extends WSProjectLink>)newValue);
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
			case WorkspacePackage.WS_ROOT__PROJECTS:
				getProjects().clear();
				return;
			case WorkspacePackage.WS_ROOT__PROJECT_LINKS:
				getProjectLinks().clear();
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
			case WorkspacePackage.WS_ROOT__PROJECTS:
				return projects != null && !projects.isEmpty();
			case WorkspacePackage.WS_ROOT__PROJECT_LINKS:
				return projectLinks != null && !projectLinks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //WSRootImpl
