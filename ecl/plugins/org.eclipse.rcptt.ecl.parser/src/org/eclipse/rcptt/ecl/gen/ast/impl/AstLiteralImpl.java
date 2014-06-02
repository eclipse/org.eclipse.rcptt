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
package org.eclipse.rcptt.ecl.gen.ast.impl;



import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.rcptt.ecl.core.impl.LiteralParameterImpl;
import org.eclipse.rcptt.ecl.gen.ast.AstLiteral;
import org.eclipse.rcptt.ecl.gen.ast.AstNode;
import org.eclipse.rcptt.ecl.gen.ast.AstPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.gen.ast.impl.AstLiteralImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.gen.ast.impl.AstLiteralImpl#getLine <em>Line</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.gen.ast.impl.AstLiteralImpl#getLength <em>Length</em>}</li>
 *   <li>{@link org.eclipse.rcptt.ecl.gen.ast.impl.AstLiteralImpl#getResourceID <em>Resource ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AstLiteralImpl extends LiteralParameterImpl implements AstLiteral {
	/**
	 * The default value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected static final int COLUMN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected int column = COLUMN_EDEFAULT;

	/**
	 * The default value of the '{@link #getLine() <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLine() <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLine()
	 * @generated
	 * @ordered
	 */
	protected int line = LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final int LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected int length = LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceID() <em>Resource ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceID()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceID() <em>Resource ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceID()
	 * @generated
	 * @ordered
	 */
	protected String resourceID = RESOURCE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AstLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.AST_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumn(int newColumn) {
		int oldColumn = column;
		column = newColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.AST_LITERAL__COLUMN, oldColumn, column));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLine() {
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLine(int newLine) {
		int oldLine = line;
		line = newLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.AST_LITERAL__LINE, oldLine, line));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLength(int newLength) {
		int oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.AST_LITERAL__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceID() {
		return resourceID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceID(String newResourceID) {
		String oldResourceID = resourceID;
		resourceID = newResourceID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.AST_LITERAL__RESOURCE_ID, oldResourceID, resourceID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstPackage.AST_LITERAL__COLUMN:
				return getColumn();
			case AstPackage.AST_LITERAL__LINE:
				return getLine();
			case AstPackage.AST_LITERAL__LENGTH:
				return getLength();
			case AstPackage.AST_LITERAL__RESOURCE_ID:
				return getResourceID();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AstPackage.AST_LITERAL__COLUMN:
				setColumn((Integer)newValue);
				return;
			case AstPackage.AST_LITERAL__LINE:
				setLine((Integer)newValue);
				return;
			case AstPackage.AST_LITERAL__LENGTH:
				setLength((Integer)newValue);
				return;
			case AstPackage.AST_LITERAL__RESOURCE_ID:
				setResourceID((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AstPackage.AST_LITERAL__COLUMN:
				setColumn(COLUMN_EDEFAULT);
				return;
			case AstPackage.AST_LITERAL__LINE:
				setLine(LINE_EDEFAULT);
				return;
			case AstPackage.AST_LITERAL__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case AstPackage.AST_LITERAL__RESOURCE_ID:
				setResourceID(RESOURCE_ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AstPackage.AST_LITERAL__COLUMN:
				return column != COLUMN_EDEFAULT;
			case AstPackage.AST_LITERAL__LINE:
				return line != LINE_EDEFAULT;
			case AstPackage.AST_LITERAL__LENGTH:
				return length != LENGTH_EDEFAULT;
			case AstPackage.AST_LITERAL__RESOURCE_ID:
				return RESOURCE_ID_EDEFAULT == null ? resourceID != null : !RESOURCE_ID_EDEFAULT.equals(resourceID);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == AstNode.class) {
			switch (derivedFeatureID) {
				case AstPackage.AST_LITERAL__COLUMN: return AstPackage.AST_NODE__COLUMN;
				case AstPackage.AST_LITERAL__LINE: return AstPackage.AST_NODE__LINE;
				case AstPackage.AST_LITERAL__LENGTH: return AstPackage.AST_NODE__LENGTH;
				case AstPackage.AST_LITERAL__RESOURCE_ID: return AstPackage.AST_NODE__RESOURCE_ID;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == AstNode.class) {
			switch (baseFeatureID) {
				case AstPackage.AST_NODE__COLUMN: return AstPackage.AST_LITERAL__COLUMN;
				case AstPackage.AST_NODE__LINE: return AstPackage.AST_LITERAL__LINE;
				case AstPackage.AST_NODE__LENGTH: return AstPackage.AST_LITERAL__LENGTH;
				case AstPackage.AST_NODE__RESOURCE_ID: return AstPackage.AST_LITERAL__RESOURCE_ID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (column: ");
		result.append(column);
		result.append(", line: ");
		result.append(line);
		result.append(", length: ");
		result.append(length);
		result.append(", resourceID: ");
		result.append(resourceID);
		result.append(')');
		return result.toString();
	}

} //AstLiteralImpl
