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
package org.eclipse.rcptt.sherlock.core.model.sherlock.report;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Snaphot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot#getTime <em>Time</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportPackage#getSnaphot()
 * @model
 * @generated
 */
public interface Snaphot extends EObject {
	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(long)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportPackage#getSnaphot_Time()
	 * @model
	 * @generated
	 */
	long getTime();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(long value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.emf.ecore.EObject},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' map.
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportPackage#getSnaphot_Properties()
	 * @model mapType="org.eclipse.rcptt.sherlock.core.model.sherlock.report.PropertyMap<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EObject>"
	 * @generated
	 */
	EMap<String, EObject> getProperties();

	/**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' containment reference.
	 * @see #setData(EObject)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportPackage#getSnaphot_Data()
	 * @model containment="true"
	 * @generated
	 */
	EObject getData();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot#getData <em>Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' containment reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(EObject value);

} // Snaphot
