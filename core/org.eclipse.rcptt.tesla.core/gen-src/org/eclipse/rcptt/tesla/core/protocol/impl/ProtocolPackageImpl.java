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
package org.eclipse.rcptt.tesla.core.protocol.impl;

import org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.Assert;
import org.eclipse.rcptt.tesla.core.protocol.AssertImageData;
import org.eclipse.rcptt.tesla.core.protocol.AssertKind;
import org.eclipse.rcptt.tesla.core.protocol.AssertResponse;
import org.eclipse.rcptt.tesla.core.protocol.AssertionModeRequest;
import org.eclipse.rcptt.tesla.core.protocol.BooleanResponse;
import org.eclipse.rcptt.tesla.core.protocol.BoundsResponse;
import org.eclipse.rcptt.tesla.core.protocol.CancelCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.CellClick;
import org.eclipse.rcptt.tesla.core.protocol.Check;
import org.eclipse.rcptt.tesla.core.protocol.CheckItem;
import org.eclipse.rcptt.tesla.core.protocol.Children;
import org.eclipse.rcptt.tesla.core.protocol.ChildrenResponse;
import org.eclipse.rcptt.tesla.core.protocol.Click;
import org.eclipse.rcptt.tesla.core.protocol.ClickAboutMenu;
import org.eclipse.rcptt.tesla.core.protocol.ClickColumn;
import org.eclipse.rcptt.tesla.core.protocol.ClickLink;
import org.eclipse.rcptt.tesla.core.protocol.ClickPreferencesMenu;
import org.eclipse.rcptt.tesla.core.protocol.ClickText;
import org.eclipse.rcptt.tesla.core.protocol.Close;
import org.eclipse.rcptt.tesla.core.protocol.CloseWorkbench;
import org.eclipse.rcptt.tesla.core.protocol.Collapse;
import org.eclipse.rcptt.tesla.core.protocol.CopyTextSelection;
import org.eclipse.rcptt.tesla.core.protocol.CountItems;
import org.eclipse.rcptt.tesla.core.protocol.CutTextSelection;
import org.eclipse.rcptt.tesla.core.protocol.DeactivateCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.DoubleClick;
import org.eclipse.rcptt.tesla.core.protocol.DoubleClickText;
import org.eclipse.rcptt.tesla.core.protocol.DragCommand;
import org.eclipse.rcptt.tesla.core.protocol.DragKind;
import org.eclipse.rcptt.tesla.core.protocol.ElementCommand;
import org.eclipse.rcptt.tesla.core.protocol.Expand;
import org.eclipse.rcptt.tesla.core.protocol.GetBounds;
import org.eclipse.rcptt.tesla.core.protocol.GetColor;
import org.eclipse.rcptt.tesla.core.protocol.GetColorResponse;
import org.eclipse.rcptt.tesla.core.protocol.GetPropertyValue;
import org.eclipse.rcptt.tesla.core.protocol.GetRegionText;
import org.eclipse.rcptt.tesla.core.protocol.GetSelection;
import org.eclipse.rcptt.tesla.core.protocol.GetState;
import org.eclipse.rcptt.tesla.core.protocol.GetStateResponse;
import org.eclipse.rcptt.tesla.core.protocol.GetText;
import org.eclipse.rcptt.tesla.core.protocol.GetTextLine;
import org.eclipse.rcptt.tesla.core.protocol.GetTextLineLength;
import org.eclipse.rcptt.tesla.core.protocol.GetTextLineOffset;
import org.eclipse.rcptt.tesla.core.protocol.GetTextRange;
import org.eclipse.rcptt.tesla.core.protocol.GetTextResponse;
import org.eclipse.rcptt.tesla.core.protocol.GetTextSelection;
import org.eclipse.rcptt.tesla.core.protocol.GoToTextLine;
import org.eclipse.rcptt.tesla.core.protocol.Hide;
import org.eclipse.rcptt.tesla.core.protocol.HoverAtText;
import org.eclipse.rcptt.tesla.core.protocol.HoverAtTextOffset;
import org.eclipse.rcptt.tesla.core.protocol.IMLSelectData;
import org.eclipse.rcptt.tesla.core.protocol.IntResponse;
import org.eclipse.rcptt.tesla.core.protocol.IsDirty;
import org.eclipse.rcptt.tesla.core.protocol.IsDisposed;
import org.eclipse.rcptt.tesla.core.protocol.IsEnabled;
import org.eclipse.rcptt.tesla.core.protocol.Maximize;
import org.eclipse.rcptt.tesla.core.protocol.Minimize;
import org.eclipse.rcptt.tesla.core.protocol.MouseEvent;
import org.eclipse.rcptt.tesla.core.protocol.MouseEventKind;
import org.eclipse.rcptt.tesla.core.protocol.MultiSelectionItem;
import org.eclipse.rcptt.tesla.core.protocol.Nop;
import org.eclipse.rcptt.tesla.core.protocol.ObjectResponse;
import org.eclipse.rcptt.tesla.core.protocol.OpenDeclaration;
import org.eclipse.rcptt.tesla.core.protocol.Parent;
import org.eclipse.rcptt.tesla.core.protocol.ParentResponse;
import org.eclipse.rcptt.tesla.core.protocol.PasteTextSelection;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;
import org.eclipse.rcptt.tesla.core.protocol.RecordingModeRequest;
import org.eclipse.rcptt.tesla.core.protocol.ReplaceTextSelection;
import org.eclipse.rcptt.tesla.core.protocol.Restore;
import org.eclipse.rcptt.tesla.core.protocol.RollbackToState;
import org.eclipse.rcptt.tesla.core.protocol.RulerClick;
import org.eclipse.rcptt.tesla.core.protocol.RulerDoubleClick;
import org.eclipse.rcptt.tesla.core.protocol.RulerHover;
import org.eclipse.rcptt.tesla.core.protocol.SWTDialogKind;
import org.eclipse.rcptt.tesla.core.protocol.Save;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.SelectData;
import org.eclipse.rcptt.tesla.core.protocol.SelectResponse;
import org.eclipse.rcptt.tesla.core.protocol.SelectTextLine;
import org.eclipse.rcptt.tesla.core.protocol.SelectionItem;
import org.eclipse.rcptt.tesla.core.protocol.SelectionResponse;
import org.eclipse.rcptt.tesla.core.protocol.SetCaretPosition;
import org.eclipse.rcptt.tesla.core.protocol.SetColor;
import org.eclipse.rcptt.tesla.core.protocol.SetCursorOffset;
import org.eclipse.rcptt.tesla.core.protocol.SetFocus;
import org.eclipse.rcptt.tesla.core.protocol.SetPosition;
import org.eclipse.rcptt.tesla.core.protocol.SetSWTDialogInfo;
import org.eclipse.rcptt.tesla.core.protocol.SetSelection;
import org.eclipse.rcptt.tesla.core.protocol.SetSortColumn;
import org.eclipse.rcptt.tesla.core.protocol.SetStatusDialogMode;
import org.eclipse.rcptt.tesla.core.protocol.SetText;
import org.eclipse.rcptt.tesla.core.protocol.SetTextOffset;
import org.eclipse.rcptt.tesla.core.protocol.SetTextSelection;
import org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2;
import org.eclipse.rcptt.tesla.core.protocol.SetWidth;
import org.eclipse.rcptt.tesla.core.protocol.Show;
import org.eclipse.rcptt.tesla.core.protocol.ShowContentAssist;
import org.eclipse.rcptt.tesla.core.protocol.ShowSelection;
import org.eclipse.rcptt.tesla.core.protocol.ShowTabList;
import org.eclipse.rcptt.tesla.core.protocol.Shutdown;
import org.eclipse.rcptt.tesla.core.protocol.TextSelectionResponse;
import org.eclipse.rcptt.tesla.core.protocol.Type;
import org.eclipse.rcptt.tesla.core.protocol.TypeAction;
import org.eclipse.rcptt.tesla.core.protocol.TypeText;
import org.eclipse.rcptt.tesla.core.protocol.UpdateControlCommand;
import org.eclipse.rcptt.tesla.core.protocol.WaitForRestart;
import org.eclipse.rcptt.tesla.core.protocol.WaitForState;

