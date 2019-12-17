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
 * A representation of the literals of the enumeration '<em><b>Collapse Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.verifications.tree.TreePackage#getCollapseType()
 * @model
 * @generated
 */
public enum CollapseType implements Enumerator {
	/**
	 * The '<em><b>AS IS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AS_IS_VALUE
	 * @generated
	 * @ordered
	 */
	AS_IS(0, "AS_IS", "As is"),

	/**
	 * The '<em><b>EXPAND ALL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXPAND_ALL_VALUE
	 * @generated
	 * @ordered
	 */
	EXPAND_ALL(1, "EXPAND_ALL", "Expand all"),

	/**
	 * The '<em><b>COLLAPSE ALL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLLAPSE_ALL_VALUE
	 * @generated
	 * @ordered
	 */
	COLLAPSE_ALL(2, "COLLAPSE_ALL", "Collapse all");

	/**
	 * The '<em><b>AS IS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AS IS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AS_IS
	 * @model literal="As is"
	 * @generated
	 * @ordered
	 */
	public static final int AS_IS_VALUE = 0;

	/**
	 * The '<em><b>EXPAND ALL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXPAND ALL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXPAND_ALL
	 * @model literal="Expand all"
	 * @generated
	 * @ordered
	 */
	public static final int EXPAND_ALL_VALUE = 1;

	/**
	 * The '<em><b>COLLAPSE ALL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COLLAPSE ALL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COLLAPSE_ALL
	 * @model literal="Collapse all"
	 * @generated
	 * @ordered
	 */
	public static final int COLLAPSE_ALL_VALUE = 2;

	/**
	 * An array of all the '<em><b>Collapse Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CollapseType[] VALUES_ARRAY =
		new CollapseType[] {
			AS_IS,
			EXPAND_ALL,
			COLLAPSE_ALL,
		};

	/**
	 * A public read-only list of all the '<em><b>Collapse Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CollapseType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Collapse Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollapseType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollapseType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collapse Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollapseType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollapseType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collapse Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollapseType get(int value) {
		switch (value) {
			case AS_IS_VALUE: return AS_IS;
			case EXPAND_ALL_VALUE: return EXPAND_ALL;
			case COLLAPSE_ALL_VALUE: return COLLAPSE_ALL;
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
	private CollapseType(int value, String name, String literal) {
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
	
} //CollapseType
