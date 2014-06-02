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
package org.eclipse.rcptt.verifications.tree.impl;

import org.eclipse.rcptt.core.scenario.impl.WidgetVerificationImpl;

import org.eclipse.rcptt.verifications.tree.CommonTreeVerificationData;
import org.eclipse.rcptt.verifications.tree.Tree;
import org.eclipse.rcptt.verifications.tree.TreePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Common Tree Verification Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.tree.impl.CommonTreeVerificationDataImpl#getTree <em>Tree</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommonTreeVerificationDataImpl extends WidgetVerificationImpl implements CommonTreeVerificationData {
	/**
	 * The cached value of the '{@link #getTree() <em>Tree</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTree()
	 * @generated
	 * @ordered
	 */
	protected Tree tree;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommonTreeVerificationDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TreePackage.Literals.COMMON_TREE_VERIFICATION_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tree getTree() {
		return tree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTree(Tree newTree, NotificationChain msgs) {
		Tree oldTree = tree;
		tree = newTree;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TreePackage.COMMON_TREE_VERIFICATION_DATA__TREE, oldTree, newTree);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTree(Tree newTree) {
		if (newTree != tree) {
			NotificationChain msgs = null;
			if (tree != null)
				msgs = ((InternalEObject)tree).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TreePackage.COMMON_TREE_VERIFICATION_DATA__TREE, null, msgs);
			if (newTree != null)
				msgs = ((InternalEObject)newTree).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TreePackage.COMMON_TREE_VERIFICATION_DATA__TREE, null, msgs);
			msgs = basicSetTree(newTree, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.COMMON_TREE_VERIFICATION_DATA__TREE, newTree, newTree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TreePackage.COMMON_TREE_VERIFICATION_DATA__TREE:
				return basicSetTree(null, msgs);
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
			case TreePackage.COMMON_TREE_VERIFICATION_DATA__TREE:
				return getTree();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TreePackage.COMMON_TREE_VERIFICATION_DATA__TREE:
				setTree((Tree)newValue);
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
			case TreePackage.COMMON_TREE_VERIFICATION_DATA__TREE:
				setTree((Tree)null);
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
			case TreePackage.COMMON_TREE_VERIFICATION_DATA__TREE:
				return tree != null;
		}
		return super.eIsSet(featureID);
	}

} //CommonTreeVerificationDataImpl
