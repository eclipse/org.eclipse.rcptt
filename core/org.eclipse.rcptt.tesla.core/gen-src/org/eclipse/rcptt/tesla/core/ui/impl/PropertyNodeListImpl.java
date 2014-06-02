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
package org.eclipse.rcptt.tesla.core.ui.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.rcptt.tesla.core.ui.PropertyNode;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeList;
import org.eclipse.rcptt.tesla.core.ui.UiPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Property Node List</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.PropertyNodeListImpl#getPropertyNodes <em>Property Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyNodeListImpl extends EObjectImpl implements PropertyNodeList {
	/**
	 * The cached value of the '{@link #getPropertyNodes() <em>Property Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPropertyNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyNode> propertyNodes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyNodeListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiPackage.Literals.PROPERTY_NODE_LIST;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyNode> getPropertyNodes() {
		if (propertyNodes == null) {
			propertyNodes = new EObjectContainmentEList<PropertyNode>(PropertyNode.class, this, UiPackage.PROPERTY_NODE_LIST__PROPERTY_NODES);
		}
		return propertyNodes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UiPackage.PROPERTY_NODE_LIST__PROPERTY_NODES:
				return ((InternalEList<?>)getPropertyNodes()).basicRemove(otherEnd, msgs);
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
			case UiPackage.PROPERTY_NODE_LIST__PROPERTY_NODES:
				return getPropertyNodes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UiPackage.PROPERTY_NODE_LIST__PROPERTY_NODES:
				getPropertyNodes().clear();
				getPropertyNodes().addAll((Collection<? extends PropertyNode>)newValue);
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
			case UiPackage.PROPERTY_NODE_LIST__PROPERTY_NODES:
				getPropertyNodes().clear();
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
			case UiPackage.PROPERTY_NODE_LIST__PROPERTY_NODES:
				return propertyNodes != null && !propertyNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // PropertyNodeListImpl
