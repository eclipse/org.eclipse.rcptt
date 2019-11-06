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
package org.eclipse.rcptt.tesla.ecl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.util.ScriptletFactory;
import org.eclipse.rcptt.tesla.ecl.model.ActivateCellEdit;
import org.eclipse.rcptt.tesla.ecl.model.ActivationEventType;
import org.eclipse.rcptt.tesla.ecl.model.ApplyCellEdit;
import org.eclipse.rcptt.tesla.ecl.model.Button;
import org.eclipse.rcptt.tesla.ecl.model.CancelCellEdit;
import org.eclipse.rcptt.tesla.ecl.model.Check;
import org.eclipse.rcptt.tesla.ecl.model.Click;
import org.eclipse.rcptt.tesla.ecl.model.ClickColumn;
import org.eclipse.rcptt.tesla.ecl.model.ClickRuler;
import org.eclipse.rcptt.tesla.ecl.model.Close;
import org.eclipse.rcptt.tesla.ecl.model.Contains;
import org.eclipse.rcptt.tesla.ecl.model.ContainsImage;
import org.eclipse.rcptt.tesla.ecl.model.ControlNotFound;
import org.eclipse.rcptt.tesla.ecl.model.DeactivateCellEdit;
import org.eclipse.rcptt.tesla.ecl.model.DoubleClick;
import org.eclipse.rcptt.tesla.ecl.model.DoubleClickRuler;
import org.eclipse.rcptt.tesla.ecl.model.DragAccept;
import org.eclipse.rcptt.tesla.ecl.model.DragDetect;
import org.eclipse.rcptt.tesla.ecl.model.DragEnd;
import org.eclipse.rcptt.tesla.ecl.model.DragEnter;
import org.eclipse.rcptt.tesla.ecl.model.DragExit;
import org.eclipse.rcptt.tesla.ecl.model.DragOver;
import org.eclipse.rcptt.tesla.ecl.model.DragSetData;
import org.eclipse.rcptt.tesla.ecl.model.DragStart;
import org.eclipse.rcptt.tesla.ecl.model.Drop;
import org.eclipse.rcptt.tesla.ecl.model.Equals;
import org.eclipse.rcptt.tesla.ecl.model.ExecWithOptions;
import org.eclipse.rcptt.tesla.ecl.model.GetBanner;
import org.eclipse.rcptt.tesla.ecl.model.GetButton;
import org.eclipse.rcptt.tesla.ecl.model.GetCanvas;
import org.eclipse.rcptt.tesla.ecl.model.GetCell;
import org.eclipse.rcptt.tesla.ecl.model.GetCheckbox;
import org.eclipse.rcptt.tesla.ecl.model.GetCombo;
import org.eclipse.rcptt.tesla.ecl.model.GetControl;
import org.eclipse.rcptt.tesla.ecl.model.GetCoolbar;
import org.eclipse.rcptt.tesla.ecl.model.GetDateTime;
import org.eclipse.rcptt.tesla.ecl.model.GetEclipseWindow;
import org.eclipse.rcptt.tesla.ecl.model.GetEditbox;
import org.eclipse.rcptt.tesla.ecl.model.GetEditor;
import org.eclipse.rcptt.tesla.ecl.model.GetGroup;
import org.eclipse.rcptt.tesla.ecl.model.GetItem;
import org.eclipse.rcptt.tesla.ecl.model.GetLabel;
import org.eclipse.rcptt.tesla.ecl.model.GetLeftRuler;
import org.eclipse.rcptt.tesla.ecl.model.GetLink;
import org.eclipse.rcptt.tesla.ecl.model.GetList;
import org.eclipse.rcptt.tesla.ecl.model.GetMenu;
import org.eclipse.rcptt.tesla.ecl.model.GetProperty;
import org.eclipse.rcptt.tesla.ecl.model.GetQuickAccess;
import org.eclipse.rcptt.tesla.ecl.model.GetRegion;
import org.eclipse.rcptt.tesla.ecl.model.GetRegionText;
import org.eclipse.rcptt.tesla.ecl.model.GetRightRuler;
import org.eclipse.rcptt.tesla.ecl.model.GetRulerColumn;
import org.eclipse.rcptt.tesla.ecl.model.GetSection;
import org.eclipse.rcptt.tesla.ecl.model.GetSlider;
import org.eclipse.rcptt.tesla.ecl.model.GetTabFolder;
import org.eclipse.rcptt.tesla.ecl.model.GetTabItem;
import org.eclipse.rcptt.tesla.ecl.model.GetTable;
import org.eclipse.rcptt.tesla.ecl.model.GetTextViewer;
import org.eclipse.rcptt.tesla.ecl.model.GetToolbar;
import org.eclipse.rcptt.tesla.ecl.model.GetTree;
import org.eclipse.rcptt.tesla.ecl.model.GetVerticalRuler;
import org.eclipse.rcptt.tesla.ecl.model.GetView;
import org.eclipse.rcptt.tesla.ecl.model.GetWindow;
import org.eclipse.rcptt.tesla.ecl.model.HoverAtTextOffset;
import org.eclipse.rcptt.tesla.ecl.model.HoverRuler;
import org.eclipse.rcptt.tesla.ecl.model.HoverText;
import org.eclipse.rcptt.tesla.ecl.model.IsEmpty;
import org.eclipse.rcptt.tesla.ecl.model.KeyType;
import org.eclipse.rcptt.tesla.ecl.model.Matches;
import org.eclipse.rcptt.tesla.ecl.model.OpenDeclaration;
import org.eclipse.rcptt.tesla.ecl.model.Options;
import org.eclipse.rcptt.tesla.ecl.model.Select;
import org.eclipse.rcptt.tesla.ecl.model.SelectRange;
import org.eclipse.rcptt.tesla.ecl.model.SetCaretPos;
import org.eclipse.rcptt.tesla.ecl.model.SetDialogResult;
import org.eclipse.rcptt.tesla.ecl.model.SetText;
import org.eclipse.rcptt.tesla.ecl.model.SetTextOffset;
import org.eclipse.rcptt.tesla.ecl.model.SetTextSelection;
import org.eclipse.rcptt.tesla.ecl.model.SetValue;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;
import org.eclipse.rcptt.tesla.ecl.model.TeslaPackage;
import org.eclipse.rcptt.tesla.ecl.model.TypeText;
import org.eclipse.rcptt.tesla.ecl.model.Uncheck;
import org.eclipse.rcptt.tesla.ecl.model.Unsupported;
import org.eclipse.rcptt.tesla.ecl.model.VerifyFalse;
import org.eclipse.rcptt.tesla.ecl.model.VerifyTrue;
import org.eclipse.rcptt.tesla.ecl.model.diagram.ActivateDirectEdit;
import org.eclipse.rcptt.tesla.ecl.model.diagram.CancelDirectEdit;
import org.eclipse.rcptt.tesla.ecl.model.diagram.CommitDirectEdit;
import org.eclipse.rcptt.tesla.ecl.model.diagram.DiagramFactory;
import org.eclipse.rcptt.tesla.ecl.model.diagram.GetConnectionHandle;
import org.eclipse.rcptt.tesla.ecl.model.diagram.GetDiagram;
import org.eclipse.rcptt.tesla.ecl.model.diagram.GetEditPart;
import org.eclipse.rcptt.tesla.ecl.model.diagram.GetFigure;
import org.eclipse.rcptt.tesla.ecl.model.diagram.GetHandle;
import org.eclipse.rcptt.tesla.ecl.model.diagram.GetPalette;
import org.eclipse.rcptt.tesla.ecl.model.diagram.GetPaletteEntry;
import org.eclipse.rcptt.tesla.ecl.model.diagram.GetPopupBarItem;
import org.eclipse.rcptt.tesla.ecl.model.diagram.GetSourceConnection;
import org.eclipse.rcptt.tesla.ecl.model.diagram.GetTargetConnection;
import org.eclipse.rcptt.tesla.ecl.model.diagram.MouseAction;
import org.eclipse.rcptt.tesla.ecl.model.diagram.MouseDoubleClick;
import org.eclipse.rcptt.tesla.ecl.model.diagram.MouseDrag;
import org.eclipse.rcptt.tesla.ecl.model.diagram.MouseEnter;
import org.eclipse.rcptt.tesla.ecl.model.diagram.MouseExit;
import org.eclipse.rcptt.tesla.ecl.model.diagram.MouseHover;
import org.eclipse.rcptt.tesla.ecl.model.diagram.MouseMove;
import org.eclipse.rcptt.tesla.ecl.model.diagram.MousePress;
import org.eclipse.rcptt.tesla.ecl.model.diagram.MouseRelease;
// import org.eclipse.rcptt.tesla.ecl.rap.model.ExecWithoutJs;
// import org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaFactory;
// import org.eclipse.rcptt.tesla.ecl.rap.model.SetDownloadResultFile;
// import org.eclipse.rcptt.tesla.ecl.rap.model.VerifyDownloadFile;
import org.eclipse.rcptt.util.KeysAndButtons;

