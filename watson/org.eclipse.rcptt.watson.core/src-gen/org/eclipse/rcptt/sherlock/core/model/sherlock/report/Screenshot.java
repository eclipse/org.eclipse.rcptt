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
package org.eclipse.rcptt.sherlock.core.model.sherlock.report;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Screenshot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot#getData <em>Data</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot#getMessage <em>Message</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportPackage#getScreenshot()
 * @model
 * @generated
 */
public interface Screenshot extends EObject {
	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(byte[])
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportPackage#getScreenshot_Data()
	 * @model
	 * @generated
	 */
	byte[] getData();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(byte[] value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.ScreenshotKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ScreenshotKind
	 * @see #setKind(ScreenshotKind)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportPackage#getScreenshot_Kind()
	 * @model
	 * @generated
	 */
	ScreenshotKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ScreenshotKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ScreenshotKind value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportPackage#getScreenshot_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

} // Screenshot
