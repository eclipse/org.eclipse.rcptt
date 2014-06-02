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
package org.eclipse.rcptt.core.ecl.core.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Q7 Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.Q7Information#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.Q7Information#isTeslaActive <em>Tesla Active</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.Q7Information#getTeslaPort <em>Tesla Port</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.Q7Information#isClientActive <em>Client Active</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getQ7Information()
 * @model
 * @generated
 */
public interface Q7Information extends EObject {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getQ7Information_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.ecl.core.model.Q7Information#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Tesla Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tesla Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tesla Active</em>' attribute.
	 * @see #setTeslaActive(boolean)
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getQ7Information_TeslaActive()
	 * @model
	 * @generated
	 */
	boolean isTeslaActive();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.ecl.core.model.Q7Information#isTeslaActive <em>Tesla Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tesla Active</em>' attribute.
	 * @see #isTeslaActive()
	 * @generated
	 */
	void setTeslaActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Tesla Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tesla Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tesla Port</em>' attribute.
	 * @see #setTeslaPort(int)
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getQ7Information_TeslaPort()
	 * @model
	 * @generated
	 */
	int getTeslaPort();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.ecl.core.model.Q7Information#getTeslaPort <em>Tesla Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tesla Port</em>' attribute.
	 * @see #getTeslaPort()
	 * @generated
	 */
	void setTeslaPort(int value);

	/**
	 * Returns the value of the '<em><b>Client Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Client Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Client Active</em>' attribute.
	 * @see #setClientActive(boolean)
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getQ7Information_ClientActive()
	 * @model
	 * @generated
	 */
	boolean isClientActive();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.ecl.core.model.Q7Information#isClientActive <em>Client Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Active</em>' attribute.
	 * @see #isClientActive()
	 * @generated
	 */
	void setClientActive(boolean value);

} // Q7Information