public class TeslaScriptletFactory extends ScriptletFactory {

	public static Unsupported unsupported(String desc) {
		Unsupported command = TeslaFactory.eINSTANCE.createUnsupported();
		command.setDesc(desc);
		return command;
	}

	public static ControlNotFound controlNotFound() {
		return TeslaFactory.eINSTANCE.createControlNotFound();
	}

	public static ControlNotFound controlNotFound(String id) {
		ControlNotFound command = TeslaFactory.eINSTANCE
				.createControlNotFound();
		command.setId(id);
		return command;
	}

	public static GetProperty makeGetProperty(String name) {
		GetProperty c = TeslaFactory.eINSTANCE.createGetProperty();
		c.setName(name);
		return c;
	}

	public static VerifyTrue makeVerifyTrue() {
		return TeslaFactory.eINSTANCE.createVerifyTrue();
	}

	public static VerifyFalse makeVerifyFalse() {
		return TeslaFactory.eINSTANCE.createVerifyFalse();
	}

	public static VerifyTrue makeVerify(Command condition) {
		VerifyTrue cmd = makeVerifyTrue();
		return bind(cmd, TeslaPackage.eINSTANCE.getVerifyTrue_Condition(),
				condition);
	}

	public static Equals makeEquals(String value) {
		Equals c = TeslaFactory.eINSTANCE.createEquals();
		c.setValue(value);
		return c;
	}

