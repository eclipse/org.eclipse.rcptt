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
package org.eclipse.rcptt.tesla.core.protocol;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Mouse Event Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getMouseEventKind()
 * @model
 * @generated
 */
public enum MouseEventKind implements Enumerator {
	/**
	 * The '<em><b>DOWN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOWN_VALUE
	 * @generated
	 * @ordered
	 */
	DOWN(0, "DOWN", "down"),

	/**
	 * The '<em><b>UP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UP_VALUE
	 * @generated
	 * @ordered
	 */
	UP(1, "UP", "up"),

	/**
	 * The '<em><b>MOVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_VALUE
	 * @generated
	 * @ordered
	 */
	MOVE(2, "MOVE", "move"),

	/**
	 * The '<em><b>ENTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENTER_VALUE
	 * @generated
	 * @ordered
	 */
	ENTER(3, "ENTER", "enter"),

	/**
	 * The '<em><b>EXIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXIT_VALUE
	 * @generated
	 * @ordered
	 */
	EXIT(4, "EXIT", "exit"),

	/**
	 * The '<em><b>DOUBLE CLICK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_CLICK_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE_CLICK(5, "DOUBLE_CLICK", "double-click"), /**
	 * The '<em><b>HOVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOVER_VALUE
	 * @generated
	 * @ordered
	 */
	HOVER(6, "HOVER", "hover");

	/**
	 * The '<em><b>DOWN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOWN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOWN
	 * @model literal="down"
	 * @generated
	 * @ordered
	 */
	public static final int DOWN_VALUE = 0;

	/**
	 * The '<em><b>UP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UP
	 * @model literal="up"
	 * @generated
	 * @ordered
	 */
	public static final int UP_VALUE = 1;

	/**
	 * The '<em><b>MOVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MOVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOVE
	 * @model literal="move"
	 * @generated
	 * @ordered
	 */
	public static final int MOVE_VALUE = 2;

	/**
	 * The '<em><b>ENTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENTER
	 * @model literal="enter"
	 * @generated
	 * @ordered
	 */
	public static final int ENTER_VALUE = 3;

	/**
	 * The '<em><b>EXIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXIT
	 * @model literal="exit"
	 * @generated
	 * @ordered
	 */
	public static final int EXIT_VALUE = 4;

	/**
	 * The '<em><b>DOUBLE CLICK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE CLICK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_CLICK
	 * @model literal="double-click"
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_CLICK_VALUE = 5;

	/**
	 * The '<em><b>HOVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HOVER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HOVER
	 * @model literal="hover"
	 * @generated
	 * @ordered
	 */
	public static final int HOVER_VALUE = 6;

	/**
	 * An array of all the '<em><b>Mouse Event Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MouseEventKind[] VALUES_ARRAY =
		new MouseEventKind[] {
			DOWN,
			UP,
			MOVE,
			ENTER,
			EXIT,
			DOUBLE_CLICK,
			HOVER,
		};

	/**
	 * A public read-only list of all the '<em><b>Mouse Event Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MouseEventKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Mouse Event Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MouseEventKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MouseEventKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mouse Event Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MouseEventKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MouseEventKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mouse Event Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static MouseEventKind get(int value) {
		switch (value) {
			case DOWN_VALUE: return DOWN;
			case UP_VALUE: return UP;
			case MOVE_VALUE: return MOVE;
			case ENTER_VALUE: return ENTER;
			case EXIT_VALUE: return EXIT;
			case DOUBLE_CLICK_VALUE: return DOUBLE_CLICK;
			case HOVER_VALUE: return HOVER;
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
	private MouseEventKind(int value, String name, String literal) {
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
	
} //MouseEventKind
