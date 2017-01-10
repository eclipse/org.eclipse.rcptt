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
 * A representation of the model object '<em><b>Style Range Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getLength <em>Length</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getFontStyle <em>Font Style</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getFont <em>Font</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getUnderline <em>Underline</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getUnderlineColor <em>Underline Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStrikeout <em>Strikeout</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStrikeoutColor <em>Strikeout Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getBorderStyle <em>Border Style</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getBorderColor <em>Border Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getRise <em>Rise</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStartPos <em>Start Pos</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getEndPos <em>End Pos</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry()
 * @model
 * @generated
 */
public interface StyleRangeEntry extends Widget {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(int)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_Start()
	 * @model
	 * @generated
	 */
	int getStart();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(int value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(int)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_Length()
	 * @model
	 * @generated
	 */
	int getLength();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(int value);

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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Font Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Style</em>' attribute.
	 * @see #setFontStyle(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_FontStyle()
	 * @model
	 * @generated
	 */
	String getFontStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getFontStyle <em>Font Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Style</em>' attribute.
	 * @see #getFontStyle()
	 * @generated
	 */
	void setFontStyle(String value);

	/**
	 * Returns the value of the '<em><b>Font</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font</em>' attribute.
	 * @see #setFont(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_Font()
	 * @model
	 * @generated
	 */
	String getFont();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getFont <em>Font</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font</em>' attribute.
	 * @see #getFont()
	 * @generated
	 */
	void setFont(String value);

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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_ForegroundColor()
	 * @model containment="true"
	 * @generated
	 */
	Color getForegroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getForegroundColor <em>Foreground Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreground Color</em>' containment reference.
	 * @see #getForegroundColor()
	 * @generated
	 */
	void setForegroundColor(Color value);

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
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_BackgroundColor()
	 * @model containment="true"
	 * @generated
	 */
	Color getBackgroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getBackgroundColor <em>Background Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Color</em>' containment reference.
	 * @see #getBackgroundColor()
	 * @generated
	 */
	void setBackgroundColor(Color value);

	/**
	 * Returns the value of the '<em><b>Underline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Underline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Underline</em>' attribute.
	 * @see #setUnderline(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_Underline()
	 * @model
	 * @generated
	 */
	String getUnderline();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getUnderline <em>Underline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Underline</em>' attribute.
	 * @see #getUnderline()
	 * @generated
	 */
	void setUnderline(String value);

	/**
	 * Returns the value of the '<em><b>Underline Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Underline Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Underline Color</em>' containment reference.
	 * @see #setUnderlineColor(Color)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_UnderlineColor()
	 * @model containment="true"
	 * @generated
	 */
	Color getUnderlineColor();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getUnderlineColor <em>Underline Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Underline Color</em>' containment reference.
	 * @see #getUnderlineColor()
	 * @generated
	 */
	void setUnderlineColor(Color value);

	/**
	 * Returns the value of the '<em><b>Strikeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strikeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strikeout</em>' attribute.
	 * @see #setStrikeout(Boolean)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_Strikeout()
	 * @model
	 * @generated
	 */
	Boolean getStrikeout();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStrikeout <em>Strikeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strikeout</em>' attribute.
	 * @see #getStrikeout()
	 * @generated
	 */
	void setStrikeout(Boolean value);

	/**
	 * Returns the value of the '<em><b>Strikeout Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strikeout Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strikeout Color</em>' containment reference.
	 * @see #setStrikeoutColor(Color)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_StrikeoutColor()
	 * @model containment="true"
	 * @generated
	 */
	Color getStrikeoutColor();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStrikeoutColor <em>Strikeout Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strikeout Color</em>' containment reference.
	 * @see #getStrikeoutColor()
	 * @generated
	 */
	void setStrikeoutColor(Color value);

	/**
	 * Returns the value of the '<em><b>Border Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Border Style</em>' attribute.
	 * @see #setBorderStyle(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_BorderStyle()
	 * @model
	 * @generated
	 */
	String getBorderStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getBorderStyle <em>Border Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border Style</em>' attribute.
	 * @see #getBorderStyle()
	 * @generated
	 */
	void setBorderStyle(String value);

	/**
	 * Returns the value of the '<em><b>Border Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Border Color</em>' containment reference.
	 * @see #setBorderColor(Color)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_BorderColor()
	 * @model containment="true"
	 * @generated
	 */
	Color getBorderColor();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getBorderColor <em>Border Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border Color</em>' containment reference.
	 * @see #getBorderColor()
	 * @generated
	 */
	void setBorderColor(Color value);

	/**
	 * Returns the value of the '<em><b>Rise</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rise</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rise</em>' attribute.
	 * @see #setRise(Integer)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_Rise()
	 * @model
	 * @generated
	 */
	Integer getRise();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getRise <em>Rise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rise</em>' attribute.
	 * @see #getRise()
	 * @generated
	 */
	void setRise(Integer value);

	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metrics</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metrics</em>' attribute.
	 * @see #setMetrics(String)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_Metrics()
	 * @model
	 * @generated
	 */
	String getMetrics();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getMetrics <em>Metrics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metrics</em>' attribute.
	 * @see #getMetrics()
	 * @generated
	 */
	void setMetrics(String value);

	/**
	 * Returns the value of the '<em><b>Start Pos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Pos</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Pos</em>' containment reference.
	 * @see #setStartPos(TextPosition)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_StartPos()
	 * @model containment="true"
	 * @generated
	 */
	TextPosition getStartPos();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStartPos <em>Start Pos</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Pos</em>' containment reference.
	 * @see #getStartPos()
	 * @generated
	 */
	void setStartPos(TextPosition value);

	/**
	 * Returns the value of the '<em><b>End Pos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Pos</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Pos</em>' containment reference.
	 * @see #setEndPos(TextPosition)
	 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage#getStyleRangeEntry_EndPos()
	 * @model containment="true"
	 * @generated
	 */
	TextPosition getEndPos();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getEndPos <em>End Pos</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Pos</em>' containment reference.
	 * @see #getEndPos()
	 * @generated
	 */
	void setEndPos(TextPosition value);

} // StyleRangeEntry
