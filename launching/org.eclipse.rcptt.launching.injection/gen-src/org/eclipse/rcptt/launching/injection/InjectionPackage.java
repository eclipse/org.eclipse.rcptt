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
package org.eclipse.rcptt.launching.injection;

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
 * @see org.eclipse.rcptt.launching.injection.InjectionFactory
 * @model kind="package"
 * @generated
 */
public interface InjectionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "injection";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/launching/injection";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.launching.injection";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InjectionPackage eINSTANCE = org.eclipse.rcptt.launching.injection.impl.InjectionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.launching.injection.impl.InjectionConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.launching.injection.impl.InjectionConfigurationImpl
	 * @see org.eclipse.rcptt.launching.injection.impl.InjectionPackageImpl#getInjectionConfiguration()
	 * @generated
	 */
	int INJECTION_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTION_CONFIGURATION__ENTRIES = 0;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INJECTION_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.launching.injection.impl.EntryImpl <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.launching.injection.impl.EntryImpl
	 * @see org.eclipse.rcptt.launching.injection.impl.InjectionPackageImpl#getEntry()
	 * @generated
	 */
	int ENTRY = 2;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.launching.injection.impl.UpdateSiteImpl <em>Update Site</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.launching.injection.impl.UpdateSiteImpl
	 * @see org.eclipse.rcptt.launching.injection.impl.InjectionPackageImpl#getUpdateSite()
	 * @generated
	 */
	int UPDATE_SITE = 1;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SITE__URI = ENTRY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Units</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SITE__UNITS = ENTRY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>All Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SITE__ALL_UNITS = ENTRY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Update Site</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_SITE_FEATURE_COUNT = ENTRY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.launching.injection.impl.DirectoryImpl <em>Directory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.launching.injection.impl.DirectoryImpl
	 * @see org.eclipse.rcptt.launching.injection.impl.InjectionPackageImpl#getDirectory()
	 * @generated
	 */
	int DIRECTORY = 3;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__PATH = ENTRY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Directory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_FEATURE_COUNT = ENTRY_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.launching.injection.InjectionConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.eclipse.rcptt.launching.injection.InjectionConfiguration
	 * @generated
	 */
	EClass getInjectionConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.launching.injection.InjectionConfiguration#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see org.eclipse.rcptt.launching.injection.InjectionConfiguration#getEntries()
	 * @see #getInjectionConfiguration()
	 * @generated
	 */
	EReference getInjectionConfiguration_Entries();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.launching.injection.UpdateSite <em>Update Site</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update Site</em>'.
	 * @see org.eclipse.rcptt.launching.injection.UpdateSite
	 * @generated
	 */
	EClass getUpdateSite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.launching.injection.UpdateSite#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.launching.injection.UpdateSite#getUri()
	 * @see #getUpdateSite()
	 * @generated
	 */
	EAttribute getUpdateSite_Uri();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.launching.injection.UpdateSite#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Units</em>'.
	 * @see org.eclipse.rcptt.launching.injection.UpdateSite#getUnits()
	 * @see #getUpdateSite()
	 * @generated
	 */
	EAttribute getUpdateSite_Units();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.launching.injection.UpdateSite#isAllUnits <em>All Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>All Units</em>'.
	 * @see org.eclipse.rcptt.launching.injection.UpdateSite#isAllUnits()
	 * @see #getUpdateSite()
	 * @generated
	 */
	EAttribute getUpdateSite_AllUnits();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.launching.injection.Entry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see org.eclipse.rcptt.launching.injection.Entry
	 * @generated
	 */
	EClass getEntry();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.launching.injection.Directory <em>Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directory</em>'.
	 * @see org.eclipse.rcptt.launching.injection.Directory
	 * @generated
	 */
	EClass getDirectory();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.launching.injection.Directory#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.launching.injection.Directory#getPath()
	 * @see #getDirectory()
	 * @generated
	 */
	EAttribute getDirectory_Path();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InjectionFactory getInjectionFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.launching.injection.impl.InjectionConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.launching.injection.impl.InjectionConfigurationImpl
		 * @see org.eclipse.rcptt.launching.injection.impl.InjectionPackageImpl#getInjectionConfiguration()
		 * @generated
		 */
		EClass INJECTION_CONFIGURATION = eINSTANCE.getInjectionConfiguration();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INJECTION_CONFIGURATION__ENTRIES = eINSTANCE.getInjectionConfiguration_Entries();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.launching.injection.impl.UpdateSiteImpl <em>Update Site</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.launching.injection.impl.UpdateSiteImpl
		 * @see org.eclipse.rcptt.launching.injection.impl.InjectionPackageImpl#getUpdateSite()
		 * @generated
		 */
		EClass UPDATE_SITE = eINSTANCE.getUpdateSite();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPDATE_SITE__URI = eINSTANCE.getUpdateSite_Uri();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPDATE_SITE__UNITS = eINSTANCE.getUpdateSite_Units();

		/**
		 * The meta object literal for the '<em><b>All Units</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPDATE_SITE__ALL_UNITS = eINSTANCE.getUpdateSite_AllUnits();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.launching.injection.impl.EntryImpl <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.launching.injection.impl.EntryImpl
		 * @see org.eclipse.rcptt.launching.injection.impl.InjectionPackageImpl#getEntry()
		 * @generated
		 */
		EClass ENTRY = eINSTANCE.getEntry();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.launching.injection.impl.DirectoryImpl <em>Directory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.launching.injection.impl.DirectoryImpl
		 * @see org.eclipse.rcptt.launching.injection.impl.InjectionPackageImpl#getDirectory()
		 * @generated
		 */
		EClass DIRECTORY = eINSTANCE.getDirectory();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY__PATH = eINSTANCE.getDirectory_Path();

	}

} //InjectionPackage
