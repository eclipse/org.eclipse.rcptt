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
package org.eclipse.rcptt.ecl.interop;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Java Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.GetJavaProperty#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.interop.GetJavaProperty#getDefault <em>Default</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getGetJavaProperty()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Gets the Java system property indicated by the specified key.' returns='The string value of the system property.' example='get-java-property \"java.home\" | log'"
 * @generated
 */
public interface GetJavaProperty extends Command {
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
	 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getGetJavaProperty_Key()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='The name of the system property.'"
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.interop.GetJavaProperty#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

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
	 * @see org.eclipse.rcptt.ecl.interop.InteropPackage#getGetJavaProperty_Default()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Default value to use if there is no property with the key.'"
	 * @generated
	 */
	String getDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.interop.GetJavaProperty#getDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(String value);

} // GetJavaProperty
