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
package org.eclipse.rcptt.tesla.ecl.model;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Get Cell</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetCell#getRow <em>Row</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetCell#getColumn <em>Column</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetCell()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Gets cell with defined parameter. If this cell doesn\'t exist, then error is returned.' returns='cell' recorded='true' example=''"
 * @generated
 */
public interface GetCell extends Selector {
	/**
	 * Returns the value of the '<em><b>Row</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Row</em>' attribute.
	 * @see #setRow(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetCell_Row()
	 * @model required="true"
	 * @generated
	 */
	Integer getRow();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetCell#getRow <em>Row</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Row</em>' attribute.
	 * @see #getRow()
	 * @generated
	 */
	void setRow(Integer value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Column</em>' attribute.
	 * @see #setColumn(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetCell_Column()
	 * @model required="true"
	 * @generated
	 */
	Integer getColumn();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetCell#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(Integer value);

} // GetCell
