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

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Control#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Control#isEnablement <em>Enablement</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Control#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Control#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Control#isContainMenu <em>Contain Menu</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Control#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Control#getBorderWith <em>Border With</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Control#getDecorators <em>Decorators</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getControl()
 * @model
 * @generated
 */
public interface Control extends Widget {
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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getControl_ClassName()
	 * @model
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Control#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

	/**
	 * Returns the value of the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enablement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enablement</em>' attribute.
	 * @see #setEnablement(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getControl_Enablement()
	 * @model
	 * @generated
	 */
	boolean isEnablement();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Control#isEnablement <em>Enablement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enablement</em>' attribute.
	 * @see #isEnablement()
	 * @generated
	 */
	void setEnablement(boolean value);

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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getControl_BackgroundColor()
	 * @model containment="true"
	 * @generated
	 */
	Color getBackgroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Control#getBackgroundColor <em>Background Color</em>}' containment reference.
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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getControl_ForegroundColor()
	 * @model containment="true"
	 * @generated
	 */
	Color getForegroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Control#getForegroundColor <em>Foreground Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreground Color</em>' containment reference.
	 * @see #getForegroundColor()
	 * @generated
	 */
	void setForegroundColor(Color value);

	/**
	 * Returns the value of the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contain Menu</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contain Menu</em>' attribute.
	 * @see #setContainMenu(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getControl_ContainMenu()
	 * @model
	 * @generated
	 */
	boolean isContainMenu();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Control#isContainMenu <em>Contain Menu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contain Menu</em>' attribute.
	 * @see #isContainMenu()
	 * @generated
	 */
	void setContainMenu(boolean value);

	/**
	 * Returns the value of the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounds</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounds</em>' containment reference.
	 * @see #setBounds(Rectangle)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getControl_Bounds()
	 * @model containment="true"
	 * @generated
	 */
	Rectangle getBounds();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Control#getBounds <em>Bounds</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds</em>' containment reference.
	 * @see #getBounds()
	 * @generated
	 */
	void setBounds(Rectangle value);

	/**
	 * Returns the value of the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border With</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Border With</em>' attribute.
	 * @see #setBorderWith(int)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getControl_BorderWith()
	 * @model
	 * @generated
	 */
	int getBorderWith();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Control#getBorderWith <em>Border With</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border With</em>' attribute.
	 * @see #getBorderWith()
	 * @generated
	 */
	void setBorderWith(int value);

	/**
	 * Returns the value of the '<em><b>Decorators</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.ui.ControlDecorator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decorators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decorators</em>' reference list.
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getControl_Decorators()
	 * @model
	 * @generated
	 */
	EList<ControlDecorator> getDecorators();

} // Control
