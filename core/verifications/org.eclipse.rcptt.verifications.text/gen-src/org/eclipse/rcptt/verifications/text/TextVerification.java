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
package org.eclipse.rcptt.verifications.text;

import org.eclipse.rcptt.core.scenario.WidgetVerification;
import org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Verification</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.verifications.text.TextVerification#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.text.TextVerification#getStyles <em>Styles</em>}</li>
 *   <li>{@link org.eclipse.rcptt.verifications.text.TextVerification#isIgnoreStyling <em>Ignore Styling</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.verifications.text.TextPackage#getTextVerification()
 * @model
 * @generated
 */
public interface TextVerification extends WidgetVerification {

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.rcptt.verifications.text.TextPackage#getTextVerification_Text()
	 * @model required="true"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.text.TextVerification#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @see org.eclipse.rcptt.verifications.text.TextPackage#getTextVerification_Styles()
	 * @model containment="true"
	 * @generated
	 */
	EList<StyleRangeEntry> getStyles();

	/**
	 * Returns the value of the '<em><b>Ignore Styling</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ignore Styling</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignore Styling</em>' attribute.
	 * @see #setIgnoreStyling(boolean)
	 * @see org.eclipse.rcptt.verifications.text.TextPackage#getTextVerification_IgnoreStyling()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIgnoreStyling();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.verifications.text.TextVerification#isIgnoreStyling <em>Ignore Styling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ignore Styling</em>' attribute.
	 * @see #isIgnoreStyling()
	 * @generated
	 */
	void setIgnoreStyling(boolean value);
} // TextVerification
