/**
 */
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
			case RapTeslaPackage.MARK_DOWNLOAD_HANDLER: return createMarkDownloadHandler();
			case RapTeslaPackage.UPLOAD_FILE: return createUploadFile();
			case RapTeslaPackage.DOWNLOAD_FILE: return createDownloadFile();
			case RapTeslaPackage.TO_STRING: return createToString();
			case RapTeslaPackage.MATCH_BINARY: return createMatchBinary();
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
	public MarkDownloadHandler createMarkDownloadHandler() {
		MarkDownloadHandlerImpl markDownloadHandler = new MarkDownloadHandlerImpl();
		return markDownloadHandler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UploadFile createUploadFile() {
		UploadFileImpl uploadFile = new UploadFileImpl();
		return uploadFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DownloadFile createDownloadFile() {
		DownloadFileImpl downloadFile = new DownloadFileImpl();
		return downloadFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToString createToString() {
		ToStringImpl toString = new ToStringImpl();
		return toString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchBinary createMatchBinary() {
		MatchBinaryImpl matchBinary = new MatchBinaryImpl();
		return matchBinary;
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
