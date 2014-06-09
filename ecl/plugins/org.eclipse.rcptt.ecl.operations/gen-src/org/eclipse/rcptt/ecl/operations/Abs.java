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
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Abs#getArg <em>Arg</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getAbs()
 * @model annotation="http://www.eclipse.org/ecl/docs description='<p>returns <code>java.lang.Math.abs(arg)</code></p>\n<p>The return type of an operation is determined by the following rules:</p>\n<ol>\n  <li><code>string</code> arg is converted to <code>long</code></li>\n  <li><code>boolean</code> arg is converted to <code>long</code> (1 for <code>true</code> and 0 for <code>false</code>)</li>\n  <li><code>double</code>, <code>float</code>, <code>long</code> args retain its original type</li>\n  <li>Otherwise (in case of <code>byte</code>, <code>char</code>, or <code>short</code>) the returned value has type <code>int</code></li>\n</ol>\n' example=' emit \"-10.6\" | int | abs | str | log (writes 10 to  log)'"
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
