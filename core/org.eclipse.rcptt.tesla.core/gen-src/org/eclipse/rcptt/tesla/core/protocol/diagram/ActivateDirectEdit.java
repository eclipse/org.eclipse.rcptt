/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.tesla.core.protocol.diagram;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.tesla.core.protocol.ElementCommand;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activate Direct Edit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.ActivateDirectEdit#getPartPath <em>Part Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getActivateDirectEdit()
 * @model
 * @generated
 */
public interface ActivateDirectEdit extends ElementCommand {
	/**
	 * Returns the value of the '<em><b>Part Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Path</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Path</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getActivateDirectEdit_PartPath()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getPartPath();

} // ActivateDirectEdit
