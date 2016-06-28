/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
/**
 */
package org.eclipse.rcptt.tesla.ecl.model;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Check Download Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.CheckDownloadResult#getContentOnBase64 <em>Content On Base64</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.CheckDownloadResult#getFileName <em>File Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getCheckDownloadResult()
 * @model
 * @generated
 */
public interface CheckDownloadResult extends Command {
	/**
	 * Returns the value of the '<em><b>Content On Base64</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content On Base64</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content On Base64</em>' attribute.
	 * @see #setContentOnBase64(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getCheckDownloadResult_ContentOnBase64()
	 * @model required="true"
	 * @generated
	 */
	String getContentOnBase64();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.CheckDownloadResult#getContentOnBase64 <em>Content On Base64</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content On Base64</em>' attribute.
	 * @see #getContentOnBase64()
	 * @generated
	 */
	void setContentOnBase64(String value);

	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see #setFileName(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getCheckDownloadResult_FileName()
	 * @model
	 * @generated
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.CheckDownloadResult#getFileName <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);

} // CheckDownloadResult
