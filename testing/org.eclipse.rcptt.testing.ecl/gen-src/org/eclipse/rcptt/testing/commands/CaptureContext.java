/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.testing.commands;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Capture Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.testing.commands.CaptureContext#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.testing.commands.CaptureContext#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getCaptureContext()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Captures context from AUT' returns='Nothing'"
 * @generated
 */
public interface CaptureContext extends Command {
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
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getCaptureContext_Path()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Workspace-relative path of context'"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testing.commands.CaptureContext#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getCaptureContext_Type()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Class name of context to apply. If context already exists, can be omitted. If context exists, but has another type, command fails\nPossible values:\n<ul>\n<li>WorkspaceContext</li>\n<li>WorkbenchContext</li>\n<li>GroupContext</li>\n<li>DebugContext</li>\n<li>EclContext</li>\n</ul>'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testing.commands.CaptureContext#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // CaptureContext
