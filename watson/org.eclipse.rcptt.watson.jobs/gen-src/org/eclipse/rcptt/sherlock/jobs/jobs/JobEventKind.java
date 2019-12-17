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
 * A representation of the literals of the enumeration '<em><b>Job Event Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.sherlock.jobs.jobs.JobsPackage#getJobEventKind()
 * @model
 * @generated
 */
public enum JobEventKind implements Enumerator {
	/**
	 * The '<em><b>Sheduled</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHEDULED_VALUE
	 * @generated
	 * @ordered
	 */
	SHEDULED(0, "Sheduled", "Sheduled"),

	/**
	 * The '<em><b>Running</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUNNING_VALUE
	 * @generated
	 * @ordered
	 */
	RUNNING(1, "Running", "Running"),

	/**
	 * The '<em><b>Async Finish</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASYNC_FINISH_VALUE
	 * @generated
	 * @ordered
	 */
	ASYNC_FINISH(2, "AsyncFinish", "AsyncFinish"),

	/**
	 * The '<em><b>Async Done</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASYNC_DONE_VALUE
	 * @generated
	 * @ordered
	 */
	ASYNC_DONE(3, "AsyncDone", "AsyncDone"),

	/**
	 * The '<em><b>Finished</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FINISHED_VALUE
	 * @generated
	 * @ordered
	 */
	FINISHED(4, "Finished", "Finished"),

	/**
	 * The '<em><b>Slepping</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLEPPING_VALUE
	 * @generated
	 * @ordered
	 */
	SLEPPING(5, "Slepping", "Slepping"),

	/**
	 * The '<em><b>Waiting</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WAITING_VALUE
	 * @generated
	 * @ordered
	 */
	WAITING(6, "Waiting", "Waiting"),

	/**
	 * The '<em><b>Canceled</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CANCELED_VALUE
	 * @generated
	 * @ordered
	 */
	CANCELED(7, "Canceled", "Canceled");

	/**
	 * The '<em><b>Sheduled</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sheduled</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHEDULED
	 * @model name="Sheduled"
	 * @generated
	 * @ordered
	 */
	public static final int SHEDULED_VALUE = 0;

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
	public static final int RUNNING_VALUE = 1;

	/**
	 * The '<em><b>Async Finish</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Async Finish</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASYNC_FINISH
	 * @model name="AsyncFinish"
	 * @generated
	 * @ordered
	 */
	public static final int ASYNC_FINISH_VALUE = 2;

	/**
	 * The '<em><b>Async Done</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Async Done</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASYNC_DONE
	 * @model name="AsyncDone"
	 * @generated
	 * @ordered
	 */
	public static final int ASYNC_DONE_VALUE = 3;

	/**
	 * The '<em><b>Finished</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Finished</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FINISHED
	 * @model name="Finished"
	 * @generated
	 * @ordered
	 */
	public static final int FINISHED_VALUE = 4;

	/**
	 * The '<em><b>Slepping</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Slepping</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLEPPING
	 * @model name="Slepping"
	 * @generated
	 * @ordered
	 */
	public static final int SLEPPING_VALUE = 5;

	/**
	 * The '<em><b>Waiting</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Waiting</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WAITING
	 * @model name="Waiting"
	 * @generated
	 * @ordered
	 */
	public static final int WAITING_VALUE = 6;

	/**
	 * The '<em><b>Canceled</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Canceled</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CANCELED
	 * @model name="Canceled"
	 * @generated
	 * @ordered
	 */
	public static final int CANCELED_VALUE = 7;

	/**
	 * An array of all the '<em><b>Job Event Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final JobEventKind[] VALUES_ARRAY =
		new JobEventKind[] {
			SHEDULED,
			RUNNING,
			ASYNC_FINISH,
			ASYNC_DONE,
			FINISHED,
			SLEPPING,
			WAITING,
			CANCELED,
		};

	/**
	 * A public read-only list of all the '<em><b>Job Event Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<JobEventKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Job Event Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JobEventKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JobEventKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Job Event Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JobEventKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			JobEventKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Job Event Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JobEventKind get(int value) {
		switch (value) {
			case SHEDULED_VALUE: return SHEDULED;
			case RUNNING_VALUE: return RUNNING;
			case ASYNC_FINISH_VALUE: return ASYNC_FINISH;
			case ASYNC_DONE_VALUE: return ASYNC_DONE;
			case FINISHED_VALUE: return FINISHED;
			case SLEPPING_VALUE: return SLEPPING;
			case WAITING_VALUE: return WAITING;
			case CANCELED_VALUE: return CANCELED;
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
	private JobEventKind(int value, String name, String literal) {
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
	
} //JobEventKind
