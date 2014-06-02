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
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import java.text.ParseException;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.bindings.keys.IKeyLookup;
import org.eclipse.jface.bindings.keys.KeyLookupFactory;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.EclBoolean;
import org.eclipse.rcptt.ecl.core.EclString;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;

import org.eclipse.rcptt.util.swt.KeysAndButtons;
import org.eclipse.rcptt.tesla.core.protocol.CanvasUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ClickAboutMenu;
import org.eclipse.rcptt.tesla.core.protocol.ClickPreferencesMenu;
import org.eclipse.rcptt.tesla.core.protocol.ControlUIElement;
import org.eclipse.rcptt.tesla.core.protocol.DragKind;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.PartUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.SWTDialogKind;
import org.eclipse.rcptt.tesla.core.protocol.SetSWTDialogInfo;
import org.eclipse.rcptt.tesla.core.protocol.SetStatusDialogMode;
import org.eclipse.rcptt.tesla.core.protocol.TextUIElement;
import org.eclipse.rcptt.tesla.core.protocol.ViewerUIElement;
import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramFactory;
import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramViewerUIElement;
import org.eclipse.rcptt.tesla.core.protocol.diagram.FigureUIElement;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.ecl.TeslaEclUtils;
import org.eclipse.rcptt.tesla.ecl.impl.AbstractActionService;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.ActivateCellEdit;
import org.eclipse.rcptt.tesla.ecl.model.CellEdit;
import org.eclipse.rcptt.tesla.ecl.model.Check;
import org.eclipse.rcptt.tesla.ecl.model.Click;
import org.eclipse.rcptt.tesla.ecl.model.ClickRuler;
import org.eclipse.rcptt.tesla.ecl.model.ClickText;
import org.eclipse.rcptt.tesla.ecl.model.Close;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.DoubleClick;
import org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler;
import org.eclipse.rcptt.tesla.ecl.model.DoubleClickText;
import org.eclipse.rcptt.tesla.ecl.model.DragAction;
import org.eclipse.rcptt.tesla.ecl.model.GetText;
import org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset;
import org.eclipse.rcptt.tesla.ecl.model.HoverRuler;
import org.eclipse.rcptt.tesla.ecl.model.HoverText;
import org.eclipse.rcptt.tesla.ecl.model.IsDisabled;
import org.eclipse.rcptt.tesla.ecl.model.IsDisposed;
import org.eclipse.rcptt.tesla.ecl.model.KeyType;
import org.eclipse.rcptt.tesla.ecl.model.Maximize;
import org.eclipse.rcptt.tesla.ecl.model.Minimize;
import org.eclipse.rcptt.tesla.ecl.model.OpenDeclaration;
import org.eclipse.rcptt.tesla.ecl.model.Options;
import org.eclipse.rcptt.tesla.ecl.model.Restore;
import org.eclipse.rcptt.tesla.ecl.model.ReturnFromOsDialog;
import org.eclipse.rcptt.tesla.ecl.model.SelectRange;
import org.eclipse.rcptt.tesla.ecl.model.SetCaretPos;
import org.eclipse.rcptt.tesla.ecl.model.SetDialogResult;
import org.eclipse.rcptt.tesla.ecl.model.SetFocus;
import org.eclipse.rcptt.tesla.ecl.model.SetText;
import org.eclipse.rcptt.tesla.ecl.model.SetTextOffset;
import org.eclipse.rcptt.tesla.ecl.model.SetTextSelection;
import org.eclipse.rcptt.tesla.ecl.model.SetValue;
import org.eclipse.rcptt.tesla.ecl.model.ShowContentAssist;
import org.eclipse.rcptt.tesla.ecl.model.ShowTabList;
import org.eclipse.rcptt.tesla.ecl.model.TeslaPackage;
import org.eclipse.rcptt.tesla.ecl.model.TypeCommandKey;
import org.eclipse.rcptt.tesla.ecl.model.TypeText;
import org.eclipse.rcptt.tesla.ecl.model.Uncheck;
import org.eclipse.rcptt.tesla.ecl.model.Unfocus;
import org.eclipse.rcptt.tesla.ecl.model.diagram.DiagramPackage;
import org.eclipse.rcptt.tesla.ecl.model.diagram.DirectEdit;
import org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction;

public class ActionService extends AbstractActionService {

