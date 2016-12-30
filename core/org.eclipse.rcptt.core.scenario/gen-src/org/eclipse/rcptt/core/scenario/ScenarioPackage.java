/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.scenario;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.core.scenario.ScenarioFactory
 * @model kind="package"
 * @generated
 */
public interface ScenarioPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scenario";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/model/scenario.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.scenario";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScenarioPackage eINSTANCE = org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.NamedElementImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__VERSION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__ID = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__TAGS = 4;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__ATTACHMENTS = 5;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.ScenarioImpl <em>Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getScenario()
	 * @generated
	 */
	int SCENARIO = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__VERSION = NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__TAGS = NAMED_ELEMENT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__ATTACHMENTS = NAMED_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__CONTEXTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__CONTENT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tesla Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__TESLA_CONTENT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Scenario References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__SCENARIO_REFERENCES = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Raw Supported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__RAW_SUPPORTED = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>External Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__EXTERNAL_REFERENCE = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Verifications</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__VERIFICATIONS = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__PROPERTIES = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.ScenarioPropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPropertyImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getScenarioProperty()
	 * @generated
	 */
	int SCENARIO_PROPERTY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_PROPERTY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.ContextImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__VERSION = NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__TAGS = NAMED_ELEMENT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__ATTACHMENTS = NAMED_ELEMENT__ATTACHMENTS;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.WorkbenchContextImpl <em>Workbench Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.WorkbenchContextImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getWorkbenchContext()
	 * @generated
	 */
	int WORKBENCH_CONTEXT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_CONTEXT__NAME = CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_CONTEXT__VERSION = CONTEXT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_CONTEXT__ID = CONTEXT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_CONTEXT__DESCRIPTION = CONTEXT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_CONTEXT__TAGS = CONTEXT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_CONTEXT__ATTACHMENTS = CONTEXT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Perspective Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_CONTEXT__PERSPECTIVE_ID = CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>No Modal Dialogs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_CONTEXT__NO_MODAL_DIALOGS = CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Close Editors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_CONTEXT__CLOSE_EDITORS = CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_CONTEXT__EDITORS = CONTEXT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Views</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_CONTEXT__VIEWS = CONTEXT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Reset Perspective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_CONTEXT__RESET_PERSPECTIVE = CONTEXT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Clear Clipboard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_CONTEXT__CLEAR_CLIPBOARD = CONTEXT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Workbench Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_CONTEXT_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.EditorImpl <em>Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.EditorImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getEditor()
	 * @generated
	 */
	int EDITOR = 5;

	/**
	 * The number of structural features of the '<em>Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.FileEditorImpl <em>File Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.FileEditorImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getFileEditor()
	 * @generated
	 */
	int FILE_EDITOR = 6;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_EDITOR__PATH = EDITOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_EDITOR_FEATURE_COUNT = EDITOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.GroupContextImpl <em>Group Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.GroupContextImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getGroupContext()
	 * @generated
	 */
	int GROUP_CONTEXT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CONTEXT__NAME = CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CONTEXT__VERSION = CONTEXT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CONTEXT__ID = CONTEXT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CONTEXT__DESCRIPTION = CONTEXT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CONTEXT__TAGS = CONTEXT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CONTEXT__ATTACHMENTS = CONTEXT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Context References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CONTEXT__CONTEXT_REFERENCES = CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CONTEXT__CONTEXTS = CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Group Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_CONTEXT_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.UnresolvedContextImpl <em>Unresolved Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.UnresolvedContextImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getUnresolvedContext()
	 * @generated
	 */
	int UNRESOLVED_CONTEXT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_CONTEXT__NAME = CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_CONTEXT__VERSION = CONTEXT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_CONTEXT__ID = CONTEXT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_CONTEXT__DESCRIPTION = CONTEXT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_CONTEXT__TAGS = CONTEXT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_CONTEXT__ATTACHMENTS = CONTEXT__ATTACHMENTS;

	/**
	 * The number of structural features of the '<em>Unresolved Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_CONTEXT_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.AttachmentImpl <em>Attachment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.AttachmentImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getAttachment()
	 * @generated
	 */
	int ATTACHMENT = 9;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT__DATA = 2;

	/**
	 * The number of structural features of the '<em>Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTACHMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.TestSuiteItemImpl <em>Test Suite Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.TestSuiteItemImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getTestSuiteItem()
	 * @generated
	 */
	int TEST_SUITE_ITEM = 10;

	/**
	 * The feature id for the '<em><b>Named Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_ITEM__NAMED_ELEMENT_ID = 0;

	/**
	 * The feature id for the '<em><b>Named Elemet Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_ITEM__NAMED_ELEMET_NAME = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_ITEM__KIND = 2;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_ITEM__PATH = 3;

	/**
	 * The number of structural features of the '<em>Test Suite Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_ITEM_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.TestSuiteImpl <em>Test Suite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.TestSuiteImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getTestSuite()
	 * @generated
	 */
	int TEST_SUITE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__VERSION = NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__TAGS = NAMED_ELEMENT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__ATTACHMENTS = NAMED_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__ITEMS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Manually Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__MANUALLY_ORDERED = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Test Suite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.ProjectMetadataImpl <em>Project Metadata</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.ProjectMetadataImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getProjectMetadata()
	 * @generated
	 */
	int PROJECT_METADATA = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_METADATA__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_METADATA__VERSION = NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_METADATA__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_METADATA__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_METADATA__TAGS = NAMED_ELEMENT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_METADATA__ATTACHMENTS = NAMED_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_METADATA__CONTEXTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ignores</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_METADATA__IGNORES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Verifications</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_METADATA__VERIFICATIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Project Metadata</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_METADATA_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.SuperContextImpl <em>Super Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.SuperContextImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getSuperContext()
	 * @generated
	 */
	int SUPER_CONTEXT = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CONTEXT__NAME = CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CONTEXT__VERSION = CONTEXT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CONTEXT__ID = CONTEXT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CONTEXT__DESCRIPTION = CONTEXT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CONTEXT__TAGS = CONTEXT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CONTEXT__ATTACHMENTS = CONTEXT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Context References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CONTEXT__CONTEXT_REFERENCES = CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Child Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CONTEXT__CHILD_TYPE = CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Super Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_CONTEXT_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.VerificationImpl <em>Verification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.VerificationImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getVerification()
	 * @generated
	 */
	int VERIFICATION = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION__VERSION = NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION__TAGS = NAMED_ELEMENT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION__ATTACHMENTS = NAMED_ELEMENT__ATTACHMENTS;

	/**
	 * The number of structural features of the '<em>Verification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.UnresolvedVerificationImpl <em>Unresolved Verification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.UnresolvedVerificationImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getUnresolvedVerification()
	 * @generated
	 */
	int UNRESOLVED_VERIFICATION = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_VERIFICATION__NAME = VERIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_VERIFICATION__VERSION = VERIFICATION__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_VERIFICATION__ID = VERIFICATION__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_VERIFICATION__DESCRIPTION = VERIFICATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_VERIFICATION__TAGS = VERIFICATION__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_VERIFICATION__ATTACHMENTS = VERIFICATION__ATTACHMENTS;

	/**
	 * The number of structural features of the '<em>Unresolved Verification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNRESOLVED_VERIFICATION_FEATURE_COUNT = VERIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.WidgetVerificationImpl <em>Widget Verification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.WidgetVerificationImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getWidgetVerification()
	 * @generated
	 */
	int WIDGET_VERIFICATION = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_VERIFICATION__NAME = VERIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_VERIFICATION__VERSION = VERIFICATION__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_VERIFICATION__ID = VERIFICATION__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_VERIFICATION__DESCRIPTION = VERIFICATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_VERIFICATION__TAGS = VERIFICATION__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_VERIFICATION__ATTACHMENTS = VERIFICATION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_VERIFICATION__SELECTOR = VERIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Widget Verification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_VERIFICATION_FEATURE_COUNT = VERIFICATION_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.CapabilityContextImpl <em>Capability Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.CapabilityContextImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getCapabilityContext()
	 * @generated
	 */
	int CAPABILITY_CONTEXT = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_CONTEXT__NAME = CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_CONTEXT__VERSION = CONTEXT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_CONTEXT__ID = CONTEXT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_CONTEXT__DESCRIPTION = CONTEXT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_CONTEXT__TAGS = CONTEXT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_CONTEXT__ATTACHMENTS = CONTEXT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_CONTEXT__ITEMS = CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Capability Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_CONTEXT_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.scenario.impl.CapabilityContextItemImpl <em>Capability Context Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.scenario.impl.CapabilityContextItemImpl
	 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getCapabilityContextItem()
	 * @generated
	 */
	int CAPABILITY_CONTEXT_ITEM = 18;

	/**
	 * The feature id for the '<em><b>Capability</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_CONTEXT_ITEM__CAPABILITY = 0;

	/**
	 * The feature id for the '<em><b>Context References</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_CONTEXT_ITEM__CONTEXT_REFERENCES = 1;

	/**
	 * The number of structural features of the '<em>Capability Context Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPABILITY_CONTEXT_ITEM_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipse.rcptt.core.scenario.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.core.scenario.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.NamedElement#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.rcptt.core.scenario.NamedElement#getVersion()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.NamedElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.core.scenario.NamedElement#getId()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.NamedElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.rcptt.core.scenario.NamedElement#getDescription()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.NamedElement#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tags</em>'.
	 * @see org.eclipse.rcptt.core.scenario.NamedElement#getTags()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Tags();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.core.scenario.NamedElement#getAttachments <em>Attachments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attachments</em>'.
	 * @see org.eclipse.rcptt.core.scenario.NamedElement#getAttachments()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Attachments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.Scenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Scenario
	 * @generated
	 */
	EClass getScenario();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.core.scenario.Scenario#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Contexts</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Scenario#getContexts()
	 * @see #getScenario()
	 * @generated
	 */
	EAttribute getScenario_Contexts();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.core.scenario.Scenario#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Content</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Scenario#getContent()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Content();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.core.scenario.Scenario#getTeslaContent <em>Tesla Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tesla Content</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Scenario#getTeslaContent()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_TeslaContent();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.core.scenario.Scenario#getScenarioReferences <em>Scenario References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Scenario References</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Scenario#getScenarioReferences()
	 * @see #getScenario()
	 * @generated
	 */
	EAttribute getScenario_ScenarioReferences();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.Scenario#isRawSupported <em>Raw Supported</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Raw Supported</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Scenario#isRawSupported()
	 * @see #getScenario()
	 * @generated
	 */
	EAttribute getScenario_RawSupported();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.Scenario#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Scenario#getType()
	 * @see #getScenario()
	 * @generated
	 */
	EAttribute getScenario_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.Scenario#getExternalReference <em>External Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External Reference</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Scenario#getExternalReference()
	 * @see #getScenario()
	 * @generated
	 */
	EAttribute getScenario_ExternalReference();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.core.scenario.Scenario#getVerifications <em>Verifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Verifications</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Scenario#getVerifications()
	 * @see #getScenario()
	 * @generated
	 */
	EAttribute getScenario_Verifications();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.core.scenario.Scenario#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Scenario#getProperties()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_Properties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.ScenarioProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioProperty
	 * @generated
	 */
	EClass getScenarioProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.ScenarioProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioProperty#getName()
	 * @see #getScenarioProperty()
	 * @generated
	 */
	EAttribute getScenarioProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.ScenarioProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.core.scenario.ScenarioProperty#getValue()
	 * @see #getScenarioProperty()
	 * @generated
	 */
	EAttribute getScenarioProperty_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Context
	 * @generated
	 */
	EClass getContext();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.WorkbenchContext <em>Workbench Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workbench Context</em>'.
	 * @see org.eclipse.rcptt.core.scenario.WorkbenchContext
	 * @generated
	 */
	EClass getWorkbenchContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#getPerspectiveId <em>Perspective Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Perspective Id</em>'.
	 * @see org.eclipse.rcptt.core.scenario.WorkbenchContext#getPerspectiveId()
	 * @see #getWorkbenchContext()
	 * @generated
	 */
	EAttribute getWorkbenchContext_PerspectiveId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#isNoModalDialogs <em>No Modal Dialogs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>No Modal Dialogs</em>'.
	 * @see org.eclipse.rcptt.core.scenario.WorkbenchContext#isNoModalDialogs()
	 * @see #getWorkbenchContext()
	 * @generated
	 */
	EAttribute getWorkbenchContext_NoModalDialogs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#isCloseEditors <em>Close Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Close Editors</em>'.
	 * @see org.eclipse.rcptt.core.scenario.WorkbenchContext#isCloseEditors()
	 * @see #getWorkbenchContext()
	 * @generated
	 */
	EAttribute getWorkbenchContext_CloseEditors();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Editors</em>'.
	 * @see org.eclipse.rcptt.core.scenario.WorkbenchContext#getEditors()
	 * @see #getWorkbenchContext()
	 * @generated
	 */
	EReference getWorkbenchContext_Editors();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Views</em>'.
	 * @see org.eclipse.rcptt.core.scenario.WorkbenchContext#getViews()
	 * @see #getWorkbenchContext()
	 * @generated
	 */
	EAttribute getWorkbenchContext_Views();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#isResetPerspective <em>Reset Perspective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reset Perspective</em>'.
	 * @see org.eclipse.rcptt.core.scenario.WorkbenchContext#isResetPerspective()
	 * @see #getWorkbenchContext()
	 * @generated
	 */
	EAttribute getWorkbenchContext_ResetPerspective();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.WorkbenchContext#isClearClipboard <em>Clear Clipboard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clear Clipboard</em>'.
	 * @see org.eclipse.rcptt.core.scenario.WorkbenchContext#isClearClipboard()
	 * @see #getWorkbenchContext()
	 * @generated
	 */
	EAttribute getWorkbenchContext_ClearClipboard();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.Editor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Editor
	 * @generated
	 */
	EClass getEditor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.FileEditor <em>File Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Editor</em>'.
	 * @see org.eclipse.rcptt.core.scenario.FileEditor
	 * @generated
	 */
	EClass getFileEditor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.FileEditor#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.core.scenario.FileEditor#getPath()
	 * @see #getFileEditor()
	 * @generated
	 */
	EAttribute getFileEditor_Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.GroupContext <em>Group Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group Context</em>'.
	 * @see org.eclipse.rcptt.core.scenario.GroupContext
	 * @generated
	 */
	EClass getGroupContext();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.core.scenario.GroupContext#getContextReferences <em>Context References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Context References</em>'.
	 * @see org.eclipse.rcptt.core.scenario.GroupContext#getContextReferences()
	 * @see #getGroupContext()
	 * @generated
	 */
	EAttribute getGroupContext_ContextReferences();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.core.scenario.GroupContext#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contexts</em>'.
	 * @see org.eclipse.rcptt.core.scenario.GroupContext#getContexts()
	 * @see #getGroupContext()
	 * @generated
	 */
	EReference getGroupContext_Contexts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.UnresolvedContext <em>Unresolved Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unresolved Context</em>'.
	 * @see org.eclipse.rcptt.core.scenario.UnresolvedContext
	 * @generated
	 */
	EClass getUnresolvedContext();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.Attachment <em>Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attachment</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Attachment
	 * @generated
	 */
	EClass getAttachment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.Attachment#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Attachment#getType()
	 * @see #getAttachment()
	 * @generated
	 */
	EAttribute getAttachment_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.Attachment#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Attachment#getName()
	 * @see #getAttachment()
	 * @generated
	 */
	EAttribute getAttachment_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.core.scenario.Attachment#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Attachment#getData()
	 * @see #getAttachment()
	 * @generated
	 */
	EReference getAttachment_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.TestSuiteItem <em>Test Suite Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Suite Item</em>'.
	 * @see org.eclipse.rcptt.core.scenario.TestSuiteItem
	 * @generated
	 */
	EClass getTestSuiteItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.TestSuiteItem#getNamedElementId <em>Named Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Named Element Id</em>'.
	 * @see org.eclipse.rcptt.core.scenario.TestSuiteItem#getNamedElementId()
	 * @see #getTestSuiteItem()
	 * @generated
	 */
	EAttribute getTestSuiteItem_NamedElementId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.TestSuiteItem#getNamedElemetName <em>Named Elemet Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Named Elemet Name</em>'.
	 * @see org.eclipse.rcptt.core.scenario.TestSuiteItem#getNamedElemetName()
	 * @see #getTestSuiteItem()
	 * @generated
	 */
	EAttribute getTestSuiteItem_NamedElemetName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.TestSuiteItem#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.core.scenario.TestSuiteItem#getKind()
	 * @see #getTestSuiteItem()
	 * @generated
	 */
	EAttribute getTestSuiteItem_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.TestSuiteItem#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.core.scenario.TestSuiteItem#getPath()
	 * @see #getTestSuiteItem()
	 * @generated
	 */
	EAttribute getTestSuiteItem_Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.TestSuite <em>Test Suite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Suite</em>'.
	 * @see org.eclipse.rcptt.core.scenario.TestSuite
	 * @generated
	 */
	EClass getTestSuite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.core.scenario.TestSuite#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.eclipse.rcptt.core.scenario.TestSuite#getItems()
	 * @see #getTestSuite()
	 * @generated
	 */
	EReference getTestSuite_Items();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.TestSuite#isManuallyOrdered <em>Manually Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manually Ordered</em>'.
	 * @see org.eclipse.rcptt.core.scenario.TestSuite#isManuallyOrdered()
	 * @see #getTestSuite()
	 * @generated
	 */
	EAttribute getTestSuite_ManuallyOrdered();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.ProjectMetadata <em>Project Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Metadata</em>'.
	 * @see org.eclipse.rcptt.core.scenario.ProjectMetadata
	 * @generated
	 */
	EClass getProjectMetadata();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.core.scenario.ProjectMetadata#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Contexts</em>'.
	 * @see org.eclipse.rcptt.core.scenario.ProjectMetadata#getContexts()
	 * @see #getProjectMetadata()
	 * @generated
	 */
	EAttribute getProjectMetadata_Contexts();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.core.scenario.ProjectMetadata#getIgnores <em>Ignores</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Ignores</em>'.
	 * @see org.eclipse.rcptt.core.scenario.ProjectMetadata#getIgnores()
	 * @see #getProjectMetadata()
	 * @generated
	 */
	EAttribute getProjectMetadata_Ignores();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.core.scenario.ProjectMetadata#getVerifications <em>Verifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Verifications</em>'.
	 * @see org.eclipse.rcptt.core.scenario.ProjectMetadata#getVerifications()
	 * @see #getProjectMetadata()
	 * @generated
	 */
	EAttribute getProjectMetadata_Verifications();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.SuperContext <em>Super Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Super Context</em>'.
	 * @see org.eclipse.rcptt.core.scenario.SuperContext
	 * @generated
	 */
	EClass getSuperContext();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.core.scenario.SuperContext#getContextReferences <em>Context References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Context References</em>'.
	 * @see org.eclipse.rcptt.core.scenario.SuperContext#getContextReferences()
	 * @see #getSuperContext()
	 * @generated
	 */
	EAttribute getSuperContext_ContextReferences();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.SuperContext#getChildType <em>Child Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Child Type</em>'.
	 * @see org.eclipse.rcptt.core.scenario.SuperContext#getChildType()
	 * @see #getSuperContext()
	 * @generated
	 */
	EAttribute getSuperContext_ChildType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.Verification <em>Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verification</em>'.
	 * @see org.eclipse.rcptt.core.scenario.Verification
	 * @generated
	 */
	EClass getVerification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.UnresolvedVerification <em>Unresolved Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unresolved Verification</em>'.
	 * @see org.eclipse.rcptt.core.scenario.UnresolvedVerification
	 * @generated
	 */
	EClass getUnresolvedVerification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.WidgetVerification <em>Widget Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget Verification</em>'.
	 * @see org.eclipse.rcptt.core.scenario.WidgetVerification
	 * @generated
	 */
	EClass getWidgetVerification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.core.scenario.WidgetVerification#getSelector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selector</em>'.
	 * @see org.eclipse.rcptt.core.scenario.WidgetVerification#getSelector()
	 * @see #getWidgetVerification()
	 * @generated
	 */
	EAttribute getWidgetVerification_Selector();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.CapabilityContext <em>Capability Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capability Context</em>'.
	 * @see org.eclipse.rcptt.core.scenario.CapabilityContext
	 * @generated
	 */
	EClass getCapabilityContext();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.core.scenario.CapabilityContext#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.eclipse.rcptt.core.scenario.CapabilityContext#getItems()
	 * @see #getCapabilityContext()
	 * @generated
	 */
	EReference getCapabilityContext_Items();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.core.scenario.CapabilityContextItem <em>Capability Context Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capability Context Item</em>'.
	 * @see org.eclipse.rcptt.core.scenario.CapabilityContextItem
	 * @generated
	 */
	EClass getCapabilityContextItem();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.core.scenario.CapabilityContextItem#getCapability <em>Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Capability</em>'.
	 * @see org.eclipse.rcptt.core.scenario.CapabilityContextItem#getCapability()
	 * @see #getCapabilityContextItem()
	 * @generated
	 */
	EAttribute getCapabilityContextItem_Capability();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.core.scenario.CapabilityContextItem#getContextReferences <em>Context References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Context References</em>'.
	 * @see org.eclipse.rcptt.core.scenario.CapabilityContextItem#getContextReferences()
	 * @see #getCapabilityContextItem()
	 * @generated
	 */
	EAttribute getCapabilityContextItem_ContextReferences();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScenarioFactory getScenarioFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.NamedElementImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__VERSION = eINSTANCE.getNamedElement_Version();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__ID = eINSTANCE.getNamedElement_Id();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__DESCRIPTION = eINSTANCE.getNamedElement_Description();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__TAGS = eINSTANCE.getNamedElement_Tags();

		/**
		 * The meta object literal for the '<em><b>Attachments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_ELEMENT__ATTACHMENTS = eINSTANCE.getNamedElement_Attachments();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.ScenarioImpl <em>Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getScenario()
		 * @generated
		 */
		EClass SCENARIO = eINSTANCE.getScenario();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENARIO__CONTEXTS = eINSTANCE.getScenario_Contexts();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__CONTENT = eINSTANCE.getScenario_Content();

		/**
		 * The meta object literal for the '<em><b>Tesla Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__TESLA_CONTENT = eINSTANCE.getScenario_TeslaContent();

		/**
		 * The meta object literal for the '<em><b>Scenario References</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENARIO__SCENARIO_REFERENCES = eINSTANCE.getScenario_ScenarioReferences();

		/**
		 * The meta object literal for the '<em><b>Raw Supported</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENARIO__RAW_SUPPORTED = eINSTANCE.getScenario_RawSupported();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENARIO__TYPE = eINSTANCE.getScenario_Type();

		/**
		 * The meta object literal for the '<em><b>External Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENARIO__EXTERNAL_REFERENCE = eINSTANCE.getScenario_ExternalReference();

		/**
		 * The meta object literal for the '<em><b>Verifications</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENARIO__VERIFICATIONS = eINSTANCE.getScenario_Verifications();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__PROPERTIES = eINSTANCE.getScenario_Properties();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.ScenarioPropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPropertyImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getScenarioProperty()
		 * @generated
		 */
		EClass SCENARIO_PROPERTY = eINSTANCE.getScenarioProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENARIO_PROPERTY__NAME = eINSTANCE.getScenarioProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENARIO_PROPERTY__VALUE = eINSTANCE.getScenarioProperty_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.ContextImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getContext()
		 * @generated
		 */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.WorkbenchContextImpl <em>Workbench Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.WorkbenchContextImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getWorkbenchContext()
		 * @generated
		 */
		EClass WORKBENCH_CONTEXT = eINSTANCE.getWorkbenchContext();

		/**
		 * The meta object literal for the '<em><b>Perspective Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKBENCH_CONTEXT__PERSPECTIVE_ID = eINSTANCE.getWorkbenchContext_PerspectiveId();

		/**
		 * The meta object literal for the '<em><b>No Modal Dialogs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKBENCH_CONTEXT__NO_MODAL_DIALOGS = eINSTANCE.getWorkbenchContext_NoModalDialogs();

		/**
		 * The meta object literal for the '<em><b>Close Editors</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKBENCH_CONTEXT__CLOSE_EDITORS = eINSTANCE.getWorkbenchContext_CloseEditors();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKBENCH_CONTEXT__EDITORS = eINSTANCE.getWorkbenchContext_Editors();

		/**
		 * The meta object literal for the '<em><b>Views</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKBENCH_CONTEXT__VIEWS = eINSTANCE.getWorkbenchContext_Views();

		/**
		 * The meta object literal for the '<em><b>Reset Perspective</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKBENCH_CONTEXT__RESET_PERSPECTIVE = eINSTANCE.getWorkbenchContext_ResetPerspective();

		/**
		 * The meta object literal for the '<em><b>Clear Clipboard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORKBENCH_CONTEXT__CLEAR_CLIPBOARD = eINSTANCE.getWorkbenchContext_ClearClipboard();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.EditorImpl <em>Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.EditorImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getEditor()
		 * @generated
		 */
		EClass EDITOR = eINSTANCE.getEditor();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.FileEditorImpl <em>File Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.FileEditorImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getFileEditor()
		 * @generated
		 */
		EClass FILE_EDITOR = eINSTANCE.getFileEditor();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_EDITOR__PATH = eINSTANCE.getFileEditor_Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.GroupContextImpl <em>Group Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.GroupContextImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getGroupContext()
		 * @generated
		 */
		EClass GROUP_CONTEXT = eINSTANCE.getGroupContext();

		/**
		 * The meta object literal for the '<em><b>Context References</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP_CONTEXT__CONTEXT_REFERENCES = eINSTANCE.getGroupContext_ContextReferences();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP_CONTEXT__CONTEXTS = eINSTANCE.getGroupContext_Contexts();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.UnresolvedContextImpl <em>Unresolved Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.UnresolvedContextImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getUnresolvedContext()
		 * @generated
		 */
		EClass UNRESOLVED_CONTEXT = eINSTANCE.getUnresolvedContext();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.AttachmentImpl <em>Attachment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.AttachmentImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getAttachment()
		 * @generated
		 */
		EClass ATTACHMENT = eINSTANCE.getAttachment();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT__TYPE = eINSTANCE.getAttachment_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTACHMENT__NAME = eINSTANCE.getAttachment_Name();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTACHMENT__DATA = eINSTANCE.getAttachment_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.TestSuiteItemImpl <em>Test Suite Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.TestSuiteItemImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getTestSuiteItem()
		 * @generated
		 */
		EClass TEST_SUITE_ITEM = eINSTANCE.getTestSuiteItem();

		/**
		 * The meta object literal for the '<em><b>Named Element Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SUITE_ITEM__NAMED_ELEMENT_ID = eINSTANCE.getTestSuiteItem_NamedElementId();

		/**
		 * The meta object literal for the '<em><b>Named Elemet Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SUITE_ITEM__NAMED_ELEMET_NAME = eINSTANCE.getTestSuiteItem_NamedElemetName();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SUITE_ITEM__KIND = eINSTANCE.getTestSuiteItem_Kind();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SUITE_ITEM__PATH = eINSTANCE.getTestSuiteItem_Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.TestSuiteImpl <em>Test Suite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.TestSuiteImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getTestSuite()
		 * @generated
		 */
		EClass TEST_SUITE = eINSTANCE.getTestSuite();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SUITE__ITEMS = eINSTANCE.getTestSuite_Items();

		/**
		 * The meta object literal for the '<em><b>Manually Ordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SUITE__MANUALLY_ORDERED = eINSTANCE.getTestSuite_ManuallyOrdered();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.ProjectMetadataImpl <em>Project Metadata</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.ProjectMetadataImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getProjectMetadata()
		 * @generated
		 */
		EClass PROJECT_METADATA = eINSTANCE.getProjectMetadata();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_METADATA__CONTEXTS = eINSTANCE.getProjectMetadata_Contexts();

		/**
		 * The meta object literal for the '<em><b>Ignores</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_METADATA__IGNORES = eINSTANCE.getProjectMetadata_Ignores();

		/**
		 * The meta object literal for the '<em><b>Verifications</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_METADATA__VERIFICATIONS = eINSTANCE.getProjectMetadata_Verifications();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.SuperContextImpl <em>Super Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.SuperContextImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getSuperContext()
		 * @generated
		 */
		EClass SUPER_CONTEXT = eINSTANCE.getSuperContext();

		/**
		 * The meta object literal for the '<em><b>Context References</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPER_CONTEXT__CONTEXT_REFERENCES = eINSTANCE.getSuperContext_ContextReferences();

		/**
		 * The meta object literal for the '<em><b>Child Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPER_CONTEXT__CHILD_TYPE = eINSTANCE.getSuperContext_ChildType();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.VerificationImpl <em>Verification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.VerificationImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getVerification()
		 * @generated
		 */
		EClass VERIFICATION = eINSTANCE.getVerification();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.UnresolvedVerificationImpl <em>Unresolved Verification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.UnresolvedVerificationImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getUnresolvedVerification()
		 * @generated
		 */
		EClass UNRESOLVED_VERIFICATION = eINSTANCE.getUnresolvedVerification();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.WidgetVerificationImpl <em>Widget Verification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.WidgetVerificationImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getWidgetVerification()
		 * @generated
		 */
		EClass WIDGET_VERIFICATION = eINSTANCE.getWidgetVerification();

		/**
		 * The meta object literal for the '<em><b>Selector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET_VERIFICATION__SELECTOR = eINSTANCE.getWidgetVerification_Selector();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.CapabilityContextImpl <em>Capability Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.CapabilityContextImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getCapabilityContext()
		 * @generated
		 */
		EClass CAPABILITY_CONTEXT = eINSTANCE.getCapabilityContext();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPABILITY_CONTEXT__ITEMS = eINSTANCE.getCapabilityContext_Items();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.scenario.impl.CapabilityContextItemImpl <em>Capability Context Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.core.scenario.impl.CapabilityContextItemImpl
		 * @see org.eclipse.rcptt.core.scenario.impl.ScenarioPackageImpl#getCapabilityContextItem()
		 * @generated
		 */
		EClass CAPABILITY_CONTEXT_ITEM = eINSTANCE.getCapabilityContextItem();

		/**
		 * The meta object literal for the '<em><b>Capability</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAPABILITY_CONTEXT_ITEM__CAPABILITY = eINSTANCE.getCapabilityContextItem_Capability();

		/**
		 * The meta object literal for the '<em><b>Context References</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAPABILITY_CONTEXT_ITEM__CONTEXT_REFERENCES = eINSTANCE.getCapabilityContextItem_ContextReferences();

	}

} //ScenarioPackage
