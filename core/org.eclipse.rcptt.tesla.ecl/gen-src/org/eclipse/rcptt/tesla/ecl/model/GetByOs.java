/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.model;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get By Os</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetByOs#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetByOs#getWin <em>Win</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetByOs#getLinux <em>Linux</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.GetByOs#getMacosx <em>Macosx</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetByOs()
 * @model annotation="http://www.eclipse.org/ecl/docs description='&lt;p&gt;Returns value depending on current operating system. This allows to create cross-platform tests in cases when assertion values slightly differ on various operating system &amp;ndash; this command can be used as an argument for commands like &lt;code&gt;equals&lt;/code&gt;:&lt;/p&gt;\r\n&lt;pre&gt;\r\n... | get-property \"text\" | equals [\r\n      get-by-os -macosx \"Mac value\" -win \"Windows value\" -linux \"Linux value\"\r\n    ] | verify-true\r\n&lt;/pre&gt;\r\n&lt;p&gt;When two platforms have the same value, it is convenient to use &lt;code&gt;-default&lt;/code&gt; argument. For example, if some value is the same on Linux and Mac OS X, but differs on Windows, &lt;code&gt;get-by-os&lt;/code&gt; can be used like this:&lt;/p&gt;\r\n&lt;pre&gt;\r\n  get-by-os -win \"Windows value\" -default \"Mac OS X and Linux value\"\r\n&lt;/pre&gt;\r\n' returns='Value of an argument corresponding to current platform, or value of &lt;code&gt;default&lt;/code&gt; argument.'"
 * @generated
 */
public interface GetByOs extends Command {
	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetByOs_Default()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Value to use when no platform-specific argument specified'"
	 * @generated
	 */
	String getDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetByOs#getDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(String value);

	/**
	 * Returns the value of the '<em><b>Win</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Win</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Win</em>' attribute.
	 * @see #setWin(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetByOs_Win()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Value to use on Windows'"
	 * @generated
	 */
	String getWin();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetByOs#getWin <em>Win</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Win</em>' attribute.
	 * @see #getWin()
	 * @generated
	 */
	void setWin(String value);

	/**
	 * Returns the value of the '<em><b>Linux</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linux</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linux</em>' attribute.
	 * @see #setLinux(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetByOs_Linux()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Value to use on Linux'"
	 * @generated
	 */
	String getLinux();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetByOs#getLinux <em>Linux</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linux</em>' attribute.
	 * @see #getLinux()
	 * @generated
	 */
	void setLinux(String value);

	/**
	 * Returns the value of the '<em><b>Macosx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Macosx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Macosx</em>' attribute.
	 * @see #setMacosx(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getGetByOs_Macosx()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Value to use on Mac OS X'"
	 * @generated
	 */
	String getMacosx();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.GetByOs#getMacosx <em>Macosx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Macosx</em>' attribute.
	 * @see #getMacosx()
	 * @generated
	 */
	void setMacosx(String value);

} // GetByOs
