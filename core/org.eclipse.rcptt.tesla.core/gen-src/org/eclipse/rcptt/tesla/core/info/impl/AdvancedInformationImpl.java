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

import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.InfoNode;
import org.eclipse.rcptt.tesla.core.info.InfoPackage;

import org.eclipse.rcptt.tesla.core.info.JobEntry;
import org.eclipse.rcptt.tesla.core.info.StackTraceEntry;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Advanced Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.AdvancedInformationImpl#getThreads <em>Threads</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.AdvancedInformationImpl#getJobs <em>Jobs</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.AdvancedInformationImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.info.impl.AdvancedInformationImpl#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdvancedInformationImpl extends EObjectImpl implements AdvancedInformation {
	/**
	 * The cached value of the '{@link #getThreads() <em>Threads</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreads()
	 * @generated
	 * @ordered
	 */
	protected EList<StackTraceEntry> threads;
	/**
	 * The cached value of the '{@link #getJobs() <em>Jobs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobs()
	 * @generated
	 * @ordered
	 */
	protected EList<JobEntry> jobs;
	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<InfoNode> nodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdvancedInformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfoPackage.Literals.ADVANCED_INFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StackTraceEntry> getThreads() {
		if (threads == null) {
			threads = new EObjectContainmentEList<StackTraceEntry>(StackTraceEntry.class, this, InfoPackage.ADVANCED_INFORMATION__THREADS);
		}
		return threads;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JobEntry> getJobs() {
		if (jobs == null) {
			jobs = new EObjectContainmentEList<JobEntry>(JobEntry.class, this, InfoPackage.ADVANCED_INFORMATION__JOBS);
		}
		return jobs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfoPackage.ADVANCED_INFORMATION__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InfoNode> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<InfoNode>(InfoNode.class, this, InfoPackage.ADVANCED_INFORMATION__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InfoPackage.ADVANCED_INFORMATION__THREADS:
				return ((InternalEList<?>)getThreads()).basicRemove(otherEnd, msgs);
			case InfoPackage.ADVANCED_INFORMATION__JOBS:
				return ((InternalEList<?>)getJobs()).basicRemove(otherEnd, msgs);
			case InfoPackage.ADVANCED_INFORMATION__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
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
			case InfoPackage.ADVANCED_INFORMATION__THREADS:
				return getThreads();
			case InfoPackage.ADVANCED_INFORMATION__JOBS:
				return getJobs();
			case InfoPackage.ADVANCED_INFORMATION__MESSAGE:
				return getMessage();
			case InfoPackage.ADVANCED_INFORMATION__NODES:
				return getNodes();
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
			case InfoPackage.ADVANCED_INFORMATION__THREADS:
				getThreads().clear();
				getThreads().addAll((Collection<? extends StackTraceEntry>)newValue);
				return;
			case InfoPackage.ADVANCED_INFORMATION__JOBS:
				getJobs().clear();
				getJobs().addAll((Collection<? extends JobEntry>)newValue);
				return;
			case InfoPackage.ADVANCED_INFORMATION__MESSAGE:
				setMessage((String)newValue);
				return;
			case InfoPackage.ADVANCED_INFORMATION__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends InfoNode>)newValue);
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
			case InfoPackage.ADVANCED_INFORMATION__THREADS:
				getThreads().clear();
				return;
			case InfoPackage.ADVANCED_INFORMATION__JOBS:
				getJobs().clear();
				return;
			case InfoPackage.ADVANCED_INFORMATION__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case InfoPackage.ADVANCED_INFORMATION__NODES:
				getNodes().clear();
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
			case InfoPackage.ADVANCED_INFORMATION__THREADS:
				return threads != null && !threads.isEmpty();
			case InfoPackage.ADVANCED_INFORMATION__JOBS:
				return jobs != null && !jobs.isEmpty();
			case InfoPackage.ADVANCED_INFORMATION__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case InfoPackage.ADVANCED_INFORMATION__NODES:
				return nodes != null && !nodes.isEmpty();
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
		result.append(" (message: ");
		result.append(message);
		result.append(')');
		return result.toString();
	}

} //AdvancedInformationImpl
