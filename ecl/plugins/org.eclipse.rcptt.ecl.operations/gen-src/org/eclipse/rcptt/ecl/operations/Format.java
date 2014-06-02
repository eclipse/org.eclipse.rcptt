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


import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Format</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Format#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Format#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getFormat()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Writes a formatted string to output pipe' returns='Formatted string' example='format \"string: %s, int: %d\" \"foo\" 5 | log'"
 * @generated
 */
public interface Format extends Command {
	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(String)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getFormat_Format()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Format string as in Java\'s <a href=\"http://docs.oracle.com/javase/6/docs/api/java/util/Formatter.html\">String.format</a>'"
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.Format#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

	/**
	 * Returns the value of the '<em><b>Args</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Args</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Args</em>' reference list.
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getFormat_Args()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Arguments for format string'"
	 * @generated
	 */
	EList<EObject> getArgs();

} // Format
