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
package org.eclipse.rcptt.core.ecl.core.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage
 * @generated
 */
public interface Q7CoreFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Q7CoreFactory eINSTANCE = org.eclipse.rcptt.core.ecl.core.model.impl.Q7CoreFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Enter Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enter Context</em>'.
	 * @generated
	 */
	EnterContext createEnterContext();

	/**
	 * Returns a new object of class '<em>Create Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Context</em>'.
	 * @generated
	 */
	CreateContext createCreateContext();

	/**
	 * Returns a new object of class '<em>Prepare Environment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Prepare Environment</em>'.
	 * @generated
	 */
	PrepareEnvironment createPrepareEnvironment();

	/**
	 * Returns a new object of class '<em>Set Commands Delay</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Commands Delay</em>'.
	 * @generated
	 */
	SetCommandsDelay createSetCommandsDelay();

	/**
	 * Returns a new object of class '<em>Get Q7 Information</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Q7 Information</em>'.
	 * @generated
	 */
	GetQ7Information createGetQ7Information();

	/**
	 * Returns a new object of class '<em>Q7 Information</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Q7 Information</em>'.
	 * @generated
	 */
	Q7Information createQ7Information();

	/**
	 * Returns a new object of class '<em>Set Q7 Features</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Q7 Features</em>'.
	 * @generated
	 */
	SetQ7Features createSetQ7Features();

	/**
	 * Returns a new object of class '<em>Get Perspectives</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Perspectives</em>'.
	 * @generated
	 */
	GetPerspectives createGetPerspectives();

	/**
	 * Returns a new object of class '<em>Perspective Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Perspective Info</em>'.
	 * @generated
	 */
	PerspectiveInfo createPerspectiveInfo();

	/**
	 * Returns a new object of class '<em>Perspectives List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Perspectives List</em>'.
	 * @generated
	 */
	PerspectivesList createPerspectivesList();

	/**
	 * Returns a new object of class '<em>Get Views</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Views</em>'.
	 * @generated
	 */
	GetViews createGetViews();

	/**
	 * Returns a new object of class '<em>View Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>View Info</em>'.
	 * @generated
	 */
	ViewInfo createViewInfo();

	/**
	 * Returns a new object of class '<em>View List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>View List</em>'.
	 * @generated
	 */
	ViewList createViewList();

	/**
	 * Returns a new object of class '<em>Create Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Report</em>'.
	 * @generated
	 */
	CreateReport createCreateReport();

	/**
	 * Returns a new object of class '<em>Get Report</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Report</em>'.
	 * @generated
	 */
	GetReport createGetReport();

	/**
	 * Returns a new object of class '<em>Begin Report Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Begin Report Node</em>'.
	 * @generated
	 */
	BeginReportNode createBeginReportNode();

	/**
	 * Returns a new object of class '<em>End Report Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End Report Node</em>'.
	 * @generated
	 */
	EndReportNode createEndReportNode();

	/**
	 * Returns a new object of class '<em>Report Append</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Report Append</em>'.
	 * @generated
	 */
	ReportAppend createReportAppend();

	/**
	 * Returns a new object of class '<em>Set Q7 Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Q7 Option</em>'.
	 * @generated
	 */
	SetQ7Option createSetQ7Option();

	/**
	 * Returns a new object of class '<em>Exec Verification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exec Verification</em>'.
	 * @generated
	 */
	ExecVerification createExecVerification();

	/**
	 * Returns a new object of class '<em>Reset Verifications</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reset Verifications</em>'.
	 * @generated
	 */
	ResetVerifications createResetVerifications();

	/**
	 * Returns a new object of class '<em>Create Verification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Verification</em>'.
	 * @generated
	 */
	CreateVerification createCreateVerification();

	/**
	 * Returns a new object of class '<em>Create Widget Verification Param</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Widget Verification Param</em>'.
	 * @generated
	 */
	CreateWidgetVerificationParam createCreateWidgetVerificationParam();

	/**
	 * Returns a new object of class '<em>Terminate Aut</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Terminate Aut</em>'.
	 * @generated
	 */
	TerminateAut createTerminateAut();

	/**
	 * Returns a new object of class '<em>Set Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Option</em>'.
	 * @generated
	 */
	SetOption createSetOption();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Q7CorePackage getQ7CorePackage();

} //Q7CoreFactory
