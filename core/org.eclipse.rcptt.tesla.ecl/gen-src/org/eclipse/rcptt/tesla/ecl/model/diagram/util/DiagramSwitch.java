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
package org.eclipse.rcptt.tesla.ecl.model.diagram.util;

import org.eclipse.rcptt.tesla.ecl.model.PathSelector;
import org.eclipse.rcptt.tesla.ecl.model.Selector;

import org.eclipse.rcptt.tesla.ecl.model.TextSelector;
import org.eclipse.rcptt.tesla.ecl.model.diagram.*;

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
 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.DiagramPackage
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
			case DiagramPackage.GET_DIAGRAM: {
				GetDiagram getDiagram = (GetDiagram)theEObject;
				T result = caseGetDiagram(getDiagram);
				if (result == null) result = caseSelector(getDiagram);
				if (result == null) result = caseCommand(getDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.GET_PALETTE: {
				GetPalette getPalette = (GetPalette)theEObject;
				T result = caseGetPalette(getPalette);
				if (result == null) result = caseSelector(getPalette);
				if (result == null) result = caseCommand(getPalette);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.GET_EDIT_PART: {
				GetEditPart getEditPart = (GetEditPart)theEObject;
				T result = caseGetEditPart(getEditPart);
				if (result == null) result = caseSelector(getEditPart);
				if (result == null) result = caseCommand(getEditPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.GET_FIGURE: {
				GetFigure getFigure = (GetFigure)theEObject;
				T result = caseGetFigure(getFigure);
				if (result == null) result = casePathSelector(getFigure);
				if (result == null) result = caseSelector(getFigure);
				if (result == null) result = caseCommand(getFigure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.GET_ENTRY: {
				GetEntry getEntry = (GetEntry)theEObject;
				T result = caseGetEntry(getEntry);
				if (result == null) result = caseTextSelector(getEntry);
				if (result == null) result = caseSelector(getEntry);
				if (result == null) result = caseCommand(getEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.DIRECT_EDIT: {
				DirectEdit directEdit = (DirectEdit)theEObject;
				T result = caseDirectEdit(directEdit);
				if (result == null) result = caseCommand(directEdit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.ACTIVATE_DIRECT_EDIT: {
				ActivateDirectEdit activateDirectEdit = (ActivateDirectEdit)theEObject;
				T result = caseActivateDirectEdit(activateDirectEdit);
				if (result == null) result = caseDirectEdit(activateDirectEdit);
				if (result == null) result = caseCommand(activateDirectEdit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.COMMIT_DIRECT_EDIT: {
				CommitDirectEdit commitDirectEdit = (CommitDirectEdit)theEObject;
				T result = caseCommitDirectEdit(commitDirectEdit);
				if (result == null) result = caseDirectEdit(commitDirectEdit);
				if (result == null) result = caseCommand(commitDirectEdit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.CANCEL_DIRECT_EDIT: {
				CancelDirectEdit cancelDirectEdit = (CancelDirectEdit)theEObject;
				T result = caseCancelDirectEdit(cancelDirectEdit);
				if (result == null) result = caseDirectEdit(cancelDirectEdit);
				if (result == null) result = caseCommand(cancelDirectEdit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.MOUSE_ACTION: {
				MouseAction mouseAction = (MouseAction)theEObject;
				T result = caseMouseAction(mouseAction);
				if (result == null) result = caseCommand(mouseAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.MOUSE_MOVE: {
				MouseMove mouseMove = (MouseMove)theEObject;
				T result = caseMouseMove(mouseMove);
				if (result == null) result = caseMouseAction(mouseMove);
				if (result == null) result = caseCommand(mouseMove);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.MOUSE_DRAG: {
				MouseDrag mouseDrag = (MouseDrag)theEObject;
				T result = caseMouseDrag(mouseDrag);
				if (result == null) result = caseMouseAction(mouseDrag);
				if (result == null) result = caseCommand(mouseDrag);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.MOUSE_PRESS: {
				MousePress mousePress = (MousePress)theEObject;
				T result = caseMousePress(mousePress);
				if (result == null) result = caseMouseAction(mousePress);
				if (result == null) result = caseCommand(mousePress);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.MOUSE_RELEASE: {
				MouseRelease mouseRelease = (MouseRelease)theEObject;
				T result = caseMouseRelease(mouseRelease);
				if (result == null) result = caseMouseAction(mouseRelease);
				if (result == null) result = caseCommand(mouseRelease);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.MOUSE_DOUBLE_CLICK: {
				MouseDoubleClick mouseDoubleClick = (MouseDoubleClick)theEObject;
				T result = caseMouseDoubleClick(mouseDoubleClick);
				if (result == null) result = caseMouseAction(mouseDoubleClick);
				if (result == null) result = caseCommand(mouseDoubleClick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.MOUSE_ENTER: {
				MouseEnter mouseEnter = (MouseEnter)theEObject;
				T result = caseMouseEnter(mouseEnter);
				if (result == null) result = caseMouseAction(mouseEnter);
				if (result == null) result = caseCommand(mouseEnter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.MOUSE_EXIT: {
				MouseExit mouseExit = (MouseExit)theEObject;
				T result = caseMouseExit(mouseExit);
				if (result == null) result = caseMouseAction(mouseExit);
				if (result == null) result = caseCommand(mouseExit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.MOUSE_HOVER: {
				MouseHover mouseHover = (MouseHover)theEObject;
				T result = caseMouseHover(mouseHover);
				if (result == null) result = caseMouseAction(mouseHover);
				if (result == null) result = caseCommand(mouseHover);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.GET_SOURCE_CONNECTION: {
				GetSourceConnection getSourceConnection = (GetSourceConnection)theEObject;
				T result = caseGetSourceConnection(getSourceConnection);
				if (result == null) result = casePathSelector(getSourceConnection);
				if (result == null) result = caseSelector(getSourceConnection);
				if (result == null) result = caseCommand(getSourceConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.GET_TARGET_CONNECTION: {
				GetTargetConnection getTargetConnection = (GetTargetConnection)theEObject;
				T result = caseGetTargetConnection(getTargetConnection);
				if (result == null) result = casePathSelector(getTargetConnection);
				if (result == null) result = caseSelector(getTargetConnection);
				if (result == null) result = caseCommand(getTargetConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.GET_POPUP_BAR_ITEM: {
				GetPopupBarItem getPopupBarItem = (GetPopupBarItem)theEObject;
				T result = caseGetPopupBarItem(getPopupBarItem);
				if (result == null) result = casePathSelector(getPopupBarItem);
				if (result == null) result = caseSelector(getPopupBarItem);
				if (result == null) result = caseCommand(getPopupBarItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.GET_CONNECTION_HANDLE: {
				GetConnectionHandle getConnectionHandle = (GetConnectionHandle)theEObject;
				T result = caseGetConnectionHandle(getConnectionHandle);
				if (result == null) result = casePathSelector(getConnectionHandle);
				if (result == null) result = caseSelector(getConnectionHandle);
				if (result == null) result = caseCommand(getConnectionHandle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.GET_PALETTE_ENTRY: {
				GetPaletteEntry getPaletteEntry = (GetPaletteEntry)theEObject;
				T result = caseGetPaletteEntry(getPaletteEntry);
				if (result == null) result = caseTextSelector(getPaletteEntry);
				if (result == null) result = caseSelector(getPaletteEntry);
				if (result == null) result = caseCommand(getPaletteEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.GET_HANDLE: {
				GetHandle getHandle = (GetHandle)theEObject;
				T result = caseGetHandle(getHandle);
				if (result == null) result = caseTextSelector(getHandle);
				if (result == null) result = caseSelector(getHandle);
				if (result == null) result = caseCommand(getHandle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetDiagram(GetDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Palette</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Palette</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetPalette(GetPalette object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Edit Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Edit Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetEditPart(GetEditPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Figure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Figure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetFigure(GetFigure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetEntry(GetEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Direct Edit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Direct Edit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectEdit(DirectEdit object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMouseAction(MouseAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Move</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Move</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMouseMove(MouseMove object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Drag</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Drag</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMouseDrag(MouseDrag object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Press</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Press</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMousePress(MousePress object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Release</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Release</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMouseRelease(MouseRelease object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Double Click</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Double Click</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMouseDoubleClick(MouseDoubleClick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Enter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Enter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMouseEnter(MouseEnter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Exit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Exit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMouseExit(MouseExit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Hover</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Hover</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMouseHover(MouseHover object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Source Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Source Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetSourceConnection(GetSourceConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Target Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Target Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetTargetConnection(GetTargetConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Popup Bar Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Popup Bar Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetPopupBarItem(GetPopupBarItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Connection Handle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Connection Handle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetConnectionHandle(GetConnectionHandle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Palette Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Palette Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetPaletteEntry(GetPaletteEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Handle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Handle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetHandle(GetHandle object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelector(Selector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePathSelector(PathSelector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextSelector(TextSelector object) {
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
