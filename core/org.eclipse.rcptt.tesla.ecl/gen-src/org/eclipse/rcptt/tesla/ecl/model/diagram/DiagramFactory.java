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
package org.eclipse.rcptt.tesla.ecl.model.diagram;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.DiagramPackage
 * @generated
 */
public interface DiagramFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagramFactory eINSTANCE = org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Get Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Diagram</em>'.
	 * @generated
	 */
	GetDiagram createGetDiagram();

	/**
	 * Returns a new object of class '<em>Get Palette</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Palette</em>'.
	 * @generated
	 */
	GetPalette createGetPalette();

	/**
	 * Returns a new object of class '<em>Get Edit Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Edit Part</em>'.
	 * @generated
	 */
	GetEditPart createGetEditPart();

	/**
	 * Returns a new object of class '<em>Get Figure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Figure</em>'.
	 * @generated
	 */
	GetFigure createGetFigure();

	/**
	 * Returns a new object of class '<em>Get Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Entry</em>'.
	 * @generated
	 */
	GetEntry createGetEntry();

	/**
	 * Returns a new object of class '<em>Activate Direct Edit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activate Direct Edit</em>'.
	 * @generated
	 */
	ActivateDirectEdit createActivateDirectEdit();

	/**
	 * Returns a new object of class '<em>Commit Direct Edit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Commit Direct Edit</em>'.
	 * @generated
	 */
	CommitDirectEdit createCommitDirectEdit();

	/**
	 * Returns a new object of class '<em>Cancel Direct Edit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cancel Direct Edit</em>'.
	 * @generated
	 */
	CancelDirectEdit createCancelDirectEdit();

	/**
	 * Returns a new object of class '<em>Mouse Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Action</em>'.
	 * @generated
	 */
	MouseAction createMouseAction();

	/**
	 * Returns a new object of class '<em>Mouse Move</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Move</em>'.
	 * @generated
	 */
	MouseMove createMouseMove();

	/**
	 * Returns a new object of class '<em>Mouse Drag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Drag</em>'.
	 * @generated
	 */
	MouseDrag createMouseDrag();

	/**
	 * Returns a new object of class '<em>Mouse Press</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Press</em>'.
	 * @generated
	 */
	MousePress createMousePress();

	/**
	 * Returns a new object of class '<em>Mouse Release</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Release</em>'.
	 * @generated
	 */
	MouseRelease createMouseRelease();

	/**
	 * Returns a new object of class '<em>Mouse Double Click</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Double Click</em>'.
	 * @generated
	 */
	MouseDoubleClick createMouseDoubleClick();

	/**
	 * Returns a new object of class '<em>Mouse Enter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Enter</em>'.
	 * @generated
	 */
	MouseEnter createMouseEnter();

	/**
	 * Returns a new object of class '<em>Mouse Exit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Exit</em>'.
	 * @generated
	 */
	MouseExit createMouseExit();

	/**
	 * Returns a new object of class '<em>Mouse Hover</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Hover</em>'.
	 * @generated
	 */
	MouseHover createMouseHover();

	/**
	 * Returns a new object of class '<em>Get Source Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Source Connection</em>'.
	 * @generated
	 */
	GetSourceConnection createGetSourceConnection();

	/**
	 * Returns a new object of class '<em>Get Target Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Target Connection</em>'.
	 * @generated
	 */
	GetTargetConnection createGetTargetConnection();

	/**
	 * Returns a new object of class '<em>Get Popup Bar Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Popup Bar Item</em>'.
	 * @generated
	 */
	GetPopupBarItem createGetPopupBarItem();

	/**
	 * Returns a new object of class '<em>Get Connection Handle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Connection Handle</em>'.
	 * @generated
	 */
	GetConnectionHandle createGetConnectionHandle();

	/**
	 * Returns a new object of class '<em>Get Palette Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Palette Entry</em>'.
	 * @generated
	 */
	GetPaletteEntry createGetPaletteEntry();

	/**
	 * Returns a new object of class '<em>Get Handle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Handle</em>'.
	 * @generated
	 */
	GetHandle createGetHandle();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DiagramPackage getDiagramPackage();

} //DiagramFactory
