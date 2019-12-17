/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
/**
 */
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rap Download File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.RapDownloadFile#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.RapDownloadFile#getHandler <em>Handler</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.RapDownloadFile#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getRapDownloadFile()
 * @model
 * @generated
 */
public interface RapDownloadFile extends Command {
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
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getRapDownloadFile_Url()
	 * @model required="true"
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.RapDownloadFile#getUrl <em>Url</em>}' attribute.
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
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getRapDownloadFile_Handler()
	 * @model required="true"
	 * @generated
	 */
	String getHandler();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.RapDownloadFile#getHandler <em>Handler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handler</em>' attribute.
	 * @see #getHandler()
	 * @generated
	 */
	void setHandler(String value);

	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getRapDownloadFile_Content()
	 * @model
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.core.protocol.RapDownloadFile#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

} // RapDownloadFile