import org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProtocolPackageImpl extends EPackageImpl implements ProtocolPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imlSelectDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleClickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass showEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hideEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass closeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getTextResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isEnabledEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isDisposedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getStateResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass waitForStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rollbackToStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiSelectionItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shutdownEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass countItemsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass saveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isDirtyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setTextSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setTextOffsetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass showSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getTextSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass goToTextLineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getTextLineOffsetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getTextLineLengthEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectTextLineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setCaretPositionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getTextLineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getTextRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textSelectionResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getColorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setColorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getColorResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childrenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childrenResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parentResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass copyTextSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cutTextSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pasteTextSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replaceTextSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass closeWorkbenchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activateCellEditorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applyCellEditorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cancelCellEditorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deactivateCellEditorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setSWTDialogInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getRegionTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertImageDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectionResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectionItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dragCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass waitForRestartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cellClickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass showContentAssistEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clickAboutMenuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clickPreferencesMenuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recordingModeRequestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertionModeRequestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass minimizeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass maximizeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass restoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass showTabListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setStatusDialogModeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hoverAtTextOffsetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setCursorOffsetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setTextSelection2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hoverAtTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rulerClickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rulerDoubleClickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rulerHoverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clickLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setFocusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getPropertyValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getBoundsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundsResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collapseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clickColumnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setSortColumnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mouseEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clickTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleClickTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setWidthEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setPositionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateControlCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum swtDialogKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum assertKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dragKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mouseEventKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProtocolPackageImpl() {
		super(eNS_URI, ProtocolFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ProtocolPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProtocolPackage init() {
		if (isInited) return (ProtocolPackage)EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI);

		// Obtain or create and register package
		ProtocolPackageImpl theProtocolPackage = (ProtocolPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ProtocolPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ProtocolPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		RawPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theProtocolPackage.createPackageContents();

		// Initialize created meta-data
		theProtocolPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProtocolPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProtocolPackage.eNS_URI, theProtocolPackage);
		return theProtocolPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectData() {
		return selectDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectData_Kind() {
		return (EAttribute)selectDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectData_Pattern() {
		return (EAttribute)selectDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectData_Path() {
		return (EAttribute)selectDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectData_Index() {
		return (EAttribute)selectDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectData_Multiplicity() {
		return (EAttribute)selectDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectData_After() {
		return (EReference)selectDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectData_Parent() {
		return (EReference)selectDataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectData_ClassPattern() {
		return (EAttribute)selectDataEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectData_Indexes() {
		return (EAttribute)selectDataEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIMLSelectData() {
		return imlSelectDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIMLSelectData_Image() {
		return (EAttribute)imlSelectDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectCommand() {
		return selectCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectCommand_Data() {
		return (EReference)selectCommandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectCommand_ContainChildren() {
		return (EReference)selectCommandEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectResponse() {
		return selectResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectResponse_Elements() {
		return (EReference)selectResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementCommand() {
		return elementCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementCommand_Element() {
		return (EReference)elementCommandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClick() {
		return clickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClick_Default() {
		return (EAttribute)clickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClick_WithWait() {
		return (EAttribute)clickEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClick_Arrow() {
		return (EAttribute)clickEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleClick() {
		return doubleClickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleClick_WithWait() {
		return (EAttribute)doubleClickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShow() {
		return showEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHide() {
		return hideEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClose() {
		return closeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetText() {
		return getTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetTextResponse() {
		return getTextResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetTextResponse_Text() {
		return (EAttribute)getTextResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanResponse() {
		return booleanResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanResponse_Result() {
		return (EAttribute)booleanResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsEnabled() {
		return isEnabledEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsDisposed() {
		return isDisposedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetText() {
		return setTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetText_Value() {
		return (EAttribute)setTextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetText_Select() {
		return (EAttribute)setTextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetText_Hidden() {
		return (EAttribute)setTextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetState() {
		return getStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetStateResponse() {
		return getStateResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGetStateResponse_State() {
		return (EReference)getStateResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWaitForState() {
		return waitForStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWaitForState_State() {
		return (EReference)waitForStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRollbackToState() {
		return rollbackToStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRollbackToState_State() {
		return (EReference)rollbackToStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetSelection() {
		return setSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetSelection_Path() {
		return (EAttribute)setSelectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetSelection_Pattern() {
		return (EAttribute)setSelectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetSelection_Index() {
		return (EAttribute)setSelectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetSelection_AdditionalItems() {
		return (EReference)setSelectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetSelection_All() {
		return (EAttribute)setSelectionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiSelectionItem() {
		return multiSelectionItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiSelectionItem_Path() {
		return (EAttribute)multiSelectionItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiSelectionItem_Pattern() {
		return (EAttribute)multiSelectionItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiSelectionItem_Index() {
		return (EAttribute)multiSelectionItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShutdown() {
		return shutdownEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNop() {
		return nopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCountItems() {
		return countItemsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountItems_Path() {
		return (EAttribute)countItemsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntResponse() {
		return intResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntResponse_Result() {
		return (EAttribute)intResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSave() {
		return saveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsDirty() {
		return isDirtyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetTextSelection() {
		return setTextSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetTextSelection_Offset() {
		return (EAttribute)setTextSelectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetTextSelection_Length() {
		return (EAttribute)setTextSelectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetTextSelection_StartLine() {
		return (EAttribute)setTextSelectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetTextSelection_Endline() {
		return (EAttribute)setTextSelectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetTextSelection_Endoffset() {
		return (EAttribute)setTextSelectionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetTextOffset() {
		return setTextOffsetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetTextOffset_Offset() {
		return (EAttribute)setTextOffsetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetTextOffset_Line() {
		return (EAttribute)setTextOffsetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShowSelection() {
		return showSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetTextSelection() {
		return getTextSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoToTextLine() {
		return goToTextLineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGoToTextLine_Line() {
		return (EAttribute)goToTextLineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetTextLineOffset() {
		return getTextLineOffsetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetTextLineOffset_Line() {
		return (EAttribute)getTextLineOffsetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetTextLineLength() {
		return getTextLineLengthEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetTextLineLength_Line() {
		return (EAttribute)getTextLineLengthEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectTextLine() {
		return selectTextLineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectTextLine_Line() {
		return (EAttribute)selectTextLineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetCaretPosition() {
		return setCaretPositionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetCaretPosition_Offset() {
		return (EAttribute)setCaretPositionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetTextLine() {
		return getTextLineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetTextLine_Line() {
		return (EAttribute)getTextLineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetTextRange() {
		return getTextRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetTextRange_StartOffset() {
		return (EAttribute)getTextRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetTextRange_EndOffset() {
		return (EAttribute)getTextRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextSelectionResponse() {
		return textSelectionResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextSelectionResponse_X() {
		return (EAttribute)textSelectionResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextSelectionResponse_Y() {
		return (EAttribute)textSelectionResponseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextSelectionResponse_Text() {
		return (EAttribute)textSelectionResponseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetColor() {
		return getColorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetColor() {
		return setColorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetColor_Color() {
		return (EAttribute)setColorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetColorResponse() {
		return getColorResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetColorResponse_Color() {
		return (EAttribute)getColorResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeText() {
		return typeTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeText_State() {
		return (EAttribute)typeTextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeText_Text() {
		return (EAttribute)typeTextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeText_FromDisplay() {
		return (EAttribute)typeTextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildren() {
		return childrenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChildrenResponse() {
		return childrenResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChildrenResponse_Children() {
		return (EReference)childrenResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParent() {
		return parentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParentResponse() {
		return parentResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParentResponse_Parent() {
		return (EReference)parentResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_State() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Code() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_FromDisplay() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Character() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Meta() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Traverse() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Times() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeAction() {
		return typeActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeAction_ActionId() {
		return (EAttribute)typeActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCopyTextSelection() {
		return copyTextSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCutTextSelection() {
		return cutTextSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPasteTextSelection() {
		return pasteTextSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplaceTextSelection() {
		return replaceTextSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReplaceTextSelection_Text() {
		return (EAttribute)replaceTextSelectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckItem() {
		return checkItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckItem_Path() {
		return (EAttribute)checkItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckItem_Pattern() {
		return (EAttribute)checkItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckItem_Index() {
		return (EAttribute)checkItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckItem_State() {
		return (EAttribute)checkItemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpand() {
		return expandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloseWorkbench() {
		return closeWorkbenchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivateCellEditor() {
		return activateCellEditorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivateCellEditor_Path() {
		return (EAttribute)activateCellEditorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivateCellEditor_Pattern() {
		return (EAttribute)activateCellEditorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivateCellEditor_Index() {
		return (EAttribute)activateCellEditorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivateCellEditor_Column() {
		return (EAttribute)activateCellEditorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplyCellEditor() {
		return applyCellEditorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplyCellEditor_Deactivate() {
		return (EAttribute)applyCellEditorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplyCellEditor_Column() {
		return (EAttribute)applyCellEditorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCancelCellEditor() {
		return cancelCellEditorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeactivateCellEditor() {
		return deactivateCellEditorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetSWTDialogInfo() {
		return setSWTDialogInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetSWTDialogInfo_Kind() {
		return (EAttribute)setSWTDialogInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetSWTDialogInfo_Path() {
		return (EAttribute)setSWTDialogInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssert() {
		return assertEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssert_Element() {
		return (EReference)assertEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssert_Attribute() {
		return (EAttribute)assertEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssert_Value() {
		return (EAttribute)assertEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssert_Kind() {
		return (EAttribute)assertEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssert_Index() {
		return (EAttribute)assertEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssert_Category() {
		return (EAttribute)assertEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssert_ValueType() {
		return (EReference)assertEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssert_ImageData() {
		return (EReference)assertEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssert_ShowIndex() {
		return (EAttribute)assertEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetRegionText() {
		return getRegionTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetRegionText_X() {
		return (EAttribute)getRegionTextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetRegionText_Y() {
		return (EAttribute)getRegionTextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetRegionText_Sx() {
		return (EAttribute)getRegionTextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetRegionText_Sy() {
		return (EAttribute)getRegionTextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetRegionText_Width() {
		return (EAttribute)getRegionTextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetRegionText_Height() {
		return (EAttribute)getRegionTextEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssertImageData() {
		return assertImageDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertImageData_Image() {
		return (EAttribute)assertImageDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertImageData_X() {
		return (EAttribute)assertImageDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertImageData_Y() {
		return (EAttribute)assertImageDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertImageData_Sx() {
		return (EAttribute)assertImageDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertImageData_Sy() {
		return (EAttribute)assertImageDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertImageData_Width() {
		return (EAttribute)assertImageDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertImageData_Height() {
		return (EAttribute)assertImageDataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssertResponse() {
		return assertResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetSelection() {
		return getSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectionResponse() {
		return selectionResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectionResponse_Values() {
		return (EReference)selectionResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectionItem() {
		return selectionItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectionItem_Text() {
		return (EAttribute)selectionItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDragCommand() {
		return dragCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDragCommand_Kind() {
		return (EAttribute)dragCommandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDragCommand_X() {
		return (EAttribute)dragCommandEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDragCommand_Y() {
		return (EAttribute)dragCommandEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDragCommand_Style() {
		return (EAttribute)dragCommandEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWaitForRestart() {
		return waitForRestartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCellClick() {
		return cellClickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCellClick_Column() {
		return (EAttribute)cellClickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShowContentAssist() {
		return showContentAssistEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClickAboutMenu() {
		return clickAboutMenuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClickPreferencesMenu() {
		return clickPreferencesMenuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecordingModeRequest() {
		return recordingModeRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssertionModeRequest() {
		return assertionModeRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMinimize() {
		return minimizeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMaximize() {
		return maximizeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRestore() {
		return restoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShowTabList() {
		return showTabListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetStatusDialogMode() {
		return setStatusDialogModeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetStatusDialogMode_Enabled() {
		return (EAttribute)setStatusDialogModeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheck() {
		return checkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheck_State() {
		return (EAttribute)checkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHoverAtTextOffset() {
		return hoverAtTextOffsetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHoverAtTextOffset_Offset() {
		return (EAttribute)hoverAtTextOffsetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHoverAtTextOffset_Line() {
		return (EAttribute)hoverAtTextOffsetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetCursorOffset() {
		return setCursorOffsetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetCursorOffset_Line() {
		return (EAttribute)setCursorOffsetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetCursorOffset_Offset() {
		return (EAttribute)setCursorOffsetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetTextSelection2() {
		return setTextSelection2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetTextSelection2_StartLine() {
		return (EAttribute)setTextSelection2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetTextSelection2_StartOffset() {
		return (EAttribute)setTextSelection2EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetTextSelection2_EndLine() {
		return (EAttribute)setTextSelection2EClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetTextSelection2_EndOffset() {
		return (EAttribute)setTextSelection2EClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetTextSelection2_BlockMode() {
		return (EAttribute)setTextSelection2EClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHoverAtText() {
		return hoverAtTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHoverAtText_Line() {
		return (EAttribute)hoverAtTextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHoverAtText_Offset() {
		return (EAttribute)hoverAtTextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHoverAtText_StateMask() {
		return (EAttribute)hoverAtTextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenDeclaration() {
		return openDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRulerClick() {
		return rulerClickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRulerClick_Line() {
		return (EAttribute)rulerClickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRulerClick_Button() {
		return (EAttribute)rulerClickEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRulerClick_StateMask() {
		return (EAttribute)rulerClickEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRulerDoubleClick() {
		return rulerDoubleClickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRulerDoubleClick_Line() {
		return (EAttribute)rulerDoubleClickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRulerDoubleClick_Button() {
		return (EAttribute)rulerDoubleClickEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRulerDoubleClick_StateMask() {
		return (EAttribute)rulerDoubleClickEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRulerHover() {
		return rulerHoverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRulerHover_Line() {
		return (EAttribute)rulerHoverEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRulerHover_StateMask() {
		return (EAttribute)rulerHoverEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClickLink() {
		return clickLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClickLink_Ref() {
		return (EAttribute)clickLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetFocus() {
		return setFocusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetFocus_Value() {
		return (EAttribute)setFocusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetPropertyValue() {
		return getPropertyValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetPropertyValue_Name() {
		return (EAttribute)getPropertyValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetPropertyValue_Index() {
		return (EAttribute)getPropertyValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGetPropertyValue_AllowRawValues() {
		return (EAttribute)getPropertyValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectResponse() {
		return objectResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectResponse_Result() {
		return (EAttribute)objectResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetBounds() {
		return getBoundsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundsResponse() {
		return boundsResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundsResponse_X() {
		return (EAttribute)boundsResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundsResponse_Y() {
		return (EAttribute)boundsResponseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundsResponse_Width() {
		return (EAttribute)boundsResponseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoundsResponse_Height() {
		return (EAttribute)boundsResponseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollapse() {
		return collapseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClickColumn() {
		return clickColumnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClickColumn_Name() {
		return (EAttribute)clickColumnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClickColumn_Index() {
		return (EAttribute)clickColumnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetSortColumn() {
		return setSortColumnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetSortColumn_Name() {
		return (EAttribute)setSortColumnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetSortColumn_Index() {
		return (EAttribute)setSortColumnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetSortColumn_Descending() {
		return (EAttribute)setSortColumnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMouseEvent() {
		return mouseEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseEvent_Kind() {
		return (EAttribute)mouseEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseEvent_Button() {
		return (EAttribute)mouseEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseEvent_StateMask() {
		return (EAttribute)mouseEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseEvent_Count() {
		return (EAttribute)mouseEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseEvent_X() {
		return (EAttribute)mouseEventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMouseEvent_Y() {
		return (EAttribute)mouseEventEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClickText() {
		return clickTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClickText_Start() {
		return (EAttribute)clickTextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClickText_End() {
		return (EAttribute)clickTextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClickText_Button() {
		return (EAttribute)clickTextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleClickText() {
		return doubleClickTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleClickText_Position() {
		return (EAttribute)doubleClickTextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleClickText_Button() {
		return (EAttribute)doubleClickTextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetWidth() {
		return setWidthEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetWidth_Width() {
		return (EAttribute)setWidthEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetPosition() {
		return setPositionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetPosition_Index() {
		return (EAttribute)setPositionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateControlCommand() {
		return updateControlCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUpdateControlCommand_Elements() {
		return (EReference)updateControlCommandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSWTDialogKind() {
		return swtDialogKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAssertKind() {
		return assertKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDragKind() {
		return dragKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMouseEventKind() {
		return mouseEventKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtocolFactory getProtocolFactory() {
		return (ProtocolFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		selectDataEClass = createEClass(SELECT_DATA);
		createEAttribute(selectDataEClass, SELECT_DATA__KIND);
		createEAttribute(selectDataEClass, SELECT_DATA__PATTERN);
		createEAttribute(selectDataEClass, SELECT_DATA__PATH);
		createEAttribute(selectDataEClass, SELECT_DATA__INDEX);
		createEAttribute(selectDataEClass, SELECT_DATA__MULTIPLICITY);
		createEReference(selectDataEClass, SELECT_DATA__AFTER);
		createEReference(selectDataEClass, SELECT_DATA__PARENT);
		createEAttribute(selectDataEClass, SELECT_DATA__CLASS_PATTERN);
		createEAttribute(selectDataEClass, SELECT_DATA__INDEXES);

		imlSelectDataEClass = createEClass(IML_SELECT_DATA);
		createEAttribute(imlSelectDataEClass, IML_SELECT_DATA__IMAGE);

		selectCommandEClass = createEClass(SELECT_COMMAND);
		createEReference(selectCommandEClass, SELECT_COMMAND__DATA);
		createEReference(selectCommandEClass, SELECT_COMMAND__CONTAIN_CHILDREN);

		selectResponseEClass = createEClass(SELECT_RESPONSE);
		createEReference(selectResponseEClass, SELECT_RESPONSE__ELEMENTS);

		elementCommandEClass = createEClass(ELEMENT_COMMAND);
		createEReference(elementCommandEClass, ELEMENT_COMMAND__ELEMENT);

		clickEClass = createEClass(CLICK);
		createEAttribute(clickEClass, CLICK__DEFAULT);
		createEAttribute(clickEClass, CLICK__WITH_WAIT);
		createEAttribute(clickEClass, CLICK__ARROW);

		doubleClickEClass = createEClass(DOUBLE_CLICK);
		createEAttribute(doubleClickEClass, DOUBLE_CLICK__WITH_WAIT);

		showEClass = createEClass(SHOW);

		hideEClass = createEClass(HIDE);

		closeEClass = createEClass(CLOSE);

		getTextEClass = createEClass(GET_TEXT);

		getTextResponseEClass = createEClass(GET_TEXT_RESPONSE);
		createEAttribute(getTextResponseEClass, GET_TEXT_RESPONSE__TEXT);

		booleanResponseEClass = createEClass(BOOLEAN_RESPONSE);
		createEAttribute(booleanResponseEClass, BOOLEAN_RESPONSE__RESULT);

		isEnabledEClass = createEClass(IS_ENABLED);

		isDisposedEClass = createEClass(IS_DISPOSED);

		setTextEClass = createEClass(SET_TEXT);
		createEAttribute(setTextEClass, SET_TEXT__VALUE);
		createEAttribute(setTextEClass, SET_TEXT__SELECT);
		createEAttribute(setTextEClass, SET_TEXT__HIDDEN);

		getStateEClass = createEClass(GET_STATE);

		getStateResponseEClass = createEClass(GET_STATE_RESPONSE);
		createEReference(getStateResponseEClass, GET_STATE_RESPONSE__STATE);

		waitForStateEClass = createEClass(WAIT_FOR_STATE);
		createEReference(waitForStateEClass, WAIT_FOR_STATE__STATE);

		rollbackToStateEClass = createEClass(ROLLBACK_TO_STATE);
		createEReference(rollbackToStateEClass, ROLLBACK_TO_STATE__STATE);

		setSelectionEClass = createEClass(SET_SELECTION);
		createEAttribute(setSelectionEClass, SET_SELECTION__PATH);
		createEAttribute(setSelectionEClass, SET_SELECTION__PATTERN);
		createEAttribute(setSelectionEClass, SET_SELECTION__INDEX);
		createEReference(setSelectionEClass, SET_SELECTION__ADDITIONAL_ITEMS);
		createEAttribute(setSelectionEClass, SET_SELECTION__ALL);

		multiSelectionItemEClass = createEClass(MULTI_SELECTION_ITEM);
		createEAttribute(multiSelectionItemEClass, MULTI_SELECTION_ITEM__PATH);
		createEAttribute(multiSelectionItemEClass, MULTI_SELECTION_ITEM__PATTERN);
		createEAttribute(multiSelectionItemEClass, MULTI_SELECTION_ITEM__INDEX);

		shutdownEClass = createEClass(SHUTDOWN);

		nopEClass = createEClass(NOP);

		countItemsEClass = createEClass(COUNT_ITEMS);
		createEAttribute(countItemsEClass, COUNT_ITEMS__PATH);

		intResponseEClass = createEClass(INT_RESPONSE);
		createEAttribute(intResponseEClass, INT_RESPONSE__RESULT);

		saveEClass = createEClass(SAVE);

		isDirtyEClass = createEClass(IS_DIRTY);

		setTextSelectionEClass = createEClass(SET_TEXT_SELECTION);
		createEAttribute(setTextSelectionEClass, SET_TEXT_SELECTION__OFFSET);
		createEAttribute(setTextSelectionEClass, SET_TEXT_SELECTION__LENGTH);
		createEAttribute(setTextSelectionEClass, SET_TEXT_SELECTION__START_LINE);
		createEAttribute(setTextSelectionEClass, SET_TEXT_SELECTION__ENDLINE);
		createEAttribute(setTextSelectionEClass, SET_TEXT_SELECTION__ENDOFFSET);

		setTextOffsetEClass = createEClass(SET_TEXT_OFFSET);
		createEAttribute(setTextOffsetEClass, SET_TEXT_OFFSET__OFFSET);
		createEAttribute(setTextOffsetEClass, SET_TEXT_OFFSET__LINE);

		showSelectionEClass = createEClass(SHOW_SELECTION);

		getTextSelectionEClass = createEClass(GET_TEXT_SELECTION);

		goToTextLineEClass = createEClass(GO_TO_TEXT_LINE);
		createEAttribute(goToTextLineEClass, GO_TO_TEXT_LINE__LINE);

		getTextLineOffsetEClass = createEClass(GET_TEXT_LINE_OFFSET);
		createEAttribute(getTextLineOffsetEClass, GET_TEXT_LINE_OFFSET__LINE);

		getTextLineLengthEClass = createEClass(GET_TEXT_LINE_LENGTH);
		createEAttribute(getTextLineLengthEClass, GET_TEXT_LINE_LENGTH__LINE);

		selectTextLineEClass = createEClass(SELECT_TEXT_LINE);
		createEAttribute(selectTextLineEClass, SELECT_TEXT_LINE__LINE);

		setCaretPositionEClass = createEClass(SET_CARET_POSITION);
		createEAttribute(setCaretPositionEClass, SET_CARET_POSITION__OFFSET);

		getTextLineEClass = createEClass(GET_TEXT_LINE);
		createEAttribute(getTextLineEClass, GET_TEXT_LINE__LINE);

		getTextRangeEClass = createEClass(GET_TEXT_RANGE);
		createEAttribute(getTextRangeEClass, GET_TEXT_RANGE__START_OFFSET);
		createEAttribute(getTextRangeEClass, GET_TEXT_RANGE__END_OFFSET);

		textSelectionResponseEClass = createEClass(TEXT_SELECTION_RESPONSE);
		createEAttribute(textSelectionResponseEClass, TEXT_SELECTION_RESPONSE__X);
		createEAttribute(textSelectionResponseEClass, TEXT_SELECTION_RESPONSE__Y);
		createEAttribute(textSelectionResponseEClass, TEXT_SELECTION_RESPONSE__TEXT);

		getColorEClass = createEClass(GET_COLOR);

		setColorEClass = createEClass(SET_COLOR);
		createEAttribute(setColorEClass, SET_COLOR__COLOR);

		getColorResponseEClass = createEClass(GET_COLOR_RESPONSE);
		createEAttribute(getColorResponseEClass, GET_COLOR_RESPONSE__COLOR);

		typeTextEClass = createEClass(TYPE_TEXT);
		createEAttribute(typeTextEClass, TYPE_TEXT__STATE);
		createEAttribute(typeTextEClass, TYPE_TEXT__TEXT);
		createEAttribute(typeTextEClass, TYPE_TEXT__FROM_DISPLAY);

		childrenEClass = createEClass(CHILDREN);

		childrenResponseEClass = createEClass(CHILDREN_RESPONSE);
		createEReference(childrenResponseEClass, CHILDREN_RESPONSE__CHILDREN);

		parentEClass = createEClass(PARENT);

		parentResponseEClass = createEClass(PARENT_RESPONSE);
		createEReference(parentResponseEClass, PARENT_RESPONSE__PARENT);

		typeEClass = createEClass(TYPE);
		createEAttribute(typeEClass, TYPE__STATE);
		createEAttribute(typeEClass, TYPE__CODE);
		createEAttribute(typeEClass, TYPE__FROM_DISPLAY);
		createEAttribute(typeEClass, TYPE__CHARACTER);
		createEAttribute(typeEClass, TYPE__META);
		createEAttribute(typeEClass, TYPE__TRAVERSE);
		createEAttribute(typeEClass, TYPE__TIMES);

		typeActionEClass = createEClass(TYPE_ACTION);
		createEAttribute(typeActionEClass, TYPE_ACTION__ACTION_ID);

		copyTextSelectionEClass = createEClass(COPY_TEXT_SELECTION);

		cutTextSelectionEClass = createEClass(CUT_TEXT_SELECTION);

		pasteTextSelectionEClass = createEClass(PASTE_TEXT_SELECTION);

		replaceTextSelectionEClass = createEClass(REPLACE_TEXT_SELECTION);
		createEAttribute(replaceTextSelectionEClass, REPLACE_TEXT_SELECTION__TEXT);

		checkItemEClass = createEClass(CHECK_ITEM);
		createEAttribute(checkItemEClass, CHECK_ITEM__PATH);
		createEAttribute(checkItemEClass, CHECK_ITEM__PATTERN);
		createEAttribute(checkItemEClass, CHECK_ITEM__INDEX);
		createEAttribute(checkItemEClass, CHECK_ITEM__STATE);

		expandEClass = createEClass(EXPAND);

		closeWorkbenchEClass = createEClass(CLOSE_WORKBENCH);

		activateCellEditorEClass = createEClass(ACTIVATE_CELL_EDITOR);
		createEAttribute(activateCellEditorEClass, ACTIVATE_CELL_EDITOR__PATH);
		createEAttribute(activateCellEditorEClass, ACTIVATE_CELL_EDITOR__PATTERN);
		createEAttribute(activateCellEditorEClass, ACTIVATE_CELL_EDITOR__INDEX);
		createEAttribute(activateCellEditorEClass, ACTIVATE_CELL_EDITOR__COLUMN);

		applyCellEditorEClass = createEClass(APPLY_CELL_EDITOR);
		createEAttribute(applyCellEditorEClass, APPLY_CELL_EDITOR__DEACTIVATE);
		createEAttribute(applyCellEditorEClass, APPLY_CELL_EDITOR__COLUMN);

		cancelCellEditorEClass = createEClass(CANCEL_CELL_EDITOR);

		deactivateCellEditorEClass = createEClass(DEACTIVATE_CELL_EDITOR);

		setSWTDialogInfoEClass = createEClass(SET_SWT_DIALOG_INFO);
		createEAttribute(setSWTDialogInfoEClass, SET_SWT_DIALOG_INFO__KIND);
		createEAttribute(setSWTDialogInfoEClass, SET_SWT_DIALOG_INFO__PATH);

		assertEClass = createEClass(ASSERT);
		createEReference(assertEClass, ASSERT__ELEMENT);
		createEAttribute(assertEClass, ASSERT__ATTRIBUTE);
		createEAttribute(assertEClass, ASSERT__VALUE);
		createEAttribute(assertEClass, ASSERT__KIND);
		createEAttribute(assertEClass, ASSERT__INDEX);
		createEAttribute(assertEClass, ASSERT__CATEGORY);
		createEReference(assertEClass, ASSERT__VALUE_TYPE);
		createEReference(assertEClass, ASSERT__IMAGE_DATA);
		createEAttribute(assertEClass, ASSERT__SHOW_INDEX);

		getRegionTextEClass = createEClass(GET_REGION_TEXT);
		createEAttribute(getRegionTextEClass, GET_REGION_TEXT__X);
		createEAttribute(getRegionTextEClass, GET_REGION_TEXT__Y);
		createEAttribute(getRegionTextEClass, GET_REGION_TEXT__SX);
		createEAttribute(getRegionTextEClass, GET_REGION_TEXT__SY);
		createEAttribute(getRegionTextEClass, GET_REGION_TEXT__WIDTH);
		createEAttribute(getRegionTextEClass, GET_REGION_TEXT__HEIGHT);

		assertImageDataEClass = createEClass(ASSERT_IMAGE_DATA);
		createEAttribute(assertImageDataEClass, ASSERT_IMAGE_DATA__IMAGE);
		createEAttribute(assertImageDataEClass, ASSERT_IMAGE_DATA__X);
		createEAttribute(assertImageDataEClass, ASSERT_IMAGE_DATA__Y);
		createEAttribute(assertImageDataEClass, ASSERT_IMAGE_DATA__SX);
		createEAttribute(assertImageDataEClass, ASSERT_IMAGE_DATA__SY);
		createEAttribute(assertImageDataEClass, ASSERT_IMAGE_DATA__WIDTH);
		createEAttribute(assertImageDataEClass, ASSERT_IMAGE_DATA__HEIGHT);

		assertResponseEClass = createEClass(ASSERT_RESPONSE);

		getSelectionEClass = createEClass(GET_SELECTION);

		selectionResponseEClass = createEClass(SELECTION_RESPONSE);
		createEReference(selectionResponseEClass, SELECTION_RESPONSE__VALUES);

		selectionItemEClass = createEClass(SELECTION_ITEM);
		createEAttribute(selectionItemEClass, SELECTION_ITEM__TEXT);

		dragCommandEClass = createEClass(DRAG_COMMAND);
		createEAttribute(dragCommandEClass, DRAG_COMMAND__KIND);
		createEAttribute(dragCommandEClass, DRAG_COMMAND__X);
		createEAttribute(dragCommandEClass, DRAG_COMMAND__Y);
		createEAttribute(dragCommandEClass, DRAG_COMMAND__STYLE);

		waitForRestartEClass = createEClass(WAIT_FOR_RESTART);

		cellClickEClass = createEClass(CELL_CLICK);
		createEAttribute(cellClickEClass, CELL_CLICK__COLUMN);

		showContentAssistEClass = createEClass(SHOW_CONTENT_ASSIST);

		clickAboutMenuEClass = createEClass(CLICK_ABOUT_MENU);

		clickPreferencesMenuEClass = createEClass(CLICK_PREFERENCES_MENU);

		recordingModeRequestEClass = createEClass(RECORDING_MODE_REQUEST);

		assertionModeRequestEClass = createEClass(ASSERTION_MODE_REQUEST);

		minimizeEClass = createEClass(MINIMIZE);

		maximizeEClass = createEClass(MAXIMIZE);

		restoreEClass = createEClass(RESTORE);

		showTabListEClass = createEClass(SHOW_TAB_LIST);

		setStatusDialogModeEClass = createEClass(SET_STATUS_DIALOG_MODE);
		createEAttribute(setStatusDialogModeEClass, SET_STATUS_DIALOG_MODE__ENABLED);

		checkEClass = createEClass(CHECK);
		createEAttribute(checkEClass, CHECK__STATE);

		hoverAtTextOffsetEClass = createEClass(HOVER_AT_TEXT_OFFSET);
		createEAttribute(hoverAtTextOffsetEClass, HOVER_AT_TEXT_OFFSET__OFFSET);
		createEAttribute(hoverAtTextOffsetEClass, HOVER_AT_TEXT_OFFSET__LINE);

		setCursorOffsetEClass = createEClass(SET_CURSOR_OFFSET);
		createEAttribute(setCursorOffsetEClass, SET_CURSOR_OFFSET__LINE);
		createEAttribute(setCursorOffsetEClass, SET_CURSOR_OFFSET__OFFSET);

		setTextSelection2EClass = createEClass(SET_TEXT_SELECTION2);
		createEAttribute(setTextSelection2EClass, SET_TEXT_SELECTION2__START_LINE);
		createEAttribute(setTextSelection2EClass, SET_TEXT_SELECTION2__START_OFFSET);
		createEAttribute(setTextSelection2EClass, SET_TEXT_SELECTION2__END_LINE);
		createEAttribute(setTextSelection2EClass, SET_TEXT_SELECTION2__END_OFFSET);
		createEAttribute(setTextSelection2EClass, SET_TEXT_SELECTION2__BLOCK_MODE);

		hoverAtTextEClass = createEClass(HOVER_AT_TEXT);
		createEAttribute(hoverAtTextEClass, HOVER_AT_TEXT__LINE);
		createEAttribute(hoverAtTextEClass, HOVER_AT_TEXT__OFFSET);
		createEAttribute(hoverAtTextEClass, HOVER_AT_TEXT__STATE_MASK);

		openDeclarationEClass = createEClass(OPEN_DECLARATION);

		rulerClickEClass = createEClass(RULER_CLICK);
		createEAttribute(rulerClickEClass, RULER_CLICK__LINE);
		createEAttribute(rulerClickEClass, RULER_CLICK__BUTTON);
		createEAttribute(rulerClickEClass, RULER_CLICK__STATE_MASK);

		rulerDoubleClickEClass = createEClass(RULER_DOUBLE_CLICK);
		createEAttribute(rulerDoubleClickEClass, RULER_DOUBLE_CLICK__LINE);
		createEAttribute(rulerDoubleClickEClass, RULER_DOUBLE_CLICK__BUTTON);
		createEAttribute(rulerDoubleClickEClass, RULER_DOUBLE_CLICK__STATE_MASK);

		rulerHoverEClass = createEClass(RULER_HOVER);
		createEAttribute(rulerHoverEClass, RULER_HOVER__LINE);
		createEAttribute(rulerHoverEClass, RULER_HOVER__STATE_MASK);

		clickLinkEClass = createEClass(CLICK_LINK);
		createEAttribute(clickLinkEClass, CLICK_LINK__REF);

		setFocusEClass = createEClass(SET_FOCUS);
		createEAttribute(setFocusEClass, SET_FOCUS__VALUE);

		getPropertyValueEClass = createEClass(GET_PROPERTY_VALUE);
		createEAttribute(getPropertyValueEClass, GET_PROPERTY_VALUE__NAME);
		createEAttribute(getPropertyValueEClass, GET_PROPERTY_VALUE__INDEX);
		createEAttribute(getPropertyValueEClass, GET_PROPERTY_VALUE__ALLOW_RAW_VALUES);

		objectResponseEClass = createEClass(OBJECT_RESPONSE);
		createEAttribute(objectResponseEClass, OBJECT_RESPONSE__RESULT);

		getBoundsEClass = createEClass(GET_BOUNDS);

		boundsResponseEClass = createEClass(BOUNDS_RESPONSE);
		createEAttribute(boundsResponseEClass, BOUNDS_RESPONSE__X);
		createEAttribute(boundsResponseEClass, BOUNDS_RESPONSE__Y);
		createEAttribute(boundsResponseEClass, BOUNDS_RESPONSE__WIDTH);
		createEAttribute(boundsResponseEClass, BOUNDS_RESPONSE__HEIGHT);

		collapseEClass = createEClass(COLLAPSE);

		clickColumnEClass = createEClass(CLICK_COLUMN);
		createEAttribute(clickColumnEClass, CLICK_COLUMN__NAME);
		createEAttribute(clickColumnEClass, CLICK_COLUMN__INDEX);

		setSortColumnEClass = createEClass(SET_SORT_COLUMN);
		createEAttribute(setSortColumnEClass, SET_SORT_COLUMN__NAME);
		createEAttribute(setSortColumnEClass, SET_SORT_COLUMN__INDEX);
		createEAttribute(setSortColumnEClass, SET_SORT_COLUMN__DESCENDING);

		mouseEventEClass = createEClass(MOUSE_EVENT);
		createEAttribute(mouseEventEClass, MOUSE_EVENT__KIND);
		createEAttribute(mouseEventEClass, MOUSE_EVENT__BUTTON);
		createEAttribute(mouseEventEClass, MOUSE_EVENT__STATE_MASK);
		createEAttribute(mouseEventEClass, MOUSE_EVENT__COUNT);
		createEAttribute(mouseEventEClass, MOUSE_EVENT__X);
		createEAttribute(mouseEventEClass, MOUSE_EVENT__Y);

		clickTextEClass = createEClass(CLICK_TEXT);
		createEAttribute(clickTextEClass, CLICK_TEXT__START);
		createEAttribute(clickTextEClass, CLICK_TEXT__END);
		createEAttribute(clickTextEClass, CLICK_TEXT__BUTTON);

		doubleClickTextEClass = createEClass(DOUBLE_CLICK_TEXT);
		createEAttribute(doubleClickTextEClass, DOUBLE_CLICK_TEXT__POSITION);
		createEAttribute(doubleClickTextEClass, DOUBLE_CLICK_TEXT__BUTTON);

		setWidthEClass = createEClass(SET_WIDTH);
		createEAttribute(setWidthEClass, SET_WIDTH__WIDTH);

		setPositionEClass = createEClass(SET_POSITION);
		createEAttribute(setPositionEClass, SET_POSITION__INDEX);

		updateControlCommandEClass = createEClass(UPDATE_CONTROL_COMMAND);
		createEReference(updateControlCommandEClass, UPDATE_CONTROL_COMMAND__ELEMENTS);

		// Create enums
		swtDialogKindEEnum = createEEnum(SWT_DIALOG_KIND);
		assertKindEEnum = createEEnum(ASSERT_KIND);
		dragKindEEnum = createEEnum(DRAG_KIND);
		mouseEventKindEEnum = createEEnum(MOUSE_EVENT_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		RawPackage theRawPackage = (RawPackage)EPackage.Registry.INSTANCE.getEPackage(RawPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		imlSelectDataEClass.getESuperTypes().add(this.getSelectData());
		selectCommandEClass.getESuperTypes().add(theRawPackage.getCommand());
		selectResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		elementCommandEClass.getESuperTypes().add(theRawPackage.getCommand());
		clickEClass.getESuperTypes().add(this.getElementCommand());
		doubleClickEClass.getESuperTypes().add(this.getElementCommand());
		showEClass.getESuperTypes().add(this.getElementCommand());
		hideEClass.getESuperTypes().add(this.getElementCommand());
		closeEClass.getESuperTypes().add(this.getElementCommand());
		getTextEClass.getESuperTypes().add(this.getElementCommand());
		getTextResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		booleanResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		isEnabledEClass.getESuperTypes().add(this.getElementCommand());
		isDisposedEClass.getESuperTypes().add(this.getElementCommand());
		setTextEClass.getESuperTypes().add(this.getElementCommand());
		getStateEClass.getESuperTypes().add(theRawPackage.getCommand());
		getStateResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		waitForStateEClass.getESuperTypes().add(theRawPackage.getCommand());
		rollbackToStateEClass.getESuperTypes().add(theRawPackage.getCommand());
		setSelectionEClass.getESuperTypes().add(this.getElementCommand());
		shutdownEClass.getESuperTypes().add(theRawPackage.getCommand());
		nopEClass.getESuperTypes().add(theRawPackage.getCommand());
		countItemsEClass.getESuperTypes().add(this.getElementCommand());
		intResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		saveEClass.getESuperTypes().add(this.getElementCommand());
		isDirtyEClass.getESuperTypes().add(this.getElementCommand());
		setTextSelectionEClass.getESuperTypes().add(this.getElementCommand());
		setTextOffsetEClass.getESuperTypes().add(this.getElementCommand());
		showSelectionEClass.getESuperTypes().add(this.getElementCommand());
		getTextSelectionEClass.getESuperTypes().add(this.getElementCommand());
		goToTextLineEClass.getESuperTypes().add(this.getElementCommand());
		getTextLineOffsetEClass.getESuperTypes().add(this.getElementCommand());
		getTextLineLengthEClass.getESuperTypes().add(this.getElementCommand());
		selectTextLineEClass.getESuperTypes().add(this.getElementCommand());
		setCaretPositionEClass.getESuperTypes().add(this.getElementCommand());
		getTextLineEClass.getESuperTypes().add(this.getElementCommand());
		getTextRangeEClass.getESuperTypes().add(this.getElementCommand());
		textSelectionResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		getColorEClass.getESuperTypes().add(this.getElementCommand());
		setColorEClass.getESuperTypes().add(this.getElementCommand());
		getColorResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		typeTextEClass.getESuperTypes().add(this.getElementCommand());
		childrenEClass.getESuperTypes().add(this.getElementCommand());
		childrenResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		parentEClass.getESuperTypes().add(this.getElementCommand());
		parentResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		typeEClass.getESuperTypes().add(this.getElementCommand());
		typeActionEClass.getESuperTypes().add(this.getElementCommand());
		copyTextSelectionEClass.getESuperTypes().add(this.getElementCommand());
		cutTextSelectionEClass.getESuperTypes().add(this.getElementCommand());
		pasteTextSelectionEClass.getESuperTypes().add(this.getElementCommand());
		replaceTextSelectionEClass.getESuperTypes().add(this.getElementCommand());
		checkItemEClass.getESuperTypes().add(this.getElementCommand());
		expandEClass.getESuperTypes().add(this.getElementCommand());
		closeWorkbenchEClass.getESuperTypes().add(theRawPackage.getCommand());
		activateCellEditorEClass.getESuperTypes().add(this.getElementCommand());
		applyCellEditorEClass.getESuperTypes().add(this.getElementCommand());
		cancelCellEditorEClass.getESuperTypes().add(this.getElementCommand());
		deactivateCellEditorEClass.getESuperTypes().add(this.getElementCommand());
		setSWTDialogInfoEClass.getESuperTypes().add(theRawPackage.getCommand());
		assertEClass.getESuperTypes().add(theRawPackage.getCommand());
		getRegionTextEClass.getESuperTypes().add(this.getElementCommand());
		assertResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		getSelectionEClass.getESuperTypes().add(this.getElementCommand());
		selectionResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		dragCommandEClass.getESuperTypes().add(this.getElementCommand());
		waitForRestartEClass.getESuperTypes().add(theRawPackage.getCommand());
		cellClickEClass.getESuperTypes().add(this.getElementCommand());
		showContentAssistEClass.getESuperTypes().add(this.getElementCommand());
		clickAboutMenuEClass.getESuperTypes().add(this.getElementCommand());
		clickPreferencesMenuEClass.getESuperTypes().add(this.getElementCommand());
		recordingModeRequestEClass.getESuperTypes().add(theRawPackage.getCommand());
		assertionModeRequestEClass.getESuperTypes().add(theRawPackage.getCommand());
		minimizeEClass.getESuperTypes().add(this.getElementCommand());
		maximizeEClass.getESuperTypes().add(this.getElementCommand());
		restoreEClass.getESuperTypes().add(this.getElementCommand());
		showTabListEClass.getESuperTypes().add(this.getElementCommand());
		setStatusDialogModeEClass.getESuperTypes().add(theRawPackage.getCommand());
		checkEClass.getESuperTypes().add(this.getElementCommand());
		hoverAtTextOffsetEClass.getESuperTypes().add(this.getElementCommand());
		setCursorOffsetEClass.getESuperTypes().add(this.getElementCommand());
		setTextSelection2EClass.getESuperTypes().add(this.getElementCommand());
		hoverAtTextEClass.getESuperTypes().add(this.getElementCommand());
		openDeclarationEClass.getESuperTypes().add(this.getElementCommand());
		rulerClickEClass.getESuperTypes().add(this.getElementCommand());
		rulerDoubleClickEClass.getESuperTypes().add(this.getElementCommand());
		rulerHoverEClass.getESuperTypes().add(this.getElementCommand());
		clickLinkEClass.getESuperTypes().add(this.getElementCommand());
		setFocusEClass.getESuperTypes().add(this.getElementCommand());
		getPropertyValueEClass.getESuperTypes().add(this.getElementCommand());
		objectResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		getBoundsEClass.getESuperTypes().add(this.getElementCommand());
		boundsResponseEClass.getESuperTypes().add(theRawPackage.getResponse());
		collapseEClass.getESuperTypes().add(this.getElementCommand());
		clickColumnEClass.getESuperTypes().add(this.getElementCommand());
		setSortColumnEClass.getESuperTypes().add(this.getElementCommand());
		mouseEventEClass.getESuperTypes().add(this.getElementCommand());
		clickTextEClass.getESuperTypes().add(this.getElementCommand());
		doubleClickTextEClass.getESuperTypes().add(this.getElementCommand());
		setWidthEClass.getESuperTypes().add(this.getElementCommand());
		setPositionEClass.getESuperTypes().add(this.getElementCommand());
		updateControlCommandEClass.getESuperTypes().add(theRawPackage.getCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(selectDataEClass, SelectData.class, "SelectData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSelectData_Kind(), ecorePackage.getEString(), "kind", null, 0, 1, SelectData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectData_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, SelectData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectData_Path(), ecorePackage.getEString(), "path", null, 0, -1, SelectData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectData_Index(), ecorePackage.getEIntegerObject(), "index", null, 0, 1, SelectData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectData_Multiplicity(), ecorePackage.getEInt(), "multiplicity", null, 0, 1, SelectData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectData_After(), theRawPackage.getElement(), null, "after", null, 0, 1, SelectData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectData_Parent(), theRawPackage.getElement(), null, "parent", null, 0, 1, SelectData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectData_ClassPattern(), ecorePackage.getEString(), "classPattern", null, 0, 1, SelectData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectData_Indexes(), ecorePackage.getEInt(), "indexes", null, 0, -1, SelectData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imlSelectDataEClass, IMLSelectData.class, "IMLSelectData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIMLSelectData_Image(), ecorePackage.getEByteArray(), "image", null, 0, 1, IMLSelectData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectCommandEClass, SelectCommand.class, "SelectCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectCommand_Data(), this.getSelectData(), null, "data", null, 1, 1, SelectCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectCommand_ContainChildren(), this.getSelectData(), null, "containChildren", null, 0, -1, SelectCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectResponseEClass, SelectResponse.class, "SelectResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectResponse_Elements(), theRawPackage.getElement(), null, "elements", null, 0, -1, SelectResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementCommandEClass, ElementCommand.class, "ElementCommand", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementCommand_Element(), theRawPackage.getElement(), null, "element", null, 0, 1, ElementCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clickEClass, Click.class, "Click", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClick_Default(), ecorePackage.getEBoolean(), "default", "false", 0, 1, Click.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClick_WithWait(), ecorePackage.getEBoolean(), "withWait", "true", 0, 1, Click.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClick_Arrow(), ecorePackage.getEBoolean(), "arrow", "false", 0, 1, Click.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleClickEClass, DoubleClick.class, "DoubleClick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleClick_WithWait(), ecorePackage.getEBoolean(), "withWait", "true", 0, 1, DoubleClick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(showEClass, Show.class, "Show", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hideEClass, Hide.class, "Hide", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(closeEClass, Close.class, "Close", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getTextEClass, GetText.class, "GetText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getTextResponseEClass, GetTextResponse.class, "GetTextResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetTextResponse_Text(), ecorePackage.getEString(), "text", null, 0, 1, GetTextResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanResponseEClass, BooleanResponse.class, "BooleanResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanResponse_Result(), ecorePackage.getEBoolean(), "result", null, 0, 1, BooleanResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(isEnabledEClass, IsEnabled.class, "IsEnabled", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isDisposedEClass, IsDisposed.class, "IsDisposed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setTextEClass, SetText.class, "SetText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetText_Value(), ecorePackage.getEString(), "value", null, 0, 1, SetText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetText_Select(), ecorePackage.getEBoolean(), "select", "false", 0, 1, SetText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetText_Hidden(), theEcorePackage.getEBoolean(), "hidden", "false", 0, 1, SetText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getStateEClass, GetState.class, "GetState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getStateResponseEClass, GetStateResponse.class, "GetStateResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGetStateResponse_State(), theRawPackage.getElement(), null, "state", null, 0, 1, GetStateResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(waitForStateEClass, WaitForState.class, "WaitForState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWaitForState_State(), theRawPackage.getElement(), null, "state", null, 0, 1, WaitForState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rollbackToStateEClass, RollbackToState.class, "RollbackToState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRollbackToState_State(), theRawPackage.getElement(), null, "state", null, 0, 1, RollbackToState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setSelectionEClass, SetSelection.class, "SetSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetSelection_Path(), ecorePackage.getEString(), "path", null, 0, -1, SetSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetSelection_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, SetSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetSelection_Index(), ecorePackage.getEIntegerObject(), "index", null, 0, 1, SetSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetSelection_AdditionalItems(), this.getMultiSelectionItem(), null, "additionalItems", null, 0, -1, SetSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetSelection_All(), ecorePackage.getEBoolean(), "all", "false", 0, 1, SetSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiSelectionItemEClass, MultiSelectionItem.class, "MultiSelectionItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiSelectionItem_Path(), ecorePackage.getEString(), "path", null, 0, -1, MultiSelectionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiSelectionItem_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, MultiSelectionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiSelectionItem_Index(), ecorePackage.getEIntegerObject(), "index", null, 0, 1, MultiSelectionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(shutdownEClass, Shutdown.class, "Shutdown", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nopEClass, Nop.class, "Nop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(countItemsEClass, CountItems.class, "CountItems", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCountItems_Path(), ecorePackage.getEString(), "path", "", 0, -1, CountItems.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intResponseEClass, IntResponse.class, "IntResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntResponse_Result(), ecorePackage.getEInt(), "result", null, 0, 1, IntResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(saveEClass, Save.class, "Save", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isDirtyEClass, IsDirty.class, "IsDirty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setTextSelectionEClass, SetTextSelection.class, "SetTextSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetTextSelection_Offset(), ecorePackage.getEIntegerObject(), "offset", null, 0, 1, SetTextSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetTextSelection_Length(), ecorePackage.getEIntegerObject(), "length", null, 0, 1, SetTextSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetTextSelection_StartLine(), ecorePackage.getEIntegerObject(), "startLine", null, 0, 1, SetTextSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetTextSelection_Endline(), ecorePackage.getEIntegerObject(), "endline", null, 0, 1, SetTextSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetTextSelection_Endoffset(), ecorePackage.getEIntegerObject(), "endoffset", null, 0, 1, SetTextSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setTextOffsetEClass, SetTextOffset.class, "SetTextOffset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetTextOffset_Offset(), ecorePackage.getEInt(), "offset", null, 0, 1, SetTextOffset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetTextOffset_Line(), ecorePackage.getEInt(), "line", "-1", 0, 1, SetTextOffset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(showSelectionEClass, ShowSelection.class, "ShowSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getTextSelectionEClass, GetTextSelection.class, "GetTextSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(goToTextLineEClass, GoToTextLine.class, "GoToTextLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGoToTextLine_Line(), ecorePackage.getEIntegerObject(), "line", null, 0, 1, GoToTextLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getTextLineOffsetEClass, GetTextLineOffset.class, "GetTextLineOffset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetTextLineOffset_Line(), ecorePackage.getEIntegerObject(), "line", null, 0, 1, GetTextLineOffset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getTextLineLengthEClass, GetTextLineLength.class, "GetTextLineLength", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetTextLineLength_Line(), ecorePackage.getEIntegerObject(), "line", null, 0, 1, GetTextLineLength.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectTextLineEClass, SelectTextLine.class, "SelectTextLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSelectTextLine_Line(), ecorePackage.getEIntegerObject(), "line", null, 0, 1, SelectTextLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setCaretPositionEClass, SetCaretPosition.class, "SetCaretPosition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetCaretPosition_Offset(), ecorePackage.getEInt(), "offset", null, 0, 1, SetCaretPosition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getTextLineEClass, GetTextLine.class, "GetTextLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetTextLine_Line(), ecorePackage.getEIntegerObject(), "line", null, 0, 1, GetTextLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getTextRangeEClass, GetTextRange.class, "GetTextRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetTextRange_StartOffset(), ecorePackage.getEIntegerObject(), "startOffset", null, 0, 1, GetTextRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetTextRange_EndOffset(), ecorePackage.getEIntegerObject(), "endOffset", null, 0, 1, GetTextRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textSelectionResponseEClass, TextSelectionResponse.class, "TextSelectionResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTextSelectionResponse_X(), ecorePackage.getEIntegerObject(), "x", null, 0, 1, TextSelectionResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextSelectionResponse_Y(), ecorePackage.getEIntegerObject(), "y", null, 0, 1, TextSelectionResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextSelectionResponse_Text(), ecorePackage.getEString(), "text", null, 0, 1, TextSelectionResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getColorEClass, GetColor.class, "GetColor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setColorEClass, SetColor.class, "SetColor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetColor_Color(), ecorePackage.getEString(), "color", null, 0, 1, SetColor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getColorResponseEClass, GetColorResponse.class, "GetColorResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetColorResponse_Color(), ecorePackage.getEString(), "color", null, 0, 1, GetColorResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeTextEClass, TypeText.class, "TypeText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeText_State(), ecorePackage.getEIntegerObject(), "state", null, 0, 1, TypeText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeText_Text(), ecorePackage.getEString(), "text", null, 0, 1, TypeText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeText_FromDisplay(), ecorePackage.getEBoolean(), "fromDisplay", null, 0, 1, TypeText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(childrenEClass, Children.class, "Children", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(childrenResponseEClass, ChildrenResponse.class, "ChildrenResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChildrenResponse_Children(), theRawPackage.getElement(), null, "children", null, 0, -1, ChildrenResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parentEClass, Parent.class, "Parent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parentResponseEClass, ParentResponse.class, "ParentResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParentResponse_Parent(), theRawPackage.getElement(), null, "parent", null, 0, 1, ParentResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getType_State(), ecorePackage.getEIntegerObject(), "state", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getType_Code(), ecorePackage.getEIntegerObject(), "code", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getType_FromDisplay(), ecorePackage.getEBoolean(), "fromDisplay", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getType_Character(), ecorePackage.getEChar(), "character", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getType_Meta(), ecorePackage.getEIntegerObject(), "meta", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getType_Traverse(), ecorePackage.getEBoolean(), "traverse", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getType_Times(), ecorePackage.getEIntegerObject(), "times", "1", 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeActionEClass, TypeAction.class, "TypeAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeAction_ActionId(), ecorePackage.getEString(), "actionId", null, 0, 1, TypeAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(copyTextSelectionEClass, CopyTextSelection.class, "CopyTextSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cutTextSelectionEClass, CutTextSelection.class, "CutTextSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pasteTextSelectionEClass, PasteTextSelection.class, "PasteTextSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(replaceTextSelectionEClass, ReplaceTextSelection.class, "ReplaceTextSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReplaceTextSelection_Text(), ecorePackage.getEString(), "text", null, 0, 1, ReplaceTextSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(checkItemEClass, CheckItem.class, "CheckItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCheckItem_Path(), ecorePackage.getEString(), "path", null, 0, -1, CheckItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCheckItem_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, CheckItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCheckItem_Index(), ecorePackage.getEIntegerObject(), "index", null, 0, 1, CheckItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCheckItem_State(), ecorePackage.getEBoolean(), "state", null, 0, 1, CheckItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expandEClass, Expand.class, "Expand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(closeWorkbenchEClass, CloseWorkbench.class, "CloseWorkbench", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(activateCellEditorEClass, ActivateCellEditor.class, "ActivateCellEditor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActivateCellEditor_Path(), ecorePackage.getEString(), "path", null, 0, -1, ActivateCellEditor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivateCellEditor_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, ActivateCellEditor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivateCellEditor_Index(), ecorePackage.getEIntegerObject(), "index", null, 0, 1, ActivateCellEditor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivateCellEditor_Column(), ecorePackage.getEInt(), "column", null, 0, 1, ActivateCellEditor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(applyCellEditorEClass, ApplyCellEditor.class, "ApplyCellEditor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getApplyCellEditor_Deactivate(), theEcorePackage.getEBoolean(), "deactivate", "false", 0, 1, ApplyCellEditor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplyCellEditor_Column(), ecorePackage.getEInt(), "column", null, 0, 1, ApplyCellEditor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cancelCellEditorEClass, CancelCellEditor.class, "CancelCellEditor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deactivateCellEditorEClass, DeactivateCellEditor.class, "DeactivateCellEditor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setSWTDialogInfoEClass, SetSWTDialogInfo.class, "SetSWTDialogInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetSWTDialogInfo_Kind(), this.getSWTDialogKind(), "kind", null, 0, 1, SetSWTDialogInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetSWTDialogInfo_Path(), ecorePackage.getEString(), "path", null, 0, -1, SetSWTDialogInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assertEClass, Assert.class, "Assert", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssert_Element(), theRawPackage.getElement(), null, "element", null, 0, 1, Assert.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssert_Attribute(), ecorePackage.getEString(), "attribute", null, 0, 1, Assert.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssert_Value(), ecorePackage.getEString(), "value", null, 0, 1, Assert.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssert_Kind(), this.getAssertKind(), "kind", null, 0, 1, Assert.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssert_Index(), ecorePackage.getEIntegerObject(), "index", null, 0, 1, Assert.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssert_Category(), ecorePackage.getEString(), "category", null, 0, 1, Assert.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssert_ValueType(), theEcorePackage.getEClassifier(), null, "valueType", null, 0, 1, Assert.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssert_ImageData(), this.getAssertImageData(), null, "imageData", null, 0, 1, Assert.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssert_ShowIndex(), ecorePackage.getEBoolean(), "showIndex", "false", 0, 1, Assert.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getRegionTextEClass, GetRegionText.class, "GetRegionText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetRegionText_X(), ecorePackage.getEInt(), "x", null, 0, 1, GetRegionText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetRegionText_Y(), ecorePackage.getEInt(), "y", null, 0, 1, GetRegionText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetRegionText_Sx(), ecorePackage.getEInt(), "sx", null, 0, 1, GetRegionText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetRegionText_Sy(), ecorePackage.getEInt(), "sy", null, 0, 1, GetRegionText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetRegionText_Width(), ecorePackage.getEInt(), "width", null, 0, 1, GetRegionText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetRegionText_Height(), ecorePackage.getEInt(), "height", null, 0, 1, GetRegionText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assertImageDataEClass, AssertImageData.class, "AssertImageData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssertImageData_Image(), ecorePackage.getEByteArray(), "image", null, 0, 1, AssertImageData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertImageData_X(), ecorePackage.getEInt(), "x", null, 0, 1, AssertImageData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertImageData_Y(), ecorePackage.getEInt(), "y", null, 0, 1, AssertImageData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertImageData_Sx(), ecorePackage.getEInt(), "sx", null, 0, 1, AssertImageData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertImageData_Sy(), ecorePackage.getEInt(), "sy", null, 0, 1, AssertImageData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertImageData_Width(), ecorePackage.getEInt(), "width", null, 0, 1, AssertImageData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertImageData_Height(), ecorePackage.getEInt(), "height", null, 0, 1, AssertImageData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assertResponseEClass, AssertResponse.class, "AssertResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getSelectionEClass, GetSelection.class, "GetSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(selectionResponseEClass, SelectionResponse.class, "SelectionResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectionResponse_Values(), this.getSelectionItem(), null, "values", null, 0, -1, SelectionResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectionItemEClass, SelectionItem.class, "SelectionItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSelectionItem_Text(), ecorePackage.getEString(), "text", null, 0, -1, SelectionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dragCommandEClass, DragCommand.class, "DragCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDragCommand_Kind(), this.getDragKind(), "kind", null, 0, 1, DragCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDragCommand_X(), ecorePackage.getEIntegerObject(), "x", null, 0, 1, DragCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDragCommand_Y(), ecorePackage.getEIntegerObject(), "y", null, 0, 1, DragCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDragCommand_Style(), ecorePackage.getEString(), "style", null, 0, 1, DragCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(waitForRestartEClass, WaitForRestart.class, "WaitForRestart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cellClickEClass, CellClick.class, "CellClick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCellClick_Column(), ecorePackage.getEInt(), "column", null, 0, 1, CellClick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(showContentAssistEClass, ShowContentAssist.class, "ShowContentAssist", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(clickAboutMenuEClass, ClickAboutMenu.class, "ClickAboutMenu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(clickPreferencesMenuEClass, ClickPreferencesMenu.class, "ClickPreferencesMenu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(recordingModeRequestEClass, RecordingModeRequest.class, "RecordingModeRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assertionModeRequestEClass, AssertionModeRequest.class, "AssertionModeRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(minimizeEClass, Minimize.class, "Minimize", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(maximizeEClass, Maximize.class, "Maximize", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(restoreEClass, Restore.class, "Restore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(showTabListEClass, ShowTabList.class, "ShowTabList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setStatusDialogModeEClass, SetStatusDialogMode.class, "SetStatusDialogMode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetStatusDialogMode_Enabled(), theEcorePackage.getEBoolean(), "enabled", null, 0, 1, SetStatusDialogMode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(checkEClass, Check.class, "Check", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCheck_State(), ecorePackage.getEBoolean(), "state", "false", 0, 1, Check.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hoverAtTextOffsetEClass, HoverAtTextOffset.class, "HoverAtTextOffset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHoverAtTextOffset_Offset(), ecorePackage.getEInt(), "offset", null, 0, 1, HoverAtTextOffset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHoverAtTextOffset_Line(), ecorePackage.getEInt(), "line", "-1", 0, 1, HoverAtTextOffset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setCursorOffsetEClass, SetCursorOffset.class, "SetCursorOffset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetCursorOffset_Line(), ecorePackage.getEInt(), "line", "-1", 0, 1, SetCursorOffset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetCursorOffset_Offset(), ecorePackage.getEInt(), "offset", null, 0, 1, SetCursorOffset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setTextSelection2EClass, SetTextSelection2.class, "SetTextSelection2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetTextSelection2_StartLine(), theEcorePackage.getEInt(), "startLine", null, 0, 1, SetTextSelection2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetTextSelection2_StartOffset(), theEcorePackage.getEInt(), "startOffset", null, 0, 1, SetTextSelection2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetTextSelection2_EndLine(), theEcorePackage.getEInt(), "endLine", null, 0, 1, SetTextSelection2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetTextSelection2_EndOffset(), theEcorePackage.getEInt(), "endOffset", null, 0, 1, SetTextSelection2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetTextSelection2_BlockMode(), theEcorePackage.getEBoolean(), "blockMode", "false", 0, 1, SetTextSelection2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hoverAtTextEClass, HoverAtText.class, "HoverAtText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHoverAtText_Line(), ecorePackage.getEInt(), "line", "-1", 0, 1, HoverAtText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHoverAtText_Offset(), ecorePackage.getEInt(), "offset", null, 0, 1, HoverAtText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHoverAtText_StateMask(), ecorePackage.getEInt(), "stateMask", "0", 0, 1, HoverAtText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(openDeclarationEClass, OpenDeclaration.class, "OpenDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rulerClickEClass, RulerClick.class, "RulerClick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRulerClick_Line(), ecorePackage.getEInt(), "line", "-1", 0, 1, RulerClick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRulerClick_Button(), theEcorePackage.getEInt(), "button", null, 0, 1, RulerClick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRulerClick_StateMask(), ecorePackage.getEInt(), "stateMask", "0", 0, 1, RulerClick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rulerDoubleClickEClass, RulerDoubleClick.class, "RulerDoubleClick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRulerDoubleClick_Line(), ecorePackage.getEInt(), "line", "-1", 0, 1, RulerDoubleClick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRulerDoubleClick_Button(), theEcorePackage.getEInt(), "button", null, 0, 1, RulerDoubleClick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRulerDoubleClick_StateMask(), ecorePackage.getEInt(), "stateMask", "0", 0, 1, RulerDoubleClick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rulerHoverEClass, RulerHover.class, "RulerHover", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRulerHover_Line(), ecorePackage.getEInt(), "line", "-1", 0, 1, RulerHover.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRulerHover_StateMask(), ecorePackage.getEInt(), "stateMask", "0", 0, 1, RulerHover.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clickLinkEClass, ClickLink.class, "ClickLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClickLink_Ref(), theEcorePackage.getEString(), "ref", null, 0, 1, ClickLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setFocusEClass, SetFocus.class, "SetFocus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetFocus_Value(), theEcorePackage.getEBoolean(), "value", "true", 0, 1, SetFocus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getPropertyValueEClass, GetPropertyValue.class, "GetPropertyValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetPropertyValue_Name(), theEcorePackage.getEString(), "name", null, 0, 1, GetPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetPropertyValue_Index(), theEcorePackage.getEIntegerObject(), "index", null, 0, 1, GetPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetPropertyValue_AllowRawValues(), theEcorePackage.getEBooleanObject(), "allowRawValues", null, 0, 1, GetPropertyValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectResponseEClass, ObjectResponse.class, "ObjectResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObjectResponse_Result(), theEcorePackage.getEJavaObject(), "result", null, 0, 1, ObjectResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getBoundsEClass, GetBounds.class, "GetBounds", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(boundsResponseEClass, BoundsResponse.class, "BoundsResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBoundsResponse_X(), theEcorePackage.getEInt(), "x", null, 0, 1, BoundsResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoundsResponse_Y(), theEcorePackage.getEInt(), "y", null, 0, 1, BoundsResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoundsResponse_Width(), theEcorePackage.getEInt(), "width", null, 0, 1, BoundsResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoundsResponse_Height(), theEcorePackage.getEInt(), "height", null, 0, 1, BoundsResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collapseEClass, Collapse.class, "Collapse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(clickColumnEClass, ClickColumn.class, "ClickColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClickColumn_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ClickColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClickColumn_Index(), theEcorePackage.getEInt(), "index", "0", 0, 1, ClickColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setSortColumnEClass, SetSortColumn.class, "SetSortColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetSortColumn_Name(), theEcorePackage.getEString(), "name", null, 0, 1, SetSortColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetSortColumn_Index(), theEcorePackage.getEInt(), "index", null, 0, 1, SetSortColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetSortColumn_Descending(), theEcorePackage.getEBoolean(), "descending", "false", 0, 1, SetSortColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mouseEventEClass, MouseEvent.class, "MouseEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMouseEvent_Kind(), this.getMouseEventKind(), "kind", null, 0, 1, MouseEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMouseEvent_Button(), theEcorePackage.getEInt(), "button", null, 0, 1, MouseEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMouseEvent_StateMask(), theEcorePackage.getEInt(), "stateMask", null, 0, 1, MouseEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMouseEvent_Count(), theEcorePackage.getEInt(), "count", null, 0, 1, MouseEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMouseEvent_X(), theEcorePackage.getEInt(), "x", null, 0, 1, MouseEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMouseEvent_Y(), theEcorePackage.getEInt(), "y", null, 0, 1, MouseEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clickTextEClass, ClickText.class, "ClickText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClickText_Start(), theEcorePackage.getEString(), "start", "", 0, 1, ClickText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClickText_End(), theEcorePackage.getEString(), "end", "", 0, 1, ClickText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClickText_Button(), theEcorePackage.getEString(), "button", "left", 0, 1, ClickText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleClickTextEClass, DoubleClickText.class, "DoubleClickText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleClickText_Position(), theEcorePackage.getEString(), "position", "", 0, 1, DoubleClickText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDoubleClickText_Button(), theEcorePackage.getEString(), "button", "left", 0, 1, DoubleClickText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setWidthEClass, SetWidth.class, "SetWidth", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetWidth_Width(), theEcorePackage.getEInt(), "width", null, 1, 1, SetWidth.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setPositionEClass, SetPosition.class, "SetPosition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetPosition_Index(), theEcorePackage.getEInt(), "index", null, 1, 1, SetPosition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updateControlCommandEClass, UpdateControlCommand.class, "UpdateControlCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUpdateControlCommand_Elements(), theRawPackage.getElement(), null, "elements", null, 0, 1, UpdateControlCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(swtDialogKindEEnum, SWTDialogKind.class, "SWTDialogKind");
		addEEnumLiteral(swtDialogKindEEnum, SWTDialogKind.FILE_SELECTOR);
		addEEnumLiteral(swtDialogKindEEnum, SWTDialogKind.FOLDER_SELECTOR);
		addEEnumLiteral(swtDialogKindEEnum, SWTDialogKind.FONT_DIALOG);
		addEEnumLiteral(swtDialogKindEEnum, SWTDialogKind.MESSAGE_BOX);
		addEEnumLiteral(swtDialogKindEEnum, SWTDialogKind.COLOR);

		initEEnum(assertKindEEnum, AssertKind.class, "AssertKind");
		addEEnumLiteral(assertKindEEnum, AssertKind.EQUALS);
		addEEnumLiteral(assertKindEEnum, AssertKind.NOT_EQUALS);
		addEEnumLiteral(assertKindEEnum, AssertKind.NOT_NULL);
		addEEnumLiteral(assertKindEEnum, AssertKind.ASSERT_TRUE);
		addEEnumLiteral(assertKindEEnum, AssertKind.ASSERT_FALSE);
		addEEnumLiteral(assertKindEEnum, AssertKind.CONTAINS);
		addEEnumLiteral(assertKindEEnum, AssertKind.REGEXP);
		addEEnumLiteral(assertKindEEnum, AssertKind.CONTAINS_IMAGE);
		addEEnumLiteral(assertKindEEnum, AssertKind.IMAGE_CONTAINS_TEXT);
		addEEnumLiteral(assertKindEEnum, AssertKind.NOT_CONTAINS);
		addEEnumLiteral(assertKindEEnum, AssertKind.NOT_REGEXP);
		addEEnumLiteral(assertKindEEnum, AssertKind.IS_EMPTY);
		addEEnumLiteral(assertKindEEnum, AssertKind.NOT_EMPTY);

		initEEnum(dragKindEEnum, DragKind.class, "DragKind");
		addEEnumLiteral(dragKindEEnum, DragKind.START);
		addEEnumLiteral(dragKindEEnum, DragKind.END);
		addEEnumLiteral(dragKindEEnum, DragKind.SET_DATA);
		addEEnumLiteral(dragKindEEnum, DragKind.ACCEPT);
		addEEnumLiteral(dragKindEEnum, DragKind.DROP);
		addEEnumLiteral(dragKindEEnum, DragKind.DETECT);
		addEEnumLiteral(dragKindEEnum, DragKind.OVER);
		addEEnumLiteral(dragKindEEnum, DragKind.LEAVE);
		addEEnumLiteral(dragKindEEnum, DragKind.ENTER);

		initEEnum(mouseEventKindEEnum, MouseEventKind.class, "MouseEventKind");
		addEEnumLiteral(mouseEventKindEEnum, MouseEventKind.DOWN);
		addEEnumLiteral(mouseEventKindEEnum, MouseEventKind.UP);
		addEEnumLiteral(mouseEventKindEEnum, MouseEventKind.MOVE);
		addEEnumLiteral(mouseEventKindEEnum, MouseEventKind.ENTER);
		addEEnumLiteral(mouseEventKindEEnum, MouseEventKind.EXIT);
		addEEnumLiteral(mouseEventKindEEnum, MouseEventKind.DOUBLE_CLICK);
		addEEnumLiteral(mouseEventKindEEnum, MouseEventKind.HOVER);

		// Create resource
		createResource(eNS_URI);
	}

} //ProtocolPackageImpl
