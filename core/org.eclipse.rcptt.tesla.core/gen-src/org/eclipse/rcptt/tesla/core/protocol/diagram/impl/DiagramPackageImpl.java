/*******************************************************************************
 * Copyright (c) 2014-2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.tesla.core.protocol.diagram.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;

import org.eclipse.rcptt.tesla.core.protocol.diagram.ActivateDirectEdit;
import org.eclipse.rcptt.tesla.core.protocol.diagram.AssertFigureExists;
import org.eclipse.rcptt.tesla.core.protocol.diagram.CancelDirectEdit;
import org.eclipse.rcptt.tesla.core.protocol.diagram.CommitDirectEdit;
import org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnection;
import org.eclipse.rcptt.tesla.core.protocol.diagram.CreateConnectionResponse;
import org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigure;
import org.eclipse.rcptt.tesla.core.protocol.diagram.CreateFigureResponse;
import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramFactory;
import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage;
import org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand;
import org.eclipse.rcptt.tesla.core.protocol.diagram.GetFigures;
import org.eclipse.rcptt.tesla.core.protocol.diagram.GetFiguresResponse;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MoveFigure;
import org.eclipse.rcptt.tesla.core.protocol.diagram.ResizeFigure;
import org.eclipse.rcptt.tesla.core.protocol.diagram.SetFigureSelection;

import org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagramPackageImpl extends EPackageImpl implements DiagramPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createFigureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createFigureResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moveFigureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setFigureSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getFiguresEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getFiguresResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activateDirectEditEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cancelDirectEditEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commitDirectEditEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createConnectionResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resizeFigureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mouseCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass figureMouseCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertFigureExistsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mouseCommandKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DiagramPackageImpl() {
		super(eNS_URI, DiagramFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DiagramPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DiagramPackage init() {
		if (isInited) return (DiagramPackage)EPackage.Registry.INSTANCE.getEPackage(DiagramPackage.eNS_URI);

		// Obtain or create and register package
		DiagramPackageImpl theDiagramPackage = (DiagramPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DiagramPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DiagramPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ProtocolPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDiagramPackage.createPackageContents();

		// Initialize created meta-data
		theDiagramPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDiagramPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DiagramPackage.eNS_URI, theDiagramPackage);
		return theDiagramPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateFigure() {
		return createFigureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateFigure_X() {
		return (EAttribute)createFigureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateFigure_Y() {
		return (EAttribute)createFigureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateFigure_Pattern() {
		return (EAttribute)createFigureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateFigure_GuesPosition() {
		return (EAttribute)createFigureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateFigureResponse() {
		return createFigureResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateFigureResponse_Figure() {
		return (EReference)createFigureResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMoveFigure() {
		return moveFigureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMoveFigure_X() {
		return (EAttribute)moveFigureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMoveFigure_Y() {
		return (EAttribute)moveFigureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetFigureSelection() {
		return setFigureSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetFigureSelection_Figures() {
		return (EReference)setFigureSelectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetFigures() {
		return getFiguresEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetFiguresResponse() {
		return getFiguresResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGetFiguresResponse_Figures() {
		return (EReference)getFiguresResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivateDirectEdit() {
		return activateDirectEditEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivateDirectEdit_PartPath() {
		return (EAttribute)activateDirectEditEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCancelDirectEdit() {
		return cancelDirectEditEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommitDirectEdit() {
		return commitDirectEditEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateConnection() {
		return createConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateConnection_Pattern() {
		return (EAttribute)createConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateConnection_From() {
		return (EReference)createConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateConnection_To() {
		return (EReference)createConnectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateConnectionResponse() {
		return createConnectionResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateConnectionResponse_Figure() {
		return (EReference)createConnectionResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResizeFigure() {
		return resizeFigureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResizeFigure_X() {
		return (EAttribute)resizeFigureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResizeFigure_Y() {
		return (EAttribute)resizeFigureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMouseCommand() {
		return mouseCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseCommand_X() {
		return (EAttribute)mouseCommandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseCommand_Y() {
		return (EAttribute)mouseCommandEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseCommand_Button() {
		return (EAttribute)mouseCommandEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseCommand_Kind() {
		return (EAttribute)mouseCommandEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseCommand_BoundsWidth() {
		return (EAttribute)mouseCommandEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseCommand_BoundsHeight() {
		return (EAttribute)mouseCommandEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseCommand_StateMask() {
		return (EAttribute)mouseCommandEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFigureMouseCommand() {
		return figureMouseCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFigureMouseCommand_X() {
		return (EAttribute)figureMouseCommandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFigureMouseCommand_Y() {
		return (EAttribute)figureMouseCommandEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFigureMouseCommand_Button() {
		return (EAttribute)figureMouseCommandEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFigureMouseCommand_Kind() {
		return (EAttribute)figureMouseCommandEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFigureMouseCommand_FigurePath() {
		return (EAttribute)figureMouseCommandEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFigureMouseCommand_PartPath() {
		return (EAttribute)figureMouseCommandEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFigureMouseCommand_BoundsWidth() {
		return (EAttribute)figureMouseCommandEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFigureMouseCommand_BoundsHeight() {
		return (EAttribute)figureMouseCommandEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFigureMouseCommand_StateMask() {
		return (EAttribute)figureMouseCommandEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFigureMouseCommand_FigureWidth() {
		return (EAttribute)figureMouseCommandEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFigureMouseCommand_FigureHeight() {
		return (EAttribute)figureMouseCommandEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssertFigureExists() {
		return assertFigureExistsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertFigureExists_PartPath() {
		return (EAttribute)assertFigureExistsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertFigureExists_FigureID() {
		return (EAttribute)assertFigureExistsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMouseCommandKind() {
		return mouseCommandKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramFactory getDiagramFactory() {
		return (DiagramFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
		createFigureEClass = createEClass(CREATE_FIGURE);
		createEAttribute(createFigureEClass, CREATE_FIGURE__X);
		createEAttribute(createFigureEClass, CREATE_FIGURE__Y);
		createEAttribute(createFigureEClass, CREATE_FIGURE__PATTERN);
		createEAttribute(createFigureEClass, CREATE_FIGURE__GUES_POSITION);

		createFigureResponseEClass = createEClass(CREATE_FIGURE_RESPONSE);
		createEReference(createFigureResponseEClass, CREATE_FIGURE_RESPONSE__FIGURE);

		moveFigureEClass = createEClass(MOVE_FIGURE);
		createEAttribute(moveFigureEClass, MOVE_FIGURE__X);
		createEAttribute(moveFigureEClass, MOVE_FIGURE__Y);

		setFigureSelectionEClass = createEClass(SET_FIGURE_SELECTION);
		createEReference(setFigureSelectionEClass, SET_FIGURE_SELECTION__FIGURES);

		getFiguresEClass = createEClass(GET_FIGURES);

		getFiguresResponseEClass = createEClass(GET_FIGURES_RESPONSE);
		createEReference(getFiguresResponseEClass, GET_FIGURES_RESPONSE__FIGURES);

		activateDirectEditEClass = createEClass(ACTIVATE_DIRECT_EDIT);
		createEAttribute(activateDirectEditEClass, ACTIVATE_DIRECT_EDIT__PART_PATH);

		cancelDirectEditEClass = createEClass(CANCEL_DIRECT_EDIT);

		commitDirectEditEClass = createEClass(COMMIT_DIRECT_EDIT);

		createConnectionEClass = createEClass(CREATE_CONNECTION);
		createEAttribute(createConnectionEClass, CREATE_CONNECTION__PATTERN);
		createEReference(createConnectionEClass, CREATE_CONNECTION__FROM);
		createEReference(createConnectionEClass, CREATE_CONNECTION__TO);

		createConnectionResponseEClass = createEClass(CREATE_CONNECTION_RESPONSE);
		createEReference(createConnectionResponseEClass, CREATE_CONNECTION_RESPONSE__FIGURE);

		resizeFigureEClass = createEClass(RESIZE_FIGURE);
		createEAttribute(resizeFigureEClass, RESIZE_FIGURE__X);
		createEAttribute(resizeFigureEClass, RESIZE_FIGURE__Y);

		mouseCommandEClass = createEClass(MOUSE_COMMAND);
		createEAttribute(mouseCommandEClass, MOUSE_COMMAND__X);
		createEAttribute(mouseCommandEClass, MOUSE_COMMAND__Y);
		createEAttribute(mouseCommandEClass, MOUSE_COMMAND__BUTTON);
		createEAttribute(mouseCommandEClass, MOUSE_COMMAND__KIND);
		createEAttribute(mouseCommandEClass, MOUSE_COMMAND__BOUNDS_WIDTH);
		createEAttribute(mouseCommandEClass, MOUSE_COMMAND__BOUNDS_HEIGHT);
		createEAttribute(mouseCommandEClass, MOUSE_COMMAND__STATE_MASK);

		figureMouseCommandEClass = createEClass(FIGURE_MOUSE_COMMAND);
		createEAttribute(figureMouseCommandEClass, FIGURE_MOUSE_COMMAND__X);
		createEAttribute(figureMouseCommandEClass, FIGURE_MOUSE_COMMAND__Y);
		createEAttribute(figureMouseCommandEClass, FIGURE_MOUSE_COMMAND__BUTTON);
		createEAttribute(figureMouseCommandEClass, FIGURE_MOUSE_COMMAND__KIND);
		createEAttribute(figureMouseCommandEClass, FIGURE_MOUSE_COMMAND__FIGURE_PATH);
		createEAttribute(figureMouseCommandEClass, FIGURE_MOUSE_COMMAND__PART_PATH);
		createEAttribute(figureMouseCommandEClass, FIGURE_MOUSE_COMMAND__BOUNDS_WIDTH);
		createEAttribute(figureMouseCommandEClass, FIGURE_MOUSE_COMMAND__BOUNDS_HEIGHT);
		createEAttribute(figureMouseCommandEClass, FIGURE_MOUSE_COMMAND__STATE_MASK);
		createEAttribute(figureMouseCommandEClass, FIGURE_MOUSE_COMMAND__FIGURE_WIDTH);
		createEAttribute(figureMouseCommandEClass, FIGURE_MOUSE_COMMAND__FIGURE_HEIGHT);

		assertFigureExistsEClass = createEClass(ASSERT_FIGURE_EXISTS);
		createEAttribute(assertFigureExistsEClass, ASSERT_FIGURE_EXISTS__PART_PATH);
		createEAttribute(assertFigureExistsEClass, ASSERT_FIGURE_EXISTS__FIGURE_ID);

		// Create enums
		mouseCommandKindEEnum = createEEnum(MOUSE_COMMAND_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
		ProtocolPackage theProtocolPackage = (ProtocolPackage)EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI);
		RawPackage theRawPackage = (RawPackage)EPackage.Registry.INSTANCE.getEPackage(RawPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		createFigureEClass.getESuperTypes().add(theProtocolPackage.getElementCommand());
		createFigureResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		moveFigureEClass.getESuperTypes().add(theProtocolPackage.getElementCommand());
		setFigureSelectionEClass.getESuperTypes().add(theProtocolPackage.getElementCommand());
		getFiguresEClass.getESuperTypes().add(theProtocolPackage.getElementCommand());
		getFiguresResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		activateDirectEditEClass.getESuperTypes().add(theProtocolPackage.getElementCommand());
		cancelDirectEditEClass.getESuperTypes().add(theProtocolPackage.getElementCommand());
		commitDirectEditEClass.getESuperTypes().add(theProtocolPackage.getElementCommand());
		createConnectionEClass.getESuperTypes().add(theProtocolPackage.getElementCommand());
		createConnectionResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		resizeFigureEClass.getESuperTypes().add(theProtocolPackage.getElementCommand());
		mouseCommandEClass.getESuperTypes().add(theProtocolPackage.getElementCommand());
		figureMouseCommandEClass.getESuperTypes().add(theProtocolPackage.getElementCommand());
		assertFigureExistsEClass.getESuperTypes().add(theProtocolPackage.getElementCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(createFigureEClass, CreateFigure.class, "CreateFigure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateFigure_X(), ecorePackage.getEInt(), "x", null, 0, 1, CreateFigure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreateFigure_Y(), ecorePackage.getEInt(), "y", null, 0, 1, CreateFigure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreateFigure_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, CreateFigure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreateFigure_GuesPosition(), ecorePackage.getEBoolean(), "guesPosition", null, 0, 1, CreateFigure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createFigureResponseEClass, CreateFigureResponse.class, "CreateFigureResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreateFigureResponse_Figure(), theRawPackage.getElement(), null, "figure", null, 0, -1, CreateFigureResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moveFigureEClass, MoveFigure.class, "MoveFigure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMoveFigure_X(), ecorePackage.getEInt(), "x", null, 0, 1, MoveFigure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMoveFigure_Y(), ecorePackage.getEInt(), "y", null, 0, 1, MoveFigure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setFigureSelectionEClass, SetFigureSelection.class, "SetFigureSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetFigureSelection_Figures(), theRawPackage.getElement(), null, "figures", null, 0, -1, SetFigureSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getFiguresEClass, GetFigures.class, "GetFigures", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getFiguresResponseEClass, GetFiguresResponse.class, "GetFiguresResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGetFiguresResponse_Figures(), theRawPackage.getElement(), null, "figures", null, 0, -1, GetFiguresResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(activateDirectEditEClass, ActivateDirectEdit.class, "ActivateDirectEdit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActivateDirectEdit_PartPath(), ecorePackage.getEInt(), "partPath", null, 0, -1, ActivateDirectEdit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cancelDirectEditEClass, CancelDirectEdit.class, "CancelDirectEdit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(commitDirectEditEClass, CommitDirectEdit.class, "CommitDirectEdit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(createConnectionEClass, CreateConnection.class, "CreateConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateConnection_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, CreateConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateConnection_From(), theRawPackage.getElement(), null, "from", null, 0, 1, CreateConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateConnection_To(), theRawPackage.getElement(), null, "to", null, 0, 1, CreateConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createConnectionResponseEClass, CreateConnectionResponse.class, "CreateConnectionResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreateConnectionResponse_Figure(), theRawPackage.getElement(), null, "figure", null, 0, -1, CreateConnectionResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resizeFigureEClass, ResizeFigure.class, "ResizeFigure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResizeFigure_X(), ecorePackage.getEInt(), "x", null, 0, 1, ResizeFigure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResizeFigure_Y(), ecorePackage.getEInt(), "y", null, 0, 1, ResizeFigure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mouseCommandEClass, MouseCommand.class, "MouseCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMouseCommand_X(), ecorePackage.getEInt(), "x", null, 0, 1, MouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMouseCommand_Y(), ecorePackage.getEInt(), "y", null, 0, 1, MouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMouseCommand_Button(), ecorePackage.getEInt(), "button", null, 0, 1, MouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMouseCommand_Kind(), this.getMouseCommandKind(), "kind", null, 0, 1, MouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMouseCommand_BoundsWidth(), ecorePackage.getEInt(), "boundsWidth", null, 0, 1, MouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMouseCommand_BoundsHeight(), ecorePackage.getEInt(), "boundsHeight", null, 0, 1, MouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMouseCommand_StateMask(), ecorePackage.getEInt(), "stateMask", "0", 0, 1, MouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(figureMouseCommandEClass, FigureMouseCommand.class, "FigureMouseCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFigureMouseCommand_X(), ecorePackage.getEInt(), "x", null, 0, 1, FigureMouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFigureMouseCommand_Y(), ecorePackage.getEInt(), "y", null, 0, 1, FigureMouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFigureMouseCommand_Button(), ecorePackage.getEInt(), "button", null, 0, 1, FigureMouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFigureMouseCommand_Kind(), this.getMouseCommandKind(), "kind", null, 0, 1, FigureMouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFigureMouseCommand_FigurePath(), ecorePackage.getEInt(), "figurePath", null, 0, -1, FigureMouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFigureMouseCommand_PartPath(), ecorePackage.getEInt(), "partPath", null, 0, -1, FigureMouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFigureMouseCommand_BoundsWidth(), ecorePackage.getEInt(), "boundsWidth", null, 0, 1, FigureMouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFigureMouseCommand_BoundsHeight(), ecorePackage.getEInt(), "boundsHeight", null, 0, 1, FigureMouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFigureMouseCommand_StateMask(), ecorePackage.getEInt(), "stateMask", "0", 0, 1, FigureMouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFigureMouseCommand_FigureWidth(), ecorePackage.getEInt(), "figureWidth", null, 0, 1, FigureMouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFigureMouseCommand_FigureHeight(), ecorePackage.getEInt(), "figureHeight", null, 0, 1, FigureMouseCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assertFigureExistsEClass, AssertFigureExists.class, "AssertFigureExists", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssertFigureExists_PartPath(), ecorePackage.getEInt(), "partPath", null, 0, -1, AssertFigureExists.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertFigureExists_FigureID(), ecorePackage.getEString(), "figureID", null, 0, 1, AssertFigureExists.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(mouseCommandKindEEnum, MouseCommandKind.class, "MouseCommandKind");
		addEEnumLiteral(mouseCommandKindEEnum, MouseCommandKind.DOWN);
		addEEnumLiteral(mouseCommandKindEEnum, MouseCommandKind.UP);
		addEEnumLiteral(mouseCommandKindEEnum, MouseCommandKind.MOVE);
		addEEnumLiteral(mouseCommandKindEEnum, MouseCommandKind.DRAG);
		addEEnumLiteral(mouseCommandKindEEnum, MouseCommandKind.DOUBLE_CLICK);
		addEEnumLiteral(mouseCommandKindEEnum, MouseCommandKind.NATIVE_DRAG_STARTED);
		addEEnumLiteral(mouseCommandKindEEnum, MouseCommandKind.NATIVE_DRAG_FINISHED);
		addEEnumLiteral(mouseCommandKindEEnum, MouseCommandKind.ENTER);
		addEEnumLiteral(mouseCommandKindEEnum, MouseCommandKind.EXIT);
		addEEnumLiteral(mouseCommandKindEEnum, MouseCommandKind.HOVER);

		// Create resource
		createResource(eNS_URI);
	}

} //DiagramPackageImpl
