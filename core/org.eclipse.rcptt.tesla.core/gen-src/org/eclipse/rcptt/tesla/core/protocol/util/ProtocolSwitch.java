/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core.protocol.util;

import org.eclipse.rcptt.tesla.core.protocol.*;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage
 * @generated
 */
public class ProtocolSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProtocolPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolSwitch() {
		if (modelPackage == null) {
			modelPackage = ProtocolPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ProtocolPackage.SELECT_DATA: {
				SelectData selectData = (SelectData)theEObject;
				T result = caseSelectData(selectData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.IML_SELECT_DATA: {
				IMLSelectData imlSelectData = (IMLSelectData)theEObject;
				T result = caseIMLSelectData(imlSelectData);
				if (result == null) result = caseSelectData(imlSelectData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SELECT_COMMAND: {
				SelectCommand selectCommand = (SelectCommand)theEObject;
				T result = caseSelectCommand(selectCommand);
				if (result == null) result = caseCommand(selectCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SELECT_RESPONSE: {
				SelectResponse selectResponse = (SelectResponse)theEObject;
				T result = caseSelectResponse(selectResponse);
				if (result == null) result = caseResponse(selectResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.ELEMENT_COMMAND: {
				ElementCommand elementCommand = (ElementCommand)theEObject;
				T result = caseElementCommand(elementCommand);
				if (result == null) result = caseCommand(elementCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.CLICK: {
				Click click = (Click)theEObject;
				T result = caseClick(click);
				if (result == null) result = caseElementCommand(click);
				if (result == null) result = caseCommand(click);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.DOUBLE_CLICK: {
				DoubleClick doubleClick = (DoubleClick)theEObject;
				T result = caseDoubleClick(doubleClick);
				if (result == null) result = caseElementCommand(doubleClick);
				if (result == null) result = caseCommand(doubleClick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SHOW: {
				Show show = (Show)theEObject;
				T result = caseShow(show);
				if (result == null) result = caseElementCommand(show);
				if (result == null) result = caseCommand(show);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.HIDE: {
				Hide hide = (Hide)theEObject;
				T result = caseHide(hide);
				if (result == null) result = caseElementCommand(hide);
				if (result == null) result = caseCommand(hide);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.CLOSE: {
				Close close = (Close)theEObject;
				T result = caseClose(close);
				if (result == null) result = caseElementCommand(close);
				if (result == null) result = caseCommand(close);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_TEXT: {
				GetText getText = (GetText)theEObject;
				T result = caseGetText(getText);
				if (result == null) result = caseElementCommand(getText);
				if (result == null) result = caseCommand(getText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_TEXT_RESPONSE: {
				GetTextResponse getTextResponse = (GetTextResponse)theEObject;
				T result = caseGetTextResponse(getTextResponse);
				if (result == null) result = caseResponse(getTextResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.BOOLEAN_RESPONSE: {
				BooleanResponse booleanResponse = (BooleanResponse)theEObject;
				T result = caseBooleanResponse(booleanResponse);
				if (result == null) result = caseResponse(booleanResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.IS_ENABLED: {
				IsEnabled isEnabled = (IsEnabled)theEObject;
				T result = caseIsEnabled(isEnabled);
				if (result == null) result = caseElementCommand(isEnabled);
				if (result == null) result = caseCommand(isEnabled);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.IS_DISPOSED: {
				IsDisposed isDisposed = (IsDisposed)theEObject;
				T result = caseIsDisposed(isDisposed);
				if (result == null) result = caseElementCommand(isDisposed);
				if (result == null) result = caseCommand(isDisposed);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SET_TEXT: {
				SetText setText = (SetText)theEObject;
				T result = caseSetText(setText);
				if (result == null) result = caseElementCommand(setText);
				if (result == null) result = caseCommand(setText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_STATE: {
				GetState getState = (GetState)theEObject;
				T result = caseGetState(getState);
				if (result == null) result = caseCommand(getState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_STATE_RESPONSE: {
				GetStateResponse getStateResponse = (GetStateResponse)theEObject;
				T result = caseGetStateResponse(getStateResponse);
				if (result == null) result = caseResponse(getStateResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.WAIT_FOR_STATE: {
				WaitForState waitForState = (WaitForState)theEObject;
				T result = caseWaitForState(waitForState);
				if (result == null) result = caseCommand(waitForState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.ROLLBACK_TO_STATE: {
				RollbackToState rollbackToState = (RollbackToState)theEObject;
				T result = caseRollbackToState(rollbackToState);
				if (result == null) result = caseCommand(rollbackToState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SET_SELECTION: {
				SetSelection setSelection = (SetSelection)theEObject;
				T result = caseSetSelection(setSelection);
				if (result == null) result = caseElementCommand(setSelection);
				if (result == null) result = caseCommand(setSelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.MULTI_SELECTION_ITEM: {
				MultiSelectionItem multiSelectionItem = (MultiSelectionItem)theEObject;
				T result = caseMultiSelectionItem(multiSelectionItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SHUTDOWN: {
				Shutdown shutdown = (Shutdown)theEObject;
				T result = caseShutdown(shutdown);
				if (result == null) result = caseCommand(shutdown);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.NOP: {
				Nop nop = (Nop)theEObject;
				T result = caseNop(nop);
				if (result == null) result = caseCommand(nop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.COUNT_ITEMS: {
				CountItems countItems = (CountItems)theEObject;
				T result = caseCountItems(countItems);
				if (result == null) result = caseElementCommand(countItems);
				if (result == null) result = caseCommand(countItems);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.INT_RESPONSE: {
				IntResponse intResponse = (IntResponse)theEObject;
				T result = caseIntResponse(intResponse);
				if (result == null) result = caseResponse(intResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SAVE: {
				Save save = (Save)theEObject;
				T result = caseSave(save);
				if (result == null) result = caseElementCommand(save);
				if (result == null) result = caseCommand(save);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.IS_DIRTY: {
				IsDirty isDirty = (IsDirty)theEObject;
				T result = caseIsDirty(isDirty);
				if (result == null) result = caseElementCommand(isDirty);
				if (result == null) result = caseCommand(isDirty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SET_TEXT_SELECTION: {
				SetTextSelection setTextSelection = (SetTextSelection)theEObject;
				T result = caseSetTextSelection(setTextSelection);
				if (result == null) result = caseElementCommand(setTextSelection);
				if (result == null) result = caseCommand(setTextSelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SET_TEXT_OFFSET: {
				SetTextOffset setTextOffset = (SetTextOffset)theEObject;
				T result = caseSetTextOffset(setTextOffset);
				if (result == null) result = caseElementCommand(setTextOffset);
				if (result == null) result = caseCommand(setTextOffset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SHOW_SELECTION: {
				ShowSelection showSelection = (ShowSelection)theEObject;
				T result = caseShowSelection(showSelection);
				if (result == null) result = caseElementCommand(showSelection);
				if (result == null) result = caseCommand(showSelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_TEXT_SELECTION: {
				GetTextSelection getTextSelection = (GetTextSelection)theEObject;
				T result = caseGetTextSelection(getTextSelection);
				if (result == null) result = caseElementCommand(getTextSelection);
				if (result == null) result = caseCommand(getTextSelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GO_TO_TEXT_LINE: {
				GoToTextLine goToTextLine = (GoToTextLine)theEObject;
				T result = caseGoToTextLine(goToTextLine);
				if (result == null) result = caseElementCommand(goToTextLine);
				if (result == null) result = caseCommand(goToTextLine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_TEXT_LINE_OFFSET: {
				GetTextLineOffset getTextLineOffset = (GetTextLineOffset)theEObject;
				T result = caseGetTextLineOffset(getTextLineOffset);
				if (result == null) result = caseElementCommand(getTextLineOffset);
				if (result == null) result = caseCommand(getTextLineOffset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_TEXT_LINE_LENGTH: {
				GetTextLineLength getTextLineLength = (GetTextLineLength)theEObject;
				T result = caseGetTextLineLength(getTextLineLength);
				if (result == null) result = caseElementCommand(getTextLineLength);
				if (result == null) result = caseCommand(getTextLineLength);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SELECT_TEXT_LINE: {
				SelectTextLine selectTextLine = (SelectTextLine)theEObject;
				T result = caseSelectTextLine(selectTextLine);
				if (result == null) result = caseElementCommand(selectTextLine);
				if (result == null) result = caseCommand(selectTextLine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SET_CARET_POSITION: {
				SetCaretPosition setCaretPosition = (SetCaretPosition)theEObject;
				T result = caseSetCaretPosition(setCaretPosition);
				if (result == null) result = caseElementCommand(setCaretPosition);
				if (result == null) result = caseCommand(setCaretPosition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_TEXT_LINE: {
				GetTextLine getTextLine = (GetTextLine)theEObject;
				T result = caseGetTextLine(getTextLine);
				if (result == null) result = caseElementCommand(getTextLine);
				if (result == null) result = caseCommand(getTextLine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_TEXT_RANGE: {
				GetTextRange getTextRange = (GetTextRange)theEObject;
				T result = caseGetTextRange(getTextRange);
				if (result == null) result = caseElementCommand(getTextRange);
				if (result == null) result = caseCommand(getTextRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.TEXT_SELECTION_RESPONSE: {
				TextSelectionResponse textSelectionResponse = (TextSelectionResponse)theEObject;
				T result = caseTextSelectionResponse(textSelectionResponse);
				if (result == null) result = caseResponse(textSelectionResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_COLOR: {
				GetColor getColor = (GetColor)theEObject;
				T result = caseGetColor(getColor);
				if (result == null) result = caseElementCommand(getColor);
				if (result == null) result = caseCommand(getColor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SET_COLOR: {
				SetColor setColor = (SetColor)theEObject;
				T result = caseSetColor(setColor);
				if (result == null) result = caseElementCommand(setColor);
				if (result == null) result = caseCommand(setColor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_COLOR_RESPONSE: {
				GetColorResponse getColorResponse = (GetColorResponse)theEObject;
				T result = caseGetColorResponse(getColorResponse);
				if (result == null) result = caseResponse(getColorResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.TYPE_TEXT: {
				TypeText typeText = (TypeText)theEObject;
				T result = caseTypeText(typeText);
				if (result == null) result = caseElementCommand(typeText);
				if (result == null) result = caseCommand(typeText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.CHILDREN: {
				Children children = (Children)theEObject;
				T result = caseChildren(children);
				if (result == null) result = caseElementCommand(children);
				if (result == null) result = caseCommand(children);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.CHILDREN_RESPONSE: {
				ChildrenResponse childrenResponse = (ChildrenResponse)theEObject;
				T result = caseChildrenResponse(childrenResponse);
				if (result == null) result = caseResponse(childrenResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.PARENT: {
				Parent parent = (Parent)theEObject;
				T result = caseParent(parent);
				if (result == null) result = caseElementCommand(parent);
				if (result == null) result = caseCommand(parent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.PARENT_RESPONSE: {
				ParentResponse parentResponse = (ParentResponse)theEObject;
				T result = caseParentResponse(parentResponse);
				if (result == null) result = caseResponse(parentResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = caseElementCommand(type);
				if (result == null) result = caseCommand(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.TYPE_ACTION: {
				TypeAction typeAction = (TypeAction)theEObject;
				T result = caseTypeAction(typeAction);
				if (result == null) result = caseElementCommand(typeAction);
				if (result == null) result = caseCommand(typeAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.COPY_TEXT_SELECTION: {
				CopyTextSelection copyTextSelection = (CopyTextSelection)theEObject;
				T result = caseCopyTextSelection(copyTextSelection);
				if (result == null) result = caseElementCommand(copyTextSelection);
				if (result == null) result = caseCommand(copyTextSelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.CUT_TEXT_SELECTION: {
				CutTextSelection cutTextSelection = (CutTextSelection)theEObject;
				T result = caseCutTextSelection(cutTextSelection);
				if (result == null) result = caseElementCommand(cutTextSelection);
				if (result == null) result = caseCommand(cutTextSelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.PASTE_TEXT_SELECTION: {
				PasteTextSelection pasteTextSelection = (PasteTextSelection)theEObject;
				T result = casePasteTextSelection(pasteTextSelection);
				if (result == null) result = caseElementCommand(pasteTextSelection);
				if (result == null) result = caseCommand(pasteTextSelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.REPLACE_TEXT_SELECTION: {
				ReplaceTextSelection replaceTextSelection = (ReplaceTextSelection)theEObject;
				T result = caseReplaceTextSelection(replaceTextSelection);
				if (result == null) result = caseElementCommand(replaceTextSelection);
				if (result == null) result = caseCommand(replaceTextSelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.CHECK_ITEM: {
				CheckItem checkItem = (CheckItem)theEObject;
				T result = caseCheckItem(checkItem);
				if (result == null) result = caseElementCommand(checkItem);
				if (result == null) result = caseCommand(checkItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.EXPAND: {
				Expand expand = (Expand)theEObject;
				T result = caseExpand(expand);
				if (result == null) result = caseElementCommand(expand);
				if (result == null) result = caseCommand(expand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.CLOSE_WORKBENCH: {
				CloseWorkbench closeWorkbench = (CloseWorkbench)theEObject;
				T result = caseCloseWorkbench(closeWorkbench);
				if (result == null) result = caseCommand(closeWorkbench);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.ACTIVATE_CELL_EDITOR: {
				ActivateCellEditor activateCellEditor = (ActivateCellEditor)theEObject;
				T result = caseActivateCellEditor(activateCellEditor);
				if (result == null) result = caseElementCommand(activateCellEditor);
				if (result == null) result = caseCommand(activateCellEditor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.APPLY_CELL_EDITOR: {
				ApplyCellEditor applyCellEditor = (ApplyCellEditor)theEObject;
				T result = caseApplyCellEditor(applyCellEditor);
				if (result == null) result = caseElementCommand(applyCellEditor);
				if (result == null) result = caseCommand(applyCellEditor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.CANCEL_CELL_EDITOR: {
				CancelCellEditor cancelCellEditor = (CancelCellEditor)theEObject;
				T result = caseCancelCellEditor(cancelCellEditor);
				if (result == null) result = caseElementCommand(cancelCellEditor);
				if (result == null) result = caseCommand(cancelCellEditor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.DEACTIVATE_CELL_EDITOR: {
				DeactivateCellEditor deactivateCellEditor = (DeactivateCellEditor)theEObject;
				T result = caseDeactivateCellEditor(deactivateCellEditor);
				if (result == null) result = caseElementCommand(deactivateCellEditor);
				if (result == null) result = caseCommand(deactivateCellEditor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SET_SWT_DIALOG_INFO: {
				SetSWTDialogInfo setSWTDialogInfo = (SetSWTDialogInfo)theEObject;
				T result = caseSetSWTDialogInfo(setSWTDialogInfo);
				if (result == null) result = caseCommand(setSWTDialogInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.ASSERT: {
				Assert assert_ = (Assert)theEObject;
				T result = caseAssert(assert_);
				if (result == null) result = caseCommand(assert_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_REGION_TEXT: {
				GetRegionText getRegionText = (GetRegionText)theEObject;
				T result = caseGetRegionText(getRegionText);
				if (result == null) result = caseElementCommand(getRegionText);
				if (result == null) result = caseCommand(getRegionText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.ASSERT_IMAGE_DATA: {
				AssertImageData assertImageData = (AssertImageData)theEObject;
				T result = caseAssertImageData(assertImageData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.ASSERT_RESPONSE: {
				AssertResponse assertResponse = (AssertResponse)theEObject;
				T result = caseAssertResponse(assertResponse);
				if (result == null) result = caseResponse(assertResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_SELECTION: {
				GetSelection getSelection = (GetSelection)theEObject;
				T result = caseGetSelection(getSelection);
				if (result == null) result = caseElementCommand(getSelection);
				if (result == null) result = caseCommand(getSelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SELECTION_RESPONSE: {
				SelectionResponse selectionResponse = (SelectionResponse)theEObject;
				T result = caseSelectionResponse(selectionResponse);
				if (result == null) result = caseResponse(selectionResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SELECTION_ITEM: {
				SelectionItem selectionItem = (SelectionItem)theEObject;
				T result = caseSelectionItem(selectionItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.DRAG_COMMAND: {
				DragCommand dragCommand = (DragCommand)theEObject;
				T result = caseDragCommand(dragCommand);
				if (result == null) result = caseElementCommand(dragCommand);
				if (result == null) result = caseCommand(dragCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.WAIT_FOR_RESTART: {
				WaitForRestart waitForRestart = (WaitForRestart)theEObject;
				T result = caseWaitForRestart(waitForRestart);
				if (result == null) result = caseCommand(waitForRestart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.CELL_CLICK: {
				CellClick cellClick = (CellClick)theEObject;
				T result = caseCellClick(cellClick);
				if (result == null) result = caseElementCommand(cellClick);
				if (result == null) result = caseCommand(cellClick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SHOW_CONTENT_ASSIST: {
				ShowContentAssist showContentAssist = (ShowContentAssist)theEObject;
				T result = caseShowContentAssist(showContentAssist);
				if (result == null) result = caseElementCommand(showContentAssist);
				if (result == null) result = caseCommand(showContentAssist);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.CLICK_ABOUT_MENU: {
				ClickAboutMenu clickAboutMenu = (ClickAboutMenu)theEObject;
				T result = caseClickAboutMenu(clickAboutMenu);
				if (result == null) result = caseElementCommand(clickAboutMenu);
				if (result == null) result = caseCommand(clickAboutMenu);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.CLICK_PREFERENCES_MENU: {
				ClickPreferencesMenu clickPreferencesMenu = (ClickPreferencesMenu)theEObject;
				T result = caseClickPreferencesMenu(clickPreferencesMenu);
				if (result == null) result = caseElementCommand(clickPreferencesMenu);
				if (result == null) result = caseCommand(clickPreferencesMenu);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.RECORDING_MODE_REQUEST: {
				RecordingModeRequest recordingModeRequest = (RecordingModeRequest)theEObject;
				T result = caseRecordingModeRequest(recordingModeRequest);
				if (result == null) result = caseCommand(recordingModeRequest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.ASSERTION_MODE_REQUEST: {
				AssertionModeRequest assertionModeRequest = (AssertionModeRequest)theEObject;
				T result = caseAssertionModeRequest(assertionModeRequest);
				if (result == null) result = caseCommand(assertionModeRequest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.MINIMIZE: {
				Minimize minimize = (Minimize)theEObject;
				T result = caseMinimize(minimize);
				if (result == null) result = caseElementCommand(minimize);
				if (result == null) result = caseCommand(minimize);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.MAXIMIZE: {
				Maximize maximize = (Maximize)theEObject;
				T result = caseMaximize(maximize);
				if (result == null) result = caseElementCommand(maximize);
				if (result == null) result = caseCommand(maximize);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.RESTORE: {
				Restore restore = (Restore)theEObject;
				T result = caseRestore(restore);
				if (result == null) result = caseElementCommand(restore);
				if (result == null) result = caseCommand(restore);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SHOW_TAB_LIST: {
				ShowTabList showTabList = (ShowTabList)theEObject;
				T result = caseShowTabList(showTabList);
				if (result == null) result = caseElementCommand(showTabList);
				if (result == null) result = caseCommand(showTabList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SET_STATUS_DIALOG_MODE: {
				SetStatusDialogMode setStatusDialogMode = (SetStatusDialogMode)theEObject;
				T result = caseSetStatusDialogMode(setStatusDialogMode);
				if (result == null) result = caseCommand(setStatusDialogMode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.CHECK: {
				Check check = (Check)theEObject;
				T result = caseCheck(check);
				if (result == null) result = caseElementCommand(check);
				if (result == null) result = caseCommand(check);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.HOVER_AT_TEXT_OFFSET: {
				HoverAtTextOffset hoverAtTextOffset = (HoverAtTextOffset)theEObject;
				T result = caseHoverAtTextOffset(hoverAtTextOffset);
				if (result == null) result = caseElementCommand(hoverAtTextOffset);
				if (result == null) result = caseCommand(hoverAtTextOffset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SET_CURSOR_OFFSET: {
				SetCursorOffset setCursorOffset = (SetCursorOffset)theEObject;
				T result = caseSetCursorOffset(setCursorOffset);
				if (result == null) result = caseElementCommand(setCursorOffset);
				if (result == null) result = caseCommand(setCursorOffset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SET_TEXT_SELECTION2: {
				SetTextSelection2 setTextSelection2 = (SetTextSelection2)theEObject;
				T result = caseSetTextSelection2(setTextSelection2);
				if (result == null) result = caseElementCommand(setTextSelection2);
				if (result == null) result = caseCommand(setTextSelection2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.HOVER_AT_TEXT: {
				HoverAtText hoverAtText = (HoverAtText)theEObject;
				T result = caseHoverAtText(hoverAtText);
				if (result == null) result = caseElementCommand(hoverAtText);
				if (result == null) result = caseCommand(hoverAtText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.OPEN_DECLARATION: {
				OpenDeclaration openDeclaration = (OpenDeclaration)theEObject;
				T result = caseOpenDeclaration(openDeclaration);
				if (result == null) result = caseElementCommand(openDeclaration);
				if (result == null) result = caseCommand(openDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.RULER_CLICK: {
				RulerClick rulerClick = (RulerClick)theEObject;
				T result = caseRulerClick(rulerClick);
				if (result == null) result = caseElementCommand(rulerClick);
				if (result == null) result = caseCommand(rulerClick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.RULER_DOUBLE_CLICK: {
				RulerDoubleClick rulerDoubleClick = (RulerDoubleClick)theEObject;
				T result = caseRulerDoubleClick(rulerDoubleClick);
				if (result == null) result = caseElementCommand(rulerDoubleClick);
				if (result == null) result = caseCommand(rulerDoubleClick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.RULER_HOVER: {
				RulerHover rulerHover = (RulerHover)theEObject;
				T result = caseRulerHover(rulerHover);
				if (result == null) result = caseElementCommand(rulerHover);
				if (result == null) result = caseCommand(rulerHover);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.CLICK_LINK: {
				ClickLink clickLink = (ClickLink)theEObject;
				T result = caseClickLink(clickLink);
				if (result == null) result = caseElementCommand(clickLink);
				if (result == null) result = caseCommand(clickLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SET_FOCUS: {
				SetFocus setFocus = (SetFocus)theEObject;
				T result = caseSetFocus(setFocus);
				if (result == null) result = caseElementCommand(setFocus);
				if (result == null) result = caseCommand(setFocus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_PROPERTY_VALUE: {
				GetPropertyValue getPropertyValue = (GetPropertyValue)theEObject;
				T result = caseGetPropertyValue(getPropertyValue);
				if (result == null) result = caseElementCommand(getPropertyValue);
				if (result == null) result = caseCommand(getPropertyValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.OBJECT_RESPONSE: {
				ObjectResponse objectResponse = (ObjectResponse)theEObject;
				T result = caseObjectResponse(objectResponse);
				if (result == null) result = caseResponse(objectResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_BOUNDS: {
				GetBounds getBounds = (GetBounds)theEObject;
				T result = caseGetBounds(getBounds);
				if (result == null) result = caseElementCommand(getBounds);
				if (result == null) result = caseCommand(getBounds);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.BOUNDS_RESPONSE: {
				BoundsResponse boundsResponse = (BoundsResponse)theEObject;
				T result = caseBoundsResponse(boundsResponse);
				if (result == null) result = caseResponse(boundsResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.COLLAPSE: {
				Collapse collapse = (Collapse)theEObject;
				T result = caseCollapse(collapse);
				if (result == null) result = caseElementCommand(collapse);
				if (result == null) result = caseCommand(collapse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.CLICK_COLUMN: {
				ClickColumn clickColumn = (ClickColumn)theEObject;
				T result = caseClickColumn(clickColumn);
				if (result == null) result = caseElementCommand(clickColumn);
				if (result == null) result = caseCommand(clickColumn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SET_SORT_COLUMN: {
				SetSortColumn setSortColumn = (SetSortColumn)theEObject;
				T result = caseSetSortColumn(setSortColumn);
				if (result == null) result = caseElementCommand(setSortColumn);
				if (result == null) result = caseCommand(setSortColumn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.MOUSE_EVENT: {
				MouseEvent mouseEvent = (MouseEvent)theEObject;
				T result = caseMouseEvent(mouseEvent);
				if (result == null) result = caseElementCommand(mouseEvent);
				if (result == null) result = caseCommand(mouseEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.CLICK_TEXT: {
				ClickText clickText = (ClickText)theEObject;
				T result = caseClickText(clickText);
				if (result == null) result = caseElementCommand(clickText);
				if (result == null) result = caseCommand(clickText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.DOUBLE_CLICK_TEXT: {
				DoubleClickText doubleClickText = (DoubleClickText)theEObject;
				T result = caseDoubleClickText(doubleClickText);
				if (result == null) result = caseElementCommand(doubleClickText);
				if (result == null) result = caseCommand(doubleClickText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SET_WIDTH: {
				SetWidth setWidth = (SetWidth)theEObject;
				T result = caseSetWidth(setWidth);
				if (result == null) result = caseElementCommand(setWidth);
				if (result == null) result = caseCommand(setWidth);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.SET_POSITION: {
				SetPosition setPosition = (SetPosition)theEObject;
				T result = caseSetPosition(setPosition);
				if (result == null) result = caseElementCommand(setPosition);
				if (result == null) result = caseCommand(setPosition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.UPDATE_CONTROL_COMMAND: {
				UpdateControlCommand updateControlCommand = (UpdateControlCommand)theEObject;
				T result = caseUpdateControlCommand(updateControlCommand);
				if (result == null) result = caseCommand(updateControlCommand);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.RAP_DOWNLOAD_FILE: {
				RapDownloadFile rapDownloadFile = (RapDownloadFile)theEObject;
				T result = caseRapDownloadFile(rapDownloadFile);
				if (result == null) result = caseCommand(rapDownloadFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.RAP_UPLOAD_FILE: {
				RapUploadFile rapUploadFile = (RapUploadFile)theEObject;
				T result = caseRapUploadFile(rapUploadFile);
				if (result == null) result = caseCommand(rapUploadFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_ITEMS: {
				GetItems getItems = (GetItems)theEObject;
				T result = caseGetItems(getItems);
				if (result == null) result = caseElementCommand(getItems);
				if (result == null) result = caseCommand(getItems);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProtocolPackage.GET_ITEMS_RESPONSE: {
				GetItemsResponse getItemsResponse = (GetItemsResponse)theEObject;
				T result = caseGetItemsResponse(getItemsResponse);
				if (result == null) result = caseResponse(getItemsResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Select Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Select Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectData(SelectData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IML Select Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IML Select Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIMLSelectData(IMLSelectData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Select Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Select Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectCommand(SelectCommand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Select Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Select Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectResponse(SelectResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementCommand(ElementCommand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Click</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Click</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClick(Click object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Click</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Click</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleClick(DoubleClick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Show</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Show</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShow(Show object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hide</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hide</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHide(Hide object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Close</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Close</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClose(Close object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetText(GetText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Text Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Text Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetTextResponse(GetTextResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanResponse(BooleanResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Enabled</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Enabled</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIsEnabled(IsEnabled object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Disposed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Disposed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIsDisposed(IsDisposed object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetText(SetText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetState(GetState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get State Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get State Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetStateResponse(GetStateResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wait For State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wait For State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWaitForState(WaitForState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rollback To State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rollback To State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRollbackToState(RollbackToState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetSelection(SetSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Selection Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Selection Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiSelectionItem(MultiSelectionItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shutdown</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shutdown</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShutdown(Shutdown object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNop(Nop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Count Items</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Count Items</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCountItems(CountItems object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntResponse(IntResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Save</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Save</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSave(Save object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Dirty</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Dirty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIsDirty(IsDirty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Text Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Text Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetTextSelection(SetTextSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Text Offset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Text Offset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetTextOffset(SetTextOffset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Show Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Show Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShowSelection(ShowSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Text Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Text Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetTextSelection(GetTextSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Go To Text Line</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Go To Text Line</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGoToTextLine(GoToTextLine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Text Line Offset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Text Line Offset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetTextLineOffset(GetTextLineOffset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Text Line Length</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Text Line Length</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetTextLineLength(GetTextLineLength object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Select Text Line</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Select Text Line</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectTextLine(SelectTextLine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Caret Position</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Caret Position</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetCaretPosition(SetCaretPosition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Text Line</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Text Line</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetTextLine(GetTextLine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Text Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Text Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetTextRange(GetTextRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Selection Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Selection Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextSelectionResponse(TextSelectionResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Color</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Color</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetColor(GetColor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Color</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Color</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetColor(SetColor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Color Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Color Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetColorResponse(GetColorResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeText(TypeText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Children</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Children</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChildren(Children object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Children Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Children Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChildrenResponse(ChildrenResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParent(Parent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parent Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parent Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParentResponse(ParentResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeAction(TypeAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Copy Text Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Copy Text Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCopyTextSelection(CopyTextSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cut Text Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cut Text Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCutTextSelection(CutTextSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Paste Text Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Paste Text Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePasteTextSelection(PasteTextSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Replace Text Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replace Text Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplaceTextSelection(ReplaceTextSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Check Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Check Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheckItem(CheckItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expand</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expand</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpand(Expand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Close Workbench</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Close Workbench</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloseWorkbench(CloseWorkbench object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activate Cell Editor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activate Cell Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivateCellEditor(ActivateCellEditor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Apply Cell Editor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Apply Cell Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplyCellEditor(ApplyCellEditor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cancel Cell Editor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cancel Cell Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCancelCellEditor(CancelCellEditor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deactivate Cell Editor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deactivate Cell Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeactivateCellEditor(DeactivateCellEditor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set SWT Dialog Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set SWT Dialog Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetSWTDialogInfo(SetSWTDialogInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assert</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assert</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssert(Assert object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Region Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Region Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetRegionText(GetRegionText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assert Image Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assert Image Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssertImageData(AssertImageData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assert Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assert Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssertResponse(AssertResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetSelection(GetSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selection Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectionResponse(SelectionResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selection Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectionItem(SelectionItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Drag Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Drag Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDragCommand(DragCommand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wait For Restart</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wait For Restart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWaitForRestart(WaitForRestart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cell Click</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cell Click</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCellClick(CellClick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Show Content Assist</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Show Content Assist</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShowContentAssist(ShowContentAssist object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Click About Menu</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Click About Menu</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClickAboutMenu(ClickAboutMenu object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Click Preferences Menu</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Click Preferences Menu</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClickPreferencesMenu(ClickPreferencesMenu object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recording Mode Request</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recording Mode Request</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecordingModeRequest(RecordingModeRequest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assertion Mode Request</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assertion Mode Request</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssertionModeRequest(AssertionModeRequest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Minimize</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Minimize</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMinimize(Minimize object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Maximize</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Maximize</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMaximize(Maximize object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Restore</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Restore</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRestore(Restore object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Show Tab List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Show Tab List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShowTabList(ShowTabList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Status Dialog Mode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Status Dialog Mode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetStatusDialogMode(SetStatusDialogMode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Check</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Check</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheck(Check object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hover At Text Offset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hover At Text Offset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHoverAtTextOffset(HoverAtTextOffset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Cursor Offset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Cursor Offset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetCursorOffset(SetCursorOffset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Text Selection2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Text Selection2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetTextSelection2(SetTextSelection2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hover At Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hover At Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHoverAtText(HoverAtText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenDeclaration(OpenDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ruler Click</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ruler Click</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRulerClick(RulerClick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ruler Double Click</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ruler Double Click</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRulerDoubleClick(RulerDoubleClick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ruler Hover</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ruler Hover</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRulerHover(RulerHover object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Click Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Click Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClickLink(ClickLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Focus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Focus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetFocus(SetFocus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Property Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetPropertyValue(GetPropertyValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectResponse(ObjectResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Bounds</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Bounds</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetBounds(GetBounds object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bounds Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bounds Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundsResponse(BoundsResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collapse</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collapse</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollapse(Collapse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Click Column</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Click Column</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClickColumn(ClickColumn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Sort Column</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Sort Column</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetSortColumn(SetSortColumn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMouseEvent(MouseEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Click Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Click Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClickText(ClickText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Click Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Click Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleClickText(DoubleClickText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Width</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Width</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetWidth(SetWidth object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Position</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Position</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetPosition(SetPosition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Control Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Control Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateControlCommand(UpdateControlCommand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rap Download File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rap Download File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRapDownloadFile(RapDownloadFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rap Upload File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rap Upload File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRapUploadFile(RapUploadFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Items</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Items</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetItems(GetItems object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Items Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Items Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetItemsResponse(GetItemsResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommand(Command object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResponse(Response object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ProtocolSwitch
