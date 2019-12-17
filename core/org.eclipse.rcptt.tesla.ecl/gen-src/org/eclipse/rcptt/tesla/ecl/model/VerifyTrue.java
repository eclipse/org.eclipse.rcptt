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


import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verify True</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.VerifyTrue#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getVerifyTrue()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Checks &lt;code&gt;input&lt;/code&gt; condition\'s verity. If verity is not confirmed, then error is returned' input='EObject condition' example='get-editor \"Test scenario\" | get-section Script | get-editbox | get-property value | equals test | verify-true'"
 * @generated
 */
public interface VerifyTrue extends Command {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' reference.
	 * @see #setCondition(EObject)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getVerifyTrue_Condition()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='&lt;code&gt;input&lt;/code&gt; condition that has to be true'"
	 *        annotation="http://www.eclipse.org/ecl/input"
	 * @generated
	 */
	EObject getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.VerifyTrue#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(EObject value);

} // VerifyTrue
