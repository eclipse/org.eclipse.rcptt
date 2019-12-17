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
package org.eclipse.rcptt.verifications.text.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.rcptt.core.scenario.impl.WidgetVerificationImpl;
import org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry;
import org.eclipse.rcptt.verifications.text.TextPackage;
import org.eclipse.rcptt.verifications.text.TextVerification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.text.impl.TextVerificationImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.text.impl.TextVerificationImpl#getStyles <em>Styles</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.text.impl.TextVerificationImpl#isIgnoreStyling <em>Ignore Styling</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextVerificationImpl extends WidgetVerificationImpl implements TextVerification {
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
	 * The default value of the '{@link #isIgnoreStyling() <em>Ignore Styling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIgnoreStyling()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IGNORE_STYLING_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIgnoreStyling() <em>Ignore Styling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIgnoreStyling()
	 * @generated
	 * @ordered
	 */
	protected boolean ignoreStyling = IGNORE_STYLING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextVerificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TextPackage.Literals.TEXT_VERIFICATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TextPackage.TEXT_VERIFICATION__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StyleRangeEntry> getStyles() {
		if (styles == null) {
			styles = new EObjectContainmentEList<StyleRangeEntry>(StyleRangeEntry.class, this, TextPackage.TEXT_VERIFICATION__STYLES);
		}
		return styles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIgnoreStyling() {
		return ignoreStyling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIgnoreStyling(boolean newIgnoreStyling) {
		boolean oldIgnoreStyling = ignoreStyling;
		ignoreStyling = newIgnoreStyling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextPackage.TEXT_VERIFICATION__IGNORE_STYLING, oldIgnoreStyling, ignoreStyling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TextPackage.TEXT_VERIFICATION__STYLES:
				return ((InternalEList<?>)getStyles()).basicRemove(otherEnd, msgs);
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
			case TextPackage.TEXT_VERIFICATION__TEXT:
				return getText();
			case TextPackage.TEXT_VERIFICATION__STYLES:
				return getStyles();
			case TextPackage.TEXT_VERIFICATION__IGNORE_STYLING:
				return isIgnoreStyling();
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
			case TextPackage.TEXT_VERIFICATION__TEXT:
				setText((String)newValue);
				return;
			case TextPackage.TEXT_VERIFICATION__STYLES:
				getStyles().clear();
				getStyles().addAll((Collection<? extends StyleRangeEntry>)newValue);
				return;
			case TextPackage.TEXT_VERIFICATION__IGNORE_STYLING:
				setIgnoreStyling((Boolean)newValue);
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
			case TextPackage.TEXT_VERIFICATION__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case TextPackage.TEXT_VERIFICATION__STYLES:
				getStyles().clear();
				return;
			case TextPackage.TEXT_VERIFICATION__IGNORE_STYLING:
				setIgnoreStyling(IGNORE_STYLING_EDEFAULT);
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
			case TextPackage.TEXT_VERIFICATION__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case TextPackage.TEXT_VERIFICATION__STYLES:
				return styles != null && !styles.isEmpty();
			case TextPackage.TEXT_VERIFICATION__IGNORE_STYLING:
				return ignoreStyling != IGNORE_STYLING_EDEFAULT;
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
		result.append(" (text: ");
		result.append(text);
		result.append(", ignoreStyling: ");
		result.append(ignoreStyling);
		result.append(')');
		return result.toString();
	}

} //TextVerificationImpl
