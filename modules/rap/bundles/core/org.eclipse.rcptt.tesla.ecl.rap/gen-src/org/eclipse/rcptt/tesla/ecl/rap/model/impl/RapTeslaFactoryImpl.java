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
public class RapTeslaFactoryImpl extends EFactoryImpl implements RapTeslaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RapTeslaFactory init() {
		try {
			RapTeslaFactory theRapTeslaFactory = (RapTeslaFactory)EPackage.Registry.INSTANCE.getEFactory(RapTeslaPackage.eNS_URI);
			if (theRapTeslaFactory != null) {
				return theRapTeslaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RapTeslaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RapTeslaFactoryImpl() {
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
			case RapTeslaPackage.RUN_JS: return createRunJs();
			case RapTeslaPackage.EXEC_WITHOUT_JS: return createExecWithoutJs();
			case RapTeslaPackage.SET_DOWNLOAD_RESULT_FILE: return createSetDownloadResultFile();
			case RapTeslaPackage.VERIFY_DOWNLOAD_FILE: return createVerifyDownloadFile();
			case RapTeslaPackage.MARK_DOWNLOAD_HANDLER: return createMarkDownloadHandler();
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
	public MarkDownloadHandler createMarkDownloadHandler() {
		MarkDownloadHandlerImpl markDownloadHandler = new MarkDownloadHandlerImpl();
		return markDownloadHandler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RapTeslaPackage getRapTeslaPackage() {
		return (RapTeslaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RapTeslaPackage getPackage() {
		return RapTeslaPackage.eINSTANCE;
	}

} //RapTeslaFactoryImpl
