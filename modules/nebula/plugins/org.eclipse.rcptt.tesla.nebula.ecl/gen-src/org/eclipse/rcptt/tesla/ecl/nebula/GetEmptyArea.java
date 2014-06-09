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
package org.eclipse.rcptt.tesla.ecl.nebula;

import org.eclipse.rcptt.tesla.ecl.model.Selector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Empty Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea#isTop <em>Top</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea#isLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea#getColumn <em>Column</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getGetEmptyArea()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Gets the Nebula Grid empty area specified by its place.\n' returns='grid empty area' recorded='true' example='get-nebula-grid | get-empty-area -top -left\nget-nebula-grid | get-empty-area -column \"Column Title\"\nget-nebula-grid | get-item \"Item Label\" | get-empty-area'"
 * @generated
 */
public interface GetEmptyArea extends Selector {
	/**
	 * Returns the value of the '<em><b>Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top</em>' attribute.
	 * @see #setTop(boolean)
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getGetEmptyArea_Top()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Area is located on the top header line. Can be combined with <code>-left</code> parameter to get the intersection corner.'"
	 * @generated
	 */
	boolean isTop();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea#isTop <em>Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top</em>' attribute.
	 * @see #isTop()
	 * @generated
	 */
	void setTop(boolean value);

	/**
	 * Returns the value of the '<em><b>Left</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' attribute.
	 * @see #setLeft(boolean)
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getGetEmptyArea_Left()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Area is located on the left header column. Can be combined with <code>-top</code> parameter to get the intersection corner.'"
	 * @generated
	 */
	boolean isLeft();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea#isLeft <em>Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' attribute.
	 * @see #isLeft()
	 * @generated
	 */
	void setLeft(boolean value);

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
	 * @see org.eclipse.rcptt.tesla.ecl.nebula.NebulaPackage#getGetEmptyArea_Column()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Area is located at the bottom of specified column. Must not be combined with <code>-top</code> or <code>-left</code> parameters.'"
	 * @generated
	 */
	String getColumn();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.nebula.GetEmptyArea#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(String value);

} // GetEmptyArea
