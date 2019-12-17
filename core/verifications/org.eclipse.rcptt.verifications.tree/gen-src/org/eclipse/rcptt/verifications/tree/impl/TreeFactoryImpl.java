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
package org.eclipse.rcptt.verifications.tree.impl;

import org.eclipse.rcptt.verifications.tree.*;

import org.eclipse.rcptt.tesla.core.ui.Image;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TreeFactoryImpl extends EFactoryImpl implements TreeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TreeFactory init() {
		try {
			TreeFactory theTreeFactory = (TreeFactory)EPackage.Registry.INSTANCE.getEFactory(TreePackage.eNS_URI);
			if (theTreeFactory != null) {
				return theTreeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TreeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TreePackage.TREE_VERIFICATION: return createTreeVerification();
			case TreePackage.TREE: return createTree();
			case TreePackage.COLUMN: return createColumn();
			case TreePackage.ROW: return createRow();
			case TreePackage.CELL: return createCell();
			case TreePackage.IMAGES_MAP: return (EObject)createImagesMap();
			case TreePackage.ITEM_DATA: return createItemData();
			case TreePackage.COMMON_TREE_VERIFICATION_DATA: return createCommonTreeVerificationData();
			case TreePackage.CAPTURE_TREE_VERIFICATION_DATA: return createCaptureTreeVerificationData();
			case TreePackage.VERIFY_TREE_DATA: return createVerifyTreeData();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TreePackage.VERIFY_STYLE_TYPE:
				return createVerifyStyleTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TreePackage.VERIFY_STYLE_TYPE:
				return convertVerifyStyleTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeVerification createTreeVerification() {
		TreeVerificationImpl treeVerification = new TreeVerificationImpl();
		return treeVerification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tree createTree() {
		TreeImpl tree = new TreeImpl();
		return tree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column createColumn() {
		ColumnImpl column = new ColumnImpl();
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Row createRow() {
		RowImpl row = new RowImpl();
		return row;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cell createCell() {
		CellImpl cell = new CellImpl();
		return cell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, byte[]> createImagesMap() {
		ImagesMapImpl imagesMap = new ImagesMapImpl();
		return imagesMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ItemData createItemData() {
		ItemDataImpl itemData = new ItemDataImpl();
		return itemData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonTreeVerificationData createCommonTreeVerificationData() {
		CommonTreeVerificationDataImpl commonTreeVerificationData = new CommonTreeVerificationDataImpl();
		return commonTreeVerificationData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaptureTreeVerificationData createCaptureTreeVerificationData() {
		CaptureTreeVerificationDataImpl captureTreeVerificationData = new CaptureTreeVerificationDataImpl();
		return captureTreeVerificationData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerifyTreeData createVerifyTreeData() {
		VerifyTreeDataImpl verifyTreeData = new VerifyTreeDataImpl();
		return verifyTreeData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerifyStyleType createVerifyStyleTypeFromString(EDataType eDataType, String initialValue) {
		VerifyStyleType result = VerifyStyleType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVerifyStyleTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreePackage getTreePackage() {
		return (TreePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TreePackage getPackage() {
		return TreePackage.eINSTANCE;
	}

} //TreeFactoryImpl
