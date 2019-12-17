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
package org.eclipse.rcptt.verifications.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Verify Style Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getVerifyStyleType()
 * @model
 * @generated
 */
public enum VerifyStyleType implements Enumerator {
	/**
	 * The '<em><b>ALL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALL_VALUE
	 * @generated
	 * @ordered
	 */
	ALL(0, "ALL", "All"),

	/**
	 * The '<em><b>IGNORE STYLES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IGNORE_STYLES_VALUE
	 * @generated
	 * @ordered
	 */
	IGNORE_STYLES(1, "IGNORE_STYLES", "Ignore Styles"),

	/**
	 * The '<em><b>IGNORE STYLED TEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IGNORE_STYLED_TEXT_VALUE
	 * @generated
	 * @ordered
	 */
	IGNORE_STYLED_TEXT(2, "IGNORE_STYLED_TEXT", "Ignore Styled Text");

	/**
	 * The '<em><b>ALL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ALL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ALL
	 * @model literal="All"
	 * @generated
	 * @ordered
	 */
	public static final int ALL_VALUE = 0;

	/**
	 * The '<em><b>IGNORE STYLES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IGNORE STYLES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IGNORE_STYLES
	 * @model literal="Ignore Styles"
	 * @generated
	 * @ordered
	 */
	public static final int IGNORE_STYLES_VALUE = 1;

	/**
	 * The '<em><b>IGNORE STYLED TEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IGNORE STYLED TEXT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IGNORE_STYLED_TEXT
	 * @model literal="Ignore Styled Text"
	 * @generated
	 * @ordered
	 */
	public static final int IGNORE_STYLED_TEXT_VALUE = 2;

	/**
	 * An array of all the '<em><b>Verify Style Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final VerifyStyleType[] VALUES_ARRAY =
		new VerifyStyleType[] {
			ALL,
			IGNORE_STYLES,
			IGNORE_STYLED_TEXT,
		};

	/**
	 * A public read-only list of all the '<em><b>Verify Style Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<VerifyStyleType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Verify Style Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static VerifyStyleType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VerifyStyleType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Verify Style Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static VerifyStyleType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VerifyStyleType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Verify Style Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static VerifyStyleType get(int value) {
		switch (value) {
			case ALL_VALUE: return ALL;
			case IGNORE_STYLES_VALUE: return IGNORE_STYLES;
			case IGNORE_STYLED_TEXT_VALUE: return IGNORE_STYLED_TEXT;
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
	private VerifyStyleType(int value, String name, String literal) {
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
	
} //VerifyStyleType
