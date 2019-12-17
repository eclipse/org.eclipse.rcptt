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
package org.eclipse.rcptt.sherlock.jobs.jobs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Async Event Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getAsyncEventKind()
 * @model
 * @generated
 */
public enum AsyncEventKind implements Enumerator {
	/**
	 * The '<em><b>Starting</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STARTING_VALUE
	 * @generated
	 * @ordered
	 */
	STARTING(0, "Starting", "Starting"),

	/**
	 * The '<em><b>Done</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DONE_VALUE
	 * @generated
	 * @ordered
	 */
	DONE(1, "Done", "Done"),

	/**
	 * The '<em><b>Running</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUNNING_VALUE
	 * @generated
	 * @ordered
	 */
	RUNNING(2, "Running", "Running"),

	/**
	 * The '<em><b>Timer Exec</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIMER_EXEC_VALUE
	 * @generated
	 * @ordered
	 */
	TIMER_EXEC(3, "TimerExec", "TimerExec");

	/**
	 * The '<em><b>Starting</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Starting</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STARTING
	 * @model name="Starting"
	 * @generated
	 * @ordered
	 */
	public static final int STARTING_VALUE = 0;

	/**
	 * The '<em><b>Done</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Done</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DONE
	 * @model name="Done"
	 * @generated
	 * @ordered
	 */
	public static final int DONE_VALUE = 1;

	/**
	 * The '<em><b>Running</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Running</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RUNNING
	 * @model name="Running"
	 * @generated
	 * @ordered
	 */
	public static final int RUNNING_VALUE = 2;

	/**
	 * The '<em><b>Timer Exec</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Timer Exec</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIMER_EXEC
	 * @model name="TimerExec"
	 * @generated
	 * @ordered
	 */
	public static final int TIMER_EXEC_VALUE = 3;

	/**
	 * An array of all the '<em><b>Async Event Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AsyncEventKind[] VALUES_ARRAY =
		new AsyncEventKind[] {
			STARTING,
			DONE,
			RUNNING,
			TIMER_EXEC,
		};

	/**
	 * A public read-only list of all the '<em><b>Async Event Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AsyncEventKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Async Event Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AsyncEventKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AsyncEventKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Async Event Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AsyncEventKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AsyncEventKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Async Event Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AsyncEventKind get(int value) {
		switch (value) {
			case STARTING_VALUE: return STARTING;
			case DONE_VALUE: return DONE;
			case RUNNING_VALUE: return RUNNING;
			case TIMER_EXEC_VALUE: return TIMER_EXEC;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private AsyncEventKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //AsyncEventKind
