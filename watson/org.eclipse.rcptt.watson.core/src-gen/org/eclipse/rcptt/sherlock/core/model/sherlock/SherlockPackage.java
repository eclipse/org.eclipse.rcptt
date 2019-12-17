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
package org.eclipse.rcptt.sherlock.core.model.sherlock;

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
 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockFactory
 * @model kind="package"
 * @generated
 */
public interface SherlockPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sherlock";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/sherlock/core";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sh";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SherlockPackage eINSTANCE = org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SystemInfoImpl <em>System Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SystemInfoImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getSystemInfo()
	 * @generated
	 */
	int SYSTEM_INFO = 0;

	/**
	 * The feature id for the '<em><b>Os Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INFO__OS_NAME = 0;

	/**
	 * The feature id for the '<em><b>Os Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INFO__OS_VERSION = 1;

	/**
	 * The feature id for the '<em><b>Os Arch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INFO__OS_ARCH = 2;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INFO__USERNAME = 3;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INFO__VARIABLES = 4;

	/**
	 * The number of structural features of the '<em>System Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_INFO_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SystemVariableImpl <em>System Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SystemVariableImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getSystemVariable()
	 * @generated
	 */
	int SYSTEM_VARIABLE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_VARIABLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_VARIABLE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>System Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_VARIABLE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaInfoImpl <em>Java Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaInfoImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getJavaInfo()
	 * @generated
	 */
	int JAVA_INFO = 2;

	/**
	 * The feature id for the '<em><b>Runtime Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__RUNTIME_NAME = 0;

	/**
	 * The feature id for the '<em><b>Runtime Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__RUNTIME_VERSION = 1;

	/**
	 * The feature id for the '<em><b>Max Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__MAX_MEMORY = 2;

	/**
	 * The feature id for the '<em><b>Free Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__FREE_MEMORY = 3;

	/**
	 * The feature id for the '<em><b>Total Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__TOTAL_MEMORY = 4;

	/**
	 * The feature id for the '<em><b>Args</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__ARGS = 5;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__PROPERTIES = 6;

	/**
	 * The number of structural features of the '<em>Java Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaPropertyImpl <em>Java Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaPropertyImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getJavaProperty()
	 * @generated
	 */
	int JAVA_PROPERTY = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Java Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl <em>Eclipse Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getEclipseInfo()
	 * @generated
	 */
	int ECLIPSE_INFO = 4;

	/**
	 * The feature id for the '<em><b>Workspace Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_INFO__WORKSPACE_LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_INFO__PRODUCT_ID = 1;

	/**
	 * The feature id for the '<em><b>Application Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_INFO__APPLICATION_ID = 2;

	/**
	 * The feature id for the '<em><b>Application Args</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_INFO__APPLICATION_ARGS = 3;

	/**
	 * The feature id for the '<em><b>Build Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_INFO__BUILD_ID = 4;

	/**
	 * The feature id for the '<em><b>Uptime</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_INFO__UPTIME = 5;

	/**
	 * The feature id for the '<em><b>Plugins</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_INFO__PLUGINS = 6;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_INFO__FEATURES = 7;

	/**
	 * The feature id for the '<em><b>Workspace Partition Total Diskspace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_INFO__WORKSPACE_PARTITION_TOTAL_DISKSPACE = 8;

	/**
	 * The feature id for the '<em><b>Workspace Partition Usable Diskspace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_INFO__WORKSPACE_PARTITION_USABLE_DISKSPACE = 9;

	/**
	 * The feature id for the '<em><b>Workspace Partition Free Diskspace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_INFO__WORKSPACE_PARTITION_FREE_DISKSPACE = 10;

	/**
	 * The feature id for the '<em><b>Preferences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_INFO__PREFERENCES = 11;

	/**
	 * The number of structural features of the '<em>Eclipse Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_INFO_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipsePluginImpl <em>Eclipse Plugin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipsePluginImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getEclipsePlugin()
	 * @generated
	 */
	int ECLIPSE_PLUGIN = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_PLUGIN__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_PLUGIN__NAME = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_PLUGIN__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_PLUGIN__PROVIDER = 3;

	/**
	 * The number of structural features of the '<em>Eclipse Plugin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_PLUGIN_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseFeatureImpl <em>Eclipse Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseFeatureImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getEclipseFeature()
	 * @generated
	 */
	int ECLIPSE_FEATURE = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_FEATURE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_FEATURE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_FEATURE__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_FEATURE__PROVIDER = 3;

	/**
	 * The number of structural features of the '<em>Eclipse Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_FEATURE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipsePreferenceImpl <em>Eclipse Preference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipsePreferenceImpl
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getEclipsePreference()
	 * @generated
	 */
	int ECLIPSE_PREFERENCE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_PREFERENCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_PREFERENCE__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_PREFERENCE__PATH = 2;

	/**
	 * The number of structural features of the '<em>Eclipse Preference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLIPSE_PREFERENCE_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.SystemInfo <em>System Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Info</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SystemInfo
	 * @generated
	 */
	EClass getSystemInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.SystemInfo#getOsName <em>Os Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Os Name</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SystemInfo#getOsName()
	 * @see #getSystemInfo()
	 * @generated
	 */
	EAttribute getSystemInfo_OsName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.SystemInfo#getOsVersion <em>Os Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Os Version</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SystemInfo#getOsVersion()
	 * @see #getSystemInfo()
	 * @generated
	 */
	EAttribute getSystemInfo_OsVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.SystemInfo#getOsArch <em>Os Arch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Os Arch</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SystemInfo#getOsArch()
	 * @see #getSystemInfo()
	 * @generated
	 */
	EAttribute getSystemInfo_OsArch();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.SystemInfo#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SystemInfo#getUsername()
	 * @see #getSystemInfo()
	 * @generated
	 */
	EAttribute getSystemInfo_Username();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.SystemInfo#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SystemInfo#getVariables()
	 * @see #getSystemInfo()
	 * @generated
	 */
	EReference getSystemInfo_Variables();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.SystemVariable <em>System Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Variable</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SystemVariable
	 * @generated
	 */
	EClass getSystemVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.SystemVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SystemVariable#getName()
	 * @see #getSystemVariable()
	 * @generated
	 */
	EAttribute getSystemVariable_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.SystemVariable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.SystemVariable#getValue()
	 * @see #getSystemVariable()
	 * @generated
	 */
	EAttribute getSystemVariable_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo <em>Java Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Info</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo
	 * @generated
	 */
	EClass getJavaInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getRuntimeName <em>Runtime Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runtime Name</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getRuntimeName()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_RuntimeName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getRuntimeVersion <em>Runtime Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Runtime Version</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getRuntimeVersion()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_RuntimeVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getMaxMemory <em>Max Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Memory</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getMaxMemory()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_MaxMemory();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getFreeMemory <em>Free Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Free Memory</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getFreeMemory()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_FreeMemory();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getTotalMemory <em>Total Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Memory</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getTotalMemory()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_TotalMemory();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getArgs <em>Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Args</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getArgs()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_Args();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.JavaInfo#getProperties()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EReference getJavaInfo_Properties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaProperty <em>Java Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Property</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.JavaProperty
	 * @generated
	 */
	EClass getJavaProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.JavaProperty#getName()
	 * @see #getJavaProperty()
	 * @generated
	 */
	EAttribute getJavaProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.JavaProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.JavaProperty#getValue()
	 * @see #getJavaProperty()
	 * @generated
	 */
	EAttribute getJavaProperty_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo <em>Eclipse Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eclipse Info</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo
	 * @generated
	 */
	EClass getEclipseInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspaceLocation <em>Workspace Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workspace Location</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspaceLocation()
	 * @see #getEclipseInfo()
	 * @generated
	 */
	EAttribute getEclipseInfo_WorkspaceLocation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getProductId <em>Product Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product Id</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getProductId()
	 * @see #getEclipseInfo()
	 * @generated
	 */
	EAttribute getEclipseInfo_ProductId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getApplicationId <em>Application Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Application Id</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getApplicationId()
	 * @see #getEclipseInfo()
	 * @generated
	 */
	EAttribute getEclipseInfo_ApplicationId();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getApplicationArgs <em>Application Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Application Args</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getApplicationArgs()
	 * @see #getEclipseInfo()
	 * @generated
	 */
	EAttribute getEclipseInfo_ApplicationArgs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getBuildId <em>Build Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Build Id</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getBuildId()
	 * @see #getEclipseInfo()
	 * @generated
	 */
	EAttribute getEclipseInfo_BuildId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getUptime <em>Uptime</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uptime</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getUptime()
	 * @see #getEclipseInfo()
	 * @generated
	 */
	EAttribute getEclipseInfo_Uptime();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getPlugins <em>Plugins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Plugins</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getPlugins()
	 * @see #getEclipseInfo()
	 * @generated
	 */
	EReference getEclipseInfo_Plugins();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getFeatures()
	 * @see #getEclipseInfo()
	 * @generated
	 */
	EReference getEclipseInfo_Features();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspacePartitionTotalDiskspace <em>Workspace Partition Total Diskspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workspace Partition Total Diskspace</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspacePartitionTotalDiskspace()
	 * @see #getEclipseInfo()
	 * @generated
	 */
	EAttribute getEclipseInfo_WorkspacePartitionTotalDiskspace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspacePartitionUsableDiskspace <em>Workspace Partition Usable Diskspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workspace Partition Usable Diskspace</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspacePartitionUsableDiskspace()
	 * @see #getEclipseInfo()
	 * @generated
	 */
	EAttribute getEclipseInfo_WorkspacePartitionUsableDiskspace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspacePartitionFreeDiskspace <em>Workspace Partition Free Diskspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workspace Partition Free Diskspace</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getWorkspacePartitionFreeDiskspace()
	 * @see #getEclipseInfo()
	 * @generated
	 */
	EAttribute getEclipseInfo_WorkspacePartitionFreeDiskspace();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getPreferences <em>Preferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Preferences</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseInfo#getPreferences()
	 * @see #getEclipseInfo()
	 * @generated
	 */
	EReference getEclipseInfo_Preferences();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePlugin <em>Eclipse Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eclipse Plugin</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePlugin
	 * @generated
	 */
	EClass getEclipsePlugin();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePlugin#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePlugin#getId()
	 * @see #getEclipsePlugin()
	 * @generated
	 */
	EAttribute getEclipsePlugin_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePlugin#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePlugin#getName()
	 * @see #getEclipsePlugin()
	 * @generated
	 */
	EAttribute getEclipsePlugin_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePlugin#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePlugin#getVersion()
	 * @see #getEclipsePlugin()
	 * @generated
	 */
	EAttribute getEclipsePlugin_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePlugin#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePlugin#getProvider()
	 * @see #getEclipsePlugin()
	 * @generated
	 */
	EAttribute getEclipsePlugin_Provider();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseFeature <em>Eclipse Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eclipse Feature</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseFeature
	 * @generated
	 */
	EClass getEclipseFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseFeature#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseFeature#getId()
	 * @see #getEclipseFeature()
	 * @generated
	 */
	EAttribute getEclipseFeature_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseFeature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseFeature#getName()
	 * @see #getEclipseFeature()
	 * @generated
	 */
	EAttribute getEclipseFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseFeature#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseFeature#getVersion()
	 * @see #getEclipseFeature()
	 * @generated
	 */
	EAttribute getEclipseFeature_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseFeature#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseFeature#getProvider()
	 * @see #getEclipseFeature()
	 * @generated
	 */
	EAttribute getEclipseFeature_Provider();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePreference <em>Eclipse Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eclipse Preference</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePreference
	 * @generated
	 */
	EClass getEclipsePreference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePreference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePreference#getName()
	 * @see #getEclipsePreference()
	 * @generated
	 */
	EAttribute getEclipsePreference_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePreference#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePreference#getValue()
	 * @see #getEclipsePreference()
	 * @generated
	 */
	EAttribute getEclipsePreference_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePreference#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.EclipsePreference#getPath()
	 * @see #getEclipsePreference()
	 * @generated
	 */
	EAttribute getEclipsePreference_Path();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SherlockFactory getSherlockFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SystemInfoImpl <em>System Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SystemInfoImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getSystemInfo()
		 * @generated
		 */
		EClass SYSTEM_INFO = eINSTANCE.getSystemInfo();

		/**
		 * The meta object literal for the '<em><b>Os Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_INFO__OS_NAME = eINSTANCE.getSystemInfo_OsName();

		/**
		 * The meta object literal for the '<em><b>Os Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_INFO__OS_VERSION = eINSTANCE.getSystemInfo_OsVersion();

		/**
		 * The meta object literal for the '<em><b>Os Arch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_INFO__OS_ARCH = eINSTANCE.getSystemInfo_OsArch();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_INFO__USERNAME = eINSTANCE.getSystemInfo_Username();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_INFO__VARIABLES = eINSTANCE.getSystemInfo_Variables();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SystemVariableImpl <em>System Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SystemVariableImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getSystemVariable()
		 * @generated
		 */
		EClass SYSTEM_VARIABLE = eINSTANCE.getSystemVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_VARIABLE__NAME = eINSTANCE.getSystemVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_VARIABLE__VALUE = eINSTANCE.getSystemVariable_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaInfoImpl <em>Java Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaInfoImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getJavaInfo()
		 * @generated
		 */
		EClass JAVA_INFO = eINSTANCE.getJavaInfo();

		/**
		 * The meta object literal for the '<em><b>Runtime Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__RUNTIME_NAME = eINSTANCE.getJavaInfo_RuntimeName();

		/**
		 * The meta object literal for the '<em><b>Runtime Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__RUNTIME_VERSION = eINSTANCE.getJavaInfo_RuntimeVersion();

		/**
		 * The meta object literal for the '<em><b>Max Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__MAX_MEMORY = eINSTANCE.getJavaInfo_MaxMemory();

		/**
		 * The meta object literal for the '<em><b>Free Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__FREE_MEMORY = eINSTANCE.getJavaInfo_FreeMemory();

		/**
		 * The meta object literal for the '<em><b>Total Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__TOTAL_MEMORY = eINSTANCE.getJavaInfo_TotalMemory();

		/**
		 * The meta object literal for the '<em><b>Args</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__ARGS = eINSTANCE.getJavaInfo_Args();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_INFO__PROPERTIES = eINSTANCE.getJavaInfo_Properties();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaPropertyImpl <em>Java Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.JavaPropertyImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getJavaProperty()
		 * @generated
		 */
		EClass JAVA_PROPERTY = eINSTANCE.getJavaProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_PROPERTY__NAME = eINSTANCE.getJavaProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_PROPERTY__VALUE = eINSTANCE.getJavaProperty_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl <em>Eclipse Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseInfoImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getEclipseInfo()
		 * @generated
		 */
		EClass ECLIPSE_INFO = eINSTANCE.getEclipseInfo();

		/**
		 * The meta object literal for the '<em><b>Workspace Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_INFO__WORKSPACE_LOCATION = eINSTANCE.getEclipseInfo_WorkspaceLocation();

		/**
		 * The meta object literal for the '<em><b>Product Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_INFO__PRODUCT_ID = eINSTANCE.getEclipseInfo_ProductId();

		/**
		 * The meta object literal for the '<em><b>Application Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_INFO__APPLICATION_ID = eINSTANCE.getEclipseInfo_ApplicationId();

		/**
		 * The meta object literal for the '<em><b>Application Args</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_INFO__APPLICATION_ARGS = eINSTANCE.getEclipseInfo_ApplicationArgs();

		/**
		 * The meta object literal for the '<em><b>Build Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_INFO__BUILD_ID = eINSTANCE.getEclipseInfo_BuildId();

		/**
		 * The meta object literal for the '<em><b>Uptime</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_INFO__UPTIME = eINSTANCE.getEclipseInfo_Uptime();

		/**
		 * The meta object literal for the '<em><b>Plugins</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLIPSE_INFO__PLUGINS = eINSTANCE.getEclipseInfo_Plugins();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLIPSE_INFO__FEATURES = eINSTANCE.getEclipseInfo_Features();

		/**
		 * The meta object literal for the '<em><b>Workspace Partition Total Diskspace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_INFO__WORKSPACE_PARTITION_TOTAL_DISKSPACE = eINSTANCE.getEclipseInfo_WorkspacePartitionTotalDiskspace();

		/**
		 * The meta object literal for the '<em><b>Workspace Partition Usable Diskspace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_INFO__WORKSPACE_PARTITION_USABLE_DISKSPACE = eINSTANCE.getEclipseInfo_WorkspacePartitionUsableDiskspace();

		/**
		 * The meta object literal for the '<em><b>Workspace Partition Free Diskspace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_INFO__WORKSPACE_PARTITION_FREE_DISKSPACE = eINSTANCE.getEclipseInfo_WorkspacePartitionFreeDiskspace();

		/**
		 * The meta object literal for the '<em><b>Preferences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECLIPSE_INFO__PREFERENCES = eINSTANCE.getEclipseInfo_Preferences();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipsePluginImpl <em>Eclipse Plugin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipsePluginImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getEclipsePlugin()
		 * @generated
		 */
		EClass ECLIPSE_PLUGIN = eINSTANCE.getEclipsePlugin();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_PLUGIN__ID = eINSTANCE.getEclipsePlugin_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_PLUGIN__NAME = eINSTANCE.getEclipsePlugin_Name();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_PLUGIN__VERSION = eINSTANCE.getEclipsePlugin_Version();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_PLUGIN__PROVIDER = eINSTANCE.getEclipsePlugin_Provider();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseFeatureImpl <em>Eclipse Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipseFeatureImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getEclipseFeature()
		 * @generated
		 */
		EClass ECLIPSE_FEATURE = eINSTANCE.getEclipseFeature();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_FEATURE__ID = eINSTANCE.getEclipseFeature_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_FEATURE__NAME = eINSTANCE.getEclipseFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_FEATURE__VERSION = eINSTANCE.getEclipseFeature_Version();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_FEATURE__PROVIDER = eINSTANCE.getEclipseFeature_Provider();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipsePreferenceImpl <em>Eclipse Preference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.EclipsePreferenceImpl
		 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.impl.SherlockPackageImpl#getEclipsePreference()
		 * @generated
		 */
		EClass ECLIPSE_PREFERENCE = eINSTANCE.getEclipsePreference();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_PREFERENCE__NAME = eINSTANCE.getEclipsePreference_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_PREFERENCE__VALUE = eINSTANCE.getEclipsePreference_Value();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECLIPSE_PREFERENCE__PATH = eINSTANCE.getEclipsePreference_Path();

	}

} //SherlockPackage
