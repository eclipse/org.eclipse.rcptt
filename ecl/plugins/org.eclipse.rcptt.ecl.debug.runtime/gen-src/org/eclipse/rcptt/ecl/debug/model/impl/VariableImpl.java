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
package org.eclipse.rcptt.ecl.debug.model.impl;

import java.util.Collection;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.rcptt.ecl.debug.model.ModelPackage;
import org.eclipse.rcptt.ecl.debug.model.Variable;
import org.eclipse.rcptt.ecl.debug.model.VariableKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.impl.VariableImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.impl.VariableImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.impl.VariableImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.impl.VariableImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.impl.VariableImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.impl.VariableImpl#getObjectRef <em>Object Ref</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.impl.VariableImpl#isComplex <em>Complex</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.debug.model.impl.VariableImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableImpl extends EObjectImpl implements Variable {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EObject value;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> children;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getObjectRef() <em>Object Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectRef()
	 * @generated
	 * @ordered
	 */
	protected static final Object OBJECT_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObjectRef() <em>Object Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectRef()
	 * @generated
	 * @ordered
	 */
	protected Object objectRef = OBJECT_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #isComplex() <em>Complex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComplex()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPLEX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isComplex() <em>Complex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComplex()
	 * @generated
	 * @ordered
	 */
	protected boolean complex = COMPLEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final VariableKind KIND_EDEFAULT = VariableKind.VARIABLE;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected VariableKind kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.VARIABLE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.VARIABLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(EObject newValue, NotificationChain msgs) {
		EObject oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.VARIABLE__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(EObject newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.VARIABLE__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.VARIABLE__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.VARIABLE__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<Variable>(Variable.class, this, ModelPackage.VARIABLE__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getObjectRef() {
		return objectRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectRef(Object newObjectRef) {
		Object oldObjectRef = objectRef;
		objectRef = newObjectRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.VARIABLE__OBJECT_REF, oldObjectRef, objectRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComplex() {
		return complex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComplex(boolean newComplex) {
		boolean oldComplex = complex;
		complex = newComplex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.VARIABLE__COMPLEX, oldComplex, complex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(VariableKind newKind) {
		VariableKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.VARIABLE__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.VARIABLE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.VARIABLE__VALUE:
				return basicSetValue(null, msgs);
			case ModelPackage.VARIABLE__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.VARIABLE__TYPE:
				return getType();
			case ModelPackage.VARIABLE__NAME:
				return getName();
			case ModelPackage.VARIABLE__VALUE:
				return getValue();
			case ModelPackage.VARIABLE__CHILDREN:
				return getChildren();
			case ModelPackage.VARIABLE__ID:
				return getId();
			case ModelPackage.VARIABLE__OBJECT_REF:
				return getObjectRef();
			case ModelPackage.VARIABLE__COMPLEX:
				return isComplex();
			case ModelPackage.VARIABLE__KIND:
				return getKind();
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
			case ModelPackage.VARIABLE__TYPE:
				setType((String)newValue);
				return;
			case ModelPackage.VARIABLE__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.VARIABLE__VALUE:
				setValue((EObject)newValue);
				return;
			case ModelPackage.VARIABLE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends Variable>)newValue);
				return;
			case ModelPackage.VARIABLE__ID:
				setId((String)newValue);
				return;
			case ModelPackage.VARIABLE__OBJECT_REF:
				setObjectRef(newValue);
				return;
			case ModelPackage.VARIABLE__COMPLEX:
				setComplex((Boolean)newValue);
				return;
			case ModelPackage.VARIABLE__KIND:
				setKind((VariableKind)newValue);
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
			case ModelPackage.VARIABLE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModelPackage.VARIABLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.VARIABLE__VALUE:
				setValue((EObject)null);
				return;
			case ModelPackage.VARIABLE__CHILDREN:
				getChildren().clear();
				return;
			case ModelPackage.VARIABLE__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelPackage.VARIABLE__OBJECT_REF:
				setObjectRef(OBJECT_REF_EDEFAULT);
				return;
			case ModelPackage.VARIABLE__COMPLEX:
				setComplex(COMPLEX_EDEFAULT);
				return;
			case ModelPackage.VARIABLE__KIND:
				setKind(KIND_EDEFAULT);
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
			case ModelPackage.VARIABLE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case ModelPackage.VARIABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.VARIABLE__VALUE:
				return value != null;
			case ModelPackage.VARIABLE__CHILDREN:
				return children != null && !children.isEmpty();
			case ModelPackage.VARIABLE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ModelPackage.VARIABLE__OBJECT_REF:
				return OBJECT_REF_EDEFAULT == null ? objectRef != null : !OBJECT_REF_EDEFAULT.equals(objectRef);
			case ModelPackage.VARIABLE__COMPLEX:
				return complex != COMPLEX_EDEFAULT;
			case ModelPackage.VARIABLE__KIND:
				return kind != KIND_EDEFAULT;
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
		result.append(" (type: ");
		result.append(type);
		result.append(", name: ");
		result.append(name);
		result.append(", id: ");
		result.append(id);
		result.append(", objectRef: ");
		result.append(objectRef);
		result.append(", complex: ");
		result.append(complex);
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //VariableImpl
