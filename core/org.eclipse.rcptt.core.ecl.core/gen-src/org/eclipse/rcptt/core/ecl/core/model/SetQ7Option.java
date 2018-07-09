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
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.SetQ7Option#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.rcptt.core.ecl.core.model.SetQ7Option#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.core.ecl.core.model.Q7CorePackage#getSetQ7Option()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Sets Q7 runtime option.' example='&lt;code&gt;set-q7-option eclExecutionDelay 0&lt;/code&gt;'"
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
	 *        annotation="http://www.eclipse.org/ecl/docs description='&lt;br/&gt;\r\nAvailable keys:\r\n&lt;ul&gt;\r\n    &lt;li&gt; &lt;b&gt;jobDebugjobTimeout&lt;/b&gt; Eclipse job debug plugin jobs timeout (def: 300000 ms) &lt;/li&gt;\r\n    &lt;li&gt; &lt;b&gt;jobSleepingStepTime&lt;/b&gt; Step in step mode (def: 200 ms) &lt;/li&gt;\r\n    &lt;li&gt; &lt;b&gt;jobSleepingStepTimeout&lt;/b&gt; Stepping job timeout (def: 120000 ms) &lt;/li&gt;\r\n    &lt;li&gt; &lt;b&gt;jobTreatAsSleepingTimeout&lt;/b&gt; Enable Job step mode timeout (def: 10000 ms) &lt;/li&gt;\r\n    &lt;li&gt; &lt;b&gt;jobHangTimeout&lt;/b&gt; Job skip timeout (def: 30000 ms) &lt;/li&gt;\r\n    &lt;li&gt; &lt;b&gt;jobScheduleDelayedMaxtime&lt;/b&gt; Wait for jobs with delay less timeout (def: 600 ms) &lt;/li&gt;\r\n    &lt;li&gt; &lt;b&gt;eclExecutionDelay&lt;/b&gt; Wait for time between each ECL command (def: 0 ms) &lt;/li&gt;\r\n    &lt;li&gt; &lt;b&gt;workspaceClearForceGc&lt;/b&gt; Forces garbage collection on workspace cleanup (def: true) &lt;/li&gt;\r\n&lt;/ul&gt;'"
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
