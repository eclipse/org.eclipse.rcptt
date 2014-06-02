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
package org.eclipse.rcptt.core.ecl.context;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.rcptt.core.scenario.ScenarioPackage;

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
 * @see org.eclipse.rcptt.core.ecl.context.ContextFactory
 * @model kind="package"
 * @generated
 */
public interface ContextPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "context";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/ctx/ecl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.ctx.ecl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	ContextPackage eINSTANCE = org.eclipse.rcptt.core.ecl.context.impl.ContextPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.core.ecl.context.impl.EclContextImpl <em>Ecl Context</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.core.ecl.context.impl.EclContextImpl
	 * @see org.eclipse.rcptt.core.ecl.context.impl.ContextPackageImpl#getEclContext()
	 * @generated
	 */
	int ECL_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ECL_CONTEXT__NAME = ScenarioPackage.CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ECL_CONTEXT__VERSION = ScenarioPackage.CONTEXT__VERSION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ECL_CONTEXT__ID = ScenarioPackage.CONTEXT__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ECL_CONTEXT__DESCRIPTION = ScenarioPackage.CONTEXT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_CONTEXT__TAGS = ScenarioPackage.CONTEXT__TAGS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_CONTEXT__ATTACHMENTS = ScenarioPackage.CONTEXT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Script</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_CONTEXT__SCRIPT = ScenarioPackage.CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ecl Context</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_CONTEXT_FEATURE_COUNT = ScenarioPackage.CONTEXT_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.rcptt.core.ecl.context.EclContext <em>Ecl Context</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Ecl Context</em>'.
	 * @see org.eclipse.rcptt.core.ecl.context.EclContext
	 * @generated
	 */
	EClass getEclContext();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.core.ecl.context.EclContext#getScript <em>Script</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Script</em>'.
	 * @see org.eclipse.rcptt.core.ecl.context.EclContext#getScript()
	 * @see #getEclContext()
	 * @generated
	 */
	EReference getEclContext_Script();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ContextFactory getContextFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.core.ecl.context.impl.EclContextImpl <em>Ecl Context</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.rcptt.core.ecl.context.impl.EclContextImpl
		 * @see org.eclipse.rcptt.core.ecl.context.impl.ContextPackageImpl#getEclContext()
		 * @generated
		 */
		EClass ECL_CONTEXT = eINSTANCE.getEclContext();

		/**
		 * The meta object literal for the '<em><b>Script</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECL_CONTEXT__SCRIPT = eINSTANCE.getEclContext_Script();

	}

} // ContextPackage
