/*******************************************************************************
 * Copyright (c) 2014-2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.ecl.perf;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measure Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.perf.MeasureTime#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.perf.MeasureTime#getDo <em>Do</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.perf.PerfPackage#getMeasureTime()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Takes the name of the counter and the command on execution. Writes to the output stream the object with fields name and duration, where the name is counterName, and duration - the execution in milliseconds.' returns='object with fields name and the duration of execution in milliseconds' example='measure-time \"MyCounterName\" {\r\n   // some ECL script\r\n} | constrain-max duration 2000 \r\n// fail if the operation was more than 2 seconds with a message \r\n//Max constraint violation: \'MyCounterName\' duration is 100500 which is greater than 2000.'"
 * @generated
 */
public interface MeasureTime extends Command {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.rcptt.ecl.perf.PerfPackage#getMeasureTime_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.perf.MeasureTime#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Do</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Do</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Do</em>' containment reference.
	 * @see #setDo(Command)
	 * @see org.eclipse.rcptt.ecl.perf.PerfPackage#getMeasureTime_Do()
	 * @model containment="true"
	 * @generated
	 */
	Command getDo();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.perf.MeasureTime#getDo <em>Do</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Do</em>' containment reference.
	 * @see #getDo()
	 * @generated
	 */
	void setDo(Command value);

} // MeasureTime
