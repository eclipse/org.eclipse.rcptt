/**
 */
package org.eclipse.rcptt.tesla.ecl.rap.model;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Upload File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.rap.model.UploadFile#getFile <em>File</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.rap.model.UploadFile#getBase64 <em>Base64</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage#getUploadFile()
 * @model
 * @generated
 */
public interface UploadFile extends Command {
	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(String)
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage#getUploadFile_File()
	 * @model
	 * @generated
	 */
	String getFile();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.UploadFile#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(String value);

	/**
	 * Returns the value of the '<em><b>Base64</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base64</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base64</em>' attribute.
	 * @see #setBase64(String)
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage#getUploadFile_Base64()
	 * @model
	 * @generated
	 */
	String getBase64();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.UploadFile#getBase64 <em>Base64</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base64</em>' attribute.
	 * @see #getBase64()
	 * @generated
	 */
	void setBase64(String value);

} // UploadFile