	public static Contains makeContains(String value) {
		Contains c = TeslaFactory.eINSTANCE.createContains();
		c.setValue(value);
		return c;
	}

	public static ContainsImage makeContainsImage(String uri, String raw) {
		ContainsImage c = TeslaFactory.eINSTANCE.createContainsImage();
		c.setImageURI(uri);
		c.setRawImage(raw);
		return c;
	}

	public static GetRegionText makeRegionContainsText(int x, int y, int sx,
			int sy, int width, int height) {
		GetRegionText c = TeslaFactory.eINSTANCE.createGetRegionText();
		c.setX(x);
		c.setY(y);
		c.setSx(sx);
		c.setSy(sy);
		c.setWidth(width);
		c.setHeight(height);
		return c;
	}

	public static Matches makeMatches(String value) {
		Matches c = TeslaFactory.eINSTANCE.createMatches();
		c.setValue(value);
		return c;
	}

	public static IsEmpty makeIsEmpty() {
		return TeslaFactory.eINSTANCE.createIsEmpty();
	}

	public static GetControl makeControl(String kind, String text) {
		GetControl cmd = TeslaFactory.eINSTANCE.createGetControl();
		cmd.setKind(kind);
		cmd.setText(text);
		return cmd;
	}

	public static GetButton makeButton(String text) {
		GetButton cmd = TeslaFactory.eINSTANCE.createGetButton();
		cmd.setText(text);
		return cmd;
	}

	public static GetCanvas makeCanvas() {
		return TeslaFactory.eINSTANCE.createGetCanvas();
	}

	public static GetRegion makeRegion() {
		return TeslaFactory.eINSTANCE.createGetRegion();
	}

	public static GetBanner makeCBanner() {
		return TeslaFactory.eINSTANCE.createGetBanner();
	}

	public static GetCheckbox makeCheckbox(String text) {
		GetCheckbox cmd = TeslaFactory.eINSTANCE.createGetCheckbox();
		cmd.setText(text);
		return cmd;
	}

	public static GetCombo makeCombo() {
		return TeslaFactory.eINSTANCE.createGetCombo();
	}

	public static GetCoolbar makeCoolbar() {
		return TeslaFactory.eINSTANCE.createGetCoolbar();
	}

	public static GetEditbox makeEditbox() {
		return TeslaFactory.eINSTANCE.createGetEditbox();
	}

	public static GetDateTime makeDateTime() {
		return TeslaFactory.eINSTANCE.createGetDateTime();
	}

	public static GetSlider makeSlider() {
		return TeslaFactory.eINSTANCE.createGetSlider();
	}

	public static GetEditor makeEditor(String text, String type, Integer index) {
		GetEditor cmd = TeslaFactory.eINSTANCE.createGetEditor();
		cmd.setText(text);
		cmd.setType(type);
		cmd.setIndex(index);
		return cmd;
	}

	public static GetEclipseWindow makeEclipseWindow(int index) {
		GetEclipseWindow cmd = TeslaFactory.eINSTANCE.createGetEclipseWindow();
		cmd.setIndex(index);
		return cmd;
	}

	public static GetQuickAccess makeQuickAccess() {
		GetQuickAccess cmd = TeslaFactory.eINSTANCE.createGetQuickAccess();
		return cmd;
	}

