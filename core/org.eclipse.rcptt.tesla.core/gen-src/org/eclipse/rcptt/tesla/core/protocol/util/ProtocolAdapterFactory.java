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
package org.eclipse.rcptt.tesla.core.protocol.util;

import org.eclipse.rcptt.tesla.core.protocol.*;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage
 * @generated
 */
public class ProtocolAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProtocolPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ProtocolPackage.eINSTANCE;
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
	protected ProtocolSwitch<Adapter> modelSwitch =
		new ProtocolSwitch<Adapter>() {
			@Override
			public Adapter caseSelectData(SelectData object) {
				return createSelectDataAdapter();
			}
			@Override
			public Adapter caseIMLSelectData(IMLSelectData object) {
				return createIMLSelectDataAdapter();
			}
			@Override
			public Adapter caseSelectCommand(SelectCommand object) {
				return createSelectCommandAdapter();
			}
			@Override
			public Adapter caseSelectResponse(SelectResponse object) {
				return createSelectResponseAdapter();
			}
			@Override
			public Adapter caseElementCommand(ElementCommand object) {
				return createElementCommandAdapter();
			}
			@Override
			public Adapter caseClick(Click object) {
				return createClickAdapter();
			}
			@Override
			public Adapter caseDoubleClick(DoubleClick object) {
				return createDoubleClickAdapter();
			}
			@Override
			public Adapter caseShow(Show object) {
				return createShowAdapter();
			}
			@Override
			public Adapter caseHide(Hide object) {
				return createHideAdapter();
			}
			@Override
			public Adapter caseClose(Close object) {
				return createCloseAdapter();
			}
			@Override
			public Adapter caseGetText(GetText object) {
				return createGetTextAdapter();
			}
			@Override
			public Adapter caseGetTextResponse(GetTextResponse object) {
				return createGetTextResponseAdapter();
			}
			@Override
			public Adapter caseBooleanResponse(BooleanResponse object) {
				return createBooleanResponseAdapter();
			}
			@Override
			public Adapter caseIsEnabled(IsEnabled object) {
				return createIsEnabledAdapter();
			}
			@Override
			public Adapter caseIsDisposed(IsDisposed object) {
				return createIsDisposedAdapter();
			}
			@Override
			public Adapter caseSetText(SetText object) {
				return createSetTextAdapter();
			}
			@Override
			public Adapter caseGetState(GetState object) {
				return createGetStateAdapter();
			}
			@Override
			public Adapter caseGetStateResponse(GetStateResponse object) {
				return createGetStateResponseAdapter();
			}
			@Override
			public Adapter caseWaitForState(WaitForState object) {
				return createWaitForStateAdapter();
			}
			@Override
			public Adapter caseRollbackToState(RollbackToState object) {
				return createRollbackToStateAdapter();
			}
			@Override
			public Adapter caseSetSelection(SetSelection object) {
				return createSetSelectionAdapter();
			}
			@Override
			public Adapter caseMultiSelectionItem(MultiSelectionItem object) {
				return createMultiSelectionItemAdapter();
			}
			@Override
			public Adapter caseShutdown(Shutdown object) {
				return createShutdownAdapter();
			}
			@Override
			public Adapter caseNop(Nop object) {
				return createNopAdapter();
			}
			@Override
			public Adapter caseCountItems(CountItems object) {
				return createCountItemsAdapter();
			}
			@Override
			public Adapter caseIntResponse(IntResponse object) {
				return createIntResponseAdapter();
			}
			@Override
			public Adapter caseSave(Save object) {
				return createSaveAdapter();
			}
			@Override
			public Adapter caseIsDirty(IsDirty object) {
				return createIsDirtyAdapter();
			}
			@Override
			public Adapter caseSetTextSelection(SetTextSelection object) {
				return createSetTextSelectionAdapter();
			}
			@Override
			public Adapter caseSetTextOffset(SetTextOffset object) {
				return createSetTextOffsetAdapter();
			}
			@Override
			public Adapter caseShowSelection(ShowSelection object) {
				return createShowSelectionAdapter();
			}
			@Override
			public Adapter caseGetTextSelection(GetTextSelection object) {
				return createGetTextSelectionAdapter();
			}
			@Override
			public Adapter caseGoToTextLine(GoToTextLine object) {
				return createGoToTextLineAdapter();
			}
			@Override
			public Adapter caseGetTextLineOffset(GetTextLineOffset object) {
				return createGetTextLineOffsetAdapter();
			}
			@Override
			public Adapter caseGetTextLineLength(GetTextLineLength object) {
				return createGetTextLineLengthAdapter();
			}
			@Override
			public Adapter caseSelectTextLine(SelectTextLine object) {
				return createSelectTextLineAdapter();
			}
			@Override
			public Adapter caseSetCaretPosition(SetCaretPosition object) {
				return createSetCaretPositionAdapter();
			}
			@Override
			public Adapter caseGetTextLine(GetTextLine object) {
				return createGetTextLineAdapter();
			}
			@Override
			public Adapter caseGetTextRange(GetTextRange object) {
				return createGetTextRangeAdapter();
			}
			@Override
			public Adapter caseTextSelectionResponse(TextSelectionResponse object) {
				return createTextSelectionResponseAdapter();
			}
			@Override
			public Adapter caseGetColor(GetColor object) {
				return createGetColorAdapter();
			}
			@Override
			public Adapter caseSetColor(SetColor object) {
				return createSetColorAdapter();
			}
			@Override
			public Adapter caseGetColorResponse(GetColorResponse object) {
				return createGetColorResponseAdapter();
			}
			@Override
			public Adapter caseTypeText(TypeText object) {
				return createTypeTextAdapter();
			}
			@Override
			public Adapter caseChildren(Children object) {
				return createChildrenAdapter();
			}
			@Override
			public Adapter caseChildrenResponse(ChildrenResponse object) {
				return createChildrenResponseAdapter();
			}
			@Override
			public Adapter caseParent(Parent object) {
				return createParentAdapter();
			}
			@Override
			public Adapter caseParentResponse(ParentResponse object) {
				return createParentResponseAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter caseTypeAction(TypeAction object) {
				return createTypeActionAdapter();
			}
			@Override
			public Adapter caseCopyTextSelection(CopyTextSelection object) {
				return createCopyTextSelectionAdapter();
			}
			@Override
			public Adapter caseCutTextSelection(CutTextSelection object) {
				return createCutTextSelectionAdapter();
			}
			@Override
			public Adapter casePasteTextSelection(PasteTextSelection object) {
				return createPasteTextSelectionAdapter();
			}
			@Override
			public Adapter caseReplaceTextSelection(ReplaceTextSelection object) {
				return createReplaceTextSelectionAdapter();
			}
			@Override
			public Adapter caseCheckItem(CheckItem object) {
				return createCheckItemAdapter();
			}
			@Override
			public Adapter caseExpand(Expand object) {
				return createExpandAdapter();
			}
			@Override
			public Adapter caseCloseWorkbench(CloseWorkbench object) {
				return createCloseWorkbenchAdapter();
			}
			@Override
			public Adapter caseActivateCellEditor(ActivateCellEditor object) {
				return createActivateCellEditorAdapter();
			}
			@Override
			public Adapter caseApplyCellEditor(ApplyCellEditor object) {
				return createApplyCellEditorAdapter();
			}
			@Override
			public Adapter caseCancelCellEditor(CancelCellEditor object) {
				return createCancelCellEditorAdapter();
			}
			@Override
			public Adapter caseDeactivateCellEditor(DeactivateCellEditor object) {
				return createDeactivateCellEditorAdapter();
			}
			@Override
			public Adapter caseSetSWTDialogInfo(SetSWTDialogInfo object) {
				return createSetSWTDialogInfoAdapter();
			}
			@Override
			public Adapter caseAssert(Assert object) {
				return createAssertAdapter();
			}
			@Override
			public Adapter caseGetRegionText(GetRegionText object) {
				return createGetRegionTextAdapter();
			}
			@Override
			public Adapter caseAssertImageData(AssertImageData object) {
				return createAssertImageDataAdapter();
			}
			@Override
			public Adapter caseAssertResponse(AssertResponse object) {
				return createAssertResponseAdapter();
			}
			@Override
			public Adapter caseGetSelection(GetSelection object) {
				return createGetSelectionAdapter();
			}
			@Override
			public Adapter caseSelectionResponse(SelectionResponse object) {
				return createSelectionResponseAdapter();
			}
			@Override
			public Adapter caseSelectionItem(SelectionItem object) {
				return createSelectionItemAdapter();
			}
			@Override
			public Adapter caseDragCommand(DragCommand object) {
				return createDragCommandAdapter();
			}
			@Override
			public Adapter caseWaitForRestart(WaitForRestart object) {
				return createWaitForRestartAdapter();
			}
			@Override
			public Adapter caseCellClick(CellClick object) {
				return createCellClickAdapter();
			}
			@Override
			public Adapter caseShowContentAssist(ShowContentAssist object) {
				return createShowContentAssistAdapter();
			}
			@Override
			public Adapter caseClickAboutMenu(ClickAboutMenu object) {
				return createClickAboutMenuAdapter();
			}
			@Override
			public Adapter caseClickPreferencesMenu(ClickPreferencesMenu object) {
				return createClickPreferencesMenuAdapter();
			}
			@Override
			public Adapter caseRecordingModeRequest(RecordingModeRequest object) {
				return createRecordingModeRequestAdapter();
			}
			@Override
			public Adapter caseAssertionModeRequest(AssertionModeRequest object) {
				return createAssertionModeRequestAdapter();
			}
			@Override
			public Adapter caseMinimize(Minimize object) {
				return createMinimizeAdapter();
			}
			@Override
			public Adapter caseMaximize(Maximize object) {
				return createMaximizeAdapter();
			}
			@Override
			public Adapter caseRestore(Restore object) {
				return createRestoreAdapter();
			}
			@Override
			public Adapter caseShowTabList(ShowTabList object) {
				return createShowTabListAdapter();
			}
			@Override
			public Adapter caseSetStatusDialogMode(SetStatusDialogMode object) {
				return createSetStatusDialogModeAdapter();
			}
			@Override
			public Adapter caseCheck(Check object) {
				return createCheckAdapter();
			}
			@Override
			public Adapter caseHoverAtTextOffset(HoverAtTextOffset object) {
				return createHoverAtTextOffsetAdapter();
			}
			@Override
			public Adapter caseSetCursorOffset(SetCursorOffset object) {
				return createSetCursorOffsetAdapter();
			}
			@Override
			public Adapter caseSetTextSelection2(SetTextSelection2 object) {
				return createSetTextSelection2Adapter();
			}
			@Override
			public Adapter caseHoverAtText(HoverAtText object) {
				return createHoverAtTextAdapter();
			}
			@Override
			public Adapter caseOpenDeclaration(OpenDeclaration object) {
				return createOpenDeclarationAdapter();
			}
			@Override
			public Adapter caseRulerClick(RulerClick object) {
				return createRulerClickAdapter();
			}
			@Override
			public Adapter caseRulerDoubleClick(RulerDoubleClick object) {
				return createRulerDoubleClickAdapter();
			}
			@Override
			public Adapter caseRulerHover(RulerHover object) {
				return createRulerHoverAdapter();
			}
			@Override
			public Adapter caseClickLink(ClickLink object) {
				return createClickLinkAdapter();
			}
			@Override
			public Adapter caseSetFocus(SetFocus object) {
				return createSetFocusAdapter();
			}
			@Override
			public Adapter caseGetPropertyValue(GetPropertyValue object) {
				return createGetPropertyValueAdapter();
			}
			@Override
			public Adapter caseObjectResponse(ObjectResponse object) {
				return createObjectResponseAdapter();
			}
			@Override
			public Adapter caseGetBounds(GetBounds object) {
				return createGetBoundsAdapter();
			}
			@Override
			public Adapter caseBoundsResponse(BoundsResponse object) {
				return createBoundsResponseAdapter();
			}
			@Override
			public Adapter caseCollapse(Collapse object) {
				return createCollapseAdapter();
			}
			@Override
			public Adapter caseClickColumn(ClickColumn object) {
				return createClickColumnAdapter();
			}
			@Override
			public Adapter caseSetSortColumn(SetSortColumn object) {
				return createSetSortColumnAdapter();
			}
			@Override
			public Adapter caseMouseEvent(MouseEvent object) {
				return createMouseEventAdapter();
			}
			@Override
			public Adapter caseClickText(ClickText object) {
				return createClickTextAdapter();
			}
			@Override
			public Adapter caseDoubleClickText(DoubleClickText object) {
				return createDoubleClickTextAdapter();
			}
			@Override
			public Adapter caseSetWidth(SetWidth object) {
				return createSetWidthAdapter();
			}
			@Override
			public Adapter caseSetPosition(SetPosition object) {
				return createSetPositionAdapter();
			}
			@Override
			public Adapter caseUpdateControlCommand(UpdateControlCommand object) {
				return createUpdateControlCommandAdapter();
			}
			@Override
			public Adapter caseRapDownloadFile(RapDownloadFile object) {
				return createRapDownloadFileAdapter();
			}
			@Override
			public Adapter caseRapUploadFile(RapUploadFile object) {
				return createRapUploadFileAdapter();
			}
			@Override
			public Adapter caseGetItems(GetItems object) {
				return createGetItemsAdapter();
			}
			@Override
			public Adapter caseGetItemsResponse(GetItemsResponse object) {
				return createGetItemsResponseAdapter();
			}
			@Override
			public Adapter caseCommand(Command object) {
				return createCommandAdapter();
			}
			@Override
			public Adapter caseResponse(Response object) {
				return createResponseAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SelectData <em>Select Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectData
	 * @generated
	 */
	public Adapter createSelectDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.IMLSelectData <em>IML Select Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.IMLSelectData
	 * @generated
	 */
	public Adapter createIMLSelectDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SelectCommand <em>Select Command</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectCommand
	 * @generated
	 */
	public Adapter createSelectCommandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SelectResponse <em>Select Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectResponse
	 * @generated
	 */
	public Adapter createSelectResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.ElementCommand <em>Element Command</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ElementCommand
	 * @generated
	 */
	public Adapter createElementCommandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Click <em>Click</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Click
	 * @generated
	 */
	public Adapter createClickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.DoubleClick <em>Double Click</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DoubleClick
	 * @generated
	 */
	public Adapter createDoubleClickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Show <em>Show</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Show
	 * @generated
	 */
	public Adapter createShowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Hide <em>Hide</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Hide
	 * @generated
	 */
	public Adapter createHideAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Close <em>Close</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Close
	 * @generated
	 */
	public Adapter createCloseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetText <em>Get Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetText
	 * @generated
	 */
	public Adapter createGetTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextResponse <em>Get Text Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextResponse
	 * @generated
	 */
	public Adapter createGetTextResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.BooleanResponse <em>Boolean Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.BooleanResponse
	 * @generated
	 */
	public Adapter createBooleanResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.IsEnabled <em>Is Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.IsEnabled
	 * @generated
	 */
	public Adapter createIsEnabledAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.IsDisposed <em>Is Disposed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.IsDisposed
	 * @generated
	 */
	public Adapter createIsDisposedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SetText <em>Set Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetText
	 * @generated
	 */
	public Adapter createSetTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetState <em>Get State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetState
	 * @generated
	 */
	public Adapter createGetStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetStateResponse <em>Get State Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetStateResponse
	 * @generated
	 */
	public Adapter createGetStateResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.WaitForState <em>Wait For State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.WaitForState
	 * @generated
	 */
	public Adapter createWaitForStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.RollbackToState <em>Rollback To State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RollbackToState
	 * @generated
	 */
	public Adapter createRollbackToStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SetSelection <em>Set Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSelection
	 * @generated
	 */
	public Adapter createSetSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem <em>Multi Selection Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem
	 * @generated
	 */
	public Adapter createMultiSelectionItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Shutdown <em>Shutdown</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Shutdown
	 * @generated
	 */
	public Adapter createShutdownAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Nop <em>Nop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Nop
	 * @generated
	 */
	public Adapter createNopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.CountItems <em>Count Items</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CountItems
	 * @generated
	 */
	public Adapter createCountItemsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.IntResponse <em>Int Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.IntResponse
	 * @generated
	 */
	public Adapter createIntResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Save <em>Save</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Save
	 * @generated
	 */
	public Adapter createSaveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.IsDirty <em>Is Dirty</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.IsDirty
	 * @generated
	 */
	public Adapter createIsDirtyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection <em>Set Text Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextSelection
	 * @generated
	 */
	public Adapter createSetTextSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextOffset <em>Set Text Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextOffset
	 * @generated
	 */
	public Adapter createSetTextOffsetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.ShowSelection <em>Show Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ShowSelection
	 * @generated
	 */
	public Adapter createShowSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextSelection <em>Get Text Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextSelection
	 * @generated
	 */
	public Adapter createGetTextSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GoToTextLine <em>Go To Text Line</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GoToTextLine
	 * @generated
	 */
	public Adapter createGoToTextLineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextLineOffset <em>Get Text Line Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextLineOffset
	 * @generated
	 */
	public Adapter createGetTextLineOffsetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextLineLength <em>Get Text Line Length</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextLineLength
	 * @generated
	 */
	public Adapter createGetTextLineLengthAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SelectTextLine <em>Select Text Line</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectTextLine
	 * @generated
	 */
	public Adapter createSelectTextLineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SetCaretPosition <em>Set Caret Position</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetCaretPosition
	 * @generated
	 */
	public Adapter createSetCaretPositionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextLine <em>Get Text Line</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextLine
	 * @generated
	 */
	public Adapter createGetTextLineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetTextRange <em>Get Text Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetTextRange
	 * @generated
	 */
	public Adapter createGetTextRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.TextSelectionResponse <em>Text Selection Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.TextSelectionResponse
	 * @generated
	 */
	public Adapter createTextSelectionResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetColor <em>Get Color</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetColor
	 * @generated
	 */
	public Adapter createGetColorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SetColor <em>Set Color</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetColor
	 * @generated
	 */
	public Adapter createSetColorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetColorResponse <em>Get Color Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetColorResponse
	 * @generated
	 */
	public Adapter createGetColorResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.TypeText <em>Type Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.TypeText
	 * @generated
	 */
	public Adapter createTypeTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Children <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Children
	 * @generated
	 */
	public Adapter createChildrenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.ChildrenResponse <em>Children Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ChildrenResponse
	 * @generated
	 */
	public Adapter createChildrenResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Parent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Parent
	 * @generated
	 */
	public Adapter createParentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.ParentResponse <em>Parent Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ParentResponse
	 * @generated
	 */
	public Adapter createParentResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.TypeAction <em>Type Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.TypeAction
	 * @generated
	 */
	public Adapter createTypeActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.CopyTextSelection <em>Copy Text Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CopyTextSelection
	 * @generated
	 */
	public Adapter createCopyTextSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.CutTextSelection <em>Cut Text Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CutTextSelection
	 * @generated
	 */
	public Adapter createCutTextSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.PasteTextSelection <em>Paste Text Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.PasteTextSelection
	 * @generated
	 */
	public Adapter createPasteTextSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.ReplaceTextSelection <em>Replace Text Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ReplaceTextSelection
	 * @generated
	 */
	public Adapter createReplaceTextSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.CheckItem <em>Check Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CheckItem
	 * @generated
	 */
	public Adapter createCheckItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Expand <em>Expand</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Expand
	 * @generated
	 */
	public Adapter createExpandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.CloseWorkbench <em>Close Workbench</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CloseWorkbench
	 * @generated
	 */
	public Adapter createCloseWorkbenchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor <em>Activate Cell Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor
	 * @generated
	 */
	public Adapter createActivateCellEditorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor <em>Apply Cell Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor
	 * @generated
	 */
	public Adapter createApplyCellEditorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.CancelCellEditor <em>Cancel Cell Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CancelCellEditor
	 * @generated
	 */
	public Adapter createCancelCellEditorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.DeactivateCellEditor <em>Deactivate Cell Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DeactivateCellEditor
	 * @generated
	 */
	public Adapter createDeactivateCellEditorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SetSWTDialogInfo <em>Set SWT Dialog Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSWTDialogInfo
	 * @generated
	 */
	public Adapter createSetSWTDialogInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Assert <em>Assert</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Assert
	 * @generated
	 */
	public Adapter createAssertAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetRegionText <em>Get Region Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetRegionText
	 * @generated
	 */
	public Adapter createGetRegionTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.AssertImageData <em>Assert Image Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertImageData
	 * @generated
	 */
	public Adapter createAssertImageDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.AssertResponse <em>Assert Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertResponse
	 * @generated
	 */
	public Adapter createAssertResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetSelection <em>Get Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetSelection
	 * @generated
	 */
	public Adapter createGetSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SelectionResponse <em>Selection Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectionResponse
	 * @generated
	 */
	public Adapter createSelectionResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SelectionItem <em>Selection Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SelectionItem
	 * @generated
	 */
	public Adapter createSelectionItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.DragCommand <em>Drag Command</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DragCommand
	 * @generated
	 */
	public Adapter createDragCommandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.WaitForRestart <em>Wait For Restart</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.WaitForRestart
	 * @generated
	 */
	public Adapter createWaitForRestartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.CellClick <em>Cell Click</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.CellClick
	 * @generated
	 */
	public Adapter createCellClickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.ShowContentAssist <em>Show Content Assist</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ShowContentAssist
	 * @generated
	 */
	public Adapter createShowContentAssistAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.ClickAboutMenu <em>Click About Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickAboutMenu
	 * @generated
	 */
	public Adapter createClickAboutMenuAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.ClickPreferencesMenu <em>Click Preferences Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickPreferencesMenu
	 * @generated
	 */
	public Adapter createClickPreferencesMenuAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.RecordingModeRequest <em>Recording Mode Request</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RecordingModeRequest
	 * @generated
	 */
	public Adapter createRecordingModeRequestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.AssertionModeRequest <em>Assertion Mode Request</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.AssertionModeRequest
	 * @generated
	 */
	public Adapter createAssertionModeRequestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Minimize <em>Minimize</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Minimize
	 * @generated
	 */
	public Adapter createMinimizeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Maximize <em>Maximize</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Maximize
	 * @generated
	 */
	public Adapter createMaximizeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Restore <em>Restore</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Restore
	 * @generated
	 */
	public Adapter createRestoreAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.ShowTabList <em>Show Tab List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ShowTabList
	 * @generated
	 */
	public Adapter createShowTabListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SetStatusDialogMode <em>Set Status Dialog Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetStatusDialogMode
	 * @generated
	 */
	public Adapter createSetStatusDialogModeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Check <em>Check</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Check
	 * @generated
	 */
	public Adapter createCheckAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.HoverAtTextOffset <em>Hover At Text Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.HoverAtTextOffset
	 * @generated
	 */
	public Adapter createHoverAtTextOffsetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SetCursorOffset <em>Set Cursor Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetCursorOffset
	 * @generated
	 */
	public Adapter createSetCursorOffsetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2 <em>Set Text Selection2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2
	 * @generated
	 */
	public Adapter createSetTextSelection2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.HoverAtText <em>Hover At Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.HoverAtText
	 * @generated
	 */
	public Adapter createHoverAtTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.OpenDeclaration <em>Open Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.OpenDeclaration
	 * @generated
	 */
	public Adapter createOpenDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.RulerClick <em>Ruler Click</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RulerClick
	 * @generated
	 */
	public Adapter createRulerClickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.RulerDoubleClick <em>Ruler Double Click</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RulerDoubleClick
	 * @generated
	 */
	public Adapter createRulerDoubleClickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.RulerHover <em>Ruler Hover</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RulerHover
	 * @generated
	 */
	public Adapter createRulerHoverAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.ClickLink <em>Click Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickLink
	 * @generated
	 */
	public Adapter createClickLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SetFocus <em>Set Focus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetFocus
	 * @generated
	 */
	public Adapter createSetFocusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue <em>Get Property Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue
	 * @generated
	 */
	public Adapter createGetPropertyValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.ObjectResponse <em>Object Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ObjectResponse
	 * @generated
	 */
	public Adapter createObjectResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetBounds <em>Get Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetBounds
	 * @generated
	 */
	public Adapter createGetBoundsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.BoundsResponse <em>Bounds Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.BoundsResponse
	 * @generated
	 */
	public Adapter createBoundsResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.Collapse <em>Collapse</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.Collapse
	 * @generated
	 */
	public Adapter createCollapseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.ClickColumn <em>Click Column</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickColumn
	 * @generated
	 */
	public Adapter createClickColumnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SetSortColumn <em>Set Sort Column</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetSortColumn
	 * @generated
	 */
	public Adapter createSetSortColumnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.MouseEvent <em>Mouse Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.MouseEvent
	 * @generated
	 */
	public Adapter createMouseEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.ClickText <em>Click Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.ClickText
	 * @generated
	 */
	public Adapter createClickTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.DoubleClickText <em>Double Click Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.DoubleClickText
	 * @generated
	 */
	public Adapter createDoubleClickTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SetWidth <em>Set Width</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetWidth
	 * @generated
	 */
	public Adapter createSetWidthAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.SetPosition <em>Set Position</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.SetPosition
	 * @generated
	 */
	public Adapter createSetPositionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.UpdateControlCommand <em>Update Control Command</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.UpdateControlCommand
	 * @generated
	 */
	public Adapter createUpdateControlCommandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.RapDownloadFile <em>Rap Download File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RapDownloadFile
	 * @generated
	 */
	public Adapter createRapDownloadFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.RapUploadFile <em>Rap Upload File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.RapUploadFile
	 * @generated
	 */
	public Adapter createRapUploadFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetItems <em>Get Items</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetItems
	 * @generated
	 */
	public Adapter createGetItemsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.GetItemsResponse <em>Get Items Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.GetItemsResponse
	 * @generated
	 */
	public Adapter createGetItemsResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Command
	 * @generated
	 */
	public Adapter createCommandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.rcptt.tesla.core.protocol.raw.Response <em>Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.rcptt.tesla.core.protocol.raw.Response
	 * @generated
	 */
	public Adapter createResponseAdapter() {
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

} //ProtocolAdapterFactory
