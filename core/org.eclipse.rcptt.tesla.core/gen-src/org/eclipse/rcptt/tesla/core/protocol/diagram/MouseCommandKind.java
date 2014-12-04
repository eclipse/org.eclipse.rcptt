/*******************************************************************************
 * Copyright (c) 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.tesla.core.protocol.diagram;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Mouse Command Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage#getMouseCommandKind()
 * @model
 * @generated
 */
public enum MouseCommandKind implements Enumerator {
	/**
	 * The '<em><b>Down</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOWN_VALUE
	 * @generated
	 * @ordered
	 */
	DOWN(0, "Down", "Down"),

	/**
	 * The '<em><b>Up</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UP_VALUE
	 * @generated
	 * @ordered
	 */
	UP(1, "Up", "Up"),

	/**
	 * The '<em><b>Move</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOVE_VALUE
	 * @generated
	 * @ordered
	 */
	MOVE(2, "Move", "Move"),

	/**
	 * The '<em><b>Drag</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRAG_VALUE
	 * @generated
	 * @ordered
	 */
	DRAG(3, "Drag", "Drag"),

	/**
	 * The '<em><b>Double Click</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_CLICK_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLE_CLICK(4, "DoubleClick", "DoubleClick"),

	/**
	 * The '<em><b>Native Drag Started</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NATIVE_DRAG_STARTED_VALUE
	 * @generated
	 * @ordered
	 */
	NATIVE_DRAG_STARTED(5, "NativeDragStarted", "NativeDragStarted"),

	/**
	 * The '<em><b>Native Drag Finished</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NATIVE_DRAG_FINISHED_VALUE
	 * @generated
	 * @ordered
	 */
	NATIVE_DRAG_FINISHED(6, "NativeDragFinished", "NativeDragFinished"),

	/**
	 * The '<em><b>Enter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENTER_VALUE
	 * @generated
	 * @ordered
	 */
	ENTER(7, "Enter", "Enter"),

	/**
	 * The '<em><b>Exit</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXIT_VALUE
	 * @generated
	 * @ordered
	 */
	EXIT(8, "Exit", "Exit"),

	/**
	 * The '<em><b>Hover</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOVER_VALUE
	 * @generated
	 * @ordered
	 */
	HOVER(9, "Hover", "Hover");

	/**
	 * The '<em><b>Down</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Down</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOWN
	 * @model name="Down"
	 * @generated
	 * @ordered
	 */
	public static final int DOWN_VALUE = 0;

	/**
	 * The '<em><b>Up</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Up</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UP
	 * @model name="Up"
	 * @generated
	 * @ordered
	 */
	public static final int UP_VALUE = 1;

	/**
	 * The '<em><b>Move</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Move</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOVE
	 * @model name="Move"
	 * @generated
	 * @ordered
	 */
	public static final int MOVE_VALUE = 2;

	/**
	 * The '<em><b>Drag</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Drag</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DRAG
	 * @model name="Drag"
	 * @generated
	 * @ordered
	 */
	public static final int DRAG_VALUE = 3;

	/**
	 * The '<em><b>Double Click</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Double Click</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_CLICK
	 * @model name="DoubleClick"
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE_CLICK_VALUE = 4;

	/**
	 * The '<em><b>Native Drag Started</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Native Drag Started</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NATIVE_DRAG_STARTED
	 * @model name="NativeDragStarted"
	 * @generated
	 * @ordered
	 */
	public static final int NATIVE_DRAG_STARTED_VALUE = 5;

	/**
	 * The '<em><b>Native Drag Finished</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Native Drag Finished</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NATIVE_DRAG_FINISHED
	 * @model name="NativeDragFinished"
	 * @generated
	 * @ordered
	 */
	public static final int NATIVE_DRAG_FINISHED_VALUE = 6;

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
	public static final int ENTER_VALUE = 7;

	/**
	 * The '<em><b>Exit</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Exit</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXIT
	 * @model name="Exit"
	 * @generated
	 * @ordered
	 */
	public static final int EXIT_VALUE = 8;

	/**
	 * The '<em><b>Hover</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hover</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HOVER
	 * @model name="Hover"
	 * @generated
	 * @ordered
	 */
	public static final int HOVER_VALUE = 9;

	/**
	 * An array of all the '<em><b>Mouse Command Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MouseCommandKind[] VALUES_ARRAY =
		new MouseCommandKind[] {
			DOWN,
			UP,
			MOVE,
			DRAG,
			DOUBLE_CLICK,
			NATIVE_DRAG_STARTED,
			NATIVE_DRAG_FINISHED,
			ENTER,
			EXIT,
			HOVER,
		};

	/**
	 * A public read-only list of all the '<em><b>Mouse Command Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MouseCommandKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Mouse Command Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MouseCommandKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MouseCommandKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mouse Command Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MouseCommandKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MouseCommandKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mouse Command Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MouseCommandKind get(int value) {
		switch (value) {
			case DOWN_VALUE: return DOWN;
			case UP_VALUE: return UP;
			case MOVE_VALUE: return MOVE;
			case DRAG_VALUE: return DRAG;
			case DOUBLE_CLICK_VALUE: return DOUBLE_CLICK;
			case NATIVE_DRAG_STARTED_VALUE: return NATIVE_DRAG_STARTED;
			case NATIVE_DRAG_FINISHED_VALUE: return NATIVE_DRAG_FINISHED;
			case ENTER_VALUE: return ENTER;
			case EXIT_VALUE: return EXIT;
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
	private MouseCommandKind(int value, String name, String literal) {
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
	
} //MouseCommandKind
