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
package org.eclipse.rcptt.core.ecl.core.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.rcptt.ecl.core.CorePackage;

import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.core.ecl.core.model.BeginReportNode;
import org.eclipse.rcptt.core.ecl.core.model.CreateContext;
import org.eclipse.rcptt.core.ecl.core.model.CreateReport;
import org.eclipse.rcptt.core.ecl.core.model.CreateVerification;
import org.eclipse.rcptt.core.ecl.core.model.CreateWidgetVerificationParam;
import org.eclipse.rcptt.core.ecl.core.model.EndReportNode;
import org.eclipse.rcptt.core.ecl.core.model.EnterContext;
import org.eclipse.rcptt.core.ecl.core.model.ExecVerification;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.core.ecl.core.model.GetPerspectives;
import org.eclipse.rcptt.core.ecl.core.model.GetQ7Information;
import org.eclipse.rcptt.core.ecl.core.model.GetReport;
import org.eclipse.rcptt.core.ecl.core.model.GetViews;
import org.eclipse.rcptt.core.ecl.core.model.PerspectiveInfo;
import org.eclipse.rcptt.core.ecl.core.model.PerspectivesList;
import org.eclipse.rcptt.core.ecl.core.model.PrepareEnvironment;
import org.eclipse.rcptt.core.ecl.core.model.Q7CoreFactory;
import org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage;
import org.eclipse.rcptt.core.ecl.core.model.Q7Information;
import org.eclipse.rcptt.core.ecl.core.model.ReportAppend;
import org.eclipse.rcptt.core.ecl.core.model.ResetVerifications;
import org.eclipse.rcptt.core.ecl.core.model.SetCommandsDelay;
import org.eclipse.rcptt.core.ecl.core.model.SetQ7Features;
import org.eclipse.rcptt.core.ecl.core.model.SetQ7Option;
import org.eclipse.rcptt.core.ecl.core.model.TerminateAut;
import org.eclipse.rcptt.core.ecl.core.model.ViewInfo;
import org.eclipse.rcptt.core.ecl.core.model.ViewList;
import org.eclipse.rcptt.reporting.ReportingPackage;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class Q7CorePackageImpl extends EPackageImpl implements Q7CorePackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enterContextEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createContextEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prepareEnvironmentEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setCommandsDelayEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getQ7InformationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass q7InformationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setQ7FeaturesEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getPerspectivesEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass perspectiveInfoEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass perspectivesListEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getViewsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewInfoEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewListEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createReportEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getReportEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass beginReportNodeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endReportNodeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reportAppendEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setQ7OptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass execVerificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resetVerificationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createVerificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createWidgetVerificationParamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass terminateAutEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum executionPhaseEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Q7CorePackageImpl() {
		super(eNS_URI, Q7CoreFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link Q7CorePackage#eINSTANCE} when
	 * that field is accessed. Clients should not invoke it directly. Instead,
	 * they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Q7CorePackage init() {
		if (isInited) return (Q7CorePackage)EPackage.Registry.INSTANCE.getEPackage(Q7CorePackage.eNS_URI);

		// Obtain or create and register package
		Q7CorePackageImpl theQ7CorePackage = (Q7CorePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Q7CorePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Q7CorePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		ScenarioPackage.eINSTANCE.eClass();
		ReportPackage.eINSTANCE.eClass();
		ReportingPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQ7CorePackage.createPackageContents();

		// Initialize created meta-data
		theQ7CorePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQ7CorePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Q7CorePackage.eNS_URI, theQ7CorePackage);
		return theQ7CorePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnterContext() {
		return enterContextEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnterContext_Data() {
		return (EReference)enterContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateContext() {
		return createContextEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateContext_Type() {
		return (EAttribute)createContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateContext_Param() {
		return (EReference)createContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrepareEnvironment() {
		return prepareEnvironmentEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetCommandsDelay() {
		return setCommandsDelayEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetCommandsDelay_Delay() {
		return (EAttribute)setCommandsDelayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetQ7Information() {
		return getQ7InformationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQ7Information() {
		return q7InformationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7Information_Version() {
		return (EAttribute)q7InformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7Information_TeslaActive() {
		return (EAttribute)q7InformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7Information_TeslaPort() {
		return (EAttribute)q7InformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQ7Information_ClientActive() {
		return (EAttribute)q7InformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetQ7Features() {
		return setQ7FeaturesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetQ7Features_Features() {
		return (EAttribute)setQ7FeaturesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetPerspectives() {
		return getPerspectivesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerspectiveInfo() {
		return perspectiveInfoEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerspectiveInfo_Id() {
		return (EAttribute)perspectiveInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerspectiveInfo_Image() {
		return (EAttribute)perspectiveInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerspectiveInfo_Label() {
		return (EAttribute)perspectiveInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerspectiveInfo_Description() {
		return (EAttribute)perspectiveInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerspectivesList() {
		return perspectivesListEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerspectivesList_Perspectives() {
		return (EReference)perspectivesListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetViews() {
		return getViewsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewInfo() {
		return viewInfoEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewInfo_Id() {
		return (EAttribute)viewInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewInfo_Image() {
		return (EAttribute)viewInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewInfo_Label() {
		return (EAttribute)viewInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewInfo_Description() {
		return (EAttribute)viewInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewInfo_Items() {
		return (EReference)viewInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewList() {
		return viewListEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewList_Items() {
		return (EReference)viewListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateReport() {
		return createReportEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateReport_Name() {
		return (EAttribute)createReportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateReport_Q7info() {
		return (EReference)createReportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetReport() {
		return getReportEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBeginReportNode() {
		return beginReportNodeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeginReportNode_Name() {
		return (EAttribute)beginReportNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBeginReportNode_Properties() {
		return (EReference)beginReportNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndReportNode() {
		return endReportNodeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndReportNode_Snaphots() {
		return (EAttribute)endReportNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndReportNode_TakeSnaphots() {
		return (EAttribute)endReportNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndReportNode_Properties() {
		return (EReference)endReportNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReportAppend() {
		return reportAppendEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReportAppend_Objects() {
		return (EReference)reportAppendEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetQ7Option() {
		return setQ7OptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetQ7Option_Key() {
		return (EAttribute)setQ7OptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetQ7Option_Value() {
		return (EAttribute)setQ7OptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecVerification() {
		return execVerificationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecVerification_Verification() {
		return (EReference)execVerificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecVerification_Phase() {
		return (EAttribute)execVerificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResetVerifications() {
		return resetVerificationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateVerification() {
		return createVerificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateVerification_Type() {
		return (EAttribute)createVerificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateVerification_Param() {
		return (EReference)createVerificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateWidgetVerificationParam() {
		return createWidgetVerificationParamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateWidgetVerificationParam_Selector() {
		return (EAttribute)createWidgetVerificationParamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerminateAut() {
		return terminateAutEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExecutionPhase() {
		return executionPhaseEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Q7CoreFactory getQ7CoreFactory() {
		return (Q7CoreFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		enterContextEClass = createEClass(ENTER_CONTEXT);
		createEReference(enterContextEClass, ENTER_CONTEXT__DATA);

		createContextEClass = createEClass(CREATE_CONTEXT);
		createEAttribute(createContextEClass, CREATE_CONTEXT__TYPE);
		createEReference(createContextEClass, CREATE_CONTEXT__PARAM);

		prepareEnvironmentEClass = createEClass(PREPARE_ENVIRONMENT);

		setCommandsDelayEClass = createEClass(SET_COMMANDS_DELAY);
		createEAttribute(setCommandsDelayEClass, SET_COMMANDS_DELAY__DELAY);

		getQ7InformationEClass = createEClass(GET_Q7_INFORMATION);

		q7InformationEClass = createEClass(Q7_INFORMATION);
		createEAttribute(q7InformationEClass, Q7_INFORMATION__VERSION);
		createEAttribute(q7InformationEClass, Q7_INFORMATION__TESLA_ACTIVE);
		createEAttribute(q7InformationEClass, Q7_INFORMATION__TESLA_PORT);
		createEAttribute(q7InformationEClass, Q7_INFORMATION__CLIENT_ACTIVE);

		setQ7FeaturesEClass = createEClass(SET_Q7_FEATURES);
		createEAttribute(setQ7FeaturesEClass, SET_Q7_FEATURES__FEATURES);

		getPerspectivesEClass = createEClass(GET_PERSPECTIVES);

		perspectiveInfoEClass = createEClass(PERSPECTIVE_INFO);
		createEAttribute(perspectiveInfoEClass, PERSPECTIVE_INFO__ID);
		createEAttribute(perspectiveInfoEClass, PERSPECTIVE_INFO__IMAGE);
		createEAttribute(perspectiveInfoEClass, PERSPECTIVE_INFO__LABEL);
		createEAttribute(perspectiveInfoEClass, PERSPECTIVE_INFO__DESCRIPTION);

		perspectivesListEClass = createEClass(PERSPECTIVES_LIST);
		createEReference(perspectivesListEClass, PERSPECTIVES_LIST__PERSPECTIVES);

		getViewsEClass = createEClass(GET_VIEWS);

		viewInfoEClass = createEClass(VIEW_INFO);
		createEAttribute(viewInfoEClass, VIEW_INFO__ID);
		createEAttribute(viewInfoEClass, VIEW_INFO__IMAGE);
		createEAttribute(viewInfoEClass, VIEW_INFO__LABEL);
		createEAttribute(viewInfoEClass, VIEW_INFO__DESCRIPTION);
		createEReference(viewInfoEClass, VIEW_INFO__ITEMS);

		viewListEClass = createEClass(VIEW_LIST);
		createEReference(viewListEClass, VIEW_LIST__ITEMS);

		createReportEClass = createEClass(CREATE_REPORT);
		createEAttribute(createReportEClass, CREATE_REPORT__NAME);
		createEReference(createReportEClass, CREATE_REPORT__Q7INFO);

		getReportEClass = createEClass(GET_REPORT);

		beginReportNodeEClass = createEClass(BEGIN_REPORT_NODE);
		createEAttribute(beginReportNodeEClass, BEGIN_REPORT_NODE__NAME);
		createEReference(beginReportNodeEClass, BEGIN_REPORT_NODE__PROPERTIES);

		endReportNodeEClass = createEClass(END_REPORT_NODE);
		createEAttribute(endReportNodeEClass, END_REPORT_NODE__SNAPHOTS);
		createEAttribute(endReportNodeEClass, END_REPORT_NODE__TAKE_SNAPHOTS);
		createEReference(endReportNodeEClass, END_REPORT_NODE__PROPERTIES);

		reportAppendEClass = createEClass(REPORT_APPEND);
		createEReference(reportAppendEClass, REPORT_APPEND__OBJECTS);

		setQ7OptionEClass = createEClass(SET_Q7_OPTION);
		createEAttribute(setQ7OptionEClass, SET_Q7_OPTION__KEY);
		createEAttribute(setQ7OptionEClass, SET_Q7_OPTION__VALUE);

		execVerificationEClass = createEClass(EXEC_VERIFICATION);
		createEReference(execVerificationEClass, EXEC_VERIFICATION__VERIFICATION);
		createEAttribute(execVerificationEClass, EXEC_VERIFICATION__PHASE);

		resetVerificationsEClass = createEClass(RESET_VERIFICATIONS);

		createVerificationEClass = createEClass(CREATE_VERIFICATION);
		createEAttribute(createVerificationEClass, CREATE_VERIFICATION__TYPE);
		createEReference(createVerificationEClass, CREATE_VERIFICATION__PARAM);

		createWidgetVerificationParamEClass = createEClass(CREATE_WIDGET_VERIFICATION_PARAM);
		createEAttribute(createWidgetVerificationParamEClass, CREATE_WIDGET_VERIFICATION_PARAM__SELECTOR);

		terminateAutEClass = createEClass(TERMINATE_AUT);

		// Create enums
		executionPhaseEEnum = createEEnum(EXECUTION_PHASE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		ScenarioPackage theScenarioPackage = (ScenarioPackage)EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		ReportingPackage theReportingPackage = (ReportingPackage)EPackage.Registry.INSTANCE.getEPackage(ReportingPackage.eNS_URI);
		ReportPackage theReportPackage = (ReportPackage)EPackage.Registry.INSTANCE.getEPackage(ReportPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		enterContextEClass.getESuperTypes().add(theCorePackage.getCommand());
		createContextEClass.getESuperTypes().add(theCorePackage.getCommand());
		prepareEnvironmentEClass.getESuperTypes().add(theCorePackage.getCommand());
		setCommandsDelayEClass.getESuperTypes().add(theCorePackage.getCommand());
		getQ7InformationEClass.getESuperTypes().add(theCorePackage.getCommand());
		setQ7FeaturesEClass.getESuperTypes().add(theCorePackage.getCommand());
		getPerspectivesEClass.getESuperTypes().add(theCorePackage.getCommand());
		getViewsEClass.getESuperTypes().add(theCorePackage.getCommand());
		createReportEClass.getESuperTypes().add(theCorePackage.getCommand());
		getReportEClass.getESuperTypes().add(theCorePackage.getCommand());
		beginReportNodeEClass.getESuperTypes().add(theCorePackage.getCommand());
		endReportNodeEClass.getESuperTypes().add(theCorePackage.getCommand());
		reportAppendEClass.getESuperTypes().add(theCorePackage.getCommand());
		setQ7OptionEClass.getESuperTypes().add(theCorePackage.getCommand());
		execVerificationEClass.getESuperTypes().add(theCorePackage.getCommand());
		resetVerificationsEClass.getESuperTypes().add(theCorePackage.getCommand());
		createVerificationEClass.getESuperTypes().add(theCorePackage.getCommand());
		terminateAutEClass.getESuperTypes().add(theCorePackage.getCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(enterContextEClass, EnterContext.class, "EnterContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnterContext_Data(), theScenarioPackage.getContext(), null, "data", null, 0, 1, EnterContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createContextEClass, CreateContext.class, "CreateContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateContext_Type(), theEcorePackage.getEString(), "type", null, 0, 1, CreateContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateContext_Param(), theEcorePackage.getEObject(), null, "param", null, 0, 1, CreateContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(prepareEnvironmentEClass, PrepareEnvironment.class, "PrepareEnvironment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setCommandsDelayEClass, SetCommandsDelay.class, "SetCommandsDelay", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetCommandsDelay_Delay(), theEcorePackage.getEInt(), "delay", null, 0, 1, SetCommandsDelay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getQ7InformationEClass, GetQ7Information.class, "GetQ7Information", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(q7InformationEClass, Q7Information.class, "Q7Information", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQ7Information_Version(), theEcorePackage.getEString(), "version", null, 0, 1, Q7Information.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQ7Information_TeslaActive(), theEcorePackage.getEBoolean(), "teslaActive", null, 0, 1, Q7Information.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQ7Information_TeslaPort(), theEcorePackage.getEInt(), "teslaPort", null, 0, 1, Q7Information.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQ7Information_ClientActive(), theEcorePackage.getEBoolean(), "clientActive", null, 0, 1, Q7Information.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setQ7FeaturesEClass, SetQ7Features.class, "SetQ7Features", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetQ7Features_Features(), theEcorePackage.getEString(), "features", null, 0, -1, SetQ7Features.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getPerspectivesEClass, GetPerspectives.class, "GetPerspectives", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(perspectiveInfoEClass, PerspectiveInfo.class, "PerspectiveInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerspectiveInfo_Id(), theEcorePackage.getEString(), "id", null, 0, 1, PerspectiveInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerspectiveInfo_Image(), theEcorePackage.getEByteArray(), "image", null, 0, 1, PerspectiveInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerspectiveInfo_Label(), theEcorePackage.getEString(), "label", null, 0, 1, PerspectiveInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerspectiveInfo_Description(), theEcorePackage.getEString(), "description", null, 0, 1, PerspectiveInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(perspectivesListEClass, PerspectivesList.class, "PerspectivesList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPerspectivesList_Perspectives(), this.getPerspectiveInfo(), null, "perspectives", null, 0, -1, PerspectivesList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getViewsEClass, GetViews.class, "GetViews", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(viewInfoEClass, ViewInfo.class, "ViewInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getViewInfo_Id(), theEcorePackage.getEString(), "id", null, 0, 1, ViewInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewInfo_Image(), theEcorePackage.getEByteArray(), "image", null, 0, 1, ViewInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewInfo_Label(), theEcorePackage.getEString(), "label", null, 0, 1, ViewInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getViewInfo_Description(), theEcorePackage.getEString(), "description", null, 0, 1, ViewInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getViewInfo_Items(), this.getViewInfo(), null, "items", null, 0, -1, ViewInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewListEClass, ViewList.class, "ViewList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViewList_Items(), this.getViewInfo(), null, "items", null, 0, -1, ViewList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createReportEClass, CreateReport.class, "CreateReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateReport_Name(), theEcorePackage.getEString(), "name", null, 0, 1, CreateReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateReport_Q7info(), theReportingPackage.getQ7Info(), null, "q7info", null, 0, 1, CreateReport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getReportEClass, GetReport.class, "GetReport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(beginReportNodeEClass, BeginReportNode.class, "BeginReportNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBeginReportNode_Name(), theEcorePackage.getEString(), "name", null, 0, 1, BeginReportNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBeginReportNode_Properties(), theReportPackage.getPropertyMap(), null, "properties", null, 0, -1, BeginReportNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endReportNodeEClass, EndReportNode.class, "EndReportNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEndReportNode_Snaphots(), theEcorePackage.getEString(), "snaphots", null, 0, -1, EndReportNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEndReportNode_TakeSnaphots(), theEcorePackage.getEBoolean(), "takeSnaphots", null, 0, 1, EndReportNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndReportNode_Properties(), theReportPackage.getPropertyMap(), null, "properties", null, 0, -1, EndReportNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reportAppendEClass, ReportAppend.class, "ReportAppend", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReportAppend_Objects(), theEcorePackage.getEObject(), null, "objects", null, 0, -1, ReportAppend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setQ7OptionEClass, SetQ7Option.class, "SetQ7Option", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetQ7Option_Key(), theEcorePackage.getEString(), "key", null, 1, 1, SetQ7Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetQ7Option_Value(), theEcorePackage.getEString(), "value", null, 1, 1, SetQ7Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(execVerificationEClass, ExecVerification.class, "ExecVerification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecVerification_Verification(), theScenarioPackage.getVerification(), null, "verification", null, 0, 1, ExecVerification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecVerification_Phase(), this.getExecutionPhase(), "phase", null, 0, 1, ExecVerification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resetVerificationsEClass, ResetVerifications.class, "ResetVerifications", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(createVerificationEClass, CreateVerification.class, "CreateVerification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateVerification_Type(), theEcorePackage.getEString(), "type", null, 0, 1, CreateVerification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateVerification_Param(), theEcorePackage.getEObject(), null, "param", null, 0, 1, CreateVerification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createWidgetVerificationParamEClass, CreateWidgetVerificationParam.class, "CreateWidgetVerificationParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateWidgetVerificationParam_Selector(), theEcorePackage.getEString(), "selector", null, 0, 1, CreateWidgetVerificationParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(terminateAutEClass, TerminateAut.class, "TerminateAut", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(executionPhaseEEnum, ExecutionPhase.class, "ExecutionPhase");
		addEEnumLiteral(executionPhaseEEnum, ExecutionPhase.AUTO);
		addEEnumLiteral(executionPhaseEEnum, ExecutionPhase.START);
		addEEnumLiteral(executionPhaseEEnum, ExecutionPhase.RUN);
		addEEnumLiteral(executionPhaseEEnum, ExecutionPhase.FINISH);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/ecl/internal
		createInternalAnnotations();
		// http://www.eclipse.org/ecl/input
		createInputAnnotations();
		// http://www.eclipse.org/ecl/docs
		createDocsAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/internal</b>.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void createInternalAnnotations() {
		String source = "http://www.eclipse.org/ecl/internal";		
		addAnnotation
		  (enterContextEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (createContextEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (prepareEnvironmentEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (setCommandsDelayEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getQ7InformationEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (setQ7FeaturesEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getPerspectivesEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getViewsEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (createReportEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getReportEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (beginReportNodeEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (endReportNodeEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (reportAppendEClass, 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (execVerificationEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (createVerificationEClass, 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (terminateAutEClass, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/input</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createInputAnnotations() {
		String source = "http://www.eclipse.org/ecl/input";															
		addAnnotation
		  (getReportAppend_Objects(), 
		   source, 
		   new String[] {
		   });					
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/docs</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDocsAnnotations() {
		String source = "http://www.eclipse.org/ecl/docs";																
		addAnnotation
		  (setQ7OptionEClass, 
		   source, 
		   new String[] {
			 "description", "Sets Q7 runtime option.",
			 "example", "<code>set-q7-option eclExecutionDelay 0</code>"
		   });		
		addAnnotation
		  (getSetQ7Option_Key(), 
		   source, 
		   new String[] {
			 "description", "<br/>\r\nAvailable keys:\r\n<ul>\r\n    <li> <b>jobDebugjobTimeout</b> Eclipse job debug plugin jobs timeout (def: 300000 ms) </li>\r\n    <li> <b>jobSleepingStepTime</b> Step in step mode (def: 200 ms) </li>\r\n    <li> <b>jobSleepingStepTimeout</b> Stepping job timeout (def: 120000 ms) </li>\r\n    <li> <b>jobTreatAsSleepingTimeout</b> Enable Job step mode timeout (def: 10000 ms) </li>\r\n    <li> <b>jobHangTimeout</b> Job skip timeout (def: 30000 ms) </li>\r\n    <li> <b>jobScheduleDelayedMaxtime</b> Wait for jobs with delay less timeout (def: 600 ms) </li>\r\n    <li> <b>eclExecutionDelay</b> Wait for time between each ECL command (def: 0 ms) </li>\r\n    <li> <b>workspaceClearForceGc</b> Forces garbage collection on workspace cleanup (def: true) </li>\r\n</ul>"
		   });			
	}

} // Q7CorePackageImpl
