/*******************************************************************************
 * Copyright (c) 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.tesla.core.protocol.diagram;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.tesla.core.protocol.ElementCommand;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Figure Mouse Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getButton <em>Button</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getFigurePath <em>Figure Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getPartPath <em>Part Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getBoundsWidth <em>Bounds Width</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getBoundsHeight <em>Bounds Height</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getStateMask <em>State Mask</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getFigureWidth <em>Figure Width</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getFigureHeight <em>Figure Height</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getFigureMouseCommand()
 * @model
 * @generated
 */
public interface FigureMouseCommand extends ElementCommand {
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getFigureMouseCommand_X()
	 * @model
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getFigureMouseCommand_Y()
	 * @model
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

	/**
	 * Returns the value of the '<em><b>Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Button</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Button</em>' attribute.
	 * @see #setButton(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getFigureMouseCommand_Button()
	 * @model
	 * @generated
	 */
	int getButton();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getButton <em>Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Button</em>' attribute.
	 * @see #getButton()
	 * @generated
	 */
	void setButton(int value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind
	 * @see #setKind(MouseCommandKind)
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getFigureMouseCommand_Kind()
	 * @model
	 * @generated
	 */
	MouseCommandKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(MouseCommandKind value);

	/**
	 * Returns the value of the '<em><b>Figure Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Figure Path</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Figure Path</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getFigureMouseCommand_FigurePath()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getFigurePath();

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
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getFigureMouseCommand_PartPath()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getPartPath();

	/**
	 * Returns the value of the '<em><b>Bounds Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounds Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds Width</em>' attribute.
	 * @see #setBoundsWidth(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getFigureMouseCommand_BoundsWidth()
	 * @model
	 * @generated
	 */
	int getBoundsWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getBoundsWidth <em>Bounds Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds Width</em>' attribute.
	 * @see #getBoundsWidth()
	 * @generated
	 */
	void setBoundsWidth(int value);

	/**
	 * Returns the value of the '<em><b>Bounds Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounds Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds Height</em>' attribute.
	 * @see #setBoundsHeight(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getFigureMouseCommand_BoundsHeight()
	 * @model
	 * @generated
	 */
	int getBoundsHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getBoundsHeight <em>Bounds Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds Height</em>' attribute.
	 * @see #getBoundsHeight()
	 * @generated
	 */
	void setBoundsHeight(int value);

	/**
	 * Returns the value of the '<em><b>State Mask</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Mask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Mask</em>' attribute.
	 * @see #setStateMask(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getFigureMouseCommand_StateMask()
	 * @model default="0"
	 * @generated
	 */
	int getStateMask();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getStateMask <em>State Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Mask</em>' attribute.
	 * @see #getStateMask()
	 * @generated
	 */
	void setStateMask(int value);

	/**
	 * Returns the value of the '<em><b>Figure Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Figure Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Figure Width</em>' attribute.
	 * @see #setFigureWidth(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getFigureMouseCommand_FigureWidth()
	 * @model
	 * @generated
	 */
	int getFigureWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getFigureWidth <em>Figure Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Figure Width</em>' attribute.
	 * @see #getFigureWidth()
	 * @generated
	 */
	void setFigureWidth(int value);

	/**
	 * Returns the value of the '<em><b>Figure Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Figure Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Figure Height</em>' attribute.
	 * @see #setFigureHeight(int)
	 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getFigureMouseCommand_FigureHeight()
	 * @model
	 * @generated
	 */
	int getFigureHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand#getFigureHeight <em>Figure Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Figure Height</em>' attribute.
	 * @see #getFigureHeight()
	 * @generated
	 */
	void setFigureHeight(int value);

} // FigureMouseCommand
