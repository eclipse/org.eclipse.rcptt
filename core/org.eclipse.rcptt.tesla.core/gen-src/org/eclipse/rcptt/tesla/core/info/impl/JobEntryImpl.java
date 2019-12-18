/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core.info.impl;

import org.eclipse.rcptt.tesla.core.info.InfoPackage;
import org.eclipse.rcptt.tesla.core.info.JobEntry;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Job Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.JobEntryImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.JobEntryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.JobEntryImpl#getJobClass <em>Job Class</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.JobEntryImpl#getState <em>State</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.JobEntryImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.JobEntryImpl#getRuleClass <em>Rule Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JobEntryImpl extends EObjectImpl implements JobEntry {
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
	 * The default value of the '{@link #getJobClass() <em>Job Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobClass()
	 * @generated
	 * @ordered
	 */
	protected static final String JOB_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJobClass() <em>Job Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobClass()
	 * @generated
	 * @ordered
	 */
	protected String jobClass = JOB_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final String STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected String state = STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRule() <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected static final String RULE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRule() <em>Rule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected String rule = RULE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRuleClass() <em>Rule Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleClass()
	 * @generated
	 * @ordered
	 */
	protected static final String RULE_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRuleClass() <em>Rule Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleClass()
	 * @generated
	 * @ordered
	 */
	protected String ruleClass = RULE_CLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JobEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfoPackage.Literals.JOB_ENTRY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.JOB_ENTRY__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.JOB_ENTRY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJobClass() {
		return jobClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJobClass(String newJobClass) {
		String oldJobClass = jobClass;
		jobClass = newJobClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.JOB_ENTRY__JOB_CLASS, oldJobClass, jobClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(String newState) {
		String oldState = state;
		state = newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.JOB_ENTRY__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRule() {
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRule(String newRule) {
		String oldRule = rule;
		rule = newRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.JOB_ENTRY__RULE, oldRule, rule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRuleClass() {
		return ruleClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleClass(String newRuleClass) {
		String oldRuleClass = ruleClass;
		ruleClass = newRuleClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.JOB_ENTRY__RULE_CLASS, oldRuleClass, ruleClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InfoPackage.JOB_ENTRY__ID:
				return getId();
			case InfoPackage.JOB_ENTRY__NAME:
				return getName();
			case InfoPackage.JOB_ENTRY__JOB_CLASS:
				return getJobClass();
			case InfoPackage.JOB_ENTRY__STATE:
				return getState();
			case InfoPackage.JOB_ENTRY__RULE:
				return getRule();
			case InfoPackage.JOB_ENTRY__RULE_CLASS:
				return getRuleClass();
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
			case InfoPackage.JOB_ENTRY__ID:
				setId((String)newValue);
				return;
			case InfoPackage.JOB_ENTRY__NAME:
				setName((String)newValue);
				return;
			case InfoPackage.JOB_ENTRY__JOB_CLASS:
				setJobClass((String)newValue);
				return;
			case InfoPackage.JOB_ENTRY__STATE:
				setState((String)newValue);
				return;
			case InfoPackage.JOB_ENTRY__RULE:
				setRule((String)newValue);
				return;
			case InfoPackage.JOB_ENTRY__RULE_CLASS:
				setRuleClass((String)newValue);
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
			case InfoPackage.JOB_ENTRY__ID:
				setId(ID_EDEFAULT);
				return;
			case InfoPackage.JOB_ENTRY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case InfoPackage.JOB_ENTRY__JOB_CLASS:
				setJobClass(JOB_CLASS_EDEFAULT);
				return;
			case InfoPackage.JOB_ENTRY__STATE:
				setState(STATE_EDEFAULT);
				return;
			case InfoPackage.JOB_ENTRY__RULE:
				setRule(RULE_EDEFAULT);
				return;
			case InfoPackage.JOB_ENTRY__RULE_CLASS:
				setRuleClass(RULE_CLASS_EDEFAULT);
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
			case InfoPackage.JOB_ENTRY__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case InfoPackage.JOB_ENTRY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case InfoPackage.JOB_ENTRY__JOB_CLASS:
				return JOB_CLASS_EDEFAULT == null ? jobClass != null : !JOB_CLASS_EDEFAULT.equals(jobClass);
			case InfoPackage.JOB_ENTRY__STATE:
				return STATE_EDEFAULT == null ? state != null : !STATE_EDEFAULT.equals(state);
			case InfoPackage.JOB_ENTRY__RULE:
				return RULE_EDEFAULT == null ? rule != null : !RULE_EDEFAULT.equals(rule);
			case InfoPackage.JOB_ENTRY__RULE_CLASS:
				return RULE_CLASS_EDEFAULT == null ? ruleClass != null : !RULE_CLASS_EDEFAULT.equals(ruleClass);
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
		result.append(", name: ");
		result.append(name);
		result.append(", jobClass: ");
		result.append(jobClass);
		result.append(", state: ");
		result.append(state);
		result.append(", rule: ");
		result.append(rule);
		result.append(", ruleClass: ");
		result.append(ruleClass);
		result.append(')');
		return result.toString();
	}

} //JobEntryImpl
