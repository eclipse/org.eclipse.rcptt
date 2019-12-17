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
package org.eclipse.rcptt.ecl.platform.objects.impl;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.rcptt.ecl.platform.objects.Feature;
import org.eclipse.rcptt.ecl.platform.objects.InstallUnit;
import org.eclipse.rcptt.ecl.platform.objects.LaunchConfiguration;
import org.eclipse.rcptt.ecl.platform.objects.LogMessage;
import org.eclipse.rcptt.ecl.platform.objects.ObjectsFactory;
import org.eclipse.rcptt.ecl.platform.objects.ObjectsPackage;
import org.eclipse.rcptt.ecl.platform.objects.Plugin;
import org.eclipse.rcptt.ecl.platform.objects.PluginState;
import org.eclipse.rcptt.ecl.platform.objects.Repository;
import org.eclipse.rcptt.ecl.platform.objects.UpdateResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ObjectsPackageImpl extends EPackageImpl implements ObjectsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pluginEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass installUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass launchConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum pluginStateEEnum = null;

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
	 * @see org.eclipse.rcptt.ecl.platform.objects.ObjectsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ObjectsPackageImpl() {
		super(eNS_URI, ObjectsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ObjectsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ObjectsPackage init() {
		if (isInited) return (ObjectsPackage)EPackage.Registry.INSTANCE.getEPackage(ObjectsPackage.eNS_URI);

		// Obtain or create and register package
		ObjectsPackageImpl theObjectsPackage = (ObjectsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ObjectsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ObjectsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theObjectsPackage.createPackageContents();

		// Initialize created meta-data
		theObjectsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theObjectsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ObjectsPackage.eNS_URI, theObjectsPackage);
		return theObjectsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Id() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Version() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Name() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Provider() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlugin() {
		return pluginEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlugin_Id() {
		return (EAttribute)pluginEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlugin_Version() {
		return (EAttribute)pluginEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlugin_Name() {
		return (EAttribute)pluginEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlugin_State() {
		return (EAttribute)pluginEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlugin_RequiredBundles() {
		return (EAttribute)pluginEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlugin_ImportedPackages() {
		return (EAttribute)pluginEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepository() {
		return repositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepository_Name() {
		return (EAttribute)repositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepository_Location() {
		return (EAttribute)repositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepository_IsMetadata() {
		return (EAttribute)repositoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepository_IsArtifact() {
		return (EAttribute)repositoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstallUnit() {
		return installUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstallUnit_Id() {
		return (EAttribute)installUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstallUnit_Version() {
		return (EAttribute)installUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstallUnit_Name() {
		return (EAttribute)installUnitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateResult() {
		return updateResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUpdateResult_Id() {
		return (EAttribute)updateResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUpdateResult_From() {
		return (EAttribute)updateResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUpdateResult_To() {
		return (EAttribute)updateResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogMessage() {
		return logMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMessage_Severity() {
		return (EAttribute)logMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMessage_Message() {
		return (EAttribute)logMessageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMessage_DateText() {
		return (EAttribute)logMessageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMessage_PluginId() {
		return (EAttribute)logMessageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLaunchConfiguration() {
		return launchConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLaunchConfiguration_Name() {
		return (EAttribute)launchConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPluginState() {
		return pluginStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectsFactory getObjectsFactory() {
		return (ObjectsFactory)getEFactoryInstance();
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
		featureEClass = createEClass(FEATURE);
		createEAttribute(featureEClass, FEATURE__ID);
		createEAttribute(featureEClass, FEATURE__VERSION);
		createEAttribute(featureEClass, FEATURE__NAME);
		createEAttribute(featureEClass, FEATURE__PROVIDER);

		pluginEClass = createEClass(PLUGIN);
		createEAttribute(pluginEClass, PLUGIN__ID);
		createEAttribute(pluginEClass, PLUGIN__VERSION);
		createEAttribute(pluginEClass, PLUGIN__NAME);
		createEAttribute(pluginEClass, PLUGIN__STATE);
		createEAttribute(pluginEClass, PLUGIN__REQUIRED_BUNDLES);
		createEAttribute(pluginEClass, PLUGIN__IMPORTED_PACKAGES);

		repositoryEClass = createEClass(REPOSITORY);
		createEAttribute(repositoryEClass, REPOSITORY__NAME);
		createEAttribute(repositoryEClass, REPOSITORY__LOCATION);
		createEAttribute(repositoryEClass, REPOSITORY__IS_METADATA);
		createEAttribute(repositoryEClass, REPOSITORY__IS_ARTIFACT);

		installUnitEClass = createEClass(INSTALL_UNIT);
		createEAttribute(installUnitEClass, INSTALL_UNIT__ID);
		createEAttribute(installUnitEClass, INSTALL_UNIT__VERSION);
		createEAttribute(installUnitEClass, INSTALL_UNIT__NAME);

		updateResultEClass = createEClass(UPDATE_RESULT);
		createEAttribute(updateResultEClass, UPDATE_RESULT__ID);
		createEAttribute(updateResultEClass, UPDATE_RESULT__FROM);
		createEAttribute(updateResultEClass, UPDATE_RESULT__TO);

		logMessageEClass = createEClass(LOG_MESSAGE);
		createEAttribute(logMessageEClass, LOG_MESSAGE__SEVERITY);
		createEAttribute(logMessageEClass, LOG_MESSAGE__MESSAGE);
		createEAttribute(logMessageEClass, LOG_MESSAGE__DATE_TEXT);
		createEAttribute(logMessageEClass, LOG_MESSAGE__PLUGIN_ID);

		launchConfigurationEClass = createEClass(LAUNCH_CONFIGURATION);
		createEAttribute(launchConfigurationEClass, LAUNCH_CONFIGURATION__NAME);

		// Create enums
		pluginStateEEnum = createEEnum(PLUGIN_STATE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeature_Id(), ecorePackage.getEString(), "id", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Version(), ecorePackage.getEString(), "version", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Name(), ecorePackage.getEString(), "name", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeature_Provider(), ecorePackage.getEString(), "provider", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pluginEClass, Plugin.class, "Plugin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlugin_Id(), ecorePackage.getEString(), "id", null, 0, 1, Plugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlugin_Version(), ecorePackage.getEString(), "version", null, 0, 1, Plugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlugin_Name(), ecorePackage.getEString(), "name", null, 0, 1, Plugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlugin_State(), this.getPluginState(), "state", null, 0, 1, Plugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlugin_RequiredBundles(), ecorePackage.getEString(), "requiredBundles", "", 0, -1, Plugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlugin_ImportedPackages(), ecorePackage.getEString(), "importedPackages", "", 0, -1, Plugin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repositoryEClass, Repository.class, "Repository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRepository_Name(), ecorePackage.getEString(), "name", null, 0, 1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepository_Location(), ecorePackage.getEString(), "location", null, 0, 1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepository_IsMetadata(), ecorePackage.getEBoolean(), "isMetadata", null, 0, 1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepository_IsArtifact(), ecorePackage.getEBoolean(), "isArtifact", null, 0, 1, Repository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(installUnitEClass, InstallUnit.class, "InstallUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInstallUnit_Id(), ecorePackage.getEString(), "id", null, 0, 1, InstallUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstallUnit_Version(), ecorePackage.getEString(), "version", null, 0, 1, InstallUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstallUnit_Name(), ecorePackage.getEString(), "name", null, 0, 1, InstallUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updateResultEClass, UpdateResult.class, "UpdateResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUpdateResult_Id(), ecorePackage.getEString(), "id", null, 0, 1, UpdateResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUpdateResult_From(), ecorePackage.getEString(), "from", null, 0, 1, UpdateResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUpdateResult_To(), ecorePackage.getEString(), "to", null, 0, 1, UpdateResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(logMessageEClass, LogMessage.class, "LogMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLogMessage_Severity(), ecorePackage.getEString(), "severity", null, 0, 1, LogMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogMessage_Message(), ecorePackage.getEString(), "message", null, 0, 1, LogMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogMessage_DateText(), ecorePackage.getEString(), "dateText", null, 0, 1, LogMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogMessage_PluginId(), ecorePackage.getEString(), "pluginId", null, 0, 1, LogMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(launchConfigurationEClass, LaunchConfiguration.class, "LaunchConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLaunchConfiguration_Name(), ecorePackage.getEString(), "name", "", 0, 1, LaunchConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(pluginStateEEnum, PluginState.class, "PluginState");
		addEEnumLiteral(pluginStateEEnum, PluginState.UNINSTALLED);
		addEEnumLiteral(pluginStateEEnum, PluginState.INSTALLED);
		addEEnumLiteral(pluginStateEEnum, PluginState.RESOLVED);
		addEEnumLiteral(pluginStateEEnum, PluginState.STARTING);
		addEEnumLiteral(pluginStateEEnum, PluginState.STOPPING);
		addEEnumLiteral(pluginStateEEnum, PluginState.ACTIVE);

		// Create resource
		createResource(eNS_URI);
	}

} //ObjectsPackageImpl