	public static GetTextViewer makeTextViewer() {
		GetTextViewer cmd = TeslaFactory.eINSTANCE.createGetTextViewer();
		return cmd;
	}

	public static GetVerticalRuler makeVerticalRuler() {
		GetVerticalRuler cmd = TeslaFactory.eINSTANCE.createGetVerticalRuler();
		return cmd;
	}

	public static GetRightRuler makeRightRuler() {
		GetRightRuler cmd = TeslaFactory.eINSTANCE.createGetRightRuler();
		return cmd;
	}

	public static GetRulerColumn makeRulerColumn(String text) {
		GetRulerColumn cmd = TeslaFactory.eINSTANCE.createGetRulerColumn();
		cmd.setText(text);
		return cmd;
	}

	public static GetLeftRuler makeLeftRuler() {
		GetLeftRuler cmd = TeslaFactory.eINSTANCE.createGetLeftRuler();
		return cmd;
	}

	public static GetSection makeExpandable(String text) {
		GetSection cmd = TeslaFactory.eINSTANCE.createGetSection();
		cmd.setText(text);
		return cmd;
	}

	public static GetGroup makeGroup(String name) {
		GetGroup cmd = TeslaFactory.eINSTANCE.createGetGroup();
		cmd.setText(name);
		return cmd;
	}

	public static GetItem makeItem(String path, Integer index) {
		GetItem cmd = TeslaFactory.eINSTANCE.createGetItem();
		cmd.setPath(path);
		cmd.setIndex(index);
		return cmd;
	}

	public static GetItem makeItem(String path, Integer index, String column) {
		GetItem cmd = makeItem(path, index);
		cmd.setColumn(column);
		return cmd;
	}

	public static GetCell makeCell(int row, int column) {
		GetCell cmd = TeslaFactory.eINSTANCE.createGetCell();
		cmd.setRow(row);
		cmd.setColumn(column);
		return cmd;
	}

	public static GetLabel makeLabel(String text) {
		GetLabel cmd = TeslaFactory.eINSTANCE.createGetLabel();
		cmd.setText(text);
		return cmd;
	}

	public static GetLink makeLink(String text) {
		GetLink cmd = TeslaFactory.eINSTANCE.createGetLink();
		cmd.setText(text);
		return cmd;
	}

	public static GetList makeList() {
		return TeslaFactory.eINSTANCE.createGetList();
	}

	public static GetMenu makeMenu(String path, Integer index) {
		GetMenu cmd = TeslaFactory.eINSTANCE.createGetMenu();
		cmd.setPath(path);
		cmd.setIndex(index);
		return cmd;
	}

	public static GetTabFolder makeTabFolder() {
		return TeslaFactory.eINSTANCE.createGetTabFolder();
	}

	public static GetTabItem makeTabItem(String text) {
		GetTabItem cmd = TeslaFactory.eINSTANCE.createGetTabItem();
		cmd.setText(text);
		return cmd;
	}

	public static GetTable makeTable() {
		return TeslaFactory.eINSTANCE.createGetTable();
	}

	public static GetToolbar makeToolbar() {
		return TeslaFactory.eINSTANCE.createGetToolbar();
	}

	public static GetTree makeTree() {
		GetTree cmd = TeslaFactory.eINSTANCE.createGetTree();
		return cmd;
	}

	public static GetView makeView(String text) {
		GetView cmd = TeslaFactory.eINSTANCE.createGetView();
		cmd.setText(text);
		return cmd;
	}

	public static GetPaletteEntry paletteEntry(String text) {
		GetPaletteEntry cmd = DiagramFactory.eINSTANCE.createGetPaletteEntry();
		cmd.setText(text);
		return cmd;
	}

	public static Close makeClose() {
		return TeslaFactory.eINSTANCE.createClose();
	}

	public static Options makeOptions() {
		return TeslaFactory.eINSTANCE.createOptions();
	}

	public static GetWindow makeWindow(String text) {
		GetWindow cmd = TeslaFactory.eINSTANCE.createGetWindow();
		cmd.setText(text);
		return cmd;
	}

	public static GetWindow makeFromedWindow(String from) {
		GetWindow cmd = TeslaFactory.eINSTANCE.createGetWindow();
		cmd.setFrom(getFromedWindowTitle(from));
		return cmd;
	}

	public static GetWindow makeClassedWindow(String klass) {
		GetWindow cmd = TeslaFactory.eINSTANCE.createGetWindow();
		cmd.setClass(klass);
		return cmd;
	}

	public static String getFromedWindowTitle(String from) {
		if (from.equals("AbstractInformationControl.<init>()")) {
			return "Information Window";
		}
		return from;
	}

