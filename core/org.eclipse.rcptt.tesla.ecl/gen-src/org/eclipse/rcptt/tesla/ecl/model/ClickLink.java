/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Click Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ClickLink#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getClickLink()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Clicks on a link.' returns='value of <code>control</code> parameter' recorded='true' example='with [get-window Preferences] {\n    get-tree | select \"Ant/Editor\"\n    get-link \"See <a href=\\\"org.eclipse.ui.preferencePages.GeneralTextEditor\\\">\\\'Text Editors\\\'</a> for general text editor preferences and <a href=\\\"org.eclipse.ui.preferencePages.ColorsAndFonts\\\">\\\'Colors and Fonts\\\'</a> to configure the font.\" \n        | click-link \"org.eclipse.ui.preferencePages.GeneralTextEditor\"\n    get-button OK | click\n}'"
 * @generated
 */
public interface ClickLink extends ControlCommand {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' attribute.
	 * @see #setRef(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getClickLink_Ref()
	 * @model
	 * @generated
	 */
	String getRef();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ClickLink#getRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(String value);

} // ClickLink
