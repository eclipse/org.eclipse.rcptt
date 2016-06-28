/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2016 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.rap.model;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verify Download File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.rap.model.VerifyDownloadFile#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.rap.model.VerifyDownloadFile#getHandler <em>Handler</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage#getVerifyDownloadFile()
 * @model
 * @generated
 */
public interface VerifyDownloadFile extends Command {
	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage#getVerifyDownloadFile_Url()
	 * @model required="true"
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.VerifyDownloadFile#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Returns the value of the '<em><b>Handler</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handler</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handler</em>' attribute.
	 * @see #setHandler(String)
	 * @see org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage#getVerifyDownloadFile_Handler()
	 * @model required="true"
	 * @generated
	 */
	String getHandler();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.rap.model.VerifyDownloadFile#getHandler <em>Handler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handler</em>' attribute.
	 * @see #getHandler()
	 * @generated
	 */
	void setHandler(String value);

} // VerifyDownloadFile
