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
package org.eclipse.rcptt.tesla.core.protocol;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Drag Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getDragKind()
 * @model
 * @generated
 */
public enum DragKind implements Enumerator {
	/**
	 * The '<em><b>Start</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START_VALUE
	 * @generated
	 * @ordered
	 */
	START(0, "Start", "Start"),

	/**
	 * The '<em><b>End</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #END_VALUE
	 * @generated
	 * @ordered
	 */
	END(1, "End", "End"),

	/**
	 * The '<em><b>Set Data</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_DATA_VALUE
	 * @generated
	 * @ordered
	 */
	SET_DATA(2, "SetData", "SetData"),

	/**
	 * The '<em><b>Accept</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCEPT_VALUE
	 * @generated
	 * @ordered
	 */
	ACCEPT(3, "Accept", "Accept"),

	/**
	 * The '<em><b>Drop</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DROP_VALUE
	 * @generated
	 * @ordered
	 */
	DROP(4, "Drop", "Drop"), /**
	 * The '<em><b>Detect</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DETECT_VALUE
	 * @generated
	 * @ordered
	 */
	DETECT(5, "Detect", "Detect"), /**
	 * The '<em><b>Over</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVER_VALUE
	 * @generated
	 * @ordered
	 */
	OVER(6, "Over", "Over"), /**
	 * The '<em><b>Leave</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEAVE_VALUE
	 * @generated
	 * @ordered
	 */
	LEAVE(7, "Leave", "Leave"), /**
	 * The '<em><b>Enter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENTER_VALUE
	 * @generated
	 * @ordered
	 */
	ENTER(8, "Enter", "Enter");

	/**
	 * The '<em><b>Start</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Start</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #START
	 * @model name="Start"
	 * @generated
	 * @ordered
	 */
	public static final int START_VALUE = 0;

	/**
	 * The '<em><b>End</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>End</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #END
	 * @model name="End"
	 * @generated
	 * @ordered
	 */
	public static final int END_VALUE = 1;

	/**
	 * The '<em><b>Set Data</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Set Data</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SET_DATA
	 * @model name="SetData"
	 * @generated
	 * @ordered
	 */
	public static final int SET_DATA_VALUE = 2;

	/**
	 * The '<em><b>Accept</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Accept</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCEPT
	 * @model name="Accept"
	 * @generated
	 * @ordered
	 */
	public static final int ACCEPT_VALUE = 3;

	/**
	 * The '<em><b>Drop</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Drop</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DROP
	 * @model name="Drop"
	 * @generated
	 * @ordered
	 */
	public static final int DROP_VALUE = 4;

	/**
	 * The '<em><b>Detect</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Detect</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DETECT
	 * @model name="Detect"
	 * @generated
	 * @ordered
	 */
	public static final int DETECT_VALUE = 5;

	/**
	 * The '<em><b>Over</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Over</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVER
	 * @model name="Over"
	 * @generated
	 * @ordered
	 */
	public static final int OVER_VALUE = 6;

	/**
	 * The '<em><b>Leave</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Leave</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LEAVE
	 * @model name="Leave"
	 * @generated
	 * @ordered
	 */
	public static final int LEAVE_VALUE = 7;

	/**
	 * The '<em><b>Enter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Enter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENTER
	 * @model name="Enter"
	 * @generated
	 * @ordered
	 */
	public static final int ENTER_VALUE = 8;

	/**
	 * An array of all the '<em><b>Drag Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DragKind[] VALUES_ARRAY =
		new DragKind[] {
			START,
			END,
			SET_DATA,
			ACCEPT,
			DROP,
			DETECT,
			OVER,
			LEAVE,
			ENTER,
		};

	/**
	 * A public read-only list of all the '<em><b>Drag Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DragKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Drag Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DragKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DragKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Drag Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DragKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DragKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Drag Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DragKind get(int value) {
		switch (value) {
			case START_VALUE: return START;
			case END_VALUE: return END;
			case SET_DATA_VALUE: return SET_DATA;
			case ACCEPT_VALUE: return ACCEPT;
			case DROP_VALUE: return DROP;
			case DETECT_VALUE: return DETECT;
			case OVER_VALUE: return OVER;
			case LEAVE_VALUE: return LEAVE;
			case ENTER_VALUE: return ENTER;
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
	private DragKind(int value, String name, String literal) {
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
	
} //DragKind
