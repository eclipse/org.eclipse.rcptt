/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.tesla.core.protocol.diagram;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Figures Response</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.GetFiguresResponse#getFigures <em>Figures</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getGetFiguresResponse()
 * @model
 * @generated
 */
public interface GetFiguresResponse extends Response {
	/**
	 * Returns the value of the '<em><b>Figures</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.protocol.raw.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Figures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Figures</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getGetFiguresResponse_Figures()
	 * @model containment="true"
	 * @generated
	 */
	EList<Element> getFigures();

} // GetFiguresResponse
