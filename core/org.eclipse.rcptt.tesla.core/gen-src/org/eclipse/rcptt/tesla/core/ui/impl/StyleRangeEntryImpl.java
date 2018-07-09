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
package org.eclipse.rcptt.tesla.core.ui.impl;

import org.eclipse.rcptt.tesla.core.ui.Color;
import org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry;
import org.eclipse.rcptt.tesla.core.ui.TextPosition;
import org.eclipse.rcptt.tesla.core.ui.UiPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Style Range Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getLength <em>Length</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getFontStyle <em>Font Style</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getFont <em>Font</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getUnderline <em>Underline</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getUnderlineColor <em>Underline Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getStrikeout <em>Strikeout</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getStrikeoutColor <em>Strikeout Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getBorderStyle <em>Border Style</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getBorderColor <em>Border Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getRise <em>Rise</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getStartPos <em>Start Pos</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl#getEndPos <em>End Pos</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StyleRangeEntryImpl extends WidgetImpl implements StyleRangeEntry {
	/**
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final int START_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected int start = START_EDEFAULT;

	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final int LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected int length = LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFontStyle() <em>Font Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontStyle()
	 * @generated
	 * @ordered
	 */
	protected static final String FONT_STYLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFontStyle() <em>Font Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontStyle()
	 * @generated
	 * @ordered
	 */
	protected String fontStyle = FONT_STYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFont() <em>Font</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFont()
	 * @generated
	 * @ordered
	 */
	protected static final String FONT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFont() <em>Font</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFont()
	 * @generated
	 * @ordered
	 */
	protected String font = FONT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForegroundColor()
	 * @generated
	 * @ordered
	 */
	protected Color foregroundColor;

	/**
	 * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundColor()
	 * @generated
	 * @ordered
	 */
	protected Color backgroundColor;

	/**
	 * The default value of the '{@link #getUnderline() <em>Underline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnderline()
	 * @generated
	 * @ordered
	 */
	protected static final String UNDERLINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnderline() <em>Underline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnderline()
	 * @generated
	 * @ordered
	 */
	protected String underline = UNDERLINE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUnderlineColor() <em>Underline Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnderlineColor()
	 * @generated
	 * @ordered
	 */
	protected Color underlineColor;

	/**
	 * The default value of the '{@link #getStrikeout() <em>Strikeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrikeout()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean STRIKEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStrikeout() <em>Strikeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrikeout()
	 * @generated
	 * @ordered
	 */
	protected Boolean strikeout = STRIKEOUT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStrikeoutColor() <em>Strikeout Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrikeoutColor()
	 * @generated
	 * @ordered
	 */
	protected Color strikeoutColor;

	/**
	 * The default value of the '{@link #getBorderStyle() <em>Border Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderStyle()
	 * @generated
	 * @ordered
	 */
	protected static final String BORDER_STYLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBorderStyle() <em>Border Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderStyle()
	 * @generated
	 * @ordered
	 */
	protected String borderStyle = BORDER_STYLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBorderColor() <em>Border Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderColor()
	 * @generated
	 * @ordered
	 */
	protected Color borderColor;

	/**
	 * The default value of the '{@link #getRise() <em>Rise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRise()
	 * @generated
	 * @ordered
	 */
	protected static final Integer RISE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRise() <em>Rise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRise()
	 * @generated
	 * @ordered
	 */
	protected Integer rise = RISE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMetrics() <em>Metrics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected static final String METRICS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetrics() <em>Metrics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected String metrics = METRICS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStartPos() <em>Start Pos</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartPos()
	 * @generated
	 * @ordered
	 */
	protected TextPosition startPos;

	/**
	 * The cached value of the '{@link #getEndPos() <em>End Pos</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndPos()
	 * @generated
	 * @ordered
	 */
	protected TextPosition endPos;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StyleRangeEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiPackage.Literals.STYLE_RANGE_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(int newStart) {
		int oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLength(int newLength) {
		int oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFontStyle() {
		return fontStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFontStyle(String newFontStyle) {
		String oldFontStyle = fontStyle;
		fontStyle = newFontStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__FONT_STYLE, oldFontStyle, fontStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFont() {
		return font;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFont(String newFont) {
		String oldFont = font;
		font = newFont;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__FONT, oldFont, font));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getForegroundColor() {
		return foregroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForegroundColor(Color newForegroundColor, NotificationChain msgs) {
		Color oldForegroundColor = foregroundColor;
		foregroundColor = newForegroundColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__FOREGROUND_COLOR, oldForegroundColor, newForegroundColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForegroundColor(Color newForegroundColor) {
		if (newForegroundColor != foregroundColor) {
			NotificationChain msgs = null;
			if (foregroundColor != null)
				msgs = ((InternalEObject)foregroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.STYLE_RANGE_ENTRY__FOREGROUND_COLOR, null, msgs);
			if (newForegroundColor != null)
				msgs = ((InternalEObject)newForegroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.STYLE_RANGE_ENTRY__FOREGROUND_COLOR, null, msgs);
			msgs = basicSetForegroundColor(newForegroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__FOREGROUND_COLOR, newForegroundColor, newForegroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBackgroundColor(Color newBackgroundColor, NotificationChain msgs) {
		Color oldBackgroundColor = backgroundColor;
		backgroundColor = newBackgroundColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__BACKGROUND_COLOR, oldBackgroundColor, newBackgroundColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackgroundColor(Color newBackgroundColor) {
		if (newBackgroundColor != backgroundColor) {
			NotificationChain msgs = null;
			if (backgroundColor != null)
				msgs = ((InternalEObject)backgroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.STYLE_RANGE_ENTRY__BACKGROUND_COLOR, null, msgs);
			if (newBackgroundColor != null)
				msgs = ((InternalEObject)newBackgroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.STYLE_RANGE_ENTRY__BACKGROUND_COLOR, null, msgs);
			msgs = basicSetBackgroundColor(newBackgroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__BACKGROUND_COLOR, newBackgroundColor, newBackgroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnderline() {
		return underline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnderline(String newUnderline) {
		String oldUnderline = underline;
		underline = newUnderline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__UNDERLINE, oldUnderline, underline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getUnderlineColor() {
		return underlineColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnderlineColor(Color newUnderlineColor, NotificationChain msgs) {
		Color oldUnderlineColor = underlineColor;
		underlineColor = newUnderlineColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__UNDERLINE_COLOR, oldUnderlineColor, newUnderlineColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnderlineColor(Color newUnderlineColor) {
		if (newUnderlineColor != underlineColor) {
			NotificationChain msgs = null;
			if (underlineColor != null)
				msgs = ((InternalEObject)underlineColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.STYLE_RANGE_ENTRY__UNDERLINE_COLOR, null, msgs);
			if (newUnderlineColor != null)
				msgs = ((InternalEObject)newUnderlineColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.STYLE_RANGE_ENTRY__UNDERLINE_COLOR, null, msgs);
			msgs = basicSetUnderlineColor(newUnderlineColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__UNDERLINE_COLOR, newUnderlineColor, newUnderlineColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getStrikeout() {
		return strikeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStrikeout(Boolean newStrikeout) {
		Boolean oldStrikeout = strikeout;
		strikeout = newStrikeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__STRIKEOUT, oldStrikeout, strikeout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getStrikeoutColor() {
		return strikeoutColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStrikeoutColor(Color newStrikeoutColor, NotificationChain msgs) {
		Color oldStrikeoutColor = strikeoutColor;
		strikeoutColor = newStrikeoutColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__STRIKEOUT_COLOR, oldStrikeoutColor, newStrikeoutColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStrikeoutColor(Color newStrikeoutColor) {
		if (newStrikeoutColor != strikeoutColor) {
			NotificationChain msgs = null;
			if (strikeoutColor != null)
				msgs = ((InternalEObject)strikeoutColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.STYLE_RANGE_ENTRY__STRIKEOUT_COLOR, null, msgs);
			if (newStrikeoutColor != null)
				msgs = ((InternalEObject)newStrikeoutColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.STYLE_RANGE_ENTRY__STRIKEOUT_COLOR, null, msgs);
			msgs = basicSetStrikeoutColor(newStrikeoutColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__STRIKEOUT_COLOR, newStrikeoutColor, newStrikeoutColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBorderStyle() {
		return borderStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorderStyle(String newBorderStyle) {
		String oldBorderStyle = borderStyle;
		borderStyle = newBorderStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__BORDER_STYLE, oldBorderStyle, borderStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getBorderColor() {
		return borderColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBorderColor(Color newBorderColor, NotificationChain msgs) {
		Color oldBorderColor = borderColor;
		borderColor = newBorderColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__BORDER_COLOR, oldBorderColor, newBorderColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorderColor(Color newBorderColor) {
		if (newBorderColor != borderColor) {
			NotificationChain msgs = null;
			if (borderColor != null)
				msgs = ((InternalEObject)borderColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.STYLE_RANGE_ENTRY__BORDER_COLOR, null, msgs);
			if (newBorderColor != null)
				msgs = ((InternalEObject)newBorderColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.STYLE_RANGE_ENTRY__BORDER_COLOR, null, msgs);
			msgs = basicSetBorderColor(newBorderColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__BORDER_COLOR, newBorderColor, newBorderColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getRise() {
		return rise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRise(Integer newRise) {
		Integer oldRise = rise;
		rise = newRise;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__RISE, oldRise, rise));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetrics() {
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetrics(String newMetrics) {
		String oldMetrics = metrics;
		metrics = newMetrics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__METRICS, oldMetrics, metrics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextPosition getStartPos() {
		return startPos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartPos(TextPosition newStartPos, NotificationChain msgs) {
		TextPosition oldStartPos = startPos;
		startPos = newStartPos;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__START_POS, oldStartPos, newStartPos);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartPos(TextPosition newStartPos) {
		if (newStartPos != startPos) {
			NotificationChain msgs = null;
			if (startPos != null)
				msgs = ((InternalEObject)startPos).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.STYLE_RANGE_ENTRY__START_POS, null, msgs);
			if (newStartPos != null)
				msgs = ((InternalEObject)newStartPos).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.STYLE_RANGE_ENTRY__START_POS, null, msgs);
			msgs = basicSetStartPos(newStartPos, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__START_POS, newStartPos, newStartPos));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextPosition getEndPos() {
		return endPos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndPos(TextPosition newEndPos, NotificationChain msgs) {
		TextPosition oldEndPos = endPos;
		endPos = newEndPos;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__END_POS, oldEndPos, newEndPos);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndPos(TextPosition newEndPos) {
		if (newEndPos != endPos) {
			NotificationChain msgs = null;
			if (endPos != null)
				msgs = ((InternalEObject)endPos).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.STYLE_RANGE_ENTRY__END_POS, null, msgs);
			if (newEndPos != null)
				msgs = ((InternalEObject)newEndPos).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.STYLE_RANGE_ENTRY__END_POS, null, msgs);
			msgs = basicSetEndPos(newEndPos, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.STYLE_RANGE_ENTRY__END_POS, newEndPos, newEndPos));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UiPackage.STYLE_RANGE_ENTRY__FOREGROUND_COLOR:
				return basicSetForegroundColor(null, msgs);
			case UiPackage.STYLE_RANGE_ENTRY__BACKGROUND_COLOR:
				return basicSetBackgroundColor(null, msgs);
			case UiPackage.STYLE_RANGE_ENTRY__UNDERLINE_COLOR:
				return basicSetUnderlineColor(null, msgs);
			case UiPackage.STYLE_RANGE_ENTRY__STRIKEOUT_COLOR:
				return basicSetStrikeoutColor(null, msgs);
			case UiPackage.STYLE_RANGE_ENTRY__BORDER_COLOR:
				return basicSetBorderColor(null, msgs);
			case UiPackage.STYLE_RANGE_ENTRY__START_POS:
				return basicSetStartPos(null, msgs);
			case UiPackage.STYLE_RANGE_ENTRY__END_POS:
				return basicSetEndPos(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UiPackage.STYLE_RANGE_ENTRY__START:
				return getStart();
			case UiPackage.STYLE_RANGE_ENTRY__LENGTH:
				return getLength();
			case UiPackage.STYLE_RANGE_ENTRY__TEXT:
				return getText();
			case UiPackage.STYLE_RANGE_ENTRY__FONT_STYLE:
				return getFontStyle();
			case UiPackage.STYLE_RANGE_ENTRY__FONT:
				return getFont();
			case UiPackage.STYLE_RANGE_ENTRY__FOREGROUND_COLOR:
				return getForegroundColor();
			case UiPackage.STYLE_RANGE_ENTRY__BACKGROUND_COLOR:
				return getBackgroundColor();
			case UiPackage.STYLE_RANGE_ENTRY__UNDERLINE:
				return getUnderline();
			case UiPackage.STYLE_RANGE_ENTRY__UNDERLINE_COLOR:
				return getUnderlineColor();
			case UiPackage.STYLE_RANGE_ENTRY__STRIKEOUT:
				return getStrikeout();
			case UiPackage.STYLE_RANGE_ENTRY__STRIKEOUT_COLOR:
				return getStrikeoutColor();
			case UiPackage.STYLE_RANGE_ENTRY__BORDER_STYLE:
				return getBorderStyle();
			case UiPackage.STYLE_RANGE_ENTRY__BORDER_COLOR:
				return getBorderColor();
			case UiPackage.STYLE_RANGE_ENTRY__RISE:
				return getRise();
			case UiPackage.STYLE_RANGE_ENTRY__METRICS:
				return getMetrics();
			case UiPackage.STYLE_RANGE_ENTRY__START_POS:
				return getStartPos();
			case UiPackage.STYLE_RANGE_ENTRY__END_POS:
				return getEndPos();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UiPackage.STYLE_RANGE_ENTRY__START:
				setStart((Integer)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__LENGTH:
				setLength((Integer)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__TEXT:
				setText((String)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__FONT_STYLE:
				setFontStyle((String)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__FONT:
				setFont((String)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__FOREGROUND_COLOR:
				setForegroundColor((Color)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__BACKGROUND_COLOR:
				setBackgroundColor((Color)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__UNDERLINE:
				setUnderline((String)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__UNDERLINE_COLOR:
				setUnderlineColor((Color)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__STRIKEOUT:
				setStrikeout((Boolean)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__STRIKEOUT_COLOR:
				setStrikeoutColor((Color)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__BORDER_STYLE:
				setBorderStyle((String)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__BORDER_COLOR:
				setBorderColor((Color)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__RISE:
				setRise((Integer)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__METRICS:
				setMetrics((String)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__START_POS:
				setStartPos((TextPosition)newValue);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__END_POS:
				setEndPos((TextPosition)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UiPackage.STYLE_RANGE_ENTRY__START:
				setStart(START_EDEFAULT);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__FONT_STYLE:
				setFontStyle(FONT_STYLE_EDEFAULT);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__FONT:
				setFont(FONT_EDEFAULT);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__FOREGROUND_COLOR:
				setForegroundColor((Color)null);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__BACKGROUND_COLOR:
				setBackgroundColor((Color)null);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__UNDERLINE:
				setUnderline(UNDERLINE_EDEFAULT);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__UNDERLINE_COLOR:
				setUnderlineColor((Color)null);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__STRIKEOUT:
				setStrikeout(STRIKEOUT_EDEFAULT);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__STRIKEOUT_COLOR:
				setStrikeoutColor((Color)null);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__BORDER_STYLE:
				setBorderStyle(BORDER_STYLE_EDEFAULT);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__BORDER_COLOR:
				setBorderColor((Color)null);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__RISE:
				setRise(RISE_EDEFAULT);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__METRICS:
				setMetrics(METRICS_EDEFAULT);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__START_POS:
				setStartPos((TextPosition)null);
				return;
			case UiPackage.STYLE_RANGE_ENTRY__END_POS:
				setEndPos((TextPosition)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UiPackage.STYLE_RANGE_ENTRY__START:
				return start != START_EDEFAULT;
			case UiPackage.STYLE_RANGE_ENTRY__LENGTH:
				return length != LENGTH_EDEFAULT;
			case UiPackage.STYLE_RANGE_ENTRY__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case UiPackage.STYLE_RANGE_ENTRY__FONT_STYLE:
				return FONT_STYLE_EDEFAULT == null ? fontStyle != null : !FONT_STYLE_EDEFAULT.equals(fontStyle);
			case UiPackage.STYLE_RANGE_ENTRY__FONT:
				return FONT_EDEFAULT == null ? font != null : !FONT_EDEFAULT.equals(font);
			case UiPackage.STYLE_RANGE_ENTRY__FOREGROUND_COLOR:
				return foregroundColor != null;
			case UiPackage.STYLE_RANGE_ENTRY__BACKGROUND_COLOR:
				return backgroundColor != null;
			case UiPackage.STYLE_RANGE_ENTRY__UNDERLINE:
				return UNDERLINE_EDEFAULT == null ? underline != null : !UNDERLINE_EDEFAULT.equals(underline);
			case UiPackage.STYLE_RANGE_ENTRY__UNDERLINE_COLOR:
				return underlineColor != null;
			case UiPackage.STYLE_RANGE_ENTRY__STRIKEOUT:
				return STRIKEOUT_EDEFAULT == null ? strikeout != null : !STRIKEOUT_EDEFAULT.equals(strikeout);
			case UiPackage.STYLE_RANGE_ENTRY__STRIKEOUT_COLOR:
				return strikeoutColor != null;
			case UiPackage.STYLE_RANGE_ENTRY__BORDER_STYLE:
				return BORDER_STYLE_EDEFAULT == null ? borderStyle != null : !BORDER_STYLE_EDEFAULT.equals(borderStyle);
			case UiPackage.STYLE_RANGE_ENTRY__BORDER_COLOR:
				return borderColor != null;
			case UiPackage.STYLE_RANGE_ENTRY__RISE:
				return RISE_EDEFAULT == null ? rise != null : !RISE_EDEFAULT.equals(rise);
			case UiPackage.STYLE_RANGE_ENTRY__METRICS:
				return METRICS_EDEFAULT == null ? metrics != null : !METRICS_EDEFAULT.equals(metrics);
			case UiPackage.STYLE_RANGE_ENTRY__START_POS:
				return startPos != null;
			case UiPackage.STYLE_RANGE_ENTRY__END_POS:
				return endPos != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (start: ");
		result.append(start);
		result.append(", length: ");
		result.append(length);
		result.append(", text: ");
		result.append(text);
		result.append(", fontStyle: ");
		result.append(fontStyle);
		result.append(", font: ");
		result.append(font);
		result.append(", underline: ");
		result.append(underline);
		result.append(", strikeout: ");
		result.append(strikeout);
		result.append(", borderStyle: ");
		result.append(borderStyle);
		result.append(", rise: ");
		result.append(rise);
		result.append(", metrics: ");
		result.append(metrics);
		result.append(')');
		return result.toString();
	}

} //StyleRangeEntryImpl
