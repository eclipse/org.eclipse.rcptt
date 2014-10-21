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

import org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry;
import org.eclipse.rcptt.tesla.core.ui.Text;
import org.eclipse.rcptt.tesla.core.ui.TextPosition;
import org.eclipse.rcptt.tesla.core.ui.Tree;
import org.eclipse.rcptt.tesla.core.ui.TreeItem;
import org.eclipse.rcptt.tesla.core.ui.UiPackage;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.rcptt.tesla.core.ui.Marker;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TextImpl#getTooltip <em>Tooltip</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TextImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TextImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TextImpl#getRawValue <em>Raw Value</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TextImpl#getStyleRanges <em>Style Ranges</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TextImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TextImpl#getStyles <em>Styles</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TextImpl#getCaretPosition <em>Caret Position</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TextImpl#getStyleAtCaret <em>Style At Caret</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TextImpl#getMarkers <em>Markers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextImpl extends ControlImpl implements Text {
	/**
	 * The default value of the '{@link #getTooltip() <em>Tooltip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTooltip()
	 * @generated
	 * @ordered
	 */
	protected static final String TOOLTIP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTooltip() <em>Tooltip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTooltip()
	 * @generated
	 * @ordered
	 */
	protected String tooltip = TOOLTIP_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean READ_ONLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected boolean readOnly = READ_ONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getRawValue() <em>Raw Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawValue()
	 * @generated
	 * @ordered
	 */
	protected static final String RAW_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRawValue() <em>Raw Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawValue()
	 * @generated
	 * @ordered
	 */
	protected String rawValue = RAW_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStyleRanges() <em>Style Ranges</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyleRanges()
	 * @generated
	 * @ordered
	 */
	protected EList<String> styleRanges;

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
	 * The cached value of the '{@link #getStyles() <em>Styles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyles()
	 * @generated
	 * @ordered
	 */
	protected EList<StyleRangeEntry> styles;

	/**
	 * The cached value of the '{@link #getCaretPosition() <em>Caret Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaretPosition()
	 * @generated
	 * @ordered
	 */
	protected TextPosition caretPosition;

	/**
	 * The cached value of the '{@link #getStyleAtCaret() <em>Style At Caret</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyleAtCaret()
	 * @generated
	 * @ordered
	 */
	protected StyleRangeEntry styleAtCaret;

	/**
	 * The cached value of the '{@link #getMarkers() <em>Markers</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarkers()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EList<Marker>> markers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiPackage.Literals.TEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTooltip() {
		return tooltip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTooltip(String newTooltip) {
		String oldTooltip = tooltip;
		tooltip = newTooltip;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TEXT__TOOLTIP, oldTooltip, tooltip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TEXT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadOnly(boolean newReadOnly) {
		boolean oldReadOnly = readOnly;
		readOnly = newReadOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TEXT__READ_ONLY, oldReadOnly, readOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRawValue() {
		return rawValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawValue(String newRawValue) {
		String oldRawValue = rawValue;
		rawValue = newRawValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TEXT__RAW_VALUE, oldRawValue, rawValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getStyleRanges() {
		if (styleRanges == null) {
			styleRanges = new EDataTypeUniqueEList<String>(String.class, this, UiPackage.TEXT__STYLE_RANGES);
		}
		return styleRanges;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TEXT__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StyleRangeEntry> getStyles() {
		if (styles == null) {
			styles = new EObjectContainmentEList<StyleRangeEntry>(StyleRangeEntry.class, this, UiPackage.TEXT__STYLES);
		}
		return styles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextPosition getCaretPosition() {
		if (caretPosition != null && caretPosition.eIsProxy()) {
			InternalEObject oldCaretPosition = (InternalEObject)caretPosition;
			caretPosition = (TextPosition)eResolveProxy(oldCaretPosition);
			if (caretPosition != oldCaretPosition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UiPackage.TEXT__CARET_POSITION, oldCaretPosition, caretPosition));
			}
		}
		return caretPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextPosition basicGetCaretPosition() {
		return caretPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCaretPosition(TextPosition newCaretPosition) {
		TextPosition oldCaretPosition = caretPosition;
		caretPosition = newCaretPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TEXT__CARET_POSITION, oldCaretPosition, caretPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StyleRangeEntry getStyleAtCaret() {
		return styleAtCaret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStyleAtCaret(StyleRangeEntry newStyleAtCaret, NotificationChain msgs) {
		StyleRangeEntry oldStyleAtCaret = styleAtCaret;
		styleAtCaret = newStyleAtCaret;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.TEXT__STYLE_AT_CARET, oldStyleAtCaret, newStyleAtCaret);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStyleAtCaret(StyleRangeEntry newStyleAtCaret) {
		if (newStyleAtCaret != styleAtCaret) {
			NotificationChain msgs = null;
			if (styleAtCaret != null)
				msgs = ((InternalEObject)styleAtCaret).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.TEXT__STYLE_AT_CARET, null, msgs);
			if (newStyleAtCaret != null)
				msgs = ((InternalEObject)newStyleAtCaret).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.TEXT__STYLE_AT_CARET, null, msgs);
			msgs = basicSetStyleAtCaret(newStyleAtCaret, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TEXT__STYLE_AT_CARET, newStyleAtCaret, newStyleAtCaret));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EList<Marker>> getMarkers() {
		if (markers == null) {
			markers = new EcoreEMap<String,EList<Marker>>(UiPackage.Literals.LINE_MARKERS_VALUE, LineMarkersValueImpl.class, this, UiPackage.TEXT__MARKERS);
		}
		return markers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UiPackage.TEXT__STYLES:
				return ((InternalEList<?>)getStyles()).basicRemove(otherEnd, msgs);
			case UiPackage.TEXT__STYLE_AT_CARET:
				return basicSetStyleAtCaret(null, msgs);
			case UiPackage.TEXT__MARKERS:
				return ((InternalEList<?>)getMarkers()).basicRemove(otherEnd, msgs);
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
			case UiPackage.TEXT__TOOLTIP:
				return getTooltip();
			case UiPackage.TEXT__VALUE:
				return getValue();
			case UiPackage.TEXT__READ_ONLY:
				return isReadOnly();
			case UiPackage.TEXT__RAW_VALUE:
				return getRawValue();
			case UiPackage.TEXT__STYLE_RANGES:
				return getStyleRanges();
			case UiPackage.TEXT__TEXT:
				return getText();
			case UiPackage.TEXT__STYLES:
				return getStyles();
			case UiPackage.TEXT__CARET_POSITION:
				if (resolve) return getCaretPosition();
				return basicGetCaretPosition();
			case UiPackage.TEXT__STYLE_AT_CARET:
				return getStyleAtCaret();
			case UiPackage.TEXT__MARKERS:
				if (coreType) return getMarkers();
				else return getMarkers().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UiPackage.TEXT__TOOLTIP:
				setTooltip((String)newValue);
				return;
			case UiPackage.TEXT__VALUE:
				setValue((String)newValue);
				return;
			case UiPackage.TEXT__READ_ONLY:
				setReadOnly((Boolean)newValue);
				return;
			case UiPackage.TEXT__RAW_VALUE:
				setRawValue((String)newValue);
				return;
			case UiPackage.TEXT__STYLE_RANGES:
				getStyleRanges().clear();
				getStyleRanges().addAll((Collection<? extends String>)newValue);
				return;
			case UiPackage.TEXT__TEXT:
				setText((String)newValue);
				return;
			case UiPackage.TEXT__STYLES:
				getStyles().clear();
				getStyles().addAll((Collection<? extends StyleRangeEntry>)newValue);
				return;
			case UiPackage.TEXT__CARET_POSITION:
				setCaretPosition((TextPosition)newValue);
				return;
			case UiPackage.TEXT__STYLE_AT_CARET:
				setStyleAtCaret((StyleRangeEntry)newValue);
				return;
			case UiPackage.TEXT__MARKERS:
				((EStructuralFeature.Setting)getMarkers()).set(newValue);
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
			case UiPackage.TEXT__TOOLTIP:
				setTooltip(TOOLTIP_EDEFAULT);
				return;
			case UiPackage.TEXT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case UiPackage.TEXT__READ_ONLY:
				setReadOnly(READ_ONLY_EDEFAULT);
				return;
			case UiPackage.TEXT__RAW_VALUE:
				setRawValue(RAW_VALUE_EDEFAULT);
				return;
			case UiPackage.TEXT__STYLE_RANGES:
				getStyleRanges().clear();
				return;
			case UiPackage.TEXT__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case UiPackage.TEXT__STYLES:
				getStyles().clear();
				return;
			case UiPackage.TEXT__CARET_POSITION:
				setCaretPosition((TextPosition)null);
				return;
			case UiPackage.TEXT__STYLE_AT_CARET:
				setStyleAtCaret((StyleRangeEntry)null);
				return;
			case UiPackage.TEXT__MARKERS:
				getMarkers().clear();
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
			case UiPackage.TEXT__TOOLTIP:
				return TOOLTIP_EDEFAULT == null ? tooltip != null : !TOOLTIP_EDEFAULT.equals(tooltip);
			case UiPackage.TEXT__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case UiPackage.TEXT__READ_ONLY:
				return readOnly != READ_ONLY_EDEFAULT;
			case UiPackage.TEXT__RAW_VALUE:
				return RAW_VALUE_EDEFAULT == null ? rawValue != null : !RAW_VALUE_EDEFAULT.equals(rawValue);
			case UiPackage.TEXT__STYLE_RANGES:
				return styleRanges != null && !styleRanges.isEmpty();
			case UiPackage.TEXT__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case UiPackage.TEXT__STYLES:
				return styles != null && !styles.isEmpty();
			case UiPackage.TEXT__CARET_POSITION:
				return caretPosition != null;
			case UiPackage.TEXT__STYLE_AT_CARET:
				return styleAtCaret != null;
			case UiPackage.TEXT__MARKERS:
				return markers != null && !markers.isEmpty();
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
		result.append(" (tooltip: ");
		result.append(tooltip);
		result.append(", value: ");
		result.append(value);
		result.append(", readOnly: ");
		result.append(readOnly);
		result.append(", rawValue: ");
		result.append(rawValue);
		result.append(", styleRanges: ");
		result.append(styleRanges);
		result.append(", text: ");
		result.append(text);
		result.append(')');
		return result.toString();
	}

} //TextImpl
