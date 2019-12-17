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
package org.eclipse.rcptt.launching.injection;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update Site</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.launching.injection.UpdateSite#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.rcptt.launching.injection.UpdateSite#getUnits <em>Units</em>}</li>
 *   <li>{@link org.eclipse.rcptt.launching.injection.UpdateSite#isAllUnits <em>All Units</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.launching.injection.InjectionPackage#getUpdateSite()
 * @model
 * @generated
 */
public interface UpdateSite extends Entry {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.eclipse.rcptt.launching.injection.InjectionPackage#getUpdateSite_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.launching.injection.UpdateSite#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Units</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units</em>' attribute list.
	 * @see org.eclipse.rcptt.launching.injection.InjectionPackage#getUpdateSite_Units()
	 * @model
	 * @generated
	 */
	EList<String> getUnits();

	/**
	 * Returns the value of the '<em><b>All Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Units</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Units</em>' attribute.
	 * @see #setAllUnits(boolean)
	 * @see org.eclipse.rcptt.launching.injection.InjectionPackage#getUpdateSite_AllUnits()
	 * @model
	 * @generated
	 */
	boolean isAllUnits();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.launching.injection.UpdateSite#isAllUnits <em>All Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>All Units</em>' attribute.
	 * @see #isAllUnits()
	 * @generated
	 */
	void setAllUnits(boolean value);

} // UpdateSite
