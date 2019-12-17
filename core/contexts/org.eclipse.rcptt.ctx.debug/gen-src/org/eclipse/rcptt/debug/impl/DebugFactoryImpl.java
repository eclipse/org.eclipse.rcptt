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
package org.eclipse.rcptt.debug.impl;

import org.eclipse.rcptt.debug.*;

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
public class DebugFactoryImpl extends EFactoryImpl implements DebugFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DebugFactory init() {
		try {
			DebugFactory theDebugFactory = (DebugFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/rcptt/ctx/debug"); 
			if (theDebugFactory != null) {
				return theDebugFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DebugFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DebugFactoryImpl() {
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
			case DebugPackage.DEBUG_CONTEXT: return createDebugContext();
			case DebugPackage.LAUNCH_CONFIGURATION: return createLaunchConfiguration();
			case DebugPackage.MAP_VALUE: return createMapValue();
			case DebugPackage.LIST_VALUE: return createListValue();
			case DebugPackage.SET_VALUE: return createSetValue();
			case DebugPackage.LAUNCH_TYPE: return createLaunchType();
			case DebugPackage.BREAKPOINT: return createBreakpoint();
			case DebugPackage.LAUNCH: return createLaunch();
			case DebugPackage.BREAKPOINT_RESOURCE: return createBreakpointResource();
			case DebugPackage.COLLECTION: return createCollection();
			case DebugPackage.PRIMITIVE_VALUE: return createPrimitiveValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DebugContext createDebugContext() {
		DebugContextImpl debugContext = new DebugContextImpl();
		return debugContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaunchConfiguration createLaunchConfiguration() {
		LaunchConfigurationImpl launchConfiguration = new LaunchConfigurationImpl();
		return launchConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapValue createMapValue() {
		MapValueImpl mapValue = new MapValueImpl();
		return mapValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListValue createListValue() {
		ListValueImpl listValue = new ListValueImpl();
		return listValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetValue createSetValue() {
		SetValueImpl setValue = new SetValueImpl();
		return setValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LaunchType createLaunchType() {
		LaunchTypeImpl launchType = new LaunchTypeImpl();
		return launchType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Breakpoint createBreakpoint() {
		BreakpointImpl breakpoint = new BreakpointImpl();
		return breakpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Launch createLaunch() {
		LaunchImpl launch = new LaunchImpl();
		return launch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BreakpointResource createBreakpointResource() {
		BreakpointResourceImpl breakpointResource = new BreakpointResourceImpl();
		return breakpointResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection createCollection() {
		CollectionImpl collection = new CollectionImpl();
		return collection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveValue createPrimitiveValue() {
		PrimitiveValueImpl primitiveValue = new PrimitiveValueImpl();
		return primitiveValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DebugPackage getDebugPackage() {
		return (DebugPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DebugPackage getPackage() {
		return DebugPackage.eINSTANCE;
	}

} //DebugFactoryImpl
