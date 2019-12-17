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
package org.eclipse.rcptt.tesla.ecl.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Position</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.SetPosition#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getSetPosition()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Sets position of a table column.' returns='value of &lt;code&gt;control&lt;/code&gt; parameter' recorded='false' example='get-nebula-grid | get-column-header Name | set-position 4'"
 * @generated
 */
public interface SetPosition extends ControlCommand {
	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getSetPosition_Index()
	 * @model required="true"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.SetPosition#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

} // SetPosition
