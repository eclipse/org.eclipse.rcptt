/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.ecl.core.model.impl;

import org.eclipse.rcptt.core.ecl.core.model.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Q7CoreFactoryImpl extends EFactoryImpl implements Q7CoreFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Q7CoreFactory init() {
		try {
			Q7CoreFactory theQ7CoreFactory = (Q7CoreFactory)EPackage.Registry.INSTANCE.getEFactory(Q7CorePackage.eNS_URI);
			if (theQ7CoreFactory != null) {
				return theQ7CoreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Q7CoreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Q7CoreFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Q7CorePackage.ENTER_CONTEXT: return createEnterContext();
			case Q7CorePackage.CREATE_CONTEXT: return createCreateContext();
			case Q7CorePackage.PREPARE_ENVIRONMENT: return createPrepareEnvironment();
			case Q7CorePackage.SET_COMMANDS_DELAY: return createSetCommandsDelay();
			case Q7CorePackage.GET_Q7_INFORMATION: return createGetQ7Information();
			case Q7CorePackage.Q7_INFORMATION: return createQ7Information();
			case Q7CorePackage.SET_Q7_FEATURES: return createSetQ7Features();
			case Q7CorePackage.GET_PERSPECTIVES: return createGetPerspectives();
			case Q7CorePackage.PERSPECTIVE_INFO: return createPerspectiveInfo();
			case Q7CorePackage.PERSPECTIVES_LIST: return createPerspectivesList();
			case Q7CorePackage.GET_VIEWS: return createGetViews();
			case Q7CorePackage.VIEW_INFO: return createViewInfo();
			case Q7CorePackage.VIEW_LIST: return createViewList();
			case Q7CorePackage.CREATE_REPORT: return createCreateReport();
			case Q7CorePackage.GET_REPORT: return createGetReport();
			case Q7CorePackage.BEGIN_REPORT_NODE: return createBeginReportNode();
			case Q7CorePackage.END_REPORT_NODE: return createEndReportNode();
			case Q7CorePackage.REPORT_APPEND: return createReportAppend();
			case Q7CorePackage.SET_Q7_OPTION: return createSetQ7Option();
			case Q7CorePackage.EXEC_VERIFICATION: return createExecVerification();
			case Q7CorePackage.RESET_VERIFICATIONS: return createResetVerifications();
			case Q7CorePackage.CREATE_VERIFICATION: return createCreateVerification();
			case Q7CorePackage.CREATE_WIDGET_VERIFICATION_PARAM: return createCreateWidgetVerificationParam();
			case Q7CorePackage.TERMINATE_AUT: return createTerminateAut();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case Q7CorePackage.EXECUTION_PHASE:
				return createExecutionPhaseFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case Q7CorePackage.EXECUTION_PHASE:
				return convertExecutionPhaseToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnterContext createEnterContext() {
		EnterContextImpl enterContext = new EnterContextImpl();
		return enterContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateContext createCreateContext() {
		CreateContextImpl createContext = new CreateContextImpl();
		return createContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrepareEnvironment createPrepareEnvironment() {
		PrepareEnvironmentImpl prepareEnvironment = new PrepareEnvironmentImpl();
		return prepareEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetCommandsDelay createSetCommandsDelay() {
		SetCommandsDelayImpl setCommandsDelay = new SetCommandsDelayImpl();
		return setCommandsDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetQ7Information createGetQ7Information() {
		GetQ7InformationImpl getQ7Information = new GetQ7InformationImpl();
		return getQ7Information;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Q7Information createQ7Information() {
		Q7InformationImpl q7Information = new Q7InformationImpl();
		return q7Information;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetQ7Features createSetQ7Features() {
		SetQ7FeaturesImpl setQ7Features = new SetQ7FeaturesImpl();
		return setQ7Features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetPerspectives createGetPerspectives() {
		GetPerspectivesImpl getPerspectives = new GetPerspectivesImpl();
		return getPerspectives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerspectiveInfo createPerspectiveInfo() {
		PerspectiveInfoImpl perspectiveInfo = new PerspectiveInfoImpl();
		return perspectiveInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerspectivesList createPerspectivesList() {
		PerspectivesListImpl perspectivesList = new PerspectivesListImpl();
		return perspectivesList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetViews createGetViews() {
		GetViewsImpl getViews = new GetViewsImpl();
		return getViews;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewInfo createViewInfo() {
		ViewInfoImpl viewInfo = new ViewInfoImpl();
		return viewInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewList createViewList() {
		ViewListImpl viewList = new ViewListImpl();
		return viewList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateReport createCreateReport() {
		CreateReportImpl createReport = new CreateReportImpl();
		return createReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetReport createGetReport() {
		GetReportImpl getReport = new GetReportImpl();
		return getReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeginReportNode createBeginReportNode() {
		BeginReportNodeImpl beginReportNode = new BeginReportNodeImpl();
		return beginReportNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndReportNode createEndReportNode() {
		EndReportNodeImpl endReportNode = new EndReportNodeImpl();
		return endReportNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReportAppend createReportAppend() {
		ReportAppendImpl reportAppend = new ReportAppendImpl();
		return reportAppend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetQ7Option createSetQ7Option() {
		SetQ7OptionImpl setQ7Option = new SetQ7OptionImpl();
		return setQ7Option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecVerification createExecVerification() {
		ExecVerificationImpl execVerification = new ExecVerificationImpl();
		return execVerification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResetVerifications createResetVerifications() {
		ResetVerificationsImpl resetVerifications = new ResetVerificationsImpl();
		return resetVerifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateVerification createCreateVerification() {
		CreateVerificationImpl createVerification = new CreateVerificationImpl();
		return createVerification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateWidgetVerificationParam createCreateWidgetVerificationParam() {
		CreateWidgetVerificationParamImpl createWidgetVerificationParam = new CreateWidgetVerificationParamImpl();
		return createWidgetVerificationParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TerminateAut createTerminateAut() {
		TerminateAutImpl terminateAut = new TerminateAutImpl();
		return terminateAut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionPhase createExecutionPhaseFromString(EDataType eDataType, String initialValue) {
		ExecutionPhase result = ExecutionPhase.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExecutionPhaseToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Q7CorePackage getQ7CorePackage() {
		return (Q7CorePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Q7CorePackage getPackage() {
		return Q7CorePackage.eINSTANCE;
	}

} //Q7CoreFactoryImpl
