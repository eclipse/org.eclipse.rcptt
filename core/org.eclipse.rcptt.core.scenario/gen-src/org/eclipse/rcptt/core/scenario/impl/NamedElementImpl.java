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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.rcptt.core.scenario.Attachment;
import org.eclipse.rcptt.core.scenario.ILazyEMFResolver;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Named Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.NamedElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.NamedElementImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.NamedElementImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.NamedElementImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.NamedElementImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.NamedElementImpl#getAttachments <em>Attachments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamedElementImpl extends EObjectImpl implements NamedElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = "2.0";

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTags() <em>Tags</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected static final String TAGS_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected String tags = TAGS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttachments() <em>Attachments</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAttachments()
	 * @generated
	 * @ordered
	 */
	protected EList<Attachment> attachments;

	/**
	 * @generated NOT
	 */
	private boolean descriptionSet = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScenarioPackage.Literals.NAMED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.NAMED_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.NAMED_ELEMENT__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.NAMED_ELEMENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getDescription() {
		if (description == null && !descriptionSet) {
			Resource res = eResource();
			if (res instanceof ILazyEMFResolver) {
				description = ((ILazyEMFResolver) res).resolveStringValue(
						ScenarioPackage.Literals.NAMED_ELEMENT__DESCRIPTION,
						this);
			}
		}
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setDescription(String newDescription) {
		descriptionSet = true;
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ScenarioPackage.NAMED_ELEMENT__DESCRIPTION, oldDescription,
					description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTags(String newTags) {
		String oldTags = tags;
		tags = newTags;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.NAMED_ELEMENT__TAGS, oldTags, tags));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attachment> getAttachments() {
		if (attachments == null) {
			attachments = new EObjectContainmentEList<Attachment>(Attachment.class, this, ScenarioPackage.NAMED_ELEMENT__ATTACHMENTS);
		}
		return attachments;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScenarioPackage.NAMED_ELEMENT__ATTACHMENTS:
				return ((InternalEList<?>)getAttachments()).basicRemove(otherEnd, msgs);
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
			case ScenarioPackage.NAMED_ELEMENT__NAME:
				return getName();
			case ScenarioPackage.NAMED_ELEMENT__VERSION:
				return getVersion();
			case ScenarioPackage.NAMED_ELEMENT__ID:
				return getId();
			case ScenarioPackage.NAMED_ELEMENT__DESCRIPTION:
				return getDescription();
			case ScenarioPackage.NAMED_ELEMENT__TAGS:
				return getTags();
			case ScenarioPackage.NAMED_ELEMENT__ATTACHMENTS:
				return getAttachments();
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
			case ScenarioPackage.NAMED_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case ScenarioPackage.NAMED_ELEMENT__VERSION:
				setVersion((String)newValue);
				return;
			case ScenarioPackage.NAMED_ELEMENT__ID:
				setId((String)newValue);
				return;
			case ScenarioPackage.NAMED_ELEMENT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ScenarioPackage.NAMED_ELEMENT__TAGS:
				setTags((String)newValue);
				return;
			case ScenarioPackage.NAMED_ELEMENT__ATTACHMENTS:
				getAttachments().clear();
				getAttachments().addAll((Collection<? extends Attachment>)newValue);
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
			case ScenarioPackage.NAMED_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ScenarioPackage.NAMED_ELEMENT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case ScenarioPackage.NAMED_ELEMENT__ID:
				setId(ID_EDEFAULT);
				return;
			case ScenarioPackage.NAMED_ELEMENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ScenarioPackage.NAMED_ELEMENT__TAGS:
				setTags(TAGS_EDEFAULT);
				return;
			case ScenarioPackage.NAMED_ELEMENT__ATTACHMENTS:
				getAttachments().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ScenarioPackage.NAMED_ELEMENT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case ScenarioPackage.NAMED_ELEMENT__VERSION:
			return VERSION_EDEFAULT == null ? version != null
					: !VERSION_EDEFAULT.equals(version);
		case ScenarioPackage.NAMED_ELEMENT__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case ScenarioPackage.NAMED_ELEMENT__DESCRIPTION:
			getDescription();
			return DESCRIPTION_EDEFAULT == null ? description != null
					: !DESCRIPTION_EDEFAULT.equals(description);
		case ScenarioPackage.NAMED_ELEMENT__TAGS:
			return TAGS_EDEFAULT == null ? tags != null : !TAGS_EDEFAULT
					.equals(tags);
		case ScenarioPackage.NAMED_ELEMENT__ATTACHMENTS:
			return attachments != null && !attachments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", version: ");
		result.append(version);
		result.append(", id: ");
		result.append(id);
		result.append(", description: ");
		result.append(description);
		result.append(", tags: ");
		result.append(tags);
		result.append(')');
		return result.toString();
	}

} // NamedElementImpl
