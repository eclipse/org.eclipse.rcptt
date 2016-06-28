/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2016 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.rap.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.rcptt.tesla.ecl.rap.model.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TeslaFactoryImpl extends EFactoryImpl implements TeslaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TeslaFactory init() {
		try {
			TeslaFactory theTeslaFactory = (TeslaFactory)EPackage.Registry.INSTANCE.getEFactory(TeslaPackage.eNS_URI);
			if (theTeslaFactory != null) {
				return theTeslaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TeslaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TeslaFactoryImpl() {
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
			case TeslaPackage.RUN_JS: return createRunJs();
			case TeslaPackage.EXEC_WITHOUT_JS: return createExecWithoutJs();
			case TeslaPackage.SET_DOWNLOAD_RESULT_FILE: return createSetDownloadResultFile();
			case TeslaPackage.VERIFY_DOWNLOAD_FILE: return createVerifyDownloadFile();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunJs createRunJs() {
		RunJsImpl runJs = new RunJsImpl();
		return runJs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecWithoutJs createExecWithoutJs() {
		ExecWithoutJsImpl execWithoutJs = new ExecWithoutJsImpl();
		return execWithoutJs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetDownloadResultFile createSetDownloadResultFile() {
		SetDownloadResultFileImpl setDownloadResultFile = new SetDownloadResultFileImpl();
		return setDownloadResultFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerifyDownloadFile createVerifyDownloadFile() {
		VerifyDownloadFileImpl verifyDownloadFile = new VerifyDownloadFileImpl();
		return verifyDownloadFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TeslaPackage getTeslaPackage() {
		return (TeslaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TeslaPackage getPackage() {
		return TeslaPackage.eINSTANCE;
	}

} //TeslaFactoryImpl
