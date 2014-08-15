/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.ecl.filesystem;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.filesystem.GetFile#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.filesystem.FilesystemPackage#getGetFile()
 * @model annotation="http://www.eclipse.org/ecl/docs returns='A File object.  Properties: uri, name, exists, children.' description='Creates a file object by its URI.' example='get-file \"file:/C:/Windows/System32\"  | get exists'"
 * @generated
 */
public interface GetFile extends Command {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.eclipse.rcptt.ecl.filesystem.FilesystemPackage#getGetFile_Uri()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='URI of a file or directory. Can be created manually, or with uri-from-path.' example='file:/C:/windows/system32'"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.filesystem.GetFile#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

} // GetFile
