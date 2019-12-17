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
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Format Time</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.FormatTime#getFormat <em>Format</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getFormatTime()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Reads timestamp value (as a number of milliseconds since January, 1, 1970) from input pipe and formats according to given format string. Format string is the same as used in &lt;code&gt;java.text.SimpleDateFormat&lt;/code&gt;.' returns='String representation of given time' example='get-time | format-time -format \"dd.MM.yyyy\" | log\n// writes current date, month and year into log'"
 * @generated
 */
public interface FormatTime extends Command {
	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(String)
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getFormatTime_Format()
	 * @model
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.operations.FormatTime#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

} // FormatTime
