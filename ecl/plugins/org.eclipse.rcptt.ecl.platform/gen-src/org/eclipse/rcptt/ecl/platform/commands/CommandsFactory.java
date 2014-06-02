/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.platform.commands;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.ecl.platform.commands.CommandsPackage
 * @generated
 */
public interface CommandsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommandsFactory eINSTANCE = org.eclipse.rcptt.ecl.platform.commands.impl.CommandsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>List Plugins</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Plugins</em>'.
	 * @generated
	 */
	ListPlugins createListPlugins();

	/**
	 * Returns a new object of class '<em>List Features</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Features</em>'.
	 * @generated
	 */
	ListFeatures createListFeatures();

	/**
	 * Returns a new object of class '<em>List Repositories</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Repositories</em>'.
	 * @generated
	 */
	ListRepositories createListRepositories();

	/**
	 * Returns a new object of class '<em>Add Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Repository</em>'.
	 * @generated
	 */
	AddRepository createAddRepository();

	/**
	 * Returns a new object of class '<em>Remove Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Repository</em>'.
	 * @generated
	 */
	RemoveRepository createRemoveRepository();

	/**
	 * Returns a new object of class '<em>Update Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Feature</em>'.
	 * @generated
	 */
	UpdateFeature createUpdateFeature();

	/**
	 * Returns a new object of class '<em>Update All</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update All</em>'.
	 * @generated
	 */
	UpdateAll createUpdateAll();

	/**
	 * Returns a new object of class '<em>Sort By</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sort By</em>'.
	 * @generated
	 */
	SortBy createSortBy();

	/**
	 * Returns a new object of class '<em>List Install Units</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Install Units</em>'.
	 * @generated
	 */
	ListInstallUnits createListInstallUnits();

	/**
	 * Returns a new object of class '<em>Get Log</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Log</em>'.
	 * @generated
	 */
	GetLog createGetLog();

	/**
	 * Returns a new object of class '<em>Log</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Log</em>'.
	 * @generated
	 */
	Log createLog();

	/**
	 * Returns a new object of class '<em>Echo</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Echo</em>'.
	 * @generated
	 */
	Echo createEcho();

	/**
	 * Returns a new object of class '<em>Clear Log</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clear Log</em>'.
	 * @generated
	 */
	ClearLog createClearLog();

	/**
	 * Returns a new object of class '<em>List Launch Configurations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Launch Configurations</em>'.
	 * @generated
	 */
	ListLaunchConfigurations createListLaunchConfigurations();

	/**
	 * Returns a new object of class '<em>Launch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Launch</em>'.
	 * @generated
	 */
	Launch createLaunch();

	/**
	 * Returns a new object of class '<em>Substitute Variables</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Substitute Variables</em>'.
	 * @generated
	 */
	SubstituteVariables createSubstituteVariables();

	/**
	 * Returns a new object of class '<em>Get Workspace Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Workspace Location</em>'.
	 * @generated
	 */
	GetWorkspaceLocation createGetWorkspaceLocation();

	/**
	 * Returns a new object of class '<em>Find In Workspace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Find In Workspace</em>'.
	 * @generated
	 */
	FindInWorkspace createFindInWorkspace();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CommandsPackage getCommandsPackage();

} //CommandsFactory
