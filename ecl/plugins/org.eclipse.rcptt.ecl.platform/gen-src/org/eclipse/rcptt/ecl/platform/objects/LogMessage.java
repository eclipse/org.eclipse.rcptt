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
package org.eclipse.rcptt.ecl.platform.objects;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Log Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.LogMessage#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.LogMessage#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.LogMessage#getDateText <em>Date Text</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.platform.objects.LogMessage#getPluginId <em>Plugin Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.platform.objects.ObjectsPackage#getLogMessage()
 * @model
 * @generated
 */
public interface LogMessage extends EObject {
	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see #setSeverity(String)
	 * @see org.eclipse.rcptt.ecl.platform.objects.ObjectsPackage#getLogMessage_Severity()
	 * @model
	 * @generated
	 */
	String getSeverity();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.platform.objects.LogMessage#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(String value);

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
	 * @see org.eclipse.rcptt.ecl.platform.objects.ObjectsPackage#getLogMessage_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.platform.objects.LogMessage#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Date Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Text</em>' attribute.
	 * @see #setDateText(String)
	 * @see org.eclipse.rcptt.ecl.platform.objects.ObjectsPackage#getLogMessage_DateText()
	 * @model
	 * @generated
	 */
	String getDateText();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.platform.objects.LogMessage#getDateText <em>Date Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Text</em>' attribute.
	 * @see #getDateText()
	 * @generated
	 */
	void setDateText(String value);

	/**
	 * Returns the value of the '<em><b>Plugin Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin Id</em>' attribute.
	 * @see #setPluginId(String)
	 * @see org.eclipse.rcptt.ecl.platform.objects.ObjectsPackage#getLogMessage_PluginId()
	 * @model
	 * @generated
	 */
	String getPluginId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.platform.objects.LogMessage#getPluginId <em>Plugin Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin Id</em>' attribute.
	 * @see #getPluginId()
	 * @generated
	 */
	void setPluginId(String value);

} // LogMessage
