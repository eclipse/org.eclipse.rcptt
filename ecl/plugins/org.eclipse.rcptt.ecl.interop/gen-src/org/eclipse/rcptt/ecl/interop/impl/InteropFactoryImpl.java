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
package org.eclipse.rcptt.ecl.interop.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.rcptt.ecl.interop.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InteropFactoryImpl extends EFactoryImpl implements InteropFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InteropFactory init() {
		try {
			InteropFactory theInteropFactory = (InteropFactory)EPackage.Registry.INSTANCE.getEFactory(InteropPackage.eNS_URI);
			if (theInteropFactory != null) {
				return theInteropFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InteropFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteropFactoryImpl() {
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
			case InteropPackage.INVOKE: return createInvoke();
			case InteropPackage.EXEC_PROCESS: return createExecProcess();
			case InteropPackage.EXEC_PROCESS_RESULT: return createExecProcessResult();
			case InteropPackage.GET_MEMORY_USAGE: return createGetMemoryUsage();
			case InteropPackage.GET_JAVA_PROPERTY: return createGetJavaProperty();
			case InteropPackage.INVOKE_STATIC: return createInvokeStatic();
			case InteropPackage.INVOKE_UI: return createInvokeUi();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invoke createInvoke() {
		InvokeImpl invoke = new InvokeImpl();
		return invoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecProcess createExecProcess() {
		ExecProcessImpl execProcess = new ExecProcessImpl();
		return execProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecProcessResult createExecProcessResult() {
		ExecProcessResultImpl execProcessResult = new ExecProcessResultImpl();
		return execProcessResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetMemoryUsage createGetMemoryUsage() {
		GetMemoryUsageImpl getMemoryUsage = new GetMemoryUsageImpl();
		return getMemoryUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetJavaProperty createGetJavaProperty() {
		GetJavaPropertyImpl getJavaProperty = new GetJavaPropertyImpl();
		return getJavaProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvokeStatic createInvokeStatic() {
		InvokeStaticImpl invokeStatic = new InvokeStaticImpl();
		return invokeStatic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvokeUi createInvokeUi() {
		InvokeUiImpl invokeUi = new InvokeUiImpl();
		return invokeUi;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteropPackage getInteropPackage() {
		return (InteropPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InteropPackage getPackage() {
		return InteropPackage.eINSTANCE;
	}

} //InteropFactoryImpl