	public static String getWindowFromByTitle(String title) {
		if (title.equals("Information Window")) {
			return "AbstractInformationControl.<init>()";
		}
		return title;
	}

	public static GetDiagram makeDiagramViewer(Integer index) {
		GetDiagram getDiagram = DiagramFactory.eINSTANCE.createGetDiagram();
		getDiagram.setIndex(index);
		return getDiagram;
	}

	public static GetPalette makePaletteViewer() {
		return DiagramFactory.eINSTANCE.createGetPalette();
	}

	public static Click makeClick(boolean wait, boolean def, boolean arrow, String metaKeys) {
		Click cmd = TeslaFactory.eINSTANCE.createClick();
		cmd.setNowait(!wait);
		cmd.setDefault(def);
		cmd.setArrow(arrow);
		cmd.setMetaKeys(metaKeys);
		return cmd;
	}

	public static DoubleClick makeDoubleClick(boolean wait) {
		DoubleClick cmd = TeslaFactory.eINSTANCE.createDoubleClick();
		cmd.setNowait(!wait);
		return cmd;
	}

	public static SetText makeSetText(String text) {
		SetText cmd = TeslaFactory.eINSTANCE.createSetText();
		cmd.setText(text);
		return cmd;
	}

	public static SetValue makeSetValue(String text) {
		SetValue cmd = TeslaFactory.eINSTANCE.createSetValue();
		cmd.setValue(text);
		return cmd;
	}

	public static SetTextSelection makeSetTextSelection(int startLine,
			int startOffset, Integer endLine, Integer endOffset) {
		SetTextSelection cmd = TeslaFactory.eINSTANCE.createSetTextSelection();
		cmd.setStartLine(startLine);
		cmd.setOffset(startOffset);
		cmd.setEndLine(endLine);
		cmd.setEndOffset(endOffset);
		return cmd;
	}

	public static SetTextSelection makeSetTextSelection(int offset, int length) {
		SetTextSelection cmd = TeslaFactory.eINSTANCE.createSetTextSelection();

		cmd.setOffset(offset);
		cmd.setLength(length);
		return cmd;
	}

	public static TypeText makeTypeText(String text, boolean fromDisplay) {
		TypeText cmd = TeslaFactory.eINSTANCE.createTypeText();
		cmd.setText(text);
		cmd.setDisplay(fromDisplay);
		return cmd;
	}

	public static KeyType makeType(String key, String ch) {
		KeyType cmd = TeslaFactory.eINSTANCE.createKeyType();
		cmd.setKey(key);
		cmd.setChar(ch);
		return cmd;
	}

	public static Select makeSelect(String path) {
		Select cmd = TeslaFactory.eINSTANCE.createSelect();
		cmd.getItems().add(path);
		return cmd;
	}

	public static Select makeSelect(List<String> paths) {
		Select cmd = TeslaFactory.eINSTANCE.createSelect();
		cmd.getItems().addAll(paths);
		return cmd;
	}

	public static Check makeCheck() {
		return TeslaFactory.eINSTANCE.createCheck();
	}

	public static Uncheck makeUncheck() {
		return TeslaFactory.eINSTANCE.createUncheck();
	}

	public static <T extends MouseAction> T makeMouseAction(T cmd, int x,
			int y, Button button, Integer height, Integer width, String mask) {
		cmd.setX(x);
		cmd.setY(y);
		cmd.setButton(button);
		cmd.setHeight(height);
		cmd.setWidth(width);
		cmd.setMask(mask);
		return cmd;
	}

	public static MousePress makeMousePress(int x, int y, Button button,
			Integer height, Integer width, String mask) {
		MousePress cmd = DiagramFactory.eINSTANCE.createMousePress();
		return makeMouseAction(cmd, x, y, button, height, width, mask);
	}

	public static MouseRelease makeMouseRelease(int x, int y, Button button,
			Integer height, Integer width, String mask) {
		MouseRelease cmd = DiagramFactory.eINSTANCE.createMouseRelease();
		return makeMouseAction(cmd, x, y, button, height, width, mask);
	}

	public static MouseDoubleClick makeMouseDoubleClick(int x, int y,
			Button button, Integer height, Integer width, String mask) {
		MouseDoubleClick cmd = DiagramFactory.eINSTANCE
				.createMouseDoubleClick();
		return makeMouseAction(cmd, x, y, button, height, width, mask);
	}

	public static MouseMove makeMouseMove(int x, int y, Button button,
			Integer height, Integer width, String mask) {
		MouseMove cmd = DiagramFactory.eINSTANCE.createMouseMove();
		return makeMouseAction(cmd, x, y, button, height, width, mask);
	}

