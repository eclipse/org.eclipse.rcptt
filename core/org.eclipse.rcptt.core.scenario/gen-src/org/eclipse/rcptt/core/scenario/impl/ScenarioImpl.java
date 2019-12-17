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
package org.eclipse.rcptt.core.scenario.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.rcptt.core.scenario.ILazyEMFResolver;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.core.scenario.ScenarioProperty;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Scenario</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.ScenarioImpl#getContexts <em>Contexts</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.ScenarioImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.ScenarioImpl#getTeslaContent <em>Tesla Content</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.ScenarioImpl#getScenarioReferences <em>Scenario References</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.ScenarioImpl#isRawSupported <em>Raw Supported</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.ScenarioImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.ScenarioImpl#getExternalReference <em>External Reference</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.ScenarioImpl#getVerifications <em>Verifications</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.scenario.impl.ScenarioImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScenarioImpl extends NamedElementImpl implements Scenario {
	/**
	 * The cached value of the '{@link #getContexts() <em>Contexts</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContexts()
	 * @generated
	 * @ordered
	 */
	protected EList<String> contexts;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected EObject content;

	/**
	 * The cached value of the '{@link #getTeslaContent() <em>Tesla Content</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTeslaContent()
	 * @generated
	 * @ordered
	 */
	protected EObject teslaContent;

	/**
	 * The cached value of the '{@link #getScenarioReferences() <em>Scenario References</em>}' attribute list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getScenarioReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<String> scenarioReferences;

	/**
	 * The default value of the '{@link #isRawSupported() <em>Raw Supported</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isRawSupported()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RAW_SUPPORTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRawSupported() <em>Raw Supported</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isRawSupported()
	 * @generated
	 * @ordered
	 */
	protected boolean rawSupported = RAW_SUPPORTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExternalReference() <em>External Reference</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExternalReference()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTERNAL_REFERENCE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getExternalReference() <em>External Reference</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExternalReference()
	 * @generated
	 * @ordered
	 */
	protected String externalReference = EXTERNAL_REFERENCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVerifications() <em>Verifications</em>}' attribute list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getVerifications()
	 * @generated
	 * @ordered
	 */
	protected EList<String> verifications;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<ScenarioProperty> properties;

	/**
	 * @generated NOT
	 */
	private boolean contentSet = false;
	/**
	 * @generated NOT
	 */
	private boolean teslaContentSet = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScenarioPackage.Literals.SCENARIO;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getContexts() {
		if (contexts == null) {
			contexts = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.SCENARIO__CONTEXTS);
		}
		return contexts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EObject getContent() {
		if (content == null && !contentSet) {
			Resource res = eResource();
			if (res instanceof ILazyEMFResolver) {
				content = ((ILazyEMFResolver) res).resolveReference(ScenarioPackage.Literals.SCENARIO__CONTENT, this);
			}
		}

		return content;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContent(EObject newContent, NotificationChain msgs) {
		EObject oldContent = content;
		content = newContent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ScenarioPackage.SCENARIO__CONTENT, oldContent, newContent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setContent(EObject newContent) {
		contentSet = true;
		if (newContent != content) {
			NotificationChain msgs = null;
			if (content != null)
				msgs = ((InternalEObject) content).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - ScenarioPackage.SCENARIO__CONTENT, null, msgs);
			if (newContent != null)
				msgs = ((InternalEObject) newContent).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - ScenarioPackage.SCENARIO__CONTENT, null, msgs);
			msgs = basicSetContent(newContent, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.SCENARIO__CONTENT, newContent,
					newContent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EObject getTeslaContent() {
		if (teslaContent == null && !teslaContentSet) {
			Resource res = eResource();
			if (res instanceof ILazyEMFResolver) {
				return ((ILazyEMFResolver) res)
						.resolveReference(ScenarioPackage.Literals.SCENARIO__TESLA_CONTENT, this);
			}
		}
		return teslaContent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTeslaContent(EObject newTeslaContent, NotificationChain msgs) {
		EObject oldTeslaContent = teslaContent;
		teslaContent = newTeslaContent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ScenarioPackage.SCENARIO__TESLA_CONTENT, oldTeslaContent, newTeslaContent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setTeslaContent(EObject newTeslaContent) {
		teslaContentSet = true;
		if (newTeslaContent != teslaContent) {
			NotificationChain msgs = null;
			if (teslaContent != null)
				msgs = ((InternalEObject) teslaContent).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - ScenarioPackage.SCENARIO__TESLA_CONTENT, null, msgs);
			if (newTeslaContent != null)
				msgs = ((InternalEObject) newTeslaContent).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - ScenarioPackage.SCENARIO__TESLA_CONTENT, null, msgs);
			msgs = basicSetTeslaContent(newTeslaContent, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.SCENARIO__TESLA_CONTENT,
					newTeslaContent, newTeslaContent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getScenarioReferences() {
		if (scenarioReferences == null) {
			scenarioReferences = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.SCENARIO__SCENARIO_REFERENCES);
		}
		return scenarioReferences;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRawSupported() {
		return rawSupported;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawSupported(boolean newRawSupported) {
		boolean oldRawSupported = rawSupported;
		rawSupported = newRawSupported;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.SCENARIO__RAW_SUPPORTED, oldRawSupported, rawSupported));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.SCENARIO__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getExternalReference() {
		return externalReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setExternalReference(String newExternalReference) {
		String oldExternalReference = externalReference;
		externalReference = newExternalReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.SCENARIO__EXTERNAL_REFERENCE, oldExternalReference, externalReference));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getVerifications() {
		if (verifications == null) {
			verifications = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.SCENARIO__VERIFICATIONS);
		}
		return verifications;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ScenarioProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<ScenarioProperty>(ScenarioProperty.class, this, ScenarioPackage.SCENARIO__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScenarioPackage.SCENARIO__CONTENT:
				return basicSetContent(null, msgs);
			case ScenarioPackage.SCENARIO__TESLA_CONTENT:
				return basicSetTeslaContent(null, msgs);
			case ScenarioPackage.SCENARIO__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
			case ScenarioPackage.SCENARIO__CONTEXTS:
				return getContexts();
			case ScenarioPackage.SCENARIO__CONTENT:
				return getContent();
			case ScenarioPackage.SCENARIO__TESLA_CONTENT:
				return getTeslaContent();
			case ScenarioPackage.SCENARIO__SCENARIO_REFERENCES:
				return getScenarioReferences();
			case ScenarioPackage.SCENARIO__RAW_SUPPORTED:
				return isRawSupported();
			case ScenarioPackage.SCENARIO__TYPE:
				return getType();
			case ScenarioPackage.SCENARIO__EXTERNAL_REFERENCE:
				return getExternalReference();
			case ScenarioPackage.SCENARIO__VERIFICATIONS:
				return getVerifications();
			case ScenarioPackage.SCENARIO__PROPERTIES:
				return getProperties();
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
			case ScenarioPackage.SCENARIO__CONTEXTS:
				getContexts().clear();
				getContexts().addAll((Collection<? extends String>)newValue);
				return;
			case ScenarioPackage.SCENARIO__CONTENT:
				setContent((EObject)newValue);
				return;
			case ScenarioPackage.SCENARIO__TESLA_CONTENT:
				setTeslaContent((EObject)newValue);
				return;
			case ScenarioPackage.SCENARIO__SCENARIO_REFERENCES:
				getScenarioReferences().clear();
				getScenarioReferences().addAll((Collection<? extends String>)newValue);
				return;
			case ScenarioPackage.SCENARIO__RAW_SUPPORTED:
				setRawSupported((Boolean)newValue);
				return;
			case ScenarioPackage.SCENARIO__TYPE:
				setType((String)newValue);
				return;
			case ScenarioPackage.SCENARIO__EXTERNAL_REFERENCE:
				setExternalReference((String)newValue);
				return;
			case ScenarioPackage.SCENARIO__VERIFICATIONS:
				getVerifications().clear();
				getVerifications().addAll((Collection<? extends String>)newValue);
				return;
			case ScenarioPackage.SCENARIO__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends ScenarioProperty>)newValue);
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
			case ScenarioPackage.SCENARIO__CONTEXTS:
				getContexts().clear();
				return;
			case ScenarioPackage.SCENARIO__CONTENT:
				setContent((EObject)null);
				return;
			case ScenarioPackage.SCENARIO__TESLA_CONTENT:
				setTeslaContent((EObject)null);
				return;
			case ScenarioPackage.SCENARIO__SCENARIO_REFERENCES:
				getScenarioReferences().clear();
				return;
			case ScenarioPackage.SCENARIO__RAW_SUPPORTED:
				setRawSupported(RAW_SUPPORTED_EDEFAULT);
				return;
			case ScenarioPackage.SCENARIO__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ScenarioPackage.SCENARIO__EXTERNAL_REFERENCE:
				setExternalReference(EXTERNAL_REFERENCE_EDEFAULT);
				return;
			case ScenarioPackage.SCENARIO__VERIFICATIONS:
				getVerifications().clear();
				return;
			case ScenarioPackage.SCENARIO__PROPERTIES:
				getProperties().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ScenarioPackage.SCENARIO__CONTEXTS:
				return contexts != null && !contexts.isEmpty();
			case ScenarioPackage.SCENARIO__CONTENT:
				getContent();
				return content != null;
			case ScenarioPackage.SCENARIO__TESLA_CONTENT:
				if(!teslaContentSet) {
					Object value = getTeslaContent();
					if(value != null) {
						return true;
					}
				}
				return teslaContent != null;
			case ScenarioPackage.SCENARIO__SCENARIO_REFERENCES:
				return scenarioReferences != null && !scenarioReferences.isEmpty();
			case ScenarioPackage.SCENARIO__RAW_SUPPORTED:
				return rawSupported != RAW_SUPPORTED_EDEFAULT;
			case ScenarioPackage.SCENARIO__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case ScenarioPackage.SCENARIO__EXTERNAL_REFERENCE:
				return EXTERNAL_REFERENCE_EDEFAULT == null ? externalReference != null : !EXTERNAL_REFERENCE_EDEFAULT.equals(externalReference);
			case ScenarioPackage.SCENARIO__VERIFICATIONS:
				return verifications != null && !verifications.isEmpty();
			case ScenarioPackage.SCENARIO__PROPERTIES:
				return properties != null && !properties.isEmpty();
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
		result.append(" (contexts: ");
		result.append(contexts);
		result.append(", scenarioReferences: ");
		result.append(scenarioReferences);
		result.append(", rawSupported: ");
		result.append(rawSupported);
		result.append(", type: ");
		result.append(type);
		result.append(", externalReference: ");
		result.append(externalReference);
		result.append(", verifications: ");
		result.append(verifications);
		result.append(')');
		return result.toString();
	}

} // ScenarioImpl
