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
package org.eclipse.rcptt.tesla.core.protocol.diagram.impl;

import org.eclipse.rcptt.tesla.core.protocol.diagram.AssertFigureExists;
import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assert Figure Exists</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.AssertFigureExistsImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.AssertFigureExistsImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.AssertFigureExistsImpl#getPartPath <em>Part Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.AssertFigureExistsImpl#getFigureID <em>Figure ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssertFigureExistsImpl extends EObjectImpl implements AssertFigureExists {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected Element element;

	/**
	 * The cached value of the '{@link #getPartPath() <em>Part Path</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartPath()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> partPath;

	/**
	 * The default value of the '{@link #getFigureID() <em>Figure ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFigureID()
	 * @generated
	 * @ordered
	 */
	protected static final String FIGURE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFigureID() <em>Figure ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFigureID()
	 * @generated
	 * @ordered
	 */
	protected String figureID = FIGURE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssertFigureExistsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.ASSERT_FIGURE_EXISTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.ASSERT_FIGURE_EXISTS__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElement(Element newElement, NotificationChain msgs) {
		Element oldElement = element;
		element = newElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.ASSERT_FIGURE_EXISTS__ELEMENT, oldElement, newElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(Element newElement) {
		if (newElement != element) {
			NotificationChain msgs = null;
			if (element != null)
				msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.ASSERT_FIGURE_EXISTS__ELEMENT, null, msgs);
			if (newElement != null)
				msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.ASSERT_FIGURE_EXISTS__ELEMENT, null, msgs);
			msgs = basicSetElement(newElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.ASSERT_FIGURE_EXISTS__ELEMENT, newElement, newElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getPartPath() {
		if (partPath == null) {
			partPath = new EDataTypeEList<Integer>(Integer.class, this, DiagramPackage.ASSERT_FIGURE_EXISTS__PART_PATH);
		}
		return partPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFigureID() {
		return figureID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFigureID(String newFigureID) {
		String oldFigureID = figureID;
		figureID = newFigureID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.ASSERT_FIGURE_EXISTS__FIGURE_ID, oldFigureID, figureID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.ASSERT_FIGURE_EXISTS__ELEMENT:
				return basicSetElement(null, msgs);
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
			case DiagramPackage.ASSERT_FIGURE_EXISTS__ID:
				return getId();
			case DiagramPackage.ASSERT_FIGURE_EXISTS__ELEMENT:
				return getElement();
			case DiagramPackage.ASSERT_FIGURE_EXISTS__PART_PATH:
				return getPartPath();
			case DiagramPackage.ASSERT_FIGURE_EXISTS__FIGURE_ID:
				return getFigureID();
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
			case DiagramPackage.ASSERT_FIGURE_EXISTS__ID:
				setId((Integer)newValue);
				return;
			case DiagramPackage.ASSERT_FIGURE_EXISTS__ELEMENT:
				setElement((Element)newValue);
				return;
			case DiagramPackage.ASSERT_FIGURE_EXISTS__PART_PATH:
				getPartPath().clear();
				getPartPath().addAll((Collection<? extends Integer>)newValue);
				return;
			case DiagramPackage.ASSERT_FIGURE_EXISTS__FIGURE_ID:
				setFigureID((String)newValue);
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
			case DiagramPackage.ASSERT_FIGURE_EXISTS__ID:
				setId(ID_EDEFAULT);
				return;
			case DiagramPackage.ASSERT_FIGURE_EXISTS__ELEMENT:
				setElement((Element)null);
				return;
			case DiagramPackage.ASSERT_FIGURE_EXISTS__PART_PATH:
				getPartPath().clear();
				return;
			case DiagramPackage.ASSERT_FIGURE_EXISTS__FIGURE_ID:
				setFigureID(FIGURE_ID_EDEFAULT);
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
			case DiagramPackage.ASSERT_FIGURE_EXISTS__ID:
				return id != ID_EDEFAULT;
			case DiagramPackage.ASSERT_FIGURE_EXISTS__ELEMENT:
				return element != null;
			case DiagramPackage.ASSERT_FIGURE_EXISTS__PART_PATH:
				return partPath != null && !partPath.isEmpty();
			case DiagramPackage.ASSERT_FIGURE_EXISTS__FIGURE_ID:
				return FIGURE_ID_EDEFAULT == null ? figureID != null : !FIGURE_ID_EDEFAULT.equals(figureID);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", partPath: ");
		result.append(partPath);
		result.append(", figureID: ");
		result.append(figureID);
		result.append(')');
		return result.toString();
	}

} //AssertFigureExistsImpl
