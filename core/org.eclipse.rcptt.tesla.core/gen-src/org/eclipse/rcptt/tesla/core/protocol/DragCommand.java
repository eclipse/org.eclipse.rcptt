/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core.protocol;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Drag Command</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.DragCommand#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.DragCommand#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.DragCommand#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.DragCommand#getStyle <em>Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getDragCommand()
 * @model
 * @generated
 */
public interface DragCommand extends ElementCommand {

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.tesla.core.protocol.DragKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DragKind
	 * @see #setKind(DragKind)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getDragCommand_Kind()
	 * @model
	 * @generated
	 */
	DragKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.DragCommand#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DragKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(DragKind value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getDragCommand_X()
	 * @model
	 * @generated
	 */
	Integer getX();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.DragCommand#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(Integer value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(Integer)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getDragCommand_Y()
	 * @model
	 * @generated
	 */
	Integer getY();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.DragCommand#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(Integer value);

	/**
	 * Returns the value of the '<em><b>Style</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Style</em>' attribute.
	 * @see #setStyle(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getDragCommand_Style()
	 * @model
	 * @generated
	 */
	String getStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.DragCommand#getStyle <em>Style</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' attribute.
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(String value);
} // DragCommand