	@Override
	protected Object exec(Command command) throws CoreException {
		Object result = null;

		if (command instanceof GetText)
			result = handleGetText((GetText) command);
		else if (command instanceof IsDisposed)
			result = handleIsDisposed((IsDisposed) command);
		else if (command instanceof IsDisabled)
			result = handleIsDisabled((IsDisabled) command);
		else if (command instanceof DoubleClick)
			result = handleDoubleClick((DoubleClick) command);
		else if (command instanceof Click)
			result = handleClick((Click) command);
		else if (command instanceof TypeText)
			result = handleTypeText((TypeText) command);
		else if (command instanceof KeyType)
			result = handleKeyType((KeyType) command);
		else if (command instanceof TypeCommandKey)
			result = handleTypeCommandKey((TypeCommandKey) command);
		else if (command instanceof DragAction)
			result = handleDrag((DragAction) command);
		// Text
		else if (command instanceof SetText)
			result = handleSetText((SetText) command);
		else if (command instanceof SetValue)
			result = handleSetValue((SetValue) command);
		else if (command instanceof SetTextSelection)
			result = handleSetTextSelection((SetTextSelection) command);
		else if (command instanceof SelectRange)
			result = handleSelectRange((SelectRange) command);
		else if (command instanceof SetTextOffset)
			result = handleSetTextOffset((SetTextOffset) command);
		else if (command instanceof SetCaretPos)
			result = handleSetCaretPos((SetCaretPos) command);
		else if (command instanceof OpenDeclaration)
			result = handleOpenDeclaration((OpenDeclaration) command);
		else if (command instanceof HoverText)
			result = handleHoverAtText((HoverText) command);
		else if (command instanceof HoverAtTextOffset)
			result = handleHoverAtTextOffset((HoverAtTextOffset) command);
		else if (command instanceof ClickRuler)
			result = handleRulerClick((ClickRuler) command);
		else if (command instanceof DoubleClickRuler)
			result = handleRulerDoubleClick((DoubleClickRuler) command);
		else if (command instanceof HoverRuler)
			result = handleRulerHover((HoverRuler) command);
		// Canvas
		else if (command instanceof MouseAction)
			result = handleMouseAction((MouseAction) command);
		// Part
		else if (command instanceof Close)
			result = handleClose((Close) command);
		// Viewer
		else if (command instanceof Check)
			result = handleCheck((Check) command);
		else if (command instanceof Uncheck)
			result = handleUncheck((Uncheck) command);
		else if (command instanceof CellEdit)
			result = handleCellEditorAction((CellEdit) command);
		// TabFolder
		else if (command instanceof Minimize)
			result = handleMinimize((Minimize) command);
		else if (command instanceof Maximize)
			result = handleMaximize((Maximize) command);
		else if (command instanceof Restore)
			result = handleRestore((Restore) command);
		else if (command instanceof ShowTabList)
			result = handleShowTabList((ShowTabList) command);
		// Diagram
		else if (command instanceof DirectEdit)
			result = handleDirectEdit((DirectEdit) command);

		// Other
		else if (command instanceof ReturnFromOsDialog)
			handleReturnFromOsDialog((ReturnFromOsDialog) command);
		else if (command instanceof SetDialogResult)
			handleSetDialogResult((SetDialogResult) command);
		else if (command instanceof ShowContentAssist)
			handleShowContentAssist((ShowContentAssist) command);
		else if (command instanceof SetFocus)
			handleSetFocus((SetFocus) command);
		else if (command instanceof Unfocus)
			handleUnfocus((Unfocus) command);
		else if (command instanceof ClickText)
			handleClickText((ClickText) command);
		else if (command instanceof DoubleClickText)
			handleDoubleClickText((DoubleClickText) command);
		// Options
		else if (command instanceof Options)
			handleOptions((Options) command);
		return result;
	}

	private Object handleMinimize(Minimize command) throws CoreException {
		ControlUIElement controlUIElement = getControlUIElement(command
				.getControl());
		controlUIElement.minimize();
		return command.getControl();
	}

	private Object handleMaximize(Maximize command) throws CoreException {
		ControlUIElement controlUIElement = getControlUIElement(command
				.getControl());
		controlUIElement.maximize();
		return command.getControl();
	}

	private Object handleRestore(Restore command) throws CoreException {
		ControlUIElement controlUIElement = getControlUIElement(command
				.getControl());
		controlUIElement.restore();
		return command.getControl();
	}

	private Object handleShowTabList(ShowTabList command) throws CoreException {
		ControlUIElement controlUIElement = getControlUIElement(command
				.getControl());
		controlUIElement.showTabList();
		return command.getControl();
	}

	private Object handleTypeCommandKey(TypeCommandKey tck)
			throws CoreException {
		ControlUIElement controlUIElement = getControlUIElement(tck
				.getControl());
		controlUIElement.typeAction(tck.getCommandId());
		return tck.getControl();
	}

	private EclString handleGetText(GetText gt) throws CoreException {
		EclString result = CoreFactory.eINSTANCE.createEclString();
		result.setValue(getControlUIElement(gt.getControl()).getText());
		return result;
	}

	private EclBoolean handleIsDisposed(IsDisposed id) throws CoreException {
		EclBoolean result = CoreFactory.eINSTANCE.createEclBoolean();
		result.setValue(getControlUIElement(id.getControl()).isDisposed());
		return result;
	}

	private EclBoolean handleIsDisabled(IsDisabled id) throws CoreException {
		EclBoolean result = CoreFactory.eINSTANCE.createEclBoolean();
		result.setValue(getControlUIElement(id.getControl()).isDisabled());
		return result;
	}

