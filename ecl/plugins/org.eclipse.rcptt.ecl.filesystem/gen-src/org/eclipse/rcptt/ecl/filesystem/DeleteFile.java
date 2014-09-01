/**
 */
package org.eclipse.rcptt.ecl.filesystem;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.filesystem.DeleteFile#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.filesystem.FilesystemPackage#getDeleteFile()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Deletes file or folder identified by URI.\r\nCurrently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system.' returns='Nothing' example='delete-file \"file:/C:/temp/1.txt\"\r\ndelete-file [uri-from-path \"C:/temp/2.txt\"]\r\nuri-from-path \"C:/temp/3.txt\" | delete-file\r\nget-file \"file:/C:/temp/4.txt\" | delete-file\r\nstr \"workspace:/MyProject/text.txt\" | delete-file\r\n\r\n'"
 * @generated
 */
public interface DeleteFile extends Command {
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
	 * @see org.eclipse.rcptt.ecl.filesystem.FilesystemPackage#getDeleteFile_Uri()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='URI of a file or directory. Can be created manually, or with uri-from-path.' example='file:/C:/temp'"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.filesystem.DeleteFile#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

} // DeleteFile
