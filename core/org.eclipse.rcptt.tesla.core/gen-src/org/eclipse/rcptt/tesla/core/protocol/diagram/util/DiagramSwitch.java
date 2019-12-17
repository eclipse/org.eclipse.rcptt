/*******************************************************************************
 * Copyright (c) 2014-2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.tesla.core.protocol.diagram.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.tesla.core.protocol.ElementCommand;

import org.eclipse.rcptt.tesla.core.protocol.diagram.*;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;

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
 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage
 * @generated
 */
public class DiagramSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DiagramPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramSwitch() {
		if (modelPackage == null) {
			modelPackage = DiagramPackage.eINSTANCE;
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
			case DiagramPackage.CREATE_FIGURE: {
				CreateFigure createFigure = (CreateFigure)theEObject;
				T result = caseCreateFigure(createFigure);
				if (result == null) result = caseElementCommand(createFigure);
				if (result == null) result = caseCommand(createFigure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.CREATE_FIGURE_RESPONSE: {
				CreateFigureResponse createFigureResponse = (CreateFigureResponse)theEObject;
				T result = caseCreateFigureResponse(createFigureResponse);
				if (result == null) result = caseResponse(createFigureResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.MOVE_FIGURE: {
				MoveFigure moveFigure = (MoveFigure)theEObject;
				T result = caseMoveFigure(moveFigure);
				if (result == null) result = caseElementCommand(moveFigure);
				if (result == null) result = caseCommand(moveFigure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.SET_FIGURE_SELECTION: {
				SetFigureSelection setFigureSelection = (SetFigureSelection)theEObject;
				T result = caseSetFigureSelection(setFigureSelection);
				if (result == null) result = caseElementCommand(setFigureSelection);
				if (result == null) result = caseCommand(setFigureSelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.GET_FIGURES: {
				GetFigures getFigures = (GetFigures)theEObject;
				T result = caseGetFigures(getFigures);
				if (result == null) result = caseElementCommand(getFigures);
				if (result == null) result = caseCommand(getFigures);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.GET_FIGURES_RESPONSE: {
				GetFiguresResponse getFiguresResponse = (GetFiguresResponse)theEObject;
				T result = caseGetFiguresResponse(getFiguresResponse);
				if (result == null) result = caseResponse(getFiguresResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.ACTIVATE_DIRECT_EDIT: {
				ActivateDirectEdit activateDirectEdit = (ActivateDirectEdit)theEObject;
				T result = caseActivateDirectEdit(activateDirectEdit);
				if (result == null) result = caseElementCommand(activateDirectEdit);
				if (result == null) result = caseCommand(activateDirectEdit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.CANCEL_DIRECT_EDIT: {
				CancelDirectEdit cancelDirectEdit = (CancelDirectEdit)theEObject;
				T result = caseCancelDirectEdit(cancelDirectEdit);
				if (result == null) result = caseElementCommand(cancelDirectEdit);
				if (result == null) result = caseCommand(cancelDirectEdit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.COMMIT_DIRECT_EDIT: {
				CommitDirectEdit commitDirectEdit = (CommitDirectEdit)theEObject;
				T result = caseCommitDirectEdit(commitDirectEdit);
				if (result == null) result = caseElementCommand(commitDirectEdit);
				if (result == null) result = caseCommand(commitDirectEdit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.CREATE_CONNECTION: {
				CreateConnection createConnection = (CreateConnection)theEObject;
				T result = caseCreateConnection(createConnection);
				if (result == null) result = caseElementCommand(createConnection);
				if (result == null) result = caseCommand(createConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.CREATE_CONNECTION_RESPONSE: {
				CreateConnectionResponse createConnectionResponse = (CreateConnectionResponse)theEObject;
				T result = caseCreateConnectionResponse(createConnectionResponse);
				if (result == null) result = caseResponse(createConnectionResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.RESIZE_FIGURE: {
				ResizeFigure resizeFigure = (ResizeFigure)theEObject;
				T result = caseResizeFigure(resizeFigure);
				if (result == null) result = caseElementCommand(resizeFigure);
				if (result == null) result = caseCommand(resizeFigure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.MOUSE_COMMAND: {
				MouseCommand mouseCommand = (MouseCommand)theEObject;
				T result = caseMouseCommand(mouseCommand);
				if (result == null) result = caseElementCommand(mouseCommand);
				if (result == null) result = caseCommand(mouseCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.FIGURE_MOUSE_COMMAND: {
				FigureMouseCommand figureMouseCommand = (FigureMouseCommand)theEObject;
				T result = caseFigureMouseCommand(figureMouseCommand);
				if (result == null) result = caseElementCommand(figureMouseCommand);
				if (result == null) result = caseCommand(figureMouseCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.ASSERT_FIGURE_EXISTS: {
				AssertFigureExists assertFigureExists = (AssertFigureExists)theEObject;
				T result = caseAssertFigureExists(assertFigureExists);
				if (result == null) result = caseElementCommand(assertFigureExists);
				if (result == null) result = caseCommand(assertFigureExists);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Figure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Figure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateFigure(CreateFigure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Figure Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Figure Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateFigureResponse(CreateFigureResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Move Figure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Move Figure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMoveFigure(MoveFigure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Figure Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Figure Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetFigureSelection(SetFigureSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Figures</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Figures</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetFigures(GetFigures object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Figures Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Figures Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetFiguresResponse(GetFiguresResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activate Direct Edit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activate Direct Edit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivateDirectEdit(ActivateDirectEdit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cancel Direct Edit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cancel Direct Edit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCancelDirectEdit(CancelDirectEdit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Commit Direct Edit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Commit Direct Edit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommitDirectEdit(CommitDirectEdit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateConnection(CreateConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Connection Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Connection Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateConnectionResponse(CreateConnectionResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resize Figure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resize Figure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResizeFigure(ResizeFigure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMouseCommand(MouseCommand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Figure Mouse Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Figure Mouse Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFigureMouseCommand(FigureMouseCommand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assert Figure Exists</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assert Figure Exists</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssertFigureExists(AssertFigureExists object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Element Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementCommand(ElementCommand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResponse(Response object) {
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

} //DiagramSwitch