	@SuppressWarnings("deprecation")
	private ControlHandler handleClick(Click c) throws CoreException {
		ControlHandler control = c.getControl();

		if (control.getKind() == ElementKind.Item && control.getIndex() != null) {
			// That's cell click
			Integer column = control.getIndex();
			ControlHandler itemParent = control.getParent();
			if (itemParent == null)
				throw new CoreException(
						TeslaImplPlugin.err("Cell parent is not specified"));
			switch (itemParent.getKind()) {
			case Tree:
			case Table:
				ControlHandler viewer = itemParent;
				Element viewerElement = TeslaBridge.find(viewer);
				if (viewerElement == null)
					throw new CoreException(
							TeslaImplPlugin.err("Couldn't find "
									+ viewer.getKind().name()));
				ViewerUIElement viewerUIElement = new ViewerUIElement(
						viewerElement, TeslaBridge.getPlayer());
				// viewerUIElement.setSelection(control.getPath());
				viewerUIElement.cellClick(column);
				break;
			default:
				throw new CoreException(
						TeslaImplPlugin
								.err("Cell parent must be table or tree"));
			}
			return control;
		} else if (control.getKind() == ElementKind.AboutMenu) {
			ClickAboutMenu a = ProtocolFactory.eINSTANCE.createClickAboutMenu();
			a.setElement(TeslaBridge.eclipseWindow());
			TeslaBridge.getPlayer().safeExecuteCommand(a);
			return control;
		} else if (control.getKind() == ElementKind.PreferencesMenu) {
			ClickPreferencesMenu a = ProtocolFactory.eINSTANCE
					.createClickPreferencesMenu();
			a.setElement(TeslaBridge.eclipseWindow());
			TeslaBridge.getPlayer().safeExecuteCommand(a);
			return control;
		}

		ControlUIElement controlUIElement = getControlUIElement(control);

		// Element state = null;
		// if (!c.isNowait())
		// state = TeslaBridge.getPlayer().getState();

		controlUIElement.click(!c.isNowait(), c.isDefault(), c.isArrow());

		// if (state != null)
		// TeslaBridge.getPlayer().waitForState(state);

		return control;
	}

	private ControlHandler handleDoubleClick(DoubleClick dc)
			throws CoreException {
		ControlUIElement controlUIElement = getControlUIElement(dc.getControl());
		controlUIElement.doubleClick(!dc.isNowait());
		return dc.getControl();
	}

	private ControlHandler handleTypeText(TypeText tt) throws CoreException {
		getControlUIElement(tt.getControl()).type(tt.getText(), 0,
				tt.isDisplay());
		return tt.getControl();
	}

	private Object handleKeyType(KeyType kt) throws CoreException {

		if (tryHandleTraverse(kt))
			return kt.getControl();

		kt.setKey(TeslaEclUtils.getKeyByAlias(kt.getKey()));

		ControlUIElement controlUIElement = getControlUIElement(kt.getControl());
		String keyStr = kt.getKey();
		String charStr = kt.getChar();
		char ch;
		try {
			ch = charStr == null ? 0 : stringToChar(charStr);
		} catch (ParseException e1) {
			throw new CoreException(TeslaImplPlugin.err("Illegal character"));
		}

		try {
			KeyStroke key = parseKey(keyStr);
			int keyCode = key.getNaturalKey();
			int mask = key.getModifierKeys();
			if (keyCode == 0) {
				controlUIElement.press(mask, 0, kt.isDisplay(), ch, 0, false,
						kt.getTimes());
			} else {
				if (ch == 0) {
					if (!(keyCode >= SWT.ARROW_UP && keyCode <= SWT.PRINT_SCREEN)) {
						// That means that null char means duplicate not 0
						int ctrlForm = Character.toUpperCase(keyCode) - 0x40;
						if ((mask & SWT.SHIFT) != 0 && (mask & SWT.CTRL) != 0
								&& (ctrlForm < 0x20 || ctrlForm == 0x7F)
								&& (ctrlForm & SWT.KEYCODE_BIT) == 0) {
							ch = (char) ctrlForm;
						} else if ((mask & SWT.CTRL) != 0
								&& (ctrlForm < 0x20 || ctrlForm == 0x7F)
								&& (ctrlForm & SWT.KEYCODE_BIT) == 0) {
							ch = (char) ctrlForm;
						} else if ((mask & SWT.SHIFT) != 0)
							ch = (char) Character.toUpperCase(keyCode);
						else
							ch = (char) keyCode;
					}
				} else {
					if ((mask & SWT.CTRL) != 0
							&& (ch - 0x40 < 0x20 || ch - 0x40 == 0x7F)
							&& (ch - 0x40 & SWT.KEYCODE_BIT) == 0) {
						ch -= 0x40;
					}
				}
				controlUIElement.press(keyCode, mask, kt.isDisplay(), ch, 0,
						false, kt.getTimes());
			}
		} catch (IllegalArgumentException e) {
			throw new CoreException(TeslaImplPlugin.err("Illegal key"));
		}
		return kt.getControl();
	}

