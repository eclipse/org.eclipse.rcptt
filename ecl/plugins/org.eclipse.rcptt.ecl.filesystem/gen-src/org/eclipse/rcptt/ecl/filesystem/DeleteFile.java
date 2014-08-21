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
 *   <li>{@link org.eclipse.rcptt.ecl.filesystem.DeleteFile#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.filesystem.FilesystemPackage#getDeleteFile()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Deletes file or folder' returns='Nothing' example='delete-file \"C:/temp/t.test\"'"
 * @generated
 */
public interface DeleteFile extends Command {
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
	 * @see org.eclipse.rcptt.ecl.filesystem.FilesystemPackage#getDeleteFile_Path()
	 * @model required="true"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.filesystem.DeleteFile#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // DeleteFile
