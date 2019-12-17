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
package org.eclipse.rcptt.core.scenario.impl;

import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.core.scenario.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScenarioFactoryImpl extends EFactoryImpl implements ScenarioFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ScenarioFactory init() {
		try {
			ScenarioFactory theScenarioFactory = (ScenarioFactory)EPackage.Registry.INSTANCE.getEFactory(ScenarioPackage.eNS_URI);
			if (theScenarioFactory != null) {
				return theScenarioFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ScenarioFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ScenarioPackage.NAMED_ELEMENT: return createNamedElement();
			case ScenarioPackage.SCENARIO: return createScenario();
			case ScenarioPackage.SCENARIO_PROPERTY: return createScenarioProperty();
			case ScenarioPackage.CONTEXT: return createContext();
			case ScenarioPackage.WORKBENCH_CONTEXT: return createWorkbenchContext();
			case ScenarioPackage.EDITOR: return createEditor();
			case ScenarioPackage.FILE_EDITOR: return createFileEditor();
			case ScenarioPackage.GROUP_CONTEXT: return createGroupContext();
			case ScenarioPackage.UNRESOLVED_CONTEXT: return createUnresolvedContext();
			case ScenarioPackage.ATTACHMENT: return createAttachment();
			case ScenarioPackage.TEST_SUITE_ITEM: return createTestSuiteItem();
			case ScenarioPackage.TEST_SUITE: return createTestSuite();
			case ScenarioPackage.PROJECT_METADATA: return createProjectMetadata();
			case ScenarioPackage.SUPER_CONTEXT: return createSuperContext();
			case ScenarioPackage.VERIFICATION: return createVerification();
			case ScenarioPackage.UNRESOLVED_VERIFICATION: return createUnresolvedVerification();
			case ScenarioPackage.WIDGET_VERIFICATION: return createWidgetVerification();
			case ScenarioPackage.CAPABILITY_CONTEXT: return createCapabilityContext();
			case ScenarioPackage.CAPABILITY_CONTEXT_ITEM: return createCapabilityContextItem();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement createNamedElement() {
		NamedElementImpl namedElement = new NamedElementImpl();
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario createScenario() {
		ScenarioImpl scenario = new ScenarioImpl();
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioProperty createScenarioProperty() {
		ScenarioPropertyImpl scenarioProperty = new ScenarioPropertyImpl();
		return scenarioProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context createContext() {
		ContextImpl context = new ContextImpl();
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkbenchContext createWorkbenchContext() {
		WorkbenchContextImpl workbenchContext = new WorkbenchContextImpl();
		return workbenchContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor createEditor() {
		EditorImpl editor = new EditorImpl();
		return editor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileEditor createFileEditor() {
		FileEditorImpl fileEditor = new FileEditorImpl();
		return fileEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupContext createGroupContext() {
		GroupContextImpl groupContext = new GroupContextImpl();
		return groupContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnresolvedContext createUnresolvedContext() {
		UnresolvedContextImpl unresolvedContext = new UnresolvedContextImpl();
		return unresolvedContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attachment createAttachment() {
		AttachmentImpl attachment = new AttachmentImpl();
		return attachment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSuiteItem createTestSuiteItem() {
		TestSuiteItemImpl testSuiteItem = new TestSuiteItemImpl();
		return testSuiteItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestSuite createTestSuite() {
		TestSuiteImpl testSuite = new TestSuiteImpl();
		return testSuite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectMetadata createProjectMetadata() {
		ProjectMetadataImpl projectMetadata = new ProjectMetadataImpl();
		return projectMetadata;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperContext createSuperContext() {
		SuperContextImpl superContext = new SuperContextImpl();
		return superContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Verification createVerification() {
		VerificationImpl verification = new VerificationImpl();
		return verification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnresolvedVerification createUnresolvedVerification() {
		UnresolvedVerificationImpl unresolvedVerification = new UnresolvedVerificationImpl();
		return unresolvedVerification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WidgetVerification createWidgetVerification() {
		WidgetVerificationImpl widgetVerification = new WidgetVerificationImpl();
		return widgetVerification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapabilityContext createCapabilityContext() {
		CapabilityContextImpl capabilityContext = new CapabilityContextImpl();
		return capabilityContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapabilityContextItem createCapabilityContextItem() {
		CapabilityContextItemImpl capabilityContextItem = new CapabilityContextItemImpl();
		return capabilityContextItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioPackage getScenarioPackage() {
		return (ScenarioPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ScenarioPackage getPackage() {
		return ScenarioPackage.eINSTANCE;
	}

} //ScenarioFactoryImpl
