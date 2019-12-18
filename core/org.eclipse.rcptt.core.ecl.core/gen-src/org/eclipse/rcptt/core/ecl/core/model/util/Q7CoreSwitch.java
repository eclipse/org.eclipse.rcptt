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

import java.util.List;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage
 * @generated
 */
public class Q7CoreSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Q7CorePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Q7CoreSwitch() {
		if (modelPackage == null) {
			modelPackage = Q7CorePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case Q7CorePackage.ENTER_CONTEXT: {
				EnterContext enterContext = (EnterContext)theEObject;
				T result = caseEnterContext(enterContext);
				if (result == null) result = caseCommand(enterContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.CREATE_CONTEXT: {
				CreateContext createContext = (CreateContext)theEObject;
				T result = caseCreateContext(createContext);
				if (result == null) result = caseCommand(createContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.PREPARE_ENVIRONMENT: {
				PrepareEnvironment prepareEnvironment = (PrepareEnvironment)theEObject;
				T result = casePrepareEnvironment(prepareEnvironment);
				if (result == null) result = caseCommand(prepareEnvironment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.SET_COMMANDS_DELAY: {
				SetCommandsDelay setCommandsDelay = (SetCommandsDelay)theEObject;
				T result = caseSetCommandsDelay(setCommandsDelay);
				if (result == null) result = caseCommand(setCommandsDelay);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.GET_Q7_INFORMATION: {
				GetQ7Information getQ7Information = (GetQ7Information)theEObject;
				T result = caseGetQ7Information(getQ7Information);
				if (result == null) result = caseCommand(getQ7Information);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.Q7_INFORMATION: {
				Q7Information q7Information = (Q7Information)theEObject;
				T result = caseQ7Information(q7Information);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.SET_Q7_FEATURES: {
				SetQ7Features setQ7Features = (SetQ7Features)theEObject;
				T result = caseSetQ7Features(setQ7Features);
				if (result == null) result = caseCommand(setQ7Features);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.GET_PERSPECTIVES: {
				GetPerspectives getPerspectives = (GetPerspectives)theEObject;
				T result = caseGetPerspectives(getPerspectives);
				if (result == null) result = caseCommand(getPerspectives);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.PERSPECTIVE_INFO: {
				PerspectiveInfo perspectiveInfo = (PerspectiveInfo)theEObject;
				T result = casePerspectiveInfo(perspectiveInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.PERSPECTIVES_LIST: {
				PerspectivesList perspectivesList = (PerspectivesList)theEObject;
				T result = casePerspectivesList(perspectivesList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.GET_VIEWS: {
				GetViews getViews = (GetViews)theEObject;
				T result = caseGetViews(getViews);
				if (result == null) result = caseCommand(getViews);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.VIEW_INFO: {
				ViewInfo viewInfo = (ViewInfo)theEObject;
				T result = caseViewInfo(viewInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.VIEW_LIST: {
				ViewList viewList = (ViewList)theEObject;
				T result = caseViewList(viewList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.CREATE_REPORT: {
				CreateReport createReport = (CreateReport)theEObject;
				T result = caseCreateReport(createReport);
				if (result == null) result = caseCommand(createReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.GET_REPORT: {
				GetReport getReport = (GetReport)theEObject;
				T result = caseGetReport(getReport);
				if (result == null) result = caseCommand(getReport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.BEGIN_REPORT_NODE: {
				BeginReportNode beginReportNode = (BeginReportNode)theEObject;
				T result = caseBeginReportNode(beginReportNode);
				if (result == null) result = caseCommand(beginReportNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.END_REPORT_NODE: {
				EndReportNode endReportNode = (EndReportNode)theEObject;
				T result = caseEndReportNode(endReportNode);
				if (result == null) result = caseCommand(endReportNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.REPORT_APPEND: {
				ReportAppend reportAppend = (ReportAppend)theEObject;
				T result = caseReportAppend(reportAppend);
				if (result == null) result = caseCommand(reportAppend);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.SET_Q7_OPTION: {
				SetQ7Option setQ7Option = (SetQ7Option)theEObject;
				T result = caseSetQ7Option(setQ7Option);
				if (result == null) result = caseCommand(setQ7Option);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.EXEC_VERIFICATION: {
				ExecVerification execVerification = (ExecVerification)theEObject;
				T result = caseExecVerification(execVerification);
				if (result == null) result = caseCommand(execVerification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.RESET_VERIFICATIONS: {
				ResetVerifications resetVerifications = (ResetVerifications)theEObject;
				T result = caseResetVerifications(resetVerifications);
				if (result == null) result = caseCommand(resetVerifications);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.CREATE_VERIFICATION: {
				CreateVerification createVerification = (CreateVerification)theEObject;
				T result = caseCreateVerification(createVerification);
				if (result == null) result = caseCommand(createVerification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.CREATE_WIDGET_VERIFICATION_PARAM: {
				CreateWidgetVerificationParam createWidgetVerificationParam = (CreateWidgetVerificationParam)theEObject;
				T result = caseCreateWidgetVerificationParam(createWidgetVerificationParam);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.TERMINATE_AUT: {
				TerminateAut terminateAut = (TerminateAut)theEObject;
				T result = caseTerminateAut(terminateAut);
				if (result == null) result = caseCommand(terminateAut);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Q7CorePackage.SET_OPTION: {
				SetOption setOption = (SetOption)theEObject;
				T result = caseSetOption(setOption);
				if (result == null) result = caseCommand(setOption);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enter Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enter Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnterContext(EnterContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateContext(CreateContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prepare Environment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prepare Environment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrepareEnvironment(PrepareEnvironment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Commands Delay</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Commands Delay</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetCommandsDelay(SetCommandsDelay object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Q7 Information</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Q7 Information</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetQ7Information(GetQ7Information object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Q7 Information</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Q7 Information</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQ7Information(Q7Information object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Q7 Features</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Q7 Features</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetQ7Features(SetQ7Features object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Perspectives</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Perspectives</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetPerspectives(GetPerspectives object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Perspective Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Perspective Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePerspectiveInfo(PerspectiveInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Perspectives List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Perspectives List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePerspectivesList(PerspectivesList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Views</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Views</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetViews(GetViews object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewInfo(ViewInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewList(ViewList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateReport(CreateReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Report</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Report</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetReport(GetReport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Begin Report Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Begin Report Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBeginReportNode(BeginReportNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Report Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Report Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndReportNode(EndReportNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Report Append</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Report Append</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReportAppend(ReportAppend object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Q7 Option</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Q7 Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetQ7Option(SetQ7Option object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exec Verification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exec Verification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecVerification(ExecVerification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reset Verifications</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reset Verifications</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResetVerifications(ResetVerifications object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Verification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Verification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateVerification(CreateVerification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Widget Verification Param</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Widget Verification Param</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateWidgetVerificationParam(CreateWidgetVerificationParam object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminate Aut</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminate Aut</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminateAut(TerminateAut object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Option</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetOption(SetOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommand(Command object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //Q7CoreSwitch
