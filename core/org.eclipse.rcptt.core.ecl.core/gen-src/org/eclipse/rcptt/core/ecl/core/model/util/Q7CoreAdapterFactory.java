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
package org.eclipse.rcptt.core.ecl.core.model.util;

import org.eclipse.rcptt.core.ecl.core.model.*;


import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage
 * @generated
 */
public class Q7CoreAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Q7CorePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Q7CoreAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Q7CorePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Q7CoreSwitch<Adapter> modelSwitch =
		new Q7CoreSwitch<Adapter>() {
			@Override
			public Adapter caseEnterContext(EnterContext object) {
				return createEnterContextAdapter();
			}
			@Override
			public Adapter caseCreateContext(CreateContext object) {
				return createCreateContextAdapter();
			}
			@Override
			public Adapter casePrepareEnvironment(PrepareEnvironment object) {
				return createPrepareEnvironmentAdapter();
			}
			@Override
			public Adapter caseSetCommandsDelay(SetCommandsDelay object) {
				return createSetCommandsDelayAdapter();
			}
			@Override
			public Adapter caseGetQ7Information(GetQ7Information object) {
				return createGetQ7InformationAdapter();
			}
			@Override
			public Adapter caseQ7Information(Q7Information object) {
				return createQ7InformationAdapter();
			}
			@Override
			public Adapter caseSetQ7Features(SetQ7Features object) {
				return createSetQ7FeaturesAdapter();
			}
			@Override
			public Adapter caseGetPerspectives(GetPerspectives object) {
				return createGetPerspectivesAdapter();
			}
			@Override
			public Adapter casePerspectiveInfo(PerspectiveInfo object) {
				return createPerspectiveInfoAdapter();
			}
			@Override
			public Adapter casePerspectivesList(PerspectivesList object) {
				return createPerspectivesListAdapter();
			}
			@Override
			public Adapter caseGetViews(GetViews object) {
				return createGetViewsAdapter();
			}
			@Override
			public Adapter caseViewInfo(ViewInfo object) {
				return createViewInfoAdapter();
			}
			@Override
			public Adapter caseViewList(ViewList object) {
				return createViewListAdapter();
			}
			@Override
			public Adapter caseCreateReport(CreateReport object) {
				return createCreateReportAdapter();
			}
			@Override
			public Adapter caseGetReport(GetReport object) {
				return createGetReportAdapter();
			}
			@Override
			public Adapter caseBeginReportNode(BeginReportNode object) {
				return createBeginReportNodeAdapter();
			}
			@Override
			public Adapter caseEndReportNode(EndReportNode object) {
				return createEndReportNodeAdapter();
			}
			@Override
			public Adapter caseReportAppend(ReportAppend object) {
				return createReportAppendAdapter();
			}
			@Override
			public Adapter caseSetQ7Option(SetQ7Option object) {
				return createSetQ7OptionAdapter();
			}
			@Override
			public Adapter caseExecVerification(ExecVerification object) {
				return createExecVerificationAdapter();
			}
			@Override
			public Adapter caseResetVerifications(ResetVerifications object) {
				return createResetVerificationsAdapter();
			}
			@Override
			public Adapter caseCreateVerification(CreateVerification object) {
				return createCreateVerificationAdapter();
			}
			@Override
			public Adapter caseCreateWidgetVerificationParam(CreateWidgetVerificationParam object) {
				return createCreateWidgetVerificationParamAdapter();
			}
			@Override
			public Adapter caseTerminateAut(TerminateAut object) {
				return createTerminateAutAdapter();
			}
			@Override
			public Adapter caseSetOption(SetOption object) {
				return createSetOptionAdapter();
			}
			@Override
			public Adapter caseCommand(Command object) {
				return createCommandAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.EnterContext <em>Enter Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.EnterContext
	 * @generated
	 */
	public Adapter createEnterContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.CreateContext <em>Create Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.CreateContext
	 * @generated
	 */
	public Adapter createCreateContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.PrepareEnvironment <em>Prepare Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.PrepareEnvironment
	 * @generated
	 */
	public Adapter createPrepareEnvironmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.SetCommandsDelay <em>Set Commands Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.SetCommandsDelay
	 * @generated
	 */
	public Adapter createSetCommandsDelayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.GetQ7Information <em>Get Q7 Information</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.GetQ7Information
	 * @generated
	 */
	public Adapter createGetQ7InformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.Q7Information <em>Q7 Information</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7Information
	 * @generated
	 */
	public Adapter createQ7InformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.SetQ7Features <em>Set Q7 Features</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.SetQ7Features
	 * @generated
	 */
	public Adapter createSetQ7FeaturesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.GetPerspectives <em>Get Perspectives</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.GetPerspectives
	 * @generated
	 */
	public Adapter createGetPerspectivesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.PerspectiveInfo <em>Perspective Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.PerspectiveInfo
	 * @generated
	 */
	public Adapter createPerspectiveInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.PerspectivesList <em>Perspectives List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.PerspectivesList
	 * @generated
	 */
	public Adapter createPerspectivesListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.GetViews <em>Get Views</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.GetViews
	 * @generated
	 */
	public Adapter createGetViewsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.ViewInfo <em>View Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ViewInfo
	 * @generated
	 */
	public Adapter createViewInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.ViewList <em>View List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ViewList
	 * @generated
	 */
	public Adapter createViewListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.CreateReport <em>Create Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.CreateReport
	 * @generated
	 */
	public Adapter createCreateReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.GetReport <em>Get Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.GetReport
	 * @generated
	 */
	public Adapter createGetReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.BeginReportNode <em>Begin Report Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.BeginReportNode
	 * @generated
	 */
	public Adapter createBeginReportNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.EndReportNode <em>End Report Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.EndReportNode
	 * @generated
	 */
	public Adapter createEndReportNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.ReportAppend <em>Report Append</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ReportAppend
	 * @generated
	 */
	public Adapter createReportAppendAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.SetQ7Option <em>Set Q7 Option</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.SetQ7Option
	 * @generated
	 */
	public Adapter createSetQ7OptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.ExecVerification <em>Exec Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ExecVerification
	 * @generated
	 */
	public Adapter createExecVerificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.ResetVerifications <em>Reset Verifications</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.ResetVerifications
	 * @generated
	 */
	public Adapter createResetVerificationsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.CreateVerification <em>Create Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.CreateVerification
	 * @generated
	 */
	public Adapter createCreateVerificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.CreateWidgetVerificationParam <em>Create Widget Verification Param</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.CreateWidgetVerificationParam
	 * @generated
	 */
	public Adapter createCreateWidgetVerificationParamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.TerminateAut <em>Terminate Aut</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.TerminateAut
	 * @generated
	 */
	public Adapter createTerminateAutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.core.ecl.core.model.SetOption <em>Set Option</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.core.ecl.core.model.SetOption
	 * @generated
	 */
	public Adapter createSetOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.ecl.core.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.ecl.core.Command
	 * @generated
	 */
	public Adapter createCommandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Q7CoreAdapterFactory
