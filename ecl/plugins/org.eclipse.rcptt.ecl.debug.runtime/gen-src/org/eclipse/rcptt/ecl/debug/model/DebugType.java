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
 * A representation of the literals of the enumeration '<em><b>Debug Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.ecl.debug.model.ModelPackage#getDebugType()
 * @model
 * @generated
 */
public enum DebugType implements Enumerator {
	/**
	 * The '<em><b>Suspend</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUSPEND_VALUE
	 * @generated
	 * @ordered
	 */
	SUSPEND(0, "Suspend", "Suspend"),

	/**
	 * The '<em><b>Resume</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESUME_VALUE
	 * @generated
	 * @ordered
	 */
	RESUME(1, "Resume", "Resume"),

	/**
	 * The '<em><b>Step</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEP_VALUE
	 * @generated
	 * @ordered
	 */
	STEP(2, "Step", "Step"),

	/**
	 * The '<em><b>Step Over</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEP_OVER_VALUE
	 * @generated
	 * @ordered
	 */
	STEP_OVER(3, "StepOver", "StepOver"),

	/**
	 * The '<em><b>Breakpoint Add</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BREAKPOINT_ADD_VALUE
	 * @generated
	 * @ordered
	 */
	BREAKPOINT_ADD(4, "BreakpointAdd", "BreakpointAdd"),

	/**
	 * The '<em><b>Breakpoint Remove</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BREAKPOINT_REMOVE_VALUE
	 * @generated
	 * @ordered
	 */
	BREAKPOINT_REMOVE(5, "BreakpointRemove", "BreakpointRemove"),

	/**
	 * The '<em><b>Skip All</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SKIP_ALL_VALUE
	 * @generated
	 * @ordered
	 */
	SKIP_ALL(6, "SkipAll", "SkipAll"), /**
	 * The '<em><b>Resolve Variable</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESOLVE_VARIABLE_VALUE
	 * @generated
	 * @ordered
	 */
	RESOLVE_VARIABLE(7, "ResolveVariable", "ResolveVariable"), /**
	 * The '<em><b>Step Return</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEP_RETURN_VALUE
	 * @generated
	 * @ordered
	 */
	STEP_RETURN(8, "StepReturn", "StepReturn");

	/**
	 * The '<em><b>Suspend</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Suspend</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUSPEND
	 * @model name="Suspend"
	 * @generated
	 * @ordered
	 */
	public static final int SUSPEND_VALUE = 0;

	/**
	 * The '<em><b>Resume</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Resume</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESUME
	 * @model name="Resume"
	 * @generated
	 * @ordered
	 */
	public static final int RESUME_VALUE = 1;

	/**
	 * The '<em><b>Step</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Step</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEP
	 * @model name="Step"
	 * @generated
	 * @ordered
	 */
	public static final int STEP_VALUE = 2;

	/**
	 * The '<em><b>Step Over</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Step Over</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEP_OVER
	 * @model name="StepOver"
	 * @generated
	 * @ordered
	 */
	public static final int STEP_OVER_VALUE = 3;

	/**
	 * The '<em><b>Breakpoint Add</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Breakpoint Add</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BREAKPOINT_ADD
	 * @model name="BreakpointAdd"
	 * @generated
	 * @ordered
	 */
	public static final int BREAKPOINT_ADD_VALUE = 4;

	/**
	 * The '<em><b>Breakpoint Remove</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Breakpoint Remove</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BREAKPOINT_REMOVE
	 * @model name="BreakpointRemove"
	 * @generated
	 * @ordered
	 */
	public static final int BREAKPOINT_REMOVE_VALUE = 5;

	/**
	 * The '<em><b>Skip All</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Skip All</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SKIP_ALL
	 * @model name="SkipAll"
	 * @generated
	 * @ordered
	 */
	public static final int SKIP_ALL_VALUE = 6;

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
	public static final int RESOLVE_VARIABLE_VALUE = 7;

	/**
	 * The '<em><b>Step Return</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Step Return</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEP_RETURN
	 * @model name="StepReturn"
	 * @generated
	 * @ordered
	 */
	public static final int STEP_RETURN_VALUE = 8;

	/**
	 * An array of all the '<em><b>Debug Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DebugType[] VALUES_ARRAY =
		new DebugType[] {
			SUSPEND,
			RESUME,
			STEP,
			STEP_OVER,
			BREAKPOINT_ADD,
			BREAKPOINT_REMOVE,
			SKIP_ALL,
			RESOLVE_VARIABLE,
			STEP_RETURN,
		};

	/**
	 * A public read-only list of all the '<em><b>Debug Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DebugType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Debug Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DebugType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DebugType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Debug Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DebugType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DebugType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Debug Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DebugType get(int value) {
		switch (value) {
			case SUSPEND_VALUE: return SUSPEND;
			case RESUME_VALUE: return RESUME;
			case STEP_VALUE: return STEP;
			case STEP_OVER_VALUE: return STEP_OVER;
			case BREAKPOINT_ADD_VALUE: return BREAKPOINT_ADD;
			case BREAKPOINT_REMOVE_VALUE: return BREAKPOINT_REMOVE;
			case SKIP_ALL_VALUE: return SKIP_ALL;
			case RESOLVE_VARIABLE_VALUE: return RESOLVE_VARIABLE;
			case STEP_RETURN_VALUE: return STEP_RETURN;
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
	private DebugType(int value, String name, String literal) {
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
	
} //DebugType
