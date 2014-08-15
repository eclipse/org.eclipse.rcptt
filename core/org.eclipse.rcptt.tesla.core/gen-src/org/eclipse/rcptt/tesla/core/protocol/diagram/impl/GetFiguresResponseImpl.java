/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.tesla.core.protocol.diagram.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage;
import org.eclipse.rcptt.tesla.core.protocol.diagram.GetFiguresResponse;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

import org.eclipse.rcptt.tesla.core.protocol.raw.impl.ResponseImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Get Figures Response</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.GetFiguresResponseImpl#getFigures <em>Figures</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GetFiguresResponseImpl extends ResponseImpl implements GetFiguresResponse {
	/**
	 * The cached value of the '{@link #getFigures() <em>Figures</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFigures()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> figures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GetFiguresResponseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.GET_FIGURES_RESPONSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getFigures() {
		if (figures == null) {
			figures = new EObjectContainmentEList<Element>(Element.class, this, DiagramPackage.GET_FIGURES_RESPONSE__FIGURES);
		}
		return figures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.GET_FIGURES_RESPONSE__FIGURES:
				return ((InternalEList<?>)getFigures()).basicRemove(otherEnd, msgs);
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
			case DiagramPackage.GET_FIGURES_RESPONSE__FIGURES:
				return getFigures();
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
			case DiagramPackage.GET_FIGURES_RESPONSE__FIGURES:
				getFigures().clear();
				getFigures().addAll((Collection<? extends Element>)newValue);
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
			case DiagramPackage.GET_FIGURES_RESPONSE__FIGURES:
				getFigures().clear();
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
			case DiagramPackage.GET_FIGURES_RESPONSE__FIGURES:
				return figures != null && !figures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GetFiguresResponseImpl
