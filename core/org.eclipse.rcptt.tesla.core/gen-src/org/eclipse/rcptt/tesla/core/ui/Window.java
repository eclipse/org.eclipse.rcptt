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
package org.eclipse.rcptt.tesla.core.ui;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Window</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Window#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Window#isSizeable <em>Sizeable</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Window#isHasBorder <em>Has Border</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Window#isHasMinimizeButton <em>Has Minimize Button</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Window#isHasMaximizeButton <em>Has Maximize Button</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Window#isHasCloseButton <em>Has Close Button</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Window#isIsPrimaryModal <em>Is Primary Modal</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Window#isIsApplicationModal <em>Is Application Modal</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Window#isIsSystemModal <em>Is System Modal</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Window#isIsTool <em>Is Tool</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Window#isIsSheet <em>Is Sheet</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getWindow()
 * @model
 * @generated
 */
public interface Window extends Control {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getWindow_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Window#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Sizeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sizeable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sizeable</em>' attribute.
	 * @see #setSizeable(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getWindow_Sizeable()
	 * @model
	 * @generated
	 */
	boolean isSizeable();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Window#isSizeable <em>Sizeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sizeable</em>' attribute.
	 * @see #isSizeable()
	 * @generated
	 */
	void setSizeable(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Primary Modal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Primary Modal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Primary Modal</em>' attribute.
	 * @see #setIsPrimaryModal(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getWindow_IsPrimaryModal()
	 * @model
	 * @generated
	 */
	boolean isIsPrimaryModal();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Window#isIsPrimaryModal <em>Is Primary Modal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Primary Modal</em>' attribute.
	 * @see #isIsPrimaryModal()
	 * @generated
	 */
	void setIsPrimaryModal(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Application Modal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Application Modal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Application Modal</em>' attribute.
	 * @see #setIsApplicationModal(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getWindow_IsApplicationModal()
	 * @model
	 * @generated
	 */
	boolean isIsApplicationModal();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Window#isIsApplicationModal <em>Is Application Modal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Application Modal</em>' attribute.
	 * @see #isIsApplicationModal()
	 * @generated
	 */
	void setIsApplicationModal(boolean value);

	/**
	 * Returns the value of the '<em><b>Is System Modal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is System Modal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is System Modal</em>' attribute.
	 * @see #setIsSystemModal(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getWindow_IsSystemModal()
	 * @model
	 * @generated
	 */
	boolean isIsSystemModal();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Window#isIsSystemModal <em>Is System Modal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is System Modal</em>' attribute.
	 * @see #isIsSystemModal()
	 * @generated
	 */
	void setIsSystemModal(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Tool</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Tool</em>' attribute.
	 * @see #setIsTool(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getWindow_IsTool()
	 * @model
	 * @generated
	 */
	boolean isIsTool();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Window#isIsTool <em>Is Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Tool</em>' attribute.
	 * @see #isIsTool()
	 * @generated
	 */
	void setIsTool(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Sheet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Sheet</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Sheet</em>' attribute.
	 * @see #setIsSheet(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getWindow_IsSheet()
	 * @model
	 * @generated
	 */
	boolean isIsSheet();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Window#isIsSheet <em>Is Sheet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Sheet</em>' attribute.
	 * @see #isIsSheet()
	 * @generated
	 */
	void setIsSheet(boolean value);

	/**
	 * Returns the value of the '<em><b>Has Close Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Close Button</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Close Button</em>' attribute.
	 * @see #setHasCloseButton(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getWindow_HasCloseButton()
	 * @model
	 * @generated
	 */
	boolean isHasCloseButton();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Window#isHasCloseButton <em>Has Close Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Close Button</em>' attribute.
	 * @see #isHasCloseButton()
	 * @generated
	 */
	void setHasCloseButton(boolean value);

	/**
	 * Returns the value of the '<em><b>Has Minimize Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Minimize Button</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Minimize Button</em>' attribute.
	 * @see #setHasMinimizeButton(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getWindow_HasMinimizeButton()
	 * @model
	 * @generated
	 */
	boolean isHasMinimizeButton();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Window#isHasMinimizeButton <em>Has Minimize Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Minimize Button</em>' attribute.
	 * @see #isHasMinimizeButton()
	 * @generated
	 */
	void setHasMinimizeButton(boolean value);

	/**
	 * Returns the value of the '<em><b>Has Maximize Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Maximize Button</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Maximize Button</em>' attribute.
	 * @see #setHasMaximizeButton(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getWindow_HasMaximizeButton()
	 * @model
	 * @generated
	 */
	boolean isHasMaximizeButton();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Window#isHasMaximizeButton <em>Has Maximize Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Maximize Button</em>' attribute.
	 * @see #isHasMaximizeButton()
	 * @generated
	 */
	void setHasMaximizeButton(boolean value);

	/**
	 * Returns the value of the '<em><b>Has Border</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Border</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Border</em>' attribute.
	 * @see #setHasBorder(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getWindow_HasBorder()
	 * @model
	 * @generated
	 */
	boolean isHasBorder();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Window#isHasBorder <em>Has Border</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Border</em>' attribute.
	 * @see #isHasBorder()
	 * @generated
	 */
	void setHasBorder(boolean value);

} // Window
