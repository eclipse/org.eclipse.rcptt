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

import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#isSelected <em>Selected</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#isChecked <em>Checked</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getChildCount <em>Child Count</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getColumnsBackgroundColor <em>Columns Background Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getColumnsForegroundColor <em>Columns Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getStyleRanges <em>Style Ranges</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getStyles <em>Styles</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTreeItem()
 * @model
 * @generated
 */
public interface TreeItem extends Item, WithImage {
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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTreeItem_Selected()
	 * @model
	 * @generated
	 */
	boolean isSelected();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#isSelected <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selected</em>' attribute.
	 * @see #isSelected()
	 * @generated
	 */
	void setSelected(boolean value);

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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTreeItem_Checked()
	 * @model
	 * @generated
	 */
	boolean isChecked();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#isChecked <em>Checked</em>}' attribute.
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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTreeItem_BackgroundColor()
	 * @model containment="true"
	 * @generated
	 */
	Color getBackgroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getBackgroundColor <em>Background Color</em>}' containment reference.
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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTreeItem_ForegroundColor()
	 * @model containment="true"
	 * @generated
	 */
	Color getForegroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getForegroundColor <em>Foreground Color</em>}' containment reference.
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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTreeItem_Bounds()
	 * @model containment="true"
	 * @generated
	 */
	Rectangle getBounds();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getBounds <em>Bounds</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bounds</em>' containment reference.
	 * @see #getBounds()
	 * @generated
	 */
	void setBounds(Rectangle value);

	/**
	 * Returns the value of the '<em><b>Child Count</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Count</em>' attribute.
	 * @see #setChildCount(Integer)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTreeItem_ChildCount()
	 * @model default="0"
	 * @generated
	 */
	Integer getChildCount();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getChildCount <em>Child Count</em>}' attribute.
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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTreeItem_Columns()
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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTreeItem_ColumnsBackgroundColor()
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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTreeItem_ColumnsForegroundColor()
	 * @model containment="true"
	 * @generated
	 */
	EList<Color> getColumnsForegroundColor();

	/**
	 * Returns the value of the '<em><b>Style Ranges</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style Ranges</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style Ranges</em>' attribute list.
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTreeItem_StyleRanges()
	 * @model
	 * @generated
	 */
	EList<String> getStyleRanges();

	/**
	 * Returns the value of the '<em><b>Styles</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Styles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Styles</em>' containment reference list.
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTreeItem_Styles()
	 * @model containment="true"
	 * @generated
	 */
	EList<StyleRangeEntry> getStyles();

	/**
	 * Returns the value of the '<em><b>Values</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' map.
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getTreeItem_Values()
	 * @model mapType="org.eclipse.rcptt.tesla.core.ui.ValuesMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EMap<String, String> getValues();

} // TreeItem
