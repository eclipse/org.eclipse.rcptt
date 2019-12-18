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
 * A representation of the literals of the enumeration '<em><b>Tesla Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage#getTeslaMode()
 * @model
 * @generated
 */
public enum TeslaMode implements Enumerator {
	/**
	 * The '<em><b>Features</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FEATURES_VALUE
	 * @generated
	 * @ordered
	 */
	FEATURES(0, "Features", "Features"),

	/**
	 * The '<em><b>Recording</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECORDING_VALUE
	 * @generated
	 * @ordered
	 */
	RECORDING(1, "Recording", "Recording"),

	/**
	 * The '<em><b>Replay</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPLAY_VALUE
	 * @generated
	 * @ordered
	 */
	REPLAY(2, "Replay", "Replay"),

	/**
	 * The '<em><b>Assertions</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSERTIONS_VALUE
	 * @generated
	 * @ordered
	 */
	ASSERTIONS(3, "Assertions", "Assertions"), /**
												 * The '<em><b>Pause</b></em>' literal object.
												 * <!-- begin-user-doc -->
												 * <!-- end-user-doc -->
												 * @see #PAUSE_VALUE
												 * @generated
												 * @ordered
												 */
	PAUSE(4, "Pause", "Pause");

	/**
	 * The '<em><b>Features</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Features</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FEATURES
	 * @model name="Features"
	 * @generated
	 * @ordered
	 */
	public static final int FEATURES_VALUE = 0;

	/**
	 * The '<em><b>Recording</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Recording</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RECORDING
	 * @model name="Recording"
	 * @generated
	 * @ordered
	 */
	public static final int RECORDING_VALUE = 1;

	/**
	 * The '<em><b>Replay</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Replay</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REPLAY
	 * @model name="Replay"
	 * @generated
	 * @ordered
	 */
	public static final int REPLAY_VALUE = 2;

	/**
	 * The '<em><b>Assertions</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Assertions</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSERTIONS
	 * @model name="Assertions"
	 * @generated
	 * @ordered
	 */
	public static final int ASSERTIONS_VALUE = 3;

	/**
	 * The '<em><b>Pause</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pause</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PAUSE
	 * @model name="Pause"
	 * @generated
	 * @ordered
	 */
	public static final int PAUSE_VALUE = 4;

	/**
	 * An array of all the '<em><b>Tesla Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TeslaMode[] VALUES_ARRAY = new TeslaMode[]
	{
			FEATURES,
			RECORDING,
			REPLAY,
			ASSERTIONS,
			PAUSE,
	};

	/**
	 * A public read-only list of all the '<em><b>Tesla Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TeslaMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Tesla Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TeslaMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			TeslaMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tesla Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TeslaMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			TeslaMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Tesla Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TeslaMode get(int value) {
		switch (value)
		{
		case FEATURES_VALUE:
			return FEATURES;
		case RECORDING_VALUE:
			return RECORDING;
		case REPLAY_VALUE:
			return REPLAY;
		case ASSERTIONS_VALUE:
			return ASSERTIONS;
		case PAUSE_VALUE:
			return PAUSE;
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
	private TeslaMode(int value, String name, String literal) {
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

} //TeslaMode