	public static MouseDrag makeMouseDrag(int x, int y, Button button,
			Integer height, Integer width, String mask) {
		MouseDrag cmd = DiagramFactory.eINSTANCE.createMouseDrag();
		return makeMouseAction(cmd, x, y, button, height, width, mask);
	}

	public static MouseHover makeMouseHover(int x, int y, Button button,
			Integer height, Integer width, String mask) {
		MouseHover cmd = DiagramFactory.eINSTANCE.createMouseHover();
		return makeMouseAction(cmd, x, y, button, height, width, mask);
	}

	public static MouseEnter makeMouseEnter(int x, int y, Button button,
			Integer height, Integer width, String mask) {
		MouseEnter cmd = DiagramFactory.eINSTANCE.createMouseEnter();
		return makeMouseAction(cmd, x, y, button, height, width, mask);
	}

	public static MouseExit makeMouseExit(int x, int y, Button button,
			Integer height, Integer width, String mask) {
		MouseExit cmd = DiagramFactory.eINSTANCE.createMouseExit();
		return makeMouseAction(cmd, x, y, button, height, width, mask);
	}

	public static GetEditPart makeEditPart(List<Integer> path) {
		GetEditPart cmd = DiagramFactory.eINSTANCE.createGetEditPart();
		StringBuilder pathAsStr = makePath(path);
		if (pathAsStr.length() > 0)
			cmd.setPath(pathAsStr.toString());
		return cmd;
	}

	public static GetSourceConnection makeSourceConnection(List<Integer> path) {
		GetSourceConnection cmd = DiagramFactory.eINSTANCE
				.createGetSourceConnection();
		StringBuilder pathAsStr = new StringBuilder();
		for (int p : path) {
			if (pathAsStr.length() > 0)
				pathAsStr.append("/");
			pathAsStr.append(String.valueOf(p));
		}
		if (pathAsStr.length() > 0)
			cmd.setPath(pathAsStr.toString());
		return cmd;
	}

	public static GetEditPart makeEditPartByFeature(String feature, String value) {
		GetEditPart cmd = DiagramFactory.eINSTANCE.createGetEditPart();
		cmd.setFeature(feature + ":" + value);
		return cmd;
	}

	public static GetEditPart makeEditPartByName(String value) {
		GetEditPart cmd = DiagramFactory.eINSTANCE.createGetEditPart();
		cmd.setName(value);
		return cmd;
	}

	public static GetEditPart makeEditPartByText(String value) {
		GetEditPart cmd = DiagramFactory.eINSTANCE.createGetEditPart();
		cmd.setText(value);
		return cmd;
	}

	public static GetEditPart makeEditPartByCustomId(String value) {
		GetEditPart cmd = DiagramFactory.eINSTANCE.createGetEditPart();
		cmd.setCustomId(value);
		return cmd;
	}

	public static GetEditPart makeEditPartByClassName(String value) {
		GetEditPart cmd = DiagramFactory.eINSTANCE.createGetEditPart();
		cmd.setClassName(value);
		return cmd;
	}

	public static GetHandle makeHandle(String className) {
		GetHandle cmd = DiagramFactory.eINSTANCE.createGetHandle();
		cmd.setText(className);
		return cmd;
	}

	public static GetTargetConnection makeTargetConnection(List<Integer> path) {
		GetTargetConnection cmd = DiagramFactory.eINSTANCE
				.createGetTargetConnection();
		StringBuilder pathAsStr = new StringBuilder();
		for (int p : path) {
			if (pathAsStr.length() > 0)
				pathAsStr.append("/");
			pathAsStr.append(String.valueOf(p));
		}
		if (pathAsStr.length() > 0)
			cmd.setPath(pathAsStr.toString());
		return cmd;
	}

	public static GetFigure makeFigure(List<Integer> path) {
		GetFigure cmd = DiagramFactory.eINSTANCE.createGetFigure();
		StringBuilder pathAsStr = makePath(path);
		if (pathAsStr.length() > 0)
			cmd.setPath(pathAsStr.toString());
		return cmd;
	}

	public static GetPopupBarItem makePopupBarItem(List<Integer> path) {
		GetPopupBarItem cmd = DiagramFactory.eINSTANCE.createGetPopupBarItem();
		List<Integer> nPath = new ArrayList<Integer>(path);
		nPath.remove(0);
		StringBuilder pathAsStr = makePath(nPath);
		if (pathAsStr.length() > 0)
			cmd.setPath(pathAsStr.toString());
		return cmd;
	}

