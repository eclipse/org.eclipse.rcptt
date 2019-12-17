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
 * A representation of the literals of the enumeration '<em><b>Assert Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getAssertKind()
 * @model
 * @generated
 */
public enum AssertKind implements Enumerator {
	/**
	 * The '<em><b>Equals</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUALS_VALUE
	 * @generated
	 * @ordered
	 */
	EQUALS(0, "Equals", "equals"),

	/**
	 * The '<em><b>Not Equals</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_EQUALS_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_EQUALS(1, "NotEquals", "doesn\'t equal"),

	/**
	 * The '<em><b>Not Null</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_NULL_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_NULL(2, "NotNull", "NotNull"), /**
	 * The '<em><b>Assert True</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSERT_TRUE_VALUE
	 * @generated
	 * @ordered
	 */
	ASSERT_TRUE(3, "AssertTrue", "is true"), /**
	 * The '<em><b>Assert False</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSERT_FALSE_VALUE
	 * @generated
	 * @ordered
	 */
	ASSERT_FALSE(4, "AssertFalse", "is false"), /**
	 * The '<em><b>Contains</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTAINS_VALUE
	 * @generated
	 * @ordered
	 */
	CONTAINS(5, "Contains", "contains"),

	/**
	 * The '<em><b>Regexp</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REGEXP_VALUE
	 * @generated
	 * @ordered
	 */
	REGEXP(6, "Regexp", "matches"), /**
	 * The '<em><b>Contains Image</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTAINS_IMAGE_VALUE
	 * @generated
	 * @ordered
	 */
	CONTAINS_IMAGE(7, "ContainsImage", "ContainsImage"), /**
	 * The '<em><b>Image Contains Text</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMAGE_CONTAINS_TEXT_VALUE
	 * @generated
	 * @ordered
	 */
	IMAGE_CONTAINS_TEXT(8, "ImageContainsText", "ImageContainsText"), /**
	 * The '<em><b>Not Contains</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_CONTAINS_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_CONTAINS(9, "NotContains", "doesn\'t contain"), /**
	 * The '<em><b>Not Regexp</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_REGEXP_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_REGEXP(10, "NotRegexp", "doesn\'t match"), /**
	 * The '<em><b>Is Empty</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IS_EMPTY_VALUE
	 * @generated
	 * @ordered
	 */
	IS_EMPTY(11, "IsEmpty", "is empty"), /**
	 * The '<em><b>Not Empty</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_EMPTY_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_EMPTY(12, "NotEmpty", "isn\'t empty");

	/**
	 * The '<em><b>Equals</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Equals</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUALS
	 * @model name="Equals" literal="equals"
	 * @generated
	 * @ordered
	 */
	public static final int EQUALS_VALUE = 0;

	/**
	 * The '<em><b>Not Equals</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Not Equals</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_EQUALS
	 * @model name="NotEquals" literal="doesn\'t equal"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_EQUALS_VALUE = 1;

	/**
	 * The '<em><b>Not Null</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Not Null</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_NULL
	 * @model name="NotNull"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_NULL_VALUE = 2;

	/**
	 * The '<em><b>Assert True</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Assert True</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSERT_TRUE
	 * @model name="AssertTrue" literal="is true"
	 * @generated
	 * @ordered
	 */
	public static final int ASSERT_TRUE_VALUE = 3;

	/**
	 * The '<em><b>Assert False</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Assert False</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSERT_FALSE
	 * @model name="AssertFalse" literal="is false"
	 * @generated
	 * @ordered
	 */
	public static final int ASSERT_FALSE_VALUE = 4;

	/**
	 * The '<em><b>Contains</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Contains</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTAINS
	 * @model name="Contains" literal="contains"
	 * @generated
	 * @ordered
	 */
	public static final int CONTAINS_VALUE = 5;

	/**
	 * The '<em><b>Regexp</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Regexp</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REGEXP
	 * @model name="Regexp" literal="matches"
	 * @generated
	 * @ordered
	 */
	public static final int REGEXP_VALUE = 6;

	/**
	 * The '<em><b>Contains Image</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Contains Image</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTAINS_IMAGE
	 * @model name="ContainsImage"
	 * @generated
	 * @ordered
	 */
	public static final int CONTAINS_IMAGE_VALUE = 7;

	/**
	 * The '<em><b>Image Contains Text</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Image Contains Text</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IMAGE_CONTAINS_TEXT
	 * @model name="ImageContainsText"
	 * @generated
	 * @ordered
	 */
	public static final int IMAGE_CONTAINS_TEXT_VALUE = 8;

	/**
	 * The '<em><b>Not Contains</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Not Contains</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_CONTAINS
	 * @model name="NotContains" literal="doesn\'t contain"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_CONTAINS_VALUE = 9;

	/**
	 * The '<em><b>Not Regexp</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Not Regexp</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_REGEXP
	 * @model name="NotRegexp" literal="doesn\'t match"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_REGEXP_VALUE = 10;

	/**
	 * The '<em><b>Is Empty</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Is Empty</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IS_EMPTY
	 * @model name="IsEmpty" literal="is empty"
	 * @generated
	 * @ordered
	 */
	public static final int IS_EMPTY_VALUE = 11;

	/**
	 * The '<em><b>Not Empty</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Not Empty</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_EMPTY
	 * @model name="NotEmpty" literal="isn\'t empty"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_EMPTY_VALUE = 12;

	/**
	 * An array of all the '<em><b>Assert Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AssertKind[] VALUES_ARRAY =
		new AssertKind[] {
			EQUALS,
			NOT_EQUALS,
			NOT_NULL,
			ASSERT_TRUE,
			ASSERT_FALSE,
			CONTAINS,
			REGEXP,
			CONTAINS_IMAGE,
			IMAGE_CONTAINS_TEXT,
			NOT_CONTAINS,
			NOT_REGEXP,
			IS_EMPTY,
			NOT_EMPTY,
		};

	/**
	 * A public read-only list of all the '<em><b>Assert Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AssertKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Assert Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AssertKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AssertKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Assert Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AssertKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AssertKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Assert Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AssertKind get(int value) {
		switch (value) {
			case EQUALS_VALUE: return EQUALS;
			case NOT_EQUALS_VALUE: return NOT_EQUALS;
			case NOT_NULL_VALUE: return NOT_NULL;
			case ASSERT_TRUE_VALUE: return ASSERT_TRUE;
			case ASSERT_FALSE_VALUE: return ASSERT_FALSE;
			case CONTAINS_VALUE: return CONTAINS;
			case REGEXP_VALUE: return REGEXP;
			case CONTAINS_IMAGE_VALUE: return CONTAINS_IMAGE;
			case IMAGE_CONTAINS_TEXT_VALUE: return IMAGE_CONTAINS_TEXT;
			case NOT_CONTAINS_VALUE: return NOT_CONTAINS;
			case NOT_REGEXP_VALUE: return NOT_REGEXP;
			case IS_EMPTY_VALUE: return IS_EMPTY;
			case NOT_EMPTY_VALUE: return NOT_EMPTY;
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
	private AssertKind(int value, String name, String literal) {
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
	
} //AssertKind
