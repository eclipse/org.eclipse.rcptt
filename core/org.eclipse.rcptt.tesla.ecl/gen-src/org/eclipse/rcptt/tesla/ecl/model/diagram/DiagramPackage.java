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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.rcptt.ecl.core.CorePackage;

import org.eclipse.rcptt.tesla.ecl.model.TeslaPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.DiagramFactory
 * @model kind="package"
 * @generated
 */
public interface DiagramPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "diagram";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/tesla/ecl/diagram";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.ecl.tesla.diagram";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	DiagramPackage eINSTANCE = org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl.init();

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetDiagramImpl
	 * <em>Get Diagram</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetDiagramImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetDiagram()
	 * @generated
	 */
	int GET_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_DIAGRAM__HOST = TeslaPackage.SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIAGRAM__BINDINGS = TeslaPackage.SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_DIAGRAM__ID = TeslaPackage.SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_DIAGRAM__AFTER = TeslaPackage.SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_DIAGRAM__TYPE = TeslaPackage.SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_DIAGRAM__INDEX = TeslaPackage.SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_DIAGRAM__PARENT = TeslaPackage.SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Diagram</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_DIAGRAM_FEATURE_COUNT = TeslaPackage.SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetPaletteImpl
	 * <em>Get Palette</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetPaletteImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetPalette()
	 * @generated
	 */
	int GET_PALETTE = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE__HOST = TeslaPackage.SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE__BINDINGS = TeslaPackage.SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE__ID = TeslaPackage.SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE__AFTER = TeslaPackage.SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE__TYPE = TeslaPackage.SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE__INDEX = TeslaPackage.SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE__PARENT = TeslaPackage.SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Palette</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE_FEATURE_COUNT = TeslaPackage.SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetEditPartImpl
	 * <em>Get Edit Part</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetEditPartImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetEditPart()
	 * @generated
	 */
	int GET_EDIT_PART = 2;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_EDIT_PART__HOST = TeslaPackage.SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDIT_PART__BINDINGS = TeslaPackage.SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_EDIT_PART__ID = TeslaPackage.SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_EDIT_PART__AFTER = TeslaPackage.SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_EDIT_PART__TYPE = TeslaPackage.SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_EDIT_PART__INDEX = TeslaPackage.SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_EDIT_PART__PARENT = TeslaPackage.SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_EDIT_PART__PATH = TeslaPackage.SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_EDIT_PART__NAME = TeslaPackage.SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_EDIT_PART__FEATURE = TeslaPackage.SELECTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_EDIT_PART__CLASS_NAME = TeslaPackage.SELECTOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_EDIT_PART__TEXT = TeslaPackage.SELECTOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Custom Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDIT_PART__CUSTOM_ID = TeslaPackage.SELECTOR_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Get Edit Part</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_EDIT_PART_FEATURE_COUNT = TeslaPackage.SELECTOR_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetFigureImpl
	 * <em>Get Figure</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetFigureImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetFigure()
	 * @generated
	 */
	int GET_FIGURE = 3;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_FIGURE__HOST = TeslaPackage.PATH_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FIGURE__BINDINGS = TeslaPackage.PATH_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_FIGURE__ID = TeslaPackage.PATH_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_FIGURE__AFTER = TeslaPackage.PATH_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_FIGURE__TYPE = TeslaPackage.PATH_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_FIGURE__INDEX = TeslaPackage.PATH_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_FIGURE__PARENT = TeslaPackage.PATH_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_FIGURE__PATH = TeslaPackage.PATH_SELECTOR__PATH;

	/**
	 * The number of structural features of the '<em>Get Figure</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FIGURE_FEATURE_COUNT = TeslaPackage.PATH_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetEntryImpl <em>Get Entry</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetEntryImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetEntry()
	 * @generated
	 */
	int GET_ENTRY = 4;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_ENTRY__HOST = TeslaPackage.TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_ENTRY__BINDINGS = TeslaPackage.TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_ENTRY__ID = TeslaPackage.TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_ENTRY__AFTER = TeslaPackage.TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_ENTRY__TYPE = TeslaPackage.TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_ENTRY__INDEX = TeslaPackage.TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_ENTRY__PARENT = TeslaPackage.TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_ENTRY__TEXT = TeslaPackage.TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Entry</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_ENTRY_FEATURE_COUNT = TeslaPackage.TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DirectEditImpl
	 * <em>Direct Edit</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DirectEditImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getDirectEdit()
	 * @generated
	 */
	int DIRECT_EDIT = 5;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIRECT_EDIT__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_EDIT__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIRECT_EDIT__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Direct Edit</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECT_EDIT_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.ActivateDirectEditImpl <em>Activate Direct Edit</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.ActivateDirectEditImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getActivateDirectEdit()
	 * @generated
	 */
	int ACTIVATE_DIRECT_EDIT = 6;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_DIRECT_EDIT__HOST = DIRECT_EDIT__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_DIRECT_EDIT__BINDINGS = DIRECT_EDIT__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_DIRECT_EDIT__CONTROL = DIRECT_EDIT__CONTROL;

	/**
	 * The number of structural features of the '<em>Activate Direct Edit</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATE_DIRECT_EDIT_FEATURE_COUNT = DIRECT_EDIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.CommitDirectEditImpl <em>Commit Direct Edit</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.CommitDirectEditImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getCommitDirectEdit()
	 * @generated
	 */
	int COMMIT_DIRECT_EDIT = 7;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMIT_DIRECT_EDIT__HOST = DIRECT_EDIT__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMIT_DIRECT_EDIT__BINDINGS = DIRECT_EDIT__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMIT_DIRECT_EDIT__CONTROL = DIRECT_EDIT__CONTROL;

	/**
	 * The number of structural features of the '<em>Commit Direct Edit</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMIT_DIRECT_EDIT_FEATURE_COUNT = DIRECT_EDIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.CancelDirectEditImpl <em>Cancel Direct Edit</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.CancelDirectEditImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getCancelDirectEdit()
	 * @generated
	 */
	int CANCEL_DIRECT_EDIT = 8;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CANCEL_DIRECT_EDIT__HOST = DIRECT_EDIT__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_DIRECT_EDIT__BINDINGS = DIRECT_EDIT__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CANCEL_DIRECT_EDIT__CONTROL = DIRECT_EDIT__CONTROL;

	/**
	 * The number of structural features of the '<em>Cancel Direct Edit</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANCEL_DIRECT_EDIT_FEATURE_COUNT = DIRECT_EDIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseActionImpl
	 * <em>Mouse Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseActionImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseAction()
	 * @generated
	 */
	int MOUSE_ACTION = 9;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_ACTION__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_ACTION__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_ACTION__CONTROL = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_ACTION__X = CorePackage.COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_ACTION__Y = CorePackage.COMMAND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_ACTION__BUTTON = CorePackage.COMMAND_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_ACTION__MASK = CorePackage.COMMAND_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_ACTION__HEIGHT = CorePackage.COMMAND_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_ACTION__WIDTH = CorePackage.COMMAND_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Mouse Action</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_ACTION_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseMoveImpl
	 * <em>Mouse Move</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseMoveImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseMove()
	 * @generated
	 */
	int MOUSE_MOVE = 10;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_MOVE__HOST = MOUSE_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_MOVE__BINDINGS = MOUSE_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_MOVE__CONTROL = MOUSE_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_MOVE__X = MOUSE_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_MOVE__Y = MOUSE_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_MOVE__BUTTON = MOUSE_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_MOVE__MASK = MOUSE_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_MOVE__HEIGHT = MOUSE_ACTION__HEIGHT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_MOVE__WIDTH = MOUSE_ACTION__WIDTH;

	/**
	 * The number of structural features of the '<em>Mouse Move</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_MOVE_FEATURE_COUNT = MOUSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseDragImpl
	 * <em>Mouse Drag</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseDragImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseDrag()
	 * @generated
	 */
	int MOUSE_DRAG = 11;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_DRAG__HOST = MOUSE_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_DRAG__BINDINGS = MOUSE_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_DRAG__CONTROL = MOUSE_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_DRAG__X = MOUSE_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_DRAG__Y = MOUSE_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_DRAG__BUTTON = MOUSE_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_DRAG__MASK = MOUSE_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_DRAG__HEIGHT = MOUSE_ACTION__HEIGHT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_DRAG__WIDTH = MOUSE_ACTION__WIDTH;

	/**
	 * The number of structural features of the '<em>Mouse Drag</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_DRAG_FEATURE_COUNT = MOUSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MousePressImpl
	 * <em>Mouse Press</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MousePressImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMousePress()
	 * @generated
	 */
	int MOUSE_PRESS = 12;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_PRESS__HOST = MOUSE_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_PRESS__BINDINGS = MOUSE_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_PRESS__CONTROL = MOUSE_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_PRESS__X = MOUSE_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_PRESS__Y = MOUSE_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_PRESS__BUTTON = MOUSE_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_PRESS__MASK = MOUSE_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_PRESS__HEIGHT = MOUSE_ACTION__HEIGHT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_PRESS__WIDTH = MOUSE_ACTION__WIDTH;

	/**
	 * The number of structural features of the '<em>Mouse Press</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_PRESS_FEATURE_COUNT = MOUSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseReleaseImpl
	 * <em>Mouse Release</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseReleaseImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseRelease()
	 * @generated
	 */
	int MOUSE_RELEASE = 13;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_RELEASE__HOST = MOUSE_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_RELEASE__BINDINGS = MOUSE_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_RELEASE__CONTROL = MOUSE_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_RELEASE__X = MOUSE_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_RELEASE__Y = MOUSE_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_RELEASE__BUTTON = MOUSE_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_RELEASE__MASK = MOUSE_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_RELEASE__HEIGHT = MOUSE_ACTION__HEIGHT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_RELEASE__WIDTH = MOUSE_ACTION__WIDTH;

	/**
	 * The number of structural features of the '<em>Mouse Release</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_RELEASE_FEATURE_COUNT = MOUSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseDoubleClickImpl <em>Mouse Double Click</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseDoubleClickImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseDoubleClick()
	 * @generated
	 */
	int MOUSE_DOUBLE_CLICK = 14;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_DOUBLE_CLICK__HOST = MOUSE_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_DOUBLE_CLICK__BINDINGS = MOUSE_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_DOUBLE_CLICK__CONTROL = MOUSE_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_DOUBLE_CLICK__X = MOUSE_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_DOUBLE_CLICK__Y = MOUSE_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_DOUBLE_CLICK__BUTTON = MOUSE_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_DOUBLE_CLICK__MASK = MOUSE_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_DOUBLE_CLICK__HEIGHT = MOUSE_ACTION__HEIGHT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_DOUBLE_CLICK__WIDTH = MOUSE_ACTION__WIDTH;

	/**
	 * The number of structural features of the '<em>Mouse Double Click</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_DOUBLE_CLICK_FEATURE_COUNT = MOUSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseEnterImpl
	 * <em>Mouse Enter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseEnterImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseEnter()
	 * @generated
	 */
	int MOUSE_ENTER = 15;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_ENTER__HOST = MOUSE_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_ENTER__BINDINGS = MOUSE_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_ENTER__CONTROL = MOUSE_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_ENTER__X = MOUSE_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_ENTER__Y = MOUSE_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_ENTER__BUTTON = MOUSE_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_ENTER__MASK = MOUSE_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_ENTER__HEIGHT = MOUSE_ACTION__HEIGHT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_ENTER__WIDTH = MOUSE_ACTION__WIDTH;

	/**
	 * The number of structural features of the '<em>Mouse Enter</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_ENTER_FEATURE_COUNT = MOUSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseExitImpl
	 * <em>Mouse Exit</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseExitImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseExit()
	 * @generated
	 */
	int MOUSE_EXIT = 16;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_EXIT__HOST = MOUSE_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_EXIT__BINDINGS = MOUSE_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_EXIT__CONTROL = MOUSE_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_EXIT__X = MOUSE_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_EXIT__Y = MOUSE_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_EXIT__BUTTON = MOUSE_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_EXIT__MASK = MOUSE_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_EXIT__HEIGHT = MOUSE_ACTION__HEIGHT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_EXIT__WIDTH = MOUSE_ACTION__WIDTH;

	/**
	 * The number of structural features of the '<em>Mouse Exit</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_EXIT_FEATURE_COUNT = MOUSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseHoverImpl
	 * <em>Mouse Hover</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseHoverImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseHover()
	 * @generated
	 */
	int MOUSE_HOVER = 17;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_HOVER__HOST = MOUSE_ACTION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_HOVER__BINDINGS = MOUSE_ACTION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Control</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_HOVER__CONTROL = MOUSE_ACTION__CONTROL;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_HOVER__X = MOUSE_ACTION__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_HOVER__Y = MOUSE_ACTION__Y;

	/**
	 * The feature id for the '<em><b>Button</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_HOVER__BUTTON = MOUSE_ACTION__BUTTON;

	/**
	 * The feature id for the '<em><b>Mask</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_HOVER__MASK = MOUSE_ACTION__MASK;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_HOVER__HEIGHT = MOUSE_ACTION__HEIGHT;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MOUSE_HOVER__WIDTH = MOUSE_ACTION__WIDTH;

	/**
	 * The number of structural features of the '<em>Mouse Hover</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOUSE_HOVER_FEATURE_COUNT = MOUSE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetSourceConnectionImpl <em>Get Source Connection</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetSourceConnectionImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetSourceConnection()
	 * @generated
	 */
	int GET_SOURCE_CONNECTION = 18;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_SOURCE_CONNECTION__HOST = TeslaPackage.PATH_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SOURCE_CONNECTION__BINDINGS = TeslaPackage.PATH_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_SOURCE_CONNECTION__ID = TeslaPackage.PATH_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_SOURCE_CONNECTION__AFTER = TeslaPackage.PATH_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_SOURCE_CONNECTION__TYPE = TeslaPackage.PATH_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_SOURCE_CONNECTION__INDEX = TeslaPackage.PATH_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_SOURCE_CONNECTION__PARENT = TeslaPackage.PATH_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_SOURCE_CONNECTION__PATH = TeslaPackage.PATH_SELECTOR__PATH;

	/**
	 * The number of structural features of the '<em>Get Source Connection</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_SOURCE_CONNECTION_FEATURE_COUNT = TeslaPackage.PATH_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetTargetConnectionImpl <em>Get Target Connection</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetTargetConnectionImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetTargetConnection()
	 * @generated
	 */
	int GET_TARGET_CONNECTION = 19;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_TARGET_CONNECTION__HOST = TeslaPackage.PATH_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TARGET_CONNECTION__BINDINGS = TeslaPackage.PATH_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_TARGET_CONNECTION__ID = TeslaPackage.PATH_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_TARGET_CONNECTION__AFTER = TeslaPackage.PATH_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_TARGET_CONNECTION__TYPE = TeslaPackage.PATH_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_TARGET_CONNECTION__INDEX = TeslaPackage.PATH_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_TARGET_CONNECTION__PARENT = TeslaPackage.PATH_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_TARGET_CONNECTION__PATH = TeslaPackage.PATH_SELECTOR__PATH;

	/**
	 * The number of structural features of the '<em>Get Target Connection</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_TARGET_CONNECTION_FEATURE_COUNT = TeslaPackage.PATH_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetPopupBarItemImpl <em>Get Popup Bar Item</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetPopupBarItemImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetPopupBarItem()
	 * @generated
	 */
	int GET_POPUP_BAR_ITEM = 20;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_POPUP_BAR_ITEM__HOST = TeslaPackage.PATH_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_POPUP_BAR_ITEM__BINDINGS = TeslaPackage.PATH_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_POPUP_BAR_ITEM__ID = TeslaPackage.PATH_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_POPUP_BAR_ITEM__AFTER = TeslaPackage.PATH_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_POPUP_BAR_ITEM__TYPE = TeslaPackage.PATH_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_POPUP_BAR_ITEM__INDEX = TeslaPackage.PATH_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_POPUP_BAR_ITEM__PARENT = TeslaPackage.PATH_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_POPUP_BAR_ITEM__PATH = TeslaPackage.PATH_SELECTOR__PATH;

	/**
	 * The number of structural features of the '<em>Get Popup Bar Item</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_POPUP_BAR_ITEM_FEATURE_COUNT = TeslaPackage.PATH_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetConnectionHandleImpl <em>Get Connection Handle</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetConnectionHandleImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetConnectionHandle()
	 * @generated
	 */
	int GET_CONNECTION_HANDLE = 21;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_CONNECTION_HANDLE__HOST = TeslaPackage.PATH_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CONNECTION_HANDLE__BINDINGS = TeslaPackage.PATH_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_CONNECTION_HANDLE__ID = TeslaPackage.PATH_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_CONNECTION_HANDLE__AFTER = TeslaPackage.PATH_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_CONNECTION_HANDLE__TYPE = TeslaPackage.PATH_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_CONNECTION_HANDLE__INDEX = TeslaPackage.PATH_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_CONNECTION_HANDLE__PARENT = TeslaPackage.PATH_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_CONNECTION_HANDLE__PATH = TeslaPackage.PATH_SELECTOR__PATH;

	/**
	 * The number of structural features of the '<em>Get Connection Handle</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_CONNECTION_HANDLE_FEATURE_COUNT = TeslaPackage.PATH_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetPaletteEntryImpl <em>Get Palette Entry</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetPaletteEntryImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetPaletteEntry()
	 * @generated
	 */
	int GET_PALETTE_ENTRY = 22;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE_ENTRY__HOST = TeslaPackage.TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE_ENTRY__BINDINGS = TeslaPackage.TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE_ENTRY__ID = TeslaPackage.TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE_ENTRY__AFTER = TeslaPackage.TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE_ENTRY__TYPE = TeslaPackage.TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE_ENTRY__INDEX = TeslaPackage.TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE_ENTRY__PARENT = TeslaPackage.TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE_ENTRY__TEXT = TeslaPackage.TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Palette Entry</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_PALETTE_ENTRY_FEATURE_COUNT = TeslaPackage.TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetHandleImpl
	 * <em>Get Handle</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetHandleImpl
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetHandle()
	 * @generated
	 */
	int GET_HANDLE = 23;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_HANDLE__HOST = TeslaPackage.TEXT_SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_HANDLE__BINDINGS = TeslaPackage.TEXT_SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_HANDLE__ID = TeslaPackage.TEXT_SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_HANDLE__AFTER = TeslaPackage.TEXT_SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_HANDLE__TYPE = TeslaPackage.TEXT_SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_HANDLE__INDEX = TeslaPackage.TEXT_SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_HANDLE__PARENT = TeslaPackage.TEXT_SELECTOR__PARENT;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GET_HANDLE__TEXT = TeslaPackage.TEXT_SELECTOR__TEXT;

	/**
	 * The number of structural features of the '<em>Get Handle</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_HANDLE_FEATURE_COUNT = TeslaPackage.TEXT_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetDiagram <em>Get Diagram</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Diagram</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetDiagram
	 * @generated
	 */
	EClass getGetDiagram();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetPalette <em>Get Palette</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Palette</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetPalette
	 * @generated
	 */
	EClass getGetPalette();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart <em>Get Edit Part</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Edit Part</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart
	 * @generated
	 */
	EClass getGetEditPart();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart#getPath()
	 * @see #getGetEditPart()
	 * @generated
	 */
	EAttribute getGetEditPart_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart#getName()
	 * @see #getGetEditPart()
	 * @generated
	 */
	EAttribute getGetEditPart_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart#getFeature()
	 * @see #getGetEditPart()
	 * @generated
	 */
	EAttribute getGetEditPart_Feature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart#getClassName()
	 * @see #getGetEditPart()
	 * @generated
	 */
	EAttribute getGetEditPart_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart#getText <em>Text</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart#getText()
	 * @see #getGetEditPart()
	 * @generated
	 */
	EAttribute getGetEditPart_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart#getCustomId <em>Custom Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Custom Id</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart#getCustomId()
	 * @see #getGetEditPart()
	 * @generated
	 */
	EAttribute getGetEditPart_CustomId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetFigure <em>Get Figure</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Figure</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetFigure
	 * @generated
	 */
	EClass getGetFigure();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetEntry <em>Get Entry</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Entry</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetEntry
	 * @generated
	 */
	EClass getGetEntry();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.DirectEdit <em>Direct Edit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Direct Edit</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.DirectEdit
	 * @generated
	 */
	EClass getDirectEdit();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.DirectEdit#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.DirectEdit#getControl()
	 * @see #getDirectEdit()
	 * @generated
	 */
	EReference getDirectEdit_Control();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.ActivateDirectEdit <em>Activate Direct Edit</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for class '<em>Activate Direct Edit</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.ActivateDirectEdit
	 * @generated
	 */
	EClass getActivateDirectEdit();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.CommitDirectEdit
	 * <em>Commit Direct Edit</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Commit Direct Edit</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.CommitDirectEdit
	 * @generated
	 */
	EClass getCommitDirectEdit();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.CancelDirectEdit
	 * <em>Cancel Direct Edit</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Cancel Direct Edit</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.CancelDirectEdit
	 * @generated
	 */
	EClass getCancelDirectEdit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction <em>Mouse Action</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mouse Action</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction
	 * @generated
	 */
	EClass getMouseAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getControl <em>Control</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getControl()
	 * @see #getMouseAction()
	 * @generated
	 */
	EReference getMouseAction_Control();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getX <em>X</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getX()
	 * @see #getMouseAction()
	 * @generated
	 */
	EAttribute getMouseAction_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getY <em>Y</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getY()
	 * @see #getMouseAction()
	 * @generated
	 */
	EAttribute getMouseAction_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getMask <em>Mask</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mask</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getMask()
	 * @see #getMouseAction()
	 * @generated
	 */
	EAttribute getMouseAction_Mask();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getButton <em>Button</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getButton()
	 * @see #getMouseAction()
	 * @generated
	 */
	EAttribute getMouseAction_Button();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getHeight()
	 * @see #getMouseAction()
	 * @generated
	 */
	EAttribute getMouseAction_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction#getWidth()
	 * @see #getMouseAction()
	 * @generated
	 */
	EAttribute getMouseAction_Width();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseMove <em>Mouse Move</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mouse Move</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseMove
	 * @generated
	 */
	EClass getMouseMove();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseDrag <em>Mouse Drag</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mouse Drag</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseDrag
	 * @generated
	 */
	EClass getMouseDrag();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MousePress <em>Mouse Press</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mouse Press</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MousePress
	 * @generated
	 */
	EClass getMousePress();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseRelease <em>Mouse Release</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mouse Release</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseRelease
	 * @generated
	 */
	EClass getMouseRelease();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseDoubleClick
	 * <em>Mouse Double Click</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Mouse Double Click</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseDoubleClick
	 * @generated
	 */
	EClass getMouseDoubleClick();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseEnter <em>Mouse Enter</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mouse Enter</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseEnter
	 * @generated
	 */
	EClass getMouseEnter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseExit <em>Mouse Exit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mouse Exit</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseExit
	 * @generated
	 */
	EClass getMouseExit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseHover <em>Mouse Hover</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mouse Hover</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseHover
	 * @generated
	 */
	EClass getMouseHover();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetSourceConnection <em>Get Source Connection</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for class '<em>Get Source Connection</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetSourceConnection
	 * @generated
	 */
	EClass getGetSourceConnection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetTargetConnection <em>Get Target Connection</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for class '<em>Get Target Connection</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetTargetConnection
	 * @generated
	 */
	EClass getGetTargetConnection();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetPopupBarItem
	 * <em>Get Popup Bar Item</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Get Popup Bar Item</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetPopupBarItem
	 * @generated
	 */
	EClass getGetPopupBarItem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetConnectionHandle <em>Get Connection Handle</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for class '<em>Get Connection Handle</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetConnectionHandle
	 * @generated
	 */
	EClass getGetConnectionHandle();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetPaletteEntry
	 * <em>Get Palette Entry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Get Palette Entry</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetPaletteEntry
	 * @generated
	 */
	EClass getGetPaletteEntry();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetHandle <em>Get Handle</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Handle</em>'.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetHandle
	 * @generated
	 */
	EClass getGetHandle();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiagramFactory getDiagramFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetDiagramImpl <em>Get Diagram</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetDiagramImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetDiagram()
		 * @generated
		 */
		EClass GET_DIAGRAM = eINSTANCE.getGetDiagram();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetPaletteImpl <em>Get Palette</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetPaletteImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetPalette()
		 * @generated
		 */
		EClass GET_PALETTE = eINSTANCE.getGetPalette();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetEditPartImpl <em>Get Edit Part</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetEditPartImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetEditPart()
		 * @generated
		 */
		EClass GET_EDIT_PART = eINSTANCE.getGetEditPart();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_EDIT_PART__PATH = eINSTANCE.getGetEditPart_Path();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_EDIT_PART__NAME = eINSTANCE.getGetEditPart_Name();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_EDIT_PART__FEATURE = eINSTANCE.getGetEditPart_Feature();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_EDIT_PART__CLASS_NAME = eINSTANCE.getGetEditPart_ClassName();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_EDIT_PART__TEXT = eINSTANCE.getGetEditPart_Text();

		/**
		 * The meta object literal for the '<em><b>Custom Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_EDIT_PART__CUSTOM_ID = eINSTANCE.getGetEditPart_CustomId();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetFigureImpl <em>Get Figure</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetFigureImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetFigure()
		 * @generated
		 */
		EClass GET_FIGURE = eINSTANCE.getGetFigure();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetEntryImpl
		 * <em>Get Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetEntryImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetEntry()
		 * @generated
		 */
		EClass GET_ENTRY = eINSTANCE.getGetEntry();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DirectEditImpl <em>Direct Edit</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DirectEditImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getDirectEdit()
		 * @generated
		 */
		EClass DIRECT_EDIT = eINSTANCE.getDirectEdit();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECT_EDIT__CONTROL = eINSTANCE.getDirectEdit_Control();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.ActivateDirectEditImpl <em>Activate Direct Edit</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.ActivateDirectEditImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getActivateDirectEdit()
		 * @generated
		 */
		EClass ACTIVATE_DIRECT_EDIT = eINSTANCE.getActivateDirectEdit();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.CommitDirectEditImpl <em>Commit Direct Edit</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.CommitDirectEditImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getCommitDirectEdit()
		 * @generated
		 */
		EClass COMMIT_DIRECT_EDIT = eINSTANCE.getCommitDirectEdit();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.CancelDirectEditImpl <em>Cancel Direct Edit</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.CancelDirectEditImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getCancelDirectEdit()
		 * @generated
		 */
		EClass CANCEL_DIRECT_EDIT = eINSTANCE.getCancelDirectEdit();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseActionImpl <em>Mouse Action</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseActionImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseAction()
		 * @generated
		 */
		EClass MOUSE_ACTION = eINSTANCE.getMouseAction();

		/**
		 * The meta object literal for the '<em><b>Control</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOUSE_ACTION__CONTROL = eINSTANCE.getMouseAction_Control();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_ACTION__X = eINSTANCE.getMouseAction_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_ACTION__Y = eINSTANCE.getMouseAction_Y();

		/**
		 * The meta object literal for the '<em><b>Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_ACTION__MASK = eINSTANCE.getMouseAction_Mask();

		/**
		 * The meta object literal for the '<em><b>Button</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_ACTION__BUTTON = eINSTANCE.getMouseAction_Button();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_ACTION__HEIGHT = eINSTANCE.getMouseAction_Height();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOUSE_ACTION__WIDTH = eINSTANCE.getMouseAction_Width();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseMoveImpl <em>Mouse Move</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseMoveImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseMove()
		 * @generated
		 */
		EClass MOUSE_MOVE = eINSTANCE.getMouseMove();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseDragImpl <em>Mouse Drag</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseDragImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseDrag()
		 * @generated
		 */
		EClass MOUSE_DRAG = eINSTANCE.getMouseDrag();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MousePressImpl <em>Mouse Press</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MousePressImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMousePress()
		 * @generated
		 */
		EClass MOUSE_PRESS = eINSTANCE.getMousePress();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseReleaseImpl <em>Mouse Release</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseReleaseImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseRelease()
		 * @generated
		 */
		EClass MOUSE_RELEASE = eINSTANCE.getMouseRelease();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseDoubleClickImpl <em>Mouse Double Click</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseDoubleClickImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseDoubleClick()
		 * @generated
		 */
		EClass MOUSE_DOUBLE_CLICK = eINSTANCE.getMouseDoubleClick();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseEnterImpl <em>Mouse Enter</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseEnterImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseEnter()
		 * @generated
		 */
		EClass MOUSE_ENTER = eINSTANCE.getMouseEnter();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseExitImpl <em>Mouse Exit</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseExitImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseExit()
		 * @generated
		 */
		EClass MOUSE_EXIT = eINSTANCE.getMouseExit();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseHoverImpl <em>Mouse Hover</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.MouseHoverImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getMouseHover()
		 * @generated
		 */
		EClass MOUSE_HOVER = eINSTANCE.getMouseHover();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetSourceConnectionImpl <em>Get Source Connection</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetSourceConnectionImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetSourceConnection()
		 * @generated
		 */
		EClass GET_SOURCE_CONNECTION = eINSTANCE.getGetSourceConnection();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetTargetConnectionImpl <em>Get Target Connection</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetTargetConnectionImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetTargetConnection()
		 * @generated
		 */
		EClass GET_TARGET_CONNECTION = eINSTANCE.getGetTargetConnection();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetPopupBarItemImpl <em>Get Popup Bar Item</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetPopupBarItemImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetPopupBarItem()
		 * @generated
		 */
		EClass GET_POPUP_BAR_ITEM = eINSTANCE.getGetPopupBarItem();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetConnectionHandleImpl <em>Get Connection Handle</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetConnectionHandleImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetConnectionHandle()
		 * @generated
		 */
		EClass GET_CONNECTION_HANDLE = eINSTANCE.getGetConnectionHandle();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetPaletteEntryImpl <em>Get Palette Entry</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetPaletteEntryImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetPaletteEntry()
		 * @generated
		 */
		EClass GET_PALETTE_ENTRY = eINSTANCE.getGetPaletteEntry();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetHandleImpl <em>Get Handle</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.GetHandleImpl
		 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.impl.DiagramPackageImpl#getGetHandle()
		 * @generated
		 */
		EClass GET_HANDLE = eINSTANCE.getGetHandle();

	}

} // DiagramPackage
