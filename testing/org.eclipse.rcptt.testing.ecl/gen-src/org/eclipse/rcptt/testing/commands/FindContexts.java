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
 * A representation of the model object '<em><b>Find Contexts</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.testing.commands.FindContexts#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getFindContexts()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Searches for all contexts of a given type (or all if type is empty) and writes their paths to output pipe' returns='List of context paths'"
 * @generated
 */
public interface FindContexts extends Command {
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
	 * @see org.eclipse.rcptt.testing.commands.CommandsPackage#getFindContexts_Type()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Class name of context to find. When empty, all context types.\nPossible values:\n<ul>\n<li>WorkspaceContext</li>\n<li>WorkbenchContext</li>\n<li>GroupContext</li>\n<li>DebugContext</li>\n<li>EclContext</li>\n</ul>'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.testing.commands.FindContexts#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // FindContexts
