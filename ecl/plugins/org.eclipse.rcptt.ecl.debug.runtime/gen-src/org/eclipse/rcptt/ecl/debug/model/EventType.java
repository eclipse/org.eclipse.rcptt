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
package org.eclipse.rcptt.ecl.debug.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Event Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getEventType()
 * @model
 * @generated
 */
public enum EventType implements Enumerator {
	/**
	 * The '<em><b>Started</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STARTED_VALUE
	 * @generated
	 * @ordered
	 */
	STARTED(0, "Started", "Started"),

	/**
	 * The '<em><b>Suspended</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUSPENDED_VALUE
	 * @generated
	 * @ordered
	 */
	SUSPENDED(1, "Suspended", "Suspended"),

	/**
	 * The '<em><b>Step Ended</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEP_ENDED_VALUE
	 * @generated
	 * @ordered
	 */
	STEP_ENDED(2, "StepEnded", "StepEnded"),

	/**
	 * The '<em><b>Breakpoint Hit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BREAKPOINT_HIT_VALUE
	 * @generated
	 * @ordered
	 */
	BREAKPOINT_HIT(3, "BreakpointHit", "BreakpointHit"),

	/**
	 * The '<em><b>Resumed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESUMED_VALUE
	 * @generated
	 * @ordered
	 */
	RESUMED(4, "Resumed", "Resumed"), /**
	 * The '<em><b>Resolve Variable</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESOLVE_VARIABLE_VALUE
	 * @generated
	 * @ordered
	 */
	RESOLVE_VARIABLE(5, "ResolveVariable", "ResolveVariable");

	/**
	 * The '<em><b>Started</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Started</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STARTED
	 * @model name="Started"
	 * @generated
	 * @ordered
	 */
	public static final int STARTED_VALUE = 0;

	/**
	 * The '<em><b>Suspended</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Suspended</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUSPENDED
	 * @model name="Suspended"
	 * @generated
	 * @ordered
	 */
	public static final int SUSPENDED_VALUE = 1;

	/**
	 * The '<em><b>Step Ended</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Step Ended</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEP_ENDED
	 * @model name="StepEnded"
	 * @generated
	 * @ordered
	 */
	public static final int STEP_ENDED_VALUE = 2;

	/**
	 * The '<em><b>Breakpoint Hit</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Breakpoint Hit</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BREAKPOINT_HIT
	 * @model name="BreakpointHit"
	 * @generated
	 * @ordered
	 */
	public static final int BREAKPOINT_HIT_VALUE = 3;

	/**
	 * The '<em><b>Resumed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Resumed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESUMED
	 * @model name="Resumed"
	 * @generated
	 * @ordered
	 */
	public static final int RESUMED_VALUE = 4;

	/**
	 * The '<em><b>Resolve Variable</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Resolve Variable</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESOLVE_VARIABLE
	 * @model name="ResolveVariable"
	 * @generated
	 * @ordered
	 */
	public static final int RESOLVE_VARIABLE_VALUE = 5;

	/**
	 * An array of all the '<em><b>Event Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EventType[] VALUES_ARRAY =
		new EventType[] {
			STARTED,
			SUSPENDED,
			STEP_ENDED,
			BREAKPOINT_HIT,
			RESUMED,
			RESOLVE_VARIABLE,
		};

	/**
	 * A public read-only list of all the '<em><b>Event Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EventType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Event Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EventType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Event Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EventType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Event Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventType get(int value) {
		switch (value) {
			case STARTED_VALUE: return STARTED;
			case SUSPENDED_VALUE: return SUSPENDED;
			case STEP_ENDED_VALUE: return STEP_ENDED;
			case BREAKPOINT_HIT_VALUE: return BREAKPOINT_HIT;
			case RESUMED_VALUE: return RESUMED;
			case RESOLVE_VARIABLE_VALUE: return RESOLVE_VARIABLE;
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
	private EventType(int value, String name, String literal) {
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
	
} //EventType
