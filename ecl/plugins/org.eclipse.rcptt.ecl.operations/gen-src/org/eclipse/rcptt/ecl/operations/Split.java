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
package org.eclipse.rcptt.ecl.operations;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Split</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Split#getStr <em>Str</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Split#getSep <em>Sep</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Split#isTrimResults <em>Trim Results</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Split#isOmitEmptyStrings <em>Omit Empty Strings</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getSplit()
 * @model annotation="http://www.eclipse.org/ecl/docs description='' example='str \"1, 2, 3, 4, 5\" | split -sep \",\" -trimResults | foreach [val item]{\n\t$item | log\n}\n'"
 * @generated
 */
public interface Split extends Command {
	/**
	 * Returns the value of the '<em><b>Str</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Str</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Str</em>' attribute.
	 * @see #setStr(String)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getSplit_Str()
	 * @model
	 * @generated
	 */
	String getStr();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Split#getStr <em>Str</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Str</em>' attribute.
	 * @see #getStr()
	 * @generated
	 */
	void setStr(String value);

	/**
	 * Returns the value of the '<em><b>Sep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sep</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sep</em>' attribute.
	 * @see #setSep(String)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getSplit_Sep()
	 * @model
	 * @generated
	 */
	String getSep();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Split#getSep <em>Sep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sep</em>' attribute.
	 * @see #getSep()
	 * @generated
	 */
	void setSep(String value);

	/**
	 * Returns the value of the '<em><b>Trim Results</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trim Results</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trim Results</em>' attribute.
	 * @see #setTrimResults(boolean)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getSplit_TrimResults()
	 * @model default="false"
	 * @generated
	 */
	boolean isTrimResults();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Split#isTrimResults <em>Trim Results</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trim Results</em>' attribute.
	 * @see #isTrimResults()
	 * @generated
	 */
	void setTrimResults(boolean value);

	/**
	 * Returns the value of the '<em><b>Omit Empty Strings</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Omit Empty Strings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Omit Empty Strings</em>' attribute.
	 * @see #setOmitEmptyStrings(boolean)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getSplit_OmitEmptyStrings()
	 * @model default="false"
	 * @generated
	 */
	boolean isOmitEmptyStrings();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Split#isOmitEmptyStrings <em>Omit Empty Strings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Omit Empty Strings</em>' attribute.
	 * @see #isOmitEmptyStrings()
	 * @generated
	 */
	void setOmitEmptyStrings(boolean value);

} // Split
