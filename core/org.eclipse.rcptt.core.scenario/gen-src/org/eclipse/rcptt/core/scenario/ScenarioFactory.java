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
package org.eclipse.rcptt.core.scenario;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.core.scenario.ScenarioPackage
 * @generated
 */
public interface ScenarioFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScenarioFactory eINSTANCE = org.eclipse.rcptt.core.scenario.impl.ScenarioFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Element</em>'.
	 * @generated
	 */
	NamedElement createNamedElement();

	/**
	 * Returns a new object of class '<em>Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scenario</em>'.
	 * @generated
	 */
	Scenario createScenario();

	/**
	 * Returns a new object of class '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property</em>'.
	 * @generated
	 */
	ScenarioProperty createScenarioProperty();

	/**
	 * Returns a new object of class '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Context</em>'.
	 * @generated
	 */
	Context createContext();

	/**
	 * Returns a new object of class '<em>Workbench Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Workbench Context</em>'.
	 * @generated
	 */
	WorkbenchContext createWorkbenchContext();

	/**
	 * Returns a new object of class '<em>Editor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Editor</em>'.
	 * @generated
	 */
	Editor createEditor();

	/**
	 * Returns a new object of class '<em>File Editor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Editor</em>'.
	 * @generated
	 */
	FileEditor createFileEditor();

	/**
	 * Returns a new object of class '<em>Group Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Group Context</em>'.
	 * @generated
	 */
	GroupContext createGroupContext();

	/**
	 * Returns a new object of class '<em>Unresolved Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unresolved Context</em>'.
	 * @generated
	 */
	UnresolvedContext createUnresolvedContext();

	/**
	 * Returns a new object of class '<em>Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attachment</em>'.
	 * @generated
	 */
	Attachment createAttachment();

	/**
	 * Returns a new object of class '<em>Test Suite Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Suite Item</em>'.
	 * @generated
	 */
	TestSuiteItem createTestSuiteItem();

	/**
	 * Returns a new object of class '<em>Test Suite</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Suite</em>'.
	 * @generated
	 */
	TestSuite createTestSuite();

	/**
	 * Returns a new object of class '<em>Project Metadata</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Metadata</em>'.
	 * @generated
	 */
	ProjectMetadata createProjectMetadata();

	/**
	 * Returns a new object of class '<em>Super Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Super Context</em>'.
	 * @generated
	 */
	SuperContext createSuperContext();

	/**
	 * Returns a new object of class '<em>Verification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Verification</em>'.
	 * @generated
	 */
	Verification createVerification();

	/**
	 * Returns a new object of class '<em>Unresolved Verification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unresolved Verification</em>'.
	 * @generated
	 */
	UnresolvedVerification createUnresolvedVerification();

	/**
	 * Returns a new object of class '<em>Widget Verification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Widget Verification</em>'.
	 * @generated
	 */
	WidgetVerification createWidgetVerification();

	/**
	 * Returns a new object of class '<em>Capability Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Capability Context</em>'.
	 * @generated
	 */
	CapabilityContext createCapabilityContext();

	/**
	 * Returns a new object of class '<em>Capability Context Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Capability Context Item</em>'.
	 * @generated
	 */
	CapabilityContextItem createCapabilityContextItem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ScenarioPackage getScenarioPackage();

} //ScenarioFactory
