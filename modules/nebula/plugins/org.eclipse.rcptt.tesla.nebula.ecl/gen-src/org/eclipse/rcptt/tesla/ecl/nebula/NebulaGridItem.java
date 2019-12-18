/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.nebula;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.tesla.core.ui.Color;
import org.eclipse.rcptt.tesla.core.ui.Item;
import org.eclipse.rcptt.tesla.core.ui.Rectangle;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grid Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#isChecked <em>Checked</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getChildCount <em>Child Count</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getColumnsBackgroundColor <em>Columns Background Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getColumnsForegroundColor <em>Columns Foreground Color</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getNebulaGridItem()
 * @model
 * @generated
 */
public interface NebulaGridItem extends Item {
	/**
	 * Returns the value of the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checked</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checked</em>' attribute.
	 * @see #setChecked(boolean)
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getNebulaGridItem_Checked()
	 * @model
	 * @generated
	 */
	boolean isChecked();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#isChecked <em>Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checked</em>' attribute.
	 * @see #isChecked()
	 * @generated
	 */
	void setChecked(boolean value);

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
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getNebulaGridItem_BackgroundColor()
	 * @model containment="true"
	 * @generated
	 */
	Color getBackgroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getBackgroundColor <em>Background Color</em>}' containment reference.
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
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getNebulaGridItem_ForegroundColor()
	 * @model containment="true"
	 * @generated
	 */
	Color getForegroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getForegroundColor <em>Foreground Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreground Color</em>' containment reference.
	 * @see #getForegroundColor()
	 * @generated
	 */
	void setForegroundColor(Color value);

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
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getNebulaGridItem_Bounds()
	 * @model containment="true"
	 * @generated
	 */
	Rectangle getBounds();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getBounds <em>Bounds</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds</em>' containment reference.
	 * @see #getBounds()
	 * @generated
	 */
	void setBounds(Rectangle value);

	/**
	 * Returns the value of the '<em><b>Child Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Count</em>' attribute.
	 * @see #setChildCount(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getNebulaGridItem_ChildCount()
	 * @model
	 * @generated
	 */
	Integer getChildCount();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.nebula.NebulaGridItem#getChildCount <em>Child Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child Count</em>' attribute.
	 * @see #getChildCount()
	 * @generated
	 */
	void setChildCount(Integer value);

	/**
	 * Returns the value of the '<em><b>Columns</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getNebulaGridItem_Columns()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getColumns();

	/**
	 * Returns the value of the '<em><b>Columns Background Color</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.ui.Color}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns Background Color</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns Background Color</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getNebulaGridItem_ColumnsBackgroundColor()
	 * @model containment="true"
	 * @generated
	 */
	EList<Color> getColumnsBackgroundColor();

	/**
	 * Returns the value of the '<em><b>Columns Foreground Color</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.ui.Color}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns Foreground Color</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns Foreground Color</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getNebulaGridItem_ColumnsForegroundColor()
	 * @model containment="true"
	 * @generated
	 */
	EList<Color> getColumnsForegroundColor();

} // NebulaGridItem