	public static GetConnectionHandle makeConnectionHandle(List<Integer> path) {
		GetConnectionHandle cmd = DiagramFactory.eINSTANCE
				.createGetConnectionHandle();
		List<Integer> nPath = new ArrayList<Integer>(path);
		nPath.remove(0);
		StringBuilder pathAsStr = makePath(nPath);
		if (pathAsStr.length() > 0)
			cmd.setPath(pathAsStr.toString());
		return cmd;
	}

	private static StringBuilder makePath(List<Integer> path) {
		StringBuilder pathAsStr = new StringBuilder();
		for (int p : path) {
			if (pathAsStr.length() > 0)
				pathAsStr.append("/");
			pathAsStr.append(String.valueOf(p));
		}
		return pathAsStr;
	}

	public static Drop makeDrop(Integer x, Integer y, String detail,
			Integer operations, String mask, Button button) {
		Drop cmd = TeslaFactory.eINSTANCE.createDrop();
		cmd.setX(x);
		cmd.setY(y);
		cmd.setDetail(detail);
		cmd.setMask(mask);
		cmd.setButton(button);
		cmd.setOperation(operations);
		return cmd;
	}

	public static DragStart makeDragStart(Integer x, Integer y, String detail,
			Integer operations, String mask, Button button) {
		DragStart cmd = TeslaFactory.eINSTANCE.createDragStart();
		cmd.setX(x);
		cmd.setY(y);
		cmd.setDetail(detail);
		cmd.setMask(mask);
		cmd.setButton(button);
		cmd.setOperation(operations);
		return cmd;
	}

	public static DragEnd makeDragEnd(Integer x, Integer y, String detail,
			Integer operations, String mask, Button button) {
		DragEnd cmd = TeslaFactory.eINSTANCE.createDragEnd();
		cmd.setX(x);
		cmd.setY(y);
		cmd.setDetail(detail);
		cmd.setMask(mask);
		cmd.setButton(button);
		cmd.setOperation(operations);
		return cmd;
	}

	public static DragEnter makeDragEnter(Integer x, Integer y, String detail,
			Integer operations, String mask, Button button) {
		DragEnter cmd = TeslaFactory.eINSTANCE.createDragEnter();
		cmd.setX(x);
		cmd.setY(y);
		cmd.setDetail(detail);
		cmd.setMask(mask);
		cmd.setButton(button);
		cmd.setOperation(operations);
		return cmd;
	}

	public static DragExit makeDragExit(Integer x, Integer y, String detail,
			Integer operations, String mask, Button button) {
		DragExit cmd = TeslaFactory.eINSTANCE.createDragExit();
		cmd.setX(x);
		cmd.setY(y);
		cmd.setDetail(detail);
		cmd.setMask(mask);
		cmd.setButton(button);
		cmd.setOperation(operations);
		return cmd;
	}

	public static DragAccept makeDragAccept(Integer x, Integer y,
			String detail, Integer operations, String mask, Button button) {
		DragAccept cmd = TeslaFactory.eINSTANCE.createDragAccept();
		cmd.setX(x);
		cmd.setY(y);
		cmd.setDetail(detail);
		cmd.setMask(mask);
		cmd.setButton(button);
		cmd.setOperation(operations);
		return cmd;
	}

	public static DragSetData makeDragSetData(Integer x, Integer y,
			String detail, Integer operations, String mask, Button button) {
		DragSetData cmd = TeslaFactory.eINSTANCE.createDragSetData();
		cmd.setX(x);
		cmd.setY(y);
		cmd.setDetail(detail);
		cmd.setMask(mask);
		cmd.setButton(button);
		cmd.setOperation(operations);
		return cmd;
	}

	public static DragDetect makeDragDetect(Integer x, Integer y,
			String detail, Integer operations, String mask, Button button) {
		DragDetect cmd = TeslaFactory.eINSTANCE.createDragDetect();
		cmd.setX(x);
		cmd.setY(y);
		cmd.setDetail(detail);
		cmd.setMask(mask);
		cmd.setButton(button);
		cmd.setOperation(operations);
		return cmd;
	}

	public static DragOver makeDragOver(Integer x, Integer y, String detail,
			Integer operations, String mask, Button button) {
		DragOver cmd = TeslaFactory.eINSTANCE.createDragOver();
		cmd.setX(x);
		cmd.setY(y);
		cmd.setDetail(detail);
		cmd.setMask(mask);
		cmd.setButton(button);
		cmd.setOperation(operations);
		return cmd;
	}

	public static SetDialogResult makeDialogReturns(String kind,
			EList<String> result) {
		SetDialogResult cmd = TeslaFactory.eINSTANCE.createSetDialogResult();
		cmd.setKind(kind);
		for (String currentStr : result) {
			cmd.getResult().add(currentStr);
		}
		return cmd;
	}

