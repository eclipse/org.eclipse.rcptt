/*******************************************************************************
 * Copyright (c) 2014-2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.tesla.core.protocol.diagram.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigureResponse;
import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

import org.eclipse.rcptt.tesla.core.protocol.raw.impl.ResponseImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Figure Response</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateFigureResponseImpl#getFigure <em>Figure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreateFigureResponseImpl extends ResponseImpl implements CreateFigureResponse {
	/**
	 * The cached value of the '{@link #getFigure() <em>Figure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFigure()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> figure;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateFigureResponseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.CREATE_FIGURE_RESPONSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getFigure() {
		if (figure == null) {
			figure = new EObjectContainmentEList<Element>(Element.class, this, DiagramPackage.CREATE_FIGURE_RESPONSE__FIGURE);
		}
		return figure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.CREATE_FIGURE_RESPONSE__FIGURE:
				return ((InternalEList<?>)getFigure()).basicRemove(otherEnd, msgs);
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
			case DiagramPackage.CREATE_FIGURE_RESPONSE__FIGURE:
				return getFigure();
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
			case DiagramPackage.CREATE_FIGURE_RESPONSE__FIGURE:
				getFigure().clear();
				getFigure().addAll((Collection<? extends Element>)newValue);
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
			case DiagramPackage.CREATE_FIGURE_RESPONSE__FIGURE:
				getFigure().clear();
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
			case DiagramPackage.CREATE_FIGURE_RESPONSE__FIGURE:
				return figure != null && !figure.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CreateFigureResponseImpl
