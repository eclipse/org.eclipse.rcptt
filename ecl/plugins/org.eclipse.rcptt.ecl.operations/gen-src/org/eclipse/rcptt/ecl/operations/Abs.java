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
package org.eclipse.rcptt.ecl.operations;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Abs#getArg <em>Arg</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getAbs()
 * @model annotation="http://www.eclipse.org/ecl/docs description='&lt;p&gt;returns &lt;code&gt;java.lang.Math.abs(arg)&lt;/code&gt;&lt;/p&gt;\n&lt;p&gt;The return type of an operation is determined by the following rules:&lt;/p&gt;\n&lt;ol&gt;\n  &lt;li&gt;&lt;code&gt;string&lt;/code&gt; arg is converted to &lt;code&gt;long&lt;/code&gt;&lt;/li&gt;\n  &lt;li&gt;&lt;code&gt;boolean&lt;/code&gt; arg is converted to &lt;code&gt;long&lt;/code&gt; (1 for &lt;code&gt;true&lt;/code&gt; and 0 for &lt;code&gt;false&lt;/code&gt;)&lt;/li&gt;\n  &lt;li&gt;&lt;code&gt;double&lt;/code&gt;, &lt;code&gt;float&lt;/code&gt;, &lt;code&gt;long&lt;/code&gt; args retain its original type&lt;/li&gt;\n  &lt;li&gt;Otherwise (in case of &lt;code&gt;byte&lt;/code&gt;, &lt;code&gt;char&lt;/code&gt;, or &lt;code&gt;short&lt;/code&gt;) the returned value has type &lt;code&gt;int&lt;/code&gt;&lt;/li&gt;\n&lt;/ol&gt;\n' example=' emit \"-10.6\" | int | abs | str | log (writes 10 to  log)'"
 * @generated
 */
public interface Abs extends Command {
	/**
	 * Returns the value of the '<em><b>Arg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arg</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arg</em>' reference.
	 * @see #setArg(EObject)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getAbs_Arg()
	 * @model
	 * @generated
	 */
	EObject getArg();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Abs#getArg <em>Arg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arg</em>' reference.
	 * @see #getArg()
	 * @generated
	 */
	void setArg(EObject value);

} // Abs
