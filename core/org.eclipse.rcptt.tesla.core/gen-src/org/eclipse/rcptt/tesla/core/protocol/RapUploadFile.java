/**
 */
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rap Upload File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.RapUploadFile#getBase64file <em>Base64file</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.RapUploadFile#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getRapUploadFile()
 * @model
 * @generated
 */
public interface RapUploadFile extends Command {
	/**
	 * Returns the value of the '<em><b>Base64file</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base64file</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base64file</em>' attribute.
	 * @see #setBase64file(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getRapUploadFile_Base64file()
	 * @model
	 * @generated
	 */
	String getBase64file();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.RapUploadFile#getBase64file <em>Base64file</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base64file</em>' attribute.
	 * @see #getBase64file()
	 * @generated
	 */
	void setBase64file(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getRapUploadFile_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.RapUploadFile#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // RapUploadFile