	public static SetTextOffset makeSetTextOffset(int line, int value) {
		SetTextOffset cmd = TeslaFactory.eINSTANCE.createSetTextOffset();
		cmd.setValue(value);
		if (line != -1) {
			cmd.setLine(line);
		}
		return cmd;
	}

	public static SetCaretPos makeSetCaretPos(int line, int column) {
		SetCaretPos cmd = TeslaFactory.eINSTANCE.createSetCaretPos();
		cmd.setLine(line);
		cmd.setColumn(column);
		return cmd;
	}

	public static SelectRange makeSelectRange(int line, int column, int end,
			int endcolumn) {
		SelectRange cmd = TeslaFactory.eINSTANCE.createSelectRange();
		cmd.setLine(line);
		cmd.setColumn(column);
		cmd.setEndLine(end);
		cmd.setEndColumn(endcolumn);
		return cmd;
	}

	public static HoverAtTextOffset makeHoverAtTextOffset(int line, int offset) {
		HoverAtTextOffset cmd = TeslaFactory.eINSTANCE
				.createHoverAtTextOffset();
		cmd.setOffset(offset);
		cmd.setLine(line);
		return cmd;
	}

	public static HoverText makeHoverText(int line, int offset, int stateMask) {
		HoverText cmd = TeslaFactory.eINSTANCE.createHoverText();
		cmd.setColumn(offset);
		cmd.setLine(line);
		cmd.setWith(KeysAndButtons.stateMaskToStr(stateMask));
		return cmd;
	}

	public static ClickRuler makeClickRuler(int line, Button button,
			int stateMask) {
		ClickRuler cmd = TeslaFactory.eINSTANCE.createClickRuler();
		cmd.setLine(line);
		cmd.setButton(KeysAndButtons.getButtonNameSafe(button.getValue()));
		cmd.setWith(KeysAndButtons.stateMaskToStr(stateMask));
		return cmd;
	}

	public static DoubleClickRuler makeDoubleClickRuler(int line,
			Button button, int stateMask) {
		DoubleClickRuler cmd = TeslaFactory.eINSTANCE.createDoubleClickRuler();
		cmd.setLine(line);
		cmd.setButton(KeysAndButtons.getButtonNameSafe(button.getValue()));
		cmd.setWith(KeysAndButtons.stateMaskToStr(stateMask));
		return cmd;
	}

	public static HoverRuler makeHoverRuler(int line, int stateMask) {
		HoverRuler cmd = TeslaFactory.eINSTANCE.createHoverRuler();
		cmd.setLine(line);
		cmd.setWith(KeysAndButtons.stateMaskToStr(stateMask));
		return cmd;
	}

	public static OpenDeclaration makeOpenDeclaration() {
		OpenDeclaration cmd = TeslaFactory.eINSTANCE.createOpenDeclaration();
		return cmd;
	}

	public static ActivateCellEdit makeCellEditorActivate(Integer column, Integer type, Integer button) {
		ActivateCellEdit c = TeslaFactory.eINSTANCE.createActivateCellEdit();
		c.setColumn(column);
		c.setType(ActivationEventType.get(type));
		c.setButton(button);
		return c;
	}

	public static ApplyCellEdit makeCellEditorApply(boolean deactivate) {
		ApplyCellEdit cell = TeslaFactory.eINSTANCE.createApplyCellEdit();
		cell.setDeactivate(deactivate);
		return cell;
	}

	public static CancelCellEdit makeCellEditorCancel() {
		return TeslaFactory.eINSTANCE.createCancelCellEdit();
	}

	public static DeactivateCellEdit makeCellEditorDeactivate() {
		return TeslaFactory.eINSTANCE.createDeactivateCellEdit();
	}

	public static ActivateDirectEdit makeDirectEditActivate() {
		return DiagramFactory.eINSTANCE.createActivateDirectEdit();
	}

	public static CommitDirectEdit makeDirectEditCommit() {
		return DiagramFactory.eINSTANCE.createCommitDirectEdit();
	}

	public static CancelDirectEdit makeDirectEditCancel() {
		return DiagramFactory.eINSTANCE.createCancelDirectEdit();
	}

	public static ExecWithOptions makeExecWithOptions() {
		return TeslaFactory.eINSTANCE.createExecWithOptions();
	}

	public static ClickColumn makeClickColumn(String name, int index) {
		ClickColumn result = TeslaFactory.eINSTANCE.createClickColumn();
		result.setName(name);
		result.setIndex(index);
		return result;
	}

}