	private boolean tryHandleTraverse(KeyType kt) throws CoreException {

		String Key = kt.getKey();
		char ch = 0;
		Integer traverseType = null;

		if (Key.equals("TRAVERSE_NONE"))
			traverseType = SWT.TRAVERSE_NONE;
		else if (Key.equals("TRAVERSE_ESCAPE"))
			traverseType = SWT.TRAVERSE_ESCAPE;
		else if (Key.equals("TRAVERSE_RETURN"))
			traverseType = SWT.TRAVERSE_RETURN;
		else if (Key.equals("TRAVERSE_TAB_NEXT"))
			traverseType = SWT.TRAVERSE_TAB_NEXT;
		else if (Key.equals("TRAVERSE_TAB_PREVIOUS"))
			traverseType = SWT.TRAVERSE_TAB_PREVIOUS;
		else if (Key.equals("TRAVERSE_ARROW_NEXT"))
			traverseType = SWT.TRAVERSE_ARROW_NEXT;
		else if (Key.equals("TRAVERSE_ARROW_PREVIOUS"))
			traverseType = SWT.TRAVERSE_ARROW_PREVIOUS;
		else if (Key.equals("TRAVERSE_MNEMONIC")) {
			traverseType = SWT.TRAVERSE_MNEMONIC;
			String charStr = kt.getChar();
			try {
				ch = charStr == null ? 0 : stringToChar(charStr);
			} catch (ParseException e1) {
				throw new CoreException(
						TeslaImplPlugin.err("Illegal character"));
			}
		} else if (Key.equals("TRAVERSE_PAGE_NEXT"))
			traverseType = SWT.TRAVERSE_PAGE_NEXT;
		else if (Key.equals("TRAVERSE_PAGE_PREVIOUS"))
			traverseType = SWT.TRAVERSE_PAGE_PREVIOUS;

		if (traverseType != null) {
			ControlUIElement controlUIElement = getControlUIElement(kt
					.getControl());
			controlUIElement.traverse(traverseType, ch, kt.getTimes());
			return true;
		}

		return false;
	}

	private int parseMask(String keyStr) throws CoreException {
		try {
			if (keyStr == null || keyStr.length() == 0)
				return 0;
			KeyStroke ks = parseKey(keyStr);
			return ks.getModifierKeys() | ks.getNaturalKey();
		} catch (IllegalArgumentException e) {
			try {
				return Integer.valueOf(keyStr);
			} catch (NumberFormatException e1) {
				throw new CoreException(TeslaImplPlugin.err("Invalid mask"));
			}
		}
	}

