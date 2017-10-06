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
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage
 * @generated
 */
public interface ProtocolFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProtocolFactory eINSTANCE = org.eclipse.rcptt.tesla.core.protocol.impl.ProtocolFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Select Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select Data</em>'.
	 * @generated
	 */
	SelectData createSelectData();

	/**
	 * Returns a new object of class '<em>IML Select Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>IML Select Data</em>'.
	 * @generated
	 */
	IMLSelectData createIMLSelectData();

	/**
	 * Returns a new object of class '<em>Select Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select Command</em>'.
	 * @generated
	 */
	SelectCommand createSelectCommand();

	/**
	 * Returns a new object of class '<em>Select Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select Response</em>'.
	 * @generated
	 */
	SelectResponse createSelectResponse();

	/**
	 * Returns a new object of class '<em>Click</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Click</em>'.
	 * @generated
	 */
	Click createClick();

	/**
	 * Returns a new object of class '<em>Double Click</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Click</em>'.
	 * @generated
	 */
	DoubleClick createDoubleClick();

	/**
	 * Returns a new object of class '<em>Show</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Show</em>'.
	 * @generated
	 */
	Show createShow();

	/**
	 * Returns a new object of class '<em>Hide</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hide</em>'.
	 * @generated
	 */
	Hide createHide();

	/**
	 * Returns a new object of class '<em>Close</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Close</em>'.
	 * @generated
	 */
	Close createClose();

	/**
	 * Returns a new object of class '<em>Get Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Text</em>'.
	 * @generated
	 */
	GetText createGetText();

	/**
	 * Returns a new object of class '<em>Get Text Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Text Response</em>'.
	 * @generated
	 */
	GetTextResponse createGetTextResponse();

	/**
	 * Returns a new object of class '<em>Boolean Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Response</em>'.
	 * @generated
	 */
	BooleanResponse createBooleanResponse();

	/**
	 * Returns a new object of class '<em>Is Enabled</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Enabled</em>'.
	 * @generated
	 */
	IsEnabled createIsEnabled();

	/**
	 * Returns a new object of class '<em>Is Disposed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Disposed</em>'.
	 * @generated
	 */
	IsDisposed createIsDisposed();

	/**
	 * Returns a new object of class '<em>Set Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Text</em>'.
	 * @generated
	 */
	SetText createSetText();

	/**
	 * Returns a new object of class '<em>Get State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get State</em>'.
	 * @generated
	 */
	GetState createGetState();

	/**
	 * Returns a new object of class '<em>Get State Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get State Response</em>'.
	 * @generated
	 */
	GetStateResponse createGetStateResponse();

	/**
	 * Returns a new object of class '<em>Wait For State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait For State</em>'.
	 * @generated
	 */
	WaitForState createWaitForState();

	/**
	 * Returns a new object of class '<em>Rollback To State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rollback To State</em>'.
	 * @generated
	 */
	RollbackToState createRollbackToState();

	/**
	 * Returns a new object of class '<em>Set Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Selection</em>'.
	 * @generated
	 */
	SetSelection createSetSelection();

	/**
	 * Returns a new object of class '<em>Multi Selection Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Selection Item</em>'.
	 * @generated
	 */
	MultiSelectionItem createMultiSelectionItem();

	/**
	 * Returns a new object of class '<em>Shutdown</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shutdown</em>'.
	 * @generated
	 */
	Shutdown createShutdown();

	/**
	 * Returns a new object of class '<em>Nop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nop</em>'.
	 * @generated
	 */
	Nop createNop();

	/**
	 * Returns a new object of class '<em>Count Items</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Count Items</em>'.
	 * @generated
	 */
	CountItems createCountItems();

	/**
	 * Returns a new object of class '<em>Int Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Response</em>'.
	 * @generated
	 */
	IntResponse createIntResponse();

	/**
	 * Returns a new object of class '<em>Save</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Save</em>'.
	 * @generated
	 */
	Save createSave();

	/**
	 * Returns a new object of class '<em>Is Dirty</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Dirty</em>'.
	 * @generated
	 */
	IsDirty createIsDirty();

	/**
	 * Returns a new object of class '<em>Set Text Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Text Selection</em>'.
	 * @generated
	 */
	SetTextSelection createSetTextSelection();

	/**
	 * Returns a new object of class '<em>Set Text Offset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Text Offset</em>'.
	 * @generated
	 */
	SetTextOffset createSetTextOffset();

	/**
	 * Returns a new object of class '<em>Show Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Show Selection</em>'.
	 * @generated
	 */
	ShowSelection createShowSelection();

	/**
	 * Returns a new object of class '<em>Get Text Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Text Selection</em>'.
	 * @generated
	 */
	GetTextSelection createGetTextSelection();

	/**
	 * Returns a new object of class '<em>Go To Text Line</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Go To Text Line</em>'.
	 * @generated
	 */
	GoToTextLine createGoToTextLine();

	/**
	 * Returns a new object of class '<em>Get Text Line Offset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Text Line Offset</em>'.
	 * @generated
	 */
	GetTextLineOffset createGetTextLineOffset();

	/**
	 * Returns a new object of class '<em>Get Text Line Length</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Text Line Length</em>'.
	 * @generated
	 */
	GetTextLineLength createGetTextLineLength();

	/**
	 * Returns a new object of class '<em>Select Text Line</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select Text Line</em>'.
	 * @generated
	 */
	SelectTextLine createSelectTextLine();

	/**
	 * Returns a new object of class '<em>Set Caret Position</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Caret Position</em>'.
	 * @generated
	 */
	SetCaretPosition createSetCaretPosition();

	/**
	 * Returns a new object of class '<em>Get Text Line</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Text Line</em>'.
	 * @generated
	 */
	GetTextLine createGetTextLine();

	/**
	 * Returns a new object of class '<em>Get Text Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Text Range</em>'.
	 * @generated
	 */
	GetTextRange createGetTextRange();

	/**
	 * Returns a new object of class '<em>Text Selection Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Selection Response</em>'.
	 * @generated
	 */
	TextSelectionResponse createTextSelectionResponse();

	/**
	 * Returns a new object of class '<em>Get Color</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Color</em>'.
	 * @generated
	 */
	GetColor createGetColor();

	/**
	 * Returns a new object of class '<em>Set Color</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Color</em>'.
	 * @generated
	 */
	SetColor createSetColor();

	/**
	 * Returns a new object of class '<em>Get Color Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Color Response</em>'.
	 * @generated
	 */
	GetColorResponse createGetColorResponse();

	/**
	 * Returns a new object of class '<em>Type Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Text</em>'.
	 * @generated
	 */
	TypeText createTypeText();

	/**
	 * Returns a new object of class '<em>Children</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Children</em>'.
	 * @generated
	 */
	Children createChildren();

	/**
	 * Returns a new object of class '<em>Children Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Children Response</em>'.
	 * @generated
	 */
	ChildrenResponse createChildrenResponse();

	/**
	 * Returns a new object of class '<em>Parent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parent</em>'.
	 * @generated
	 */
	Parent createParent();

	/**
	 * Returns a new object of class '<em>Parent Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parent Response</em>'.
	 * @generated
	 */
	ParentResponse createParentResponse();

	/**
	 * Returns a new object of class '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type</em>'.
	 * @generated
	 */
	Type createType();

	/**
	 * Returns a new object of class '<em>Type Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Action</em>'.
	 * @generated
	 */
	TypeAction createTypeAction();

	/**
	 * Returns a new object of class '<em>Copy Text Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Copy Text Selection</em>'.
	 * @generated
	 */
	CopyTextSelection createCopyTextSelection();

	/**
	 * Returns a new object of class '<em>Cut Text Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cut Text Selection</em>'.
	 * @generated
	 */
	CutTextSelection createCutTextSelection();

	/**
	 * Returns a new object of class '<em>Paste Text Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Paste Text Selection</em>'.
	 * @generated
	 */
	PasteTextSelection createPasteTextSelection();

	/**
	 * Returns a new object of class '<em>Replace Text Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Replace Text Selection</em>'.
	 * @generated
	 */
	ReplaceTextSelection createReplaceTextSelection();

	/**
	 * Returns a new object of class '<em>Check Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Check Item</em>'.
	 * @generated
	 */
	CheckItem createCheckItem();

	/**
	 * Returns a new object of class '<em>Expand</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expand</em>'.
	 * @generated
	 */
	Expand createExpand();

	/**
	 * Returns a new object of class '<em>Close Workbench</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Close Workbench</em>'.
	 * @generated
	 */
	CloseWorkbench createCloseWorkbench();

	/**
	 * Returns a new object of class '<em>Activate Cell Editor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activate Cell Editor</em>'.
	 * @generated
	 */
	ActivateCellEditor createActivateCellEditor();

	/**
	 * Returns a new object of class '<em>Apply Cell Editor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Apply Cell Editor</em>'.
	 * @generated
	 */
	ApplyCellEditor createApplyCellEditor();

	/**
	 * Returns a new object of class '<em>Cancel Cell Editor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cancel Cell Editor</em>'.
	 * @generated
	 */
	CancelCellEditor createCancelCellEditor();

	/**
	 * Returns a new object of class '<em>Deactivate Cell Editor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deactivate Cell Editor</em>'.
	 * @generated
	 */
	DeactivateCellEditor createDeactivateCellEditor();

	/**
	 * Returns a new object of class '<em>Set SWT Dialog Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set SWT Dialog Info</em>'.
	 * @generated
	 */
	SetSWTDialogInfo createSetSWTDialogInfo();

	/**
	 * Returns a new object of class '<em>Assert</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assert</em>'.
	 * @generated
	 */
	Assert createAssert();

	/**
	 * Returns a new object of class '<em>Get Region Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Region Text</em>'.
	 * @generated
	 */
	GetRegionText createGetRegionText();

	/**
	 * Returns a new object of class '<em>Assert Image Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assert Image Data</em>'.
	 * @generated
	 */
	AssertImageData createAssertImageData();

	/**
	 * Returns a new object of class '<em>Assert Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assert Response</em>'.
	 * @generated
	 */
	AssertResponse createAssertResponse();

	/**
	 * Returns a new object of class '<em>Get Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Selection</em>'.
	 * @generated
	 */
	GetSelection createGetSelection();

	/**
	 * Returns a new object of class '<em>Selection Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Selection Response</em>'.
	 * @generated
	 */
	SelectionResponse createSelectionResponse();

	/**
	 * Returns a new object of class '<em>Selection Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Selection Item</em>'.
	 * @generated
	 */
	SelectionItem createSelectionItem();

	/**
	 * Returns a new object of class '<em>Drag Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drag Command</em>'.
	 * @generated
	 */
	DragCommand createDragCommand();

	/**
	 * Returns a new object of class '<em>Wait For Restart</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait For Restart</em>'.
	 * @generated
	 */
	WaitForRestart createWaitForRestart();

	/**
	 * Returns a new object of class '<em>Cell Click</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cell Click</em>'.
	 * @generated
	 */
	CellClick createCellClick();

	/**
	 * Returns a new object of class '<em>Show Content Assist</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Show Content Assist</em>'.
	 * @generated
	 */
	ShowContentAssist createShowContentAssist();

	/**
	 * Returns a new object of class '<em>Click About Menu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Click About Menu</em>'.
	 * @generated
	 */
	ClickAboutMenu createClickAboutMenu();

	/**
	 * Returns a new object of class '<em>Click Preferences Menu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Click Preferences Menu</em>'.
	 * @generated
	 */
	ClickPreferencesMenu createClickPreferencesMenu();

	/**
	 * Returns a new object of class '<em>Recording Mode Request</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recording Mode Request</em>'.
	 * @generated
	 */
	RecordingModeRequest createRecordingModeRequest();

	/**
	 * Returns a new object of class '<em>Assertion Mode Request</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assertion Mode Request</em>'.
	 * @generated
	 */
	AssertionModeRequest createAssertionModeRequest();

	/**
	 * Returns a new object of class '<em>Minimize</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Minimize</em>'.
	 * @generated
	 */
	Minimize createMinimize();

	/**
	 * Returns a new object of class '<em>Maximize</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Maximize</em>'.
	 * @generated
	 */
	Maximize createMaximize();

	/**
	 * Returns a new object of class '<em>Restore</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Restore</em>'.
	 * @generated
	 */
	Restore createRestore();

	/**
	 * Returns a new object of class '<em>Show Tab List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Show Tab List</em>'.
	 * @generated
	 */
	ShowTabList createShowTabList();

	/**
	 * Returns a new object of class '<em>Set Status Dialog Mode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Status Dialog Mode</em>'.
	 * @generated
	 */
	SetStatusDialogMode createSetStatusDialogMode();

	/**
	 * Returns a new object of class '<em>Check</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Check</em>'.
	 * @generated
	 */
	Check createCheck();

	/**
	 * Returns a new object of class '<em>Hover At Text Offset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hover At Text Offset</em>'.
	 * @generated
	 */
	HoverAtTextOffset createHoverAtTextOffset();

	/**
	 * Returns a new object of class '<em>Set Cursor Offset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Cursor Offset</em>'.
	 * @generated
	 */
	SetCursorOffset createSetCursorOffset();

	/**
	 * Returns a new object of class '<em>Set Text Selection2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Text Selection2</em>'.
	 * @generated
	 */
	SetTextSelection2 createSetTextSelection2();

	/**
	 * Returns a new object of class '<em>Hover At Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hover At Text</em>'.
	 * @generated
	 */
	HoverAtText createHoverAtText();

	/**
	 * Returns a new object of class '<em>Open Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Open Declaration</em>'.
	 * @generated
	 */
	OpenDeclaration createOpenDeclaration();

	/**
	 * Returns a new object of class '<em>Ruler Click</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ruler Click</em>'.
	 * @generated
	 */
	RulerClick createRulerClick();

	/**
	 * Returns a new object of class '<em>Ruler Double Click</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ruler Double Click</em>'.
	 * @generated
	 */
	RulerDoubleClick createRulerDoubleClick();

	/**
	 * Returns a new object of class '<em>Ruler Hover</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ruler Hover</em>'.
	 * @generated
	 */
	RulerHover createRulerHover();

	/**
	 * Returns a new object of class '<em>Click Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Click Link</em>'.
	 * @generated
	 */
	ClickLink createClickLink();

	/**
	 * Returns a new object of class '<em>Set Focus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Focus</em>'.
	 * @generated
	 */
	SetFocus createSetFocus();

	/**
	 * Returns a new object of class '<em>Get Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Property Value</em>'.
	 * @generated
	 */
	GetPropertyValue createGetPropertyValue();

	/**
	 * Returns a new object of class '<em>Object Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Response</em>'.
	 * @generated
	 */
	ObjectResponse createObjectResponse();

	/**
	 * Returns a new object of class '<em>Get Bounds</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Bounds</em>'.
	 * @generated
	 */
	GetBounds createGetBounds();

	/**
	 * Returns a new object of class '<em>Bounds Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bounds Response</em>'.
	 * @generated
	 */
	BoundsResponse createBoundsResponse();

	/**
	 * Returns a new object of class '<em>Collapse</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collapse</em>'.
	 * @generated
	 */
	Collapse createCollapse();

	/**
	 * Returns a new object of class '<em>Click Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Click Column</em>'.
	 * @generated
	 */
	ClickColumn createClickColumn();

	/**
	 * Returns a new object of class '<em>Set Sort Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Sort Column</em>'.
	 * @generated
	 */
	SetSortColumn createSetSortColumn();

	/**
	 * Returns a new object of class '<em>Mouse Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse Event</em>'.
	 * @generated
	 */
	MouseEvent createMouseEvent();

	/**
	 * Returns a new object of class '<em>Click Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Click Text</em>'.
	 * @generated
	 */
	ClickText createClickText();

	/**
	 * Returns a new object of class '<em>Double Click Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Click Text</em>'.
	 * @generated
	 */
	DoubleClickText createDoubleClickText();

	/**
	 * Returns a new object of class '<em>Set Width</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Width</em>'.
	 * @generated
	 */
	SetWidth createSetWidth();

	/**
	 * Returns a new object of class '<em>Set Position</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Position</em>'.
	 * @generated
	 */
	SetPosition createSetPosition();

	/**
	 * Returns a new object of class '<em>Update Control Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Control Command</em>'.
	 * @generated
	 */
	UpdateControlCommand createUpdateControlCommand();

	/**
	 * Returns a new object of class '<em>Rap Download File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rap Download File</em>'.
	 * @generated
	 */
	RapDownloadFile createRapDownloadFile();

	/**
	 * Returns a new object of class '<em>Rap Upload File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rap Upload File</em>'.
	 * @generated
	 */
	RapUploadFile createRapUploadFile();

	/**
	 * Returns a new object of class '<em>Get Items</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Items</em>'.
	 * @generated
	 */
	GetItems createGetItems();

	/**
	 * Returns a new object of class '<em>Get Items Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Items Response</em>'.
	 * @generated
	 */
	GetItemsResponse createGetItemsResponse();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProtocolPackage getProtocolPackage();

} //ProtocolFactory
