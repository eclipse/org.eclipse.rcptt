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
package org.eclipse.rcptt.workspace.util;

import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.scenario.NamedElement;

import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.workspace.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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
 * @see org.eclipse.rcptt.workspace.WorkspacePackage
 * @generated
 */
public class WorkspaceSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WorkspacePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkspaceSwitch() {
		if (modelPackage == null) {
			modelPackage = WorkspacePackage.eINSTANCE;
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
			case WorkspacePackage.WORKSPACE_DATA: {
				WorkspaceData workspaceData = (WorkspaceData)theEObject;
				T result = caseWorkspaceData(workspaceData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkspacePackage.WORKSPACE_CONTEXT: {
				WorkspaceContext workspaceContext = (WorkspaceContext)theEObject;
				T result = caseWorkspaceContext(workspaceContext);
				if (result == null) result = caseContext(workspaceContext);
				if (result == null) result = caseWorkspaceData(workspaceContext);
				if (result == null) result = caseNamedElement(workspaceContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkspacePackage.WORKSPACE_VERIFICATION: {
				WorkspaceVerification workspaceVerification = (WorkspaceVerification)theEObject;
				T result = caseWorkspaceVerification(workspaceVerification);
				if (result == null) result = caseVerification(workspaceVerification);
				if (result == null) result = caseWorkspaceData(workspaceVerification);
				if (result == null) result = caseNamedElement(workspaceVerification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkspacePackage.WS_RESOURCE: {
				WSResource wsResource = (WSResource)theEObject;
				T result = caseWSResource(wsResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkspacePackage.WS_CONTAINER: {
				WSContainer wsContainer = (WSContainer)theEObject;
				T result = caseWSContainer(wsContainer);
				if (result == null) result = caseWSResource(wsContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkspacePackage.WS_FILE: {
				WSFile wsFile = (WSFile)theEObject;
				T result = caseWSFile(wsFile);
				if (result == null) result = caseWSResource(wsFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkspacePackage.WS_FOLDER: {
				WSFolder wsFolder = (WSFolder)theEObject;
				T result = caseWSFolder(wsFolder);
				if (result == null) result = caseWSContainer(wsFolder);
				if (result == null) result = caseWSResource(wsFolder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkspacePackage.WS_PROJECT: {
				WSProject wsProject = (WSProject)theEObject;
				T result = caseWSProject(wsProject);
				if (result == null) result = caseWSFolder(wsProject);
				if (result == null) result = caseWSContainer(wsProject);
				if (result == null) result = caseWSResource(wsProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkspacePackage.WS_ROOT: {
				WSRoot wsRoot = (WSRoot)theEObject;
				T result = caseWSRoot(wsRoot);
				if (result == null) result = caseWSContainer(wsRoot);
				if (result == null) result = caseWSResource(wsRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkspacePackage.WS_LINK: {
				WSLink wsLink = (WSLink)theEObject;
				T result = caseWSLink(wsLink);
				if (result == null) result = caseWSResource(wsLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkspacePackage.WS_FILE_LINK: {
				WSFileLink wsFileLink = (WSFileLink)theEObject;
				T result = caseWSFileLink(wsFileLink);
				if (result == null) result = caseWSLink(wsFileLink);
				if (result == null) result = caseWSResource(wsFileLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkspacePackage.WS_FOLDER_LINK: {
				WSFolderLink wsFolderLink = (WSFolderLink)theEObject;
				T result = caseWSFolderLink(wsFolderLink);
				if (result == null) result = caseWSLink(wsFolderLink);
				if (result == null) result = caseWSResource(wsFolderLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkspacePackage.WS_PROJECT_LINK: {
				WSProjectLink wsProjectLink = (WSProjectLink)theEObject;
				T result = caseWSProjectLink(wsProjectLink);
				if (result == null) result = caseWSFolderLink(wsProjectLink);
				if (result == null) result = caseWSLink(wsProjectLink);
				if (result == null) result = caseWSResource(wsProjectLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkspaceData(WorkspaceData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkspaceContext(WorkspaceContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WS Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WS Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSResource(WSResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WS Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WS Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSContainer(WSContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WS File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WS File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSFile(WSFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WS Folder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WS Folder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSFolder(WSFolder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WS Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WS Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSProject(WSProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WS Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WS Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSRoot(WSRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WS Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WS Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSLink(WSLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WS File Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WS File Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSFileLink(WSFileLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WS Folder Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WS Folder Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSFolderLink(WSFolderLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>WS Project Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>WS Project Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWSProjectLink(WSProjectLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Verification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Verification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkspaceVerification(WorkspaceVerification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContext(Context object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Verification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Verification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVerification(Verification object) {
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

} //WorkspaceSwitch
