/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core.ui;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getTooltip <em>Tooltip</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getItemAddress <em>Item Address</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#isSelected <em>Selected</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getChildrenCount <em>Children Count</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getModelPropertyNodes <em>Model Property Nodes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramItem()
 * @model
 * @generated
 */
public interface DiagramItem extends Widget, PropertyMap, WithImage {
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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramItem_X()
	 * @model
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getX <em>X</em>}' attribute.
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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramItem_Y()
	 * @model
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramItem_Width()
	 * @model
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(int)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramItem_Height()
	 * @model
	 * @generated
	 */
	int getHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(int value);

	/**
	 * Returns the value of the '<em><b>Tooltip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tooltip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tooltip</em>' attribute.
	 * @see #setTooltip(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramItem_Tooltip()
	 * @model
	 * @generated
	 */
	String getTooltip();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getTooltip <em>Tooltip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tooltip</em>' attribute.
	 * @see #getTooltip()
	 * @generated
	 */
	void setTooltip(String value);

	/**
	 * Returns the value of the '<em><b>Children Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children Count</em>' attribute.
	 * @see #setChildrenCount(int)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramItem_ChildrenCount()
	 * @model
	 * @generated
	 */
	int getChildrenCount();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getChildrenCount <em>Children Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Children Count</em>' attribute.
	 * @see #getChildrenCount()
	 * @generated
	 */
	void setChildrenCount(int value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramItem_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Background Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background Color</em>' containment reference.
	 * @see #setBackgroundColor(Color)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramItem_BackgroundColor()
	 * @model containment="true"
	 * @generated
	 */
	Color getBackgroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getBackgroundColor <em>Background Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Color</em>' containment reference.
	 * @see #getBackgroundColor()
	 * @generated
	 */
	void setBackgroundColor(Color value);

	/**
	 * Returns the value of the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreground Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreground Color</em>' containment reference.
	 * @see #setForegroundColor(Color)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramItem_ForegroundColor()
	 * @model containment="true"
	 * @generated
	 */
	Color getForegroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getForegroundColor <em>Foreground Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreground Color</em>' containment reference.
	 * @see #getForegroundColor()
	 * @generated
	 */
	void setForegroundColor(Color value);

	/**
	 * Returns the value of the '<em><b>Model Property Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.ui.PropertyNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Property Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Property Nodes</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramItem_ModelPropertyNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropertyNode> getModelPropertyNodes();

	/**
	 * Returns the value of the '<em><b>Item Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item Address</em>' attribute.
	 * @see #setItemAddress(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramItem_ItemAddress()
	 * @model
	 * @generated
	 */
	String getItemAddress();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getItemAddress <em>Item Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item Address</em>' attribute.
	 * @see #getItemAddress()
	 * @generated
	 */
	void setItemAddress(String value);

	/**
	 * Returns the value of the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selected</em>' attribute.
	 * @see #setSelected(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramItem_Selected()
	 * @model
	 * @generated
	 */
	boolean isSelected();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#isSelected <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selected</em>' attribute.
	 * @see #isSelected()
	 * @generated
	 */
	void setSelected(boolean value);

	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getDiagramItem_ClassName()
	 * @model
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

} // DiagramItem
