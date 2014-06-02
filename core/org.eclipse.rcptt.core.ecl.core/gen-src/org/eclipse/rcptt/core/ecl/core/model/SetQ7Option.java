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

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Q7 Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.SetQ7Option#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.SetQ7Option#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getSetQ7Option()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Sets Q7 runtime option.' example='<code>set-q7-option eclExecutionDelay 0</code>'"
 * @generated
 */
public interface SetQ7Option extends Command {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getSetQ7Option_Key()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='<br/>\r\nAvailable keys:\r\n<ul>\r\n    <li> <b>jobDebugjobTimeout</b> Eclipse job debug plugin jobs timeout (def: 300000 ms) </li>\r\n    <li> <b>jobSleepingStepTime</b> Step in step mode (def: 200 ms) </li>\r\n    <li> <b>jobSleepingStepTimeout</b> Stepping job timeout (def: 120000 ms) </li>\r\n    <li> <b>jobTreatAsSleepingTimeout</b> Enable Job step mode timeout (def: 10000 ms) </li>\r\n    <li> <b>jobHangTimeout</b> Job skip timeout (def: 30000 ms) </li>\r\n    <li> <b>jobScheduleDelayedMaxtime</b> Wait for jobs with delay less timeout (def: 600 ms) </li>\r\n    <li> <b>eclExecutionDelay</b> Wait for time between each ECL command (def: 0 ms) </li>\r\n    <li> <b>workspaceClearForceGc</b> Forces garbage collection on workspace cleanup (def: true) </li>\r\n</ul>'"
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.ecl.core.model.SetQ7Option#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getSetQ7Option_Value()
	 * @model required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.core.ecl.core.model.SetQ7Option#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // SetQ7Option
