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
package org.eclipse.rcptt.tesla.core.protocol.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.rcptt.tesla.core.protocol.*;
import org.eclipse.rcptt.tesla.core.protocol.Shutdown;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProtocolFactoryImpl extends EFactoryImpl implements ProtocolFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProtocolFactory init() {
		try {
			ProtocolFactory theProtocolFactory = (ProtocolFactory)EPackage.Registry.INSTANCE.getEFactory(ProtocolPackage.eNS_URI);
			if (theProtocolFactory != null) {
				return theProtocolFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProtocolFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolFactoryImpl() {
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
			case ProtocolPackage.SELECT_DATA: return createSelectData();
			case ProtocolPackage.IML_SELECT_DATA: return createIMLSelectData();
			case ProtocolPackage.SELECT_COMMAND: return createSelectCommand();
			case ProtocolPackage.SELECT_RESPONSE: return createSelectResponse();
			case ProtocolPackage.CLICK: return createClick();
			case ProtocolPackage.DOUBLE_CLICK: return createDoubleClick();
			case ProtocolPackage.SHOW: return createShow();
			case ProtocolPackage.HIDE: return createHide();
			case ProtocolPackage.CLOSE: return createClose();
			case ProtocolPackage.GET_TEXT: return createGetText();
			case ProtocolPackage.GET_TEXT_RESPONSE: return createGetTextResponse();
			case ProtocolPackage.BOOLEAN_RESPONSE: return createBooleanResponse();
			case ProtocolPackage.IS_ENABLED: return createIsEnabled();
			case ProtocolPackage.IS_DISPOSED: return createIsDisposed();
			case ProtocolPackage.SET_TEXT: return createSetText();
			case ProtocolPackage.GET_STATE: return createGetState();
			case ProtocolPackage.GET_STATE_RESPONSE: return createGetStateResponse();
			case ProtocolPackage.WAIT_FOR_STATE: return createWaitForState();
			case ProtocolPackage.ROLLBACK_TO_STATE: return createRollbackToState();
			case ProtocolPackage.SET_SELECTION: return createSetSelection();
			case ProtocolPackage.MULTI_SELECTION_ITEM: return createMultiSelectionItem();
			case ProtocolPackage.SHUTDOWN: return createShutdown();
			case ProtocolPackage.NOP: return createNop();
			case ProtocolPackage.COUNT_ITEMS: return createCountItems();
			case ProtocolPackage.INT_RESPONSE: return createIntResponse();
			case ProtocolPackage.SAVE: return createSave();
			case ProtocolPackage.IS_DIRTY: return createIsDirty();
			case ProtocolPackage.SET_TEXT_SELECTION: return createSetTextSelection();
			case ProtocolPackage.SET_TEXT_OFFSET: return createSetTextOffset();
			case ProtocolPackage.SHOW_SELECTION: return createShowSelection();
			case ProtocolPackage.GET_TEXT_SELECTION: return createGetTextSelection();
			case ProtocolPackage.GO_TO_TEXT_LINE: return createGoToTextLine();
			case ProtocolPackage.GET_TEXT_LINE_OFFSET: return createGetTextLineOffset();
			case ProtocolPackage.GET_TEXT_LINE_LENGTH: return createGetTextLineLength();
			case ProtocolPackage.SELECT_TEXT_LINE: return createSelectTextLine();
			case ProtocolPackage.SET_CARET_POSITION: return createSetCaretPosition();
			case ProtocolPackage.GET_TEXT_LINE: return createGetTextLine();
			case ProtocolPackage.GET_TEXT_RANGE: return createGetTextRange();
			case ProtocolPackage.TEXT_SELECTION_RESPONSE: return createTextSelectionResponse();
			case ProtocolPackage.GET_COLOR: return createGetColor();
			case ProtocolPackage.SET_COLOR: return createSetColor();
			case ProtocolPackage.GET_COLOR_RESPONSE: return createGetColorResponse();
			case ProtocolPackage.TYPE_TEXT: return createTypeText();
			case ProtocolPackage.CHILDREN: return createChildren();
			case ProtocolPackage.CHILDREN_RESPONSE: return createChildrenResponse();
			case ProtocolPackage.PARENT: return createParent();
			case ProtocolPackage.PARENT_RESPONSE: return createParentResponse();
			case ProtocolPackage.TYPE: return createType();
			case ProtocolPackage.TYPE_ACTION: return createTypeAction();
			case ProtocolPackage.COPY_TEXT_SELECTION: return createCopyTextSelection();
			case ProtocolPackage.CUT_TEXT_SELECTION: return createCutTextSelection();
			case ProtocolPackage.PASTE_TEXT_SELECTION: return createPasteTextSelection();
			case ProtocolPackage.REPLACE_TEXT_SELECTION: return createReplaceTextSelection();
			case ProtocolPackage.CHECK_ITEM: return createCheckItem();
			case ProtocolPackage.EXPAND: return createExpand();
			case ProtocolPackage.CLOSE_WORKBENCH: return createCloseWorkbench();
			case ProtocolPackage.ACTIVATE_CELL_EDITOR: return createActivateCellEditor();
			case ProtocolPackage.APPLY_CELL_EDITOR: return createApplyCellEditor();
			case ProtocolPackage.CANCEL_CELL_EDITOR: return createCancelCellEditor();
			case ProtocolPackage.DEACTIVATE_CELL_EDITOR: return createDeactivateCellEditor();
			case ProtocolPackage.SET_SWT_DIALOG_INFO: return createSetSWTDialogInfo();
			case ProtocolPackage.ASSERT: return createAssert();
			case ProtocolPackage.GET_REGION_TEXT: return createGetRegionText();
			case ProtocolPackage.ASSERT_IMAGE_DATA: return createAssertImageData();
			case ProtocolPackage.ASSERT_RESPONSE: return createAssertResponse();
			case ProtocolPackage.GET_SELECTION: return createGetSelection();
			case ProtocolPackage.SELECTION_RESPONSE: return createSelectionResponse();
			case ProtocolPackage.SELECTION_ITEM: return createSelectionItem();
			case ProtocolPackage.DRAG_COMMAND: return createDragCommand();
			case ProtocolPackage.WAIT_FOR_RESTART: return createWaitForRestart();
			case ProtocolPackage.CELL_CLICK: return createCellClick();
			case ProtocolPackage.SHOW_CONTENT_ASSIST: return createShowContentAssist();
			case ProtocolPackage.CLICK_ABOUT_MENU: return createClickAboutMenu();
			case ProtocolPackage.CLICK_PREFERENCES_MENU: return createClickPreferencesMenu();
			case ProtocolPackage.RECORDING_MODE_REQUEST: return createRecordingModeRequest();
			case ProtocolPackage.ASSERTION_MODE_REQUEST: return createAssertionModeRequest();
			case ProtocolPackage.MINIMIZE: return createMinimize();
			case ProtocolPackage.MAXIMIZE: return createMaximize();
			case ProtocolPackage.RESTORE: return createRestore();
			case ProtocolPackage.SHOW_TAB_LIST: return createShowTabList();
			case ProtocolPackage.SET_STATUS_DIALOG_MODE: return createSetStatusDialogMode();
			case ProtocolPackage.CHECK: return createCheck();
			case ProtocolPackage.HOVER_AT_TEXT_OFFSET: return createHoverAtTextOffset();
			case ProtocolPackage.SET_CURSOR_OFFSET: return createSetCursorOffset();
			case ProtocolPackage.SET_TEXT_SELECTION2: return createSetTextSelection2();
			case ProtocolPackage.HOVER_AT_TEXT: return createHoverAtText();
			case ProtocolPackage.OPEN_DECLARATION: return createOpenDeclaration();
			case ProtocolPackage.RULER_CLICK: return createRulerClick();
			case ProtocolPackage.RULER_DOUBLE_CLICK: return createRulerDoubleClick();
			case ProtocolPackage.RULER_HOVER: return createRulerHover();
			case ProtocolPackage.CLICK_LINK: return createClickLink();
			case ProtocolPackage.SET_FOCUS: return createSetFocus();
			case ProtocolPackage.GET_PROPERTY_VALUE: return createGetPropertyValue();
			case ProtocolPackage.OBJECT_RESPONSE: return createObjectResponse();
			case ProtocolPackage.GET_BOUNDS: return createGetBounds();
			case ProtocolPackage.BOUNDS_RESPONSE: return createBoundsResponse();
			case ProtocolPackage.COLLAPSE: return createCollapse();
			case ProtocolPackage.CLICK_COLUMN: return createClickColumn();
			case ProtocolPackage.SET_SORT_COLUMN: return createSetSortColumn();
			case ProtocolPackage.MOUSE_EVENT: return createMouseEvent();
			case ProtocolPackage.CLICK_TEXT: return createClickText();
			case ProtocolPackage.DOUBLE_CLICK_TEXT: return createDoubleClickText();
			case ProtocolPackage.SET_WIDTH: return createSetWidth();
			case ProtocolPackage.SET_POSITION: return createSetPosition();
			case ProtocolPackage.UPDATE_CONTROL_COMMAND: return createUpdateControlCommand();
			case ProtocolPackage.RAP_DOWNLOAD_FILE: return createRapDownloadFile();
			case ProtocolPackage.RAP_UPLOAD_FILE: return createRapUploadFile();
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
			case ProtocolPackage.SWT_DIALOG_KIND:
				return createSWTDialogKindFromString(eDataType, initialValue);
			case ProtocolPackage.ASSERT_KIND:
				return createAssertKindFromString(eDataType, initialValue);
			case ProtocolPackage.DRAG_KIND:
				return createDragKindFromString(eDataType, initialValue);
			case ProtocolPackage.MOUSE_EVENT_KIND:
				return createMouseEventKindFromString(eDataType, initialValue);
			case ProtocolPackage.ACTIVATION_EVENT_TYPE:
				return createActivationEventTypeFromString(eDataType, initialValue);
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
			case ProtocolPackage.SWT_DIALOG_KIND:
				return convertSWTDialogKindToString(eDataType, instanceValue);
			case ProtocolPackage.ASSERT_KIND:
				return convertAssertKindToString(eDataType, instanceValue);
			case ProtocolPackage.DRAG_KIND:
				return convertDragKindToString(eDataType, instanceValue);
			case ProtocolPackage.MOUSE_EVENT_KIND:
				return convertMouseEventKindToString(eDataType, instanceValue);
			case ProtocolPackage.ACTIVATION_EVENT_TYPE:
				return convertActivationEventTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectData createSelectData() {
		SelectDataImpl selectData = new SelectDataImpl();
		return selectData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IMLSelectData createIMLSelectData() {
		IMLSelectDataImpl imlSelectData = new IMLSelectDataImpl();
		return imlSelectData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectCommand createSelectCommand() {
		SelectCommandImpl selectCommand = new SelectCommandImpl();
		return selectCommand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectResponse createSelectResponse() {
		SelectResponseImpl selectResponse = new SelectResponseImpl();
		return selectResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Click createClick() {
		ClickImpl click = new ClickImpl();
		return click;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleClick createDoubleClick() {
		DoubleClickImpl doubleClick = new DoubleClickImpl();
		return doubleClick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Show createShow() {
		ShowImpl show = new ShowImpl();
		return show;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hide createHide() {
		HideImpl hide = new HideImpl();
		return hide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Close createClose() {
		CloseImpl close = new CloseImpl();
		return close;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetText createGetText() {
		GetTextImpl getText = new GetTextImpl();
		return getText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetTextResponse createGetTextResponse() {
		GetTextResponseImpl getTextResponse = new GetTextResponseImpl();
		return getTextResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanResponse createBooleanResponse() {
		BooleanResponseImpl booleanResponse = new BooleanResponseImpl();
		return booleanResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsEnabled createIsEnabled() {
		IsEnabledImpl isEnabled = new IsEnabledImpl();
		return isEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsDisposed createIsDisposed() {
		IsDisposedImpl isDisposed = new IsDisposedImpl();
		return isDisposed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetText createSetText() {
		SetTextImpl setText = new SetTextImpl();
		return setText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetState createGetState() {
		GetStateImpl getState = new GetStateImpl();
		return getState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetStateResponse createGetStateResponse() {
		GetStateResponseImpl getStateResponse = new GetStateResponseImpl();
		return getStateResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaitForState createWaitForState() {
		WaitForStateImpl waitForState = new WaitForStateImpl();
		return waitForState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RollbackToState createRollbackToState() {
		RollbackToStateImpl rollbackToState = new RollbackToStateImpl();
		return rollbackToState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetSelection createSetSelection() {
		SetSelectionImpl setSelection = new SetSelectionImpl();
		return setSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiSelectionItem createMultiSelectionItem() {
		MultiSelectionItemImpl multiSelectionItem = new MultiSelectionItemImpl();
		return multiSelectionItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Shutdown createShutdown() {
		ShutdownImpl shutdown = new ShutdownImpl();
		return shutdown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Nop createNop() {
		NopImpl nop = new NopImpl();
		return nop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CountItems createCountItems() {
		CountItemsImpl countItems = new CountItemsImpl();
		return countItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntResponse createIntResponse() {
		IntResponseImpl intResponse = new IntResponseImpl();
		return intResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Save createSave() {
		SaveImpl save = new SaveImpl();
		return save;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsDirty createIsDirty() {
		IsDirtyImpl isDirty = new IsDirtyImpl();
		return isDirty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetTextSelection createSetTextSelection() {
		SetTextSelectionImpl setTextSelection = new SetTextSelectionImpl();
		return setTextSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetTextOffset createSetTextOffset() {
		SetTextOffsetImpl setTextOffset = new SetTextOffsetImpl();
		return setTextOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShowSelection createShowSelection() {
		ShowSelectionImpl showSelection = new ShowSelectionImpl();
		return showSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetTextSelection createGetTextSelection() {
		GetTextSelectionImpl getTextSelection = new GetTextSelectionImpl();
		return getTextSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoToTextLine createGoToTextLine() {
		GoToTextLineImpl goToTextLine = new GoToTextLineImpl();
		return goToTextLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetTextLineOffset createGetTextLineOffset() {
		GetTextLineOffsetImpl getTextLineOffset = new GetTextLineOffsetImpl();
		return getTextLineOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetTextLineLength createGetTextLineLength() {
		GetTextLineLengthImpl getTextLineLength = new GetTextLineLengthImpl();
		return getTextLineLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectTextLine createSelectTextLine() {
		SelectTextLineImpl selectTextLine = new SelectTextLineImpl();
		return selectTextLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetCaretPosition createSetCaretPosition() {
		SetCaretPositionImpl setCaretPosition = new SetCaretPositionImpl();
		return setCaretPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetTextLine createGetTextLine() {
		GetTextLineImpl getTextLine = new GetTextLineImpl();
		return getTextLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetTextRange createGetTextRange() {
		GetTextRangeImpl getTextRange = new GetTextRangeImpl();
		return getTextRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSelectionResponse createTextSelectionResponse() {
		TextSelectionResponseImpl textSelectionResponse = new TextSelectionResponseImpl();
		return textSelectionResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetColor createGetColor() {
		GetColorImpl getColor = new GetColorImpl();
		return getColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetColor createSetColor() {
		SetColorImpl setColor = new SetColorImpl();
		return setColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetColorResponse createGetColorResponse() {
		GetColorResponseImpl getColorResponse = new GetColorResponseImpl();
		return getColorResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeText createTypeText() {
		TypeTextImpl typeText = new TypeTextImpl();
		return typeText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Children createChildren() {
		ChildrenImpl children = new ChildrenImpl();
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildrenResponse createChildrenResponse() {
		ChildrenResponseImpl childrenResponse = new ChildrenResponseImpl();
		return childrenResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parent createParent() {
		ParentImpl parent = new ParentImpl();
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParentResponse createParentResponse() {
		ParentResponseImpl parentResponse = new ParentResponseImpl();
		return parentResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type createType() {
		TypeImpl type = new TypeImpl();
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeAction createTypeAction() {
		TypeActionImpl typeAction = new TypeActionImpl();
		return typeAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CopyTextSelection createCopyTextSelection() {
		CopyTextSelectionImpl copyTextSelection = new CopyTextSelectionImpl();
		return copyTextSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CutTextSelection createCutTextSelection() {
		CutTextSelectionImpl cutTextSelection = new CutTextSelectionImpl();
		return cutTextSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PasteTextSelection createPasteTextSelection() {
		PasteTextSelectionImpl pasteTextSelection = new PasteTextSelectionImpl();
		return pasteTextSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplaceTextSelection createReplaceTextSelection() {
		ReplaceTextSelectionImpl replaceTextSelection = new ReplaceTextSelectionImpl();
		return replaceTextSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckItem createCheckItem() {
		CheckItemImpl checkItem = new CheckItemImpl();
		return checkItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expand createExpand() {
		ExpandImpl expand = new ExpandImpl();
		return expand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloseWorkbench createCloseWorkbench() {
		CloseWorkbenchImpl closeWorkbench = new CloseWorkbenchImpl();
		return closeWorkbench;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivateCellEditor createActivateCellEditor() {
		ActivateCellEditorImpl activateCellEditor = new ActivateCellEditorImpl();
		return activateCellEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplyCellEditor createApplyCellEditor() {
		ApplyCellEditorImpl applyCellEditor = new ApplyCellEditorImpl();
		return applyCellEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CancelCellEditor createCancelCellEditor() {
		CancelCellEditorImpl cancelCellEditor = new CancelCellEditorImpl();
		return cancelCellEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeactivateCellEditor createDeactivateCellEditor() {
		DeactivateCellEditorImpl deactivateCellEditor = new DeactivateCellEditorImpl();
		return deactivateCellEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetSWTDialogInfo createSetSWTDialogInfo() {
		SetSWTDialogInfoImpl setSWTDialogInfo = new SetSWTDialogInfoImpl();
		return setSWTDialogInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assert createAssert() {
		AssertImpl assert_ = new AssertImpl();
		return assert_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetRegionText createGetRegionText() {
		GetRegionTextImpl getRegionText = new GetRegionTextImpl();
		return getRegionText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssertImageData createAssertImageData() {
		AssertImageDataImpl assertImageData = new AssertImageDataImpl();
		return assertImageData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssertResponse createAssertResponse() {
		AssertResponseImpl assertResponse = new AssertResponseImpl();
		return assertResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetSelection createGetSelection() {
		GetSelectionImpl getSelection = new GetSelectionImpl();
		return getSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionResponse createSelectionResponse() {
		SelectionResponseImpl selectionResponse = new SelectionResponseImpl();
		return selectionResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionItem createSelectionItem() {
		SelectionItemImpl selectionItem = new SelectionItemImpl();
		return selectionItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DragCommand createDragCommand() {
		DragCommandImpl dragCommand = new DragCommandImpl();
		return dragCommand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WaitForRestart createWaitForRestart() {
		WaitForRestartImpl waitForRestart = new WaitForRestartImpl();
		return waitForRestart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CellClick createCellClick() {
		CellClickImpl cellClick = new CellClickImpl();
		return cellClick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShowContentAssist createShowContentAssist() {
		ShowContentAssistImpl showContentAssist = new ShowContentAssistImpl();
		return showContentAssist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClickAboutMenu createClickAboutMenu() {
		ClickAboutMenuImpl clickAboutMenu = new ClickAboutMenuImpl();
		return clickAboutMenu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClickPreferencesMenu createClickPreferencesMenu() {
		ClickPreferencesMenuImpl clickPreferencesMenu = new ClickPreferencesMenuImpl();
		return clickPreferencesMenu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecordingModeRequest createRecordingModeRequest() {
		RecordingModeRequestImpl recordingModeRequest = new RecordingModeRequestImpl();
		return recordingModeRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssertionModeRequest createAssertionModeRequest() {
		AssertionModeRequestImpl assertionModeRequest = new AssertionModeRequestImpl();
		return assertionModeRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Minimize createMinimize() {
		MinimizeImpl minimize = new MinimizeImpl();
		return minimize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Maximize createMaximize() {
		MaximizeImpl maximize = new MaximizeImpl();
		return maximize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Restore createRestore() {
		RestoreImpl restore = new RestoreImpl();
		return restore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShowTabList createShowTabList() {
		ShowTabListImpl showTabList = new ShowTabListImpl();
		return showTabList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetStatusDialogMode createSetStatusDialogMode() {
		SetStatusDialogModeImpl setStatusDialogMode = new SetStatusDialogModeImpl();
		return setStatusDialogMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Check createCheck() {
		CheckImpl check = new CheckImpl();
		return check;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HoverAtTextOffset createHoverAtTextOffset() {
		HoverAtTextOffsetImpl hoverAtTextOffset = new HoverAtTextOffsetImpl();
		return hoverAtTextOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetCursorOffset createSetCursorOffset() {
		SetCursorOffsetImpl setCursorOffset = new SetCursorOffsetImpl();
		return setCursorOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetTextSelection2 createSetTextSelection2() {
		SetTextSelection2Impl setTextSelection2 = new SetTextSelection2Impl();
		return setTextSelection2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HoverAtText createHoverAtText() {
		HoverAtTextImpl hoverAtText = new HoverAtTextImpl();
		return hoverAtText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenDeclaration createOpenDeclaration() {
		OpenDeclarationImpl openDeclaration = new OpenDeclarationImpl();
		return openDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RulerClick createRulerClick() {
		RulerClickImpl rulerClick = new RulerClickImpl();
		return rulerClick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RulerDoubleClick createRulerDoubleClick() {
		RulerDoubleClickImpl rulerDoubleClick = new RulerDoubleClickImpl();
		return rulerDoubleClick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RulerHover createRulerHover() {
		RulerHoverImpl rulerHover = new RulerHoverImpl();
		return rulerHover;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClickLink createClickLink() {
		ClickLinkImpl clickLink = new ClickLinkImpl();
		return clickLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetFocus createSetFocus() {
		SetFocusImpl setFocus = new SetFocusImpl();
		return setFocus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetPropertyValue createGetPropertyValue() {
		GetPropertyValueImpl getPropertyValue = new GetPropertyValueImpl();
		return getPropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectResponse createObjectResponse() {
		ObjectResponseImpl objectResponse = new ObjectResponseImpl();
		return objectResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetBounds createGetBounds() {
		GetBoundsImpl getBounds = new GetBoundsImpl();
		return getBounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundsResponse createBoundsResponse() {
		BoundsResponseImpl boundsResponse = new BoundsResponseImpl();
		return boundsResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collapse createCollapse() {
		CollapseImpl collapse = new CollapseImpl();
		return collapse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClickColumn createClickColumn() {
		ClickColumnImpl clickColumn = new ClickColumnImpl();
		return clickColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetSortColumn createSetSortColumn() {
		SetSortColumnImpl setSortColumn = new SetSortColumnImpl();
		return setSortColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MouseEvent createMouseEvent() {
		MouseEventImpl mouseEvent = new MouseEventImpl();
		return mouseEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClickText createClickText() {
		ClickTextImpl clickText = new ClickTextImpl();
		return clickText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleClickText createDoubleClickText() {
		DoubleClickTextImpl doubleClickText = new DoubleClickTextImpl();
		return doubleClickText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetWidth createSetWidth() {
		SetWidthImpl setWidth = new SetWidthImpl();
		return setWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetPosition createSetPosition() {
		SetPositionImpl setPosition = new SetPositionImpl();
		return setPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdateControlCommand createUpdateControlCommand() {
		UpdateControlCommandImpl updateControlCommand = new UpdateControlCommandImpl();
		return updateControlCommand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RapDownloadFile createRapDownloadFile() {
		RapDownloadFileImpl rapDownloadFile = new RapDownloadFileImpl();
		return rapDownloadFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RapUploadFile createRapUploadFile() {
		RapUploadFileImpl rapUploadFile = new RapUploadFileImpl();
		return rapUploadFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SWTDialogKind createSWTDialogKindFromString(EDataType eDataType, String initialValue) {
		SWTDialogKind result = SWTDialogKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSWTDialogKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssertKind createAssertKindFromString(EDataType eDataType, String initialValue) {
		AssertKind result = AssertKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAssertKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DragKind createDragKindFromString(EDataType eDataType, String initialValue) {
		DragKind result = DragKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDragKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MouseEventKind createMouseEventKindFromString(EDataType eDataType, String initialValue) {
		MouseEventKind result = MouseEventKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMouseEventKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivationEventType createActivationEventTypeFromString(EDataType eDataType, String initialValue) {
		ActivationEventType result = ActivationEventType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActivationEventTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolPackage getProtocolPackage() {
		return (ProtocolPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProtocolPackage getPackage() {
		return ProtocolPackage.eINSTANCE;
	}

} //ProtocolFactoryImpl
