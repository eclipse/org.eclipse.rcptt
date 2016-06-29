/**
 */
package org.eclipse.rcptt.tesla.ecl.rap.model.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.ecl.core.Command;

import org.eclipse.rcptt.tesla.ecl.rap.model.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage
 * @generated
 */
public class RapTeslaSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RapTeslaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RapTeslaSwitch() {
		if (modelPackage == null) {
			modelPackage = RapTeslaPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case RapTeslaPackage.RUN_JS: {
				RunJs runJs = (RunJs)theEObject;
				T result = caseRunJs(runJs);
				if (result == null) result = caseCommand(runJs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapTeslaPackage.EXEC_WITHOUT_JS: {
				ExecWithoutJs execWithoutJs = (ExecWithoutJs)theEObject;
				T result = caseExecWithoutJs(execWithoutJs);
				if (result == null) result = caseCommand(execWithoutJs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapTeslaPackage.MARK_DOWNLOAD_HANDLER: {
				MarkDownloadHandler markDownloadHandler = (MarkDownloadHandler)theEObject;
				T result = caseMarkDownloadHandler(markDownloadHandler);
				if (result == null) result = caseCommand(markDownloadHandler);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapTeslaPackage.UPLOAD_FILE: {
				UploadFile uploadFile = (UploadFile)theEObject;
				T result = caseUploadFile(uploadFile);
				if (result == null) result = caseCommand(uploadFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapTeslaPackage.DOWNLOAD_FILE: {
				DownloadFile downloadFile = (DownloadFile)theEObject;
				T result = caseDownloadFile(downloadFile);
				if (result == null) result = caseCommand(downloadFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapTeslaPackage.TO_STRING: {
				ToString toString = (ToString)theEObject;
				T result = caseToString(toString);
				if (result == null) result = caseCommand(toString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapTeslaPackage.MATCH_BINARY: {
				MatchBinary matchBinary = (MatchBinary)theEObject;
				T result = caseMatchBinary(matchBinary);
				if (result == null) result = caseCommand(matchBinary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Run Js</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Run Js</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRunJs(RunJs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exec Without Js</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exec Without Js</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecWithoutJs(ExecWithoutJs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mark Download Handler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mark Download Handler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMarkDownloadHandler(MarkDownloadHandler object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Upload File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Upload File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUploadFile(UploadFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Download File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Download File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDownloadFile(DownloadFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>To String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToString(ToString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match Binary</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match Binary</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatchBinary(MatchBinary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommand(Command object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //RapTeslaSwitch
