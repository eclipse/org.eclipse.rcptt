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
package org.eclipse.rcptt.ecl.platform.objects;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.eclipse.rcptt.ecl.platform.objects.ObjectsFactory
 * @model kind="package"
 * @generated
 */
public interface ObjectsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "objects";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ecl/platform/objects.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "platformObjects";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ObjectsPackage eINSTANCE = org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.objects.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.objects.impl.FeatureImpl
	 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ID = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__VERSION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = 2;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__PROVIDER = 3;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.objects.impl.PluginImpl <em>Plugin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.objects.impl.PluginImpl
	 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getPlugin()
	 * @generated
	 */
	int PLUGIN = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__ID = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__VERSION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__NAME = 2;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__STATE = 3;

	/**
	 * The feature id for the '<em><b>Required Bundles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__REQUIRED_BUNDLES = 4;

	/**
	 * The feature id for the '<em><b>Imported Packages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__IMPORTED_PACKAGES = 5;

	/**
	 * The number of structural features of the '<em>Plugin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.objects.impl.RepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.objects.impl.RepositoryImpl
	 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getRepository()
	 * @generated
	 */
	int REPOSITORY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__LOCATION = 1;

	/**
	 * The feature id for the '<em><b>Is Metadata</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__IS_METADATA = 2;

	/**
	 * The feature id for the '<em><b>Is Artifact</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__IS_ARTIFACT = 3;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.objects.impl.InstallUnitImpl <em>Install Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.objects.impl.InstallUnitImpl
	 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getInstallUnit()
	 * @generated
	 */
	int INSTALL_UNIT = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALL_UNIT__ID = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALL_UNIT__VERSION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALL_UNIT__NAME = 2;

	/**
	 * The number of structural features of the '<em>Install Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALL_UNIT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.objects.impl.UpdateResultImpl <em>Update Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.objects.impl.UpdateResultImpl
	 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getUpdateResult()
	 * @generated
	 */
	int UPDATE_RESULT = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_RESULT__ID = 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_RESULT__FROM = 1;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_RESULT__TO = 2;

	/**
	 * The number of structural features of the '<em>Update Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_RESULT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.objects.impl.LogMessageImpl <em>Log Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.objects.impl.LogMessageImpl
	 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getLogMessage()
	 * @generated
	 */
	int LOG_MESSAGE = 5;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE__SEVERITY = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Date Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE__DATE_TEXT = 2;

	/**
	 * The feature id for the '<em><b>Plugin Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE__PLUGIN_ID = 3;

	/**
	 * The number of structural features of the '<em>Log Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.objects.impl.LaunchConfigurationImpl <em>Launch Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.objects.impl.LaunchConfigurationImpl
	 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getLaunchConfiguration()
	 * @generated
	 */
	int LAUNCH_CONFIGURATION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_CONFIGURATION__NAME = 0;

	/**
	 * The number of structural features of the '<em>Launch Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAUNCH_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.platform.objects.PluginState <em>Plugin State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.platform.objects.PluginState
	 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getPluginState()
	 * @generated
	 */
	int PLUGIN_STATE = 7;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.objects.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.Feature#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Feature#getId()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.Feature#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Feature#getVersion()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.Feature#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Feature#getProvider()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Provider();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.objects.Plugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugin</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Plugin
	 * @generated
	 */
	EClass getPlugin();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.Plugin#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Plugin#getId()
	 * @see #getPlugin()
	 * @generated
	 */
	EAttribute getPlugin_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.Plugin#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Plugin#getVersion()
	 * @see #getPlugin()
	 * @generated
	 */
	EAttribute getPlugin_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.Plugin#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Plugin#getName()
	 * @see #getPlugin()
	 * @generated
	 */
	EAttribute getPlugin_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.Plugin#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Plugin#getState()
	 * @see #getPlugin()
	 * @generated
	 */
	EAttribute getPlugin_State();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.ecl.platform.objects.Plugin#getRequiredBundles <em>Required Bundles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Required Bundles</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Plugin#getRequiredBundles()
	 * @see #getPlugin()
	 * @generated
	 */
	EAttribute getPlugin_RequiredBundles();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.ecl.platform.objects.Plugin#getImportedPackages <em>Imported Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Imported Packages</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Plugin#getImportedPackages()
	 * @see #getPlugin()
	 * @generated
	 */
	EAttribute getPlugin_ImportedPackages();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.objects.Repository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Repository
	 * @generated
	 */
	EClass getRepository();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.Repository#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Repository#getName()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.Repository#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Repository#getLocation()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.Repository#isIsMetadata <em>Is Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Metadata</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Repository#isIsMetadata()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_IsMetadata();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.Repository#isIsArtifact <em>Is Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Artifact</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.Repository#isIsArtifact()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_IsArtifact();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.objects.InstallUnit <em>Install Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Install Unit</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.InstallUnit
	 * @generated
	 */
	EClass getInstallUnit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.InstallUnit#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.InstallUnit#getId()
	 * @see #getInstallUnit()
	 * @generated
	 */
	EAttribute getInstallUnit_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.InstallUnit#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.InstallUnit#getVersion()
	 * @see #getInstallUnit()
	 * @generated
	 */
	EAttribute getInstallUnit_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.InstallUnit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.InstallUnit#getName()
	 * @see #getInstallUnit()
	 * @generated
	 */
	EAttribute getInstallUnit_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.objects.UpdateResult <em>Update Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Result</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.UpdateResult
	 * @generated
	 */
	EClass getUpdateResult();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.UpdateResult#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.UpdateResult#getId()
	 * @see #getUpdateResult()
	 * @generated
	 */
	EAttribute getUpdateResult_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.UpdateResult#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.UpdateResult#getFrom()
	 * @see #getUpdateResult()
	 * @generated
	 */
	EAttribute getUpdateResult_From();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.UpdateResult#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.UpdateResult#getTo()
	 * @see #getUpdateResult()
	 * @generated
	 */
	EAttribute getUpdateResult_To();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.objects.LogMessage <em>Log Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log Message</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.LogMessage
	 * @generated
	 */
	EClass getLogMessage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.LogMessage#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.LogMessage#getSeverity()
	 * @see #getLogMessage()
	 * @generated
	 */
	EAttribute getLogMessage_Severity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.LogMessage#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.LogMessage#getMessage()
	 * @see #getLogMessage()
	 * @generated
	 */
	EAttribute getLogMessage_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.LogMessage#getDateText <em>Date Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Text</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.LogMessage#getDateText()
	 * @see #getLogMessage()
	 * @generated
	 */
	EAttribute getLogMessage_DateText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.LogMessage#getPluginId <em>Plugin Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin Id</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.LogMessage#getPluginId()
	 * @see #getLogMessage()
	 * @generated
	 */
	EAttribute getLogMessage_PluginId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.platform.objects.LaunchConfiguration <em>Launch Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Launch Configuration</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.LaunchConfiguration
	 * @generated
	 */
	EClass getLaunchConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.platform.objects.LaunchConfiguration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.LaunchConfiguration#getName()
	 * @see #getLaunchConfiguration()
	 * @generated
	 */
	EAttribute getLaunchConfiguration_Name();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.ecl.platform.objects.PluginState <em>Plugin State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Plugin State</em>'.
	 * @see org.eclipse.rcptt.ecl.platform.objects.PluginState
	 * @generated
	 */
	EEnum getPluginState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ObjectsFactory getObjectsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.objects.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.objects.impl.FeatureImpl
		 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__ID = eINSTANCE.getFeature_Id();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__VERSION = eINSTANCE.getFeature_Version();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__PROVIDER = eINSTANCE.getFeature_Provider();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.objects.impl.PluginImpl <em>Plugin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.objects.impl.PluginImpl
		 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getPlugin()
		 * @generated
		 */
		EClass PLUGIN = eINSTANCE.getPlugin();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN__ID = eINSTANCE.getPlugin_Id();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN__VERSION = eINSTANCE.getPlugin_Version();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN__NAME = eINSTANCE.getPlugin_Name();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN__STATE = eINSTANCE.getPlugin_State();

		/**
		 * The meta object literal for the '<em><b>Required Bundles</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN__REQUIRED_BUNDLES = eINSTANCE.getPlugin_RequiredBundles();

		/**
		 * The meta object literal for the '<em><b>Imported Packages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN__IMPORTED_PACKAGES = eINSTANCE.getPlugin_ImportedPackages();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.objects.impl.RepositoryImpl <em>Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.objects.impl.RepositoryImpl
		 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getRepository()
		 * @generated
		 */
		EClass REPOSITORY = eINSTANCE.getRepository();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__NAME = eINSTANCE.getRepository_Name();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__LOCATION = eINSTANCE.getRepository_Location();

		/**
		 * The meta object literal for the '<em><b>Is Metadata</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__IS_METADATA = eINSTANCE.getRepository_IsMetadata();

		/**
		 * The meta object literal for the '<em><b>Is Artifact</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__IS_ARTIFACT = eINSTANCE.getRepository_IsArtifact();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.objects.impl.InstallUnitImpl <em>Install Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.objects.impl.InstallUnitImpl
		 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getInstallUnit()
		 * @generated
		 */
		EClass INSTALL_UNIT = eINSTANCE.getInstallUnit();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTALL_UNIT__ID = eINSTANCE.getInstallUnit_Id();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTALL_UNIT__VERSION = eINSTANCE.getInstallUnit_Version();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTALL_UNIT__NAME = eINSTANCE.getInstallUnit_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.objects.impl.UpdateResultImpl <em>Update Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.objects.impl.UpdateResultImpl
		 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getUpdateResult()
		 * @generated
		 */
		EClass UPDATE_RESULT = eINSTANCE.getUpdateResult();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPDATE_RESULT__ID = eINSTANCE.getUpdateResult_Id();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPDATE_RESULT__FROM = eINSTANCE.getUpdateResult_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPDATE_RESULT__TO = eINSTANCE.getUpdateResult_To();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.objects.impl.LogMessageImpl <em>Log Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.objects.impl.LogMessageImpl
		 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getLogMessage()
		 * @generated
		 */
		EClass LOG_MESSAGE = eINSTANCE.getLogMessage();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MESSAGE__SEVERITY = eINSTANCE.getLogMessage_Severity();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MESSAGE__MESSAGE = eINSTANCE.getLogMessage_Message();

		/**
		 * The meta object literal for the '<em><b>Date Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MESSAGE__DATE_TEXT = eINSTANCE.getLogMessage_DateText();

		/**
		 * The meta object literal for the '<em><b>Plugin Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MESSAGE__PLUGIN_ID = eINSTANCE.getLogMessage_PluginId();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.objects.impl.LaunchConfigurationImpl <em>Launch Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.objects.impl.LaunchConfigurationImpl
		 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getLaunchConfiguration()
		 * @generated
		 */
		EClass LAUNCH_CONFIGURATION = eINSTANCE.getLaunchConfiguration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAUNCH_CONFIGURATION__NAME = eINSTANCE.getLaunchConfiguration_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.platform.objects.PluginState <em>Plugin State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.platform.objects.PluginState
		 * @see org.eclipse.rcptt.ecl.platform.objects.impl.ObjectsPackageImpl#getPluginState()
		 * @generated
		 */
		EEnum PLUGIN_STATE = eINSTANCE.getPluginState();

	}

} //ObjectsPackage