	private static int parseDetail(String detail) {
		if (detail == null)
			return 0;

		if (detail.equalsIgnoreCase("copy"))
			return DND.DROP_COPY;
		if (detail.equalsIgnoreCase("move"))
			return DND.DROP_MOVE;
		if (detail.equalsIgnoreCase("link"))
			return DND.DROP_LINK;
		if (detail.equalsIgnoreCase("target-move"))
			return DND.DROP_TARGET_MOVE;
		if (detail.equalsIgnoreCase("any"))
			return DND.DROP_DEFAULT;
		if (detail.equalsIgnoreCase("none"))
			return 0;

		// backward compatibility
		try {
			return Integer.parseInt(detail);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private Object handleDrag(DragAction d) throws CoreException {
		DragKind kind = null;
		switch (d.eClass().getClassifierID()) {
		case TeslaPackage.DRAG_ACCEPT:
			kind = DragKind.ACCEPT;
			break;
		case TeslaPackage.DRAG_DETECT:
			kind = DragKind.DETECT;
			break;
		case TeslaPackage.DROP:
			kind = DragKind.DROP;
			break;
		case TeslaPackage.DRAG_END:
			kind = DragKind.END;
			break;
		case TeslaPackage.DRAG_ENTER:
			kind = DragKind.ENTER;
			break;
		case TeslaPackage.DRAG_EXIT:
			kind = DragKind.LEAVE;
			break;
		case TeslaPackage.DRAG_OVER:
			kind = DragKind.OVER;
			break;
		case TeslaPackage.DRAG_SET_DATA:
			kind = DragKind.SET_DATA;
			break;
		case TeslaPackage.DRAG_START:
			kind = DragKind.START;
			break;
		default:
			throw new CoreException(
					TeslaImplPlugin.err("Unsupported kind of DnD"));
		}
		int detail = parseDetail(d.getDetail());
		int button = d.getButton() == null ? 0 : d.getButton().getValue();
		int operations = d.getOperation() == null ? -1 : d.getOperation();
		int stateMask = parseMask(d.getMask());

		String style = "";
		style += "detail:" + detail + ",";
		style += "button:" + button + ",";
		style += "mask:" + stateMask + ",";
		style += "operations:" + operations;
		getControlUIElement(d.getControl()).drag(kind, d.getX(), d.getY(),
				style);
		return d.getControl();
	}

	private ControlHandler handleSetText(SetText st) throws CoreException {
		ControlHandler control = st.getControl();
		if (ElementKind.Item.equals(control.getKind())) {
			ControlHandler parent = control.getParent();
			ViewerUIElement viewer = new ViewerUIElement(
					TeslaBridge.find(parent), TeslaBridge.getPlayer());
			viewer.setSelection(control.getPath());
			viewer.activateCellEditor(1);
			PartUIElement part = new PartUIElement(TeslaBridge.find(parent
					.getParent()), TeslaBridge.getPlayer());
			TextUIElement text = part.text();
			text.setText(st.getText());
			viewer.applyCellEditor();
		} else
			getTextUIElement(control).setText(st.getText());
		return control;
	}

	private ControlHandler handleSetValue(SetValue st) throws CoreException {
		ControlHandler control = st.getControl();
		if (ElementKind.Item.equals(control.getKind())) {
			ControlHandler parent = control.getParent();
			ViewerUIElement viewer = new ViewerUIElement(
					TeslaBridge.find(parent), TeslaBridge.getPlayer());
			viewer.setSelection(control.getPath());
			viewer.activateCellEditor(1);
			PartUIElement part = new PartUIElement(TeslaBridge.find(parent
					.getParent()), TeslaBridge.getPlayer());
			TextUIElement text = part.text();
			text.setText(st.getValue());
			viewer.applyCellEditor();
		} else
			getTextUIElement(control).setText(st.getValue());
		return control;
	}

	private ControlHandler handleSetTextSelection(SetTextSelection st)
			throws CoreException {
		ControlHandler control = st.getControl();

		if (st.getStartLine() != null && st.getEndLine() != null
				&& st.getEndOffset() != null) {
			getTextUIElement(control).setSelection(st.getStartLine(),
					st.getOffset(), st.getEndLine(), st.getEndOffset());
		} else {
			getTextUIElement(control).setSelection(st.getOffset(),
					st.getLength());
		}
		return control;
	}

	private ControlHandler handleSelectRange(SelectRange st)
			throws CoreException {
		ControlHandler control = st.getControl();

		getTextUIElement(control).setSelection2(st.getLine(), st.getColumn(),
				st.getEndLine(), st.getEndColumn());
		return control;
	}

	private ControlHandler handleSetTextOffset(SetTextOffset st)
			throws CoreException {
		if (st.getLine() != null) {
			getTextUIElement(st.getControl()).setTextOffset(st.getLine(),
					st.getValue());
		} else {
			getTextUIElement(st.getControl()).setTextOffset(-1, st.getValue());
		}
		return st.getControl();
	}

	private ControlHandler handleSetCaretPos(SetCaretPos st)
			throws CoreException {
		getTextUIElement(st.getControl()).setTextCursor(st.getLine(),
				st.getColumn());
		return st.getControl();
	}

	private ControlHandler handleOpenDeclaration(OpenDeclaration od)
			throws CoreException {
		getTextUIElement(od.getControl()).openDeclaration();
		return od.getControl();
	}

	private ControlHandler handleHoverAtTextOffset(HoverAtTextOffset st)
			throws CoreException {
		getTextUIElement(st.getControl()).hoverAtOffset(st.getOffset(),
				st.getLine());
		return st.getControl();
	}

	private ControlHandler handleHoverAtText(HoverText st) throws CoreException {
		getTextUIElement(st.getControl()).hoverAtText(st.getLine(),
				st.getColumn(), KeysAndButtons.stateMaskFromStr(st.getWith()));
		return st.getControl();
	}

	private ControlHandler handleRulerClick(ClickRuler rulerClick)
			throws CoreException {
		int button = KeysAndButtons.getButtonNumber(rulerClick.getButton());
		int stateMask = KeysAndButtons.stateMaskFromStr(rulerClick.getWith());
		getTextUIElement(rulerClick.getControl()).RulerClick(
				rulerClick.getLine(), button, stateMask);
		return rulerClick.getControl();
	}

	private ControlHandler handleRulerDoubleClick(
			DoubleClickRuler rulerDoubleClick) throws CoreException {
		int button = KeysAndButtons.getButtonNumber(rulerDoubleClick
				.getButton());
		getTextUIElement(rulerDoubleClick.getControl()).RulerDoubleClick(
				rulerDoubleClick.getLine(), button,
				KeysAndButtons.stateMaskFromStr(rulerDoubleClick.getWith()));
		return rulerDoubleClick.getControl();
	}

	private ControlHandler handleRulerHover(HoverRuler rulerHover)
			throws CoreException {
		getTextUIElement(rulerHover.getControl()).RulerHover(
				rulerHover.getLine(),
				KeysAndButtons.stateMaskFromStr(rulerHover.getWith()));
		return rulerHover.getControl();
	}

	private ControlHandler handleMouseAction(MouseAction ma)
			throws CoreException {
		int x = ma.getX() == null ? 0 : ma.getX();
		int y = ma.getY() == null ? 0 : ma.getY();
		int button = ma.getButton() == null ? 0 : ma.getButton().getValue();
		int mask = parseMask(ma.getMask());
		MouseCommandKind kind = null;
		switch (ma.eClass().getClassifierID()) {
		case DiagramPackage.MOUSE_DOUBLE_CLICK:
			kind = MouseCommandKind.DOUBLE_CLICK;
			break;
		case DiagramPackage.MOUSE_DRAG:
			kind = MouseCommandKind.DRAG;
			break;
		case DiagramPackage.MOUSE_ENTER:
			kind = MouseCommandKind.ENTER;
			break;
		case DiagramPackage.MOUSE_EXIT:
			kind = MouseCommandKind.EXIT;
			break;
		case DiagramPackage.MOUSE_HOVER:
			kind = MouseCommandKind.HOVER;
			break;
		case DiagramPackage.MOUSE_MOVE:
			kind = MouseCommandKind.MOVE;
			break;
		case DiagramPackage.MOUSE_PRESS:
			kind = MouseCommandKind.DOWN;
			break;
		case DiagramPackage.MOUSE_RELEASE:
			kind = MouseCommandKind.UP;
			break;
		default:
			throw new CoreException(
					TeslaImplPlugin.err("Unsupported mouse command kind"));
		}
		ControlHandler control = ma.getControl();
		Integer height = ma.getHeight();
		Integer width = ma.getWidth();
		if (height != null && width != null) {
			// List<Integer> editPartPath = null;
			// List<Integer> figurePath = null;
			ControlHandler target = control;
			// if (target.getKind().is(ElementKind.DiagramFigure)) {
			// if ("editpart/address".equals(target.getPath())) {
			// editPartPath = TeslaBridge
			// .parseIndexes(target.getIndexes());
			// } else if ("rawFigure/address".equals(target.getPath())) {
			// figurePath = TeslaBridge.parseIndexes(target.getIndexes());
			// } else {
			// throw new CoreException(
			// TeslaImplPlugin.err("Illegal figure path: "
			// + target.getIndexes()));
			// }
			// //target = target.getParent();
			// }
			if (target.getKind().equals(ElementKind.PaletteEntry)) {
				Element paletteEntry = TeslaBridge.find(target);
				FigureUIElement uiElement = new FigureUIElement(paletteEntry,
						TeslaBridge.getPlayer());
				uiElement.executeFigureMouseCommand(x, y, button, kind, null,
						/* figurePath */null, width, height, width, height, mask);
				return target;
			}
			if (target.getKind().equals(ElementKind.Canvas)
			/* || target.getKind().is(ElementKind.NebulaGrid) */) { // FIXME
				Element paletteEntry = TeslaBridge.find(target);
				FigureUIElement uiElement = new FigureUIElement(paletteEntry,
						TeslaBridge.getPlayer());
				uiElement.executeFigureMouseCommand(x, y, button, kind, null,
						/* figurePath */null, width, height, width, height, mask);
				return target;
			}
			// if (target.getKind().is(ElementKind.DiagramFigure)) {
			// if ("editpart/address".equals(target.getPath())) {
			// editPartPath = TeslaBridge
			// .parseIndexes(target.getIndexes());
			// } else if ("rawFigure/address".equals(target.getPath())) {
			// figurePath = TeslaBridge.parseIndexes(target.getIndexes());
			// } else {
			// throw new CoreException(
			// TeslaImplPlugin.err("Illegal figure path: "
			// + target.getIndexes()));
			// }
			// target = target.getParent();
			// }
			switch (target.getKind()) {
			case DiagramFigure:
				FigureUIElement element = getFigureUIElement(target);
				element.executeFigureMouseCommand(x, y, button, kind,
						/* editPartPath */null, /* figurePath */null, width, height,
						width, height, mask);
				return target;
			case DiagramViewer:
			case PaletteViewer:
				element = getDiagramViewerUIElement(target);
				element.executeFigureMouseCommand(x, y, button, kind,
						/* editPartPath */null, /* figurePath */null, width, height,
						width, height, mask);
				return target;
			}
			throw new CoreException(
					TeslaImplPlugin.err("Illegal control kind: "
							+ target.getKind()));
		}
		MouseCommand command = DiagramFactory.eINSTANCE.createMouseCommand();
		command.setKind(kind);
		command.setButton(button);
		command.setElement(TeslaBridge.find(control));
		command.setX(x);
		command.setY(y);
		command.setStateMask(mask);
		TeslaBridge.getPlayer().safeExecuteCommand(command);

		return control;
	}

	private ControlHandler handleClose(Close c) throws CoreException {
		getPartUIElement(c.getControl()).close();
		return c.getControl();
	}

	private ControlHandler handleCheck(Check c) throws CoreException {
		ControlHandler control = c.getControl();
		String path = control.getPath();
		if (path == null
				|| (path != null && control.getKind().equals(ElementKind.Menu))) {
			ControlUIElement controlUIElement = getControlUIElement(control);
			controlUIElement.check(true);
			return control;
		}
		boolean result = getViewerUIElement(control.getParent()).checkItemList(
				true, TeslaBridge.parsePath(path));
		if (!result)
			throw new CoreException(TeslaImplPlugin.err("Cannot check item(s)"));

		return control;
	}

	private ControlHandler handleUncheck(Uncheck c) throws CoreException {
		ControlHandler control = c.getControl();
		String path = control.getPath();
		if (path == null
				|| (path != null && control.getKind().equals(ElementKind.Menu))) {
			ControlUIElement controlUIElement = getControlUIElement(control);
			controlUIElement.check(false);
			return control;
		}
		boolean result = getViewerUIElement(control.getParent()).checkItemList(
				false, TeslaBridge.parsePath(path));
		if (!result)
			throw new CoreException(
					TeslaImplPlugin.err("Cannot uncheck item(s)"));

		return control;
	}

	private ControlHandler handleCellEditorAction(CellEdit c)
			throws CoreException {
		ControlHandler control = c.getControl();
		Integer column = null;
		if (control.getKind() == ElementKind.Item
				&& control.getColumn() != null) {
			column = control.getColumn();
			control = control.getParent();
			if (control == null)
				throw new CoreException(
						TeslaImplPlugin.err("Parent is not specified"));
		}
		if (control.getKind() != ElementKind.Tree
				&& control.getKind() != ElementKind.Table) {
			if (control.getKind() == ElementKind.Item) {
				control = control.getParent();
				if (control == null)
					throw new CoreException(
							TeslaImplPlugin.err("Parent is not specified"));
			}
		}

		boolean capable = control.getKind().equals(ElementKind.Tree)
				|| control.getKind().equals(ElementKind.Table)
				|| "NebulaGrid".equals(control.getCustomKindId()); // !!!
		// TODO design some extensibility mechanism for custom element kind
		// capabilities

		if (capable) {
			Element viewerElement = TeslaBridge.find(control);
			if (viewerElement == null)
				throw new CoreException(TeslaImplPlugin.err("Couldn't find "
						+ control.getKind().name()));
			ViewerUIElement viewerUIElement = new ViewerUIElement(
					viewerElement, TeslaBridge.getPlayer());
			switch (c.eClass().getClassifierID()) {
			case TeslaPackage.ACTIVATE_CELL_EDIT:
				if (column == null) {
					column = ((ActivateCellEdit) c).getColumn();
				}
				if (column == null) {
					throw new CoreException(
							TeslaImplPlugin.err("Column is not specified"));
				}
				// viewerUIElement.setSelection(item.getPath());
				viewerUIElement.activateCellEditor(column);
				break;
			case TeslaPackage.APPLY_CELL_EDIT:
				viewerUIElement.applyCellEditor();
				break;
			case TeslaPackage.CANCEL_CELL_EDIT:
				viewerUIElement.cancelCellEditor();
				break;
			case TeslaPackage.DEACTIVATE_CELL_EDIT:
				viewerUIElement.deactivateCellEditor();
				break;
			default:
				throw new CoreException(
						TeslaImplPlugin.err("Unsupported cell operation"));
			}
		} else {
			throw new CoreException(
					TeslaImplPlugin.err("Cell parent must be table or tree"));
		}
		return c.getControl();
	}

	private ControlHandler handleDirectEdit(DirectEdit c) throws CoreException {
		ControlHandler control = c.getControl();
		if (control.getKind() != ElementKind.DiagramViewer
				&& control.getKind() != ElementKind.PaletteViewer
				&& control.getKind() != ElementKind.DiagramFigure
				&& control.getKind() != ElementKind.PaletteEntry) {
			throw new CoreException(
					TeslaImplPlugin.err("Diagram element is not specified"));
		}

		FigureUIElement diagramUIElement = getFigureUIElement(control);
		switch (c.eClass().getClassifierID()) {
		case DiagramPackage.ACTIVATE_DIRECT_EDIT:
			diagramUIElement.activateDirectEdit(null);
			break;
		case DiagramPackage.COMMIT_DIRECT_EDIT:
			diagramUIElement.commitDirectEdit();
			break;
		case DiagramPackage.CANCEL_DIRECT_EDIT:
			diagramUIElement.cancelDirectEdit();
			break;
		default:
			throw new CoreException(
					TeslaImplPlugin.err("Unsupported direct edit operation"));
		}
		return c.getControl();
	}

	private void handleReturnFromOsDialog(ReturnFromOsDialog c)
			throws CoreException {
		SetSWTDialogInfo info = ProtocolFactory.eINSTANCE
				.createSetSWTDialogInfo();
		SWTDialogKind kind = SWTDialogKind.valueOf(c.getKind());
		if (kind == null)
			throw new CoreException(TeslaImplPlugin.err("Illegal kind"));
		info.setKind(kind);
		for (String currentStr : c.getResult()) {
			info.getPath().add(currentStr);
		}
		TeslaBridge.getPlayer().safeExecuteCommand(info);
	}

	private void handleSetDialogResult(SetDialogResult c) throws CoreException {
		SetSWTDialogInfo info = ProtocolFactory.eINSTANCE
				.createSetSWTDialogInfo();
		SWTDialogKind kind = null;
		String k = c.getKind();
		if (k.equalsIgnoreCase("File")) {
			kind = SWTDialogKind.FILE_SELECTOR;
		} else if (k.equalsIgnoreCase("Folder")) {
			kind = SWTDialogKind.FOLDER_SELECTOR;
		} else if (k.equalsIgnoreCase("Color")) {
			kind = SWTDialogKind.COLOR;
		} else if (k.equalsIgnoreCase("Font")) {
			kind = SWTDialogKind.FONT_DIALOG;
		} else if (k.equalsIgnoreCase("MessageBox")) {
			kind = SWTDialogKind.MESSAGE_BOX;
		}
		if (kind == null)
			throw new CoreException(TeslaImplPlugin.err("Illegal kind"));
		info.setKind(kind);
		for (String currentStr : c.getResult()) {
			info.getPath().add(currentStr);
		}
		TeslaBridge.getPlayer().safeExecuteCommand(info);
	}

	private void handleOptions(Options c) throws CoreException {
		SetStatusDialogMode mode = ProtocolFactory.eINSTANCE
				.createSetStatusDialogMode();
		mode.setEnabled(c.isAllowStatusDialog());
		TeslaBridge.getPlayer().safeExecuteCommand(mode);
	}

	private void handleShowContentAssist(ShowContentAssist c)
			throws CoreException {
		org.eclipse.rcptt.tesla.core.protocol.ShowContentAssist a = ProtocolFactory.eINSTANCE
				.createShowContentAssist();
		a.setElement(TeslaBridge.find(c.getControl()));
		TeslaBridge.getPlayer().safeExecuteCommand(a);
	}

	private ControlHandler handleSetFocus(SetFocus c) throws CoreException {
		getControlUIElement(c.getControl()).setFocus();
		return c.getControl();
	}
	private ControlHandler handleUnfocus(Unfocus c) throws CoreException {
		getControlUIElement(c.getControl()).unfocus();
		return c.getControl();
	}

	private ControlHandler handleClickText(ClickText c) throws CoreException {
		getControlUIElement(c.getControl()).clickText(c.getStart(), c.getEnd(),
				c.getButton());
		return c.getControl();
	}

	private ControlHandler handleDoubleClickText(DoubleClickText c)
			throws CoreException {
		getControlUIElement(c.getControl()).doubleClickText(c.getPosition(),
				c.getButton());
		return c.getControl();
	}

	private ControlUIElement getControlUIElement(ControlHandler control)
			throws CoreException {
		ControlUIElement element = new ControlUIElement(
				TeslaBridge.find(control), TeslaBridge.getPlayer());
		TeslaBridge.storeLastControlUIElement(element);
		return element;
	}

	static TextUIElement getTextUIElement(ControlHandler control)
			throws CoreException {
		TextUIElement element = new TextUIElement(TeslaBridge.find(control),
				TeslaBridge.getPlayer());
		TeslaBridge.storeLastControlUIElement(element);
		return element;
	}

	@SuppressWarnings("unused")
	private CanvasUIElement getCanvasUIElement(ControlHandler control)
			throws CoreException {
		CanvasUIElement element = new CanvasUIElement(
				TeslaBridge.find(control), TeslaBridge.getPlayer());
		return element;
	}

	private PartUIElement getPartUIElement(ControlHandler control)
			throws CoreException {
		PartUIElement element = new PartUIElement(TeslaBridge.find(control),
				TeslaBridge.getPlayer());
		TeslaBridge.storeLastControlUIElement(element);
		return element;
	}

	// TODO move these methods into some ActionServiceUtils
	static ViewerUIElement getViewerUIElement(ControlHandler control)
			throws CoreException {
		ViewerUIElement element = new ViewerUIElement(
				TeslaBridge.find(control), TeslaBridge.getPlayer());
		TeslaBridge.storeLastControlUIElement(element);
		return element;
	}

	private DiagramViewerUIElement getDiagramViewerUIElement(
			ControlHandler control) throws CoreException {
		DiagramViewerUIElement element = new DiagramViewerUIElement(
				TeslaBridge.find(control), TeslaBridge.getPlayer());
		return element;
	}

	private FigureUIElement getFigureUIElement(ControlHandler control)
			throws CoreException {
		return new FigureUIElement(TeslaBridge.find(control),
				TeslaBridge.getPlayer());
	}

	private KeyStroke parseKey(final String string) {
		if (string == null) {
			throw new NullPointerException("Cannot parse a null string"); //$NON-NLS-1$
		}

		final IKeyLookup lookup = KeyLookupFactory.getDefault();
		int modifierKeys = KeyStroke.NO_KEY;
		int naturalKey = KeyStroke.NO_KEY;
		final StringTokenizer stringTokenizer = new StringTokenizer(string,
				KeyStroke.KEY_DELIMITERS, true);
		int i = 0;

		while (stringTokenizer.hasMoreTokens()) {
			String token = stringTokenizer.nextToken();
			if (i % 2 == 0) {
				if (stringTokenizer.hasMoreTokens()) {
					token = token.toUpperCase();
					final int modifierKey = lookup.formalModifierLookup(token);
					if (modifierKey == KeyStroke.NO_KEY) {
						throw new IllegalArgumentException();
					}

					modifierKeys |= modifierKey;

				} else if (token.length() == 1) {
					naturalKey = token.charAt(0);

				} else {
					token = token.toUpperCase();
					try {
						naturalKey = lookup.formalKeyLookup(token);
					} catch (IllegalArgumentException e) {
						naturalKey = lookup.formalModifierLookup(token);
					}
					if (naturalKey == KeyStroke.NO_KEY) {
						throw new IllegalArgumentException();
					}
				}
			}

			i++;
		}

		return KeyStroke.getInstance(modifierKeys, naturalKey);
	}

	/**
	 * Convert string to character.
	 * 
	 * String must contain single character or unicode escape sequence.
	 * 
	 * If string contains single character method returns it as is. If string is
	 * unicode escape sequence method encode it to character. Otherwise method
	 * return throws ParseException.
	 * 
	 * @param s
	 *            string presentation of character
	 * @return character or null if string format is invalid
	 * @throws ParseException
	 */
	private Character stringToChar(String s) throws ParseException {
		if (s.length() == 1)
			return s.charAt(0);
		if (s.startsWith("\\u")) {
			try {
				return (char) (int) Integer.valueOf(s.substring(2), 16);
			} catch (NumberFormatException e) {
				// Illegal format, dealing with it in the end.
			}
		}
		// Illegal format
		return null;
	}

}
