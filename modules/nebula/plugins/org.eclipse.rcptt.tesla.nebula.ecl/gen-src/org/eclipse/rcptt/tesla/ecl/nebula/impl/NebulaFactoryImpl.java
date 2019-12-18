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
package org.eclipse.rcptt.tesla.ecl.nebula.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.rcptt.tesla.ecl.nebula.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NebulaFactoryImpl extends EFactoryImpl implements NebulaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NebulaFactory init() {
		try {
			NebulaFactory theNebulaFactory = (NebulaFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/rcptt/tesla/nebula/ecl"); 
			if (theNebulaFactory != null) {
				return theNebulaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NebulaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NebulaFactoryImpl() {
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
			case NebulaPackage.GET_NEBULA_GRID: return createGetNebulaGrid();
			case NebulaPackage.NEBULA_GRID: return createNebulaGrid();
			case NebulaPackage.NEBULA_GRID_ITEM: return createNebulaGridItem();
			case NebulaPackage.NEBULA_GRID_COLUMN: return createNebulaGridColumn();
			case NebulaPackage.GET_ROW_HEADER: return createGetRowHeader();
			case NebulaPackage.GET_ITEM_CELL: return createGetItemCell();
			case NebulaPackage.GET_EMPTY_AREA: return createGetEmptyArea();
			case NebulaPackage.SELECT_GRID_RANGE: return createSelectGridRange();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetNebulaGrid createGetNebulaGrid() {
		GetNebulaGridImpl getNebulaGrid = new GetNebulaGridImpl();
		return getNebulaGrid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NebulaGrid createNebulaGrid() {
		NebulaGridImpl nebulaGrid = new NebulaGridImpl();
		return nebulaGrid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NebulaGridItem createNebulaGridItem() {
		NebulaGridItemImpl nebulaGridItem = new NebulaGridItemImpl();
		return nebulaGridItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NebulaGridColumn createNebulaGridColumn() {
		NebulaGridColumnImpl nebulaGridColumn = new NebulaGridColumnImpl();
		return nebulaGridColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetRowHeader createGetRowHeader() {
		GetRowHeaderImpl getRowHeader = new GetRowHeaderImpl();
		return getRowHeader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetItemCell createGetItemCell() {
		GetItemCellImpl getItemCell = new GetItemCellImpl();
		return getItemCell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetEmptyArea createGetEmptyArea() {
		GetEmptyAreaImpl getEmptyArea = new GetEmptyAreaImpl();
		return getEmptyArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectGridRange createSelectGridRange() {
		SelectGridRangeImpl selectGridRange = new SelectGridRangeImpl();
		return selectGridRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NebulaPackage getNebulaPackage() {
		return (NebulaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NebulaPackage getPackage() {
		return NebulaPackage.eINSTANCE;
	}

} //NebulaFactoryImpl
