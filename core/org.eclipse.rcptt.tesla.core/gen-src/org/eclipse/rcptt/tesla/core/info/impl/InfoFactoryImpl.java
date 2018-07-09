/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core.info.impl;

import org.eclipse.rcptt.tesla.core.info.*;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.InfoFactory;
import org.eclipse.rcptt.tesla.core.info.InfoNode;
import org.eclipse.rcptt.tesla.core.info.InfoPackage;
import org.eclipse.rcptt.tesla.core.info.JobEntry;
import org.eclipse.rcptt.tesla.core.info.NodeProperty;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfo;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.core.info.StackTraceEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InfoFactoryImpl extends EFactoryImpl implements InfoFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InfoFactory init() {
		try {
			InfoFactory theInfoFactory = (InfoFactory)EPackage.Registry.INSTANCE.getEFactory(InfoPackage.eNS_URI);
			if (theInfoFactory != null) {
				return theInfoFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InfoFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfoFactoryImpl() {
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
			case InfoPackage.ADVANCED_INFORMATION: return createAdvancedInformation();
			case InfoPackage.STACK_TRACE_ENTRY: return createStackTraceEntry();
			case InfoPackage.JOB_ENTRY: return createJobEntry();
			case InfoPackage.INFO_NODE: return createInfoNode();
			case InfoPackage.NODE_PROPERTY: return createNodeProperty();
			case InfoPackage.Q7_WAIT_INFO: return createQ7WaitInfo();
			case InfoPackage.Q7_WAIT_INFO_ROOT: return createQ7WaitInfoRoot();
			case InfoPackage.Q7_WAIT_INFO_INNER_CLASS_MAP: return (EObject)createQ7WaitInfoInnerClassMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdvancedInformation createAdvancedInformation() {
		AdvancedInformationImpl advancedInformation = new AdvancedInformationImpl();
		return advancedInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StackTraceEntry createStackTraceEntry() {
		StackTraceEntryImpl stackTraceEntry = new StackTraceEntryImpl();
		return stackTraceEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobEntry createJobEntry() {
		JobEntryImpl jobEntry = new JobEntryImpl();
		return jobEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfoNode createInfoNode() {
		InfoNodeImpl infoNode = new InfoNodeImpl();
		return infoNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeProperty createNodeProperty() {
		NodePropertyImpl nodeProperty = new NodePropertyImpl();
		return nodeProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Q7WaitInfo createQ7WaitInfo() {
		Q7WaitInfoImpl q7WaitInfo = new Q7WaitInfoImpl();
		return q7WaitInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Q7WaitInfoRoot createQ7WaitInfoRoot() {
		Q7WaitInfoRootImpl q7WaitInfoRoot = new Q7WaitInfoRootImpl();
		return q7WaitInfoRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, String> createQ7WaitInfoInnerClassMap() {
		Q7WaitInfoInnerClassMapImpl q7WaitInfoInnerClassMap = new Q7WaitInfoInnerClassMapImpl();
		return q7WaitInfoInnerClassMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfoPackage getInfoPackage() {
		return (InfoPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InfoPackage getPackage() {
		return InfoPackage.eINSTANCE;
	}

} //InfoFactoryImpl
