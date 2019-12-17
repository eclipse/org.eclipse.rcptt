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
package org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportBuilderStore;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Builder Store</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportBuilderStoreImpl#getReport <em>Report</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.impl.ReportBuilderStoreImpl#getCurrentNode <em>Current Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReportBuilderStoreImpl extends EObjectImpl implements ReportBuilderStore {
	/**
	 * The cached value of the '{@link #getReport() <em>Report</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReport()
	 * @generated
	 * @ordered
	 */
	protected Report report;

	/**
	 * The cached value of the '{@link #getCurrentNode() <em>Current Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentNode()
	 * @generated
	 * @ordered
	 */
	protected Node currentNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReportBuilderStoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReportPackage.Literals.REPORT_BUILDER_STORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Report getReport() {
		return report;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReport(Report newReport, NotificationChain msgs) {
		Report oldReport = report;
		report = newReport;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReportPackage.REPORT_BUILDER_STORE__REPORT, oldReport, newReport);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReport(Report newReport) {
		if (newReport != report) {
			NotificationChain msgs = null;
			if (report != null)
				msgs = ((InternalEObject)report).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReportPackage.REPORT_BUILDER_STORE__REPORT, null, msgs);
			if (newReport != null)
				msgs = ((InternalEObject)newReport).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReportPackage.REPORT_BUILDER_STORE__REPORT, null, msgs);
			msgs = basicSetReport(newReport, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReportPackage.REPORT_BUILDER_STORE__REPORT, newReport, newReport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getCurrentNode() {
		if (currentNode != null && currentNode.eIsProxy()) {
			InternalEObject oldCurrentNode = (InternalEObject)currentNode;
			currentNode = (Node)eResolveProxy(oldCurrentNode);
			if (currentNode != oldCurrentNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReportPackage.REPORT_BUILDER_STORE__CURRENT_NODE, oldCurrentNode, currentNode));
			}
		}
		return currentNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetCurrentNode() {
		return currentNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentNode(Node newCurrentNode) {
		Node oldCurrentNode = currentNode;
		currentNode = newCurrentNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReportPackage.REPORT_BUILDER_STORE__CURRENT_NODE, oldCurrentNode, currentNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ReportPackage.REPORT_BUILDER_STORE__REPORT:
				return basicSetReport(null, msgs);
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
			case ReportPackage.REPORT_BUILDER_STORE__REPORT:
				return getReport();
			case ReportPackage.REPORT_BUILDER_STORE__CURRENT_NODE:
				if (resolve) return getCurrentNode();
				return basicGetCurrentNode();
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
			case ReportPackage.REPORT_BUILDER_STORE__REPORT:
				setReport((Report)newValue);
				return;
			case ReportPackage.REPORT_BUILDER_STORE__CURRENT_NODE:
				setCurrentNode((Node)newValue);
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
			case ReportPackage.REPORT_BUILDER_STORE__REPORT:
				setReport((Report)null);
				return;
			case ReportPackage.REPORT_BUILDER_STORE__CURRENT_NODE:
				setCurrentNode((Node)null);
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
			case ReportPackage.REPORT_BUILDER_STORE__REPORT:
				return report != null;
			case ReportPackage.REPORT_BUILDER_STORE__CURRENT_NODE:
				return currentNode != null;
		}
		return super.eIsSet(featureID);
	}

} //ReportBuilderStoreImpl
