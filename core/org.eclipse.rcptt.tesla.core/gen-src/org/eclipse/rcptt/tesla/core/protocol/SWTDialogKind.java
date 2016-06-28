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
 * A representation of the literals of the enumeration '<em><b>SWT Dialog Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#getSWTDialogKind()
 * @model
 * @generated
 */
public enum SWTDialogKind implements Enumerator {
	/**
	 * The '<em><b>File Selector</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILE_SELECTOR_VALUE
	 * @generated
	 * @ordered
	 */
	FILE_SELECTOR(0, "FileSelector", "FileSelector"),

	/**
	 * The '<em><b>Folder Selector</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOLDER_SELECTOR_VALUE
	 * @generated
	 * @ordered
	 */
	FOLDER_SELECTOR(1, "FolderSelector", "FolderSelector"),

	/**
	 * The '<em><b>Font Dialog</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FONT_DIALOG_VALUE
	 * @generated
	 * @ordered
	 */
	FONT_DIALOG(2, "FontDialog", "FontDialog"),

	/**
	 * The '<em><b>Message Box</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_BOX_VALUE
	 * @generated
	 * @ordered
	 */
	MESSAGE_BOX(3, "MessageBox", "MessageBox"),

	/**
	 * The '<em><b>Color</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLOR_VALUE
	 * @generated
	 * @ordered
	 */
	COLOR(4, "Color", "Color");

	/**
	 * The '<em><b>File Selector</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>File Selector</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILE_SELECTOR
	 * @model name="FileSelector"
	 * @generated
	 * @ordered
	 */
	public static final int FILE_SELECTOR_VALUE = 0;

	/**
	 * The '<em><b>Folder Selector</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Folder Selector</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOLDER_SELECTOR
	 * @model name="FolderSelector"
	 * @generated
	 * @ordered
	 */
	public static final int FOLDER_SELECTOR_VALUE = 1;

	/**
	 * The '<em><b>Font Dialog</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Font Dialog</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FONT_DIALOG
	 * @model name="FontDialog"
	 * @generated
	 * @ordered
	 */
	public static final int FONT_DIALOG_VALUE = 2;

	/**
	 * The '<em><b>Message Box</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Message Box</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MESSAGE_BOX
	 * @model name="MessageBox"
	 * @generated
	 * @ordered
	 */
	public static final int MESSAGE_BOX_VALUE = 3;

	/**
	 * The '<em><b>Color</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Color</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COLOR
	 * @model name="Color"
	 * @generated
	 * @ordered
	 */
	public static final int COLOR_VALUE = 4;

	/**
	 * An array of all the '<em><b>SWT Dialog Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SWTDialogKind[] VALUES_ARRAY =
		new SWTDialogKind[] {
			FILE_SELECTOR,
			FOLDER_SELECTOR,
			FONT_DIALOG,
			MESSAGE_BOX,
			COLOR,
		};

	/**
	 * A public read-only list of all the '<em><b>SWT Dialog Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SWTDialogKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>SWT Dialog Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SWTDialogKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SWTDialogKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SWT Dialog Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SWTDialogKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SWTDialogKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SWT Dialog Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SWTDialogKind get(int value) {
		switch (value) {
			case FILE_SELECTOR_VALUE: return FILE_SELECTOR;
			case FOLDER_SELECTOR_VALUE: return FOLDER_SELECTOR;
			case FONT_DIALOG_VALUE: return FONT_DIALOG;
			case MESSAGE_BOX_VALUE: return MESSAGE_BOX;
			case COLOR_VALUE: return COLOR;
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
	private SWTDialogKind(int value, String name, String literal) {
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
	
} //SWTDialogKind
