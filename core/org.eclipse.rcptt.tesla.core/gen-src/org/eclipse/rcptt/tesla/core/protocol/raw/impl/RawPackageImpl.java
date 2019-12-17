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
package org.eclipse.rcptt.tesla.core.protocol.raw.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.rcptt.tesla.core.info.InfoPackage;
import org.eclipse.rcptt.tesla.core.protocol.raw.AssertionFocus;
import org.eclipse.rcptt.tesla.core.protocol.raw.CloseConnection;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandToRawEntry;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransfer;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransferKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteMode;
import org.eclipse.rcptt.tesla.core.protocol.raw.ExecuteScenario;
import org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatus;
import org.eclipse.rcptt.tesla.core.protocol.raw.ExecutionStatusKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.GetFeature;
import org.eclipse.rcptt.tesla.core.protocol.raw.GetFeatureResponse;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResetAssertSelection;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetFeature;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.core.protocol.raw.StepExecution;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaMode;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario;
import org.eclipse.rcptt.tesla.core.ui.UiPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class RawPackageImpl extends EPackageImpl implements RawPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass responseEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandTransferEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass closeConnectionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass teslaScenarioEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandToElementEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandToRawEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getFeatureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getFeatureResponseEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setModeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executeScenarioEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stepExecutionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionStatusEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertionFocusEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rawEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setFeatureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resetAssertSelectionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum responseStatusEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum commandTransferKindEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum teslaModeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum executeModeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum executionStatusKindEEnum = null;

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
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RawPackageImpl() {
		super(eNS_URI, RawFactory.eINSTANCE);
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
	 * This method is used to initialize {@link RawPackage#eINSTANCE} when that
	 * field is accessed. Clients should not invoke it directly. Instead, they
	 * should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RawPackage init() {
		if (isInited)
			return (RawPackage) EPackage.Registry.INSTANCE.getEPackage(RawPackage.eNS_URI);

		// Obtain or create and register package
		RawPackageImpl theRawPackage = (RawPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RawPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new RawPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		InfoPackage.eINSTANCE.eClass();
		UiPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRawPackage.createPackageContents();

		// Initialize created meta-data
		theRawPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRawPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RawPackage.eNS_URI, theRawPackage);
		return theRawPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElement_Id() {
		return (EAttribute) elementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElement_Kind() {
		return (EAttribute) elementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElement_Description() {
		return (EAttribute) elementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommand() {
		return commandEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommand_Id() {
		return (EAttribute) commandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResponse() {
		return responseEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResponse_Status() {
		return (EAttribute) responseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResponse_Message() {
		return (EAttribute) responseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponse_AdvancedInformation() {
		return (EReference) responseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandTransfer() {
		return commandTransferEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandTransfer_Command() {
		return (EReference) commandTransferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandTransfer_Elements() {
		return (EReference) commandTransferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandTransfer_Kind() {
		return (EAttribute) commandTransferEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandTransfer_Controls() {
		return (EReference) commandTransferEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandTransfer_Index() {
		return (EAttribute) commandTransferEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandTransfer_RawEvents() {
		return (EReference) commandTransferEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloseConnection() {
		return closeConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTeslaScenario() {
		return teslaScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTeslaScenario_Commands() {
		return (EReference) teslaScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTeslaScenario_ElementMapping() {
		return (EReference) teslaScenarioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTeslaScenario_Id() {
		return (EAttribute) teslaScenarioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTeslaScenario_RequiredContexts() {
		return (EAttribute) teslaScenarioEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTeslaScenario_RawMapping() {
		return (EReference) teslaScenarioEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandToElementEntry() {
		return commandToElementEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandToElementEntry_Command() {
		return (EReference) commandToElementEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandToElementEntry_Elements() {
		return (EReference) commandToElementEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandToElementEntry_Controls() {
		return (EReference) commandToElementEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandToRawEntry() {
		return commandToRawEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandToRawEntry_RawEvents() {
		return (EReference) commandToRawEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandToRawEntry_Command() {
		return (EReference) commandToRawEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetFeature() {
		return getFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetFeature_Name() {
		return (EAttribute) getFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetFeatureResponse() {
		return getFeatureResponseEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetFeatureResponse_Value() {
		return (EAttribute) getFeatureResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetMode() {
		return setModeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetMode_Mode() {
		return (EAttribute) setModeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetMode_WidgetClasses() {
		return (EAttribute) setModeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecuteScenario() {
		return executeScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecuteScenario_Id() {
		return (EAttribute) executeScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecuteScenario_ExecuteMode() {
		return (EAttribute) executeScenarioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStepExecution() {
		return stepExecutionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStepExecution_Count() {
		return (EAttribute) stepExecutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionStatus() {
		return executionStatusEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionStatus_Message() {
		return (EAttribute) executionStatusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionStatus_Progress() {
		return (EAttribute) executionStatusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionStatus_StatusKind() {
		return (EAttribute) executionStatusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssertionFocus() {
		return assertionFocusEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertionFocus_PointFixed() {
		return (EAttribute) assertionFocusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssertionFocus_Element() {
		return (EReference) assertionFocusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertionFocus_ImageCapture() {
		return (EAttribute) assertionFocusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRawEvent() {
		return rawEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_Widget() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_Type() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_Detail() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_Item() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_Index() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_X() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_Y() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_Width() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_Height() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_Count() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_Time() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_Button() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_Character() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_KeyCode() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_StateMask() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_Start() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_End() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_Text() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_Data() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRawEvent_NativeEvent() {
		return (EAttribute) rawEventEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetFeature() {
		return setFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetFeature_Name() {
		return (EAttribute) setFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetFeature_Value() {
		return (EAttribute) setFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResetAssertSelection() {
		return resetAssertSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getResponseStatus() {
		return responseStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCommandTransferKind() {
		return commandTransferKindEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTeslaMode() {
		return teslaModeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExecuteMode() {
		return executeModeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExecutionStatusKind() {
		return executionStatusKindEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RawFactory getRawFactory() {
		return (RawFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		elementEClass = createEClass(ELEMENT);
		createEAttribute(elementEClass, ELEMENT__ID);
		createEAttribute(elementEClass, ELEMENT__KIND);
		createEAttribute(elementEClass, ELEMENT__DESCRIPTION);

		commandEClass = createEClass(COMMAND);
		createEAttribute(commandEClass, COMMAND__ID);

		responseEClass = createEClass(RESPONSE);
		createEAttribute(responseEClass, RESPONSE__STATUS);
		createEAttribute(responseEClass, RESPONSE__MESSAGE);
		createEReference(responseEClass, RESPONSE__ADVANCED_INFORMATION);

		commandTransferEClass = createEClass(COMMAND_TRANSFER);
		createEReference(commandTransferEClass, COMMAND_TRANSFER__COMMAND);
		createEReference(commandTransferEClass, COMMAND_TRANSFER__ELEMENTS);
		createEAttribute(commandTransferEClass, COMMAND_TRANSFER__KIND);
		createEReference(commandTransferEClass, COMMAND_TRANSFER__CONTROLS);
		createEAttribute(commandTransferEClass, COMMAND_TRANSFER__INDEX);
		createEReference(commandTransferEClass, COMMAND_TRANSFER__RAW_EVENTS);

		closeConnectionEClass = createEClass(CLOSE_CONNECTION);

		teslaScenarioEClass = createEClass(TESLA_SCENARIO);
		createEReference(teslaScenarioEClass, TESLA_SCENARIO__COMMANDS);
		createEReference(teslaScenarioEClass, TESLA_SCENARIO__ELEMENT_MAPPING);
		createEAttribute(teslaScenarioEClass, TESLA_SCENARIO__ID);
		createEAttribute(teslaScenarioEClass, TESLA_SCENARIO__REQUIRED_CONTEXTS);
		createEReference(teslaScenarioEClass, TESLA_SCENARIO__RAW_MAPPING);

		commandToElementEntryEClass = createEClass(COMMAND_TO_ELEMENT_ENTRY);
		createEReference(commandToElementEntryEClass, COMMAND_TO_ELEMENT_ENTRY__COMMAND);
		createEReference(commandToElementEntryEClass, COMMAND_TO_ELEMENT_ENTRY__ELEMENTS);
		createEReference(commandToElementEntryEClass, COMMAND_TO_ELEMENT_ENTRY__CONTROLS);

		commandToRawEntryEClass = createEClass(COMMAND_TO_RAW_ENTRY);
		createEReference(commandToRawEntryEClass, COMMAND_TO_RAW_ENTRY__RAW_EVENTS);
		createEReference(commandToRawEntryEClass, COMMAND_TO_RAW_ENTRY__COMMAND);

		getFeatureEClass = createEClass(GET_FEATURE);
		createEAttribute(getFeatureEClass, GET_FEATURE__NAME);

		getFeatureResponseEClass = createEClass(GET_FEATURE_RESPONSE);
		createEAttribute(getFeatureResponseEClass, GET_FEATURE_RESPONSE__VALUE);

		setModeEClass = createEClass(SET_MODE);
		createEAttribute(setModeEClass, SET_MODE__MODE);
		createEAttribute(setModeEClass, SET_MODE__WIDGET_CLASSES);

		executeScenarioEClass = createEClass(EXECUTE_SCENARIO);
		createEAttribute(executeScenarioEClass, EXECUTE_SCENARIO__ID);
		createEAttribute(executeScenarioEClass, EXECUTE_SCENARIO__EXECUTE_MODE);

		stepExecutionEClass = createEClass(STEP_EXECUTION);
		createEAttribute(stepExecutionEClass, STEP_EXECUTION__COUNT);

		executionStatusEClass = createEClass(EXECUTION_STATUS);
		createEAttribute(executionStatusEClass, EXECUTION_STATUS__MESSAGE);
		createEAttribute(executionStatusEClass, EXECUTION_STATUS__PROGRESS);
		createEAttribute(executionStatusEClass, EXECUTION_STATUS__STATUS_KIND);

		assertionFocusEClass = createEClass(ASSERTION_FOCUS);
		createEAttribute(assertionFocusEClass, ASSERTION_FOCUS__POINT_FIXED);
		createEReference(assertionFocusEClass, ASSERTION_FOCUS__ELEMENT);
		createEAttribute(assertionFocusEClass, ASSERTION_FOCUS__IMAGE_CAPTURE);

		rawEventEClass = createEClass(RAW_EVENT);
		createEAttribute(rawEventEClass, RAW_EVENT__WIDGET);
		createEAttribute(rawEventEClass, RAW_EVENT__TYPE);
		createEAttribute(rawEventEClass, RAW_EVENT__DETAIL);
		createEAttribute(rawEventEClass, RAW_EVENT__ITEM);
		createEAttribute(rawEventEClass, RAW_EVENT__INDEX);
		createEAttribute(rawEventEClass, RAW_EVENT__X);
		createEAttribute(rawEventEClass, RAW_EVENT__Y);
		createEAttribute(rawEventEClass, RAW_EVENT__WIDTH);
		createEAttribute(rawEventEClass, RAW_EVENT__HEIGHT);
		createEAttribute(rawEventEClass, RAW_EVENT__COUNT);
		createEAttribute(rawEventEClass, RAW_EVENT__TIME);
		createEAttribute(rawEventEClass, RAW_EVENT__BUTTON);
		createEAttribute(rawEventEClass, RAW_EVENT__CHARACTER);
		createEAttribute(rawEventEClass, RAW_EVENT__KEY_CODE);
		createEAttribute(rawEventEClass, RAW_EVENT__STATE_MASK);
		createEAttribute(rawEventEClass, RAW_EVENT__START);
		createEAttribute(rawEventEClass, RAW_EVENT__END);
		createEAttribute(rawEventEClass, RAW_EVENT__TEXT);
		createEAttribute(rawEventEClass, RAW_EVENT__DATA);
		createEAttribute(rawEventEClass, RAW_EVENT__NATIVE_EVENT);

		setFeatureEClass = createEClass(SET_FEATURE);
		createEAttribute(setFeatureEClass, SET_FEATURE__NAME);
		createEAttribute(setFeatureEClass, SET_FEATURE__VALUE);

		resetAssertSelectionEClass = createEClass(RESET_ASSERT_SELECTION);

		// Create enums
		responseStatusEEnum = createEEnum(RESPONSE_STATUS);
		commandTransferKindEEnum = createEEnum(COMMAND_TRANSFER_KIND);
		teslaModeEEnum = createEEnum(TESLA_MODE);
		executeModeEEnum = createEEnum(EXECUTE_MODE);
		executionStatusKindEEnum = createEEnum(EXECUTION_STATUS_KIND);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		InfoPackage theInfoPackage = (InfoPackage) EPackage.Registry.INSTANCE.getEPackage(InfoPackage.eNS_URI);
		UiPackage theUiPackage = (UiPackage) EPackage.Registry.INSTANCE.getEPackage(UiPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		closeConnectionEClass.getESuperTypes().add(this.getCommand());
		getFeatureResponseEClass.getESuperTypes().add(this.getResponse());
		assertionFocusEClass.getESuperTypes().add(this.getCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(elementEClass, Element.class, "Element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElement_Id(), ecorePackage.getEString(), "id", null, 0, 1, Element.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElement_Kind(), ecorePackage.getEString(), "kind", null, 0, 1, Element.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, Element.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandEClass, Command.class, "Command", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCommand_Id(), ecorePackage.getEInt(), "id", null, 0, 1, Command.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(responseEClass, Response.class, "Response", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResponse_Status(), this.getResponseStatus(), "status", "Ok", 0, 1, Response.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResponse_Message(), ecorePackage.getEString(), "message", null, 0, 1, Response.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponse_AdvancedInformation(), theInfoPackage.getAdvancedInformation(), null,
				"advancedInformation", null, 0, 1, Response.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandTransferEClass, CommandTransfer.class, "CommandTransfer", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommandTransfer_Command(), this.getCommand(), null, "command", null, 0, 1,
				CommandTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommandTransfer_Elements(), this.getElement(), null, "elements", null, 0, -1,
				CommandTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandTransfer_Kind(), this.getCommandTransferKind(), "kind", null, 0, 1,
				CommandTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getCommandTransfer_Controls(), theUiPackage.getWidget(), null, "controls", null, 0, -1,
				CommandTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandTransfer_Index(), ecorePackage.getEInt(), "index", "0", 0, 1, CommandTransfer.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommandTransfer_RawEvents(), this.getRawEvent(), null, "rawEvents", null, 0, -1,
				CommandTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(closeConnectionEClass, CloseConnection.class, "CloseConnection", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(teslaScenarioEClass, TeslaScenario.class, "TeslaScenario", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTeslaScenario_Commands(), this.getCommand(), null, "commands", null, 0, -1,
				TeslaScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTeslaScenario_ElementMapping(), this.getCommandToElementEntry(), null, "elementMapping",
				null, 0, -1, TeslaScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeslaScenario_Id(), ecorePackage.getEString(), "id", null, 0, 1, TeslaScenario.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeslaScenario_RequiredContexts(), ecorePackage.getEString(), "requiredContexts", null, 0, -1,
				TeslaScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getTeslaScenario_RawMapping(), this.getCommandToRawEntry(), null, "rawMapping", null, 0, -1,
				TeslaScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandToElementEntryEClass, CommandToElementEntry.class, "CommandToElementEntry", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommandToElementEntry_Command(), this.getCommand(), null, "command", null, 0, 1,
				CommandToElementEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommandToElementEntry_Elements(), this.getElement(), null, "elements", null, 0, -1,
				CommandToElementEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommandToElementEntry_Controls(), theUiPackage.getWidget(), null, "controls", null, 0, -1,
				CommandToElementEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandToRawEntryEClass, CommandToRawEntry.class, "CommandToRawEntry", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommandToRawEntry_RawEvents(), this.getRawEvent(), null, "rawEvents", null, 0, -1,
				CommandToRawEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommandToRawEntry_Command(), this.getCommand(), null, "command", null, 0, 1,
				CommandToRawEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getFeatureEClass, GetFeature.class, "GetFeature", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetFeature_Name(), ecorePackage.getEString(), "name", null, 0, 1, GetFeature.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getFeatureResponseEClass, GetFeatureResponse.class, "GetFeatureResponse", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetFeatureResponse_Value(), ecorePackage.getEString(), "value", null, 0, 1,
				GetFeatureResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setModeEClass, SetMode.class, "SetMode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetMode_Mode(), this.getTeslaMode(), "mode", null, 0, 1, SetMode.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetMode_WidgetClasses(), ecorePackage.getEString(), "widgetClasses", null, 0, -1,
				SetMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(executeScenarioEClass, ExecuteScenario.class, "ExecuteScenario", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExecuteScenario_Id(), ecorePackage.getEString(), "id", null, 0, 1, ExecuteScenario.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecuteScenario_ExecuteMode(), this.getExecuteMode(), "executeMode", null, 0, 1,
				ExecuteScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(stepExecutionEClass, StepExecution.class, "StepExecution", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStepExecution_Count(), ecorePackage.getEInt(), "count", "1", 0, 1, StepExecution.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executionStatusEClass, ExecutionStatus.class, "ExecutionStatus", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExecutionStatus_Message(), ecorePackage.getEString(), "message", null, 0, 1,
				ExecutionStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionStatus_Progress(), ecorePackage.getEInt(), "progress", null, 0, 1,
				ExecutionStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionStatus_StatusKind(), this.getExecutionStatusKind(), "statusKind", null, 0, 1,
				ExecutionStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(assertionFocusEClass, AssertionFocus.class, "AssertionFocus", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssertionFocus_PointFixed(), ecorePackage.getEBoolean(), "pointFixed", null, 0, 1,
				AssertionFocus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getAssertionFocus_Element(), this.getElement(), null, "element", null, 0, 1,
				AssertionFocus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertionFocus_ImageCapture(), ecorePackage.getEByteArray(), "imageCapture", null, 0, 1,
				AssertionFocus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(rawEventEClass, RawEvent.class, "RawEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRawEvent_Widget(), ecorePackage.getEString(), "widget", null, 0, -1, RawEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_Type(), ecorePackage.getEInt(), "type", null, 0, 1, RawEvent.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_Detail(), ecorePackage.getEInt(), "detail", null, 0, 1, RawEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_Item(), ecorePackage.getEString(), "item", null, 0, -1, RawEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_Index(), ecorePackage.getEInt(), "index", null, 0, 1, RawEvent.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_X(), ecorePackage.getEInt(), "x", null, 0, 1, RawEvent.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_Y(), ecorePackage.getEInt(), "y", null, 0, 1, RawEvent.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_Width(), ecorePackage.getEInt(), "width", null, 0, 1, RawEvent.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_Height(), ecorePackage.getEInt(), "height", null, 0, 1, RawEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_Count(), ecorePackage.getEInt(), "count", null, 0, 1, RawEvent.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_Time(), ecorePackage.getEInt(), "time", null, 0, 1, RawEvent.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_Button(), ecorePackage.getEInt(), "button", null, 0, 1, RawEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_Character(), ecorePackage.getEChar(), "character", null, 0, 1, RawEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_KeyCode(), ecorePackage.getEInt(), "keyCode", null, 0, 1, RawEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_StateMask(), ecorePackage.getEInt(), "stateMask", null, 0, 1, RawEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_Start(), ecorePackage.getEInt(), "start", null, 0, 1, RawEvent.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_End(), ecorePackage.getEInt(), "end", null, 0, 1, RawEvent.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_Text(), ecorePackage.getEString(), "text", null, 0, 1, RawEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_Data(), ecorePackage.getEString(), "data", null, 0, 1, RawEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRawEvent_NativeEvent(), ecorePackage.getEBoolean(), "nativeEvent", null, 0, 1,
				RawEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(setFeatureEClass, SetFeature.class, "SetFeature", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetFeature_Name(), ecorePackage.getEString(), "name", null, 0, 1, SetFeature.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetFeature_Value(), ecorePackage.getEString(), "value", null, 0, 1, SetFeature.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resetAssertSelectionEClass, ResetAssertSelection.class, "ResetAssertSelection", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(responseStatusEEnum, ResponseStatus.class, "ResponseStatus");
		addEEnumLiteral(responseStatusEEnum, ResponseStatus.OK);
		addEEnumLiteral(responseStatusEEnum, ResponseStatus.FAILED);

		initEEnum(commandTransferKindEEnum, CommandTransferKind.class, "CommandTransferKind");
		addEEnumLiteral(commandTransferKindEEnum, CommandTransferKind.DEFAULT);
		addEEnumLiteral(commandTransferKindEEnum, CommandTransferKind.REPLACE_PREVIOUS);
		addEEnumLiteral(commandTransferKindEEnum, CommandTransferKind.INSERT_BEFORE_ESSENTIAL_COMMAND);
		addEEnumLiteral(commandTransferKindEEnum, CommandTransferKind.INSERT_BEFORE);
		addEEnumLiteral(commandTransferKindEEnum, CommandTransferKind.REMOVE);

		initEEnum(teslaModeEEnum, TeslaMode.class, "TeslaMode");
		addEEnumLiteral(teslaModeEEnum, TeslaMode.FEATURES);
		addEEnumLiteral(teslaModeEEnum, TeslaMode.RECORDING);
		addEEnumLiteral(teslaModeEEnum, TeslaMode.REPLAY);
		addEEnumLiteral(teslaModeEEnum, TeslaMode.ASSERTIONS);
		addEEnumLiteral(teslaModeEEnum, TeslaMode.PAUSE);

		initEEnum(executeModeEEnum, ExecuteMode.class, "ExecuteMode");
		addEEnumLiteral(executeModeEEnum, ExecuteMode.IMMEDIATE);
		addEEnumLiteral(executeModeEEnum, ExecuteMode.STEPBYSTEP);

		initEEnum(executionStatusKindEEnum, ExecutionStatusKind.class, "ExecutionStatusKind");
		addEEnumLiteral(executionStatusKindEEnum, ExecutionStatusKind.STARTED);
		addEEnumLiteral(executionStatusKindEEnum, ExecutionStatusKind.RUNNING);
		addEEnumLiteral(executionStatusKindEEnum, ExecutionStatusKind.FINISHED);
		addEEnumLiteral(executionStatusKindEEnum, ExecutionStatusKind.CANCELED);
		addEEnumLiteral(executionStatusKindEEnum, ExecutionStatusKind.PAUSED);

		// Create resource
		createResource(eNS_URI);
	}

} // RawPackageImpl
