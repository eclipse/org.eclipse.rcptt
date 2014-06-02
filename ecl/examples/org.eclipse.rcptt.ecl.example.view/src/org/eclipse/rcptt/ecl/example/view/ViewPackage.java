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
package org.eclipse.rcptt.ecl.example.view;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.rcptt.ecl.core.CorePackage;

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
 * @see org.eclipse.rcptt.ecl.example.view.ViewFactory
 * @model kind="package"
 * @generated
 */
public interface ViewPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "view";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/ecl/examples/view.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.ecl.example.view";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ViewPackage eINSTANCE = org.eclipse.rcptt.ecl.example.view.impl.ViewPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.example.view.impl.ShowViewsImpl <em>Show Views</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.example.view.impl.ShowViewsImpl
	 * @see org.eclipse.rcptt.ecl.example.view.impl.ViewPackageImpl#getShowViews()
	 * @generated
	 */
	int SHOW_VIEWS = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_VIEWS__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_VIEWS__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Show Views</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_VIEWS_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.example.view.impl.ViewImpl <em>View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.example.view.impl.ViewImpl
	 * @see org.eclipse.rcptt.ecl.example.view.impl.ViewPackageImpl#getView()
	 * @generated
	 */
	int VIEW = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__ID = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__LABEL = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_FEATURE_COUNT = 3;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.example.view.impl.ShowViewImpl <em>Show View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.example.view.impl.ShowViewImpl
	 * @see org.eclipse.rcptt.ecl.example.view.impl.ViewPackageImpl#getShowView()
	 * @generated
	 */
	int SHOW_VIEW = 2;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_VIEW__HOST = CorePackage.COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_VIEW__BINDINGS = CorePackage.COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_VIEW__ID = CorePackage.COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Show View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_VIEW_FEATURE_COUNT = CorePackage.COMMAND_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.example.view.ShowViews <em>Show Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Show Views</em>'.
	 * @see org.eclipse.rcptt.ecl.example.view.ShowViews
	 * @generated
	 */
	EClass getShowViews();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.example.view.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View</em>'.
	 * @see org.eclipse.rcptt.ecl.example.view.View
	 * @generated
	 */
	EClass getView();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.example.view.View#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.ecl.example.view.View#getId()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.example.view.View#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.rcptt.ecl.example.view.View#getLabel()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.example.view.View#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.rcptt.ecl.example.view.View#getDescription()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_Description();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.example.view.ShowView <em>Show View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Show View</em>'.
	 * @see org.eclipse.rcptt.ecl.example.view.ShowView
	 * @generated
	 */
	EClass getShowView();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.example.view.ShowView#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.rcptt.ecl.example.view.ShowView#getId()
	 * @see #getShowView()
	 * @generated
	 */
	EAttribute getShowView_Id();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ViewFactory getViewFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.example.view.impl.ShowViewsImpl <em>Show Views</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.example.view.impl.ShowViewsImpl
		 * @see org.eclipse.rcptt.ecl.example.view.impl.ViewPackageImpl#getShowViews()
		 * @generated
		 */
		EClass SHOW_VIEWS = eINSTANCE.getShowViews();
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.example.view.impl.ViewImpl <em>View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.example.view.impl.ViewImpl
		 * @see org.eclipse.rcptt.ecl.example.view.impl.ViewPackageImpl#getView()
		 * @generated
		 */
		EClass VIEW = eINSTANCE.getView();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__ID = eINSTANCE.getView_Id();
		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__LABEL = eINSTANCE.getView_Label();
		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__DESCRIPTION = eINSTANCE.getView_Description();
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.example.view.impl.ShowViewImpl <em>Show View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.example.view.impl.ShowViewImpl
		 * @see org.eclipse.rcptt.ecl.example.view.impl.ViewPackageImpl#getShowView()
		 * @generated
		 */
		EClass SHOW_VIEW = eINSTANCE.getShowView();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHOW_VIEW__ID = eINSTANCE.getShowView_Id();

	}

} //ViewPackage
