/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core.protocol.raw;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Command Transfer Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getCommandTransferKind()
 * @model
 * @generated
 */
public enum CommandTransferKind implements Enumerator {
	/**
	 * The '<em><b>Default</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEFAULT_VALUE
	 * @generated
	 * @ordered
	 */
	DEFAULT(0, "Default", "Default"),

	/**
	 * The '<em><b>Replace Previous</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPLACE_PREVIOUS_VALUE
	 * @generated
	 * @ordered
	 */
	REPLACE_PREVIOUS(1, "ReplacePrevious", "ReplacePrevious"),

	/**
	 * The '<em><b>Insert Before Essential Command</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSERT_BEFORE_ESSENTIAL_COMMAND_VALUE
	 * @generated
	 * @ordered
	 */
	INSERT_BEFORE_ESSENTIAL_COMMAND(2, "InsertBeforeEssentialCommand",
			"InsertBeforeEssentialCommand"),

	/**
	 * The '<em><b>Insert Before</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSERT_BEFORE_VALUE
	 * @generated
	 * @ordered
	 */
	INSERT_BEFORE(3, "InsertBefore", "InsertBefore"), /**
														 * The '<em><b>Remove</b></em>' literal object.
														 * <!-- begin-user-doc -->
														 * <!-- end-user-doc -->
														 * @see #REMOVE_VALUE
														 * @generated
														 * @ordered
														 */
	REMOVE(4, "Remove", "Remove");

	/**
	 * The '<em><b>Default</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Default</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEFAULT
	 * @model name="Default"
	 * @generated
	 * @ordered
	 */
	public static final int DEFAULT_VALUE = 0;

	/**
	 * The '<em><b>Replace Previous</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Replace Previous</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REPLACE_PREVIOUS
	 * @model name="ReplacePrevious"
	 * @generated
	 * @ordered
	 */
	public static final int REPLACE_PREVIOUS_VALUE = 1;

	/**
	 * The '<em><b>Insert Before Essential Command</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Insert Before Essential Command</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSERT_BEFORE_ESSENTIAL_COMMAND
	 * @model name="InsertBeforeEssentialCommand"
	 * @generated
	 * @ordered
	 */
	public static final int INSERT_BEFORE_ESSENTIAL_COMMAND_VALUE = 2;

	/**
	 * The '<em><b>Insert Before</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Insert Before</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSERT_BEFORE
	 * @model name="InsertBefore"
	 * @generated
	 * @ordered
	 */
	public static final int INSERT_BEFORE_VALUE = 3;

	/**
	 * The '<em><b>Remove</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Remove</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REMOVE
	 * @model name="Remove"
	 * @generated
	 * @ordered
	 */
	public static final int REMOVE_VALUE = 4;

	/**
	 * An array of all the '<em><b>Command Transfer Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CommandTransferKind[] VALUES_ARRAY = new CommandTransferKind[]
	{
			DEFAULT,
			REPLACE_PREVIOUS,
			INSERT_BEFORE_ESSENTIAL_COMMAND,
			INSERT_BEFORE,
			REMOVE,
	};

	/**
	 * A public read-only list of all the '<em><b>Command Transfer Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CommandTransferKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Command Transfer Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommandTransferKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			CommandTransferKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Command Transfer Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommandTransferKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			CommandTransferKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Command Transfer Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommandTransferKind get(int value) {
		switch (value)
		{
		case DEFAULT_VALUE:
			return DEFAULT;
		case REPLACE_PREVIOUS_VALUE:
			return REPLACE_PREVIOUS;
		case INSERT_BEFORE_ESSENTIAL_COMMAND_VALUE:
			return INSERT_BEFORE_ESSENTIAL_COMMAND;
		case INSERT_BEFORE_VALUE:
			return INSERT_BEFORE;
		case REMOVE_VALUE:
			return REMOVE;
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
	private CommandTransferKind(int value, String name, String literal) {
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

} //CommandTransferKind
