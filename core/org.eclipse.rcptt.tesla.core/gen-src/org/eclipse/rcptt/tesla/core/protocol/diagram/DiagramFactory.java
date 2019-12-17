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

package org.eclipse.rcptt.tesla.core.protocol.diagram;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage
 * @generated
 */
public interface DiagramFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagramFactory eINSTANCE = org.eclipse.rcptt.tesla.core.protocol.diagram.impl.DiagramFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Create Figure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Figure</em>'.
	 * @generated
	 */
	CreateFigure createCreateFigure();

	/**
	 * Returns a new object of class '<em>Create Figure Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Figure Response</em>'.
	 * @generated
	 */
	CreateFigureResponse createCreateFigureResponse();

	/**
	 * Returns a new object of class '<em>Move Figure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Move Figure</em>'.
	 * @generated
	 */
	MoveFigure createMoveFigure();

	/**
	 * Returns a new object of class '<em>Set Figure Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Figure Selection</em>'.
	 * @generated
	 */
	SetFigureSelection createSetFigureSelection();

	/**
	 * Returns a new object of class '<em>Get Figures</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Figures</em>'.
	 * @generated
	 */
	GetFigures createGetFigures();

	/**
	 * Returns a new object of class '<em>Get Figures Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Figures Response</em>'.
	 * @generated
	 */
	GetFiguresResponse createGetFiguresResponse();

	/**
	 * Returns a new object of class '<em>Activate Direct Edit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activate Direct Edit</em>'.
	 * @generated
	 */
	ActivateDirectEdit createActivateDirectEdit();

	/**
	 * Returns a new object of class '<em>Cancel Direct Edit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cancel Direct Edit</em>'.
	 * @generated
	 */
	CancelDirectEdit createCancelDirectEdit();

	/**
	 * Returns a new object of class '<em>Commit Direct Edit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Commit Direct Edit</em>'.
	 * @generated
	 */
	CommitDirectEdit createCommitDirectEdit();

	/**
	 * Returns a new object of class '<em>Create Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Connection</em>'.
	 * @generated
	 */
	CreateConnection createCreateConnection();

	/**
	 * Returns a new object of class '<em>Create Connection Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Connection Response</em>'.
	 * @generated
	 */
	CreateConnectionResponse createCreateConnectionResponse();

	/**
	 * Returns a new object of class '<em>Resize Figure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resize Figure</em>'.
	 * @generated
	 */
	ResizeFigure createResizeFigure();

	/**
	 * Returns a new object of class '<em>Mouse Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Command</em>'.
	 * @generated
	 */
	MouseCommand createMouseCommand();

	/**
	 * Returns a new object of class '<em>Figure Mouse Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Figure Mouse Command</em>'.
	 * @generated
	 */
	FigureMouseCommand createFigureMouseCommand();

	/**
	 * Returns a new object of class '<em>Assert Figure Exists</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assert Figure Exists</em>'.
	 * @generated
	 */
	AssertFigureExists createAssertFigureExists();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DiagramPackage getDiagramPackage();

} //DiagramFactory
