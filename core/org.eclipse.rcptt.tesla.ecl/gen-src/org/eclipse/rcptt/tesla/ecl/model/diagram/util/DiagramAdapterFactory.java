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
package org.eclipse.rcptt.tesla.ecl.model.diagram.util;

import org.eclipse.rcptt.tesla.ecl.model.PathSelector;
import org.eclipse.rcptt.tesla.ecl.model.Selector;

import org.eclipse.rcptt.tesla.ecl.model.TextSelector;
import org.eclipse.rcptt.tesla.ecl.model.diagram.*;


import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.DiagramPackage
 * @generated
 */
public class DiagramAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DiagramPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DiagramPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramSwitch<Adapter> modelSwitch =
		new DiagramSwitch<Adapter>() {
			@Override
			public Adapter caseGetDiagram(GetDiagram object) {
				return createGetDiagramAdapter();
			}
			@Override
			public Adapter caseGetPalette(GetPalette object) {
				return createGetPaletteAdapter();
			}
			@Override
			public Adapter caseGetEditPart(GetEditPart object) {
				return createGetEditPartAdapter();
			}
			@Override
			public Adapter caseGetFigure(GetFigure object) {
				return createGetFigureAdapter();
			}
			@Override
			public Adapter caseGetEntry(GetEntry object) {
				return createGetEntryAdapter();
			}
			@Override
			public Adapter caseDirectEdit(DirectEdit object) {
				return createDirectEditAdapter();
			}
			@Override
			public Adapter caseActivateDirectEdit(ActivateDirectEdit object) {
				return createActivateDirectEditAdapter();
			}
			@Override
			public Adapter caseCommitDirectEdit(CommitDirectEdit object) {
				return createCommitDirectEditAdapter();
			}
			@Override
			public Adapter caseCancelDirectEdit(CancelDirectEdit object) {
				return createCancelDirectEditAdapter();
			}
			@Override
			public Adapter caseMouseAction(MouseAction object) {
				return createMouseActionAdapter();
			}
			@Override
			public Adapter caseMouseMove(MouseMove object) {
				return createMouseMoveAdapter();
			}
			@Override
			public Adapter caseMouseDrag(MouseDrag object) {
				return createMouseDragAdapter();
			}
			@Override
			public Adapter caseMousePress(MousePress object) {
				return createMousePressAdapter();
			}
			@Override
			public Adapter caseMouseRelease(MouseRelease object) {
				return createMouseReleaseAdapter();
			}
			@Override
			public Adapter caseMouseDoubleClick(MouseDoubleClick object) {
				return createMouseDoubleClickAdapter();
			}
			@Override
			public Adapter caseMouseEnter(MouseEnter object) {
				return createMouseEnterAdapter();
			}
			@Override
			public Adapter caseMouseExit(MouseExit object) {
				return createMouseExitAdapter();
			}
			@Override
			public Adapter caseMouseHover(MouseHover object) {
				return createMouseHoverAdapter();
			}
			@Override
			public Adapter caseGetSourceConnection(GetSourceConnection object) {
				return createGetSourceConnectionAdapter();
			}
			@Override
			public Adapter caseGetTargetConnection(GetTargetConnection object) {
				return createGetTargetConnectionAdapter();
			}
			@Override
			public Adapter caseGetPopupBarItem(GetPopupBarItem object) {
				return createGetPopupBarItemAdapter();
			}
			@Override
			public Adapter caseGetConnectionHandle(GetConnectionHandle object) {
				return createGetConnectionHandleAdapter();
			}
			@Override
			public Adapter caseGetPaletteEntry(GetPaletteEntry object) {
				return createGetPaletteEntryAdapter();
			}
			@Override
			public Adapter caseGetHandle(GetHandle object) {
				return createGetHandleAdapter();
			}
			@Override
			public Adapter caseCommand(Command object) {
				return createCommandAdapter();
			}
			@Override
			public Adapter caseSelector(Selector object) {
				return createSelectorAdapter();
			}
			@Override
			public Adapter casePathSelector(PathSelector object) {
				return createPathSelectorAdapter();
			}
			@Override
			public Adapter caseTextSelector(TextSelector object) {
				return createTextSelectorAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetDiagram <em>Get Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetDiagram
	 * @generated
	 */
	public Adapter createGetDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetPalette <em>Get Palette</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetPalette
	 * @generated
	 */
	public Adapter createGetPaletteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart <em>Get Edit Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart
	 * @generated
	 */
	public Adapter createGetEditPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetFigure <em>Get Figure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetFigure
	 * @generated
	 */
	public Adapter createGetFigureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetEntry <em>Get Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetEntry
	 * @generated
	 */
	public Adapter createGetEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.DirectEdit <em>Direct Edit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.DirectEdit
	 * @generated
	 */
	public Adapter createDirectEditAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.ActivateDirectEdit <em>Activate Direct Edit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.ActivateDirectEdit
	 * @generated
	 */
	public Adapter createActivateDirectEditAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.CommitDirectEdit <em>Commit Direct Edit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.CommitDirectEdit
	 * @generated
	 */
	public Adapter createCommitDirectEditAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.CancelDirectEdit <em>Cancel Direct Edit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.CancelDirectEdit
	 * @generated
	 */
	public Adapter createCancelDirectEditAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction <em>Mouse Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction
	 * @generated
	 */
	public Adapter createMouseActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseMove <em>Mouse Move</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseMove
	 * @generated
	 */
	public Adapter createMouseMoveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseDrag <em>Mouse Drag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseDrag
	 * @generated
	 */
	public Adapter createMouseDragAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MousePress <em>Mouse Press</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MousePress
	 * @generated
	 */
	public Adapter createMousePressAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseRelease <em>Mouse Release</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseRelease
	 * @generated
	 */
	public Adapter createMouseReleaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseDoubleClick <em>Mouse Double Click</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseDoubleClick
	 * @generated
	 */
	public Adapter createMouseDoubleClickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseEnter <em>Mouse Enter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseEnter
	 * @generated
	 */
	public Adapter createMouseEnterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseExit <em>Mouse Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseExit
	 * @generated
	 */
	public Adapter createMouseExitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.MouseHover <em>Mouse Hover</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.MouseHover
	 * @generated
	 */
	public Adapter createMouseHoverAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetSourceConnection <em>Get Source Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetSourceConnection
	 * @generated
	 */
	public Adapter createGetSourceConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetTargetConnection <em>Get Target Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetTargetConnection
	 * @generated
	 */
	public Adapter createGetTargetConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetPopupBarItem <em>Get Popup Bar Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetPopupBarItem
	 * @generated
	 */
	public Adapter createGetPopupBarItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetConnectionHandle <em>Get Connection Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetConnectionHandle
	 * @generated
	 */
	public Adapter createGetConnectionHandleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetPaletteEntry <em>Get Palette Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetPaletteEntry
	 * @generated
	 */
	public Adapter createGetPaletteEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.diagram.GetHandle <em>Get Handle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.diagram.GetHandle
	 * @generated
	 */
	public Adapter createGetHandleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.ecl.core.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.ecl.core.Command
	 * @generated
	 */
	public Adapter createCommandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.Selector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.Selector
	 * @generated
	 */
	public Adapter createSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.PathSelector <em>Path Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.PathSelector
	 * @generated
	 */
	public Adapter createPathSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.ecl.model.TextSelector <em>Text Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.ecl.model.TextSelector
	 * @generated
	 */
	public Adapter createTextSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DiagramAdapterFactory
