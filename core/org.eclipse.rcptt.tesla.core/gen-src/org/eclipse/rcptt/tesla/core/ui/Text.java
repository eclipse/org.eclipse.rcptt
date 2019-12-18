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
package org.eclipse.rcptt.tesla.core.ui;

import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Text#getTooltip <em>Tooltip</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Text#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Text#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Text#getRawValue <em>Raw Value</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Text#getStyleRanges <em>Style Ranges</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Text#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Text#getStyles <em>Styles</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Text#getCaretPosition <em>Caret Position</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Text#getStyleAtCaret <em>Style At Caret</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Text#getMarkers <em>Markers</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.Text#getMarkersCount <em>Markers Count</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getText()
 * @model
 * @generated
 */
public interface Text extends Control {
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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getText_Tooltip()
	 * @model
	 * @generated
	 */
	String getTooltip();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Text#getTooltip <em>Tooltip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tooltip</em>' attribute.
	 * @see #getTooltip()
	 * @generated
	 */
	void setTooltip(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getText_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Text#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see #setReadOnly(boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getText_ReadOnly()
	 * @model
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Text#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Raw Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Value</em>' attribute.
	 * @see #setRawValue(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getText_RawValue()
	 * @model
	 * @generated
	 */
	String getRawValue();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Text#getRawValue <em>Raw Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Value</em>' attribute.
	 * @see #getRawValue()
	 * @generated
	 */
	void setRawValue(String value);

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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getText_StyleRanges()
	 * @model
	 * @generated
	 */
	EList<String> getStyleRanges();

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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getText_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Text#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getText_Styles()
	 * @model containment="true"
	 * @generated
	 */
	EList<StyleRangeEntry> getStyles();

	/**
	 * Returns the value of the '<em><b>Caret Position</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Caret Position</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caret Position</em>' reference.
	 * @see #setCaretPosition(TextPosition)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getText_CaretPosition()
	 * @model
	 * @generated
	 */
	TextPosition getCaretPosition();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Text#getCaretPosition <em>Caret Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caret Position</em>' reference.
	 * @see #getCaretPosition()
	 * @generated
	 */
	void setCaretPosition(TextPosition value);

	/**
	 * Returns the value of the '<em><b>Style At Caret</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style At Caret</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style At Caret</em>' containment reference.
	 * @see #setStyleAtCaret(StyleRangeEntry)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getText_StyleAtCaret()
	 * @model containment="true"
	 * @generated
	 */
	StyleRangeEntry getStyleAtCaret();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Text#getStyleAtCaret <em>Style At Caret</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style At Caret</em>' containment reference.
	 * @see #getStyleAtCaret()
	 * @generated
	 */
	void setStyleAtCaret(StyleRangeEntry value);

	/**
	 * Returns the value of the '<em><b>Markers</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type list of {@link org.eclipse.rcptt.tesla.core.ui.Marker},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Markers</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Markers</em>' map.
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getText_Markers()
	 * @model mapType="org.eclipse.rcptt.tesla.core.ui.LineMarkersValue&lt;org.eclipse.emf.ecore.EString, org.eclipse.rcptt.tesla.core.ui.Marker&gt;"
	 * @generated
	 */
	EMap<String, EList<Marker>> getMarkers();

	/**
	 * Returns the value of the '<em><b>Markers Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Markers Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Markers Count</em>' attribute.
	 * @see #setMarkersCount(int)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getText_MarkersCount()
	 * @model
	 * @generated
	 */
	int getMarkersCount();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.Text#getMarkersCount <em>Markers Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Markers Count</em>' attribute.
	 * @see #getMarkersCount()
	 * @generated
	 */
	void setMarkersCount(int value);

} // Text
