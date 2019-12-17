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
package org.eclipse.rcptt.tesla.ecl.nebula;

import org.eclipse.rcptt.tesla.ecl.model.Selector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Item Cell</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.GetItemCell#getColumn <em>Column</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getGetItemCell()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Gets the Nebula Grid item cell by its column name.' returns='item cell' recorded='true' example='get-nebula-grid | get-item \"Item Label\" | get-item-cell -column \"Column Title\"'"
 * @generated
 */
public interface GetItemCell extends Selector {
	/**
	 * Returns the value of the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' attribute.
	 * @see #setColumn(String)
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getGetItemCell_Column()
	 * @model required="true"
	 * @generated
	 */
	String getColumn();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.nebula.GetItemCell#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(String value);

} // GetItemCell
