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

import org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnectionResponse;
import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

import org.eclipse.rcptt.tesla.core.protocol.raw.impl.ResponseImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Connection Response</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.CreateConnectionResponseImpl#getFigure <em>Figure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreateConnectionResponseImpl extends ResponseImpl implements CreateConnectionResponse {
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
	protected CreateConnectionResponseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.CREATE_CONNECTION_RESPONSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getFigure() {
		if (figure == null) {
			figure = new EObjectContainmentEList<Element>(Element.class, this, DiagramPackage.CREATE_CONNECTION_RESPONSE__FIGURE);
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
			case DiagramPackage.CREATE_CONNECTION_RESPONSE__FIGURE:
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
			case DiagramPackage.CREATE_CONNECTION_RESPONSE__FIGURE:
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
			case DiagramPackage.CREATE_CONNECTION_RESPONSE__FIGURE:
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
			case DiagramPackage.CREATE_CONNECTION_RESPONSE__FIGURE:
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
			case DiagramPackage.CREATE_CONNECTION_RESPONSE__FIGURE:
				return figure != null && !figure.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CreateConnectionResponseImpl
